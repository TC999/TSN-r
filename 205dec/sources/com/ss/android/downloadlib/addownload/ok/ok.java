package com.ss.android.downloadlib.addownload.ok;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.p;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    private static ok f48579a = null;
    private static final String ok = "ok";
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> bl;
    private a kf;

    /* renamed from: n  reason: collision with root package name */
    private String f48580n;

    /* renamed from: s  reason: collision with root package name */
    private boolean f48581s = false;

    /* renamed from: com.ss.android.downloadlib.addownload.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC0944ok {
        void ok();
    }

    private ok() {
        a aVar = new a();
        this.kf = aVar;
        this.bl = aVar.ok("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static ok ok() {
        if (f48579a == null) {
            f48579a = new ok();
        }
        return f48579a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f48580n = "";
        } else if (TextUtils.equals(this.f48580n, str)) {
            this.f48580n = "";
        }
    }

    private boolean ok(Activity activity, DownloadInfo downloadInfo, boolean z3, InterfaceC0944ok interfaceC0944ok) {
        if (downloadInfo == null) {
            try {
                if (this.bl.isEmpty()) {
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z4 = true;
            if (downloadInfo != null && this.bl.isEmpty()) {
                ok(activity, new com.ss.android.downloadlib.addownload.a.ok(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z3, interfaceC0944ok);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> copyOnWriteArrayList = this.bl;
            ListIterator<com.ss.android.downloadlib.addownload.a.ok> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z4 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.a.ok previous = listIterator.previous();
                if (previous != null && !j.n(r.getContext(), previous.f48378s) && j.ok(previous.f48375h)) {
                    if (new File(previous.f48375h).lastModified() >= lastModified) {
                        ok(activity, previous, z3, interfaceC0944ok);
                    } else {
                        ok(activity, new com.ss.android.downloadlib.addownload.a.ok(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z3, interfaceC0944ok);
                    }
                }
            }
            String str = ok;
            com.ss.android.downloadlib.h.r.ok(str, "tryShowInstallDialog isShow:" + z4, null);
            return z4;
        }
        return false;
    }

    @MainThread
    public boolean ok(Activity activity, boolean z3, InterfaceC0944ok interfaceC0944ok) {
        if (r.q().optInt("disable_install_app_dialog") == 1 || this.f48581s) {
            return false;
        }
        return ok(activity, ok(activity), z3, interfaceC0944ok);
    }

    public void ok(Context context, com.ss.android.downloadlib.addownload.a.ok okVar, boolean z3, InterfaceC0944ok interfaceC0944ok) {
        this.bl.clear();
        ok(context, okVar, interfaceC0944ok, z3);
        this.f48581s = true;
        p.ok(context).bl();
        this.kf.a("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.h.r.ok(ok, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo ok(Context context) {
        long a4;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            a4 = p.ok(context).a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (r.q().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j4 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !j.n(context, downloadInfo2.getPackageName()) && j.ok(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= a4 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j4 == 0 || lastModified > j4)) {
                                downloadInfo = downloadInfo2;
                                j4 = lastModified;
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void ok(long j4, long j5, long j6, String str, String str2, String str3, String str4) {
        for (int i4 = 0; i4 < this.bl.size(); i4++) {
            com.ss.android.downloadlib.addownload.a.ok okVar = this.bl.get(i4);
            if (okVar != null && okVar.f48374a == j5) {
                this.bl.set(i4, new com.ss.android.downloadlib.addownload.a.ok(j4, j5, j6, str, str2, str3, str4));
                this.kf.ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.bl);
                return;
            }
        }
        this.bl.add(new com.ss.android.downloadlib.addownload.a.ok(j4, j5, j6, str, str2, str3, str4));
        this.kf.ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.bl);
    }

    private void ok(final Context context, final com.ss.android.downloadlib.addownload.a.ok okVar, final InterfaceC0944ok interfaceC0944ok, boolean z3) {
        final com.ss.android.downloadad.api.ok.a s3 = kf.ok().s(okVar.f48374a);
        if (s3 == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.j bl = r.bl();
        a.ok ok2 = new a.ok(context).ok(z3 ? "\u5e94\u7528\u5b89\u88c5\u786e\u8ba4" : "\u9000\u51fa\u786e\u8ba4");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(okVar.f48376n) ? "\u521a\u521a\u4e0b\u8f7d\u7684\u5e94\u7528" : okVar.f48376n;
        bl.a(ok2.a(String.format("%1$s\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u5b89\u88c5\uff1f", objArr)).bl("\u7acb\u5373\u5b89\u88c5").s(z3 ? "\u6682\u4e0d\u5b89\u88c5" : String.format("\u9000\u51fa%1$s", context.getResources().getString(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().labelRes))).ok(false).ok(j.ok(context, okVar.f48375h)).ok(new a.InterfaceC0935a() { // from class: com.ss.android.downloadlib.addownload.ok.ok.1
            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("backdialog_exit", s3);
                InterfaceC0944ok interfaceC0944ok2 = interfaceC0944ok;
                if (interfaceC0944ok2 != null) {
                    interfaceC0944ok2.ok();
                }
                ok.this.a("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void bl(DialogInterface dialogInterface) {
                ok.this.a("");
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void ok(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("backdialog_install", s3);
                com.ss.android.socialbase.appdownloader.s.ok(context, (int) okVar.ok);
                dialogInterface.dismiss();
            }
        }).ok(1).ok());
        com.ss.android.downloadlib.s.ok.ok().a("backdialog_show", s3);
        this.f48580n = okVar.f48378s;
    }

    public boolean ok(String str) {
        return TextUtils.equals(this.f48580n, str);
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (r.q().optInt("enable_open_app_dialog", 0) == 1 && !aVar.cf() && aVar.x() && Build.VERSION.SDK_INT < 34) {
            aVar.r(true);
            TTDelegateActivity.ok(aVar);
        }
    }
}
