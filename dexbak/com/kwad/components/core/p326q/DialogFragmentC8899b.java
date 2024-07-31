package com.kwad.components.core.p326q;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.p335c.C9267b;
import com.kwad.components.core.webview.tachikoma.p335c.C9268c;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;

/* renamed from: com.kwad.components.core.q.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogFragmentC8899b extends DialogFragmentC9274e {

    /* renamed from: Sy */
    protected InterfaceC9291c f28768Sy;

    /* renamed from: a */
    public static DialogFragmentC8899b m29642a(DialogFragmentC9274e.C9277b c9277b) {
        DialogFragmentC8899b dialogFragmentC8899b = new DialogFragmentC8899b();
        dialogFragmentC8899b.mAdResultData = c9277b.m29128hk();
        dialogFragmentC8899b.f29336xn = c9277b.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", c9277b.getTemplateId());
        dialogFragmentC8899b.setArguments(bundle);
        return dialogFragmentC8899b;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e
    /* renamed from: jk */
    public final C9267b mo29146jk() {
        return super.mo29146jk();
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e
    /* renamed from: jl */
    public final C9268c mo29145jl() {
        return new C8900c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        InterfaceC9291c interfaceC9291c = this.f28768Sy;
        if (interfaceC9291c != null) {
            interfaceC9291c.mo29098fZ();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e, android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        InterfaceC9291c interfaceC9291c = this.f28768Sy;
        if (interfaceC9291c != null) {
            interfaceC9291c.mo29099fR();
        }
    }

    @Nullable
    /* renamed from: a */
    public static DialogFragmentC8899b m29643a(DialogFragmentC8899b dialogFragmentC8899b, Activity activity, InterfaceC9291c interfaceC9291c) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        dialogFragmentC8899b.f28768Sy = interfaceC9291c;
        dialogFragmentC8899b.show(activity.getFragmentManager(), "webTKCloseDialog");
        return dialogFragmentC8899b;
    }
}
