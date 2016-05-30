package activity.example.chaosxu.googleplayframework.util;

import android.content.res.Resources;

import activity.example.chaosxu.googleplayframework.global.GooglePlayApp;

/**
 * Created by ChaosXu on 2016/05/30 030.
 */
public class Utils {
        public static void runOnUIThread(Runnable runnable) {
                GooglePlayApp.mainHandler.post(runnable);
        }

        public static String[] getStringArray(int resId) {
                return getResources().getStringArray(resId);
        }

        public static Resources getResources() {
                return GooglePlayApp.context.getResources();
        }

        public static int getDimens(int resId) {
                return getResources().getDimensionPixelSize(resId);
        }


        public static int getColor(int resId) {
                return getResources().getColor(resId);
        }
}
