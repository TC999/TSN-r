package com.kwad.components.core.p289e.p290a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p445n.C10887l;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.core.e.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8594h implements InterfaceC8582d {

    /* renamed from: JZ */
    private static WeakReference<Window> f28164JZ;

    /* renamed from: JW */
    private C8592g f28165JW;

    /* renamed from: JX */
    private InterfaceC8580b f28166JX;

    /* renamed from: JY */
    private WeakReference<Activity> f28167JY;

    /* renamed from: nY */
    private ViewGroup f28168nY;

    /* renamed from: nZ */
    private boolean f28169nZ;

    /* renamed from: wT */
    private final InterfaceC10246c<Activity> f28170wT = new AbstractC10247d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityDestroyed */
        public final void mo24589b(Activity activity) {
            super.mo24589b(activity);
            C10232b.m26625DD();
            C10232b.m26621b((InterfaceC10246c) this);
            if (activity.equals((Activity) C8594h.this.f28167JY.get())) {
                C8594h.this.m30290eQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eQ */
    public void m30290eQ() {
        C8592g c8592g;
        if (this.f28169nZ) {
            return;
        }
        this.f28169nZ = true;
        this.f28166JX.mo30302eP();
        ViewGroup viewGroup = this.f28168nY;
        if (viewGroup != null && (c8592g = this.f28165JW) != null) {
            viewGroup.removeView(c8592g);
        }
        C10232b.m26625DD();
        C10232b.m26621b((InterfaceC10246c) this.f28170wT);
    }

    /* renamed from: nm */
    public static void m30288nm() {
        WeakReference<Window> weakReference = f28164JZ;
        if (weakReference != null) {
            weakReference.clear();
        }
        f28164JZ = null;
    }

    @Override // com.kwad.components.core.p289e.p290a.InterfaceC8582d
    /* renamed from: ne */
    public final void mo30289ne() {
        m30290eQ();
    }

    /* renamed from: a */
    public static void m30294a(Window window) {
        f28164JZ = new WeakReference<>(window);
    }

    /* renamed from: b */
    public final boolean m30291b(AdTemplate adTemplate, InterfaceC8580b interfaceC8580b) {
        Window window;
        try {
            this.f28166JX = interfaceC8580b;
            C10232b.m26625DD();
            Activity currentActivity = C10232b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = f28164JZ;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View findViewById = window.getDecorView().findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    this.f28167JY = new WeakReference<>(currentActivity);
                    this.f28165JW = new C8592g(C10887l.wrapContextIfNeed(currentActivity), adTemplate, this);
                    C10232b.m26625DD();
                    C10232b.m26622a(this.f28170wT);
                    this.f28168nY = (ViewGroup) findViewById;
                    this.f28168nY.addView(this.f28165JW, new ViewGroup.LayoutParams(-1, -1));
                    interfaceC8580b.mo30301nd();
                    return true;
                }
                return false;
            }
            C10331c.m26254d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            C10331c.m26254d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            C10331c.printStackTrace(th);
            return false;
        }
    }
}
