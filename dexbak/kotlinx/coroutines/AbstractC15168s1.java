package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractC14267b;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Executors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H&R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/l0;", "Ljava/io/Closeable;", "Lkotlin/f1;", "close", "Ljava/util/concurrent/Executor;", "p", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "a", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.s1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15168s1 extends CoroutineDispatcher implements Closeable {

    /* renamed from: a */
    public static final C15169a f43237a = new C15169a(null);

    /* compiled from: Executors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlinx/coroutines/s1$a;", "Lkotlin/coroutines/b;", "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/s1;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    @ExperimentalStdlibApi
    /* renamed from: kotlinx.coroutines.s1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15169a extends AbstractC14267b<CoroutineDispatcher, AbstractC15168s1> {

        /* compiled from: Executors.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/coroutines/f$b;", "it", "Lkotlinx/coroutines/s1;", "a", "(Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/s1;"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.s1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C15170a extends Lambda implements InterfaceC15280l<CoroutineContext.InterfaceC14275b, AbstractC15168s1> {

            /* renamed from: a */
            public static final C15170a f43238a = new C15170a();

            C15170a() {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            @Nullable
            /* renamed from: a */
            public final AbstractC15168s1 invoke(@NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
                if (!(interfaceC14275b instanceof AbstractC15168s1)) {
                    interfaceC14275b = null;
                }
                return (AbstractC15168s1) interfaceC14275b;
            }
        }

        public /* synthetic */ C15169a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private C15169a() {
            super(CoroutineDispatcher.Key, C15170a.f43238a);
        }
    }

    public abstract void close();

    @NotNull
    /* renamed from: p */
    public abstract Executor mo3514p();
}
