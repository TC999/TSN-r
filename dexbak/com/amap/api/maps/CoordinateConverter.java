package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.p0463l.OffsetUtil;
import com.amap.api.col.p0463l.RegionUtil;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.StatisticsUtil;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    /* renamed from: com.amap.api.maps.CoordinateConverter$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C22581 {

        /* renamed from: a */
        static final /* synthetic */ int[] f7015a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f7015a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7015a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7015a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7015a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7015a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7015a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7015a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static boolean isAMapDataAvailable(double d, double d2) {
        return RegionUtil.m53892a(d, d2);
    }

    public LatLng convert() {
        CoordType coordType = this.coordType;
        LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            String str = "";
            switch (C22581.f7015a[coordType.ordinal()]) {
                case 1:
                    latLng = OffsetUtil.m54271d(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLng = OffsetUtil.m54266i(this.ctx, this.sourceLatLng);
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
                    str = GeocodeSearch.GPS;
                    latLng = OffsetUtil.m54272c(this.ctx, this.sourceLatLng);
                    break;
            }
            StatisticsUtil.m53553h(this.ctx, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogHandler.m53863p(th, TAG, "convert");
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
