package kotlin.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Standard;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Intrinsics.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001aD\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\b\u0004\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0087Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u000b\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "j", "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "getCOROUTINE_SUSPENDED$annotations", "()V", "COROUTINE_SUSPENDED", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* renamed from: kotlin.coroutines.intrinsics.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14287b extends IntrinsicsJvm {
    @NotNull
    /* renamed from: h */
    public static Object m8642h() {
        return Intrinsics.COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: i */
    public static /* synthetic */ void m8641i() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: j */
    private static final <T> Object m8640j(InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, InterfaceC14268c<? super T> interfaceC14268c) {
        throw new Standard("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
