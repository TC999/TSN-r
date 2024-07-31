package com.acse.ottn.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.acse.ottn.C1239R;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* renamed from: com.acse.ottn.util.Ja */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1636Ja {

    /* renamed from: a */
    public static final int f3248a = 112;

    /* renamed from: b */
    private static final int f3249b = C1239R.C1242id.statusbarutil_fake_status_bar_view;

    /* renamed from: c */
    private static final int f3250c = C1239R.C1242id.statusbarutil_translucent_view;

    /* renamed from: d */
    private static final int f3251d = -123;

    /* renamed from: a */
    private static int m56232a(@ColorInt int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (i2 / 255.0f);
        double d = ((i >> 16) & 255) * f;
        Double.isNaN(d);
        int i3 = (int) (d + 0.5d);
        double d2 = ((i >> 8) & 255) * f;
        Double.isNaN(d2);
        double d3 = (i & 255) * f;
        Double.isNaN(d3);
        return ((int) (d3 + 0.5d)) | (i3 << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) (d2 + 0.5d)) << 8);
    }

    /* renamed from: a */
    private static int m56223a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: a */
    public static void m56231a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f3249b);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(f3250c);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    /* renamed from: a */
    public static void m56230a(Activity activity, @ColorInt int i) {
        m56229a(activity, i, 112);
    }

    /* renamed from: a */
    public static void m56229a(Activity activity, @ColorInt int i, @IntRange(from = 0, m60035to = 255) int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(m56232a(i, i2));
        } else if (i3 >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(f3249b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(m56232a(i, i2));
            } else {
                viewGroup.addView(m56212c(activity, i, i2));
            }
            m56202f(activity);
        }
    }

    /* renamed from: a */
    public static void m56228a(Activity activity, @IntRange(from = 0, m60035to = 255) int i, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56200g(activity);
            m56199g(activity, i);
            if (view != null) {
                Object tag = view.getTag(f3251d);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + m56223a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(f3251d, Boolean.TRUE);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m56227a(Activity activity, View view) {
        m56228a(activity, 112, view);
    }

    /* renamed from: a */
    public static void m56226a(Activity activity, DrawerLayout drawerLayout) {
        m56205d(activity, drawerLayout, 112);
    }

    /* renamed from: a */
    public static void m56225a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        m56224a(activity, drawerLayout, i, 112);
    }

    /* renamed from: a */
    public static void m56224a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i, @IntRange(from = 0, m60035to = 255) int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            if (i3 >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(67108864);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f3249b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i);
            } else {
                viewGroup.addView(m56197h(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), m56223a((Context) activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
            m56222a(drawerLayout, viewGroup);
            m56199g(activity, i2);
        }
    }

    /* renamed from: a */
    private static void m56222a(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    /* renamed from: b */
    public static void m56221b(Activity activity) {
        m56203e(activity, 112);
    }

    @Deprecated
    /* renamed from: b */
    public static void m56220b(Activity activity, @ColorInt int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56198h(activity);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View findViewById = viewGroup.findViewById(f3249b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i);
            } else {
                viewGroup.addView(m56197h(activity, i));
            }
            m56202f(activity);
        }
    }

    /* renamed from: b */
    public static void m56219b(Activity activity, @ColorInt int i, @IntRange(from = 0, m60035to = 255) int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            int m56223a = m56223a((Context) activity);
            if (childAt == null || !(childAt instanceof CoordinatorLayout)) {
                viewGroup.setPadding(0, m56223a, 0, 0);
                viewGroup.setBackgroundColor(m56232a(i, i2));
            } else {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) childAt;
                if (i3 < 21) {
                    coordinatorLayout.setFitsSystemWindows(false);
                    viewGroup.setBackgroundColor(m56232a(i, i2));
                    if (viewGroup.getPaddingTop() < m56223a) {
                        viewGroup.setPadding(0, m56223a, 0, 0);
                        coordinatorLayout.post(new RunnableC1634Ia(coordinatorLayout));
                    }
                } else {
                    coordinatorLayout.setStatusBarBackgroundColor(m56232a(i, i2));
                }
            }
            m56200g(activity);
        }
    }

    /* renamed from: b */
    public static void m56218b(Activity activity, @IntRange(from = 0, m60035to = 255) int i, View view) {
        m56228a(activity, i, view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 21) {
            return;
        }
        m56204e(activity);
    }

    /* renamed from: b */
    public static void m56217b(Activity activity, View view) {
        m56218b(activity, 112, view);
    }

    @Deprecated
    /* renamed from: b */
    public static void m56216b(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    @Deprecated
    /* renamed from: b */
    public static void m56215b(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f3249b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(m56232a(i, 112));
            } else {
                viewGroup.addView(m56197h(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, m56223a((Context) activity), 0, 0);
            }
            m56222a(drawerLayout, viewGroup);
        }
    }

    /* renamed from: c */
    private static View m56212c(Activity activity, @ColorInt int i, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m56223a((Context) activity)));
        view.setBackgroundColor(m56232a(i, i2));
        view.setId(f3249b);
        return view;
    }

    @Deprecated
    /* renamed from: c */
    public static void m56214c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            m56202f(activity);
        }
    }

    /* renamed from: c */
    public static void m56213c(Activity activity, int i) {
        m56219b(activity, i, 112);
    }

    /* renamed from: c */
    public static void m56211c(Activity activity, View view) {
        m56228a(activity, 0, view);
    }

    /* renamed from: c */
    public static void m56210c(Activity activity, DrawerLayout drawerLayout) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (i >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(67108864);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, m56223a((Context) activity), 0, 0);
            }
            m56222a(drawerLayout, viewGroup);
        }
    }

    /* renamed from: c */
    public static void m56209c(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        m56224a(activity, drawerLayout, i, 0);
    }

    /* renamed from: d */
    public static void m56208d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56198h(activity);
            m56202f(activity);
        }
    }

    /* renamed from: d */
    public static void m56207d(Activity activity, @ColorInt int i) {
        m56229a(activity, i, 0);
    }

    /* renamed from: d */
    public static void m56206d(Activity activity, View view) {
        m56218b(activity, 0, view);
    }

    /* renamed from: d */
    public static void m56205d(Activity activity, DrawerLayout drawerLayout, @IntRange(from = 0, m60035to = 255) int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56210c(activity, drawerLayout);
            m56199g(activity, i);
        }
    }

    @TargetApi(19)
    /* renamed from: e */
    private static void m56204e(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f3249b);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    /* renamed from: e */
    public static void m56203e(Activity activity, @IntRange(from = 0, m60035to = 255) int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56208d(activity);
            m56199g(activity, i);
        }
    }

    /* renamed from: f */
    private static void m56202f(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    /* renamed from: f */
    public static void m56201f(Activity activity, @IntRange(from = 0, m60035to = 255) int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m56198h(activity);
            m56199g(activity, i);
        }
    }

    /* renamed from: g */
    private static void m56200g(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
        } else if (i >= 19) {
            activity.getWindow().setFlags(67108864, 67108864);
        }
    }

    /* renamed from: g */
    private static void m56199g(Activity activity, @IntRange(from = 0, m60035to = 255) int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(f3250c);
        if (findViewById == null) {
            viewGroup.addView(m56196i(activity, i));
            return;
        }
        if (findViewById.getVisibility() == 8) {
            findViewById.setVisibility(0);
        }
        findViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
    }

    /* renamed from: h */
    private static View m56197h(Activity activity, @ColorInt int i) {
        return m56212c(activity, i, 0);
    }

    @TargetApi(19)
    /* renamed from: h */
    private static void m56198h(Activity activity) {
        if (Build.VERSION.SDK_INT < 21) {
            activity.getWindow().addFlags(67108864);
            return;
        }
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        activity.getWindow().setStatusBarColor(0);
    }

    /* renamed from: i */
    private static View m56196i(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m56223a((Context) activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setId(f3250c);
        return view;
    }
}
