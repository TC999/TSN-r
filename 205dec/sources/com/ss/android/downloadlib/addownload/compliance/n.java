package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.downloadlib.h.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private ok f48457a;
    private int bl;

    /* renamed from: h  reason: collision with root package name */
    private String f48458h;

    /* renamed from: j  reason: collision with root package name */
    private String f48459j;

    /* renamed from: k  reason: collision with root package name */
    private String f48460k;
    private int kf;

    /* renamed from: n  reason: collision with root package name */
    private int f48461n = 15;
    private boolean ok;

    /* renamed from: p  reason: collision with root package name */
    private String f48462p;

    /* renamed from: q  reason: collision with root package name */
    private int f48463q;

    /* renamed from: r  reason: collision with root package name */
    private long f48464r;
    private a rh;

    /* renamed from: s  reason: collision with root package name */
    private int f48465s;

    /* renamed from: t  reason: collision with root package name */
    private String f48466t;

    /* renamed from: z  reason: collision with root package name */
    private String f48467z;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f48468a;
        private int ok;

        public void ok(int i4) {
            this.ok = i4;
        }

        public void ok(String str) {
            this.f48468a = str;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f48469a;
        private long bl;

        /* renamed from: h  reason: collision with root package name */
        private List<C0942ok> f48470h;

        /* renamed from: j  reason: collision with root package name */
        private String f48471j;

        /* renamed from: k  reason: collision with root package name */
        private String f48472k;
        private String kf;

        /* renamed from: n  reason: collision with root package name */
        private String f48473n;
        private String ok;

        /* renamed from: p  reason: collision with root package name */
        private String f48474p;

        /* renamed from: q  reason: collision with root package name */
        private String f48475q;

        /* renamed from: r  reason: collision with root package name */
        private String f48476r;

        /* renamed from: s  reason: collision with root package name */
        private long f48477s;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.n$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0942ok {

            /* renamed from: a  reason: collision with root package name */
            private String f48478a;
            private String ok;

            public void a(String str) {
                this.f48478a = str;
            }

            public void ok(String str) {
                this.ok = str;
            }
        }

        public void a(String str) {
            this.f48469a = str;
        }

        public void bl(String str) {
            this.f48473n = str;
        }

        public void h(String str) {
            this.f48472k = str;
        }

        public void kf(String str) {
            this.f48475q = str;
        }

        public void n(String str) {
            this.f48474p = str;
        }

        public void ok(String str) {
            this.ok = str;
        }

        public void p(String str) {
            this.f48476r = str;
        }

        public void q(String str) {
            this.f48471j = str;
        }

        public void s(String str) {
            this.kf = str;
        }

        public void a(long j4) {
            this.f48477s = j4;
        }

        public void ok(long j4) {
            this.bl = j4;
        }

        public void ok(List<C0942ok> list) {
            this.f48470h = list;
        }
    }

    public static n h(String str) {
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ok ok2 = ok(jSONObject);
            a a4 = a(jSONObject);
            nVar.ok(ok2);
            nVar.ok(a4);
            nVar.ok(jSONObject.optInt("show_auth", 0) == 1);
            nVar.ok(jSONObject.optInt("download_permit"));
            nVar.a(jSONObject.optInt("appstore_permit"));
            nVar.bl(jSONObject.optInt("market_online_status", 15));
            nVar.s(jSONObject.optInt("hijack_permit"));
            nVar.ok(jSONObject.optString("package_name"));
            nVar.a(jSONObject.optString("hijack_url"));
            nVar.n(jSONObject.optInt("code"));
            nVar.bl(jSONObject.optString("message"));
            nVar.ok(jSONObject.optLong("request_duration", 0L));
            nVar.s(jSONObject.optString("back_web_url"));
            nVar.n(jSONObject.optString("hw_app_id"));
            nVar.kf(jSONObject.optString(CampaignEx.JSON_KEY_DEEP_LINK_URL));
        } catch (Exception e4) {
            com.ss.android.downloadlib.n.bl.ok().ok(e4, "ComplianceResult fromJson");
        }
        return nVar;
    }

    public void a(int i4) {
        this.f48465s = i4;
    }

    public void bl(int i4) {
        this.f48461n = i4;
    }

    public void kf(String str) {
        this.f48467z = str;
    }

    public void n(int i4) {
        this.f48463q = i4;
    }

    public void ok(boolean z3) {
        this.ok = z3;
    }

    public void s(int i4) {
        this.kf = i4;
    }

    public String toString() {
        return ok(this);
    }

    public void a(String str) {
        this.f48462p = str;
    }

    public void bl(String str) {
        this.f48460k = str;
    }

    public void n(String str) {
        this.f48459j = str;
    }

    public void ok(ok okVar) {
        this.f48457a = okVar;
    }

    public void s(String str) {
        this.f48466t = str;
    }

    private static JSONArray bl(ok okVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<ok.C0942ok> list = okVar.f48470h;
        if (list != null && list.size() > 0) {
            for (ok.C0942ok c0942ok : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0942ok.ok);
                jSONObject.putOpt("permission_desc", c0942ok.f48478a);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public String a() {
        return this.f48467z;
    }

    public void ok(int i4) {
        this.bl = i4;
    }

    private static JSONObject a(ok okVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (okVar != null) {
            jSONObject.putOpt("app_name", okVar.ok);
            jSONObject.putOpt("version_name", okVar.f48469a);
            jSONObject.putOpt("update_time", Long.valueOf(okVar.bl));
            jSONObject.putOpt("size", Long.valueOf(okVar.f48477s));
            jSONObject.putOpt("developer_name", okVar.f48473n);
            jSONObject.putOpt("policy_url", okVar.f48475q);
            jSONObject.putOpt(CampaignEx.JSON_KEY_ICON_URL, okVar.f48472k);
            jSONObject.putOpt(DownloadModel.DOWNLOAD_URL, okVar.f48476r);
            jSONObject.putOpt(TTDelegateActivity.INTENT_PERMISSIONS, bl(okVar));
            jSONObject.putOpt("permission_classify_url", okVar.f48474p);
            jSONObject.putOpt("desc_url", okVar.f48471j);
        }
        return jSONObject;
    }

    public void ok(String str) {
        this.f48458h = str;
    }

    public int ok() {
        return this.f48463q;
    }

    public void ok(long j4) {
        this.f48464r = j4;
    }

    public void ok(a aVar) {
        this.rh = aVar;
    }

    public static String ok(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(nVar.ok ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(nVar.bl));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(nVar.f48465s));
            jSONObject.putOpt("market_online_status", Integer.valueOf(nVar.f48461n));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(nVar.kf));
            jSONObject.putOpt("package_name", nVar.f48458h);
            jSONObject.putOpt("hijack_url", nVar.f48462p);
            jSONObject.putOpt("code", Integer.valueOf(nVar.f48463q));
            jSONObject.putOpt("message", nVar.f48460k);
            jSONObject.putOpt("request_duration", Long.valueOf(nVar.f48464r));
            jSONObject.putOpt("auth_info", a(nVar.f48457a));
            jSONObject.putOpt("status", a(nVar.rh));
            jSONObject.putOpt("back_web_url", nVar.f48466t);
            jSONObject.putOpt("hw_app_id", nVar.f48459j);
            jSONObject.putOpt(CampaignEx.JSON_KEY_DEEP_LINK_URL, nVar.f48467z);
        } catch (JSONException e4) {
            com.ss.android.downloadlib.n.bl.ok().ok(e4, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                aVar.ok(optJSONObject.optInt("status"));
                aVar.ok(optJSONObject.optString("message"));
            }
        } catch (Exception e4) {
            com.ss.android.downloadlib.n.bl.ok().ok(e4, "ComplianceResult getStatus");
        }
        return aVar;
    }

    private static JSONObject a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(aVar.ok));
            jSONObject.putOpt("message", aVar.f48468a);
        }
        return jSONObject;
    }

    private static ok ok(JSONObject jSONObject) {
        ok okVar = new ok();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                okVar.ok(optJSONObject.optString("app_name"));
                okVar.a(optJSONObject.optString("version_name"));
                okVar.ok(j.ok(optJSONObject, "update_time"));
                okVar.a(j.ok(optJSONObject, "size"));
                okVar.bl(optJSONObject.optString("developer_name"));
                okVar.s(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray(TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    ok(optJSONArray, arrayList);
                    okVar.ok(arrayList);
                }
                okVar.n(optJSONObject.optString("permission_classify_url"));
                okVar.kf(optJSONObject.optString("policy_url"));
                okVar.h(optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL));
                okVar.p(optJSONObject.optString(DownloadModel.DOWNLOAD_URL));
                okVar.q(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e4) {
            com.ss.android.downloadlib.n.bl.ok().ok(e4, "ComplianceResult getAuthInfo");
        }
        return okVar;
    }

    private static void ok(JSONArray jSONArray, List<ok.C0942ok> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                ok.C0942ok c0942ok = new ok.C0942ok();
                c0942ok.ok(optJSONObject.optString("permission_name"));
                c0942ok.a(optJSONObject.optString("permission_desc"));
                list.add(c0942ok);
            }
        }
    }
}
