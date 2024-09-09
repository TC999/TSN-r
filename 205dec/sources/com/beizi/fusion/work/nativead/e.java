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
import com.beizi.ad.NativeAd;
import com.beizi.ad.NativeAdListener;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.internal.nativead.NativeAdEventListener;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import com.beizi.ad.internal.nativead.NativeAdUtil;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.fusion.R;
import com.beizi.fusion.g.ac;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.ag;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aq;
import com.beizi.fusion.g.at;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.ax;
import com.beizi.fusion.g.p;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.dialog.dislike.a;
import com.beizi.fusion.work.splash.SplashContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BeiZiNativeWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {
    private AdSpacesBean.BuyerBean.CoolShakeViewBean A;
    private ag B;
    private AdSpacesBean.BuyerBean.DislikeConfigBean E;
    private AdSpacesBean.BuyerBean.DislikeConfigBean F;
    private AdSpacesBean.ComplainBean O;

    /* renamed from: n  reason: collision with root package name */
    private Context f15834n;

    /* renamed from: o  reason: collision with root package name */
    private String f15835o;

    /* renamed from: p  reason: collision with root package name */
    private long f15836p;

    /* renamed from: q  reason: collision with root package name */
    private long f15837q;

    /* renamed from: r  reason: collision with root package name */
    private float f15838r;

    /* renamed from: s  reason: collision with root package name */
    private float f15839s;

    /* renamed from: t  reason: collision with root package name */
    private NativeAd f15840t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup f15841u;

    /* renamed from: v  reason: collision with root package name */
    private View f15842v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15843w;

    /* renamed from: x  reason: collision with root package name */
    private AdSpacesBean.RenderViewBean f15844x;

    /* renamed from: y  reason: collision with root package name */
    private List<Pair<String, Integer>> f15845y;

    /* renamed from: z  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f15846z;
    private String C = null;
    private boolean D = false;
    private float G = 0.0f;
    private float H = 0.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private String K = null;

    /* renamed from: L  reason: collision with root package name */
    private String f15833L = null;
    private boolean M = false;
    private boolean N = false;

    public e(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15834n = context;
        this.f15835o = str;
        this.f15836p = j4;
        this.f15837q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15838r = f4;
        this.f15839s = f5;
        this.f15841u = new SplashContainer(context);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f15834n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.f15834n);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.f15834n);
            textView.setText("\u6295\u8bc9\u6210\u529f\uff0c\u6211\u4eec\u5c06\u91cd\u89c6\u60a8\u7684\u53cd\u9988\u3002");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.f15842v.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f15842v.getMeasuredWidth(), this.f15842v.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.f15841u.addView(linearLayout, layoutParams2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean aH() {
        try {
            return System.currentTimeMillis() - this.f15834n.getPackageManager().getPackageInfo(this.f15834n.getPackageName(), 0).firstInstallTime < this.A.getUserProtectTime();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        AdSpacesBean.BuyerBean.DislikeConfigBean b4;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f15368e.getDislikeConfig();
        this.E = dislikeConfig;
        if (dislikeConfig == null || (b4 = b(dislikeConfig.getOrderData(), this.f15840t.getAdId())) == null) {
            return;
        }
        this.F = b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJ() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    private boolean aK() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aL() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
        if (dislikeConfigBean != null) {
            return al.a(dislikeConfigBean.getRandomNum());
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
        if (dislikeConfigBean2 != null) {
            return al.a(dislikeConfigBean2.getRandomNum());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aM() {
        long longValue = ((Long) at.b(this.f15834n, this.K, 0L)).longValue();
        return this.E == null || longValue == 0 || System.currentTimeMillis() - longValue >= this.E.getCoolTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        try {
            if (!aK()) {
                com.beizi.fusion.d.e eVar = this.f15367d;
                if (eVar != null && eVar.s() != 2) {
                    this.f15367d.b(g(), this.f15842v);
                }
                G();
                return;
            }
            a.C0149a c0149a = new a.C0149a(this.f15834n);
            c0149a.a(new a.c() { // from class: com.beizi.fusion.work.nativead.e.3
                @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                public void a() {
                    try {
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) e.this).f15367d.b(e.this.g(), e.this.f15842v);
                        }
                        e.this.G();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            c0149a.a().show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean aO() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f15846z;
        if (shakeViewBean == null) {
            return false;
        }
        return al.a(shakeViewBean.getRenderRate());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final NativeAdResponse nativeAdResponse) {
        ImageView imageView = new ImageView(this.f15834n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(85, 85);
        imageView.setPadding(25, 15, 15, 25);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.beizi_close);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(85, 85);
        layoutParams2.gravity = 5;
        this.f15841u.addView(imageView, layoutParams2);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.nativead.e.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    e.this.G = motionEvent.getX();
                    e.this.H = motionEvent.getY();
                    e.this.I = motionEvent.getRawX();
                    e.this.J = motionEvent.getRawY();
                    return false;
                }
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aL()) {
                    if (e.this.aM()) {
                        at.a(e.this.f15834n, e.this.K, Long.valueOf(System.currentTimeMillis()));
                        NativeAdUtil.handleClick(nativeAdResponse, e.this.f15842v, String.valueOf(e.this.G), String.valueOf(e.this.H), String.valueOf(e.this.I), String.valueOf(e.this.J), 0);
                        return;
                    }
                    e.this.aN();
                    return;
                }
                e.this.aN();
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15840t == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        NativeAd nativeAd = this.f15840t;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getPrice();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f15368e.getShakeView();
        this.f15846z = shakeView;
        if (shakeView != null) {
            this.A = shakeView.getCoolShakeView();
        }
        this.B = new ag(this.f15834n);
        this.C = "cool_" + this.f15372i;
        this.K = "dl_cool_" + this.f15372i;
        if (this.f15838r <= 0.0f) {
            this.f15838r = av.j(this.f15834n);
        }
        if (this.f15839s <= 0.0f) {
            this.f15839s = 0.0f;
        }
        NativeAd nativeAd = new NativeAd(this.f15834n, this.f15372i, 3, new NativeAdListener() { // from class: com.beizi.fusion.work.nativead.e.4
            @Override // com.beizi.ad.NativeAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBeiZiNativeAd onAdClick()");
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdFailed(int i4) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdFailed: " + i4);
                e.this.a(String.valueOf(i4), i4);
            }

            @Override // com.beizi.ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdLoaded()");
                ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                if (e.this.f15840t.getPrice() != null) {
                    try {
                        e eVar = e.this;
                        eVar.a(Double.parseDouble(eVar.f15840t.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                e.this.y();
                if (nativeAdResponse == null) {
                    e.this.c(-991);
                } else {
                    e.this.c(nativeAdResponse);
                }
            }
        });
        this.f15840t = nativeAd;
        nativeAd.openAdInNativeBrowser(true);
        this.f15840t.loadAd();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        NativeAd nativeAd = this.f15840t;
        if (nativeAd != null) {
            nativeAd.cancel();
        }
        ag agVar = this.B;
        if (agVar != null) {
            agVar.c();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15842v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(NativeAdResponse nativeAdResponse) {
        View downloadTextView;
        if (nativeAdResponse == null) {
            return;
        }
        try {
            if (nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(this.f15834n, nativeAdResponse)) == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f15841u.getLayoutParams().width * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.f15841u.addView(downloadTextView, layoutParams);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final NativeAdResponse nativeAdResponse) {
        if (nativeAdResponse == null) {
            c(-991);
            return;
        }
        ArrayList<String> imageUrls = nativeAdResponse.getImageUrls();
        if (imageUrls != null && imageUrls.size() != 0) {
            final ImageView imageView = new ImageView(this.f15834n);
            imageView.setVisibility(0);
            ImageManager.with(null).getBitmap(imageUrls.get(0), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.e.5
                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
                    e.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    try {
                        Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded");
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        double d4 = width;
                        Double.isNaN(d4);
                        double d5 = height;
                        Double.isNaN(d5);
                        float f4 = (float) ((d4 * 1.0d) / d5);
                        int a4 = av.a(e.this.f15834n, e.this.f15838r);
                        int a5 = e.this.f15839s > 0.0f ? av.a(e.this.f15834n, e.this.f15839s) : (int) (a4 / f4);
                        ImageView imageView2 = imageView;
                        if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                            layoutParams.width = a4;
                            layoutParams.height = a5;
                            imageView.setLayoutParams(layoutParams);
                        }
                        if (imageView != null) {
                            imageView.setBackground(new BitmapDrawable(ac.a(e.this.f15834n, bitmap, 20.0f)));
                            imageView.setImageBitmap(bitmap);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a4, a5);
                        if (e.this.f15841u != null) {
                            e.this.f15841u.removeAllViews();
                            e.this.f15841u.setLayoutParams(layoutParams2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("mNativeAd != null ? ");
                            boolean z3 = true;
                            sb.append(e.this.f15840t != null);
                            sb.append(",renderViewBean != null ? ");
                            if (e.this.f15844x == null) {
                                z3 = false;
                            }
                            sb.append(z3);
                            af.a("BeiZis", sb.toString());
                            e.this.f15841u.addView(imageView, layoutParams2);
                            e.this.d(nativeAdResponse);
                            e.this.b();
                            e.this.e(nativeAdResponse);
                            e.this.a(nativeAdResponse, a4, a5, bitmap.getHeight());
                            e.this.aI();
                            if (((com.beizi.fusion.work.a) e.this).f15365b != null && e.this.E != null) {
                                ((com.beizi.fusion.work.a) e.this).f15365b.Q(e.this.E.getDislikeUuid());
                                e.this.au();
                            }
                            if (e.this.aJ()) {
                                e.this.f(nativeAdResponse);
                            }
                            e eVar = e.this;
                            eVar.f15842v = eVar.f15841u;
                            e.this.B.a(e.this.f15842v);
                        }
                        if (e.this.f15840t != null && e.this.f15844x != null) {
                            e.this.f15840t.setOrderOptimizeList(e.this.f15845y);
                            e.this.f15840t.setAdOptimizePercent(e.this.f15844x.getOptimizePercent());
                            af.a("BeiZis", "percent = " + e.this.f15844x.getOptimizePercent());
                            e.this.f15841u.post(new Runnable() { // from class: com.beizi.fusion.work.nativead.e.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NativeAd nativeAd = e.this.f15840t;
                                    int optimizeSize = e.this.f15844x.getOptimizeSize();
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    nativeAd.optimizeClickArea(optimizeSize, imageView, e.this.f15841u, e.this.f15844x.getDirection());
                                }
                            });
                        }
                        e.this.b(nativeAdResponse);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            NativeAdUtil.registerTracking(nativeAdResponse, imageView, new NativeAdEventListener() { // from class: com.beizi.fusion.work.nativead.e.6

                /* renamed from: a  reason: collision with root package name */
                boolean f15859a = false;

                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWasClicked() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
                    if (e.this.M && ((com.beizi.fusion.work.a) e.this).f15368e != null) {
                        ((com.beizi.fusion.work.a) e.this).f15365b.P(((com.beizi.fusion.work.a) e.this).f15368e.getCallBackStrategyUuid());
                        e.this.au();
                    }
                    e.this.F();
                    if (!e.this.M || e.this.N) {
                        if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) e.this).f15367d.d(e.this.g());
                        }
                        e.this.E();
                        e.this.ai();
                        if (e.this.f15840t != null) {
                            e.this.f15840t.setTouchAreaNormal();
                        }
                    }
                }

                @Override // com.beizi.ad.internal.nativead.NativeAdEventListener
                public void onAdWillLeaveApplication() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                }
            });
            NativeAdUtil.registerShow(nativeAdResponse, imageView, new NativeAdShownListener() { // from class: com.beizi.fusion.work.nativead.e.7
                @Override // com.beizi.ad.internal.nativead.NativeAdShownListener
                public void onAdShown() {
                    Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                    ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) e.this).f15367d.b(e.this.g());
                    }
                    e.this.C();
                    e.this.D();
                    e.this.ah();
                }
            });
            return;
        }
        Log.d("BeiZis", "showBeiZiNativeAd imageUrls address is null");
        c(-991);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        r7.N = com.beizi.fusion.g.al.a(java.lang.Integer.parseInt(r4.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.nativead.e.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NativeAdResponse nativeAdResponse) {
        if (Y()) {
            a(nativeAdResponse);
        } else {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.O;
            if (complainBean != null && complainBean.getOpen() == 1) {
                p pVar = new p();
                pVar.a(this.f15834n, this.f15841u, "1");
                pVar.a(new p.a() { // from class: com.beizi.fusion.work.nativead.e.8
                    @Override // com.beizi.fusion.g.p.a
                    public void a(String str) {
                        try {
                            at.a(e.this.f15834n, e.this.f15833L, Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) e.this).f15365b.S(str);
                            e.this.au();
                            e.this.I();
                            e.this.aG();
                            if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                                ((com.beizi.fusion.work.a) e.this).f15367d.b(e.this.g(), e.this.f15842v);
                            }
                            e.this.G();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(NativeAdResponse nativeAdResponse) {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            if (this.f15842v != null) {
                this.f15367d.a(g(), this.f15842v);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) at.b(this.f15834n, this.C, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.A.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.B.a(shakeViewBean);
                    }
                }, this.A.getCoolTime() - currentTimeMillis);
                return true;
            }
            aq.a().a(this.C);
        }
        return false;
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

    private AdSpacesBean.BuyerBean.DislikeConfigBean b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
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
    public void a(final NativeAdResponse nativeAdResponse, final int i4, final int i5, int i6) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean;
        try {
            if (!aO() || (shakeViewBean = this.f15846z) == null || this.B == null || shakeViewBean.getPosition() == null) {
                return;
            }
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.G(this.f15846z.getShakeViewUuid());
                au();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a4 = a(this.f15846z.getOrderData(), this.f15840t.getAdId());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = null;
            if (a4 != null && a4.getShakeView() != null) {
                shakeViewBean2 = a4.getShakeView();
            }
            if (i5 <= 0) {
                i5 = i6;
            }
            View a5 = this.B.a(av.b(this.f15834n, i4), av.b(this.f15834n, i5), this.f15846z.getPosition());
            if (a5 != null) {
                ViewGroup.LayoutParams layoutParams = a5.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f15846z;
                    if (shakeViewBean3 != null && shakeViewBean3.getIsHideAnim() == 0) {
                        this.f15841u.addView(a5, layoutParams2);
                    }
                }
            }
            a(shakeViewBean2);
            this.B.a(new ag.a() { // from class: com.beizi.fusion.work.nativead.e.9
                @Override // com.beizi.fusion.g.ag.a
                public void a() {
                    if (ax.a(e.this.f15842v)) {
                        int[] iArr = new int[2];
                        e.this.f15842v.getLocationOnScreen(iArr);
                        int[] a6 = al.a(i4 / 2, i5 / 2);
                        NativeAdUtil.handleClick(nativeAdResponse, e.this.f15842v, String.valueOf(a6[0]), String.valueOf(a6[1]), String.valueOf(a6[0] + iArr[0]), String.valueOf(a6[1] + iArr[1]), 2);
                        if (!e.this.D || e.this.A == null) {
                            return;
                        }
                        e.this.D = false;
                        e.this.B.a(e.this.A);
                        at.a(e.this.f15834n, e.this.C, Long.valueOf(System.currentTimeMillis()));
                        aq.a().a(e.this.C, System.currentTimeMillis());
                    }
                }
            });
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.A;
            if (coolShakeViewBean != null) {
                this.B.a(coolShakeViewBean, this.C);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(NativeAdResponse nativeAdResponse) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f15834n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(this.f15834n, nativeAdResponse.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(this.f15834n, nativeAdResponse.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            this.f15841u.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int a4 = av.a(this.f15834n, 12.0f);
            layoutParams2.setMargins(0, 0, a4, a4);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f15846z;
        }
        if (this.A == null) {
            this.D = true;
            this.B.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.B.a(this.A);
        } else if (aH()) {
            this.B.a(this.A);
        } else {
            this.D = true;
            this.B.a(shakeViewBean);
        }
    }
}
