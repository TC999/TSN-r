package p601i0;

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
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: WindowUtil.java */
/* renamed from: i0.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13584f {
    /* renamed from: a */
    public static int m12710a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    public static AppCompatActivity m12709b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return m12709b(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: c */
    public static int m12708c(Context context) {
        if (m12703h(context)) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.f8430OS));
        }
        return 0;
    }

    /* renamed from: d */
    public static int m12707d(Context context, boolean z) {
        if (z) {
            return context.getResources().getDisplayMetrics().heightPixels + m12708c(context);
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: e */
    public static int m12706e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: f */
    public static double m12705f(Context context) {
        return Math.ceil(context.getResources().getDisplayMetrics().density * 25.0f);
    }

    /* renamed from: g */
    public static WindowManager m12704g(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    /* renamed from: h */
    public static boolean m12703h(Context context) {
        Display defaultDisplay = m12704g(context).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.x == point.x && point2.y == point.y) ? false : true;
    }

    /* renamed from: i */
    public static void m12702i(Context context) {
        m12699l(context).getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 4098 : 2);
    }

    /* renamed from: j */
    public static void m12701j(Context context) {
        m12699l(context).getWindow().addFlags(1024);
    }

    /* renamed from: k */
    public static void m12700k(Context context, boolean z, boolean z2) {
        AppCompatActivity m12709b;
        ActionBar supportActionBar;
        if (z && (m12709b = m12709b(context)) != null && (supportActionBar = m12709b.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (z2) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().addFlags(1024);
                fragmentActivity.getWindow().addFlags(512);
                return;
            }
            m12699l(context).getWindow().addFlags(1024);
            m12699l(context).getWindow().addFlags(512);
        }
    }

    /* renamed from: l */
    public static Activity m12699l(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m12699l(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: m */
    public static void m12698m(Context context) {
        m12699l(context).getWindow().getDecorView().setSystemUiVisibility(0);
    }

    /* renamed from: n */
    public static void m12697n(Context context) {
        m12699l(context).getWindow().clearFlags(1024);
    }

    /* renamed from: o */
    public static void m12696o(Context context, boolean z, boolean z2) {
        AppCompatActivity m12709b;
        ActionBar supportActionBar;
        if (z && (m12709b = m12709b(context)) != null && (supportActionBar = m12709b.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (z2) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().clearFlags(1024);
                fragmentActivity.getWindow().clearFlags(512);
                return;
            }
            m12699l(context).getWindow().clearFlags(1024);
            m12699l(context).getWindow().clearFlags(512);
        }
    }

    /* renamed from: p */
    public static int m12695p(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
