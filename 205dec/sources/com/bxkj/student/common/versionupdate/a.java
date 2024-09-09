package com.bxkj.student.common.versionupdate;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.content.FileProvider;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.InstallUtil;
import com.bxkj.student.common.download.a;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p.f;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: VersionUpdate.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f19668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VersionUpdate.java */
    /* renamed from: com.bxkj.student.common.versionupdate.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class C0217a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f19669a;

        C0217a(final d val$versionUpdateListener) {
            this.f19669a = val$versionUpdateListener;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            ex.printStackTrace();
            d dVar = this.f19669a;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            d dVar = this.f19669a;
            if (dVar != null) {
                dVar.a(false, TsnSecret.f16433a.getVersionName(a.this.f19668a), "", "");
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = JsonParse.getInt(data, "versions");
            String string = JsonParse.getString(data, "versionsName");
            String string2 = JsonParse.getString(data, "instruction");
            String string3 = JsonParse.getString(data, "filePath");
            TsnSecret tsnSecret = TsnSecret.f16433a;
            if (i4 > tsnSecret.getVersionCode(a.this.f19668a)) {
                d dVar = this.f19669a;
                if (dVar != null) {
                    dVar.a(true, string, string3, string2);
                    return;
                }
                return;
            }
            d dVar2 = this.f19669a;
            if (dVar2 != null) {
                dVar2.a(false, tsnSecret.getVersionName(a.this.f19668a), string3, string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VersionUpdate.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19671a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19672b;

        b(final String val$downLoadUrl, final String val$versionName) {
            this.f19671a = val$downLoadUrl;
            this.f19672b = val$versionName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            a aVar = a.this;
            String str = this.f19671a;
            aVar.c(str, BaseApp.b().getString(2131820604) + "_" + this.f19672b + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VersionUpdate.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f19674a;

        c(final ProgressDialog val$progressDialog) {
            this.f19674a = val$progressDialog;
        }

        private int c(long bt) {
            return Math.round((float) (bt / 1024));
        }

        private void f(File apkFile) {
            Uri fromFile;
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                new ProcessBuilder("chmod", "777", apkFile.toString()).start();
            } catch (IOException unused) {
            }
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(a.this.f19668a, "com.bxkj.student.provider", apkFile);
                intent.addFlags(1);
            } else {
                fromFile = Uri.fromFile(apkFile);
            }
            j.c("uri.getPath()=" + fromFile.getPath());
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            a.this.f19668a.startActivity(intent);
            cn.bluemobi.dylan.base.utils.a.n().j();
        }

        private void g(File file) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            a.this.f19668a.startActivity(intent);
        }

        @Override // com.bxkj.student.common.download.a.d
        public void a(final File file) {
            j.c("\u4e0b\u8f7d\u5b8c\u6210");
            this.f19674a.dismiss();
            new InstallUtil(a.this.f19668a, file).c();
        }

        @Override // com.bxkj.student.common.download.a.d
        public void b(final long totalSize, final long bytesWritten, final int progress) {
            this.f19674a.show();
            this.f19674a.setProgressNumberFormat("%1d M/%2d M");
            this.f19674a.setMax(d(totalSize));
            this.f19674a.setProgress(d(bytesWritten));
        }

        public int d(long bt) {
            return Math.round(Math.round((((float) bt) / 1048576) * 100.0f) / 100.0f);
        }

        public String e(long size) {
            if (size >= 1073741824) {
                return String.format("%.1f GB", Float.valueOf(((float) size) / ((float) 1073741824)));
            }
            if (size >= 1048576) {
                float f4 = ((float) size) / ((float) 1048576);
                return String.format(f4 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f4));
            } else if (size >= 1024) {
                float f5 = ((float) size) / ((float) 1024);
                return String.format(f5 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f5));
            } else {
                return String.format("%d B", Long.valueOf(size));
            }
        }

        @Override // com.bxkj.student.common.download.a.d
        public void onDownloadFailed() {
            j.c("\u4e0b\u8f7d\u5931\u8d25");
            this.f19674a.dismiss();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student"));
            a.this.f19668a.startActivity(intent);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: VersionUpdate.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface d {
        void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction);

        void b();
    }

    public a(Context mcContext) {
        this.f19668a = mcContext;
    }

    public m b(final d versionUpdateListener) {
        return Http.with(this.f19668a).setCanCancel(false).setObservable(((f) Http.getApiService(f.class)).b(LoginUser.getLoginUser().getSchoolId(), TsnSecret.f16433a.getSignatureMD5(this.f19668a))).setDataListener(new C0217a(versionUpdateListener));
    }

    public void c(String downLoadUrl, String fileName) {
        ProgressDialog progressDialog = new ProgressDialog(this.f19668a);
        progressDialog.setTitle("\u6b63\u5728\u4e0b\u8f7d...");
        progressDialog.setProgressStyle(1);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);
        com.bxkj.student.common.download.a.f().e(downLoadUrl, fileName, new c(progressDialog));
    }

    public Dialog d(String versionName, final String downLoadUrl, String instruction) {
        iOSOneButtonDialog title = new iOSOneButtonDialog(this.f19668a).setTitle("\u63d0\u793a");
        iOSOneButtonDialog buttonOnClickListener = title.setMessage("\u68c0\u6d4b\u5230\u65b0\u7248\u672c" + versionName + "\u8bf7\u5347\u7ea7\n" + instruction).setOneButtonText("\u5347\u7ea7").setMessageGrivity(3).setButtonOnClickListener(new b(downLoadUrl, versionName));
        buttonOnClickListener.setClickAutoCancel(false);
        buttonOnClickListener.setCancelable(false);
        buttonOnClickListener.show();
        return buttonOnClickListener;
    }
}
