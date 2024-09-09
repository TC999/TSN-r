package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int Om;
    public String aog;
    public String aon;
    public int status;
    public String url;

    public static b AQ() {
        return new b();
    }

    public final b cG(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b ck(int i4) {
        this.status = i4;
        return this;
    }

    public final b cl(int i4) {
        this.Om = i4;
        return this;
    }
}
