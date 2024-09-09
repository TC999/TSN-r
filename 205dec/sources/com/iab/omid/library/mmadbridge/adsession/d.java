package com.iab.omid.library.mmadbridge.adsession;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f37678a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f37679b;

    /* renamed from: c  reason: collision with root package name */
    private final List<g> f37680c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, g> f37681d;

    /* renamed from: e  reason: collision with root package name */
    private final String f37682e;

    /* renamed from: f  reason: collision with root package name */
    private final String f37683f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f37684g;

    /* renamed from: h  reason: collision with root package name */
    private final AdSessionContextType f37685h;

    private d(e eVar, WebView webView, String str, List<g> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f37680c = arrayList;
        this.f37681d = new HashMap();
        this.f37678a = eVar;
        this.f37679b = webView;
        this.f37682e = str;
        this.f37685h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (g gVar : list) {
                String uuid = UUID.randomUUID().toString();
                this.f37681d.put(uuid, gVar);
            }
        }
        this.f37684g = str2;
        this.f37683f = str3;
    }

    public static d a(e eVar, WebView webView, @Nullable String str, String str2) {
        com.iab.omid.library.mmadbridge.d.e.d(eVar, "Partner is null");
        com.iab.omid.library.mmadbridge.d.e.d(webView, "WebView is null");
        if (str2 != null) {
            com.iab.omid.library.mmadbridge.d.e.e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public static d b(e eVar, WebView webView, @Nullable String str, String str2) {
        com.iab.omid.library.mmadbridge.d.e.d(eVar, "Partner is null");
        com.iab.omid.library.mmadbridge.d.e.d(webView, "WebView is null");
        if (str2 != null) {
            com.iab.omid.library.mmadbridge.d.e.e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, webView, null, null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    public static d c(e eVar, String str, List<g> list, @Nullable String str2, String str3) {
        com.iab.omid.library.mmadbridge.d.e.d(eVar, "Partner is null");
        com.iab.omid.library.mmadbridge.d.e.d(str, "OM SDK JS script content is null");
        com.iab.omid.library.mmadbridge.d.e.d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            com.iab.omid.library.mmadbridge.d.e.e(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType d() {
        return this.f37685h;
    }

    @Nullable
    public String e() {
        return this.f37684g;
    }

    public String f() {
        return this.f37683f;
    }

    public Map<String, g> g() {
        return Collections.unmodifiableMap(this.f37681d);
    }

    public String h() {
        return this.f37682e;
    }

    public e i() {
        return this.f37678a;
    }

    public List<g> j() {
        return Collections.unmodifiableList(this.f37680c);
    }

    public WebView k() {
        return this.f37679b;
    }
}
