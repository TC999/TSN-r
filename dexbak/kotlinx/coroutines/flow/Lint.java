package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007\u001a\"\u0010\u000f\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\n2\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0007\"\"\u0010\u0015\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\"\u0010\u0019\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/x;", "Lkotlinx/coroutines/flow/h;", "c", "Lkotlin/coroutines/f;", "context", "f", "Lkotlinx/coroutines/flow/h0;", "d", "e", "Lkotlinx/coroutines/flow/i;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "a", "", "i", "(Lkotlinx/coroutines/flow/i;)Z", "isActive$annotations", "(Lkotlinx/coroutines/flow/i;)V", "isActive", "g", "(Lkotlinx/coroutines/flow/i;)Lkotlin/coroutines/f;", "getCoroutineContext$annotations", "coroutineContext", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Lint {
    @Annotations(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    /* renamed from: a */
    public static final void m4511a(@NotNull FlowCollector<?> flowCollector, @Nullable CancellationException cancellationException) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    /* renamed from: b */
    public static /* synthetic */ void m4510b(FlowCollector flowCollector, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        m4511a(flowCollector, cancellationException);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4509c(@NotNull InterfaceC15048x<? extends T> interfaceC15048x) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4508d(@NotNull StateFlow<? extends T> stateFlow) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14958h<T> m4507e(@NotNull StateFlow<? extends T> stateFlow) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m4506f(@NotNull InterfaceC15048x<? extends T> interfaceC15048x, @NotNull CoroutineContext coroutineContext) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @NotNull
    /* renamed from: g */
    public static final CoroutineContext m4505g(@NotNull FlowCollector<?> flowCollector) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext()", imports = {}))
    /* renamed from: h */
    public static /* synthetic */ void m4504h(FlowCollector flowCollector) {
    }

    /* renamed from: i */
    public static final boolean m4503i(@NotNull FlowCollector<?> flowCollector) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().isActive", imports = {}))
    /* renamed from: j */
    public static /* synthetic */ void m4502j(FlowCollector flowCollector) {
    }
}
