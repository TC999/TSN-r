package com.acse.ottn.animator.p031a;

import com.acse.ottn.animator.p031a.C1339e;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1338d extends AbstractC1337c {

    /* renamed from: a */
    boolean f2349a = false;

    /* renamed from: b */
    final /* synthetic */ ArrayList f2350b;

    /* renamed from: c */
    final /* synthetic */ C1339e f2351c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1338d(C1339e c1339e, ArrayList arrayList) {
        this.f2351c = c1339e;
        this.f2350b = arrayList;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1337c, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: a */
    public void mo56852a(AbstractC1334a abstractC1334a) {
        if (this.f2349a) {
            return;
        }
        int size = this.f2350b.size();
        for (int i = 0; i < size; i++) {
            C1339e.C1344e c1344e = (C1339e.C1344e) this.f2350b.get(i);
            c1344e.f2374a.mo57038j();
            this.f2351c.f2352b.add(c1344e.f2374a);
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1337c, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: c */
    public void mo56855c(AbstractC1334a abstractC1334a) {
        this.f2349a = true;
    }
}
