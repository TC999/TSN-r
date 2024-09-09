package com.iab.omid.library.mmadbridge.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.walking.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements b.c.InterfaceC0551b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f37802a;

    /* renamed from: b  reason: collision with root package name */
    private final b.d f37803b;

    public d(b.d dVar) {
        this.f37803b = dVar;
    }

    public void a() {
        this.f37803b.c(new b.e(this));
    }

    @Override // com.iab.omid.library.mmadbridge.walking.b.c.InterfaceC0551b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f37802a = jSONObject;
    }

    @Override // com.iab.omid.library.mmadbridge.walking.b.c.InterfaceC0551b
    @VisibleForTesting
    public JSONObject b() {
        return this.f37802a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j4) {
        this.f37803b.c(new b.g(this, hashSet, jSONObject, j4));
    }

    public void c(JSONObject jSONObject, HashSet<String> hashSet, long j4) {
        this.f37803b.c(new b.f(this, hashSet, jSONObject, j4));
    }
}
