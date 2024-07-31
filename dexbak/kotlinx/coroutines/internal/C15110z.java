package kotlinx.coroutines.internal;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.InterfaceC15263z0;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainDispatchers.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\t2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m12616d2 = {"Lkotlinx/coroutines/internal/z;", "Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/z0;", "", "s", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "", RtspHeaders.Values.TIME, "k", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/i1;", "e", "r", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "continuation", "u", "", "toString", "", "a", "Ljava/lang/Throwable;", "cause", "b", "Ljava/lang/String;", "errorHint", "p", "()Lkotlinx/coroutines/p2;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15110z extends MainCoroutineDispatcher implements InterfaceC15263z0 {

    /* renamed from: a */
    private final Throwable f43134a;

    /* renamed from: b */
    private final String f43135b;

    public /* synthetic */ C15110z(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != null) goto L7;
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void m4133s() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f43134a
            if (r0 == 0) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f43135b
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f43134a
            r1.<init>(r0, r2)
            throw r1
        L37:
            kotlinx.coroutines.internal.C15109y.m4136e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C15110z.m4133s():java.lang.Void");
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        m4133s();
        throw new ExceptionsH();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        m4133s();
        throw new ExceptionsH();
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @Nullable
    /* renamed from: k */
    public Object mo3485k(long j, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        m4133s();
        throw new ExceptionsH();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    /* renamed from: p */
    public MainCoroutineDispatcher mo3875p() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* renamed from: r */
    public Void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        m4133s();
        throw new ExceptionsH();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f43134a != null) {
            str = ", cause=" + this.f43134a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: u */
    public Void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        m4133s();
        throw new ExceptionsH();
    }

    public C15110z(@Nullable Throwable th, @Nullable String str) {
        this.f43134a = th;
        this.f43135b = str;
    }
}
