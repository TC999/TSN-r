package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: HttpPostThread.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52542a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b  reason: collision with root package name */
    private String f52543b;

    /* renamed from: c  reason: collision with root package name */
    private String f52544c;

    /* renamed from: d  reason: collision with root package name */
    private String f52545d;

    public ao(String str, JSONObject jSONObject, String str2) {
        this.f52543b = str;
        this.f52544c = jSONObject.toString();
        this.f52545d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] a4 = am.a(this.f52543b, this.f52544c);
            if (a4 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a4));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f52545d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
