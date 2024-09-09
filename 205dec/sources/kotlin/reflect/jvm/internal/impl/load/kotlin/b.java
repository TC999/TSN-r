package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.load.kotlin.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d0 f57158c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final f0 f57159d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.d f57160e;

    /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements p.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f57161a = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f57163c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.b f57164d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f57165e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ v0 f57166f;

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1146a implements p.a {

            /* renamed from: a  reason: collision with root package name */
            private final /* synthetic */ p.a f57167a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p.a f57168b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f57169c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f57170d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f57171e;

            C1146a(p.a aVar, a aVar2, kotlin.reflect.jvm.internal.impl.name.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                this.f57168b = aVar;
                this.f57169c = aVar2;
                this.f57170d = fVar;
                this.f57171e = arrayList;
                this.f57167a = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            public void a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                kotlin.jvm.internal.f0.p(name, "name");
                kotlin.jvm.internal.f0.p(enumClassId, "enumClassId");
                kotlin.jvm.internal.f0.p(enumEntryName, "enumEntryName");
                this.f57167a.a(name, enumClassId, enumEntryName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            @Nullable
            public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
                kotlin.jvm.internal.f0.p(name, "name");
                kotlin.jvm.internal.f0.p(classId, "classId");
                return this.f57167a.b(name, classId);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.f0.p(name, "name");
                kotlin.jvm.internal.f0.p(value, "value");
                this.f57167a.c(name, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            public void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj) {
                this.f57167a.d(fVar, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            @Nullable
            public p.b e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
                kotlin.jvm.internal.f0.p(name, "name");
                return this.f57167a.e(name);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
            public void visitEnd() {
                Object S4;
                this.f57168b.visitEnd();
                HashMap hashMap = this.f57169c.f57161a;
                kotlin.reflect.jvm.internal.impl.name.f fVar = this.f57170d;
                S4 = kotlin.collections.f0.S4(this.f57171e);
                hashMap.put(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) S4));
            }
        }

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.b$a$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1147b implements p.b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f57172a = new ArrayList<>();

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f57174c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ b f57175d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f57176e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.b f57177f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f57178g;

            /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
            /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class C1148a implements p.a {

                /* renamed from: a  reason: collision with root package name */
                private final /* synthetic */ p.a f57179a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ p.a f57180b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ C1147b f57181c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f57182d;

                C1148a(p.a aVar, C1147b c1147b, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                    this.f57180b = aVar;
                    this.f57181c = c1147b;
                    this.f57182d = arrayList;
                    this.f57179a = aVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                public void a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                    kotlin.jvm.internal.f0.p(name, "name");
                    kotlin.jvm.internal.f0.p(enumClassId, "enumClassId");
                    kotlin.jvm.internal.f0.p(enumEntryName, "enumEntryName");
                    this.f57179a.a(name, enumClassId, enumEntryName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                @Nullable
                public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
                    kotlin.jvm.internal.f0.p(name, "name");
                    kotlin.jvm.internal.f0.p(classId, "classId");
                    return this.f57179a.b(name, classId);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                    kotlin.jvm.internal.f0.p(name, "name");
                    kotlin.jvm.internal.f0.p(value, "value");
                    this.f57179a.c(name, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                public void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj) {
                    this.f57179a.d(fVar, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                @Nullable
                public p.b e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
                    kotlin.jvm.internal.f0.p(name, "name");
                    return this.f57179a.e(name);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
                public void visitEnd() {
                    Object S4;
                    this.f57180b.visitEnd();
                    ArrayList arrayList = this.f57181c.f57172a;
                    S4 = kotlin.collections.f0.S4(this.f57182d);
                    arrayList.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) S4));
                }
            }

            C1147b(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.name.b bVar2, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list) {
                this.f57174c = fVar;
                this.f57175d = bVar;
                this.f57176e = dVar;
                this.f57177f = bVar2;
                this.f57178g = list;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
            @Nullable
            public p.a a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
                kotlin.jvm.internal.f0.p(classId, "classId");
                ArrayList arrayList = new ArrayList();
                b bVar = this.f57175d;
                v0 NO_SOURCE = v0.f56634a;
                kotlin.jvm.internal.f0.o(NO_SOURCE, "NO_SOURCE");
                p.a y3 = bVar.y(classId, NO_SOURCE, arrayList);
                kotlin.jvm.internal.f0.m(y3);
                return new C1148a(y3, this, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
            public void b(@Nullable Object obj) {
                this.f57172a.add(a.this.h(this.f57174c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
            public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                kotlin.jvm.internal.f0.p(enumClassId, "enumClassId");
                kotlin.jvm.internal.f0.p(enumEntryName, "enumEntryName");
                this.f57172a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.j(enumClassId, enumEntryName));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
            public void d(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.f0.p(value, "value");
                this.f57172a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.q(value));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
            public void visitEnd() {
                d1 b4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(this.f57174c, this.f57176e);
                if (b4 != null) {
                    HashMap hashMap = a.this.f57161a;
                    kotlin.reflect.jvm.internal.impl.name.f fVar = this.f57174c;
                    kotlin.reflect.jvm.internal.impl.resolve.constants.h hVar = kotlin.reflect.jvm.internal.impl.resolve.constants.h.f57831a;
                    List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> c4 = kotlin.reflect.jvm.internal.impl.utils.a.c(this.f57172a);
                    e0 type = b4.getType();
                    kotlin.jvm.internal.f0.o(type, "parameter.type");
                    hashMap.put(fVar, hVar.b(c4, type));
                } else if (this.f57175d.w(this.f57177f) && kotlin.jvm.internal.f0.g(this.f57174c.b(), "value")) {
                    ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arrayList = this.f57172a;
                    ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.a> arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
                            arrayList2.add(obj);
                        }
                    }
                    List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list = this.f57178g;
                    for (kotlin.reflect.jvm.internal.impl.resolve.constants.a aVar : arrayList2) {
                        list.add(aVar.a());
                    }
                }
            }
        }

        a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.name.b bVar, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list, v0 v0Var) {
            this.f57163c = dVar;
            this.f57164d = bVar;
            this.f57165e = list;
            this.f57166f = v0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> h(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> c4 = kotlin.reflect.jvm.internal.impl.resolve.constants.h.f57831a.c(obj);
            return c4 == null ? kotlin.reflect.jvm.internal.impl.resolve.constants.k.f57836b.a(kotlin.jvm.internal.f0.C("Unsupported annotation argument: ", fVar)) : c4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(enumClassId, "enumClassId");
            kotlin.jvm.internal.f0.p(enumEntryName, "enumEntryName");
            this.f57161a.put(name, new kotlin.reflect.jvm.internal.impl.resolve.constants.j(enumClassId, enumEntryName));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(classId, "classId");
            ArrayList arrayList = new ArrayList();
            b bVar = b.this;
            v0 NO_SOURCE = v0.f56634a;
            kotlin.jvm.internal.f0.o(NO_SOURCE, "NO_SOURCE");
            p.a y3 = bVar.y(classId, NO_SOURCE, arrayList);
            kotlin.jvm.internal.f0.m(y3);
            return new C1146a(y3, this, name, arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            this.f57161a.put(name, new kotlin.reflect.jvm.internal.impl.resolve.constants.q(value));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj) {
            if (fVar != null) {
                this.f57161a.put(fVar, h(fVar, obj));
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.b e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.f0.p(name, "name");
            return new C1147b(name, b.this, this.f57163c, this.f57164d, this.f57165e);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void visitEnd() {
            if (b.this.x(this.f57164d, this.f57161a) || b.this.w(this.f57164d)) {
                return;
            }
            this.f57165e.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(this.f57163c.q(), this.f57161a, this.f57166f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull d0 module, @NotNull f0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull n kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f57158c = module;
        this.f57159d = notFoundClasses;
        this.f57160e = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(module, notFoundClasses);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d I(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.v.c(this.f57158c, bVar, this.f57159d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    @Nullable
    /* renamed from: G */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> B(@NotNull String desc, @NotNull Object initializer) {
        boolean V2;
        kotlin.jvm.internal.f0.p(desc, "desc");
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        V2 = kotlin.text.x.V2("ZBCS", desc, false, 2, null);
        if (V2) {
            int intValue = ((Integer) initializer).intValue();
            int hashCode = desc.hashCode();
            if (hashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(desc);
            } else if (hashCode == 67) {
                if (desc.equals("C")) {
                    initializer = Character.valueOf((char) intValue);
                }
                throw new AssertionError(desc);
            } else if (hashCode == 83) {
                if (desc.equals("S")) {
                    initializer = Short.valueOf((short) intValue);
                }
                throw new AssertionError(desc);
            } else {
                if (hashCode == 90 && desc.equals("Z")) {
                    initializer = Boolean.valueOf(intValue != 0);
                }
                throw new AssertionError(desc);
            }
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.h.f57831a.c(initializer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    @NotNull
    /* renamed from: H */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c D(@NotNull ProtoBuf.Annotation proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        return this.f57160e.a(proto, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    @Nullable
    /* renamed from: J */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> F(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> constant) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> yVar;
        kotlin.jvm.internal.f0.p(constant, "constant");
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.d) {
            yVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.w(((kotlin.reflect.jvm.internal.impl.resolve.constants.d) constant).a().byteValue());
        } else if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.u) {
            yVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.z(((kotlin.reflect.jvm.internal.impl.resolve.constants.u) constant).a().shortValue());
        } else if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.m) {
            yVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.x(((kotlin.reflect.jvm.internal.impl.resolve.constants.m) constant).a().intValue());
        } else if (!(constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.r)) {
            return constant;
        } else {
            yVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.y(((kotlin.reflect.jvm.internal.impl.resolve.constants.r) constant).a().longValue());
        }
        return yVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    @Nullable
    protected p.a y(@NotNull kotlin.reflect.jvm.internal.impl.name.b annotationClassId, @NotNull v0 source, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> result) {
        kotlin.jvm.internal.f0.p(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(result, "result");
        return new a(I(annotationClassId), annotationClassId, result, source);
    }
}
