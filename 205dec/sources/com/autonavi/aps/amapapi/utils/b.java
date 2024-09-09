package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.m4;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.u5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CoreUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f12005a = "5.3";

    /* renamed from: c  reason: collision with root package name */
    static String f12007c = "http://apilocate.amap.com/mobile/binary";

    /* renamed from: d  reason: collision with root package name */
    static String f12008d = "http://dualstack-a.apilocate.amap.com/mobile/binary";

    /* renamed from: e  reason: collision with root package name */
    static String f12009e = "";

    /* renamed from: f  reason: collision with root package name */
    static String f12010f = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";

    /* renamed from: g  reason: collision with root package name */
    public static String f12011g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f12012h = null;

    /* renamed from: i  reason: collision with root package name */
    public static int f12013i = 30000;

    /* renamed from: j  reason: collision with root package name */
    public static String f12014j;

    /* renamed from: k  reason: collision with root package name */
    public static String f12015k;

    /* renamed from: l  reason: collision with root package name */
    static String f12016l;

    /* renamed from: m  reason: collision with root package name */
    static HashMap<String, String> f12017m;

    /* renamed from: n  reason: collision with root package name */
    static boolean f12018n;

    /* renamed from: o  reason: collision with root package name */
    static boolean f12019o;

    /* renamed from: q  reason: collision with root package name */
    private static p4 f12021q;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f12022r;

    /* renamed from: s  reason: collision with root package name */
    private static boolean f12023s;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f12006b = {"5.1"};

    /* renamed from: p  reason: collision with root package name */
    private static final String[] f12020p = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};

    public static String a() {
        return f12007c;
    }

    private static boolean a(double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 - d4;
        double d12 = d10 - d9;
        double d13 = d7 - d5;
        double d14 = 180.0d - d8;
        double d15 = (d11 * d12) - (d13 * d14);
        if (d15 != 0.0d) {
            double d16 = d5 - d9;
            double d17 = d4 - d8;
            double d18 = ((d14 * d16) - (d12 * d17)) / d15;
            double d19 = ((d16 * d11) - (d17 * d13)) / d15;
            if (d18 >= 0.0d && d18 <= 1.0d && d19 >= 0.0d && d19 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    private static double b(double d4, double d5, double d6, double d7, double d8, double d9) {
        return ((d6 - d4) * (d9 - d5)) - ((d8 - d4) * (d7 - d5));
    }

    public static String b() {
        return f12008d;
    }

    public static p4 c() {
        try {
            if (f12021q == null) {
                f12021q = new p4.a("loc", "6.4.3", "AMAP_Location_SDK_Android 6.4.3").b(e()).a("6.4.3").c();
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
        }
        return f12021q;
    }

    public static String d() {
        return f12010f;
    }

    private static String[] e() {
        return (String[]) f12020p.clone();
    }

    private static void f() {
        try {
            if (f12017m == null) {
                f12017m = new HashMap<>(16);
            }
            f12017m.clear();
            f12017m.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            f12017m.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            f12017m.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
        } catch (Throwable th) {
            a(th, "CoreUtil", "initUrlHash");
        }
    }

    public static boolean a(double d4, double d5) {
        int i4 = (int) ((d5 - 73.0d) / 0.5d);
        int i5 = (int) ((d4 - 3.5d) / 0.5d);
        if (i5 < 0 || i5 >= 101 || i4 < 0 || i4 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i5 * 124) + i4) == '1';
        } catch (Throwable th) {
            a(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static byte[] b(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = (byte) (j.f(lowerCase.substring(i5, i5 + 2)) & 255);
        }
        return bArr;
    }

    public static AMapLocation a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return aMapLocation;
        }
        try {
            aMapLocation.setCountry(aMapLocation2.getCountry());
            aMapLocation.setRoad(aMapLocation2.getRoad());
            aMapLocation.setPoiName(aMapLocation2.getPoiName());
            aMapLocation.setStreet(aMapLocation2.getStreet());
            aMapLocation.setNumber(aMapLocation2.getStreetNum());
            String cityCode = aMapLocation2.getCityCode();
            String adCode = aMapLocation2.getAdCode();
            aMapLocation.setCityCode(cityCode);
            aMapLocation.setAdCode(adCode);
            aMapLocation.setCity(aMapLocation2.getCity());
            aMapLocation.setDistrict(aMapLocation2.getDistrict());
            aMapLocation.setProvince(aMapLocation2.getProvince());
            aMapLocation.setAoiName(aMapLocation2.getAoiName());
            aMapLocation.setAddress(aMapLocation2.getAddress());
            aMapLocation.setDescription(aMapLocation2.getDescription());
            if (aMapLocation.getExtras() != null) {
                aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                aMapLocation.getExtras().putString("desc", aMapLocation2.getExtras().getString("desc"));
                aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation2.getCityCode());
                bundle.putString("desc", aMapLocation2.getExtras().getString("desc"));
                bundle.putString("adcode", aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            }
        } catch (Throwable unused) {
        }
        return aMapLocation;
    }

    public static void c(Context context) {
        try {
            if (q4.s(context)) {
                f12007c = "http://abroad.apilocate.amap.com/mobile/binary";
                f12008d = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            f12007c = "http://apilocate.amap.com/mobile/binary";
            f12008d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
        } catch (Throwable th) {
            a(th, "CoreUtil", "changeUrl");
        }
    }

    public static String b(Context context) {
        return m4.d(e4.i(context));
    }

    public static void a(AMapLocation aMapLocation, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                double optDouble = jSONObject.optDouble("lat", aMapLocation.getLatitude());
                double optDouble2 = jSONObject.optDouble("lon", aMapLocation.getLongitude());
                aMapLocation.setProvider(jSONObject.optString("provider", aMapLocation.getProvider()));
                aMapLocation.setLatitude(optDouble);
                aMapLocation.setLongitude(optDouble2);
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    String optString = jSONObject.optString("accuracy");
                    if (!TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(Float.parseFloat(optString));
                    }
                } catch (Throwable unused) {
                }
                try {
                    String optString2 = jSONObject.optString("speed");
                    if (!TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(Float.parseFloat(optString2));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    String optString3 = jSONObject.optString("bearing");
                    if (!TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(Float.parseFloat(optString3));
                    }
                } catch (Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString("address", aMapLocation.getAddress()));
                String optString4 = jSONObject.optString("desc", "");
                aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString("province", aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString("city", aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString("district", aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString("number", aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString("errorInfo", aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt("locationType", aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                boolean optBoolean = jSONObject.optBoolean("isOffset", aMapLocation.isOffset());
                aMapLocation.setOffset(optBoolean);
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString("description", aMapLocation.getDescription()));
                if (jSONObject.has("coordType")) {
                    aMapLocation.setCoordType(jSONObject.optString("coordType", "GCJ02"));
                } else if (a(optDouble, optDouble2) && optBoolean) {
                    aMapLocation.setCoordType("GCJ02");
                } else {
                    aMapLocation.setCoordType("WGS84");
                }
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation.getCityCode());
                bundle.putString("desc", optString4.toString());
                bundle.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable th) {
                a(th, "CoreUtil", "transformLocation");
            }
        }
    }

    public static void a(Context context) {
        try {
            if (q4.s(context)) {
                f12007c = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            f();
            String a4 = com.autonavi.aps.amapapi.security.a.a(e4.j(context));
            f12016l = a4;
            a(a4);
        } catch (Throwable th) {
            a(th, "CoreUtil", "checkUrl");
        }
    }

    private static void a(String str) {
        HashMap<String, String> hashMap;
        if (str != null) {
            try {
                if (str.length() == 0 || (hashMap = f12017m) == null || !hashMap.containsKey(str)) {
                    return;
                }
                String str2 = f12017m.get(str);
                String str3 = null;
                if (str2 != null && str2.length() > 0) {
                    str3 = new String(com.autonavi.aps.amapapi.security.a.b(b(str2), str), "utf-8");
                }
                if (str3 == null || str3.length() <= 0 || !str3.contains("http:")) {
                    return;
                }
                f12009e = str3;
                f12007c = str3;
            } catch (Throwable th) {
                a(th, "CoreUtil", "checkUrl");
            }
        }
    }

    public static void a(Throwable th, String str, String str2) {
        if ("reportError".equals(str2) || (th instanceof fk)) {
            return;
        }
        try {
            u5.p(th, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static Bundle a(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionBundle");
        }
        return bundle;
    }

    public static AMapLocationClientOption a(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
        if (r25 > r29) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009c, code lost:
        r22 = r22 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
        if (r29 > r25) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.amap.api.location.DPoint r31, java.util.List<com.amap.api.location.DPoint> r32) {
        /*
            r0 = r32
            double r15 = r31.getLongitude()
            double r17 = r31.getLatitude()
            double r19 = r31.getLatitude()
            r13 = 0
            java.lang.Object r1 = r0.get(r13)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            int r2 = r32.size()
            r21 = 1
            int r2 = r2 + (-1)
            java.lang.Object r2 = r0.get(r2)
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L2e
            java.lang.Object r1 = r0.get(r13)
            r0.add(r1)
        L2e:
            r1 = 0
            r22 = 0
        L31:
            int r2 = r32.size()
            int r2 = r2 + (-1)
            if (r1 >= r2) goto Lda
            java.lang.Object r2 = r0.get(r1)
            com.amap.api.location.DPoint r2 = (com.amap.api.location.DPoint) r2
            double r23 = r2.getLongitude()
            java.lang.Object r2 = r0.get(r1)
            com.amap.api.location.DPoint r2 = (com.amap.api.location.DPoint) r2
            double r25 = r2.getLatitude()
            int r14 = r1 + 1
            java.lang.Object r1 = r0.get(r14)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            double r27 = r1.getLongitude()
            java.lang.Object r1 = r0.get(r14)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            double r29 = r1.getLatitude()
            r1 = r15
            r3 = r17
            r5 = r23
            r7 = r25
            r9 = r27
            r11 = r29
            boolean r1 = a(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto L75
            return r21
        L75:
            double r1 = r29 - r25
            double r1 = java.lang.Math.abs(r1)
            r3 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L9e
            r9 = 4640537203540230144(0x4066800000000000, double:180.0)
            r1 = r23
            r3 = r25
            r5 = r15
            r7 = r17
            r11 = r19
            boolean r1 = a(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto La3
            int r1 = (r25 > r29 ? 1 : (r25 == r29 ? 0 : -1))
            if (r1 <= 0) goto L9e
        L9c:
            int r22 = r22 + 1
        L9e:
            r24 = r14
            r23 = 0
            goto Ld5
        La3:
            r9 = 4640537203540230144(0x4066800000000000, double:180.0)
            r1 = r27
            r3 = r29
            r5 = r15
            r7 = r17
            r11 = r19
            boolean r1 = a(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto Lbc
            int r1 = (r29 > r25 ? 1 : (r29 == r25 ? 0 : -1))
            if (r1 <= 0) goto L9e
            goto L9c
        Lbc:
            r1 = r23
            r3 = r25
            r5 = r27
            r7 = r29
            r9 = r15
            r11 = r17
            r24 = r14
            r23 = 0
            r13 = r19
            boolean r1 = a(r1, r3, r5, r7, r9, r11, r13)
            if (r1 == 0) goto Ld5
            int r22 = r22 + 1
        Ld5:
            r1 = r24
            r13 = 0
            goto L31
        Lda:
            r23 = 0
            int r22 = r22 % 2
            if (r22 == 0) goto Le2
            r13 = 1
            goto Le3
        Le2:
            r13 = 0
        Le3:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.b.a(com.amap.api.location.DPoint, java.util.List):boolean");
    }

    private static boolean a(double d4, double d5, double d6, double d7, double d8, double d9) {
        return Math.abs(b(d4, d5, d6, d7, d8, d9)) < 1.0E-9d && (d4 - d6) * (d4 - d8) <= 0.0d && (d5 - d7) * (d5 - d9) <= 0.0d;
    }
}
