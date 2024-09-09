package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.dynamic.xv.r;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.utils.q;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.w, sr, ux {

    /* renamed from: a  reason: collision with root package name */
    protected r f29132a;
    protected ev bk;

    /* renamed from: c  reason: collision with root package name */
    private float f29133c;
    protected int ev;

    /* renamed from: f  reason: collision with root package name */
    protected float f29134f;
    protected boolean fp;
    private float fz;
    protected int gd;

    /* renamed from: i  reason: collision with root package name */
    private q f29135i;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.c.w ia;

    /* renamed from: k  reason: collision with root package name */
    protected Context f29136k;

    /* renamed from: p  reason: collision with root package name */
    protected int f29137p;

    /* renamed from: r  reason: collision with root package name */
    protected int f29138r;

    /* renamed from: s  reason: collision with root package name */
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.c f29139s;
    protected float sr;

    /* renamed from: t  reason: collision with root package name */
    protected DynamicRootView f29140t;

    /* renamed from: u  reason: collision with root package name */
    private float f29141u;
    protected float ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29142w;
    protected float xv;
    protected View ys;

    /* renamed from: q  reason: collision with root package name */
    private static final View.OnTouchListener f29131q = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private static final View.OnClickListener f29130j = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context);
        this.f29136k = context;
        this.f29140t = dynamicRootView;
        this.bk = evVar;
        this.xv = evVar.f();
        this.sr = evVar.r();
        this.ux = evVar.ev();
        this.f29134f = evVar.gd();
        this.gd = (int) f.c(this.f29136k, this.xv);
        this.f29137p = (int) f.c(this.f29136k, this.sr);
        this.f29138r = (int) f.c(this.f29136k, this.ux);
        this.ev = (int) f.c(this.f29136k, this.f29134f);
        r rVar = new r(evVar.p());
        this.f29132a = rVar;
        if (rVar.s() > 0) {
            this.f29138r += this.f29132a.s() * 2;
            this.ev += this.f29132a.s() * 2;
            this.gd -= this.f29132a.s();
            this.f29137p -= this.f29132a.s();
            List<ev> k4 = evVar.k();
            if (k4 != null) {
                for (ev evVar2 : k4) {
                    evVar2.xv(evVar2.f() + f.w(this.f29136k, this.f29132a.s()));
                    evVar2.sr(evVar2.r() + f.w(this.f29136k, this.f29132a.s()));
                    evVar2.c(f.w(this.f29136k, this.f29132a.s()));
                    evVar2.w(f.w(this.f29136k, this.f29132a.s()));
                }
            }
        }
        this.fp = this.f29132a.t() > 0.0d;
        this.f29139s = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.c();
    }

    private void gd() {
        if (isShown()) {
            int c4 = com.bytedance.sdk.component.adexpress.dynamic.w.c.c(this.f29132a);
            if (c4 == 2) {
                if (this.f29135i == null) {
                    this.f29135i = new q(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 1);
                }
                this.f29135i.c(new q.c() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.q.c
                    public void c(int i4) {
                        if (i4 == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.p();
                        }
                    }
                });
                bk renderRequest = this.f29140t.getRenderRequest();
                if (renderRequest != null) {
                    this.f29135i.c(renderRequest.ys());
                    this.f29135i.c(renderRequest.fz());
                }
            } else if (c4 == 3) {
                if (this.f29135i == null) {
                    this.f29135i = new q(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 2);
                }
                this.f29135i.c(new q.c() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.q.c
                    public void c(int i4) {
                        if (i4 == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.p();
                        }
                    }
                });
                bk renderRequest2 = this.f29140t.getRenderRequest();
                if (renderRequest2 != null) {
                    this.f29135i.w(renderRequest2.ia());
                    this.f29135i.w(renderRequest2.u());
                    this.f29135i.c(renderRequest2.s());
                }
            }
            q qVar = this.f29135i;
            if (qVar != null) {
                qVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            View view = this.ys;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(f29130j);
        } catch (Exception unused) {
        }
    }

    public void f() {
        if (r()) {
            return;
        }
        View view = this.ys;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.c.w wVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.c.w(view, this.bk.p().sr().rd());
        this.ia = wVar;
        wVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getBackgroundDrawable() {
        return c(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.fp;
    }

    public int getClickArea() {
        return this.f29132a.ck();
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ux.c getDynamicClickListener() {
        return this.f29140t.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.ev;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.xv.f getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.xv.ux p3;
        ev evVar = this.bk;
        if (evVar == null || (p3 = evVar.p()) == null) {
            return null;
        }
        return p3.sr();
    }

    public int getDynamicWidth() {
        return this.f29138r;
    }

    public String getImageObjectFit() {
        return this.f29132a.b();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getMarqueeValue() {
        return this.fz;
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(c(w(this.f29132a.yu().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getRippleValue() {
        return this.f29133c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getShineValue() {
        return this.f29142w;
    }

    public float getStretchValue() {
        return this.f29141u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
        gd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        w();
        super.onDetachedFromWindow();
        q qVar = this.f29135i;
        if (qVar != null) {
            qVar.w();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f29139s.c(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.c cVar = this.f29139s;
        View view = this.ys;
        if (view == null) {
            view = this;
        }
        cVar.c(view, i4, i5);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        q qVar = this.f29135i;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        ev evVar = this.bk;
        return evVar == null || evVar.p() == null || this.bk.p().sr() == null || this.bk.p().sr().rd() == null;
    }

    public void setMarqueeValue(float f4) {
        this.fz = f4;
        postInvalidate();
    }

    public void setRippleValue(float f4) {
        this.f29133c = f4;
        postInvalidate();
    }

    public void setShineValue(float f4) {
        this.f29142w = f4;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z3) {
        this.fp = z3;
    }

    public void setStretchValue(float f4) {
        this.f29141u = f4;
        this.f29139s.c(this, f4);
    }

    public boolean sr() {
        r rVar = this.f29132a;
        return (rVar == null || rVar.ck() == 0) ? false : true;
    }

    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
        layoutParams.topMargin = this.f29137p;
        int i4 = this.gd;
        layoutParams.leftMargin = i4;
        layoutParams.setMarginStart(i4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(View view) {
        com.bytedance.sdk.component.adexpress.dynamic.xv.f sr;
        ev evVar = this.bk;
        if (evVar == null || (sr = evVar.p().sr()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(sr.nc()));
    }

    protected boolean xv() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.ys;
        if (view == null) {
            view = this;
        }
        if (sr()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = f29131q;
            onClickListener = f29130j;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int c4 = com.bytedance.sdk.component.adexpress.dynamic.w.c.c(this.f29132a);
            if (c4 != 2 && c4 != 3) {
                view.setOnClickListener(onClickListener);
            } else {
                view.setOnClickListener(f29130j);
            }
        }
        c(view);
        w(view);
        return true;
    }

    public boolean c() {
        ev();
        ux();
        xv();
        return true;
    }

    private List<String> w(String str) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (str.charAt(i6) == '(') {
                i4++;
                z3 = true;
            } else if (str.charAt(i6) == ')' && i4 - 1 == 0 && z3) {
                int i7 = i6 + 1;
                arrayList.add(str.substring(i5, i7));
                i5 = i7;
                z3 = false;
            }
        }
        return arrayList;
    }

    public void c(int i4) {
        r rVar = this.f29132a;
        if (rVar != null && rVar.c(i4)) {
            ev();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null && (getChildAt(i5) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).c(i4);
                }
            }
        }
    }

    public void w() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.c.w wVar = this.ia;
        if (wVar != null) {
            wVar.w();
        }
    }

    protected void c(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.bk.ev());
            jSONObject.put("height", this.bk.gd());
            if (com.bytedance.sdk.component.adexpress.sr.c()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.c.f29098u, this.f29132a.wx());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.c.f29090i, this.bk.p().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.c.f29094q, this.bk.xv());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.c.f29091j, jSONObject.toString());
            } else {
                view.setTag(2097610717, this.f29132a.wx());
                view.setTag(2097610715, this.bk.p().getType());
                view.setTag(2097610714, this.bk.xv());
                view.setTag(2097610713, jSONObject.toString());
                int c4 = com.bytedance.sdk.component.adexpress.dynamic.w.c.c(this.f29132a);
                if (c4 == 1) {
                    view.setTag(2097610707, new Pair(this.f29132a.gb(), Long.valueOf(this.f29132a.n())));
                    view.setTag(2097610708, Integer.valueOf(c4));
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable c(boolean z3, String str) {
        String[] split;
        int[] iArr;
        int z4;
        if (!TextUtils.isEmpty(this.f29132a.yu())) {
            try {
                String yu = this.f29132a.yu();
                String substring = yu.substring(yu.indexOf("(") + 1, yu.length() - 1);
                if (substring.contains("rgba") && substring.contains("%")) {
                    split = new String[]{substring.substring(0, substring.indexOf(",")).trim(), substring.substring(substring.indexOf(",") + 1, substring.indexOf("%") + 1).trim(), substring.substring(substring.indexOf("%") + 2).trim()};
                    iArr = new int[]{r.c(split[1]), r.c(split[2])};
                } else {
                    split = substring.split(", ");
                    iArr = new int[]{r.c(split[1].substring(0, 7)), r.c(split[2].substring(0, 7))};
                }
                try {
                    double parseDouble = Double.parseDouble(substring.substring(substring.indexOf("linear-gradient(") + 1, substring.indexOf("deg")));
                    if (parseDouble > 225.0d && parseDouble < 315.0d) {
                        int i4 = iArr[iArr.length - 1];
                        iArr[iArr.length - 1] = iArr[0];
                        iArr[0] = i4;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable c4 = c(c(split[0]), iArr);
                c4.setShape(0);
                c4.setCornerRadius(f.c(this.f29136k, this.f29132a.ys()));
                return c4;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float c5 = f.c(this.f29136k, this.f29132a.ys());
        drawable.setCornerRadius(c5);
        if (c5 < 1.0f) {
            float c6 = f.c(this.f29136k, this.f29132a.y());
            float c7 = f.c(this.f29136k, this.f29132a.eq());
            float c8 = f.c(this.f29136k, this.f29132a.me());
            float c9 = f.c(this.f29136k, this.f29132a.wv());
            float[] fArr = new float[8];
            if (c6 > 0.0f) {
                fArr[0] = c6;
                fArr[1] = c6;
            }
            if (c7 > 0.0f) {
                fArr[2] = c7;
                fArr[3] = c7;
            }
            if (c8 > 0.0f) {
                fArr[4] = c8;
                fArr[5] = c8;
            }
            if (c9 > 0.0f) {
                fArr[6] = c9;
                fArr[7] = c9;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z3) {
            z4 = Color.parseColor(str);
        } else {
            z4 = this.f29132a.z();
        }
        drawable.setColor(z4);
        if (this.f29132a.ia() > 0.0f) {
            drawable.setStroke((int) f.c(this.f29136k, this.f29132a.ia()), this.f29132a.fp());
            return drawable;
        } else if (this.f29132a.s() > 0) {
            drawable.setStroke(this.f29132a.s(), this.f29132a.fp());
            drawable.setAlpha(50);
            if (TextUtils.equals(this.bk.p().getType(), "video-vd")) {
                setLayerType(1, null);
                return new xv((int) c5, this.f29132a.s());
            }
            return drawable;
        } else {
            return drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w c(Bitmap bitmap) {
        return new c(bitmap, null);
    }

    private Drawable[] c(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    iArr[i5] = r.c(split[i6].substring(0, 7));
                    i5 = i6;
                }
                GradientDrawable c4 = c(c(split[0]), iArr);
                c4.setShape(0);
                c4.setCornerRadius(f.c(this.f29136k, this.f29132a.ys()));
                drawableArr[(list.size() - 1) - i4] = c4;
            }
        }
        return drawableArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GradientDrawable c(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GradientDrawable.Orientation c(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (parseFloat <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseFloat <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseFloat <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
