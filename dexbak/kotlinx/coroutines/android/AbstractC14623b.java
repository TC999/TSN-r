package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15263z0;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HandlerDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\b¨\u0006\t"}, m12616d2 = {"Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/z0;", "r", "()Lkotlinx/coroutines/android/b;", "immediate", "<init>", "()V", "Lkotlinx/coroutines/android/a;", "kotlinx-coroutines-android"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.android.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14623b extends MainCoroutineDispatcher implements InterfaceC15263z0 {
    private AbstractC14623b() {
    }

    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return InterfaceC15263z0.C15264a.m3483b(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @Nullable
    /* renamed from: k */
    public Object mo3485k(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return InterfaceC15263z0.C15264a.m3484a(this, j, interfaceC14268c);
    }

    @NotNull
    /* renamed from: r */
    public abstract AbstractC14623b mo5740r();

    public /* synthetic */ AbstractC14623b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
