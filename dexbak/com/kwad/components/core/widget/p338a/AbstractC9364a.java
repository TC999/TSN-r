package com.kwad.components.core.widget.p338a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.p403h.InterfaceC10383a;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11014ah;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.HandlerC11068br;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.core.widget.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9364a implements InterfaceC10383a, HandlerC11068br.InterfaceC11069a {
    private Set<InterfaceC10385c> acv;
    private final int acw;
    private final View mRootView;
    private final AtomicBoolean acu = new AtomicBoolean(false);

    /* renamed from: hh */
    protected final HandlerC11068br f29457hh = new HandlerC11068br(this);

    public AbstractC9364a(@NonNull View view, int i) {
        this.mRootView = view;
        this.acw = i;
    }

    /* renamed from: aZ */
    private void m28903aZ(boolean z) {
        Set<InterfaceC10385c> set = this.acv;
        if (set == null) {
            return;
        }
        for (InterfaceC10385c interfaceC10385c : set) {
            if (interfaceC10385c != null) {
                if (z) {
                    interfaceC10385c.mo26182aM();
                } else {
                    interfaceC10385c.mo26181aN();
                }
            }
        }
    }

    /* renamed from: iY */
    private void m28902iY() {
        if (this.acu.getAndSet(true)) {
            return;
        }
        m28903aZ(true);
    }

    /* renamed from: tv */
    private void m28901tv() {
        if (mo28897dW()) {
            m28902iY();
        } else {
            m28898ty();
        }
    }

    /* renamed from: ty */
    private void m28898ty() {
        if (this.acu.getAndSet(false)) {
            m28903aZ(false);
        }
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (message.what == 666) {
            m28901tv();
            this.f29457hh.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10383a
    @MainThread
    /* renamed from: b */
    public final void mo26186b(InterfaceC10385c interfaceC10385c) {
        Set<InterfaceC10385c> set;
        C11014ah.checkUiThread();
        if (interfaceC10385c == null || (set = this.acv) == null) {
            return;
        }
        set.remove(interfaceC10385c);
    }

    /* renamed from: dW */
    public abstract boolean mo28897dW();

    @Override // com.kwad.sdk.core.p403h.InterfaceC10383a
    @CallSuper
    public final void release() {
        m28899tx();
        Set<InterfaceC10385c> set = this.acv;
        if (set != null) {
            set.clear();
        }
    }

    /* renamed from: tw */
    public final void m28900tw() {
        this.f29457hh.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.f29457hh.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    /* renamed from: tx */
    public final void m28899tx() {
        m28901tv();
        this.f29457hh.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10383a
    @MainThread
    /* renamed from: tz */
    public final boolean mo26185tz() {
        return this.acu.get();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10383a
    @MainThread
    /* renamed from: a */
    public final void mo26187a(final InterfaceC10385c interfaceC10385c) {
        C11014ah.checkUiThread();
        if (interfaceC10385c == null) {
            return;
        }
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (AbstractC9364a.this.mo28897dW()) {
                    interfaceC10385c.mo26182aM();
                } else {
                    interfaceC10385c.mo26181aN();
                }
            }
        });
        if (this.acv == null) {
            this.acv = new HashSet();
        }
        this.acv.add(interfaceC10385c);
    }
}
