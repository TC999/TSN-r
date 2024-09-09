package com.bytedance.sdk.component.ev.xv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.t;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    private sr ev;
    private int fz;

    /* renamed from: r  reason: collision with root package name */
    private Context f29773r;
    private boolean sr;
    private w ux;
    private c xv;

    /* renamed from: w  reason: collision with root package name */
    private long f29776w = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29770f = false;
    private int gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private long f29772p = 19700101000L;

    /* renamed from: k  reason: collision with root package name */
    private int f29771k = 0;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f29768a = new HashMap<>();
    private HashMap<String, Integer> bk = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    private int f29775t = 0;
    private HashMap<String, Integer> ys = new HashMap<>();
    private HashMap<String, Integer> fp = new HashMap<>();
    private boolean ia = true;

    /* renamed from: s  reason: collision with root package name */
    private Map<String, Integer> f29774s = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Handler f29769c = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.ev.xv.ux.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            ux.this.w(message.arg1 != 0);
        }
    };

    private ux() {
    }

    private boolean c(int i4) {
        return i4 >= 200 && i4 < 400;
    }

    private void gd() {
        SharedPreferences w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29773r, c(), 0);
        this.gd = w3.getInt("tnc_probe_cmd", 0);
        this.f29772p = w3.getLong("tnc_probe_version", 19700101000L);
    }

    private void p() {
        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "resetTNCControlState");
        this.f29771k = 0;
        this.f29768a.clear();
        this.bk.clear();
        this.f29775t = 0;
        this.ys.clear();
        this.fp.clear();
    }

    public sr ev() {
        return this.ev;
    }

    public xv f() {
        sr srVar = this.ev;
        if (srVar != null) {
            return srVar.xv();
        }
        return null;
    }

    public Map<String, String> r() {
        xv f4 = f();
        if (f4 != null) {
            return f4.sr;
        }
        return null;
    }

    public w sr() {
        return this.ux;
    }

    public void ux() {
        this.f29774s.clear();
    }

    public c w() {
        return this.xv;
    }

    public boolean xv() {
        return this.sr;
    }

    private boolean sr(String str) {
        Map<String, String> r3 = r();
        if (r3 == null) {
            return false;
        }
        String str2 = r3.get(str);
        if (TextUtils.isEmpty(str2) || this.f29774s.get(str2) == null || this.f29774s.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    private void w(String str) {
        Map<String, String> r3;
        if (TextUtils.isEmpty(str) || (r3 = r()) == null || !r3.containsValue(str)) {
            return;
        }
        if (this.f29774s.get(str) == null) {
            this.f29774s.put(str, 1);
        } else {
            this.f29774s.put(str, Integer.valueOf(this.f29774s.get(str).intValue() + 1));
        }
    }

    private void xv(String str) {
        if (!TextUtils.isEmpty(str) && this.f29774s.containsKey(str)) {
            this.f29774s.put(str, 0);
        }
    }

    public String c() {
        return "ttnet_tnc_config" + this.fz;
    }

    public void c(boolean z3) {
        this.sr = z3;
    }

    public void c(w wVar) {
        this.ux = wVar;
    }

    public synchronized void c(Context context, boolean z3) {
        if (!this.f29770f) {
            this.f29773r = context;
            this.ia = z3;
            this.ev = new sr(context, z3, this.fz);
            if (z3) {
                gd();
            }
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "initTnc, isMainProc: " + z3 + " probeCmd: " + this.gd + " probeVersion: " + this.f29772p);
            this.xv = r.c().c(this.fz, this.f29773r);
            this.f29770f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z3) {
        xv f4 = f();
        if (f4 == null) {
            return;
        }
        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doUpdateRemote, " + z3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z3 && this.f29776w + (f4.f29781k * 1000) > elapsedRealtime) {
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doUpdateRemote, time limit");
            return;
        }
        this.f29776w = elapsedRealtime;
        r.c().c(this.fz, this.f29773r).xv();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Lf8
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            r1.printStackTrace()
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Lf8
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lf8
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L54
            goto Lf8
        L54:
            boolean r1 = r6.sr(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.component.ev.sr.xv.xv(r3, r0)
            return r7
        L71:
            java.util.Map r1 = r6.r()
            if (r1 == 0) goto Le4
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L7e
            goto Le4
        L7e:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L8b
            return r7
        L8b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleHostMapping, match, origin: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.bytedance.sdk.component.ev.sr.xv.xv(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Lcf
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Lcf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleHostMapping, target: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.ev.sr.xv.xv(r3, r0)
            return r7
        Le4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.component.ev.sr.xv.xv(r3, r0)
        Lf8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.xv.ux.c(java.lang.String):java.lang.String");
    }

    public ux(int i4) {
        this.fz = i4;
    }

    private boolean w(int i4) {
        if (i4 < 100 || i4 >= 1000) {
            return true;
        }
        xv f4 = f();
        if (f4 == null || TextUtils.isEmpty(f4.bk)) {
            return false;
        }
        String str = f4.bk;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i4);
        return str.contains(sb.toString());
    }

    public synchronized void c(t tVar, fp fpVar) {
        if (tVar == null || fpVar == null) {
            return;
        }
        if (this.ia) {
            if (com.bytedance.sdk.component.ev.sr.f.c(this.f29773r)) {
                URL url = null;
                try {
                    url = tVar.w().c();
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String c4 = c(tVar);
                int xv = fpVar.xv();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(c4)) {
                        return;
                    }
                    com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + c4 + "#" + xv);
                    xv f4 = f();
                    if (f4 != null && f4.f29785w) {
                        c(fpVar, host);
                    }
                    if (f4 == null) {
                        return;
                    }
                    com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + c4 + "#" + xv + " " + this.f29771k + "#" + this.f29768a.size() + "#" + this.bk.size() + " " + this.f29775t + "#" + this.ys.size() + "#" + this.fp.size());
                    if (xv > 0) {
                        if (c(xv)) {
                            if (this.f29771k > 0 || this.f29775t > 0) {
                                p();
                            }
                            xv(host);
                        } else if (!w(xv)) {
                            this.f29775t++;
                            this.ys.put(path, 0);
                            this.fp.put(c4, 0);
                            if (this.f29775t >= f4.ev && this.ys.size() >= f4.gd && this.fp.size() >= f4.f29782p) {
                                com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + c4 + "#" + xv);
                                c(false, 0L);
                                p();
                            }
                            w(host);
                        }
                    }
                }
            }
        }
    }

    private String c(t tVar) {
        if (tVar == null || tVar.w() == null) {
            return "";
        }
        if (tVar.w().c() != null) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return InetAddress.getByName(tVar.w().c().getHost()).getHostAddress();
    }

    public synchronized void c(t tVar, Exception exc) {
        if (tVar != null) {
            if (tVar.w() != null && exc != null) {
                if (this.ia) {
                    if (com.bytedance.sdk.component.ev.sr.f.c(this.f29773r)) {
                        URL url = null;
                        try {
                            url = tVar.w().c();
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String c4 = c(tVar);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            xv f4 = f();
                            if (f4 == null) {
                                return;
                            }
                            com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + c4 + "# " + this.f29771k + "#" + this.f29768a.size() + "#" + this.bk.size() + " " + this.f29775t + "#" + this.ys.size() + "#" + this.fp.size());
                            this.f29771k = this.f29771k + 1;
                            this.f29768a.put(path, 0);
                            this.bk.put(c4, 0);
                            if (this.f29771k >= f4.ux && this.f29768a.size() >= f4.f29780f && this.bk.size() >= f4.f29783r) {
                                com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + c4);
                                c(false, 0L);
                                p();
                            }
                            w(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bytedance.sdk.component.w.c.fp r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.xv.ux.c(com.bytedance.sdk.component.w.c.fp, java.lang.String):void");
    }

    private void c(boolean z3, long j4) {
        if (this.f29769c.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.f29769c.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z3 ? 1 : 0;
        if (j4 > 0) {
            this.f29769c.sendMessageDelayed(obtainMessage, j4);
        } else {
            this.f29769c.sendMessage(obtainMessage);
        }
    }
}
