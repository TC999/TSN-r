package cn.jpush.android.webview.bridge;

import android.webkit.WebView;
import cn.jpush.android.api.SystemAlertHelper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HostJsScope {

    /* renamed from: a  reason: collision with root package name */
    private static d f4505a;

    public static void click(WebView webView, String str, String str2, String str3) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.click(str, str2, str3);
    }

    public static void close(WebView webView) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.close();
    }

    public static void createShortcut(WebView webView, String str, String str2, String str3) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.createShortcut(str, str2, str3);
    }

    public static void download(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.download(str);
    }

    public static void download(WebView webView, String str, String str2) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.download(str, str2);
    }

    public static void download(WebView webView, String str, String str2, String str3) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.download(str, str2, str3);
    }

    public static void executeMsgMessage(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.executeMsgMessage(str);
    }

    public static String getDevInfo(WebView webView) {
        d dVar = f4505a;
        return dVar != null ? dVar.getDevInfo() : "";
    }

    public static String getNotificationInfo(WebView webView) {
        d dVar = f4505a;
        return dVar != null ? dVar.getNotificationInfo() : "";
    }

    public static String getTplData(WebView webView) {
        d dVar = f4505a;
        return dVar != null ? dVar.getTplData() : "";
    }

    public static String getTplExtraData(WebView webView) {
        d dVar = f4505a;
        return dVar != null ? dVar.getTplExtraData() : "";
    }

    public static void inAppClick(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar != null) {
            dVar.inAppClick(str);
        }
    }

    public static void onLoadCallback(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar != null) {
            dVar.onLoadCallback(str);
        }
    }

    public static void reportData(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar != null) {
            dVar.reportData(str);
        }
    }

    public static void setWebViewHelper(d dVar) {
        if (dVar == null) {
            return;
        }
        f4505a = dVar;
    }

    public static void showTitleBar(WebView webView) {
        d dVar = f4505a;
        if (dVar != null) {
            dVar.showTitleBar();
        }
    }

    public static void showToast(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.showToast(str);
    }

    public static void startActivityByIntent(WebView webView, String str, String str2) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.startActivityByIntent(str, str2);
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.startActivityByName(str, str2);
    }

    public static void startActivityByNameWithSystemAlert(WebView webView, String str, String str2) {
        SystemAlertHelper.startActivityByName(webView, str, str2);
    }

    public static void startMainActivity(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.startMainActivity(str);
    }

    public static void startPushActivity(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar != null) {
            dVar.startPushActivity(str);
        }
    }

    public static void triggerNativeAction(WebView webView, String str) {
        d dVar = f4505a;
        if (dVar == null) {
            return;
        }
        dVar.triggerNativeAction(str);
    }
}
