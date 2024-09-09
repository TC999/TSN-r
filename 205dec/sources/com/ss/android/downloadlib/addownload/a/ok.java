package com.ss.android.downloadlib.addownload.a;

import com.ss.android.downloadlib.h.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    public long f48374a;
    public long bl;

    /* renamed from: h  reason: collision with root package name */
    public String f48375h;
    public String kf;

    /* renamed from: n  reason: collision with root package name */
    public String f48376n;
    public long ok;

    /* renamed from: p  reason: collision with root package name */
    public volatile long f48377p;

    /* renamed from: s  reason: collision with root package name */
    public String f48378s;

    public ok() {
    }

    public JSONObject ok() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.ok);
            jSONObject.put("mAdId", this.f48374a);
            jSONObject.put("mExtValue", this.bl);
            jSONObject.put("mPackageName", this.f48378s);
            jSONObject.put("mAppName", this.f48376n);
            jSONObject.put("mLogExtra", this.kf);
            jSONObject.put("mFileName", this.f48375h);
            jSONObject.put("mTimeStamp", this.f48377p);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public ok(long j4, long j5, long j6, String str, String str2, String str3, String str4) {
        this.ok = j4;
        this.f48374a = j5;
        this.bl = j6;
        this.f48378s = str;
        this.f48376n = str2;
        this.kf = str3;
        this.f48375h = str4;
    }

    public static ok ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ok okVar = new ok();
        try {
            okVar.ok = j.ok(jSONObject, "mDownloadId");
            okVar.f48374a = j.ok(jSONObject, "mAdId");
            okVar.bl = j.ok(jSONObject, "mExtValue");
            okVar.f48378s = jSONObject.optString("mPackageName");
            okVar.f48376n = jSONObject.optString("mAppName");
            okVar.kf = jSONObject.optString("mLogExtra");
            okVar.f48375h = jSONObject.optString("mFileName");
            okVar.f48377p = j.ok(jSONObject, "mTimeStamp");
            return okVar;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
