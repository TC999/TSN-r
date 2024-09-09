package com.mbridge.msdk.mbdownload;

import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.b;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import com.stub.StubApp;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkThread.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class k extends Thread {

    /* renamed from: f  reason: collision with root package name */
    private c f40144f;

    /* renamed from: g  reason: collision with root package name */
    private Context f40145g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f40146h;

    /* renamed from: i  reason: collision with root package name */
    private File f40147i;

    /* renamed from: j  reason: collision with root package name */
    private int f40148j;

    /* renamed from: k  reason: collision with root package name */
    private long f40149k;

    /* renamed from: l  reason: collision with root package name */
    private long f40150l;

    /* renamed from: n  reason: collision with root package name */
    private int f40152n;

    /* renamed from: o  reason: collision with root package name */
    private Handler f40153o;

    /* renamed from: p  reason: collision with root package name */
    private b.a f40154p;

    /* renamed from: q  reason: collision with root package name */
    private NotificationManager f40155q;

    /* renamed from: r  reason: collision with root package name */
    private IDownloadListener f40156r;

    /* renamed from: e  reason: collision with root package name */
    private static final String f40142e = k.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static int f40138a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f40139b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f40140c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f40141d = 4;

    /* renamed from: t  reason: collision with root package name */
    private static Boolean f40143t = Boolean.FALSE;

    /* renamed from: m  reason: collision with root package name */
    private int f40151m = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f40157s = 0;

    public k(c cVar, b.a aVar, int i4, int i5) {
        String str;
        long[] jArr;
        this.f40148j = 0;
        this.f40149k = -1L;
        this.f40150l = -1L;
        this.f40144f = cVar;
        this.f40145g = StubApp.getOrigApplicationContext(cVar.c().getApplicationContext());
        this.f40154p = aVar;
        this.f40148j = i5;
        this.f40155q = (NotificationManager) cVar.c().getSystemService("notification");
        j.a();
        this.f40153o = new Handler(this.f40144f.c().getMainLooper());
        try {
            if (c.f40073d.indexOfKey(i4) >= 0 && (jArr = c.f40073d.get(i4).f40103f) != null && jArr.length > 1) {
                this.f40149k = jArr[0];
                this.f40150l = jArr[1];
            }
            this.f40152n = i4;
            boolean[] zArr = new boolean[1];
            this.f40147i = e.a("/apk", this.f40145g, zArr);
            this.f40146h = zArr[0];
            b.a aVar2 = this.f40154p;
            if (aVar2.f40055f != null) {
                str = aVar2.f40055f + ".apk.tmp";
            } else {
                str = e.a(aVar2.f40053d) + ".apk.tmp";
            }
            this.f40147i = new File(this.f40147i, aVar2.f40051b.equalsIgnoreCase("delta_update") ? str.replace(".apk", ".patch") : str);
        } catch (Exception e4) {
            x.b(f40142e, e4.getMessage(), e4);
            this.f40144f.a(this.f40152n, e4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f40148j = 0;
        try {
            c cVar = this.f40144f;
            if (cVar != null) {
                cVar.a(this.f40152n);
            }
            a(this.f40149k > 0);
            if (c.f40072c.size() <= 0) {
                this.f40144f.c().stopSelf();
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        this.f40157s = f40138a;
    }

    public final void b() {
        this.f40157s = f40138a;
        a(false);
    }

    public final int c() {
        return this.f40157s;
    }

    public final void d() {
        x.a("workthread", "=====installOrActive");
        String h4 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.i.a(this.f40145g)).h(this.f40154p.f40056g);
        if (!com.mbridge.msdk.click.c.d(this.f40145g, h4)) {
            Context context = this.f40145g;
            Uri fromFile = Uri.fromFile(this.f40147i);
            b.a aVar = this.f40154p;
            com.mbridge.msdk.click.c.a(context, fromFile, aVar.f40053d, aVar.f40056g);
            return;
        }
        com.mbridge.msdk.click.c.f(this.f40145g, h4);
    }

    public final void a(int i4) {
        this.f40151m = i4;
        this.f40157s = f40140c;
        ADownloadManager.getInstance().pause(this.f40154p.f40056g);
        ADownloadManager.getInstance().deleteDownloadListener(this.f40154p.f40056g, this.f40156r);
    }

    public final void a() {
        this.f40157s = f40139b;
        ADownloadManager.getInstance().pause(this.f40154p.f40056g);
    }

    private void a(boolean z3) {
        if (this.f40156r == null) {
            this.f40156r = new IDownloadListener() { // from class: com.mbridge.msdk.mbdownload.k.1
                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onEnd(int i4, int i5, String str) {
                    x.a("download workthread", "onEnd:" + k.this.f40147i);
                    try {
                        if (k.this.f40144f == null || TextUtils.isEmpty(str)) {
                            return;
                        }
                        k.this.f40147i = new File(str);
                        k.this.f40144f.a(k.this.f40152n, str);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onProgressUpdate(int i4) {
                    try {
                        if (k.this.f40144f != null) {
                            k.this.f40144f.a(k.this.f40152n, i4);
                        }
                        k.a(k.this, i4);
                    } catch (RemoteException | IllegalStateException e4) {
                        e4.printStackTrace();
                    }
                    d.a(k.this.f40145g).a(k.this.f40154p.f40051b, k.this.f40154p.f40053d, i4);
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStart() {
                    x.a("download workthread", "onstart");
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStatus(int i4) {
                    if (i4 == 9) {
                        try {
                            if (k.this.f40144f != null) {
                                k.this.f40144f.b(k.this.f40152n, i4);
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            };
        }
        ADownloadManager.getInstance().addDownloadListener(this.f40154p.f40056g, this.f40156r);
        ADownloadManager aDownloadManager = ADownloadManager.getInstance();
        b.a aVar = this.f40154p;
        aDownloadManager.start(aVar.f40056g, aVar.f40053d);
    }

    static /* synthetic */ void a(k kVar, int i4) throws RemoteException {
        try {
            if (c.f40072c.get(kVar.f40154p) != null) {
                c.f40072c.get(kVar.f40154p).send(Message.obtain(null, 3, i4, 0));
            }
        } catch (DeadObjectException unused) {
            x.d(f40142e, String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", kVar.f40154p.f40052c));
            c.f40072c.put(kVar.f40154p, null);
        }
    }
}
