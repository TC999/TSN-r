package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\u0014\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\nH'¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/channels/j;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/h0;", "Lkotlinx/coroutines/channels/d0;", "v", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "b", "", "", "a", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@ExperimentalCoroutinesApi
/* renamed from: kotlinx.coroutines.channels.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface BroadcastChannel<E> extends InterfaceC14704h0<E> {

    /* compiled from: BroadcastChannel.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14707a {
        /* renamed from: a */
        public static /* synthetic */ void m5435a(BroadcastChannel broadcastChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                broadcastChannel.mo3827b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* renamed from: b */
        public static /* synthetic */ boolean m5434b(BroadcastChannel broadcastChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return broadcastChannel.mo3828a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    /* renamed from: a */
    /* synthetic */ boolean mo3828a(@Nullable Throwable th);

    /* renamed from: b */
    void mo3827b(@Nullable CancellationException cancellationException);

    @NotNull
    /* renamed from: v */
    InterfaceC14695d0<E> mo5175v();
}
