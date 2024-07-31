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
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.DownloadAgent;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import com.stub.StubApp;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mbridge.msdk.mbdownload.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WorkThread extends Thread {

    /* renamed from: f */
    private DownloadProvider f31372f;

    /* renamed from: g */
    private Context f31373g;

    /* renamed from: h */
    private boolean f31374h;

    /* renamed from: i */
    private File f31375i;

    /* renamed from: j */
    private int f31376j;

    /* renamed from: k */
    private long f31377k;

    /* renamed from: l */
    private long f31378l;

    /* renamed from: n */
    private int f31380n;

    /* renamed from: o */
    private Handler f31381o;

    /* renamed from: p */
    private DownloadAgent.C11460a f31382p;

    /* renamed from: q */
    private NotificationManager f31383q;

    /* renamed from: r */
    private IDownloadListener f31384r;

    /* renamed from: e */
    private static final String f31370e = WorkThread.class.getSimpleName();

    /* renamed from: a */
    public static int f31366a = 1;

    /* renamed from: b */
    public static int f31367b = 2;

    /* renamed from: c */
    public static int f31368c = 3;

    /* renamed from: d */
    public static int f31369d = 4;

    /* renamed from: t */
    private static Boolean f31371t = Boolean.FALSE;

    /* renamed from: m */
    private int f31379m = -1;

    /* renamed from: s */
    private int f31385s = 0;

    public WorkThread(DownloadProvider downloadProvider, DownloadAgent.C11460a c11460a, int i, int i2) {
        String str;
        long[] jArr;
        this.f31376j = 0;
        this.f31377k = -1L;
        this.f31378l = -1L;
        this.f31372f = downloadProvider;
        this.f31373g = StubApp.getOrigApplicationContext(downloadProvider.m21642c().getApplicationContext());
        this.f31382p = c11460a;
        this.f31376j = i2;
        this.f31383q = (NotificationManager) downloadProvider.m21642c().getSystemService("notification");
        NotificationUtils.m21590a();
        this.f31381o = new Handler(this.f31372f.m21642c().getMainLooper());
        try {
            if (DownloadProvider.f31301d.indexOfKey(i) >= 0 && (jArr = DownloadProvider.f31301d.get(i).f31331f) != null && jArr.length > 1) {
                this.f31377k = jArr[0];
                this.f31378l = jArr[1];
            }
            this.f31380n = i;
            boolean[] zArr = new boolean[1];
            this.f31375i = DownloadTool.m21623a("/apk", this.f31373g, zArr);
            this.f31374h = zArr[0];
            DownloadAgent.C11460a c11460a2 = this.f31382p;
            if (c11460a2.f31283f != null) {
                str = c11460a2.f31283f + ".apk.tmp";
            } else {
                str = DownloadTool.m21625a(c11460a2.f31281d) + ".apk.tmp";
            }
            this.f31375i = new File(this.f31375i, c11460a2.f31279b.equalsIgnoreCase("delta_update") ? str.replace(".apk", ".patch") : str);
        } catch (Exception e) {
            SameLogTool.m21735b(f31370e, e.getMessage(), e);
            this.f31372f.m21653a(this.f31380n, e);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f31376j = 0;
        try {
            DownloadProvider downloadProvider = this.f31372f;
            if (downloadProvider != null) {
                downloadProvider.m21655a(this.f31380n);
            }
            m21582a(this.f31377k > 0);
            if (DownloadProvider.f31300c.size() <= 0) {
                this.f31372f.m21642c().stopSelf();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        this.f31385s = f31366a;
    }

    /* renamed from: b */
    public final void m21581b() {
        this.f31385s = f31366a;
        m21582a(false);
    }

    /* renamed from: c */
    public final int m21579c() {
        return this.f31385s;
    }

    /* renamed from: d */
    public final void m21577d() {
        SameLogTool.m21738a("workthread", "=====installOrActive");
        String m22776h = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(this.f31373g)).m22776h(this.f31382p.f31284g);
        if (!CommonClickUtil.m23065d(this.f31373g, m22776h)) {
            Context context = this.f31373g;
            Uri fromFile = Uri.fromFile(this.f31375i);
            DownloadAgent.C11460a c11460a = this.f31382p;
            CommonClickUtil.m23077a(context, fromFile, c11460a.f31281d, c11460a.f31284g);
            return;
        }
        CommonClickUtil.m23063f(this.f31373g, m22776h);
    }

    /* renamed from: a */
    public final void m21586a(int i) {
        this.f31379m = i;
        this.f31385s = f31368c;
        ADownloadManager.getInstance().pause(this.f31382p.f31284g);
        ADownloadManager.getInstance().deleteDownloadListener(this.f31382p.f31284g, this.f31384r);
    }

    /* renamed from: a */
    public final void m21587a() {
        this.f31385s = f31367b;
        ADownloadManager.getInstance().pause(this.f31382p.f31284g);
    }

    /* renamed from: a */
    private void m21582a(boolean z) {
        if (this.f31384r == null) {
            this.f31384r = new IDownloadListener() { // from class: com.mbridge.msdk.mbdownload.k.1
                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onEnd(int i, int i2, String str) {
                    SameLogTool.m21738a("download workthread", "onEnd:" + WorkThread.this.f31375i);
                    try {
                        if (WorkThread.this.f31372f == null || TextUtils.isEmpty(str)) {
                            return;
                        }
                        WorkThread.this.f31375i = new File(str);
                        WorkThread.this.f31372f.m21652a(WorkThread.this.f31380n, str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onProgressUpdate(int i) {
                    try {
                        if (WorkThread.this.f31372f != null) {
                            WorkThread.this.f31372f.m21654a(WorkThread.this.f31380n, i);
                        }
                        WorkThread.m21584a(WorkThread.this, i);
                    } catch (RemoteException | IllegalStateException e) {
                        e.printStackTrace();
                    }
                    DownloadTaskList.m21637a(WorkThread.this.f31373g).m21636a(WorkThread.this.f31382p.f31279b, WorkThread.this.f31382p.f31281d, i);
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStart() {
                    SameLogTool.m21738a("download workthread", "onstart");
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStatus(int i) {
                    if (i == 9) {
                        try {
                            if (WorkThread.this.f31372f != null) {
                                WorkThread.this.f31372f.m21644b(WorkThread.this.f31380n, i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        }
        ADownloadManager.getInstance().addDownloadListener(this.f31382p.f31284g, this.f31384r);
        ADownloadManager aDownloadManager = ADownloadManager.getInstance();
        DownloadAgent.C11460a c11460a = this.f31382p;
        aDownloadManager.start(c11460a.f31284g, c11460a.f31281d);
    }

    /* renamed from: a */
    static /* synthetic */ void m21584a(WorkThread workThread, int i) throws RemoteException {
        try {
            if (DownloadProvider.f31300c.get(workThread.f31382p) != null) {
                DownloadProvider.f31300c.get(workThread.f31382p).send(Message.obtain(null, 3, i, 0));
            }
        } catch (DeadObjectException unused) {
            SameLogTool.m21733d(f31370e, String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", workThread.f31382p.f31280c));
            DownloadProvider.f31300c.put(workThread.f31382p, null);
        }
    }
}
