package com.beizi.p051ad.internal.nativead;

import android.util.Log;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.AdParameters;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.RequestManager;
import com.beizi.p051ad.internal.nativead.p061a.MediationNativeAdController;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.p055b.MediationAdRequest;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.beizi.ad.internal.nativead.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeAdRequestManagerImpl extends RequestManager {

    /* renamed from: a */
    private final SoftReference<NativeAdRequestImpl> f10308a;

    /* renamed from: b */
    private MediationNativeAdController f10309b;

    public NativeAdRequestManagerImpl(NativeAdRequestImpl nativeAdRequestImpl) {
        this.f10308a = new SoftReference<>(nativeAdRequestImpl);
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49374a() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl == null) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        m49457g();
        try {
            nativeAdRequestImpl.m49345a(this);
            nativeAdRequestImpl.executeOnExecutor(BeiZiExecutor.m49087b().m49086c(), new Void[0]);
        } catch (IllegalStateException e) {
            Log.d("lance", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: c */
    public AdParameters mo49370c() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl != null) {
            return nativeAdRequestImpl.m49377g();
        }
        return null;
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: d */
    public MediationAdRequest mo49369d() {
        return null;
    }

    @Override // com.beizi.p051ad.internal.RequestManager
    /* renamed from: e */
    public void mo49368e() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl != null) {
            nativeAdRequestImpl.cancel(true);
        }
        m49459a((LinkedList<MediationAd>) null);
        MediationNativeAdController mediationNativeAdController = this.f10309b;
        if (mediationNativeAdController != null) {
            mediationNativeAdController.m49405a(true);
            this.f10309b = null;
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49373a(int i) {
        m49456h();
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl != null) {
            nativeAdRequestImpl.m49376h().mo49221a(i);
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49372a(final ServerResponse serverResponse) {
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl != null) {
            boolean containsAds = serverResponse.containsAds();
            boolean z = (mo49458b() == null || mo49458b().isEmpty()) ? false : true;
            Log.d("lance", containsAds + "=====" + z);
            if (!containsAds && !z) {
                HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_no_ads));
                nativeAdRequestImpl.m49376h().mo49221a(3);
                return;
            }
            if (containsAds) {
                m49459a(serverResponse.getMediationAds());
            }
            if (mo49458b() != null && !mo49458b().isEmpty()) {
                MediationAd m49455i = m49455i();
                if (m49455i != null) {
                    m49455i.m49782a(serverResponse.getExtras());
                }
                this.f10309b = MediationNativeAdController.m49408a(m49455i, this, serverResponse);
                return;
            }
            final BeiZiNativeAdResponse beiZiNativeAdResponse = (BeiZiNativeAdResponse) serverResponse.getNativeAdResponse();
            beiZiNativeAdResponse.m49437a(nativeAdRequestImpl.m49377g().m49519a());
            beiZiNativeAdResponse.m49432a(nativeAdRequestImpl.m49397a());
            beiZiNativeAdResponse.m49424b(nativeAdRequestImpl.m49390b());
            m49371a(new AdResponse() { // from class: com.beizi.ad.internal.nativead.c.1
                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: a */
                public EnumC2888k mo49313a() {
                    return EnumC2888k.NATIVE;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: b */
                public boolean mo49312b() {
                    return false;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: c */
                public Displayable mo49311c() {
                    return null;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: d */
                public NativeAdResponse mo49310d() {
                    return beiZiNativeAdResponse;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: e */
                public String mo49309e() {
                    return "";
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: f */
                public String mo49308f() {
                    return serverResponse.getPrice();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: g */
                public String mo49307g() {
                    return serverResponse.getAdId();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: h */
                public void mo49306h() {
                    beiZiNativeAdResponse.destroy();
                }
            });
        }
    }

    /* renamed from: a */
    public void m49371a(AdResponse adResponse) {
        m49456h();
        if (this.f10309b != null) {
            this.f10309b = null;
        }
        NativeAdRequestImpl nativeAdRequestImpl = this.f10308a.get();
        if (nativeAdRequestImpl != null) {
            nativeAdRequestImpl.m49376h().mo49219a(adResponse);
        } else {
            adResponse.mo49306h();
        }
    }
}
