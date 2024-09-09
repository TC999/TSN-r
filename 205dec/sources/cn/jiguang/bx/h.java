package cn.jiguang.bx;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: j  reason: collision with root package name */
    private static volatile h f3100j;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f3101k = new Object();

    /* renamed from: a  reason: collision with root package name */
    private cn.jiguang.bv.h f3102a;

    /* renamed from: b  reason: collision with root package name */
    private int f3103b;

    /* renamed from: c  reason: collision with root package name */
    private int f3104c;

    /* renamed from: g  reason: collision with root package name */
    private long f3108g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3109h;

    /* renamed from: l  reason: collision with root package name */
    private Context f3111l;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3105d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f3106e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f3107f = 0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3112m = false;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f3113n = new AtomicBoolean(false);

    /* renamed from: o  reason: collision with root package name */
    private cn.jiguang.cb.a f3114o = new cn.jiguang.cb.a() { // from class: cn.jiguang.bx.h.1
        @Override // cn.jiguang.cb.a
        public void a(Message message) {
            h hVar;
            Context context;
            String str;
            Bundle bundle;
            boolean z3;
            if (message != null) {
                int i4 = message.what;
                if (i4 == 1011) {
                    hVar = h.this;
                    context = hVar.f3111l;
                    str = "tcp_a14";
                } else if (i4 != 1022) {
                    if (i4 == 2000) {
                        k.a().a(h.this.f3111l);
                        return;
                    }
                    switch (i4) {
                        case 1004:
                            bundle = new Bundle();
                            z3 = true;
                            break;
                        case 1005:
                            bundle = new Bundle();
                            z3 = false;
                            break;
                        case 1006:
                        case 1007:
                            hVar = h.this;
                            context = hVar.f3111l;
                            str = "tcp_a2";
                            break;
                        default:
                            return;
                    }
                    bundle.putBoolean("force", z3);
                    h hVar2 = h.this;
                    hVar2.a(hVar2.f3111l, "tcp_a16", bundle);
                    return;
                } else {
                    hVar = h.this;
                    context = hVar.f3111l;
                    str = "tcp_a17";
                }
                hVar.a(context, str, null);
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private boolean f3115p = false;

    /* renamed from: q  reason: collision with root package name */
    private int f3116q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f3117r = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3110i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends cn.jiguang.cm.b {

        /* renamed from: b  reason: collision with root package name */
        private Context f3120b;

        /* renamed from: c  reason: collision with root package name */
        private String f3121c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f3122d;

        public a(Context context, String str, Bundle bundle) {
            this.f3120b = context;
            this.f3121c = str;
            this.f3122d = bundle;
            this.f3462h = "TcpManager";
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            h hVar;
            long j4;
            try {
                if (!this.f3121c.equals("tcp_a1")) {
                    if (!this.f3121c.equals("tcp_a3") && !this.f3121c.equals("tcp_a4") && !this.f3121c.equals("tcp_a20")) {
                        if (this.f3121c.equals("tcp_a5")) {
                            Bundle bundle = this.f3122d;
                            if (bundle != null) {
                                byte[] byteArray = bundle.getByteArray("body");
                                int i4 = this.f3122d.getInt("cmd", -1);
                                int i5 = this.f3122d.getInt("ver", -1);
                                long j5 = this.f3122d.getLong("rid", -1L);
                                String string = this.f3122d.getString("sdk_type");
                                long j6 = this.f3122d.getLong("timeout");
                                cn.jiguang.bq.d.c("JCoreTCPManager", "send quest,cmd:" + i4 + ",ver:" + i5 + ",rid:" + j5 + ",body size:" + byteArray.length);
                                if (i4 >= 0 && i5 >= 0 && j5 >= 0 && !TextUtils.isEmpty(string)) {
                                    j.a().a(this.f3120b, j5, i4, i5, byteArray, string, j6);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.f3121c.equals("tcp_a19")) {
                            Bundle bundle2 = this.f3122d;
                            if (bundle2 != null) {
                                h.this.f3105d = bundle2.getBoolean("connect_state", false);
                            }
                            h.this.l();
                            return;
                        } else if (this.f3121c.equals("tcp_a11")) {
                            cn.jiguang.bq.d.d("JCoreTCPManager", "resgiter success:" + cn.jiguang.d.a.b(this.f3120b));
                            cn.jiguang.f.a.g(this.f3120b);
                            b a4 = b.a();
                            Context context = this.f3120b;
                            a4.a(context, 0, 0, cn.jiguang.d.a.b(context));
                            e.a(this.f3120b, "on_register", null);
                            return;
                        } else if (this.f3121c.equals("tcp_a10")) {
                            h.this.j();
                            return;
                        } else if (this.f3121c.equals("tcp_a9")) {
                            h.this.d(this.f3120b);
                            return;
                        } else if (this.f3121c.equals("tcp_a8")) {
                            h.this.b(this.f3120b);
                            return;
                        } else if (this.f3121c.equals("tcp_a23")) {
                            h.this.m();
                            return;
                        } else if (this.f3121c.equals("tcp_a2")) {
                            g.a().a(this.f3120b, false);
                            h.this.a(this.f3122d);
                            return;
                        } else if (this.f3121c.equals("tcp_a13")) {
                            cn.jiguang.bq.d.d("JCoreTCPManager", "resgiter failed");
                            Bundle bundle3 = this.f3122d;
                            if (bundle3 != null) {
                                int i6 = bundle3.getInt("resCode", 0);
                                h.this.f3104c = i6;
                                cn.jiguang.bv.c.a(this.f3120b, i6);
                                return;
                            }
                            return;
                        } else if (this.f3121c.equals("tcp_a12")) {
                            cn.jiguang.bq.d.d("JCoreTCPManager", "login failed");
                            Bundle bundle4 = this.f3122d;
                            if (bundle4 != null) {
                                h.this.a(bundle4.getInt("resCode", 0));
                                return;
                            }
                            return;
                        } else if (this.f3121c.equals("tcp_a14")) {
                            hVar = h.this;
                        } else if (this.f3121c.equals("tcp_a15")) {
                            h.this.b(this.f3122d);
                            return;
                        } else if (this.f3121c.equals("tcp_a16")) {
                            h.this.c(this.f3122d);
                            return;
                        } else if (this.f3121c.equals("tcp_a17")) {
                            h.this.q();
                            return;
                        } else if (this.f3121c.equals("tcp_a18")) {
                            h.this.s();
                            return;
                        } else if (this.f3121c.equals("tcp_a6")) {
                            Bundle bundle5 = this.f3122d;
                            if (bundle5 != null) {
                                long j7 = bundle5.getLong("rid", -1L);
                                if (j7 > 0) {
                                    j.a().b(this.f3120b, j7);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.f3121c.equals("tcp_a7")) {
                            Bundle bundle6 = this.f3122d;
                            if (bundle6 != null) {
                                long j8 = bundle6.getLong("rid", -1L);
                                if (j8 > 0) {
                                    j.a().a(this.f3120b, j8);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.f3121c.equals("tcp_a21")) {
                            h.this.k();
                            return;
                        } else if (this.f3121c.equals("tcp_a22")) {
                            h.this.b();
                            return;
                        } else if (this.f3121c.equals("tcp_a23")) {
                            h.this.c(this.f3120b);
                            return;
                        } else if (!this.f3121c.equals("tcp_a24")) {
                            return;
                        } else {
                            h.this.m();
                            h.this.f3104c = 0;
                            h.this.f3103b = 0;
                            hVar = h.this;
                        }
                    }
                    if (h.this.f3102a != null) {
                        if (h.this.f3102a.d() != null) {
                            byte[] byteArray2 = this.f3122d.getByteArray("body");
                            int i7 = this.f3122d.getInt("cmd", -1);
                            int i8 = this.f3122d.getInt("ver", -1);
                            long j9 = this.f3122d.getLong("rid", -1L);
                            String string2 = this.f3122d.getString("sdk_type");
                            cn.jiguang.bq.d.c("JCoreTCPManager", "send data,cmd:" + i7 + ",ver:" + i8 + ",rid:" + j9 + ",body size:" + byteArray2.length);
                            if (i7 >= 0 && i8 >= 0 && j9 >= 0) {
                                if (this.f3121c.equals("tcp_a3")) {
                                    j.a().a(this.f3120b, j9, i7, i8, byteArray2, string2);
                                    return;
                                }
                                if (this.f3121c.equals("tcp_a20")) {
                                    long j10 = this.f3122d.getLong("uid", 0L);
                                    if (j10 == 0) {
                                        cn.jiguang.bq.d.i("JCoreTCPManager", "share response uid is 0");
                                        return;
                                    }
                                    j4 = j10;
                                } else {
                                    j4 = 0;
                                }
                                h.a().c().d().a(cn.jiguang.bz.b.a(this.f3120b, i7, i8, j9, byteArray2, j4));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    cn.jiguang.bq.d.c("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                    hVar = h.this;
                } else if (h.this.f3102a != null) {
                    return;
                } else {
                    hVar = h.this;
                }
                hVar.o();
            } catch (Throwable th) {
                cn.jiguang.bq.d.j("JCoreTCPManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    private h() {
    }

    public static h a() {
        if (f3100j == null) {
            synchronized (f3101k) {
                if (f3100j == null) {
                    f3100j = new h();
                }
            }
        }
        return f3100j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        this.f3103b = i4;
        if (i4 == 1012) {
            cn.jiguang.bv.c.a(this.f3111l);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        cn.jiguang.bq.d.c("JCoreTCPManager", "handleStop...");
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.Z())).booleanValue()) {
            cn.jiguang.bq.d.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
        } else {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.Z().a((cn.jiguang.g.a<Boolean>) Boolean.TRUE));
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.bq.d.c("JCoreTCPManager", "handleUnRegister...");
        if (!((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.L())).booleanValue()) {
            cn.jiguang.bq.d.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "Action: handleUnRegister - can't stop tcp");
        } else {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.L().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        String str;
        if (this.f3113n.get()) {
            str = "isBeating, skip this time";
        } else {
            if ((bundle != null ? bundle.getBoolean("force", false) : false) || !p()) {
                cn.jiguang.bq.d.d("JCoreTCPManager", "Send heart beat");
                cn.jiguang.cb.b.a().b(1005);
                if (this.f3109h) {
                    r();
                    return;
                } else {
                    cn.jiguang.bq.d.c("JCoreTCPManager", "socket is closed or push isn't login");
                    return;
                }
            }
            str = "No need to rtc, Because it have succeed recently";
        }
        cn.jiguang.bq.d.c("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        String str;
        cn.jiguang.bq.d.c("JCoreTCPManager", "handleResume...");
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.Z().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
        if (this.f3109h) {
            str = "[handleResume] is loggedin";
        } else if (this.f3102a == null) {
            o();
            return;
        } else {
            str = "[handleResume] tcp is connecting...";
        }
        cn.jiguang.bq.d.c("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - onLoggedIn");
        if (!this.f3109h) {
            this.f3109h = true;
            b.a().a(this.f3111l, 1, 0, "success");
        }
        b();
        this.f3106e = 0;
        this.f3107f = 0;
        cn.jiguang.bq.d.c("JCoreTCPManager", "Force to send 12s heartbeat after login");
        cn.jiguang.a.a.a(this.f3111l, true, 12000L);
        e.a(this.f3111l, "on_logged", null);
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", true);
        e.a(this.f3111l, "periodtask", bundle);
        if (k()) {
            cn.jiguang.cb.b.a().b(2000, 2000L, this.f3114o);
            cn.jiguang.e.a.b().a(this.f3111l);
            j.a().a(this.f3111l);
            g.a().a(this.f3111l, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (cn.jiguang.bk.c.a().a(this.f3111l) || k.a().b(this.f3111l)) {
            return true;
        }
        cn.jiguang.bq.d.c("JCoreTCPManager", "not keep tcp");
        this.f3110i = false;
        m();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - onDisconnected");
        if (this.f3109h) {
            this.f3109h = false;
            b.a().a(this.f3111l, -1, -1, "push connect break");
        }
        if (this.f3102a == null && ((Boolean) cn.jiguang.g.b.a(this.f3111l, cn.jiguang.g.a.Z())).booleanValue()) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        this.f3107f = 0;
        m();
        n();
        this.f3106e++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        cn.jiguang.bv.h hVar = this.f3102a;
        if (hVar == null) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "tcp has stopeed");
            return;
        }
        hVar.c();
        this.f3102a = null;
    }

    private void n() {
        String str;
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.f3106e);
        if (!cn.jiguang.f.a.e(StubApp.getOrigApplicationContext(this.f3111l.getApplicationContext()))) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "[retryConnect] network is not connect");
        } else if (this.f3104c > 0) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "[retryConnect] registerErrCode >0,registerErrCode:" + this.f3104c);
        } else {
            int d4 = cn.jiguang.f.a.d(StubApp.getOrigApplicationContext(this.f3111l.getApplicationContext()));
            int pow = (int) (Math.pow(2.0d, this.f3106e) * 3.0d * 1000.0d);
            int f4 = f();
            int i4 = (f4 * 1000) / 2;
            if (pow > i4) {
                pow = i4;
            }
            cn.jiguang.bq.d.c("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.f3106e + ",chargedLever:" + d4 + ",heartbeatInterval:" + f4 + ",delayTime:" + pow);
            if (d4 != 1 ? this.f3106e >= 5 : this.f3106e >= 30) {
                if (cn.jiguang.bv.c.d(StubApp.getOrigApplicationContext(this.f3111l.getApplicationContext())) && this.f3105d) {
                    cn.jiguang.bq.d.c("JCoreTCPManager", "tcp ssl retry connect times use up, use no ssl retry again.");
                    cn.jiguang.bv.c.a(false);
                    this.f3106e = 0;
                    cn.jiguang.cb.b.a().b(1011, pow, this.f3114o);
                    return;
                }
                str = "Give up to retry connect.";
            } else if (!cn.jiguang.cb.b.a().a(1011)) {
                cn.jiguang.cb.b.a().b(1011, pow, this.f3114o);
                return;
            } else {
                str = "Already has MSG_RESTART_CONN";
            }
            cn.jiguang.bq.d.c("JCoreTCPManager", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.f3110i) {
            cn.jiguang.bq.d.h("JCoreTCPManager", "need not keep tcp,next start app will re login");
        } else if (!cn.jiguang.f.a.e(StubApp.getOrigApplicationContext(this.f3111l.getApplicationContext()))) {
            cn.jiguang.bq.d.h("JCoreTCPManager", "No network connection. Give up to start connection thread.");
        } else if (((Boolean) cn.jiguang.g.b.a(this.f3111l, cn.jiguang.g.a.Z())).booleanValue()) {
            cn.jiguang.bq.d.e("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
        } else if (!cn.jiguang.cf.b.a().c(this.f3111l)) {
            cn.jiguang.bq.d.e("JCoreTCPManager", "[restartNetworkingClient] sdk limit");
        } else if (!((Boolean) cn.jiguang.g.b.a(this.f3111l, cn.jiguang.g.a.L())).booleanValue()) {
            cn.jiguang.bq.d.e("JCoreTCPManager", "[restartNetworkingClient] tcp has close by ups.unregister");
        } else {
            int i4 = this.f3104c;
            if (i4 != 1005 && i4 != 1006 && i4 != 1008 && i4 != 1009) {
                if (this.f3103b == 102) {
                    cn.jiguang.bq.d.k("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                    return;
                } else if (this.f3102a != null) {
                    cn.jiguang.bq.d.d("JCoreTCPManager", "NetworkingClient is running");
                    return;
                } else {
                    cn.jiguang.bv.h hVar = new cn.jiguang.bv.h(StubApp.getOrigApplicationContext(this.f3111l.getApplicationContext()));
                    this.f3102a = hVar;
                    hVar.b();
                    return;
                }
            }
            cn.jiguang.bq.d.c("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.f3104c);
            b.a().a(this.f3111l, 2002, this.f3104c, "");
        }
    }

    private boolean p() {
        int i4 = this.f3116q;
        long currentTimeMillis = System.currentTimeMillis() - this.f3108g;
        return i4 > 0 ? currentTimeMillis < ((long) (this.f3116q + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f3113n.set(false);
        this.f3107f++;
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + this.f3107f);
        cn.jiguang.bq.d.b("JCoreTCPManager", "============================================================");
        if (this.f3102a != null && !this.f3109h) {
            cn.jiguang.bq.d.d("JCoreTCPManager", "Is connecting now. Give up to retry.");
        } else if (!this.f3109h || this.f3107f > 1) {
            m();
            n();
        } else {
            cn.jiguang.bq.d.d("JCoreTCPManager", "Already logged in. Give up to retry.");
            cn.jiguang.cb.b.a().b(1005, 5000L, this.f3114o);
        }
    }

    private void r() {
        this.f3113n.set(true);
        cn.jiguang.cb.b.a().b(1022);
        Long valueOf = Long.valueOf(cn.jiguang.bv.c.c(this.f3111l));
        long f4 = cn.jiguang.d.a.f(this.f3111l);
        int i4 = cn.jiguang.bt.b.f2892b;
        cn.jiguang.bq.d.c("JCoreTCPManager", "heartbeat - juid:" + f4 + ", flag:1 ,userType:" + i4);
        byte[] a4 = cn.jiguang.bz.b.a(this.f3111l, cn.jiguang.bz.b.a(valueOf.longValue(), JConstants.tcpSessionId, f4, (short) 1, i4));
        if (a4 != null) {
            this.f3102a.d().a(a4);
        } else {
            cn.jiguang.bq.d.j("JCoreTCPManager", "send hb failed:sendData is null");
        }
        cn.jiguang.cb.b.a().b(1022, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, this.f3114o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        cn.jiguang.bq.d.d("JCoreTCPManager", "Action - onHeartbeatSucceed");
        b.a().a(this.f3111l, 19, 0, "ack success");
    }

    public synchronized void a(Context context) {
        if (this.f3112m) {
            return;
        }
        if (context == null) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "init context is null");
            return;
        }
        cn.jiguang.bq.d.c("JCoreTCPManager", "init tcp manager...");
        this.f3111l = StubApp.getOrigApplicationContext(context.getApplicationContext());
        cn.jiguang.bt.b.a("JCoreTCPManager");
        cn.jiguang.cb.b.a().a(this.f3111l);
        g.a().a(context, true);
        this.f3112m = true;
    }

    public void a(Context context, String str, Bundle bundle) {
        a(context);
        cn.jiguang.bt.b.b(new a(context, str, bundle), new int[0]);
    }

    public void a(Bundle bundle) {
        long j4;
        if (((Boolean) cn.jiguang.g.b.a(this.f3111l, cn.jiguang.g.a.Z())).booleanValue()) {
            cn.jiguang.bq.d.d("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z3 = true;
        if (bundle != null) {
            z3 = bundle.getBoolean("force", true);
            j4 = bundle.getLong("delay_time", 0L);
        } else {
            j4 = 0;
        }
        if (this.f3102a == null) {
            o();
            return;
        }
        if (j4 <= 0) {
            c(bundle);
        } else {
            if (z3) {
                cn.jiguang.cb.b.a().b(1005);
                cn.jiguang.cb.b.a().b(1004);
            }
            cn.jiguang.cb.b.a().b(z3 ? 1004 : 1005, j4, this.f3114o);
        }
        cn.jiguang.bq.d.f("JCoreTCPManager", "send rtc force=" + z3 + " delay=" + j4);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean optBoolean = jSONObject.optBoolean("use_ssp");
                this.f3115p = optBoolean;
                if (optBoolean) {
                    int optInt = jSONObject.optInt("hb_interval");
                    if (optInt <= 0) {
                        cn.jiguang.bq.d.i("JCoreTCPManager", "hb_interval is less than 0, will use 15s");
                        this.f3116q = 15;
                    } else if (optInt >= JConstants.DEFAULT_HEARTBEAT_INTERVAL / 2) {
                        cn.jiguang.bq.d.i("JCoreTCPManager", "hb_interval is more than " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + ", will use " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + "s");
                        int i4 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                        this.f3116q = 0;
                    } else {
                        cn.jiguang.bq.d.i("JCoreTCPManager", "set ssp heartbeat interval:" + optInt);
                        this.f3116q = optInt;
                    }
                    if (this.f3116q > 0) {
                        i();
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("JCoreTCPManager", "[TcpManager] handleCtrlHeartBeatCmd error:" + th);
            }
        }
    }

    public void b() {
        cn.jiguang.cb.b.a().b(1022);
        this.f3108g = System.currentTimeMillis();
        this.f3107f = 0;
        this.f3113n.set(false);
        cn.jiguang.bq.d.f("JCoreTCPManager", "update rtc state");
    }

    public void b(Bundle bundle) {
        if (((Boolean) cn.jiguang.g.b.a(this.f3111l, cn.jiguang.g.a.Z())).booleanValue()) {
            cn.jiguang.bq.d.i("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        cn.jiguang.cb.b.a().b(1006);
        cn.jiguang.cb.b.a().b(1007);
        if (!bundle.getBoolean("connected", false)) {
            cn.jiguang.bq.d.c("JCoreTCPManager", "Handle disconnected state.");
            cn.jiguang.cb.b.a().b(1007, 3000L, this.f3114o);
            return;
        }
        cn.jiguang.bq.d.c("JCoreTCPManager", "Handle connected state.");
        if (this.f3102a == null) {
            o();
        } else {
            cn.jiguang.cb.b.a().b(1006, 3000L, this.f3114o);
        }
    }

    public cn.jiguang.bv.h c() {
        return this.f3102a;
    }

    public boolean d() {
        return this.f3109h;
    }

    public void e() {
        cn.jiguang.bq.d.c("JCoreTCPManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.f3117r);
        int i4 = this.f3116q;
        if (i4 > 0) {
            int i5 = this.f3117r;
            if (i5 == 0) {
                this.f3117r = i4 * 2;
                return;
            }
            int i6 = i5 * 2;
            int i7 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            if (i6 < i7 / 2) {
                this.f3117r = i5 * 2;
            } else {
                this.f3117r = i7;
            }
        }
    }

    public int f() {
        cn.jiguang.bq.d.c("JCoreTCPManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.f3117r);
        int i4 = this.f3116q;
        if (i4 > 0) {
            int i5 = this.f3117r;
            return i5 == 0 ? i4 : i5;
        }
        return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
    }

    public int g() {
        cn.jiguang.bq.d.c("JCoreTCPManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.f3117r);
        int i4 = this.f3116q;
        if (i4 > 0) {
            int i5 = this.f3117r;
            if (i5 == 0) {
                int i6 = i4 * 2;
                int i7 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                return i6 < i7 / 2 ? i4 * 2 : i7;
            }
            int i8 = i5 * 2;
            int i9 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            return i8 < i9 / 2 ? i5 * 2 : i9;
        }
        return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
    }

    public int h() {
        cn.jiguang.bq.d.c("JCoreTCPManager", "getAlarmDelay  -- current HeartBeatInterval = " + this.f3117r);
        int i4 = this.f3116q;
        if (i4 > 0) {
            int i5 = this.f3117r;
            return i5 == 0 ? i4 + 5 : i5 + 5;
        }
        return JConstants.DEFAULT_ALARM_DELAY;
    }

    public void i() {
        this.f3117r = 0;
        g.a().b();
    }
}
