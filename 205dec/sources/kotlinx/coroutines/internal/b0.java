package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnUndeliveredElement.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001aE\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0011"}, d2 = {"E", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "c", "(Ld2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "Lkotlin/coroutines/f;", "context", "b", "(Ld2/l;Ljava/lang/Object;Lkotlin/coroutines/f;)V", "", "a", "(Ld2/l;Ljava/lang/Object;Lkotlin/coroutines/f;)Ld2/l;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnUndeliveredElement.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"E", "", "<anonymous parameter 0>", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<Throwable, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l f60347a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f60348b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.f f60349c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d2.l lVar, Object obj, kotlin.coroutines.f fVar) {
            super(1);
            this.f60347a = lVar;
            this.f60348b = obj;
            this.f60349c = fVar;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            invoke2(th);
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            b0.b(this.f60347a, this.f60348b, this.f60349c);
        }
    }

    @NotNull
    public static final <E> d2.l<Throwable, f1> a(@NotNull d2.l<? super E, f1> lVar, E e4, @NotNull kotlin.coroutines.f fVar) {
        return new a(lVar, e4, fVar);
    }

    public static final <E> void b(@NotNull d2.l<? super E, f1> lVar, E e4, @NotNull kotlin.coroutines.f fVar) {
        UndeliveredElementException c4 = c(lVar, e4, null);
        if (c4 != null) {
            kotlinx.coroutines.n0.b(fVar, c4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E> UndeliveredElementException c(@NotNull d2.l<? super E, f1> lVar, E e4, @Nullable UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e4);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                kotlin.j.a(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e4, th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(d2.l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
