package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2429e;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CoordinateConverter {

    /* renamed from: b */
    private static int f6955b = 0;

    /* renamed from: c */
    private static int f6956c = 1;

    /* renamed from: d */
    private static int f6957d = 2;

    /* renamed from: e */
    private static int f6958e = 4;

    /* renamed from: f */
    private static int f6959f = 8;

    /* renamed from: g */
    private static int f6960g = 16;

    /* renamed from: h */
    private static int f6961h = 32;

    /* renamed from: i */
    private static int f6962i = 64;

    /* renamed from: j */
    private Context f6964j;

    /* renamed from: k */
    private CoordType f6965k = null;

    /* renamed from: l */
    private DPoint f6966l = null;

    /* renamed from: a */
    DPoint f6963a = null;

    /* renamed from: com.amap.api.location.CoordinateConverter$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C22371 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6967a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f6967a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6967a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6967a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6967a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6967a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6967a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6967a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        this.f6964j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return C2432j.m51195a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return C2428b.m51309a(d, d2);
    }

    public synchronized DPoint convert() throws Exception {
        if (this.f6965k != null) {
            DPoint dPoint = this.f6966l;
            if (dPoint != null) {
                if (dPoint.getLongitude() <= 180.0d && this.f6966l.getLongitude() >= -180.0d) {
                    if (this.f6966l.getLatitude() <= 90.0d && this.f6966l.getLatitude() >= -90.0d) {
                        boolean z = false;
                        String str = null;
                        switch (C22371.f6967a[this.f6965k.ordinal()]) {
                            case 1:
                                this.f6963a = C2429e.m51277a(this.f6966l);
                                int i = f6955b;
                                int i2 = f6956c;
                                if ((i & i2) == 0) {
                                    str = "baidu";
                                    f6955b = i | i2;
                                    z = true;
                                    break;
                                }
                                break;
                            case 2:
                                this.f6963a = C2429e.m51274b(this.f6964j, this.f6966l);
                                int i3 = f6955b;
                                int i4 = f6957d;
                                if ((i3 & i4) == 0) {
                                    str = "mapbar";
                                    f6955b = i3 | i4;
                                    z = true;
                                    break;
                                }
                                break;
                            case 3:
                                int i5 = f6955b;
                                int i6 = f6958e;
                                if ((i5 & i6) == 0) {
                                    str = "mapabc";
                                    f6955b = i5 | i6;
                                    z = true;
                                }
                                this.f6963a = this.f6966l;
                                break;
                            case 4:
                                int i7 = f6955b;
                                int i8 = f6959f;
                                if ((i7 & i8) == 0) {
                                    str = "sosomap";
                                    f6955b = i7 | i8;
                                    z = true;
                                }
                                this.f6963a = this.f6966l;
                                break;
                            case 5:
                                int i9 = f6955b;
                                int i10 = f6960g;
                                if ((i9 & i10) == 0) {
                                    str = "aliyun";
                                    f6955b = i9 | i10;
                                    z = true;
                                }
                                this.f6963a = this.f6966l;
                                break;
                            case 6:
                                int i11 = f6955b;
                                int i12 = f6961h;
                                if ((i11 & i12) == 0) {
                                    str = "google";
                                    f6955b = i11 | i12;
                                    z = true;
                                }
                                this.f6963a = this.f6966l;
                                break;
                            case 7:
                                int i13 = f6955b;
                                int i14 = f6962i;
                                if ((i13 & i14) == 0) {
                                    str = GeocodeSearch.GPS;
                                    f6955b = i13 | i14;
                                    z = true;
                                }
                                this.f6963a = C2429e.m51278a(this.f6964j, this.f6966l);
                                break;
                        }
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("amap_loc_coordinate", str);
                            }
                            ReportUtil.m51236a(this.f6964j, "O021", jSONObject);
                        }
                    } else {
                        throw new IllegalArgumentException("请传入合理纬度");
                    }
                } else {
                    throw new IllegalArgumentException("请传入合理经度");
                }
            } else {
                throw new IllegalArgumentException("转换坐标源不能为空");
            }
        } else {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        }
        return this.f6963a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        try {
            if (dPoint != null) {
                if (dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d) {
                        this.f6966l = dPoint;
                    } else {
                        throw new IllegalArgumentException("请传入合理纬度");
                    }
                } else {
                    throw new IllegalArgumentException("请传入合理经度");
                }
            } else {
                throw new IllegalArgumentException("传入经纬度对象为空");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f6965k = coordType;
        return this;
    }
}
