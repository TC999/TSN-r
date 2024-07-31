package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¨\u0006\u0013"}, m12616d2 = {"Lkotlin/coroutines/f;", "", "Lkotlin/coroutines/f$b;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ll1/p;)Ljava/lang/Object;", "context", "plus", "minusKey", "b", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14273a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CoroutineContext.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lkotlin/coroutines/f;", "acc", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f$b;)Lkotlin/coroutines/f;"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.coroutines.f$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14274a extends Lambda implements InterfaceC15284p<CoroutineContext, InterfaceC14275b, CoroutineContext> {

            /* renamed from: a */
            public static final C14274a f41028a = new C14274a();

            C14274a() {
                super(2);
            }

            @Override // p617l1.InterfaceC15284p
            @NotNull
            /* renamed from: a */
            public final CoroutineContext invoke(@NotNull CoroutineContext acc, @NotNull InterfaceC14275b element) {
                CoroutineContextImpl coroutineContextImpl;
                C14342f0.m8184p(acc, "acc");
                C14342f0.m8184p(element, "element");
                CoroutineContext minusKey = acc.minusKey(element.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (minusKey == emptyCoroutineContext) {
                    return element;
                }
                ContinuationInterceptor.C14270b c14270b = ContinuationInterceptor.f41024k0;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(c14270b);
                if (continuationInterceptor == null) {
                    coroutineContextImpl = new CoroutineContextImpl(minusKey, element);
                } else {
                    CoroutineContext minusKey2 = minusKey.minusKey(c14270b);
                    if (minusKey2 == emptyCoroutineContext) {
                        return new CoroutineContextImpl(element, continuationInterceptor);
                    }
                    coroutineContextImpl = new CoroutineContextImpl(new CoroutineContextImpl(minusKey2, element), continuationInterceptor);
                }
                return coroutineContextImpl;
            }
        }

        @NotNull
        /* renamed from: a */
        public static CoroutineContext m8663a(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext context) {
            C14342f0.m8184p(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, C14274a.f41028a);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00028\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ll1/p;)Ljava/lang/Object;", "minusKey", "getKey", "()Lkotlin/coroutines/f$c;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.f$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14275b extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.coroutines.f$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14276a {
            /* renamed from: a */
            public static <R> R m8661a(@NotNull InterfaceC14275b interfaceC14275b, R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14275b, ? extends R> operation) {
                C14342f0.m8184p(operation, "operation");
                return operation.invoke(r, interfaceC14275b);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            /* renamed from: b */
            public static <E extends InterfaceC14275b> E m8660b(@NotNull InterfaceC14275b interfaceC14275b, @NotNull InterfaceC14277c<E> key) {
                C14342f0.m8184p(key, "key");
                if (C14342f0.m8193g(interfaceC14275b.getKey(), key)) {
                    return interfaceC14275b;
                }
                return null;
            }

            @NotNull
            /* renamed from: c */
            public static CoroutineContext m8659c(@NotNull InterfaceC14275b interfaceC14275b, @NotNull InterfaceC14277c<?> key) {
                C14342f0.m8184p(key, "key");
                return C14342f0.m8193g(interfaceC14275b.getKey(), key) ? EmptyCoroutineContext.INSTANCE : interfaceC14275b;
            }

            @NotNull
            /* renamed from: d */
            public static CoroutineContext m8658d(@NotNull InterfaceC14275b interfaceC14275b, @NotNull CoroutineContext context) {
                C14342f0.m8184p(context, "context");
                return C14273a.m8663a(interfaceC14275b, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14275b, ? extends R> interfaceC15284p);

        @Override // kotlin.coroutines.CoroutineContext
        @Nullable
        <E extends InterfaceC14275b> E get(@NotNull InterfaceC14277c<E> interfaceC14277c);

        @NotNull
        InterfaceC14277c<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @NotNull
        CoroutineContext minusKey(@NotNull InterfaceC14277c<?> interfaceC14277c);
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, m12616d2 = {"Lkotlin/coroutines/f$c;", "Lkotlin/coroutines/f$b;", ExifInterface.LONGITUDE_EAST, "", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.f$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14277c<E extends InterfaceC14275b> {
    }

    <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14275b, ? extends R> interfaceC15284p);

    @Nullable
    <E extends InterfaceC14275b> E get(@NotNull InterfaceC14277c<E> interfaceC14277c);

    @NotNull
    CoroutineContext minusKey(@NotNull InterfaceC14277c<?> interfaceC14277c);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);
}
