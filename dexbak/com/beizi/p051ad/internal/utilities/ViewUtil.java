package com.beizi.p051ad.internal.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: com.beizi.ad.internal.utilities.ViewUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewUtil {
    public static void convertFromDPToPixels(Activity activity, int[] iArr) {
        float f = activity.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] * f) + 0.5f);
        }
    }

    public static void convertFromPixelsToDP(Activity activity, int[] iArr) {
        float f = activity.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] / f) + 0.5f);
        }
    }

    public static FrameLayout createAdImageView(Context context, ServerResponse.AdLogoInfo adLogoInfo) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (adLogoInfo != null) {
                if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(85, 42, 17));
                    imageView.setVisibility(0);
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                    frameLayout.addView(imageView);
                } else if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(adLogoInfo.getAdurl());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AppCompatTextView createCloseButton(Context context) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, C2750R.C2752drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(C2750R.C2755string.skip_ad);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.TOP_END);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 10.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 42.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 10.0f, m49492a.m49467k()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, C2750R.C2752drawable.button_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, m49492a.m49467k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 10.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 10.0f, m49492a.m49467k()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.utilities.ViewUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }

    public static ImageView createImageCloseButton(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C2750R.C2752drawable.banner_da_close);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getValueInPixel(context, 18), getValueInPixel(context, 18), BadgeDrawable.TOP_END);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public static AppCompatTextView createInterstitialCountDown(Context context, int i) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, C2750R.C2752drawable.button_count_down_interstitial_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, m49492a.m49467k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 0.0f, m49492a.m49467k()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.utilities.ViewUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }

    public static FrameLayout createLogoImageView(Context context, ServerResponse.AdLogoInfo adLogoInfo) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (adLogoInfo != null) {
                if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(42, 42, 17));
                    imageView.setVisibility(0);
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                    frameLayout.addView(imageView);
                } else if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(adLogoInfo.getAdurl());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AppCompatImageView createMuteButton(Context context, boolean z) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageResource(z ? C2750R.C2752drawable.voice_off : C2750R.C2752drawable.voice_on);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.TOP_START);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 15.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 15.0f, m49492a.m49467k()), (int) TypedValue.applyDimension(1, 15.0f, m49492a.m49467k()));
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int[] getScreenSizeAsDP(Activity activity) {
        int[] screenSizeAsPixels = getScreenSizeAsPixels(activity);
        convertFromPixelsToDP(activity, screenSizeAsPixels);
        return screenSizeAsPixels;
    }

    public static int[] getScreenSizeAsPixels(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new int[]{point.x, point.y};
    }

    public static Context getTopContext(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof View)) {
            while (parent.getParent() != null && (parent.getParent() instanceof View)) {
                parent = parent.getParent();
            }
            return ((View) parent).getContext();
        } else if (view.getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) view.getContext()).getBaseContext();
        } else {
            return view.getContext();
        }
    }

    public static int getValueInPixel(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removeChildFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static AppCompatTextView createCloseButton(Context context, int i, int i2, int i3, int i4) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, C2750R.C2752drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(C2750R.C2755string.skip_ad);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.TOP_END);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i + 5, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i2 + 10, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i3 + 42, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i4 + 10, m49492a.m49467k()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i, int i2, int i3, int i4, int i5) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, C2750R.C2752drawable.button_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, C2750R.C2751color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        BeiZiImpl m49492a = BeiZiImpl.m49492a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, m49492a.m49467k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i2 + 5, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i3 + 10, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i4 + 5, m49492a.m49467k()), (int) TypedValue.applyDimension(1, i5 + 10, m49492a.m49467k()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.utilities.ViewUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }
}
