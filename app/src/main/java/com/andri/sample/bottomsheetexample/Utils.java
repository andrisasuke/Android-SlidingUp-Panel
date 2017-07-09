package com.andri.sample.bottomsheetexample;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public final class Utils {

    public static int dpToPx(Context context, int dp) {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                resources.getDisplayMetrics());
    }

}
