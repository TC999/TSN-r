package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class InteractViewContainer extends FrameLayout implements gd {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.w.bk f29225a;
    private DynamicBrushMaskView bk;

    /* renamed from: c  reason: collision with root package name */
    private Context f29226c;
    private View.OnTouchListener ev;

    /* renamed from: f  reason: collision with root package name */
    private String f29227f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.xv.p f29228k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29229p;

    /* renamed from: r  reason: collision with root package name */
    private RippleView f29230r;
    private View sr;
    private ev ux;

    /* renamed from: w  reason: collision with root package name */
    private DynamicBaseWidget f29231w;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.r xv;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        super(context);
        this.f29226c = context;
        this.f29231w = dynamicBaseWidget;
        this.xv = rVar;
        r();
    }

    private boolean ev() {
        return (this.xv.ox() || TextUtils.equals("9", this.f29227f) || TextUtils.equals("16", this.f29227f) || TextUtils.equals("17", this.f29227f) || TextUtils.equals("18", this.f29227f) || TextUtils.equals("20", this.f29227f) || TextUtils.equals("29", this.f29227f) || TextUtils.equals("10", this.f29227f)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        if (this.ev != null) {
            setOnClickListener((View.OnClickListener) this.f29231w.getDynamicClickListener());
            performClick();
            if (this.xv.lf()) {
                return;
            }
            setVisibility(8);
        }
    }

    private void r() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f29227f = this.xv.m();
        this.gd = this.xv.up();
        this.f29229p = this.xv.ox();
        ev c4 = p.c(this.f29226c, this.f29231w, this.xv, this.f29228k, this.f29225a);
        this.ux = c4;
        if (c4 != null) {
            this.sr = c4.xv();
            if (this.xv.gw()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.f29227f, "6")) {
                if (this.xv.xu() && !TextUtils.isEmpty(this.xv.ng())) {
                    this.f29230r = new RippleView(this.f29226c, com.bytedance.sdk.component.adexpress.dynamic.xv.r.c(this.xv.ng()));
                } else {
                    this.f29230r = new RippleView(this.f29226c, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.f29226c);
                frameLayout.addView(this.f29230r, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.f29230r.w();
                    }
                });
            }
            if (TextUtils.equals(this.f29227f, "20")) {
                this.bk = (DynamicBrushMaskView) this.ux.xv();
            }
            if (c(this.f29227f) && com.bytedance.sdk.component.adexpress.sr.c()) {
                int parseColor = Color.parseColor("#99000000");
                if (this.xv.xu() && !TextUtils.isEmpty(this.xv.ng())) {
                    try {
                        parseColor = com.bytedance.sdk.component.adexpress.dynamic.xv.r.c(this.xv.ng());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.f29226c);
                view.setBackgroundColor(parseColor);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.ux.xv());
            c(this.ux.xv());
            setVisibility(0);
        }
    }

    public void f() {
        if (this.sr != null && TextUtils.equals(this.f29227f, "2")) {
            View view = this.sr;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).sr();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ev evVar = this.ux;
            if (evVar != null) {
                evVar.w();
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.getMessage());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ev instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.c.xv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void sr() {
        ev evVar = this.ux;
        if (evVar != null) {
            evVar.w();
        }
    }

    public void ux() {
        if (this.sr != null && TextUtils.equals(this.f29227f, "2")) {
            View view = this.sr;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).xv();
            }
        }
    }

    public void xv() {
        ev evVar = this.ux;
        if (evVar != null) {
            evVar.c();
        }
    }

    private boolean c(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gd
    public void w() {
        if (ev()) {
            setOnClickListener((View.OnClickListener) this.f29231w.getDynamicClickListener());
            performClick();
            if (this.xv.lf()) {
                return;
            }
            setVisibility(8);
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, com.bytedance.sdk.component.adexpress.dynamic.xv.p pVar, com.bytedance.sdk.component.adexpress.w.bk bkVar) {
        super(context);
        this.f29226c = context;
        this.f29231w = dynamicBaseWidget;
        this.xv = rVar;
        this.f29228k = pVar;
        this.f29225a = bkVar;
        r();
    }

    private void c(ViewGroup viewGroup) {
        if (this.sr == null) {
            return;
        }
        String str = this.f29227f;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c4 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c4 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c4 = 2;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c4 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c4 = 4;
                    break;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    c4 = 5;
                    break;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    c4 = 6;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c4 = 11;
                    break;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c4 = '\r';
                    break;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    c4 = 14;
                    break;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    c4 = 15;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c4 = 16;
                    break;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    c4 = 17;
                    break;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    c4 = 18;
                    break;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    c4 = 19;
                    break;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    c4 = 20;
                    break;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    c4 = 21;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.ux(this, this.gd);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.xv.xu() || TextUtils.isEmpty(this.xv.ng())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.f(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.w(this, this);
                break;
            case 3:
                if (this.xv.xu() && !TextUtils.isEmpty(this.xv.ng())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.xv.r.c(this.xv.ng()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.xv(this);
                this.sr.setTag(2);
                break;
            case 6:
            case '\t':
                this.f29231w.setClipChildren(false);
                this.f29231w.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.f29231w.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.f(this);
                break;
            case 7:
            case 14:
                this.sr.setTag(2);
                break;
            case '\b':
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.sr(this, this.gd, this.f29229p);
                break;
            case '\n':
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.xv(this);
                this.sr.setTag(2);
                break;
            case 11:
            case 19:
                if (this.f29227f.equals("24") && com.bytedance.sdk.component.adexpress.sr.c()) {
                    this.f29231w.setClipChildren(false);
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.f(this);
                    break;
                } else {
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.ux(this, this.gd);
                    break;
                }
            case '\f':
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.w(this, this);
                break;
            case '\r':
                View view = this.sr;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.sr).getShakeLayout().setTag(2);
                }
                this.sr.setTag(2);
                break;
            case 15:
                View view2 = this.sr;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.sr).getWriggleLayout().setTag(2);
                }
                this.sr.setTag(2);
                break;
            case 16:
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.c(this, this.gd, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.ev(this, this.f29229p);
                    break;
                } else {
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.r(this, this.gd, viewGroup);
                    break;
                }
            case 18:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.f(this);
                    break;
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.ev(this, this.f29229p);
                    break;
                }
                break;
            case 21:
                View view3 = this.sr;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.sr).getShakeView().setTag(2);
                }
                this.ev = new com.bytedance.sdk.component.adexpress.dynamic.interact.c.ux(this, this.gd);
                break;
        }
        View.OnTouchListener onTouchListener = this.ev;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (ev()) {
            this.sr.setTag(2);
            setOnClickListener((View.OnClickListener) this.f29231w.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gd
    public void c() {
        if (TextUtils.equals(this.f29227f, "6")) {
            RippleView rippleView = this.f29230r;
            if (rippleView != null) {
                rippleView.xv();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.gd();
                    }
                }, 300L);
            }
        } else if (TextUtils.equals(this.f29227f, "20")) {
            DynamicBrushMaskView dynamicBrushMaskView = this.bk;
            if (dynamicBrushMaskView != null) {
                dynamicBrushMaskView.w();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.gd();
                    }
                }, 400L);
            }
        } else {
            gd();
        }
    }
}
