package com.ss.android.socialbase.appdownloader.sr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.xv.a;
import com.ss.android.socialbase.appdownloader.xv.k;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends com.ss.android.socialbase.appdownloader.xv.w {

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog.Builder f49215c;

    /* renamed from: com.ss.android.socialbase.appdownloader.sr.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class C0969c implements k {

        /* renamed from: c  reason: collision with root package name */
        private AlertDialog f49216c;

        public C0969c(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f49216c = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.xv.k
        public void c() {
            AlertDialog alertDialog = this.f49216c;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.xv.k
        public boolean w() {
            AlertDialog alertDialog = this.f49216c;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public c(Context context) {
        this.f49215c = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public a c(int i4) {
        AlertDialog.Builder builder = this.f49215c;
        if (builder != null) {
            builder.setTitle(i4);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public a w(int i4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f49215c;
        if (builder != null) {
            builder.setNegativeButton(i4, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public a c(String str) {
        AlertDialog.Builder builder = this.f49215c;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public a c(int i4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f49215c;
        if (builder != null) {
            builder.setPositiveButton(i4, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public a c(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f49215c;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.a
    public k c() {
        return new C0969c(this.f49215c);
    }
}
