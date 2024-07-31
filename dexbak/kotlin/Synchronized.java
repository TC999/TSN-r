package kotlin;

import com.kuaishou.weapon.p205p0.C7304t;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.InlineMarker;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m12616d2 = {"R", "", "lock", "Lkotlin/Function0;", "block", C7304t.f25048d, "(Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/StandardKt")
/* renamed from: kotlin.h0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class Synchronized extends C14303g0 {
    @InlineOnly
    /* renamed from: l */
    private static final <R> R m8550l(Object obj, InterfaceC15269a<? extends R> interfaceC15269a) {
        R invoke;
        synchronized (obj) {
            try {
                invoke = interfaceC15269a.invoke();
                InlineMarker.m8228d(1);
            } catch (Throwable th) {
                InlineMarker.m8228d(1);
                InlineMarker.m8229c(1);
                throw th;
            }
        }
        InlineMarker.m8229c(1);
        return invoke;
    }
}
