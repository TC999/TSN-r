package kotlin.coroutines;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.p;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ContinuationInterceptor.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J*\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lkotlin/coroutines/d;", "Lkotlin/coroutines/f$b;", "T", "Lkotlin/coroutines/c;", "continuation", "interceptContinuation", "Lkotlin/f1;", "releaseInterceptedContinuation", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "minusKey", "f0", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d extends f.b {
    @NotNull

    /* renamed from: f0  reason: collision with root package name */
    public static final b f55503f0 = b.f55504a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <R> R a(@NotNull d dVar, R r3, @NotNull p<? super R, ? super f.b, ? extends R> operation) {
            f0.p(dVar, "this");
            f0.p(operation, "operation");
            return (R) f.b.a.a(dVar, r3, operation);
        }

        @Nullable
        public static <E extends f.b> E b(@NotNull d dVar, @NotNull f.c<E> key) {
            f0.p(dVar, "this");
            f0.p(key, "key");
            if (key instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
                if (bVar.a(dVar.getKey())) {
                    E e4 = (E) bVar.b(dVar);
                    if (e4 instanceof f.b) {
                        return e4;
                    }
                    return null;
                }
                return null;
            } else if (d.f55503f0 == key) {
                return dVar;
            } else {
                return null;
            }
        }

        @NotNull
        public static f c(@NotNull d dVar, @NotNull f.c<?> key) {
            f0.p(dVar, "this");
            f0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return d.f55503f0 == key ? EmptyCoroutineContext.INSTANCE : dVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) ? dVar : EmptyCoroutineContext.INSTANCE;
        }

        @NotNull
        public static f d(@NotNull d dVar, @NotNull f context) {
            f0.p(dVar, "this");
            f0.p(context, "context");
            return f.b.a.d(dVar, context);
        }

        public static void e(@NotNull d dVar, @NotNull c<?> continuation) {
            f0.p(dVar, "this");
            f0.p(continuation, "continuation");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/f$c;", "Lkotlin/coroutines/d;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements f.c<d> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f55504a = new b();

        private b() {
        }
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    <E extends f.b> E get(@NotNull f.c<E> cVar);

    @NotNull
    <T> c<T> interceptContinuation(@NotNull c<? super T> cVar);

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    f minusKey(@NotNull f.c<?> cVar);

    void releaseInterceptedContinuation(@NotNull c<?> cVar);
}
