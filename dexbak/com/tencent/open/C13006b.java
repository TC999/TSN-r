package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13006b {

    /* renamed from: a */
    protected HashMap<String, C13008b> f37284a = new HashMap<>();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13008b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
            r13.mo14902a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.C13006b.C13007a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.C13006b.C13008b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    /* renamed from: a */
    public void m15199a(C13008b c13008b, String str) {
        this.f37284a.put(str, c13008b);
    }

    /* renamed from: a */
    public void mo14904a(String str, String str2, List<String> list, C13007a c13007a) {
        SLog.m15123v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C13008b c13008b = this.f37284a.get(str);
        if (c13008b != null) {
            SLog.m15131d("openSDK_LOG.JsBridge", "call----");
            c13008b.call(str2, list, c13007a);
            return;
        }
        SLog.m15131d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c13007a != null) {
            c13007a.mo14903a();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13007a {

        /* renamed from: a */
        protected WeakReference<WebView> f37285a;

        /* renamed from: b */
        protected long f37286b;

        /* renamed from: c */
        protected String f37287c;

        public C13007a(WebView webView, long j, String str) {
            this.f37285a = new WeakReference<>(webView);
            this.f37286b = j;
            this.f37287c = str;
        }

        /* renamed from: a */
        public void mo14902a(Object obj) {
            String obj2;
            WebView webView = this.f37285a.get();
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
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f37286b + ",{'r':0,'result':" + obj2 + "});");
        }

        /* renamed from: a */
        public void mo14903a() {
            WebView webView = this.f37285a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f37286b + ",{'r':1,'result':'no such method'})");
        }

        /* renamed from: a */
        public void mo14901a(String str) {
            WebView webView = this.f37285a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* renamed from: a */
    public boolean mo14905a(WebView webView, String str) {
        SLog.m15123v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 6) {
                return false;
            }
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            C13007a c13007a = new C13007a(webView, 4L, str);
            webView.getUrl();
            mo14904a((String) arrayList.get(2), (String) arrayList.get(3), subList, c13007a);
            return true;
        }
        return false;
    }
}
