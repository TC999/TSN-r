package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.InterfaceC15195d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H§@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH&J\b\u0010\u0011\u001a\u00020\u000fH\u0017J\u0014\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0012H'R\u001a\u0010\u0019\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0018\u001a\u0004\b \u0010\u001eR)\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001c8&X§\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b$\u0010\u0018\u001a\u0004\b#\u0010\u001e\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006&"}, m12616d2 = {"Lkotlinx/coroutines/channels/d0;", ExifInterface.LONGITUDE_EAST, "", "K", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "H", "Lkotlinx/coroutines/channels/m0;", "B", "poll", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/p;", "iterator", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "b", CommonNetImpl.CANCEL, "", "", "a", "h", "()Z", "isClosedForReceive$annotations", "()V", "isClosedForReceive", "isEmpty", "isEmpty$annotations", "Lkotlinx/coroutines/selects/d;", "F", "()Lkotlinx/coroutines/selects/d;", "onReceive", "G", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "M", "getOnReceiveOrClosed$annotations", "onReceiveOrClosed", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.d0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC14695d0<E> {

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.d0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14696a {
        /* renamed from: b */
        public static /* synthetic */ void m5472b(InterfaceC14695d0 interfaceC14695d0, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                interfaceC14695d0.mo5474b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* renamed from: c */
        public static /* synthetic */ boolean m5471c(InterfaceC14695d0 interfaceC14695d0, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return interfaceC14695d0.mo5475a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @InternalCoroutinesApi
        /* renamed from: d */
        public static /* synthetic */ void m5470d() {
        }

        @Annotations(level = DeprecationLevel.WARNING, message = "Deprecated in favor of onReceiveOrClosed and onReceiveOrNull extension", replaceWith = @ReplaceWith(expression = "onReceiveOrNull", imports = {"kotlinx.coroutines.channels.onReceiveOrNull"}))
        @LowPriorityInOverloadResolution
        @ObsoleteCoroutinesApi
        /* renamed from: e */
        public static /* synthetic */ void m5469e() {
        }

        @ExperimentalCoroutinesApi
        /* renamed from: f */
        public static /* synthetic */ void m5468f() {
        }

        @ExperimentalCoroutinesApi
        /* renamed from: g */
        public static /* synthetic */ void m5467g() {
        }
    }

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: B */
    Object mo5400B(@NotNull InterfaceC14268c<? super C14719m0<? extends E>> interfaceC14268c);

    @NotNull
    /* renamed from: F */
    InterfaceC15195d<E> mo5399F();

    @NotNull
    /* renamed from: G */
    InterfaceC15195d<E> mo5398G();

    @ObsoleteCoroutinesApi
    @Nullable
    @Annotations(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    /* renamed from: H */
    Object mo5397H(@NotNull InterfaceC14268c<? super E> interfaceC14268c);

    @Nullable
    /* renamed from: K */
    Object mo5396K(@NotNull InterfaceC14268c<? super E> interfaceC14268c);

    @NotNull
    /* renamed from: M */
    InterfaceC15195d<C14719m0<E>> mo5395M();

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    /* synthetic */ boolean mo5475a(@Nullable Throwable th);

    /* renamed from: b */
    void mo5474b(@Nullable CancellationException cancellationException);

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    /* renamed from: h */
    boolean mo5394h();

    boolean isEmpty();

    @NotNull
    InterfaceC14725p<E> iterator();

    @Nullable
    E poll();
}
