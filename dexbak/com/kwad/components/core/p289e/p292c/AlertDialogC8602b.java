package com.kwad.components.core.p289e.p292c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.C8526a;
import com.kwad.components.core.p289e.p292c.C8600a;
import com.kwad.components.core.proxy.AbstractAlertDialogC8887d;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.e.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AlertDialogC8602b extends AbstractAlertDialogC8887d {
    @Nullable

    /* renamed from: Ke */
    private static AlertDialogC8602b f28179Ke;
    @NonNull

    /* renamed from: Kf */
    private final C8605b f28180Kf;

    /* renamed from: Ki */
    private C8600a f28181Ki;

    /* renamed from: Kj */
    private boolean f28182Kj;

    /* renamed from: com.kwad.components.core.e.c.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8604a {
        @Nullable

        /* renamed from: Kl */
        private DialogInterface.OnShowListener f28184Kl;
        @Nullable

        /* renamed from: Km */
        private DialogInterface.OnDismissListener f28185Km;
        private AdTemplate adTemplate;
        private String url;

        /* renamed from: ae */
        public final C8604a m30262ae(String str) {
            this.url = str;
            return this;
        }

        /* renamed from: ap */
        public final C8604a m30261ap(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        /* renamed from: nu */
        public final C8605b m30256nu() {
            if (C8526a.f28050md.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C8605b(this, (byte) 0);
        }

        /* renamed from: a */
        public final C8604a m30264a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.f28184Kl = onShowListener;
            return this;
        }

        /* renamed from: c */
        public final C8604a m30259c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.f28185Km = onDismissListener;
            return this;
        }
    }

    /* renamed from: com.kwad.components.core.e.c.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8605b {
        @Nullable

        /* renamed from: Kl */
        protected DialogInterface.OnShowListener f28186Kl;
        @Nullable

        /* renamed from: Km */
        protected DialogInterface.OnDismissListener f28187Km;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C8605b(C8604a c8604a, byte b) {
            this(c8604a);
        }

        private C8605b(C8604a c8604a) {
            this.adTemplate = c8604a.adTemplate;
            this.url = c8604a.url;
            this.f28186Kl = c8604a.f28184Kl;
            this.f28187Km = c8604a.f28185Km;
        }
    }

    private AlertDialogC8602b(Activity activity, @NonNull C8605b c8605b) {
        super(activity);
        this.f28182Kj = false;
        this.f28180Kf = c8605b;
        if (C10751a.m24918b(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c8605b.f28186Kl);
        setOnDismissListener(c8605b.f28187Km);
    }

    /* renamed from: a */
    public static boolean m30269a(Context context, C8605b c8605b) {
        Activity m24559dn;
        AlertDialogC8602b alertDialogC8602b = f28179Ke;
        if ((alertDialogC8602b == null || !alertDialogC8602b.isShowing()) && context != null && (m24559dn = C10887l.m24559dn(context)) != null && !m24559dn.isFinishing()) {
            C9679c.m28040zM().dismiss();
            try {
                AlertDialogC8602b alertDialogC8602b2 = new AlertDialogC8602b(m24559dn, c8605b);
                f28179Ke = alertDialogC8602b2;
                alertDialogC8602b2.show();
                C9908c.m27337b(c8605b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
        }
        return false;
    }

    /* renamed from: nr */
    public static boolean m30267nr() {
        AlertDialogC8602b alertDialogC8602b = f28179Ke;
        if (alertDialogC8602b != null) {
            return alertDialogC8602b.isShowing();
        }
        return false;
    }

    /* renamed from: aj */
    public final void m30268aj(boolean z) {
        this.f28182Kj = z;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: ck */
    public final ViewGroup mo29674ck() {
        C8600a c8600a = new C8600a(this.mContext, this, this.f28180Kf);
        this.f28181Ki = c8600a;
        return c8600a;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        f28179Ke = null;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: g */
    public final void mo28085g(View view) {
        this.f28181Ki.setChangeListener(new C8600a.InterfaceC8601a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.p289e.p292c.C8600a.InterfaceC8601a
            /* renamed from: nq */
            public final void mo30265nq() {
                AlertDialogC8602b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    public final int getLayoutId() {
        return 0;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: ns */
    public final boolean mo29673ns() {
        return true;
    }

    /* renamed from: nt */
    public final boolean m30266nt() {
        return this.f28182Kj;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        C9908c.m27320bO(this.f28180Kf.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f28179Ke = null;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d, android.app.Dialog
    public final void onStart() {
        super.onStart();
        AlertDialogC8602b alertDialogC8602b = f28179Ke;
        if (alertDialogC8602b != null) {
            alertDialogC8602b.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}
