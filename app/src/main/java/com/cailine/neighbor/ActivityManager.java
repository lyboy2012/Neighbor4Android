package com.cailine.neighbor;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liying on 2016/2/16.
 */
public class ActivityManager {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);

    }


    public static void removeActivity(Activity activity) {

        activities.remove(activity);
    }

    /**
     * 结束所有activity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
