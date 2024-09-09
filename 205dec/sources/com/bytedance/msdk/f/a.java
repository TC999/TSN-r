package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f28304c;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f28305w;

    public static List<String> c() {
        ArrayList arrayList = null;
        if (com.bytedance.msdk.core.w.k().n()) {
            Field[] declaredFields = com.bytedance.msdk.core.k.w.class.getDeclaredFields();
            if (declaredFields != null && declaredFields.length != 0) {
                arrayList = new ArrayList();
                for (Field field : declaredFields) {
                    if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                        arrayList.add(field.getName());
                    }
                }
                arrayList.remove("mTotalWaterFallCount");
                arrayList.remove("mWaterFallConfigList");
                arrayList.remove("mWaterFallConfMap");
                arrayList.remove("mTotalLoadLevelCount");
                arrayList.remove("mCurrentCommonAdMaxCpm");
                arrayList.remove("mLoadSortLevelList");
                arrayList.remove("hasServerBidding");
                arrayList.remove("hasClientOrMultiLevel");
                arrayList.remove("mRitInfoJson");
            }
            return arrayList;
        }
        return null;
    }

    public static List<String> w() {
        ArrayList arrayList = null;
        if (com.bytedance.msdk.core.w.k().n()) {
            Field[] declaredFields = com.bytedance.msdk.core.k.p.class.getDeclaredFields();
            if (declaredFields != null && declaredFields.length != 0) {
                arrayList = new ArrayList();
                for (Field field : declaredFields) {
                    if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                        arrayList.add(field.getName());
                    }
                }
                arrayList.remove("mServerBiddingWinner");
            }
            return arrayList;
        }
        return null;
    }

    public static void w(List<String> list, String str) {
    }

    public static void c(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }
}
