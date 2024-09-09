package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.same.a.b;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReplaceTempDaoMiddle.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private n f39145a;

    /* renamed from: b  reason: collision with root package name */
    private b f39146b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReplaceTempDaoMiddle.java */
    /* renamed from: com.mbridge.msdk.foundation.db.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0739a {

        /* renamed from: a  reason: collision with root package name */
        private static a f39150a = new a();
    }

    private a() {
        this.f39146b = new b(1000);
        try {
            n a4 = n.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            this.f39145a = a4;
            a(a4.a(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static a a() {
        return C0739a.f39150a;
    }

    public final JSONArray b() {
        return new JSONArray((Collection) this.f39146b.a());
    }

    public final JSONObject a(String str) {
        n nVar;
        JSONObject b4 = this.f39146b.b(str);
        if (b4 == null && (nVar = this.f39145a) != null) {
            JSONObject a4 = nVar.a(str);
            if (a4 != null) {
                this.f39146b.a(str, a4);
            }
            return a4;
        }
        return b4;
    }

    public final void a(JSONObject jSONObject, final boolean z3) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            final b bVar = new b(100);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.f39146b.a(next, optJSONObject);
                bVar.a(next, optJSONObject);
            }
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.db.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (!z3 || a.this.f39145a == null) {
                        return;
                    }
                    for (String str : bVar.a()) {
                        a.this.f39145a.a(str, a.this.f39146b.b(str));
                    }
                }
            });
        }
    }
}
