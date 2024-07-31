package com.p521ss.android.downloadlib.addownload.p528a;

import com.p521ss.android.downloadlib.p534h.C12197j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.a.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12036ok {

    /* renamed from: a */
    public long f34081a;

    /* renamed from: bl */
    public long f34082bl;

    /* renamed from: h */
    public String f34083h;

    /* renamed from: kf */
    public String f34084kf;

    /* renamed from: n */
    public String f34085n;

    /* renamed from: ok */
    public long f34086ok;

    /* renamed from: p */
    public volatile long f34087p;

    /* renamed from: s */
    public String f34088s;

    public C12036ok() {
    }

    /* renamed from: ok */
    public JSONObject m19284ok() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f34086ok);
            jSONObject.put("mAdId", this.f34081a);
            jSONObject.put("mExtValue", this.f34082bl);
            jSONObject.put("mPackageName", this.f34088s);
            jSONObject.put("mAppName", this.f34085n);
            jSONObject.put("mLogExtra", this.f34084kf);
            jSONObject.put("mFileName", this.f34083h);
            jSONObject.put("mTimeStamp", this.f34087p);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public C12036ok(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.f34086ok = j;
        this.f34081a = j2;
        this.f34082bl = j3;
        this.f34088s = str;
        this.f34085n = str2;
        this.f34084kf = str3;
        this.f34083h = str4;
    }

    /* renamed from: ok */
    public static C12036ok m19283ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C12036ok c12036ok = new C12036ok();
        try {
            c12036ok.f34086ok = C12197j.m18779ok(jSONObject, "mDownloadId");
            c12036ok.f34081a = C12197j.m18779ok(jSONObject, "mAdId");
            c12036ok.f34082bl = C12197j.m18779ok(jSONObject, "mExtValue");
            c12036ok.f34088s = jSONObject.optString("mPackageName");
            c12036ok.f34085n = jSONObject.optString("mAppName");
            c12036ok.f34084kf = jSONObject.optString("mLogExtra");
            c12036ok.f34083h = jSONObject.optString("mFileName");
            c12036ok.f34087p = C12197j.m18779ok(jSONObject, "mTimeStamp");
            return c12036ok;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
