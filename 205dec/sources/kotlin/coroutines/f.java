package kotlin.coroutines;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.p;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContext.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u00a6\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\nH&\u00a2\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lkotlin/coroutines/f;", "", "Lkotlin/coroutines/f$b;", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ld2/p;)Ljava/lang/Object;", "context", "plus", "minusKey", "b", "c", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContext.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CoroutineContext.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/f;", "acc", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f$b;)Lkotlin/coroutines/f;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.coroutines.f$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1098a extends Lambda implements p<f, b, f> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1098a f55507a = new C1098a();

            C1098a() {
                super(2);
            }

            @Override // d2.p
            @NotNull
            /* renamed from: a */
            public final f invoke(@NotNull f acc, @NotNull b element) {
                CombinedContext combinedContext;
                f0.p(acc, "acc");
                f0.p(element, "element");
                f minusKey = acc.minusKey(element.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (minusKey == emptyCoroutineContext) {
                    return element;
                }
                d.b bVar = d.f55503f0;
                d dVar = (d) minusKey.get(bVar);
                if (dVar == null) {
                    combinedContext = new CombinedContext(minusKey, element);
                } else {
                    f minusKey2 = minusKey.minusKey(bVar);
                    if (minusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(element, dVar);
                    }
                    combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), dVar);
                }
                return combinedContext;
            }
        }

        @NotNull
        public static f a(@NotNull f fVar, @NotNull f context) {
            f0.p(fVar, "this");
            f0.p(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? fVar : (f) context.fold(fVar, C1098a.f55507a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00028\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ld2/p;)Ljava/lang/Object;", "minusKey", "getKey", "()Lkotlin/coroutines/f$c;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface b extends f {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CoroutineContext.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a {
            public static <R> R a(@NotNull b bVar, R r3, @NotNull p<? super R, ? super b, ? extends R> operation) {
                f0.p(bVar, "this");
                f0.p(operation, "operation");
                return operation.invoke(r3, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends b> E b(@NotNull b bVar, @NotNull c<E> key) {
                f0.p(bVar, "this");
                f0.p(key, "key");
                if (f0.g(bVar.getKey(), key)) {
                    return bVar;
                }
                return null;
            }

            @NotNull
            public static f c(@NotNull b bVar, @NotNull c<?> key) {
                f0.p(bVar, "this");
                f0.p(key, "key");
                return f0.g(bVar.getKey(), key) ? EmptyCoroutineContext.INSTANCE : bVar;
            }

            @NotNull
            public static f d(@NotNull b bVar, @NotNull f context) {
                f0.p(bVar, "this");
                f0.p(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // kotlin.coroutines.f
        <R> R fold(R r3, @NotNull p<? super R, ? super b, ? extends R> pVar);

        @Override // kotlin.coroutines.f
        @Nullable
        <E extends b> E get(@NotNull c<E> cVar);

        @NotNull
        c<?> getKey();

        @Override // kotlin.coroutines.f
        @NotNull
        f minusKey(@NotNull c<?> cVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlin/coroutines/f$c;", "Lkotlin/coroutines/f$b;", "E", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r3, @NotNull p<? super R, ? super b, ? extends R> pVar);

    @Nullable
    <E extends b> E get(@NotNull c<E> cVar);

    @NotNull
    f minusKey(@NotNull c<?> cVar);

    @NotNull
    f plus(@NotNull f fVar);
}
