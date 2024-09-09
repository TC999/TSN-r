package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.LongSparseArray;
import com.amap.api.col.p0003l.k2;
import com.amap.api.maps.AMapException;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 200;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private k2 mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e4) {
                Log.e("amap", e4.getErrorMessage());
                e4.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i4) {
            this.radius = Math.max(10, Math.min(i4, 200));
            return this;
        }

        public Builder transparency(double d4) {
            this.opacity = Math.max(0.0d, Math.min(d4, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b4) {
        this(builder);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d4 = weightedLatLng.latLng.latitude;
                if (d4 < 85.0d && d4 > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            k2 d5 = d(arrayList);
            this.mBounds = d5;
            this.mTree = new a(d5);
            for (WeightedLatLng weightedLatLng2 : this.mData) {
                this.mTree.a(weightedLatLng2);
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    private static k2 d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d4 = next.getPoint().f11671x;
        double d5 = next.getPoint().f11671x;
        double d6 = d4;
        double d7 = d5;
        double d8 = next.getPoint().f11672y;
        double d9 = next.getPoint().f11672y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d10 = next2.getPoint().f11671x;
            double d11 = next2.getPoint().f11672y;
            if (d10 < d6) {
                d6 = d10;
            }
            if (d10 > d7) {
                d7 = d10;
            }
            if (d11 < d8) {
                d8 = d11;
            }
            if (d11 > d9) {
                d9 = d11;
            }
        }
        return new k2(d6, d7, d8, d9);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
    @Override // com.amap.api.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.maps.model.Tile getTile(int r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.HeatmapTileProvider.getTile(int, int, int):com.amap.api.maps.model.Tile");
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i4 = this.mRadius;
        double d4 = i4;
        Double.isNaN(d4);
        this.mKernel = a(i4, d4 / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i4) {
        int i5;
        double[] dArr = new double[21];
        int i6 = 5;
        while (true) {
            if (i6 >= 11) {
                break;
            }
            dArr[i6] = a(this.mData, this.mBounds, i4, (int) (Math.pow(2.0d, i6) * 1280.0d));
            if (i6 == 5) {
                for (int i7 = 0; i7 < i6; i7++) {
                    dArr[i7] = dArr[i6];
                }
            }
            i6++;
        }
        for (i5 = 11; i5 < 21; i5++) {
            dArr[i5] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private static double[] a(int i4, double d4) {
        double[] dArr = new double[(i4 * 2) + 1];
        for (int i5 = -i4; i5 <= i4; i5++) {
            double d5 = (-i5) * i5;
            Double.isNaN(d5);
            dArr[i5 + i4] = Math.exp(d5 / ((2.0d * d4) * d4));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        double length = dArr2.length;
        Double.isNaN(length);
        int floor = (int) Math.floor(length / 2.0d);
        int length2 = dArr.length;
        int i4 = length2 - (floor * 2);
        int i5 = 1;
        int i6 = (floor + i4) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, length2, length2);
        int i7 = 0;
        while (true) {
            double d4 = 0.0d;
            if (i7 >= length2) {
                break;
            }
            int i8 = 0;
            while (i8 < length2) {
                double d5 = dArr[i7][i8];
                if (d5 != d4) {
                    int i9 = i7 + floor;
                    if (i6 < i9) {
                        i9 = i6;
                    }
                    int i10 = i9 + 1;
                    int i11 = i7 - floor;
                    for (int i12 = floor > i11 ? floor : i11; i12 < i10; i12++) {
                        double[] dArr4 = dArr3[i12];
                        dArr4[i8] = dArr4[i8] + (dArr2[i12 - i11] * d5);
                    }
                }
                i8++;
                d4 = 0.0d;
            }
            i7++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, i4, i4);
        int i13 = floor;
        while (i13 < i6 + 1) {
            int i14 = 0;
            while (i14 < length2) {
                double d6 = dArr3[i13][i14];
                if (d6 != 0.0d) {
                    int i15 = i14 + floor;
                    if (i6 < i15) {
                        i15 = i6;
                    }
                    int i16 = i15 + i5;
                    int i17 = i14 - floor;
                    for (int i18 = floor > i17 ? floor : i17; i18 < i16; i18++) {
                        double[] dArr6 = dArr5[i13 - floor];
                        int i19 = i18 - floor;
                        dArr6[i19] = dArr6[i19] + (dArr2[i18 - i17] * d6);
                    }
                }
                i14++;
                i5 = 1;
            }
            i13++;
            i5 = 1;
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d4) {
        int i4 = iArr[iArr.length - 1];
        double length = iArr.length - 1;
        Double.isNaN(length);
        double d5 = length / d4;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i5 = 0; i5 < length2; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                double d6 = dArr[i6][i5];
                int i7 = (i5 * length2) + i6;
                int i8 = (int) (d6 * d5);
                if (d6 != 0.0d) {
                    if (i8 < iArr.length) {
                        iArr2[i7] = iArr[i8];
                    } else {
                        iArr2[i7] = i4;
                    }
                } else {
                    iArr2[i7] = 0;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static double a(Collection<WeightedLatLng> collection, k2 k2Var, int i4, int i5) {
        double d4 = k2Var.f8229a;
        double d5 = k2Var.f8231c;
        double d6 = k2Var.f8230b;
        double d7 = d5 - d4;
        double d8 = k2Var.f8232d - d6;
        if (d7 <= d8) {
            d7 = d8;
        }
        double d9 = i5 / (i4 * 2);
        Double.isNaN(d9);
        double d10 = (int) (d9 + 0.5d);
        Double.isNaN(d10);
        double d11 = d10 / d7;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d12 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d13 = weightedLatLng.getPoint().f11671x;
            int i6 = (int) ((weightedLatLng.getPoint().f11672y - d6) * d11);
            long j4 = (int) ((d13 - d4) * d11);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j4);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j4, longSparseArray2);
            }
            long j5 = i6;
            Double d14 = (Double) longSparseArray2.get(j5);
            if (d14 == null) {
                d14 = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d15 = d4;
            Double valueOf = Double.valueOf(d14.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j5, valueOf);
            if (valueOf.doubleValue() > d12) {
                d12 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d4 = d15;
        }
        return d12;
    }
}
