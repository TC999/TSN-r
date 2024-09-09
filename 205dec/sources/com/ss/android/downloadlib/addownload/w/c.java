package com.ss.android.downloadlib.addownload.w;

import com.ss.android.downloadlib.r.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public long f48702c;
    public volatile long ev;

    /* renamed from: f  reason: collision with root package name */
    public String f48703f;

    /* renamed from: r  reason: collision with root package name */
    public String f48704r;
    public String sr;
    public String ux;

    /* renamed from: w  reason: collision with root package name */
    public long f48705w;
    public long xv;

    public c() {
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f48702c);
            jSONObject.put("mAdId", this.f48705w);
            jSONObject.put("mExtValue", this.xv);
            jSONObject.put("mPackageName", this.sr);
            jSONObject.put("mAppName", this.ux);
            jSONObject.put("mLogExtra", this.f48703f);
            jSONObject.put("mFileName", this.f48704r);
            jSONObject.put("mTimeStamp", this.ev);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public c(long j4, long j5, long j6, String str, String str2, String str3, String str4) {
        this.f48702c = j4;
        this.f48705w = j5;
        this.xv = j6;
        this.sr = str;
        this.ux = str2;
        this.f48703f = str3;
        this.f48704r = str4;
    }

    public static c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        try {
            cVar.f48702c = a.c(jSONObject, "mDownloadId");
            cVar.f48705w = a.c(jSONObject, "mAdId");
            cVar.xv = a.c(jSONObject, "mExtValue");
            cVar.sr = jSONObject.optString("mPackageName");
            cVar.ux = jSONObject.optString("mAppName");
            cVar.f48703f = jSONObject.optString("mLogExtra");
            cVar.f48704r = jSONObject.optString("mFileName");
            cVar.ev = a.c(jSONObject, "mTimeStamp");
            return cVar;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
