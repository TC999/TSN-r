package cn.jpush.android.webview.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static String f4514d;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f4515a;

    /* renamed from: b  reason: collision with root package name */
    private final cn.jpush.android.d.d f4516b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4517c;

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.f4517c = false;
        this.f4515a = new WeakReference<>((Activity) context);
        this.f4516b = dVar;
        this.f4517c = false;
    }

    private void a(String str) {
        long j4;
        try {
            try {
                j4 = Long.parseLong(str);
            } catch (Exception unused) {
                Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
                j4 = 1100;
            }
            cn.jpush.android.helper.c.a(this.f4516b.f4127d, j4, JPushConstants.mApplicationContext);
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        Logger.d("WebViewHelper", "Web callback:click - actionId:" + str + ", shouldClose:" + str2 + ", shouldCancelNotification:" + str3);
        try {
            a(str);
            boolean parseBoolean = Boolean.parseBoolean(str2);
            if (Boolean.parseBoolean(str3)) {
                cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f4516b);
            }
            if (!parseBoolean || this.f4515a.get() == null) {
                return;
            }
            this.f4515a.get().finish();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.f4515a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.f4515a.get().finish();
        }
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }

    @JavascriptInterface
    public void download(String str) {
        if (this.f4515a.get() == null) {
            return;
        }
        Logger.d("WebViewHelper", "Web callback:download - " + str);
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.f4515a.get() == null) {
            return;
        }
        a(str);
        download(str2);
        cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f4516b);
        this.f4515a.get().finish();
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public String getDevInfo() {
        return "";
    }

    @JavascriptInterface
    public String getNotificationInfo() {
        return "";
    }

    @JavascriptInterface
    public String getTplData() {
        if (this.f4516b == null) {
            Logger.w("WebViewHelper", "[getTplData] entity is null");
            return "";
        }
        Logger.d("WebViewHelper", "[getTplData] js get template data: " + this.f4516b.bk);
        return this.f4516b.bk;
    }

    @JavascriptInterface
    public String getTplExtraData() {
        return "";
    }

    @JavascriptInterface
    public void inAppClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("actionType");
            String optString = jSONObject.optString("param");
            Logger.d("WebViewHelper", "h5 click, actionType: " + optInt + ", actionKey: " + optString + ", param: " + str);
            cn.jpush.android.o.a.a().d(JPushConstants.mApplicationContext, this.f4516b);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "h5 click failed, " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void onLoadCallback(String str) {
        try {
            Logger.d("WebViewHelper", "onLoadCallback : " + str);
            if (this.f4517c) {
                Logger.d("WebViewHelper", "js callback already, param: " + str);
                return;
            }
            boolean z3 = true;
            this.f4517c = true;
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.f4515a.get() != null) {
                context = StubApp.getOrigApplicationContext(this.f4515a.get().getApplicationContext());
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("statusCode");
            String optString = jSONObject.optString("msg");
            if (optInt != 0) {
                Logger.ww("WebViewHelper", "msg tpl load failed, code: " + optInt + ", errMsg: " + optString);
            }
            cn.jpush.android.o.a a4 = cn.jpush.android.o.a.a();
            cn.jpush.android.d.d dVar = this.f4516b;
            if (optInt != 0) {
                z3 = false;
            }
            a4.a(context, dVar, z3);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "[onLoadCallback] parse param error. " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void reportData(String str) {
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.f4515a.get() == null || !(this.f4515a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.f4515a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.f4515a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:showToast - " + str);
            Toast.makeText(this.f4515a.get(), str, 1).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Context context = JPushConstants.mApplicationContext;
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        Logger.d("WebViewHelper", "activityName = " + str);
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
            }
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName(str));
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
            }
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.f4515a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.ad.a.b(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.f4515a.get());
            if (this.f4515a.get() == null || !(this.f4515a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.f4515a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.f4515a.get();
    }
}
