package xyz.adscope.amps.tool.util;

import java.util.Random;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSRandomUtil {
    public static int getRandomNum(int i4) {
        return new Random().nextInt(i4) + 1;
    }

    public static boolean isHitRandomNum(int i4, int i5, int i6) {
        return i6 >= i4 && i6 <= i5;
    }
}
