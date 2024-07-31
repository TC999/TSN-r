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
import com.scwang.smartrefresh.layout.C11882R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshFooter;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ClassicsFooter extends RelativeLayout implements RefreshFooter {

    /* renamed from: m */
    public static String f33594m = "上拉加载更多";

    /* renamed from: n */
    public static String f33595n = "释放立即加载";

    /* renamed from: o */
    public static String f33596o = "正在加载...";

    /* renamed from: p */
    public static String f33597p = "正在刷新...";

    /* renamed from: q */
    public static String f33598q = "加载完成";

    /* renamed from: r */
    public static String f33599r = "加载失败";

    /* renamed from: s */
    public static String f33600s = "全部加载完成";

    /* renamed from: a */
    protected TextView f33601a;

    /* renamed from: b */
    protected ImageView f33602b;

    /* renamed from: c */
    protected ImageView f33603c;

    /* renamed from: d */
    protected PathsDrawable f33604d;

    /* renamed from: e */
    protected ProgressDrawable f33605e;

    /* renamed from: f */
    protected SpinnerStyle f33606f;

    /* renamed from: g */
    protected RefreshKernel f33607g;

    /* renamed from: h */
    protected int f33608h;

    /* renamed from: i */
    protected int f33609i;

    /* renamed from: j */
    protected boolean f33610j;

    /* renamed from: k */
    protected int f33611k;

    /* renamed from: l */
    protected int f33612l;

    /* renamed from: com.scwang.smartrefresh.layout.footer.ClassicsFooter$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11909a {

        /* renamed from: a */
        static final /* synthetic */ int[] f33613a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33613a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33613a[RefreshState.PullToUpLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33613a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33613a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33613a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33613a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        super(context);
        this.f33606f = SpinnerStyle.Translate;
        this.f33608h = 500;
        this.f33609i = 0;
        this.f33610j = false;
        this.f33611k = 20;
        this.f33612l = 20;
        m19899q(context, null, 0);
    }

    /* renamed from: q */
    private void m19899q(Context context, AttributeSet attributeSet, int i) {
        C11925c c11925c = new C11925c();
        TextView textView = new TextView(context);
        this.f33601a = textView;
        textView.setId(16908312);
        this.f33601a.setTextColor(-10066330);
        this.f33601a.setText(f33594m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f33601a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(c11925c.m19767a(20.0f), c11925c.m19767a(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f33602b = imageView;
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f33603c = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f33603c, layoutParams3);
        if (!isInEditMode()) {
            this.f33603c.setVisibility(8);
        } else {
            this.f33602b.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.ClassicsFooter);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C11882R.styleable.ClassicsFooter_srlDrawableMarginRight, c11925c.m19767a(20.0f));
        layoutParams3.rightMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        int i2 = C11882R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.height);
        int i3 = C11882R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams3.height);
        int i4 = C11882R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i4, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i4, layoutParams2.height);
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i4, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i4, layoutParams3.height);
        this.f33608h = obtainStyledAttributes.getInt(C11882R.styleable.ClassicsFooter_srlFinishDuration, this.f33608h);
        this.f33606f = SpinnerStyle.values()[obtainStyledAttributes.getInt(C11882R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f33606f.ordinal())];
        int i5 = C11882R.styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f33602b.setImageDrawable(obtainStyledAttributes.getDrawable(i5));
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            this.f33604d = pathsDrawable;
            pathsDrawable.m19801h(-10066330);
            this.f33604d.m19800i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f33602b.setImageDrawable(this.f33604d);
        }
        int i6 = C11882R.styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f33603c.setImageDrawable(obtainStyledAttributes.getDrawable(i6));
        } else {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.f33605e = progressDrawable;
            progressDrawable.m19832c(-10066330);
            this.f33603c.setImageDrawable(this.f33605e);
        }
        int i7 = C11882R.styleable.ClassicsFooter_srlTextSizeTitle;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.f33601a.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i7, C11925c.m19766b(16.0f)));
        } else {
            this.f33601a.setTextSize(16.0f);
        }
        int i8 = C11882R.styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            m19907M(obtainStyledAttributes.getColor(i8, 0));
        }
        int i9 = C11882R.styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i9)) {
            m19898s(obtainStyledAttributes.getColor(i9, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int m19767a = c11925c.m19767a(20.0f);
                this.f33611k = m19767a;
                int paddingRight = getPaddingRight();
                int m19767a2 = c11925c.m19767a(20.0f);
                this.f33612l = m19767a2;
                setPadding(paddingLeft, m19767a, paddingRight, m19767a2);
                return;
            }
            int paddingLeft2 = getPaddingLeft();
            int m19767a3 = c11925c.m19767a(20.0f);
            this.f33611k = m19767a3;
            int paddingRight2 = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            this.f33612l = paddingBottom;
            setPadding(paddingLeft2, m19767a3, paddingRight2, paddingBottom);
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f33611k = paddingTop;
            int paddingRight3 = getPaddingRight();
            int m19767a4 = c11925c.m19767a(20.0f);
            this.f33612l = m19767a4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, m19767a4);
        } else {
            this.f33611k = getPaddingTop();
            this.f33612l = getPaddingBottom();
        }
    }

    /* renamed from: A */
    public ClassicsFooter m19919A(Bitmap bitmap) {
        this.f33604d = null;
        this.f33602b.setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: B */
    public ClassicsFooter m19918B(Drawable drawable) {
        this.f33604d = null;
        this.f33602b.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: C */
    public ClassicsFooter m19917C(@DrawableRes int i) {
        this.f33604d = null;
        this.f33602b.setImageResource(i);
        return this;
    }

    /* renamed from: D */
    public ClassicsFooter m19916D(float f) {
        return m19915E(C11925c.m19766b(f));
    }

    /* renamed from: E */
    public ClassicsFooter m19915E(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33602b.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f33602b.setLayoutParams(layoutParams);
        return this;
    }

    /* renamed from: F */
    public ClassicsFooter m19914F(float f) {
        return m19913G(C11925c.m19766b(f));
    }

    /* renamed from: G */
    public ClassicsFooter m19913G(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33602b.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f33603c.getLayoutParams();
        marginLayoutParams2.rightMargin = i;
        marginLayoutParams.rightMargin = i;
        this.f33602b.setLayoutParams(marginLayoutParams);
        this.f33603c.setLayoutParams(marginLayoutParams2);
        return this;
    }

    /* renamed from: H */
    public ClassicsFooter m19912H(float f) {
        return m19911I(C11925c.m19766b(f));
    }

    /* renamed from: I */
    public ClassicsFooter m19911I(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33603c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f33603c.setLayoutParams(layoutParams);
        return this;
    }

    /* renamed from: J */
    public ClassicsFooter m19910J(float f) {
        return m19909K(C11925c.m19766b(f));
    }

    /* renamed from: K */
    public ClassicsFooter m19909K(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33602b.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f33603c.getLayoutParams();
        layoutParams2.width = i;
        layoutParams.width = i;
        layoutParams2.height = i;
        layoutParams.height = i;
        this.f33602b.setLayoutParams(layoutParams);
        this.f33603c.setLayoutParams(layoutParams2);
        return this;
    }

    /* renamed from: L */
    public ClassicsFooter m19908L(int i) {
        this.f33608h = i;
        return this;
    }

    /* renamed from: M */
    public ClassicsFooter m19907M(@ColorInt int i) {
        this.f33609i = i;
        setBackgroundColor(i);
        RefreshKernel refreshKernel = this.f33607g;
        if (refreshKernel != null) {
            refreshKernel.mo2083l(this.f33609i);
        }
        return this;
    }

    /* renamed from: N */
    public ClassicsFooter m19906N(@ColorRes int i) {
        m19907M(ContextCompat.getColor(getContext(), i));
        return this;
    }

    /* renamed from: O */
    public ClassicsFooter m19905O(Bitmap bitmap) {
        this.f33605e = null;
        this.f33603c.setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: P */
    public ClassicsFooter m19904P(Drawable drawable) {
        this.f33605e = null;
        this.f33603c.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: Q */
    public ClassicsFooter m19903Q(@DrawableRes int i) {
        this.f33605e = null;
        this.f33603c.setImageResource(i);
        return this;
    }

    /* renamed from: R */
    public ClassicsFooter m19902R(SpinnerStyle spinnerStyle) {
        this.f33606f = spinnerStyle;
        return this;
    }

    /* renamed from: S */
    public ClassicsFooter m19901S(float f) {
        this.f33601a.setTextSize(f);
        RefreshKernel refreshKernel = this.f33607g;
        if (refreshKernel != null) {
            refreshKernel.mo2082m();
        }
        return this;
    }

    /* renamed from: T */
    public ClassicsFooter m19900T(int i, float f) {
        this.f33601a.setTextSize(i, f);
        RefreshKernel refreshKernel = this.f33607g;
        if (refreshKernel != null) {
            refreshKernel.mo2082m();
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        if (this.f33610j) {
            return;
        }
        switch (C11909a.f33613a[refreshState2.ordinal()]) {
            case 1:
                this.f33602b.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f33602b.setVisibility(8);
                this.f33601a.setText(f33596o);
                return;
            case 5:
                this.f33601a.setText(f33595n);
                this.f33602b.animate().rotation(0.0f);
                return;
            case 6:
                this.f33601a.setText(f33597p);
                this.f33603c.setVisibility(8);
                this.f33602b.setVisibility(8);
                return;
            default:
                return;
        }
        this.f33601a.setText(f33594m);
        this.f33602b.animate().rotation(180.0f);
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: c */
    public boolean mo2106c(boolean z) {
        if (this.f33610j != z) {
            this.f33610j = z;
            if (z) {
                this.f33601a.setText(f33600s);
                this.f33602b.setVisibility(8);
            } else {
                this.f33601a.setText(f33594m);
                this.f33602b.setVisibility(0);
            }
            ProgressDrawable progressDrawable = this.f33605e;
            if (progressDrawable != null) {
                progressDrawable.stop();
            } else {
                this.f33603c.animate().rotation(0.0f).setDuration(300L);
            }
            this.f33603c.setVisibility(8);
            return true;
        }
        return true;
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: d */
    public void mo2105d(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: f */
    public void mo2104f(RefreshLayout refreshLayout, int i, int i2) {
        if (this.f33610j) {
            return;
        }
        this.f33603c.setVisibility(0);
        ProgressDrawable progressDrawable = this.f33605e;
        if (progressDrawable != null) {
            progressDrawable.start();
        } else {
            this.f33603c.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    public ImageView getArrowView() {
        return this.f33602b;
    }

    public ImageView getProgressView() {
        return this.f33603c;
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return this.f33606f;
    }

    public TextView getTitleText() {
        return this.f33601a;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        this.f33607g = refreshKernel;
        refreshKernel.mo2083l(this.f33609i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f33611k, getPaddingRight(), this.f33612l);
        }
        super.onMeasure(i, i2);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    /* renamed from: s */
    public ClassicsFooter m19898s(@ColorInt int i) {
        this.f33601a.setTextColor(i);
        ProgressDrawable progressDrawable = this.f33605e;
        if (progressDrawable != null) {
            progressDrawable.m19832c(i);
        }
        PathsDrawable pathsDrawable = this.f33604d;
        if (pathsDrawable != null) {
            pathsDrawable.m19801h(i);
        }
        return this;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f33606f != SpinnerStyle.FixedBehind || iArr.length <= 0) {
            return;
        }
        if (!(getBackground() instanceof BitmapDrawable)) {
            m19907M(iArr[0]);
        }
        if (iArr.length > 1) {
            m19898s(iArr[1]);
        } else {
            m19898s(iArr[0] == -1 ? -10066330 : -1);
        }
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: t */
    public void mo2103t(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        if (this.f33610j) {
            return 0;
        }
        ProgressDrawable progressDrawable = this.f33605e;
        if (progressDrawable != null) {
            progressDrawable.stop();
        } else {
            this.f33603c.animate().rotation(0.0f).setDuration(300L);
        }
        this.f33603c.setVisibility(8);
        if (z) {
            this.f33601a.setText(f33598q);
        } else {
            this.f33601a.setText(f33599r);
        }
        return this.f33608h;
    }

    /* renamed from: z */
    public ClassicsFooter m19897z(@ColorRes int i) {
        m19898s(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33606f = SpinnerStyle.Translate;
        this.f33608h = 500;
        this.f33609i = 0;
        this.f33610j = false;
        this.f33611k = 20;
        this.f33612l = 20;
        m19899q(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33606f = SpinnerStyle.Translate;
        this.f33608h = 500;
        this.f33609i = 0;
        this.f33610j = false;
        this.f33611k = 20;
        this.f33612l = 20;
        m19899q(context, attributeSet, i);
    }
}
