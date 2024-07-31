package com.kwad.sdk.commercial.p377f;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.net.URL;

@KsJson
/* renamed from: com.kwad.sdk.commercial.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9834b extends AbstractC9822a {
    public String aog;
    public String aon;
    public int status;
    public String url;

    /* renamed from: AP */
    public static C9834b m27561AP() {
        return new C9834b();
    }

    /* renamed from: cF */
    public final C9834b m27560cF(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    /* renamed from: cj */
    public final C9834b m27559cj(int i) {
        this.status = i;
        return this;
    }
}
