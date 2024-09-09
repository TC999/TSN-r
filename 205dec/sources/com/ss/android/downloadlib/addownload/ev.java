package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.r.bk;
import com.ss.android.downloadlib.r.p;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev implements bk.c {

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.w.ux f48525c;
    private ux sr;
    private w ux;

    /* renamed from: w  reason: collision with root package name */
    private long f48526w;
    private boolean xv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c extends com.ss.android.socialbase.downloader.depend.c {

        /* renamed from: c  reason: collision with root package name */
        private com.ss.android.downloadlib.r.bk f48532c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(com.ss.android.downloadlib.r.bk bkVar) {
            this.f48532c = bkVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.c, com.ss.android.socialbase.downloader.depend.fz
        public void c(DownloadInfo downloadInfo) {
            c(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            c(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            c(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            c(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            c(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            c(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            c(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            c(downloadInfo, -3);
        }

        private void c(DownloadInfo downloadInfo, int i4) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i4;
            this.f48532c.sendMessage(obtain);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface w {
        void c(DownloadInfo downloadInfo);
    }

    public ev(ux uxVar) {
        this.sr = uxVar;
    }

    private boolean f() {
        return com.ss.android.downloadlib.r.a.c(this.f48525c.f48723w) && gd.c(this.f48525c.sr.getLinkMode());
    }

    private boolean sr() {
        DownloadModel downloadModel = this.f48525c.f48723w;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f48525c.f48723w.getDownloadUrl())) ? false : true;
    }

    private boolean ux() {
        return this.f48525c.sr.isAddToDownloadManage();
    }

    private boolean xv() {
        return sr() && ux();
    }

    @Override // com.ss.android.downloadlib.r.bk.c
    public void c(Message message) {
    }

    public void w(@Nullable DownloadInfo downloadInfo) {
        w wVar = this.ux;
        if (wVar != null) {
            wVar.c(downloadInfo);
            this.ux = null;
        }
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.gd.f.sr(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean ux(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.r.a.c(this.f48525c.f48723w) && f(downloadInfo);
    }

    public void c(long j4) {
        this.f48526w = j4;
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        this.f48525c = ux;
        if (ux.ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("setAdId ModelBox notValid");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv(DownloadInfo downloadInfo) {
        if (!gd.c(this.f48525c.f48723w) || this.xv) {
            return;
        }
        com.ss.android.downloadlib.sr.c.c().c("file_status", (downloadInfo == null || !com.ss.android.downloadlib.r.a.w(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f48525c);
        this.xv = true;
    }

    private void w(final u uVar) {
        if (com.ss.android.downloadlib.r.p.w("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (uVar != null) {
                uVar.c();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!com.ss.android.downloadlib.r.a.c()) {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        } else if (com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_VIDEO")) {
            if (uVar != null) {
                uVar.c();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.r.p.c(new String[]{str}, new p.c() { // from class: com.ss.android.downloadlib.addownload.ev.2
            @Override // com.ss.android.downloadlib.r.p.c
            public void c() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.c();
                }
            }

            @Override // com.ss.android.downloadlib.r.p.c
            public void c(String str2) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.c(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sr(DownloadInfo downloadInfo) {
        return f() || ux(downloadInfo);
    }

    public void c(DownloadInfo downloadInfo) {
        this.xv = false;
        w(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Context context, int i4, boolean z3) {
        if (com.ss.android.downloadlib.r.a.c(this.f48525c.f48723w)) {
            com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(this.f48525c.f48722c);
            if (sr != null) {
                com.ss.android.socialbase.downloader.notification.w.c().f(sr.fz());
            }
            return com.ss.android.downloadlib.w.c.c(this.f48525c);
        } else if (c(i4) && !TextUtils.isEmpty(this.f48525c.f48723w.getPackageName()) && k.gd().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.w.c.c(this.f48525c, i4)) {
                return true;
            }
            return this.sr.gd() && this.sr.sr(true);
        } else if (z3 && this.f48525c.sr.getDownloadMode() == 4 && !this.sr.ux()) {
            this.sr.xv(true);
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    public String w() {
        File externalFilesDir = k.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.c> w(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.c) {
                    arrayList.add((com.ss.android.download.api.download.c) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c) {
                            arrayList.add((com.ss.android.download.api.download.c) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.c) {
                            arrayList.add((com.ss.android.download.api.download.c) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean c(int i4) {
        if (this.f48525c.sr.getDownloadMode() == 2 && i4 == 2) {
            return true;
        }
        return this.f48525c.sr.getDownloadMode() == 2 && i4 == 1 && k.gd().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean c(int i4, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.f.ux.xv() && c(i4) && !com.ss.android.downloadlib.r.a.c(downloadModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(boolean z3) {
        return !z3 && this.f48525c.sr.getDownloadMode() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@NonNull final u uVar) {
        if (!TextUtils.isEmpty(this.f48525c.f48723w.getFilePath())) {
            String filePath = this.f48525c.f48723w.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                uVar.c();
                return;
            }
            try {
                if (filePath.startsWith(k.getContext().getExternalCacheDir().getParent())) {
                    uVar.c();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        w(new u() { // from class: com.ss.android.downloadlib.addownload.ev.1
            @Override // com.ss.android.download.api.config.u
            public void c() {
                uVar.c();
            }

            @Override // com.ss.android.download.api.config.u
            public void c(String str) {
                k.xv().c(1, k.getContext(), ev.this.f48525c.f48723w, "\u60a8\u5df2\u7981\u6b62\u4f7f\u7528\u5b58\u50a8\u6743\u9650\uff0c\u8bf7\u6388\u6743\u540e\u518d\u4e0b\u8f7d", null, 1);
                com.ss.android.downloadlib.sr.c.c().w(ev.this.f48526w, 1);
                uVar.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        w wVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i4 = message.arg1;
        if (i4 != 1 && i4 != 6 && i4 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.r c4 = com.ss.android.downloadlib.r.c();
                com.ss.android.downloadlib.addownload.w.ux uxVar = this.f48525c;
                c4.c(uxVar.f48723w, uxVar.sr, uxVar.xv);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.sr.c.c().c(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        p.c(downloadShortInfo);
        int c5 = com.ss.android.socialbase.appdownloader.xv.c(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.r.c.xv().c("fix_click_start")) && (wVar = this.ux) != null) {
            wVar.c(downloadInfo);
            this.ux = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : c(map)) {
            if (c5 != 1) {
                if (c5 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, p.c(downloadInfo.getId(), curBytes));
                } else if (c5 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.r.a.c(this.f48525c.f48723w)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, p.c(downloadInfo.getId(), curBytes));
            } else {
                for (com.ss.android.download.api.download.c cVar : w(map)) {
                    cVar.c(downloadInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.ux == null) {
            this.ux = new w() { // from class: com.ss.android.downloadlib.addownload.ev.3
                @Override // com.ss.android.downloadlib.addownload.ev.w
                public void c(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.sr.c.c().c(ev.this.f48526w, 2, downloadInfo);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.socialbase.downloader.model.xv c4;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f48525c.f48723w.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (k.gd().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f48525c.f48723w.getLogExtra()) && (c4 = c(this.f48525c.f48723w.getLogExtra())) != null) {
            arrayList.add(c4);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.xv(entry.getKey(), entry.getValue()));
                }
            }
        }
        String c5 = com.ss.android.downloadlib.r.sr.c(String.valueOf(this.f48525c.f48723w.getId()), this.f48525c.f48723w.getNotificationJumpUrl(), this.f48525c.f48723w.isShowToast(), String.valueOf(this.f48525c.f48723w.getModelType()));
        com.ss.android.socialbase.downloader.r.c w3 = com.ss.android.downloadlib.r.ux.w(this.f48525c.f48723w);
        JSONObject c6 = com.ss.android.downloadlib.r.ux.c(this.f48525c.f48723w);
        if (!this.f48525c.sr.enableAH()) {
            c6 = com.ss.android.downloadlib.r.a.c(c6);
            com.ss.android.downloadlib.r.a.c(c6, "ah_plans", new JSONArray());
        }
        this.f48525c.f48723w.getExecutorGroup();
        int i4 = (this.f48525c.f48723w.isAd() || gd.w(this.f48525c.f48723w)) ? 4 : 4;
        String c7 = c(w3);
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.xv.c(this.f48525c.f48723w.getDownloadUrl(), c7));
        if (downloadInfo != null && 3 == this.f48525c.f48723w.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f ys = new com.ss.android.socialbase.appdownloader.f(context, this.f48525c.f48723w.getDownloadUrl()).w(this.f48525c.f48723w.getBackupUrls()).c(this.f48525c.f48723w.getName()).ux(c5).c(arrayList).c(this.f48525c.f48723w.isShowNotification()).xv(this.f48525c.f48723w.isNeedWifi()).w(this.f48525c.f48723w.getFileName()).xv(c7).k(this.f48525c.f48723w.getAppIcon()).ev(this.f48525c.f48723w.getMd5()).p(this.f48525c.f48723w.getSdkMonitorScene()).c(this.f48525c.f48723w.getExpectFileLength()).c(iDownloadListener).a(this.f48525c.f48723w.needIndependentProcess() || w3.c("need_independent_process", 0) == 1).c(this.f48525c.f48723w.getDownloadFileUriProvider()).w(this.f48525c.f48723w.autoInstallWithoutNotification()).r(this.f48525c.f48723w.getPackageName()).sr(1000).ux(100).c(c6).gd(true).p(true).w(w3.c("retry_count", 5)).xv(w3.c("backup_url_retry_count", 0)).p(true).bk(w3.c("need_head_connection", 0) == 1).sr(w3.c("need_https_to_http_retry", 0) == 1).ev(w3.c("need_chunk_downgrade_retry", 1) == 1).r(w3.c("need_retry_delay", 0) == 1).gd(w3.xv("retry_delay_time_array")).k(w3.c("need_reuse_runnable", 0) == 1).f(i4).fp(this.f48525c.f48723w.isAutoInstall()).ys(this.f48525c.f48723w.distinctDir());
        if (!TextUtils.isEmpty(this.f48525c.f48723w.getMimeType())) {
            ys.f(this.f48525c.f48723w.getMimeType());
        } else {
            ys.f("application/vnd.android.package-archive");
        }
        if (w3.c("notification_opt_2", 0) == 1) {
            ys.c(false);
            ys.w(true);
        }
        com.ss.android.downloadlib.addownload.xv.c cVar = null;
        if (w3.c("clear_space_use_disk_handler", 0) == 1) {
            cVar = new com.ss.android.downloadlib.addownload.xv.c();
            ys.c((com.ss.android.socialbase.downloader.depend.s) cVar);
        }
        DownloadModel downloadModel = this.f48525c.f48723w;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            ys.sr(((AdDownloadModel) this.f48525c.f48723w).getTaskKey());
        }
        int c8 = gd.c(this.f48525c, xv(), ys);
        if (cVar != null) {
            cVar.c(c8);
        }
        return c8;
    }

    private String c(com.ss.android.socialbase.downloader.r.c cVar) {
        boolean z3;
        if (!TextUtils.isEmpty(this.f48525c.f48723w.getFilePath())) {
            return this.f48525c.f48723w.getFilePath();
        }
        DownloadInfo c4 = com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), this.f48525c.f48723w.getDownloadUrl());
        if (!com.ss.android.downloadlib.r.a.c()) {
            z3 = com.ss.android.downloadlib.r.p.w("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            z3 = com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_VIDEO");
        }
        String w3 = w();
        if (c4 != null && !TextUtils.isEmpty(c4.getSavePath())) {
            String savePath = c4.getSavePath();
            if (z3 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(w3)) {
                    if (savePath.startsWith(w3)) {
                        return savePath;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).cancel(c4.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z3 ? 1 : 2));
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("label_external_permission", jSONObject, this.f48525c);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.xv.w();
        } catch (Exception unused) {
        }
        int c5 = com.ss.android.downloadlib.r.ux.c(cVar);
        if (c5 != 0) {
            if (c5 != 4 && (z3 || c5 != 2)) {
                if ((c5 == 3 || (!z3 && c5 == 1)) && !TextUtils.isEmpty(w3)) {
                    return w3;
                }
            } else {
                File filesDir = k.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(DownloadInfo downloadInfo, boolean z3) {
        if (this.f48525c.f48723w == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (gd.c(this.f48525c.f48723w)) {
                com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 2);
            } else if (z3 && com.ss.android.downloadlib.sr.xv.c().xv() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 2);
            }
        } else {
            com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 2);
        }
        switch (status) {
            case -4:
            case -1:
                c();
                com.ss.android.downloadlib.addownload.w.f c4 = com.ss.android.downloadlib.addownload.w.f.c();
                com.ss.android.downloadlib.addownload.w.ux uxVar = this.f48525c;
                c4.c(new com.ss.android.downloadad.api.c.w(uxVar.f48723w, uxVar.xv, uxVar.sr, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.r.a.c(this.f48525c.f48723w)) {
                    com.ss.android.downloadlib.ux.xv.c().w("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 5, downloadInfo);
                if (z3 && com.ss.android.downloadlib.sr.xv.c().w() && !com.ss.android.downloadlib.sr.xv.c().w(this.f48526w, this.f48525c.f48723w.getLogExtra())) {
                    com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 4, downloadInfo);
                if (z3 && com.ss.android.downloadlib.sr.xv.c().w() && !com.ss.android.downloadlib.sr.xv.c().w(this.f48526w, this.f48525c.f48723w.getLogExtra())) {
                    com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.sr.c.c().c(this.f48526w, 3, downloadInfo);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            if (r7 == 0) goto La8
            if (r8 != 0) goto Ld
            goto La8
        Ld:
            r0 = 0
            long r1 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2b
            long r1 = r7.getCurBytes()     // Catch: java.lang.Exception -> L27
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2c
        L27:
            r1 = move-exception
            r1.printStackTrace()
        L2b:
            r2 = 0
        L2c:
            if (r2 >= 0) goto L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            r8.updateFromNewDownloadInfo(r7)
            com.ss.android.downloadlib.addownload.p.c(r8)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto La7
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L92;
                case -3: goto L80;
                case -2: goto L74;
                case -1: goto L70;
                case 0: goto L92;
                case 1: goto L64;
                case 2: goto L64;
                case 3: goto L64;
                case 4: goto L64;
                case 5: goto L64;
                case 6: goto L4d;
                case 7: goto L64;
                case 8: goto L64;
                case 9: goto L4d;
                case 10: goto L4d;
                case 11: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L3a
        L4e:
            boolean r2 = r1 instanceof com.ss.android.download.api.download.c
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.c r1 = (com.ss.android.download.api.download.c) r1
            r1.c(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.p.c(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.p.c(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.p.c(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.w.ux r2 = r6.f48525c
            com.ss.android.download.api.download.DownloadModel r2 = r2.f48723w
            boolean r2 = com.ss.android.downloadlib.r.a.c(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.w.ux r2 = r6.f48525c
            com.ss.android.download.api.download.DownloadModel r2 = r2.f48723w
            boolean r2 = com.ss.android.downloadlib.r.a.c(r2)
            if (r2 == 0) goto La3
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3a
        La3:
            r1.onIdle()
            goto L3a
        La7:
            return
        La8:
            java.util.Iterator r7 = r9.iterator()
        Lac:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lbc
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto Lac
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ev.c(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> c(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.xv c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.xv("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e4) {
            k.u().c(e4, "parseLogExtra Error");
            return null;
        }
    }
}
