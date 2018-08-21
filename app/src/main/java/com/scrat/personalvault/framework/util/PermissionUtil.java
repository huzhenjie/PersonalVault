package com.scrat.personalvault.framework.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionUtil {
    private PermissionUtil() {
        throw new AssertionError("No instances.");
    }

    private static final int PERMISSION_REQUEST_CODE = 250;

    public static boolean checkPermission(Activity activity, int requestCode, String... permissions) {
        boolean permissionGranted = true;
        for (String permission : permissions) {
            int permissionCode = ContextCompat.checkSelfPermission(activity, permission);
            if (permissionCode != PackageManager.PERMISSION_GRANTED) {
                permissionGranted = false;
                try {
                    ActivityCompat.requestPermissions(
                            activity, new String[]{permission}, requestCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return permissionGranted;
    }

    public static boolean checkPermission(Activity activity, String... permissions) {
        return checkPermission(activity, PERMISSION_REQUEST_CODE, permissions);
    }
}
