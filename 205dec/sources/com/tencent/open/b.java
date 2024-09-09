package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, C1042b> f51684a = new HashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1042b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.b.a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.C1042b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(C1042b c1042b, String str) {
        this.f51684a.put(str, c1042b);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                list.set(i4, URLDecoder.decode(list.get(i4), "UTF-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        C1042b c1042b = this.f51684a.get(str);
        if (c1042b != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            c1042b.call(str2, list, aVar);
            return;
        }
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<WebView> f51686a;

        /* renamed from: b  reason: collision with root package name */
        protected long f51687b;

        /* renamed from: c  reason: collision with root package name */
        protected String f51688c;

        public a(WebView webView, long j4, String str) {
            this.f51686a = new WeakReference<>(webView);
            this.f51687b = j4;
            this.f51688c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f51686a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                obj2 = "'" + ((Object) replace) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                obj2 = obj instanceof Boolean ? obj.toString() : "'undefined'";
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f51687b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f51686a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f51687b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f51686a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split(TTPathConst.sSeparator)));
            if (arrayList.size() < 6) {
                return false;
            }
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            a aVar = new a(webView, 4L, str);
            webView.getUrl();
            a((String) arrayList.get(2), (String) arrayList.get(3), subList, aVar);
            return true;
        }
        return false;
    }
}
