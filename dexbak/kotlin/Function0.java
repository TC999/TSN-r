package kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: Timing.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a'\u0010\u0005\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, m12616d2 = {"Lkotlin/Function0;", "Lkotlin/f1;", "block", "", "b", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "TimingKt")
/* renamed from: p1.b  reason: from Kotlin metadata and invalid package */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Function0 {
    /* renamed from: a */
    public static final long m2543a(@NotNull InterfaceC15269a<Unit> block) {
        C14342f0.m8184p(block, "block");
        long nanoTime = System.nanoTime();
        block.invoke();
        return System.nanoTime() - nanoTime;
    }

    /* renamed from: b */
    public static final long m2542b(@NotNull InterfaceC15269a<Unit> block) {
        C14342f0.m8184p(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        block.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
