package com.kwad.sdk.commercial.p373b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.net.URL;

@KsJson
/* renamed from: com.kwad.sdk.commercial.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9820b extends AbstractC9822a {
    public String aog;
    public String aon;
    public String aoo;
    public int aop;
    public int aoq;
    public int status;
    public String url;

    /* renamed from: AL */
    public static C9820b m27642AL() {
        return new C9820b();
    }

    /* renamed from: cf */
    public final C9820b m27641cf(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: cg */
    public final C9820b m27640cg(int i) {
        this.aop = i;
        return this;
    }

    /* renamed from: ch */
    public final C9820b m27639ch(int i) {
        this.aoq = i;
        return this;
    }

    /* renamed from: cw */
    public final C9820b m27638cw(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    /* renamed from: cx */
    public final C9820b m27637cx(String str) {
        this.aoo = str;
        return this;
    }
}
