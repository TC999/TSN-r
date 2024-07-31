package com.p521ss.android.downloadlib.addownload.compliance;

import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12072n {

    /* renamed from: a */
    private C12074ok f34160a;

    /* renamed from: bl */
    private int f34161bl;

    /* renamed from: h */
    private String f34162h;

    /* renamed from: j */
    private String f34163j;

    /* renamed from: k */
    private String f34164k;

    /* renamed from: kf */
    private int f34165kf;

    /* renamed from: n */
    private int f34166n = 15;

    /* renamed from: ok */
    private boolean f34167ok;

    /* renamed from: p */
    private String f34168p;

    /* renamed from: q */
    private int f34169q;

    /* renamed from: r */
    private long f34170r;

    /* renamed from: rh */
    private C12073a f34171rh;

    /* renamed from: s */
    private int f34172s;

    /* renamed from: t */
    private String f34173t;

    /* renamed from: z */
    private String f34174z;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.n$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12073a {

        /* renamed from: a */
        private String f34175a;

        /* renamed from: ok */
        private int f34176ok;

        /* renamed from: ok */
        public void m19165ok(int i) {
            this.f34176ok = i;
        }

        /* renamed from: ok */
        public void m19163ok(String str) {
            this.f34175a = str;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12074ok {

        /* renamed from: a */
        private String f34177a;

        /* renamed from: bl */
        private long f34178bl;

        /* renamed from: h */
        private List<C12075ok> f34179h;

        /* renamed from: j */
        private String f34180j;

        /* renamed from: k */
        private String f34181k;

        /* renamed from: kf */
        private String f34182kf;

        /* renamed from: n */
        private String f34183n;

        /* renamed from: ok */
        private String f34184ok;

        /* renamed from: p */
        private String f34185p;

        /* renamed from: q */
        private String f34186q;

        /* renamed from: r */
        private String f34187r;

        /* renamed from: s */
        private long f34188s;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.n$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12075ok {

            /* renamed from: a */
            private String f34189a;

            /* renamed from: ok */
            private String f34190ok;

            /* renamed from: a */
            public void m19138a(String str) {
                this.f34189a = str;
            }

            /* renamed from: ok */
            public void m19136ok(String str) {
                this.f34190ok = str;
            }
        }

        /* renamed from: a */
        public void m19160a(String str) {
            this.f34177a = str;
        }

        /* renamed from: bl */
        public void m19158bl(String str) {
            this.f34183n = str;
        }

        /* renamed from: h */
        public void m19156h(String str) {
            this.f34181k = str;
        }

        /* renamed from: kf */
        public void m19153kf(String str) {
            this.f34186q = str;
        }

        /* renamed from: n */
        public void m19151n(String str) {
            this.f34185p = str;
        }

        /* renamed from: ok */
        public void m19148ok(String str) {
            this.f34184ok = str;
        }

        /* renamed from: p */
        public void m19145p(String str) {
            this.f34187r = str;
        }

        /* renamed from: q */
        public void m19143q(String str) {
            this.f34180j = str;
        }

        /* renamed from: s */
        public void m19140s(String str) {
            this.f34182kf = str;
        }

        /* renamed from: a */
        public void m19162a(long j) {
            this.f34188s = j;
        }

        /* renamed from: ok */
        public void m19150ok(long j) {
            this.f34178bl = j;
        }

        /* renamed from: ok */
        public void m19147ok(List<C12075ok> list) {
            this.f34179h = list;
        }
    }

    /* renamed from: h */
    public static C12072n m19182h(String str) {
        C12072n c12072n = new C12072n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            C12074ok m19170ok = m19170ok(jSONObject);
            C12073a m19186a = m19186a(jSONObject);
            c12072n.m19174ok(m19170ok);
            c12072n.m19175ok(m19186a);
            c12072n.m19169ok(jSONObject.optInt("show_auth", 0) == 1);
            c12072n.m19177ok(jSONObject.optInt("download_permit"));
            c12072n.m19190a(jSONObject.optInt("appstore_permit"));
            c12072n.m19185bl(jSONObject.optInt("market_online_status", 15));
            c12072n.m19168s(jSONObject.optInt("hijack_permit"));
            c12072n.m19172ok(jSONObject.optString("package_name"));
            c12072n.m19187a(jSONObject.optString("hijack_url"));
            c12072n.m19180n(jSONObject.optInt("code"));
            c12072n.m19183bl(jSONObject.optString("message"));
            c12072n.m19176ok(jSONObject.optLong("request_duration", 0L));
            c12072n.m19167s(jSONObject.optString("back_web_url"));
            c12072n.m19179n(jSONObject.optString("hw_app_id"));
            c12072n.m19181kf(jSONObject.optString(CampaignEx.JSON_KEY_DEEP_LINK_URL));
        } catch (Exception e) {
            C12235bl.m18640ok().mo18637ok(e, "ComplianceResult fromJson");
        }
        return c12072n;
    }

    /* renamed from: a */
    public void m19190a(int i) {
        this.f34172s = i;
    }

    /* renamed from: bl */
    public void m19185bl(int i) {
        this.f34166n = i;
    }

    /* renamed from: kf */
    public void m19181kf(String str) {
        this.f34174z = str;
    }

    /* renamed from: n */
    public void m19180n(int i) {
        this.f34169q = i;
    }

    /* renamed from: ok */
    public void m19169ok(boolean z) {
        this.f34167ok = z;
    }

    /* renamed from: s */
    public void m19168s(int i) {
        this.f34165kf = i;
    }

    public String toString() {
        return m19173ok(this);
    }

    /* renamed from: a */
    public void m19187a(String str) {
        this.f34168p = str;
    }

    /* renamed from: bl */
    public void m19183bl(String str) {
        this.f34164k = str;
    }

    /* renamed from: n */
    public void m19179n(String str) {
        this.f34163j = str;
    }

    /* renamed from: ok */
    public void m19174ok(C12074ok c12074ok) {
        this.f34160a = c12074ok;
    }

    /* renamed from: s */
    public void m19167s(String str) {
        this.f34173t = str;
    }

    /* renamed from: bl */
    private static JSONArray m19184bl(C12074ok c12074ok) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<C12074ok.C12075ok> list = c12074ok.f34179h;
        if (list != null && list.size() > 0) {
            for (C12074ok.C12075ok c12075ok : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c12075ok.f34190ok);
                jSONObject.putOpt("permission_desc", c12075ok.f34189a);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public String m19191a() {
        return this.f34174z;
    }

    /* renamed from: ok */
    public void m19177ok(int i) {
        this.f34161bl = i;
    }

    /* renamed from: a */
    private static JSONObject m19188a(C12074ok c12074ok) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (c12074ok != null) {
            jSONObject.putOpt("app_name", c12074ok.f34184ok);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, c12074ok.f34177a);
            jSONObject.putOpt("update_time", Long.valueOf(c12074ok.f34178bl));
            jSONObject.putOpt("size", Long.valueOf(c12074ok.f34188s));
            jSONObject.putOpt("developer_name", c12074ok.f34183n);
            jSONObject.putOpt("policy_url", c12074ok.f34186q);
            jSONObject.putOpt(CampaignEx.JSON_KEY_ICON_URL, c12074ok.f34181k);
            jSONObject.putOpt(DownloadModel.DOWNLOAD_URL, c12074ok.f34187r);
            jSONObject.putOpt(TTDelegateActivity.INTENT_PERMISSIONS, m19184bl(c12074ok));
            jSONObject.putOpt("permission_classify_url", c12074ok.f34185p);
            jSONObject.putOpt("desc_url", c12074ok.f34180j);
        }
        return jSONObject;
    }

    /* renamed from: ok */
    public void m19172ok(String str) {
        this.f34162h = str;
    }

    /* renamed from: ok */
    public int m19178ok() {
        return this.f34169q;
    }

    /* renamed from: ok */
    public void m19176ok(long j) {
        this.f34170r = j;
    }

    /* renamed from: ok */
    public void m19175ok(C12073a c12073a) {
        this.f34171rh = c12073a;
    }

    /* renamed from: ok */
    public static String m19173ok(C12072n c12072n) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(c12072n.f34167ok ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(c12072n.f34161bl));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(c12072n.f34172s));
            jSONObject.putOpt("market_online_status", Integer.valueOf(c12072n.f34166n));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(c12072n.f34165kf));
            jSONObject.putOpt("package_name", c12072n.f34162h);
            jSONObject.putOpt("hijack_url", c12072n.f34168p);
            jSONObject.putOpt("code", Integer.valueOf(c12072n.f34169q));
            jSONObject.putOpt("message", c12072n.f34164k);
            jSONObject.putOpt("request_duration", Long.valueOf(c12072n.f34170r));
            jSONObject.putOpt("auth_info", m19188a(c12072n.f34160a));
            jSONObject.putOpt("status", m19189a(c12072n.f34171rh));
            jSONObject.putOpt("back_web_url", c12072n.f34173t);
            jSONObject.putOpt("hw_app_id", c12072n.f34163j);
            jSONObject.putOpt(CampaignEx.JSON_KEY_DEEP_LINK_URL, c12072n.f34174z);
        } catch (JSONException e) {
            C12235bl.m18640ok().mo18637ok(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static C12073a m19186a(JSONObject jSONObject) {
        C12073a c12073a = new C12073a();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                c12073a.m19165ok(optJSONObject.optInt("status"));
                c12073a.m19163ok(optJSONObject.optString("message"));
            }
        } catch (Exception e) {
            C12235bl.m18640ok().mo18637ok(e, "ComplianceResult getStatus");
        }
        return c12073a;
    }

    /* renamed from: a */
    private static JSONObject m19189a(C12073a c12073a) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (c12073a != null) {
            jSONObject.putOpt("status", Integer.valueOf(c12073a.f34176ok));
            jSONObject.putOpt("message", c12073a.f34175a);
        }
        return jSONObject;
    }

    /* renamed from: ok */
    private static C12074ok m19170ok(JSONObject jSONObject) {
        C12074ok c12074ok = new C12074ok();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                c12074ok.m19148ok(optJSONObject.optString("app_name"));
                c12074ok.m19160a(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                c12074ok.m19150ok(C12197j.m18779ok(optJSONObject, "update_time"));
                c12074ok.m19162a(C12197j.m18779ok(optJSONObject, "size"));
                c12074ok.m19158bl(optJSONObject.optString("developer_name"));
                c12074ok.m19140s(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray(TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    m19171ok(optJSONArray, arrayList);
                    c12074ok.m19147ok(arrayList);
                }
                c12074ok.m19151n(optJSONObject.optString("permission_classify_url"));
                c12074ok.m19153kf(optJSONObject.optString("policy_url"));
                c12074ok.m19156h(optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL));
                c12074ok.m19145p(optJSONObject.optString(DownloadModel.DOWNLOAD_URL));
                c12074ok.m19143q(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            C12235bl.m18640ok().mo18637ok(e, "ComplianceResult getAuthInfo");
        }
        return c12074ok;
    }

    /* renamed from: ok */
    private static void m19171ok(JSONArray jSONArray, List<C12074ok.C12075ok> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C12074ok.C12075ok c12075ok = new C12074ok.C12075ok();
                c12075ok.m19136ok(optJSONObject.optString("permission_name"));
                c12075ok.m19138a(optJSONObject.optString("permission_desc"));
                list.add(c12075ok);
            }
        }
    }
}
