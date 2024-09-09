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
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.b;
import com.scwang.smartrefresh.layout.util.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ClassicsHeader extends RelativeLayout implements e {

    /* renamed from: r  reason: collision with root package name */
    public static String f47970r = "\u4e0b\u62c9\u53ef\u4ee5\u5237\u65b0";

    /* renamed from: s  reason: collision with root package name */
    public static String f47971s = "\u6b63\u5728\u5237\u65b0...";

    /* renamed from: t  reason: collision with root package name */
    public static String f47972t = "\u6b63\u5728\u52a0\u8f7d...";

    /* renamed from: u  reason: collision with root package name */
    public static String f47973u = "\u91ca\u653e\u7acb\u5373\u5237\u65b0";

    /* renamed from: v  reason: collision with root package name */
    public static String f47974v = "\u5237\u65b0\u5b8c\u6210";

    /* renamed from: w  reason: collision with root package name */
    public static String f47975w = "\u5237\u65b0\u5931\u8d25";

    /* renamed from: x  reason: collision with root package name */
    public static String f47976x = "\u4e0a\u6b21\u66f4\u65b0 M-d HH:mm";

    /* renamed from: y  reason: collision with root package name */
    public static String f47977y = "\u91ca\u653e\u8fdb\u5165\u4e8c\u697c";

    /* renamed from: a  reason: collision with root package name */
    protected String f47978a;

    /* renamed from: b  reason: collision with root package name */
    protected Date f47979b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f47980c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f47981d;

    /* renamed from: e  reason: collision with root package name */
    protected ImageView f47982e;

    /* renamed from: f  reason: collision with root package name */
    protected ImageView f47983f;

    /* renamed from: g  reason: collision with root package name */
    protected SharedPreferences f47984g;

    /* renamed from: h  reason: collision with root package name */
    protected g f47985h;

    /* renamed from: i  reason: collision with root package name */
    protected b f47986i;

    /* renamed from: j  reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.internal.a f47987j;

    /* renamed from: k  reason: collision with root package name */
    protected SpinnerStyle f47988k;

    /* renamed from: l  reason: collision with root package name */
    protected DateFormat f47989l;

    /* renamed from: m  reason: collision with root package name */
    protected int f47990m;

    /* renamed from: n  reason: collision with root package name */
    protected int f47991n;

    /* renamed from: o  reason: collision with root package name */
    protected int f47992o;

    /* renamed from: p  reason: collision with root package name */
    protected int f47993p;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f47994q;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47995a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47995a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47995a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47995a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47995a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47995a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47995a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f47995a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        super(context);
        this.f47978a = "LAST_UPDATE_TIME";
        this.f47988k = SpinnerStyle.Translate;
        this.f47989l = new SimpleDateFormat(f47976x, Locale.CHINA);
        this.f47990m = 500;
        this.f47992o = 20;
        this.f47993p = 20;
        this.f47994q = true;
        q(context, null);
    }

    private void q(Context context, AttributeSet attributeSet) {
        int i4;
        int i5;
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        c cVar = new c();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16908312);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.f47980c = textView;
        textView.setText(f47970r);
        this.f47980c.setTextColor(-10066330);
        TextView textView2 = new TextView(context);
        this.f47981d = textView2;
        textView2.setTextColor(-8618884);
        linearLayout.addView(this.f47980c, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(this.f47981d, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(cVar.a(20.0f), cVar.a(20.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f47982e = imageView;
        addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams3);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f47983f = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f47983f, layoutParams4);
        if (isInEditMode()) {
            this.f47982e.setVisibility(8);
            this.f47980c.setText(f47971s);
        } else {
            this.f47983f.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        layoutParams.topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, cVar.a(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, cVar.a(20.0f));
        layoutParams4.rightMargin = dimensionPixelSize;
        layoutParams3.rightMargin = dimensionPixelSize;
        int i6 = R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.height);
        int i7 = R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i7, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i7, layoutParams4.height);
        int i8 = R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.height);
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i8, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i8, layoutParams4.height);
        this.f47990m = obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.f47990m);
        this.f47994q = obtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.f47994q);
        this.f47988k = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f47988k.ordinal())];
        this.f47981d.setVisibility(this.f47994q ? 0 : 8);
        int i9 = R.styleable.ClassicsHeader_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f47982e.setImageDrawable(obtainStyledAttributes.getDrawable(i9));
        } else {
            b bVar = new b();
            this.f47986i = bVar;
            bVar.h(-10066330);
            this.f47986i.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f47982e.setImageDrawable(this.f47986i);
        }
        int i10 = R.styleable.ClassicsHeader_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f47983f.setImageDrawable(obtainStyledAttributes.getDrawable(i10));
        } else {
            com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
            this.f47987j = aVar;
            aVar.c(-10066330);
            this.f47983f.setImageDrawable(this.f47987j);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f47980c.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i4, c.b(16.0f)));
        } else {
            this.f47980c.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f47981d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i5, c.b(12.0f)));
        } else {
            this.f47981d.setTextSize(12.0f);
        }
        int i11 = R.styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            P(obtainStyledAttributes.getColor(i11, 0));
        }
        int i12 = R.styleable.ClassicsHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            s(obtainStyledAttributes.getColor(i12, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a4 = cVar.a(20.0f);
                this.f47992o = a4;
                int paddingRight = getPaddingRight();
                int a5 = cVar.a(20.0f);
                this.f47993p = a5;
                setPadding(paddingLeft, a4, paddingRight, a5);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int a6 = cVar.a(20.0f);
                this.f47992o = a6;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f47993p = paddingBottom;
                setPadding(paddingLeft2, a6, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f47992o = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a7 = cVar.a(20.0f);
            this.f47993p = a7;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a7);
        } else {
            this.f47992o = getPaddingTop();
            this.f47993p = getPaddingBottom();
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                O(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f47978a += context.getClass().getName();
        this.f47984g = context.getSharedPreferences("ClassicsHeader", 0);
        O(new Date(this.f47984g.getLong(this.f47978a, System.currentTimeMillis())));
    }

    public ClassicsHeader A(Bitmap bitmap) {
        this.f47986i = null;
        this.f47982e.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsHeader B(Drawable drawable) {
        this.f47986i = null;
        this.f47982e.setImageDrawable(drawable);
        return this;
    }

    public ClassicsHeader C(@DrawableRes int i4) {
        this.f47986i = null;
        this.f47982e.setImageResource(i4);
        return this;
    }

    public ClassicsHeader D(float f4) {
        return E(c.b(f4));
    }

    public ClassicsHeader E(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47982e.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.f47982e.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsHeader F(float f4) {
        return G(c.b(f4));
    }

    public ClassicsHeader G(int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47982e.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47983f.getLayoutParams();
        marginLayoutParams2.rightMargin = i4;
        marginLayoutParams.rightMargin = i4;
        this.f47982e.setLayoutParams(marginLayoutParams);
        this.f47983f.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public ClassicsHeader H(float f4) {
        return I(c.b(f4));
    }

    public ClassicsHeader I(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47983f.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.f47983f.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsHeader J(float f4) {
        return K(c.b(f4));
    }

    public ClassicsHeader K(int i4) {
        ViewGroup.LayoutParams layoutParams = this.f47982e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f47983f.getLayoutParams();
        layoutParams2.width = i4;
        layoutParams.width = i4;
        layoutParams2.height = i4;
        layoutParams.height = i4;
        this.f47982e.setLayoutParams(layoutParams);
        this.f47983f.setLayoutParams(layoutParams2);
        return this;
    }

    public ClassicsHeader L(boolean z3) {
        this.f47994q = z3;
        this.f47981d.setVisibility(z3 ? 0 : 8);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader M(int i4) {
        this.f47990m = i4;
        return this;
    }

    public ClassicsHeader N(CharSequence charSequence) {
        this.f47979b = null;
        this.f47981d.setText(charSequence);
        return this;
    }

    public ClassicsHeader O(Date date) {
        this.f47979b = date;
        this.f47981d.setText(this.f47989l.format(date));
        if (this.f47984g != null && !isInEditMode()) {
            this.f47984g.edit().putLong(this.f47978a, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader P(@ColorInt int i4) {
        this.f47991n = i4;
        setBackgroundColor(i4);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.c(this.f47991n);
        }
        return this;
    }

    public ClassicsHeader Q(@ColorRes int i4) {
        P(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public ClassicsHeader R(Bitmap bitmap) {
        this.f47987j = null;
        this.f47983f.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsHeader S(Drawable drawable) {
        this.f47987j = null;
        this.f47983f.setImageDrawable(drawable);
        return this;
    }

    public ClassicsHeader T(@DrawableRes int i4) {
        this.f47987j = null;
        this.f47983f.setImageResource(i4);
        return this;
    }

    public ClassicsHeader U(SpinnerStyle spinnerStyle) {
        this.f47988k = spinnerStyle;
        return this;
    }

    public ClassicsHeader V(float f4) {
        this.f47981d.setTextSize(f4);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader W(int i4, float f4) {
        this.f47981d.setTextSize(i4, f4);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader X(float f4) {
        this.f47980c.setTextSize(f4);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader Y(int i4, float f4) {
        this.f47980c.setTextSize(i4, f4);
        g gVar = this.f47985h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader Z(float f4) {
        return a0(c.b(f4));
    }

    public ClassicsHeader a0(int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47981d.getLayoutParams();
        marginLayoutParams.topMargin = i4;
        this.f47981d.setLayoutParams(marginLayoutParams);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        switch (a.f47995a[refreshState2.ordinal()]) {
            case 1:
                this.f47981d.setVisibility(this.f47994q ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f47980c.setText(f47971s);
                this.f47983f.setVisibility(0);
                this.f47982e.setVisibility(8);
                return;
            case 5:
                this.f47980c.setText(f47973u);
                this.f47982e.animate().rotation(180.0f);
                return;
            case 6:
                this.f47980c.setText(f47977y);
                this.f47982e.animate().rotation(0.0f);
                return;
            case 7:
                this.f47982e.setVisibility(8);
                this.f47983f.setVisibility(8);
                this.f47981d.setVisibility(8);
                this.f47980c.setText(f47972t);
                return;
            default:
                return;
        }
        this.f47980c.setText(f47970r);
        this.f47982e.setVisibility(0);
        this.f47983f.setVisibility(8);
        this.f47982e.animate().rotation(0.0f);
    }

    public ClassicsHeader b0(DateFormat dateFormat) {
        this.f47989l = dateFormat;
        Date date = this.f47979b;
        if (date != null) {
            this.f47981d.setText(dateFormat.format(date));
        }
        return this;
    }

    public ImageView getArrowView() {
        return this.f47982e;
    }

    public TextView getLastUpdateText() {
        return this.f47981d;
    }

    public ImageView getProgressView() {
        return this.f47983f;
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f47988k;
    }

    public TextView getTitleText() {
        return this.f47980c;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47987j;
        if (aVar != null) {
            aVar.start();
            return;
        }
        Drawable drawable = this.f47983f.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        } else {
            this.f47983f.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        this.f47985h = gVar;
        gVar.c(this.f47991n);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f47992o, getPaddingRight(), this.f47993p);
        }
        super.onMeasure(i4, i5);
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    public ClassicsHeader s(@ColorInt int i4) {
        b bVar = this.f47986i;
        if (bVar != null) {
            bVar.h(i4);
        }
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47987j;
        if (aVar != null) {
            aVar.c(i4);
        }
        this.f47980c.setTextColor(i4);
        this.f47981d.setTextColor((i4 & 16777215) | (-872415232));
        return this;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable)) {
                P(iArr[0]);
            }
            if (iArr.length > 1) {
                s(iArr[1]);
            } else {
                s(iArr[0] == -1 ? -10066330 : -1);
            }
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        com.scwang.smartrefresh.layout.internal.a aVar = this.f47987j;
        if (aVar != null) {
            aVar.stop();
        } else {
            Drawable drawable = this.f47983f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            } else {
                this.f47983f.animate().rotation(0.0f).setDuration(300L);
            }
        }
        this.f47983f.setVisibility(8);
        if (z3) {
            this.f47980c.setText(f47974v);
            if (this.f47979b != null) {
                O(new Date());
            }
        } else {
            this.f47980c.setText(f47975w);
        }
        return this.f47990m;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
    }

    public ClassicsHeader z(@ColorRes int i4) {
        s(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47978a = "LAST_UPDATE_TIME";
        this.f47988k = SpinnerStyle.Translate;
        this.f47989l = new SimpleDateFormat(f47976x, Locale.CHINA);
        this.f47990m = 500;
        this.f47992o = 20;
        this.f47993p = 20;
        this.f47994q = true;
        q(context, attributeSet);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47978a = "LAST_UPDATE_TIME";
        this.f47988k = SpinnerStyle.Translate;
        this.f47989l = new SimpleDateFormat(f47976x, Locale.CHINA);
        this.f47990m = 500;
        this.f47992o = 20;
        this.f47993p = 20;
        this.f47994q = true;
        q(context, attributeSet);
    }

    @RequiresApi(21)
    public ClassicsHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47978a = "LAST_UPDATE_TIME";
        this.f47988k = SpinnerStyle.Translate;
        this.f47989l = new SimpleDateFormat(f47976x, Locale.CHINA);
        this.f47990m = 500;
        this.f47992o = 20;
        this.f47993p = 20;
        this.f47994q = true;
        q(context, attributeSet);
    }
}
