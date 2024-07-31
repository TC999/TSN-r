package com.beizi.p051ad.internal.view;

import android.view.View;
import com.beizi.p051ad.internal.p057a.MediationAdViewController;

/* renamed from: com.beizi.ad.internal.view.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DisplayableInterstitialAdQueueEntry implements InterstitialAdQueueEntry {

    /* renamed from: a */
    private long f10722a;

    /* renamed from: b */
    private Displayable f10723b;

    /* renamed from: c */
    private boolean f10724c;

    /* renamed from: d */
    private MediationAdViewController f10725d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisplayableInterstitialAdQueueEntry(Displayable displayable, Long l, boolean z, MediationAdViewController mediationAdViewController) {
        this.f10722a = l.longValue();
        this.f10723b = displayable;
        this.f10724c = z;
        this.f10725d = mediationAdViewController;
    }

    @Override // com.beizi.p051ad.internal.view.InterstitialAdQueueEntry
    /* renamed from: a */
    public long mo49127a() {
        return this.f10722a;
    }

    @Override // com.beizi.p051ad.internal.view.InterstitialAdQueueEntry
    /* renamed from: b */
    public boolean mo49126b() {
        return this.f10724c;
    }

    @Override // com.beizi.p051ad.internal.view.InterstitialAdQueueEntry
    /* renamed from: c */
    public MediationAdViewController mo49125c() {
        return this.f10725d;
    }

    @Override // com.beizi.p051ad.internal.view.InterstitialAdQueueEntry
    /* renamed from: d */
    public View mo49124d() {
        Displayable displayable = this.f10723b;
        if (displayable == null) {
            return null;
        }
        return displayable.getView();
    }
}
