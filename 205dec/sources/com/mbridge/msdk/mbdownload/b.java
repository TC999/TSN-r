package com.mbridge.msdk.mbdownload;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.IDownloadListener;
import com.stub.StubApp;

/* compiled from: DownloadAgent.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f40023b = "com.mbridge.msdk.mbdownload.b";

    /* renamed from: d  reason: collision with root package name */
    private IDownloadListener f40026d;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f40027e;

    /* renamed from: f  reason: collision with root package name */
    private String f40028f;

    /* renamed from: h  reason: collision with root package name */
    private String f40030h;

    /* renamed from: i  reason: collision with root package name */
    private String f40031i;

    /* renamed from: j  reason: collision with root package name */
    private String f40032j;

    /* renamed from: k  reason: collision with root package name */
    private String f40033k;

    /* renamed from: n  reason: collision with root package name */
    private String f40036n;

    /* renamed from: o  reason: collision with root package name */
    private String f40037o;

    /* renamed from: p  reason: collision with root package name */
    private String f40038p;

    /* renamed from: q  reason: collision with root package name */
    private String[] f40039q;

    /* renamed from: r  reason: collision with root package name */
    private String[] f40040r;

    /* renamed from: s  reason: collision with root package name */
    private String[] f40041s;

    /* renamed from: t  reason: collision with root package name */
    private String[] f40042t;

    /* renamed from: u  reason: collision with root package name */
    private String[] f40043u;

    /* renamed from: v  reason: collision with root package name */
    private String[] f40044v;

    /* renamed from: g  reason: collision with root package name */
    private String f40029g = "";

    /* renamed from: l  reason: collision with root package name */
    private boolean f40034l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40035m = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f40045w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f40046x = false;

    /* renamed from: y  reason: collision with root package name */
    private boolean f40047y = false;

    /* renamed from: a  reason: collision with root package name */
    final Messenger f40024a = new Messenger(new HandlerC0746b());

    /* renamed from: z  reason: collision with root package name */
    private ServiceConnection f40048z = new ServiceConnection() { // from class: com.mbridge.msdk.mbdownload.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.a(b.f40023b, "ServiceConnection.onServiceConnected");
            b.this.f40027e = new Messenger(iBinder);
            try {
                Message obtain = Message.obtain((Handler) null, 4);
                a aVar = new a(b.this.f40028f, b.this.f40029g, b.this.f40030h, b.this.f40033k, b.this.f40034l);
                aVar.f40054e = b.this.f40031i;
                aVar.f40055f = b.this.f40032j;
                aVar.f40050a = b.this.f40037o;
                aVar.f40060k = b.this.f40039q;
                aVar.f40062m = b.this.f40043u;
                aVar.f40063n = b.this.f40040r;
                aVar.f40064o = b.this.f40041s;
                aVar.f40065p = b.this.f40042t;
                aVar.f40061l = b.this.f40044v;
                aVar.f40066q = b.this.f40045w;
                aVar.f40067r = b.this.f40046x;
                aVar.f40068s = b.this.f40047y;
                aVar.f40059j = b.this.f40036n;
                aVar.f40058i = b.this.f40035m;
                Bundle bundle = new Bundle();
                bundle.putString("mComponentName", aVar.f40051b);
                bundle.putString("mTitle", aVar.f40052c);
                bundle.putString("mUrl", aVar.f40053d);
                bundle.putString("mMd5", aVar.f40054e);
                bundle.putString("mTargetMd5", aVar.f40055f);
                bundle.putString("uniqueKey", aVar.f40056g);
                bundle.putString("mReqClz", aVar.f40050a);
                bundle.putStringArray("succUrls", aVar.f40060k);
                bundle.putStringArray("faiUrls", aVar.f40062m);
                bundle.putStringArray("startUrls", aVar.f40063n);
                bundle.putStringArray("pauseUrls", aVar.f40064o);
                bundle.putStringArray("cancelUrls", aVar.f40065p);
                bundle.putStringArray("carryonUrls", aVar.f40061l);
                bundle.putBoolean("rich_notification", aVar.f40066q);
                bundle.putBoolean("mSilent", aVar.f40067r);
                bundle.putBoolean("mWifiOnly", aVar.f40068s);
                bundle.putBoolean("mOnGoingStatus", aVar.f40057h);
                bundle.putBoolean("mCanPause", aVar.f40058i);
                bundle.putString("mTargetAppIconUrl", aVar.f40059j);
                obtain.setData(bundle);
                b bVar = b.this;
                obtain.replyTo = bVar.f40024a;
                bVar.f40027e.send(obtain);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            x.a(b.f40023b, "ServiceConnection.onServiceDisconnected");
            b.this.f40027e = null;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f40025c = StubApp.getOrigApplicationContext(com.mbridge.msdk.foundation.controller.a.f().j().getApplicationContext());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadAgent.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f40050a;

        /* renamed from: b  reason: collision with root package name */
        public String f40051b;

        /* renamed from: c  reason: collision with root package name */
        public String f40052c;

        /* renamed from: d  reason: collision with root package name */
        public String f40053d;

        /* renamed from: e  reason: collision with root package name */
        public String f40054e;

        /* renamed from: f  reason: collision with root package name */
        public String f40055f;

        /* renamed from: g  reason: collision with root package name */
        public String f40056g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40057h;

        /* renamed from: j  reason: collision with root package name */
        public String f40059j;

        /* renamed from: i  reason: collision with root package name */
        public boolean f40058i = false;

        /* renamed from: k  reason: collision with root package name */
        public String[] f40060k = null;

        /* renamed from: l  reason: collision with root package name */
        public String[] f40061l = null;

        /* renamed from: m  reason: collision with root package name */
        public String[] f40062m = null;

        /* renamed from: n  reason: collision with root package name */
        public String[] f40063n = null;

        /* renamed from: o  reason: collision with root package name */
        public String[] f40064o = null;

        /* renamed from: p  reason: collision with root package name */
        public String[] f40065p = null;

        /* renamed from: q  reason: collision with root package name */
        public boolean f40066q = false;

        /* renamed from: r  reason: collision with root package name */
        public boolean f40067r = false;

        /* renamed from: s  reason: collision with root package name */
        public boolean f40068s = false;

        public a(String str, String str2, String str3, String str4, boolean z3) {
            this.f40051b = str;
            this.f40052c = str2;
            this.f40053d = str3;
            this.f40056g = str4;
            this.f40057h = z3;
        }
    }

    /* compiled from: DownloadAgent.java */
    /* renamed from: com.mbridge.msdk.mbdownload.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class HandlerC0746b extends Handler {
        HandlerC0746b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i4 = message.what;
                if (i4 == 1) {
                    if (b.this.f40026d != null) {
                        b.this.f40026d.onStart();
                    }
                } else if (i4 == 2) {
                    if (b.this.f40026d != null) {
                        b.this.f40026d.onStatus(message.arg1);
                    }
                } else if (i4 == 3) {
                    if (b.this.f40026d != null) {
                        b.this.f40026d.onProgressUpdate(message.arg1);
                    }
                } else if (i4 != 5) {
                    super.handleMessage(message);
                } else {
                    try {
                        if (b.this.f40048z != null) {
                            b.this.f40025c.unbindService(b.this.f40048z);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (b.this.f40026d != null) {
                        int i5 = message.arg1;
                        if (i5 != 1 && i5 != 3 && i5 != 5) {
                            b.this.f40026d.onEnd(8, 0, null);
                            x.a(b.f40023b, "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
                            return;
                        }
                        b.this.f40026d.onEnd(message.arg1, message.arg2, message.getData().getString("filename"));
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                String str = b.f40023b;
                x.a(str, "DownloadAgent.handleMessage(" + message.what + "): " + e5.getMessage());
            }
        }
    }

    public b(String str, String str2, String str3) {
        this.f40028f = "none";
        this.f40028f = str2;
        this.f40030h = str3;
        this.f40033k = str;
    }

    public String getTargetAppIconUrl() {
        return this.f40036n;
    }

    public boolean isCanPause() {
        return this.f40035m;
    }

    public boolean isOnGoingStatus() {
        return this.f40034l;
    }

    public void setCanPause(boolean z3) {
        this.f40035m = z3;
    }

    public void setCancelUrls(String... strArr) {
        this.f40042t = strArr;
    }

    public void setCarryOnUrls(String... strArr) {
        this.f40044v = strArr;
    }

    public void setDownloadClz(String str) {
        this.f40038p = str;
    }

    public void setDownloadListener(IDownloadListener iDownloadListener) {
        this.f40026d = iDownloadListener;
    }

    public void setFaiUrls(String... strArr) {
        this.f40043u = strArr;
    }

    public void setMd5(String str) {
        this.f40031i = str;
    }

    public void setOnGoingStatus(boolean z3) {
        this.f40034l = z3;
    }

    public void setPauseUrls(String... strArr) {
        this.f40041s = strArr;
    }

    public void setReportClz(String str) {
        this.f40037o = str;
    }

    public void setRichNotification(boolean z3) {
        this.f40045w = z3;
    }

    public void setSilentDownload(boolean z3) {
        this.f40046x = z3;
    }

    public void setStartUrls(String... strArr) {
        this.f40040r = strArr;
    }

    public void setSuccUrls(String... strArr) {
        this.f40039q = strArr;
    }

    public void setTargetAppIconUrl(String str) {
        this.f40036n = str;
    }

    public void setTargetMd5(String str) {
        this.f40032j = str;
    }

    public b setTitle(String str) {
        this.f40029g = str;
        return this;
    }

    public void setWifiOnly(boolean z3) {
        this.f40047y = z3;
    }

    public void start() {
        String str = this.f40038p;
        if (str != null) {
            try {
                Class<?> cls = Class.forName(str);
                this.f40025c.bindService(new Intent(this.f40025c, cls), this.f40048z, 1);
                this.f40025c.startService(new Intent(this.f40025c, cls));
                return;
            } catch (ClassNotFoundException e4) {
                throw new IllegalArgumentException(e4);
            }
        }
        throw new IllegalArgumentException("cannot find MBService");
    }
}
