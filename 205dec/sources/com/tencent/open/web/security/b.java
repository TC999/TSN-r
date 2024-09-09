package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.open.b;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends com.tencent.open.b {
    @Override // com.tencent.open.b
    public void a(String str, String str2, List<String> list, b.a aVar) {
        SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                list.set(i4, URLDecoder.decode(list.get(i4), "UTF-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        b.C1042b c1042b = this.f51684a.get(str);
        if (c1042b != null) {
            SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            c1042b.call(str2, list, aVar);
            return;
        }
        SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.open.b
    public boolean a(WebView webView, String str) {
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split(TTPathConst.sSeparator)));
            if (arrayList.size() < 7) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            String str4 = (String) arrayList.get(4);
            String str5 = (String) arrayList.get(5);
            SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                try {
                    a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new c(webView, Long.parseLong(str4), str, str5));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return false;
    }
}
