package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefconProcesser {

    /* renamed from: a */
    private static final int f38438a = 0;

    /* renamed from: b */
    private static final int f38439b = 1;

    /* renamed from: c */
    private static final int f38440c = 2;

    /* renamed from: d */
    private static final int f38441d = 3;

    /* renamed from: e */
    private final long f38442e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefconProcesser.java */
    /* renamed from: com.umeng.analytics.pro.r$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13173a {

        /* renamed from: a */
        public static final DefconProcesser f38443a = new DefconProcesser();

        private C13173a() {
        }
    }

    /* renamed from: a */
    public static DefconProcesser m14212a() {
        return C13173a.f38443a;
    }

    /* renamed from: c */
    private JSONArray m14206c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", SessionIdManager.m14159a().m14148d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(UContent.f38151p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    /* renamed from: b */
    public void m14207b(JSONObject jSONObject, Context context) {
        int m14211a = m14211a(context);
        if (m14211a == 1) {
            if (jSONObject.has(UContent.f38081L)) {
                jSONObject.remove(UContent.f38081L);
            }
            if (jSONObject.has(UContent.f38149n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(UContent.f38149n);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(UContent.f38097aA)) {
                            jSONObject2.remove(UContent.f38097aA);
                        }
                        if (jSONObject2.has(UContent.f38098aB)) {
                            jSONObject2.remove(UContent.f38098aB);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            UMStoreManager.m14345a(context).m14333a(false, true);
        } else if (m14211a == 2) {
            if (jSONObject.has(UContent.f38081L)) {
                jSONObject.remove(UContent.f38081L);
            }
            if (jSONObject.has(UContent.f38149n)) {
                jSONObject.remove(UContent.f38149n);
            }
            try {
                jSONObject.put(UContent.f38149n, m14206c());
            } catch (Exception unused2) {
            }
            UMStoreManager.m14345a(context).m14333a(false, true);
        } else if (m14211a == 3) {
            if (jSONObject.has(UContent.f38081L)) {
                jSONObject.remove(UContent.f38081L);
            }
            jSONObject.remove(UContent.f38149n);
            UMStoreManager.m14345a(context).m14333a(false, true);
        }
    }

    private DefconProcesser() {
        this.f38442e = 60000L;
    }

    /* renamed from: a */
    public int m14211a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    /* renamed from: a */
    private void m14209a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(UContent.f38149n)) {
            jSONObject.remove(UContent.f38149n);
        }
        if (jSONObject.has(UContent.f38081L)) {
            jSONObject.remove(UContent.f38081L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(UContent.f38095Z)) {
            jSONObject.remove(UContent.f38095Z);
        }
        if (jSONObject.has(UContent.f38081L)) {
            jSONObject.remove(UContent.f38081L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    /* renamed from: a */
    public void m14210a(JSONObject jSONObject, Context context) {
        int m14211a = m14211a(context);
        if (m14211a == 1) {
            m14209a(jSONObject, true);
            UMStoreManager.m14345a(context).m14325b(false, true);
        } else if (m14211a == 2) {
            jSONObject.remove(UContent.f38149n);
            try {
                jSONObject.put(UContent.f38149n, m14208b());
            } catch (Exception unused) {
            }
            m14209a(jSONObject, true);
            UMStoreManager.m14345a(context).m14325b(false, true);
        } else if (m14211a == 3) {
            m14209a(jSONObject, false);
            UMStoreManager.m14345a(context).m14325b(false, true);
        }
    }

    /* renamed from: b */
    private JSONArray m14208b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", SessionIdManager.m14159a().m14156a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(UContent.f38151p, currentTimeMillis);
            jSONObject.put(UContent.f38152q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
