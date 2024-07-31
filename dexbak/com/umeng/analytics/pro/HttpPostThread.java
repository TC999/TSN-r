package com.umeng.analytics.pro;

import com.umeng.ccg.Dispatch;
import com.umeng.ccg.Monitor;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.ao */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpPostThread implements Runnable {

    /* renamed from: a */
    public static final String f37650a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b */
    private String f37651b;

    /* renamed from: c */
    private String f37652c;

    /* renamed from: d */
    private String f37653d;

    public HttpPostThread(String str, JSONObject jSONObject, String str2) {
        this.f37651b = str;
        this.f37652c = jSONObject.toString();
        this.f37653d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] m14718a = HttpManager.m14718a(this.f37651b, this.f37652c);
            if (m14718a != null) {
                JSONObject jSONObject2 = new JSONObject(new String(m14718a));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f37653d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        Dispatch.m14099a(UMGlobalContext.getAppContext(), 102, Monitor.m14095a(), jSONObject);
    }
}
