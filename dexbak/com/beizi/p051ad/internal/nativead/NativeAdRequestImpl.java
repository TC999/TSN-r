package com.beizi.p051ad.internal.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdListener;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.Ad;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdFetcher;
import com.beizi.p051ad.internal.AdParameters;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.utilities.DeviceInfoUtil;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.ImageService;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.UserEnvInfoUtil;
import com.stub.StubApp;

/* renamed from: com.beizi.ad.internal.nativead.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeAdRequestImpl extends AdRequestImpl implements Ad {

    /* renamed from: a */
    public AdFetcher f10291a;

    /* renamed from: c */
    private NativeAdListener f10292c;

    /* renamed from: d */
    private C2912a f10293d;

    /* renamed from: e */
    private boolean f10294e;

    /* renamed from: f */
    private boolean f10295f;

    /* renamed from: g */
    private AdParameters f10296g;

    /* renamed from: h */
    private String f10297h;

    /* renamed from: i */
    private String f10298i;

    /* renamed from: j */
    private String f10299j;

    /* renamed from: k */
    private boolean f10300k = false;

    public NativeAdRequestImpl(Context context, String str, int i) {
        this.f10296g = null;
        DeviceInfoUtil.retrieveDeviceInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        UserEnvInfoUtil.retrieveUserEnvInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        AdParameters adParameters = new AdParameters(context, StringUtil.createRequestId());
        this.f10296g = adParameters;
        adParameters.m49516a(str);
        this.f10296g.m49518a(i);
        this.f10296g.m49517a(EnumC2888k.NATIVE);
        AdFetcher adFetcher = new AdFetcher(this);
        this.f10291a = adFetcher;
        adFetcher.m49538a(-1);
        this.f10293d = new C2912a();
    }

    /* renamed from: d */
    public String m49382d() {
        return this.f10297h;
    }

    /* renamed from: e */
    public String m49379e() {
        return this.f10298i;
    }

    /* renamed from: f */
    public NativeAdListener m49378f() {
        return this.f10292c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public AdParameters m49377g() {
        return this.f10296g;
    }

    @Override // com.beizi.p051ad.internal.Ad
    public EnumC2888k getMediaType() {
        return this.f10296g.m49501i();
    }

    /* renamed from: h */
    public AdDispatcher m49376h() {
        return this.f10293d;
    }

    /* renamed from: i */
    public String m49375i() {
        return this.f10299j;
    }

    @Override // com.beizi.p051ad.internal.Ad
    public boolean isReadyToStart() {
        return this.f10292c != null && this.f10296g.m49500j();
    }

    /* renamed from: b */
    public boolean m49390b() {
        AdParameters adParameters = this.f10296g;
        if (adParameters != null) {
            return adParameters.m49498l();
        }
        return true;
    }

    /* renamed from: c */
    public String m49386c() {
        HaoboLog.m49292d(HaoboLog.nativeLogTag, HaoboLog.getString(C2750R.C2755string.get_placement_id, this.f10296g.m49511c()));
        return this.f10296g.m49511c();
    }

    /* renamed from: d */
    public void m49380d(boolean z) {
        this.f10295f = z;
    }

    /* renamed from: a */
    public boolean m49397a() {
        HaoboLog.m49292d(HaoboLog.nativeLogTag, HaoboLog.getString(C2750R.C2755string.get_opens_native_browser, this.f10296g.m49502h()));
        return this.f10296g.m49502h();
    }

    /* renamed from: d */
    public void m49381d(String str) {
        this.f10299j = str;
    }

    /* renamed from: b */
    public void m49387b(boolean z) {
        AdParameters adParameters = this.f10296g;
        if (adParameters != null) {
            adParameters.m49509c(z);
        }
    }

    /* renamed from: b */
    public void m49388b(String str) {
        this.f10297h = str;
    }

    /* renamed from: c */
    public void m49384c(String str) {
        this.f10298i = str;
    }

    /* renamed from: a */
    public void m49391a(boolean z) {
        HaoboLog.m49292d(HaoboLog.nativeLogTag, HaoboLog.getString(C2750R.C2755string.set_opens_native_browser, z));
        this.f10296g.m49512b(z);
    }

    /* renamed from: c */
    public void m49383c(boolean z) {
        this.f10294e = z;
    }

    /* renamed from: a */
    public void m49392a(String str) {
        HaoboLog.m49292d(HaoboLog.nativeLogTag, HaoboLog.getString(C2750R.C2755string.set_placement_id, str));
        this.f10296g.m49516a(str);
    }

    /* renamed from: a */
    public void m49396a(NativeAdListener nativeAdListener) {
        this.f10292c = nativeAdListener;
    }

    /* renamed from: a */
    public boolean m49393a(AdRequestImpl.C2918a c2918a) {
        if (this.f10292c == null) {
            HaoboLog.m49290e(HaoboLog.nativeLogTag, "No mNativeAdListener installed for this request, won't load a new ad");
            return false;
        } else if (this.f10300k) {
            HaoboLog.m49290e(HaoboLog.nativeLogTag, "Still loading last nativead ad , won't load a new ad");
            return false;
        } else if (this.f10296g.m49500j()) {
            this.f10291a.m49539a();
            this.f10291a.m49532c();
            this.f10291a.m49534b();
            this.f10300k = true;
            return true;
        } else {
            return false;
        }
    }

    /* compiled from: NativeAdRequestImpl.java */
    /* renamed from: com.beizi.ad.internal.nativead.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2912a implements AdDispatcher, ImageService.ImageServiceListener {

        /* renamed from: a */
        ImageService f10301a;

        /* renamed from: b */
        NativeAdResponse f10302b;

        private C2912a() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49222a() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49220a(long j) {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49219a(AdResponse adResponse) {
            if (!adResponse.mo49313a().equals(EnumC2888k.NATIVE)) {
                mo49221a(0);
                return;
            }
            final NativeAdResponse mo49310d = adResponse.mo49310d();
            if (mo49310d == null) {
                return;
            }
            NativeAdRequestImpl.this.m49388b(adResponse.mo49308f());
            NativeAdRequestImpl.this.m49384c(adResponse.mo49307g());
            NativeAdRequestImpl.this.m49381d(mo49310d.getLandingPageUrl());
            if (!NativeAdRequestImpl.this.f10294e && !NativeAdRequestImpl.this.f10295f) {
                if (NativeAdRequestImpl.this.f10292c != null) {
                    NativeAdRequestImpl.this.f10292c.onAdLoaded(mo49310d);
                } else {
                    mo49310d.destroy();
                }
                NativeAdRequestImpl.this.f10300k = false;
                return;
            }
            this.f10301a = new ImageService();
            this.f10302b = mo49310d;
            if (NativeAdRequestImpl.this.f10294e) {
                this.f10301a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.beizi.ad.internal.nativead.b.a.1
                    @Override // com.beizi.p051ad.internal.utilities.ImageService.ImageReceiver
                    public void onFail() {
                        String str = HaoboLog.httpRespLogTag;
                        HaoboLog.m49290e(str, "Image downloading logFailed for url " + mo49310d.getImageUrl());
                    }

                    @Override // com.beizi.p051ad.internal.utilities.ImageService.ImageReceiver
                    public void onReceiveImage(Bitmap bitmap) {
                        mo49310d.setImage(bitmap);
                    }
                }, mo49310d.getImageUrl());
            }
            if (NativeAdRequestImpl.this.f10295f) {
                this.f10301a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.beizi.ad.internal.nativead.b.a.2
                    @Override // com.beizi.p051ad.internal.utilities.ImageService.ImageReceiver
                    public void onFail() {
                        String str = HaoboLog.httpRespLogTag;
                        HaoboLog.m49290e(str, "Image downloading logFailed for url " + mo49310d.getIconUrl());
                    }

                    @Override // com.beizi.p051ad.internal.utilities.ImageService.ImageReceiver
                    public void onReceiveImage(Bitmap bitmap) {
                        mo49310d.setIcon(bitmap);
                    }
                }, mo49310d.getIconUrl());
            }
            this.f10301a.registerNotification(this);
            this.f10301a.execute();
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49217a(String str) {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49216a(String str, int i) {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49215a(String str, String str2) {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: b */
        public void mo49214b() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: c */
        public void mo49213c() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: d */
        public void mo49212d() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: e */
        public void mo49211e() {
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: f */
        public void mo49210f() {
        }

        @Override // com.beizi.p051ad.internal.utilities.ImageService.ImageServiceListener
        public void onAllImageDownloadsFinish() {
            if (NativeAdRequestImpl.this.f10292c != null) {
                NativeAdRequestImpl.this.f10292c.onAdLoaded(this.f10302b);
            } else {
                this.f10302b.destroy();
            }
            this.f10301a = null;
            this.f10302b = null;
            NativeAdRequestImpl.this.f10300k = false;
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49221a(int i) {
            if (NativeAdRequestImpl.this.f10292c != null) {
                NativeAdRequestImpl.this.f10292c.onAdFailed(i);
            }
            NativeAdRequestImpl.this.f10300k = false;
        }
    }
}
