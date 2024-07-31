package com.scwang.smartrefresh.header.storehouse;

import android.util.SparseArray;
import io.netty.handler.codec.http.HttpConstants;
import java.util.ArrayList;

/* renamed from: com.scwang.smartrefresh.header.storehouse.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StoreHousePath {

    /* renamed from: a */
    private static final SparseArray<float[]> f33419a = new SparseArray<>();

    static {
        float[][] fArr = {new float[]{24.0f, 0.0f, 1.0f, 22.0f, 1.0f, 22.0f, 1.0f, 72.0f, 24.0f, 0.0f, 47.0f, 22.0f, 47.0f, 22.0f, 47.0f, 72.0f, 1.0f, 48.0f, 47.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 37.0f, 0.0f, 37.0f, 0.0f, 47.0f, 11.0f, 47.0f, 11.0f, 47.0f, 26.0f, 47.0f, 26.0f, 38.0f, 36.0f, 38.0f, 36.0f, 0.0f, 36.0f, 38.0f, 36.0f, 47.0f, 46.0f, 47.0f, 46.0f, 47.0f, 61.0f, 47.0f, 61.0f, 38.0f, 71.0f, 37.0f, 72.0f, 0.0f, 72.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 24.0f, 0.0f, 24.0f, 0.0f, 47.0f, 22.0f, 47.0f, 22.0f, 47.0f, 48.0f, 47.0f, 48.0f, 23.0f, 72.0f, 23.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 0.0f, 36.0f, 37.0f, 36.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 0.0f, 36.0f, 37.0f, 36.0f}, new float[]{47.0f, 23.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 48.0f, 47.0f, 48.0f, 24.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 24.0f, 0.0f, 24.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{47.0f, 0.0f, 47.0f, 72.0f, 47.0f, 72.0f, 24.0f, 72.0f, 24.0f, 72.0f, 0.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 47.0f, 0.0f, 3.0f, 33.0f, 3.0f, 38.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 24.0f, 23.0f, 24.0f, 23.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 23.0f, 72.0f, 23.0f, 72.0f, 47.0f, 48.0f, 47.0f, 48.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 24.0f, 28.0f, 47.0f, 71.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 0.0f, 37.0f, 47.0f, 72.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 24.0f, 0.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 24.0f, 72.0f, 24.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 24.0f, 49.0f, 24.0f, 49.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 47.0f, 72.0f, 47.0f, 0.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 24.0f, 23.0f, 47.0f, 0.0f, 24.0f, 23.0f, 24.0f, 23.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}};
        float[][] fArr2 = {new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f}, new float[]{24.0f, 0.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 0.0f, 36.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 47.0f, 36.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}};
        for (int i = 0; i < 26; i++) {
            f33419a.append(i + 65, fArr[i]);
        }
        for (int i2 = 0; i2 < 26; i2++) {
            f33419a.append(i2 + 65 + 32, fArr[i2]);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            f33419a.append(i3 + 48, fArr2[i3]);
        }
        m20027a(HttpConstants.SP_CHAR, new float[0]);
        m20027a('-', new float[]{0.0f, 36.0f, 47.0f, 36.0f});
        m20027a('.', new float[]{24.0f, 60.0f, 24.0f, 72.0f});
    }

    /* renamed from: a */
    public static void m20027a(char c, float[] fArr) {
        f33419a.append(c, fArr);
    }

    /* renamed from: b */
    public static ArrayList<float[]> m20026b(String str) {
        return m20025c(str, 1.0f, 14);
    }

    /* renamed from: c */
    public static ArrayList<float[]> m20025c(String str, float f, int i) {
        ArrayList<float[]> arrayList = new ArrayList<>();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            SparseArray<float[]> sparseArray = f33419a;
            if (sparseArray.indexOfKey(charAt) != -1) {
                float[] fArr = sparseArray.get(charAt);
                int length = fArr.length / 4;
                for (int i3 = 0; i3 < length; i3++) {
                    float[] fArr2 = new float[4];
                    for (int i4 = 0; i4 < 4; i4++) {
                        float f3 = fArr[(i3 * 4) + i4];
                        if (i4 % 2 == 0) {
                            fArr2[i4] = (f3 + f2) * f;
                        } else {
                            fArr2[i4] = f3 * f;
                        }
                    }
                    arrayList.add(fArr2);
                }
                f2 += i + 57;
            }
        }
        return arrayList;
    }
}
