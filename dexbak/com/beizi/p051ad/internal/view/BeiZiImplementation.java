package com.beizi.p051ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.activity.InterstitialAdActivity;
import com.beizi.p051ad.internal.utilities.DeviceInfo;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.UserEnvInfo;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.beizi.p051ad.lance.p062a.OaidAndGaidUtils;
import com.beizi.p051ad.p056c.CommonInfo;
import com.beizi.p051ad.p056c.EnumType;
import com.tencent.open.SocialConstants;
import java.util.LinkedList;
import java.util.List;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.ad.internal.view.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class BeiZiImplementation {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m49141a(AdWebView adWebView, String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if ("GotoPage".equals(host)) {
            m49142a(adWebView, parse);
        } else if ("SendMsg".equals(host)) {
            m49139b(adWebView, parse);
        } else if ("CallNo".equals(host)) {
            m49137c(adWebView, parse);
        } else if ("ClosePage".equals(host)) {
            m49135d(adWebView, parse);
        } else if ("GetDeviceID".equals(host)) {
            m49134e((WebView) adWebView, parse);
        } else if ("Download".equals(host)) {
            m49133e(adWebView, parse);
        } else if ("PingClick".equals(host)) {
            m49132f(adWebView, parse);
        } else if ("PingConvertion".equals(host)) {
            m49131g(adWebView, parse);
        } else if ("GetCommonInfo".equals(host)) {
            m49144a((WebView) adWebView, parse);
        } else if ("MayDeepLink".equals(host)) {
            m49140b((WebView) adWebView, parse);
        } else if ("DeepLink".equals(host)) {
            if (adWebView.getUserInteraction()) {
                m49138c((WebView) adWebView, parse);
            } else {
                HaoboLog.m49284w(HaoboLog.jsLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, str));
            }
        } else if ("ExternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                m49136d((WebView) adWebView, parse);
            } else {
                HaoboLog.m49284w(HaoboLog.jsLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, str));
            }
        } else if ("InternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                m49130h(adWebView, parse);
            } else {
                HaoboLog.m49284w(HaoboLog.jsLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, str));
            }
        } else if ("RecordEvent".equals(host)) {
            m49129i(adWebView, parse);
        } else if ("DispatchAppEvent".equals(host)) {
            m49128j(adWebView, parse);
        } else if ("GetDeviceID".equals(host)) {
            m49134e((WebView) adWebView, parse);
        } else {
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.m49284w(str2, "BeiZiSDK called with unsupported function: " + host);
        }
    }

    /* renamed from: b */
    private static void m49139b(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter("msg");
        uri.getQueryParameter(SocialConstants.PARAM_RECEIVER);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "SendMsg"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        m49143a(adWebView, queryParameter, linkedList);
    }

    /* renamed from: c */
    private static void m49137c(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter(SocialConstants.PARAM_RECEIVER);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "CallNo"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        m49143a(adWebView, queryParameter, linkedList);
    }

    /* renamed from: d */
    private static void m49135d(final AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        adWebView.adViewImpl.getMyHandler().post(new Runnable() { // from class: com.beizi.ad.internal.view.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (AdWebView.this.adViewImpl.mo49147e()) {
                    AdWebView.this.adViewImpl.getAdDispatcher().mo49214b();
                    Activity activity = (Activity) AdWebView.this.getContextFromMutableContext();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    activity.finish();
                    return;
                }
                AdWebView.this.m49185d();
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "ClosePage"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        m49143a(adWebView, queryParameter, linkedList);
    }

    /* renamed from: e */
    private static void m49133e(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter)));
            if (adWebView != null) {
                adWebView.getContext().startActivity(intent);
            }
        } catch (Exception unused) {
            Toast.makeText(adWebView.getContext(), C2750R.C2755string.action_cant_be_completed, 0).show();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "Download"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        m49143a(adWebView, queryParameter2, linkedList);
    }

    /* renamed from: f */
    private static void m49132f(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.adViewImpl.pingClick(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingClick"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        m49143a(adWebView, queryParameter2, linkedList);
    }

    /* renamed from: g */
    private static void m49131g(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.adViewImpl.pingConvert(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingConvertion"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        m49143a(adWebView, queryParameter2, linkedList);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: h */
    private static void m49130h(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (adWebView.getContext() == null || queryParameter == null || !queryParameter.startsWith(IDataSource.f43971a)) {
            return;
        }
        String decode = Uri.decode(queryParameter);
        Class m50215a = AdActivity.m50215a();
        Intent intent = new Intent(adWebView.getContext(), m50215a);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        WebView webView = new WebView(adWebView.getContext());
        WebviewUtil.setWebViewSettings(webView);
        BrowserAdActivity.f9980a.add(webView);
        webView.loadUrl(decode, HeaderUtil.m49052a());
        if (adWebView.adViewImpl.getBrowserStyle() != null) {
            String str = "" + webView.hashCode();
            intent.putExtra("bridgeid", str);
            AdViewImpl.C2985c.f10612a.add(new Pair<>(str, adWebView.adViewImpl.getBrowserStyle()));
        }
        try {
            adWebView.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(adWebView.getContext(), C2750R.C2755string.action_cant_be_completed, 0).show();
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
            BrowserAdActivity.f9980a.remove();
        }
    }

    /* renamed from: i */
    private static void m49129i(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter == null || !queryParameter.startsWith(IDataSource.f43971a)) {
            return;
        }
        WebView webView = new WebView(adWebView.getContext());
        webView.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.view.b.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.m49292d(str2, "RecordEvent completed loading: " + str);
                CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                if (cookieSyncManager != null) {
                    cookieSyncManager.sync();
                }
            }
        });
        webView.loadUrl(queryParameter, HeaderUtil.m49052a());
        webView.setVisibility(8);
        adWebView.addView(webView);
    }

    /* renamed from: j */
    private static void m49128j(AdWebView adWebView, Uri uri) {
        adWebView.adViewImpl.getAdDispatcher().mo49215a(uri.getQueryParameter("event"), uri.getQueryParameter("data"));
    }

    /* renamed from: c */
    private static void m49138c(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "DeepLink"));
        if (webView.getContext() != null && queryParameter2 != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
                intent.setFlags(268435456);
                webView.getContext().startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                m49143a(webView, queryParameter, linkedList);
                return;
            }
        }
        m49143a(webView, queryParameter, linkedList);
    }

    /* renamed from: d */
    private static void m49136d(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (webView.getContext() == null || queryParameter == null || !queryParameter.startsWith(IDataSource.f43971a)) {
            return;
        }
        try {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter))));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(webView.getContext(), C2750R.C2755string.action_cant_be_completed, 0).show();
        }
    }

    /* renamed from: b */
    private static void m49140b(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        boolean z = false;
        if (webView.getContext() != null && webView.getContext().getPackageManager() != null && queryParameter2 != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
            intent.setFlags(268435456);
            if (intent.resolveActivity(webView.getContext().getPackageManager()) != null) {
                z = true;
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "MayDeepLink"));
        linkedList.add(new Pair("mayDeepLink", String.valueOf(z)));
        m49143a(webView, queryParameter, linkedList);
    }

    /* renamed from: e */
    private static void m49134e(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GetDeviceID"));
        linkedList.add(new Pair("idname", "imei"));
        m49143a(webView, queryParameter, linkedList);
    }

    /* renamed from: a */
    private static void m49142a(AdWebView adWebView, Uri uri) {
        boolean z;
        String queryParameter = uri.getQueryParameter("cb");
        if (adWebView.loadAdAt(Integer.parseInt(uri.getQueryParameter("index")))) {
            AdViewImpl adViewImpl = adWebView.adViewImpl;
            if (adViewImpl instanceof InterstitialAdViewImpl) {
                ((InterstitialAdActivity) ((InterstitialAdViewImpl) adViewImpl).getAdImplementation()).m49658g();
            }
            z = true;
        } else {
            z = false;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GotoPage"));
        linkedList.add(new Pair("success", String.valueOf(z)));
        m49143a(adWebView, queryParameter, linkedList);
    }

    /* renamed from: a */
    private static void m49144a(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        DeviceInfo deviceInfo = DeviceInfo.getInstance();
        CommonInfo.C2807a m49821a = new CommonInfo.C2807a.C2808a().m49818a(deviceInfo.sdkUID).m49806l(OaidAndGaidUtils.m49042a(BeiZiImpl.m49492a().f10139i)).m49805m(OaidAndGaidUtils.m49041b(BeiZiImpl.m49492a().f10139i)).m49804n(deviceInfo.bootMark).m49803o(deviceInfo.updateMark).m49816b("").m49815c(deviceInfo.f10413os).m49819a(EnumType.EnumC2816e.PLATFORM_ANDROID).m49820a(deviceInfo.devType).m49814d(deviceInfo.brand).m49813e(deviceInfo.model).m49812f(deviceInfo.manufacturer).m49811g(deviceInfo.resolution).m49810h(deviceInfo.screenSize).m49809i(deviceInfo.language).m49802p(deviceInfo.agVercode).m49817a(deviceInfo.wxInstalled).m49801q(DeviceInfo.physicalMemoryByte).m49800r(DeviceInfo.harddiskSizeByte).m49821a();
        UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
        CommonInfo.C2810c m49791a = new CommonInfo.C2810c.C2811a().m49789a(userEnvInfo.f47179net).m49790a(userEnvInfo.isp).m49791a();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GetDeviceID"));
        linkedList.add(new Pair("deviceInfo", Base64.encodeToString(m49821a.m49841b(), 0)));
        linkedList.add(new Pair("userEnvInfo", Base64.encodeToString(m49791a.m49792b(), 0)));
        m49143a(webView, queryParameter, linkedList);
    }

    /* renamed from: a */
    private static void m49143a(WebView webView, String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cb=");
        if (str == null) {
            str = "-1";
        }
        sb.append(str);
        if (list != null) {
            for (Pair<String, String> pair : list) {
                if (pair.first != null && pair.second != null) {
                    sb.append("&");
                    sb.append((String) pair.first);
                    sb.append("=");
                    sb.append(Uri.encode((String) pair.second));
                }
            }
        }
        String format = String.format("javascript:window.sdkjs.client.result(\"%s\")", sb.toString());
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(format, null);
        } else {
            webView.loadUrl(format, HeaderUtil.m49052a());
        }
    }
}
