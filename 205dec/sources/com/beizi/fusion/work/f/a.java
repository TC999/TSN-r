package com.beizi.fusion.work.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseNativeUnifiedWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    protected Context f15525n;

    /* renamed from: o  reason: collision with root package name */
    protected long f15526o;

    /* renamed from: p  reason: collision with root package name */
    protected float f15527p;

    /* renamed from: q  reason: collision with root package name */
    protected float f15528q;

    /* renamed from: r  reason: collision with root package name */
    protected NativeUnifiedAdResponse f15529r;

    /* renamed from: s  reason: collision with root package name */
    protected FrameLayout f15530s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f15531t = false;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f15532u = false;

    public a(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        this.f15525n = context;
        this.f15526o = j4;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15374k = i4;
        this.f15369f = forwardBean;
        this.f15527p = aw.l(context);
        this.f15528q = aw.m(context);
        r();
    }

    private void aU() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeUnifiedWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            aV();
            this.f15367d.a(g(), (View) null);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void aV() {
        this.f15529r = new NativeUnifiedAdResponse() { // from class: com.beizi.fusion.work.f.a.1
            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getActionText() {
                return a.this.aO();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getDescription() {
                return a.this.aJ();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getECPM() {
                String j4 = a.this.j();
                if (j4 != null) {
                    try {
                        return Integer.parseInt(j4);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return -1;
                    }
                }
                return -1;
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getIconUrl() {
                return a.this.aK();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getImageUrl() {
                return a.this.aL();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public List<String> getImgList() {
                return a.this.aM();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getMaterialType() {
                return a.this.aN();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getTitle() {
                return a.this.aI();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public View getVideoView() {
                return a.this.aR();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public ViewGroup getViewContainer() {
                return a.this.aQ();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public boolean isVideo() {
                return a.this.aP();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerViewForInteraction(List<View> list) {
                a.this.a(list);
            }
        };
    }

    public void a(List<View> list) {
    }

    @Override // com.beizi.fusion.work.a
    public NativeUnifiedAdResponse aD() {
        return this.f15529r;
    }

    public void aG() {
    }

    public void aH() {
    }

    public String aI() {
        return null;
    }

    public String aJ() {
        return null;
    }

    public String aK() {
        return null;
    }

    public String aL() {
        return null;
    }

    public List<String> aM() {
        return null;
    }

    public int aN() {
        return 0;
    }

    public String aO() {
        return null;
    }

    public boolean aP() {
        return false;
    }

    public ViewGroup aQ() {
        return null;
    }

    public View aR() {
        return null;
    }

    public void aS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT() {
        try {
            if (Y()) {
                aU();
            } else {
                O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void ab() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        this.f15373j = com.beizi.fusion.f.a.ADSHOW;
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.s() != 2) {
            this.f15367d.b(g());
        }
        if (this.f15531t) {
            return;
        }
        this.f15531t = true;
        az();
        C();
        D();
        ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onADClicked()");
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.s() != 2) {
            this.f15367d.d(g());
        }
        if (this.f15532u) {
            return;
        }
        this.f15532u = true;
        E();
        ai();
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                aG();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void l() {
        w();
        ag();
        aH();
    }
}
