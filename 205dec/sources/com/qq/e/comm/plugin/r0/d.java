package com.qq.e.comm.plugin.r0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Activity f45690a;

    /* renamed from: b  reason: collision with root package name */
    private String f45691b;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.c f45692c;

    /* renamed from: d  reason: collision with root package name */
    private AlertDialog f45693d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45694e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            d.this.f45694e = true;
            d.this.f45692c.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            d.this.f45694e = true;
            d.this.f45692c.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            d.this.f45694e = true;
            d.this.f45692c.onConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.r0.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class DialogInterface$OnDismissListenerC0884d implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0884d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.this.f45692c.b(d.this.f45694e);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a();
            if (d.this.f45693d == null || d.this.f45690a.isFinishing()) {
                return;
            }
            d.this.f45693d.show();
        }
    }

    public d(Activity activity, String str, com.qq.e.comm.plugin.i.d0.c cVar) {
        this.f45690a = activity;
        this.f45691b = str;
        this.f45692c = cVar;
        b();
    }

    private void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f45690a, Build.VERSION.SDK_INT >= 21 ? 16974394 : 0);
        Object[] objArr = new Object[1];
        String str = this.f45691b;
        if (str == null) {
            str = "APP";
        }
        objArr[0] = str;
        builder.setMessage(String.format("\u524d\u5f80\u201c%s\u201d\u4e86\u89e3\u66f4\u591a", objArr)).setCancelable(false).setPositiveButton("\u524d\u5f80", new c()).setNegativeButton("\u53d6\u6d88", new b()).setOnCancelListener(new a());
        AlertDialog create = builder.create();
        this.f45693d = create;
        create.setOnDismissListener(new DialogInterface$OnDismissListenerC0884d());
    }

    public void c() {
        p0.a((Runnable) new e());
    }

    public void a() {
        AlertDialog alertDialog = this.f45693d;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f45693d.dismiss();
    }
}
