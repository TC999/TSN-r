package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Channel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u000b"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lkotlin/f1;", "onUndeliveredElement", "Lkotlinx/coroutines/channels/n;", "b", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C14728q {
    @NotNull
    /* renamed from: b */
    public static final <E> InterfaceC14722n<E> m5384b(int i, @NotNull BufferOverflow bufferOverflow, @Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        if (i == -2) {
            return new ArrayChannel(bufferOverflow == BufferOverflow.SUSPEND ? InterfaceC14722n.f42117n0.m5401a() : 1, bufferOverflow, interfaceC15280l);
        } else if (i == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new ConflatedChannel(interfaceC15280l);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new RendezvousChannel(interfaceC15280l);
            }
            return new ArrayChannel(1, bufferOverflow, interfaceC15280l);
        } else if (i != Integer.MAX_VALUE) {
            if (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new ConflatedChannel(interfaceC15280l);
            }
            return new ArrayChannel(i, bufferOverflow, interfaceC15280l);
        } else {
            return new LinkedListChannel(interfaceC15280l);
        }
    }

    /* renamed from: c */
    public static /* synthetic */ InterfaceC14722n m5383c(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m5382d(i, null, null, 6, null);
    }

    /* renamed from: d */
    public static /* synthetic */ InterfaceC14722n m5382d(int i, BufferOverflow bufferOverflow, InterfaceC15280l interfaceC15280l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            interfaceC15280l = null;
        }
        return m5384b(i, bufferOverflow, interfaceC15280l);
    }
}
