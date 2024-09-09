package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CoordinateConverter {

    /* renamed from: b  reason: collision with root package name */
    private static int f10659b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f10660c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static int f10661d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static int f10662e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static int f10663f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static int f10664g = 16;

    /* renamed from: h  reason: collision with root package name */
    private static int f10665h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static int f10666i = 64;

    /* renamed from: j  reason: collision with root package name */
    private Context f10668j;

    /* renamed from: k  reason: collision with root package name */
    private CoordType f10669k = null;

    /* renamed from: l  reason: collision with root package name */
    private DPoint f10670l = null;

    /* renamed from: a  reason: collision with root package name */
    DPoint f10667a = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.amap.api.location.CoordinateConverter$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10671a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f10671a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10671a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10671a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10671a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10671a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10671a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10671a[CoordType.GPS.ordinal()] = 7;
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
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.f10668j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return j.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d4, double d5) {
        return b.a(d4, d5);
    }

    public synchronized DPoint convert() throws Exception {
        if (this.f10669k != null) {
            DPoint dPoint = this.f10670l;
            if (dPoint != null) {
                if (dPoint.getLongitude() <= 180.0d && this.f10670l.getLongitude() >= -180.0d) {
                    if (this.f10670l.getLatitude() <= 90.0d && this.f10670l.getLatitude() >= -90.0d) {
                        boolean z3 = false;
                        String str = null;
                        switch (AnonymousClass1.f10671a[this.f10669k.ordinal()]) {
                            case 1:
                                this.f10667a = e.a(this.f10670l);
                                int i4 = f10659b;
                                int i5 = f10660c;
                                if ((i4 & i5) == 0) {
                                    str = "baidu";
                                    f10659b = i4 | i5;
                                    z3 = true;
                                    break;
                                }
                                break;
                            case 2:
                                this.f10667a = e.b(this.f10668j, this.f10670l);
                                int i6 = f10659b;
                                int i7 = f10661d;
                                if ((i6 & i7) == 0) {
                                    str = "mapbar";
                                    f10659b = i6 | i7;
                                    z3 = true;
                                    break;
                                }
                                break;
                            case 3:
                                int i8 = f10659b;
                                int i9 = f10662e;
                                if ((i8 & i9) == 0) {
                                    str = "mapabc";
                                    f10659b = i8 | i9;
                                    z3 = true;
                                }
                                this.f10667a = this.f10670l;
                                break;
                            case 4:
                                int i10 = f10659b;
                                int i11 = f10663f;
                                if ((i10 & i11) == 0) {
                                    str = "sosomap";
                                    f10659b = i10 | i11;
                                    z3 = true;
                                }
                                this.f10667a = this.f10670l;
                                break;
                            case 5:
                                int i12 = f10659b;
                                int i13 = f10664g;
                                if ((i12 & i13) == 0) {
                                    str = "aliyun";
                                    f10659b = i12 | i13;
                                    z3 = true;
                                }
                                this.f10667a = this.f10670l;
                                break;
                            case 6:
                                int i14 = f10659b;
                                int i15 = f10665h;
                                if ((i14 & i15) == 0) {
                                    str = "google";
                                    f10659b = i14 | i15;
                                    z3 = true;
                                }
                                this.f10667a = this.f10670l;
                                break;
                            case 7:
                                int i16 = f10659b;
                                int i17 = f10666i;
                                if ((i16 & i17) == 0) {
                                    str = "gps";
                                    f10659b = i16 | i17;
                                    z3 = true;
                                }
                                this.f10667a = e.a(this.f10668j, this.f10670l);
                                break;
                        }
                        if (z3) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("amap_loc_coordinate", str);
                            }
                            h.a(this.f10668j, "O021", jSONObject);
                        }
                    } else {
                        throw new IllegalArgumentException("\u8bf7\u4f20\u5165\u5408\u7406\u7eac\u5ea6");
                    }
                } else {
                    throw new IllegalArgumentException("\u8bf7\u4f20\u5165\u5408\u7406\u7ecf\u5ea6");
                }
            } else {
                throw new IllegalArgumentException("\u8f6c\u6362\u5750\u6807\u6e90\u4e0d\u80fd\u4e3a\u7a7a");
            }
        } else {
            throw new IllegalArgumentException("\u8f6c\u6362\u5750\u6807\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a");
        }
        return this.f10667a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        try {
            if (dPoint != null) {
                if (dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d) {
                        this.f10670l = dPoint;
                    } else {
                        throw new IllegalArgumentException("\u8bf7\u4f20\u5165\u5408\u7406\u7eac\u5ea6");
                    }
                } else {
                    throw new IllegalArgumentException("\u8bf7\u4f20\u5165\u5408\u7406\u7ecf\u5ea6");
                }
            } else {
                throw new IllegalArgumentException("\u4f20\u5165\u7ecf\u7eac\u5ea6\u5bf9\u8c61\u4e3a\u7a7a");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f10669k = coordType;
        return this;
    }
}
