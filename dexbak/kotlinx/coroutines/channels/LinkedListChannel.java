package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.C15072c;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.C15198g;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u001b"}, m12616d2 = {"Lkotlinx/coroutines/channels/y;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a;", "element", "", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", UMCommonContent.f37777aG, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "u", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(@Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(interfaceC15280l);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: Z */
    protected final boolean mo5174Z() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: a0 */
    protected final boolean mo5173a0() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: u */
    protected final boolean mo5172u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: w */
    protected final boolean mo5171w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: y */
    public Object mo5170y(E e) {
        InterfaceC14698e0<?> m5497E;
        do {
            Object mo5170y = super.mo5170y(e);
            Symbol symbol = C14685b.f42052e;
            if (mo5170y == symbol) {
                return symbol;
            }
            if (mo5170y == C14685b.f42053f) {
                m5497E = m5497E(e);
                if (m5497E == null) {
                    return symbol;
                }
            } else if (mo5170y instanceof C14731t) {
                return mo5170y;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + mo5170y).toString());
            }
        } while (!(m5497E instanceof C14731t));
        return m5497E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: z */
    public Object mo5169z(E e, @NotNull InterfaceC15197f<?> interfaceC15197f) {
        Object mo3700u;
        while (true) {
            if (m5524Y()) {
                mo3700u = super.mo5169z(e, interfaceC15197f);
            } else {
                mo3700u = interfaceC15197f.mo3700u(m5490f(e));
                if (mo3700u == null) {
                    mo3700u = C14685b.f42052e;
                }
            }
            if (mo3700u == C15198g.m3696d()) {
                return C15198g.m3696d();
            }
            Symbol symbol = C14685b.f42052e;
            if (mo3700u == symbol) {
                return symbol;
            }
            if (mo3700u != C14685b.f42053f && mo3700u != C15072c.f43034b) {
                if (mo3700u instanceof C14731t) {
                    return mo3700u;
                }
                throw new IllegalStateException(("Invalid result " + mo3700u).toString());
            }
        }
    }
}
