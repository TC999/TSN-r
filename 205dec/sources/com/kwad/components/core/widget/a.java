package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends KSFrameLayout implements br.a {
    private final View UI;
    private InterfaceC0661a abd;
    private boolean abe;
    private boolean abf;
    private int abg;
    private boolean abh;
    private long abi;
    private boolean abj;
    private final float abk;
    private final int abl;
    private final br hh;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0661a {
        void ac();

        void ad();

        void ep();

        void k(View view);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [float] */
    public a(Context context, View view) {
        super(context, view);
        this.hh = new br(this);
        this.abg = 5;
        this.UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float Cl = com.kwad.sdk.core.config.d.Cl();
        this.abk = Cl;
        setVisiblePercent(Cl);
        ?? Cm = com.kwad.sdk.core.config.d.Cm();
        this.abl = (int) ((Cm < 0.0f ? 1.0f : Cm) * 1000.0f);
    }

    private void tf() {
        InterfaceC0661a interfaceC0661a;
        if (this.abl == 0 && (interfaceC0661a = this.abd) != null) {
            interfaceC0661a.k(this.UI);
            return;
        }
        Message obtainMessage = this.hh.obtainMessage();
        obtainMessage.what = 2;
        this.hh.sendMessageDelayed(obtainMessage, this.abl);
    }

    private void tg() {
        this.hh.removeCallbacksAndMessages(null);
        this.abf = false;
    }

    private void th() {
        if (this.abf) {
            return;
        }
        this.abf = true;
        this.hh.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view) {
        InterfaceC0661a interfaceC0661a;
        InterfaceC0661a interfaceC0661a2;
        super.A(view);
        if (this.abl == 0 && (interfaceC0661a2 = this.abd) != null) {
            interfaceC0661a2.k(view);
        } else if (!this.abh) {
            this.abh = true;
            this.abi = System.currentTimeMillis();
            tg();
            tf();
        } else if (System.currentTimeMillis() - this.abi <= this.abl || (interfaceC0661a = this.abd) == null) {
        } else {
            interfaceC0661a.k(view);
            tg();
        }
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (this.abe) {
            return;
        }
        int i4 = message.what;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            if (bq.a(this.UI, (int) (this.abk * 100.0f), false)) {
                InterfaceC0661a interfaceC0661a = this.abd;
                if (interfaceC0661a != null) {
                    interfaceC0661a.k(this.UI);
                    return;
                }
                return;
            }
            this.abg = 5;
            this.hh.sendEmptyMessage(1);
            return;
        }
        if (bq.a(this.UI, (int) (this.abk * 100.0f), false)) {
            tg();
            if (this.abh) {
                InterfaceC0661a interfaceC0661a2 = this.abd;
                if (interfaceC0661a2 != null) {
                    interfaceC0661a2.k(this.UI);
                }
            } else {
                this.abh = true;
                this.abi = System.currentTimeMillis();
                tf();
            }
            this.abj = false;
            br brVar = this.hh;
            int i5 = this.abg;
            this.abg = i5 - 1;
            brVar.sendEmptyMessageDelayed(1, i5 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC0661a interfaceC0661a3 = this.abd;
        if (interfaceC0661a3 != null && !this.abj) {
            interfaceC0661a3.ep();
        }
        this.abj = true;
        br brVar2 = this.hh;
        int i6 = this.abg;
        this.abg = i6 - 1;
        brVar2.sendEmptyMessageDelayed(1, i6 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.abg = 5;
        this.abe = false;
        this.abh = false;
        th();
        InterfaceC0661a interfaceC0661a = this.abd;
        if (interfaceC0661a != null) {
            interfaceC0661a.ac();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        tg();
        this.abg = 0;
        this.abi = 0L;
        this.abe = true;
        InterfaceC0661a interfaceC0661a = this.abd;
        if (interfaceC0661a != null) {
            interfaceC0661a.ad();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        com.kwad.sdk.core.e.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z3);
    }

    public final void setViewCallback(InterfaceC0661a interfaceC0661a) {
        this.abd = interfaceC0661a;
    }

    public final void ti() {
        th();
    }
}
