package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TNCManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements c {

    /* renamed from: b  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a f738b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f739c;

    /* renamed from: d  reason: collision with root package name */
    private b f740d;

    /* renamed from: f  reason: collision with root package name */
    private Context f742f;

    /* renamed from: g  reason: collision with root package name */
    private e f743g;

    /* renamed from: r  reason: collision with root package name */
    private int f754r;

    /* renamed from: a  reason: collision with root package name */
    private long f737a = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f741e = false;

    /* renamed from: h  reason: collision with root package name */
    private int f744h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f745i = 19700101000L;

    /* renamed from: j  reason: collision with root package name */
    private int f746j = 0;

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, Integer> f747k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private HashMap<String, Integer> f748l = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private int f749m = 0;

    /* renamed from: n  reason: collision with root package name */
    private HashMap<String, Integer> f750n = new HashMap<>();

    /* renamed from: o  reason: collision with root package name */
    private HashMap<String, Integer> f751o = new HashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private boolean f752p = true;

    /* renamed from: q  reason: collision with root package name */
    private Map<String, Integer> f753q = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    Handler f755s = new a(Looper.getMainLooper());

    /* compiled from: TNCManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.b(message.arg1 != 0);
        }
    }

    private f() {
    }

    private boolean b(int i4) {
        return i4 >= 200 && i4 < 400;
    }

    private void i() {
        SharedPreferences sharedPreferences = this.f742f.getSharedPreferences(f(), 0);
        this.f744h = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f745i = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "resetTNCControlState");
        this.f746j = 0;
        this.f747k.clear();
        this.f748l.clear();
        this.f749m = 0;
        this.f750n.clear();
        this.f751o.clear();
    }

    public b b() {
        return this.f740d;
    }

    public d c() {
        e eVar = this.f743g;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public e d() {
        return this.f743g;
    }

    public Map<String, String> e() {
        d c4 = c();
        if (c4 != null) {
            return c4.f722d;
        }
        return null;
    }

    public String f() {
        return "ttnet_tnc_config" + this.f754r;
    }

    public boolean g() {
        return this.f739c;
    }

    public void h() {
        this.f753q.clear();
    }

    private void b(String str) {
        Map<String, String> e4;
        if (TextUtils.isEmpty(str) || (e4 = e()) == null || !e4.containsValue(str)) {
            return;
        }
        if (this.f753q.get(str) == null) {
            this.f753q.put(str, 1);
        } else {
            this.f753q.put(str, Integer.valueOf(this.f753q.get(str).intValue() + 1));
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f753q.containsKey(str)) {
            this.f753q.put(str, 0);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a a() {
        return this.f738b;
    }

    private boolean c(String str) {
        Map<String, String> e4 = e();
        if (e4 == null) {
            return false;
        }
        String str2 = e4.get(str);
        if (TextUtils.isEmpty(str2) || this.f753q.get(str2) == null || this.f753q.get(str2).intValue() < 3) {
            return false;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    public void a(boolean z3) {
        this.f739c = z3;
    }

    public void a(b bVar) {
        this.f740d = bVar;
    }

    public synchronized void a(Context context, boolean z3) {
        if (!this.f741e) {
            this.f742f = context;
            this.f752p = z3;
            this.f743g = new e(context, z3, this.f754r);
            if (z3) {
                i();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "initTnc, isMainProc: " + z3 + " probeCmd: " + this.f744h + " probeVersion: " + this.f745i);
            this.f738b = h.a().a(this.f754r, this.f742f);
            this.f741e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z3) {
        d c4 = c();
        if (c4 == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doUpdateRemote, " + z3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z3 && this.f737a + (c4.f729k * 1000) > elapsedRealtime) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doUpdateRemote, time limit");
            return;
        }
        this.f737a = elapsedRealtime;
        h.a().a(this.f754r, this.f742f).a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f742f));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r7) {
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
            boolean r1 = r6.c(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r0)
            return r7
        L71:
            java.util.Map r1 = r6.e()
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r4)
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r0)
            return r7
        Le4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r0)
        Lf8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f.a(java.lang.String):java.lang.String");
    }

    public f(int i4) {
        this.f754r = i4;
    }

    public synchronized void a(y yVar, a0 a0Var) {
        if (yVar == null || a0Var == null) {
            return;
        }
        if (this.f752p) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f742f)) {
                URL url = null;
                try {
                    url = yVar.g().o();
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String a4 = a(yVar);
                int c4 = a0Var.c();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(a4)) {
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + a4 + "#" + c4);
                    d c5 = c();
                    if (c5 != null && c5.f720b) {
                        a(a0Var, host);
                    }
                    if (c5 == null) {
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + a4 + "#" + c4 + " " + this.f746j + "#" + this.f747k.size() + "#" + this.f748l.size() + " " + this.f749m + "#" + this.f750n.size() + "#" + this.f751o.size());
                    if (c4 > 0) {
                        if (b(c4)) {
                            if (this.f746j > 0 || this.f749m > 0) {
                                j();
                            }
                            d(host);
                        } else if (!a(c4)) {
                            this.f749m++;
                            this.f750n.put(path, 0);
                            this.f751o.put(a4, 0);
                            if (this.f749m >= c5.f726h && this.f750n.size() >= c5.f727i && this.f751o.size() >= c5.f728j) {
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + a4 + "#" + c4);
                                a(false, 0L);
                                j();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    private String a(y yVar) {
        if (yVar == null || yVar.g() == null) {
            return "";
        }
        if (yVar.g().o() != null) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return InetAddress.getByName(yVar.g().o().getHost()).getHostAddress();
    }

    public synchronized void a(y yVar, Exception exc) {
        if (yVar != null) {
            if (yVar.g() != null && exc != null) {
                if (this.f752p) {
                    if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f742f)) {
                        URL url = null;
                        try {
                            url = yVar.g().o();
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String a4 = a(yVar);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            d c4 = c();
                            if (c4 == null) {
                                return;
                            }
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + a4 + "# " + this.f746j + "#" + this.f747k.size() + "#" + this.f748l.size() + " " + this.f749m + "#" + this.f750n.size() + "#" + this.f751o.size());
                            this.f746j = this.f746j + 1;
                            this.f747k.put(path, 0);
                            this.f748l.put(a4, 0);
                            if (this.f746j >= c4.f723e && this.f747k.size() >= c4.f724f && this.f748l.size() >= c4.f725g) {
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + a4);
                                a(false, 0L);
                                j();
                            }
                            b(host);
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
    private void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0 r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, java.lang.String):void");
    }

    private void a(boolean z3, long j4) {
        if (this.f755s.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.f755s.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z3 ? 1 : 0;
        if (j4 > 0) {
            this.f755s.sendMessageDelayed(obtainMessage, j4);
        } else {
            this.f755s.sendMessage(obtainMessage);
        }
    }

    private boolean a(int i4) {
        if (i4 < 100 || i4 >= 1000) {
            return true;
        }
        d c4 = c();
        if (c4 == null || TextUtils.isEmpty(c4.f731m)) {
            return false;
        }
        String str = c4.f731m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i4);
        return str.contains(sb.toString());
    }
}
