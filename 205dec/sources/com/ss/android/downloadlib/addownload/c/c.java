package com.ss.android.downloadlib.addownload.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.w;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.downloadlib.ev;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f48401c = "c";

    /* renamed from: w  reason: collision with root package name */
    private static c f48402w;

    /* renamed from: f  reason: collision with root package name */
    private w f48403f;
    private boolean sr = false;
    private String ux;
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.w.c> xv;

    /* renamed from: com.ss.android.downloadlib.addownload.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC0941c {
        void c();
    }

    private c() {
        w wVar = new w();
        this.f48403f = wVar;
        this.xv = wVar.c("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static c c() {
        if (f48402w == null) {
            f48402w = new c();
        }
        return f48402w;
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ux = "";
        } else if (TextUtils.equals(this.ux, str)) {
            this.ux = "";
        }
    }

    private boolean c(Activity activity, DownloadInfo downloadInfo, boolean z3, InterfaceC0941c interfaceC0941c) {
        if (downloadInfo == null) {
            try {
                if (this.xv.isEmpty()) {
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z4 = true;
            if (downloadInfo != null && this.xv.isEmpty()) {
                c(activity, new com.ss.android.downloadlib.addownload.w.c(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z3, interfaceC0941c);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.w.c> copyOnWriteArrayList = this.xv;
            ListIterator<com.ss.android.downloadlib.addownload.w.c> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z4 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.w.c previous = listIterator.previous();
                if (previous != null && !a.ux(k.getContext(), previous.sr) && a.c(previous.f48704r)) {
                    if (new File(previous.f48704r).lastModified() >= lastModified) {
                        c(activity, previous, z3, interfaceC0941c);
                    } else {
                        c(activity, new com.ss.android.downloadlib.addownload.w.c(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z3, interfaceC0941c);
                    }
                }
            }
            String str = f48401c;
            com.ss.android.downloadlib.r.k.c(str, "tryShowInstallDialog isShow:" + z4, null);
            return z4;
        }
        return false;
    }

    @MainThread
    public boolean c(Activity activity, boolean z3, InterfaceC0941c interfaceC0941c) {
        if (k.gd().optInt("disable_install_app_dialog") == 1 || this.sr) {
            return false;
        }
        return c(activity, c(activity), z3, interfaceC0941c);
    }

    public void c(Context context, com.ss.android.downloadlib.addownload.w.c cVar, boolean z3, InterfaceC0941c interfaceC0941c) {
        this.xv.clear();
        c(context, cVar, interfaceC0941c, z3);
        this.sr = true;
        ev.c(context).xv();
        this.f48403f.w("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.r.k.c(f48401c, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo c(Context context) {
        long w3;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            w3 = ev.c(context).w();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (k.gd().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j4 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !a.ux(context, downloadInfo2.getPackageName()) && a.c(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= w3 && downloadInfo2.getExtra() != null) {
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

    public void c(long j4, long j5, long j6, String str, String str2, String str3, String str4) {
        for (int i4 = 0; i4 < this.xv.size(); i4++) {
            com.ss.android.downloadlib.addownload.w.c cVar = this.xv.get(i4);
            if (cVar != null && cVar.f48705w == j5) {
                this.xv.set(i4, new com.ss.android.downloadlib.addownload.w.c(j4, j5, j6, str, str2, str3, str4));
                this.f48403f.c("sp_ad_install_back_dialog", "key_uninstalled_list", this.xv);
                return;
            }
        }
        this.xv.add(new com.ss.android.downloadlib.addownload.w.c(j4, j5, j6, str, str2, str3, str4));
        this.f48403f.c("sp_ad_install_back_dialog", "key_uninstalled_list", this.xv);
    }

    private void c(final Context context, final com.ss.android.downloadlib.addownload.w.c cVar, final InterfaceC0941c interfaceC0941c, boolean z3) {
        final com.ss.android.downloadad.api.c.w sr = f.c().sr(cVar.f48705w);
        if (sr == null) {
            com.ss.android.downloadlib.ux.xv.c().c("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.a xv = k.xv();
        w.c c4 = new w.c(context).c(z3 ? "\u5e94\u7528\u5b89\u88c5\u786e\u8ba4" : "\u9000\u51fa\u786e\u8ba4");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(cVar.ux) ? "\u521a\u521a\u4e0b\u8f7d\u7684\u5e94\u7528" : cVar.ux;
        xv.w(c4.w(String.format("%1$s\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u5b89\u88c5\uff1f", objArr)).xv("\u7acb\u5373\u5b89\u88c5").sr(z3 ? "\u6682\u4e0d\u5b89\u88c5" : String.format("\u9000\u51fa%1$s", context.getResources().getString(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().labelRes))).c(false).c(a.c(context, cVar.f48704r)).c(new w.InterfaceC0938w() { // from class: com.ss.android.downloadlib.addownload.c.c.1
            @Override // com.ss.android.download.api.model.w.InterfaceC0938w
            public void c(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.sr.c.c().w("backdialog_install", sr);
                com.ss.android.socialbase.appdownloader.sr.c(context, (int) cVar.f48702c);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.w.InterfaceC0938w
            public void w(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.sr.c.c().w("backdialog_exit", sr);
                InterfaceC0941c interfaceC0941c2 = interfaceC0941c;
                if (interfaceC0941c2 != null) {
                    interfaceC0941c2.c();
                }
                c.this.w("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.w.InterfaceC0938w
            public void xv(DialogInterface dialogInterface) {
                c.this.w("");
            }
        }).c(1).c());
        com.ss.android.downloadlib.sr.c.c().w("backdialog_show", sr);
        this.ux = cVar.sr;
    }

    public boolean c(String str) {
        return TextUtils.equals(this.ux, str);
    }

    public void c(com.ss.android.downloadad.api.c.w wVar) {
        if (k.gd().optInt("enable_open_app_dialog", 0) == 1 && !wVar.xu() && wVar.ia() && Build.VERSION.SDK_INT < 34) {
            wVar.k(true);
            TTDelegateActivity.c(wVar);
        }
    }
}
