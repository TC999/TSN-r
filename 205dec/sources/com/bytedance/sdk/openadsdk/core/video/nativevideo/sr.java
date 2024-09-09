package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.sr.w;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.widget.fp;
import com.bytedance.sdk.openadsdk.core.widget.ys;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends ux {
    private View au;

    /* renamed from: b  reason: collision with root package name */
    private TextView f35156b;
    private final Rect be;
    private SeekBar bj;
    private TextView bm;
    private boolean bs;
    private View bw;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35157e;
    private final Rect eb;
    private float eu;
    private int fm;

    /* renamed from: g  reason: collision with root package name */
    private int f35158g;
    private final Rect ge;
    private boolean gp;
    private TextView gw;

    /* renamed from: h  reason: collision with root package name */
    private int f35159h;
    private final Rect iw;
    private float kk;
    private float kn;
    private int lf;
    private ColorStateList lw;

    /* renamed from: m  reason: collision with root package name */
    private TextView f35160m;
    private ImageView mt;
    private ys mu;
    private boolean ng;
    private int oh;
    private int ok;
    private TextView oo;
    private final n ox;
    private ImageView pr;
    private final Rect qy;
    private float rh;
    private ColorStateList ta;
    private int te;
    private final View.OnTouchListener tl;
    private View up;
    private ImageView vc;
    private ImageView wo;
    private TextView wx;

    /* renamed from: x  reason: collision with root package name */
    private TextView f35161x;
    private int xg;
    private boolean xu;
    private boolean zg;
    private ColorStateList zr;
    private float zt;

    public sr(Context context, View view, boolean z3, EnumSet<w.c> enumSet, me meVar, com.bykv.vk.openvk.component.video.api.sr.xv xvVar, boolean z4) {
        super(context, view, z3, enumSet, meVar, xvVar, z4, null);
        this.ox = new n(this);
        this.xu = false;
        this.ng = false;
        this.ok = 0;
        this.f35159h = 0;
        this.oh = 0;
        this.fm = 0;
        this.te = 0;
        this.ge = new Rect();
        this.be = new Rect();
        this.f35158g = 0;
        this.lf = 0;
        this.xg = 0;
        this.mu = null;
        this.f35157e = false;
        this.tl = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.7

            /* renamed from: w  reason: collision with root package name */
            private float f35169w;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x3 = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        sr.this.f35157e = Math.abs(this.f35169w - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.f35169w = x3;
                }
                return false;
            }
        };
        this.eb = new Rect();
        this.qy = new Rect();
        this.iw = new Rect();
        this.f35180n = StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext());
        sr(z4);
        this.f35173c = view;
        this.f35176i = z3;
        ys ysVar = new ys(this);
        this.mu = ysVar;
        ysVar.c(this.f35176i);
        DisplayMetrics displayMetrics = this.f35180n.getResources().getDisplayMetrics();
        this.lf = displayMetrics.widthPixels;
        this.xg = displayMetrics.heightPixels;
        this.ls = enumSet == null ? EnumSet.noneOf(w.c.class) : enumSet;
        this.eq = xvVar;
        this.gb = meVar;
        sr(8);
        c(context, this.f35173c, meVar);
        sr();
        fp();
    }

    private void ba() {
        DisplayMetrics displayMetrics = this.f35180n.getResources().getDisplayMetrics();
        TextView textView = this.f35156b;
        if (textView != null) {
            this.kk = textView.getTextSize();
            this.f35156b.setTextSize(2, 14.0f);
            ColorStateList textColors = this.f35156b.getTextColors();
            this.zr = textColors;
            if (textColors != null) {
                this.f35156b.setTextColor(i.r(this.f35180n, "tt_ssxinzi15"));
            }
            this.zt = this.f35156b.getAlpha();
            this.f35156b.setAlpha(0.85f);
            this.f35156b.setShadowLayer(0.0f, xk.xv(this.f35180n, 0.5f), xk.xv(this.f35180n, 0.5f), i.r(this.f35180n, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.f35156b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.eb.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                xk.w(this.f35156b, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.eb.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.eb.bottom);
            }
        }
        TextView textView2 = this.bm;
        if (textView2 != null) {
            this.rh = textView2.getTextSize();
            this.bm.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.bm.getTextColors();
            this.lw = textColors2;
            if (textColors2 != null) {
                this.bm.setTextColor(i.r(this.f35180n, "tt_ssxinzi15"));
            }
            this.kn = this.bm.getAlpha();
            this.bm.setAlpha(0.85f);
            this.bm.setShadowLayer(0.0f, xk.xv(this.f35180n, 0.5f), xk.xv(this.f35180n, 0.5f), i.r(this.f35180n, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.bm.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.qy.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                Rect rect = this.qy;
                xk.w(this.bm, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.wo;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.iw.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.wo;
                Rect rect2 = this.iw;
                xk.w(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.iw.bottom);
            }
        }
        ImageView imageView3 = this.wo;
        if (imageView3 != null) {
            imageView3.setImageDrawable(i.xv(this.f35180n, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.f35160m;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.ta = textColors3;
            if (textColors3 != null) {
                this.f35160m.setTextColor(i.r(this.f35180n, "tt_ssxinzi15"));
            }
            this.eu = this.f35160m.getAlpha();
            this.f35160m.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.f35160m.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.be.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                Rect rect3 = this.qy;
                xk.w(this.f35160m, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.bw;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.f35158g = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.bw.setLayoutParams(layoutParams5);
            this.bw.setBackground(i.xv(this.f35180n, "tt_shadow_fullscreen_top"));
        }
        w(this.bs, true);
    }

    private boolean eq() {
        me meVar = this.gb;
        if (meVar == null) {
            return false;
        }
        int m4 = meVar.m();
        return m4 == 1 || m4 == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable w(int i4, String str) {
        Context context = ls.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int ux = xk.ux(context, i4);
        shapeDrawable.setIntrinsicWidth(ux);
        shapeDrawable.setIntrinsicHeight(ux);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(xk.ux(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    private void y() {
        TextView textView = this.f35156b;
        if (textView != null) {
            textView.setTextSize(0, this.kk);
            ColorStateList colorStateList = this.zr;
            if (colorStateList != null) {
                this.f35156b.setTextColor(colorStateList);
            }
            this.f35156b.setAlpha(this.zt);
            this.f35156b.setShadowLayer(xk.xv(this.f35180n, 1.0f), 0.0f, 0.0f, i.r(this.f35180n, "tt_video_shadow_color"));
            TextView textView2 = this.f35156b;
            Rect rect = this.eb;
            xk.w(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.bm;
        if (textView3 != null) {
            textView3.setTextSize(0, this.rh);
            ColorStateList colorStateList2 = this.lw;
            if (colorStateList2 != null) {
                this.bm.setTextColor(colorStateList2);
            }
            this.bm.setAlpha(this.kn);
            this.bm.setShadowLayer(xk.xv(this.f35180n, 1.0f), 0.0f, 0.0f, i.r(this.f35180n, "tt_video_shadow_color"));
            TextView textView4 = this.bm;
            Rect rect2 = this.qy;
            xk.w(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.wo;
        if (imageView != null) {
            Rect rect3 = this.iw;
            xk.w(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.wo;
        if (imageView2 != null) {
            imageView2.setImageDrawable(i.xv(this.f35180n, "tt_enlarge_video"));
        }
        TextView textView5 = this.f35160m;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.ta;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.f35160m.setAlpha(this.eu);
            TextView textView6 = this.f35160m;
            Rect rect4 = this.qy;
            xk.w(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.bw;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.f35158g;
            this.bw.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.bw.setBackground(gradientDrawable);
        }
        w(this.bs, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.openadsdk.core.widget.fp.w
    public void a() {
        c(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public boolean bk() {
        return this.f35182q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void ev() {
        xk.ux(this.sr);
        xk.ux(this.up);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void f() {
        this.ox.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void gd() {
        this.bj.setProgress(0);
        this.bj.setSecondaryProgress(0);
        this.ys.setProgress(0);
        this.ys.setSecondaryProgress(0);
        this.bm.setText(i.c(this.f35180n, "tt_00_00"));
        this.f35156b.setText(i.c(this.f35180n, "tt_00_00"));
        sr(8);
        if (z()) {
            this.f35187w.setVisibility(8);
        }
        ImageView imageView = this.f35174f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        sr(8);
        xk.c(this.au, 8);
        xk.c(this.ev, 8);
        xk.c((View) this.gd, 8);
        xk.c(this.f35181p, 8);
        xk.c((View) this.f35178k, 8);
        xk.c((View) this.f35171a, 8);
        xk.c((View) this.bk, 8);
        fp fpVar = this.ck;
        if (fpVar != null) {
            fpVar.c(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public boolean k() {
        return this.f35176i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.openadsdk.core.widget.fp.w
    public boolean p() {
        return this.xu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void r() {
        me meVar;
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            q();
            return;
        }
        xk.f(this.sr);
        xk.f(this.ux);
        xk.ux(this.up);
        if (this.f35174f != null && (meVar = this.gb) != null && !TextUtils.isEmpty(ng.w(meVar))) {
            xk.f(this.f35174f);
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.gb)).c(this.f35174f);
        }
        if (this.xv.getVisibility() == 0) {
            xk.c((View) this.xv, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void sr() {
        super.sr();
        this.mu.c(this.f35173c);
        int i4 = 8;
        xk.c((View) this.pr, (this.f35176i || this.ls.contains(w.c.hideCloseBtn)) ? 8 : 0);
        this.pr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.xv(srVar, view);
                }
            }
        });
        xk.c((View) this.wx, (!this.f35176i || this.ls.contains(w.c.alwayShowBackBtn)) ? 0 : 0);
        this.wx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.sr(srVar, view);
                }
            }
        });
        this.vc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.ux(srVar, view);
                }
            }
        });
        this.mt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sr.this.w(false, true);
                sr.this.ev();
                sr.this.r();
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.f(srVar, view);
                }
            }
        });
        this.wo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.w(srVar, view);
                }
            }
        });
        this.bj.setThumbOffset(0);
        this.bj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i5, boolean z3) {
                if (sr.this.i()) {
                    sr srVar = sr.this;
                    srVar.f35190z.c(srVar, i5, z3);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!sr.this.xu && sr.this.f35180n != null) {
                    seekBar.setThumb(sr.w(22, "#1E000000"));
                }
                if (sr.this.i()) {
                    seekBar.setThumbOffset(0);
                    sr srVar = sr.this;
                    srVar.f35190z.w(srVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!sr.this.xu && sr.this.f35180n != null) {
                    seekBar.setThumb(sr.w(15, "#1E000000"));
                }
                if (sr.this.i()) {
                    seekBar.setThumbOffset(0);
                    sr srVar = sr.this;
                    srVar.f35190z.c(srVar, seekBar.getProgress());
                }
            }
        });
        this.bj.setOnTouchListener(this.tl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.openadsdk.core.widget.ys.c
    public void t() {
        a();
        xv(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void ux() {
        this.ox.removeMessages(1);
        this.ox.sendMessageDelayed(this.ox.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public boolean xv(int i4) {
        SeekBar seekBar = this.bj;
        return seekBar != null && i4 > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.openadsdk.core.widget.ys.c
    public boolean ys() {
        fp fpVar = this.ck;
        return fpVar != null && fpVar.c();
    }

    private void f(boolean z3) {
        if (z3) {
            ba();
        } else {
            y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bykv.vk.openvk.component.video.api.sr.w
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void c(Object obj, WeakReference weakReference, boolean z3) {
        c((me) obj, (WeakReference<Context>) weakReference, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void xv(boolean z3) {
        TextView textView = this.f35161x;
        if (textView != null) {
            if (this.f35176i) {
                xk.c((View) textView, 8);
            } else {
                xk.c((View) textView, z3 ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(Context context, View view, me meVar) {
        super.c(context, view, meVar);
        this.wx = (TextView) view.findViewById(2114387761);
        this.pr = (ImageView) view.findViewById(2114387677);
        this.bw = view.findViewById(2114387604);
        this.vc = (ImageView) view.findViewById(2114387901);
        this.f35161x = (TextView) view.findViewById(2114387731);
        this.f35160m = (TextView) view.findViewById(2114387705);
        this.gw = (TextView) view.findViewById(2114387849);
        this.up = view.findViewById(2114387826);
        this.mt = (ImageView) view.findViewById(2114387617);
        this.oo = (TextView) view.findViewById(2114387863);
        this.bj = (SeekBar) view.findViewById(2114387875);
        this.bm = (TextView) view.findViewById(2114387667);
        this.f35156b = (TextView) view.findViewById(2114387814);
        this.au = view.findViewById(2114387627);
        this.wo = (ImageView) view.findViewById(2114387660);
        this.f35183r = (TTViewStub) view.findViewById(2114387745);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void w(boolean z3) {
        int i4 = p() ? this.xg : this.ia;
        int i5 = p() ? this.lf : this.f35184s;
        if (this.f35186u <= 0 || this.fz <= 0 || i4 <= 0) {
            return;
        }
        if (!k() && !p() && !this.ls.contains(w.c.fixedSize)) {
            i5 = this.f35180n.getResources().getDimensionPixelSize(i.f(this.f35180n, "tt_video_container_maxheight"));
        }
        int i6 = this.fz;
        int i7 = this.f35186u;
        int i8 = (int) (i7 * ((i4 * 1.0f) / i6));
        if (i8 > i5) {
            i4 = (int) (i6 * ((i5 * 1.0f) / i7));
        } else {
            i5 = i8;
        }
        if (!z3 && !p()) {
            i4 = this.ia;
            i5 = this.f35184s;
        }
        this.f35187w.c(i4, i5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void sr(int i4) {
        this.f35177j = i4;
        xk.c(this.f35173c, i4);
        if (i4 != 0) {
            this.zg = false;
        } else if (this.gp) {
            this.zg = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(String str) {
        TextView textView = this.f35161x;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f35160m;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void w(int i4) {
        View view = this.au;
        if (view != null && view.getVisibility() == 0) {
            xk.c((View) this.ys, 8);
            return;
        }
        xk.c((View) this.ys, 0);
        this.bj.setProgress(i4);
        this.ys.setProgress(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(long j4, long j5) {
        this.bm.setText(com.bykv.vk.openvk.component.video.c.ux.c.c(j5));
        this.f35156b.setText(com.bykv.vk.openvk.component.video.c.ux.c.c(j4));
        this.bj.setProgress(com.bykv.vk.openvk.component.video.c.ux.c.c(j4, j5));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void w(ViewGroup viewGroup) {
        View view;
        a.f("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.f35173c) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.xu = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35173c.getLayoutParams();
        marginLayoutParams.width = this.oh;
        marginLayoutParams.height = this.fm;
        marginLayoutParams.leftMargin = this.f35159h;
        marginLayoutParams.topMargin = this.ok;
        this.f35173c.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.te);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.ge;
            xk.w(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        w(true);
        this.wo.setImageDrawable(i.xv(this.f35180n, "tt_enlarge_video"));
        this.bj.setThumb(w(15, "#1E000000"));
        this.bj.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.c.ux.c.c(this.f35173c, true);
        f(this.xu);
        xk.c(this.bw, 8);
        if (this.ls.contains(w.c.alwayShowBackBtn)) {
            xk.c((View) this.wx, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bykv.vk.openvk.component.video.api.sr.w
    public void c() {
        c(false, this.f35176i);
        gb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(long j4) {
        this.f35156b.setText(com.bykv.vk.openvk.component.video.c.ux.c.c(j4));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(me meVar, WeakReference<Context> weakReference, boolean z3) {
        me meVar2;
        if (meVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            c(ls.getContext(), this.f35173c);
            s();
            return;
        }
        c(this.f35173c, ls.getContext());
        c(false, this.f35176i);
        xk.c(this.ev, 0);
        xk.c((View) this.gd, 0);
        xk.c(this.f35181p, 0);
        if (this.gd != null && (meVar2 = this.gb) != null && !TextUtils.isEmpty(ng.w(meVar2))) {
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.gb)).c(this.gd);
        }
        xk.c((View) this.f35185t, 0);
        xk.c((View) this.f35178k, 8);
        xk.c((View) this.f35171a, 8);
        xk.c((View) this.bk, 8);
        xk.c(this.f35185t, i.c(this.f35180n, "tt_video_dial_replay"));
        xk.c(this.f35185t, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.sr.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = sr.this.f35190z;
                if (cVar != null) {
                    cVar.c();
                }
            }
        }, "video_ad_button");
        xk.c(this.f35185t, (View.OnTouchListener) null, "video_ad_button");
        if (eq()) {
            xk.c(this.f35181p, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(ViewGroup viewGroup) {
        if (viewGroup != null && (this.f35173c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.xu = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35173c.getLayoutParams();
            this.f35159h = marginLayoutParams.leftMargin;
            this.ok = marginLayoutParams.topMargin;
            this.oh = marginLayoutParams.width;
            this.fm = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f35173c.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.te = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ge.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                xk.w(viewGroup, 0, 0, 0, 0);
            }
            w(true);
            this.wo.setImageDrawable(i.xv(this.f35180n, "tt_shrink_video"));
            this.bj.setThumb(w(18, "#00000000"));
            this.bj.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.c.ux.c.c(this.f35173c, false);
            f(this.xu);
            xk.c(this.bw, 8);
            if (!this.f35176i) {
                xk.c((View) this.pr, 8);
                xk.c((View) this.wx, 8);
            } else if (this.ls.contains(w.c.hideCloseBtn)) {
                xk.c((View) this.pr, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 1) {
            return;
        }
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(boolean z3, boolean z4, boolean z5) {
        xk.c(this.au, 0);
        xk.c((View) this.ys, 0);
        if (this.xu) {
            xk.c(this.bw, 0);
            xk.c((View) this.f35160m, 0);
        } else if (z5) {
            xk.c(this.bw, 8);
        }
        xk.c((View) this.xv, (!z3 || this.sr.getVisibility() == 0) ? 8 : 0);
        if (!this.f35176i && !this.xu) {
            if (!this.ls.contains(w.c.hideCloseBtn) && !z5) {
                xk.c((View) this.pr, 0);
            }
            xk.c((View) this.wx, z5 ? 8 : 0);
        }
        xk.c((View) this.bm, 0);
        xk.c((View) this.f35156b, 0);
        if (eq()) {
            xk.c((View) this.bj, 8);
        } else {
            xk.c((View) this.bj, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux
    public void c(boolean z3, boolean z4) {
        xk.c(this.au, 8);
        xk.c(this.bw, 8);
        xk.c((View) this.ys, z3 ? 0 : 8);
        xk.c((View) this.xv, 8);
        if (!this.f35176i && !this.xu) {
            xk.c((View) this.pr, 8);
            if (!this.ls.contains(w.c.alwayShowBackBtn)) {
                xk.c((View) this.wx, 8);
            }
        } else if (this.ls.contains(w.c.hideCloseBtn)) {
            xk.c((View) this.pr, 8);
        }
        if (z4) {
            xk.c((View) this.pr, 8);
            xk.c((View) this.wx, 8);
        }
        xv(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ux, com.bytedance.sdk.openadsdk.core.widget.ys.c
    public void c(View view, boolean z3) {
        if (p()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            me meVar = this.gb;
            if (meVar != null && !TextUtils.isEmpty(meVar.ny())) {
                c(this.gb.ny());
            }
            this.gw.setText(format);
        } else {
            c("");
            this.gw.setText("");
        }
        if (this.ba) {
            return;
        }
        xv(this.f35176i && !this.xu);
        if (i()) {
            this.f35190z.c(this, view, true, this.sr.getVisibility() != 0);
        }
    }
}
