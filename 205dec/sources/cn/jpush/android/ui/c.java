package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.k;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import com.stub.StubApp;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends ProxyActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public static d f4434a;

    /* renamed from: c  reason: collision with root package name */
    private cn.jpush.android.d.d f4436c;

    /* renamed from: e  reason: collision with root package name */
    private String f4438e;

    /* renamed from: g  reason: collision with root package name */
    private WebView f4440g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f4441h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f4442i;

    /* renamed from: j  reason: collision with root package name */
    private ImageButton f4443j;

    /* renamed from: k  reason: collision with root package name */
    private ProgressBar f4444k;

    /* renamed from: l  reason: collision with root package name */
    private a f4445l;

    /* renamed from: b  reason: collision with root package name */
    private int f4435b = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4437d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4439f = false;

    /* renamed from: m  reason: collision with root package name */
    private View.OnClickListener f4446m = new View.OnClickListener() { // from class: cn.jpush.android.ui.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
                        return;
                    }
                    ((Activity) view.getContext()).onBackPressed();
                } catch (Throwable unused) {
                }
            }
        }
    };

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d b4 = cn.jpush.android.x.b.b(activity, activity.getIntent());
        if (b4 != null) {
            return b4;
        }
        Logger.dd("PushActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        Logger.d("PushActivityImpl", "content:" + uri);
        return cn.jpush.android.ac.d.a(activity, uri, "");
    }

    private void a(Activity activity, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else if (dVar.f4141r == 0) {
            activity.setRequestedOrientation(1);
            b(activity, dVar);
            return;
        } else {
            Logger.w("PushActivityImpl", "Invalid msg type to show - " + dVar.f4141r);
            cn.jpush.android.x.b.c(activity, dVar);
        }
        activity.finish();
    }

    private void b() {
        try {
            k.a(this.f4440g, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f4434a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PushActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void b(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                if (cn.jpush.android.x.b.a(activity, activity.getIntent())) {
                    this.f4437d = activity.getIntent().getBooleanExtra(PushActivity.FROM_OTHER_WAY, false);
                    cn.jpush.android.d.d a4 = a(activity, activity.getIntent());
                    this.f4436c = a4;
                    if (a4 != null) {
                        this.f4438e = a4.f4127d;
                        this.f4439f = TextUtils.isEmpty(a4.bg) ? false : true;
                        a(activity, this.f4436c);
                        cn.jpush.android.k.a.a(activity, this.f4436c);
                    } else {
                        Logger.ww("PushActivityImpl", "Warning\uff0cnull message entity! Close PushActivity!");
                        activity.finish();
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PushActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PushActivityImpl", "PushActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity, cn.jpush.android.d.d dVar) {
        String str;
        Logger.i("PushActivityImpl", "Action: processShow");
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else if (dVar.ad != 0) {
            return;
        } else {
            this.f4435b = dVar.ab;
            int identifier = activity.getResources().getIdentifier("jpush_webview_layout", "layout", activity.getPackageName());
            if (identifier == 0) {
                str = "Please add layout resource jpush_webview_layout.xml to res/layout !";
            } else {
                activity.setContentView(identifier);
                String str2 = dVar.Y;
                if (cn.jpush.android.ad.a.c(str2)) {
                    String str3 = dVar.aa;
                    if (dVar.f4142s) {
                        int identifier2 = activity.getResources().getIdentifier("actionbarLayoutId", "id", activity.getPackageName());
                        if (identifier2 == 0) {
                            str = "Please use default code in jpush_webview_layout.xml!";
                        } else {
                            View findViewById = activity.findViewById(identifier2);
                            if (findViewById != null) {
                                a(activity, findViewById, dVar);
                                if (TextUtils.isEmpty(str3) || !new File(str3.replace("file://", "")).exists() || this.f4437d) {
                                    this.f4440g.loadUrl(str2);
                                } else {
                                    this.f4440g.loadUrl(str3);
                                }
                            }
                        }
                    }
                    if (this.f4437d || this.f4439f) {
                        return;
                    }
                    byte b4 = dVar.ah;
                    if (b4 == 0) {
                        cn.jpush.android.helper.c.a(this.f4438e, 1000L, activity);
                        return;
                    } else {
                        cn.jpush.android.helper.c.a(dVar.f4127d, "", b4, 1000L, activity);
                        return;
                    }
                }
                cn.jpush.android.x.b.c(activity, dVar);
            }
            Logger.ee("PushActivityImpl", str);
        }
        activity.finish();
    }

    private void c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags &= -1025;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().clearFlags(512);
        } catch (Throwable unused) {
            Logger.w("PushActivityImpl", "quitFullScreen errno");
        }
    }

    public void a() {
        try {
            RelativeLayout relativeLayout = this.f4441h;
            if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
                return;
            }
            this.f4441h.setVisibility(0);
            c((Activity) this.f4441h.getContext());
            this.f4443j.setOnClickListener(this.f4446m);
            WebView webView = this.f4440g;
            if (webView != null) {
                webView.postDelayed(new f("PushActivityImpl#showTitleBar") { // from class: cn.jpush.android.ui.c.3
                    @Override // cn.jpush.android.ad.f
                    public void a() {
                        try {
                            if (c.this.f4440g != null) {
                                c.this.f4440g.clearHistory();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Activity activity) {
        activity.finish();
        if (1 == this.f4435b) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                ComponentName componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                ComponentName componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                Logger.d("PushActivityImpl", "baseActivity  = " + componentName.toString());
                Logger.d("PushActivityImpl", "topActivity  = " + componentName2.toString());
                if (componentName2.toString().equals(componentName.toString())) {
                    cn.jpush.android.ad.a.e(activity);
                }
            } catch (Throwable unused) {
                Logger.ww("PushActivityImpl", "Get running tasks failed.");
                cn.jpush.android.ad.a.e(activity);
            }
        }
    }

    public void a(Activity activity, View view, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.Z;
            view.setFocusable(true);
            int identifier = activity.getResources().getIdentifier("fullWebView", "id", activity.getPackageName());
            if (identifier > 0) {
                ((LinearLayout) view).removeView(activity.findViewById(identifier));
            }
            WebView webView = new WebView(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
            this.f4440g = webView;
            webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f4440g.setBackgroundColor(Color.parseColor("#000000"));
            ((LinearLayout) view).addView(this.f4440g);
            this.f4441h = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlRichpushTitleBar", "id", activity.getPackageName()));
            this.f4442i = (TextView) activity.findViewById(activity.getResources().getIdentifier("tvRichpushTitle", "id", activity.getPackageName()));
            this.f4443j = (ImageButton) activity.findViewById(activity.getResources().getIdentifier("imgRichpushBtnBack", "id", activity.getPackageName()));
            this.f4444k = (ProgressBar) activity.findViewById(activity.getResources().getIdentifier("pushPrograssBar", "id", activity.getPackageName()));
            if (this.f4440g == null || this.f4441h == null || this.f4442i == null || this.f4443j == null) {
                Logger.ee("PushActivityImpl", "Please use default code in jpush_webview_layout.xml!");
                activity.finish();
            }
            if (1 == dVar.ac) {
                this.f4441h.setVisibility(8);
                activity.getWindow().setFlags(1024, 1024);
            } else {
                this.f4442i.setText(str);
                this.f4443j.setOnClickListener(this.f4446m);
                m.a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), this.f4443j, true, 10, 6, 10, 6);
            }
            this.f4440g.setScrollbarFadingEnabled(true);
            this.f4440g.setScrollBarStyle(33554432);
            WebSettings settings = this.f4440g.getSettings();
            cn.jpush.android.ad.a.c(settings);
            cn.jpush.android.ad.a.a(this.f4440g);
            cn.jpush.android.ad.a.a(settings);
            settings.setSavePassword(false);
            f4434a = new d(activity, dVar);
            Logger.dd("PushActivityImpl", "Android sdk version greater than or equal to 17, Java\u2014Js interact by annotation!");
            Logger.d("PushActivityImpl", "Android sdk version greater than or equal to 17, Java\u2014Js interact by annotation!");
            b();
            this.f4440g.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, this.f4444k, this.f4442i));
            a aVar = new a(dVar, activity);
            this.f4445l = aVar;
            aVar.a(this.f4439f);
            this.f4440g.setWebViewClient(this.f4445l);
            HostJsScope.setWebViewHelper(f4434a);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        byte b4;
        WebView webView = this.f4440g;
        if (webView != null && webView.canGoBack()) {
            this.f4440g.goBack();
            return;
        }
        cn.jpush.android.d.d dVar = this.f4436c;
        if (dVar == null || (b4 = dVar.ah) == 0) {
            cn.jpush.android.helper.c.a(this.f4438e, 1006L, activity);
        } else {
            cn.jpush.android.helper.c.a(this.f4438e, "", b4, 1006L, activity);
        }
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ad.a.d(activity);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f4440g;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null) {
                Logger.d("PushActivityImpl", "webview parent view " + parent.toString());
                ((ViewGroup) parent).removeView(this.f4440g);
            }
            this.f4440g.getSettings().setJavaScriptEnabled(false);
            this.f4440g.clearCache(true);
            this.f4440g.clearHistory();
            this.f4440g.clearView();
            this.f4440g.removeAllViews();
            this.f4440g.clearSslPreferences();
            this.f4440g.destroy();
            this.f4440g = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("push_show_titlebar")) {
            return;
        }
        activity.runOnUiThread(new f("PushActivityImpl#onEvent") { // from class: cn.jpush.android.ui.c.1
            @Override // cn.jpush.android.ad.f
            public void a() {
                c.this.a();
            }
        });
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i4, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
        activity.setIntent(intent);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f4440g;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.f4440g;
        if (webView != null) {
            webView.onResume();
            HostJsScope.setWebViewHelper(f4434a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
