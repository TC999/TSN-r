package com.beizi.p051ad.internal.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.AdFetcher;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.activity.BeiZiInterstitialActivity;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.p057a.MediationDisplayable;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.clj.fastble.BleManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.beizi.ad.internal.view.InterstitialAdViewImpl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InterstitialAdViewImpl extends AdViewImpl {
    public static final String INTENT_KEY_CLOSE_BUTTON_DELAY = "CLOSE_BUTTON_DELAY";
    public static final String INTENT_KEY_TIME = "TIME";
    public static InterstitialAdViewImpl INTERSTITIALADVIEW_TO_USE = null;
    public static final long MAX_AGE = 270000;

    /* renamed from: m */
    protected boolean f10713m;

    /* renamed from: n */
    protected boolean f10714n;

    /* renamed from: o */
    private int f10715o;

    /* renamed from: p */
    private int f10716p;

    /* renamed from: q */
    private boolean f10717q;

    /* renamed from: r */
    private Queue<InterstitialAdQueueEntry> f10718r;

    /* renamed from: s */
    private AdActivity.InterfaceC2741a f10719s;

    /* renamed from: t */
    private AdSpacesBean.BuyerBean f10720t;

    public InterstitialAdViewImpl(Context context, boolean z, boolean z2) {
        super(context);
        this.f10715o = 0;
        this.f10716p = BleManager.f22896l;
        this.f10718r = new LinkedList();
        this.f10719s = null;
        this.f10713m = false;
        this.f10714n = false;
        this.f10521j = z;
        this.f10522k = z2;
        if (z) {
            this.f10715o = ViewCompat.MEASURED_STATE_MASK;
        } else if (z2) {
            this.f10715o = 0;
        } else {
            this.f10715o = Color.argb(51, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    public void mo49153a(Context context, AttributeSet attributeSet) {
        super.mo49153a(context, attributeSet);
        this.mAdFetcher.m49538a(-1);
        this.f10519h.m49517a(EnumC2888k.INTERSTITIAL);
        try {
            View view = (View) getParent();
            if (view != null) {
                int measuredHeight = view.getMeasuredHeight();
                int measuredHeight2 = view.getMeasuredHeight();
                BeiZiImpl m49492a = BeiZiImpl.m49492a();
                this.f10519h.m49507d((int) ((measuredHeight2 / m49492a.m49470h()) + 0.5f));
                this.f10519h.m49505e((int) ((measuredHeight / m49492a.m49469i()) + 0.5f));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnDestroy() {
        this.f10713m = true;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnPause() {
        this.f10714n = true;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnResume() {
        this.f10714n = false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: b */
    protected void mo49150b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2750R.styleable.AdView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        HaoboLog.m49286v(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.found_n_in_xml, indexCount));
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C2750R.styleable.AdView_beizi_adUnitId) {
                setAdUnitId(obtainStyledAttributes.getString(index));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.placement_id, obtainStyledAttributes.getString(index)));
            } else if (index == C2750R.styleable.AdView_test) {
                BeiZiImpl.m49492a().f10136c = obtainStyledAttributes.getBoolean(index, false);
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_test, BeiZiImpl.m49492a().f10136c));
            } else if (index == C2750R.styleable.AdView_opens_native_browser) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_opens_native_browser));
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == C2750R.styleable.AdView_show_loading_indicator) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.show_loading_indicator_xml));
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == C2750R.styleable.AdView_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_load_landing_page_in_background, this.f10518g));
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void cancel() {
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
        INTERSTITIALADVIEW_TO_USE = null;
        this.f10718r.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: d */
    public boolean mo49148d() {
        return false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void destroy() {
        super.destroy();
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.destroy_int));
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
        this.f10718r.clear();
        INTERSTITIALADVIEW_TO_USE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: e */
    public boolean mo49147e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: f */
    public void mo49146f() {
        AdActivity.InterfaceC2741a interfaceC2741a = this.f10719s;
        if (interfaceC2741a != null) {
            interfaceC2741a.mo49653d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m49145g() {
        AdActivity.InterfaceC2741a interfaceC2741a = this.f10719s;
        if (interfaceC2741a != null) {
            interfaceC2741a.mo49652e();
        }
    }

    public AdSpacesBean.BuyerBean getAdBuyerBean() {
        return this.f10720t;
    }

    public AdActivity.InterfaceC2741a getAdImplementation() {
        return this.f10719s;
    }

    public Queue<InterstitialAdQueueEntry> getAdQueue() {
        return this.f10718r;
    }

    public int getBackgroundColor() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_bg));
        return this.f10715o;
    }

    public int getCloseButtonDelay() {
        return this.f10716p;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public int getCreativeHeight() {
        return -1;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public int getCreativeWidth() {
        return -1;
    }

    @Override // com.beizi.p051ad.internal.Ad
    public EnumC2888k getMediaType() {
        return EnumC2888k.INTERSTITIAL;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public boolean loadAd(AdRequestImpl.C2918a c2918a) {
        AdFetcher adFetcher;
        getAdParameters().m49515a(false);
        this.f10520i = c2918a;
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.load_ad_int));
        if (isReadyToStart() && (adFetcher = this.mAdFetcher) != null) {
            adFetcher.m49539a();
            this.mAdFetcher.m49534b();
            this.loadCount = 1;
            this.clickCount = 0;
            return true;
        }
        return false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onDestoryLifeCycle() {
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, com.beizi.p051ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    public void setAdBuyerBean(AdSpacesBean.BuyerBean buyerBean) {
        this.f10720t = buyerBean;
    }

    public void setAdImplementation(AdActivity.InterfaceC2741a interfaceC2741a) {
        this.f10719s = interfaceC2741a;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_bg));
        this.f10715o = i;
    }

    public void setCloseButtonDelay(int i) {
        this.f10716p = Math.min(i, (int) BleManager.f22896l);
    }

    public void setDismissOnClick(boolean z) {
        this.f10717q = z;
    }

    public boolean shouldDismissOnClick() {
        return this.f10717q;
    }

    public int show() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.show_int));
        long currentTimeMillis = System.currentTimeMillis();
        boolean m49154a = m49154a(currentTimeMillis);
        InterstitialAdQueueEntry peek = this.f10718r.peek();
        if (peek != null && peek.mo49126b() && peek.mo49125c() != null) {
            peek.mo49125c().mo49751c();
            this.f10718r.poll();
            return this.f10718r.size();
        } else if (m49154a && !this.f10713m) {
            Class m50215a = AdActivity.m50215a();
            Intent intent = new Intent(getContext(), m50215a);
            intent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
            intent.putExtra(INTENT_KEY_TIME, currentTimeMillis);
            intent.putExtra(INTENT_KEY_CLOSE_BUTTON_DELAY, this.f10716p);
            INTERSTITIALADVIEW_TO_USE = this;
            try {
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                INTERSTITIALADVIEW_TO_USE = null;
                HaoboLog.m49290e(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
            }
            return this.f10718r.size() - 1;
        } else {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.empty_queue));
            return this.f10718r.size();
        }
    }

    public void showInterstitial(Context context) {
        LogUtil.m49044c("BeiZisAd", "showInterstitial");
        INTERSTITIALADVIEW_TO_USE = this;
        context.startActivity(new Intent(context, BeiZiInterstitialActivity.class));
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10715o = 0;
        this.f10716p = BleManager.f22896l;
        this.f10718r = new LinkedList();
        this.f10719s = null;
        this.f10713m = false;
        this.f10714n = false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    protected void mo49151a(Displayable displayable) {
        if (m49149b(displayable)) {
            Displayable displayable2 = this.f10514c;
            if (displayable2 != null) {
                displayable2.destroy();
            }
            if (!this.f10713m && !this.f10714n) {
                this.f10514c = displayable;
                this.f10718r.add(new DisplayableInterstitialAdQueueEntry(displayable, Long.valueOf(System.currentTimeMillis()), false, null));
            } else if (displayable != null) {
                displayable.destroy();
            }
        }
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10715o = 0;
        this.f10716p = BleManager.f22896l;
        this.f10718r = new LinkedList();
        this.f10719s = null;
        this.f10713m = false;
        this.f10714n = false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    protected void mo49152a(MediationDisplayable mediationDisplayable) {
        if (m49149b(mediationDisplayable)) {
            Displayable displayable = this.f10514c;
            if (displayable != null) {
                displayable.destroy();
            }
            if (!this.f10713m && !this.f10714n) {
                this.f10514c = mediationDisplayable;
                this.f10718r.add(new DisplayableInterstitialAdQueueEntry(mediationDisplayable, Long.valueOf(System.currentTimeMillis()), true, mediationDisplayable.m49757a()));
            } else if (mediationDisplayable != null) {
                mediationDisplayable.destroy();
            }
        }
    }

    /* renamed from: a */
    private boolean m49154a(long j) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (InterstitialAdQueueEntry interstitialAdQueueEntry : this.f10718r) {
            if (interstitialAdQueueEntry != null && j - interstitialAdQueueEntry.mo49127a() <= MAX_AGE && j - interstitialAdQueueEntry.mo49127a() >= 0 && (!interstitialAdQueueEntry.mo49126b() || !interstitialAdQueueEntry.mo49125c().m49766d())) {
                z = true;
                break;
            }
            arrayList.add(interstitialAdQueueEntry);
        }
        z = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f10718r.remove((InterstitialAdQueueEntry) it.next());
        }
        return z;
    }

    /* renamed from: b */
    private boolean m49149b(Displayable displayable) {
        if (displayable == null || displayable.failed()) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, "Loaded an ad with an invalid displayable");
            return false;
        }
        return true;
    }
}
