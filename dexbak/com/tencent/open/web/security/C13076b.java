package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.C13006b;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13076b extends C13006b {
    @Override // com.tencent.open.C13006b
    /* renamed from: a */
    public void mo14904a(String str, String str2, List<String> list, C13006b.C13007a c13007a) {
        SLog.m15123v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C13006b.C13008b c13008b = this.f37284a.get(str);
        if (c13008b != null) {
            SLog.m15131d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            c13008b.call(str2, list, c13007a);
            return;
        }
        SLog.m15129e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (c13007a != null) {
            c13007a.mo14903a();
        }
    }

    @Override // com.tencent.open.C13006b
    /* renamed from: a */
    public boolean mo14905a(WebView webView, String str) {
        SLog.m15127i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 7) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            String str4 = (String) arrayList.get(4);
            String str5 = (String) arrayList.get(5);
            SLog.m15127i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                try {
                    mo14904a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new C13077c(webView, Long.parseLong(str4), str, str5));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return false;
    }
}
