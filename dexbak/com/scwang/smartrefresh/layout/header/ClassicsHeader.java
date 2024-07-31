package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.C11882R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.C11925c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ClassicsHeader extends RelativeLayout implements RefreshHeader {

    /* renamed from: r */
    public static String f33636r = "下拉可以刷新";

    /* renamed from: s */
    public static String f33637s = "正在刷新...";

    /* renamed from: t */
    public static String f33638t = "正在加载...";

    /* renamed from: u */
    public static String f33639u = "释放立即刷新";

    /* renamed from: v */
    public static String f33640v = "刷新完成";

    /* renamed from: w */
    public static String f33641w = "刷新失败";

    /* renamed from: x */
    public static String f33642x = "上次更新 M-d HH:mm";

    /* renamed from: y */
    public static String f33643y = "释放进入二楼";

    /* renamed from: a */
    protected String f33644a;

    /* renamed from: b */
    protected Date f33645b;

    /* renamed from: c */
    protected TextView f33646c;

    /* renamed from: d */
    protected TextView f33647d;

    /* renamed from: e */
    protected ImageView f33648e;

    /* renamed from: f */
    protected ImageView f33649f;

    /* renamed from: g */
    protected SharedPreferences f33650g;

    /* renamed from: h */
    protected RefreshKernel f33651h;

    /* renamed from: i */
    protected PathsDrawable f33652i;

    /* renamed from: j */
    protected ProgressDrawable f33653j;

    /* renamed from: k */
    protected SpinnerStyle f33654k;

    /* renamed from: l */
    protected DateFormat f33655l;

    /* renamed from: m */
    protected int f33656m;

    /* renamed from: n */
    protected int f33657n;

    /* renamed from: o */
    protected int f33658o;

    /* renamed from: p */
    protected int f33659p;

    /* renamed from: q */
    protected boolean f33660q;

    /* renamed from: com.scwang.smartrefresh.layout.header.ClassicsHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11916a {

        /* renamed from: a */
        static final /* synthetic */ int[] f33661a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33661a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33661a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33661a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33661a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33661a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33661a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33661a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        super(context);
        this.f33644a = "LAST_UPDATE_TIME";
        this.f33654k = SpinnerStyle.Translate;
        this.f33655l = new SimpleDateFormat(f33642x, Locale.CHINA);
        this.f33656m = 500;
        this.f33658o = 20;
        this.f33659p = 20;
        this.f33660q = true;
        m19854q(context, null);
    }

    /* renamed from: q */
    private void m19854q(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        C11925c c11925c = new C11925c();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16908312);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.f33646c = textView;
        textView.setText(f33636r);
        this.f33646c.setTextColor(-10066330);
        TextView textView2 = new TextView(context);
        this.f33647d = textView2;
        textView2.setTextColor(-8618884);
        linearLayout.addView(this.f33646c, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(this.f33647d, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(c11925c.m19767a(20.0f), c11925c.m19767a(20.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f33648e = imageView;
        addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams3);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f33649f = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f33649f, layoutParams4);
        if (isInEditMode()) {
            this.f33648e.setVisibility(8);
            this.f33646c.setText(f33637s);
        } else {
            this.f33649f.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.ClassicsHeader);
        layoutParams.topMargin = obtainStyledAttributes.getDimensionPixelSize(C11882R.styleable.ClassicsHeader_srlTextTimeMarginTop, c11925c.m19767a(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C11882R.styleable.ClassicsFooter_srlDrawableMarginRight, c11925c.m19767a(20.0f));
        layoutParams4.rightMargin = dimensionPixelSize;
        layoutParams3.rightMargin = dimensionPixelSize;
        int i3 = C11882R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams3.height);
        int i4 = C11882R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i4, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i4, layoutParams4.height);
        int i5 = C11882R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i5, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i5, layoutParams3.height);
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i5, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i5, layoutParams4.height);
        this.f33656m = obtainStyledAttributes.getInt(C11882R.styleable.ClassicsHeader_srlFinishDuration, this.f33656m);
        this.f33660q = obtainStyledAttributes.getBoolean(C11882R.styleable.ClassicsHeader_srlEnableLastTime, this.f33660q);
        this.f33654k = SpinnerStyle.values()[obtainStyledAttributes.getInt(C11882R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f33654k.ordinal())];
        this.f33647d.setVisibility(this.f33660q ? 0 : 8);
        int i6 = C11882R.styleable.ClassicsHeader_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f33648e.setImageDrawable(obtainStyledAttributes.getDrawable(i6));
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            this.f33652i = pathsDrawable;
            pathsDrawable.m19801h(-10066330);
            this.f33652i.m19800i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f33648e.setImageDrawable(this.f33652i);
        }
        int i7 = C11882R.styleable.ClassicsHeader_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.f33649f.setImageDrawable(obtainStyledAttributes.getDrawable(i7));
        } else {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.f33653j = progressDrawable;
            progressDrawable.m19832c(-10066330);
            this.f33649f.setImageDrawable(this.f33653j);
        }
        if (obtainStyledAttributes.hasValue(C11882R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f33646c.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i, C11925c.m19766b(16.0f)));
        } else {
            this.f33646c.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(C11882R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f33647d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i2, C11925c.m19766b(12.0f)));
        } else {
            this.f33647d.setTextSize(12.0f);
        }
        int i8 = C11882R.styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            m19867P(obtainStyledAttributes.getColor(i8, 0));
        }
        int i9 = C11882R.styleable.ClassicsHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i9)) {
            m19853s(obtainStyledAttributes.getColor(i9, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int m19767a = c11925c.m19767a(20.0f);
                this.f33658o = m19767a;
                int paddingRight = getPaddingRight();
                int m19767a2 = c11925c.m19767a(20.0f);
                this.f33659p = m19767a2;
                setPadding(paddingLeft, m19767a, paddingRight, m19767a2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int m19767a3 = c11925c.m19767a(20.0f);
                this.f33658o = m19767a3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f33659p = paddingBottom;
                setPadding(paddingLeft2, m19767a3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f33658o = paddingTop;
            int paddingRight3 = getPaddingRight();
            int m19767a4 = c11925c.m19767a(20.0f);
            this.f33659p = m19767a4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, m19767a4);
        } else {
            this.f33658o = getPaddingTop();
            this.f33659p = getPaddingBottom();
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                m19868O(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f33644a += context.getClass().getName();
        this.f33650g = context.getSharedPreferences("ClassicsHeader", 0);
        m19868O(new Date(this.f33650g.getLong(this.f33644a, System.currentTimeMillis())));
    }

    /* renamed from: A */
    public ClassicsHeader m19882A(Bitmap bitmap) {
        this.f33652i = null;
        this.f33648e.setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: B */
    public ClassicsHeader m19881B(Drawable drawable) {
        this.f33652i = null;
        this.f33648e.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: C */
    public ClassicsHeader m19880C(@DrawableRes int i) {
        this.f33652i = null;
        this.f33648e.setImageResource(i);
        return this;
    }

    /* renamed from: D */
    public ClassicsHeader m19879D(float f) {
        return m19878E(C11925c.m19766b(f));
    }

    /* renamed from: E */
    public ClassicsHeader m19878E(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33648e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f33648e.setLayoutParams(layoutParams);
        return this;
    }

    /* renamed from: F */
    public ClassicsHeader m19877F(float f) {
        return m19876G(C11925c.m19766b(f));
    }

    /* renamed from: G */
    public ClassicsHeader m19876G(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33648e.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f33649f.getLayoutParams();
        marginLayoutParams2.rightMargin = i;
        marginLayoutParams.rightMargin = i;
        this.f33648e.setLayoutParams(marginLayoutParams);
        this.f33649f.setLayoutParams(marginLayoutParams2);
        return this;
    }

    /* renamed from: H */
    public ClassicsHeader m19875H(float f) {
        return m19874I(C11925c.m19766b(f));
    }

    /* renamed from: I */
    public ClassicsHeader m19874I(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33649f.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f33649f.setLayoutParams(layoutParams);
        return this;
    }

    /* renamed from: J */
    public ClassicsHeader m19873J(float f) {
        return m19872K(C11925c.m19766b(f));
    }

    /* renamed from: K */
    public ClassicsHeader m19872K(int i) {
        ViewGroup.LayoutParams layoutParams = this.f33648e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f33649f.getLayoutParams();
        layoutParams2.width = i;
        layoutParams.width = i;
        layoutParams2.height = i;
        layoutParams.height = i;
        this.f33648e.setLayoutParams(layoutParams);
        this.f33649f.setLayoutParams(layoutParams2);
        return this;
    }

    /* renamed from: L */
    public ClassicsHeader m19871L(boolean z) {
        this.f33660q = z;
        this.f33647d.setVisibility(z ? 0 : 8);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2094a();
        }
        return this;
    }

    /* renamed from: M */
    public ClassicsHeader m19870M(int i) {
        this.f33656m = i;
        return this;
    }

    /* renamed from: N */
    public ClassicsHeader m19869N(CharSequence charSequence) {
        this.f33645b = null;
        this.f33647d.setText(charSequence);
        return this;
    }

    /* renamed from: O */
    public ClassicsHeader m19868O(Date date) {
        this.f33645b = date;
        this.f33647d.setText(this.f33655l.format(date));
        if (this.f33650g != null && !isInEditMode()) {
            this.f33650g.edit().putLong(this.f33644a, date.getTime()).apply();
        }
        return this;
    }

    /* renamed from: P */
    public ClassicsHeader m19867P(@ColorInt int i) {
        this.f33657n = i;
        setBackgroundColor(i);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2092c(this.f33657n);
        }
        return this;
    }

    /* renamed from: Q */
    public ClassicsHeader m19866Q(@ColorRes int i) {
        m19867P(ContextCompat.getColor(getContext(), i));
        return this;
    }

    /* renamed from: R */
    public ClassicsHeader m19865R(Bitmap bitmap) {
        this.f33653j = null;
        this.f33649f.setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: S */
    public ClassicsHeader m19864S(Drawable drawable) {
        this.f33653j = null;
        this.f33649f.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: T */
    public ClassicsHeader m19863T(@DrawableRes int i) {
        this.f33653j = null;
        this.f33649f.setImageResource(i);
        return this;
    }

    /* renamed from: U */
    public ClassicsHeader m19862U(SpinnerStyle spinnerStyle) {
        this.f33654k = spinnerStyle;
        return this;
    }

    /* renamed from: V */
    public ClassicsHeader m19861V(float f) {
        this.f33647d.setTextSize(f);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2094a();
        }
        return this;
    }

    /* renamed from: W */
    public ClassicsHeader m19860W(int i, float f) {
        this.f33647d.setTextSize(i, f);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2094a();
        }
        return this;
    }

    /* renamed from: X */
    public ClassicsHeader m19859X(float f) {
        this.f33646c.setTextSize(f);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2094a();
        }
        return this;
    }

    /* renamed from: Y */
    public ClassicsHeader m19858Y(int i, float f) {
        this.f33646c.setTextSize(i, f);
        RefreshKernel refreshKernel = this.f33651h;
        if (refreshKernel != null) {
            refreshKernel.mo2094a();
        }
        return this;
    }

    /* renamed from: Z */
    public ClassicsHeader m19857Z(float f) {
        return m19856a0(C11925c.m19766b(f));
    }

    /* renamed from: a0 */
    public ClassicsHeader m19856a0(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33647d.getLayoutParams();
        marginLayoutParams.topMargin = i;
        this.f33647d.setLayoutParams(marginLayoutParams);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        switch (C11916a.f33661a[refreshState2.ordinal()]) {
            case 1:
                this.f33647d.setVisibility(this.f33660q ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f33646c.setText(f33637s);
                this.f33649f.setVisibility(0);
                this.f33648e.setVisibility(8);
                return;
            case 5:
                this.f33646c.setText(f33639u);
                this.f33648e.animate().rotation(180.0f);
                return;
            case 6:
                this.f33646c.setText(f33643y);
                this.f33648e.animate().rotation(0.0f);
                return;
            case 7:
                this.f33648e.setVisibility(8);
                this.f33649f.setVisibility(8);
                this.f33647d.setVisibility(8);
                this.f33646c.setText(f33638t);
                return;
            default:
                return;
        }
        this.f33646c.setText(f33636r);
        this.f33648e.setVisibility(0);
        this.f33649f.setVisibility(8);
        this.f33648e.animate().rotation(0.0f);
    }

    /* renamed from: b0 */
    public ClassicsHeader m19855b0(DateFormat dateFormat) {
        this.f33655l = dateFormat;
        Date date = this.f33645b;
        if (date != null) {
            this.f33647d.setText(dateFormat.format(date));
        }
        return this;
    }

    public ImageView getArrowView() {
        return this.f33648e;
    }

    public TextView getLastUpdateText() {
        return this.f33647d;
    }

    public ImageView getProgressView() {
        return this.f33649f;
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return this.f33654k;
    }

    public TextView getTitleText() {
        return this.f33646c;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        ProgressDrawable progressDrawable = this.f33653j;
        if (progressDrawable != null) {
            progressDrawable.start();
            return;
        }
        Drawable drawable = this.f33649f.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        } else {
            this.f33649f.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        this.f33651h = refreshKernel;
        refreshKernel.mo2092c(this.f33657n);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f33658o, getPaddingRight(), this.f33659p);
        }
        super.onMeasure(i, i2);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    /* renamed from: s */
    public ClassicsHeader m19853s(@ColorInt int i) {
        PathsDrawable pathsDrawable = this.f33652i;
        if (pathsDrawable != null) {
            pathsDrawable.m19801h(i);
        }
        ProgressDrawable progressDrawable = this.f33653j;
        if (progressDrawable != null) {
            progressDrawable.m19832c(i);
        }
        this.f33646c.setTextColor(i);
        this.f33647d.setTextColor((i & 16777215) | (-872415232));
        return this;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable)) {
                m19867P(iArr[0]);
            }
            if (iArr.length > 1) {
                m19853s(iArr[1]);
            } else {
                m19853s(iArr[0] == -1 ? -10066330 : -1);
            }
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        ProgressDrawable progressDrawable = this.f33653j;
        if (progressDrawable != null) {
            progressDrawable.stop();
        } else {
            Drawable drawable = this.f33649f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            } else {
                this.f33649f.animate().rotation(0.0f).setDuration(300L);
            }
        }
        this.f33649f.setVisibility(8);
        if (z) {
            this.f33646c.setText(f33640v);
            if (this.f33645b != null) {
                m19868O(new Date());
            }
        } else {
            this.f33646c.setText(f33641w);
        }
        return this.f33656m;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
    }

    /* renamed from: z */
    public ClassicsHeader m19852z(@ColorRes int i) {
        m19853s(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33644a = "LAST_UPDATE_TIME";
        this.f33654k = SpinnerStyle.Translate;
        this.f33655l = new SimpleDateFormat(f33642x, Locale.CHINA);
        this.f33656m = 500;
        this.f33658o = 20;
        this.f33659p = 20;
        this.f33660q = true;
        m19854q(context, attributeSet);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33644a = "LAST_UPDATE_TIME";
        this.f33654k = SpinnerStyle.Translate;
        this.f33655l = new SimpleDateFormat(f33642x, Locale.CHINA);
        this.f33656m = 500;
        this.f33658o = 20;
        this.f33659p = 20;
        this.f33660q = true;
        m19854q(context, attributeSet);
    }

    @RequiresApi(21)
    public ClassicsHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33644a = "LAST_UPDATE_TIME";
        this.f33654k = SpinnerStyle.Translate;
        this.f33655l = new SimpleDateFormat(f33642x, Locale.CHINA);
        this.f33656m = 500;
        this.f33658o = 20;
        this.f33659p = 20;
        this.f33660q = true;
        m19854q(context, attributeSet);
    }
}
