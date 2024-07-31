package com.beizi.p051ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.internal.view.MRAIDImplementation;

/* renamed from: com.beizi.ad.internal.activity.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MRAIDAdActivity implements AdActivity.InterfaceC2741a {

    /* renamed from: a */
    private Activity f9996a;

    /* renamed from: b */
    private AdWebView f9997b;

    /* renamed from: c */
    private MRAIDImplementation f9998c = null;

    public MRAIDAdActivity(Activity activity) {
        this.f9996a = activity;
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: a */
    public void mo49656a() {
        if (AdViewImpl.getMRAIDFullscreenContainer() != null && AdViewImpl.getMRAIDFullscreenImplementation() != null) {
            ViewUtil.removeChildFromParent(AdViewImpl.getMRAIDFullscreenContainer());
            this.f9996a.setContentView(AdViewImpl.getMRAIDFullscreenContainer());
            if (AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0) instanceof AdWebView) {
                this.f9997b = (AdWebView) AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0);
            }
            if (this.f9997b.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f9997b.getContext()).setBaseContext(this.f9996a);
            }
            MRAIDImplementation mRAIDFullscreenImplementation = AdViewImpl.getMRAIDFullscreenImplementation();
            this.f9998c = mRAIDFullscreenImplementation;
            mRAIDFullscreenImplementation.m49120a(this.f9996a);
            if (AdViewImpl.getMRAIDFullscreenListener() != null) {
                AdViewImpl.getMRAIDFullscreenListener().mo49096a();
                return;
            }
            return;
        }
        HaoboLog.m49290e(HaoboLog.baseLogTag, "Launched MRAID Fullscreen activity with invalid properties");
        this.f9996a.finish();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: b */
    public void mo49655b() {
        MRAIDImplementation mRAIDImplementation = this.f9998c;
        if (mRAIDImplementation != null) {
            mRAIDImplementation.m49120a((Activity) null);
            this.f9998c.m49123a();
        }
        this.f9998c = null;
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: c */
    public void mo49654c() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: d */
    public void mo49653d() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: e */
    public void mo49652e() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: f */
    public WebView mo49651f() {
        return this.f9997b;
    }
}
