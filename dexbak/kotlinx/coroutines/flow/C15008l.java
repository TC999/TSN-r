package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.internal.C14983f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007\u001a0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007\u001a&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/channels/d0;", "channel", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/channels/d0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "consume", "f", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/channels/d0;ZLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/h;", "h", "d", "Lkotlinx/coroutines/channels/j;", "a", "Lkotlinx/coroutines/q0;", Constants.PARAM_SCOPE, "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "b", "g", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class C15008l {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15009a<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ BroadcastChannel f42869a;

        public C15009a(BroadcastChannel broadcastChannel) {
            this.f42869a = broadcastChannel;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object m4604q0 = C15006k.m4604q0(flowCollector, this.f42869a.mo5175v(), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return m4604q0 == m8642h ? m4604q0 : Unit.f41048a;
        }
    }

    /* compiled from: Channels.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/channels/d0;", "channel", "", "consume", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "emitAllImpl"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", m8638f = "Channels.kt", m8637i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m8636l = {50, 61}, m8635m = "emitAllImpl$FlowKt__ChannelsKt", m8634n = {"$this$emitAllImpl", "channel", "consume", "cause", "$this$run", "$this$emitAllImpl", "channel", "consume", "cause", CommonNetImpl.RESULT}, m8633s = {"L$0", "L$1", "Z$0", "L$2", "L$3", "L$0", "L$1", "Z$0", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.l$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15010b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42870a;

        /* renamed from: b */
        int f42871b;

        /* renamed from: c */
        Object f42872c;

        /* renamed from: d */
        Object f42873d;

        /* renamed from: e */
        Object f42874e;

        /* renamed from: f */
        Object f42875f;

        /* renamed from: g */
        boolean f42876g;

        C15010b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42870a = obj;
            this.f42871b |= Integer.MIN_VALUE;
            return C15008l.m4562f(null, null, false, this);
        }
    }

    @FlowPreview
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4567a(@NotNull BroadcastChannel<T> broadcastChannel) {
        return new C15009a(broadcastChannel);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @NotNull
    /* renamed from: b */
    public static final <T> BroadcastChannel<T> m4566b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        return C14983f.m4779b(interfaceC14958h).mo4784h(coroutineScope, coroutineStart);
    }

    /* renamed from: c */
    public static /* synthetic */ BroadcastChannel m4565c(InterfaceC14958h interfaceC14958h, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return C15006k.m4617n(interfaceC14958h, coroutineScope, coroutineStart);
    }

    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4564d(@NotNull InterfaceC14695d0<? extends T> interfaceC14695d0) {
        return new C14950e(interfaceC14695d0, true, null, 0, null, 28, null);
    }

    @Nullable
    /* renamed from: e */
    public static final <T> Object m4563e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14695d0<? extends T> interfaceC14695d0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4562f = m4562f(flowCollector, interfaceC14695d0, true, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4562f == m8642h ? m4562f : Unit.f41048a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0083 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:67:0x0036, B:81:0x007d, B:83:0x0083, B:89:0x0091, B:90:0x0092, B:72:0x0059), top: B:104:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0092 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:67:0x0036, B:81:0x007d, B:83:0x0083, B:89:0x0091, B:90:0x0092, B:72:0x0059), top: B:104:0x0022 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.d0] */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.channels.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x00a6 -> B:68:0x0039). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object m4562f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r8, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14695d0<? extends T> r9, boolean r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.C15008l.C15010b
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.l$b r0 = (kotlinx.coroutines.flow.C15008l.C15010b) r0
            int r1 = r0.f42871b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42871b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l$b r0 = new kotlinx.coroutines.flow.l$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f42870a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42871b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5f
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r8 = r0.f42874e
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.f42876g
            java.lang.Object r10 = r0.f42873d
            kotlinx.coroutines.channels.d0 r10 = (kotlinx.coroutines.channels.InterfaceC14695d0) r10
            java.lang.Object r2 = r0.f42872c
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.C14294d0.m8596n(r11)     // Catch: java.lang.Throwable -> L5d
        L39:
            r11 = r8
            r8 = r2
            r6 = r10
            r10 = r9
            r9 = r6
            goto L63
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            java.lang.Object r8 = r0.f42875f
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.f42874e
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.f42876g
            java.lang.Object r10 = r0.f42873d
            kotlinx.coroutines.channels.d0 r10 = (kotlinx.coroutines.channels.InterfaceC14695d0) r10
            java.lang.Object r2 = r0.f42872c
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.C14294d0.m8596n(r11)     // Catch: java.lang.Throwable -> L5d
            goto L7d
        L5d:
            r8 = move-exception
            goto Lad
        L5f:
            kotlin.C14294d0.m8596n(r11)
            r11 = 0
        L63:
            r0.f42872c = r8     // Catch: java.lang.Throwable -> La9
            r0.f42873d = r9     // Catch: java.lang.Throwable -> La9
            r0.f42876g = r10     // Catch: java.lang.Throwable -> La9
            r0.f42874e = r11     // Catch: java.lang.Throwable -> La9
            r0.f42875f = r8     // Catch: java.lang.Throwable -> La9
            r0.f42871b = r4     // Catch: java.lang.Throwable -> La9
            java.lang.Object r2 = r9.mo5400B(r0)     // Catch: java.lang.Throwable -> La9
            if (r2 != r1) goto L76
            return r1
        L76:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L7d:
            boolean r5 = kotlinx.coroutines.channels.C14719m0.m5407l(r11)     // Catch: java.lang.Throwable -> L5d
            if (r5 == 0) goto L92
            java.lang.Throwable r11 = kotlinx.coroutines.channels.C14719m0.m5413f(r11)     // Catch: java.lang.Throwable -> L5d
            if (r11 != 0) goto L91
            if (r9 == 0) goto L8e
            kotlinx.coroutines.channels.C14729r.m5239r(r10, r8)
        L8e:
            kotlin.f1 r8 = kotlin.Unit.f41048a
            return r8
        L91:
            throw r11     // Catch: java.lang.Throwable -> L5d
        L92:
            java.lang.Object r5 = kotlinx.coroutines.channels.C14719m0.m5411h(r11)     // Catch: java.lang.Throwable -> L5d
            r0.f42872c = r2     // Catch: java.lang.Throwable -> L5d
            r0.f42873d = r10     // Catch: java.lang.Throwable -> L5d
            r0.f42876g = r9     // Catch: java.lang.Throwable -> L5d
            r0.f42874e = r8     // Catch: java.lang.Throwable -> L5d
            r0.f42875f = r11     // Catch: java.lang.Throwable -> L5d
            r0.f42871b = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r11 = r2.emit(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r11 != r1) goto L39
            return r1
        La9:
            r8 = move-exception
            r6 = r10
            r10 = r9
            r9 = r6
        Lad:
            throw r8     // Catch: java.lang.Throwable -> Lae
        Lae:
            r11 = move-exception
            if (r9 == 0) goto Lb4
            kotlinx.coroutines.channels.C14729r.m5239r(r10, r8)
        Lb4:
            goto Lb6
        Lb5:
            throw r11
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15008l.m4562f(kotlinx.coroutines.flow.i, kotlinx.coroutines.channels.d0, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    @FlowPreview
    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14695d0<T> m4561g(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope) {
        return C14983f.m4779b(interfaceC14958h).mo4768o(coroutineScope);
    }

    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4560h(@NotNull InterfaceC14695d0<? extends T> interfaceC14695d0) {
        return new C14950e(interfaceC14695d0, false, null, 0, null, 28, null);
    }
}
