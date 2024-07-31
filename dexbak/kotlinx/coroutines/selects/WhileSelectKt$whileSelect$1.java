package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WhileSelect.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0002\b\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0087H"}, m12616d2 = {"Lkotlin/Function1;", "Lkotlinx/coroutines/selects/a;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "Lkotlin/coroutines/c;", "continuation", "", "whileSelect"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.selects.WhileSelectKt", m8638f = "WhileSelect.kt", m8637i = {0}, m8636l = {37}, m8635m = "whileSelect", m8634n = {"builder"}, m8633s = {"L$0"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public WhileSelectKt$whileSelect$1(InterfaceC14268c interfaceC14268c) {
        super(interfaceC14268c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelect.m3722a(null, this);
    }
}
