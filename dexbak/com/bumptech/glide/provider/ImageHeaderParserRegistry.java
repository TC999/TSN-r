package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.provider.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ImageHeaderParserRegistry {

    /* renamed from: a */
    private final List<ImageHeaderParser> f14314a = new ArrayList();

    /* renamed from: a */
    public synchronized void m44701a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f14314a.add(imageHeaderParser);
    }

    @NonNull
    /* renamed from: b */
    public synchronized List<ImageHeaderParser> m44700b() {
        return this.f14314a;
    }
}
