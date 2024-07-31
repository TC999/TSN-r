package kotlinx.coroutines.debug.internal;

import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b(\u0010)R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\b\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8G¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010%\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006*"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/c;", "", "Lkotlin/coroutines/jvm/internal/c;", "a", "Lkotlin/coroutines/jvm/internal/c;", "()Lkotlin/coroutines/jvm/internal/c;", "creationStackBottom", "", "b", "J", "e", "()J", "sequenceNumber", "", "Ljava/lang/StackTraceElement;", "c", "Ljava/util/List;", "()Ljava/util/List;", "creationStackTrace", "", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "state", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "()Ljava/lang/Thread;", "lastObservedThread", "lastObservedFrame", "g", "lastObservedStackTrace", "Lkotlin/coroutines/f;", "h", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/debug/internal/d;", SocialConstants.PARAM_SOURCE, "<init>", "(Lkotlinx/coroutines/debug/internal/d;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.debug.internal.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DebugCoroutineInfo {
    @Nullable

    /* renamed from: a */
    private final CoroutineStackFrame f42228a;

    /* renamed from: b */
    private final long f42229b;
    @NotNull

    /* renamed from: c */
    private final List<StackTraceElement> f42230c;
    @NotNull

    /* renamed from: d */
    private final String f42231d;
    @Nullable

    /* renamed from: e */
    private final Thread f42232e;
    @Nullable

    /* renamed from: f */
    private final CoroutineStackFrame f42233f;
    @NotNull

    /* renamed from: g */
    private final List<StackTraceElement> f42234g;
    @NotNull

    /* renamed from: h */
    private final CoroutineContext f42235h;

    public DebugCoroutineInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        this.f42235h = coroutineContext;
        this.f42228a = debugCoroutineInfoImpl.m5106b();
        this.f42229b = debugCoroutineInfoImpl.f42241f;
        this.f42230c = debugCoroutineInfoImpl.m5105c();
        this.f42231d = debugCoroutineInfoImpl.m5103e();
        this.f42232e = debugCoroutineInfoImpl.f42238c;
        this.f42233f = debugCoroutineInfoImpl.m5104d();
        this.f42234g = debugCoroutineInfoImpl.m5102f();
    }

    @Nullable
    /* renamed from: a */
    public final CoroutineStackFrame m5114a() {
        return this.f42228a;
    }

    @NotNull
    /* renamed from: b */
    public final List<StackTraceElement> m5113b() {
        return this.f42230c;
    }

    @Nullable
    /* renamed from: c */
    public final CoroutineStackFrame m5112c() {
        return this.f42233f;
    }

    @Nullable
    /* renamed from: d */
    public final Thread m5111d() {
        return this.f42232e;
    }

    /* renamed from: e */
    public final long m5110e() {
        return this.f42229b;
    }

    @NotNull
    /* renamed from: f */
    public final String m5109f() {
        return this.f42231d;
    }

    @JvmName(name = "lastObservedStackTrace")
    @NotNull
    /* renamed from: g */
    public final List<StackTraceElement> m5108g() {
        return this.f42234g;
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.f42235h;
    }
}
