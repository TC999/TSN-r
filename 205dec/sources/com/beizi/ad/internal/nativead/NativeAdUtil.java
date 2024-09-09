package com.beizi.ad.internal.nativead;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.lance.ApkBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import xyz.adscope.ad.constants.Constants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeAdUtil {
    static boolean a(NativeAdResponse nativeAdResponse) {
        if (nativeAdResponse == null || nativeAdResponse.hasExpired()) {
            HaoboLog.d(HaoboLog.nativeLogTag, "NativeAdResponse is not valid");
            return false;
        }
        return true;
    }

    public static FrameLayout addADLogo(View view, NativeAdResponse nativeAdResponse) {
        try {
            int i4 = R.drawable.button_close_background;
            if (view.getTag(i4) != null && (view.getTag(i4) instanceof FrameLayout)) {
                ViewUtil.removeChildFromParent((FrameLayout) view.getTag(i4));
                return (FrameLayout) view.getTag(i4);
            }
            view.getContext();
            ViewUtil.removeChildFromParent(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(view.getContext(), nativeAdResponse.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(view.getContext(), nativeAdResponse.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new FrameLayout.LayoutParams(-2, -2, 17));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int dip2px = ViewUtil.dip2px(view.getContext(), 20.0f);
            layoutParams2.setMargins(0, 0, dip2px, dip2px);
            linearLayout.setLayoutParams(layoutParams2);
            view.setTag(i4, frameLayout);
            return frameLayout;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static FrameLayout getCustomRenderView(Context context, Bitmap bitmap, NativeAdResponse nativeAdResponse) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        return addADLogo(imageView, nativeAdResponse);
    }

    public static View getDownloadTextView(final Context context, NativeAdResponse nativeAdResponse) {
        if (context != null && nativeAdResponse != null) {
            try {
                ApkBean apkInfo = nativeAdResponse.getApkInfo();
                if (apkInfo == null) {
                    return null;
                }
                final String apkName = apkInfo.getApkName();
                String appDeveloper = apkInfo.getAppDeveloper();
                String appVersion = apkInfo.getAppVersion();
                String appPermissionsUrl = apkInfo.getAppPermissionsUrl();
                final String appPermissionsDesc = apkInfo.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsUrl)) {
                    appPermissionsDesc = appPermissionsUrl;
                }
                final String appPrivacyUrl = apkInfo.getAppPrivacyUrl();
                final String appintro = apkInfo.getAppintro();
                TextView textView = new TextView(context);
                textView.setText(Html.fromHtml("\u5e94\u7528\u540d\u79f0\uff1a" + apkName + " | \u5f00\u53d1\u8005\uff1a" + appDeveloper + " | \u5e94\u7528\u7248\u672c\uff1a" + appVersion + " | <u>\u6743\u9650\u8be6\u60c5</u> | <u>\u9690\u79c1\u534f\u8bae</u> | <u>\u529f\u80fd\u4ecb\u7ecd</u>"));
                textView.setTextSize(2, 6.0f);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                textView.setPadding(10, 10, 10, 10);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(context, DownloadAppInfoActivity.class);
                            intent.putExtra(Constants.TITLE_CONTENT_KEY, apkName);
                            intent.putExtra(Constants.PRIVACY_CONTENT_KEY, appPrivacyUrl);
                            intent.putExtra("permission_content_key", appPermissionsDesc);
                            intent.putExtra(Constants.INTRO_CONTENT_KEY, appintro);
                            context.startActivity(intent);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
                return textView;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static void getOneAdBitmap(NativeAdResponse nativeAdResponse, final ImageManager.BitmapLoadedListener bitmapLoadedListener) {
        int i4;
        boolean z3;
        boolean z4;
        ArrayList<String> imageUrls = nativeAdResponse.getImageUrls();
        final Bitmap[] bitmapArr = new Bitmap[3];
        if (imageUrls == null || imageUrls.size() <= 0) {
            return;
        }
        final ServerResponse.AdLogoInfo adUrl = nativeAdResponse.getAdUrl();
        if (adUrl.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
            i4 = 1;
            z3 = true;
        } else {
            i4 = 0;
            z3 = false;
        }
        final ServerResponse.AdLogoInfo adLogoInfo = nativeAdResponse.getlogoUrl();
        if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
            i4++;
            z4 = true;
        } else {
            z4 = false;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(i4 + 1);
        new Thread(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                    Handler handler = new Handler(Looper.getMainLooper());
                    Bitmap[] bitmapArr2 = bitmapArr;
                    if (bitmapArr2[0] == null) {
                        handler.post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bitmapLoadedListener.onBitmapLoadFailed();
                            }
                        });
                        return;
                    }
                    final Bitmap createBitmap = Bitmap.createBitmap(bitmapArr2[0].getWidth(), bitmapArr[0].getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = new Paint();
                    paint.setTextSize(ViewUtil.dip2px(h.a().e(), 14.0f));
                    canvas.drawBitmap(bitmapArr[0], 0.0f, 0.0f, paint);
                    Bitmap[] bitmapArr3 = bitmapArr;
                    if (bitmapArr3[1] == null) {
                        if (adUrl.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                            Rect rect = new Rect();
                            paint.getTextBounds(adUrl.getAdurl(), 0, adUrl.getAdurl().length(), rect);
                            rect.width();
                            canvas.drawText(adUrl.getAdurl(), 0.0f, (canvas.getHeight() - rect.height()) - 3, paint);
                        }
                    } else {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr3[1], 85, 42, false);
                        canvas.drawBitmap(createScaledBitmap, 0.0f, canvas.getHeight() - createScaledBitmap.getHeight(), paint);
                    }
                    Bitmap[] bitmapArr4 = bitmapArr;
                    if (bitmapArr4[2] == null) {
                        if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                            Rect rect2 = new Rect();
                            paint.getTextBounds(adLogoInfo.getAdurl(), 0, adLogoInfo.getAdurl().length(), rect2);
                            canvas.drawText(adUrl.getAdurl(), (canvas.getWidth() - rect2.width()) - 3, (canvas.getHeight() - rect2.height()) - 3, paint);
                        }
                    } else {
                        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmapArr4[2], 42, 42, false);
                        canvas.drawBitmap(createScaledBitmap2, canvas.getWidth() - createScaledBitmap2.getWidth(), canvas.getHeight() - createScaledBitmap2.getHeight(), paint);
                    }
                    handler.post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bitmapLoadedListener.onBitmapLoaded(createBitmap);
                        }
                    });
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            }
        }).start();
        ImageManager.with(null).getBitmap(imageUrls.get(0), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.5
            @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                countDownLatch.countDown();
            }

            @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                countDownLatch.countDown();
                bitmapArr[0] = bitmap;
            }
        });
        if (z3) {
            ImageManager.with(null).getBitmap(adUrl.getAdurl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.6
                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    countDownLatch.countDown();
                }

                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    countDownLatch.countDown();
                    bitmapArr[1] = bitmap;
                }
            });
        }
        if (z4) {
            ImageManager.with(null).getBitmap(adLogoInfo.getAdurl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.7
                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    countDownLatch.countDown();
                }

                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    countDownLatch.countDown();
                    bitmapArr[2] = bitmap;
                }
            });
        }
    }

    public static void handleClick(NativeAdResponse nativeAdResponse, View view, String str, String str2, String str3, String str4, int i4) {
        try {
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            nativeAdResponse.handleClick(context, view, str, str2, str3, str4, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void regesterClickListener(NativeAdResponse nativeAdResponse, View view, NativeAdEventListener nativeAdEventListener) {
        nativeAdResponse.regesterClickListener(view, nativeAdEventListener);
    }

    public static boolean registerShow(NativeAdResponse nativeAdResponse, View view) {
        return nativeAdResponse.regesterShow(view);
    }

    public static void registerTracking(final NativeAdResponse nativeAdResponse, final View view, final NativeAdEventListener nativeAdEventListener) {
        if (a(nativeAdResponse)) {
            if (view == null) {
                HaoboLog.e(HaoboLog.nativeLogTag, "View is not valid for registering");
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeAdResponse.this.registerView(view, nativeAdEventListener)) {
                            view.setTag(R.string.native_tag, new WeakReference(NativeAdResponse.this));
                            return;
                        }
                        HaoboLog.e(HaoboLog.nativeLogTag, "failed at registering the View");
                    }
                });
            }
        }
    }

    @Deprecated
    public static void unRegisterTracking(final View view) {
        if (view == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.3
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                int i4 = R.string.native_tag;
                if (view2.getTag(i4) != null) {
                    NativeAdResponse nativeAdResponse = (NativeAdResponse) ((WeakReference) view.getTag(i4)).get();
                    if (nativeAdResponse != null) {
                        HaoboLog.d(HaoboLog.nativeLogTag, "Unregister nativead ad response, assets will be destroyed.");
                        nativeAdResponse.unregisterViews();
                    }
                    view.setTag(i4, null);
                }
            }
        });
    }

    public static boolean registerShow(NativeAdResponse nativeAdResponse, View view, NativeAdShownListener nativeAdShownListener) {
        return nativeAdResponse.regesterShow(view, nativeAdShownListener);
    }

    @Deprecated
    public static void registerTracking(final NativeAdResponse nativeAdResponse, final View view, final List<View> list, final NativeAdEventListener nativeAdEventListener) {
        if (a(nativeAdResponse)) {
            if (view != null && list != null && !list.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeAdResponse.this.registerViewList(view, list, nativeAdEventListener)) {
                            view.setTag(R.string.native_tag, new WeakReference(NativeAdResponse.this));
                            HaoboLog.d(HaoboLog.nativeLogTag, "View has been registered.");
                            return;
                        }
                        HaoboLog.e(HaoboLog.nativeLogTag, "failed at registering the View");
                    }
                });
            } else {
                HaoboLog.e(HaoboLog.nativeLogTag, "Views are not valid for registering");
            }
        }
    }
}
