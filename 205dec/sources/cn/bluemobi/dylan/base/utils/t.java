package cn.bluemobi.dylan.base.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.acse.ottn.f3;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SystemBarTintManager.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class t {

    /* renamed from: h  reason: collision with root package name */
    public static final int f1814h = -1728053248;

    /* renamed from: i  reason: collision with root package name */
    private static String f1815i;

    /* renamed from: a  reason: collision with root package name */
    private final b f1816a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1817b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1818c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1819d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1820e;

    /* renamed from: f  reason: collision with root package name */
    private View f1821f;

    /* renamed from: g  reason: collision with root package name */
    private View f1822g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SystemBarTintManager.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b {

        /* renamed from: j  reason: collision with root package name */
        private static final String f1823j = "status_bar_height";

        /* renamed from: k  reason: collision with root package name */
        private static final String f1824k = "navigation_bar_height";

        /* renamed from: l  reason: collision with root package name */
        private static final String f1825l = "navigation_bar_height_landscape";

        /* renamed from: m  reason: collision with root package name */
        private static final String f1826m = "navigation_bar_width";

        /* renamed from: n  reason: collision with root package name */
        private static final String f1827n = "config_showNavigationBar";

        /* renamed from: a  reason: collision with root package name */
        private final boolean f1828a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1829b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1830c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1831d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f1832e;

        /* renamed from: f  reason: collision with root package name */
        private final int f1833f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1834g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f1835h;

        /* renamed from: i  reason: collision with root package name */
        private final float f1836i;

        @TargetApi(14)
        private int b(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int c(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        private int e(Context context) {
            Resources resources = context.getResources();
            if (m(context)) {
                return c(resources, this.f1835h ? "navigation_bar_height" : "navigation_bar_height_landscape");
            }
            return 0;
        }

        @TargetApi(14)
        private int g(Context context) {
            Resources resources = context.getResources();
            if (m(context)) {
                return c(resources, "navigation_bar_width");
            }
            return 0;
        }

        @SuppressLint({"NewApi"})
        private float k(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f4 = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f4, displayMetrics.heightPixels / f4);
        }

        @TargetApi(14)
        private boolean m(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z3 = resources.getBoolean(identifier);
                if ("1".equals(t.f1815i)) {
                    return false;
                }
                if ("0".equals(t.f1815i)) {
                    return true;
                }
                return z3;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int a() {
            return this.f1831d;
        }

        public int d() {
            return this.f1833f;
        }

        public int f() {
            return this.f1834g;
        }

        public int h() {
            if (this.f1829b && o()) {
                return this.f1833f;
            }
            return 0;
        }

        public int i() {
            if (!this.f1829b || o()) {
                return 0;
            }
            return this.f1834g;
        }

        public int j(boolean z3) {
            return (this.f1828a ? this.f1830c : 0) + (z3 ? this.f1831d : 0);
        }

        public int l() {
            return this.f1830c;
        }

        public boolean n() {
            return this.f1832e;
        }

        public boolean o() {
            return this.f1836i >= 600.0f || this.f1835h;
        }

        private b(Activity activity, boolean z3, boolean z4) {
            Resources resources = activity.getResources();
            this.f1835h = resources.getConfiguration().orientation == 1;
            this.f1836i = k(activity);
            this.f1830c = c(resources, "status_bar_height");
            this.f1831d = b(activity);
            int e4 = e(activity);
            this.f1833f = e4;
            this.f1834g = g(activity);
            this.f1832e = e4 > 0;
            this.f1828a = z3;
            this.f1829b = z4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(f3.f5657f, String.class);
                declaredMethod.setAccessible(true);
                f1815i = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f1815i = null;
            }
        }
    }

    @TargetApi(19)
    public t(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            activity.obtainStyledAttributes(new int[]{16843759, 16843760}).recycle();
            int i4 = window.getAttributes().flags;
            if ((67108864 & i4) != 0) {
                this.f1817b = true;
            }
            if ((i4 & 134217728) != 0) {
                this.f1818c = true;
            }
        }
        b bVar = new b(activity, this.f1817b, this.f1818c);
        this.f1816a = bVar;
        if (!bVar.n()) {
            this.f1818c = false;
        }
        if (this.f1817b) {
            t(activity, viewGroup);
        }
        if (this.f1818c) {
            s(activity, viewGroup);
        }
    }

    private void s(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f1822g = new View(context);
        if (this.f1816a.o()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f1816a.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f1816a.f(), -1);
            layoutParams.gravity = 5;
        }
        this.f1822g.setLayoutParams(layoutParams);
        this.f1822g.setBackgroundColor(-1728053248);
        this.f1822g.setVisibility(8);
        viewGroup.addView(this.f1822g);
    }

    private void t(Context context, ViewGroup viewGroup) {
        this.f1821f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f1816a.l());
        layoutParams.gravity = 48;
        if (this.f1818c && !this.f1816a.o()) {
            layoutParams.rightMargin = this.f1816a.f();
        }
        this.f1821f.setLayoutParams(layoutParams);
        this.f1821f.setBackgroundColor(-1728053248);
        this.f1821f.setVisibility(8);
        viewGroup.addView(this.f1821f);
    }

    public b b() {
        return this.f1816a;
    }

    public boolean c() {
        return this.f1820e;
    }

    public boolean d() {
        return this.f1819d;
    }

    @TargetApi(11)
    public void e(float f4) {
        if (this.f1818c) {
            this.f1822g.setAlpha(f4);
        }
    }

    public void f(int i4) {
        if (this.f1818c) {
            this.f1822g.setBackgroundColor(i4);
        }
    }

    public void g(Drawable drawable) {
        if (this.f1818c) {
            this.f1822g.setBackgroundDrawable(drawable);
        }
    }

    public void h(boolean z3) {
        this.f1820e = z3;
        if (this.f1818c) {
            this.f1822g.setVisibility(z3 ? 0 : 8);
        }
    }

    public void i(int i4) {
        if (this.f1818c) {
            this.f1822g.setBackgroundResource(i4);
        }
    }

    @TargetApi(11)
    public void j(float f4) {
        if (this.f1817b) {
            this.f1821f.setAlpha(f4);
        }
    }

    public void k(int i4) {
        if (this.f1817b) {
            this.f1821f.setBackgroundColor(i4);
        }
    }

    public void l(Drawable drawable) {
        if (this.f1817b) {
            this.f1821f.setBackgroundDrawable(drawable);
        }
    }

    public void m(boolean z3) {
        this.f1819d = z3;
        if (this.f1817b) {
            this.f1821f.setVisibility(z3 ? 0 : 8);
        }
    }

    public void n(int i4) {
        if (this.f1817b) {
            this.f1821f.setBackgroundResource(i4);
        }
    }

    public void o(float f4) {
        j(f4);
        e(f4);
    }

    public void p(int i4) {
        k(i4);
        f(i4);
    }

    public void q(Drawable drawable) {
        l(drawable);
        g(drawable);
    }

    public void r(int i4) {
        n(i4);
        i(i4);
    }
}
