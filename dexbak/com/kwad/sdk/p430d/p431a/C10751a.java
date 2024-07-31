package com.kwad.sdk.p430d.p431a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.sdk.core.view.C10591a;
import com.kwad.sdk.utils.C11124s;

/* renamed from: com.kwad.sdk.d.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10751a {
    private static int anx;
    private static long any;

    /* renamed from: Au */
    public static boolean m24929Au() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - any) < 500) {
            any = uptimeMillis;
            return true;
        }
        any = uptimeMillis;
        return false;
    }

    /* renamed from: C */
    public static boolean m24928C(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    /* renamed from: D */
    public static void m24927D(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    /* renamed from: E */
    public static int[] m24926E(View view) {
        if (view == null) {
            return null;
        }
        view.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
        return iArr;
    }

    /* renamed from: F */
    public static int m24925F(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m24924a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    /* renamed from: aI */
    public static int m24920aI(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: aJ */
    public static float m24919aJ(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: b */
    public static boolean m24918b(Activity activity) {
        return m24916b(activity.getWindow());
    }

    /* renamed from: c */
    private static View m24915c(@NonNull Activity activity) {
        return m24914c(activity.getWindow());
    }

    /* renamed from: d */
    public static int m24913d(@NonNull Activity activity) {
        return m24915c(activity).getWidth();
    }

    /* renamed from: e */
    public static int m24911e(@NonNull Activity activity) {
        return m24915c(activity).getHeight();
    }

    /* renamed from: f */
    public static void m24909f(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height && i <= i2) {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: g */
    public static int m24908g(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i) {
        return context.getResources().getColor(i);
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i = anx;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS);
            if (identifier > 0) {
                anx = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    anx = context.getResources().getDimensionPixelSize(((Integer) C11124s.getField("com.android.internal.R$dimen", "status_bar_height")).intValue());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (anx <= 0) {
                anx = m24924a(context, 25.0f);
            }
            return anx;
        }
        return i;
    }

    /* renamed from: m */
    public static void m24907m(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: n */
    public static void m24906n(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static void m24923a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: b */
    private static boolean m24916b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    /* renamed from: c */
    private static View m24914c(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    /* renamed from: d */
    public static void m24912d(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i > i2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i2 > i) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    public static void m24910e(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    public static void m24917b(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, 0);
            view.requestLayout();
        }
    }

    /* renamed from: a */
    public static View m24922a(ViewGroup viewGroup, int i, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    /* renamed from: a */
    public static void m24921a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, m24924a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i = 0;
            int i2 = 1;
            int i3 = 1;
            boolean z = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i, i2));
                if (measureText < width) {
                    if (i3 == textView.getMaxLines()) {
                        float f = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f < width && f + paint.measureText("...") + paint.measureText(" ") < width) {
                            if (z) {
                                str2 = str2.substring(0, i2) + "... ";
                                break;
                            }
                        } else {
                            i2--;
                            z = true;
                        }
                    }
                    i2++;
                } else {
                    i = i2 - 1;
                    i3++;
                }
                if (i2 <= str2.length()) {
                    if (i3 > textView.getMaxLines()) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        String str3 = str2 + "*";
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new C10591a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }
}
