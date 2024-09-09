package com.beizi.ad.internal.a;

import android.view.View;
import com.beizi.ad.internal.utilities.ViewUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MediationDisplayable.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e implements com.beizi.ad.internal.view.c {

    /* renamed from: a  reason: collision with root package name */
    private View f13551a;

    /* renamed from: b  reason: collision with root package name */
    private b f13552b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f13552b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        this.f13551a = view;
    }

    @Override // com.beizi.ad.internal.view.c
    public void destroy() {
        this.f13552b.b();
        ViewUtil.removeChildFromParent(this.f13551a);
    }

    @Override // com.beizi.ad.internal.view.c
    public boolean failed() {
        return this.f13552b.f13533g;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeHeight() {
        View view = this.f13551a;
        if (view != null) {
            return view.getHeight();
        }
        return -1;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeWidth() {
        View view = this.f13551a;
        if (view != null) {
            return view.getWidth();
        }
        return -1;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getRefreshInterval() {
        return 0;
    }

    @Override // com.beizi.ad.internal.view.c
    public View getView() {
        return this.f13551a;
    }

    @Override // com.beizi.ad.internal.view.c
    public void onDestroy() {
        this.f13552b.i();
        destroy();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onPause() {
        this.f13552b.j();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onResume() {
        this.f13552b.k();
    }

    @Override // com.beizi.ad.internal.view.c
    public void visible() {
    }

    public b a() {
        return this.f13552b;
    }
}
