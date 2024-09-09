package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.p0003l.p;
import com.amap.api.col.p0003l.t2;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.x2;
import com.amap.api.maps.model.LatLng;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.amap.api.maps.CoordinateConverter$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10718a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f10718a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10718a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10718a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10718a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10718a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10718a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10718a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d4, double d5) {
        return t2.a(d4, d5);
    }

    public LatLng convert() {
        CoordType coordType = this.coordType;
        LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            String str = "";
            switch (AnonymousClass1.f10718a[coordType.ordinal()]) {
                case 1:
                    latLng = p.d(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLng = p.i(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.sourceLatLng;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.sourceLatLng;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.sourceLatLng;
                    break;
                case 6:
                    str = "google";
                    latLng = this.sourceLatLng;
                    break;
                case 7:
                    str = "gps";
                    latLng = p.c(this.ctx, this.sourceLatLng);
                    break;
            }
            x2.h(this.ctx, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            u5.p(th, "CoordinateConverter", "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
