package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.core.proxy.d {
    @Nullable
    private static b Ke;
    @NonNull
    private final C0630b Kf;
    private com.kwad.components.core.e.c.a Ki;
    private boolean Kj;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        @Nullable
        private DialogInterface.OnShowListener Kl;
        @Nullable
        private DialogInterface.OnDismissListener Km;
        private AdTemplate adTemplate;
        private String url;

        public final a ae(String str) {
            this.url = str;
            return this;
        }

        public final a ap(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0630b nu() {
            if (com.kwad.components.core.a.md.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0630b(this, (byte) 0);
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.Kl = onShowListener;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.Km = onDismissListener;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0630b {
        @Nullable
        protected DialogInterface.OnShowListener Kl;
        @Nullable
        protected DialogInterface.OnDismissListener Km;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C0630b(a aVar, byte b4) {
            this(aVar);
        }

        private C0630b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.Kl = aVar.Kl;
            this.Km = aVar.Km;
        }
    }

    private b(Activity activity, @NonNull C0630b c0630b) {
        super(activity);
        this.Kj = false;
        this.Kf = c0630b;
        if (com.kwad.sdk.d.a.a.b(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0630b.Kl);
        setOnDismissListener(c0630b.Km);
    }

    public static boolean a(Context context, C0630b c0630b) {
        Activity dn;
        b bVar = Ke;
        if ((bVar == null || !bVar.isShowing()) && context != null && (dn = l.dn(context)) != null && !dn.isFinishing()) {
            com.kwad.sdk.a.a.c.zM().dismiss();
            try {
                b bVar2 = new b(dn, c0630b);
                Ke = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0630b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean nr() {
        b bVar = Ke;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void aj(boolean z3) {
        this.Kj = z3;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.d
    public final ViewGroup ck() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Kf);
        this.Ki = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Ke = null;
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view) {
        this.Ki.setChangeListener(new a.InterfaceC0629a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0629a
            public final void nq() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return 0;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.kwad.components.core.proxy.d
    public final boolean ns() {
        return true;
    }

    public final boolean nt() {
        return this.Kj;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.bO(this.Kf.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ke = null;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Ke;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }
}
