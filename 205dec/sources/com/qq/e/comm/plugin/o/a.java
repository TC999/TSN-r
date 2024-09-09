package com.qq.e.comm.plugin.o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements ACTD, DialogInterface.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private static SparseArray<b> f45020e = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final Activity f45021c;

    /* renamed from: d  reason: collision with root package name */
    private b f45022d;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class DialogInterface$OnDismissListenerC0862a implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0862a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Activity activity) {
        this.f45021c = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.f45021c.getIntent().getStringExtra("tip_key");
        String stringExtra2 = this.f45021c.getIntent().getStringExtra("positive_text_id_key");
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "\u6253\u5f00";
        }
        String stringExtra3 = this.f45021c.getIntent().getStringExtra("negative_text_id_key");
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = "\u53d6\u6d88";
        }
        int intExtra = this.f45021c.getIntent().getIntExtra("callback_id_key", -1);
        if (intExtra != -1 && !TextUtils.isEmpty(stringExtra)) {
            b bVar = f45020e.get(intExtra);
            this.f45022d = bVar;
            if (bVar == null) {
                GDTLogger.d("open opt showDialog get callback is null");
                this.f45021c.finish();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f45021c, Build.VERSION.SDK_INT >= 21 ? 16974394 : 0);
            builder.setMessage(stringExtra).setCancelable(false).setPositiveButton(stringExtra2, this).setNegativeButton(stringExtra3, this);
            if (Build.VERSION.SDK_INT >= 17) {
                builder.setOnDismissListener(new DialogInterface$OnDismissListenerC0862a());
            }
            try {
                builder.create().show();
                return;
            } catch (Exception unused) {
                this.f45021c.finish();
                return;
            }
        }
        GDTLogger.d("open opt showDialog param illegal callbackId:" + intExtra + " tips:" + stringExtra);
        this.f45021c.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        b bVar = this.f45022d;
        if (bVar != null) {
            if (i4 == -1) {
                bVar.b();
            } else if (i4 == -2) {
                bVar.a();
            }
        }
        dialogInterface.dismiss();
        a();
        this.f45021c.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        a();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    public static void a(String str, b bVar) {
        a(str, null, null, bVar);
    }

    public static void a(String str, String str2, String str3, b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
            Intent intent = new Intent();
            intent.setClassName(a4, "com.qq.e.ads.DialogActivity");
            intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.DIALOG_ACTIVITY);
            intent.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
            intent.putExtra("tip_key", str);
            intent.putExtra("positive_text_id_key", str2);
            intent.putExtra("negative_text_id_key", str3);
            int hashCode = bVar.hashCode();
            intent.putExtra("callback_id_key", hashCode);
            intent.setFlags(268435456);
            a4.startActivity(intent);
            f45020e.put(hashCode, bVar);
            return;
        }
        GDTLogger.d("install opt showDialog param illegal callback:" + bVar + " tips:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        b bVar = this.f45022d;
        if (bVar != null) {
            f45020e.remove(bVar.hashCode());
            this.f45022d = null;
        }
    }
}
