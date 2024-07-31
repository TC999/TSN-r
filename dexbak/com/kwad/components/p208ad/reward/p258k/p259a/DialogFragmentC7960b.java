package com.kwad.components.p208ad.reward.p258k.p259a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.p335c.C9267b;
import com.kwad.components.core.webview.tachikoma.p335c.C9268c;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.sdk.core.response.p409b.C10484b;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.ad.reward.k.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogFragmentC7960b extends DialogFragmentC9274e {

    /* renamed from: xt */
    private static WeakReference<DialogFragmentC7960b> f26669xt;

    /* renamed from: xq */
    private C7907g f26670xq;

    /* renamed from: xs */
    private long f26671xs;

    /* renamed from: a */
    public static DialogFragmentC7960b m31920a(C7907g c7907g, DialogFragmentC9274e.C9277b c9277b) {
        DialogFragmentC7960b dialogFragmentC7960b = new DialogFragmentC7960b();
        dialogFragmentC7960b.f26670xq = c7907g;
        dialogFragmentC7960b.mAdResultData = c9277b.m29128hk();
        dialogFragmentC7960b.f29336xn = c9277b.getTemplateId();
        dialogFragmentC7960b.aaC = c9277b.m29127ke();
        dialogFragmentC7960b.aaM = c9277b.m29126sX();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", c9277b.getTemplateId());
        dialogFragmentC7960b.setArguments(bundle);
        return dialogFragmentC7960b;
    }

    /* renamed from: jj */
    private static boolean m31918jj() {
        WeakReference<DialogFragmentC7960b> weakReference = f26669xt;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: l */
    private void m31917l(long j) {
        this.f26671xs = j;
        C9267b c9267b = this.aay;
        if (c9267b != null) {
            c9267b.f29327xs = j;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e
    /* renamed from: jk */
    public final C9267b mo29146jk() {
        return new C7959a(this.f26670xq);
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e
    /* renamed from: jl */
    public final C9268c mo29145jl() {
        return new C7961c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e
    /* renamed from: jm */
    public final void mo29144jm() {
        super.mo29144jm();
        this.aay.f29327xs = this.f26671xs;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f26670xq = null;
        f26669xt = null;
    }

    @Nullable
    /* renamed from: a */
    public static DialogFragmentC7960b m31919a(DialogFragmentC7960b dialogFragmentC7960b, Activity activity, long j, InterfaceC9291c interfaceC9291c, DialogFragmentC9274e.InterfaceC9276a interfaceC9276a) {
        if (activity == null || activity.isFinishing() || m31918jj()) {
            return null;
        }
        dialogFragmentC7960b.f29335Sy = interfaceC9291c;
        dialogFragmentC7960b.aaD = interfaceC9276a;
        dialogFragmentC7960b.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j > 0) {
            dialogFragmentC7960b.m31917l(j);
        }
        f26669xt = new WeakReference<>(dialogFragmentC7960b);
        return dialogFragmentC7960b;
    }

    @Nullable
    /* renamed from: a */
    public static DialogFragmentC7960b m31921a(C7907g c7907g, Activity activity, long j, DialogInterface.OnDismissListener onDismissListener, InterfaceC9291c interfaceC9291c) {
        if (activity == null || activity.isFinishing() || m31918jj()) {
            return null;
        }
        DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
        c9277b.m29132d(c7907g.mAdResultData);
        c9277b.m29138aU(C10484b.m25679dv(c7907g.mAdTemplate));
        DialogFragmentC7960b m31920a = m31920a(c7907g, c9277b);
        m31920a.f29335Sy = interfaceC9291c;
        m31920a.m29148d(onDismissListener);
        m31920a.m31917l(j);
        m31920a.show(activity.getFragmentManager(), "tkExtraReward");
        f26669xt = new WeakReference<>(m31920a);
        return m31920a;
    }
}
