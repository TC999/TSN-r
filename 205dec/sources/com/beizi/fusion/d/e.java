package com.beizi.fusion.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.BannerAdListener;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.DrawAdListener;
import com.beizi.fusion.FullScreenVideoAdListener;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.NativeFloatAdListener;
import com.beizi.fusion.NativeNotificationAdListener;
import com.beizi.fusion.NativeUnifiedAdListener;
import com.beizi.fusion.RewardedVideoAdListener;
import com.beizi.fusion.d.a.a;
import com.beizi.fusion.g.ae;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.y;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class e implements com.beizi.fusion.d.a, Observer {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f14610a;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f14611r;
    private com.beizi.fusion.b.d G;
    private long H;
    private List<AdSpacesBean.BuyerBean> I;
    private ae K;

    /* renamed from: L  reason: collision with root package name */
    private a f14612L;
    private boolean M;

    /* renamed from: b  reason: collision with root package name */
    protected Context f14613b;

    /* renamed from: c  reason: collision with root package name */
    protected com.beizi.fusion.b.b f14614c;

    /* renamed from: d  reason: collision with root package name */
    protected ViewGroup f14615d;

    /* renamed from: e  reason: collision with root package name */
    protected String f14616e;

    /* renamed from: f  reason: collision with root package name */
    protected long f14617f;

    /* renamed from: g  reason: collision with root package name */
    protected View f14618g;

    /* renamed from: h  reason: collision with root package name */
    protected com.beizi.fusion.a f14619h;

    /* renamed from: i  reason: collision with root package name */
    protected com.beizi.fusion.work.a f14620i;

    /* renamed from: m  reason: collision with root package name */
    protected String f14624m;

    /* renamed from: t  reason: collision with root package name */
    private e f14630t;

    /* renamed from: u  reason: collision with root package name */
    private AdSpacesBean f14631u;

    /* renamed from: j  reason: collision with root package name */
    protected Map<String, com.beizi.fusion.work.a> f14621j = new Hashtable();

    /* renamed from: k  reason: collision with root package name */
    protected ArrayList<c> f14622k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    protected boolean f14623l = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f14629s = false;

    /* renamed from: v  reason: collision with root package name */
    private long f14632v = 500;

    /* renamed from: w  reason: collision with root package name */
    private long f14633w = 100;

    /* renamed from: x  reason: collision with root package name */
    private volatile int f14634x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f14635y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f14636z = 0;
    private int A = 1;
    private int B = 2;
    private Timer C = new Timer();
    private Timer D = new Timer();
    private Timer E = null;
    private boolean F = false;
    private boolean J = false;
    private boolean N = false;
    private AdSpacesBean O = null;
    private com.beizi.fusion.b.a P = null;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f14625n = false;
    private int Q = 0;
    private int R = 1;
    private int S = 2;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f14626o = false;
    private boolean T = false;
    private boolean U = false;

    /* renamed from: p  reason: collision with root package name */
    protected com.beizi.fusion.work.a f14627p = null;
    private TimerTask V = new TimerTask() { // from class: com.beizi.fusion.d.e.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f14635y = eVar.A;
            if (e.this.f14620i != null) {
                Log.d("BeiZis", "bid time out");
                e.this.f14628q.sendEmptyMessage(1);
            }
        }
    };
    private TimerTask W = new TimerTask() { // from class: com.beizi.fusion.d.e.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.d("BeiZis", "========update inner outTime==========:" + System.currentTimeMillis());
            e eVar = e.this;
            eVar.f14635y = eVar.B;
            e.this.f14628q.sendEmptyMessage(2);
            if (e.this.G != null) {
                e.this.G.a(true);
            }
        }
    };
    @SuppressLint({"HandlerLeak"})

    /* renamed from: q  reason: collision with root package name */
    protected Handler f14628q = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.d.e.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                e eVar = e.this;
                if (eVar.f14620i != null) {
                    eVar.b(2);
                }
            } else if (i4 != 2) {
                if (i4 != 3) {
                    return;
                }
                e.this.D();
                com.beizi.fusion.b.d f4 = b.a().f();
                e.this.G = new com.beizi.fusion.b.d(new com.beizi.fusion.b.b(b.f14592b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                e eVar2 = e.this;
                eVar2.P = eVar2.G.a();
                e eVar3 = e.this;
                eVar3.f14614c = eVar3.G.b();
                e.this.E();
                e.this.P.a(e.this.f14614c);
                e.this.H();
                if (f4 != null && f4.f14492a.a() == 2 && e.this.G.f14493b.a() == 0) {
                    e.this.G.f14493b.a(1);
                    if (e.this.G.f14493b.a() == 1) {
                        e.this.G.f14493b.a(2);
                        e eVar4 = e.this;
                        eVar4.f14631u = com.beizi.fusion.c.a.a(eVar4.f14613b, eVar4.f14624m, eVar4.f());
                        if (e.this.f14631u == null) {
                            Log.d("BeiZis", "update spaceBean is null and return fail");
                            if (e.this.G.f14493b.a() != 2) {
                                e.this.G.f14493b.a(-2);
                                e.this.a("kGetLocalConfigStatusInternalError");
                                return;
                            }
                            int a4 = com.beizi.fusion.c.a.a();
                            if (a4 == 1) {
                                e.this.G.f14493b.a(4);
                                e.this.a(10001);
                                return;
                            } else if (a4 == 2) {
                                e.this.G.f14493b.a(5);
                                e.this.a(10100);
                                return;
                            } else if (a4 == 3) {
                                e.this.G.f14493b.a(6);
                                e.this.a(10110);
                                return;
                            } else {
                                e.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                                return;
                            }
                        }
                        e.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                        return;
                    }
                    e.this.G.f14493b.a(-2);
                    e.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                e.this.a(10000);
            } else if (e.this.G != null) {
                e eVar5 = e.this;
                com.beizi.fusion.work.a aVar = eVar5.f14620i;
                if (aVar != null) {
                    aVar.q();
                    e eVar6 = e.this;
                    eVar6.a(eVar6.f14620i.g(), e.this.f14620i.o());
                    if ("4".equals(e.this.f())) {
                        e eVar7 = e.this;
                        if (!eVar7.f14625n) {
                            eVar7.f14620i.f();
                            e.this.f14625n = true;
                        }
                    }
                    Map<String, com.beizi.fusion.work.a> r3 = e.this.r();
                    if (r3 != null) {
                        for (com.beizi.fusion.work.a aVar2 : r3.values()) {
                            AdSpacesBean.BuyerBean k4 = aVar2.k();
                            AdSpacesBean.BuyerBean k5 = e.this.f14620i.k();
                            if (k4 != null && k5 != null && (TextUtils.isEmpty(k4.getBuyerSpaceUuId()) || TextUtils.isEmpty(k5.getBuyerSpaceUuId()) || !k4.getBuyerSpaceUuId().equals(k5.getBuyerSpaceUuId()))) {
                                e.this.b(aVar2, 2);
                                af.a("BeiZis", "AdRequest timeout channel = " + k4.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + e.this.G.f14498g.a(k4.getBuyerSpaceUuId()));
                                if (aVar2.i() == com.beizi.fusion.f.a.ADDEFAULT) {
                                    e.this.G.f14498g.a(k4.getBuyerSpaceUuId(), -1);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                eVar5.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                Map<String, com.beizi.fusion.work.a> r4 = e.this.r();
                if (r4 != null) {
                    for (com.beizi.fusion.work.a aVar3 : r4.values()) {
                        AdSpacesBean.BuyerBean k6 = aVar3.k();
                        if (k6 != null) {
                            e.this.b(aVar3, 2);
                            af.a("BeiZis", "AdRequest timeout channel = " + k6.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + e.this.G.f14498g.a(k6.getBuyerSpaceUuId()));
                            if (e.this.G.f14498g.a(k6.getBuyerSpaceUuId()) < 4) {
                                e.this.G.f14498g.a(k6.getBuyerSpaceUuId(), -1);
                            }
                        }
                    }
                }
            }
        }
    };
    private TimerTask X = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BaseManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("updateResult", 0);
                e.this.M = true;
                if (TextUtils.equals(action, "com.ad.action.UPDATE_CONFIG_SUCCESS")) {
                    if (intExtra == 1) {
                        if (e.this.E != null) {
                            e.this.E.cancel();
                            e.this.E = null;
                        }
                        e eVar = e.this;
                        eVar.a(eVar.f14615d);
                    } else if (intExtra == 0 && e.this.N) {
                        if (e.this.E != null) {
                            e.this.E.cancel();
                            e.this.E = null;
                        }
                        e eVar2 = e.this;
                        eVar2.a(eVar2.f14615d);
                    }
                }
                e.this.D();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public e(Context context, String str, com.beizi.fusion.a aVar, long j4) {
        if (context == null) {
            aw.b("Illegal Argument: context is null");
        } else {
            this.f14613b = context;
            f14610a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (!(this.f14613b instanceof Activity)) {
                aw.b("Illegal Argument: context is not Activity context");
            }
        }
        this.f14624m = str;
        this.f14619h = aVar;
        this.f14617f = j4;
        this.f14630t = this;
        if (f14610a != null || aVar == null) {
            return;
        }
        a(10132);
    }

    private void B() {
        if (this.K != null) {
            return;
        }
        this.K = ae.a(f14610a);
        IntentFilter intentFilter = new IntentFilter("com.ad.action.UPDATE_CONFIG_SUCCESS");
        a aVar = new a();
        this.f14612L = aVar;
        this.K.a(aVar, intentFilter);
    }

    private void C() {
        TimerTask timerTask;
        try {
            if (this.M) {
                return;
            }
            B();
            com.beizi.fusion.update.b.a(f14610a).b(5);
            if (this.E == null) {
                this.E = new Timer();
            }
            if (this.X == null) {
                this.X = new TimerTask() { // from class: com.beizi.fusion.d.e.4
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            Log.d("BeiZis", "========update outTime==========:" + System.currentTimeMillis());
                            Handler handler = e.this.f14628q;
                            if (handler != null) {
                                handler.sendEmptyMessage(3);
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                };
            }
            Timer timer = this.E;
            if (timer == null || (timerTask = this.X) == null) {
                return;
            }
            long j4 = this.f14617f;
            if (j4 > 2000) {
                j4 = 2000;
            }
            timer.schedule(timerTask, j4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        a aVar;
        try {
            ae aeVar = this.K;
            if (aeVar == null || (aVar = this.f14612L) == null) {
                return;
            }
            aeVar.a(aVar);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.b(this.f14616e);
            a();
            this.f14614c.e(b.a().b());
            this.f14614c.f(this.f14624m);
            this.f14614c.g(String.valueOf(this.f14617f));
        }
    }

    private boolean F() {
        TimerTask timerTask;
        TimerTask timerTask2;
        AdSpacesBean adSpacesBean = this.f14631u;
        if (adSpacesBean == null) {
            return false;
        }
        AdSpacesBean.BidBean bid = adSpacesBean.getBid();
        if (bid != null) {
            this.f14632v = bid.getReserveFRWTime();
            this.f14633w = bid.getReserveTime();
        }
        Log.d("BeiZis", this.f14617f + ":mUsableTime=====" + this.f14632v + "=====mLastTime:" + this.f14633w);
        if ((this instanceof q) || (this instanceof p)) {
            return false;
        }
        long j4 = this.f14617f;
        if (j4 > this.f14633w) {
            long j5 = this.f14632v;
            if (j4 > j5) {
                Timer timer = this.C;
                if (timer != null && (timerTask2 = this.V) != null) {
                    timer.schedule(timerTask2, j4 - j5);
                }
            } else {
                this.f14635y = this.A;
            }
            Timer timer2 = this.D;
            if (timer2 != null && (timerTask = this.W) != null) {
                timer2.schedule(timerTask, this.f14617f - this.f14633w);
            }
            return false;
        }
        a(10120);
        this.G.f14493b.a(7);
        return true;
    }

    private void G() {
        y.b(f14610a, this.f14624m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14493b.addObserver(dVar);
            com.beizi.fusion.b.d dVar2 = this.G;
            dVar2.f14494c.addObserver(dVar2);
            com.beizi.fusion.b.d dVar3 = this.G;
            dVar3.f14495d.addObserver(dVar3);
            com.beizi.fusion.b.d dVar4 = this.G;
            dVar4.f14496e.addObserver(dVar4);
            com.beizi.fusion.b.d dVar5 = this.G;
            dVar5.f14497f.addObserver(dVar5);
            com.beizi.fusion.b.d dVar6 = this.G;
            dVar6.f14498g.addObserver(dVar6);
            com.beizi.fusion.b.d dVar7 = this.G;
            dVar7.f14499h.addObserver(dVar7);
            com.beizi.fusion.b.d dVar8 = this.G;
            dVar8.f14500i.addObserver(dVar8);
            com.beizi.fusion.b.d dVar9 = this.G;
            dVar9.f14501j.addObserver(dVar9);
            com.beizi.fusion.b.d dVar10 = this.G;
            dVar10.f14502k.addObserver(dVar10);
        }
    }

    private void I() {
        AdSpacesBean adSpacesBean = this.f14631u;
        if (adSpacesBean != null) {
            String str = null;
            String adType = adSpacesBean.getAdType();
            adType.hashCode();
            char c4 = '\uffff';
            switch (adType.hashCode()) {
                case -1999289321:
                    if (adType.equals("NATIVE")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1842536857:
                    if (adType.equals("SPLASH")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1372958932:
                    if (adType.equals("INTERSTITIAL")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -370591475:
                    if (adType.equals("REWARDEDVIDEO")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -43721614:
                    if (adType.equals("DRAWFLOW")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 252355794:
                    if (adType.equals("INTERACTIVECARD")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 658985344:
                    if (adType.equals("FULLSCREENVIDEO")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1723213558:
                    if (adType.equals("REGIONALNATIVE")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 1951953708:
                    if (adType.equals("BANNER")) {
                        c4 = '\b';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    str = "5";
                    break;
                case 1:
                    str = "2";
                    break;
                case 2:
                    str = "3";
                    break;
                case 3:
                    str = "1";
                    break;
                case 4:
                    str = "7";
                    break;
                case 5:
                    str = "13";
                    break;
                case 6:
                    str = "6";
                    break;
                case 7:
                    str = "12";
                    break;
                case '\b':
                    str = "4";
                    break;
            }
            com.beizi.fusion.b.b bVar = this.f14614c;
            if (bVar != null) {
                bVar.d(str);
            }
        }
    }

    private boolean J() {
        if (this.U) {
            com.beizi.fusion.work.a aVar = this.f14627p;
            if (aVar != null) {
                return aVar != null && aVar.i() == com.beizi.fusion.f.a.ADDEFAULT;
            }
            return true;
        }
        return false;
    }

    private boolean K() {
        for (com.beizi.fusion.work.a aVar : r().values()) {
            if (aVar.i() == com.beizi.fusion.f.a.ADDEFAULT) {
                return true;
            }
        }
        return false;
    }

    private synchronized void L() {
        this.f14622k.clear();
    }

    private void M() {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar == null || dVar.f14501j.a() != 0) {
            return;
        }
        this.G.f14501j.a(1);
    }

    private void N() {
        if (this.G != null) {
            af.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.G.f14501j.a());
        }
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            if (dVar.f14501j.a() == 1 || this.G.f14501j.a() == 2 || this.G.f14501j.a() == 3) {
                this.G.f14501j.a(3);
            }
        }
    }

    private void O() {
        if (this.G != null) {
            af.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.G.f14501j.a());
        }
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            if (dVar.f14501j.a() == 3 || this.G.f14501j.a() == 1 || this.G.f14501j.a() == 2) {
                this.G.f14501j.a(4);
            }
        }
    }

    public String A() {
        AdSpacesBean.BuyerBean k4;
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar == null || (k4 = aVar.k()) == null || TextUtils.isEmpty(k4.getBuyerSpaceUuId())) {
            return null;
        }
        return k4.getBuyerSpaceUuId();
    }

    public abstract com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar);

    protected abstract void a();

    public void m() {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar instanceof DrawAdListener) {
            ((DrawAdListener) aVar).onVideoPlayError();
        }
    }

    public void n() {
        this.f14626o = true;
        b();
        c();
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar != null) {
            aVar.m();
        }
        if (this.Q != this.R) {
            this.f14619h = null;
        }
        Map<String, com.beizi.fusion.work.a> map = this.f14621j;
        if (map != null) {
            map.clear();
        }
        ArrayList<c> arrayList = this.f14622k;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.f14630t != null) {
            this.f14630t = null;
        }
        D();
        e();
    }

    public void o() {
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar != null) {
            aVar.n();
        }
    }

    protected void p() {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            if (dVar.f14501j.a() == 1 || this.G.f14501j.a() == 3 || this.G.f14501j.a() == 4) {
                this.G.f14501j.a(2);
            }
        }
    }

    protected void q() {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            if (dVar.f14501j.a() == 0 || this.G.f14501j.a() == 1) {
                this.G.f14501j.a(5);
            }
        }
    }

    public Map<String, com.beizi.fusion.work.a> r() {
        return this.f14621j;
    }

    public int s() {
        return this.f14635y;
    }

    public int t() {
        return this.f14634x;
    }

    public void u() {
        af.c("BeiZis", "enter clearAdStatus");
        this.f14634x = 0;
        this.F = false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    public boolean v() {
        return f14611r;
    }

    public int w() {
        AdSpacesBean adSpacesBean = this.f14631u;
        if (adSpacesBean == null || adSpacesBean.getEventStrategy() == null) {
            return Integer.MAX_VALUE;
        }
        AdSpacesBean.EventStrategyBean eventStrategy = this.f14631u.getEventStrategy();
        if (eventStrategy.getValidTimeShow() >= 0) {
            return eventStrategy.getValidTimeShow();
        }
        return Integer.MAX_VALUE;
    }

    public Integer[] x() {
        AdSpacesBean.EventStrategyBean eventStrategy;
        List<AdSpacesBean.RandomStrategyBean> randomStrategy;
        AdSpacesBean adSpacesBean = this.f14631u;
        if (adSpacesBean != null && adSpacesBean.getEventStrategy() != null && (eventStrategy = this.f14631u.getEventStrategy()) != null && (randomStrategy = eventStrategy.getRandomStrategy()) != null && randomStrategy.size() > 0) {
            for (int i4 = 0; i4 < randomStrategy.size(); i4++) {
                AdSpacesBean.RandomStrategyBean randomStrategyBean = randomStrategy.get(i4);
                if ("show".equalsIgnoreCase(randomStrategyBean.getEventType())) {
                    return new Integer[]{Integer.valueOf(randomStrategyBean.getMin()), Integer.valueOf(randomStrategyBean.getMax())};
                }
            }
        }
        return new Integer[]{0, 0};
    }

    public boolean y() {
        return this.f14629s;
    }

    public String z() {
        AdSpacesBean adSpacesBean = this.O;
        if (adSpacesBean != null) {
            return adSpacesBean.getSpaceId();
        }
        return null;
    }

    private void c() {
        TimerTask timerTask = this.W;
        if (timerTask != null) {
            timerTask.cancel();
            this.W = null;
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
        Timer timer2 = this.E;
        if (timer2 != null) {
            timer2.cancel();
            this.E = null;
        }
    }

    private boolean g(String str) {
        return str.equals("HPFRW");
    }

    private String h(String str) {
        af.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        return av.b().equals(str) ? "BEIZI" : str;
    }

    public com.beizi.fusion.b.d d() {
        return this.G;
    }

    protected void e() {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14493b.deleteObservers();
            this.G.f14494c.deleteObservers();
            this.G.f14495d.deleteObservers();
            this.G.f14496e.deleteObservers();
            this.G.f14497f.deleteObservers();
            this.G.f14498g.deleteObservers();
            this.G.f14499h.deleteObservers();
            this.G.f14500i.deleteObservers();
            this.G.f14501j.deleteObservers();
            this.G.f14502k.deleteObservers();
        }
    }

    public String f() {
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    public String i() {
        return this.f14624m;
    }

    public synchronized void j() {
        Iterator<c> it = this.f14622k.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        L();
    }

    public void k() {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewarded();
    }

    public void l() {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoComplete();
            } else if (aVar instanceof DrawAdListener) {
                ((DrawAdListener) aVar).onVideoComplete();
            }
        }
    }

    private boolean d(com.beizi.fusion.work.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.beizi.fusion.work.a aVar2 : r().values()) {
            AdSpacesBean.BuyerBean k4 = aVar2.k();
            AdSpacesBean.BuyerBean k5 = aVar.k();
            if (k4 != null && k5 != null && (TextUtils.isEmpty(k4.getBuyerSpaceUuId()) || TextUtils.isEmpty(k5.getBuyerSpaceUuId()) || !k4.getBuyerSpaceUuId().equals(k5.getBuyerSpaceUuId()))) {
                if (!b(aVar2) && !c(aVar2)) {
                    af.c("BeiZis", "worker.getAdStatus():" + aVar2.i() + ":" + aVar2.g());
                    if (aVar2.i() != com.beizi.fusion.f.a.ADFAIL && e(aVar2) > e(aVar)) {
                        return false;
                    }
                } else {
                    double f4 = f(aVar2);
                    if (aVar2.i() == com.beizi.fusion.f.a.ADDEFAULT || f4 > e(aVar)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean i(String str) {
        return "FinalLink".equalsIgnoreCase(str);
    }

    protected void g() {
        this.G.f14495d.a(3);
        a(10140);
    }

    private void b() {
        TimerTask timerTask = this.V;
        if (timerTask != null) {
            timerTask.cancel();
            this.V = null;
        }
        Timer timer = this.C;
        if (timer != null) {
            timer.cancel();
            this.C = null;
        }
        Timer timer2 = this.E;
        if (timer2 != null) {
            timer2.cancel();
            this.E = null;
        }
    }

    private double f(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean k4;
        if (aVar == null || (k4 = aVar.k()) == null) {
            return 0.0d;
        }
        return k4.getBidPrice();
    }

    public boolean h() {
        return (t() == 2 || t() == 3) ? false : true;
    }

    @NonNull
    private h k(String str) {
        j(str);
        return h.SUCCESS;
    }

    private void j(String str) {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14499h.a(str, 3);
        }
    }

    protected void f(String str) {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14499h.a(str, 4);
        }
    }

    @NonNull
    private h l(String str) {
        f(str);
        return h.FAIL;
    }

    public void c(String str) {
        if (this.Q == this.R) {
            this.Q = this.S;
        }
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClosed();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdClosed();
            } else if (aVar instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar).onAdClosed();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClosed();
            } else if (aVar instanceof BannerAdListener) {
                ((BannerAdListener) aVar).onAdClosed();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClosed();
            } else if (aVar instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) aVar).onAdClosed();
            } else if (aVar instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) aVar).onAdClosed();
            }
        }
        O();
    }

    public void a(ViewGroup viewGroup) {
        List<AdSpacesBean.BuyerBean> list;
        AdSpacesBean.BidComponent bidComponent;
        List<AdSpacesBean> adSpaces;
        AdSpacesBean adSpacesBean;
        if (this.J || this.f14613b == null || f14610a == null) {
            return;
        }
        this.f14615d = viewGroup;
        this.H = System.currentTimeMillis();
        this.f14616e = av.a();
        com.beizi.fusion.b.d f4 = b.a().f();
        com.beizi.fusion.b.d dVar = new com.beizi.fusion.b.d(new com.beizi.fusion.b.b(b.f14592b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        this.G = dVar;
        this.P = dVar.a();
        this.f14614c = this.G.b();
        E();
        this.P.a(this.f14614c);
        H();
        if (!BeiZis.isIsSyncInit() && ((f4 == null || f4.f14492a.a() != 2) && !this.T)) {
            ResponseInfo.getInstance(f14610a).init();
            this.T = true;
        }
        if (f4 != null) {
            af.b("BeiZis", "mInitObserver.mInitStatus.getStatus() = " + f4.f14492a.a() + ",mManagerObserver.mGetLocalConfigStatus.getStatus() = " + this.G.f14493b.a());
        }
        if ((f4 != null && f4.f14492a.a() == 2 && this.G.f14493b.a() == 0) || this.T) {
            this.G.f14493b.a(1);
            if (this.G.f14493b.a() == 1) {
                this.G.f14493b.a(2);
                AdSpacesBean a4 = com.beizi.fusion.c.a.a(this.f14613b, this.f14624m, f());
                this.f14631u = a4;
                if (a4 != null) {
                    com.beizi.fusion.b.b bVar = this.f14614c;
                    if (bVar != null) {
                        bVar.A(a4.getFilterSsid());
                        this.f14614c.B(this.f14631u.getComponentSsid());
                        this.f14614c.C(this.f14631u.getBzComponentSsid());
                        I();
                    }
                    ResponseInfo responseInfo = ResponseInfo.getInstance(f14610a);
                    Manager manager = responseInfo.getManager();
                    AdSpacesBean.ComponentBean componentBean = null;
                    if (manager == null || (adSpaces = manager.getAdSpaces()) == null || adSpaces.size() <= 0 || (adSpacesBean = adSpaces.get(0)) == null) {
                        list = null;
                        bidComponent = null;
                    } else {
                        componentBean = adSpacesBean.getComponent();
                        bidComponent = adSpacesBean.getBidComponent();
                        list = adSpacesBean.getBuyer();
                    }
                    if ((componentBean != null || bidComponent != null) && list != null && list.size() > 0) {
                        long maxValidTime = responseInfo.getMaxValidTime();
                        if (maxValidTime == 0) {
                            maxValidTime = 2592000000L;
                        }
                        if (System.currentTimeMillis() - ((Long) au.b(f14610a, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue() <= maxValidTime) {
                            this.N = false;
                            this.J = true;
                            if (this.G.f14493b.a() == 2) {
                                this.G.f14493b.a(3);
                                if (F()) {
                                    return;
                                }
                                G();
                                if (this.G.c()) {
                                    this.G.f14493b.a(-1);
                                    return;
                                } else {
                                    a(this.f14631u);
                                    return;
                                }
                            }
                            return;
                        }
                        this.J = false;
                        this.N = true;
                        C();
                        return;
                    }
                    this.J = false;
                    C();
                    return;
                }
                Log.d("BeiZis", "spaceBean is null and return fail mUpdateConfigSuccess:" + this.M);
                if (this.M) {
                    if (this.G.f14493b.a() == 2) {
                        int a5 = com.beizi.fusion.c.a.a();
                        if (a5 == 1) {
                            this.G.f14493b.a(4);
                            a(10001);
                            return;
                        } else if (a5 == 2) {
                            this.G.f14493b.a(5);
                            a(10100);
                            return;
                        } else if (a5 == 3) {
                            this.G.f14493b.a(6);
                            a(10110);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.G.f14493b.a(-2);
                    a("kGetLocalConfigStatusInternalError");
                    return;
                }
                Log.e("BeiZis", "startUpdateConfig");
                this.J = false;
                C();
                return;
            }
            this.G.f14493b.a(-2);
            a("kGetLocalConfigStatusInternalError");
        } else if (this.M) {
            this.J = false;
            C();
        } else {
            a(10000);
        }
    }

    private void b(List<AdSpacesBean.ForwardBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.U = true;
        new com.beizi.fusion.d.a.a(new a.InterfaceC0134a() { // from class: com.beizi.fusion.d.e.6
            @Override // com.beizi.fusion.d.a.a.InterfaceC0134a
            public void a(String str, int i4) {
                e.this.G.f14498g.a(str, i4);
            }

            @Override // com.beizi.fusion.d.a.a.InterfaceC0134a
            public void a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str, double d4) {
                if (e.this.f14635y == e.this.f14636z && forwardBean != null && buyerBean != null) {
                    e eVar = e.this;
                    if (eVar.e(eVar.f14620i) < d4) {
                        String buyerId = forwardBean.getBuyerId();
                        String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                        e.this.P.a(buyerBean, forwardBean);
                        e.this.G.f14496e.a(buyerSpaceUuId, 1);
                        if (e.this.a(forwardBean, buyerBean, buyerSpaceUuId)) {
                            e eVar2 = e.this;
                            eVar2.f14627p = eVar2.a(forwardBean, buyerId, buyerBean, buyerBean.getRenderView(), null);
                            com.beizi.fusion.work.a aVar = e.this.f14627p;
                            if (aVar != null) {
                                aVar.a(forwardBean.getSleepTime());
                                e.this.f14627p.a(forwardBean);
                                e.this.f14627p.a(buyerBean);
                                e.this.f14627p.a(buyerBean.getBidType());
                                e eVar3 = e.this;
                                eVar3.a(buyerId, buyerSpaceUuId, eVar3.f14627p);
                                e.this.f14627p.d();
                                e.this.f14627p.a(true);
                                return;
                            }
                        } else {
                            e.this.U = false;
                            e.this.a((AdSpacesBean.ComponentBean) null, buyerBean.getBidType(), true, 10130);
                            return;
                        }
                    }
                }
                e.this.U = false;
                e.this.a((AdSpacesBean.ComponentBean) null, buyerBean.getBidType(), true, 10160);
            }

            @Override // com.beizi.fusion.d.a.a.InterfaceC0134a
            public void a(String str, String str2, String str3, int i4) {
                e.this.U = false;
                e.this.a((AdSpacesBean.ComponentBean) null, AMPSConstants.BiddingType.BIDDING_TYPE_S2S, true, 10160);
                if (e.this.f14614c != null && !TextUtils.isEmpty(str2)) {
                    e.this.f14614c.i(str2);
                    e.this.f14614c.m(str);
                    e.this.P.a(str3, e.this.f14614c);
                }
                if (e.this.G == null || e.this.G.f14498g == null) {
                    return;
                }
                e.this.G.f14498g.a(str3, i4);
            }

            @Override // com.beizi.fusion.d.a.a.InterfaceC0134a
            public void a() {
                e.this.U = false;
                e.this.a((AdSpacesBean.ComponentBean) null, AMPSConstants.BiddingType.BIDDING_TYPE_S2S, true, 10160);
            }
        }).a(this.f14613b, f(), z(), list, this.I, this.f14631u.getBid().getBidTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double e(com.beizi.fusion.work.a aVar) {
        if (aVar == null || aVar.k() == null) {
            return 0.0d;
        }
        AdSpacesBean.BuyerBean k4 = aVar.k();
        if (!c(aVar) && !b(aVar)) {
            return k4.getAvgPrice();
        }
        if (k4.getBidPrice() > 0.0d) {
            return k4.getBidPrice();
        }
        return k4.getAvgPrice();
    }

    public void d(String str) {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClicked();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoClick();
            } else if (aVar instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClick();
            } else if (aVar instanceof BannerAdListener) {
                ((BannerAdListener) aVar).onAdClick();
            } else if (aVar instanceof DrawAdListener) {
                ((DrawAdListener) aVar).onAdClick();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdClick();
            }
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.beizi.fusion.work.a aVar, int i4) {
        if (b(aVar) || c(aVar)) {
            if (aVar.g().equalsIgnoreCase(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT) || aVar.g().equalsIgnoreCase("BAIDU")) {
                aVar.d(i4);
            }
        }
    }

    protected void e(String str) {
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14499h.a(str, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        a(this.f14620i, i4);
        this.f14620i.q();
        a(this.f14620i.g(), this.f14620i.o());
        if (!"4".equals(f()) || this.f14625n) {
            return;
        }
        this.f14620i.f();
        this.f14625n = true;
    }

    public void b(String str) {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null && (aVar instanceof BannerAdListener)) {
            ((BannerAdListener) aVar).onAdShown();
        } else if (this.f14634x >= 2 && !i(str)) {
            return;
        }
        if (this.Q == 0) {
            this.Q = this.R;
        }
        Log.d("BeiZis", "AdShow:" + str);
        this.f14634x = 2;
        com.beizi.fusion.a aVar2 = this.f14619h;
        if (aVar2 != null) {
            if (aVar2 instanceof AdListener) {
                ((AdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar2).onRewardedVideoAdShown();
            } else if (aVar2 instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof DrawAdListener) {
                ((DrawAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof NativeAdListener) {
                ((NativeAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) aVar2).onAdShown();
            } else if (aVar2 instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar2).onAdShown();
            }
        }
        p();
        j();
    }

    protected boolean c(com.beizi.fusion.work.a aVar) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(aVar.h());
    }

    public void b(String str, View view) {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null && view != null && (aVar instanceof NativeAdListener)) {
            ((NativeAdListener) aVar).onAdClosed(view);
        }
        O();
    }

    protected boolean b(com.beizi.fusion.work.a aVar) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(aVar.h());
    }

    @Override // com.beizi.fusion.d.a
    public void a(String str) {
        af.c("BeiZis", "enter handleAdRequestStatusError error is " + str);
        a(10131);
    }

    public void a(String str, final String str2, final EventItem eventItem) {
        if (Arrays.asList(com.beizi.fusion.g.q.f14963a).contains(str)) {
            y.a(str2, eventItem);
            com.beizi.fusion.g.h.b().c().execute(new Runnable() { // from class: com.beizi.fusion.d.e.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.beizi.fusion.a.b.a(e.this.f14613b).a(str2, eventItem);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(AdSpacesBean adSpacesBean) {
        if (this.G.f14493b.a() == 3 && this.G.f14494c.a() == 0) {
            this.G.f14494c.a(1);
            this.f14621j.clear();
            AdSpacesBean.FilterBean filter = adSpacesBean.getFilter();
            this.I = adSpacesBean.getBuyer();
            com.beizi.fusion.f.b.a(this.f14613b, this.f14617f, filter, this.G, i(), null, null, this);
            if (this.G.f14494c.a() == 2) {
                if (this.G.c()) {
                    this.G.f14494c.a(-1);
                    return;
                }
                a("200.000", this.f14624m, new EventItem("200.000", String.valueOf(System.currentTimeMillis()), null, null));
                this.O = adSpacesBean;
                af.c("BeiZis", "normal request");
                a(this.O.getComponent(), false);
                return;
            }
            a(this.G.f14494c.a(), 6, "platform error = ");
            Log.d("BeiZis", "AdDispenses AdFilter fail:" + com.beizi.fusion.b.a.a(this.G.f14494c));
            a(10130);
            return;
        }
        this.G.f14494c.a(-2);
        a("kPlatformFilterStatusInternalError");
    }

    protected void a(AdSpacesBean.ComponentBean componentBean, boolean z3) {
        af.a("BeiZis", "enter auctionAndRequestAd");
        if (this.f14631u == null) {
            return;
        }
        List<AdSpacesBean.BuyerBean> list = this.I;
        if (list != null && list.size() != 0) {
            if (t() >= 1) {
                af.a("BeiZis", "auctionAndRequestAd ad aleady callback");
                return;
            }
            if (!z3) {
                this.G.f14495d.a(1);
            }
            List<AdSpacesBean.ForwardBean> a4 = a(componentBean, this.I, z3);
            if (!z3) {
                this.G.f14495d.a(2);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (a4 != null && a4.size() > 0) {
                for (AdSpacesBean.ForwardBean forwardBean : a4) {
                    AdSpacesBean.BuyerBean a5 = a(forwardBean.getBuyerId(), this.I, forwardBean.getBuyerSpaceUuId());
                    if (a5 != null) {
                        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(a5.getBidType())) {
                            arrayList.add(forwardBean);
                        } else {
                            arrayList2.add(forwardBean);
                        }
                    }
                }
            }
            Map<String, com.beizi.fusion.work.a> a6 = a(arrayList2);
            b(arrayList);
            a(a6);
            return;
        }
        af.a("BeiZis", "auctionAndRequestAd mBuyerBeanList == null ");
    }

    private List<AdSpacesBean.ForwardBean> a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, boolean z3) {
        List<AdSpacesBean.ForwardBean> a4;
        AdSpacesBean adSpacesBean;
        ArrayList arrayList = new ArrayList();
        if (!z3 && (adSpacesBean = this.f14631u) != null && adSpacesBean.getBid() != null && this.f14631u.getBidComponent() != null && this.f14631u.getBidComponent().getBidList() != null && this.f14631u.getBidComponent().getBidList().size() > 0) {
            arrayList.addAll(this.f14631u.getBidComponent().getBidList());
        }
        if (this.f14631u != null && componentBean != null && (a4 = com.beizi.fusion.f.b.a(componentBean, list, i())) != null && a4.size() > 0) {
            arrayList.addAll(a4);
        }
        return arrayList;
    }

    protected Map<String, com.beizi.fusion.work.a> a(List<AdSpacesBean.ForwardBean> list) {
        com.beizi.fusion.work.a a4;
        if (list == null || list.size() == 0) {
            return null;
        }
        af.a("BeiZis", "generateWorkers forwardBeans.size() = " + list.size());
        Hashtable hashtable = new Hashtable();
        for (int i4 = 0; i4 < list.size(); i4++) {
            AdSpacesBean.ForwardBean forwardBean = list.get(i4);
            if (forwardBean != null) {
                String buyerId = forwardBean.getBuyerId();
                String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                AdSpacesBean.BuyerBean a5 = a(buyerId, this.I, forwardBean.getBuyerSpaceUuId());
                if (a5 != null) {
                    this.P.a(a5, forwardBean);
                    this.G.f14496e.a(buyerSpaceUuId, 1);
                    if (a(forwardBean, a5, buyerSpaceUuId) && (a4 = a(forwardBean, buyerId, a5, a5.getRenderView(), null)) != null) {
                        a4.a(forwardBean.getSleepTime());
                        a4.a(forwardBean);
                        a4.a(a5);
                        a4.a(a5.getBidType());
                        a(buyerId, buyerSpaceUuId, a4);
                        hashtable.put(h(buyerId) + buyerSpaceUuId, a4);
                        af.a("BeiZis", "generateWorkers put new " + buyerId + " worker into workerList");
                    }
                }
            }
        }
        return hashtable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str) {
        this.G.f14496e.a(str, 2);
        if (buyerBean != null) {
            try {
                long longValue = ((Long) au.b(this.f14613b, "complain_config_" + buyerBean.getSpaceId(), 0L)).longValue();
                AdSpacesBean.ComplainBean complain = buyerBean.getComplain();
                if (complain != null) {
                    if (System.currentTimeMillis() - longValue < complain.getDuration()) {
                        this.G.f14496e.a(str, 10);
                        return false;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        com.beizi.fusion.f.b.a(this.f14613b, this.f14617f, buyerBean.getFilter(), this.G, i(), buyerBean.getBuyerSpaceUuId(), buyerBean.getSpaceId(), this);
        if (this.G.f14496e.a(str) == 3) {
            if (this.G.c()) {
                this.G.f14496e.a(str, -1);
                return false;
            } else if (a(forwardBean, buyerBean) != 2) {
                return false;
            } else {
                this.G.f14496e.a(str, 3);
                return true;
            }
        }
        a(this.G.f14496e.a(str), 7, "channel error = ");
        Log.d("BeiZis", "AdDispense buyerBean AdFilter fail:" + com.beizi.fusion.b.a.a(str, this.G.f14496e));
        return false;
    }

    private void a(Map<String, com.beizi.fusion.work.a> map) {
        if (map != null && map.size() != 0) {
            for (com.beizi.fusion.work.a aVar : map.values()) {
                aVar.d();
                aVar.a(true);
            }
            return;
        }
        g();
    }

    public h a(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean k4 = aVar.k();
        if (k4 == null) {
            return null;
        }
        String id = k4.getId();
        String buyerSpaceUuId = k4.getBuyerSpaceUuId();
        String zone = k4.getZone();
        af.a("BeiZis", "enter comparePrices compareWorker:" + aVar.g() + ",mCurrentHighestWorker:" + this.f14620i);
        if (i(aVar.g())) {
            return a(buyerSpaceUuId, aVar, id);
        }
        com.beizi.fusion.b.d dVar = this.G;
        if (dVar != null) {
            dVar.f14499h.a(buyerSpaceUuId, 1);
        }
        if (this.f14634x >= 1) {
            b(aVar, 1);
            return l(buyerSpaceUuId);
        } else if (J()) {
            return a(buyerSpaceUuId, aVar);
        } else {
            boolean g4 = g(zone);
            boolean d4 = d(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("channel == mTimeStage = ");
            sb.append(this.f14635y == this.A);
            sb.append(";isNeedComparePrices = ");
            sb.append(g4);
            sb.append(",isHighestPrice:");
            sb.append(d4);
            sb.append(";mCurrentHighestWorker:");
            sb.append(this.f14620i);
            af.a("BeiZis", sb.toString());
            if (this.f14635y == this.f14636z && g4 && !d4) {
                double e4 = e(aVar);
                double e5 = e(this.f14620i);
                if (this.f14620i != null && e4 <= e5) {
                    b(aVar, 1);
                    if (d(this.f14620i)) {
                        b(1);
                    }
                    return l(buyerSpaceUuId);
                }
                return a(buyerSpaceUuId, aVar);
            }
            return a(buyerSpaceUuId, aVar, id);
        }
    }

    private void a(com.beizi.fusion.work.a aVar, int i4) {
        if (aVar == null) {
            return;
        }
        for (com.beizi.fusion.work.a aVar2 : r().values()) {
            AdSpacesBean.BuyerBean k4 = aVar2.k();
            AdSpacesBean.BuyerBean k5 = aVar.k();
            if (k4 != null && k5 != null && (TextUtils.isEmpty(k4.getBuyerSpaceUuId()) || TextUtils.isEmpty(k5.getBuyerSpaceUuId()) || !k4.getBuyerSpaceUuId().equals(k5.getBuyerSpaceUuId()))) {
                b(aVar2, i4);
                if (aVar2.aE() == h.TO_DETERMINE) {
                    f(k4.getBuyerSpaceUuId());
                } else if (aVar2.i() == com.beizi.fusion.f.a.ADDEFAULT) {
                    e(k4.getBuyerSpaceUuId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.beizi.fusion.work.a aVar) {
        Map<String, com.beizi.fusion.work.a> map = this.f14621j;
        map.put(h(str) + "_" + str2, aVar);
    }

    @Nullable
    protected AdSpacesBean.BuyerBean a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        return com.beizi.fusion.f.b.a(str, list, str2);
    }

    protected void a(int i4, int i5, String str) {
        if (i4 != i5 || y.c(this.f14624m) == null) {
            return;
        }
        String freqItem = y.c(this.f14624m).toString();
        y.d(str + freqItem);
    }

    private int a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean) {
        if (forwardBean == null || buyerBean == null) {
            return 0;
        }
        String buyerSpaceUuId = buyerBean.getBuyerSpaceUuId();
        if (this.G.f14496e.a(buyerSpaceUuId) == 3) {
            this.G.f14497f.a(buyerSpaceUuId, 1);
            if (this.G.f14497f.a(buyerSpaceUuId) == 1) {
                if (this.f14617f <= (forwardBean.getSleepTime() + System.currentTimeMillis()) - this.H) {
                    this.G.f14497f.a(buyerSpaceUuId, 4);
                    return 4;
                } else if (this.G.f14501j.a() == 2) {
                    this.G.f14497f.a(buyerSpaceUuId, 6);
                    return 6;
                } else {
                    af.a("BeiZis", "mUsableTime = " + this.f14617f + " forwardBean.getSleepTime() + System.currentTimeMillis() - mEnterRequestMethodTime = " + ((forwardBean.getSleepTime() + System.currentTimeMillis()) - this.H) + ",forwardBean.getSleepTime() = " + forwardBean.getSleepTime());
                    if (this.G.c()) {
                        this.G.f14497f.a(buyerSpaceUuId, -1);
                        return -1;
                    }
                    this.G.f14497f.a(buyerSpaceUuId, 2);
                    return 2;
                }
            }
        }
        this.G.f14497f.a(buyerSpaceUuId, -2);
        return -2;
    }

    public void a(AdSpacesBean.ComponentBean componentBean, String str, boolean z3, int i4) {
        if (componentBean != null && (TextUtils.isEmpty(str) || (!AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(str) && !AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(str)))) {
            a(componentBean, true);
            return;
        }
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar != null && d(aVar)) {
            b(1);
        } else {
            a(i4);
        }
    }

    public synchronized void a(c cVar) {
        if (cVar != null) {
            this.f14622k.remove(cVar);
        }
    }

    public void a(String str, View view) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.f14623l) {
            return;
        }
        a(this.f14620i, 1);
        this.f14623l = true;
        this.f14634x = 1;
        b();
        c();
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdLoaded();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdLoaded();
            } else if (aVar instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar).onAdLoaded();
            } else if (aVar instanceof BannerAdListener) {
                ((BannerAdListener) aVar).onAdLoaded();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdLoaded();
            } else if (aVar instanceof NativeAdListener) {
                if (view != null) {
                    com.beizi.fusion.work.a aVar2 = this.f14620i;
                    if (aVar2 != null && aVar2.aA() == 1) {
                        ((NativeAdListener) this.f14619h).onAdLoaded(null);
                    } else {
                        com.beizi.fusion.work.a aVar3 = this.f14620i;
                        if (aVar3 != null && aVar3.o() != null) {
                            ((NativeAdListener) this.f14619h).onAdLoaded(this.f14620i.o());
                        } else {
                            g();
                        }
                    }
                } else {
                    g();
                }
            } else if (aVar instanceof DrawAdListener) {
                if (view != null) {
                    ((DrawAdListener) aVar).onAdLoaded(view);
                } else {
                    g();
                }
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdLoaded(this.f14620i.aD());
            }
        }
        M();
        f14611r = true;
    }

    public void a(String str, int i4) {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i4);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i4);
            } else if (aVar instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof BannerAdListener) {
                ((BannerAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof DrawAdListener) {
                ((DrawAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i4);
            }
        }
        c();
        this.f14634x = 3;
        q();
        f14611r = true;
    }

    public void a(int i4) {
        if (i4 != 10140) {
            if (this.f14634x >= 1) {
                return;
            }
            if (i4 != 9999 && (J() || K())) {
                return;
            }
        }
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i4);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i4);
            } else if (aVar instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof BannerAdListener) {
                ((BannerAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof DrawAdListener) {
                ((DrawAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) aVar).onAdFailed(i4);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i4);
            }
        }
        c();
        this.f14634x = 3;
        q();
        f14611r = true;
    }

    public void a(long j4) {
        com.beizi.fusion.a aVar = this.f14619h;
        if (aVar == null || !(aVar instanceof AdListener)) {
            return;
        }
        ((AdListener) aVar).onAdTick(j4);
    }

    @NonNull
    private h a(String str, com.beizi.fusion.work.a aVar) {
        af.a("BeiZis", "comparePrices handleCompeteToDetermine worker:" + aVar.g());
        this.f14620i = aVar;
        this.G.f14499h.a(str, 2);
        c();
        return h.TO_DETERMINE;
    }

    @NonNull
    private h a(String str, com.beizi.fusion.work.a aVar, String str2) {
        if (!this.F) {
            a(aVar, str2);
            b();
            c();
            return k(str);
        }
        b(aVar, 1);
        return l(str);
    }

    private void a(com.beizi.fusion.work.a aVar, String str) {
        this.F = true;
        af.a("BeiZis", "---handleCompeteSuccess---" + str + "---" + e(aVar));
        this.f14620i = aVar;
        a(aVar, 1);
    }

    public void a(com.beizi.fusion.a aVar) {
        this.f14619h = aVar;
    }

    public void a(boolean z3) {
        this.f14629s = z3;
    }
}
