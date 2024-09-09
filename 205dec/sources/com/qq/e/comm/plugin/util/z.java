package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final g f46730a = g.b.a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static abstract class a implements g {

        /* renamed from: b  reason: collision with root package name */
        private static final String f46731b = "z$a";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.util.z$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class View$OnAttachStateChangeListenerC0909a implements View.OnAttachStateChangeListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Activity f46732c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f46733d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ boolean f46734e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f46735f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Window f46736g;

            View$OnAttachStateChangeListenerC0909a(Activity activity, boolean z3, boolean z4, boolean z5, Window window) {
                this.f46732c = activity;
                this.f46733d = z3;
                this.f46734e = z4;
                this.f46735f = z5;
                this.f46736g = window;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.a(this.f46732c, this.f46733d, this.f46734e, this.f46735f, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.f46736g.getDecorView().removeOnAttachStateChangeListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class b implements View.OnSystemUiVisibilityChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Activity f46738a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f46739b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f46740c;

            b(Activity activity, boolean z3, boolean z4) {
                this.f46738a = activity;
                this.f46739b = z3;
                this.f46740c = z4;
            }

            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i4) {
                a.this.a(this.f46738a, this.f46739b, this.f46740c, false, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class c implements View.OnAttachStateChangeListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f46742c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f46743d;

            c(View view, int i4) {
                this.f46742c = view;
                this.f46743d = i4;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.a(this.f46742c, this.f46743d, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.f46742c.removeOnAttachStateChangeListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class d implements View.OnAttachStateChangeListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f46745c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f46746d;

            d(View view, int i4) {
                this.f46745c = view;
                this.f46746d = i4;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.b(this.f46745c, this.f46746d, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.f46745c.removeOnAttachStateChangeListener(this);
            }
        }

        protected int a(Context context) {
            return 0;
        }

        protected void a(Activity activity) {
        }

        public int b(View view) {
            int a4;
            Context context = view.getContext();
            if (c(view)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    a4 = a(context, a(view));
                } else {
                    a4 = a(context);
                }
                int i4 = b() ? a4 : 0;
                String str = f46731b;
                d1.a(str, "getNotchHeight, notch_height = " + i4);
                return i4;
            }
            return 0;
        }

        protected boolean b() {
            return true;
        }

        protected boolean b(Context context) {
            return false;
        }

        public boolean c(View view) {
            return b(view.getContext());
        }

        public boolean d(Activity activity) {
            return b((Context) activity);
        }

        public int a(Context context, DisplayCutout displayCutout) {
            int safeInsetLeft;
            if (Build.VERSION.SDK_INT < 28 || displayCutout == null) {
                return 0;
            }
            if (context.getResources().getConfiguration().orientation == 1) {
                safeInsetLeft = displayCutout.getSafeInsetTop();
            } else if (displayCutout.getSafeInsetLeft() == 0) {
                safeInsetLeft = displayCutout.getSafeInsetRight();
            } else {
                safeInsetLeft = displayCutout.getSafeInsetLeft();
            }
            String str = f46731b;
            d1.a(str, "getNotchHeightAtAndroidP, notch_height = " + safeInsetLeft);
            return safeInsetLeft;
        }

        public int c(Activity activity) {
            int a4;
            if (d(activity) && b()) {
                if (Build.VERSION.SDK_INT >= 28) {
                    a4 = a(activity, b(activity));
                } else {
                    a4 = a((Context) activity);
                }
                String str = f46731b;
                d1.a(str, "getNotchHeight, notch_height = " + a4);
                return a4;
            }
            return 0;
        }

        @Override // com.qq.e.comm.plugin.util.z.g
        public int a() {
            int a4 = a(com.qq.e.comm.plugin.d0.a.d().a(), "status_bar_height");
            String str = f46731b;
            d1.a(str, "getStatusBarHeight, status_bar_height = " + a4);
            return a4;
        }

        protected DisplayCutout a(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = view.getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }

        protected DisplayCutout b(Activity activity) {
            Window window;
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 28 || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }

        @Override // com.qq.e.comm.plugin.util.z.g
        public void a(Activity activity, boolean z3, boolean z4) {
            a(activity, true, z3, true, z4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Activity activity, boolean z3, boolean z4, boolean z5, boolean z6) {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            if (z6) {
                window.getDecorView().addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0909a(activity, z3, z4, z5, window));
                return;
            }
            a(activity, z3);
            int i4 = 0;
            if (Build.VERSION.SDK_INT >= 16) {
                i4 = 1284;
                if (z4) {
                    i4 = 1798;
                }
            }
            window.getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? i4 | 4096 : i4 | 1);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            a(activity);
            if (z5) {
                window.getDecorView().setOnSystemUiVisibilityChangeListener(new b(activity, z3, z4));
            }
        }

        @Override // com.qq.e.comm.plugin.util.z.g
        public void b(Activity activity, boolean z3, boolean z4) {
            a(activity, false, z3, true, z4);
        }

        @Override // com.qq.e.comm.plugin.util.z.g
        public void b(View view, int i4, boolean z3) {
            if (z3) {
                view.addOnAttachStateChangeListener(new d(view, i4));
                return;
            }
            int rotation = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            Rect rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            a(rotation, i4, rect, b(view));
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }

        private void a(Activity activity, boolean z3) {
            ViewGroup viewGroup;
            Window window = activity.getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView().findViewWithTag("NOTCH_CONTAINER")) == null) {
                return;
            }
            if (viewGroup.getChildCount() == 0) {
                View view = new View(activity);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, c(activity)));
                viewGroup.addView(view);
            }
            if (z3) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.setVisibility(0);
            }
        }

        @Override // com.qq.e.comm.plugin.util.z.g
        public void a(View view, int i4, boolean z3) {
            if (z3) {
                view.addOnAttachStateChangeListener(new c(view, i4));
            } else if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                int rotation = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                Rect rect = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                a(rotation, i4, rect, b(view));
                marginLayoutParams.setMargins(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        private void a(int i4, int i5, Rect rect, int i6) {
            if (i4 == 0) {
                if ((i5 & 2) == 2 || i5 == 0) {
                    rect.top += i6;
                }
            } else if (i4 == 1 || i4 == 3) {
                if ((i5 & 1) == 1) {
                    rect.left += i6;
                }
                if ((i5 & 4) == 4) {
                    rect.right += i6;
                }
                if (i5 == 0) {
                    rect.left += i6;
                    rect.right += i6;
                }
            }
        }

        protected int a(Context context, String str) {
            try {
                int identifier = context.getResources().getIdentifier(str, "dimen", "android");
                if (identifier > 0) {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                    if (dimensionPixelSize2 >= dimensionPixelSize) {
                        return dimensionPixelSize2;
                    }
                    float f4 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                    return (int) (f4 >= 0.0f ? f4 + 0.5f : f4 - 0.5f);
                }
                return 0;
            } catch (Exception e4) {
                d1.a(f46731b, "getInternalDimensionSize Exception", e4);
                return 0;
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46749c = "z$c";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4;
            if (c()) {
                a4 = a();
            } else {
                a4 = a(context, "fringe_height");
            }
            String str = f46749c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
                return ((Boolean) Class.forName("flyme.config.FlymeFeature").getDeclaredField("IS_FRINGE_DEVICE").get(null)).booleanValue();
            } catch (Exception e4) {
                d1.a(f46749c, "hasNotch, Exception", e4);
                return false;
            }
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "mz_fringe_hide", 0) == 1;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46750c = "z$d";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4 = a();
            if (80 >= a4) {
                a4 = 80;
            }
            String str = f46750c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
                return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            } catch (Exception e4) {
                d1.a(f46750c, "hasNotch, Exception", e4);
                return false;
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e extends a {
        @Override // com.qq.e.comm.plugin.util.z.a
        public boolean c(View view) {
            return super.a(view.getContext(), a(view)) > 0;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        public boolean d(Activity activity) {
            return super.a(activity, b(activity)) > 0;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class f extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46751c = "z$f";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4 = a();
            String str = f46751c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
            } catch (Exception e4) {
                d1.a(f46751c, "hasNotch, Exception", e4);
            }
            return context.getResources().getIdentifier("config_mainBuiltInDisplayCutout", "string", "android") > 0;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface g {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46752a = a.a();

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public enum a {
            HUAWEI("Huawei"),
            XIAOMI("Xiaomi"),
            VIVO("vivo"),
            f46756g(BaseConstants.ROM_OPPO_UPPER_CONSTANT),
            MEIZU("Meizu"),
            SAMSUNG("samsung"),
            SMARTISAN("Smartisan");
            

            /* renamed from: c  reason: collision with root package name */
            private final String f46761c;

            a(String str) {
                this.f46761c = str;
            }

            public static a a() {
                a[] values;
                for (a aVar : values()) {
                    if (aVar.f46761c.equalsIgnoreCase(Build.MANUFACTURER) || aVar.f46761c.equalsIgnoreCase(Build.BRAND)) {
                        return aVar;
                    }
                }
                return null;
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public static class b {
            public static g a() {
                if (a.HUAWEI == g.f46752a) {
                    return new b();
                }
                if (a.XIAOMI == g.f46752a) {
                    return new j();
                }
                if (a.VIVO == g.f46752a) {
                    return new i();
                }
                if (a.f46756g == g.f46752a) {
                    return new d();
                }
                if (a.MEIZU == g.f46752a) {
                    return new c();
                }
                if (a.SAMSUNG == g.f46752a) {
                    return new f();
                }
                if (a.SMARTISAN == g.f46752a) {
                    return new h();
                }
                return new e();
            }
        }

        int a();

        void a(Activity activity, boolean z3, boolean z4);

        void a(View view, int i4, boolean z3);

        void b(Activity activity, boolean z3, boolean z4);

        void b(View view, int i4, boolean z3);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class h extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46762c = "z$h";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4 = a();
            if (82 >= a4) {
                a4 = 82;
            }
            String str = f46762c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("smartisanos.api.DisplayUtilsSmt");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 1)).booleanValue();
            } catch (Exception e4) {
                d1.a(f46762c, "hasNotch, Exception", e4);
                return false;
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class i extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46763c = "z$i";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4 = a();
            int a5 = f1.a(context, 27);
            if (a5 >= a4) {
                a4 = a5;
            }
            String str = f46763c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            } catch (Exception e4) {
                d1.a(f46763c, "hasNotch, Exception", e4);
                return false;
            }
        }
    }

    private static DisplayMetrics a() {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) a4.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private static int b() {
        return a().widthPixels;
    }

    public static int c() {
        return b();
    }

    public static int d() {
        return f46730a.a();
    }

    public static void c(Activity activity, boolean z3) {
        f46730a.a(activity, z3, true);
    }

    public static void d(Activity activity, boolean z3) {
        Window window;
        if (z3 && (window = activity.getWindow()) != null) {
            window.setFlags(8, 8);
        }
    }

    public static void b(Activity activity, boolean z3) {
        f46730a.b(activity, z3, true);
    }

    public static void b(Activity activity, boolean z3, boolean z4) {
        f46730a.a(activity, z3, z4);
    }

    public static void b(View view, int i4) {
        f46730a.b(view, i4, true);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46748c = "z$b";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]))[0];
            } catch (Exception e4) {
                d1.a(f46748c, "getNotchHeightPrivate, Exception", e4);
                return 0;
            }
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (Exception e4) {
                d1.a(f46748c, "hasNotch, Exception", e4);
                return false;
            }
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Secure.getInt(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "display_notch_status", 0) == 1;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        public void a(Activity activity) {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception e4) {
                d1.a(f46748c, "getNotchHeightPrivate, Exception", e4);
            }
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b() {
            int rotation = ((WindowManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("window")).getDefaultDisplay().getRotation();
            if (c()) {
                return (rotation == 1 || rotation == 3) ? false : true;
            }
            return true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class j extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f46764c = "z$j";

        @Override // com.qq.e.comm.plugin.util.z.a
        protected int a(Context context) {
            int a4;
            if (c()) {
                a4 = a();
            } else {
                a4 = a(context, "notch_height");
            }
            String str = f46764c;
            d1.a(str, "getNotchHeightPrivate, notch_height = " + a4);
            return a4;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected boolean b(Context context) {
            int i4;
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                i4 = ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue();
            } catch (Exception e4) {
                d1.a(f46764c, "hasNotch, Exception", e4);
                i4 = 0;
            }
            return i4 == 1;
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "force_black", 0) == 1;
        }

        @Override // com.qq.e.comm.plugin.util.z.a
        protected void a(Activity activity) {
            if (Build.VERSION.SDK_INT < 26 || !d(activity)) {
                return;
            }
            try {
                Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(activity.getWindow(), 1792);
            } catch (Exception e4) {
                d1.a(f46764c, e4.getMessage(), e4);
            }
        }
    }

    public static void a(Activity activity, boolean z3, boolean z4) {
        f46730a.b(activity, z3, z4);
    }

    public static void a(View view, int i4) {
        f46730a.a(view, i4, true);
    }

    public static void a(Activity activity, boolean z3) {
        Window window;
        if (z3 && (window = activity.getWindow()) != null) {
            window.clearFlags(8);
        }
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("fshng", eVar.q0(), 1);
        if (a4 == 0) {
            return false;
        }
        return a4 == 1 || com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), 1) == 1;
    }
}
