package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.ccg.CcgConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Share.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f¢\u0006\u0002\b\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/flow/m0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/x;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/flow/x;", "sharedFlow", "", "d", "()Ljava/util/List;", "replayCache", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "<init>", "(Lkotlinx/coroutines/flow/x;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15015m0<T> implements InterfaceC15048x<T> {

    /* renamed from: a */
    private final InterfaceC15048x<T> f42890a;

    /* renamed from: b */
    private final InterfaceC15284p<FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> f42891b;

    /* JADX WARN: Multi-variable type inference failed */
    public C15015m0(@NotNull InterfaceC15048x<? extends T> interfaceC15048x, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        this.f42890a = interfaceC15048x;
        this.f42891b = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15048x
    @NotNull
    /* renamed from: d */
    public List<T> mo4471d() {
        return this.f42890a.mo4471d();
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo4470e = this.f42890a.mo4470e(new C15011l0(flowCollector, this.f42891b), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }
}
