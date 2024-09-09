package com.amap.api.col.p0003l;

import android.os.Bundle;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GeoFenceSearchResultParser.java */
/* renamed from: com.amap.api.col.3l.d1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static long f7360a;

    private static double a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        double longitude;
        double latitude;
        double longitude2 = dPoint.getLongitude() - dPoint2.getLongitude();
        double latitude2 = dPoint.getLatitude() - dPoint2.getLatitude();
        double longitude3 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude3 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d4 = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        boolean z3 = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
        if (d4 < 0.0d || z3) {
            longitude = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude();
        } else if (d4 > 1.0d) {
            longitude = dPoint3.getLongitude();
            latitude = dPoint3.getLatitude();
        } else {
            latitude = dPoint2.getLatitude() + (d4 * latitude3);
            longitude = dPoint2.getLongitude() + (longitude3 * d4);
        }
        return j.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(latitude, longitude));
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i4;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c4 = 0;
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i5 = 0;
                while (i5 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString("name"));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString("address"));
                    String optString = jSONObject2.optString("location");
                    if (optString != null) {
                        String[] split = optString.split(",");
                        poiItem.setLongitude(Double.parseDouble(split[c4]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        List<List<DPoint>> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        i4 = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i4 = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString("customId"));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i5++;
                    optInt2 = i4;
                    c4 = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long c() {
        long j4;
        synchronized (d1.class) {
            long b4 = j.b();
            long j5 = f7360a;
            if (b4 > j5) {
                f7360a = b4;
            } else {
                f7360a = j5 + 1;
            }
            j4 = f7360a;
        }
        return j4;
    }

    private List<DPoint> d(List<DPoint> list, float f4) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d4 = 0.0d;
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        int i4 = 0;
        for (int i5 = 1; i5 < list.size() - 1; i5++) {
            double a4 = a(list.get(i5), dPoint, dPoint2);
            if (a4 > d4) {
                i4 = i5;
                d4 = a4;
            }
        }
        if (d4 < f4) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> d5 = d(list.subList(0, i4 + 1), f4);
        List<DPoint> d6 = d(list.subList(i4, list.size()), f4);
        arrayList.addAll(d5);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(d6);
        return arrayList;
    }

    public static int e(String str, List<GeoFence> list, Bundle bundle) {
        return b(str, list, bundle);
    }

    public final int f(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str2;
        int i4;
        String str3;
        String str4;
        float f4;
        long j4;
        long j5;
        int i5;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString("customId");
            String string2 = bundle.getString("pendingIntentAction");
            float f5 = bundle.getFloat("fenceRadius");
            long j6 = bundle.getLong("expiration");
            int i6 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i7 = 0;
                while (i7 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i7);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString(AutoScrollViewPager.f4767g);
                    int i8 = optInt2;
                    DPoint dPoint = new DPoint();
                    int i9 = i7;
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
                    geoFence.setRadius(f5);
                    geoFence.setExpiration(j6);
                    geoFence.setActivatesAction(i6);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        i4 = i6;
                        float f6 = Float.MAX_VALUE;
                        int i10 = 0;
                        float f7 = Float.MIN_VALUE;
                        while (i10 < length) {
                            String str7 = string;
                            String str8 = split2[i10];
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
                            float f8 = f5;
                            int i11 = 0;
                            while (i11 < split3.length) {
                                String[] split4 = split3[i11].split(str6);
                                String str12 = str6;
                                String[] strArr2 = split3;
                                if (split4.length > 1) {
                                    String str13 = split4[1];
                                    String str14 = split4[0];
                                    j5 = j6;
                                    double parseDouble = Double.parseDouble(str13);
                                    i5 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str14)));
                                } else {
                                    j5 = j6;
                                    i5 = length;
                                    str5 = optString;
                                }
                                i11++;
                                optString = str5;
                                str6 = str12;
                                split3 = strArr2;
                                j6 = j5;
                                length = i5;
                            }
                            String str15 = str6;
                            long j7 = j6;
                            int i12 = length;
                            String str16 = optString;
                            if (arrayList4.size() > 100.0f) {
                                try {
                                    arrayList4 = d(arrayList4, 100.0f);
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
                            f7 = Math.max(f7, a.A(dPoint, arrayList4));
                            f6 = Math.min(f6, a.b(dPoint, arrayList4));
                            i10++;
                            optString = str16;
                            arrayList = arrayList5;
                            string = str7;
                            split2 = strArr;
                            string2 = str9;
                            optString2 = str10;
                            f5 = f8;
                            str6 = str15;
                            j6 = j7;
                            length = i12;
                        }
                        str3 = string;
                        str4 = string2;
                        f4 = f5;
                        j4 = j6;
                        geoFence.setMaxDis2Center(f7);
                        geoFence.setMinDis2Center(f6);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i4 = i6;
                        str3 = string;
                        str4 = string2;
                        f4 = f5;
                        j4 = j6;
                    }
                    i7 = i9 + 1;
                    optJSONArray = jSONArray;
                    optInt2 = i8;
                    i6 = i4;
                    string = str3;
                    string2 = str4;
                    f5 = f4;
                    j6 = j4;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
        }
    }
}
