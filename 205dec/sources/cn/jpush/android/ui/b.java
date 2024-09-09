package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.ad.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import com.stub.StubApp;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends ProxyActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public static d f4430a;

    /* renamed from: b  reason: collision with root package name */
    private String f4431b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f4432c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jpush.android.d.d f4433d = null;

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d b4 = cn.jpush.android.x.b.b(StubApp.getOrigApplicationContext(activity.getApplicationContext()), activity.getIntent());
        if (b4 != null) {
            return b4;
        }
        Logger.dd("PopWinActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        return cn.jpush.android.ac.d.a(activity, uri, "");
    }

    private void a() {
        try {
            k.a(this.f4432c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f4430a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PopWinActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void a(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                if (cn.jpush.android.x.b.a(activity, activity.getIntent())) {
                    cn.jpush.android.d.d a4 = a(activity, activity.getIntent());
                    this.f4433d = a4;
                    if (a4 != null) {
                        this.f4431b = a4.f4127d;
                        b(activity);
                        c(activity);
                        cn.jpush.android.k.a.a(activity, this.f4433d);
                    } else {
                        Logger.ww("PopWinActivityImpl", "Warning\uff0cnull message entity! Close PopWinActivity!");
                        activity.finish();
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PopWinActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PopWinActivityImpl", "PopWinActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity) {
        int identifier = activity.getResources().getIdentifier("jpush_popwin_layout", "layout", activity.getPackageName());
        if (identifier == 0) {
            Logger.ee("PopWinActivityImpl", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
            activity.finish();
            return;
        }
        activity.setContentView(identifier);
        int identifier2 = activity.getResources().getIdentifier("wvPopwin", "id", activity.getPackageName());
        if (identifier2 == 0) {
            Logger.ee("PopWinActivityImpl", "Please use default code in jpush_popwin_layout.xml!");
            activity.finish();
            return;
        }
        WebView webView = (WebView) activity.findViewById(identifier2);
        this.f4432c = webView;
        if (webView == null) {
            Logger.ee("PopWinActivityImpl", "Can not get webView in layout file!");
            activity.finish();
            return;
        }
        webView.setScrollbarFadingEnabled(true);
        this.f4432c.setScrollBarStyle(33554432);
        WebSettings settings = this.f4432c.getSettings();
        settings.setDomStorageEnabled(true);
        cn.jpush.android.ad.a.c(settings);
        cn.jpush.android.ad.a.a(this.f4432c);
        cn.jpush.android.ad.a.a(settings);
        settings.setSavePassword(false);
        this.f4432c.setBackgroundColor(0);
        f4430a = new d(activity, this.f4433d);
        Logger.dd("PopWinActivityImpl", "Android sdk version greater than or equal to 17, Java\u2014Js interact by annotation!");
        a();
        this.f4432c.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
        this.f4432c.setWebViewClient(new a(this.f4433d, activity));
        HostJsScope.setWebViewHelper(f4430a);
    }

    private void c(Activity activity) {
        cn.jpush.android.d.d dVar = this.f4433d;
        String str = dVar.aa;
        String str2 = dVar.Y;
        Logger.d("PopWinActivityImpl", "showUrl = " + str2);
        if (TextUtils.isEmpty(str) || !new File(str.replace("file://", "")).exists()) {
            this.f4432c.loadUrl(str2);
        } else {
            this.f4432c.loadUrl(str);
        }
        cn.jpush.android.d.d dVar2 = this.f4433d;
        byte b4 = dVar2.ah;
        if (b4 == 0) {
            cn.jpush.android.helper.c.a(this.f4431b, 1000L, activity);
        } else {
            cn.jpush.android.helper.c.a(dVar2.f4127d, "", b4, 1000L, activity);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        byte b4;
        cn.jpush.android.d.d dVar = this.f4433d;
        if (dVar == null || (b4 = dVar.ah) == 0) {
            cn.jpush.android.helper.c.a(this.f4431b, 1006L, activity);
        } else {
            cn.jpush.android.helper.c.a(this.f4431b, "", b4, 1006L, activity);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ad.a.d(activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f4432c;
        if (webView != null) {
            webView.removeAllViews();
            this.f4432c.destroy();
            this.f4432c = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("start_push_activity") || this.f4433d == null || this.f4432c == null) {
            return;
        }
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            this.f4433d.Y = string;
            Intent intent = new Intent(activity, PushActivity.class);
            intent.putExtra("msg_data", this.f4433d.c());
            intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
            intent.setFlags(335544320);
            activity.startActivity(intent);
        }
        activity.finish();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i4, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f4432c;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.f4432c;
        if (webView != null) {
            webView.onResume();
            HostJsScope.setWebViewHelper(f4430a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
