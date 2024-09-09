package com.beizi.ad.internal.view;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DisplayableInterstitialAdQueueEntry.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private long f14287a;

    /* renamed from: b  reason: collision with root package name */
    private c f14288b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14289c;

    /* renamed from: d  reason: collision with root package name */
    private com.beizi.ad.internal.a.b f14290d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Long l4, boolean z3, com.beizi.ad.internal.a.b bVar) {
        this.f14287a = l4.longValue();
        this.f14288b = cVar;
        this.f14289c = z3;
        this.f14290d = bVar;
    }

    @Override // com.beizi.ad.internal.view.e
    public long a() {
        return this.f14287a;
    }

    @Override // com.beizi.ad.internal.view.e
    public boolean b() {
        return this.f14289c;
    }

    @Override // com.beizi.ad.internal.view.e
    public com.beizi.ad.internal.a.b c() {
        return this.f14290d;
    }

    @Override // com.beizi.ad.internal.view.e
    public View d() {
        c cVar = this.f14288b;
        if (cVar == null) {
            return null;
        }
        return cVar.getView();
    }
}
