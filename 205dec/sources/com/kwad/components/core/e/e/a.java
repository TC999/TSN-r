package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment Ln;
    private final View Lo;
    private a.C0631a Lp;

    public a(@NonNull Context context, DialogFragment dialogFragment, a.C0631a c0631a) {
        super(context);
        this.Ln = dialogFragment;
        this.Lp = c0631a;
        l.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.Lo = findViewById(R.id.ksad_second_confirm_root_view);
    }

    private static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c oq() {
        c cVar = new c();
        cVar.Ln = this.Ln;
        cVar.Lp = this.Lp;
        return cVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        Presenter af = af();
        af.G(this.Lo);
        af.k(oq());
    }
}
