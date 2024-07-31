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
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.widget.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9371c extends View implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: UI */
    private View f29461UI;

    /* renamed from: UJ */
    private final AtomicBoolean f29462UJ;
    private final int abA;
    private boolean abe;
    private boolean abf;
    private InterfaceC9372a aby;
    private boolean abz;

    /* renamed from: hh */
    private final HandlerC11068br f29463hh;

    /* renamed from: com.kwad.components.core.widget.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9372a {
        /* renamed from: eq */
        void mo28875eq();
    }

    public C9371c(Context context, View view) {
        super(context);
        this.f29463hh = new HandlerC11068br(this);
        this.f29462UJ = new AtomicBoolean(true);
        this.abA = (int) (C10251d.m26543Cl() * 100.0f);
        this.f29461UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    /* renamed from: tg */
    private void m28879tg() {
        if (this.abf) {
            this.f29463hh.removeCallbacksAndMessages(null);
            this.abf = false;
        }
    }

    /* renamed from: th */
    private void m28878th() {
        if (!this.abz || this.abf) {
            return;
        }
        this.abf = true;
        this.f29463hh.sendEmptyMessage(1);
    }

    /* renamed from: tl */
    private void m28877tl() {
        this.f29462UJ.getAndSet(false);
    }

    /* renamed from: tm */
    private void m28876tm() {
        this.f29462UJ.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        InterfaceC9372a interfaceC9372a;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!C11067bq.m23853a(this.f29461UI, this.abA, false)) {
                if (this.abe) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC9372a = this.aby) != null) {
                interfaceC9372a.mo28875eq();
            }
            this.f29463hh.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        C10331c.m26254d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.abf) {
            if (C11067bq.m23853a(this.f29461UI, this.abA, false)) {
                m28879tg();
                Message obtainMessage = this.f29463hh.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f29463hh.sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            this.f29463hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10331c.m26254d("EmptyView", "onAttachedToWindow:" + this);
        m28878th();
        this.abe = false;
        m28877tl();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C10331c.m26254d("EmptyView", "onDetachedFromWindow" + this);
        m28879tg();
        this.abe = true;
        m28876tm();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C10331c.m26254d("EmptyView", "onFinishTemporaryDetach:" + this.f29461UI.getParent());
        m28877tl();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        C10331c.m26254d("EmptyView", "onStartTemporaryDetach:" + this.f29461UI.getParent());
        m28876tm();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        C10331c.m26254d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        C10331c.m26254d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.abz = z;
        if (!z && this.abf) {
            m28879tg();
        } else if (!z || this.abf) {
        } else {
            m28878th();
        }
    }

    public final void setViewCallback(InterfaceC9372a interfaceC9372a) {
        this.aby = interfaceC9372a;
    }
}
