package kotlin.reflect.jvm.internal.impl.utils;

import d2.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: DFS.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* JADX INFO: Add missing generic type declarations: [N] */
    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<N> extends AbstractC1189b<N, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f58532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean[] f58533b;

        a(l lVar, boolean[] zArr) {
            this.f58532a = lVar;
            this.f58533b = zArr;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        public boolean c(N n4) {
            if (((Boolean) this.f58532a.invoke(n4)).booleanValue()) {
                this.f58533b[0] = true;
            }
            return !this.f58533b[0];
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d */
        public Boolean a() {
            return Boolean.valueOf(this.f58533b[0]);
        }
    }

    /* compiled from: DFS.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.utils.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class AbstractC1189b<N, R> implements e<N, R> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public void b(N n4) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public boolean c(N n4) {
            return true;
        }
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c<N, R, C extends Iterable<R>> extends AbstractC1189b<N, C> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        protected final C f58534a;

        protected c(@NotNull C c4) {
            if (c4 == null) {
                d(0);
            }
            this.f58534a = c4;
        }

        private static /* synthetic */ void d(int i4) {
            String str = i4 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 1 ? 3 : 2];
            if (i4 != 1) {
                objArr[0] = "result";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            }
            if (i4 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            } else {
                objArr[1] = "result";
            }
            if (i4 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        @NotNull
        /* renamed from: e */
        public C a() {
            C c4 = this.f58534a;
            if (c4 == null) {
                d(1);
            }
            return c4;
        }
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface d<N> {
        @NotNull
        Iterable<? extends N> a(N n4);
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface e<N, R> {
        R a();

        void b(N n4);

        boolean c(N n4);
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class f<N, R> extends c<N, R, LinkedList<R>> {
        /* JADX INFO: Access modifiers changed from: protected */
        public f() {
            super(new LinkedList());
        }
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface g<N> {
        boolean a(N n4);
    }

    /* compiled from: DFS.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class h<N> implements g<N> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<N> f58535a;

        public h() {
            this(new HashSet());
        }

        private static /* synthetic */ void b(int i4) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.g
        public boolean a(N n4) {
            return this.f58535a.add(n4);
        }

        public h(@NotNull Set<N> set) {
            if (set == null) {
                b(0);
            }
            this.f58535a = set;
        }
    }

    private static /* synthetic */ void a(int i4) {
        Object[] objArr = new Object[3];
        switch (i4) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i4) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull e<N, R> eVar) {
        if (collection == null) {
            a(4);
        }
        if (dVar == null) {
            a(5);
        }
        if (eVar == null) {
            a(6);
        }
        return (R) c(collection, dVar, new h(), eVar);
    }

    public static <N, R> R c(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull g<N> gVar, @NotNull e<N, R> eVar) {
        if (collection == null) {
            a(0);
        }
        if (dVar == null) {
            a(1);
        }
        if (gVar == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        for (N n4 : collection) {
            d(n4, dVar, gVar, eVar);
        }
        return eVar.a();
    }

    public static <N> void d(@NotNull N n4, @NotNull d<N> dVar, @NotNull g<N> gVar, @NotNull e<N, ?> eVar) {
        if (n4 == null) {
            a(22);
        }
        if (dVar == null) {
            a(23);
        }
        if (gVar == null) {
            a(24);
        }
        if (eVar == null) {
            a(25);
        }
        if (gVar.a(n4) && eVar.c(n4)) {
            for (N n5 : dVar.a(n4)) {
                d(n5, dVar, gVar, eVar);
            }
            eVar.b(n4);
        }
    }

    public static <N> Boolean e(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull l<N, Boolean> lVar) {
        if (collection == null) {
            a(7);
        }
        if (dVar == null) {
            a(8);
        }
        if (lVar == null) {
            a(9);
        }
        return (Boolean) b(collection, dVar, new a(lVar, new boolean[1]));
    }
}
