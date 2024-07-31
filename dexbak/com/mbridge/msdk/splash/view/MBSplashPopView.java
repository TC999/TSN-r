package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.SameImageTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.p505d.SplashShowListenerImpl;
import com.mbridge.msdk.splash.p506e.SplashReport;
import com.mbridge.msdk.widget.custom.p517b.FastBlurUtil;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* renamed from: c */
    private static final AtomicInteger f32024c = new AtomicInteger(1);

    /* renamed from: a */
    View.OnClickListener f32025a;

    /* renamed from: b */
    View.OnClickListener f32026b;

    /* renamed from: d */
    private String f32027d;

    /* renamed from: e */
    private String f32028e;

    /* renamed from: f */
    private int f32029f;

    /* renamed from: g */
    private CampaignEx f32030g;

    /* renamed from: h */
    private SplashShowListenerImpl f32031h;

    /* renamed from: i */
    private ImageView f32032i;

    /* renamed from: j */
    private ImageView f32033j;

    /* renamed from: k */
    private ImageView f32034k;

    /* renamed from: l */
    private ImageView f32035l;

    /* renamed from: m */
    private TextView f32036m;

    /* renamed from: n */
    private TextView f32037n;

    /* renamed from: o */
    private TextView f32038o;

    /* renamed from: p */
    private int f32039p;

    /* renamed from: q */
    private Handler f32040q;

    /* renamed from: r */
    private boolean f32041r;

    /* renamed from: s */
    private CommonClickControl f32042s;

    /* renamed from: t */
    private Runnable f32043t;

    /* renamed from: com.mbridge.msdk.splash.view.MBSplashPopView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11633a {

        /* renamed from: a */
        private String f32057a;

        /* renamed from: b */
        private String f32058b;

        /* renamed from: c */
        private int f32059c;

        /* renamed from: d */
        private CampaignEx f32060d;

        public C11633a(String str, String str2, int i, CampaignEx campaignEx) {
            this.f32057a = str;
            this.f32058b = str2;
            this.f32059c = i;
            this.f32060d = campaignEx;
        }

        /* renamed from: a */
        public final String m20954a() {
            return this.f32057a;
        }

        /* renamed from: b */
        public final String m20953b() {
            return this.f32058b;
        }

        /* renamed from: c */
        public final int m20952c() {
            return this.f32059c;
        }

        /* renamed from: d */
        public final CampaignEx m20951d() {
            return this.f32060d;
        }
    }

    public MBSplashPopView(Context context, C11633a c11633a, SplashShowListenerImpl splashShowListenerImpl) {
        super(context);
        this.f32029f = 1;
        this.f32039p = -1;
        this.f32040q = new Handler();
        this.f32041r = false;
        this.f32043t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f32038o != null) {
                    if (MBSplashPopView.this.f32039p == 0) {
                        MBSplashPopView.this.f32039p = -1;
                        MBSplashPopView.this.m20963g();
                        MBSplashPopView.this.f32040q.removeCallbacks(MBSplashPopView.this.f32043t);
                        if (MBSplashPopView.this.f32031h != null) {
                            MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.m20957l(MBSplashPopView.this);
                    MBSplashPopView.this.f32038o.setText(String.valueOf(MBSplashPopView.this.f32039p));
                    MBSplashPopView.this.f32040q.postDelayed(MBSplashPopView.this.f32043t, 1000L);
                }
            }
        };
        this.f32025a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.m20978a(mBSplashPopView, mBSplashPopView.f32030g);
                }
            }
        };
        this.f32026b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32039p <= 0 && MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 4);
                }
            }
        };
        if (c11633a != null) {
            this.f32028e = c11633a.m20953b();
            this.f32027d = c11633a.m20954a();
            this.f32029f = c11633a.m20952c();
            this.f32030g = c11633a.m20951d();
            this.f32031h = splashShowListenerImpl;
            m20982a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f32024c;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ int m20957l(MBSplashPopView mBSplashPopView) {
        int i = mBSplashPopView.f32039p;
        mBSplashPopView.f32039p = i - 1;
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SplashShowListenerImpl splashShowListenerImpl = this.f32031h;
        if (splashShowListenerImpl != null) {
            splashShowListenerImpl.m21070a(new MBridgeIds(this.f32027d, this.f32028e), getWidth(), getHeight(), this.f32029f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f32041r = true;
        if (this.f32038o != null) {
            this.f32040q.removeCallbacks(this.f32043t);
        }
    }

    public void reStartCountDown() {
        if (this.f32041r) {
            this.f32041r = false;
            int i = this.f32039p;
            if (i != -1 && i != 0) {
                TextView textView = this.f32038o;
                if (textView != null) {
                    textView.setText(String.valueOf(i));
                    this.f32040q.postDelayed(this.f32043t, 1000L);
                    return;
                }
                return;
            }
            m20963g();
        }
    }

    public void release() {
        try {
            this.f32040q.removeCallbacks(this.f32043t);
            this.f32043t = null;
            detachAllViewsFromParent();
            this.f32030g = null;
            this.f32031h = null;
        } catch (Exception e) {
            SameLogTool.m21733d("MBSplashPopView", e.getMessage());
        }
    }

    public void setPopViewType(C11633a c11633a, SplashShowListenerImpl splashShowListenerImpl) {
        if (c11633a != null) {
            this.f32028e = c11633a.m20953b();
            this.f32027d = c11633a.m20954a();
            this.f32029f = c11633a.m20952c();
            this.f32030g = c11633a.m20951d();
            this.f32031h = splashShowListenerImpl;
            m20982a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public void startCountDown() {
        this.f32040q.removeCallbacks(this.f32043t);
        CampaignEx campaignEx = this.f32030g;
        if (campaignEx == null || this.f32029f != 1) {
            return;
        }
        int flbSkipTime = campaignEx.getFlbSkipTime();
        if (flbSkipTime > 0) {
            this.f32039p = flbSkipTime;
            TextView textView = this.f32038o;
            if (textView != null) {
                textView.setText(String.valueOf(flbSkipTime));
                this.f32040q.postDelayed(this.f32043t, 1000L);
                return;
            }
            return;
        }
        m20963g();
    }

    /* renamed from: c */
    private void m20971c() {
        int m22001b = SameTool.m22001b(getContext(), 4.0f);
        this.f32032i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 28.0f), SameTool.m22001b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f32032i.setId(generateViewId());
        this.f32032i.setLayoutParams(layoutParams);
        this.f32032i.setPadding(m22001b, m22001b, m22001b, m22001b);
        this.f32032i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        m20976a(this.f32030g.getIconUrl(), false);
        TextView textView = new TextView(getContext());
        this.f32036m = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f32032i.getId());
        layoutParams2.addRule(6, this.f32032i.getId());
        layoutParams2.addRule(8, this.f32032i.getId());
        layoutParams2.leftMargin = SameTool.m22001b(getContext(), 4.0f);
        layoutParams2.rightMargin = SameTool.m22001b(getContext(), 40.0f);
        this.f32036m.setLayoutParams(layoutParams2);
        this.f32036m.setGravity(16);
        this.f32036m.setTextSize(10.0f);
        this.f32036m.setSelected(true);
        this.f32036m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f32036m.setMarqueeRepeatLimit(-1);
        this.f32036m.setSingleLine(true);
        this.f32036m.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f32036m.setText(this.f32030g.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", MBSDKContext.m22865f().m22869d()));
        addView(this.f32032i);
        addView(this.f32036m);
        m20965f();
        setOnClickListener(this.f32025a);
    }

    /* renamed from: d */
    private void m20969d() {
        int m22001b = SameTool.m22001b(getContext(), 4.0f);
        this.f32032i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 50.0f), SameTool.m22001b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f32032i.setId(generateViewId());
        this.f32032i.setLayoutParams(layoutParams);
        this.f32032i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f32032i.setPadding(m22001b, m22001b, m22001b, m22001b);
        m20976a(this.f32030g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f32032i.getId());
        layoutParams2.addRule(6, this.f32032i.getId());
        layoutParams2.addRule(8, this.f32032i.getId());
        layoutParams2.leftMargin = SameTool.m22001b(getContext(), 8.0f);
        layoutParams2.rightMargin = SameTool.m22001b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f32036m = textView;
        textView.setId(generateViewId());
        this.f32036m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f32036m.setGravity(16);
        this.f32036m.setTextSize(12.0f);
        this.f32036m.setSelected(true);
        this.f32036m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f32036m.setMarqueeRepeatLimit(-1);
        this.f32036m.setSingleLine(true);
        this.f32036m.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f32036m.setText(this.f32030g.getAppName());
        TextView textView2 = new TextView(getContext());
        this.f32037n = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.f32036m.getId());
        layoutParams3.addRule(3, this.f32036m.getId());
        layoutParams3.topMargin = SameTool.m22001b(getContext(), 4.0f);
        layoutParams3.rightMargin = SameTool.m22001b(getContext(), 36.0f);
        this.f32037n.setGravity(16);
        this.f32037n.setLayoutParams(layoutParams3);
        this.f32037n.setTextSize(8.0f);
        this.f32037n.setTextColor(-10066330);
        this.f32037n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f32037n.setMarqueeRepeatLimit(-1);
        this.f32037n.setSelected(true);
        this.f32037n.setSingleLine(true);
        this.f32037n.setText(this.f32030g.getAppDesc());
        relativeLayout.addView(this.f32036m);
        relativeLayout.addView(this.f32037n);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", MBSDKContext.m22865f().m22869d()));
        addView(this.f32032i);
        addView(relativeLayout);
        m20965f();
        setOnClickListener(this.f32025a);
    }

    /* renamed from: e */
    private void m20967e() {
        this.f32034k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, SameTool.m22001b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.f32034k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f32034k.setId(generateViewId());
        this.f32034k.setLayoutParams(layoutParams);
        m20977a(this.f32030g.getImageUrl());
        this.f32033j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, SameTool.m22001b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f32033j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f32033j.setId(generateViewId());
        this.f32033j.setLayoutParams(layoutParams2);
        m20972b(this.f32030g.getImageUrl());
        this.f32032i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 50.0f), SameTool.m22001b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.f32034k.getId());
        layoutParams3.topMargin = 20;
        this.f32032i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f32032i.setId(generateViewId());
        this.f32032i.setLayoutParams(layoutParams3);
        m20976a(this.f32030g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f32032i.getId());
        layoutParams4.addRule(6, this.f32032i.getId());
        layoutParams4.addRule(8, this.f32032i.getId());
        layoutParams4.leftMargin = SameTool.m22001b(getContext(), 8.0f);
        layoutParams4.rightMargin = SameTool.m22001b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f32036m = textView;
        textView.setId(generateViewId());
        this.f32036m.setGravity(16);
        this.f32036m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f32036m.setTextSize(12.0f);
        this.f32036m.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f32036m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f32036m.setMarqueeRepeatLimit(-1);
        this.f32036m.setSelected(true);
        this.f32036m.setSingleLine(true);
        this.f32036m.setText(this.f32030g.getAppName());
        TextView textView2 = new TextView(getContext());
        this.f32037n = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.f32036m.getId());
        layoutParams5.addRule(3, this.f32036m.getId());
        layoutParams5.topMargin = SameTool.m22001b(getContext(), 4.0f);
        layoutParams5.rightMargin = SameTool.m22001b(getContext(), 36.0f);
        this.f32037n.setGravity(16);
        this.f32037n.setLayoutParams(layoutParams5);
        this.f32037n.setTextSize(8.0f);
        this.f32037n.setTextColor(-10066330);
        this.f32037n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f32037n.setMarqueeRepeatLimit(-1);
        this.f32037n.setSelected(true);
        this.f32037n.setSingleLine(true);
        this.f32037n.setText(this.f32030g.getAppDesc());
        relativeLayout.addView(this.f32036m);
        relativeLayout.addView(this.f32037n);
        addView(this.f32034k);
        addView(this.f32033j);
        addView(this.f32032i);
        addView(relativeLayout);
        m20965f();
        setOnClickListener(this.f32025a);
    }

    /* renamed from: f */
    private void m20965f() {
        String str;
        int identifier;
        this.f32035l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 32.0f), SameTool.m22001b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f32032i.getId());
        this.f32035l.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            SameLogTool.m21733d("MBSplashPopView", th.getMessage());
            str = "ZH";
        }
        if (!str.toUpperCase().equals("CN") && !str.toUpperCase().equals("ZH")) {
            identifier = getResources().getIdentifier("mbridge_splash_ad_en", "drawable", MBSDKContext.m22865f().m22869d());
        } else {
            identifier = getResources().getIdentifier("mbridge_splash_ad", "drawable", MBSDKContext.m22865f().m22869d());
        }
        this.f32035l.setBackgroundResource(identifier);
        addView(this.f32035l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m20963g() {
        TextView textView = this.f32038o;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = SameTool.m22001b(getContext(), 16.0f);
            layoutParams.height = SameTool.m22001b(getContext(), 16.0f);
            this.f32038o.setLayoutParams(layoutParams);
            this.f32038o.setText("");
            this.f32038o.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", MBSDKContext.m22865f().m22869d()));
        }
    }

    /* renamed from: a */
    private void m20982a() {
        if (this.f32030g == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i = this.f32029f;
        if (i == 1) {
            m20975b();
        } else if (i == 2) {
            m20971c();
        } else if (i == 3) {
            m20969d();
        } else if (i != 4) {
        } else {
            m20967e();
        }
    }

    /* renamed from: b */
    private void m20975b() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 80.0f), SameTool.m22001b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = SameTool.m22001b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", MBSDKContext.m22865f().m22869d()));
        this.f32032i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 60.0f), SameTool.m22001b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = SameTool.m22001b(getContext(), 7.0f);
        layoutParams2.leftMargin = SameTool.m22001b(getContext(), 10.0f);
        this.f32032i.setId(generateViewId());
        this.f32032i.setLayoutParams(layoutParams2);
        this.f32032i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.f32030g;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            m20976a(this.f32030g.getIconUrl(), true);
        }
        this.f32038o = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = SameTool.m22001b(getContext(), 62.0f);
        layoutParams3.bottomMargin = SameTool.m22001b(getContext(), 70.0f);
        this.f32038o.setId(generateViewId());
        this.f32038o.setTextSize(10.0f);
        this.f32038o.setTextColor(-1);
        this.f32038o.setGravity(17);
        this.f32038o.setMinWidth(SameTool.m22001b(getContext(), 16.0f));
        this.f32038o.setMaxHeight(SameTool.m22001b(getContext(), 16.0f));
        this.f32038o.setLayoutParams(layoutParams3);
        this.f32038o.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", MBSDKContext.m22865f().m22869d()));
        addView(imageView);
        addView(this.f32038o);
        addView(this.f32032i);
        CampaignEx campaignEx2 = this.f32030g;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            m20963g();
        }
        setOnClickListener(this.f32025a);
        this.f32038o.setOnClickListener(this.f32026b);
    }

    /* renamed from: a */
    private void m20976a(String str, final boolean z) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(str, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.1
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str2, String str3) {
                SameLogTool.m21733d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                Bitmap m21740a;
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (z) {
                        if (bitmap.isRecycled()) {
                            m21740a = null;
                        } else {
                            int width = bitmap.getWidth();
                            m21740a = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
                            Canvas canvas = new Canvas(m21740a);
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            canvas.drawCircle(width / 2, width / 2, width / 2, paint);
                            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        }
                    } else {
                        m21740a = SameImageTool.m21740a(bitmap, 1, 16);
                    }
                    ImageView imageView = MBSplashPopView.this.f32032i;
                    if (m21740a != null) {
                        bitmap = m21740a;
                    }
                    imageView.setImageBitmap(bitmap);
                } catch (Throwable th) {
                    SameLogTool.m21733d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    /* renamed from: a */
    private void m20977a(String str) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(str, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.2
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str2, String str3) {
                SameLogTool.m21733d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    MBSplashPopView.this.f32034k.setImageBitmap(FastBlurUtil.m20576a(bitmap, 10));
                } catch (Throwable th) {
                    SameLogTool.m21733d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m20981a(CampaignEx campaignEx) {
        if (this.f32042s == null) {
            this.f32042s = new CommonClickControl(MBSDKContext.m22865f().m22861j(), this.f32028e);
        }
        campaignEx.setCampaignUnitId(this.f32028e);
        this.f32042s.m23094c(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            SplashReport.m21066a(MBSDKContext.m22865f().m22861j(), campaignEx);
        }
        SplashShowListenerImpl splashShowListenerImpl = this.f32031h;
        if (splashShowListenerImpl != null) {
            splashShowListenerImpl.m21067b(new MBridgeIds(this.f32027d, this.f32028e));
            this.f32031h.m21071a(new MBridgeIds(this.f32027d, this.f32028e), 6);
        }
    }

    public MBSplashPopView(Context context) {
        super(context);
        this.f32029f = 1;
        this.f32039p = -1;
        this.f32040q = new Handler();
        this.f32041r = false;
        this.f32043t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f32038o != null) {
                    if (MBSplashPopView.this.f32039p == 0) {
                        MBSplashPopView.this.f32039p = -1;
                        MBSplashPopView.this.m20963g();
                        MBSplashPopView.this.f32040q.removeCallbacks(MBSplashPopView.this.f32043t);
                        if (MBSplashPopView.this.f32031h != null) {
                            MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.m20957l(MBSplashPopView.this);
                    MBSplashPopView.this.f32038o.setText(String.valueOf(MBSplashPopView.this.f32039p));
                    MBSplashPopView.this.f32040q.postDelayed(MBSplashPopView.this.f32043t, 1000L);
                }
            }
        };
        this.f32025a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.m20978a(mBSplashPopView, mBSplashPopView.f32030g);
                }
            }
        };
        this.f32026b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32039p <= 0 && MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 4);
                }
            }
        };
        this.f32029f = 1;
        SameLogTool.m21736b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    /* renamed from: a */
    static /* synthetic */ void m20978a(MBSplashPopView mBSplashPopView, final CampaignEx campaignEx) {
        try {
            SplashReport.m21057b(campaignEx, mBSplashPopView.f32028e);
            if (campaignEx != null && campaignEx.needShowIDialog()) {
                final MBAlertDialogListener mBAlertDialogListener = new MBAlertDialogListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.7
                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                    /* renamed from: a */
                    public final void mo20509a() {
                        MBSplashPopView.this.m20981a(campaignEx);
                    }

                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                    /* renamed from: b */
                    public final void mo20508b() {
                        MBSplashPopView.this.reStartCountDown();
                    }

                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                    /* renamed from: c */
                    public final void mo20507c() {
                        mo20509a();
                    }
                };
                if (CommonClickUtil.m23074a(campaignEx) && campaignEx.needShowIDialog()) {
                    if (mBSplashPopView.f32042s == null) {
                        mBSplashPopView.f32042s = new CommonClickControl(MBSDKContext.m22865f().m22861j(), mBSplashPopView.f32028e);
                    }
                    final Context context = mBSplashPopView.getContext();
                    mBSplashPopView.getHandler().post(new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!MBSplashPopView.this.f32042s.m23099b(campaignEx)) {
                                MBSplashPopView.this.pauseCountDown();
                                Context context2 = context;
                                if (context2 != StubApp.getOrigApplicationContext(context2.getApplicationContext())) {
                                    SecondaryConfirmationManager.m21474a().m21455a("", campaignEx, context, MBSplashPopView.this.f32028e, mBAlertDialogListener);
                                    return;
                                } else {
                                    SecondaryConfirmationManager.m21474a().m21455a("", campaignEx, MBSplashPopView.this.getContext(), MBSplashPopView.this.f32028e, mBAlertDialogListener);
                                    return;
                                }
                            }
                            MBSplashPopView.this.pauseCountDown();
                            SplashReport.m21066a(MBSDKContext.m22865f().m22861j(), campaignEx);
                            if (MBSplashPopView.this.f32031h != null) {
                                MBSplashPopView.this.f32031h.m21067b(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e));
                                MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 6);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21738a("MBSplashPopView", th.getMessage());
            mBSplashPopView.reStartCountDown();
        }
        mBSplashPopView.m20981a(campaignEx);
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32029f = 1;
        this.f32039p = -1;
        this.f32040q = new Handler();
        this.f32041r = false;
        this.f32043t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f32038o != null) {
                    if (MBSplashPopView.this.f32039p == 0) {
                        MBSplashPopView.this.f32039p = -1;
                        MBSplashPopView.this.m20963g();
                        MBSplashPopView.this.f32040q.removeCallbacks(MBSplashPopView.this.f32043t);
                        if (MBSplashPopView.this.f32031h != null) {
                            MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.m20957l(MBSplashPopView.this);
                    MBSplashPopView.this.f32038o.setText(String.valueOf(MBSplashPopView.this.f32039p));
                    MBSplashPopView.this.f32040q.postDelayed(MBSplashPopView.this.f32043t, 1000L);
                }
            }
        };
        this.f32025a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.m20978a(mBSplashPopView, mBSplashPopView.f32030g);
                }
            }
        };
        this.f32026b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32039p <= 0 && MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 4);
                }
            }
        };
        this.f32029f = 1;
        SameLogTool.m21736b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32029f = 1;
        this.f32039p = -1;
        this.f32040q = new Handler();
        this.f32041r = false;
        this.f32043t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f32038o != null) {
                    if (MBSplashPopView.this.f32039p == 0) {
                        MBSplashPopView.this.f32039p = -1;
                        MBSplashPopView.this.m20963g();
                        MBSplashPopView.this.f32040q.removeCallbacks(MBSplashPopView.this.f32043t);
                        if (MBSplashPopView.this.f32031h != null) {
                            MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.m20957l(MBSplashPopView.this);
                    MBSplashPopView.this.f32038o.setText(String.valueOf(MBSplashPopView.this.f32039p));
                    MBSplashPopView.this.f32040q.postDelayed(MBSplashPopView.this.f32043t, 1000L);
                }
            }
        };
        this.f32025a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.m20978a(mBSplashPopView, mBSplashPopView.f32030g);
                }
            }
        };
        this.f32026b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32039p <= 0 && MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 4);
                }
            }
        };
        this.f32029f = 1;
        SameLogTool.m21736b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    /* renamed from: b */
    private void m20972b(String str) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(str, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.3
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str2, String str3) {
                SameLogTool.m21733d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    MBSplashPopView.this.f32033j.setImageBitmap(SameImageTool.m21740a(bitmap, 1, 16));
                } catch (Throwable th) {
                    SameLogTool.m21733d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f32029f = 1;
        this.f32039p = -1;
        this.f32040q = new Handler();
        this.f32041r = false;
        this.f32043t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f32038o != null) {
                    if (MBSplashPopView.this.f32039p == 0) {
                        MBSplashPopView.this.f32039p = -1;
                        MBSplashPopView.this.m20963g();
                        MBSplashPopView.this.f32040q.removeCallbacks(MBSplashPopView.this.f32043t);
                        if (MBSplashPopView.this.f32031h != null) {
                            MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.m20957l(MBSplashPopView.this);
                    MBSplashPopView.this.f32038o.setText(String.valueOf(MBSplashPopView.this.f32039p));
                    MBSplashPopView.this.f32040q.postDelayed(MBSplashPopView.this.f32043t, 1000L);
                }
            }
        };
        this.f32025a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.m20978a(mBSplashPopView, mBSplashPopView.f32030g);
                }
            }
        };
        this.f32026b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f32039p <= 0 && MBSplashPopView.this.f32031h != null) {
                    MBSplashPopView.this.f32031h.m21071a(new MBridgeIds(MBSplashPopView.this.f32027d, MBSplashPopView.this.f32028e), 4);
                }
            }
        };
        this.f32029f = 1;
        SameLogTool.m21736b("MBSplashPopView", "Please call setPopViewType() to init.");
    }
}
