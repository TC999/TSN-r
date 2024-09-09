package com.bytedance.msdk.adapter.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.q;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class UIUtils {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    /* renamed from: a  reason: collision with root package name */
    private static float f27242a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    private static int f27243b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static float f27244c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f27245d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f27246e = -1;

    static {
        init(a.d());
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5, int i6, int i7) {
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

    private static boolean b() {
        return f27242a < 0.0f || f27243b < 0 || f27244c < 0.0f || f27245d < 0 || f27246e < 0;
    }

    private static boolean c(int i4) {
        return i4 == 0 || i4 == 8 || i4 == 4;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean canShow(Context context, View view, int i4) {
        if (view == null) {
            Logger.d("adView is null.");
            return false;
        } else if (view.getParent() == null) {
            Logger.d("adView has no parent.");
            return false;
        } else if (view.getWindowVisibility() != 0) {
            Logger.d("adView window is not set to VISIBLE.");
            return false;
        } else if (view.getVisibility() != 0) {
            Logger.d("adView is not set to VISIBLE.");
            return false;
        } else {
            if (view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
                if (view.getAlpha() < 0.9f) {
                    Logger.d("adView is transparent.");
                    return false;
                }
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                try {
                    view.getLocationOnScreen(iArr);
                    int screenWidth = getScreenWidth(context);
                    int screenHeight = getScreenHeight(context);
                    if (iArr[0] >= 0 && screenWidth - iArr[0] >= width) {
                        double d4 = height;
                        double d5 = i4;
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        int i5 = (int) ((d4 * (100.0d - d5)) / 100.0d);
                        if (iArr[1] < 0 && Math.abs(iArr[1]) > i5) {
                            Logger.d("adView is not visible from the top.");
                            return false;
                        } else if ((height + iArr[1]) - screenHeight > i5) {
                            Logger.d("adView is not visible from the bottom.");
                            return false;
                        } else {
                            Logger.d("adView is visible.");
                            return isScreenOnAndNotInKeygaurdInputMode(context);
                        }
                    }
                    Logger.d("adView is not fully on screen horizontally.");
                } catch (Exception unused) {
                    Logger.d("Cannot get location on screen.");
                    return false;
                }
            } else {
                Logger.d("adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            }
            return false;
        }
    }

    public static float dip2Px(Context context, float f4) {
        init(context);
        return (f4 * getDensity(context)) + 0.5f;
    }

    public static int dp2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Nullable
    public static int[] getCoordinate(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static float getDensity(Context context) {
        init(context);
        return f27242a;
    }

    public static int getDensityDpi(Context context) {
        init(context);
        return f27243b;
    }

    public static int getInt(String str, Activity activity) {
        if (q.t()) {
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

    public static int getRealHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getRealWidth(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float getScaledDensity(Context context) {
        init(context);
        return f27244c;
    }

    public static int getScreenHeight(Context context) {
        init(context);
        return f27246e;
    }

    public static Bitmap getScreenShot(View view) {
        if (view == null) {
            return null;
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static int getScreenWidth(Context context) {
        init(context);
        return f27245d;
    }

    public static float getStatusBarHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    @Nullable
    public static int[] getViewSize(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchScreen(Activity activity) {
        return getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity) || isAndroidPHasNotch(activity);
    }

    public static void hideBottomUIMenu(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i4 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void init(Context context) {
        Context d4 = context == null ? a.d() : context;
        if (d4 == null) {
            return;
        }
        if (b()) {
            DisplayMetrics displayMetrics = d4.getResources().getDisplayMetrics();
            f27242a = displayMetrics.density;
            f27243b = displayMetrics.densityDpi;
            f27244c = displayMetrics.scaledDensity;
            f27245d = displayMetrics.widthPixels;
            f27246e = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i4 = f27245d;
            int i5 = f27246e;
            if (i4 > i5) {
                f27245d = i5;
                f27246e = i4;
                return;
            }
            return;
        }
        int i6 = f27245d;
        int i7 = f27246e;
        if (i6 < i7) {
            f27245d = i7;
            f27246e = i6;
        }
    }

    public static boolean isAndroidPHasNotch(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class<?> cls = Class.forName("android.view.WindowInsets");
                return cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isScreenOnAndNotInKeygaurdInputMode(Context context) {
        KeyguardManager keyguardManager;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager == null || !powerManager.isScreenOn() || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
                return false;
            }
            return !keyguardManager.inKeyguardRestrictedInputMode();
        } catch (Exception e4) {
            Logger.d("adView exception:" + e4.getMessage());
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean isViewVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int px2dip(Context context, float f4) {
        init(context);
        float density = getDensity(context);
        if (density <= 0.0f) {
            density = 1.0f;
        }
        return (int) ((f4 / density) + 0.5f);
    }

    public static int px2sp(Context context, float f4) {
        init(context);
        float scaledDensity = getScaledDensity(context);
        if (scaledDensity <= 0.0f) {
            scaledDensity = 1.0f;
        }
        return (int) ((f4 / scaledDensity) + 0.5f);
    }

    public static void setClickListener(boolean z3, View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        if (z3) {
            view.setOnClickListener(onClickListener);
            view.setClickable(true);
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            Logger.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void setOnTouchListener(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            Logger.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void setViewVisibility(View view, int i4) {
        if (view == null || view.getVisibility() == i4 || !c(i4)) {
            return;
        }
        view.setVisibility(i4);
    }

    public static float sp2px(Context context, float f4) {
        init(context);
        return TypedValue.applyDimension(2, f4, context.getResources().getDisplayMetrics());
    }

    public static void updateLayoutMargin(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i4, i5, i6, i7);
    }

    public int getVirtualBarHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - defaultDisplay.getHeight();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }
}
