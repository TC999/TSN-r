package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15285q;

/* compiled from: DeepRecursive.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004BM\u00129\u0010\"\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u0011\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$Je\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000429\u0010\b\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0017\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0014\"\u0004\b\u0003\u0010\u0015*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00162\u0006\u0010\u0011\u001a\u00028\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR$\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006%"}, m12616d2 = {"Lkotlin/g;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/f;", "Lkotlin/coroutines/c;", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "currentFunction", "cont", "m", "(Ll1/q;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", DomainCampaignEx.LOOPBACK_VALUE, "b", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "U", ExifInterface.LATITUDE_SOUTH, "Lkotlin/d;", "c", "(Lkotlin/d;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "n", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "block", "<init>", "(Ll1/q;Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalStdlibApi
/* renamed from: kotlin.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14301g<T, R> extends AbstractC14299f<T, R> implements InterfaceC14268c<R> {

    /* renamed from: a */
    private InterfaceC15285q<? super AbstractC14299f<?, ?>, Object, ? super InterfaceC14268c<Object>, ? extends Object> f41049a;

    /* renamed from: b */
    private Object f41050b;

    /* renamed from: c */
    private InterfaceC14268c<Object> f41051c;

    /* renamed from: d */
    private Object f41052d;

    /* compiled from: Continuation.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, m12616d2 = {"kotlin/coroutines/e$a", "Lkotlin/coroutines/c;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14302a implements InterfaceC14268c<Object> {

        /* renamed from: a */
        final /* synthetic */ CoroutineContext f41053a;

        /* renamed from: b */
        final /* synthetic */ C14301g f41054b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15285q f41055c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC14268c f41056d;

        public C14302a(CoroutineContext coroutineContext, C14301g c14301g, InterfaceC15285q interfaceC15285q, InterfaceC14268c interfaceC14268c) {
            this.f41053a = coroutineContext;
            this.f41054b = c14301g;
            this.f41055c = interfaceC15285q;
            this.f41056d = interfaceC14268c;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        @NotNull
        public CoroutineContext getContext() {
            return this.f41053a;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        public void resumeWith(@NotNull Object obj) {
            this.f41054b.f41049a = this.f41055c;
            this.f41054b.f41051c = this.f41056d;
            this.f41054b.f41052d = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C14301g(@NotNull InterfaceC15285q<? super AbstractC14299f<T, R>, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> block, T t) {
        super(null);
        Object obj;
        C14342f0.m8184p(block, "block");
        this.f41049a = block;
        this.f41050b = t;
        this.f41051c = this;
        obj = C14296e.f41042a;
        this.f41052d = obj;
    }

    /* renamed from: m */
    private final InterfaceC14268c<Object> m8576m(InterfaceC15285q<? super AbstractC14299f<?, ?>, Object, ? super InterfaceC14268c<Object>, ? extends Object> interfaceC15285q, InterfaceC14268c<Object> interfaceC14268c) {
        return new C14302a(EmptyCoroutineContext.INSTANCE, this, interfaceC15285q, interfaceC14268c);
    }

    @Override // kotlin.AbstractC14299f
    @Nullable
    /* renamed from: b */
    public Object mo8584b(T t, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        if (interfaceC14268c != null) {
            this.f41051c = interfaceC14268c;
            this.f41050b = t;
            m8642h = C14287b.m8642h();
            m8642h2 = C14287b.m8642h();
            if (m8642h == m8642h2) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m8642h;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.AbstractC14299f
    @Nullable
    /* renamed from: c */
    public <U, S> Object mo8583c(@NotNull DeepRecursive<U, S> deepRecursive, U u, @NotNull InterfaceC14268c<? super S> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        InterfaceC15285q<AbstractC14299f<U, S>, U, InterfaceC14268c<? super S>, Object> m8610a = deepRecursive.m8610a();
        if (m8610a != null) {
            InterfaceC15285q<? super AbstractC14299f<?, ?>, Object, ? super InterfaceC14268c<Object>, ? extends Object> interfaceC15285q = this.f41049a;
            if (m8610a != interfaceC15285q) {
                this.f41049a = m8610a;
                if (interfaceC14268c == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }
                this.f41051c = m8576m(interfaceC15285q, interfaceC14268c);
            } else if (interfaceC14268c != null) {
                this.f41051c = interfaceC14268c;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            this.f41050b = u;
            m8642h = C14287b.m8642h();
            m8642h2 = C14287b.m8642h();
            if (m8642h == m8642h2) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m8642h;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.DeepRecursiveFunctionBlock /* = suspend kotlin.DeepRecursiveScope<*, *>.(kotlin.Any?) -> kotlin.Any? */");
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* renamed from: n */
    public final R m8575n() {
        Object obj;
        Object obj2;
        Object m8642h;
        while (true) {
            R r = (R) this.f41052d;
            InterfaceC14268c<Object> interfaceC14268c = this.f41051c;
            if (interfaceC14268c != null) {
                obj = C14296e.f41042a;
                if (Result.m60150equalsimpl0(obj, r)) {
                    try {
                        InterfaceC15285q<? super AbstractC14299f<?, ?>, Object, ? super InterfaceC14268c<Object>, ? extends Object> interfaceC15285q = this.f41049a;
                        Object obj3 = this.f41050b;
                        if (interfaceC15285q != null) {
                            Object invoke = ((InterfaceC15285q) TypeIntrinsics.m8010q(interfaceC15285q, 3)).invoke(this, obj3, interfaceC14268c);
                            m8642h = C14287b.m8642h();
                            if (invoke != m8642h) {
                                Result.C14124a c14124a = Result.Companion;
                                interfaceC14268c.resumeWith(Result.m60148constructorimpl(invoke));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                            break;
                        }
                    } catch (Throwable th) {
                        Result.C14124a c14124a2 = Result.Companion;
                        interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
                    }
                } else {
                    obj2 = C14296e.f41042a;
                    this.f41052d = obj2;
                    interfaceC14268c.resumeWith(r);
                }
            } else {
                C14294d0.m8596n(r);
                return r;
            }
        }
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        this.f41051c = null;
        this.f41052d = obj;
    }
}
