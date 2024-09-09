package com.beizi.fusion.work;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.b.b;
import com.beizi.fusion.b.d;
import com.beizi.fusion.d.c;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.EventItem;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a extends Observable implements c {

    /* renamed from: a  reason: collision with root package name */
    protected d f15364a;

    /* renamed from: b  reason: collision with root package name */
    protected b f15365b;

    /* renamed from: c  reason: collision with root package name */
    protected String f15366c;

    /* renamed from: d  reason: collision with root package name */
    protected e f15367d;

    /* renamed from: e  reason: collision with root package name */
    protected AdSpacesBean.BuyerBean f15368e;

    /* renamed from: f  reason: collision with root package name */
    protected AdSpacesBean.ForwardBean f15369f;

    /* renamed from: h  reason: collision with root package name */
    protected String f15371h;

    /* renamed from: i  reason: collision with root package name */
    protected String f15372i;

    /* renamed from: g  reason: collision with root package name */
    protected h f15370g = null;

    /* renamed from: j  reason: collision with root package name */
    protected com.beizi.fusion.f.a f15373j = com.beizi.fusion.f.a.ADDEFAULT;

    /* renamed from: n  reason: collision with root package name */
    private int f15377n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f15378o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f15379p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f15380q = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15381r = false;

    /* renamed from: s  reason: collision with root package name */
    private long f15382s = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f15383t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f15384u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15385v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f15386w = false;

    /* renamed from: x  reason: collision with root package name */
    private TimerTask f15387x = null;

    /* renamed from: y  reason: collision with root package name */
    private Timer f15388y = null;

    /* renamed from: z  reason: collision with root package name */
    private long f15389z = 0;
    private boolean A = false;
    private String B = "WATERFALL";
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private String F = null;

    /* renamed from: k  reason: collision with root package name */
    protected int f15374k = 0;

    /* renamed from: l  reason: collision with root package name */
    protected long f15375l = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: m  reason: collision with root package name */
    protected Handler f15376m = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.work.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 == 1) {
                e eVar = a.this.f15367d;
                if (eVar == null || eVar.t() >= 1 || a.this.f15367d.s() == 2) {
                    return;
                }
                a.this.l();
            } else if (i4 != 2) {
                if (i4 == 3 && message.obj != null) {
                    a.this.a(message);
                    a.this.aj();
                    if (a.this.c()) {
                        return;
                    }
                    a.this.c(message.arg1);
                }
            } else {
                af.b("BeiZis", "before handleAdClose");
                a.this.G();
                a.this.ac();
            }
        }
    };
    private boolean G = false;
    private boolean H = false;

    private boolean aG() {
        d dVar = this.f15364a;
        return (dVar == null || dVar.c()) ? false : true;
    }

    private void aH() {
        e eVar;
        if (this.f15385v || (eVar = this.f15367d) == null || eVar.s() == 2 || this.f15373j == com.beizi.fusion.f.a.ADFAIL) {
            return;
        }
        if (!aM()) {
            this.f15367d.a((c) this);
            this.f15367d.b(g());
            U();
        } else {
            W();
        }
        this.f15385v = true;
    }

    private void aI() {
        Timer timer;
        StringBuilder sb = new StringBuilder();
        sb.append("mAdLifeManager != null ? ");
        sb.append(this.f15367d != null);
        af.c("BeiZis", sb.toString());
        if (this.f15367d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enter cancelExposureTaskIfNeed (System.currentTimeMillis() - mStartLoadTime) = ");
            sb2.append(System.currentTimeMillis() - this.f15389z);
            sb2.append(",mAdLifeManager.getValidExposureTime() = ");
            sb2.append(this.f15367d.w());
            sb2.append(",mExposureTimerTask != null ? ");
            sb2.append(this.f15387x != null);
            sb2.append(",mExposureTimer != null ? ");
            sb2.append(this.f15388y != null);
            af.c("BeiZis", sb2.toString());
        }
        if (this.f15367d == null || System.currentTimeMillis() - this.f15389z >= this.f15367d.w() || this.f15387x == null || (timer = this.f15388y) == null) {
            return;
        }
        timer.cancel();
        V();
    }

    private void aJ() {
        this.f15387x = new TimerTask() { // from class: com.beizi.fusion.work.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a.this.ae();
            }
        };
        Timer timer = new Timer();
        this.f15388y = timer;
        e eVar = this.f15367d;
        if (eVar != null) {
            timer.schedule(this.f15387x, eVar.w());
            this.A = true;
        }
    }

    private boolean aK() {
        int w3;
        e eVar = this.f15367d;
        return eVar != null && (w3 = eVar.w()) >= 0 && w3 <= 3000;
    }

    private boolean aL() {
        e eVar = this.f15367d;
        if (eVar != null) {
            Integer[] x3 = eVar.x();
            return x3.length == 2 && x3[0].intValue() >= 0 && x3[1].intValue() > x3[0].intValue() && x3[1].intValue() - x3[0].intValue() <= 30;
        }
        return false;
    }

    private boolean aM() {
        e eVar;
        af.c("BeiZis", "isRandomNoExposureRangeValid = " + aL());
        if (aL() && (eVar = this.f15367d) != null) {
            Integer[] x3 = eVar.x();
            int random = (int) ((Math.random() * 100.0d) + 1.0d);
            af.c("BeiZis", "random = " + random + ",randomNoExposureRange[0] = " + x3[0] + ",randomNoExposureRange[1] = " + x3[1]);
            return random >= x3[0].intValue() && random <= x3[1].intValue();
        }
        return false;
    }

    protected void A() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        if (aG()) {
            ak();
            if (z()) {
                L();
                a(3);
            }
            af.c("BeiZis", "channel " + this.f15366c + " reportAdLoadFail mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            if (b()) {
                return;
            }
            this.f15364a.f14498g.a(this.f15366c, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdShow mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdClick mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdClickClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 22);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdRewarded mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 12);
        }
    }

    public void K() {
        if (this.f15364a == null || this.E) {
            return;
        }
        af.c("BeiZis", "channel " + this.f15366c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f15364a.f14502k.a(this.f15366c));
        this.E = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f15364a.f14502k.a(this.f15366c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.f14499h.a(this.f15366c, 3);
            af.a("BeiZis", "channel == ---reportComparisonSuccess---" + g());
        }
    }

    protected void N() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.f14499h.a(this.f15366c, 1);
            this.f15364a.f14499h.a(this.f15366c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
        N();
    }

    protected void P() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.f14499h.a(this.f15366c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportChannelClickEnhance GrayPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f15364a.f14500i.a(this.f15366c));
            this.f15364a.f14500i.a(this.f15366c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportChannelClickEnhance RandomPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f15364a.f14500i.a(this.f15366c));
            this.f15364a.f14500i.a(this.f15366c, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportChannelClickEnhance LayerPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f15364a.f14500i.a(this.f15366c));
            this.f15364a.f14500i.a(this.f15366c, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportChannelClickEnhance ReduceArea mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f15364a.f14500i.a(this.f15366c));
            this.f15364a.f14500i.a(this.f15366c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportValidTimeExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 13);
        }
    }

    protected void V() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportNotEnoughExposureTime mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 14);
        }
    }

    protected void W() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportRandomNoExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 15);
        }
    }

    protected boolean X() {
        if (this.f15367d != null) {
            af.c("BeiZis", "adStatus = " + this.f15367d.t());
        }
        e eVar = this.f15367d;
        return eVar != null && eVar.t() < 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Y() {
        e eVar = this.f15367d;
        return eVar != null && eVar.h() && (ar() || ap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        if (this.f15370g == null && this.f15367d != null && aG()) {
            this.f15370g = this.f15367d.a(this);
        }
    }

    public void a(Activity activity) {
    }

    public void a(Context context) {
    }

    public void a(String str) {
        this.B = str;
    }

    public int aA() {
        return this.f15374k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aB() {
        if (this.f15364a == null || !AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(h())) {
            return;
        }
        af.c("BeiZis", "channel " + this.f15366c + " reportC2SPrice mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
        this.f15364a.f14498g.a(this.f15366c, 20);
    }

    public String aC() {
        return this.F;
    }

    public NativeUnifiedAdResponse aD() {
        return null;
    }

    public h aE() {
        return this.f15370g;
    }

    public void aF() {
        this.f15375l = System.currentTimeMillis() + 1000;
    }

    protected boolean aa() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab() {
        at();
        this.f15386w = true;
        af.c("BeiZis", "enter handleAdShow !isStartExposureTask ? " + (true ^ this.A) + ",isReportValidExposureTimeEvent = " + this.H);
        if (!this.A || this.H) {
            aH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
        if ((this.f15383t || this.f15367d == null) && !b(g())) {
            return;
        }
        this.f15367d.c(g());
        this.f15383t = true;
        if (this.A) {
            aI();
        }
    }

    public void ad() {
        e eVar;
        StringBuilder sb = new StringBuilder();
        sb.append("enter handleAdLoaded and !isHandleAdLoad ? ");
        sb.append(!this.f15384u);
        sb.append(",mAdLifeManager != null ? ");
        sb.append(this.f15367d != null);
        af.c("BeiZis", sb.toString());
        if (this.f15384u || (eVar = this.f15367d) == null) {
            return;
        }
        eVar.a(g(), (View) null);
        this.f15384u = true;
        af.c("BeiZis", "isExposureTimeValid = " + aK());
        if (aK()) {
            aJ();
            this.f15389z = System.currentTimeMillis();
        }
    }

    protected void ae() {
        this.f15376m.post(new Runnable() { // from class: com.beizi.fusion.work.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.af();
            }
        });
    }

    protected void af() {
        if (this.f15386w) {
            aH();
        } else {
            this.H = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag() {
        if (this.f15367d == null || !as()) {
            return;
        }
        e eVar = this.f15367d;
        eVar.a("255.200", eVar.i(), new EventItem("255.200", String.valueOf(System.currentTimeMillis()), g(), this.f15372i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah() {
        if (this.f15367d == null || !as()) {
            return;
        }
        e eVar = this.f15367d;
        eVar.a("280.300", eVar.i(), new EventItem("280.300", String.valueOf(System.currentTimeMillis()), g(), this.f15372i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai() {
        if (this.f15367d == null || !as()) {
            return;
        }
        e eVar = this.f15367d;
        eVar.a("290.300", eVar.i(), new EventItem("290.300", String.valueOf(System.currentTimeMillis()), g(), this.f15372i));
    }

    protected void aj() {
        if (this.f15367d == null || !as()) {
            return;
        }
        e eVar = this.f15367d;
        eVar.a("280.500", eVar.i(), new EventItem("280.500", String.valueOf(System.currentTimeMillis()), g(), this.f15372i));
    }

    protected void ak() {
        if (am()) {
            b(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        if (p() != 3) {
            af.a("BeiZisBid", "mWorker = " + this + ",set ad suc");
            b(2);
        }
    }

    public boolean am() {
        return an();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean an() {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(h());
    }

    protected boolean ao() {
        return AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(h());
    }

    protected boolean ap() {
        return ao() || an();
    }

    public boolean aq() {
        return "BPDI".equalsIgnoreCase(h());
    }

    public boolean ar() {
        return as() || aq();
    }

    protected boolean as() {
        return "WATERFALL".equalsIgnoreCase(h());
    }

    protected void at() {
        double avgPrice = k() != null ? k().getAvgPrice() : 0.0d;
        if (!an() && !aq()) {
            if (as()) {
                af.a("BeiZis", "waterfall worker " + g() + " show ad,price = " + avgPrice);
                return;
            }
            return;
        }
        af.a("BeiZis", "bid worker " + g() + " show ad,price = " + avgPrice);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.a().a(this.f15366c, this.f15365b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean av() {
        af.c("BeiZis", "enter checkCsjInitStatusInValid");
        boolean z3 = TextUtils.isEmpty(this.f15371h) || TextUtils.isEmpty(this.f15372i) || u.a() == null;
        if (z3) {
            ax();
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aw() {
        B();
        e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }

    public void ax() {
        af.c("BeiZis", "enter handleInitError");
        a("sdk custom error ".concat(g()).concat(" ").concat("init error"), 10140);
    }

    public void ay() {
    }

    public void az() {
    }

    public void b(int i4) {
        this.f15379p = i4;
    }

    public boolean c() {
        return this.D;
    }

    public abstract void d();

    public void d(int i4) {
    }

    public void e() {
    }

    public abstract void f();

    public abstract String g();

    public String h() {
        return this.B;
    }

    public abstract com.beizi.fusion.f.a i();

    public String j() {
        return null;
    }

    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    protected abstract void l();

    public void m() {
        Handler handler = this.f15376m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void n() {
    }

    public View o() {
        return null;
    }

    public int p() {
        return this.f15379p;
    }

    public void q() {
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        e eVar = this.f15367d;
        if (eVar != null) {
            this.f15364a = eVar.d();
        }
        AdSpacesBean.BuyerBean buyerBean = this.f15368e;
        if (buyerBean != null) {
            this.f15366c = buyerBean.getBuyerSpaceUuId();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.a().a(this.f15368e, this.f15369f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        d dVar = this.f15364a;
        if (dVar != null) {
            dVar.f14498g.a(this.f15366c, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportInitBegin mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportInitEnd mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (this.f15364a != null) {
            af.c("BeiZis", "channel " + this.f15366c + " reportAdRequest mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            this.f15364a.f14498g.a(this.f15366c, 3);
        }
    }

    public boolean x() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        if (aG()) {
            if (an() && !"MTG".equalsIgnoreCase(g())) {
                aB();
            }
            if (z()) {
                a(2);
                K();
            }
            A();
            af.c("BeiZis", "channel " + this.f15366c + " reportAdLoaded mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f15364a.f14498g.a(this.f15366c));
            if (b()) {
                return;
            }
            this.f15364a.f14498g.a(this.f15366c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z() {
        return am() && !x();
    }

    private boolean b() {
        return am() && x();
    }

    public void a(AdSpacesBean.ForwardBean forwardBean) {
        this.f15369f = forwardBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4) {
        AdSpacesBean.BuyerBean buyerBean;
        if (this.f15373j == com.beizi.fusion.f.a.ADLOAD && (buyerBean = this.f15368e) != null && !TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId()) && !TextUtils.isEmpty(this.f15367d.A()) && this.f15368e.getBuyerSpaceUuId().equals(this.f15367d.A())) {
            this.f15373j = com.beizi.fusion.f.a.ADFAIL;
            this.f15367d.a(this.f15368e.getBuyerSpaceUuId(), i4);
            return;
        }
        this.f15373j = com.beizi.fusion.f.a.ADFAIL;
        if (this.f15367d == null || this.f15369f == null) {
            return;
        }
        if (X()) {
            this.f15367d.a(this.f15369f.getComponent(), h(), true, i4);
            return;
        }
        af.b("BeiZis", "fail distribute direct fail");
        this.f15367d.a(i4);
    }

    private boolean b(String str) {
        return "FinalLink".equalsIgnoreCase(str);
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        this.f15368e = buyerBean;
    }

    public void a(boolean z3) {
        this.f15381r = z3;
    }

    public void a(long j4) {
        this.f15382s = j4;
    }

    public void a(int i4) {
        this.f15377n = i4;
    }

    @Override // com.beizi.fusion.d.c
    public void a() {
        if (i() != com.beizi.fusion.f.a.ADSHOW) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Message message) {
        b bVar;
        if (this.f15364a == null || (bVar = this.f15365b) == null) {
            return;
        }
        bVar.i(String.valueOf(message.obj));
        this.f15365b.m(String.valueOf(message.arg1));
        au();
        B();
        this.f15365b.i(null);
        this.f15365b.m(null);
        au();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i4) {
        if (aG()) {
            Message obtainMessage = this.f15376m.obtainMessage(3, str);
            obtainMessage.arg1 = i4;
            this.f15376m.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(double d4) {
        if (d4 > 0.0d) {
            if ("BEIZI".equalsIgnoreCase(g()) || "MTG".equalsIgnoreCase(g())) {
                this.f15368e.setAvgPrice(d4);
                b bVar = this.f15365b;
                if (bVar != null) {
                    bVar.M(String.valueOf(d4));
                }
            }
            if (ap()) {
                this.f15368e.setBidPrice(d4);
                b bVar2 = this.f15365b;
                if (bVar2 != null) {
                    bVar2.N(String.valueOf(d4));
                }
            }
            au();
        }
    }
}
