package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: HttpPostDataThread.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52539a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b  reason: collision with root package name */
    private String f52540b;

    /* renamed from: c  reason: collision with root package name */
    private String f52541c;

    public an(String str, JSONObject jSONObject) {
        this.f52540b = str;
        this.f52541c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f52541c)) {
                return;
            }
            am.b(this.f52540b, this.f52541c.getBytes());
        } catch (Throwable unused) {
        }
    }
}
