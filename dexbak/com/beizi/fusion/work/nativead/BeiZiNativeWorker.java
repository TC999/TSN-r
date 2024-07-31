package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.ComplaintViewUtil;
import com.beizi.fusion.p072g.ImageUtil;
import com.beizi.fusion.p072g.NativeShakeUtil;
import com.beizi.fusion.p072g.RandomUtils;
import com.beizi.fusion.p072g.ShakeCoolConfig;
import com.beizi.fusion.p072g.ViewCheckUtil;
import com.beizi.fusion.widget.dialog.dislike.DislikeDialog;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.splash.SplashContainer;
import com.beizi.p051ad.NativeAd;
import com.beizi.p051ad.NativeAdListener;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.nativead.NativeAdEventListener;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.nativead.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiNativeWorker extends AdWorker implements AdShowObserver {

    /* renamed from: A */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f12356A;

    /* renamed from: B */
    private NativeShakeUtil f12357B;

    /* renamed from: E */
    private AdSpacesBean.BuyerBean.DislikeConfigBean f12360E;

    /* renamed from: F */
    private AdSpacesBean.BuyerBean.DislikeConfigBean f12361F;

    /* renamed from: O */
    private AdSpacesBean.ComplainBean f12370O;

    /* renamed from: n */
    private Context f12371n;

    /* renamed from: o */
    private String f12372o;

    /* renamed from: p */
    private long f12373p;

    /* renamed from: q */
    private long f12374q;

    /* renamed from: r */
    private float f12375r;

    /* renamed from: s */
    private float f12376s;

    /* renamed from: t */
    private NativeAd f12377t;

    /* renamed from: u */
    private ViewGroup f12378u;

    /* renamed from: v */
    private View f12379v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12380w;

    /* renamed from: x */
    private AdSpacesBean.RenderViewBean f12381x;

    /* renamed from: y */
    private List<Pair<String, Integer>> f12382y;

    /* renamed from: z */
    private AdSpacesBean.BuyerBean.ShakeViewBean f12383z;

    /* renamed from: C */
    private String f12358C = null;

    /* renamed from: D */
    private boolean f12359D = false;

    /* renamed from: G */
    private float f12362G = 0.0f;

    /* renamed from: H */
    private float f12363H = 0.0f;

    /* renamed from: I */
    private float f12364I = 0.0f;

    /* renamed from: J */
    private float f12365J = 0.0f;

    /* renamed from: K */
    private String f12366K = null;

    /* renamed from: L */
    private String f12367L = null;

    /* renamed from: M */
    private boolean f12368M = false;

    /* renamed from: N */
    private boolean f12369N = false;

    public BeiZiNativeWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12371n = context;
        this.f12372o = str;
        this.f12373p = j;
        this.f12374q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12375r = f;
        this.f12376s = f2;
        this.f12378u = new SplashContainer(context);
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m46857aG() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f12371n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.f12371n);
            imageView.setImageResource(C3025R.C3027drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.f12371n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.f12379v.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f12379v.getMeasuredWidth(), this.f12379v.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.f12378u.addView(linearLayout, layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aH */
    private boolean m46856aH() {
        try {
            return System.currentTimeMillis() - this.f12371n.getPackageManager().getPackageInfo(this.f12371n.getPackageName(), 0).firstInstallTime < this.f12356A.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m46855aI() {
        AdSpacesBean.BuyerBean.DislikeConfigBean m46832b;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f11798e.getDislikeConfig();
        this.f12360E = dislikeConfig;
        if (dislikeConfig == null || (m46832b = m46832b(dislikeConfig.getOrderData(), this.f12377t.getAdId())) == null) {
            return;
        }
        this.f12361F = m46832b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public boolean m46854aJ() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12361F;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12360E;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    /* renamed from: aK */
    private boolean m46853aK() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12361F;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12360E;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aL */
    public boolean m46852aL() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.f12361F;
        if (dislikeConfigBean != null) {
            return RandomUtils.m48438a(dislikeConfigBean.getRandomNum());
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.f12360E;
        if (dislikeConfigBean2 != null) {
            return RandomUtils.m48438a(dislikeConfigBean2.getRandomNum());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aM */
    public boolean m46851aM() {
        long longValue = ((Long) C3137at.m48313b(this.f12371n, this.f12366K, 0L)).longValue();
        return this.f12360E == null || longValue == 0 || System.currentTimeMillis() - longValue >= this.f12360E.getCoolTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m46850aN() {
        try {
            if (!m46853aK()) {
                BaseManager baseManager = this.f11797d;
                if (baseManager != null && baseManager.m48668s() != 2) {
                    this.f11797d.m48709b(mo46059g(), this.f12379v);
                }
                m47988G();
                return;
            }
            DislikeDialog.C3235a c3235a = new DislikeDialog.C3235a(this.f12371n);
            c3235a.m48010a(new DislikeDialog.InterfaceC3238c() { // from class: com.beizi.fusion.work.nativead.e.3
                @Override // com.beizi.fusion.widget.dialog.dislike.DislikeDialog.InterfaceC3238c
                /* renamed from: a */
                public void mo46798a() {
                    try {
                        if (((AdWorker) BeiZiNativeWorker.this).f11797d != null && ((AdWorker) BeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) BeiZiNativeWorker.this).f11797d.m48709b(BeiZiNativeWorker.this.mo46059g(), BeiZiNativeWorker.this.f12379v);
                        }
                        BeiZiNativeWorker.this.m47988G();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            c3235a.m48012a().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aO */
    private boolean m46849aO() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f12383z;
        if (shakeViewBean == null) {
            return false;
        }
        return RandomUtils.m48438a(shakeViewBean.getRenderRate());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m46820f(final NativeAdResponse nativeAdResponse) {
        ImageView imageView = new ImageView(this.f12371n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(85, 85);
        imageView.setPadding(25, 15, 15, 25);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageResource(C3025R.C3027drawable.beizi_close);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(85, 85);
        layoutParams2.gravity = 5;
        this.f12378u.addView(imageView, layoutParams2);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.nativead.e.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    BeiZiNativeWorker.this.f12362G = motionEvent.getX();
                    BeiZiNativeWorker.this.f12363H = motionEvent.getY();
                    BeiZiNativeWorker.this.f12364I = motionEvent.getRawX();
                    BeiZiNativeWorker.this.f12365J = motionEvent.getRawY();
                    return false;
                }
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BeiZiNativeWorker.this.m46852aL()) {
                    if (BeiZiNativeWorker.this.m46851aM()) {
                        C3137at.m48315a(BeiZiNativeWorker.this.f12371n, BeiZiNativeWorker.this.f12366K, Long.valueOf(System.currentTimeMillis()));
                        NativeAdUtil.handleClick(nativeAdResponse, BeiZiNativeWorker.this.f12379v, String.valueOf(BeiZiNativeWorker.this.f12362G), String.valueOf(BeiZiNativeWorker.this.f12363H), String.valueOf(BeiZiNativeWorker.this.f12364I), String.valueOf(BeiZiNativeWorker.this.f12365J), 0);
                        return;
                    }
                    BeiZiNativeWorker.this.m46850aN();
                    return;
                }
                BeiZiNativeWorker.this.m46850aN();
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12377t == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        NativeAd nativeAd = this.f12377t;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getPrice();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f11798e.getShakeView();
        this.f12383z = shakeView;
        if (shakeView != null) {
            this.f12356A = shakeView.getCoolShakeView();
        }
        this.f12357B = new NativeShakeUtil(this.f12371n);
        this.f12358C = "cool_" + this.f11802i;
        this.f12366K = "dl_cool_" + this.f11802i;
        if (this.f12375r <= 0.0f) {
            this.f12375r = C3138av.m48288j(this.f12371n);
        }
        if (this.f12376s <= 0.0f) {
            this.f12376s = 0.0f;
        }
        NativeAd nativeAd = new NativeAd(this.f12371n, this.f11802i, 3, new NativeAdListener() { // from class: com.beizi.fusion.work.nativead.e.4
            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiNativeAd onAdClick()");
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdFailed(int i) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdFailed: " + i);
                BeiZiNativeWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdLoaded()");
                ((AdWorker) BeiZiNativeWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiNativeWorker.this.f12377t.getPrice() != null) {
                    try {
                        BeiZiNativeWorker beiZiNativeWorker = BeiZiNativeWorker.this;
                        beiZiNativeWorker.m47967a(Double.parseDouble(beiZiNativeWorker.f12377t.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiNativeWorker.this.m47910y();
                if (nativeAdResponse == null) {
                    BeiZiNativeWorker.this.m47921c(-991);
                } else {
                    BeiZiNativeWorker.this.m46831c(nativeAdResponse);
                }
            }
        });
        this.f12377t = nativeAd;
        nativeAd.openAdInNativeBrowser(true);
        this.f12377t.loadAd();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeAd nativeAd = this.f12377t;
        if (nativeAd != null) {
            nativeAd.cancel();
        }
        NativeShakeUtil nativeShakeUtil = this.f12357B;
        if (nativeShakeUtil != null) {
            nativeShakeUtil.m48468c();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12379v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46823e(NativeAdResponse nativeAdResponse) {
        View downloadTextView;
        if (nativeAdResponse == null) {
            return;
        }
        try {
            if (nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(this.f12371n, nativeAdResponse)) == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f12378u.getLayoutParams().width * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.f12378u.addView(downloadTextView, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m46831c(final NativeAdResponse nativeAdResponse) {
        if (nativeAdResponse == null) {
            m47921c(-991);
            return;
        }
        ArrayList<String> imageUrls = nativeAdResponse.getImageUrls();
        if (imageUrls != null && imageUrls.size() != 0) {
            final ImageView imageView = new ImageView(this.f12371n);
            imageView.setVisibility(0);
            ImageManager.with(null).getBitmap(imageUrls.get(0), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.e.5
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
                    BeiZiNativeWorker.this.m47961a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    try {
                        Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded");
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        double d = width;
                        Double.isNaN(d);
                        double d2 = height;
                        Double.isNaN(d2);
                        float f = (float) ((d * 1.0d) / d2);
                        int m48304a = C3138av.m48304a(BeiZiNativeWorker.this.f12371n, BeiZiNativeWorker.this.f12375r);
                        int m48304a2 = BeiZiNativeWorker.this.f12376s > 0.0f ? C3138av.m48304a(BeiZiNativeWorker.this.f12371n, BeiZiNativeWorker.this.f12376s) : (int) (m48304a / f);
                        ImageView imageView2 = imageView;
                        if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                            layoutParams.width = m48304a;
                            layoutParams.height = m48304a2;
                            imageView.setLayoutParams(layoutParams);
                        }
                        if (imageView != null) {
                            imageView.setBackground(new BitmapDrawable(ImageUtil.m48505a(BeiZiNativeWorker.this.f12371n, bitmap, 20.0f)));
                            imageView.setImageBitmap(bitmap);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(m48304a, m48304a2);
                        if (BeiZiNativeWorker.this.f12378u != null) {
                            BeiZiNativeWorker.this.f12378u.removeAllViews();
                            BeiZiNativeWorker.this.f12378u.setLayoutParams(layoutParams2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("mNativeAd != null ? ");
                            boolean z = true;
                            sb.append(BeiZiNativeWorker.this.f12377t != null);
                            sb.append(",renderViewBean != null ? ");
                            if (BeiZiNativeWorker.this.f12381x == null) {
                                z = false;
                            }
                            sb.append(z);
                            C3116af.m48496a("BeiZis", sb.toString());
                            BeiZiNativeWorker.this.f12378u.addView(imageView, layoutParams2);
                            BeiZiNativeWorker.this.m46827d(nativeAdResponse);
                            BeiZiNativeWorker.this.m46841b();
                            BeiZiNativeWorker.this.m46823e(nativeAdResponse);
                            BeiZiNativeWorker.this.m46870a(nativeAdResponse, m48304a, m48304a2, bitmap.getHeight());
                            BeiZiNativeWorker.this.m46855aI();
                            if (((AdWorker) BeiZiNativeWorker.this).f11795b != null && BeiZiNativeWorker.this.f12360E != null) {
                                ((AdWorker) BeiZiNativeWorker.this).f11795b.m48934Q(BeiZiNativeWorker.this.f12360E.getDislikeUuid());
                                BeiZiNativeWorker.this.m47929au();
                            }
                            if (BeiZiNativeWorker.this.m46854aJ()) {
                                BeiZiNativeWorker.this.m46820f(nativeAdResponse);
                            }
                            BeiZiNativeWorker beiZiNativeWorker = BeiZiNativeWorker.this;
                            beiZiNativeWorker.f12379v = beiZiNativeWorker.f12378u;
                            BeiZiNativeWorker.this.f12357B.m48487a(BeiZiNativeWorker.this.f12379v);
                        }
                        if (BeiZiNativeWorker.this.f12377t != null && BeiZiNativeWorker.this.f12381x != null) {
                            BeiZiNativeWorker.this.f12377t.setOrderOptimizeList(BeiZiNativeWorker.this.f12382y);
                            BeiZiNativeWorker.this.f12377t.setAdOptimizePercent(BeiZiNativeWorker.this.f12381x.getOptimizePercent());
                            C3116af.m48496a("BeiZis", "percent = " + BeiZiNativeWorker.this.f12381x.getOptimizePercent());
                            BeiZiNativeWorker.this.f12378u.post(new Runnable() { // from class: com.beizi.fusion.work.nativead.e.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NativeAd nativeAd = BeiZiNativeWorker.this.f12377t;
                                    int optimizeSize = BeiZiNativeWorker.this.f12381x.getOptimizeSize();
                                    C34095 c34095 = C34095.this;
                                    nativeAd.optimizeClickArea(optimizeSize, imageView, BeiZiNativeWorker.this.f12378u, BeiZiNativeWorker.this.f12381x.getDirection());
                                }
                            });
                        }
                        BeiZiNativeWorker.this.m46840b(nativeAdResponse);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            NativeAdUtil.registerTracking(nativeAdResponse, imageView, new NativeAdEventListener() { // from class: com.beizi.fusion.work.nativead.e.6

                /* renamed from: a */
                boolean f12396a = false;

                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
                    if (BeiZiNativeWorker.this.f12368M && ((AdWorker) BeiZiNativeWorker.this).f11798e != null) {
                        ((AdWorker) BeiZiNativeWorker.this).f11795b.m48936P(((AdWorker) BeiZiNativeWorker.this).f11798e.getCallBackStrategyUuid());
                        BeiZiNativeWorker.this.m47929au();
                    }
                    BeiZiNativeWorker.this.m47989F();
                    if (!BeiZiNativeWorker.this.f12368M || BeiZiNativeWorker.this.f12369N) {
                        if (((AdWorker) BeiZiNativeWorker.this).f11797d != null && ((AdWorker) BeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) BeiZiNativeWorker.this).f11797d.m48700d(BeiZiNativeWorker.this.mo46059g());
                        }
                        BeiZiNativeWorker.this.m47990E();
                        BeiZiNativeWorker.this.m47941ai();
                        if (BeiZiNativeWorker.this.f12377t != null) {
                            BeiZiNativeWorker.this.f12377t.setTouchAreaNormal();
                        }
                    }
                }

                @Override // com.beizi.p051ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                }
            });
            NativeAdUtil.registerShow(nativeAdResponse, imageView, new NativeAdShownListener() { // from class: com.beizi.fusion.work.nativead.e.7
                @Override // com.beizi.p051ad.internal.nativead.NativeAdShownListener
                public void onAdShown() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                    ((AdWorker) BeiZiNativeWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) BeiZiNativeWorker.this).f11797d != null && ((AdWorker) BeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BeiZiNativeWorker.this).f11797d.m48710b(BeiZiNativeWorker.this.mo46059g());
                    }
                    BeiZiNativeWorker.this.m47992C();
                    BeiZiNativeWorker.this.m47991D();
                    BeiZiNativeWorker.this.m47942ah();
                }
            });
            return;
        }
        Log.d("BeiZis", "showBeiZiNativeAd imageUrls address is null");
        m47921c(-991);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        r7.f12369N = com.beizi.fusion.p072g.RandomUtils.m48438a(java.lang.Integer.parseInt(r4.getRate()));
     */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo46065d() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.nativead.BeiZiNativeWorker.mo46065d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46840b(NativeAdResponse nativeAdResponse) {
        if (m47970Y()) {
            m46871a(nativeAdResponse);
        } else {
            m47980O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46841b() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.f12370O;
            if (complainBean != null && complainBean.getOpen() == 1) {
                ComplaintViewUtil complaintViewUtil = new ComplaintViewUtil();
                complaintViewUtil.m48231a(this.f12371n, this.f12378u, "1");
                complaintViewUtil.m48229a(new ComplaintViewUtil.InterfaceC3161a() { // from class: com.beizi.fusion.work.nativead.e.8
                    @Override // com.beizi.fusion.p072g.ComplaintViewUtil.InterfaceC3161a
                    /* renamed from: a */
                    public void mo46797a(String str) {
                        try {
                            C3137at.m48315a(BeiZiNativeWorker.this.f12371n, BeiZiNativeWorker.this.f12367L, Long.valueOf(System.currentTimeMillis()));
                            ((AdWorker) BeiZiNativeWorker.this).f11795b.m48930S(str);
                            BeiZiNativeWorker.this.m47929au();
                            BeiZiNativeWorker.this.m47986I();
                            BeiZiNativeWorker.this.m46857aG();
                            if (((AdWorker) BeiZiNativeWorker.this).f11797d != null && ((AdWorker) BeiZiNativeWorker.this).f11797d.m48668s() != 2) {
                                ((AdWorker) BeiZiNativeWorker.this).f11797d.m48709b(BeiZiNativeWorker.this.mo46059g(), BeiZiNativeWorker.this.f12379v);
                            }
                            BeiZiNativeWorker.this.m47988G();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m46871a(NativeAdResponse nativeAdResponse) {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12379v != null) {
                this.f11797d.m48726a(mo46059g(), this.f12379v);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: b */
    private boolean m46839b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) C3137at.m48313b(this.f12371n, this.f12358C, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f12356A.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        BeiZiNativeWorker.this.f12357B.m48478a(shakeViewBean);
                    }
                }, this.f12356A.getCoolTime() - currentTimeMillis);
                return true;
            }
            ShakeCoolConfig.m48369a().m48368a(this.f12358C);
        }
        return false;
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46858a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.DislikeConfigBean m46832b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislike;
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean orderDataDislikeConfigBean : list) {
                List<String> orderList = orderDataDislikeConfigBean.getOrderList();
                if (orderList != null && orderList.contains(str) && (dislike = orderDataDislikeConfigBean.getDislike()) != null) {
                    return dislike;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46870a(final NativeAdResponse nativeAdResponse, final int i, final int i2, int i3) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!m46849aO() || (shakeViewBean = this.f12383z) == null || this.f12357B == null || shakeViewBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48954G(this.f12383z.getShakeViewUuid());
                m47929au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean m46858a = m46858a(this.f12383z.getOrderData(), this.f12377t.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (m46858a != null && m46858a.getShakeView() != null) {
                shakeViewBean2 = m46858a.getShakeView();
            }
            if (i2 <= 0) {
                i2 = i3;
            }
            View m48489a = this.f12357B.m48489a(C3138av.m48298b(this.f12371n, i), C3138av.m48298b(this.f12371n, i2), this.f12383z.getPosition());
            if (m48489a != null) {
                ViewGroup.LayoutParams layoutParams = m48489a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f12383z;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        this.f12378u.addView(m48489a, layoutParams2);
                    }
                }
            }
            m46869a(shakeViewBean2);
            this.f12357B.m48486a(new NativeShakeUtil.InterfaceC3118a() { // from class: com.beizi.fusion.work.nativead.e.9
                @Override // com.beizi.fusion.p072g.NativeShakeUtil.InterfaceC3118a
                /* renamed from: a */
                public void mo46796a() {
                    if (ViewCheckUtil.m48281a(BeiZiNativeWorker.this.f12379v)) {
                        int[] iArr = new int[2];
                        BeiZiNativeWorker.this.f12379v.getLocationOnScreen(iArr);
                        int[] m48437a = RandomUtils.m48437a(i / 2, i2 / 2);
                        NativeAdUtil.handleClick(nativeAdResponse, BeiZiNativeWorker.this.f12379v, String.valueOf(m48437a[0]), String.valueOf(m48437a[1]), String.valueOf(m48437a[0] + iArr[0]), String.valueOf(m48437a[1] + iArr[1]), 2);
                        if (!BeiZiNativeWorker.this.f12359D || BeiZiNativeWorker.this.f12356A == null) {
                            return;
                        }
                        BeiZiNativeWorker.this.f12359D = false;
                        BeiZiNativeWorker.this.f12357B.m48480a(BeiZiNativeWorker.this.f12356A);
                        C3137at.m48315a(BeiZiNativeWorker.this.f12371n, BeiZiNativeWorker.this.f12358C, Long.valueOf(System.currentTimeMillis()));
                        ShakeCoolConfig.m48369a().m48367a(BeiZiNativeWorker.this.f12358C, System.currentTimeMillis());
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f12356A;
            if (coolShakeViewBean != null) {
                this.f12357B.m48479a(coolShakeViewBean, this.f12358C);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m46827d(NativeAdResponse nativeAdResponse) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f12371n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(this.f12371n, nativeAdResponse.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(this.f12371n, nativeAdResponse.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            this.f12378u.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int m48304a = C3138av.m48304a(this.f12371n, 12.0f);
            layoutParams2.setMargins(0, 0, m48304a, m48304a);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m46869a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f12383z;
        }
        if (this.f12356A == null) {
            this.f12359D = true;
            this.f12357B.m48478a(shakeViewBean);
        } else if (m46839b(shakeViewBean)) {
            this.f12357B.m48480a(this.f12356A);
        } else if (m46856aH()) {
            this.f12357B.m48480a(this.f12356A);
        } else {
            this.f12359D = true;
            this.f12357B.m48478a(shakeViewBean);
        }
    }
}
