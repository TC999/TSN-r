package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: ConcurrentWeakMap.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0002\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0012"}, m12616d2 = {"", "Lkotlinx/coroutines/debug/internal/i;", "d", "", "e", "", "a", "I", "MAGIC", "b", "MIN_CAPACITY", "Lkotlinx/coroutines/internal/j0;", "c", "Lkotlinx/coroutines/internal/j0;", "REHASH", "Lkotlinx/coroutines/debug/internal/i;", "MARKED_NULL", "MARKED_TRUE", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.debug.internal.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14759b {

    /* renamed from: a */
    private static final int f42223a = -1640531527;

    /* renamed from: b */
    private static final int f42224b = 16;

    /* renamed from: c */
    private static final Symbol f42225c = new Symbol("REHASH");

    /* renamed from: d */
    private static final C14772i f42226d = new C14772i(null);

    /* renamed from: e */
    private static final C14772i f42227e = new C14772i(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final C14772i m5116d(Object obj) {
        if (obj == null) {
            return f42226d;
        }
        return C14342f0.m8193g(obj, Boolean.TRUE) ? f42227e : new C14772i(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static final Void m5115e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
