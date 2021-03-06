package yapp14th.co.kr.myplant;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import androidx.core.content.ContextCompat;

public class MyApplication extends Application {
    public static int DIALOG_OK = 1;
    public static int DIALOG_OK_CANCEL = 2;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int convertColor(Context context, int resourceColor){
        return ContextCompat.getColor(context, resourceColor);
    }

}
