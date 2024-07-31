package com.beizi.p051ad.internal.p057a;

import android.app.Activity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdRequestDelegate;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.p055b.MediationAdapter;

/* renamed from: com.beizi.ad.internal.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediationInterstitialAdViewController extends MediationAdViewController {
    private MediationInterstitialAdViewController(Activity activity, AdRequestDelegate adRequestDelegate, MediationAd mediationAd, AdDispatcher adDispatcher, ServerResponse serverResponse) {
        super(adRequestDelegate, mediationAd, adDispatcher, EnumC2888k.INTERSTITIAL, serverResponse);
        if (m49772a(MediationInterstitialAdapter.class)) {
            HaoboLog.m49292d(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_request));
            m49765e();
            m49763g();
            int i = 0;
            try {
                if (activity != null) {
                    ((MediationInterstitialAdapter) this.f9830b).m49753a(this, activity, this.f9831c.m49781b(), this.f9831c.m49778e(), m49775a());
                    i = -1;
                } else {
                    HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_request_null_activity));
                }
            } catch (Error e) {
                HaoboLog.m49289e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_request_error), e);
            } catch (Exception e2) {
                HaoboLog.m49289e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_request_exception), e2);
            }
            if (i != -1) {
                m49774a(i);
            }
        }
    }

    /* renamed from: a */
    public static MediationInterstitialAdViewController m49755a(Activity activity, AdRequestDelegate adRequestDelegate, MediationAd mediationAd, AdDispatcher adDispatcher, ServerResponse serverResponse) {
        MediationInterstitialAdViewController mediationInterstitialAdViewController = new MediationInterstitialAdViewController(activity, adRequestDelegate, mediationAd, adDispatcher, serverResponse);
        if (mediationInterstitialAdViewController.f9835g) {
            return null;
        }
        return mediationInterstitialAdViewController;
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: c */
    public void mo49751c() {
        if (this.f9830b == null || m49766d()) {
            return;
        }
        ((MediationInterstitialAdapter) this.f9830b).m49754a();
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: i */
    public void mo49750i() {
        this.f9837i = true;
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50086e();
        }
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: j */
    public void mo49749j() {
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50088c();
        }
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: k */
    public void mo49748k() {
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50087d();
        }
    }
}
