package com.beizi.p051ad.internal.nativead;

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
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.ApkBean;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.beizi.ad.internal.nativead.NativeAdUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeAdUtil {
    /* renamed from: a */
    static boolean m49454a(NativeAdResponse nativeAdResponse) {
        if (nativeAdResponse == null || nativeAdResponse.hasExpired()) {
            HaoboLog.m49292d(HaoboLog.nativeLogTag, "NativeAdResponse is not valid");
            return false;
        }
        return true;
    }

    public static FrameLayout addADLogo(View view, NativeAdResponse nativeAdResponse) {
        try {
            int i = C2750R.C2752drawable.button_close_background;
            if (view.getTag(i) != null && (view.getTag(i) instanceof FrameLayout)) {
                ViewUtil.removeChildFromParent((FrameLayout) view.getTag(i));
                return (FrameLayout) view.getTag(i);
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
            view.setTag(i, frameLayout);
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
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
                textView.setText(Html.fromHtml("应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                textView.setTextSize(2, 6.0f);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                textView.setPadding(10, 10, 10, 10);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(context, DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", apkName);
                            intent.putExtra("privacy_content_key", appPrivacyUrl);
                            intent.putExtra(TTDelegateActivity.PERMISSION_CONTENT_KEY, appPermissionsDesc);
                            intent.putExtra("intro_content_key", appintro);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return textView;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void getOneAdBitmap(NativeAdResponse nativeAdResponse, final ImageManager.BitmapLoadedListener bitmapLoadedListener) {
        int i;
        boolean z;
        boolean z2;
        ArrayList<String> imageUrls = nativeAdResponse.getImageUrls();
        final Bitmap[] bitmapArr = new Bitmap[3];
        if (imageUrls == null || imageUrls.size() <= 0) {
            return;
        }
        final ServerResponse.AdLogoInfo adUrl = nativeAdResponse.getAdUrl();
        if (adUrl.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
            i = 1;
            z = true;
        } else {
            i = 0;
            z = false;
        }
        final ServerResponse.AdLogoInfo adLogoInfo = nativeAdResponse.getlogoUrl();
        if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
            i++;
            z2 = true;
        } else {
            z2 = false;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(i + 1);
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
                    paint.setTextSize(ViewUtil.dip2px(BeiZiImpl.m49492a().m49473e(), 14.0f));
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        ImageManager.with(null).getBitmap(imageUrls.get(0), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.5
            @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                countDownLatch.countDown();
            }

            @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                countDownLatch.countDown();
                bitmapArr[0] = bitmap;
            }
        });
        if (z) {
            ImageManager.with(null).getBitmap(adUrl.getAdurl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.6
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    countDownLatch.countDown();
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    countDownLatch.countDown();
                    bitmapArr[1] = bitmap;
                }
            });
        }
        if (z2) {
            ImageManager.with(null).getBitmap(adLogoInfo.getAdurl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.7
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    countDownLatch.countDown();
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    countDownLatch.countDown();
                    bitmapArr[2] = bitmap;
                }
            });
        }
    }

    public static void handleClick(NativeAdResponse nativeAdResponse, View view, String str, String str2, String str3, String str4, int i) {
        try {
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            nativeAdResponse.handleClick(context, view, str, str2, str3, str4, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void regesterClickListener(NativeAdResponse nativeAdResponse, View view, NativeAdEventListener nativeAdEventListener) {
        nativeAdResponse.regesterClickListener(view, nativeAdEventListener);
    }

    public static boolean registerShow(NativeAdResponse nativeAdResponse, View view) {
        return nativeAdResponse.regesterShow(view);
    }

    public static void registerTracking(final NativeAdResponse nativeAdResponse, final View view, final NativeAdEventListener nativeAdEventListener) {
        if (m49454a(nativeAdResponse)) {
            if (view == null) {
                HaoboLog.m49290e(HaoboLog.nativeLogTag, "View is not valid for registering");
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeAdResponse.this.registerView(view, nativeAdEventListener)) {
                            view.setTag(C2750R.C2755string.native_tag, new WeakReference(NativeAdResponse.this));
                            return;
                        }
                        HaoboLog.m49290e(HaoboLog.nativeLogTag, "failed at registering the View");
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
                int i = C2750R.C2755string.native_tag;
                if (view2.getTag(i) != null) {
                    NativeAdResponse nativeAdResponse = (NativeAdResponse) ((WeakReference) view.getTag(i)).get();
                    if (nativeAdResponse != null) {
                        HaoboLog.m49292d(HaoboLog.nativeLogTag, "Unregister nativead ad response, assets will be destroyed.");
                        nativeAdResponse.unregisterViews();
                    }
                    view.setTag(i, null);
                }
            }
        });
    }

    public static boolean registerShow(NativeAdResponse nativeAdResponse, View view, NativeAdShownListener nativeAdShownListener) {
        return nativeAdResponse.regesterShow(view, nativeAdShownListener);
    }

    @Deprecated
    public static void registerTracking(final NativeAdResponse nativeAdResponse, final View view, final List<View> list, final NativeAdEventListener nativeAdEventListener) {
        if (m49454a(nativeAdResponse)) {
            if (view != null && list != null && !list.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.nativead.NativeAdUtil.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeAdResponse.this.registerViewList(view, list, nativeAdEventListener)) {
                            view.setTag(C2750R.C2755string.native_tag, new WeakReference(NativeAdResponse.this));
                            HaoboLog.m49292d(HaoboLog.nativeLogTag, "View has been registered.");
                            return;
                        }
                        HaoboLog.m49290e(HaoboLog.nativeLogTag, "failed at registering the View");
                    }
                });
            } else {
                HaoboLog.m49290e(HaoboLog.nativeLogTag, "Views are not valid for registering");
            }
        }
    }
}
