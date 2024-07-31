package com.bxkj.student.common.versionupdate;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.content.FileProvider;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.InstallUtil;
import com.bxkj.student.common.download.C4238a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p635q.MainApiService;
import p640rx.Subscription;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.bxkj.student.common.versionupdate.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VersionUpdate {

    /* renamed from: a */
    private Context f16266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpdate.java */
    /* renamed from: com.bxkj.student.common.versionupdate.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4265a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ InterfaceC4268d f16267a;

        C4265a(final InterfaceC4268d val$versionUpdateListener) {
            this.f16267a = val$versionUpdateListener;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            ex.printStackTrace();
            InterfaceC4268d interfaceC4268d = this.f16267a;
            if (interfaceC4268d != null) {
                interfaceC4268d.mo38645b();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            InterfaceC4268d interfaceC4268d = this.f16267a;
            if (interfaceC4268d != null) {
                interfaceC4268d.mo38646a(false, TsnSecret.f13210a.getVersionName(VersionUpdate.this.f16266a), "", "");
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "versions");
            String string = JsonParse.getString(data, "versionsName");
            String string2 = JsonParse.getString(data, "instruction");
            String string3 = JsonParse.getString(data, TTDownloadField.TT_FILE_PATH);
            TsnSecret tsnSecret = TsnSecret.f13210a;
            if (i > tsnSecret.getVersionCode(VersionUpdate.this.f16266a)) {
                InterfaceC4268d interfaceC4268d = this.f16267a;
                if (interfaceC4268d != null) {
                    interfaceC4268d.mo38646a(true, string, string3, string2);
                    return;
                }
                return;
            }
            InterfaceC4268d interfaceC4268d2 = this.f16267a;
            if (interfaceC4268d2 != null) {
                interfaceC4268d2.mo38646a(false, tsnSecret.getVersionName(VersionUpdate.this.f16266a), string3, string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpdate.java */
    /* renamed from: com.bxkj.student.common.versionupdate.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4266b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f16269a;

        /* renamed from: b */
        final /* synthetic */ String f16270b;

        View$OnClickListenerC4266b(final String val$downLoadUrl, final String val$versionName) {
            this.f16269a = val$downLoadUrl;
            this.f16270b = val$versionName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VersionUpdate versionUpdate = VersionUpdate.this;
            String str = this.f16269a;
            versionUpdate.m42764c(str, BaseApp.m44341b().getString(2131820604) + "_" + this.f16270b + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpdate.java */
    /* renamed from: com.bxkj.student.common.versionupdate.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4267c implements C4238a.InterfaceC4242d {

        /* renamed from: a */
        final /* synthetic */ ProgressDialog f16272a;

        C4267c(final ProgressDialog val$progressDialog) {
            this.f16272a = val$progressDialog;
        }

        /* renamed from: c */
        private int m42760c(long bt) {
            return Math.round((float) (bt / 1024));
        }

        /* renamed from: f */
        private void m42757f(File apkFile) {
            Uri fromFile;
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                new ProcessBuilder("chmod", "777", apkFile.toString()).start();
            } catch (IOException unused) {
            }
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(VersionUpdate.this.f16266a, "com.bxkj.student.provider", apkFile);
                intent.addFlags(1);
            } else {
                fromFile = Uri.fromFile(apkFile);
            }
            C11792j.m20470c("uri.getPath()=" + fromFile.getPath());
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            VersionUpdate.this.f16266a.startActivity(intent);
            AppManager.m57776n().m57780j();
        }

        /* renamed from: g */
        private void m42756g(File file) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            VersionUpdate.this.f16266a.startActivity(intent);
        }

        @Override // com.bxkj.student.common.download.C4238a.InterfaceC4242d
        /* renamed from: a */
        public void mo42762a(final File file) {
            C11792j.m20470c("下载完成");
            this.f16272a.dismiss();
            new InstallUtil(VersionUpdate.this.f16266a, file).m44148c();
        }

        @Override // com.bxkj.student.common.download.C4238a.InterfaceC4242d
        /* renamed from: b */
        public void mo42761b(final long totalSize, final long bytesWritten, final int progress) {
            this.f16272a.show();
            this.f16272a.setProgressNumberFormat("%1d M/%2d M");
            this.f16272a.setMax(m42759d(totalSize));
            this.f16272a.setProgress(m42759d(bytesWritten));
        }

        /* renamed from: d */
        public int m42759d(long bt) {
            return Math.round(Math.round((((float) bt) / 1048576) * 100.0f) / 100.0f);
        }

        /* renamed from: e */
        public String m42758e(long size) {
            if (size >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                return String.format("%.1f GB", Float.valueOf(((float) size) / ((float) IjkMediaMeta.AV_CH_STEREO_RIGHT)));
            }
            if (size >= 1048576) {
                float f = ((float) size) / ((float) 1048576);
                return String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f));
            } else if (size >= 1024) {
                float f2 = ((float) size) / ((float) 1024);
                return String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f2));
            } else {
                return String.format("%d B", Long.valueOf(size));
            }
        }

        @Override // com.bxkj.student.common.download.C4238a.InterfaceC4242d
        public void onDownloadFailed() {
            C11792j.m20470c("下载失败");
            this.f16272a.dismiss();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student"));
            VersionUpdate.this.f16266a.startActivity(intent);
        }
    }

    /* compiled from: VersionUpdate.java */
    /* renamed from: com.bxkj.student.common.versionupdate.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC4268d {
        /* renamed from: a */
        void mo38646a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction);

        /* renamed from: b */
        void mo38645b();
    }

    public VersionUpdate(Context mcContext) {
        this.f16266a = mcContext;
    }

    /* renamed from: b */
    public Subscription m42765b(final InterfaceC4268d versionUpdateListener) {
        return Http.with(this.f16266a).setCanCancel(false).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2275b(LoginUser.getLoginUser().getSchoolId(), TsnSecret.f13210a.getSignatureMD5(this.f16266a))).setDataListener(new C4265a(versionUpdateListener));
    }

    /* renamed from: c */
    public void m42764c(String downLoadUrl, String fileName) {
        ProgressDialog progressDialog = new ProgressDialog(this.f16266a);
        progressDialog.setTitle("正在下载...");
        progressDialog.setProgressStyle(1);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);
        C4238a.m42909f().m42910e(downLoadUrl, fileName, new C4267c(progressDialog));
    }

    /* renamed from: d */
    public Dialog m42763d(String versionName, final String downLoadUrl, String instruction) {
        iOSOneButtonDialog title = new iOSOneButtonDialog(this.f16266a).setTitle("提示");
        iOSOneButtonDialog buttonOnClickListener = title.setMessage("检测到新版本" + versionName + "请升级\n" + instruction).setOneButtonText("升级").setMessageGrivity(3).setButtonOnClickListener(new View$OnClickListenerC4266b(downLoadUrl, versionName));
        buttonOnClickListener.setClickAutoCancel(false);
        buttonOnClickListener.setCancelable(false);
        buttonOnClickListener.show();
        return buttonOnClickListener;
    }
}
