package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Annotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f extends Iterable<c>, e2.a {
    @NotNull

    /* renamed from: g0  reason: collision with root package name */
    public static final a f56241g0 = a.f56242a;

    /* compiled from: Annotations.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f56242a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final f f56243b = new C1127a();

        /* compiled from: Annotations.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.f$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1127a implements f {
            C1127a() {
            }

            @Nullable
            public Void a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
                f0.p(fqName, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
            public /* bridge */ /* synthetic */ c b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
                return (c) a(cVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
            public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
                return b.b(this, cVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<c> iterator() {
                return w.F().iterator();
            }

            @NotNull
            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        @NotNull
        public final f a(@NotNull List<? extends c> annotations) {
            f0.p(annotations, "annotations");
            return annotations.isEmpty() ? f56243b : new g(annotations);
        }

        @NotNull
        public final f b() {
            return f56243b;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @Nullable
        public static c a(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            c cVar;
            f0.p(fVar, "this");
            f0.p(fqName, "fqName");
            Iterator<c> it = fVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (f0.g(cVar.e(), fqName)) {
                    break;
                }
            }
            return cVar;
        }

        public static boolean b(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            f0.p(fVar, "this");
            f0.p(fqName, "fqName");
            return fVar.b(fqName) != null;
        }
    }

    @Nullable
    c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    boolean isEmpty();
}
