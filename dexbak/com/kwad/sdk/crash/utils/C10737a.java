package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;

/* renamed from: com.kwad.sdk.crash.utils.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10737a {
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: a */
    public static Charset m25008a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
