package com.iab.omid.library.mmadbridge.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.walking.C7119b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.walking.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7130d implements C7119b.AbstractAsyncTaskC7122c.InterfaceC7124b {

    /* renamed from: a */
    private JSONObject f24320a;

    /* renamed from: b */
    private final C7119b.C7125d f24321b;

    public C7130d(C7119b.C7125d c7125d) {
        this.f24321b = c7125d;
    }

    /* renamed from: a */
    public void m34570a() {
        this.f24321b.m34577c(new C7119b.AsyncTaskC7126e(this));
    }

    @Override // com.iab.omid.library.mmadbridge.walking.C7119b.AbstractAsyncTaskC7122c.InterfaceC7124b
    @VisibleForTesting
    /* renamed from: a */
    public void mo34569a(JSONObject jSONObject) {
        this.f24320a = jSONObject;
    }

    @Override // com.iab.omid.library.mmadbridge.walking.C7119b.AbstractAsyncTaskC7122c.InterfaceC7124b
    @VisibleForTesting
    /* renamed from: b */
    public JSONObject mo34568b() {
        return this.f24320a;
    }

    /* renamed from: b */
    public void m34567b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f24321b.m34577c(new C7119b.AsyncTaskC7128g(this, hashSet, jSONObject, j));
    }

    /* renamed from: c */
    public void m34566c(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f24321b.m34577c(new C7119b.AsyncTaskC7127f(this, hashSet, jSONObject, j));
    }
}
