package com.ylsna.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by halsey on 16-4-19.
 */
public class InterfaceUtils {
    /**
     * 长时间toast提示
     *
     * @param context
     * @param hint
     */
    public static void showShortToast(Context context, String hint) {
        Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间toast提示
     *
     * @param context
     * @param hint
     */
    public static void showLongToast(Context context, String hint) {
        Toast.makeText(context, hint, Toast.LENGTH_LONG).show();
    }
}
