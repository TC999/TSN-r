package com.amap.api.col.p0463l;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.d1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GeoFenceSearchResultParser {

    /* renamed from: a */
    private static long f3790a;

    /* renamed from: a */
    private static double m55417a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        double longitude;
        double latitude;
        double longitude2 = dPoint.getLongitude() - dPoint2.getLongitude();
        double latitude2 = dPoint.getLatitude() - dPoint2.getLatitude();
        double longitude3 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude3 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        boolean z = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
        if (d < Utils.DOUBLE_EPSILON || z) {
            longitude = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude();
        } else if (d > 1.0d) {
            longitude = dPoint3.getLongitude();
            latitude = dPoint3.getLatitude();
        } else {
            latitude = dPoint2.getLatitude() + (d * latitude3);
            longitude = dPoint2.getLongitude() + (longitude3 * d);
        }
        return C2432j.m51195a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(latitude, longitude));
    }

    /* renamed from: b */
    public static int m55416b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c = 0;
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString("name"));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString("address"));
                    String optString = jSONObject2.optString(SocializeConstants.KEY_LOCATION);
                    if (optString != null) {
                        String[] split = optString.split(",");
                        poiItem.setLongitude(Double.parseDouble(split[c]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        List<List<DPoint>> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        i = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(m55415c());
                    geoFence.setFenceId(sb.toString());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i2++;
                    optInt2 = i;
                    c = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    /* renamed from: c */
    public static synchronized long m55415c() {
        long j;
        synchronized (GeoFenceSearchResultParser.class) {
            long m51186b = C2432j.m51186b();
            long j2 = f3790a;
            if (m51186b > j2) {
                f3790a = m51186b;
            } else {
                f3790a = j2 + 1;
            }
            j = f3790a;
        }
        return j;
    }

    /* renamed from: d */
    private List<DPoint> m55414d(List<DPoint> list, float f) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d = Utils.DOUBLE_EPSILON;
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        int i = 0;
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            double m55417a = m55417a(list.get(i2), dPoint, dPoint2);
            if (m55417a > d) {
                i = i2;
                d = m55417a;
            }
        }
        if (d < f) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> m55414d = m55414d(list.subList(0, i + 1), f);
        List<DPoint> m55414d2 = m55414d(list.subList(i, list.size()), f);
        arrayList.addAll(m55414d);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(m55414d2);
        return arrayList;
    }

    /* renamed from: e */
    public static int m55413e(String str, List<GeoFence> list, Bundle bundle) {
        return m55416b(str, list, bundle);
    }

    /* renamed from: f */
    public final int m55412f(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str2;
        int i;
        String str3;
        String str4;
        float f;
        long j;
        long j2;
        int i2;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f2 = bundle.getFloat("fenceRadius");
            long j3 = bundle.getLong("expiration");
            int i3 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i4 = 0;
                while (i4 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString("center");
                    int i5 = optInt2;
                    DPoint dPoint = new DPoint();
                    int i6 = i4;
                    String str6 = ",";
                    if (string3 != null) {
                        String[] split = string3.split(",");
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f2);
                    geoFence.setExpiration(j3);
                    geoFence.setActivatesAction(i3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(m55415c());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        i = i3;
                        float f3 = Float.MAX_VALUE;
                        int i7 = 0;
                        float f4 = Float.MIN_VALUE;
                        while (i7 < length) {
                            String str7 = string;
                            String str8 = split2[i7];
                            String[] strArr = split2;
                            DistrictItem districtItem = new DistrictItem();
                            String str9 = string2;
                            List<DPoint> arrayList4 = new ArrayList<>();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            String str10 = optString2;
                            String str11 = str2;
                            districtItem.setDistrictName(str11);
                            str2 = str11;
                            String[] split3 = str8.split(";");
                            float f5 = f2;
                            int i8 = 0;
                            while (i8 < split3.length) {
                                String[] split4 = split3[i8].split(str6);
                                String str12 = str6;
                                String[] strArr2 = split3;
                                if (split4.length > 1) {
                                    String str13 = split4[1];
                                    String str14 = split4[0];
                                    j2 = j3;
                                    double parseDouble = Double.parseDouble(str13);
                                    i2 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str14)));
                                } else {
                                    j2 = j3;
                                    i2 = length;
                                    str5 = optString;
                                }
                                i8++;
                                optString = str5;
                                str6 = str12;
                                split3 = strArr2;
                                j3 = j2;
                                length = i2;
                            }
                            String str15 = str6;
                            long j4 = j3;
                            int i9 = length;
                            String str16 = optString;
                            if (arrayList4.size() > 100.0f) {
                                try {
                                    arrayList4 = m55414d(arrayList4, 100.0f);
                                    continue;
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            } else {
                                continue;
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            ArrayList arrayList5 = arrayList;
                            arrayList5.add(districtItem);
                            f4 = Math.max(f4, GeoFenceManager.m55840A(dPoint, arrayList4));
                            f3 = Math.min(f3, GeoFenceManager.m55812b(dPoint, arrayList4));
                            i7++;
                            optString = str16;
                            arrayList = arrayList5;
                            string = str7;
                            split2 = strArr;
                            string2 = str9;
                            optString2 = str10;
                            f2 = f5;
                            str6 = str15;
                            j3 = j4;
                            length = i9;
                        }
                        str3 = string;
                        str4 = string2;
                        f = f2;
                        j = j3;
                        geoFence.setMaxDis2Center(f4);
                        geoFence.setMinDis2Center(f3);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i = i3;
                        str3 = string;
                        str4 = string2;
                        f = f2;
                        j = j3;
                    }
                    i4 = i6 + 1;
                    optJSONArray = jSONArray;
                    optInt2 = i5;
                    i3 = i;
                    string = str3;
                    string2 = str4;
                    f2 = f;
                    j3 = j;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
        }
    }
}
