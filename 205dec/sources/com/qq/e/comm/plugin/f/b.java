package com.qq.e.comm.plugin.f;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.qq.e.comm.plugin.f.a;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static final b f43031d = new b();

    /* renamed from: b  reason: collision with root package name */
    private volatile JSONObject f43033b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f43034c = new AtomicInteger(-1);

    /* renamed from: a  reason: collision with root package name */
    private final c f43032a = new c();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(b.this);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.f.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0816b implements a.b {
        C0816b() {
        }

        @Override // com.qq.e.comm.plugin.f.a.b
        public void a(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("v");
            if (TextUtils.isEmpty(optString) || (optJSONArray = jSONObject.optJSONArray("l")) == null || optJSONArray.length() <= 0) {
                return;
            }
            b.a(b.this, optString, optJSONArray);
        }
    }

    private b() {
    }

    private void a() {
        pro.getVresult(0, 0, this);
    }

    static /* synthetic */ void a(b bVar) {
        pro.getVresult(1, 1, bVar);
    }

    static /* synthetic */ void a(b bVar, String str, JSONArray jSONArray) {
        pro.getVresult(2, 1, bVar, str, jSONArray);
    }

    private void a(String str, JSONArray jSONArray) {
        pro.getVresult(3, 0, this, str, jSONArray);
    }

    private boolean a(PackageManager packageManager, String str) {
        return pro.getZresult(4, 0, this, packageManager, str);
    }

    public static b d() {
        return (b) pro.getobjresult(5, 1, new Object[0]);
    }

    private boolean e() {
        return pro.getZresult(6, 0, this);
    }

    public void b() {
        pro.getVresult(7, 0, this);
    }

    public JSONObject c() {
        return (JSONObject) pro.getobjresult(8, 0, this);
    }

    public void f() {
        pro.getVresult(9, 0, this);
    }
}
