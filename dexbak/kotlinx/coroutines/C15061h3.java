package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p649u1.Undispatched;

/* compiled from: Supervisor.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001aO\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000bH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/e2;", "parent", "Lkotlinx/coroutines/b0;", "a", "b", "(Lkotlinx/coroutines/e2;)Lkotlinx/coroutines/e2;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.h3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C15061h3 {
    @NotNull
    /* renamed from: a */
    public static final CompletableJob m4413a(@Nullable Job job) {
        return new C15056g3(job);
    }

    /* renamed from: c */
    public static /* synthetic */ CompletableJob m4411c(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return m4413a(job);
    }

    /* renamed from: d */
    public static /* synthetic */ Job m4410d(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return m4413a(job);
    }

    @Nullable
    /* renamed from: e */
    public static final <R> Object m4409e(@NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        Supervisor supervisor = new Supervisor(interfaceC14268c.getContext(), interfaceC14268c);
        Object m220f = Undispatched.m220f(supervisor, supervisor, interfaceC15284p);
        m8642h = C14287b.m8642h();
        if (m220f == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m220f;
    }
}
