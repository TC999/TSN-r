package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.time.InterfaceC14602o;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\r"}, m12616d2 = {"Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlin/time/d;", "b", "(Ll1/a;)J", "Lkotlin/time/o;", "a", "(Lkotlin/time/o;Ll1/a;)J", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/time/q;", "d", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.time.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class measureTime {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: a */
    public static final long m5991a(@NotNull InterfaceC14602o measureTime, @NotNull InterfaceC15269a<Unit> block) {
        C14342f0.m8184p(measureTime, "$this$measureTime");
        C14342f0.m8184p(block, "block");
        AbstractC14601n mo5979a = measureTime.mo5979a();
        block.invoke();
        return mo5979a.mo5984a();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: b */
    public static final long m5990b(@NotNull InterfaceC15269a<Unit> block) {
        C14342f0.m8184p(block, "block");
        AbstractC14601n mo5979a = InterfaceC14602o.C14604b.f41670c.mo5979a();
        block.invoke();
        return mo5979a.mo5984a();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    /* renamed from: c */
    public static final <T> C14606q<T> m5989c(@NotNull InterfaceC14602o measureTimedValue, @NotNull InterfaceC15269a<? extends T> block) {
        C14342f0.m8184p(measureTimedValue, "$this$measureTimedValue");
        C14342f0.m8184p(block, "block");
        return new C14606q<>(block.invoke(), measureTimedValue.mo5979a().mo5984a(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    /* renamed from: d */
    public static final <T> C14606q<T> m5988d(@NotNull InterfaceC15269a<? extends T> block) {
        C14342f0.m8184p(block, "block");
        return new C14606q<>(block.invoke(), InterfaceC14602o.C14604b.f41670c.mo5979a().mo5984a(), null);
    }
}
