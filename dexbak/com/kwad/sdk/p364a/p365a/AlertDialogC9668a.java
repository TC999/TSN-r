package com.kwad.sdk.p364a.p365a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.AbstractAlertDialogC8887d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.p372a.C9813a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11017ak;

/* renamed from: com.kwad.sdk.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AlertDialogC9668a extends AbstractAlertDialogC8887d {
    @SuppressLint({"StaticFieldLeak"})
    private static AlertDialogC9668a aln;
    @Nullable
    private final DialogInterface.OnDismissListener alo;
    private final AdTemplate mAdTemplate;
    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    private AlertDialogC9668a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.alo = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    /* renamed from: nr */
    public static boolean m28084nr() {
        AlertDialogC9668a alertDialogC9668a = aln;
        return alertDialogC9668a != null && alertDialogC9668a.isShowing();
    }

    /* renamed from: zH */
    public static boolean m28083zH() {
        AlertDialogC9668a alertDialogC9668a = aln;
        if (alertDialogC9668a == null || !alertDialogC9668a.isShowing()) {
            return false;
        }
        aln.dismiss();
        return true;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.alo;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            aln = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: g */
    public final void mo28085g(View view) {
        TextView textView = (TextView) view.findViewById(C9659R.C9662id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(C9659R.C9662id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(C9659R.C9662id.ksad_install_tv);
        final AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        String m28032F = C9692d.m28032F(C10487e.m25641dQ(this.mAdTemplate));
        if (m28032F.equals("")) {
            m28032F = this.mContext.getString(C9659R.C9664string.ksad_install_tips, C10483a.m25914av(m25641dQ));
        }
        textView.setText(m28032F);
        textView3.setText(C9692d.m28031zS());
        textView2.setText(C9692d.m28030zT());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlertDialogC9668a.this.dismiss();
                if (AlertDialogC9668a.this.mOnClickListener != null) {
                    AlertDialogC9668a.this.mOnClickListener.onClick(AlertDialogC9668a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (AlertDialogC9668a.this.mOnClickListener != null) {
                    AlertDialogC9668a.this.mOnClickListener.onClick(AlertDialogC9668a.this, -1);
                }
                C11017ak.m24115a(C10296a.m26382H(m25641dQ), new C11017ak.InterfaceC11018a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
                    /* renamed from: d */
                    public final void mo24107d(Throwable th) {
                        C9813a.m27708i(AlertDialogC9668a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
                    /* renamed from: ol */
                    public final void mo24106ol() {
                        C9908c.m27302h(AlertDialogC9668a.this.mAdTemplate, 1);
                        C9813a.m27712aY(AlertDialogC9668a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_install_dialog;
    }

    /* renamed from: a */
    public static boolean m28088a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            AlertDialogC9668a alertDialogC9668a = aln;
            if (alertDialogC9668a != null && alertDialogC9668a.isShowing()) {
                aln.dismiss();
            }
            try {
                AlertDialogC9668a alertDialogC9668a2 = new AlertDialogC9668a(activity, adTemplate, onDismissListener, onClickListener);
                alertDialogC9668a2.show();
                aln = alertDialogC9668a2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m28089a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate m28039zN;
        if (activity == null || activity.isFinishing() || (m28039zN = C9679c.m28040zM().m28039zN()) == null) {
            return false;
        }
        return m28088a(activity, m28039zN, onDismissListener, onClickListener);
    }
}
