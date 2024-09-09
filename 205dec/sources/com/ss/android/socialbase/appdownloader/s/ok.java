package com.ss.android.socialbase.appdownloader.s;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok extends com.ss.android.socialbase.appdownloader.bl.a {
    private AlertDialog.Builder ok;

    /* renamed from: com.ss.android.socialbase.appdownloader.s.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class C0968ok implements r {
        private AlertDialog ok;

        public C0968ok(AlertDialog.Builder builder) {
            if (builder != null) {
                this.ok = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public boolean a() {
            AlertDialog alertDialog = this.ok;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public void ok() {
            AlertDialog alertDialog = this.ok;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public ok(Context context) {
        this.ok = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j a(int i4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setNegativeButton(i4, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(int i4) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setTitle(i4);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(String str) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(int i4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setPositiveButton(i4, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public r ok() {
        return new C0968ok(this.ok);
    }
}
