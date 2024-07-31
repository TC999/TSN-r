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
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.IDownloadListener;
import com.stub.StubApp;

/* renamed from: com.mbridge.msdk.mbdownload.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadAgent {

    /* renamed from: b */
    private static final String f31251b = "com.mbridge.msdk.mbdownload.b";

    /* renamed from: d */
    private IDownloadListener f31254d;

    /* renamed from: e */
    private Messenger f31255e;

    /* renamed from: f */
    private String f31256f;

    /* renamed from: h */
    private String f31258h;

    /* renamed from: i */
    private String f31259i;

    /* renamed from: j */
    private String f31260j;

    /* renamed from: k */
    private String f31261k;

    /* renamed from: n */
    private String f31264n;

    /* renamed from: o */
    private String f31265o;

    /* renamed from: p */
    private String f31266p;

    /* renamed from: q */
    private String[] f31267q;

    /* renamed from: r */
    private String[] f31268r;

    /* renamed from: s */
    private String[] f31269s;

    /* renamed from: t */
    private String[] f31270t;

    /* renamed from: u */
    private String[] f31271u;

    /* renamed from: v */
    private String[] f31272v;

    /* renamed from: g */
    private String f31257g = "";

    /* renamed from: l */
    private boolean f31262l = true;

    /* renamed from: m */
    private boolean f31263m = false;

    /* renamed from: w */
    private boolean f31273w = false;

    /* renamed from: x */
    private boolean f31274x = false;

    /* renamed from: y */
    private boolean f31275y = false;

    /* renamed from: a */
    final Messenger f31252a = new Messenger(new HandlerC11461b());

    /* renamed from: z */
    private ServiceConnection f31276z = new ServiceConnection() { // from class: com.mbridge.msdk.mbdownload.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SameLogTool.m21738a(DownloadAgent.f31251b, "ServiceConnection.onServiceConnected");
            DownloadAgent.this.f31255e = new Messenger(iBinder);
            try {
                Message obtain = Message.obtain((Handler) null, 4);
                C11460a c11460a = new C11460a(DownloadAgent.this.f31256f, DownloadAgent.this.f31257g, DownloadAgent.this.f31258h, DownloadAgent.this.f31261k, DownloadAgent.this.f31262l);
                c11460a.f31282e = DownloadAgent.this.f31259i;
                c11460a.f31283f = DownloadAgent.this.f31260j;
                c11460a.f31278a = DownloadAgent.this.f31265o;
                c11460a.f31288k = DownloadAgent.this.f31267q;
                c11460a.f31290m = DownloadAgent.this.f31271u;
                c11460a.f31291n = DownloadAgent.this.f31268r;
                c11460a.f31292o = DownloadAgent.this.f31269s;
                c11460a.f31293p = DownloadAgent.this.f31270t;
                c11460a.f31289l = DownloadAgent.this.f31272v;
                c11460a.f31294q = DownloadAgent.this.f31273w;
                c11460a.f31295r = DownloadAgent.this.f31274x;
                c11460a.f31296s = DownloadAgent.this.f31275y;
                c11460a.f31287j = DownloadAgent.this.f31264n;
                c11460a.f31286i = DownloadAgent.this.f31263m;
                Bundle bundle = new Bundle();
                bundle.putString("mComponentName", c11460a.f31279b);
                bundle.putString("mTitle", c11460a.f31280c);
                bundle.putString("mUrl", c11460a.f31281d);
                bundle.putString("mMd5", c11460a.f31282e);
                bundle.putString("mTargetMd5", c11460a.f31283f);
                bundle.putString("uniqueKey", c11460a.f31284g);
                bundle.putString("mReqClz", c11460a.f31278a);
                bundle.putStringArray("succUrls", c11460a.f31288k);
                bundle.putStringArray("faiUrls", c11460a.f31290m);
                bundle.putStringArray("startUrls", c11460a.f31291n);
                bundle.putStringArray("pauseUrls", c11460a.f31292o);
                bundle.putStringArray("cancelUrls", c11460a.f31293p);
                bundle.putStringArray("carryonUrls", c11460a.f31289l);
                bundle.putBoolean("rich_notification", c11460a.f31294q);
                bundle.putBoolean("mSilent", c11460a.f31295r);
                bundle.putBoolean("mWifiOnly", c11460a.f31296s);
                bundle.putBoolean("mOnGoingStatus", c11460a.f31285h);
                bundle.putBoolean("mCanPause", c11460a.f31286i);
                bundle.putString("mTargetAppIconUrl", c11460a.f31287j);
                obtain.setData(bundle);
                DownloadAgent downloadAgent = DownloadAgent.this;
                obtain.replyTo = downloadAgent.f31252a;
                downloadAgent.f31255e.send(obtain);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            SameLogTool.m21738a(DownloadAgent.f31251b, "ServiceConnection.onServiceDisconnected");
            DownloadAgent.this.f31255e = null;
        }
    };

    /* renamed from: c */
    private Context f31253c = StubApp.getOrigApplicationContext(MBSDKContext.m22865f().m22861j().getApplicationContext());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadAgent.java */
    /* renamed from: com.mbridge.msdk.mbdownload.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11460a {

        /* renamed from: a */
        public String f31278a;

        /* renamed from: b */
        public String f31279b;

        /* renamed from: c */
        public String f31280c;

        /* renamed from: d */
        public String f31281d;

        /* renamed from: e */
        public String f31282e;

        /* renamed from: f */
        public String f31283f;

        /* renamed from: g */
        public String f31284g;

        /* renamed from: h */
        public boolean f31285h;

        /* renamed from: j */
        public String f31287j;

        /* renamed from: i */
        public boolean f31286i = false;

        /* renamed from: k */
        public String[] f31288k = null;

        /* renamed from: l */
        public String[] f31289l = null;

        /* renamed from: m */
        public String[] f31290m = null;

        /* renamed from: n */
        public String[] f31291n = null;

        /* renamed from: o */
        public String[] f31292o = null;

        /* renamed from: p */
        public String[] f31293p = null;

        /* renamed from: q */
        public boolean f31294q = false;

        /* renamed from: r */
        public boolean f31295r = false;

        /* renamed from: s */
        public boolean f31296s = false;

        public C11460a(String str, String str2, String str3, String str4, boolean z) {
            this.f31279b = str;
            this.f31280c = str2;
            this.f31281d = str3;
            this.f31284g = str4;
            this.f31285h = z;
        }
    }

    /* compiled from: DownloadAgent.java */
    /* renamed from: com.mbridge.msdk.mbdownload.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class HandlerC11461b extends Handler {
        HandlerC11461b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 1) {
                    if (DownloadAgent.this.f31254d != null) {
                        DownloadAgent.this.f31254d.onStart();
                    }
                } else if (i == 2) {
                    if (DownloadAgent.this.f31254d != null) {
                        DownloadAgent.this.f31254d.onStatus(message.arg1);
                    }
                } else if (i == 3) {
                    if (DownloadAgent.this.f31254d != null) {
                        DownloadAgent.this.f31254d.onProgressUpdate(message.arg1);
                    }
                } else if (i != 5) {
                    super.handleMessage(message);
                } else {
                    try {
                        if (DownloadAgent.this.f31276z != null) {
                            DownloadAgent.this.f31253c.unbindService(DownloadAgent.this.f31276z);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (DownloadAgent.this.f31254d != null) {
                        int i2 = message.arg1;
                        if (i2 != 1 && i2 != 3 && i2 != 5) {
                            DownloadAgent.this.f31254d.onEnd(8, 0, null);
                            SameLogTool.m21738a(DownloadAgent.f31251b, "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
                            return;
                        }
                        DownloadAgent.this.f31254d.onEnd(message.arg1, message.arg2, message.getData().getString("filename"));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str = DownloadAgent.f31251b;
                SameLogTool.m21738a(str, "DownloadAgent.handleMessage(" + message.what + "): " + e2.getMessage());
            }
        }
    }

    public DownloadAgent(String str, String str2, String str3) {
        this.f31256f = "none";
        this.f31256f = str2;
        this.f31258h = str3;
        this.f31261k = str;
    }

    public String getTargetAppIconUrl() {
        return this.f31264n;
    }

    public boolean isCanPause() {
        return this.f31263m;
    }

    public boolean isOnGoingStatus() {
        return this.f31262l;
    }

    public void setCanPause(boolean z) {
        this.f31263m = z;
    }

    public void setCancelUrls(String... strArr) {
        this.f31270t = strArr;
    }

    public void setCarryOnUrls(String... strArr) {
        this.f31272v = strArr;
    }

    public void setDownloadClz(String str) {
        this.f31266p = str;
    }

    public void setDownloadListener(IDownloadListener iDownloadListener) {
        this.f31254d = iDownloadListener;
    }

    public void setFaiUrls(String... strArr) {
        this.f31271u = strArr;
    }

    public void setMd5(String str) {
        this.f31259i = str;
    }

    public void setOnGoingStatus(boolean z) {
        this.f31262l = z;
    }

    public void setPauseUrls(String... strArr) {
        this.f31269s = strArr;
    }

    public void setReportClz(String str) {
        this.f31265o = str;
    }

    public void setRichNotification(boolean z) {
        this.f31273w = z;
    }

    public void setSilentDownload(boolean z) {
        this.f31274x = z;
    }

    public void setStartUrls(String... strArr) {
        this.f31268r = strArr;
    }

    public void setSuccUrls(String... strArr) {
        this.f31267q = strArr;
    }

    public void setTargetAppIconUrl(String str) {
        this.f31264n = str;
    }

    public void setTargetMd5(String str) {
        this.f31260j = str;
    }

    public DownloadAgent setTitle(String str) {
        this.f31257g = str;
        return this;
    }

    public void setWifiOnly(boolean z) {
        this.f31275y = z;
    }

    public void start() {
        String str = this.f31266p;
        if (str != null) {
            try {
                Class<?> cls = Class.forName(str);
                this.f31253c.bindService(new Intent(this.f31253c, cls), this.f31276z, 1);
                this.f31253c.startService(new Intent(this.f31253c, cls));
                return;
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalArgumentException("cannot find MBService");
    }
}
