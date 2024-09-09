package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aog;
    public String aon;
    public String aoo;
    public int aop;
    public int aoq;
    public int status;
    public String url;

    public static b AL() {
        return new b();
    }

    public final b cf(int i4) {
        this.status = i4;
        return this;
    }

    public final b cg(int i4) {
        this.aop = i4;
        return this;
    }

    public final b ch(int i4) {
        this.aoq = i4;
        return this;
    }

    public final b cw(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cx(String str) {
        this.aoo = str;
        return this;
    }
}
