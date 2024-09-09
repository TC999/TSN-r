package com.beizi.ad.internal.utilities;

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
import com.beizi.ad.R;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.network.ServerResponse;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ViewUtil {
    public static void convertFromDPToPixels(Activity activity, int[] iArr) {
        float f4 = activity.getResources().getDisplayMetrics().density;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = (int) ((iArr[i4] * f4) + 0.5f);
        }
    }

    public static void convertFromPixelsToDP(Activity activity, int[] iArr) {
        float f4 = activity.getResources().getDisplayMetrics().density;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = (int) ((iArr[i4] / f4) + 0.5f);
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
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(adLogoInfo.getAdurl());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static AppCompatTextView createCloseButton(Context context) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.skip_ad);
        h a4 = h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a4.k()), (int) TypedValue.applyDimension(1, 10.0f, a4.k()), (int) TypedValue.applyDimension(1, 42.0f, a4.k()), (int) TypedValue.applyDimension(1, 10.0f, a4.k()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i4) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        h a4 = h.a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, a4.k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a4.k()), (int) TypedValue.applyDimension(1, 10.0f, a4.k()), (int) TypedValue.applyDimension(1, 5.0f, a4.k()), (int) TypedValue.applyDimension(1, 10.0f, a4.k()));
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
        imageView.setImageResource(R.drawable.banner_da_close);
        h a4 = h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getValueInPixel(context, 18), getValueInPixel(context, 18), 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a4.k()), (int) TypedValue.applyDimension(1, 0.0f, a4.k()), (int) TypedValue.applyDimension(1, 0.0f, a4.k()), (int) TypedValue.applyDimension(1, 5.0f, a4.k()));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public static AppCompatTextView createInterstitialCountDown(Context context, int i4) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_count_down_interstitial_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        h a4 = h.a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, a4.k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 0.0f, a4.k()), (int) TypedValue.applyDimension(1, 0.0f, a4.k()), (int) TypedValue.applyDimension(1, 0.0f, a4.k()), (int) TypedValue.applyDimension(1, 0.0f, a4.k()));
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
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(adLogoInfo.getAdurl());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static AppCompatImageView createMuteButton(Context context, boolean z3) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageResource(z3 ? R.drawable.voice_off : R.drawable.voice_on);
        h a4 = h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388659);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a4.k()), (int) TypedValue.applyDimension(1, 15.0f, a4.k()), (int) TypedValue.applyDimension(1, 15.0f, a4.k()), (int) TypedValue.applyDimension(1, 15.0f, a4.k()));
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
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

    public static int getValueInPixel(Context context, int i4) {
        return (int) ((i4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removeChildFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static AppCompatTextView createCloseButton(Context context, int i4, int i5, int i6, int i7) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.skip_ad);
        h a4 = h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i4 + 5, a4.k()), (int) TypedValue.applyDimension(1, i5 + 10, a4.k()), (int) TypedValue.applyDimension(1, i6 + 42, a4.k()), (int) TypedValue.applyDimension(1, i7 + 10, a4.k()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i4, int i5, int i6, int i7, int i8) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        h a4 = h.a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, a4.k()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i5 + 5, a4.k()), (int) TypedValue.applyDimension(1, i6 + 10, a4.k()), (int) TypedValue.applyDimension(1, i7 + 5, a4.k()), (int) TypedValue.applyDimension(1, i8 + 10, a4.k()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.utilities.ViewUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }
}
