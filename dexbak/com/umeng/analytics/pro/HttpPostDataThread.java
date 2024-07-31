package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.an */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpPostDataThread implements Runnable {

    /* renamed from: a */
    public static final String f37647a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b */
    private String f37648b;

    /* renamed from: c */
    private String f37649c;

    public HttpPostDataThread(String str, JSONObject jSONObject) {
        this.f37648b = str;
        this.f37649c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f37649c)) {
                return;
            }
            HttpManager.m14715b(this.f37648b, this.f37649c.getBytes());
        } catch (Throwable unused) {
        }
    }
}
