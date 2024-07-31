package com.mbridge.msdk.mbjscommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbjscommon.mraid.CallMraidJS;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.mraid.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MraidUriUtil {

    /* renamed from: a */
    private static volatile ConcurrentHashMap<String, String> f31522a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private static ArrayList<String> f31523b = new ArrayList<>();

    /* renamed from: a */
    public static CallMethodContext m21416a(WindVaneWebView windVaneWebView, String str) {
        Set<String> unmodifiableSet;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        CallMethodContext callMethodContext = new CallMethodContext();
        callMethodContext.f31557d = "MraidJSBridge";
        callMethodContext.f31558e = parse.getHost();
        int i = 0;
        if (f31523b.size() == 0) {
            for (Method method : IMraidJSBridge.class.getDeclaredMethods()) {
                f31523b.add(method.getName());
            }
        }
        if (!f31523b.contains(callMethodContext.f31558e) && windVaneWebView != null) {
            String campaignId = windVaneWebView.getCampaignId();
            String str2 = callMethodContext.f31558e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f31522a.containsKey(campaignId)) {
                    String str3 = f31522a.get(campaignId);
                    if (!TextUtils.isEmpty(str2) && !str3.contains(str2)) {
                        if (str3.length() > 0) {
                            str3 = str3.concat(",");
                        }
                        f31522a.put(campaignId, str3.concat(str2));
                    }
                } else {
                    f31522a.put(campaignId, str2);
                }
            }
            CallMraidJS.C11499a.f31521a.m21425a(windVaneWebView, callMethodContext.f31558e);
            CallMraidJS.C11499a.f31521a.m21424a(windVaneWebView, callMethodContext.f31558e, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = parse.getEncodedQuery();
        if (encodedQuery == null) {
            unmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str4 : unmodifiableSet) {
                jSONObject.put(str4, parse.getQueryParameter(str4));
            }
            callMethodContext.f31559f = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callMethodContext;
    }

    /* renamed from: b */
    public static void m21414b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f31522a.remove(str);
    }

    /* renamed from: a */
    public static String m21415a(String str) {
        if (f31522a.containsKey(str)) {
            return f31522a.get(str);
        }
        return null;
    }
}
