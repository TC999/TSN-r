package com.acse.ottn.animator.a;

import com.acse.ottn.animator.a.C1365e;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1364d extends AbstractC1363c {

    /* renamed from: a  reason: collision with root package name */
    boolean f4896a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f4897b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1365e f4898c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1364d(C1365e c1365e, ArrayList arrayList) {
        this.f4898c = c1365e;
        this.f4897b = arrayList;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1363c, com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
    public void a(AbstractC1361a abstractC1361a) {
        if (this.f4896a) {
            return;
        }
        int size = this.f4897b.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1365e.C0083e c0083e = (C1365e.C0083e) this.f4897b.get(i4);
            c0083e.f4921a.j();
            this.f4898c.f4899b.add(c0083e.f4921a);
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1363c, com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
    public void c(AbstractC1361a abstractC1361a) {
        this.f4896a = true;
    }
}
