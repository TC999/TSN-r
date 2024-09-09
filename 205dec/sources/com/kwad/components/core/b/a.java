package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements View.OnClickListener {
    @Nullable
    private TextView IJ;
    @Nullable
    private ImageView IK;
    @Nullable
    private ImageView IL;
    @Nullable
    private InterfaceC0620a IM;
    private ViewGroup sz;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0620a {
        void u(View view);

        void v(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.sz = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.IJ = (TextView) this.sz.findViewById(R.id.ksad_kwad_titlebar_title);
        this.IK = (ImageView) this.sz.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.sz.findViewById(R.id.ksad_kwad_web_navi_close);
        this.IL = imageView;
        imageView.setOnClickListener(this);
        this.IK.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0620a interfaceC0620a) {
        this.IM = interfaceC0620a;
    }

    @MainThread
    public final void ah(boolean z3) {
        ImageView imageView = this.IL;
        if (imageView != null) {
            imageView.setVisibility(z3 ? 0 : 8);
        }
    }

    public final ViewGroup gF() {
        return this.sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.IM == null) {
            return;
        }
        if (view.equals(this.IL)) {
            this.IM.v(view);
        } else if (view.equals(this.IK)) {
            this.IM.u(view);
        }
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sz == null || (textView = this.IJ) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }
}
