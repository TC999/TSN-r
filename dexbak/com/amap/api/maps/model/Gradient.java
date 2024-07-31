package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.maps.model.Gradient$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2263a {

        /* renamed from: a */
        private final int f7033a;

        /* renamed from: b */
        private final int f7034b;

        /* renamed from: c */
        private final float f7035c;

        /* synthetic */ C2263a(int i, int i2, float f, byte b) {
            this(i, i2, f);
        }

        private C2263a(int i, int i2, float f) {
            this.f7033a = i;
            this.f7034b = i2;
            this.f7035c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    /* renamed from: a */
    private HashMap<Integer, C2263a> m52083a() {
        HashMap<Integer, C2263a> hashMap = new HashMap<>(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new C2263a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], (byte) 0));
        }
        for (int i = 1; i < this.mColors.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i2]));
            int[] iArr = this.mColors;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new C2263a(i3, i4, this.mColorMapSize * (fArr[i] - fArr[i2]), (byte) 0));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int[] iArr2 = this.mColors;
            hashMap.put(valueOf2, new C2263a(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateColorMap(double d) {
        HashMap<Integer, C2263a> m52083a = m52083a();
        int[] iArr = new int[this.mColorMapSize];
        C2263a c2263a = m52083a.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (m52083a.containsKey(Integer.valueOf(i2))) {
                c2263a = m52083a.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = m52082a(c2263a.f7033a, c2263a.f7034b, (i2 - i) / c2263a.f7035c);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
                int i4 = iArr[i3];
                double alpha = Color.alpha(i4);
                Double.isNaN(alpha);
                iArr[i3] = Color.argb((int) (alpha * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    private Gradient(int[] iArr, float[] fArr, byte b) {
        this.isAvailable = true;
        try {
            if (iArr != null && fArr != null) {
                if (iArr.length == fArr.length) {
                    if (iArr.length != 0) {
                        for (int i = 1; i < fArr.length; i++) {
                            if (fArr[i] < fArr[i - 1]) {
                                throw new AMapException("startPoints should be in increasing order");
                            }
                        }
                        this.mColorMapSize = 1000;
                        int[] iArr2 = new int[iArr.length];
                        this.mColors = iArr2;
                        this.mStartPoints = new float[fArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                        this.isAvailable = true;
                        return;
                    }
                    throw new AMapException("No colors have been defined");
                }
                throw new AMapException("colors and startPoints should be same length");
            }
            throw new AMapException("colors and startPoints should not be null");
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e("amap", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static int m52082a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
