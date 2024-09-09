package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collection.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\u001a9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a=\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00028\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "", "destination", "", "b", "(Lkotlinx/coroutines/flow/h;Ljava/util/List;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "", "d", "(Lkotlinx/coroutines/flow/h;Ljava/util/Set;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "C", "a", "(Lkotlinx/coroutines/flow/h;Ljava/util/Collection;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Collection f60201a;

        public a(Collection collection) {
            this.f60201a = collection;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            this.f60201a.add(obj);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collection.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@"}, d2 = {"T", "", "C", "Lkotlinx/coroutines/flow/h;", "destination", "Lkotlin/coroutines/c;", "continuation", "", "toCollection"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0, 0, 0}, l = {32}, m = "toCollection", n = {"$this$toCollection", "destination", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60202a;

        /* renamed from: b  reason: collision with root package name */
        int f60203b;

        /* renamed from: c  reason: collision with root package name */
        Object f60204c;

        /* renamed from: d  reason: collision with root package name */
        Object f60205d;

        /* renamed from: e  reason: collision with root package name */
        Object f60206e;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60202a = obj;
            this.f60203b |= Integer.MIN_VALUE;
            return k.g2(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull C r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.m.b
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.m$b r0 = (kotlinx.coroutines.flow.m.b) r0
            int r1 = r0.f60203b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60203b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.m$b r0 = new kotlinx.coroutines.flow.m$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f60202a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60203b
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.f60206e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.f60205d
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r4 = r0.f60204c
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            kotlin.d0.n(r6)
            goto L55
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.d0.n(r6)
            kotlinx.coroutines.flow.m$a r6 = new kotlinx.coroutines.flow.m$a
            r6.<init>(r5)
            r0.f60204c = r4
            r0.f60205d = r5
            r0.f60206e = r4
            r0.f60203b = r3
            java.lang.Object r4 = r4.e(r6, r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.m.a(kotlinx.coroutines.flow.h, java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public static final <T> Object b(@NotNull h<? extends T> hVar, @NotNull List<T> list, @NotNull kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return k.g2(hVar, list, cVar);
    }

    public static /* synthetic */ Object c(h hVar, List list, kotlin.coroutines.c cVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = new ArrayList();
        }
        return k.h2(hVar, list, cVar);
    }

    @Nullable
    public static final <T> Object d(@NotNull h<? extends T> hVar, @NotNull Set<T> set, @NotNull kotlin.coroutines.c<? super Set<? extends T>> cVar) {
        return k.g2(hVar, set, cVar);
    }

    public static /* synthetic */ Object e(h hVar, Set set, kotlin.coroutines.c cVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return k.j2(hVar, set, cVar);
    }
}
