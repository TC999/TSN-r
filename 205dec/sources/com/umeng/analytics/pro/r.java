package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DefconProcesser.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final int f53109a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f53110b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f53111c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f53112d = 3;

    /* renamed from: e  reason: collision with root package name */
    private final long f53113e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: DefconProcesser.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final r f53114a = new r();

        private a() {
        }
    }

    public static r a() {
        return a.f53114a;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public void b(JSONObject jSONObject, Context context) {
        int a4 = a(context);
        if (a4 == 1) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            if (jSONObject.has("sessions")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("sessions");
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        if (jSONObject2.has("_$sp")) {
                            jSONObject2.remove("_$sp");
                        }
                        if (jSONObject2.has("_$pp")) {
                            jSONObject2.remove("_$pp");
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            i.a(context).a(false, true);
        } else if (a4 == 2) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            if (jSONObject.has("sessions")) {
                jSONObject.remove("sessions");
            }
            try {
                jSONObject.put("sessions", c());
            } catch (Exception unused2) {
            }
            i.a(context).a(false, true);
        } else if (a4 == 3) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            jSONObject.remove("sessions");
            i.a(context).a(false, true);
        }
    }

    private r() {
        this.f53113e = 60000L;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z3) {
        if (!z3 && jSONObject.has("sessions")) {
            jSONObject.remove("sessions");
        }
        if (jSONObject.has("active_user")) {
            jSONObject.remove("active_user");
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has("gkv")) {
            jSONObject.remove("gkv");
        }
        if (jSONObject.has("active_user")) {
            jSONObject.remove("active_user");
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int a4 = a(context);
        if (a4 == 1) {
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a4 == 2) {
            jSONObject.remove("sessions");
            try {
                jSONObject.put("sessions", b());
            } catch (Exception unused) {
            }
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a4 == 3) {
            a(jSONObject, false);
            i.a(context).b(false, true);
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONObject.put("end_time", currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
