package com.p521ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p205p0.C7282g;
import com.p521ss.android.download.api.config.InterfaceC11970u;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.download.InterfaceC11978ok;
import com.p521ss.android.download.api.model.DownloadShortInfo;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.addownload.p529bl.C12051ok;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12198k;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p534h.C12217s;
import com.p521ss.android.downloadlib.p534h.HandlerC12218z;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12269bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12312kf;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.downloader.depend.AbstractC12461ok;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12121p implements HandlerC12218z.InterfaceC12219ok {

    /* renamed from: a */
    private long f34303a;

    /* renamed from: bl */
    private boolean f34304bl = false;

    /* renamed from: n */
    private InterfaceC12125a f34305n;

    /* renamed from: ok */
    public C12035n f34306ok;

    /* renamed from: s */
    private C12095n f34307s;

    /* renamed from: com.ss.android.downloadlib.addownload.p$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12125a {
        /* renamed from: ok */
        void mo18982ok(DownloadInfo downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.downloadlib.addownload.p$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12126ok extends AbstractC12461ok {

        /* renamed from: ok */
        private HandlerC12218z f34313ok;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C12126ok(HandlerC12218z handlerC12218z) {
            this.f34313ok = handlerC12218z;
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12461ok, com.p521ss.android.socialbase.downloader.depend.InterfaceC12485zz
        /* renamed from: ok */
        public void mo16647ok(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, 11);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, -4);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            m18981ok(downloadInfo, -1);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, -2);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, 1);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, 4);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, 2);
        }

        @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            m18981ok(downloadInfo, -3);
        }

        /* renamed from: ok */
        private void m18981ok(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.f34313ok.sendMessage(obtain);
        }
    }

    public C12121p(C12095n c12095n) {
        this.f34307s = c12095n;
    }

    /* renamed from: bl */
    private boolean m19008bl() {
        return m18986s() && m19004n();
    }

    /* renamed from: kf */
    private boolean m19006kf() {
        return C12197j.m18788ok(this.f34306ok.f34076a) && C12127q.m18978ok(this.f34306ok.f34080s.getLinkMode());
    }

    /* renamed from: n */
    private boolean m19004n() {
        return this.f34306ok.f34080s.isAddToDownloadManage();
    }

    /* renamed from: s */
    private boolean m18986s() {
        DownloadModel downloadModel = this.f34306ok.f34076a;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f34306ok.f34076a.getDownloadUrl())) ? false : true;
    }

    /* renamed from: a */
    public void m19010a(@Nullable DownloadInfo downloadInfo) {
        InterfaceC12125a interfaceC12125a = this.f34305n;
        if (interfaceC12125a != null) {
            interfaceC12125a.mo18982ok(downloadInfo);
            this.f34305n = null;
        }
    }

    @Override // com.p521ss.android.downloadlib.p534h.HandlerC12218z.InterfaceC12219ok
    /* renamed from: ok */
    public void mo18671ok(Message message) {
    }

    /* renamed from: kf */
    private boolean m19005kf(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && C12713kf.m16517s(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    /* renamed from: n */
    private boolean m19003n(DownloadInfo downloadInfo) {
        return !C12197j.m18788ok(this.f34306ok.f34076a) && m19005kf(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bl */
    public void m19007bl(DownloadInfo downloadInfo) {
        if (!C12127q.m18977ok(this.f34306ok.f34076a) || this.f34304bl) {
            return;
        }
        C12270ok.m18539ok().m18529ok("file_status", (downloadInfo == null || !C12197j.m18804a(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f34306ok);
        this.f34304bl = true;
    }

    /* renamed from: ok */
    public void m18999ok(long j) {
        this.f34303a = j;
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        this.f34306ok = m19325n;
        if (m19325n.m19287y()) {
            C12235bl.m18640ok().m18639ok("setAdId ModelBox notValid");
        }
    }

    /* renamed from: a */
    private void m19011a(final InterfaceC11970u interfaceC11970u) {
        if (C12198k.m18769a(C7282g.f24952j)) {
            if (interfaceC11970u != null) {
                interfaceC11970u.mo18984ok();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!C12197j.m18795ok()) {
            str = C7282g.f24951i;
        } else if (C12198k.m18769a("android.permission.READ_MEDIA_IMAGES") || C12198k.m18769a("android.permission.READ_MEDIA_AUDIO") || C12198k.m18769a("android.permission.READ_MEDIA_VIDEO")) {
            if (interfaceC11970u != null) {
                interfaceC11970u.mo18984ok();
                return;
            }
            return;
        }
        C12198k.m18764ok(new String[]{str}, new C12198k.InterfaceC12199ok() { // from class: com.ss.android.downloadlib.addownload.p.2
            @Override // com.p521ss.android.downloadlib.p534h.C12198k.InterfaceC12199ok
            /* renamed from: ok */
            public void mo18763ok() {
                InterfaceC11970u interfaceC11970u2 = interfaceC11970u;
                if (interfaceC11970u2 != null) {
                    interfaceC11970u2.mo18984ok();
                }
            }

            @Override // com.p521ss.android.downloadlib.p534h.C12198k.InterfaceC12199ok
            /* renamed from: ok */
            public void mo18762ok(String str2) {
                InterfaceC11970u interfaceC11970u2 = interfaceC11970u;
                if (interfaceC11970u2 != null) {
                    interfaceC11970u2.mo18983ok(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean m18985s(DownloadInfo downloadInfo) {
        return m19006kf() || m19003n(downloadInfo);
    }

    /* renamed from: ok */
    public void m18992ok(DownloadInfo downloadInfo) {
        this.f34304bl = false;
        m19010a(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public boolean m18998ok(Context context, int i, boolean z) {
        if (C12197j.m18788ok(this.f34306ok.f34076a)) {
            C11998a m19311s = C12032kf.m19324ok().m19311s(this.f34306ok.f34079ok);
            if (m19311s != null) {
                C12644a.m16876ok().m16878kf(m19311s.mo19285zz());
            }
            return C12018ok.m19379ok(this.f34306ok);
        } else if (m19001ok(i) && !TextUtils.isEmpty(this.f34306ok.f34076a.getPackageName()) && C12128r.m18946q().optInt("disable_market") != 1) {
            if (C12018ok.m19378ok(this.f34306ok, i)) {
                return true;
            }
            return this.f34307s.m19062q() && this.f34307s.m19056s(true);
        } else if (z && this.f34306ok.f34080s.getDownloadMode() == 4 && !this.f34307s.m19087n()) {
            this.f34307s.m19098bl(true);
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    /* renamed from: a */
    public String m19012a() {
        File externalFilesDir = C12128r.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
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
    /* renamed from: a */
    public static List<InterfaceC11978ok> m19009a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof InterfaceC11978ok) {
                    arrayList.add((InterfaceC11978ok) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof InterfaceC11978ok) {
                            arrayList.add((InterfaceC11978ok) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof InterfaceC11978ok) {
                            arrayList.add((InterfaceC11978ok) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ok */
    public boolean m19001ok(int i) {
        if (this.f34306ok.f34080s.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.f34306ok.f34080s.getDownloadMode() == 2 && i == 1 && C12128r.m18946q().optInt("disable_lp_if_market", 0) == 1;
    }

    /* renamed from: ok */
    public boolean m19000ok(int i, DownloadModel downloadModel) {
        return C12317n.m18244bl() && m19001ok(i) && !C12197j.m18788ok(downloadModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public boolean m18987ok(boolean z) {
        return !z && this.f34306ok.f34080s.getDownloadMode() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m18995ok(@NonNull final InterfaceC11970u interfaceC11970u) {
        if (!TextUtils.isEmpty(this.f34306ok.f34076a.getFilePath())) {
            String filePath = this.f34306ok.f34076a.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                interfaceC11970u.mo18984ok();
                return;
            }
            try {
                if (filePath.startsWith(C12128r.getContext().getExternalCacheDir().getParent())) {
                    interfaceC11970u.mo18984ok();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        m19011a(new InterfaceC11970u() { // from class: com.ss.android.downloadlib.addownload.p.1
            @Override // com.p521ss.android.download.api.config.InterfaceC11970u
            /* renamed from: ok */
            public void mo18984ok() {
                interfaceC11970u.mo18984ok();
            }

            @Override // com.p521ss.android.download.api.config.InterfaceC11970u
            /* renamed from: ok */
            public void mo18983ok(String str) {
                C12128r.m18968bl().mo19528ok(1, C12128r.getContext(), C12121p.this.f34306ok.f34076a, "您已禁止使用存储权限，请授权后再下载", null, 1);
                C12270ok.m18539ok().m18543a(C12121p.this.f34303a, 1);
                interfaceC11970u.mo18983ok(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m18996ok(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        InterfaceC12125a interfaceC12125a;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                C12184h m18835ok = C12184h.m18835ok();
                C12035n c12035n = this.f34306ok;
                m18835ok.m18832ok(c12035n.f34076a, c12035n.f34080s, c12035n.f34077bl);
                downloadInfo.setFirstDownload(false);
            }
            C12270ok.m18539ok().m18531ok(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        C12091k.m19119ok(downloadShortInfo);
        int m18432ok = C12293bl.m18432ok(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || C12534ok.m17605bl().m17595ok("fix_click_start")) && (interfaceC12125a = this.f34305n) != null) {
            interfaceC12125a.mo18982ok(downloadInfo);
            this.f34305n = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : m18988ok(map)) {
            if (m18432ok != 1) {
                if (m18432ok == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, C12091k.m19121ok(downloadInfo.getId(), curBytes));
                } else if (m18432ok == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (C12197j.m18788ok(this.f34306ok.f34076a)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, C12091k.m19121ok(downloadInfo.getId(), curBytes));
            } else {
                for (InterfaceC11978ok interfaceC11978ok : m19009a(map)) {
                    interfaceC11978ok.m19616ok(downloadInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m19002ok() {
        if (this.f34305n == null) {
            this.f34305n = new InterfaceC12125a() { // from class: com.ss.android.downloadlib.addownload.p.3
                @Override // com.p521ss.android.downloadlib.addownload.C12121p.InterfaceC12125a
                /* renamed from: ok */
                public void mo18982ok(DownloadInfo downloadInfo) {
                    C12270ok.m18539ok().m18536ok(C12121p.this.f34303a, 2, downloadInfo);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public int m18997ok(Context context, IDownloadListener iDownloadListener) {
        C12601bl m18989ok;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f34306ok.f34076a.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (C12128r.m18946q().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f34306ok.f34076a.getLogExtra()) && (m18989ok = m18989ok(this.f34306ok.f34076a.getLogExtra())) != null) {
            arrayList.add(m18989ok);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new C12601bl(entry.getKey(), entry.getValue()));
                }
            }
        }
        String m18672ok = C12217s.m18672ok(String.valueOf(this.f34306ok.f34076a.getId()), this.f34306ok.f34076a.getNotificationJumpUrl(), this.f34306ok.f34076a.isShowToast(), String.valueOf(this.f34306ok.f34076a.getModelType()));
        C12534ok m18751a = C12201n.m18751a(this.f34306ok.f34076a);
        JSONObject m18738ok = C12201n.m18738ok(this.f34306ok.f34076a);
        if (!this.f34306ok.f34080s.enableAH()) {
            m18738ok = C12197j.m18780ok(m18738ok);
            C12197j.m18778ok(m18738ok, "ah_plans", new JSONArray());
        }
        this.f34306ok.f34076a.getExecutorGroup();
        int i = (this.f34306ok.f34076a.isAd() || C12127q.m18979a(this.f34306ok.f34076a)) ? 4 : 4;
        String m18993ok = m18993ok(m18751a);
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(C12490bl.m17776ok(this.f34306ok.f34076a.getDownloadUrl(), m18993ok));
        if (downloadInfo != null && 3 == this.f34306ok.f34076a.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        C12312kf m18282t = new C12312kf(context, this.f34306ok.f34076a.getDownloadUrl()).m18359a(this.f34306ok.f34076a.getBackupUrls()).m18306ok(this.f34306ok.f34076a.getName()).m18317n(m18672ok).m18305ok(arrayList).m18303ok(this.f34306ok.f34076a.isShowNotification()).m18353bl(this.f34306ok.f34076a.isNeedWifi()).m18360a(this.f34306ok.f34076a.getFileName()).m18354bl(m18993ok).m18293r(this.f34306ok.f34076a.getAppIcon()).m18301p(this.f34306ok.f34076a.getMd5()).m18328k(this.f34306ok.f34076a.getSdkMonitorScene()).m18312ok(this.f34306ok.f34076a.getExpectFileLength()).m18309ok(iDownloadListener).m18330j(this.f34306ok.f34076a.needIndependentProcess() || m18751a.m17593ok("need_independent_process", 0) == 1).m18310ok(this.f34306ok.f34076a.getDownloadFileUriProvider()).m18358a(this.f34306ok.f34076a.autoInstallWithoutNotification()).m18336h(this.f34306ok.f34076a.getPackageName()).m18287s(1000).m18318n(100).m18304ok(m18738ok).m18297q(true).m18327k(true).m18361a(m18751a.m17593ok("retry_count", 5)).m18355bl(m18751a.m17593ok("backup_url_retry_count", 0)).m18327k(true).m18265z(m18751a.m17593ok("need_head_connection", 0) == 1).m18285s(m18751a.m17593ok("need_https_to_http_retry", 0) == 1).m18300p(m18751a.m17593ok("need_chunk_downgrade_retry", 1) == 1).m18335h(m18751a.m17593ok("need_retry_delay", 0) == 1).m18298q(m18751a.m17603bl("retry_delay_time_array")).m18292r(m18751a.m17593ok("need_reuse_runnable", 0) == 1).m18325kf(i).m18333i(this.f34306ok.f34076a.isAutoInstall()).m18282t(this.f34306ok.f34076a.distinctDir());
        if (!TextUtils.isEmpty(this.f34306ok.f34076a.getMimeType())) {
            m18282t.m18324kf(this.f34306ok.f34076a.getMimeType());
        } else {
            m18282t.m18324kf("application/vnd.android.package-archive");
        }
        if (m18751a.m17593ok("notification_opt_2", 0) == 1) {
            m18282t.m18303ok(false);
            m18282t.m18358a(true);
        }
        C12051ok c12051ok = null;
        if (m18751a.m17593ok("clear_space_use_disk_handler", 0) == 1) {
            c12051ok = new C12051ok();
            m18282t.m18308ok(c12051ok);
        }
        DownloadModel downloadModel = this.f34306ok.f34076a;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            m18282t.m18286s(((AdDownloadModel) this.f34306ok.f34076a).getTaskKey());
        }
        int m18974ok = C12127q.m18974ok(this.f34306ok, m19008bl(), m18282t);
        if (c12051ok != null) {
            c12051ok.m19251ok(m18974ok);
        }
        return m18974ok;
    }

    /* renamed from: ok */
    private String m18993ok(C12534ok c12534ok) {
        boolean z;
        if (!TextUtils.isEmpty(this.f34306ok.f34076a.getFilePath())) {
            return this.f34306ok.f34076a.getFilePath();
        }
        DownloadInfo m18061ok = C12361s.m18068k().m18061ok(C12128r.getContext(), this.f34306ok.f34076a.getDownloadUrl());
        if (!C12197j.m18795ok()) {
            z = C12198k.m18769a(C7282g.f24952j);
        } else {
            z = C12198k.m18769a("android.permission.READ_MEDIA_IMAGES") || C12198k.m18769a("android.permission.READ_MEDIA_AUDIO") || C12198k.m18769a("android.permission.READ_MEDIA_VIDEO");
        }
        String m19012a = m19012a();
        if (m18061ok != null && !TextUtils.isEmpty(m18061ok.getSavePath())) {
            String savePath = m18061ok.getSavePath();
            if (z || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(m19012a)) {
                    if (savePath.startsWith(m19012a)) {
                        return savePath;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Downloader.getInstance(C12490bl.m17807l()).cancel(m18061ok.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z ? 1 : 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("label_external_permission", jSONObject, this.f34306ok);
        String str = null;
        try {
            str = C12293bl.m18446a();
        } catch (Exception unused) {
        }
        int m18736ok = C12201n.m18736ok(c12534ok);
        if (m18736ok != 0) {
            if (m18736ok != 4 && (z || m18736ok != 2)) {
                if ((m18736ok == 3 || (!z && m18736ok == 1)) && !TextUtils.isEmpty(m19012a)) {
                    return m19012a;
                }
            } else {
                File filesDir = C12128r.getContext().getFilesDir();
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
    /* renamed from: ok */
    public void m18990ok(DownloadInfo downloadInfo, boolean z) {
        if (this.f34306ok.f34076a == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (C12127q.m18977ok(this.f34306ok.f34076a)) {
                C12270ok.m18539ok().m18537ok(this.f34303a, 2);
            } else if (z && C12269bl.m18545ok().m18547bl() && (status == -2 || status == -3)) {
                C12270ok.m18539ok().m18537ok(this.f34303a, 2);
            }
        } else {
            C12270ok.m18539ok().m18537ok(this.f34303a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                m19002ok();
                C12032kf m19324ok = C12032kf.m19324ok();
                C12035n c12035n = this.f34306ok;
                m19324ok.m19318ok(new C11998a(c12035n.f34076a, c12035n.f34077bl, c12035n.f34080s, downloadInfo.getId()));
                return;
            case -3:
                if (C12197j.m18788ok(this.f34306ok.f34076a)) {
                    C12235bl.m18640ok().m18643a("SUCCESSED isInstalledApp");
                    return;
                }
                C12270ok.m18539ok().m18536ok(this.f34303a, 5, downloadInfo);
                if (z && C12269bl.m18545ok().m18549a() && !C12269bl.m18545ok().m18548a(this.f34303a, this.f34306ok.f34076a.getLogExtra())) {
                    C12270ok.m18539ok().m18537ok(this.f34303a, 2);
                    return;
                }
                return;
            case -2:
                C12270ok.m18539ok().m18536ok(this.f34303a, 4, downloadInfo);
                if (z && C12269bl.m18545ok().m18549a() && !C12269bl.m18545ok().m18548a(this.f34303a, this.f34306ok.f34076a.getLogExtra())) {
                    C12270ok.m18539ok().m18537ok(this.f34303a, 2);
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
                C12270ok.m18539ok().m18536ok(this.f34303a, 3, downloadInfo);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m18991ok(com.p521ss.android.socialbase.downloader.model.DownloadInfo r7, com.p521ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.p521ss.android.download.api.download.DownloadStatusChangeListener> r9) {
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
            com.p521ss.android.downloadlib.addownload.C12091k.m19119ok(r8)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto La7
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.p521ss.android.download.api.download.DownloadStatusChangeListener) r1
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
            boolean r2 = r1 instanceof com.p521ss.android.download.api.download.InterfaceC11978ok
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.ok r1 = (com.p521ss.android.download.api.download.InterfaceC11978ok) r1
            r1.m19616ok(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.p521ss.android.downloadlib.addownload.C12091k.m19121ok(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.p521ss.android.downloadlib.addownload.C12091k.m19121ok(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.p521ss.android.downloadlib.addownload.C12091k.m19121ok(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.a.n r2 = r6.f34306ok
            com.ss.android.download.api.download.DownloadModel r2 = r2.f34076a
            boolean r2 = com.p521ss.android.downloadlib.p534h.C12197j.m18788ok(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.a.n r2 = r6.f34306ok
            com.ss.android.download.api.download.DownloadModel r2 = r2.f34076a
            boolean r2 = com.p521ss.android.downloadlib.p534h.C12197j.m18788ok(r2)
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
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.p521ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto Lac
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.addownload.C12121p.m18991ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    /* renamed from: ok */
    public static List<DownloadStatusChangeListener> m18988ok(Map<Integer, Object> map) {
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

    /* renamed from: ok */
    private C12601bl m18989ok(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new C12601bl("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            C12128r.m18940u().mo18637ok(e, "parseLogExtra Error");
            return null;
        }
    }
}
