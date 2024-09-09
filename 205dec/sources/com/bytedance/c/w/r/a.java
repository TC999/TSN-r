package com.bytedance.c.w.r;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.c.w.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f26538b;

    /* renamed from: a  reason: collision with root package name */
    private volatile Context f26539a;

    /* renamed from: com.bytedance.c.w.r.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class RunnableC0373a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f26540a;

        RunnableC0373a(JSONObject jSONObject) {
            this.f26540a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            String f4 = w.f(com.bytedance.c.w.d.a().a());
            try {
                this.f26540a.put("upload_scene", "direct");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            w.c(f4, this.f26540a.toString());
        }
    }

    private a(@NonNull Context context) {
        this.f26539a = context;
    }

    public static a a() {
        if (f26538b == null) {
            f26538b = new a(com.bytedance.c.w.d.i());
        }
        return f26538b;
    }

    @Nullable
    public String b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return b.m.b(b.f.a(this.f26539a), b.f.b(), w.f(com.bytedance.c.w.d.a().a()), jSONObject, w.g());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String f4 = w.f(com.bytedance.c.w.d.a().a());
                String b4 = b.m.b(b.f.a(this.f26539a), b.f.d(), f4, jSONObject, w.k());
                jSONObject.put("upload_scene", "direct");
                if (!w.c(f4, jSONObject.toString()).a()) {
                    return;
                }
                b.m.g(b4);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        b.h.a(new RunnableC0373a(jSONObject));
    }
}
