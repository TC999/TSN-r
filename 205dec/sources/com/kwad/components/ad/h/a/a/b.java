package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int nu = 1;
    public static int nv = 2;
    private com.kwad.sdk.core.webview.c.c nt;
    private int nw;
    private int nx;
    private InterfaceC0566b nz;
    private c ny = new c(this, (byte) 0);
    @Nullable
    private Runnable nA = null;

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int nC;
        public int nD;
    }

    /* renamed from: com.kwad.components.ad.h.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0566b {
        void E(int i4);
    }

    private b(int i4, int i5) {
        this.nw = i4;
        this.nx = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i4) {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "updateTimer: " + i4 + ", mCallBackFunction: " + this.nt);
        if (i4 >= 0 && this.nt != null) {
            InterfaceC0566b interfaceC0566b = this.nz;
            if (interfaceC0566b != null && i4 == 0) {
                interfaceC0566b.E(this.nw);
            }
            a aVar = new a();
            aVar.nD = i4;
            aVar.nC = this.nw;
            com.kwad.sdk.core.webview.c.c cVar = this.nt;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int f(AdInfo adInfo) {
        int b4 = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b4 <= 0) {
            b4 = 60;
        }
        int i4 = adInfo.adInsertScreenInfo.autoCloseTime;
        return i4 > 0 ? Math.min(b4, i4) : b4;
    }

    @Nullable
    public static b z(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (!com.kwad.sdk.core.response.b.a.bb(dS)) {
            if (com.kwad.sdk.core.response.b.a.bI(dS)) {
                return new b(nv, f(dS));
            }
            int i4 = dS.adInsertScreenInfo.autoCloseTime;
            if (i4 > 0) {
                return new b(nu, i4);
            }
            return null;
        }
        return null;
    }

    public final void eG() {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nt);
        if (this.nt == null) {
            this.nA = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.eG();
                }
            };
            return;
        }
        this.ny.J(this.nx);
        bo.runOnUiThread(this.ny);
    }

    public final void eH() {
        this.ny.y(true);
    }

    public final void eI() {
        this.ny.y(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nt = null;
    }

    public final void a(InterfaceC0566b interfaceC0566b) {
        this.nz = interfaceC0566b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c implements Runnable {
        private boolean nE;
        private int nF;

        private c() {
            this.nE = false;
            this.nF = -1;
        }

        public final void J(int i4) {
            this.nF = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nE + ", currentTime: " + this.nF);
            if (this.nE) {
                bo.a(this, null, 1000L);
                return;
            }
            int i4 = this.nF;
            if (i4 < 0) {
                return;
            }
            b.this.I(i4);
            this.nF--;
            bo.a(this, null, 1000L);
        }

        public final void y(boolean z3) {
            this.nE = z3;
        }

        /* synthetic */ c(b bVar, byte b4) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nt = cVar;
        Runnable runnable = this.nA;
        if (runnable != null) {
            runnable.run();
            this.nA = null;
        }
    }
}
