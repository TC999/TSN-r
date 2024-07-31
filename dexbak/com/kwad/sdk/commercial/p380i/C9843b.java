package com.kwad.sdk.commercial.p380i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.net.URL;

@KsJson
/* renamed from: com.kwad.sdk.commercial.i.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9843b extends AbstractC9822a {
    public String aoI;
    public String aoJ;
    public String aog;
    public String aon;
    public int status;
    public String url;

    /* renamed from: AT */
    public static C9843b m27537AT() {
        return new C9843b();
    }

    /* renamed from: cI */
    public final C9843b m27536cI(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    /* renamed from: cJ */
    public final C9843b m27535cJ(String str) {
        this.aoI = str;
        return this;
    }

    /* renamed from: cK */
    public final C9843b m27534cK(String str) {
        this.aoJ = str;
        return this;
    }

    /* renamed from: cm */
    public final C9843b m27533cm(int i) {
        this.status = i;
        return this;
    }
}
