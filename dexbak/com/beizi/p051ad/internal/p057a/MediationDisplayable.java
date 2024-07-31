package com.beizi.p051ad.internal.p057a;

import android.view.View;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.view.Displayable;

/* renamed from: com.beizi.ad.internal.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediationDisplayable implements Displayable {

    /* renamed from: a */
    private View f9853a;

    /* renamed from: b */
    private MediationAdViewController f9854b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediationDisplayable(MediationAdViewController mediationAdViewController) {
        this.f9854b = mediationAdViewController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49756a(View view) {
        this.f9853a = view;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void destroy() {
        this.f9854b.m49768b();
        ViewUtil.removeChildFromParent(this.f9853a);
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public boolean failed() {
        return this.f9854b.f9835g;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeHeight() {
        View view = this.f9853a;
        if (view != null) {
            return view.getHeight();
        }
        return -1;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeWidth() {
        View view = this.f9853a;
        if (view != null) {
            return view.getWidth();
        }
        return -1;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getRefreshInterval() {
        return 0;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public View getView() {
        return this.f9853a;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onDestroy() {
        this.f9854b.mo49750i();
        destroy();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onPause() {
        this.f9854b.mo49749j();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onResume() {
        this.f9854b.mo49748k();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void visible() {
    }

    /* renamed from: a */
    public MediationAdViewController m49757a() {
        return this.f9854b;
    }
}
