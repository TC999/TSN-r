package cn.jiguang.bp;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f2814c;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, b> f2815a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f2816b = new ConcurrentHashMap();

    public static c a() {
        if (f2814c == null) {
            synchronized (c.class) {
                if (f2814c == null) {
                    f2814c = new c();
                }
            }
        }
        return f2814c;
    }

    public void a(Context context, boolean z3, String str, JSONObject jSONObject) {
        b bVar = this.f2815a.get(str);
        if (bVar != null) {
            String str2 = this.f2816b.get(str);
            this.f2815a.remove(str);
            this.f2816b.remove(str);
            bVar.a(true, SystemClock.elapsedRealtime());
            long a4 = bVar.a();
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Throwable unused) {
                    return;
                }
            }
            jSONObject.put("jg_duration", a4);
            Bundle bundle = new Bundle();
            bundle.putString("event_id", str2);
            bundle.putString("event_property", jSONObject.toString());
            if (!z3) {
                cn.jiguang.bm.i.c(context, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("jg_duration");
            cn.jiguang.bm.i.a(context, bundle, hashSet);
        }
    }

    public void a(String str) {
        b bVar = this.f2815a.get(str);
        if (bVar != null) {
            bVar.a(true, SystemClock.elapsedRealtime());
        }
    }

    public void a(String str, String str2) {
        b bVar = new b(SystemClock.elapsedRealtime());
        this.f2816b.put(str2, str);
        this.f2815a.put(str2, bVar);
    }

    public void b() {
        this.f2815a.clear();
    }

    public void b(String str) {
        b bVar = this.f2815a.get(str);
        if (bVar != null) {
            bVar.a(false, SystemClock.elapsedRealtime());
        }
    }

    public void c(String str) {
        this.f2815a.remove(str);
    }
}
