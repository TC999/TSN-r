package com.beizi.fusion.p066d;

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
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.DrawAdListener;
import com.beizi.fusion.FullScreenVideoAdListener;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.NativeFloatAdListener;
import com.beizi.fusion.NativeNotificationAdListener;
import com.beizi.fusion.NativeUnifiedAdListener;
import com.beizi.fusion.RewardedVideoAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p063a.DaoManager;
import com.beizi.fusion.p064b.AdProcessStatus;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p065c.ChannelUtil;
import com.beizi.fusion.p066d.p067a.BidS2SRequest;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p071f.AdStrategy;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.FreqUtil;
import com.beizi.fusion.p072g.LocalBroadcastManager;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.update.HeartScheduler;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.clj.fastble.BleManager;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
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

/* renamed from: com.beizi.fusion.d.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseManager implements AdLifeControl, Observer {

    /* renamed from: a */
    protected static Context f11070a;

    /* renamed from: r */
    private static boolean f11071r;

    /* renamed from: G */
    private ObserverAdStatus f11078G;

    /* renamed from: H */
    private long f11079H;

    /* renamed from: I */
    private List<AdSpacesBean.BuyerBean> f11080I;

    /* renamed from: K */
    private LocalBroadcastManager f11082K;

    /* renamed from: L */
    private C3082a f11083L;

    /* renamed from: M */
    private boolean f11084M;

    /* renamed from: b */
    protected Context f11096b;

    /* renamed from: c */
    protected EventBean f11097c;

    /* renamed from: d */
    protected ViewGroup f11098d;

    /* renamed from: e */
    protected String f11099e;

    /* renamed from: f */
    protected long f11100f;

    /* renamed from: g */
    protected View f11101g;

    /* renamed from: h */
    protected BaseAdListener f11102h;

    /* renamed from: i */
    protected AdWorker f11103i;

    /* renamed from: m */
    protected String f11107m;

    /* renamed from: t */
    private BaseManager f11113t;

    /* renamed from: u */
    private AdSpacesBean f11114u;

    /* renamed from: j */
    protected Map<String, AdWorker> f11104j = new Hashtable();

    /* renamed from: k */
    protected ArrayList<AdShowObserver> f11105k = new ArrayList<>();

    /* renamed from: l */
    protected boolean f11106l = false;

    /* renamed from: s */
    private boolean f11112s = false;

    /* renamed from: v */
    private long f11115v = 500;

    /* renamed from: w */
    private long f11116w = 100;

    /* renamed from: x */
    private volatile int f11117x = 0;

    /* renamed from: y */
    private int f11118y = 0;

    /* renamed from: z */
    private int f11119z = 0;

    /* renamed from: A */
    private int f11072A = 1;

    /* renamed from: B */
    private int f11073B = 2;

    /* renamed from: C */
    private Timer f11074C = new Timer();

    /* renamed from: D */
    private Timer f11075D = new Timer();

    /* renamed from: E */
    private Timer f11076E = new Timer();

    /* renamed from: F */
    private boolean f11077F = false;

    /* renamed from: J */
    private boolean f11081J = false;

    /* renamed from: N */
    private boolean f11085N = false;

    /* renamed from: O */
    private AdSpacesBean f11086O = null;

    /* renamed from: P */
    private AdProcessStatus f11087P = null;

    /* renamed from: n */
    protected boolean f11108n = false;

    /* renamed from: Q */
    private int f11088Q = 0;

    /* renamed from: R */
    private int f11089R = 1;

    /* renamed from: S */
    private int f11090S = 2;

    /* renamed from: o */
    protected boolean f11109o = false;

    /* renamed from: T */
    private boolean f11091T = false;

    /* renamed from: U */
    private boolean f11092U = false;

    /* renamed from: p */
    protected AdWorker f11110p = null;

    /* renamed from: V */
    private TimerTask f11093V = new TimerTask() { // from class: com.beizi.fusion.d.e.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BaseManager baseManager = BaseManager.this;
            baseManager.f11118y = baseManager.f11072A;
            if (BaseManager.this.f11103i != null) {
                Log.d("BeiZis", "bid time out");
                BaseManager.this.f11111q.sendEmptyMessage(1);
            }
        }
    };

    /* renamed from: W */
    private TimerTask f11094W = new TimerTask() { // from class: com.beizi.fusion.d.e.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.d("BeiZis", "========update inner outTime==========:" + System.currentTimeMillis());
            BaseManager baseManager = BaseManager.this;
            baseManager.f11118y = baseManager.f11073B;
            BaseManager.this.f11111q.sendEmptyMessage(2);
            if (BaseManager.this.f11078G != null) {
                BaseManager.this.f11078G.m48859a(true);
            }
        }
    };
    @SuppressLint({"HandlerLeak"})

    /* renamed from: q */
    protected Handler f11111q = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.d.e.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                BaseManager baseManager = BaseManager.this;
                if (baseManager.f11103i != null) {
                    baseManager.m48716b(2);
                }
            } else if (i == 2) {
                if (BaseManager.this.f11078G != null) {
                    BaseManager baseManager2 = BaseManager.this;
                    AdWorker adWorker = baseManager2.f11103i;
                    if (adWorker != null) {
                        adWorker.m47918q();
                        BaseManager baseManager3 = BaseManager.this;
                        baseManager3.m48726a(baseManager3.f11103i.mo46059g(), BaseManager.this.f11103i.mo46446o());
                        if ("4".equals(BaseManager.this.m48695f())) {
                            BaseManager baseManager4 = BaseManager.this;
                            if (!baseManager4.f11108n) {
                                baseManager4.f11103i.mo46061f();
                                BaseManager.this.f11108n = true;
                            }
                        }
                        Map<String, AdWorker> m48669r = BaseManager.this.m48669r();
                        if (m48669r != null) {
                            for (AdWorker adWorker2 : m48669r.values()) {
                                AdSpacesBean.BuyerBean mo46052k = adWorker2.mo46052k();
                                AdSpacesBean.BuyerBean mo46052k2 = BaseManager.this.f11103i.mo46052k();
                                if (mo46052k != null && mo46052k2 != null && (TextUtils.isEmpty(mo46052k.getBuyerSpaceUuId()) || TextUtils.isEmpty(mo46052k2.getBuyerSpaceUuId()) || !mo46052k.getBuyerSpaceUuId().equals(mo46052k2.getBuyerSpaceUuId()))) {
                                    BaseManager.this.m48711b(adWorker2, 2);
                                    C3116af.m48496a("BeiZis", "AdRequest timeout channel = " + mo46052k.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + BaseManager.this.f11078G.f10964g.m48969a(mo46052k.getBuyerSpaceUuId()));
                                    if (adWorker2.mo46056i() == AdStatus.ADDEFAULT) {
                                        BaseManager.this.f11078G.f10964g.m48968a(mo46052k.getBuyerSpaceUuId(), -1);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    baseManager2.m48754a(9999);
                    Map<String, AdWorker> m48669r2 = BaseManager.this.m48669r();
                    if (m48669r2 != null) {
                        for (AdWorker adWorker3 : m48669r2.values()) {
                            AdSpacesBean.BuyerBean mo46052k3 = adWorker3.mo46052k();
                            if (mo46052k3 != null) {
                                BaseManager.this.m48711b(adWorker3, 2);
                                C3116af.m48496a("BeiZis", "AdRequest timeout channel = " + mo46052k3.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + BaseManager.this.f11078G.f10964g.m48969a(mo46052k3.getBuyerSpaceUuId()));
                                if (BaseManager.this.f11078G.f10964g.m48969a(mo46052k3.getBuyerSpaceUuId()) < 4) {
                                    BaseManager.this.f11078G.f10964g.m48968a(mo46052k3.getBuyerSpaceUuId(), -1);
                                }
                            }
                        }
                    }
                }
            } else {
                if (i != 3) {
                    return;
                }
                ObserverAdStatus m48777f = AdManager.m48786a().m48777f();
                BaseManager.this.f11078G = new ObserverAdStatus(new EventBean(AdManager.f11053b, "", "", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                BaseManager baseManager5 = BaseManager.this;
                baseManager5.f11087P = baseManager5.f11078G.m48860a();
                BaseManager baseManager6 = BaseManager.this;
                baseManager6.f11097c = baseManager6.f11078G.m48858b();
                BaseManager.this.m48765E();
                BaseManager.this.f11087P.m48980a(BaseManager.this.f11097c);
                BaseManager.this.m48762H();
                if (m48777f != null && m48777f.f10958a.m48971a() == 2 && BaseManager.this.f11078G.f10959b.m48971a() == 0) {
                    BaseManager.this.f11078G.f10959b.m48970a(1);
                    if (BaseManager.this.f11078G.f10959b.m48971a() == 1) {
                        BaseManager.this.f11078G.f10959b.m48970a(2);
                        BaseManager baseManager7 = BaseManager.this;
                        baseManager7.f11114u = ChannelUtil.m48854a(baseManager7.f11096b, baseManager7.f11107m, baseManager7.m48695f());
                        if (BaseManager.this.f11114u == null) {
                            Log.d("BeiZis", "update spaceBean is null and return fail");
                            if (BaseManager.this.f11078G.f10959b.m48971a() != 2) {
                                BaseManager.this.f11078G.f10959b.m48970a(-2);
                                BaseManager.this.mo48728a("kGetLocalConfigStatusInternalError");
                                return;
                            }
                            int m48856a = ChannelUtil.m48856a();
                            if (m48856a == 1) {
                                BaseManager.this.f11078G.f10959b.m48970a(4);
                                BaseManager.this.m48754a(10001);
                                return;
                            } else if (m48856a == 2) {
                                BaseManager.this.f11078G.f10959b.m48970a(5);
                                BaseManager.this.m48754a(10100);
                                return;
                            } else if (m48856a == 3) {
                                BaseManager.this.f11078G.f10959b.m48970a(6);
                                BaseManager.this.m48754a(Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                                return;
                            } else {
                                BaseManager.this.m48754a(9999);
                                return;
                            }
                        }
                        BaseManager.this.m48754a(9999);
                        return;
                    }
                    BaseManager.this.f11078G.f10959b.m48970a(-2);
                    BaseManager.this.mo48728a("kGetLocalConfigStatusInternalError");
                    return;
                }
                BaseManager.this.m48754a(BleManager.f22896l);
            }
        }
    };

    /* renamed from: X */
    private TimerTask f11095X = new TimerTask() { // from class: com.beizi.fusion.d.e.4
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.d("BeiZis", "========update outTime==========:" + System.currentTimeMillis());
            BaseManager.this.f11111q.sendEmptyMessage(3);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseManager.java */
    /* renamed from: com.beizi.fusion.d.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3082a extends BroadcastReceiver {
        C3082a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("updateResult", 0);
                BaseManager.this.f11084M = true;
                if (TextUtils.equals(action, "com.ad.action.UPDATE_CONFIG_SUCCESS")) {
                    if (intExtra == 1) {
                        if (BaseManager.this.f11076E != null) {
                            BaseManager.this.f11076E.cancel();
                            BaseManager.this.f11076E = null;
                        }
                        BaseManager baseManager = BaseManager.this;
                        baseManager.m48751a(baseManager.f11098d);
                    } else if (intExtra == 0 && BaseManager.this.f11085N) {
                        if (BaseManager.this.f11076E != null) {
                            BaseManager.this.f11076E.cancel();
                            BaseManager.this.f11076E = null;
                        }
                        BaseManager baseManager2 = BaseManager.this;
                        baseManager2.m48751a(baseManager2.f11098d);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BaseManager(Context context, String str, BaseAdListener baseAdListener, long j) {
        if (context == null) {
            C3138av.m48297b("Illegal Argument: context is null");
        } else {
            this.f11096b = context;
            f11070a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (!(this.f11096b instanceof Activity)) {
                C3138av.m48297b("Illegal Argument: context is not Activity context");
            }
        }
        this.f11107m = str;
        this.f11102h = baseAdListener;
        this.f11100f = j;
        this.f11113t = this;
        m48768B();
    }

    /* renamed from: B */
    private void m48768B() {
        Context context = f11070a;
        if (context == null) {
            if (this.f11102h != null) {
                m48754a(10132);
                return;
            }
            return;
        }
        this.f11082K = LocalBroadcastManager.m48499a(context);
        IntentFilter intentFilter = new IntentFilter("com.ad.action.UPDATE_CONFIG_SUCCESS");
        C3082a c3082a = new C3082a();
        this.f11083L = c3082a;
        this.f11082K.m48500a(c3082a, intentFilter);
    }

    /* renamed from: C */
    private void m48767C() {
        TimerTask timerTask;
        if (this.f11084M) {
            return;
        }
        HeartScheduler.m48105a(f11070a).m48097b(5);
        Timer timer = this.f11076E;
        if (timer == null || (timerTask = this.f11095X) == null) {
            return;
        }
        timer.schedule(timerTask, this.f11100f);
    }

    /* renamed from: D */
    private void m48766D() {
        C3082a c3082a;
        LocalBroadcastManager localBroadcastManager = this.f11082K;
        if (localBroadcastManager == null || (c3082a = this.f11083L) == null) {
            return;
        }
        localBroadcastManager.m48501a(c3082a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m48765E() {
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48919b(this.f11099e);
            mo48582a();
            this.f11097c.m48913e(AdManager.m48786a().m48782b());
            this.f11097c.m48911f(this.f11107m);
            this.f11097c.m48909g(String.valueOf(this.f11100f));
        }
    }

    /* renamed from: F */
    private boolean m48764F() {
        TimerTask timerTask;
        TimerTask timerTask2;
        AdSpacesBean adSpacesBean = this.f11114u;
        if (adSpacesBean == null) {
            return false;
        }
        AdSpacesBean.BidBean bid = adSpacesBean.getBid();
        if (bid != null) {
            this.f11115v = bid.getReserveFRWTime();
            this.f11116w = bid.getReserveTime();
        }
        Log.d("BeiZis", this.f11100f + ":mUsableTime=====" + this.f11115v + "=====mLastTime:" + this.f11116w);
        if ((this instanceof NativeNotificationManager) || (this instanceof NativeFloatManager)) {
            return false;
        }
        long j = this.f11100f;
        if (j > this.f11116w) {
            long j2 = this.f11115v;
            if (j > j2) {
                Timer timer = this.f11074C;
                if (timer != null && (timerTask2 = this.f11093V) != null) {
                    timer.schedule(timerTask2, j - j2);
                }
            } else {
                this.f11118y = this.f11072A;
            }
            Timer timer2 = this.f11075D;
            if (timer2 != null && (timerTask = this.f11094W) != null) {
                timer2.schedule(timerTask, this.f11100f - this.f11116w);
            }
            return false;
        }
        m48754a(10120);
        this.f11078G.f10959b.m48970a(7);
        return true;
    }

    /* renamed from: G */
    private void m48763G() {
        FreqUtil.m48159b(f11070a, this.f11107m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m48762H() {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10959b.addObserver(observerAdStatus);
            ObserverAdStatus observerAdStatus2 = this.f11078G;
            observerAdStatus2.f10960c.addObserver(observerAdStatus2);
            ObserverAdStatus observerAdStatus3 = this.f11078G;
            observerAdStatus3.f10961d.addObserver(observerAdStatus3);
            ObserverAdStatus observerAdStatus4 = this.f11078G;
            observerAdStatus4.f10962e.addObserver(observerAdStatus4);
            ObserverAdStatus observerAdStatus5 = this.f11078G;
            observerAdStatus5.f10963f.addObserver(observerAdStatus5);
            ObserverAdStatus observerAdStatus6 = this.f11078G;
            observerAdStatus6.f10964g.addObserver(observerAdStatus6);
            ObserverAdStatus observerAdStatus7 = this.f11078G;
            observerAdStatus7.f10965h.addObserver(observerAdStatus7);
            ObserverAdStatus observerAdStatus8 = this.f11078G;
            observerAdStatus8.f10966i.addObserver(observerAdStatus8);
            ObserverAdStatus observerAdStatus9 = this.f11078G;
            observerAdStatus9.f10967j.addObserver(observerAdStatus9);
            ObserverAdStatus observerAdStatus10 = this.f11078G;
            observerAdStatus10.f10968k.addObserver(observerAdStatus10);
        }
    }

    /* renamed from: I */
    private void m48761I() {
        AdSpacesBean adSpacesBean = this.f11114u;
        if (adSpacesBean != null) {
            String str = null;
            String adType = adSpacesBean.getAdType();
            adType.hashCode();
            char c = 65535;
            switch (adType.hashCode()) {
                case -1999289321:
                    if (adType.equals("NATIVE")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1842536857:
                    if (adType.equals("SPLASH")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1372958932:
                    if (adType.equals("INTERSTITIAL")) {
                        c = 2;
                        break;
                    }
                    break;
                case -370591475:
                    if (adType.equals("REWARDEDVIDEO")) {
                        c = 3;
                        break;
                    }
                    break;
                case -43721614:
                    if (adType.equals("DRAWFLOW")) {
                        c = 4;
                        break;
                    }
                    break;
                case 252355794:
                    if (adType.equals("INTERACTIVECARD")) {
                        c = 5;
                        break;
                    }
                    break;
                case 658985344:
                    if (adType.equals("FULLSCREENVIDEO")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1723213558:
                    if (adType.equals("REGIONALNATIVE")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1951953708:
                    if (adType.equals("BANNER")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
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
                    str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    break;
                case 6:
                    str = "6";
                    break;
                case 7:
                    str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                    break;
                case '\b':
                    str = "4";
                    break;
            }
            EventBean eventBean = this.f11097c;
            if (eventBean != null) {
                eventBean.m48915d(str);
            }
        }
    }

    /* renamed from: J */
    private boolean m48760J() {
        if (this.f11092U) {
            AdWorker adWorker = this.f11110p;
            if (adWorker != null) {
                return adWorker != null && adWorker.mo46056i() == AdStatus.ADDEFAULT;
            }
            return true;
        }
        return false;
    }

    /* renamed from: K */
    private boolean m48759K() {
        for (AdWorker adWorker : m48669r().values()) {
            if (adWorker.mo46056i() == AdStatus.ADDEFAULT) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: L */
    private synchronized void m48758L() {
        this.f11105k.clear();
    }

    /* renamed from: M */
    private void m48757M() {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus == null || observerAdStatus.f10967j.m48971a() != 0) {
            return;
        }
        this.f11078G.f10967j.m48970a(1);
    }

    /* renamed from: N */
    private void m48756N() {
        if (this.f11078G != null) {
            C3116af.m48495b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.f11078G.f10967j.m48971a());
        }
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            if (observerAdStatus.f10967j.m48971a() == 1 || this.f11078G.f10967j.m48971a() == 2 || this.f11078G.f10967j.m48971a() == 3) {
                this.f11078G.f10967j.m48970a(3);
            }
        }
    }

    /* renamed from: O */
    private void m48755O() {
        if (this.f11078G != null) {
            C3116af.m48495b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.f11078G.f10967j.m48971a());
        }
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            if (observerAdStatus.f10967j.m48971a() == 3 || this.f11078G.f10967j.m48971a() == 1 || this.f11078G.f10967j.m48971a() == 2) {
                this.f11078G.f10967j.m48970a(4);
            }
        }
    }

    /* renamed from: A */
    public String m48769A() {
        AdSpacesBean.BuyerBean mo46052k;
        AdWorker adWorker = this.f11103i;
        if (adWorker == null || (mo46052k = adWorker.mo46052k()) == null || TextUtils.isEmpty(mo46052k.getBuyerSpaceUuId())) {
            return null;
        }
        return mo46052k.getBuyerSpaceUuId();
    }

    /* renamed from: a */
    public abstract AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker);

    /* renamed from: a */
    protected abstract void mo48582a();

    /* renamed from: l */
    public void m48676l() {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoComplete();
            } else if (baseAdListener instanceof DrawAdListener) {
                ((DrawAdListener) baseAdListener).onVideoComplete();
            }
        }
    }

    /* renamed from: m */
    public void m48674m() {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener instanceof DrawAdListener) {
            ((DrawAdListener) baseAdListener).onVideoPlayError();
        }
    }

    /* renamed from: n */
    public void m48673n() {
        this.f11109o = true;
        m48717b();
        m48707c();
        AdWorker adWorker = this.f11103i;
        if (adWorker != null) {
            adWorker.mo46173m();
        }
        if (this.f11088Q != this.f11089R) {
            this.f11102h = null;
        }
        Map<String, AdWorker> map = this.f11104j;
        if (map != null) {
            map.clear();
        }
        ArrayList<AdShowObserver> arrayList = this.f11105k;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.f11113t != null) {
            this.f11113t = null;
        }
        m48766D();
        m48699e();
    }

    /* renamed from: o */
    public void m48672o() {
        AdWorker adWorker = this.f11103i;
        if (adWorker != null) {
            adWorker.mo46703n();
        }
    }

    /* renamed from: p */
    protected void m48671p() {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            if (observerAdStatus.f10967j.m48971a() == 1 || this.f11078G.f10967j.m48971a() == 3 || this.f11078G.f10967j.m48971a() == 4) {
                this.f11078G.f10967j.m48970a(2);
            }
        }
    }

    /* renamed from: q */
    protected void m48670q() {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            if (observerAdStatus.f10967j.m48971a() == 0 || this.f11078G.f10967j.m48971a() == 1) {
                this.f11078G.f10967j.m48970a(5);
            }
        }
    }

    /* renamed from: r */
    public Map<String, AdWorker> m48669r() {
        return this.f11104j;
    }

    /* renamed from: s */
    public int m48668s() {
        return this.f11118y;
    }

    /* renamed from: t */
    public int m48667t() {
        return this.f11117x;
    }

    /* renamed from: u */
    public void m48666u() {
        C3116af.m48494c("BeiZis", "enter clearAdStatus");
        this.f11117x = 0;
        this.f11077F = false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    /* renamed from: v */
    public boolean m48665v() {
        return f11071r;
    }

    /* renamed from: w */
    public int m48664w() {
        AdSpacesBean adSpacesBean = this.f11114u;
        if (adSpacesBean == null || adSpacesBean.getEventStrategy() == null) {
            return Integer.MAX_VALUE;
        }
        AdSpacesBean.EventStrategyBean eventStrategy = this.f11114u.getEventStrategy();
        if (eventStrategy.getValidTimeShow() >= 0) {
            return eventStrategy.getValidTimeShow();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: x */
    public Integer[] m48663x() {
        AdSpacesBean.EventStrategyBean eventStrategy;
        List<AdSpacesBean.RandomStrategyBean> randomStrategy;
        AdSpacesBean adSpacesBean = this.f11114u;
        if (adSpacesBean != null && adSpacesBean.getEventStrategy() != null && (eventStrategy = this.f11114u.getEventStrategy()) != null && (randomStrategy = eventStrategy.getRandomStrategy()) != null && randomStrategy.size() > 0) {
            for (int i = 0; i < randomStrategy.size(); i++) {
                AdSpacesBean.RandomStrategyBean randomStrategyBean = randomStrategy.get(i);
                if (TTLogUtil.TAG_EVENT_SHOW.equalsIgnoreCase(randomStrategyBean.getEventType())) {
                    return new Integer[]{Integer.valueOf(randomStrategyBean.getMin()), Integer.valueOf(randomStrategyBean.getMax())};
                }
            }
        }
        return new Integer[]{0, 0};
    }

    /* renamed from: y */
    public boolean m48662y() {
        return this.f11112s;
    }

    /* renamed from: z */
    public String m48661z() {
        AdSpacesBean adSpacesBean = this.f11086O;
        if (adSpacesBean != null) {
            return adSpacesBean.getSpaceId();
        }
        return null;
    }

    /* renamed from: c */
    private void m48707c() {
        TimerTask timerTask = this.f11094W;
        if (timerTask != null) {
            timerTask.cancel();
            this.f11094W = null;
        }
        Timer timer = this.f11075D;
        if (timer != null) {
            timer.cancel();
            this.f11075D = null;
        }
        Timer timer2 = this.f11076E;
        if (timer2 != null) {
            timer2.cancel();
            this.f11076E = null;
        }
    }

    /* renamed from: g */
    private boolean m48689g(String str) {
        return str.equals("HPFRW");
    }

    /* renamed from: h */
    private String m48686h(String str) {
        C3116af.m48496a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        return StringUtil.m48307b().equals(str) ? "BEIZI" : str;
    }

    /* renamed from: d */
    public ObserverAdStatus m48703d() {
        return this.f11078G;
    }

    /* renamed from: e */
    protected void m48699e() {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10959b.deleteObservers();
            this.f11078G.f10960c.deleteObservers();
            this.f11078G.f10961d.deleteObservers();
            this.f11078G.f10962e.deleteObservers();
            this.f11078G.f10963f.deleteObservers();
            this.f11078G.f10964g.deleteObservers();
            this.f11078G.f10965h.deleteObservers();
            this.f11078G.f10966i.deleteObservers();
            this.f11078G.f10967j.deleteObservers();
            this.f11078G.f10968k.deleteObservers();
        }
    }

    /* renamed from: f */
    public String m48695f() {
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            return eventBean.m48914e();
        }
        return null;
    }

    /* renamed from: i */
    public String m48685i() {
        return this.f11107m;
    }

    /* renamed from: j */
    public synchronized void m48682j() {
        Iterator<AdShowObserver> it = this.f11105k.iterator();
        while (it.hasNext()) {
            it.next().mo47968a();
        }
        m48758L();
    }

    /* renamed from: k */
    public void m48679k() {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener == null || !(baseAdListener instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) baseAdListener).onRewarded();
    }

    /* renamed from: d */
    private boolean m48701d(AdWorker adWorker) {
        if (adWorker == null) {
            return false;
        }
        for (AdWorker adWorker2 : m48669r().values()) {
            AdSpacesBean.BuyerBean mo46052k = adWorker2.mo46052k();
            AdSpacesBean.BuyerBean mo46052k2 = adWorker.mo46052k();
            if (mo46052k != null && mo46052k2 != null && (TextUtils.isEmpty(mo46052k.getBuyerSpaceUuId()) || TextUtils.isEmpty(mo46052k2.getBuyerSpaceUuId()) || !mo46052k.getBuyerSpaceUuId().equals(mo46052k2.getBuyerSpaceUuId()))) {
                if (!m48712b(adWorker2) && !m48705c(adWorker2)) {
                    C3116af.m48494c("BeiZis", "worker.getAdStatus():" + adWorker2.mo46056i() + ":" + adWorker2.mo46059g());
                    if (adWorker2.mo46056i() != AdStatus.ADFAIL && m48697e(adWorker2) > m48697e(adWorker)) {
                        return false;
                    }
                } else {
                    double m48693f = m48693f(adWorker2);
                    if (adWorker2.mo46056i() == AdStatus.ADDEFAULT || m48693f > m48697e(adWorker)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: i */
    private boolean m48683i(String str) {
        return "FinalLink".equalsIgnoreCase(str);
    }

    /* renamed from: g */
    protected void m48691g() {
        this.f11078G.f10961d.m48970a(3);
        m48754a(10140);
    }

    /* renamed from: b */
    private void m48717b() {
        TimerTask timerTask = this.f11093V;
        if (timerTask != null) {
            timerTask.cancel();
            this.f11093V = null;
        }
        Timer timer = this.f11074C;
        if (timer != null) {
            timer.cancel();
            this.f11074C = null;
        }
        Timer timer2 = this.f11076E;
        if (timer2 != null) {
            timer2.cancel();
            this.f11076E = null;
        }
    }

    /* renamed from: f */
    private double m48693f(AdWorker adWorker) {
        AdSpacesBean.BuyerBean mo46052k;
        return (adWorker == null || (mo46052k = adWorker.mo46052k()) == null) ? Utils.DOUBLE_EPSILON : mo46052k.getBidPrice();
    }

    /* renamed from: h */
    public boolean m48688h() {
        return (m48667t() == 2 || m48667t() == 3) ? false : true;
    }

    @NonNull
    /* renamed from: k */
    private CompeteStatus m48677k(String str) {
        m48680j(str);
        return CompeteStatus.SUCCESS;
    }

    /* renamed from: j */
    private void m48680j(String str) {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(str, 3);
        }
    }

    @NonNull
    /* renamed from: l */
    private CompeteStatus m48675l(String str) {
        m48692f(str);
        return CompeteStatus.FAIL;
    }

    /* renamed from: f */
    protected void m48692f(String str) {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(str, 4);
        }
    }

    /* renamed from: c */
    public void m48704c(String str) {
        if (this.f11088Q == this.f11089R) {
            this.f11088Q = this.f11090S;
        }
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof AdListener) {
                ((AdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoAdClosed();
            } else if (baseAdListener instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof NativeAdListener) {
                ((NativeAdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof BannerAdListener) {
                ((BannerAdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) baseAdListener).onAdClosed();
            } else if (baseAdListener instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) baseAdListener).onAdClosed();
            }
        }
        m48755O();
    }

    /* renamed from: a */
    public void m48751a(ViewGroup viewGroup) {
        List<AdSpacesBean.BuyerBean> list;
        AdSpacesBean.BidComponent bidComponent;
        List<AdSpacesBean> adSpaces;
        AdSpacesBean adSpacesBean;
        if (this.f11081J || this.f11096b == null || f11070a == null) {
            return;
        }
        this.f11098d = viewGroup;
        this.f11079H = System.currentTimeMillis();
        this.f11099e = StringUtil.m48312a();
        ObserverAdStatus m48777f = AdManager.m48786a().m48777f();
        ObserverAdStatus observerAdStatus = new ObserverAdStatus(new EventBean(AdManager.f11053b, "", "", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        this.f11078G = observerAdStatus;
        this.f11087P = observerAdStatus.m48860a();
        this.f11097c = this.f11078G.m48858b();
        m48765E();
        this.f11087P.m48980a(this.f11097c);
        m48762H();
        if (!BeiZis.isIsSyncInit() && ((m48777f == null || m48777f.f10958a.m48971a() != 2) && !this.f11091T)) {
            ResponseInfo.getInstance(f11070a).init();
            this.f11091T = true;
        }
        if (m48777f != null) {
            C3116af.m48495b("BeiZis", "mInitObserver.mInitStatus.getStatus() = " + m48777f.f10958a.m48971a() + ",mManagerObserver.mGetLocalConfigStatus.getStatus() = " + this.f11078G.f10959b.m48971a());
        }
        if ((m48777f != null && m48777f.f10958a.m48971a() == 2 && this.f11078G.f10959b.m48971a() == 0) || this.f11091T) {
            this.f11078G.f10959b.m48970a(1);
            if (this.f11078G.f10959b.m48971a() == 1) {
                this.f11078G.f10959b.m48970a(2);
                AdSpacesBean m48854a = ChannelUtil.m48854a(this.f11096b, this.f11107m, m48695f());
                this.f11114u = m48854a;
                if (m48854a != null) {
                    EventBean eventBean = this.f11097c;
                    if (eventBean != null) {
                        eventBean.m48966A(m48854a.getFilterSsid());
                        this.f11097c.m48964B(this.f11114u.getComponentSsid());
                        this.f11097c.m48962C(this.f11114u.getBzComponentSsid());
                        m48761I();
                    }
                    ResponseInfo responseInfo = ResponseInfo.getInstance(f11070a);
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
                        if (System.currentTimeMillis() - ((Long) C3137at.m48313b(f11070a, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue() <= maxValidTime) {
                            this.f11085N = false;
                            this.f11081J = true;
                            if (this.f11078G.f10959b.m48971a() == 2) {
                                this.f11078G.f10959b.m48970a(3);
                                if (m48764F()) {
                                    return;
                                }
                                m48763G();
                                if (this.f11078G.m48857c()) {
                                    this.f11078G.f10959b.m48970a(-1);
                                    return;
                                } else {
                                    m48732a(this.f11114u);
                                    return;
                                }
                            }
                            return;
                        }
                        this.f11081J = false;
                        this.f11085N = true;
                        m48767C();
                        return;
                    }
                    this.f11081J = false;
                    m48767C();
                    return;
                }
                Log.d("BeiZis", "spaceBean is null and return fail mUpdateConfigSuccess:" + this.f11084M);
                if (this.f11084M) {
                    if (this.f11078G.f10959b.m48971a() == 2) {
                        int m48856a = ChannelUtil.m48856a();
                        if (m48856a == 1) {
                            this.f11078G.f10959b.m48970a(4);
                            m48754a(10001);
                            return;
                        } else if (m48856a == 2) {
                            this.f11078G.f10959b.m48970a(5);
                            m48754a(10100);
                            return;
                        } else if (m48856a == 3) {
                            this.f11078G.f10959b.m48970a(6);
                            m48754a(Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f11078G.f10959b.m48970a(-2);
                    mo48728a("kGetLocalConfigStatusInternalError");
                    return;
                }
                Log.e("BeiZis", "startUpdateConfig");
                this.f11081J = false;
                m48767C();
                return;
            }
            this.f11078G.f10959b.m48970a(-2);
            mo48728a("kGetLocalConfigStatusInternalError");
        } else if (this.f11084M) {
            this.f11081J = false;
            m48767C();
        } else {
            m48754a(BleManager.f22896l);
        }
    }

    /* renamed from: b */
    private void m48708b(List<AdSpacesBean.ForwardBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f11092U = true;
        new BidS2SRequest(new BidS2SRequest.InterfaceC3057a() { // from class: com.beizi.fusion.d.e.6
            @Override // com.beizi.fusion.p066d.p067a.BidS2SRequest.InterfaceC3057a
            /* renamed from: a */
            public void mo48658a(String str, int i) {
                BaseManager.this.f11078G.f10964g.m48968a(str, i);
            }

            @Override // com.beizi.fusion.p066d.p067a.BidS2SRequest.InterfaceC3057a
            /* renamed from: a */
            public void mo48659a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str, double d) {
                if (BaseManager.this.f11118y == BaseManager.this.f11119z && forwardBean != null && buyerBean != null) {
                    BaseManager baseManager = BaseManager.this;
                    if (baseManager.m48697e(baseManager.f11103i) < d) {
                        String buyerId = forwardBean.getBuyerId();
                        String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                        BaseManager.this.f11087P.m48978a(buyerBean, forwardBean);
                        BaseManager.this.f11078G.f10962e.m48968a(buyerSpaceUuId, 1);
                        if (BaseManager.this.m48733a(forwardBean, buyerBean, buyerSpaceUuId)) {
                            BaseManager baseManager2 = BaseManager.this;
                            baseManager2.f11110p = baseManager2.mo48580a(forwardBean, buyerId, buyerBean, buyerBean.getRenderView(), null);
                            AdWorker adWorker = BaseManager.this.f11110p;
                            if (adWorker != null) {
                                adWorker.m47965a(forwardBean.getSleepTime());
                                BaseManager.this.f11110p.m47963a(forwardBean);
                                BaseManager.this.f11110p.m47964a(buyerBean);
                                BaseManager.this.f11110p.m47962a(buyerBean.getBidType());
                                BaseManager baseManager3 = BaseManager.this;
                                baseManager3.m48722a(buyerId, buyerSpaceUuId, baseManager3.f11110p);
                                BaseManager.this.f11110p.mo46065d();
                                BaseManager.this.f11110p.m47960a(true);
                                return;
                            }
                        } else {
                            BaseManager.this.f11092U = false;
                            BaseManager.this.m48737a((AdSpacesBean.ComponentBean) null, buyerBean.getBidType(), true, 10130);
                            return;
                        }
                    }
                }
                BaseManager.this.f11092U = false;
                BaseManager.this.m48737a((AdSpacesBean.ComponentBean) null, buyerBean.getBidType(), true, 10160);
            }

            @Override // com.beizi.fusion.p066d.p067a.BidS2SRequest.InterfaceC3057a
            /* renamed from: a */
            public void mo48657a(String str, String str2, String str3, int i) {
                BaseManager.this.f11092U = false;
                BaseManager.this.m48737a((AdSpacesBean.ComponentBean) null, "S2S", true, 10160);
                if (BaseManager.this.f11097c != null && !TextUtils.isEmpty(str2)) {
                    BaseManager.this.f11097c.m48905i(str2);
                    BaseManager.this.f11097c.m48897m(str);
                    BaseManager.this.f11087P.m48975a(str3, BaseManager.this.f11097c);
                }
                if (BaseManager.this.f11078G == null || BaseManager.this.f11078G.f10964g == null) {
                    return;
                }
                BaseManager.this.f11078G.f10964g.m48968a(str3, i);
            }

            @Override // com.beizi.fusion.p066d.p067a.BidS2SRequest.InterfaceC3057a
            /* renamed from: a */
            public void mo48660a() {
                BaseManager.this.f11092U = false;
                BaseManager.this.m48737a((AdSpacesBean.ComponentBean) null, "S2S", true, 10160);
            }
        }).m48853a(this.f11096b, m48695f(), m48661z(), list, this.f11080I, this.f11114u.getBid().getBidTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public double m48697e(AdWorker adWorker) {
        if (adWorker == null || adWorker.mo46052k() == null) {
            return Utils.DOUBLE_EPSILON;
        }
        AdSpacesBean.BuyerBean mo46052k = adWorker.mo46052k();
        if (!m48705c(adWorker) && !m48712b(adWorker)) {
            return mo46052k.getAvgPrice();
        }
        if (mo46052k.getBidPrice() > Utils.DOUBLE_EPSILON) {
            return mo46052k.getBidPrice();
        }
        return mo46052k.getAvgPrice();
    }

    /* renamed from: d */
    public void m48700d(String str) {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof AdListener) {
                ((AdListener) baseAdListener).onAdClicked();
            } else if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoClick();
            } else if (baseAdListener instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof NativeAdListener) {
                ((NativeAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof BannerAdListener) {
                ((BannerAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof DrawAdListener) {
                ((DrawAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) baseAdListener).onAdClick();
            } else if (baseAdListener instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) baseAdListener).onAdClick();
            }
        }
        m48756N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m48711b(AdWorker adWorker, int i) {
        if (m48712b(adWorker) || m48705c(adWorker)) {
            if (adWorker.mo46059g().equalsIgnoreCase("GDT") || adWorker.mo46059g().equalsIgnoreCase("BAIDU")) {
                adWorker.mo46064d(i);
            }
        }
    }

    /* renamed from: e */
    protected void m48696e(String str) {
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(str, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m48716b(int i) {
        m48730a(this.f11103i, i);
        this.f11103i.m47918q();
        m48726a(this.f11103i.mo46059g(), this.f11103i.mo46446o());
        if (!"4".equals(m48695f()) || this.f11108n) {
            return;
        }
        this.f11103i.mo46061f();
        this.f11108n = true;
    }

    /* renamed from: b */
    public void m48710b(String str) {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null && (baseAdListener instanceof BannerAdListener)) {
            ((BannerAdListener) baseAdListener).onAdShown();
        } else if (this.f11117x >= 2 && !m48683i(str)) {
            return;
        }
        if (this.f11088Q == 0) {
            this.f11088Q = this.f11089R;
        }
        Log.d("BeiZis", "AdShow:" + str);
        this.f11117x = 2;
        BaseAdListener baseAdListener2 = this.f11102h;
        if (baseAdListener2 != null) {
            if (baseAdListener2 instanceof AdListener) {
                ((AdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener2).onRewardedVideoAdShown();
            } else if (baseAdListener2 instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof DrawAdListener) {
                ((DrawAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof NativeAdListener) {
                ((NativeAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) baseAdListener2).onAdShown();
            } else if (baseAdListener2 instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) baseAdListener2).onAdShown();
            }
        }
        m48671p();
        m48682j();
    }

    /* renamed from: c */
    protected boolean m48705c(AdWorker adWorker) {
        return "C2S".equalsIgnoreCase(adWorker.m47920h());
    }

    /* renamed from: b */
    public void m48709b(String str, View view) {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null && view != null && (baseAdListener instanceof NativeAdListener)) {
            ((NativeAdListener) baseAdListener).onAdClosed(view);
        }
        m48755O();
    }

    /* renamed from: b */
    protected boolean m48712b(AdWorker adWorker) {
        return "S2S".equalsIgnoreCase(adWorker.m47920h());
    }

    @Override // com.beizi.fusion.p066d.AdLifeControl
    /* renamed from: a */
    public void mo48728a(String str) {
        C3116af.m48494c("BeiZis", "enter handleAdRequestStatusError error is " + str);
        m48754a(10131);
    }

    /* renamed from: a */
    public void m48723a(String str, final String str2, final EventItem eventItem) {
        if (Arrays.asList(com.beizi.fusion.p072g.Constants.f11408a).contains(str)) {
            FreqUtil.m48164a(str2, eventItem);
            C3145h.m48264b().m48263c().execute(new Runnable() { // from class: com.beizi.fusion.d.e.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DaoManager.m48999a(BaseManager.this.f11096b).m48994a(str2, eventItem);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m48732a(AdSpacesBean adSpacesBean) {
        if (this.f11078G.f10959b.m48971a() == 3 && this.f11078G.f10960c.m48971a() == 0) {
            this.f11078G.f10960c.m48970a(1);
            this.f11104j.clear();
            AdSpacesBean.FilterBean filter = adSpacesBean.getFilter();
            this.f11080I = adSpacesBean.getBuyer();
            AdStrategy.m48531a(this.f11096b, this.f11100f, filter, this.f11078G, m48685i(), null, null, this);
            if (this.f11078G.f10960c.m48971a() == 2) {
                if (this.f11078G.m48857c()) {
                    this.f11078G.f10960c.m48970a(-1);
                    return;
                }
                m48723a("200.000", this.f11107m, new EventItem("200.000", String.valueOf(System.currentTimeMillis()), null, null));
                this.f11086O = adSpacesBean;
                C3116af.m48494c("BeiZis", "normal request");
                m48735a(this.f11086O.getComponent(), false);
                return;
            }
            m48753a(this.f11078G.f10960c.m48971a(), 6, "platform error = ");
            Log.d("BeiZis", "AdDispenses AdFilter fail:" + AdProcessStatus.m48983a(this.f11078G.f10960c));
            m48754a(10130);
            return;
        }
        this.f11078G.f10960c.m48970a(-2);
        mo48728a("kPlatformFilterStatusInternalError");
    }

    /* renamed from: a */
    protected void m48735a(AdSpacesBean.ComponentBean componentBean, boolean z) {
        C3116af.m48496a("BeiZis", "enter auctionAndRequestAd");
        if (this.f11114u == null) {
            return;
        }
        List<AdSpacesBean.BuyerBean> list = this.f11080I;
        if (list != null && list.size() != 0) {
            if (m48667t() >= 1) {
                C3116af.m48496a("BeiZis", "auctionAndRequestAd ad aleady callback");
                return;
            }
            if (!z) {
                this.f11078G.f10961d.m48970a(1);
            }
            List<AdSpacesBean.ForwardBean> m48736a = m48736a(componentBean, this.f11080I, z);
            if (!z) {
                this.f11078G.f10961d.m48970a(2);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (m48736a != null && m48736a.size() > 0) {
                for (AdSpacesBean.ForwardBean forwardBean : m48736a) {
                    AdSpacesBean.BuyerBean m48721a = m48721a(forwardBean.getBuyerId(), this.f11080I, forwardBean.getBuyerSpaceUuId());
                    if (m48721a != null) {
                        if ("S2S".equalsIgnoreCase(m48721a.getBidType())) {
                            arrayList.add(forwardBean);
                        } else {
                            arrayList2.add(forwardBean);
                        }
                    }
                }
            }
            Map<String, AdWorker> m48720a = m48720a(arrayList2);
            m48708b(arrayList);
            m48719a(m48720a);
            return;
        }
        C3116af.m48496a("BeiZis", "auctionAndRequestAd mBuyerBeanList == null ");
    }

    /* renamed from: a */
    private List<AdSpacesBean.ForwardBean> m48736a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, boolean z) {
        List<AdSpacesBean.ForwardBean> m48528a;
        AdSpacesBean adSpacesBean;
        ArrayList arrayList = new ArrayList();
        if (!z && (adSpacesBean = this.f11114u) != null && adSpacesBean.getBid() != null && this.f11114u.getBidComponent() != null && this.f11114u.getBidComponent().getBidList() != null && this.f11114u.getBidComponent().getBidList().size() > 0) {
            arrayList.addAll(this.f11114u.getBidComponent().getBidList());
        }
        if (this.f11114u != null && componentBean != null && (m48528a = AdStrategy.m48528a(componentBean, list, m48685i())) != null && m48528a.size() > 0) {
            arrayList.addAll(m48528a);
        }
        return arrayList;
    }

    /* renamed from: a */
    protected Map<String, AdWorker> m48720a(List<AdSpacesBean.ForwardBean> list) {
        AdWorker mo48580a;
        if (list == null || list.size() == 0) {
            return null;
        }
        C3116af.m48496a("BeiZis", "generateWorkers forwardBeans.size() = " + list.size());
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = list.get(i);
            if (forwardBean != null) {
                String buyerId = forwardBean.getBuyerId();
                String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                AdSpacesBean.BuyerBean m48721a = m48721a(buyerId, this.f11080I, forwardBean.getBuyerSpaceUuId());
                if (m48721a != null) {
                    this.f11087P.m48978a(m48721a, forwardBean);
                    this.f11078G.f10962e.m48968a(buyerSpaceUuId, 1);
                    if (m48733a(forwardBean, m48721a, buyerSpaceUuId) && (mo48580a = mo48580a(forwardBean, buyerId, m48721a, m48721a.getRenderView(), null)) != null) {
                        mo48580a.m47965a(forwardBean.getSleepTime());
                        mo48580a.m47963a(forwardBean);
                        mo48580a.m47964a(m48721a);
                        mo48580a.m47962a(m48721a.getBidType());
                        m48722a(buyerId, buyerSpaceUuId, mo48580a);
                        hashtable.put(m48686h(buyerId) + buyerSpaceUuId, mo48580a);
                        C3116af.m48496a("BeiZis", "generateWorkers put new " + buyerId + " worker into workerList");
                    }
                }
            }
        }
        return hashtable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m48733a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str) {
        this.f11078G.f10962e.m48968a(str, 2);
        if (buyerBean != null) {
            try {
                long longValue = ((Long) C3137at.m48313b(this.f11096b, "complain_config_" + buyerBean.getSpaceId(), 0L)).longValue();
                AdSpacesBean.ComplainBean complain = buyerBean.getComplain();
                if (complain != null) {
                    if (System.currentTimeMillis() - longValue < complain.getDuration()) {
                        this.f11078G.f10962e.m48968a(str, 10);
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AdStrategy.m48531a(this.f11096b, this.f11100f, buyerBean.getFilter(), this.f11078G, m48685i(), buyerBean.getBuyerSpaceUuId(), buyerBean.getSpaceId(), this);
        if (this.f11078G.f10962e.m48969a(str) == 3) {
            if (this.f11078G.m48857c()) {
                this.f11078G.f10962e.m48968a(str, -1);
                return false;
            } else if (m48734a(forwardBean, buyerBean) != 2) {
                return false;
            } else {
                this.f11078G.f10962e.m48968a(str, 3);
                return true;
            }
        }
        m48753a(this.f11078G.f10962e.m48969a(str), 7, "channel error = ");
        Log.d("BeiZis", "AdDispense buyerBean AdFilter fail:" + AdProcessStatus.m48976a(str, this.f11078G.f10962e));
        return false;
    }

    /* renamed from: a */
    private void m48719a(Map<String, AdWorker> map) {
        if (map != null && map.size() != 0) {
            for (AdWorker adWorker : map.values()) {
                adWorker.mo46065d();
                adWorker.m47960a(true);
            }
            return;
        }
        m48691g();
    }

    /* renamed from: a */
    public CompeteStatus m48731a(AdWorker adWorker) {
        AdSpacesBean.BuyerBean mo46052k = adWorker.mo46052k();
        if (mo46052k == null) {
            return null;
        }
        String id = mo46052k.getId();
        String buyerSpaceUuId = mo46052k.getBuyerSpaceUuId();
        String zone = mo46052k.getZone();
        C3116af.m48496a("BeiZis", "enter comparePrices compareWorker:" + adWorker.mo46059g() + ",mCurrentHighestWorker:" + this.f11103i);
        if (m48683i(adWorker.mo46059g())) {
            return m48724a(buyerSpaceUuId, adWorker, id);
        }
        ObserverAdStatus observerAdStatus = this.f11078G;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(buyerSpaceUuId, 1);
        }
        if (this.f11117x >= 1) {
            m48711b(adWorker, 1);
            return m48675l(buyerSpaceUuId);
        } else if (m48760J()) {
            return m48725a(buyerSpaceUuId, adWorker);
        } else {
            boolean m48689g = m48689g(zone);
            boolean m48701d = m48701d(adWorker);
            StringBuilder sb = new StringBuilder();
            sb.append("channel == mTimeStage = ");
            sb.append(this.f11118y == this.f11072A);
            sb.append(";isNeedComparePrices = ");
            sb.append(m48689g);
            sb.append(",isHighestPrice:");
            sb.append(m48701d);
            sb.append(";mCurrentHighestWorker:");
            sb.append(this.f11103i);
            C3116af.m48496a("BeiZis", sb.toString());
            if (this.f11118y == this.f11119z && m48689g && !m48701d) {
                double m48697e = m48697e(adWorker);
                double m48697e2 = m48697e(this.f11103i);
                if (this.f11103i != null && m48697e <= m48697e2) {
                    m48711b(adWorker, 1);
                    if (m48701d(this.f11103i)) {
                        m48716b(1);
                    }
                    return m48675l(buyerSpaceUuId);
                }
                return m48725a(buyerSpaceUuId, adWorker);
            }
            return m48724a(buyerSpaceUuId, adWorker, id);
        }
    }

    /* renamed from: a */
    private void m48730a(AdWorker adWorker, int i) {
        if (adWorker == null) {
            return;
        }
        for (AdWorker adWorker2 : m48669r().values()) {
            AdSpacesBean.BuyerBean mo46052k = adWorker2.mo46052k();
            AdSpacesBean.BuyerBean mo46052k2 = adWorker.mo46052k();
            if (mo46052k != null && mo46052k2 != null && (TextUtils.isEmpty(mo46052k.getBuyerSpaceUuId()) || TextUtils.isEmpty(mo46052k2.getBuyerSpaceUuId()) || !mo46052k.getBuyerSpaceUuId().equals(mo46052k2.getBuyerSpaceUuId()))) {
                m48711b(adWorker2, i);
                if (adWorker2.m47956aE() == CompeteStatus.TO_DETERMINE) {
                    m48692f(mo46052k.getBuyerSpaceUuId());
                } else if (adWorker2.mo46056i() == AdStatus.ADDEFAULT) {
                    m48696e(mo46052k.getBuyerSpaceUuId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48722a(String str, String str2, AdWorker adWorker) {
        Map<String, AdWorker> map = this.f11104j;
        map.put(m48686h(str) + "_" + str2, adWorker);
    }

    @Nullable
    /* renamed from: a */
    protected AdSpacesBean.BuyerBean m48721a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        return AdStrategy.m48524a(str, list, str2);
    }

    /* renamed from: a */
    protected void m48753a(int i, int i2, String str) {
        if (i != i2 || FreqUtil.m48155c(this.f11107m) == null) {
            return;
        }
        String freqItem = FreqUtil.m48155c(this.f11107m).toString();
        FreqUtil.m48154d(str + freqItem);
    }

    /* renamed from: a */
    private int m48734a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean) {
        if (forwardBean == null || buyerBean == null) {
            return 0;
        }
        String buyerSpaceUuId = buyerBean.getBuyerSpaceUuId();
        if (this.f11078G.f10962e.m48969a(buyerSpaceUuId) == 3) {
            this.f11078G.f10963f.m48968a(buyerSpaceUuId, 1);
            if (this.f11078G.f10963f.m48969a(buyerSpaceUuId) == 1) {
                if (this.f11100f <= (forwardBean.getSleepTime() + System.currentTimeMillis()) - this.f11079H) {
                    this.f11078G.f10963f.m48968a(buyerSpaceUuId, 4);
                    return 4;
                } else if (this.f11078G.f10967j.m48971a() == 2) {
                    this.f11078G.f10963f.m48968a(buyerSpaceUuId, 6);
                    return 6;
                } else {
                    C3116af.m48496a("BeiZis", "mUsableTime = " + this.f11100f + " forwardBean.getSleepTime() + System.currentTimeMillis() - mEnterRequestMethodTime = " + ((forwardBean.getSleepTime() + System.currentTimeMillis()) - this.f11079H) + ",forwardBean.getSleepTime() = " + forwardBean.getSleepTime());
                    if (this.f11078G.m48857c()) {
                        this.f11078G.f10963f.m48968a(buyerSpaceUuId, -1);
                        return -1;
                    }
                    this.f11078G.f10963f.m48968a(buyerSpaceUuId, 2);
                    return 2;
                }
            }
        }
        this.f11078G.f10963f.m48968a(buyerSpaceUuId, -2);
        return -2;
    }

    /* renamed from: a */
    public void m48737a(AdSpacesBean.ComponentBean componentBean, String str, boolean z, int i) {
        if (componentBean != null && (TextUtils.isEmpty(str) || (!"C2S".equalsIgnoreCase(str) && !"S2S".equalsIgnoreCase(str)))) {
            m48735a(componentBean, true);
            return;
        }
        AdWorker adWorker = this.f11103i;
        if (adWorker != null && m48701d(adWorker)) {
            m48716b(1);
        } else {
            m48754a(i);
        }
    }

    /* renamed from: a */
    public synchronized void m48749a(AdShowObserver adShowObserver) {
        if (adShowObserver != null) {
            this.f11105k.remove(adShowObserver);
        }
    }

    /* renamed from: a */
    public void m48726a(String str, View view) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.f11106l) {
            return;
        }
        m48730a(this.f11103i, 1);
        this.f11106l = true;
        this.f11117x = 1;
        m48717b();
        m48707c();
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof AdListener) {
                ((AdListener) baseAdListener).onAdLoaded();
            } else if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoAdLoaded();
            } else if (baseAdListener instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener).onAdLoaded();
            } else if (baseAdListener instanceof BannerAdListener) {
                ((BannerAdListener) baseAdListener).onAdLoaded();
            } else if (baseAdListener instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener).onAdLoaded();
            } else if (baseAdListener instanceof NativeAdListener) {
                if (view != null) {
                    AdWorker adWorker = this.f11103i;
                    if (adWorker != null && adWorker.m47959aA() == 1) {
                        ((NativeAdListener) this.f11102h).onAdLoaded(null);
                    } else {
                        AdWorker adWorker2 = this.f11103i;
                        if (adWorker2 != null && adWorker2.mo46446o() != null) {
                            ((NativeAdListener) this.f11102h).onAdLoaded(this.f11103i.mo46446o());
                        } else {
                            m48691g();
                        }
                    }
                } else {
                    m48691g();
                }
            } else if (baseAdListener instanceof DrawAdListener) {
                if (view != null) {
                    ((DrawAdListener) baseAdListener).onAdLoaded(view);
                } else {
                    m48691g();
                }
            } else if (baseAdListener instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) baseAdListener).onAdLoaded(this.f11103i.mo47589aD());
            }
        }
        m48757M();
        f11071r = true;
    }

    /* renamed from: a */
    public void m48727a(String str, int i) {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof AdListener) {
                ((AdListener) baseAdListener).onAdFailedToLoad(i);
            } else if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoAdFailedToLoad(i);
            } else if (baseAdListener instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeAdListener) {
                ((NativeAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof BannerAdListener) {
                ((BannerAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof DrawAdListener) {
                ((DrawAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) baseAdListener).onAdFailed(i);
            }
        }
        m48707c();
        this.f11117x = 3;
        m48670q();
        f11071r = true;
    }

    /* renamed from: a */
    public void m48754a(int i) {
        if (i != 10140) {
            if (this.f11117x >= 1) {
                return;
            }
            if (i != 9999 && (m48760J() || m48759K())) {
                return;
            }
        }
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener != null) {
            if (baseAdListener instanceof AdListener) {
                ((AdListener) baseAdListener).onAdFailedToLoad(i);
            } else if (baseAdListener instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) baseAdListener).onRewardedVideoAdFailedToLoad(i);
            } else if (baseAdListener instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeAdListener) {
                ((NativeAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof BannerAdListener) {
                ((BannerAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof DrawAdListener) {
                ((DrawAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof InterstitialAdListener) {
                ((InterstitialAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeNotificationAdListener) {
                ((NativeNotificationAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeFloatAdListener) {
                ((NativeFloatAdListener) baseAdListener).onAdFailed(i);
            } else if (baseAdListener instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) baseAdListener).onAdFailed(i);
            }
        }
        m48707c();
        this.f11117x = 3;
        m48670q();
        f11071r = true;
    }

    /* renamed from: a */
    public void m48752a(long j) {
        BaseAdListener baseAdListener = this.f11102h;
        if (baseAdListener == null || !(baseAdListener instanceof AdListener)) {
            return;
        }
        ((AdListener) baseAdListener).onAdTick(j);
    }

    @NonNull
    /* renamed from: a */
    private CompeteStatus m48725a(String str, AdWorker adWorker) {
        C3116af.m48496a("BeiZis", "comparePrices handleCompeteToDetermine worker:" + adWorker.mo46059g());
        this.f11103i = adWorker;
        this.f11078G.f10965h.m48968a(str, 2);
        m48707c();
        return CompeteStatus.TO_DETERMINE;
    }

    @NonNull
    /* renamed from: a */
    private CompeteStatus m48724a(String str, AdWorker adWorker, String str2) {
        if (!this.f11077F) {
            m48729a(adWorker, str2);
            m48717b();
            m48707c();
            return m48677k(str);
        }
        m48711b(adWorker, 1);
        return m48675l(str);
    }

    /* renamed from: a */
    private void m48729a(AdWorker adWorker, String str) {
        this.f11077F = true;
        C3116af.m48496a("BeiZis", "---handleCompeteSuccess---" + str + "---" + m48697e(adWorker));
        this.f11103i = adWorker;
        m48730a(adWorker, 1);
    }

    /* renamed from: a */
    public void m48750a(BaseAdListener baseAdListener) {
        this.f11102h = baseAdListener;
    }

    /* renamed from: a */
    public void m48718a(boolean z) {
        this.f11112s = z;
    }
}
