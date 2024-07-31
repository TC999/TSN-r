package com.beizi.fusion.work.p081f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.f.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseNativeUnifiedWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    protected Context f11955n;

    /* renamed from: o */
    protected long f11956o;

    /* renamed from: p */
    protected float f11957p;

    /* renamed from: q */
    protected float f11958q;

    /* renamed from: r */
    protected NativeUnifiedAdResponse f11959r;

    /* renamed from: s */
    protected FrameLayout f11960s;

    /* renamed from: t */
    protected boolean f11961t = false;

    /* renamed from: u */
    protected boolean f11962u = false;

    public BaseNativeUnifiedWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        this.f11955n = context;
        this.f11956o = j;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11804k = i;
        this.f11799f = forwardBean;
        this.f11957p = C3138av.m48286l(context);
        this.f11958q = C3138av.m48285m(context);
        m47917r();
    }

    /* renamed from: aU */
    private void m47587aU() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeUnifiedWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m47586aV();
            this.f11797d.m48726a(mo46059g(), (View) null);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aV */
    private void m47586aV() {
        this.f11959r = new NativeUnifiedAdResponse() { // from class: com.beizi.fusion.work.f.a.1
            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getActionText() {
                return BaseNativeUnifiedWorker.this.mo47511aO();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getDescription() {
                return BaseNativeUnifiedWorker.this.mo47516aJ();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getECPM() {
                String mo46054j = BaseNativeUnifiedWorker.this.mo46054j();
                if (mo46054j != null) {
                    try {
                        return Integer.parseInt(mo46054j);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -1;
                    }
                }
                return -1;
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getIconUrl() {
                return BaseNativeUnifiedWorker.this.mo47515aK();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getImageUrl() {
                return BaseNativeUnifiedWorker.this.mo47514aL();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public List<String> getImgList() {
                return BaseNativeUnifiedWorker.this.mo47513aM();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getMaterialType() {
                return BaseNativeUnifiedWorker.this.mo47512aN();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getTitle() {
                return BaseNativeUnifiedWorker.this.mo47517aI();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public View getVideoView() {
                return BaseNativeUnifiedWorker.this.mo47508aR();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public ViewGroup getViewContainer() {
                return BaseNativeUnifiedWorker.this.mo47509aQ();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public boolean isVideo() {
                return BaseNativeUnifiedWorker.this.mo47510aP();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerViewForInteraction(List<View> list) {
                BaseNativeUnifiedWorker.this.mo47520a(list);
            }
        };
    }

    /* renamed from: a */
    public void mo47520a(List<View> list) {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: aD */
    public NativeUnifiedAdResponse mo47589aD() {
        return this.f11959r;
    }

    /* renamed from: aG */
    public void mo47519aG() {
    }

    /* renamed from: aH */
    public void mo47518aH() {
    }

    /* renamed from: aI */
    public String mo47517aI() {
        return null;
    }

    /* renamed from: aJ */
    public String mo47516aJ() {
        return null;
    }

    /* renamed from: aK */
    public String mo47515aK() {
        return null;
    }

    /* renamed from: aL */
    public String mo47514aL() {
        return null;
    }

    /* renamed from: aM */
    public List<String> mo47513aM() {
        return null;
    }

    /* renamed from: aN */
    public int mo47512aN() {
        return 0;
    }

    /* renamed from: aO */
    public String mo47511aO() {
        return null;
    }

    /* renamed from: aP */
    public boolean mo47510aP() {
        return false;
    }

    /* renamed from: aQ */
    public ViewGroup mo47509aQ() {
        return null;
    }

    /* renamed from: aR */
    public View mo47508aR() {
        return null;
    }

    /* renamed from: aS */
    public void mo47507aS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aT */
    public void m47588aT() {
        try {
            if (m47970Y()) {
                m47587aU();
            } else {
                m47980O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ab */
    public void mo47585ab() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        this.f11803j = AdStatus.ADSHOW;
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48668s() != 2) {
            this.f11797d.m48710b(mo46059g());
        }
        if (this.f11961t) {
            return;
        }
        this.f11961t = true;
        mo46072az();
        m47992C();
        m47991D();
        m47942ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m47584b() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onADClicked()");
        BaseManager baseManager = this.f11797d;
        if (baseManager != null && baseManager.m48668s() != 2) {
            this.f11797d.m48700d(mo46059g());
        }
        if (this.f11962u) {
            return;
        }
        this.f11962u = true;
        m47990E();
        m47941ai();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                mo47519aG();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    public void mo46050l() {
        m47912w();
        m47943ag();
        mo47518aH();
    }
}
