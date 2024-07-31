package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Builders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012-\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/flow/w;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/a;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "f", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15047w<T> extends Flow<T> {

    /* renamed from: a */
    private final InterfaceC15284p<FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> f42994a;

    /* JADX WARN: Multi-variable type inference failed */
    public C15047w(@NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        this.f42994a = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /* renamed from: f */
    public Object mo4500f(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object invoke = this.f42994a.invoke(flowCollector, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return invoke == m8642h ? invoke : Unit.f41048a;
    }
}
