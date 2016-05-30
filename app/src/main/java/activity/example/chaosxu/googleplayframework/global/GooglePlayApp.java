package activity.example.chaosxu.googleplayframework.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by ChaosXu on 2016/05/30 030.
 */
public class GooglePlayApp extends Application {
        public static Handler mainHandler;
        public static Context context;

        @Override
        public void onCreate() {
                super.onCreate();
                context = getApplicationContext();
                mainHandler = new Handler();


                //初始化ImageLoader
                // ImageLoader.getInstance().init( ImageLoaderConfiguration.createDefault(this));
        }
}
