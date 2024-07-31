package com.amap.api.col.p0463l;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.UContent;
import io.netty.handler.codec.http.HttpHeaders;

/* renamed from: com.amap.api.col.3l.b2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class StyleItemAdaptor {

    /* renamed from: a */
    public static final int[][] f3639a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* renamed from: b */
    public static final String[] f3640b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", HttpHeaders.Values.BOUNDARY, "poilabel", "districtlable"};

    /* renamed from: c */
    public static final String[][] f3641c = {new String[]{"land", "edu", "public", UContent.f38075F, "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", AdnName.OTHER}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", "country", DistrictSearchQuery.KEYWORDS_PROVINCE, DistrictSearchQuery.KEYWORDS_CITY, DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};

    /* renamed from: d */
    public static final String[] f3642d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    /* renamed from: a */
    public static String[] m55566a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            String[] strArr = f3640b;
            if (i2 >= strArr.length) {
                break;
            } else if (strArr[i2].equals(str)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i >= 0) {
            return f3641c[i];
        }
        return null;
    }

    /* renamed from: b */
    public static String m55565b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            String[] strArr = f3640b;
            if (i2 >= strArr.length) {
                break;
            } else if (strArr[i2].equals(str)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i >= 0) {
            return f3642d[i];
        }
        return null;
    }
}
