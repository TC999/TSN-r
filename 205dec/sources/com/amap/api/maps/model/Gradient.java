package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f10735a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10736b;

        /* renamed from: c  reason: collision with root package name */
        private final float f10737c;

        /* synthetic */ a(int i4, int i5, float f4, byte b4) {
            this(i4, i5, f4);
        }

        private a(int i4, int i5, float f4) {
            this.f10735a = i4;
            this.f10736b = i5;
            this.f10737c = f4;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], (byte) 0));
        }
        for (int i4 = 1; i4 < this.mColors.length; i4++) {
            int i5 = i4 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i5]));
            int[] iArr = this.mColors;
            int i6 = iArr[i5];
            int i7 = iArr[i4];
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new a(i6, i7, this.mColorMapSize * (fArr[i4] - fArr[i5]), (byte) 0));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int[] iArr2 = this.mColors;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateColorMap(double d4) {
        HashMap<Integer, a> a4 = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = a4.get(0);
        int i4 = 0;
        for (int i5 = 0; i5 < this.mColorMapSize; i5++) {
            if (a4.containsKey(Integer.valueOf(i5))) {
                aVar = a4.get(Integer.valueOf(i5));
                i4 = i5;
            }
            iArr[i5] = a(aVar.f10735a, aVar.f10736b, (i5 - i4) / aVar.f10737c);
        }
        if (d4 != 1.0d) {
            for (int i6 = 0; i6 < this.mColorMapSize; i6++) {
                int i7 = iArr[i6];
                double alpha = Color.alpha(i7);
                Double.isNaN(alpha);
                iArr[i6] = Color.argb((int) (alpha * d4), Color.red(i7), Color.green(i7), Color.blue(i7));
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

    private Gradient(int[] iArr, float[] fArr, byte b4) {
        this.isAvailable = true;
        try {
            if (iArr != null && fArr != null) {
                if (iArr.length == fArr.length) {
                    if (iArr.length != 0) {
                        for (int i4 = 1; i4 < fArr.length; i4++) {
                            if (fArr[i4] < fArr[i4 - 1]) {
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
        } catch (AMapException e4) {
            this.isAvailable = false;
            Log.e("amap", e4.getErrorMessage());
            e4.printStackTrace();
        }
    }

    private static int a(int i4, int i5, float f4) {
        int alpha = (int) (((Color.alpha(i5) - Color.alpha(i4)) * f4) + Color.alpha(i4));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i5), Color.green(i5), Color.blue(i5), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i6 = 0; i6 < 3; i6++) {
            fArr3[i6] = ((fArr2[i6] - fArr[i6]) * f4) + fArr[i6];
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
