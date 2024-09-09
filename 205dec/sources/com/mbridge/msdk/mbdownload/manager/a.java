package com.mbridge.msdk.mbdownload.manager;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ai;
import java.util.Observable;

/* compiled from: ApkDownloadTaskObservable.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends Observable {

    /* renamed from: d  reason: collision with root package name */
    private String f40163d;

    /* renamed from: e  reason: collision with root package name */
    private String f40164e;

    /* renamed from: f  reason: collision with root package name */
    private String f40165f;

    /* renamed from: h  reason: collision with root package name */
    private String f40167h;

    /* renamed from: k  reason: collision with root package name */
    private DownloadRequest f40170k;

    /* renamed from: l  reason: collision with root package name */
    private e f40171l;

    /* renamed from: o  reason: collision with root package name */
    private String f40174o;

    /* renamed from: p  reason: collision with root package name */
    private DownloadMessage<Object> f40175p;

    /* renamed from: a  reason: collision with root package name */
    private String f40160a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private volatile int f40161b = -1;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f40162c = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f40166g = "";

    /* renamed from: i  reason: collision with root package name */
    private String f40168i = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_APK);

    /* renamed from: j  reason: collision with root package name */
    private c f40169j = new c();

    /* renamed from: m  reason: collision with root package name */
    private OnDownloadStateListener f40172m = new OnDownloadStateListener() { // from class: com.mbridge.msdk.mbdownload.manager.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
            a.this.setChanged();
            a.this.f40161b = 5;
            a.this.f40169j.a(a.this.f40161b);
            a aVar = a.this;
            aVar.a(aVar.f40161b);
            a aVar2 = a.this;
            aVar2.notifyObservers(aVar2.f40169j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            a.this.setChanged();
            a.this.f40161b = 1;
            a.this.f40169j.a(a.this.f40161b);
            a aVar = a.this;
            aVar.a(aVar.f40161b);
            a.this.f40167h = downloadMessage.getSaveFilePath();
            a aVar2 = a.this;
            a.b(aVar2, aVar2.f40167h);
            a.this.f40169j.a(a.this.f40167h);
            a aVar3 = a.this;
            aVar3.notifyObservers(aVar3.f40169j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            a.this.setChanged();
            a.this.f40161b = 8;
            a.this.f40169j.a(a.this.f40161b);
            a aVar = a.this;
            aVar.a(aVar.f40161b);
            a aVar2 = a.this;
            aVar2.notifyObservers(aVar2.f40169j);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.setChanged();
            a.this.f40161b = 2;
            a.this.f40169j.a(a.this.f40161b);
            a aVar = a.this;
            aVar.a(aVar.f40161b);
            a aVar2 = a.this;
            aVar2.notifyObservers(aVar2.f40169j);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private OnProgressStateListener f40173n = new OnProgressStateListener() { // from class: com.mbridge.msdk.mbdownload.manager.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            int currentDownloadRate = downloadProgress.getCurrentDownloadRate();
            if (a.this.f40161b != 2 || a.this.f40162c == currentDownloadRate) {
                return;
            }
            a.this.f40162c = currentDownloadRate;
            a.this.setChanged();
            a.this.f40169j.a(a.this.f40161b);
            a aVar = a.this;
            a.d(aVar, aVar.f40162c);
            a.this.f40169j.b(a.this.f40162c);
            a.this.f40169j.a(downloadMessage.getSaveFilePath());
            a aVar2 = a.this;
            aVar2.notifyObservers(aVar2.f40169j);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private int f40176q = -1;

    public a(String str, String str2) {
        this.f40163d = "";
        this.f40164e = "";
        this.f40165f = "";
        this.f40174o = "";
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f40163d = str;
        this.f40164e = str2;
        this.f40174o = this.f40168i + TTPathConst.sSeparator;
        this.f40165f = str;
        if (TextUtils.isEmpty(str)) {
            this.f40165f = SameMD5.getMD5(ai.a(str2));
        }
        Object obj = new Object();
        this.f40175p = new DownloadMessage<>(obj, str2, this.f40165f + ".apk", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_APK);
        e a4 = e.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        this.f40171l = a4;
        a4.a(str, str2);
    }

    public final int d() {
        return this.f40161b;
    }

    public final int e() {
        return this.f40162c;
    }

    public final String f() {
        return this.f40167h;
    }

    static /* synthetic */ void d(a aVar, int i4) {
        e eVar = aVar.f40171l;
        if (eVar == null || i4 <= aVar.f40176q) {
            return;
        }
        aVar.f40176q = i4;
        eVar.b(aVar.f40163d, i4);
    }

    public final void b() {
        MBDownloadManager.getInstance().cancel(this.f40166g);
    }

    public final void c() {
        this.f40161b = 9;
        setChanged();
        this.f40169j.a(this.f40161b);
        a(this.f40161b);
        notifyObservers(this.f40169j);
    }

    static /* synthetic */ void b(a aVar, String str) {
        e eVar = aVar.f40171l;
        if (eVar != null) {
            eVar.b(aVar.f40163d, str);
        }
    }

    public final void a() {
        DownloadRequest build = MBDownloadManager.getInstance().download(this.f40175p).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f40174o).withDownloadStateListener(this.f40172m).withProgressStateListener(this.f40173n).build();
        this.f40170k = build;
        build.start();
        this.f40166g = this.f40170k.getDownloadId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        e eVar = this.f40171l;
        if (eVar != null) {
            eVar.a(this.f40163d, i4);
        }
    }
}
