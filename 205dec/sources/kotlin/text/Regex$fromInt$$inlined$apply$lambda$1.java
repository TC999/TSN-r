package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/text/g;", "", "T", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Enum;)Z", "kotlin/text/RegexKt$fromInt$1$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class Regex$fromInt$$inlined$apply$lambda$1<T> extends Lambda implements l1.l<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$fromInt$$inlined$apply$lambda$1(int i4) {
        super(1);
        this.$value$inlined = i4;
    }

    @Override // l1.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public final boolean invoke(Enum r3) {
        g gVar = (g) r3;
        return (this.$value$inlined & gVar.getMask()) == gVar.getValue();
    }
}
