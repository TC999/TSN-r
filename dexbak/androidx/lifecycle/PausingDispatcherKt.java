package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: PausingDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000b\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\t\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000b\u001aN\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class PausingDispatcherKt {
    @Nullable
    public static final <T> Object whenCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C14342f0.m8192h(lifecycle, "lifecycle");
        return whenCreated(lifecycle, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C14342f0.m8192h(lifecycle, "lifecycle");
        return whenResumed(lifecycle, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C14342f0.m8192h(lifecycle, "lifecycle");
        return whenStarted(lifecycle, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return C15057h.m4445i(Dispatchers.m5034e().mo3875p(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, interfaceC15284p, null), interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenCreated(@NotNull Lifecycle lifecycle, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull Lifecycle lifecycle, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull Lifecycle lifecycle, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, interfaceC15284p, interfaceC14268c);
    }
}
