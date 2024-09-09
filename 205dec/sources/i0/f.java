package i0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;

/* compiled from: WindowUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {
    public static int a(Context context, float f4) {
        return (int) TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
    }

    public static AppCompatActivity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return b(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int c(Context context) {
        if (h(context)) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return 0;
    }

    public static int d(Context context, boolean z3) {
        if (z3) {
            return context.getResources().getDisplayMetrics().heightPixels + c(context);
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static double f(Context context) {
        return Math.ceil(context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public static WindowManager g(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean h(Context context) {
        Display defaultDisplay = g(context).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.x == point.x && point2.y == point.y) ? false : true;
    }

    public static void i(Context context) {
        l(context).getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 4098 : 2);
    }

    public static void j(Context context) {
        l(context).getWindow().addFlags(1024);
    }

    public static void k(Context context, boolean z3, boolean z4) {
        AppCompatActivity b4;
        ActionBar supportActionBar;
        if (z3 && (b4 = b(context)) != null && (supportActionBar = b4.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (z4) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().addFlags(1024);
                fragmentActivity.getWindow().addFlags(512);
                return;
            }
            l(context).getWindow().addFlags(1024);
            l(context).getWindow().addFlags(512);
        }
    }

    public static Activity l(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return l(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void m(Context context) {
        l(context).getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public static void n(Context context) {
        l(context).getWindow().clearFlags(1024);
    }

    public static void o(Context context, boolean z3, boolean z4) {
        AppCompatActivity b4;
        ActionBar supportActionBar;
        if (z3 && (b4 = b(context)) != null && (supportActionBar = b4.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (z4) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().clearFlags(1024);
                fragmentActivity.getWindow().clearFlags(512);
                return;
            }
            l(context).getWindow().clearFlags(1024);
            l(context).getWindow().clearFlags(512);
        }
    }

    public static int p(Context context, float f4) {
        return (int) TypedValue.applyDimension(2, f4, context.getResources().getDisplayMetrics());
    }
}
