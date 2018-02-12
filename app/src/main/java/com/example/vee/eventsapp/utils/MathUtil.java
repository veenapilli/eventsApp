package com.example.vee.eventsapp.utils;

/**
 * Created by vee on 2/12/18.
 */

public class MathUtil {
        public static int dpToPx(int dps, float scale) {
            int pixels = (int) (dps * scale + 0.5f);
            return pixels;
    }
}
