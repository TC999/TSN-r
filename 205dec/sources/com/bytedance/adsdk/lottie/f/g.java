package com.bytedance.adsdk.lottie.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g {
    private static float a(float f4) {
        return f4 <= 0.0031308f ? f4 * 12.92f : (float) ((Math.pow(f4, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int b(float f4, int i4, int i5) {
        if (i4 == i5) {
            return i4;
        }
        float f5 = ((i4 >> 24) & 255) / 255.0f;
        float c4 = c(((i4 >> 16) & 255) / 255.0f);
        float c5 = c(((i4 >> 8) & 255) / 255.0f);
        float c6 = c((i4 & 255) / 255.0f);
        float c7 = c(((i5 >> 16) & 255) / 255.0f);
        float c8 = c(((i5 >> 8) & 255) / 255.0f);
        float c9 = c6 + (f4 * (c((i5 & 255) / 255.0f) - c6));
        return (Math.round(a(c4 + ((c7 - c4) * f4)) * 255.0f) << 16) | (Math.round((f5 + (((((i5 >> 24) & 255) / 255.0f) - f5) * f4)) * 255.0f) << 24) | (Math.round(a(c5 + ((c8 - c5) * f4)) * 255.0f) << 8) | Math.round(a(c9) * 255.0f);
    }

    private static float c(float f4) {
        return f4 <= 0.04045f ? f4 / 12.92f : (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }
}
