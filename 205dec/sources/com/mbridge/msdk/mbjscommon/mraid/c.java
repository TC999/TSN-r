package com.mbridge.msdk.mbjscommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbjscommon.mraid.a;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: MraidUriUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f40294a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f40295b = new ArrayList<>();

    public static com.mbridge.msdk.mbjscommon.windvane.a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> unmodifiableSet;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        com.mbridge.msdk.mbjscommon.windvane.a aVar = new com.mbridge.msdk.mbjscommon.windvane.a();
        aVar.f40329d = "MraidJSBridge";
        aVar.f40330e = parse.getHost();
        int i4 = 0;
        if (f40295b.size() == 0) {
            for (Method method : b.class.getDeclaredMethods()) {
                f40295b.add(method.getName());
            }
        }
        if (!f40295b.contains(aVar.f40330e) && windVaneWebView != null) {
            String campaignId = windVaneWebView.getCampaignId();
            String str2 = aVar.f40330e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f40294a.containsKey(campaignId)) {
                    String str3 = f40294a.get(campaignId);
                    if (!TextUtils.isEmpty(str2) && !str3.contains(str2)) {
                        if (str3.length() > 0) {
                            str3 = str3.concat(",");
                        }
                        f40294a.put(campaignId, str3.concat(str2));
                    }
                } else {
                    f40294a.put(campaignId, str2);
                }
            }
            a.C0751a.f40293a.a(windVaneWebView, aVar.f40330e);
            a.C0751a.f40293a.a(windVaneWebView, aVar.f40330e, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = parse.getEncodedQuery();
        if (encodedQuery == null) {
            unmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            do {
                int indexOf = encodedQuery.indexOf(38, i4);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i4);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i4, indexOf2)));
                i4 = indexOf + 1;
            } while (i4 < encodedQuery.length());
            unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str4 : unmodifiableSet) {
                jSONObject.put(str4, parse.getQueryParameter(str4));
            }
            aVar.f40331f = jSONObject.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return aVar;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f40294a.remove(str);
    }

    public static String a(String str) {
        if (f40294a.containsKey(str)) {
            return f40294a.get(str);
        }
        return null;
    }
}
