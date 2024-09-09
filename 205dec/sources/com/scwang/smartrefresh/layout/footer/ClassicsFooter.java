package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.b;
import com.scwang.smartrefresh.layout.util.c;
import r0.d;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ClassicsFooter extends RelativeLayout implements d {

    /* renamed from: m  reason: collision with root package name */
    public static String f47928m = "\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a";

    /* renamed from: n  reason: collision with root package name */
    public static String f47929n = "\u91ca\u653e\u7acb\u5373\u52a0\u8f7d";

    /* renamed from: o  reason: collision with root package name */
    public static String f47930o = "\u6b63\u5728\u52a0\u8f7d...";

    /* renamed from: p  reason: collision with root package name */
    public static String f47931p = "\u6b63\u5728\u5237\u65b0...";

    /* renamed from: q  reason: collision with root package name */
    public static String f47932q = "\u52a0\u8f7d\u5b8c\u6210";

    /* renamed from: r  reason: collision with root package name */
    public static String f47933r = "\u52a0\u8f7d\u5931\u8d25";

    /* renamed from: s  reason: collision with root package name */
    public static String f47934s = "\u5168\u90e8\u52a0\u8f7d\u5b8c\u6210";

    /* renamed from: a  reason: collision with root package name */
    protected TextView f47935a;

    /* renamed from: b  reason: collision with root package name */
    protected ImageView f47936b;

    /* renamed from: c  reason: collision with root package name */
    protected ImageView f47937c;

    /* renamed from: d  reason: collision with root package name */
    protected b f47938d;

    /* renamed from: e  reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.internal.a f47939e;

    /* renamed from: f  reason: collision with root package name */
    protected SpinnerStyle f47940f;

    /* renamed from: g  reason: collision with root package name */
    protected g f47941g;

    /* renamed from: h  reason: collision with root package name */
    protected int f47942h;

    /* renamed from: i  reason: collision with root package name */
    protected int f47943i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f47944j;

    /* renamed from: k  reason: collision with root package name */
    protected int f47945k;

    /* renamed from: l  reason: collision with root package name */
    protected int f47946l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47947a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47947a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47947a[RefreshState.PullToUpLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47947a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47947a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47947a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47947a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        super(context);
        this.f47940f = SpinnerStyle.Translate;
        this.f47942h = 500;
        this.f47943i = 0;
        this.f47944j = false;
        this.f47945k = 20;
        this.f47946l = 20;
        q(context, null, 0);
    }

    private void q(Context context, AttributeSet attributeSet, int i4) {
        c cVar = new c();
        TextView textView = new TextView(context);
        this.f47935a = textView;
        textView.setId(16908312);
        this.f47935a.setTextColor(-10066330);
        this.f47935a.setText(f47928m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f47935a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cVar.a(20.0f), cVar.a(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f47936b = imageView;
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f47937c = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f47937c, layoutParams3);
        if (!isInEditMode()) {
            this.f47937c.setVisibility(8);
        } else {
            this.f47936b.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, cVar.a(20.0f));
        layoutParams3.rightMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        int i5 = R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i5, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i5, layoutParams2.height);
        int i6 = R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.height);
        int i7 = R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i7, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i7, layoutParams2.height);
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i7, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i7, layoutParams3.height);
        this.f47942h = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.f47942h);
        this.f47940f = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f47940f.ordinal())];
        int i8 = R.styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.f47936b.setImageDrawable(obtainStyledAttributes.getDrawable(i8));
        } else {
            b bVar = new b();
            this.f47938d = bVar;
            bVar.h(-10066330);
            this.f47938d.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f47936b.setImageDrawable(this.f47938d);
        }
        int i9 = R.styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f47937c.setImageDrawable(obtainStyledAttributes.getDrawable(i9));
        } else {
            com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
            this.f47939e = aVar;
            aVar.c(-10066330);
            this.f47937c.setImageDrawable(this.f47939e);
        }
        int i10 = R.styleable.ClassicsFooter_srlTextSizeTitle;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f47935a.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i10, c.b(16.0f)));
        } else {
            this.f47935a.setTextSize(16.0f);
        }
        int i11 = R.styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            M(obtainStyledAttributes.getColor(i11, 0));
        }
        int i12 = R.styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            s(obtainStyledAttributes.getColor(i12, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a4 = cVar.a(20.0f);
                this.f47945k = a4;
                int paddingRight = getPaddingRight();
                int a5 = cVar.a(20.0f);
                this.f47946l = a5;
                setPadding(paddingLeft, a4, paddingRight, a5);
                return;
            }
            int paddingLeft2 = getPaddingLeft();
            int a6 = cVar.a(20.0f);
            this.f47945k = a6;
            int paddingRight2 = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            this.f47946l = paddingBottom;
            setPadding(paddingLeft2, a6, paddingRight2, paddingBottom);
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f47945k = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a7 = cVar.a(20.0f);
            this.f47946l = a7;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a7);
        } else {
            this.f47945k = getPaddingTop();
            this.f47946l = getPaddingBottom();
        }
    }

    public ClassicsFooter A(Bitmap bitmap) {
        this.f47938d = null;
        this.f47936b.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsFooter B(Drawable drawable) {
        this.f47938d = null;
        this.f47936b.setImageDrawable(drawable);
        return this;
    }

    public ClassicsFooter C(@DrawableRes int i4) {
        this.f47938d = null;
        this.f47936b.setImageResource(i4);
        return this;
    }

    public ClassicsFooter D(float f4) {
        return E(c.b(f4));
    }

    public ClassicsFooter E(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47936b.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.f47936b.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsFooter F(float f4) {
        return G(c.b(f4));
    }

    public ClassicsFooter G(int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47936b.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47937c.getLayoutParams();
        marginLayoutParams2.rightMargin = i4;
        marginLayoutParams.rightMargin = i4;
        this.f47936b.setLayoutParams(marginLayoutParams);
        this.f47937c.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public ClassicsFooter H(float f4) {
        return I(c.b(f4));
    }

    public ClassicsFooter I(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47937c.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.f47937c.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsFooter J(float f4) {
        return K(c.b(f4));
    }

    public ClassicsFooter K(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47936b.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f47937c.getLayoutParams();
        layoutParams2.width = i4;
        layoutParams.width = i4;
        layoutParams2.height = i4;
        layoutParams.height = i4;
        this.f47936b.setLayoutParams(layoutParams);
        this.f47937c.setLayoutParams(layoutParams2);
        return this;
    }

    public ClassicsFooter L(int i4) {
        this.f47942h = i4;
        return this;
    }

    public ClassicsFooter M(@ColorInt int i4) {
        this.f47943i = i4;
        setBackgroundColor(i4);
        g gVar = this.f47941g;
        if (gVar != null) {
            gVar.l(this.f47943i);
        }
        return this;
    }

    public ClassicsFooter N(@ColorRes int i4) {
        M(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public ClassicsFooter O(Bitmap bitmap) {
        this.f47939e = null;
        this.f47937c.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsFooter P(Drawable drawable) {
        this.f47939e = null;
        this.f47937c.setImageDrawable(drawable);
        return this;
    }

    public ClassicsFooter Q(@DrawableRes int i4) {
        this.f47939e = null;
        this.f47937c.setImageResource(i4);
        return this;
    }

    public ClassicsFooter R(SpinnerStyle spinnerStyle) {
        this.f47940f = spinnerStyle;
        return this;
    }

    public ClassicsFooter S(float f4) {
        this.f47935a.setTextSize(f4);
        g gVar = this.f47941g;
        if (gVar != null) {
            gVar.m();
        }
        return this;
    }

    public ClassicsFooter T(int i4, float f4) {
        this.f47935a.setTextSize(i4, f4);
        g gVar = this.f47941g;
        if (gVar != null) {
            gVar.m();
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        if (this.f47944j) {
            return;
        }
        switch (a.f47947a[refreshState2.ordinal()]) {
            case 1:
                this.f47936b.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f47936b.setVisibility(8);
                this.f47935a.setText(f47930o);
                return;
            case 5:
                this.f47935a.setText(f47929n);
                this.f47936b.animate().rotation(0.0f);
                return;
            case 6:
                this.f47935a.setText(f47931p);
                this.f47937c.setVisibility(8);
                this.f47936b.setVisibility(8);
                return;
            default:
                return;
        }
        this.f47935a.setText(f47928m);
        this.f47936b.animate().rotation(180.0f);
    }

    @Override // r0.d
    public boolean c(boolean z3) {
        if (this.f47944j != z3) {
            this.f47944j = z3;
            if (z3) {
                this.f47935a.setText(f47934s);
                this.f47936b.setVisibility(8);
            } else {
                this.f47935a.setText(f47928m);
                this.f47936b.setVisibility(0);
            }
            com.scwang.smartrefresh.layout.internal.a aVar = this.f47939e;
            if (aVar != null) {
                aVar.stop();
            } else {
                this.f47937c.animate().rotation(0.0f).setDuration(300L);
            }
            this.f47937c.setVisibility(8);
            return true;
        }
        return true;
    }

    @Override // r0.d
    public void d(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.d
    public void f(h hVar, int i4, int i5) {
        if (this.f47944j) {
            return;
        }
        this.f47937c.setVisibility(0);
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47939e;
        if (aVar != null) {
            aVar.start();
        } else {
            this.f47937c.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    public ImageView getArrowView() {
        return this.f47936b;
    }

    public ImageView getProgressView() {
        return this.f47937c;
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f47940f;
    }

    public TextView getTitleText() {
        return this.f47935a;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        this.f47941g = gVar;
        gVar.l(this.f47943i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f47945k, getPaddingRight(), this.f47946l);
        }
        super.onMeasure(i4, i5);
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    public ClassicsFooter s(@ColorInt int i4) {
        this.f47935a.setTextColor(i4);
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47939e;
        if (aVar != null) {
            aVar.c(i4);
        }
        b bVar = this.f47938d;
        if (bVar != null) {
            bVar.h(i4);
        }
        return this;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f47940f != SpinnerStyle.FixedBehind || iArr.length <= 0) {
            return;
        }
        if (!(getBackground() instanceof BitmapDrawable)) {
            M(iArr[0]);
        }
        if (iArr.length > 1) {
            s(iArr[1]);
        } else {
            s(iArr[0] == -1 ? -10066330 : -1);
        }
    }

    @Override // r0.d
    public void t(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        if (this.f47944j) {
            return 0;
        }
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47939e;
        if (aVar != null) {
            aVar.stop();
        } else {
            this.f47937c.animate().rotation(0.0f).setDuration(300L);
        }
        this.f47937c.setVisibility(8);
        if (z3) {
            this.f47935a.setText(f47932q);
        } else {
            this.f47935a.setText(f47933r);
        }
        return this.f47942h;
    }

    public ClassicsFooter z(@ColorRes int i4) {
        s(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47940f = SpinnerStyle.Translate;
        this.f47942h = 500;
        this.f47943i = 0;
        this.f47944j = false;
        this.f47945k = 20;
        this.f47946l = 20;
        q(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47940f = SpinnerStyle.Translate;
        this.f47942h = 500;
        this.f47943i = 0;
        this.f47944j = false;
        this.f47945k = 20;
        this.f47946l = 20;
        q(context, attributeSet, i4);
    }
}
