package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1008e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import com.clj.fastble.BleManager;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TNCManager implements TNCBridge {

    /* renamed from: b */
    private AppConfig f745b;

    /* renamed from: c */
    private boolean f746c;

    /* renamed from: d */
    private ITTAdNetDepend f747d;

    /* renamed from: f */
    private Context f749f;

    /* renamed from: g */
    private TNCConfigHandler f750g;

    /* renamed from: r */
    private int f761r;

    /* renamed from: a */
    private long f744a = 0;

    /* renamed from: e */
    private boolean f748e = false;

    /* renamed from: h */
    private int f751h = 0;

    /* renamed from: i */
    private long f752i = 19700101000L;

    /* renamed from: j */
    private int f753j = 0;

    /* renamed from: k */
    private HashMap<String, Integer> f754k = new HashMap<>();

    /* renamed from: l */
    private HashMap<String, Integer> f755l = new HashMap<>();

    /* renamed from: m */
    private int f756m = 0;

    /* renamed from: n */
    private HashMap<String, Integer> f757n = new HashMap<>();

    /* renamed from: o */
    private HashMap<String, Integer> f758o = new HashMap<>();

    /* renamed from: p */
    private boolean f759p = true;

    /* renamed from: q */
    private Map<String, Integer> f760q = new HashMap();

    /* renamed from: s */
    Handler f762s = new HandlerC0999a(Looper.getMainLooper());

    /* compiled from: TNCManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class HandlerC0999a extends Handler {
        HandlerC0999a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            TNCManager.this.m59018b(message.arg1 != 0);
        }
    }

    private TNCManager() {
    }

    /* renamed from: b */
    private boolean m59020b(int i) {
        return i >= 200 && i < 400;
    }

    /* renamed from: i */
    private void m59009i() {
        SharedPreferences sharedPreferences = this.f749f.getSharedPreferences(m59012f(), 0);
        this.f751h = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f752i = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    /* renamed from: j */
    private void m59008j() {
        C1003b.m58992a("TNCManager", "resetTNCControlState");
        this.f753j = 0;
        this.f754k.clear();
        this.f755l.clear();
        this.f756m = 0;
        this.f757n.clear();
        this.f758o.clear();
    }

    /* renamed from: b */
    public ITTAdNetDepend m59021b() {
        return this.f747d;
    }

    /* renamed from: c */
    public TNCConfig m59017c() {
        TNCConfigHandler tNCConfigHandler = this.f750g;
        if (tNCConfigHandler != null) {
            return tNCConfigHandler.m59038a();
        }
        return null;
    }

    /* renamed from: d */
    public TNCConfigHandler m59015d() {
        return this.f750g;
    }

    /* renamed from: e */
    public Map<String, String> m59013e() {
        TNCConfig m59017c = m59017c();
        if (m59017c != null) {
            return m59017c.f729d;
        }
        return null;
    }

    /* renamed from: f */
    public String m59012f() {
        return "ttnet_tnc_config" + this.f761r;
    }

    /* renamed from: g */
    public boolean m59011g() {
        return this.f746c;
    }

    /* renamed from: h */
    public void m59010h() {
        this.f760q.clear();
    }

    /* renamed from: b */
    private void m59019b(String str) {
        Map<String, String> m59013e;
        if (TextUtils.isEmpty(str) || (m59013e = m59013e()) == null || !m59013e.containsValue(str)) {
            return;
        }
        if (this.f760q.get(str) == null) {
            this.f760q.put(str, 1);
        } else {
            this.f760q.put(str, Integer.valueOf(this.f760q.get(str).intValue() + 1));
        }
    }

    /* renamed from: d */
    private void m59014d(String str) {
        if (!TextUtils.isEmpty(str) && this.f760q.containsKey(str)) {
            this.f760q.put(str, 0);
        }
    }

    /* renamed from: a */
    public AppConfig m59033a() {
        return this.f745b;
    }

    /* renamed from: c */
    private boolean m59016c(String str) {
        Map<String, String> m59013e = m59013e();
        if (m59013e == null) {
            return false;
        }
        String str2 = m59013e.get(str);
        if (TextUtils.isEmpty(str2) || this.f760q.get(str2) == null || this.f760q.get(str2).intValue() < 3) {
            return false;
        }
        C1003b.m58992a("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    /* renamed from: a */
    public void m59023a(boolean z) {
        this.f746c = z;
    }

    /* renamed from: a */
    public void m59030a(ITTAdNetDepend iTTAdNetDepend) {
        this.f747d = iTTAdNetDepend;
    }

    /* renamed from: a */
    public synchronized void m59031a(Context context, boolean z) {
        if (!this.f748e) {
            this.f749f = context;
            this.f759p = z;
            this.f750g = new TNCConfigHandler(context, z, this.f761r);
            if (z) {
                m59009i();
            }
            C1003b.m58992a("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.f751h + " probeVersion: " + this.f752i);
            this.f745b = TncInstanceManager.m59006a().m59004a(this.f761r, this.f749f);
            this.f748e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59018b(boolean z) {
        TNCConfig m59017c = m59017c();
        if (m59017c == null) {
            return;
        }
        C1003b.m58992a("TNCManager", "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.f744a + (m59017c.f736k * 1000) > elapsedRealtime) {
            C1003b.m58992a("TNCManager", "doUpdateRemote, time limit");
            return;
        }
        this.f744a = elapsedRealtime;
        TncInstanceManager.m59006a().m59004a(this.f761r, this.f749f).m59062a(C1008e.m58983a(this.f749f));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m59024a(java.lang.String r7) {
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
            boolean r1 = r6.m59016c(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b.m58992a(r3, r0)
            return r7
        L71:
            java.util.Map r1 = r6.m59013e()
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b.m58992a(r3, r4)
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b.m58992a(r3, r0)
            return r7
        Le4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b.m58992a(r3, r0)
        Lf8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TNCManager.m59024a(java.lang.String):java.lang.String");
    }

    public TNCManager(int i) {
        this.f761r = i;
    }

    /* renamed from: a */
    public synchronized void m59026a(Request request, Response response) {
        if (request == null || response == null) {
            return;
        }
        if (this.f759p) {
            if (C1008e.m58983a(this.f749f)) {
                URL url = null;
                try {
                    url = request.m58205g().m58299o();
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String m59027a = m59027a(request);
                int m58846c = response.m58846c();
                if (IDataSource.f43971a.equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(m59027a)) {
                        return;
                    }
                    C1003b.m58992a("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + m59027a + "#" + m58846c);
                    TNCConfig m59017c = m59017c();
                    if (m59017c != null && m59017c.f727b) {
                        m59028a(response, host);
                    }
                    if (m59017c == null) {
                        return;
                    }
                    C1003b.m58992a("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + m59027a + "#" + m58846c + " " + this.f753j + "#" + this.f754k.size() + "#" + this.f755l.size() + " " + this.f756m + "#" + this.f757n.size() + "#" + this.f758o.size());
                    if (m58846c > 0) {
                        if (m59020b(m58846c)) {
                            if (this.f753j > 0 || this.f756m > 0) {
                                m59008j();
                            }
                            m59014d(host);
                        } else if (!m59032a(m58846c)) {
                            this.f756m++;
                            this.f757n.put(path, 0);
                            this.f758o.put(m59027a, 0);
                            if (this.f756m >= m59017c.f733h && this.f757n.size() >= m59017c.f734i && this.f758o.size() >= m59017c.f735j) {
                                C1003b.m58992a("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + m59027a + "#" + m58846c);
                                m59022a(false, 0L);
                                m59008j();
                            }
                            m59019b(host);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private String m59027a(Request request) {
        if (request == null || request.m58205g() == null) {
            return "";
        }
        if (request.m58205g().m58299o() != null) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return InetAddress.getByName(request.m58205g().m58299o().getHost()).getHostAddress();
    }

    /* renamed from: a */
    public synchronized void m59025a(Request request, Exception exc) {
        if (request != null) {
            if (request.m58205g() != null && exc != null) {
                if (this.f759p) {
                    if (C1008e.m58983a(this.f749f)) {
                        URL url = null;
                        try {
                            url = request.m58205g().m58299o();
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String m59027a = m59027a(request);
                        if (IDataSource.f43971a.equals(protocol) || "https".equals(protocol)) {
                            TNCConfig m59017c = m59017c();
                            if (m59017c == null) {
                                return;
                            }
                            C1003b.m58992a("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + m59027a + "# " + this.f753j + "#" + this.f754k.size() + "#" + this.f755l.size() + " " + this.f756m + "#" + this.f757n.size() + "#" + this.f758o.size());
                            this.f753j = this.f753j + 1;
                            this.f754k.put(path, 0);
                            this.f755l.put(m59027a, 0);
                            if (this.f753j >= m59017c.f730e && this.f754k.size() >= m59017c.f731f && this.f755l.size() >= m59017c.f732g) {
                                C1003b.m58992a("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + m59027a);
                                m59022a(false, 0L);
                                m59008j();
                            }
                            m59019b(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m59028a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TNCManager.m59028a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, java.lang.String):void");
    }

    /* renamed from: a */
    private void m59022a(boolean z, long j) {
        if (this.f762s.hasMessages(BleManager.f22896l)) {
            return;
        }
        Message obtainMessage = this.f762s.obtainMessage();
        obtainMessage.what = BleManager.f22896l;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.f762s.sendMessageDelayed(obtainMessage, j);
        } else {
            this.f762s.sendMessage(obtainMessage);
        }
    }

    /* renamed from: a */
    private boolean m59032a(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        TNCConfig m59017c = m59017c();
        if (m59017c == null || TextUtils.isEmpty(m59017c.f738m)) {
            return false;
        }
        String str = m59017c.f738m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return str.contains(sb.toString());
    }
}
