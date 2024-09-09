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
import com.bxkj.base.R;
import java.io.File;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class InstallUtil {

    /* renamed from: a  reason: collision with root package name */
    private Context f18329a;

    /* renamed from: b  reason: collision with root package name */
    private File f18330b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f18331c;

    /* renamed from: d  reason: collision with root package name */
    boolean f18332d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class UpdateActivityObserver implements LifecycleObserver {
        private UpdateActivityObserver() {
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            com.orhanobut.logger.j.c("UpdateApk->UpdateActivityObserver->");
            InstallUtil.this.c();
        }
    }

    public InstallUtil(Context context, File file) {
        this.f18329a = context;
        this.f18330b = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i4, Intent intent) {
        com.orhanobut.logger.j.c("UpdateApk->onActivityResult->");
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(DialogInterface dialogInterface, int i4) {
        if (this.f18329a.getPackageManager().canRequestPackageInstalls()) {
            g();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f18329a.getPackageName()));
        intent.setFlags(268435456);
        Context context = this.f18329a;
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            new m.b(fragmentActivity).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.base.util.o
                @Override // m.b.a
                public final void a(int i5, Intent intent2) {
                    InstallUtil.this.d(i5, intent2);
                }
            });
            fragmentActivity.getLifecycle().addObserver(new UpdateActivityObserver());
        }
    }

    private void f() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(this.f18330b), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        this.f18329a.startActivity(intent);
    }

    private void g() {
        if (this.f18332d) {
            return;
        }
        Context context = this.f18329a;
        Uri uriForFile = FileProvider.getUriForFile(context, this.f18329a.getPackageName() + ".provider", this.f18330b);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        this.f18329a.startActivity(intent);
        this.f18332d = true;
    }

    @RequiresApi(api = 26)
    private void h() {
        AlertDialog alertDialog = this.f18331c;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f18331c.dismiss();
        }
        boolean canRequestPackageInstalls = this.f18329a.getPackageManager().canRequestPackageInstalls();
        com.orhanobut.logger.j.c("startInstallO->isGranted=" + canRequestPackageInstalls);
        g();
        if (canRequestPackageInstalls) {
            g();
            return;
        }
        AlertDialog show = new AlertDialog.Builder(this.f18329a).setCancelable(false).setTitle("\u5b89\u88c5\u5e94\u7528\u9700\u8981\u6253\u5f00\u672a\u77e5\u6765\u6e90\u6743\u9650\uff0c\u8bf7\u53bb\u8bbe\u7f6e\u4e2d\u5f00\u542f\u6743\u9650").setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                InstallUtil.this.e(dialogInterface, i4);
            }
        }).show();
        this.f18331c = show;
        Button button = show.getButton(-2);
        BaseApp b4 = BaseApp.b();
        int i4 = R.color.cardBlue;
        button.setTextColor(b4.getColor(i4));
        this.f18331c.getButton(-1).setTextColor(BaseApp.b().getColor(i4));
    }

    public void c() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            g();
        } else if (i4 >= 26) {
            h();
        } else if (i4 >= 24) {
            g();
        } else {
            f();
        }
    }
}
