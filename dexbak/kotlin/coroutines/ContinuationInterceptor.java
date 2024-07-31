package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J*\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\u0011"}, m12616d2 = {"Lkotlin/coroutines/d;", "Lkotlin/coroutines/f$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "continuation", "interceptContinuation", "Lkotlin/f1;", "releaseInterceptedContinuation", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "minusKey", "k0", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ContinuationInterceptor extends CoroutineContext.InterfaceC14275b {
    @NotNull

    /* renamed from: k0 */
    public static final C14270b f41024k0 = C14270b.f41025a;

    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14269a {
        /* renamed from: a */
        public static <R> R m8678a(@NotNull ContinuationInterceptor continuationInterceptor, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> operation) {
            C14342f0.m8184p(operation, "operation");
            return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(continuationInterceptor, r, operation);
        }

        @Nullable
        /* renamed from: b */
        public static <E extends CoroutineContext.InterfaceC14275b> E m8677b(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.InterfaceC14277c<E> key) {
            C14342f0.m8184p(key, "key");
            if (key instanceof AbstractC14267b) {
                AbstractC14267b abstractC14267b = (AbstractC14267b) key;
                if (abstractC14267b.m8680a(continuationInterceptor.getKey())) {
                    E e = (E) abstractC14267b.m8679b(continuationInterceptor);
                    if (e instanceof CoroutineContext.InterfaceC14275b) {
                        return e;
                    }
                    return null;
                }
                return null;
            } else if (ContinuationInterceptor.f41024k0 == key) {
                if (continuationInterceptor != null) {
                    return continuationInterceptor;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            } else {
                return null;
            }
        }

        @NotNull
        /* renamed from: c */
        public static CoroutineContext m8676c(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.InterfaceC14277c<?> key) {
            C14342f0.m8184p(key, "key");
            if (!(key instanceof AbstractC14267b)) {
                return ContinuationInterceptor.f41024k0 == key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
            }
            AbstractC14267b abstractC14267b = (AbstractC14267b) key;
            return (!abstractC14267b.m8680a(continuationInterceptor.getKey()) || abstractC14267b.m8679b(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.INSTANCE;
        }

        @NotNull
        /* renamed from: d */
        public static CoroutineContext m8675d(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext context) {
            C14342f0.m8184p(context, "context");
            return CoroutineContext.InterfaceC14275b.C14276a.m8658d(continuationInterceptor, context);
        }

        /* renamed from: e */
        public static void m8674e(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull InterfaceC14268c<?> continuation) {
            C14342f0.m8184p(continuation, "continuation");
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/f$c;", "Lkotlin/coroutines/d;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14270b implements CoroutineContext.InterfaceC14277c<ContinuationInterceptor> {

        /* renamed from: a */
        static final /* synthetic */ C14270b f41025a = new C14270b();

        private C14270b() {
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c);

    @NotNull
    <T> InterfaceC14268c<T> interceptContinuation(@NotNull InterfaceC14268c<? super T> interfaceC14268c);

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c);

    void releaseInterceptedContinuation(@NotNull InterfaceC14268c<?> interfaceC14268c);
}
