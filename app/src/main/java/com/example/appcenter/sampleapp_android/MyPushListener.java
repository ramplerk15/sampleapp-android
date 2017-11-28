package com.example.appcenter.sampleapp_android;

import android.app.Activity;
import android.app.AlertDialog;

import com.microsoft.appcenter.push.PushListener;
import com.microsoft.appcenter.push.PushNotification;

import java.util.Map;

/**
 * Created by admin on 27.11.2017.
 */

class MyPushListener implements PushListener {

    /**
     * Called whenever a push notification is either clicked from system notification center or
     * when the push is received in foreground.
     *
     * @param activity         current activity when push is received or clicked.
     * @param pushNotification the push notification details. If clicked from background, title and
     *                         message will be empty.
     *                         <p>
     *                         If the push is received in foreground,
     */
    @Override
    public void onPushNotificationReceived(Activity activity, PushNotification pushNotification) {

        /* The following notification properties are available. */
            String title = pushNotification.getTitle();
            String message = pushNotification.getMessage();
            Map<String, String> customData = pushNotification.getCustomData();

        /*
         * Message and title cannot be read from a background notification object.
         * Message being a mandatory field, you can use that to check foreground vs background.
         */
            if (message != null) {

            /* Display an alert for foreground push. */
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
                if (title != null) {
                    dialog.setTitle(title);
                }
                dialog.setMessage(message);
                if (!customData.isEmpty()) {
                    dialog.setMessage(message + "\n" + customData);
                }
                dialog.setPositiveButton(android.R.string.ok, null);
                dialog.show();
            } else {

            /* Display a toast when a background push is clicked. */
                //Toast.makeText(activity, R.string.push_toast, customData), Toast.LENGTH_LONG).show(); // For example R.string.push_toast would be "Push clicked with data=%1s"
            }


    };

}
