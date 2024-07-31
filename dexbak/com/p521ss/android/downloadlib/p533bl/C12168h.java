package com.p521ss.android.downloadlib.p533bl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.p521ss.android.download.api.model.C11980a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.socialbase.appdownloader.p542bl.C12303ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r;

/* renamed from: com.ss.android.downloadlib.bl.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12168h extends C12303ok {

    /* renamed from: ok */
    private static String f34415ok = "h";

    /* renamed from: com.ss.android.downloadlib.bl.h$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12171ok implements InterfaceC12306r {

        /* renamed from: ok */
        private Dialog f34423ok;

        public C12171ok(Dialog dialog) {
            if (dialog != null) {
                this.f34423ok = dialog;
                mo18016ok();
            }
        }

        @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r
        /* renamed from: a */
        public boolean mo18017a() {
            Dialog dialog = this.f34423ok;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r
        /* renamed from: ok */
        public void mo18016ok() {
            Dialog dialog = this.f34423ok;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.C12303ok, com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl
    /* renamed from: ok */
    public InterfaceC12299j mo18390ok(Context context) {
        return new InterfaceC12299j(context) { // from class: com.ss.android.downloadlib.bl.h.1

            /* renamed from: bl */
            private C11980a.C11983ok f34417bl;

            /* renamed from: kf */
            private DialogInterface.OnCancelListener f34418kf;

            /* renamed from: n */
            private DialogInterface.OnClickListener f34419n;

            /* renamed from: ok */
            final /* synthetic */ Context f34420ok;

            /* renamed from: s */
            private DialogInterface.OnClickListener f34421s;

            {
                this.f34420ok = context;
                this.f34417bl = new C11980a.C11983ok(context);
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: a */
            public InterfaceC12299j mo18023a(int i, DialogInterface.OnClickListener onClickListener) {
                this.f34417bl.m19594s(this.f34420ok.getResources().getString(i));
                this.f34419n = onClickListener;
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12299j mo18021ok(int i) {
                this.f34417bl.m19598ok(this.f34420ok.getResources().getString(i));
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12299j mo18018ok(String str) {
                this.f34417bl.m19609a(str);
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12299j mo18020ok(int i, DialogInterface.OnClickListener onClickListener) {
                this.f34417bl.m19607bl(this.f34420ok.getResources().getString(i));
                this.f34421s = onClickListener;
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12299j mo18019ok(DialogInterface.OnCancelListener onCancelListener) {
                this.f34418kf = onCancelListener;
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12299j mo18401ok(boolean z) {
                this.f34417bl.m19597ok(z);
                return this;
            }

            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
            /* renamed from: ok */
            public InterfaceC12306r mo18022ok() {
                this.f34417bl.m19600ok(new C11980a.InterfaceC11982a() { // from class: com.ss.android.downloadlib.bl.h.1.1
                    @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                    /* renamed from: a */
                    public void mo18862a(DialogInterface dialogInterface) {
                        if (C121691.this.f34419n != null) {
                            C121691.this.f34419n.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                    /* renamed from: bl */
                    public void mo18861bl(DialogInterface dialogInterface) {
                        if (C121691.this.f34418kf == null || dialogInterface == null) {
                            return;
                        }
                        C121691.this.f34418kf.onCancel(dialogInterface);
                    }

                    @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                    /* renamed from: ok */
                    public void mo18860ok(DialogInterface dialogInterface) {
                        if (C121691.this.f34421s != null) {
                            C121691.this.f34421s.onClick(dialogInterface, -1);
                        }
                    }
                });
                C12216r.m18673ok(C12168h.f34415ok, "getThemedAlertDlgBuilder", null);
                this.f34417bl.m19602ok(3);
                return new C12171ok(C12128r.m18968bl().mo19529a(this.f34417bl.m19603ok()));
            }
        };
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.C12303ok, com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl
    /* renamed from: ok */
    public boolean mo18391ok() {
        return true;
    }
}
