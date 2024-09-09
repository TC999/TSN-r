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
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.confirmation.e;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.d.d;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f40775c = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f40776a;

    /* renamed from: b  reason: collision with root package name */
    View.OnClickListener f40777b;

    /* renamed from: d  reason: collision with root package name */
    private String f40778d;

    /* renamed from: e  reason: collision with root package name */
    private String f40779e;

    /* renamed from: f  reason: collision with root package name */
    private int f40780f;

    /* renamed from: g  reason: collision with root package name */
    private CampaignEx f40781g;

    /* renamed from: h  reason: collision with root package name */
    private d f40782h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f40783i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f40784j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f40785k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f40786l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f40787m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f40788n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f40789o;

    /* renamed from: p  reason: collision with root package name */
    private int f40790p;

    /* renamed from: q  reason: collision with root package name */
    private Handler f40791q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f40792r;

    /* renamed from: s  reason: collision with root package name */
    private b f40793s;

    /* renamed from: t  reason: collision with root package name */
    private Runnable f40794t;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f40808a;

        /* renamed from: b  reason: collision with root package name */
        private String f40809b;

        /* renamed from: c  reason: collision with root package name */
        private int f40810c;

        /* renamed from: d  reason: collision with root package name */
        private CampaignEx f40811d;

        public a(String str, String str2, int i4, CampaignEx campaignEx) {
            this.f40808a = str;
            this.f40809b = str2;
            this.f40810c = i4;
            this.f40811d = campaignEx;
        }

        public final String a() {
            return this.f40808a;
        }

        public final String b() {
            return this.f40809b;
        }

        public final int c() {
            return this.f40810c;
        }

        public final CampaignEx d() {
            return this.f40811d;
        }
    }

    public MBSplashPopView(Context context, a aVar, d dVar) {
        super(context);
        this.f40780f = 1;
        this.f40790p = -1;
        this.f40791q = new Handler();
        this.f40792r = false;
        this.f40794t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f40789o != null) {
                    if (MBSplashPopView.this.f40790p == 0) {
                        MBSplashPopView.this.f40790p = -1;
                        MBSplashPopView.this.g();
                        MBSplashPopView.this.f40791q.removeCallbacks(MBSplashPopView.this.f40794t);
                        if (MBSplashPopView.this.f40782h != null) {
                            MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.l(MBSplashPopView.this);
                    MBSplashPopView.this.f40789o.setText(String.valueOf(MBSplashPopView.this.f40790p));
                    MBSplashPopView.this.f40791q.postDelayed(MBSplashPopView.this.f40794t, 1000L);
                }
            }
        };
        this.f40776a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.f40781g);
                }
            }
        };
        this.f40777b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40790p <= 0 && MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 4);
                }
            }
        };
        if (aVar != null) {
            this.f40779e = aVar.b();
            this.f40778d = aVar.a();
            this.f40780f = aVar.c();
            this.f40781g = aVar.d();
            this.f40782h = dVar;
            a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i4;
        int i5;
        do {
            atomicInteger = f40775c;
            i4 = atomicInteger.get();
            i5 = i4 + 1;
            if (i5 > 16777215) {
                i5 = 1;
            }
        } while (!atomicInteger.compareAndSet(i4, i5));
        return i4;
    }

    static /* synthetic */ int l(MBSplashPopView mBSplashPopView) {
        int i4 = mBSplashPopView.f40790p;
        mBSplashPopView.f40790p = i4 - 1;
        return i4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f40782h;
        if (dVar != null) {
            dVar.a(new MBridgeIds(this.f40778d, this.f40779e), getWidth(), getHeight(), this.f40780f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f40792r = true;
        if (this.f40789o != null) {
            this.f40791q.removeCallbacks(this.f40794t);
        }
    }

    public void reStartCountDown() {
        if (this.f40792r) {
            this.f40792r = false;
            int i4 = this.f40790p;
            if (i4 != -1 && i4 != 0) {
                TextView textView = this.f40789o;
                if (textView != null) {
                    textView.setText(String.valueOf(i4));
                    this.f40791q.postDelayed(this.f40794t, 1000L);
                    return;
                }
                return;
            }
            g();
        }
    }

    public void release() {
        try {
            this.f40791q.removeCallbacks(this.f40794t);
            this.f40794t = null;
            detachAllViewsFromParent();
            this.f40781g = null;
            this.f40782h = null;
        } catch (Exception e4) {
            x.d("MBSplashPopView", e4.getMessage());
        }
    }

    public void setPopViewType(a aVar, d dVar) {
        if (aVar != null) {
            this.f40779e = aVar.b();
            this.f40778d = aVar.a();
            this.f40780f = aVar.c();
            this.f40781g = aVar.d();
            this.f40782h = dVar;
            a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public void startCountDown() {
        this.f40791q.removeCallbacks(this.f40794t);
        CampaignEx campaignEx = this.f40781g;
        if (campaignEx == null || this.f40780f != 1) {
            return;
        }
        int flbSkipTime = campaignEx.getFlbSkipTime();
        if (flbSkipTime > 0) {
            this.f40790p = flbSkipTime;
            TextView textView = this.f40789o;
            if (textView != null) {
                textView.setText(String.valueOf(flbSkipTime));
                this.f40791q.postDelayed(this.f40794t, 1000L);
                return;
            }
            return;
        }
        g();
    }

    private void c() {
        int b4 = ac.b(getContext(), 4.0f);
        this.f40783i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ac.b(getContext(), 28.0f), ac.b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f40783i.setId(generateViewId());
        this.f40783i.setLayoutParams(layoutParams);
        this.f40783i.setPadding(b4, b4, b4, b4);
        this.f40783i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.f40781g.getIconUrl(), false);
        TextView textView = new TextView(getContext());
        this.f40787m = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f40783i.getId());
        layoutParams2.addRule(6, this.f40783i.getId());
        layoutParams2.addRule(8, this.f40783i.getId());
        layoutParams2.leftMargin = ac.b(getContext(), 4.0f);
        layoutParams2.rightMargin = ac.b(getContext(), 40.0f);
        this.f40787m.setLayoutParams(layoutParams2);
        this.f40787m.setGravity(16);
        this.f40787m.setTextSize(10.0f);
        this.f40787m.setSelected(true);
        this.f40787m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f40787m.setMarqueeRepeatLimit(-1);
        this.f40787m.setSingleLine(true);
        this.f40787m.setTextColor(-16777216);
        this.f40787m.setText(this.f40781g.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        addView(this.f40783i);
        addView(this.f40787m);
        f();
        setOnClickListener(this.f40776a);
    }

    private void d() {
        int b4 = ac.b(getContext(), 4.0f);
        this.f40783i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ac.b(getContext(), 50.0f), ac.b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f40783i.setId(generateViewId());
        this.f40783i.setLayoutParams(layoutParams);
        this.f40783i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f40783i.setPadding(b4, b4, b4, b4);
        a(this.f40781g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f40783i.getId());
        layoutParams2.addRule(6, this.f40783i.getId());
        layoutParams2.addRule(8, this.f40783i.getId());
        layoutParams2.leftMargin = ac.b(getContext(), 8.0f);
        layoutParams2.rightMargin = ac.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f40787m = textView;
        textView.setId(generateViewId());
        this.f40787m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f40787m.setGravity(16);
        this.f40787m.setTextSize(12.0f);
        this.f40787m.setSelected(true);
        this.f40787m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f40787m.setMarqueeRepeatLimit(-1);
        this.f40787m.setSingleLine(true);
        this.f40787m.setTextColor(-16777216);
        this.f40787m.setText(this.f40781g.getAppName());
        TextView textView2 = new TextView(getContext());
        this.f40788n = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.f40787m.getId());
        layoutParams3.addRule(3, this.f40787m.getId());
        layoutParams3.topMargin = ac.b(getContext(), 4.0f);
        layoutParams3.rightMargin = ac.b(getContext(), 36.0f);
        this.f40788n.setGravity(16);
        this.f40788n.setLayoutParams(layoutParams3);
        this.f40788n.setTextSize(8.0f);
        this.f40788n.setTextColor(-10066330);
        this.f40788n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f40788n.setMarqueeRepeatLimit(-1);
        this.f40788n.setSelected(true);
        this.f40788n.setSingleLine(true);
        this.f40788n.setText(this.f40781g.getAppDesc());
        relativeLayout.addView(this.f40787m);
        relativeLayout.addView(this.f40788n);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        addView(this.f40783i);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f40776a);
    }

    private void e() {
        this.f40785k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ac.b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.f40785k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f40785k.setId(generateViewId());
        this.f40785k.setLayoutParams(layoutParams);
        a(this.f40781g.getImageUrl());
        this.f40784j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, ac.b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f40784j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f40784j.setId(generateViewId());
        this.f40784j.setLayoutParams(layoutParams2);
        b(this.f40781g.getImageUrl());
        this.f40783i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ac.b(getContext(), 50.0f), ac.b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.f40785k.getId());
        layoutParams3.topMargin = 20;
        this.f40783i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f40783i.setId(generateViewId());
        this.f40783i.setLayoutParams(layoutParams3);
        a(this.f40781g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f40783i.getId());
        layoutParams4.addRule(6, this.f40783i.getId());
        layoutParams4.addRule(8, this.f40783i.getId());
        layoutParams4.leftMargin = ac.b(getContext(), 8.0f);
        layoutParams4.rightMargin = ac.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f40787m = textView;
        textView.setId(generateViewId());
        this.f40787m.setGravity(16);
        this.f40787m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f40787m.setTextSize(12.0f);
        this.f40787m.setTextColor(-16777216);
        this.f40787m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f40787m.setMarqueeRepeatLimit(-1);
        this.f40787m.setSelected(true);
        this.f40787m.setSingleLine(true);
        this.f40787m.setText(this.f40781g.getAppName());
        TextView textView2 = new TextView(getContext());
        this.f40788n = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.f40787m.getId());
        layoutParams5.addRule(3, this.f40787m.getId());
        layoutParams5.topMargin = ac.b(getContext(), 4.0f);
        layoutParams5.rightMargin = ac.b(getContext(), 36.0f);
        this.f40788n.setGravity(16);
        this.f40788n.setLayoutParams(layoutParams5);
        this.f40788n.setTextSize(8.0f);
        this.f40788n.setTextColor(-10066330);
        this.f40788n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f40788n.setMarqueeRepeatLimit(-1);
        this.f40788n.setSelected(true);
        this.f40788n.setSingleLine(true);
        this.f40788n.setText(this.f40781g.getAppDesc());
        relativeLayout.addView(this.f40787m);
        relativeLayout.addView(this.f40788n);
        addView(this.f40785k);
        addView(this.f40784j);
        addView(this.f40783i);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f40776a);
    }

    private void f() {
        String str;
        int identifier;
        this.f40786l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ac.b(getContext(), 32.0f), ac.b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f40783i.getId());
        this.f40786l.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            x.d("MBSplashPopView", th.getMessage());
            str = "ZH";
        }
        if (!str.toUpperCase().equals("CN") && !str.toUpperCase().equals("ZH")) {
            identifier = getResources().getIdentifier("mbridge_splash_ad_en", "drawable", com.mbridge.msdk.foundation.controller.a.f().d());
        } else {
            identifier = getResources().getIdentifier("mbridge_splash_ad", "drawable", com.mbridge.msdk.foundation.controller.a.f().d());
        }
        this.f40786l.setBackgroundResource(identifier);
        addView(this.f40786l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.f40789o;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = ac.b(getContext(), 16.0f);
            layoutParams.height = ac.b(getContext(), 16.0f);
            this.f40789o.setLayoutParams(layoutParams);
            this.f40789o.setText("");
            this.f40789o.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        }
    }

    private void a() {
        if (this.f40781g == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i4 = this.f40780f;
        if (i4 == 1) {
            b();
        } else if (i4 == 2) {
            c();
        } else if (i4 == 3) {
            d();
        } else if (i4 != 4) {
        } else {
            e();
        }
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ac.b(getContext(), 80.0f), ac.b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = ac.b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        this.f40783i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ac.b(getContext(), 60.0f), ac.b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = ac.b(getContext(), 7.0f);
        layoutParams2.leftMargin = ac.b(getContext(), 10.0f);
        this.f40783i.setId(generateViewId());
        this.f40783i.setLayoutParams(layoutParams2);
        this.f40783i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.f40781g;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            a(this.f40781g.getIconUrl(), true);
        }
        this.f40789o = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = ac.b(getContext(), 62.0f);
        layoutParams3.bottomMargin = ac.b(getContext(), 70.0f);
        this.f40789o.setId(generateViewId());
        this.f40789o.setTextSize(10.0f);
        this.f40789o.setTextColor(-1);
        this.f40789o.setGravity(17);
        this.f40789o.setMinWidth(ac.b(getContext(), 16.0f));
        this.f40789o.setMaxHeight(ac.b(getContext(), 16.0f));
        this.f40789o.setLayoutParams(layoutParams3);
        this.f40789o.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        addView(imageView);
        addView(this.f40789o);
        addView(this.f40783i);
        CampaignEx campaignEx2 = this.f40781g;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            g();
        }
        setOnClickListener(this.f40776a);
        this.f40789o.setOnClickListener(this.f40777b);
    }

    private void a(String str, final boolean z3) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str, new c() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.1
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                x.d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                Bitmap a4;
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (z3) {
                        if (bitmap.isRecycled()) {
                            a4 = null;
                        } else {
                            int width = bitmap.getWidth();
                            a4 = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
                            Canvas canvas = new Canvas(a4);
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            canvas.drawCircle(width / 2, width / 2, width / 2, paint);
                            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        }
                    } else {
                        a4 = w.a(bitmap, 1, 16);
                    }
                    ImageView imageView = MBSplashPopView.this.f40783i;
                    if (a4 != null) {
                        bitmap = a4;
                    }
                    imageView.setImageBitmap(bitmap);
                } catch (Throwable th) {
                    x.d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str, new c() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                x.d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    MBSplashPopView.this.f40785k.setImageBitmap(com.mbridge.msdk.widget.custom.b.b.a(bitmap, 10));
                } catch (Throwable th) {
                    x.d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx) {
        if (this.f40793s == null) {
            this.f40793s = new b(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40779e);
        }
        campaignEx.setCampaignUnitId(this.f40779e);
        this.f40793s.c(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx);
        }
        d dVar = this.f40782h;
        if (dVar != null) {
            dVar.b(new MBridgeIds(this.f40778d, this.f40779e));
            this.f40782h.a(new MBridgeIds(this.f40778d, this.f40779e), 6);
        }
    }

    public MBSplashPopView(Context context) {
        super(context);
        this.f40780f = 1;
        this.f40790p = -1;
        this.f40791q = new Handler();
        this.f40792r = false;
        this.f40794t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f40789o != null) {
                    if (MBSplashPopView.this.f40790p == 0) {
                        MBSplashPopView.this.f40790p = -1;
                        MBSplashPopView.this.g();
                        MBSplashPopView.this.f40791q.removeCallbacks(MBSplashPopView.this.f40794t);
                        if (MBSplashPopView.this.f40782h != null) {
                            MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.l(MBSplashPopView.this);
                    MBSplashPopView.this.f40789o.setText(String.valueOf(MBSplashPopView.this.f40790p));
                    MBSplashPopView.this.f40791q.postDelayed(MBSplashPopView.this.f40794t, 1000L);
                }
            }
        };
        this.f40776a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.f40781g);
                }
            }
        };
        this.f40777b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40790p <= 0 && MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 4);
                }
            }
        };
        this.f40780f = 1;
        x.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    static /* synthetic */ void a(MBSplashPopView mBSplashPopView, final CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.splash.e.a.b(campaignEx, mBSplashPopView.f40779e);
            if (campaignEx != null && campaignEx.needShowIDialog()) {
                final com.mbridge.msdk.widget.dialog.a aVar = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.7
                    @Override // com.mbridge.msdk.widget.dialog.a
                    public final void a() {
                        MBSplashPopView.this.a(campaignEx);
                    }

                    @Override // com.mbridge.msdk.widget.dialog.a
                    public final void b() {
                        MBSplashPopView.this.reStartCountDown();
                    }

                    @Override // com.mbridge.msdk.widget.dialog.a
                    public final void c() {
                        a();
                    }
                };
                if (com.mbridge.msdk.click.c.a(campaignEx) && campaignEx.needShowIDialog()) {
                    if (mBSplashPopView.f40793s == null) {
                        mBSplashPopView.f40793s = new b(com.mbridge.msdk.foundation.controller.a.f().j(), mBSplashPopView.f40779e);
                    }
                    final Context context = mBSplashPopView.getContext();
                    mBSplashPopView.getHandler().post(new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!MBSplashPopView.this.f40793s.b(campaignEx)) {
                                MBSplashPopView.this.pauseCountDown();
                                Context context2 = context;
                                if (context2 != StubApp.getOrigApplicationContext(context2.getApplicationContext())) {
                                    e.a().a("", campaignEx, context, MBSplashPopView.this.f40779e, aVar);
                                    return;
                                } else {
                                    e.a().a("", campaignEx, MBSplashPopView.this.getContext(), MBSplashPopView.this.f40779e, aVar);
                                    return;
                                }
                            }
                            MBSplashPopView.this.pauseCountDown();
                            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx);
                            if (MBSplashPopView.this.f40782h != null) {
                                MBSplashPopView.this.f40782h.b(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e));
                                MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 6);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Throwable th) {
            x.a("MBSplashPopView", th.getMessage());
            mBSplashPopView.reStartCountDown();
        }
        mBSplashPopView.a(campaignEx);
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40780f = 1;
        this.f40790p = -1;
        this.f40791q = new Handler();
        this.f40792r = false;
        this.f40794t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f40789o != null) {
                    if (MBSplashPopView.this.f40790p == 0) {
                        MBSplashPopView.this.f40790p = -1;
                        MBSplashPopView.this.g();
                        MBSplashPopView.this.f40791q.removeCallbacks(MBSplashPopView.this.f40794t);
                        if (MBSplashPopView.this.f40782h != null) {
                            MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.l(MBSplashPopView.this);
                    MBSplashPopView.this.f40789o.setText(String.valueOf(MBSplashPopView.this.f40790p));
                    MBSplashPopView.this.f40791q.postDelayed(MBSplashPopView.this.f40794t, 1000L);
                }
            }
        };
        this.f40776a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.f40781g);
                }
            }
        };
        this.f40777b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40790p <= 0 && MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 4);
                }
            }
        };
        this.f40780f = 1;
        x.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f40780f = 1;
        this.f40790p = -1;
        this.f40791q = new Handler();
        this.f40792r = false;
        this.f40794t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f40789o != null) {
                    if (MBSplashPopView.this.f40790p == 0) {
                        MBSplashPopView.this.f40790p = -1;
                        MBSplashPopView.this.g();
                        MBSplashPopView.this.f40791q.removeCallbacks(MBSplashPopView.this.f40794t);
                        if (MBSplashPopView.this.f40782h != null) {
                            MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.l(MBSplashPopView.this);
                    MBSplashPopView.this.f40789o.setText(String.valueOf(MBSplashPopView.this.f40790p));
                    MBSplashPopView.this.f40791q.postDelayed(MBSplashPopView.this.f40794t, 1000L);
                }
            }
        };
        this.f40776a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.f40781g);
                }
            }
        };
        this.f40777b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40790p <= 0 && MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 4);
                }
            }
        };
        this.f40780f = 1;
        x.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    private void b(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str, new c() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.3
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                x.d("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    MBSplashPopView.this.f40784j.setImageBitmap(w.a(bitmap, 1, 16));
                } catch (Throwable th) {
                    x.d("MBSplashPopView", th.getMessage());
                }
            }
        });
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f40780f = 1;
        this.f40790p = -1;
        this.f40791q = new Handler();
        this.f40792r = false;
        this.f40794t = new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBSplashPopView.this.f40789o != null) {
                    if (MBSplashPopView.this.f40790p == 0) {
                        MBSplashPopView.this.f40790p = -1;
                        MBSplashPopView.this.g();
                        MBSplashPopView.this.f40791q.removeCallbacks(MBSplashPopView.this.f40794t);
                        if (MBSplashPopView.this.f40782h != null) {
                            MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 5);
                            return;
                        }
                        return;
                    }
                    MBSplashPopView.l(MBSplashPopView.this);
                    MBSplashPopView.this.f40789o.setText(String.valueOf(MBSplashPopView.this.f40790p));
                    MBSplashPopView.this.f40791q.postDelayed(MBSplashPopView.this.f40794t, 1000L);
                }
            }
        };
        this.f40776a = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.f40781g);
                }
            }
        };
        this.f40777b = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.MBSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBSplashPopView.this.f40790p <= 0 && MBSplashPopView.this.f40782h != null) {
                    MBSplashPopView.this.f40782h.a(new MBridgeIds(MBSplashPopView.this.f40778d, MBSplashPopView.this.f40779e), 4);
                }
            }
        };
        this.f40780f = 1;
        x.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }
}
