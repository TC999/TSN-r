package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MRAIDAdActivity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c implements AdActivity.a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f13674a;

    /* renamed from: b  reason: collision with root package name */
    private AdWebView f13675b;

    /* renamed from: c  reason: collision with root package name */
    private f f13676c = null;

    public c(Activity activity) {
        this.f13674a = activity;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void a() {
        if (AdViewImpl.getMRAIDFullscreenContainer() != null && AdViewImpl.getMRAIDFullscreenImplementation() != null) {
            ViewUtil.removeChildFromParent(AdViewImpl.getMRAIDFullscreenContainer());
            this.f13674a.setContentView(AdViewImpl.getMRAIDFullscreenContainer());
            if (AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0) instanceof AdWebView) {
                this.f13675b = (AdWebView) AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0);
            }
            if (this.f13675b.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f13675b.getContext()).setBaseContext(this.f13674a);
            }
            f mRAIDFullscreenImplementation = AdViewImpl.getMRAIDFullscreenImplementation();
            this.f13676c = mRAIDFullscreenImplementation;
            mRAIDFullscreenImplementation.a(this.f13674a);
            if (AdViewImpl.getMRAIDFullscreenListener() != null) {
                AdViewImpl.getMRAIDFullscreenListener().a();
                return;
            }
            return;
        }
        HaoboLog.e(HaoboLog.baseLogTag, "Launched MRAID Fullscreen activity with invalid properties");
        this.f13674a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        f fVar = this.f13676c;
        if (fVar != null) {
            fVar.a((Activity) null);
            this.f13676c.a();
        }
        this.f13676c = null;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f13675b;
    }
}
