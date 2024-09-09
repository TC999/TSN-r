package com.bumptech.glide.repackaged.com.google.common.base;

/* compiled from: Predicates.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.google.common.base.b f17648a = com.bumptech.glide.repackaged.com.google.common.base.b.e(',');

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Predicates.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static abstract class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17649a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f17650b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f17651c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f17652d;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ b[] f17653e;

        /* compiled from: Predicates.java */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum a extends b {
            a(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* compiled from: Predicates.java */
        /* renamed from: com.bumptech.glide.repackaged.com.google.common.base.f$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum C0180b extends b {
            C0180b(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* compiled from: Predicates.java */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum c extends b {
            c(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* compiled from: Predicates.java */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum d extends b {
            d(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        static {
            a aVar = new a("ALWAYS_TRUE", 0);
            f17649a = aVar;
            C0180b c0180b = new C0180b("ALWAYS_FALSE", 1);
            f17650b = c0180b;
            c cVar = new c("IS_NULL", 2);
            f17651c = cVar;
            d dVar = new d("NOT_NULL", 3);
            f17652d = dVar;
            f17653e = new b[]{aVar, c0180b, cVar, dVar};
        }

        private b(String str, int i4) {
        }

        <T> e<T> a() {
            return this;
        }
    }

    public static <T> e<T> a() {
        return b.f17652d.a();
    }
}
