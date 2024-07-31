package com.kwad.sdk.commercial.p378g;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.net.URL;

@KsJson
/* renamed from: com.kwad.sdk.commercial.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9836b extends AbstractC9822a {

    /* renamed from: Om */
    public int f29517Om;
    public String aog;
    public String aon;
    public int status;
    public String url;

    /* renamed from: AQ */
    public static C9836b m27550AQ() {
        return new C9836b();
    }

    /* renamed from: cG */
    public final C9836b m27549cG(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    /* renamed from: ck */
    public final C9836b m27548ck(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: cl */
    public final C9836b m27547cl(int i) {
        this.f29517Om = i;
        return this;
    }
}
