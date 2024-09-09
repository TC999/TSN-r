package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.l;
import com.bumptech.glide.manager.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GlideBuilder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private com.bumptech.glide.load.engine.k f16644b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.e f16645c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.b f16646d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.engine.cache.j f16647e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f16648f;

    /* renamed from: g  reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f16649g;

    /* renamed from: h  reason: collision with root package name */
    private a.InterfaceC0166a f16650h;

    /* renamed from: i  reason: collision with root package name */
    private l f16651i;

    /* renamed from: j  reason: collision with root package name */
    private com.bumptech.glide.manager.d f16652j;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private l.b f16655m;

    /* renamed from: n  reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f16656n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16657o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private List<com.bumptech.glide.request.g<Object>> f16658p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16659q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f16643a = new ArrayMap();

    /* renamed from: k  reason: collision with root package name */
    private int f16653k = 4;

    /* renamed from: l  reason: collision with root package name */
    private com.bumptech.glide.request.h f16654l = new com.bumptech.glide.request.h();

    @NonNull
    public e a(@NonNull com.bumptech.glide.request.g<Object> gVar) {
        if (this.f16658p == null) {
            this.f16658p = new ArrayList();
        }
        this.f16658p.add(gVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public d b(@NonNull Context context) {
        if (this.f16648f == null) {
            this.f16648f = com.bumptech.glide.load.engine.executor.a.g();
        }
        if (this.f16649g == null) {
            this.f16649g = com.bumptech.glide.load.engine.executor.a.d();
        }
        if (this.f16656n == null) {
            this.f16656n = com.bumptech.glide.load.engine.executor.a.b();
        }
        if (this.f16651i == null) {
            this.f16651i = new l.a(context).a();
        }
        if (this.f16652j == null) {
            this.f16652j = new com.bumptech.glide.manager.f();
        }
        if (this.f16645c == null) {
            int b4 = this.f16651i.b();
            if (b4 > 0) {
                this.f16645c = new com.bumptech.glide.load.engine.bitmap_recycle.k(b4);
            } else {
                this.f16645c = new com.bumptech.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f16646d == null) {
            this.f16646d = new com.bumptech.glide.load.engine.bitmap_recycle.j(this.f16651i.a());
        }
        if (this.f16647e == null) {
            this.f16647e = new com.bumptech.glide.load.engine.cache.i(this.f16651i.d());
        }
        if (this.f16650h == null) {
            this.f16650h = new com.bumptech.glide.load.engine.cache.h(context);
        }
        if (this.f16644b == null) {
            this.f16644b = new com.bumptech.glide.load.engine.k(this.f16647e, this.f16650h, this.f16649g, this.f16648f, com.bumptech.glide.load.engine.executor.a.j(), com.bumptech.glide.load.engine.executor.a.b(), this.f16657o);
        }
        List<com.bumptech.glide.request.g<Object>> list = this.f16658p;
        if (list == null) {
            this.f16658p = Collections.emptyList();
        } else {
            this.f16658p = Collections.unmodifiableList(list);
        }
        return new d(context, this.f16644b, this.f16647e, this.f16645c, this.f16646d, new com.bumptech.glide.manager.l(this.f16655m), this.f16652j, this.f16653k, this.f16654l.k0(), this.f16643a, this.f16658p, this.f16659q);
    }

    @NonNull
    public e c(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f16656n = aVar;
        return this;
    }

    @NonNull
    public e d(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f16646d = bVar;
        return this;
    }

    @NonNull
    public e e(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f16645c = eVar;
        return this;
    }

    @NonNull
    public e f(@Nullable com.bumptech.glide.manager.d dVar) {
        this.f16652j = dVar;
        return this;
    }

    @NonNull
    public e g(@Nullable com.bumptech.glide.request.h hVar) {
        this.f16654l = hVar;
        return this;
    }

    @NonNull
    public <T> e h(@NonNull Class<T> cls, @Nullable k<?, T> kVar) {
        this.f16643a.put(cls, kVar);
        return this;
    }

    @NonNull
    public e i(@Nullable a.InterfaceC0166a interfaceC0166a) {
        this.f16650h = interfaceC0166a;
        return this;
    }

    @NonNull
    public e j(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f16649g = aVar;
        return this;
    }

    e k(com.bumptech.glide.load.engine.k kVar) {
        this.f16644b = kVar;
        return this;
    }

    @NonNull
    public e l(boolean z3) {
        this.f16657o = z3;
        return this;
    }

    @NonNull
    public e m(int i4) {
        if (i4 >= 2 && i4 <= 6) {
            this.f16653k = i4;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public e n(boolean z3) {
        this.f16659q = z3;
        return this;
    }

    @NonNull
    public e o(@Nullable com.bumptech.glide.load.engine.cache.j jVar) {
        this.f16647e = jVar;
        return this;
    }

    @NonNull
    public e p(@NonNull l.a aVar) {
        return q(aVar.a());
    }

    @NonNull
    public e q(@Nullable com.bumptech.glide.load.engine.cache.l lVar) {
        this.f16651i = lVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@Nullable l.b bVar) {
        this.f16655m = bVar;
    }

    @Deprecated
    public e s(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        return t(aVar);
    }

    @NonNull
    public e t(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f16648f = aVar;
        return this;
    }
}
