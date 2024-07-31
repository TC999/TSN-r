package com.iab.omid.library.mmadbridge.adsession;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7077d {

    /* renamed from: a */
    private final C7078e f24196a;

    /* renamed from: b */
    private final WebView f24197b;

    /* renamed from: c */
    private final List<C7080g> f24198c;

    /* renamed from: d */
    private final Map<String, C7080g> f24199d;

    /* renamed from: e */
    private final String f24200e;

    /* renamed from: f */
    private final String f24201f;
    @Nullable

    /* renamed from: g */
    private final String f24202g;

    /* renamed from: h */
    private final AdSessionContextType f24203h;

    private C7077d(C7078e c7078e, WebView webView, String str, List<C7080g> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f24198c = arrayList;
        this.f24199d = new HashMap();
        this.f24196a = c7078e;
        this.f24197b = webView;
        this.f24200e = str;
        this.f24203h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (C7080g c7080g : list) {
                String uuid = UUID.randomUUID().toString();
                this.f24199d.put(uuid, c7080g);
            }
        }
        this.f24202g = str2;
        this.f24201f = str3;
    }

    /* renamed from: a */
    public static C7077d m34830a(C7078e c7078e, WebView webView, @Nullable String str, String str2) {
        C7105e.m34671d(c7078e, "Partner is null");
        C7105e.m34671d(webView, "WebView is null");
        if (str2 != null) {
            C7105e.m34670e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new C7077d(c7078e, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    /* renamed from: b */
    public static C7077d m34829b(C7078e c7078e, WebView webView, @Nullable String str, String str2) {
        C7105e.m34671d(c7078e, "Partner is null");
        C7105e.m34671d(webView, "WebView is null");
        if (str2 != null) {
            C7105e.m34670e(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new C7077d(c7078e, webView, null, null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    /* renamed from: c */
    public static C7077d m34828c(C7078e c7078e, String str, List<C7080g> list, @Nullable String str2, String str3) {
        C7105e.m34671d(c7078e, "Partner is null");
        C7105e.m34671d(str, "OM SDK JS script content is null");
        C7105e.m34671d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            C7105e.m34670e(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new C7077d(c7078e, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    /* renamed from: d */
    public AdSessionContextType m34827d() {
        return this.f24203h;
    }

    @Nullable
    /* renamed from: e */
    public String m34826e() {
        return this.f24202g;
    }

    /* renamed from: f */
    public String m34825f() {
        return this.f24201f;
    }

    /* renamed from: g */
    public Map<String, C7080g> m34824g() {
        return Collections.unmodifiableMap(this.f24199d);
    }

    /* renamed from: h */
    public String m34823h() {
        return this.f24200e;
    }

    /* renamed from: i */
    public C7078e m34822i() {
        return this.f24196a;
    }

    /* renamed from: j */
    public List<C7080g> m34821j() {
        return Collections.unmodifiableList(this.f24198c);
    }

    /* renamed from: k */
    public WebView m34820k() {
        return this.f24197b;
    }
}
