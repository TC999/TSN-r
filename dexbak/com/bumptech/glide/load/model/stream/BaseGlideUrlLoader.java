package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.InterfaceC3670h;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.stream.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* renamed from: a */
    private final ModelLoader<GlideUrl, InputStream> f14031a;
    @Nullable

    /* renamed from: b */
    private final ModelCache<Model, GlideUrl> f14032b;

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, null);
    }

    /* renamed from: c */
    private static List<Key> m45032c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection) {
            arrayList.add(new GlideUrl(str));
        }
        return arrayList;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    /* renamed from: b */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelCache<Model, GlideUrl> modelCache = this.f14032b;
        GlideUrl m45071b = modelCache != null ? modelCache.m45071b(model, i, i2) : null;
        if (m45071b == null) {
            String m45029f = m45029f(model, i, i2, options);
            if (TextUtils.isEmpty(m45029f)) {
                return null;
            }
            GlideUrl glideUrl = new GlideUrl(m45029f, m45030e(model, i, i2, options));
            ModelCache<Model, GlideUrl> modelCache2 = this.f14032b;
            if (modelCache2 != null) {
                modelCache2.m45070c(model, i, i2, glideUrl);
            }
            m45071b = glideUrl;
        }
        List<String> m45031d = m45031d(model, i, i2, options);
        ModelLoader.C3678a<InputStream> mo45003b = this.f14031a.mo45003b(m45071b, i, i2, options);
        return (mo45003b == null || m45031d.isEmpty()) ? mo45003b : new ModelLoader.C3678a<>(mo45003b.f13999a, m45032c(m45031d), mo45003b.f14001c);
    }

    /* renamed from: d */
    protected List<String> m45031d(Model model, int i, int i2, Options options) {
        return Collections.emptyList();
    }

    @Nullable
    /* renamed from: e */
    protected InterfaceC3670h m45030e(Model model, int i, int i2, Options options) {
        return InterfaceC3670h.f13977b;
    }

    /* renamed from: f */
    protected abstract String m45029f(Model model, int i, int i2, Options options);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache) {
        this.f14031a = modelLoader;
        this.f14032b = modelCache;
    }
}
