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
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.z;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p implements z.ok {

    /* renamed from: a  reason: collision with root package name */
    private long f48585a;
    private boolean bl = false;

    /* renamed from: n  reason: collision with root package name */
    private a f48586n;
    public com.ss.android.downloadlib.addownload.a.n ok;

    /* renamed from: s  reason: collision with root package name */
    private n f48587s;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void ok(DownloadInfo downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok extends com.ss.android.socialbase.downloader.depend.ok {
        private com.ss.android.downloadlib.h.z ok;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ok(com.ss.android.downloadlib.h.z zVar) {
            this.ok = zVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ok, com.ss.android.socialbase.downloader.depend.zz
        public void ok(DownloadInfo downloadInfo) {
            ok(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            ok(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            ok(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            ok(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            ok(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            ok(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            ok(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            ok(downloadInfo, -3);
        }

        private void ok(DownloadInfo downloadInfo, int i4) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i4;
            this.ok.sendMessage(obtain);
        }
    }

    public p(n nVar) {
        this.f48587s = nVar;
    }

    private boolean bl() {
        return s() && n();
    }

    private boolean kf() {
        return com.ss.android.downloadlib.h.j.ok(this.ok.f48371a) && q.ok(this.ok.f48373s.getLinkMode());
    }

    private boolean n() {
        return this.ok.f48373s.isAddToDownloadManage();
    }

    private boolean s() {
        DownloadModel downloadModel = this.ok.f48371a;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.ok.f48371a.getDownloadUrl())) ? false : true;
    }

    public void a(@Nullable DownloadInfo downloadInfo) {
        a aVar = this.f48586n;
        if (aVar != null) {
            aVar.ok(downloadInfo);
            this.f48586n = null;
        }
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
    }

    private boolean kf(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.q.kf.s(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean n(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.h.j.ok(this.ok.f48371a) && kf(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bl(DownloadInfo downloadInfo) {
        if (!q.ok(this.ok.f48371a) || this.bl) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok("file_status", (downloadInfo == null || !com.ss.android.downloadlib.h.j.a(downloadInfo.getTargetFilePath())) ? 2 : 1, this.ok);
        this.bl = true;
    }

    public void ok(long j4) {
        this.f48585a = j4;
        com.ss.android.downloadlib.addownload.a.n n4 = com.ss.android.downloadlib.addownload.a.kf.ok().n(j4);
        this.ok = n4;
        if (n4.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("setAdId ModelBox notValid");
        }
    }

    private void a(final u uVar) {
        if (com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (uVar != null) {
                uVar.ok();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!com.ss.android.downloadlib.h.j.ok()) {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        } else if (com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO")) {
            if (uVar != null) {
                uVar.ok();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.h.k.ok(new String[]{str}, new k.ok() { // from class: com.ss.android.downloadlib.addownload.p.2
            @Override // com.ss.android.downloadlib.h.k.ok
            public void ok() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.ok();
                }
            }

            @Override // com.ss.android.downloadlib.h.k.ok
            public void ok(String str2) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.ok(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(DownloadInfo downloadInfo) {
        return kf() || n(downloadInfo);
    }

    public void ok(DownloadInfo downloadInfo) {
        this.bl = false;
        a(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ok(Context context, int i4, boolean z3) {
        if (com.ss.android.downloadlib.h.j.ok(this.ok.f48371a)) {
            com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(this.ok.ok);
            if (s3 != null) {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(s3.zz());
            }
            return com.ss.android.downloadlib.a.ok.ok(this.ok);
        } else if (ok(i4) && !TextUtils.isEmpty(this.ok.f48371a.getPackageName()) && r.q().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.a.ok.ok(this.ok, i4)) {
                return true;
            }
            return this.f48587s.q() && this.f48587s.s(true);
        } else if (z3 && this.ok.f48373s.getDownloadMode() == 4 && !this.f48587s.n()) {
            this.f48587s.bl(true);
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    public String a() {
        File externalFilesDir = r.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
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
    public static List<com.ss.android.download.api.download.ok> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.ok) {
                    arrayList.add((com.ss.android.download.api.download.ok) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok) {
                            arrayList.add((com.ss.android.download.api.download.ok) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.ok) {
                            arrayList.add((com.ss.android.download.api.download.ok) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean ok(int i4) {
        if (this.ok.f48373s.getDownloadMode() == 2 && i4 == 2) {
            return true;
        }
        return this.ok.f48373s.getDownloadMode() == 2 && i4 == 1 && r.q().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean ok(int i4, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.kf.n.bl() && ok(i4) && !com.ss.android.downloadlib.h.j.ok(downloadModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ok(boolean z3) {
        return !z3 && this.ok.f48373s.getDownloadMode() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(@NonNull final u uVar) {
        if (!TextUtils.isEmpty(this.ok.f48371a.getFilePath())) {
            String filePath = this.ok.f48371a.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                uVar.ok();
                return;
            }
            try {
                if (filePath.startsWith(r.getContext().getExternalCacheDir().getParent())) {
                    uVar.ok();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        a(new u() { // from class: com.ss.android.downloadlib.addownload.p.1
            public void ok() {
                uVar.ok();
            }

            public void ok(String str) {
                r.bl().ok(1, r.getContext(), p.this.ok.f48371a, "\u60a8\u5df2\u7981\u6b62\u4f7f\u7528\u5b58\u50a8\u6743\u9650\uff0c\u8bf7\u6388\u6743\u540e\u518d\u4e0b\u8f7d", null, 1);
                com.ss.android.downloadlib.s.ok.ok().a(p.this.f48585a, 1);
                uVar.ok(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        a aVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i4 = message.arg1;
        if (i4 != 1 && i4 != 6 && i4 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.h ok2 = com.ss.android.downloadlib.h.ok();
                com.ss.android.downloadlib.addownload.a.n nVar = this.ok;
                ok2.ok(nVar.f48371a, nVar.f48373s, nVar.bl);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.s.ok.ok().ok(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        k.ok(downloadShortInfo);
        int ok3 = com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) && (aVar = this.f48586n) != null) {
            aVar.ok(downloadInfo);
            this.f48586n = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : ok(map)) {
            if (ok3 != 1) {
                if (ok3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, k.ok(downloadInfo.getId(), curBytes));
                } else if (ok3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.h.j.ok(this.ok.f48371a)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, k.ok(downloadInfo.getId(), curBytes));
            } else {
                for (com.ss.android.download.api.download.ok okVar : a(map)) {
                    okVar.ok(downloadInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok() {
        if (this.f48586n == null) {
            this.f48586n = new a() { // from class: com.ss.android.downloadlib.addownload.p.3
                @Override // com.ss.android.downloadlib.addownload.p.a
                public void ok(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.s.ok.ok().ok(p.this.f48585a, 2, downloadInfo);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ok(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.socialbase.downloader.model.bl ok2;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.ok.f48371a.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (r.q().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.ok.f48371a.getLogExtra()) && (ok2 = ok(this.ok.f48371a.getLogExtra())) != null) {
            arrayList.add(ok2);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.bl(entry.getKey(), entry.getValue()));
                }
            }
        }
        String ok3 = com.ss.android.downloadlib.h.s.ok(String.valueOf(this.ok.f48371a.getId()), this.ok.f48371a.getNotificationJumpUrl(), this.ok.f48371a.isShowToast(), String.valueOf(this.ok.f48371a.getModelType()));
        com.ss.android.socialbase.downloader.h.ok a4 = com.ss.android.downloadlib.h.n.a(this.ok.f48371a);
        JSONObject ok4 = com.ss.android.downloadlib.h.n.ok(this.ok.f48371a);
        if (!this.ok.f48373s.enableAH()) {
            ok4 = com.ss.android.downloadlib.h.j.ok(ok4);
            com.ss.android.downloadlib.h.j.ok(ok4, "ah_plans", new JSONArray());
        }
        this.ok.f48371a.getExecutorGroup();
        int i4 = (this.ok.f48371a.isAd() || q.a(this.ok.f48371a)) ? 4 : 4;
        String ok5 = ok(a4);
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.bl.ok(this.ok.f48371a.getDownloadUrl(), ok5));
        if (downloadInfo != null && 3 == this.ok.f48371a.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.kf t3 = new com.ss.android.socialbase.appdownloader.kf(context, this.ok.f48371a.getDownloadUrl()).a(this.ok.f48371a.getBackupUrls()).ok(this.ok.f48371a.getName()).n(ok3).ok(arrayList).ok(this.ok.f48371a.isShowNotification()).bl(this.ok.f48371a.isNeedWifi()).a(this.ok.f48371a.getFileName()).bl(ok5).r(this.ok.f48371a.getAppIcon()).p(this.ok.f48371a.getMd5()).k(this.ok.f48371a.getSdkMonitorScene()).ok(this.ok.f48371a.getExpectFileLength()).ok(iDownloadListener).j(this.ok.f48371a.needIndependentProcess() || a4.ok("need_independent_process", 0) == 1).ok(this.ok.f48371a.getDownloadFileUriProvider()).a(this.ok.f48371a.autoInstallWithoutNotification()).h(this.ok.f48371a.getPackageName()).s(1000).n(100).ok(ok4).q(true).k(true).a(a4.ok("retry_count", 5)).bl(a4.ok("backup_url_retry_count", 0)).k(true).z(a4.ok("need_head_connection", 0) == 1).s(a4.ok("need_https_to_http_retry", 0) == 1).p(a4.ok("need_chunk_downgrade_retry", 1) == 1).h(a4.ok("need_retry_delay", 0) == 1).q(a4.bl("retry_delay_time_array")).r(a4.ok("need_reuse_runnable", 0) == 1).kf(i4).i(this.ok.f48371a.isAutoInstall()).t(this.ok.f48371a.distinctDir());
        if (!TextUtils.isEmpty(this.ok.f48371a.getMimeType())) {
            t3.kf(this.ok.f48371a.getMimeType());
        } else {
            t3.kf("application/vnd.android.package-archive");
        }
        if (a4.ok("notification_opt_2", 0) == 1) {
            t3.ok(false);
            t3.a(true);
        }
        com.ss.android.downloadlib.addownload.bl.ok okVar = null;
        if (a4.ok("clear_space_use_disk_handler", 0) == 1) {
            okVar = new com.ss.android.downloadlib.addownload.bl.ok();
            t3.ok(okVar);
        }
        DownloadModel downloadModel = this.ok.f48371a;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            t3.s(((AdDownloadModel) this.ok.f48371a).getTaskKey());
        }
        int ok6 = q.ok(this.ok, bl(), t3);
        if (okVar != null) {
            okVar.ok(ok6);
        }
        return ok6;
    }

    private String ok(com.ss.android.socialbase.downloader.h.ok okVar) {
        boolean z3;
        if (!TextUtils.isEmpty(this.ok.f48371a.getFilePath())) {
            return this.ok.f48371a.getFilePath();
        }
        DownloadInfo ok2 = com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), this.ok.f48371a.getDownloadUrl());
        if (!com.ss.android.downloadlib.h.j.ok()) {
            z3 = com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            z3 = com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO");
        }
        String a4 = a();
        if (ok2 != null && !TextUtils.isEmpty(ok2.getSavePath())) {
            String savePath = ok2.getSavePath();
            if (z3 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(a4)) {
                    if (savePath.startsWith(a4)) {
                        return savePath;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(ok2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z3 ? 1 : 2));
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("label_external_permission", jSONObject, this.ok);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.bl.a();
        } catch (Exception unused) {
        }
        int ok3 = com.ss.android.downloadlib.h.n.ok(okVar);
        if (ok3 != 0) {
            if (ok3 != 4 && (z3 || ok3 != 2)) {
                if ((ok3 == 3 || (!z3 && ok3 == 1)) && !TextUtils.isEmpty(a4)) {
                    return a4;
                }
            } else {
                File filesDir = r.getContext().getFilesDir();
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
    public void ok(DownloadInfo downloadInfo, boolean z3) {
        if (this.ok.f48371a == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (q.ok(this.ok.f48371a)) {
                com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 2);
            } else if (z3 && com.ss.android.downloadlib.s.bl.ok().bl() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 2);
            }
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                ok();
                com.ss.android.downloadlib.addownload.a.kf ok2 = com.ss.android.downloadlib.addownload.a.kf.ok();
                com.ss.android.downloadlib.addownload.a.n nVar = this.ok;
                ok2.ok(new com.ss.android.downloadad.api.ok.a(nVar.f48371a, nVar.bl, nVar.f48373s, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.h.j.ok(this.ok.f48371a)) {
                    com.ss.android.downloadlib.n.bl.ok().a("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 5, downloadInfo);
                if (z3 && com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(this.f48585a, this.ok.f48371a.getLogExtra())) {
                    com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 4, downloadInfo);
                if (z3 && com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(this.f48585a, this.ok.f48371a.getLogExtra())) {
                    com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 2);
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
                com.ss.android.downloadlib.s.ok.ok().ok(this.f48585a, 3, downloadInfo);
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
    public void ok(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9) {
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
            com.ss.android.downloadlib.addownload.k.ok(r8)
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
            boolean r2 = r1 instanceof com.ss.android.download.api.download.ok
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.ok r1 = (com.ss.android.download.api.download.ok) r1
            r1.ok(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.ok(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.ok(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.ok(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.a.n r2 = r6.ok
            com.ss.android.download.api.download.DownloadModel r2 = r2.f48371a
            boolean r2 = com.ss.android.downloadlib.h.j.ok(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.a.n r2 = r6.ok
            com.ss.android.download.api.download.DownloadModel r2 = r2.f48371a
            boolean r2 = com.ss.android.downloadlib.h.j.ok(r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.p.ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> ok(Map<Integer, Object> map) {
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

    private com.ss.android.socialbase.downloader.model.bl ok(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.bl("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e4) {
            r.u().ok(e4, "parseLogExtra Error");
            return null;
        }
    }
}
