package com.p521ss.android.socialbase.appdownloader.p547s;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.p521ss.android.socialbase.appdownloader.p542bl.AbstractC12296a;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r;

/* renamed from: com.ss.android.socialbase.appdownloader.s.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12371ok extends AbstractC12296a {

    /* renamed from: ok */
    private AlertDialog.Builder f34868ok;

    /* renamed from: com.ss.android.socialbase.appdownloader.s.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12372ok implements InterfaceC12306r {

        /* renamed from: ok */
        private AlertDialog f34869ok;

        public C12372ok(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f34869ok = builder.show();
            }
        }

        @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r
        /* renamed from: a */
        public boolean mo18017a() {
            AlertDialog alertDialog = this.f34869ok;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r
        /* renamed from: ok */
        public void mo18016ok() {
            AlertDialog alertDialog = this.f34869ok;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public C12371ok(Context context) {
        this.f34868ok = new AlertDialog.Builder(context);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: a */
    public InterfaceC12299j mo18023a(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f34868ok;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: ok */
    public InterfaceC12299j mo18021ok(int i) {
        AlertDialog.Builder builder = this.f34868ok;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: ok */
    public InterfaceC12299j mo18018ok(String str) {
        AlertDialog.Builder builder = this.f34868ok;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: ok */
    public InterfaceC12299j mo18020ok(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f34868ok;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: ok */
    public InterfaceC12299j mo18019ok(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f34868ok;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j
    /* renamed from: ok */
    public InterfaceC12306r mo18022ok() {
        return new C12372ok(this.f34868ok);
    }
}
