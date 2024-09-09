package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {

    /* renamed from: a  reason: collision with root package name */
    private String f48497a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private boolean f48498c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f48499f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private long f48500k;

    /* renamed from: p  reason: collision with root package name */
    private String f48501p;

    /* renamed from: r  reason: collision with root package name */
    private String f48502r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private w f48503t;
    private int ux = 15;

    /* renamed from: w  reason: collision with root package name */
    private c f48504w;
    private int xv;
    private String ys;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f48505a;

        /* renamed from: c  reason: collision with root package name */
        private String f48506c;
        private String ev;

        /* renamed from: f  reason: collision with root package name */
        private String f48507f;
        private String gd;

        /* renamed from: k  reason: collision with root package name */
        private String f48508k;

        /* renamed from: p  reason: collision with root package name */
        private String f48509p;

        /* renamed from: r  reason: collision with root package name */
        private List<C0943c> f48510r;
        private long sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f48511w;
        private long xv;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.ux$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C0943c {

            /* renamed from: c  reason: collision with root package name */
            private String f48512c;

            /* renamed from: w  reason: collision with root package name */
            private String f48513w;

            public void c(String str) {
                this.f48512c = str;
            }

            public void w(String str) {
                this.f48513w = str;
            }
        }

        public void c(String str) {
            this.f48506c = str;
        }

        public void ev(String str) {
            this.f48508k = str;
        }

        public void f(String str) {
            this.gd = str;
        }

        public void gd(String str) {
            this.f48505a = str;
        }

        public void r(String str) {
            this.f48509p = str;
        }

        public void sr(String str) {
            this.f48507f = str;
        }

        public void ux(String str) {
            this.ev = str;
        }

        public void w(String str) {
            this.f48511w = str;
        }

        public void xv(String str) {
            this.ux = str;
        }

        public void c(long j4) {
            this.xv = j4;
        }

        public void w(long j4) {
            this.sr = j4;
        }

        public void c(List<C0943c> list) {
            this.f48510r = list;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        private int f48514c;

        /* renamed from: w  reason: collision with root package name */
        private String f48515w;

        public void c(int i4) {
            this.f48514c = i4;
        }

        public void c(String str) {
            this.f48515w = str;
        }
    }

    public static ux r(String str) {
        ux uxVar = new ux();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c c4 = c(jSONObject);
            w w3 = w(jSONObject);
            uxVar.c(c4);
            uxVar.c(w3);
            uxVar.c(jSONObject.optInt("show_auth", 0) == 1);
            uxVar.c(jSONObject.optInt("download_permit"));
            uxVar.w(jSONObject.optInt("appstore_permit"));
            uxVar.xv(jSONObject.optInt("market_online_status", 15));
            uxVar.sr(jSONObject.optInt("hijack_permit"));
            uxVar.c(jSONObject.optString("package_name"));
            uxVar.w(jSONObject.optString("hijack_url"));
            uxVar.ux(jSONObject.optInt("code"));
            uxVar.xv(jSONObject.optString("message"));
            uxVar.c(jSONObject.optLong("request_duration", 0L));
            uxVar.sr(jSONObject.optString("back_web_url"));
            uxVar.ux(jSONObject.optString("hw_app_id"));
            uxVar.f(jSONObject.optString(CampaignEx.JSON_KEY_DEEP_LINK_URL));
        } catch (Exception e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "ComplianceResult fromJson");
        }
        return uxVar;
    }

    public void c(boolean z3) {
        this.f48498c = z3;
    }

    public void f(String str) {
        this.bk = str;
    }

    public void sr(int i4) {
        this.f48499f = i4;
    }

    public String toString() {
        return c(this);
    }

    public void ux(int i4) {
        this.gd = i4;
    }

    public void w(int i4) {
        this.sr = i4;
    }

    public void xv(int i4) {
        this.ux = i4;
    }

    public void c(c cVar) {
        this.f48504w = cVar;
    }

    public void sr(String str) {
        this.ys = str;
    }

    public void ux(String str) {
        this.f48497a = str;
    }

    public void w(String str) {
        this.ev = str;
    }

    public void xv(String str) {
        this.f48501p = str;
    }

    private static JSONArray xv(c cVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<c.C0943c> list = cVar.f48510r;
        if (list != null && list.size() > 0) {
            for (c.C0943c c0943c : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0943c.f48512c);
                jSONObject.putOpt("permission_desc", c0943c.f48513w);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public void c(int i4) {
        this.xv = i4;
    }

    public String w() {
        return this.bk;
    }

    private static JSONObject w(c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.putOpt("app_name", cVar.f48506c);
            jSONObject.putOpt("version_name", cVar.f48511w);
            jSONObject.putOpt("update_time", Long.valueOf(cVar.xv));
            jSONObject.putOpt("size", Long.valueOf(cVar.sr));
            jSONObject.putOpt("developer_name", cVar.ux);
            jSONObject.putOpt("policy_url", cVar.gd);
            jSONObject.putOpt(CampaignEx.JSON_KEY_ICON_URL, cVar.f48509p);
            jSONObject.putOpt(DownloadModel.DOWNLOAD_URL, cVar.f48508k);
            jSONObject.putOpt(TTDelegateActivity.INTENT_PERMISSIONS, xv(cVar));
            jSONObject.putOpt("permission_classify_url", cVar.ev);
            jSONObject.putOpt("desc_url", cVar.f48505a);
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f48502r = str;
    }

    public int c() {
        return this.gd;
    }

    public void c(long j4) {
        this.f48500k = j4;
    }

    public void c(w wVar) {
        this.f48503t = wVar;
    }

    public static String c(ux uxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(uxVar.f48498c ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(uxVar.xv));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(uxVar.sr));
            jSONObject.putOpt("market_online_status", Integer.valueOf(uxVar.ux));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(uxVar.f48499f));
            jSONObject.putOpt("package_name", uxVar.f48502r);
            jSONObject.putOpt("hijack_url", uxVar.ev);
            jSONObject.putOpt("code", Integer.valueOf(uxVar.gd));
            jSONObject.putOpt("message", uxVar.f48501p);
            jSONObject.putOpt("request_duration", Long.valueOf(uxVar.f48500k));
            jSONObject.putOpt("auth_info", w(uxVar.f48504w));
            jSONObject.putOpt("status", w(uxVar.f48503t));
            jSONObject.putOpt("back_web_url", uxVar.ys);
            jSONObject.putOpt("hw_app_id", uxVar.f48497a);
            jSONObject.putOpt(CampaignEx.JSON_KEY_DEEP_LINK_URL, uxVar.bk);
        } catch (JSONException e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static w w(JSONObject jSONObject) {
        w wVar = new w();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                wVar.c(optJSONObject.optInt("status"));
                wVar.c(optJSONObject.optString("message"));
            }
        } catch (Exception e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "ComplianceResult getStatus");
        }
        return wVar;
    }

    private static JSONObject w(w wVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (wVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(wVar.f48514c));
            jSONObject.putOpt("message", wVar.f48515w);
        }
        return jSONObject;
    }

    private static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                cVar.c(optJSONObject.optString("app_name"));
                cVar.w(optJSONObject.optString("version_name"));
                cVar.c(com.ss.android.downloadlib.r.a.c(optJSONObject, "update_time"));
                cVar.w(com.ss.android.downloadlib.r.a.c(optJSONObject, "size"));
                cVar.xv(optJSONObject.optString("developer_name"));
                cVar.sr(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray(TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    c(optJSONArray, arrayList);
                    cVar.c(arrayList);
                }
                cVar.ux(optJSONObject.optString("permission_classify_url"));
                cVar.f(optJSONObject.optString("policy_url"));
                cVar.r(optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL));
                cVar.ev(optJSONObject.optString(DownloadModel.DOWNLOAD_URL));
                cVar.gd(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "ComplianceResult getAuthInfo");
        }
        return cVar;
    }

    private static void c(JSONArray jSONArray, List<c.C0943c> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                c.C0943c c0943c = new c.C0943c();
                c0943c.c(optJSONObject.optString("permission_name"));
                c0943c.w(optJSONObject.optString("permission_desc"));
                list.add(c0943c);
            }
        }
    }
}
