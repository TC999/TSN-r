package com.kwad.components.core.e.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h implements d {
    private static WeakReference<Window> JZ;
    private g JW;
    private b JX;
    private WeakReference<Activity> JY;
    private ViewGroup nY;
    private boolean nZ;
    private final com.kwad.sdk.core.c.c<Activity> wT = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.JY.get())) {
                h.this.eQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        g gVar;
        if (this.nZ) {
            return;
        }
        this.nZ = true;
        this.JX.eP();
        ViewGroup viewGroup = this.nY;
        if (viewGroup != null && (gVar = this.JW) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.wT);
    }

    public static void nm() {
        WeakReference<Window> weakReference = JZ;
        if (weakReference != null) {
            weakReference.clear();
        }
        JZ = null;
    }

    @Override // com.kwad.components.core.e.a.d
    public final void ne() {
        eQ();
    }

    public static void a(Window window) {
        JZ = new WeakReference<>(window);
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.JX = bVar;
            com.kwad.sdk.core.c.b.DD();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = JZ;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View findViewById = window.getDecorView().findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    this.JY = new WeakReference<>(currentActivity);
                    this.JW = new g(l.wrapContextIfNeed(currentActivity), adTemplate, this);
                    com.kwad.sdk.core.c.b.DD();
                    com.kwad.sdk.core.c.b.a(this.wT);
                    this.nY = (ViewGroup) findViewById;
                    this.nY.addView(this.JW, new ViewGroup.LayoutParams(-1, -1));
                    bVar.nd();
                    return true;
                }
                return false;
            }
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }
}
