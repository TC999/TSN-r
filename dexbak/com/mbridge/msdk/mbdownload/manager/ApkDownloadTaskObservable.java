package com.mbridge.msdk.mbdownload.manager;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.UriUtil;
import java.util.Observable;

/* renamed from: com.mbridge.msdk.mbdownload.manager.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ApkDownloadTaskObservable extends Observable {

    /* renamed from: d */
    private String f31391d;

    /* renamed from: e */
    private String f31392e;

    /* renamed from: f */
    private String f31393f;

    /* renamed from: h */
    private String f31395h;

    /* renamed from: k */
    private DownloadRequest f31398k;

    /* renamed from: l */
    private CampaignDAIDao f31399l;

    /* renamed from: o */
    private String f31402o;

    /* renamed from: p */
    private DownloadMessage<Object> f31403p;

    /* renamed from: a */
    private String f31388a = ApkDownloadTaskObservable.class.getSimpleName();

    /* renamed from: b */
    private volatile int f31389b = -1;

    /* renamed from: c */
    private volatile int f31390c = 0;

    /* renamed from: g */
    private String f31394g = "";

    /* renamed from: i */
    private String f31396i = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_APK);

    /* renamed from: j */
    private UpdateObject f31397j = new UpdateObject();

    /* renamed from: m */
    private OnDownloadStateListener f31400m = new OnDownloadStateListener() { // from class: com.mbridge.msdk.mbdownload.manager.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
            ApkDownloadTaskObservable.this.setChanged();
            ApkDownloadTaskObservable.this.f31389b = 5;
            ApkDownloadTaskObservable.this.f31397j.m21549a(ApkDownloadTaskObservable.this.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable.m21572a(apkDownloadTaskObservable.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable2 = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable2.notifyObservers(apkDownloadTaskObservable2.f31397j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            ApkDownloadTaskObservable.this.setChanged();
            ApkDownloadTaskObservable.this.f31389b = 1;
            ApkDownloadTaskObservable.this.f31397j.m21549a(ApkDownloadTaskObservable.this.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable.m21572a(apkDownloadTaskObservable.f31389b);
            ApkDownloadTaskObservable.this.f31395h = downloadMessage.getSaveFilePath();
            ApkDownloadTaskObservable apkDownloadTaskObservable2 = ApkDownloadTaskObservable.this;
            ApkDownloadTaskObservable.m21565b(apkDownloadTaskObservable2, apkDownloadTaskObservable2.f31395h);
            ApkDownloadTaskObservable.this.f31397j.m21548a(ApkDownloadTaskObservable.this.f31395h);
            ApkDownloadTaskObservable apkDownloadTaskObservable3 = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable3.notifyObservers(apkDownloadTaskObservable3.f31397j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            ApkDownloadTaskObservable.this.setChanged();
            ApkDownloadTaskObservable.this.f31389b = 8;
            ApkDownloadTaskObservable.this.f31397j.m21549a(ApkDownloadTaskObservable.this.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable.m21572a(apkDownloadTaskObservable.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable2 = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable2.notifyObservers(apkDownloadTaskObservable2.f31397j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            ApkDownloadTaskObservable.this.setChanged();
            ApkDownloadTaskObservable.this.f31389b = 2;
            ApkDownloadTaskObservable.this.f31397j.m21549a(ApkDownloadTaskObservable.this.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable.m21572a(apkDownloadTaskObservable.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable2 = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable2.notifyObservers(apkDownloadTaskObservable2.f31397j);
        }
    };

    /* renamed from: n */
    private OnProgressStateListener f31401n = new OnProgressStateListener() { // from class: com.mbridge.msdk.mbdownload.manager.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            int currentDownloadRate = downloadProgress.getCurrentDownloadRate();
            if (ApkDownloadTaskObservable.this.f31389b != 2 || ApkDownloadTaskObservable.this.f31390c == currentDownloadRate) {
                return;
            }
            ApkDownloadTaskObservable.this.f31390c = currentDownloadRate;
            ApkDownloadTaskObservable.this.setChanged();
            ApkDownloadTaskObservable.this.f31397j.m21549a(ApkDownloadTaskObservable.this.f31389b);
            ApkDownloadTaskObservable apkDownloadTaskObservable = ApkDownloadTaskObservable.this;
            ApkDownloadTaskObservable.m21559d(apkDownloadTaskObservable, apkDownloadTaskObservable.f31390c);
            ApkDownloadTaskObservable.this.f31397j.m21546b(ApkDownloadTaskObservable.this.f31390c);
            ApkDownloadTaskObservable.this.f31397j.m21548a(downloadMessage.getSaveFilePath());
            ApkDownloadTaskObservable apkDownloadTaskObservable2 = ApkDownloadTaskObservable.this;
            apkDownloadTaskObservable2.notifyObservers(apkDownloadTaskObservable2.f31397j);
        }
    };

    /* renamed from: q */
    private int f31404q = -1;

    public ApkDownloadTaskObservable(String str, String str2) {
        this.f31391d = "";
        this.f31392e = "";
        this.f31393f = "";
        this.f31402o = "";
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f31391d = str;
        this.f31392e = str2;
        this.f31402o = this.f31396i + "/";
        this.f31393f = str;
        if (TextUtils.isEmpty(str)) {
            this.f31393f = SameMD5.getMD5(UriUtil.m21950a(str2));
        }
        Object obj = new Object();
        this.f31403p = new DownloadMessage<>(obj, str2, this.f31393f + ".apk", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_APK);
        CampaignDAIDao m22789a = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        this.f31399l = m22789a;
        m22789a.m22785a(str, str2);
    }

    /* renamed from: d */
    public final int m21561d() {
        return this.f31389b;
    }

    /* renamed from: e */
    public final int m21558e() {
        return this.f31390c;
    }

    /* renamed from: f */
    public final String m21556f() {
        return this.f31395h;
    }

    /* renamed from: d */
    static /* synthetic */ void m21559d(ApkDownloadTaskObservable apkDownloadTaskObservable, int i) {
        CampaignDAIDao campaignDAIDao = apkDownloadTaskObservable.f31399l;
        if (campaignDAIDao == null || i <= apkDownloadTaskObservable.f31404q) {
            return;
        }
        apkDownloadTaskObservable.f31404q = i;
        campaignDAIDao.m22783b(apkDownloadTaskObservable.f31391d, i);
    }

    /* renamed from: b */
    public final void m21568b() {
        MBDownloadManager.getInstance().cancel(this.f31394g);
    }

    /* renamed from: c */
    public final void m21564c() {
        this.f31389b = 9;
        setChanged();
        this.f31397j.m21549a(this.f31389b);
        m21572a(this.f31389b);
        notifyObservers(this.f31397j);
    }

    /* renamed from: b */
    static /* synthetic */ void m21565b(ApkDownloadTaskObservable apkDownloadTaskObservable, String str) {
        CampaignDAIDao campaignDAIDao = apkDownloadTaskObservable.f31399l;
        if (campaignDAIDao != null) {
            campaignDAIDao.m22782b(apkDownloadTaskObservable.f31391d, str);
        }
    }

    /* renamed from: a */
    public final void m21573a() {
        DownloadRequest build = MBDownloadManager.getInstance().download(this.f31403p).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f31402o).withDownloadStateListener(this.f31400m).withProgressStateListener(this.f31401n).build();
        this.f31398k = build;
        build.start();
        this.f31394g = this.f31398k.getDownloadId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21572a(int i) {
        CampaignDAIDao campaignDAIDao = this.f31399l;
        if (campaignDAIDao != null) {
            campaignDAIDao.m22786a(this.f31391d, i);
        }
    }
}
