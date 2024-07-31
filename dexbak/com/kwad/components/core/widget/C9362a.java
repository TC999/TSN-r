package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.HandlerC11068br;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.widget.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9362a extends KSFrameLayout implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: UI */
    private final View f29455UI;
    private InterfaceC9363a abd;
    private boolean abe;
    private boolean abf;
    private int abg;
    private boolean abh;
    private long abi;
    private boolean abj;
    private final float abk;
    private final int abl;

    /* renamed from: hh */
    private final HandlerC11068br f29456hh;

    /* renamed from: com.kwad.components.core.widget.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9363a {
        /* renamed from: ac */
        void mo28883ac();

        /* renamed from: ad */
        void mo28882ad();

        /* renamed from: ep */
        void mo28881ep();

        /* renamed from: k */
        void mo28880k(View view);
    }

    public C9362a(Context context, View view) {
        super(context, view);
        this.f29456hh = new HandlerC11068br(this);
        this.abg = 5;
        this.f29455UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float m26543Cl = C10251d.m26543Cl();
        this.abk = m26543Cl;
        setVisiblePercent(m26543Cl);
        float m26542Cm = C10251d.m26542Cm();
        this.abl = (int) ((m26542Cm < 0.0f ? 1.0f : m26542Cm) * 1000.0f);
    }

    /* renamed from: tf */
    private void m28907tf() {
        InterfaceC9363a interfaceC9363a;
        if (this.abl == 0 && (interfaceC9363a = this.abd) != null) {
            interfaceC9363a.mo28880k(this.f29455UI);
            return;
        }
        Message obtainMessage = this.f29456hh.obtainMessage();
        obtainMessage.what = 2;
        this.f29456hh.sendMessageDelayed(obtainMessage, this.abl);
    }

    /* renamed from: tg */
    private void m28906tg() {
        this.f29456hh.removeCallbacksAndMessages(null);
        this.abf = false;
    }

    /* renamed from: th */
    private void m28905th() {
        if (this.abf) {
            return;
        }
        this.abf = true;
        this.f29456hh.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.InterfaceC11153i
    /* renamed from: A */
    public final void mo23527A(View view) {
        InterfaceC9363a interfaceC9363a;
        InterfaceC9363a interfaceC9363a2;
        super.mo23527A(view);
        if (this.abl == 0 && (interfaceC9363a2 = this.abd) != null) {
            interfaceC9363a2.mo28880k(view);
        } else if (!this.abh) {
            this.abh = true;
            this.abi = System.currentTimeMillis();
            m28906tg();
            m28907tf();
        } else if (System.currentTimeMillis() - this.abi <= this.abl || (interfaceC9363a = this.abd) == null) {
        } else {
            interfaceC9363a.mo28880k(view);
            m28906tg();
        }
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (this.abe) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (C11067bq.m23853a(this.f29455UI, (int) (this.abk * 100.0f), false)) {
                InterfaceC9363a interfaceC9363a = this.abd;
                if (interfaceC9363a != null) {
                    interfaceC9363a.mo28880k(this.f29455UI);
                    return;
                }
                return;
            }
            this.abg = 5;
            this.f29456hh.sendEmptyMessage(1);
            return;
        }
        if (C11067bq.m23853a(this.f29455UI, (int) (this.abk * 100.0f), false)) {
            m28906tg();
            if (this.abh) {
                InterfaceC9363a interfaceC9363a2 = this.abd;
                if (interfaceC9363a2 != null) {
                    interfaceC9363a2.mo28880k(this.f29455UI);
                }
            } else {
                this.abh = true;
                this.abi = System.currentTimeMillis();
                m28907tf();
            }
            this.abj = false;
            HandlerC11068br handlerC11068br = this.f29456hh;
            int i2 = this.abg;
            this.abg = i2 - 1;
            handlerC11068br.sendEmptyMessageDelayed(1, i2 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC9363a interfaceC9363a3 = this.abd;
        if (interfaceC9363a3 != null && !this.abj) {
            interfaceC9363a3.mo28881ep();
        }
        this.abj = true;
        HandlerC11068br handlerC11068br2 = this.f29456hh;
        int i3 = this.abg;
        this.abg = i3 - 1;
        handlerC11068br2.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        this.abg = 5;
        this.abe = false;
        this.abh = false;
        m28905th();
        InterfaceC9363a interfaceC9363a = this.abd;
        if (interfaceC9363a != null) {
            interfaceC9363a.mo28883ac();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        m28906tg();
        this.abg = 0;
        this.abi = 0L;
        this.abe = true;
        InterfaceC9363a interfaceC9363a = this.abd;
        if (interfaceC9363a != null) {
            interfaceC9363a.mo28882ad();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        C10331c.m26254d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    public final void setViewCallback(InterfaceC9363a interfaceC9363a) {
        this.abd = interfaceC9363a;
    }

    /* renamed from: ti */
    public final void m28904ti() {
        m28905th();
    }
}
