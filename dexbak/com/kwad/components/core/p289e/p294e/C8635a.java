package com.kwad.components.core.p289e.p294e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.core.e.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8635a extends KSFrameLayout {

    /* renamed from: Ln */
    private final DialogFragment f28274Ln;

    /* renamed from: Lo */
    private final View f28275Lo;

    /* renamed from: Lp */
    private C8615a.C8616a f28276Lp;

    public C8635a(@NonNull Context context, DialogFragment dialogFragment, C8615a.C8616a c8616a) {
        super(context);
        this.f28274Ln = dialogFragment;
        this.f28276Lp = c8616a;
        C10887l.inflate(context, C9659R.C9663layout.ksad_seconed_confirm_dialog_layout, this);
        this.f28275Lo = findViewById(C9659R.C9662id.ksad_second_confirm_root_view);
    }

    /* renamed from: af */
    private static Presenter m30095af() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new View$OnClickListenerC8638d());
        return presenter;
    }

    /* renamed from: oq */
    private C8637c m30094oq() {
        C8637c c8637c = new C8637c();
        c8637c.f28278Ln = this.f28274Ln;
        c8637c.f28279Lp = this.f28276Lp;
        return c8637c;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        Presenter m30095af = m30095af();
        m30095af.m24616G(this.f28275Lo);
        m30095af.m24605k(m30094oq());
    }
}
