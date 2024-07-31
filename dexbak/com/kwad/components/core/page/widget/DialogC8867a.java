package com.kwad.components.core.page.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.core.page.widget.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogC8867a extends Dialog {

    /* renamed from: Qu */
    private final InterfaceC8872a f28716Qu;

    /* renamed from: Qv */
    private final String f28717Qv;

    /* renamed from: com.kwad.components.core.page.widget.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8872a {
        /* renamed from: a */
        void mo29705a(DialogInterface dialogInterface);

        /* renamed from: b */
        void mo29704b(DialogInterface dialogInterface);

        /* renamed from: c */
        void mo29703c(DialogInterface dialogInterface);
    }

    public DialogC8867a(@NonNull Context context, @NonNull InterfaceC8872a interfaceC8872a) {
        this(context, null, interfaceC8872a);
    }

    /* renamed from: qb */
    private View m29706qb() {
        View inflate = C10887l.inflate(getContext(), C9659R.C9663layout.ksad_web_exit_intercept_content_layout, null);
        inflate.findViewById(C9659R.C9662id.ksad_exit_intercept_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC8867a.this.f28716Qu.mo29703c(DialogC8867a.this);
            }
        });
        inflate.findViewById(C9659R.C9662id.ksad_exit_intercept_content_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        inflate.findViewById(C9659R.C9662id.ksad_web_exit_intercept_positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC8867a.this.f28716Qu.mo29705a(DialogC8867a.this);
            }
        });
        inflate.findViewById(C9659R.C9662id.ksad_web_exit_intercept_negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC8867a.this.f28716Qu.mo29704b(DialogC8867a.this);
            }
        });
        TextView textView = (TextView) inflate.findViewById(C9659R.C9662id.ksad_exit_intercept_content);
        if (!TextUtils.isEmpty(this.f28717Qv)) {
            textView.setText(this.f28717Qv);
        }
        return inflate;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Exception unused) {
        }
        setContentView(m29706qb());
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(false);
    }

    public DialogC8867a(@NonNull Context context, String str, @NonNull InterfaceC8872a interfaceC8872a) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.f28716Qu = interfaceC8872a;
        this.f28717Qv = str;
    }
}
