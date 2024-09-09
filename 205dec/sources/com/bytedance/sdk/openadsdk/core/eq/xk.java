package com.bytedance.sdk.openadsdk.core.eq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.component.widget.SSWebView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xk {

    /* renamed from: c  reason: collision with root package name */
    public static volatile int f33354c = -1;
    private static float ev = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f33355f = -1;

    /* renamed from: r  reason: collision with root package name */
    private static int f33356r = 13;
    private static volatile float sr = -1.0f;
    private static volatile int ux = -1;

    /* renamed from: w  reason: collision with root package name */
    private static volatile float f33357w = -1.0f;
    private static volatile int xv = -1;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(View view);
    }

    public static boolean a(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean bk(Context context) {
        try {
            if ("V1938CT".equals(com.bytedance.sdk.openadsdk.core.i.u())) {
                return false;
            }
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (sr()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            f33357w = displayMetrics.density;
            xv = displayMetrics.densityDpi;
            sr = displayMetrics.scaledDensity;
            ux = displayMetrics.widthPixels;
            f33355f = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (ux > f33355f) {
                    int i4 = ux;
                    ux = f33355f;
                    f33355f = i4;
                }
            } else if (ux < f33355f) {
                int i5 = ux;
                ux = f33355f;
                f33355f = i5;
            }
        }
    }

    private static boolean c(int i4) {
        return i4 == 0 || i4 == 8 || i4 == 4;
    }

    public static int ev(Context context) {
        c(context);
        return xv;
    }

    public static float f(Context context) {
        c(context);
        return f33357w;
    }

    public static boolean fp(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static int gd(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static float ia(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static float k(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        try {
            int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.sr("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    public static int p(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float r(Context context) {
        c(context);
        return sr;
    }

    private static boolean sr() {
        return f33357w < 0.0f || xv < 0 || sr < 0.0f || ux < 0 || f33355f < 0;
    }

    public static boolean t(Context context) {
        String gd = wv.gd("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(gd);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int ux(Context context) {
        c(context);
        return f33355f;
    }

    public static float xv(Context context, float f4) {
        c(context);
        return (f4 * ia(context)) + 0.5f;
    }

    public static boolean ys(Context context) {
        String u3 = com.bytedance.sdk.openadsdk.core.i.u();
        return u3.equals("IN2010") || u3.equals("IN2020") || u3.equals("KB2000");
    }

    public static int sr(Context context, float f4) {
        c(context);
        float ia = ia(context);
        if (ia <= 0.0f) {
            ia = 1.0f;
        }
        return (int) ((f4 / ia) + 0.5f);
    }

    public static int w(Context context, float f4) {
        c(context);
        float r3 = r(context);
        if (r3 <= 0.0f) {
            r3 = 1.0f;
        }
        return (int) ((f4 / r3) + 0.5f);
    }

    public static void ev(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void f(View view) {
        if (view == null) {
            return;
        }
        c(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static Bitmap r(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        return createBitmap;
    }

    public static void ux(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                xk.c(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static int[] xv(Context context) {
        c(context);
        return new int[]{ux, f33355f};
    }

    public static int sr(Context context) {
        c(context);
        return ux;
    }

    public static int[] w(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] xv(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean ev(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean sr(View view) {
        return view != null && view.getVisibility() == 0;
    }

    private static boolean gd(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (gd((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0) {
                    if (p((Context) activity) - activity.getWindow().getDecorView().getWidth() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void p(Activity activity) {
        Class<?>[] declaredClasses;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Throwable unused) {
        }
    }

    public static void sr(Activity activity) {
        if (xv()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !xk.xv()) {
                                    xk.f33354c = xk.xv(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static int ux(Context context, float f4) {
        return (int) ((f4 * ia(context)) + 0.5f);
    }

    private static Bitmap xv(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            if (capturePicture != null && capturePicture.getWidth() > 0 && capturePicture.getHeight() > 0) {
                bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                capturePicture.draw(new Canvas(bitmap));
                return bitmap;
            }
            return null;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    public static void f(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                p(activity);
            } else {
                r(activity);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean ux(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static Bitmap sr(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();
            if (webView.getMeasuredWidth() > 0 && webView.getMeasuredHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(createBitmap, 0.0f, createBitmap.getHeight(), new Paint());
                webView.draw(canvas);
                return createBitmap;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean xv(Activity activity) {
        return ux(activity) || c("ro.miui.notch", activity) == 1 || a(activity) || bk(activity) || ys(activity) || fp(activity) || gd(activity) || t(activity);
    }

    public static void r(Activity activity) {
        Class<?>[] declaredClasses;
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    public static int[] w(View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return null;
    }

    public static void w(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        c(view, (ViewGroup.MarginLayoutParams) layoutParams, i4, i5, i6, i7);
    }

    public static float c(Context context, float f4) {
        c(context);
        return TypedValue.applyDimension(2, f4, context.getResources().getDisplayMetrics());
    }

    public static boolean xv() {
        return f33354c != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, String str, String str2, Bitmap bitmap, boolean z3, int i4) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    int c4 = c(bitmap);
                    if (c4 >= 50 || z3) {
                        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, str, str2, c4, i4);
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("UIUtils", "(\u5f00\u53d1\u8005\u53ef\u5ffd\u7565\u6b64\u68c0\u6d4b\u5f02\u5e38)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    public static void c(View view, int i4, int i5, int i6, int i7) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i4;
        rect.bottom += i5;
        rect.left -= i6;
        rect.right += i7;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.r(rect, view));
    }

    public static void w(Activity activity) {
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i4 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(2050);
            }
            activity.getWindow().addFlags(134217728);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean w() {
        return f33354c == 1 || f33354c == -1;
    }

    public static int[] c(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static Bitmap w(WebView webView) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap sr2 = sr(webView);
        if (sr2 == null) {
            sr2 = xv(webView);
        }
        webView.setLayerType(layerType, null);
        if (sr2 == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.sr.c(sr2, sr2.getWidth() / 6, sr2.getHeight() / 6);
    }

    public static void c(View view, int i4) {
        if (view == null || view.getVisibility() == i4 || !c(i4)) {
            return;
        }
        view.setVisibility(i4);
    }

    public static void c(View view, float f4) {
        if (view == null) {
            return;
        }
        view.setAlpha(f4);
    }

    public static boolean c(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.sr()) {
            return false;
        }
        sSWebView.ux();
        return true;
    }

    public static void c(WebView webView) {
        WebSettings settings;
        if (webView == null || (settings = webView.getSettings()) == null) {
            return;
        }
        settings.setTextZoom(100);
    }

    private static ArrayList<Integer> w(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i4 = width * height;
            int[] iArr = new int[i4];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = iArr[i5];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i6) >> 16, (65280 & i6) >> 8, i6 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void c(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5, int i6, int i7) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i4 && marginLayoutParams.topMargin == i5 && marginLayoutParams.rightMargin == i6 && marginLayoutParams.bottomMargin == i7) {
            return;
        }
        if (i4 != -3) {
            marginLayoutParams.leftMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.topMargin = i5;
        }
        if (i6 != -3) {
            marginLayoutParams.rightMargin = i6;
        }
        if (i7 != -3) {
            marginLayoutParams.bottomMargin = i7;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static void w(View view, final float f4) {
        if (view != null && f4 > 0.0f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.7
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view2, Outline outline) {
                        if (outline == null) {
                            return;
                        }
                        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f4);
                    }
                });
                view.setClipToOutline(true);
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(f4);
            view.setBackground(gradientDrawable);
        }
    }

    public static boolean c() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i4 = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.k.sr().c() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!c())) {
                    i4 = 0;
                }
                jSONObject.put("lock_scene", i4);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.xv("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void c(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i4 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                w(activity);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void c(View view, View view2) {
        if (view != null && view2 != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28 && ev == 0.0f) {
                    WindowInsets rootWindowInsets = view.getRootWindowInsets();
                    DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                    if (displayCutout != null) {
                        ev = displayCutout.getSafeInsetTop();
                    }
                }
                if (ev == 0.0f) {
                    return;
                }
                float max = Math.max(k(view2.getContext()), ev);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = (int) (layoutParams2.topMargin + max);
                }
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams3.topMargin = (int) (layoutParams3.topMargin + max);
                }
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams4.topMargin = (int) (layoutParams4.topMargin + max);
                }
                view2.setLayoutParams(layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    public static int c(String str, Activity activity) {
        if (ls.w()) {
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
                return 0;
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return 0;
            } catch (IllegalArgumentException e6) {
                e6.printStackTrace();
                return 0;
            } catch (NoSuchMethodException e7) {
                e7.printStackTrace();
                return 0;
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static void c(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.a.f("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void c(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.a.f("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void c(final Context context, final com.bytedance.sdk.openadsdk.core.u.me meVar, final String str, final String str2, final Bitmap bitmap, final boolean z3, final int i4) {
        com.bytedance.sdk.component.gd.ev.c(new com.bytedance.sdk.component.gd.p("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.4
            @Override // java.lang.Runnable
            public void run() {
                xk.xv(context, meVar, str, str2, bitmap, z3, i4);
            }
        }, 5);
    }

    public static int c(Bitmap bitmap) {
        try {
            ArrayList<Integer> w3 = w(bitmap);
            if (w3 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it = w3.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i4 = 0;
            int i5 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i5 < intValue) {
                    i4 = ((Integer) entry.getKey()).intValue();
                    i5 = intValue;
                }
            }
            if (i4 == 0) {
                return -1;
            }
            return (int) ((i5 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void c(final View view, final c cVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view);
                }
            }
        });
    }

    public static void c(View view, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (view == null || meVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.eq.xk.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.u.me.this);
            }
        });
    }

    public static void c(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(ux(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.i.r(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(ux(context, 2.0f), ux(context, 3.0f), ux(context, 2.0f), ux(context, 3.0f));
    }

    public static void c(TextView textView, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (textView != null && meVar != null) {
            String ez = meVar.ez();
            if (TextUtils.isEmpty(ez)) {
                c(textView);
                c((View) textView, meVar);
                return;
            }
            c(textView, ez, com.bytedance.sdk.openadsdk.core.ls.getContext());
            return;
        }
        c(textView);
    }

    public static void c(TextView textView, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, int i5) {
        if (textView != null && meVar != null) {
            String ez = meVar.ez();
            if (TextUtils.isEmpty(ez)) {
                c(textView, i4, i5);
                c((View) textView, meVar);
                return;
            }
            c(textView, ez, com.bytedance.sdk.openadsdk.core.ls.getContext());
            return;
        }
        c(textView, i4, i5);
    }

    private static void c(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ux(com.bytedance.sdk.openadsdk.core.ls.getContext(), 32.0f);
        layoutParams.height = ux(com.bytedance.sdk.openadsdk.core.ls.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void c(TextView textView, int i4, int i5) {
        if (i4 <= 0) {
            i4 = 32;
        }
        if (i5 <= 0) {
            i5 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ux(com.bytedance.sdk.openadsdk.core.ls.getContext(), i4);
        layoutParams.height = ux(com.bytedance.sdk.openadsdk.core.ls.getContext(), i5);
        textView.setLayoutParams(layoutParams);
    }

    public static void c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.c.c.w().c(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int ux2 = ux(context, 20.0f);
        int ux3 = ux(context, 11.0f);
        textView.setPadding(ux2, ux3, ux2, ux3);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(f33356r);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.show();
    }
}
