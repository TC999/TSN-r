package com.beizi.fusion.work;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.github.mikephil.charting.utils.Utils;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.beizi.fusion.work.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AdWorker extends Observable implements AdShowObserver {

    /* renamed from: a */
    protected ObserverAdStatus f11794a;

    /* renamed from: b */
    protected EventBean f11795b;

    /* renamed from: c */
    protected String f11796c;

    /* renamed from: d */
    protected BaseManager f11797d;

    /* renamed from: e */
    protected AdSpacesBean.BuyerBean f11798e;

    /* renamed from: f */
    protected AdSpacesBean.ForwardBean f11799f;

    /* renamed from: h */
    protected String f11801h;

    /* renamed from: i */
    protected String f11802i;

    /* renamed from: g */
    protected CompeteStatus f11800g = null;

    /* renamed from: j */
    protected AdStatus f11803j = AdStatus.ADDEFAULT;

    /* renamed from: n */
    private int f11807n = 0;

    /* renamed from: o */
    private int f11808o = 0;

    /* renamed from: p */
    private int f11809p = 0;

    /* renamed from: q */
    private int f11810q = 0;

    /* renamed from: r */
    private boolean f11811r = false;

    /* renamed from: s */
    private long f11812s = 0;

    /* renamed from: t */
    private boolean f11813t = false;

    /* renamed from: u */
    private boolean f11814u = false;

    /* renamed from: v */
    private boolean f11815v = false;

    /* renamed from: w */
    private boolean f11816w = false;

    /* renamed from: x */
    private TimerTask f11817x = null;

    /* renamed from: y */
    private Timer f11818y = null;

    /* renamed from: z */
    private long f11819z = 0;

    /* renamed from: A */
    private boolean f11786A = false;

    /* renamed from: B */
    private String f11787B = "WATERFALL";

    /* renamed from: C */
    private int f11788C = 0;

    /* renamed from: D */
    private boolean f11789D = false;

    /* renamed from: E */
    private boolean f11790E = false;

    /* renamed from: F */
    private String f11791F = null;

    /* renamed from: k */
    protected int f11804k = 0;

    /* renamed from: l */
    protected long f11805l = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: m */
    protected Handler f11806m = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.work.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                BaseManager baseManager = AdWorker.this.f11797d;
                if (baseManager == null || baseManager.m48667t() >= 1 || AdWorker.this.f11797d.m48668s() == 2) {
                    return;
                }
                AdWorker.this.mo46050l();
            } else if (i != 2) {
                if (i == 3 && message.obj != null) {
                    AdWorker.this.mo46196a(message);
                    AdWorker.this.m47940aj();
                    if (AdWorker.this.m47922c()) {
                        return;
                    }
                    AdWorker.this.m47921c(message.arg1);
                }
            } else {
                C3116af.m48495b("BeiZis", "before handleAdClose");
                AdWorker.this.m47988G();
                AdWorker.this.m47947ac();
            }
        }
    };

    /* renamed from: G */
    private boolean f11792G = false;

    /* renamed from: H */
    private boolean f11793H = false;

    /* renamed from: aG */
    private boolean m47954aG() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        return (observerAdStatus == null || observerAdStatus.m48857c()) ? false : true;
    }

    /* renamed from: aH */
    private void m47953aH() {
        BaseManager baseManager;
        if (this.f11815v || (baseManager = this.f11797d) == null || baseManager.m48668s() == 2 || this.f11803j == AdStatus.ADFAIL) {
            return;
        }
        if (!m47948aM()) {
            this.f11797d.m48749a((AdShowObserver) this);
            this.f11797d.m48710b(mo46059g());
            m47974U();
        } else {
            m47972W();
        }
        this.f11815v = true;
    }

    /* renamed from: aI */
    private void m47952aI() {
        Timer timer;
        StringBuilder sb = new StringBuilder();
        sb.append("mAdLifeManager != null ? ");
        sb.append(this.f11797d != null);
        C3116af.m48494c("BeiZis", sb.toString());
        if (this.f11797d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enter cancelExposureTaskIfNeed (System.currentTimeMillis() - mStartLoadTime) = ");
            sb2.append(System.currentTimeMillis() - this.f11819z);
            sb2.append(",mAdLifeManager.getValidExposureTime() = ");
            sb2.append(this.f11797d.m48664w());
            sb2.append(",mExposureTimerTask != null ? ");
            sb2.append(this.f11817x != null);
            sb2.append(",mExposureTimer != null ? ");
            sb2.append(this.f11818y != null);
            C3116af.m48494c("BeiZis", sb2.toString());
        }
        if (this.f11797d == null || System.currentTimeMillis() - this.f11819z >= this.f11797d.m48664w() || this.f11817x == null || (timer = this.f11818y) == null) {
            return;
        }
        timer.cancel();
        m47973V();
    }

    /* renamed from: aJ */
    private void m47951aJ() {
        this.f11817x = new TimerTask() { // from class: com.beizi.fusion.work.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AdWorker.this.m47945ae();
            }
        };
        Timer timer = new Timer();
        this.f11818y = timer;
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            timer.schedule(this.f11817x, baseManager.m48664w());
            this.f11786A = true;
        }
    }

    /* renamed from: aK */
    private boolean m47950aK() {
        int m48664w;
        BaseManager baseManager = this.f11797d;
        return baseManager != null && (m48664w = baseManager.m48664w()) >= 0 && m48664w <= 3000;
    }

    /* renamed from: aL */
    private boolean m47949aL() {
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            Integer[] m48663x = baseManager.m48663x();
            return m48663x.length == 2 && m48663x[0].intValue() >= 0 && m48663x[1].intValue() > m48663x[0].intValue() && m48663x[1].intValue() - m48663x[0].intValue() <= 30;
        }
        return false;
    }

    /* renamed from: aM */
    private boolean m47948aM() {
        BaseManager baseManager;
        C3116af.m48494c("BeiZis", "isRandomNoExposureRangeValid = " + m47949aL());
        if (m47949aL() && (baseManager = this.f11797d) != null) {
            Integer[] m48663x = baseManager.m48663x();
            int random = (int) ((Math.random() * 100.0d) + 1.0d);
            C3116af.m48494c("BeiZis", "random = " + random + ",randomNoExposureRange[0] = " + m48663x[0] + ",randomNoExposureRange[1] = " + m48663x[1]);
            return random >= m48663x[0].intValue() && random <= m48663x[1].intValue();
        }
        return false;
    }

    /* renamed from: A */
    protected void mo46197A() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public void m47993B() {
        if (m47954aG()) {
            m47939ak();
            if (m47909z()) {
                m47983L();
                m47966a(3);
            }
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdLoadFail mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            if (m47925b()) {
                return;
            }
            this.f11794a.f10964g.m48968a(this.f11796c, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C */
    public void m47992C() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdShow mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D */
    public void m47991D() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E */
    public void m47990E() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdClick mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public void m47989F() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G */
    public void m47988G() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H */
    public void m47987H() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdClickClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public void m47986I() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 22);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J */
    public void m47985J() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdRewarded mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 12);
        }
    }

    /* renamed from: K */
    public void m47984K() {
        if (this.f11794a == null || this.f11790E) {
            return;
        }
        C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f11794a.f10968k.m48969a(this.f11796c));
        this.f11790E = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L */
    public void m47983L() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f11794a.f10968k.m48969a(this.f11796c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: M */
    public void m47982M() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(this.f11796c, 3);
            C3116af.m48496a("BeiZis", "channel == ---reportComparisonSuccess---" + mo46059g());
        }
    }

    /* renamed from: N */
    protected void m47981N() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(this.f11796c, 1);
            this.f11794a.f10965h.m48968a(this.f11796c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O */
    public void m47980O() {
        m47981N();
    }

    /* renamed from: P */
    protected void m47979P() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.f10965h.m48968a(this.f11796c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Q */
    public void m47978Q() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportChannelClickEnhance GrayPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f11794a.f10966i.m48969a(this.f11796c));
            this.f11794a.f10966i.m48968a(this.f11796c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R */
    public void m47977R() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportChannelClickEnhance RandomPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f11794a.f10966i.m48969a(this.f11796c));
            this.f11794a.f10966i.m48968a(this.f11796c, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: S */
    public void m47976S() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportChannelClickEnhance LayerPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f11794a.f10966i.m48969a(this.f11796c));
            this.f11794a.f10966i.m48968a(this.f11796c, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T */
    public void m47975T() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportChannelClickEnhance ReduceArea mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f11794a.f10966i.m48969a(this.f11796c));
            this.f11794a.f10966i.m48968a(this.f11796c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: U */
    public void m47974U() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportValidTimeExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 13);
        }
    }

    /* renamed from: V */
    protected void m47973V() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportNotEnoughExposureTime mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 14);
        }
    }

    /* renamed from: W */
    protected void m47972W() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportRandomNoExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 15);
        }
    }

    /* renamed from: X */
    protected boolean m47971X() {
        if (this.f11797d != null) {
            C3116af.m48494c("BeiZis", "adStatus = " + this.f11797d.m48667t());
        }
        BaseManager baseManager = this.f11797d;
        return baseManager != null && baseManager.m48667t() < 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y */
    public boolean m47970Y() {
        BaseManager baseManager = this.f11797d;
        return baseManager != null && baseManager.m48688h() && (m47932ar() || m47934ap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z */
    public void m47969Z() {
        if (this.f11800g == null && this.f11797d != null && m47954aG()) {
            this.f11800g = this.f11797d.m48731a(this);
        }
    }

    /* renamed from: a */
    public void mo47063a(Activity activity) {
    }

    /* renamed from: a */
    public void m47962a(String str) {
        this.f11787B = str;
    }

    /* renamed from: aA */
    public int m47959aA() {
        return this.f11804k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aB */
    public void m47958aB() {
        if (this.f11794a == null || !"C2S".equalsIgnoreCase(m47920h())) {
            return;
        }
        C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportC2SPrice mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
        this.f11794a.f10964g.m48968a(this.f11796c, 20);
    }

    /* renamed from: aC */
    public String m47957aC() {
        return this.f11791F;
    }

    /* renamed from: aD */
    public NativeUnifiedAdResponse mo47589aD() {
        return null;
    }

    /* renamed from: aE */
    public CompeteStatus m47956aE() {
        return this.f11800g;
    }

    /* renamed from: aF */
    public void m47955aF() {
        this.f11805l = System.currentTimeMillis() + 1000;
    }

    /* renamed from: aa */
    protected boolean mo46073aa() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ab */
    public void mo47585ab() {
        m47930at();
        this.f11816w = true;
        C3116af.m48494c("BeiZis", "enter handleAdShow !isStartExposureTask ? " + (true ^ this.f11786A) + ",isReportValidExposureTimeEvent = " + this.f11793H);
        if (!this.f11786A || this.f11793H) {
            m47953aH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ac */
    public void m47947ac() {
        if ((this.f11813t || this.f11797d == null) && !m47923b(mo46059g())) {
            return;
        }
        this.f11797d.m48704c(mo46059g());
        this.f11813t = true;
        if (this.f11786A) {
            m47952aI();
        }
    }

    /* renamed from: ad */
    public void m47946ad() {
        BaseManager baseManager;
        StringBuilder sb = new StringBuilder();
        sb.append("enter handleAdLoaded and !isHandleAdLoad ? ");
        sb.append(!this.f11814u);
        sb.append(",mAdLifeManager != null ? ");
        sb.append(this.f11797d != null);
        C3116af.m48494c("BeiZis", sb.toString());
        if (this.f11814u || (baseManager = this.f11797d) == null) {
            return;
        }
        baseManager.m48726a(mo46059g(), (View) null);
        this.f11814u = true;
        C3116af.m48494c("BeiZis", "isExposureTimeValid = " + m47950aK());
        if (m47950aK()) {
            m47951aJ();
            this.f11819z = System.currentTimeMillis();
        }
    }

    /* renamed from: ae */
    protected void m47945ae() {
        this.f11806m.post(new Runnable() { // from class: com.beizi.fusion.work.a.3
            @Override // java.lang.Runnable
            public void run() {
                AdWorker.this.m47944af();
            }
        });
    }

    /* renamed from: af */
    protected void m47944af() {
        if (this.f11816w) {
            m47953aH();
        } else {
            this.f11793H = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ag */
    public void m47943ag() {
        if (this.f11797d == null || !m47931as()) {
            return;
        }
        BaseManager baseManager = this.f11797d;
        baseManager.m48723a("255.200", baseManager.m48685i(), new EventItem("255.200", String.valueOf(System.currentTimeMillis()), mo46059g(), this.f11802i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ah */
    public void m47942ah() {
        if (this.f11797d == null || !m47931as()) {
            return;
        }
        BaseManager baseManager = this.f11797d;
        baseManager.m48723a("280.300", baseManager.m48685i(), new EventItem("280.300", String.valueOf(System.currentTimeMillis()), mo46059g(), this.f11802i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ai */
    public void m47941ai() {
        if (this.f11797d == null || !m47931as()) {
            return;
        }
        BaseManager baseManager = this.f11797d;
        baseManager.m48723a("290.300", baseManager.m48685i(), new EventItem("290.300", String.valueOf(System.currentTimeMillis()), mo46059g(), this.f11802i));
    }

    /* renamed from: aj */
    protected void m47940aj() {
        if (this.f11797d == null || !m47931as()) {
            return;
        }
        BaseManager baseManager = this.f11797d;
        baseManager.m48723a("280.500", baseManager.m48685i(), new EventItem("280.500", String.valueOf(System.currentTimeMillis()), mo46059g(), this.f11802i));
    }

    /* renamed from: ak */
    protected void m47939ak() {
        if (m47937am()) {
            m47924b(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: al */
    public void m47938al() {
        if (m47919p() != 3) {
            C3116af.m48496a("BeiZisBid", "mWorker = " + this + ",set ad suc");
            m47924b(2);
        }
    }

    /* renamed from: am */
    public boolean m47937am() {
        return m47936an();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: an */
    public boolean m47936an() {
        return "C2S".equalsIgnoreCase(m47920h());
    }

    /* renamed from: ao */
    protected boolean m47935ao() {
        return "S2S".equalsIgnoreCase(m47920h());
    }

    /* renamed from: ap */
    protected boolean m47934ap() {
        return m47935ao() || m47936an();
    }

    /* renamed from: aq */
    public boolean m47933aq() {
        return "BPDI".equalsIgnoreCase(m47920h());
    }

    /* renamed from: ar */
    public boolean m47932ar() {
        return m47931as() || m47933aq();
    }

    /* renamed from: as */
    protected boolean m47931as() {
        return "WATERFALL".equalsIgnoreCase(m47920h());
    }

    /* renamed from: at */
    protected void m47930at() {
        double avgPrice = mo46052k() != null ? mo46052k().getAvgPrice() : Utils.DOUBLE_EPSILON;
        if (!m47936an() && !m47933aq()) {
            if (m47931as()) {
                C3116af.m48496a("BeiZis", "waterfall worker " + mo46059g() + " show ad,price = " + avgPrice);
                return;
            }
            return;
        }
        C3116af.m48496a("BeiZis", "bid worker " + mo46059g() + " show ad,price = " + avgPrice);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: au */
    public void m47929au() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.m48860a().m48975a(this.f11796c, this.f11795b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: av */
    public boolean m47928av() {
        C3116af.m48494c("BeiZis", "enter checkCsjInitStatusInValid");
        boolean z = TextUtils.isEmpty(this.f11801h) || TextUtils.isEmpty(this.f11802i) || TTAdManagerHolder.m48594a() == null;
        if (z) {
            m47926ax();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aw */
    public void m47927aw() {
        m47993B();
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }

    /* renamed from: ax */
    public void m47926ax() {
        C3116af.m48494c("BeiZis", "enter handleInitError");
        m47961a("sdk custom error ".concat(mo46059g()).concat(" ").concat("init error"), 10140);
    }

    /* renamed from: ay */
    public void mo46297ay() {
    }

    /* renamed from: az */
    public void mo46072az() {
    }

    /* renamed from: b */
    public void m47924b(int i) {
        this.f11809p = i;
    }

    /* renamed from: c */
    public boolean m47922c() {
        return this.f11789D;
    }

    /* renamed from: d */
    public abstract void mo46065d();

    /* renamed from: d */
    public void mo46064d(int i) {
    }

    /* renamed from: e */
    public void mo46389e() {
    }

    /* renamed from: f */
    public abstract void mo46061f();

    /* renamed from: g */
    public abstract String mo46059g();

    /* renamed from: h */
    public String m47920h() {
        return this.f11787B;
    }

    /* renamed from: i */
    public abstract AdStatus mo46056i();

    /* renamed from: j */
    public String mo46054j() {
        return null;
    }

    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    /* renamed from: l */
    protected abstract void mo46050l();

    /* renamed from: m */
    public void mo46173m() {
        Handler handler = this.f11806m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: n */
    public void mo46703n() {
    }

    /* renamed from: o */
    public View mo46446o() {
        return null;
    }

    /* renamed from: p */
    public int m47919p() {
        return this.f11809p;
    }

    /* renamed from: q */
    public void m47918q() {
        m47982M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public void m47917r() {
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            this.f11794a = baseManager.m48703d();
        }
        AdSpacesBean.BuyerBean buyerBean = this.f11798e;
        if (buyerBean != null) {
            this.f11796c = buyerBean.getBuyerSpaceUuId();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public void m47916s() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.m48860a().m48978a(this.f11798e, this.f11799f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public void m47915t() {
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            observerAdStatus.f10964g.m48968a(this.f11796c, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public void m47914u() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportInitBegin mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public void m47913v() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportInitEnd mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public void m47912w() {
        if (this.f11794a != null) {
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdRequest mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            this.f11794a.f10964g.m48968a(this.f11796c, 3);
        }
    }

    /* renamed from: x */
    public boolean m47911x() {
        return this.f11792G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y */
    public void m47910y() {
        if (m47954aG()) {
            if (m47936an() && !"MTG".equalsIgnoreCase(mo46059g())) {
                m47958aB();
            }
            if (m47909z()) {
                m47966a(2);
                m47984K();
            }
            mo46197A();
            C3116af.m48494c("BeiZis", "channel " + this.f11796c + " reportAdLoaded mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f11794a.f10964g.m48969a(this.f11796c));
            if (m47925b()) {
                return;
            }
            this.f11794a.f10964g.m48968a(this.f11796c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z */
    public boolean m47909z() {
        return m47937am() && !m47911x();
    }

    /* renamed from: b */
    private boolean m47925b() {
        return m47937am() && m47911x();
    }

    /* renamed from: a */
    public void m47963a(AdSpacesBean.ForwardBean forwardBean) {
        this.f11799f = forwardBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m47921c(int i) {
        AdSpacesBean.BuyerBean buyerBean;
        if (this.f11803j == AdStatus.ADLOAD && (buyerBean = this.f11798e) != null && !TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId()) && !TextUtils.isEmpty(this.f11797d.m48769A()) && this.f11798e.getBuyerSpaceUuId().equals(this.f11797d.m48769A())) {
            this.f11803j = AdStatus.ADFAIL;
            this.f11797d.m48727a(this.f11798e.getBuyerSpaceUuId(), i);
            return;
        }
        this.f11803j = AdStatus.ADFAIL;
        if (this.f11797d == null || this.f11799f == null) {
            return;
        }
        if (m47971X()) {
            this.f11797d.m48737a(this.f11799f.getComponent(), m47920h(), true, i);
            return;
        }
        C3116af.m48495b("BeiZis", "fail distribute direct fail");
        this.f11797d.m48754a(i);
    }

    /* renamed from: b */
    private boolean m47923b(String str) {
        return "FinalLink".equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public void m47964a(AdSpacesBean.BuyerBean buyerBean) {
        this.f11798e = buyerBean;
    }

    /* renamed from: a */
    public void m47960a(boolean z) {
        this.f11811r = z;
    }

    /* renamed from: a */
    public void m47965a(long j) {
        this.f11812s = j;
    }

    /* renamed from: a */
    public void m47966a(int i) {
        this.f11807n = i;
    }

    @Override // com.beizi.fusion.p066d.AdShowObserver
    /* renamed from: a */
    public void mo47968a() {
        if (mo46056i() != AdStatus.ADSHOW) {
            m47979P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo46196a(Message message) {
        EventBean eventBean;
        if (this.f11794a == null || (eventBean = this.f11795b) == null) {
            return;
        }
        eventBean.m48905i(String.valueOf(message.obj));
        this.f11795b.m48897m(String.valueOf(message.arg1));
        m47929au();
        m47993B();
        this.f11795b.m48905i(null);
        this.f11795b.m48897m(null);
        m47929au();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m47961a(String str, int i) {
        if (m47954aG()) {
            Message obtainMessage = this.f11806m.obtainMessage(3, str);
            obtainMessage.arg1 = i;
            this.f11806m.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m47967a(double d) {
        if (d > Utils.DOUBLE_EPSILON) {
            if ("BEIZI".equalsIgnoreCase(mo46059g()) || "MTG".equalsIgnoreCase(mo46059g())) {
                this.f11798e.setAvgPrice(d);
                EventBean eventBean = this.f11795b;
                if (eventBean != null) {
                    eventBean.m48942M(String.valueOf(d));
                }
            }
            if (m47934ap()) {
                this.f11798e.setBidPrice(d);
                EventBean eventBean2 = this.f11795b;
                if (eventBean2 != null) {
                    eventBean2.m48940N(String.valueOf(d));
                }
            }
            m47929au();
        }
    }
}
