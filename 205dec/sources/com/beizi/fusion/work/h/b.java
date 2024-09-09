package com.beizi.fusion.work.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.ad.NativeAdListener;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.UnifiedCustomAd;
import com.beizi.ad.internal.nativead.NativeAdEventListener;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import com.beizi.ad.internal.nativead.NativeAdUtil;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.fusion.R;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.am;
import com.beizi.fusion.g.aq;
import com.beizi.fusion.g.as;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiUnifiedCustomWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends a implements View.OnClickListener, aq.a, as.a {
    private ViewGroup W;
    private FrameLayout X;
    private UnifiedCustomAd Y;
    private NativeAdResponse Z;
    private AdSpacesBean.BuyerBean.ShakeViewBean aa;
    private AdSpacesBean.BuyerBean.ScrollClickBean ab;
    private List<View> ac;
    private Boolean ad;

    public b(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        super(context, j4, buyerBean, forwardBean, eVar, i4);
        this.ac = new ArrayList();
    }

    private void aZ() {
        if (this.Y != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("shakeViewBean != null ? ");
            sb.append(this.aa != null);
            af.a("BeiZis", sb.toString());
            ((a) this).f15640x.removeAllViews();
            ((a) this).f15640x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.h.b.8
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup viewGroup = ((a) b.this).f15640x;
                    if (viewGroup == null) {
                        return;
                    }
                    viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    b.this.ba();
                    b.this.bb();
                }
            });
            return;
        }
        aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.aa;
        if (shakeViewBean == null || this.P == null || shakeViewBean.getPosition() == null) {
            return;
        }
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.G(this.aa.getShakeViewUuid());
            au();
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean a4 = a(this.aa.getOrderData(), this.Y.getAdId());
        if (a4 != null) {
            this.P.a(a4.getShakeView());
        } else {
            this.P.a(this.aa);
        }
        this.P.a(this.ad);
        View a5 = this.P.a(aw.b(this.N, ((a) this).f15640x.getWidth()), aw.b(this.N, ((a) this).f15640x.getHeight()), this.aa.getPosition());
        if (a5 != null) {
            ViewGroup.LayoutParams layoutParams = a5.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((a) this).f15640x.addView(a5, layoutParams2);
                    this.P.a(this);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.ab;
        if (scrollClickBean == null || this.Q == null || scrollClickBean.getPosition() == null) {
            return;
        }
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.F(this.ab.getScrollClickUuid());
            au();
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean b4 = b(this.ab.getOrderData(), this.Y.getAdId());
        if (b4 != null) {
            this.Q.a(b4.getScrollClick());
        } else {
            this.Q.a(this.ab);
        }
        this.Q.a(this.ad);
        View a4 = this.Q.a(aw.b(this.N, ((a) this).f15640x.getWidth()), aw.b(this.N, ((a) this).f15640x.getHeight()), this.ab.getPosition());
        if (a4 != null) {
            ViewGroup.LayoutParams layoutParams = a4.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((a) this).f15640x.addView(a4, layoutParams2);
                    this.Q.a(this);
                    a(((a) this).f15640x, this.ab.getScrollDirection(), this.ab.getScrollDistance(), this);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.Y == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.h.a
    public int aG() {
        return R.layout.beizi_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.h.a
    public void aH() {
        super.aH();
        this.W = (ViewGroup) ((a) this).f15631o.findViewById(R.id.fl_container_mask);
    }

    @Override // com.beizi.fusion.work.h.a
    public void aI() {
        if (!aw.a("com.beizi.ad.BeiZi")) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
            return;
        }
        u();
        w.a(this.N, this.f15371h);
        v();
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + ((a) this).H);
        long j4 = ((a) this).H;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
        } else {
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar != null && eVar.t() < 1 && this.f15367d.s() != 2) {
                l();
            }
        }
        this.P = new as(this.N);
        this.Q = new aq(this.N);
    }

    @Override // com.beizi.fusion.work.h.a
    public void aJ() {
        this.aa = this.f15368e.getShakeView();
        this.ab = this.f15368e.getScrollClick();
        UnifiedCustomAd unifiedCustomAd = new UnifiedCustomAd(this.N, this.f15372i, new NativeAdListener() { // from class: com.beizi.fusion.work.h.b.2
            @Override // com.beizi.ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdClick()");
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdFailed(int i4) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdFailed: " + i4);
                b.this.a(String.valueOf(i4), i4);
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdLoaded()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                b bVar = b.this;
                bVar.ad = Boolean.valueOf(bVar.Y.isDownloadApp());
                if (b.this.Y.getPrice() != null) {
                    try {
                        b bVar2 = b.this;
                        bVar2.a(Double.parseDouble(bVar2.Y.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                b.this.y();
                if (nativeAdResponse == null) {
                    b.this.c(-991);
                    return;
                }
                b.this.Z = nativeAdResponse;
                b.this.aM();
            }
        });
        this.Y = unifiedCustomAd;
        unifiedCustomAd.openAdInNativeBrowser(true);
        this.Y.loadAd();
    }

    @Override // com.beizi.fusion.work.h.a
    public void aO() {
        if (am.a(this.T.getCec())) {
            b("regionalClick");
        } else {
            aY();
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public void aP() {
        aZ();
        List<View> list = this.ac;
        if (list != null && list.size() > 0) {
            NativeAdUtil.registerTracking(this.Z, this.X, this.ac, new NativeAdEventListener() { // from class: com.beizi.fusion.work.h.b.4
                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    b.this.aK();
                }

                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        } else {
            NativeAdUtil.registerTracking(this.Z, this.X, new NativeAdEventListener() { // from class: com.beizi.fusion.work.h.b.5
                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    b.this.aK();
                }

                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        }
        NativeAdUtil.registerShow(this.Z, this.X, new NativeAdShownListener() { // from class: com.beizi.fusion.work.h.b.6
            @Override // com.beizi.ad.internal.nativead.NativeAdShownListener
            public void onAdShown() {
                b.this.aL();
            }
        });
        if (am.a(this.T.getRmc())) {
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b("optimize");
                }
            }, (long) ((Math.random() * 1000.0d) + 1000.0d));
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public void aR() {
        ((a) this).f15636t.removeAllViews();
        ((a) this).f15636t.addView(this.X, new FrameLayout.LayoutParams(-1, -1));
        this.W.setLayoutParams(((a) this).f15636t.getLayoutParams());
    }

    @Override // com.beizi.fusion.work.h.a
    public String aS() {
        return this.Z.getHeadline();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aT() {
        return this.Z.getBody();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aU() {
        return this.Z.getIconUrl();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aV() {
        ArrayList<String> texts;
        String callToAction = this.Z.getCallToAction();
        return (!TextUtils.isEmpty(callToAction) || (texts = this.Z.getTexts()) == null || texts.size() < 3) ? callToAction : texts.get(2);
    }

    @Override // com.beizi.fusion.work.h.a
    public void aX() {
        if (this.Z == null) {
            c(-991);
        } else {
            ImageManager.with(null).getBitmap(this.Z.getImageUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.h.b.3
                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    b.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    b bVar = b.this;
                    bVar.X = NativeAdUtil.getCustomRenderView(bVar.N, bitmap, bVar.Z);
                    b.this.aN();
                }
            });
        }
    }

    @Override // com.beizi.fusion.g.aq.a
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
    }

    @Override // com.beizi.fusion.g.aq.a
    public void c_() {
        if (this.ab != null) {
            af.a("BeiZis", "enter showBeiZiUnifiedCustomAd onScrollDistanceMeet  ");
            b("scroll");
        }
    }

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public void m() {
        UnifiedCustomAd unifiedCustomAd = this.Y;
        if (unifiedCustomAd != null) {
            unifiedCustomAd.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b("regionalClick");
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean b(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.g.as.a
    public void b() {
        af.a("BeiZis", "enter showBeiZiUnifiedCustomAd onShakeHappened  ");
        b("shake");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.Y != null) {
                this.f15365b.O(str);
                au();
                af.a("BeiZis", "enter showBeiZiUnifiedCustomAd clickUnifiedAd clickEventType:" + str);
                int[] iArr = new int[2];
                this.X.getLocationOnScreen(iArr);
                this.X.measure(0, 0);
                int[] a4 = am.a(this.X.getMeasuredWidth() / 2, this.X.getMeasuredHeight() / 2);
                NativeAdUtil.handleClick(this.Z, this.X, String.valueOf(a4[0]), String.valueOf(a4[1]), String.valueOf(a4[0] + iArr[0]), String.valueOf(a4[1] + iArr[1]), 2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public void a(List<View> list) {
        List<String> clickView = this.T.getClickView();
        if (clickView != null && clickView.size() > 0) {
            if (!clickView.contains("bg") && !clickView.contains("ad") && !clickView.contains("image")) {
                this.W.setVisibility(0);
            } else {
                this.W.setVisibility(8);
            }
            this.ac.clear();
            this.ac.addAll(list);
            return;
        }
        this.W.setVisibility(0);
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.h.a
    public void b(boolean z3) {
        boolean a4 = am.a(this.T.getSlc());
        boolean a5 = am.a(this.T.getSlac());
        if (z3 && a4) {
            b("regionalClick");
        } else if (!z3 && a5) {
            b("regionalClick");
        } else {
            aY();
        }
    }
}
