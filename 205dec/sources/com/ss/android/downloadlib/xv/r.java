package com.ss.android.downloadlib.xv;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.w;
import com.ss.android.socialbase.appdownloader.xv.a;
import com.ss.android.socialbase.appdownloader.xv.k;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r extends com.ss.android.socialbase.appdownloader.xv.c {

    /* renamed from: c  reason: collision with root package name */
    private static String f49005c = "r";

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c implements k {

        /* renamed from: c  reason: collision with root package name */
        private Dialog f49010c;

        public c(Dialog dialog) {
            if (dialog != null) {
                this.f49010c = dialog;
                c();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.xv.k
        public void c() {
            Dialog dialog = this.f49010c;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.xv.k
        public boolean w() {
            Dialog dialog = this.f49010c;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.c, com.ss.android.socialbase.appdownloader.xv.xv
    public a c(Context context) {
        return new a(context) { // from class: com.ss.android.downloadlib.xv.r.1

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f49006c;

            /* renamed from: f  reason: collision with root package name */
            private DialogInterface.OnCancelListener f49007f;
            private DialogInterface.OnClickListener sr;
            private DialogInterface.OnClickListener ux;
            private w.c xv;

            {
                this.f49006c = context;
                this.xv = new w.c(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a c(int i4) {
                this.xv.c(this.f49006c.getResources().getString(i4));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a w(int i4, DialogInterface.OnClickListener onClickListener) {
                this.xv.sr(this.f49006c.getResources().getString(i4));
                this.ux = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a c(String str) {
                this.xv.w(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a c(int i4, DialogInterface.OnClickListener onClickListener) {
                this.xv.xv(this.f49006c.getResources().getString(i4));
                this.sr = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a c(DialogInterface.OnCancelListener onCancelListener) {
                this.f49007f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public a c(boolean z3) {
                this.xv.c(z3);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.xv.a
            public k c() {
                this.xv.c(new w.InterfaceC0938w() { // from class: com.ss.android.downloadlib.xv.r.1.1
                    @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.sr != null) {
                            AnonymousClass1.this.sr.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                    public void w(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.ux != null) {
                            AnonymousClass1.this.ux.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                    public void xv(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f49007f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f49007f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.r.k.c(r.f49005c, "getThemedAlertDlgBuilder", null);
                this.xv.c(3);
                return new c(com.ss.android.downloadlib.addownload.k.xv().w(this.xv.c()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.c, com.ss.android.socialbase.appdownloader.xv.xv
    public boolean c() {
        return true;
    }
}
