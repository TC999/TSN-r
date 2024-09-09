package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Tasks.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/scheduling/g;", "Lkotlinx/coroutines/scheduling/m;", "", "a", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g extends m {

    /* renamed from: a  reason: collision with root package name */
    public static final g f60605a = new g();

    private g() {
    }

    @Override // kotlinx.coroutines.scheduling.m
    public long a() {
        return System.nanoTime();
    }
}
