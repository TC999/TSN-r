package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.p518qq.p519e.comm.adevent.AdEventType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.FlowPreview;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@FlowPreview
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/flow/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Flow<T> implements InterfaceC14958h<T>, InterfaceC14945c<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Flow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collect"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.AbstractFlow", m8638f = "Flow.kt", m8637i = {0, 0, 0}, m8636l = {AdEventType.VIDEO_PRELOADED}, m8635m = "collect", m8634n = {"this", "collector", "safeCollector"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14941a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42666a;

        /* renamed from: b */
        int f42667b;

        /* renamed from: d */
        Object f42669d;

        /* renamed from: e */
        Object f42670e;

        /* renamed from: f */
        Object f42671f;

        C14941a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42666a = obj;
            this.f42667b |= Integer.MIN_VALUE;
            return Flow.this.mo4470e(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo4470e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.Flow.C14941a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.a$a r0 = (kotlinx.coroutines.flow.Flow.C14941a) r0
            int r1 = r0.f42667b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42667b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.a$a r0 = new kotlinx.coroutines.flow.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f42666a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42667b
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f42671f
            kotlinx.coroutines.flow.internal.SafeCollector r6 = (kotlinx.coroutines.flow.internal.SafeCollector) r6
            java.lang.Object r1 = r0.f42670e
            kotlinx.coroutines.flow.i r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r0 = r0.f42669d
            kotlinx.coroutines.flow.a r0 = (kotlinx.coroutines.flow.Flow) r0
            kotlin.C14294d0.m8596n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5b
        L35:
            r7 = move-exception
            goto L65
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.C14294d0.m8596n(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.f r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f42669d = r5     // Catch: java.lang.Throwable -> L61
            r0.f42670e = r6     // Catch: java.lang.Throwable -> L61
            r0.f42671f = r7     // Catch: java.lang.Throwable -> L61
            r0.f42667b = r3     // Catch: java.lang.Throwable -> L61
            java.lang.Object r6 = r5.mo4500f(r7, r0)     // Catch: java.lang.Throwable -> L61
            if (r6 != r1) goto L5a
            return r1
        L5a:
            r6 = r7
        L5b:
            r6.releaseIntercepted()
            kotlin.f1 r6 = kotlin.Unit.f41048a
            return r6
        L61:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L65:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Flow.mo4470e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: f */
    public abstract Object mo4500f(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);
}
