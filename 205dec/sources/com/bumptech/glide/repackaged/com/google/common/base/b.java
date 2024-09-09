package com.bumptech.glide.repackaged.com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: Joiner.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f17645a;

    /* compiled from: Joiner.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class a extends b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17646b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b bVar, String str) {
            super(bVar, null);
            this.f17646b = str;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.b
        CharSequence g(Object obj) {
            return obj == null ? this.f17646b : b.this.g(obj);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.b
        public b h(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* synthetic */ b(b bVar, a aVar) {
        this(bVar);
    }

    public static b e(char c4) {
        return new b(String.valueOf(c4));
    }

    public static b f(String str) {
        return new b(str);
    }

    public <A extends Appendable> A a(A a4, Iterator<?> it) throws IOException {
        d.i(a4);
        if (it.hasNext()) {
            a4.append(g(it.next()));
            while (it.hasNext()) {
                a4.append(this.f17645a);
                a4.append(g(it.next()));
            }
        }
        return a4;
    }

    public final StringBuilder b(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        return b(new StringBuilder(), it).toString();
    }

    CharSequence g(Object obj) {
        d.i(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public b h(String str) {
        d.i(str);
        return new a(this, str);
    }

    private b(String str) {
        this.f17645a = (String) d.i(str);
    }

    private b(b bVar) {
        this.f17645a = bVar.f17645a;
    }
}
