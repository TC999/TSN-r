package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StyleItemAdaptor.java */
/* renamed from: com.amap.api.col.3l.b2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f7200a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f7201b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[][] f7202c = {new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", "country", "province", "city", "district", "town", "village"}};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f7203d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i4 = -1;
        int i5 = 0;
        while (true) {
            String[] strArr = f7201b;
            if (i5 >= strArr.length) {
                break;
            } else if (strArr[i5].equals(str)) {
                i4 = i5;
                break;
            } else {
                i5++;
            }
        }
        if (i4 >= 0) {
            return f7202c[i4];
        }
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i4 = -1;
        int i5 = 0;
        while (true) {
            String[] strArr = f7201b;
            if (i5 >= strArr.length) {
                break;
            } else if (strArr[i5].equals(str)) {
                i4 = i5;
                break;
            } else {
                i5++;
            }
        }
        if (i4 >= 0) {
            return f7203d[i4];
        }
        return null;
    }
}
