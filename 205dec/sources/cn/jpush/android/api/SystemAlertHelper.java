package cn.jpush.android.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.ad.a;
import cn.jpush.android.ad.f;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SystemAlertHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f4048a = 400;

    /* renamed from: b  reason: collision with root package name */
    private static int f4049b = 600;

    /* renamed from: c  reason: collision with root package name */
    private static ImageButton f4050c;

    /* renamed from: d  reason: collision with root package name */
    private static WindowManager f4051d;

    /* renamed from: e  reason: collision with root package name */
    private static WebView f4052e;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
            Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
            Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
            Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
            Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
            Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
            return displayMetrics;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i4;
        int i5;
        DisplayMetrics a4 = a(context);
        if (a4 != null) {
            int i6 = (a4.widthPixels * 3) / 4;
            f4048a = i6;
            int i7 = a4.heightPixels / 2;
            f4049b = i7;
            i4 = i6 / 2;
            i5 = -(i7 / 2);
        } else {
            i4 = 200;
            i5 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.flags |= MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE;
        layoutParams.width = f4048a;
        layoutParams.height = f4049b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(17170445));
        imageButton.setImageBitmap(getImageFromAssetsFile(context, "jpush_close.png"));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i5;
        layoutParams.x = i4;
        windowManager.addView(imageButton, layoutParams);
    }

    public static void close() {
        WindowManager windowManager = f4051d;
        if (windowManager == null) {
            return;
        }
        try {
            WebView webView = f4052e;
            if (webView != null) {
                windowManager.removeView(webView);
            }
            ImageButton imageButton = f4050c;
            if (imageButton != null) {
                f4051d.removeView(imageButton);
            }
        } catch (Throwable unused) {
        }
        f4051d = null;
        f4052e = null;
        f4050c = null;
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException unused) {
            return bitmap;
        }
    }

    public static int getWindowHeight() {
        return f4049b;
    }

    public static int getWindowWidth() {
        return f4048a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Intent intent = new Intent(webView.getContext(), Class.forName(str));
            intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
            intent.setFlags(268435456);
            appContext.startActivity(intent);
            close();
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert() {
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new f("SystemAlertHelper#systemAlert") { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // cn.jpush.android.ad.f
            @SuppressLint({"NewApi"})
            public void a() {
                String str = dVar.Y;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.f4051d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.f4052e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.f4050c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.f4051d, SystemAlertHelper.f4052e, SystemAlertHelper.f4050c);
                SystemAlertHelper.f4052e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.f4052e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.f4052e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.f4052e.setScrollBarStyle(33554432);
                a.c(SystemAlertHelper.f4052e.getSettings());
                a.a(SystemAlertHelper.f4052e);
                SystemAlertHelper.f4052e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.f4052e.setWebViewClient(new cn.jpush.android.ui.a(dVar, context));
                if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                    SystemAlertHelper.f4052e.loadUrl(str);
                }
                SystemAlertHelper.f4050c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }
}
