package com.kwad.sdk.core.webview.p418b.p421c;

import com.baidu.mobads.sdk.internal.C2594an;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.webview.b.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10623c {
    private static final List<String> aEB;

    static {
        ArrayList arrayList = new ArrayList();
        aEB = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add("image/png");
        arrayList.add("application/javascript");
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add(C2594an.f8583d);
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add(HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
    }

    /* renamed from: eX */
    public static boolean m25253eX(String str) {
        return aEB.contains(str);
    }
}
