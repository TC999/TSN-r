package com.bxkj.base.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.base.BaseApp;
import com.bxkj.base.C3801R;
import com.orhanobut.logger.C11792j;
import java.io.File;
import p618m.StartActivityForResult;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InstallUtil {

    /* renamed from: a */
    private Context f14845a;

    /* renamed from: b */
    private File f14846b;

    /* renamed from: c */
    private AlertDialog f14847c;

    /* renamed from: d */
    boolean f14848d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class UpdateActivityObserver implements LifecycleObserver {
        private UpdateActivityObserver() {
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            C11792j.m20470c("UpdateApk->UpdateActivityObserver->");
            InstallUtil.this.m44148c();
        }
    }

    public InstallUtil(Context context, File file) {
        this.f14845a = context;
        this.f14846b = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m44147d(int i, Intent intent) {
        C11792j.m20470c("UpdateApk->onActivityResult->");
        m44148c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m44146e(DialogInterface dialogInterface, int i) {
        if (this.f14845a.getPackageManager().canRequestPackageInstalls()) {
            m44144g();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f14845a.getPackageName()));
        intent.setFlags(268435456);
        Context context = this.f14845a;
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            new StartActivityForResult(fragmentActivity).startActivityForResult(intent).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.base.util.o
                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public final void mo3459a(int i2, Intent intent2) {
                    InstallUtil.this.m44147d(i2, intent2);
                }
            });
            fragmentActivity.getLifecycle().addObserver(new UpdateActivityObserver());
        }
    }

    /* renamed from: f */
    private void m44145f() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(this.f14846b), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        this.f14845a.startActivity(intent);
    }

    /* renamed from: g */
    private void m44144g() {
        if (this.f14848d) {
            return;
        }
        Context context = this.f14845a;
        Uri uriForFile = FileProvider.getUriForFile(context, this.f14845a.getPackageName() + ".provider", this.f14846b);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        this.f14845a.startActivity(intent);
        this.f14848d = true;
    }

    @RequiresApi(api = 26)
    /* renamed from: h */
    private void m44143h() {
        AlertDialog alertDialog = this.f14847c;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f14847c.dismiss();
        }
        boolean canRequestPackageInstalls = this.f14845a.getPackageManager().canRequestPackageInstalls();
        C11792j.m20470c("startInstallO->isGranted=" + canRequestPackageInstalls);
        m44144g();
        if (canRequestPackageInstalls) {
            m44144g();
            return;
        }
        AlertDialog show = new AlertDialog.Builder(this.f14845a).setCancelable(false).setTitle("安装应用需要打开未知来源权限，请去设置中开启权限").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                InstallUtil.this.m44146e(dialogInterface, i);
            }
        }).show();
        this.f14847c = show;
        Button button = show.getButton(-2);
        BaseApp m44341b = BaseApp.m44341b();
        int i = C3801R.C3803color.cardBlue;
        button.setTextColor(m44341b.getColor(i));
        this.f14847c.getButton(-1).setTextColor(BaseApp.m44341b().getColor(i));
    }

    /* renamed from: c */
    public void m44148c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            m44144g();
        } else if (i >= 26) {
            m44143h();
        } else if (i >= 24) {
            m44144g();
        } else {
            m44145f();
        }
    }
}
