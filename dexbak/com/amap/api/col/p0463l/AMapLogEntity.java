package com.amap.api.col.p0463l;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UContent;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.z4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapLogEntity {

    /* renamed from: e */
    public static int f5818e = 1;

    /* renamed from: f */
    public static int f5819f = 2;

    /* renamed from: a */
    private String f5820a;

    /* renamed from: b */
    private int f5821b;

    /* renamed from: c */
    private long f5822c = System.currentTimeMillis();

    /* renamed from: d */
    private String f5823d;

    private AMapLogEntity(int i, String str, String str2) {
        this.f5820a = str2;
        this.f5821b = i;
        this.f5823d = str;
    }

    /* renamed from: b */
    public static AMapLogEntity m53331b(String str, String str2) {
        return new AMapLogEntity(f5818e, str, str2);
    }

    /* renamed from: c */
    public static String m53330c(int i) {
        return i == f5819f ? "error" : "info";
    }

    /* renamed from: d */
    public static String m53329d(List<AMapLogEntity> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (AMapLogEntity aMapLogEntity : list) {
                        String m53325h = m53325h(aMapLogEntity);
                        if (!TextUtils.isEmpty(m53325h)) {
                            jSONArray.put(m53325h);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    /* renamed from: e */
    public static boolean m53328e(AMapLogEntity aMapLogEntity) {
        return (aMapLogEntity == null || TextUtils.isEmpty(aMapLogEntity.m53326g())) ? false : true;
    }

    /* renamed from: f */
    public static AMapLogEntity m53327f(String str, String str2) {
        return new AMapLogEntity(f5819f, str, str2);
    }

    /* renamed from: h */
    private static String m53325h(AMapLogEntity aMapLogEntity) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", aMapLogEntity.m53326g());
            jSONObject.put(UContent.f38099aC, aMapLogEntity.m53323j());
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, aMapLogEntity.f5822c);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: j */
    private String m53323j() {
        return this.f5823d;
    }

    /* renamed from: a */
    public final int m53332a() {
        return this.f5821b;
    }

    /* renamed from: g */
    public final String m53326g() {
        new JSONObject();
        return this.f5820a;
    }

    /* renamed from: i */
    public final String m53324i() {
        return m53330c(this.f5821b);
    }
}
