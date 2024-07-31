package com.beizi.p051ad.internal.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdParameters;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ImageUtil;
import com.beizi.p051ad.internal.utilities.ShapeUtil;
import com.beizi.p051ad.internal.utilities.VideoCacheManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.view.CustomRoundImageView;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;
import com.beizi.p051ad.internal.view.complaint.ComplaintDialog;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.beizi.p051ad.p052a.p053a.EulerAngleUtil;
import com.beizi.p051ad.p052a.p053a.FullScreenClickUtil;
import com.beizi.p051ad.p052a.p053a.RegionClickUtil;
import com.beizi.p051ad.p052a.p053a.ScrollUtil;
import com.beizi.p051ad.p052a.p053a.ShakeUtil;
import com.beizi.p051ad.p056c.ClickPositionModel;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.stub.StubApp;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.beizi.ad.internal.activity.BeiZiInterstitialActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiInterstitialActivity extends Activity {

    /* renamed from: B */
    private boolean f9879B;

    /* renamed from: C */
    private MediaPlayer f9880C;

    /* renamed from: E */
    private int f9882E;

    /* renamed from: F */
    private boolean f9883F;

    /* renamed from: G */
    private int f9884G;

    /* renamed from: H */
    private CountDownTimer f9885H;

    /* renamed from: J */
    private String f9887J;

    /* renamed from: K */
    private String f9888K;

    /* renamed from: L */
    private String f9889L;

    /* renamed from: M */
    private String f9890M;

    /* renamed from: N */
    private String f9891N;

    /* renamed from: O */
    private AdSpacesBean.BuyerBean f9892O;

    /* renamed from: P */
    private RegionClickUtil f9893P;

    /* renamed from: Q */
    private ShakeUtil f9894Q;

    /* renamed from: R */
    private ScrollUtil f9895R;

    /* renamed from: S */
    private EulerAngleUtil f9896S;

    /* renamed from: T */
    private FullScreenClickUtil f9897T;

    /* renamed from: V */
    private Timer f9899V;

    /* renamed from: W */
    private TimerTask f9900W;

    /* renamed from: a */
    private InterstitialAdViewImpl f9901a;

    /* renamed from: b */
    private ServerResponse f9902b;

    /* renamed from: c */
    private LinearLayout f9903c;

    /* renamed from: d */
    private LinearLayout f9904d;

    /* renamed from: e */
    private LinearLayout f9905e;

    /* renamed from: f */
    private TextView f9906f;

    /* renamed from: g */
    private TextView f9907g;

    /* renamed from: h */
    private TextView f9908h;

    /* renamed from: i */
    private TextView f9909i;

    /* renamed from: j */
    private TextView f9910j;

    /* renamed from: k */
    private RelativeLayout f9911k;

    /* renamed from: l */
    private RelativeLayout f9912l;

    /* renamed from: m */
    private RelativeLayout f9913m;

    /* renamed from: n */
    private RelativeLayout f9914n;

    /* renamed from: o */
    private RelativeLayout f9915o;

    /* renamed from: p */
    private RelativeLayout f9916p;

    /* renamed from: q */
    private FrameLayout f9917q;

    /* renamed from: r */
    private CustomRoundImageView f9918r;

    /* renamed from: s */
    private CustomRoundImageView f9919s;

    /* renamed from: t */
    private ImageView f9920t;

    /* renamed from: u */
    private ImageView f9921u;

    /* renamed from: v */
    private ImageView f9922v;

    /* renamed from: w */
    private VideoView f9923w;

    /* renamed from: x */
    private View f9924x;

    /* renamed from: y */
    private View f9925y;

    /* renamed from: z */
    private boolean f9926z = false;

    /* renamed from: A */
    private boolean f9878A = false;

    /* renamed from: D */
    private boolean f9881D = false;

    /* renamed from: I */
    private boolean f9886I = true;

    /* renamed from: U */
    private boolean f9898U = true;

    static {
        StubApp.interface11(8109);
    }

    /* renamed from: A */
    private void m49734A() {
        try {
            if (this.f9923w != null && this.f9879B) {
                if (this.f9914n.getVisibility() == 0) {
                    this.f9882E = 0;
                } else {
                    this.f9882E = this.f9923w.getCurrentPosition();
                }
                this.f9923w.pause();
            }
            ShakeUtil shakeUtil = this.f9894Q;
            if (shakeUtil != null) {
                shakeUtil.m50111b();
            }
            EulerAngleUtil eulerAngleUtil = this.f9896S;
            if (eulerAngleUtil != null) {
                eulerAngleUtil.m50176b();
            }
            CountDownTimer countDownTimer = this.f9885H;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f9885H = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: x */
    private void m49681x() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null || (scrollClick = buyerBean.getScrollClick()) == null) {
                return;
            }
            ScrollUtil scrollUtil = new ScrollUtil(this, scrollClick, this.f9892O.getSpaceId(), this.f9891N);
            this.f9895R = scrollUtil;
            if (this.f9926z) {
                scrollUtil.m50146a(this.f9916p);
            } else {
                scrollUtil.m50146a(this.f9915o);
            }
            this.f9895R.m50147a(this.f9911k, new ScrollUtil.InterfaceC2770a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.8
                @Override // com.beizi.p051ad.p052a.p053a.ScrollUtil.InterfaceC2770a
                /* renamed from: a */
                public void mo49675a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    LogUtil.m49046a("BeiZisAd", "handleScrollViewContent scroll");
                    BeiZiInterstitialActivity.this.m49727a(str, str2, str3, str4, str5, str6, str7, str8, 1);
                }

                @Override // com.beizi.p051ad.p052a.p053a.ScrollUtil.InterfaceC2770a
                /* renamed from: b */
                public void mo49674b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (BeiZiInterstitialActivity.this.f9897T == null || !BeiZiInterstitialActivity.this.f9897T.m50159a()) {
                        return;
                    }
                    LogUtil.m49046a("BeiZisAd", "handleScrollViewContent scroll click");
                    BeiZiInterstitialActivity.this.m49727a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: y */
    private void m49680y() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null || (eulerAngleRule = buyerBean.getEulerAngleRule()) == null) {
                return;
            }
            EulerAngleUtil eulerAngleUtil = new EulerAngleUtil(this, eulerAngleRule, this.f9892O.getSpaceId(), this.f9891N);
            this.f9896S = eulerAngleUtil;
            if (this.f9926z) {
                eulerAngleUtil.m50185a(this.f9916p);
            } else {
                eulerAngleUtil.m50185a(this.f9915o);
            }
            this.f9896S.m50182a(new EulerAngleUtil.InterfaceC2762a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.9
                @Override // com.beizi.p051ad.p052a.p053a.EulerAngleUtil.InterfaceC2762a
                /* renamed from: a */
                public void mo49673a() {
                    LogUtil.m49046a("BeiZisAd", "handleEulerAngleViewContent click");
                    BeiZiInterstitialActivity.this.m49727a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: z */
    private void m49679z() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            FullScreenClickUtil fullScreenClickUtil = new FullScreenClickUtil(this, fullScreenClick, this.f9891N);
            this.f9897T = fullScreenClickUtil;
            fullScreenClickUtil.m50157a(this.f9911k, new FullScreenClickUtil.InterfaceC2764a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.10
                @Override // com.beizi.p051ad.p052a.p053a.FullScreenClickUtil.InterfaceC2764a
                /* renamed from: a */
                public void mo49678a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    LogUtil.m49046a("BeiZisAd", "handleFullScreenClickContent click");
                    BeiZiInterstitialActivity.this.m49727a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f9901a;
            if (interstitialAdViewImpl != null) {
                interstitialAdViewImpl.setAdImplementation(null);
            }
            RegionClickUtil regionClickUtil = this.f9893P;
            if (regionClickUtil != null) {
                regionClickUtil.m50154a();
            }
            this.f9893P = null;
            ShakeUtil shakeUtil = this.f9894Q;
            if (shakeUtil != null) {
                shakeUtil.m50106c();
            }
            this.f9894Q = null;
            EulerAngleUtil eulerAngleUtil = this.f9896S;
            if (eulerAngleUtil != null) {
                eulerAngleUtil.m50172c();
            }
            this.f9896S = null;
            ScrollUtil scrollUtil = this.f9895R;
            if (scrollUtil != null) {
                scrollUtil.m50148a();
            }
            this.f9895R = null;
            FullScreenClickUtil fullScreenClickUtil = this.f9897T;
            if (fullScreenClickUtil != null) {
                fullScreenClickUtil.m50155b();
            }
            this.f9897T = null;
            Timer timer = this.f9899V;
            if (timer != null) {
                timer.cancel();
            }
            this.f9899V = null;
            TimerTask timerTask = this.f9900W;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.f9900W = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m49734A();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m49689t();
    }

    /* renamed from: c */
    private void m49723c() {
        try {
            InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE;
            this.f9901a = interstitialAdViewImpl;
            AdSpacesBean.BuyerBean adBuyerBean = interstitialAdViewImpl.getAdBuyerBean();
            this.f9892O = adBuyerBean;
            if (adBuyerBean == null) {
                return;
            }
            if (adBuyerBean.getTemplate() == 1) {
                this.f9926z = true;
            } else {
                this.f9926z = false;
            }
            ServerResponse serverResponse = this.f9901a.serverResponse;
            this.f9902b = serverResponse;
            if (serverResponse == null) {
                return;
            }
            this.f9891N = serverResponse.getAdId();
            boolean isVideo = this.f9902b.isVideo();
            this.f9879B = isVideo;
            if (isVideo) {
                this.f9890M = this.f9902b.getVideoUrl();
            } else {
                this.f9890M = this.f9902b.getImageUrl();
            }
            this.f9887J = this.f9902b.getAppIcon();
            this.f9883F = this.f9902b.isAutoClose();
            this.f9884G = this.f9902b.getMaxTimer();
            this.f9888K = this.f9902b.getTitle();
            this.f9889L = this.f9902b.getSubTitle();
            this.f9878A = this.f9902b.isMuted() ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m49721d() {
        RelativeLayout.LayoutParams layoutParams;
        double d;
        double d2;
        RelativeLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        try {
            int dip2px = ViewUtil.dip2px(this, 10.0f);
            ShapeUtil.setViewBackGround(this.f9903c, "#FFFFFF", 0, (String) null, dip2px);
            int dip2px2 = ViewUtil.dip2px(this, 49.0f);
            int dip2px3 = ViewUtil.dip2px(this, 19.0f);
            int dip2px4 = ViewUtil.dip2px(this, 8.0f);
            int dip2px5 = ViewUtil.dip2px(this, 52.0f);
            TextView textView = this.f9906f;
            if (textView != null) {
                ShapeUtil.setViewBackGround(textView, "#66303030", 0, (String) null, dip2px);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f9906f.getLayoutParams();
                layoutParams4.width = dip2px2;
                layoutParams4.height = dip2px3;
                layoutParams4.setMargins(dip2px4, dip2px4, 0, 0);
                layoutParams4.addRule(17);
                this.f9906f.setLayoutParams(layoutParams4);
            }
            ImageView imageView = this.f9920t;
            if (imageView != null && this.f9879B) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.width = dip2px3;
                layoutParams5.height = dip2px3;
                layoutParams5.setMargins(0, dip2px4, dip2px, 0);
                this.f9920t.setLayoutParams(layoutParams5);
            }
            LinearLayout linearLayout = this.f9904d;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams6.width = dip2px5;
                layoutParams6.height = dip2px3;
                layoutParams6.setMargins(0, dip2px4, dip2px4, 0);
                this.f9904d.setLayoutParams(layoutParams6);
                ShapeUtil.setViewBackGround(this.f9904d, "#66303030", 0, (String) null, dip2px);
            }
            TextView textView2 = this.f9907g;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = dip2px3;
                layoutParams7.height = dip2px3;
                this.f9907g.setLayoutParams(layoutParams7);
                ShapeUtil.setViewBackGround(this.f9907g, "#66303030", 0, (String) null, dip2px * 2);
            }
            ImageView imageView2 = this.f9921u;
            if (imageView2 != null) {
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams8.width = dip2px3;
                layoutParams8.height = dip2px3;
                layoutParams8.setMargins(0, dip2px4, dip2px4, 0);
                this.f9921u.setLayoutParams(layoutParams8);
            }
            int m49024i = SystemUtil.m49024i(this);
            int m49023j = SystemUtil.m49023j(this);
            double d3 = m49024i;
            Double.isNaN(d3);
            int i = (int) (0.65d * d3);
            int dip2px6 = ViewUtil.dip2px(this, 5.0f);
            if (this.f9926z) {
                Double.isNaN(d3);
                i = (int) (d3 * 0.85d);
                dip2px6 = ViewUtil.dip2px(this, 10.0f);
                this.f9916p.setVisibility(0);
                RelativeLayout relativeLayout = this.f9916p;
                if (relativeLayout != null && (layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams()) != null) {
                    layoutParams3.width = i - (dip2px6 * 3);
                    layoutParams3.height = -2;
                    if (!TextUtils.isEmpty(this.f9887J) && TextUtils.isEmpty(this.f9888K) && TextUtils.isEmpty(this.f9889L)) {
                        layoutParams3.setMargins(0, dip2px6, 0, ViewUtil.dip2px(this, 5.0f));
                    } else {
                        double d4 = dip2px6;
                        Double.isNaN(d4);
                        layoutParams3.setMargins(0, (int) (d4 * 1.5d), 0, ViewUtil.dip2px(this, 5.0f));
                    }
                    this.f9916p.setLayoutParams(layoutParams3);
                }
            } else {
                this.f9915o.setVisibility(0);
                RelativeLayout relativeLayout2 = this.f9915o;
                if (relativeLayout2 != null && (layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams()) != null) {
                    layoutParams.width = i;
                    layoutParams.height = -2;
                    layoutParams.setMargins(0, dip2px6 * 3, 0, 0);
                    this.f9915o.setLayoutParams(layoutParams);
                }
            }
            LinearLayout linearLayout2 = this.f9903c;
            if (linearLayout2 != null && (layoutParams2 = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams()) != null) {
                layoutParams2.width = i;
                layoutParams2.height = -2;
                this.f9903c.setLayoutParams(layoutParams2);
                this.f9903c.setPadding(dip2px6, dip2px6, dip2px6, dip2px6);
            }
            RelativeLayout relativeLayout3 = this.f9913m;
            if (relativeLayout3 != null) {
                int i2 = i - (dip2px6 * 2);
                if (this.f9926z) {
                    d = i2;
                    d2 = 0.56d;
                    Double.isNaN(d);
                } else {
                    d = i2;
                    d2 = 1.78d;
                    Double.isNaN(d);
                }
                int i3 = (int) (d * d2);
                double d5 = m49023j;
                Double.isNaN(d5);
                if (i3 > 0.7d * d5) {
                    Double.isNaN(d5);
                    i3 = (int) (d5 * 0.5d);
                }
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) relativeLayout3.getLayoutParams();
                if (layoutParams9 != null) {
                    layoutParams9.width = i2;
                    layoutParams9.height = i3;
                    this.f9913m.setLayoutParams(layoutParams9);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private boolean m49719e() {
        if (this.f9879B) {
            return true;
        }
        return this.f9883F && this.f9884G > 0;
    }

    /* renamed from: f */
    private void m49717f() {
        try {
            if (!m49719e()) {
                this.f9904d.setVisibility(8);
                this.f9921u.setVisibility(0);
                return;
            }
            this.f9904d.setVisibility(0);
            this.f9921u.setVisibility(8);
            this.f9904d.measure(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m49715g() {
        try {
            this.f9885H = null;
            int i = this.f9884G;
            TextView textView = this.f9907g;
            if (textView != null) {
                try {
                    String charSequence = textView.getText().toString();
                    if (!TextUtils.isEmpty(charSequence) && !"0".equals(charSequence)) {
                        i = Integer.parseInt(charSequence);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f9907g.setText(String.valueOf(i));
            }
            CountDownTimer countDownTimer = new CountDownTimer(i * 1000, 1000L) { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    try {
                        LogUtil.m49046a("BeiZisAd", "onFinish");
                        if (!BeiZiInterstitialActivity.this.f9883F || BeiZiInterstitialActivity.this.f9884G <= 0) {
                            return;
                        }
                        BeiZiInterstitialActivity.this.m49695q();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    try {
                        int i2 = (int) ((j / 1000) + 1);
                        if (BeiZiInterstitialActivity.this.f9907g != null) {
                            BeiZiInterstitialActivity.this.f9907g.setText(String.valueOf(i2));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
            this.f9885H = countDownTimer;
            countDownTimer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: h */
    private void m49713h() {
        try {
            if (!this.f9879B && this.f9918r != null && !TextUtils.isEmpty(this.f9890M)) {
                this.f9918r.setVisibility(0);
                ImageManager.with(null).getBitmap(this.f9890M, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.12
                    @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                    public void onBitmapLoadFailed() {
                        BeiZiInterstitialActivity.this.finish();
                    }

                    @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                    public void onBitmapLoaded(Bitmap bitmap) {
                        try {
                            if (BeiZiInterstitialActivity.this.f9918r != null) {
                                if (BeiZiInterstitialActivity.this.f9913m != null) {
                                    BeiZiInterstitialActivity.this.f9913m.measure(0, 0);
                                    ViewGroup.LayoutParams layoutParams = BeiZiInterstitialActivity.this.f9918r.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.width = BeiZiInterstitialActivity.this.f9913m.getMeasuredWidth();
                                        layoutParams.height = BeiZiInterstitialActivity.this.f9913m.getMeasuredHeight();
                                        BeiZiInterstitialActivity.this.f9918r.setLayoutParams(layoutParams);
                                    }
                                }
                                BeiZiInterstitialActivity.this.f9918r.setRectRadius(ViewUtil.dip2px(BeiZiInterstitialActivity.this, 6.0f));
                                BeiZiInterstitialActivity.this.f9918r.setBackground(new BitmapDrawable(ImageUtil.blurBitmap(BeiZiInterstitialActivity.this, bitmap, 20.0f)));
                                BeiZiInterstitialActivity.this.f9918r.setImageBitmap(bitmap);
                                BeiZiInterstitialActivity.this.m49699o();
                                BeiZiInterstitialActivity.this.m49687u();
                                BeiZiInterstitialActivity.this.m49693r();
                                if (!BeiZiInterstitialActivity.this.f9883F || BeiZiInterstitialActivity.this.f9884G <= 0) {
                                    return;
                                }
                                BeiZiInterstitialActivity.this.m49715g();
                            }
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

    /* renamed from: i */
    private void m49711i() {
        AdSpacesBean.ComplainBean complain;
        TextView textView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null || (complain = buyerBean.getComplain()) == null || complain.getOpen() != 1 || (textView = this.f9906f) == null) {
                return;
            }
            textView.setVisibility(0);
            this.f9906f.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiInterstitialActivity.this.m49709j();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m49709j() {
        try {
            m49734A();
            ComplaintDialog.Builder builder = new ComplaintDialog.Builder(this);
            builder.setDialogItemCallback(new ComplaintDialog.DialogItemCallback() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.14
                @Override // com.beizi.p051ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                public void onDialogCloseClick() {
                    BeiZiInterstitialActivity.this.m49689t();
                }

                @Override // com.beizi.p051ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                public void onDialogItemClick(String str) {
                    try {
                        AdDispatcher adDispatcher = BeiZiInterstitialActivity.this.f9901a.getAdDispatcher();
                        if (adDispatcher == null) {
                            return;
                        }
                        adDispatcher.mo49217a(str);
                        adDispatcher.mo49214b();
                        BeiZiInterstitialActivity.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            builder.create().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m49707k() {
        try {
            if (this.f9902b == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f9887J)) {
                View view = this.f9924x;
                if (view != null) {
                    view.setVisibility(8);
                }
                CustomRoundImageView customRoundImageView = this.f9919s;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(8);
                    return;
                }
                return;
            }
            int dip2px = ViewUtil.dip2px(this, 20.0f);
            CustomRoundImageView customRoundImageView2 = this.f9919s;
            if (customRoundImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customRoundImageView2.getLayoutParams();
                int i = dip2px * 2;
                layoutParams.width = i;
                layoutParams.height = i;
                this.f9919s.setLayoutParams(layoutParams);
                this.f9919s.setVisibility(0);
            }
            View view2 = this.f9924x;
            if (view2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = dip2px;
                this.f9924x.setLayoutParams(layoutParams2);
                this.f9924x.setVisibility(0);
            }
            ImageManager.with(null).getBitmap(this.f9887J, new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.15
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    try {
                        if (BeiZiInterstitialActivity.this.f9919s != null) {
                            BeiZiInterstitialActivity.this.f9919s.setImageBitmap(bitmap);
                        }
                        BeiZiInterstitialActivity.this.f9919s.setRectRadius(ViewUtil.dip2px(BeiZiInterstitialActivity.this, 6.0f));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[Catch: Exception -> 0x0122, TryCatch #0 {Exception -> 0x0122, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:9:0x001f, B:11:0x0027, B:13:0x002f, B:15:0x0045, B:17:0x004d, B:19:0x005c, B:18:0x0055, B:20:0x0061, B:21:0x0067, B:22:0x006c, B:24:0x0070, B:26:0x0078, B:28:0x0094, B:31:0x00a7, B:32:0x00ac, B:29:0x009e, B:33:0x00b2, B:34:0x00b7, B:36:0x00bb, B:38:0x00bf, B:39:0x00c3, B:41:0x00c7, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:48:0x00e5, B:50:0x00f8, B:52:0x0100, B:54:0x0108, B:56:0x0117, B:55:0x0111, B:8:0x001a), top: B:61:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[Catch: Exception -> 0x0122, TryCatch #0 {Exception -> 0x0122, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:9:0x001f, B:11:0x0027, B:13:0x002f, B:15:0x0045, B:17:0x004d, B:19:0x005c, B:18:0x0055, B:20:0x0061, B:21:0x0067, B:22:0x006c, B:24:0x0070, B:26:0x0078, B:28:0x0094, B:31:0x00a7, B:32:0x00ac, B:29:0x009e, B:33:0x00b2, B:34:0x00b7, B:36:0x00bb, B:38:0x00bf, B:39:0x00c3, B:41:0x00c7, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:48:0x00e5, B:50:0x00f8, B:52:0x0100, B:54:0x0108, B:56:0x0117, B:55:0x0111, B:8:0x001a), top: B:61:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb A[Catch: Exception -> 0x0122, TryCatch #0 {Exception -> 0x0122, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:9:0x001f, B:11:0x0027, B:13:0x002f, B:15:0x0045, B:17:0x004d, B:19:0x005c, B:18:0x0055, B:20:0x0061, B:21:0x0067, B:22:0x006c, B:24:0x0070, B:26:0x0078, B:28:0x0094, B:31:0x00a7, B:32:0x00ac, B:29:0x009e, B:33:0x00b2, B:34:0x00b7, B:36:0x00bb, B:38:0x00bf, B:39:0x00c3, B:41:0x00c7, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:48:0x00e5, B:50:0x00f8, B:52:0x0100, B:54:0x0108, B:56:0x0117, B:55:0x0111, B:8:0x001a), top: B:61:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3 A[Catch: Exception -> 0x0122, TryCatch #0 {Exception -> 0x0122, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:9:0x001f, B:11:0x0027, B:13:0x002f, B:15:0x0045, B:17:0x004d, B:19:0x005c, B:18:0x0055, B:20:0x0061, B:21:0x0067, B:22:0x006c, B:24:0x0070, B:26:0x0078, B:28:0x0094, B:31:0x00a7, B:32:0x00ac, B:29:0x009e, B:33:0x00b2, B:34:0x00b7, B:36:0x00bb, B:38:0x00bf, B:39:0x00c3, B:41:0x00c7, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:48:0x00e5, B:50:0x00f8, B:52:0x0100, B:54:0x0108, B:56:0x0117, B:55:0x0111, B:8:0x001a), top: B:61:0x0000 }] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49705l() {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.activity.BeiZiInterstitialActivity.m49705l():void");
    }

    /* renamed from: m */
    private void m49703m() {
        try {
            if (this.f9879B && this.f9923w != null && !TextUtils.isEmpty(this.f9890M)) {
                RelativeLayout relativeLayout = this.f9913m;
                if (relativeLayout != null) {
                    ShapeUtil.setViewBackGround(relativeLayout, "#000000", 0, (String) null, ViewUtil.dip2px(this, 6.0f));
                }
                ImageView imageView = this.f9920t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.f9878A) {
                        this.f9920t.setImageResource(C2750R.C2752drawable.voice_on);
                    } else {
                        this.f9920t.setImageResource(C2750R.C2752drawable.voice_off);
                    }
                }
                RelativeLayout relativeLayout2 = this.f9914n;
                if (relativeLayout2 != null) {
                    ShapeUtil.setViewBackGround(relativeLayout2, "#66303030", 0, (String) null, ViewUtil.dip2px(this, 6.0f));
                    this.f9914n.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (BeiZiInterstitialActivity.this.f9914n != null) {
                                    BeiZiInterstitialActivity.this.f9914n.setVisibility(8);
                                }
                                if (BeiZiInterstitialActivity.this.f9923w != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiInterstitialActivity.this.f9880C.seekTo(0L, 3);
                                    }
                                    BeiZiInterstitialActivity.this.f9923w.start();
                                }
                                int duration = BeiZiInterstitialActivity.this.f9880C.getDuration() / 1000;
                                if (BeiZiInterstitialActivity.this.f9907g != null) {
                                    BeiZiInterstitialActivity.this.f9907g.setText(String.valueOf(duration));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                if (this.f9922v != null) {
                    int dip2px = ViewUtil.dip2px(this, 54.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9922v.getLayoutParams();
                    layoutParams.width = dip2px;
                    layoutParams.height = dip2px;
                    this.f9922v.setLayoutParams(layoutParams);
                }
                this.f9923w.setVisibility(0);
                VideoCacheManager.with().getCacheVideo(this, this.f9890M, new VideoCacheManager.VideoLoadedListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.17
                    @Override // com.beizi.p051ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoadFailed() {
                        BeiZiInterstitialActivity.this.finish();
                    }

                    @Override // com.beizi.p051ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoaded(String str) {
                        try {
                            LogUtil.m49046a("BeiZisAd", "onVideoLoaded: 加载成功");
                            BeiZiInterstitialActivity.this.f9923w.setVideoPath(str);
                            BeiZiInterstitialActivity.this.f9923w.requestFocus();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.f9923w.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.18
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        LogUtil.m49046a("BeiZisAd", "onCompletion: 播放完成");
                        try {
                            BeiZiInterstitialActivity.this.f9882E = 0;
                            if (BeiZiInterstitialActivity.this.f9914n != null) {
                                BeiZiInterstitialActivity.this.f9914n.setVisibility(0);
                            }
                            if (!BeiZiInterstitialActivity.this.f9883F || BeiZiInterstitialActivity.this.f9884G <= 0) {
                                if (BeiZiInterstitialActivity.this.f9883F) {
                                    BeiZiInterstitialActivity.this.m49695q();
                                } else if (BeiZiInterstitialActivity.this.f9907g != null) {
                                    BeiZiInterstitialActivity.this.f9907g.setText("0");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.f9923w.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.19
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            BeiZiInterstitialActivity.this.f9880C = mediaPlayer;
                            LogUtil.m49046a("BeiZisAd", "onPrepared: 准备完成");
                            if (BeiZiInterstitialActivity.this.f9878A) {
                                BeiZiInterstitialActivity.this.f9880C.setVolume(0.0f, 1.0f);
                            } else {
                                BeiZiInterstitialActivity.this.f9880C.setVolume(0.0f, 0.0f);
                            }
                            if (BeiZiInterstitialActivity.this.f9923w != null) {
                                if (BeiZiInterstitialActivity.this.f9882E > 0) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiInterstitialActivity.this.f9880C.seekTo(BeiZiInterstitialActivity.this.f9882E, 3);
                                    }
                                } else if (Build.VERSION.SDK_INT >= 26) {
                                    BeiZiInterstitialActivity.this.f9880C.seekTo(2L, 3);
                                }
                                if (BeiZiInterstitialActivity.this.f9914n != null && BeiZiInterstitialActivity.this.f9914n.getVisibility() == 8) {
                                    BeiZiInterstitialActivity.this.f9923w.start();
                                }
                            }
                            if (BeiZiInterstitialActivity.this.f9898U) {
                                if (!BeiZiInterstitialActivity.this.f9883F || BeiZiInterstitialActivity.this.f9884G <= 0) {
                                    int duration = mediaPlayer.getDuration() / 1000;
                                    if (BeiZiInterstitialActivity.this.f9907g != null) {
                                        BeiZiInterstitialActivity.this.f9907g.setText(String.valueOf(duration));
                                    }
                                }
                                BeiZiInterstitialActivity.this.m49701n();
                                BeiZiInterstitialActivity.this.m49699o();
                                BeiZiInterstitialActivity.this.m49687u();
                                BeiZiInterstitialActivity.this.m49693r();
                            }
                            BeiZiInterstitialActivity.this.f9898U = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.f9923w.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.2
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        return false;
                    }
                });
                if (this.f9883F && this.f9884G > 0) {
                    m49715g();
                } else {
                    m49733a();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        r6.width = r7;
        r6.height = r8;
        r9.f9923w.setLayoutParams(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m49701n() {
        /*
            r9 = this;
            android.widget.VideoView r0 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.RelativeLayout r0 = r9.f9913m     // Catch: java.lang.Exception -> L9f
            int r0 = r0.getWidth()     // Catch: java.lang.Exception -> L9f
            android.widget.RelativeLayout r1 = r9.f9913m     // Catch: java.lang.Exception -> L9f
            int r1 = r1.getHeight()     // Catch: java.lang.Exception -> L9f
            android.widget.VideoView r2 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            r3 = 0
            r2.measure(r3, r3)     // Catch: java.lang.Exception -> L9f
            android.widget.VideoView r2 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            int r2 = r2.getMeasuredWidth()     // Catch: java.lang.Exception -> L9f
            android.widget.VideoView r4 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            int r4 = r4.getMeasuredHeight()     // Catch: java.lang.Exception -> L9f
            double r5 = (double) r2
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r7
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r5 = r5 / r7
            float r5 = (float) r5
            android.widget.VideoView r6 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()     // Catch: java.lang.Exception -> L9f
            r7 = -2
            r8 = -1
            if (r2 < r0) goto L3e
        L3b:
            r7 = -1
            r8 = -2
            goto L46
        L3e:
            if (r4 <= r1) goto L41
            goto L46
        L41:
            int r0 = r0 - r2
            int r1 = r1 - r4
            if (r0 > r1) goto L46
            goto L3b
        L46:
            if (r6 == 0) goto L51
            r6.width = r7     // Catch: java.lang.Exception -> L9f
            r6.height = r8     // Catch: java.lang.Exception -> L9f
            android.widget.VideoView r0 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            r0.setLayoutParams(r6)     // Catch: java.lang.Exception -> L9f
        L51:
            r0 = 1057971241(0x3f0f5c29, float:0.56)
            boolean r1 = r9.f9926z     // Catch: java.lang.Exception -> L9f
            if (r1 == 0) goto L5b
            r0 = 1071896330(0x3fe3d70a, float:1.78)
        L5b:
            float r0 = r0 - r5
            float r1 = java.lang.Math.abs(r0)     // Catch: java.lang.Exception -> L9f
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto La3
            float r0 = java.lang.Math.abs(r0)     // Catch: java.lang.Exception -> L9f
            double r0 = (double) r0     // Catch: java.lang.Exception -> L9f
            r4 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 > 0) goto La3
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L9f
            r1 = 21
            r2 = 1086324736(0x40c00000, float:6.0)
            if (r0 < r1) goto L90
            android.widget.VideoView r0 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            com.beizi.ad.a.a.f r1 = new com.beizi.ad.a.a.f     // Catch: java.lang.Exception -> L9f
            int r4 = com.beizi.p051ad.internal.utilities.ViewUtil.dip2px(r9, r2)     // Catch: java.lang.Exception -> L9f
            float r4 = (float) r4     // Catch: java.lang.Exception -> L9f
            r1.<init>(r4)     // Catch: java.lang.Exception -> L9f
            r0.setOutlineProvider(r1)     // Catch: java.lang.Exception -> L9f
            android.widget.VideoView r0 = r9.f9923w     // Catch: java.lang.Exception -> L9f
            r1 = 1
            r0.setClipToOutline(r1)     // Catch: java.lang.Exception -> L9f
        L90:
            android.widget.RelativeLayout r0 = r9.f9913m     // Catch: java.lang.Exception -> L9f
            if (r0 == 0) goto La3
            java.lang.String r1 = "#FFFFFF"
            r4 = 0
            int r2 = com.beizi.p051ad.internal.utilities.ViewUtil.dip2px(r9, r2)     // Catch: java.lang.Exception -> L9f
            com.beizi.p051ad.internal.utilities.ShapeUtil.setViewBackGround(r0, r1, r3, r4, r2)     // Catch: java.lang.Exception -> L9f
            goto La3
        L9f:
            r0 = move-exception
            r0.printStackTrace()
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.activity.BeiZiInterstitialActivity.m49701n():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m49699o() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(this, this.f9902b.getLogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(this, this.f9902b.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            if (this.f9917q != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int dip2px = ViewUtil.dip2px(this, 8.0f);
                layoutParams2.setMargins(0, 0, dip2px, dip2px);
                this.f9917q.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    private void m49697p() {
        RelativeLayout relativeLayout = this.f9912l;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        BeiZiInterstitialActivity.this.m49695q();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ImageView imageView = this.f9920t;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiInterstitialActivity.this.f9878A) {
                            BeiZiInterstitialActivity.this.f9920t.setImageResource(C2750R.C2752drawable.voice_off);
                            if (BeiZiInterstitialActivity.this.f9880C != null) {
                                BeiZiInterstitialActivity.this.f9880C.setVolume(0.0f, 0.0f);
                            }
                        } else {
                            BeiZiInterstitialActivity.this.f9920t.setImageResource(C2750R.C2752drawable.voice_on);
                            if (BeiZiInterstitialActivity.this.f9880C != null) {
                                BeiZiInterstitialActivity.this.f9880C.setVolume(0.0f, 1.0f);
                            }
                        }
                        BeiZiInterstitialActivity beiZiInterstitialActivity = BeiZiInterstitialActivity.this;
                        beiZiInterstitialActivity.f9878A = !beiZiInterstitialActivity.f9878A;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m49695q() {
        CountDownTimer countDownTimer = this.f9885H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f9885H = null;
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9901a;
        if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null) {
            this.f9901a.getAdDispatcher().mo49214b();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m49693r() {
        ServerResponse serverResponse;
        AdDispatcher adDispatcher;
        try {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f9901a;
            if (interstitialAdViewImpl == null || (serverResponse = interstitialAdViewImpl.serverResponse) == null || (adDispatcher = interstitialAdViewImpl.getAdDispatcher()) == null) {
                return;
            }
            AdParameters adParameters = this.f9901a.getAdParameters();
            serverResponse.handleView(this.f9903c, adParameters != null ? adParameters.m49519a() : null);
            adDispatcher.mo49222a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: s */
    private void m49691s() {
        try {
            ServerResponse serverResponse = this.f9902b;
            if (serverResponse == null) {
                return;
            }
            int interactType = serverResponse.getInteractType();
            if (interactType == 2 || interactType == 5) {
                this.f9908h.setVisibility(0);
                final String apkName = this.f9902b.getApkName();
                String appDeveloper = this.f9902b.getAppDeveloper();
                String appVersion = this.f9902b.getAppVersion();
                String appPermissionsUrl = this.f9902b.getAppPermissionsUrl();
                final String appPermissionsDesc = !TextUtils.isEmpty(appPermissionsUrl) ? appPermissionsUrl : this.f9902b.getAppPermissionsDesc();
                final String appPrivacyUrl = this.f9902b.getAppPrivacyUrl();
                final String appintro = this.f9902b.getAppintro();
                this.f9908h.setText(Html.fromHtml("应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                this.f9908h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(BeiZiInterstitialActivity.this, DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", apkName);
                            intent.putExtra("privacy_content_key", appPrivacyUrl);
                            intent.putExtra(TTDelegateActivity.PERMISSION_CONTENT_KEY, appPermissionsDesc);
                            intent.putExtra("intro_content_key", appintro);
                            BeiZiInterstitialActivity.this.startActivity(intent);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m49689t() {
        try {
            VideoView videoView = this.f9923w;
            if (videoView != null && this.f9879B) {
                videoView.resume();
            }
            ShakeUtil shakeUtil = this.f9894Q;
            if (shakeUtil != null) {
                shakeUtil.m50123a();
            }
            EulerAngleUtil eulerAngleUtil = this.f9896S;
            if (eulerAngleUtil != null) {
                eulerAngleUtil.m50188a();
            }
            if (!this.f9886I && this.f9883F && this.f9884G > 0) {
                m49715g();
            }
            this.f9886I = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m49687u() {
        try {
            if (this.f9892O == null) {
                return;
            }
            m49679z();
            m49685v();
            m49683w();
            m49681x();
            m49680y();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: v */
    private void m49685v() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            RegionClickUtil regionClickUtil = new RegionClickUtil(this, regionalClickView, this.f9891N);
            this.f9893P = regionClickUtil;
            if (this.f9926z) {
                regionClickUtil.m50153a(this.f9916p);
            } else {
                regionClickUtil.m50153a(this.f9915o);
            }
            this.f9893P.m50152a(new RegionClickUtil.InterfaceC2766a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.6
                @Override // com.beizi.p051ad.p052a.p053a.RegionClickUtil.InterfaceC2766a
                /* renamed from: a */
                public void mo49677a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    LogUtil.m49046a("BeiZisAd", "handleRegionalClickViewContent click");
                    BeiZiInterstitialActivity.this.m49727a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: w */
    private void m49683w() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.f9892O;
            if (buyerBean == null || (shakeView = buyerBean.getShakeView()) == null) {
                return;
            }
            ShakeUtil shakeUtil = new ShakeUtil(this, shakeView, this.f9892O.getSpaceId(), this.f9891N);
            this.f9894Q = shakeUtil;
            if (this.f9926z) {
                shakeUtil.m50118a(this.f9916p);
            } else {
                shakeUtil.m50118a(this.f9915o);
            }
            this.f9894Q.m50115a(new ShakeUtil.InterfaceC2775a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.7
                @Override // com.beizi.p051ad.p052a.p053a.ShakeUtil.InterfaceC2775a
                /* renamed from: a */
                public void mo49676a() {
                    LogUtil.m49046a("BeiZisAd", "handleShakeViewContent click");
                    BeiZiInterstitialActivity.this.m49727a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m49726b() {
        this.f9911k = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_content_rl);
        this.f9903c = (LinearLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_container_ll);
        this.f9906f = (TextView) findViewById(C2750R.C2753id.beizi_interstitial_ad_complain_tv);
        this.f9912l = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_close_container_rl);
        this.f9904d = (LinearLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_close_text_container_ll);
        this.f9921u = (ImageView) findViewById(C2750R.C2753id.beizi_interstitial_ad_close_iv);
        this.f9907g = (TextView) findViewById(C2750R.C2753id.beizi_interstitial_ad_countdown_tv);
        this.f9913m = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_material_container_rl);
        this.f9914n = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_video_replay_container_rl);
        this.f9922v = (ImageView) findViewById(C2750R.C2753id.beizi_interstitial_ad_video_replay_iv);
        this.f9917q = (FrameLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_logo_container_fl);
        this.f9918r = (CustomRoundImageView) findViewById(C2750R.C2753id.beizi_interstitial_ad_img_iv);
        this.f9923w = (VideoView) findViewById(C2750R.C2753id.beizi_interstitial_ad_video_vv);
        this.f9919s = (CustomRoundImageView) findViewById(C2750R.C2753id.beizi_interstitial_ad_app_icon_iv);
        this.f9924x = findViewById(C2750R.C2753id.beizi_interstitial_ad_divide_view);
        this.f9920t = (ImageView) findViewById(C2750R.C2753id.beizi_interstitial_ad_voice_iv);
        this.f9905e = (LinearLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_title_container_ll);
        this.f9909i = (TextView) findViewById(C2750R.C2753id.beizi_interstitial_ad_title_tv);
        this.f9910j = (TextView) findViewById(C2750R.C2753id.beizi_interstitial_ad_subtitle_tv);
        this.f9925y = findViewById(C2750R.C2753id.beizi_interstitial_ad_title_divider_view);
        this.f9916p = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_interaction_container_landscape_rl);
        this.f9915o = (RelativeLayout) findViewById(C2750R.C2753id.beizi_interstitial_ad_interaction_container_portrait_rl);
        this.f9908h = (TextView) findViewById(C2750R.C2753id.beizi_interstitial_ad_app_download_info_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49727a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        InterstitialAdViewImpl interstitialAdViewImpl;
        ServerResponse serverResponse;
        AdDispatcher adDispatcher;
        try {
            if (this.f9901a == null || !hasWindowFocus() || (serverResponse = (interstitialAdViewImpl = this.f9901a).serverResponse) == null || (adDispatcher = interstitialAdViewImpl.getAdDispatcher()) == null) {
                return;
            }
            ClickPositionModel clickPositionModel = new ClickPositionModel();
            clickPositionModel.m49862a(str);
            clickPositionModel.m49854e(str5);
            clickPositionModel.m49860b(str2);
            clickPositionModel.m49852f(str6);
            clickPositionModel.m49858c(str3);
            clickPositionModel.m49850g(str7);
            clickPositionModel.m49856d(str4);
            clickPositionModel.m49848h(str8);
            serverResponse.setOpenInNativeBrowser(true);
            serverResponse.handleClick(this.f9903c, clickPositionModel, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.f9881D, this.f9901a.getAdParameters().m49519a(), i);
            this.f9881D = true;
            adDispatcher.mo49212d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m49733a() {
        try {
            if (this.f9899V == null) {
                this.f9899V = new Timer();
            }
            if (this.f9900W == null) {
                this.f9900W = new TimerTask() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.11
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (BeiZiInterstitialActivity.this.f9923w == null || !BeiZiInterstitialActivity.this.f9923w.isPlaying()) {
                                return;
                            }
                            BeiZiInterstitialActivity.this.runOnUiThread(new Runnable() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int duration;
                                    try {
                                        if (BeiZiInterstitialActivity.this.f9907g == null || (duration = (BeiZiInterstitialActivity.this.f9923w.getDuration() - BeiZiInterstitialActivity.this.f9923w.getCurrentPosition()) / 1000) <= 0) {
                                            return;
                                        }
                                        BeiZiInterstitialActivity.this.f9907g.setText(String.valueOf(duration));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.f9899V.scheduleAtFixedRate(this.f9900W, 0L, 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
