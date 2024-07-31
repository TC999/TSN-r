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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.lang.reflect.Method;

/* renamed from: cn.bluemobi.dylan.base.utils.t */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SystemBarTintManager {

    /* renamed from: h */
    public static final int f1828h = -1728053248;

    /* renamed from: i */
    private static String f1829i;

    /* renamed from: a */
    private final C1146b f1830a;

    /* renamed from: b */
    private boolean f1831b;

    /* renamed from: c */
    private boolean f1832c;

    /* renamed from: d */
    private boolean f1833d;

    /* renamed from: e */
    private boolean f1834e;

    /* renamed from: f */
    private View f1835f;

    /* renamed from: g */
    private View f1836g;

    /* compiled from: SystemBarTintManager.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.t$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1146b {

        /* renamed from: j */
        private static final String f1837j = "status_bar_height";

        /* renamed from: k */
        private static final String f1838k = "navigation_bar_height";

        /* renamed from: l */
        private static final String f1839l = "navigation_bar_height_landscape";

        /* renamed from: m */
        private static final String f1840m = "navigation_bar_width";

        /* renamed from: n */
        private static final String f1841n = "config_showNavigationBar";

        /* renamed from: a */
        private final boolean f1842a;

        /* renamed from: b */
        private final boolean f1843b;

        /* renamed from: c */
        private final int f1844c;

        /* renamed from: d */
        private final int f1845d;

        /* renamed from: e */
        private final boolean f1846e;

        /* renamed from: f */
        private final int f1847f;

        /* renamed from: g */
        private final int f1848g;

        /* renamed from: h */
        private final boolean f1849h;

        /* renamed from: i */
        private final float f1850i;

        @TargetApi(14)
        /* renamed from: b */
        private int m57666b(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        /* renamed from: c */
        private int m57665c(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", FaceEnvironment.f8430OS);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        /* renamed from: e */
        private int m57663e(Context context) {
            Resources resources = context.getResources();
            if (m57655m(context)) {
                return m57665c(resources, this.f1849h ? f1838k : f1839l);
            }
            return 0;
        }

        @TargetApi(14)
        /* renamed from: g */
        private int m57661g(Context context) {
            Resources resources = context.getResources();
            if (m57655m(context)) {
                return m57665c(resources, f1840m);
            }
            return 0;
        }

        @SuppressLint({"NewApi"})
        /* renamed from: k */
        private float m57657k(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
        }

        @TargetApi(14)
        /* renamed from: m */
        private boolean m57655m(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(f1841n, "bool", FaceEnvironment.f8430OS);
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(SystemBarTintManager.f1829i)) {
                    return false;
                }
                if ("0".equals(SystemBarTintManager.f1829i)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        /* renamed from: a */
        public int m57667a() {
            return this.f1845d;
        }

        /* renamed from: d */
        public int m57664d() {
            return this.f1847f;
        }

        /* renamed from: f */
        public int m57662f() {
            return this.f1848g;
        }

        /* renamed from: h */
        public int m57660h() {
            if (this.f1843b && m57653o()) {
                return this.f1847f;
            }
            return 0;
        }

        /* renamed from: i */
        public int m57659i() {
            if (!this.f1843b || m57653o()) {
                return 0;
            }
            return this.f1848g;
        }

        /* renamed from: j */
        public int m57658j(boolean z) {
            return (this.f1842a ? this.f1844c : 0) + (z ? this.f1845d : 0);
        }

        /* renamed from: l */
        public int m57656l() {
            return this.f1844c;
        }

        /* renamed from: n */
        public boolean m57654n() {
            return this.f1846e;
        }

        /* renamed from: o */
        public boolean m57653o() {
            return this.f1850i >= 600.0f || this.f1849h;
        }

        private C1146b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f1849h = resources.getConfiguration().orientation == 1;
            this.f1850i = m57657k(activity);
            this.f1844c = m57665c(resources, f1837j);
            this.f1845d = m57666b(activity);
            int m57663e = m57663e(activity);
            this.f1847f = m57663e;
            this.f1848g = m57661g(activity);
            this.f1846e = m57663e > 0;
            this.f1842a = z;
            this.f1843b = z2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f1829i = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f1829i = null;
            }
        }
    }

    @TargetApi(19)
    public SystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            activity.obtainStyledAttributes(new int[]{16843759, 16843760}).recycle();
            int i = window.getAttributes().flags;
            if ((67108864 & i) != 0) {
                this.f1831b = true;
            }
            if ((i & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) {
                this.f1832c = true;
            }
        }
        C1146b c1146b = new C1146b(activity, this.f1831b, this.f1832c);
        this.f1830a = c1146b;
        if (!c1146b.m57654n()) {
            this.f1832c = false;
        }
        if (this.f1831b) {
            m57668t(activity, viewGroup);
        }
        if (this.f1832c) {
            m57669s(activity, viewGroup);
        }
    }

    /* renamed from: s */
    private void m57669s(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f1836g = new View(context);
        if (this.f1830a.m57653o()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f1830a.m57664d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f1830a.m57662f(), -1);
            layoutParams.gravity = 5;
        }
        this.f1836g.setLayoutParams(layoutParams);
        this.f1836g.setBackgroundColor(f1828h);
        this.f1836g.setVisibility(8);
        viewGroup.addView(this.f1836g);
    }

    /* renamed from: t */
    private void m57668t(Context context, ViewGroup viewGroup) {
        this.f1835f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f1830a.m57656l());
        layoutParams.gravity = 48;
        if (this.f1832c && !this.f1830a.m57653o()) {
            layoutParams.rightMargin = this.f1830a.m57662f();
        }
        this.f1835f.setLayoutParams(layoutParams);
        this.f1835f.setBackgroundColor(f1828h);
        this.f1835f.setVisibility(8);
        viewGroup.addView(this.f1835f);
    }

    /* renamed from: b */
    public C1146b m57686b() {
        return this.f1830a;
    }

    /* renamed from: c */
    public boolean m57685c() {
        return this.f1834e;
    }

    /* renamed from: d */
    public boolean m57684d() {
        return this.f1833d;
    }

    @TargetApi(11)
    /* renamed from: e */
    public void m57683e(float f) {
        if (this.f1832c) {
            this.f1836g.setAlpha(f);
        }
    }

    /* renamed from: f */
    public void m57682f(int i) {
        if (this.f1832c) {
            this.f1836g.setBackgroundColor(i);
        }
    }

    /* renamed from: g */
    public void m57681g(Drawable drawable) {
        if (this.f1832c) {
            this.f1836g.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: h */
    public void m57680h(boolean z) {
        this.f1834e = z;
        if (this.f1832c) {
            this.f1836g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: i */
    public void m57679i(int i) {
        if (this.f1832c) {
            this.f1836g.setBackgroundResource(i);
        }
    }

    @TargetApi(11)
    /* renamed from: j */
    public void m57678j(float f) {
        if (this.f1831b) {
            this.f1835f.setAlpha(f);
        }
    }

    /* renamed from: k */
    public void m57677k(int i) {
        if (this.f1831b) {
            this.f1835f.setBackgroundColor(i);
        }
    }

    /* renamed from: l */
    public void m57676l(Drawable drawable) {
        if (this.f1831b) {
            this.f1835f.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: m */
    public void m57675m(boolean z) {
        this.f1833d = z;
        if (this.f1831b) {
            this.f1835f.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: n */
    public void m57674n(int i) {
        if (this.f1831b) {
            this.f1835f.setBackgroundResource(i);
        }
    }

    /* renamed from: o */
    public void m57673o(float f) {
        m57678j(f);
        m57683e(f);
    }

    /* renamed from: p */
    public void m57672p(int i) {
        m57677k(i);
        m57682f(i);
    }

    /* renamed from: q */
    public void m57671q(Drawable drawable) {
        m57676l(drawable);
        m57681g(drawable);
    }

    /* renamed from: r */
    public void m57670r(int i) {
        m57674n(i);
        m57679i(i);
    }
}
