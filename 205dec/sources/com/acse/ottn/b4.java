package com.acse.ottn;

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
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b4 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5205a = 112;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5206b = R.id.statusbarutil_fake_status_bar_view;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5207c = R.id.statusbarutil_translucent_view;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5208d = -123;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f5209a;

        public a(CoordinatorLayout coordinatorLayout) {
            this.f5209a = coordinatorLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5209a.requestLayout();
        }
    }

    public static int a(@ColorInt int i4, int i5) {
        if (i5 == 0) {
            return i4;
        }
        float f4 = 1.0f - (i5 / 255.0f);
        double d4 = ((i4 >> 16) & 255) * f4;
        Double.isNaN(d4);
        int i6 = (int) (d4 + 0.5d);
        double d5 = ((i4 >> 8) & 255) * f4;
        Double.isNaN(d5);
        double d6 = (i4 & 255) * f4;
        Double.isNaN(d6);
        return ((int) (d6 + 0.5d)) | (i6 << 16) | (-16777216) | (((int) (d5 + 0.5d)) << 8);
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i4) {
        a(activity, drawerLayout, i4, 112);
    }

    public static void b(Activity activity, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
            activity.getWindow().setStatusBarColor(a(i4, i5));
        } else if (i6 >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(f5206b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(a(i4, i5));
            } else {
                viewGroup.addView(a(activity, i4, i5));
            }
            c(activity);
        }
    }

    public static void c(Activity activity, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 19) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            int a4 = a((Context) activity);
            if (childAt != null && (childAt instanceof CoordinatorLayout)) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) childAt;
                if (i6 < 21) {
                    coordinatorLayout.setFitsSystemWindows(false);
                    viewGroup.setBackgroundColor(a(i4, i5));
                    if (viewGroup.getPaddingTop() < a4) {
                        viewGroup.setPadding(0, a4, 0, 0);
                        coordinatorLayout.post(new a(coordinatorLayout));
                    }
                } else {
                    coordinatorLayout.setStatusBarBackgroundColor(a(i4, i5));
                }
            } else {
                viewGroup.setPadding(0, a4, 0, 0);
                viewGroup.setBackgroundColor(a(i4, i5));
            }
            g(activity);
        }
    }

    public static void d(Activity activity, @ColorInt int i4) {
        b(activity, i4, 112);
    }

    @Deprecated
    public static void e(Activity activity, @ColorInt int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            h(activity);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View findViewById = viewGroup.findViewById(f5206b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i4);
            } else {
                viewGroup.addView(b(activity, i4));
            }
            c(activity);
        }
    }

    public static void f(Activity activity, int i4) {
        c(activity, i4, 112);
    }

    public static void g(Activity activity, @ColorInt int i4) {
        b(activity, i4, 0);
    }

    public static void h(Activity activity, @IntRange(from = 0, to = 255) int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            f(activity);
            a(activity, i4);
        }
    }

    public static void i(Activity activity, @IntRange(from = 0, to = 255) int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            h(activity);
            a(activity, i4);
        }
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 19) {
            if (i6 >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f5206b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i4);
            } else {
                viewGroup.addView(b(activity, i4), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), a((Context) activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
            a(drawerLayout, viewGroup);
            a(activity, i5);
        }
    }

    public static void d(Activity activity) {
        h(activity, 112);
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            h(activity);
            c(activity);
        }
    }

    public static void g(Activity activity) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (i4 >= 19) {
            activity.getWindow().setFlags(TTAdConstant.KEY_CLICK_AREA, TTAdConstant.KEY_CLICK_AREA);
        }
    }

    public static void d(Activity activity, DrawerLayout drawerLayout, @IntRange(from = 0, to = 255) int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            c(activity, drawerLayout);
            a(activity, i4);
        }
    }

    @TargetApi(19)
    public static void h(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
            activity.getWindow().addFlags(134217728);
            activity.getWindow().setStatusBarColor(0);
            return;
        }
        activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
    }

    public static void d(Activity activity, View view) {
        b(activity, 0, view);
    }

    @Deprecated
    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            c(activity);
        }
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout, @ColorInt int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f5206b);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(a(i4, 112));
            } else {
                viewGroup.addView(b(activity, i4), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
            }
            a(drawerLayout, viewGroup);
        }
    }

    public static void c(Activity activity, DrawerLayout drawerLayout, @ColorInt int i4) {
        a(activity, drawerLayout, i4, 0);
    }

    public static void a(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    public static void c(Activity activity, DrawerLayout drawerLayout) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 19) {
            if (i4 >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
            }
            a(drawerLayout, viewGroup);
        }
    }

    public static void a(Activity activity, DrawerLayout drawerLayout) {
        d(activity, drawerLayout, 112);
    }

    public static void a(Activity activity, View view) {
        a(activity, 112, view);
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i4, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            g(activity);
            a(activity, i4);
            if (view != null) {
                Object tag = view.getTag(f5208d);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(f5208d, Boolean.TRUE);
                }
            }
        }
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public static void c(Activity activity, View view) {
        a(activity, 0, view);
    }

    public static void c(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    @TargetApi(19)
    public static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f5206b);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    public static void b(Activity activity, View view) {
        b(activity, 112, view);
    }

    public static void b(Activity activity, @IntRange(from = 0, to = 255) int i4, View view) {
        a(activity, i4, view);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 19 || i5 >= 21) {
            return;
        }
        a(activity);
    }

    public static View c(Activity activity, int i4) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(Color.argb(i4, 0, 0, 0));
        view.setId(f5207c);
        return view;
    }

    public static void b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f5206b);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(f5207c);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i4) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(f5207c);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(Color.argb(i4, 0, 0, 0));
            return;
        }
        viewGroup.addView(c(activity, i4));
    }

    public static View b(Activity activity, @ColorInt int i4) {
        return a(activity, i4, 0);
    }

    public static View a(Activity activity, @ColorInt int i4, int i5) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(a(i4, i5));
        view.setId(f5206b);
        return view;
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
