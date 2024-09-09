package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugCoroutineInfo.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b(\u0010)R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\b\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8G\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/debug/internal/c;", "", "Lkotlin/coroutines/jvm/internal/c;", "a", "Lkotlin/coroutines/jvm/internal/c;", "()Lkotlin/coroutines/jvm/internal/c;", "creationStackBottom", "", "b", "J", "e", "()J", "sequenceNumber", "", "Ljava/lang/StackTraceElement;", "c", "Ljava/util/List;", "()Ljava/util/List;", "creationStackTrace", "", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "state", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "()Ljava/lang/Thread;", "lastObservedThread", "lastObservedFrame", "g", "lastObservedStackTrace", "Lkotlin/coroutines/f;", "h", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/debug/internal/d;", "source", "<init>", "(Lkotlinx/coroutines/debug/internal/d;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.c f59573a;

    /* renamed from: b  reason: collision with root package name */
    private final long f59574b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<StackTraceElement> f59575c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f59576d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Thread f59577e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.c f59578f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final List<StackTraceElement> f59579g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.coroutines.f f59580h;

    public c(@NotNull d dVar, @NotNull kotlin.coroutines.f fVar) {
        this.f59580h = fVar;
        this.f59573a = dVar.b();
        this.f59574b = dVar.f59586f;
        this.f59575c = dVar.c();
        this.f59576d = dVar.e();
        this.f59577e = dVar.f59583c;
        this.f59578f = dVar.d();
        this.f59579g = dVar.f();
    }

    @Nullable
    public final kotlin.coroutines.jvm.internal.c a() {
        return this.f59573a;
    }

    @NotNull
    public final List<StackTraceElement> b() {
        return this.f59575c;
    }

    @Nullable
    public final kotlin.coroutines.jvm.internal.c c() {
        return this.f59578f;
    }

    @Nullable
    public final Thread d() {
        return this.f59577e;
    }

    public final long e() {
        return this.f59574b;
    }

    @NotNull
    public final String f() {
        return this.f59576d;
    }

    @JvmName(name = "lastObservedStackTrace")
    @NotNull
    public final List<StackTraceElement> g() {
        return this.f59579g;
    }

    @NotNull
    public final kotlin.coroutines.f getContext() {
        return this.f59580h;
    }
}
