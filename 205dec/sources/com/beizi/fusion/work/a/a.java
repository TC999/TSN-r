package com.beizi.fusion.work.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.f;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaiduBannerAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15393n;

    /* renamed from: o  reason: collision with root package name */
    private String f15394o;

    /* renamed from: p  reason: collision with root package name */
    private long f15395p;

    /* renamed from: q  reason: collision with root package name */
    private long f15396q;

    /* renamed from: r  reason: collision with root package name */
    private float f15397r;

    /* renamed from: s  reason: collision with root package name */
    private float f15398s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f15399t;

    /* renamed from: u  reason: collision with root package name */
    private AdView f15400u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15401v;

    public a(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar, float f4, float f5, ViewGroup viewGroup) {
        this.f15393n = context;
        this.f15394o = str;
        this.f15395p = j4;
        this.f15396q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15397r = f4;
        this.f15398s = f5;
        this.f15399t = viewGroup;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        ViewGroup viewGroup;
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " BannerAdWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15400u != null && (viewGroup = this.f15399t) != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f15399t.removeAllViews();
                }
                this.f15401v = true;
                this.f15399t.addView(this.f15400u, aH());
                this.f15367d.a(g(), (View) null);
                return;
            }
            this.f15367d.a(10140);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private ViewGroup.LayoutParams aH() {
        if (this.f15397r <= 0.0f) {
            this.f15397r = aw.j(this.f15393n);
        }
        if (this.f15398s <= 0.0f) {
            this.f15398s = Math.round(this.f15397r / 6.4f);
        }
        this.f15398s = (this.f15397r * 3.0f) / 20.0f;
        return new RelativeLayout.LayoutParams(aw.a(this.f15393n, this.f15397r), aw.a(this.f15393n, this.f15398s));
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
    }

    public String b() {
        return AMPSConstants.ChannelName.CHANNEL_NAME_BD;
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BAIDU";
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                u();
                this.f15365b.v(String.valueOf(AdSettings.getSDKVersion()));
                au();
                f.a(this.f15393n, this.f15371h);
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15396q);
        long j4 = this.f15396q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        ViewGroup viewGroup;
        Log.d("BeiZis", "showBaiduBanner showAd()");
        if (this.f15400u != null && (viewGroup = this.f15399t) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15399t.removeAllViews();
            }
            this.f15401v = true;
            this.f15399t.addView(this.f15400u, aH());
            return;
        }
        aw();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        this.f15401v = false;
        AdView adView = new AdView(this.f15393n, this.f15372i);
        this.f15400u = adView;
        adView.setListener(new AdViewListener() { // from class: com.beizi.fusion.work.a.a.2

            /* renamed from: a  reason: collision with root package name */
            boolean f15403a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15404b = false;

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdClick(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdClick()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                }
                if (this.f15404b) {
                    return;
                }
                this.f15404b = true;
                a.this.E();
                a.this.ai();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdClose(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdClose()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.c(a.this.b());
                }
                a.this.G();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdFailed: " + str);
                a.this.a(str, 3793);
                if (a.this.f15401v) {
                    return;
                }
                a.this.m();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdReady(AdView adView2) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdReady()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                a.this.y();
                if (!a.this.Y()) {
                    a.this.O();
                } else {
                    a.this.aG();
                }
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdShow(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                }
                if (this.f15403a) {
                    return;
                }
                this.f15403a = true;
                a.this.C();
                a.this.D();
                a.this.ah();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdSwitch() {
            }
        });
        ViewGroup viewGroup = this.f15399t;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15399t.removeAllViews();
            }
            this.f15399t.addView(this.f15400u, aH());
        }
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        AdView adView = this.f15400u;
        if (adView != null) {
            adView.destroy();
        }
    }
}
