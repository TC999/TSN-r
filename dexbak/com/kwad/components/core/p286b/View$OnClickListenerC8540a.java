package com.kwad.components.core.p286b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.core.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8540a implements View.OnClickListener {
    @Nullable

    /* renamed from: IJ */
    private TextView f28076IJ;
    @Nullable

    /* renamed from: IK */
    private ImageView f28077IK;
    @Nullable

    /* renamed from: IL */
    private ImageView f28078IL;
    @Nullable

    /* renamed from: IM */
    private InterfaceC8541a f28079IM;

    /* renamed from: sz */
    private ViewGroup f28080sz;

    /* renamed from: com.kwad.components.core.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8541a {
        /* renamed from: u */
        void mo29634u(View view);

        /* renamed from: v */
        void mo29633v(View view);
    }

    public View$OnClickListenerC8540a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C9659R.C9662id.ksad_kwad_web_title_bar);
        this.f28080sz = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.f28076IJ = (TextView) this.f28080sz.findViewById(C9659R.C9662id.ksad_kwad_titlebar_title);
        this.f28077IK = (ImageView) this.f28080sz.findViewById(C9659R.C9662id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.f28080sz.findViewById(C9659R.C9662id.ksad_kwad_web_navi_close);
        this.f28078IL = imageView;
        imageView.setOnClickListener(this);
        this.f28077IK.setOnClickListener(this);
    }

    /* renamed from: a */
    public final void m30412a(@Nullable InterfaceC8541a interfaceC8541a) {
        this.f28079IM = interfaceC8541a;
    }

    @MainThread
    /* renamed from: ah */
    public final void m30410ah(boolean z) {
        ImageView imageView = this.f28078IL;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: gF */
    public final ViewGroup m30409gF() {
        return this.f28080sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f28079IM == null) {
            return;
        }
        if (view.equals(this.f28078IL)) {
            this.f28079IM.mo29633v(view);
        } else if (view.equals(this.f28077IK)) {
            this.f28079IM.mo29634u(view);
        }
    }

    /* renamed from: a */
    public final void m30411a(C8542b c8542b) {
        TextView textView;
        if (this.f28080sz == null || (textView = this.f28076IJ) == null) {
            return;
        }
        textView.setText(c8542b.getTitle());
    }
}
