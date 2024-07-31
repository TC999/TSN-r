package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.tencent.connect.common.Constants;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterfaceC15255y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Share.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aM\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aC\u0010\u001d\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000 \u001aU\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2-\u0010'\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130$\u0012\u0006\u0012\u0004\u0018\u00010%0\"¢\u0006\u0002\b&ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/q0;", Constants.PARAM_SCOPE, "Lkotlinx/coroutines/flow/d0;", "started", "", "replay", "Lkotlinx/coroutines/flow/x;", "g", "Lkotlinx/coroutines/flow/c0;", "c", "(Lkotlinx/coroutines/flow/h;I)Lkotlinx/coroutines/flow/c0;", "Lkotlin/coroutines/f;", "context", "upstream", "Lkotlinx/coroutines/flow/s;", "shared", "initialValue", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/s;Lkotlinx/coroutines/flow/d0;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/h0;", "j", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/q0;Lkotlinx/coroutines/flow/d0;Ljava/lang/Object;)Lkotlinx/coroutines/flow/h0;", "i", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/q0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/y;", CommonNetImpl.RESULT, "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/y;)V", "a", "Lkotlinx/coroutines/flow/t;", "b", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "f", "(Lkotlinx/coroutines/flow/x;Ll1/p;)Lkotlinx/coroutines/flow/x;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15037q {

    /* compiled from: Share.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", m8638f = "Share.kt", m8637i = {0, 1, 2, 3}, m8636l = {AdEventType.VIDEO_COMPLETE, AdEventType.VIDEO_READY, AdEventType.VIDEO_LOADING, 217}, m8635m = "invokeSuspend", m8634n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, m8633s = {"L$0", "L$0", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.q$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15038a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42969a;

        /* renamed from: b */
        Object f42970b;

        /* renamed from: c */
        int f42971c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC14948d0 f42972d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC14958h f42973e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15043s f42974f;

        /* renamed from: g */
        final /* synthetic */ Object f42975g;

        /* compiled from: Share.kt */
        @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", m8638f = "Share.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
        /* renamed from: kotlinx.coroutines.flow.q$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15039a extends SuspendLambda implements InterfaceC15284p<Integer, InterfaceC14268c<? super Boolean>, Object> {

            /* renamed from: a */
            private int f42976a;

            /* renamed from: b */
            int f42977b;

            C15039a(InterfaceC14268c interfaceC14268c) {
                super(2, interfaceC14268c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15039a c15039a = new C15039a(interfaceC14268c);
                Number number = (Number) obj;
                number.intValue();
                c15039a.f42976a = number.intValue();
                return c15039a;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(Integer num, InterfaceC14268c<? super Boolean> interfaceC14268c) {
                return ((C15039a) create(num, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                C14287b.m8642h();
                if (this.f42977b == 0) {
                    C14294d0.m8596n(obj);
                    return boxing.m8631a(this.f42976a > 0);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: Share.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/SharingCommand;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", m8638f = "Share.kt", m8637i = {0}, m8636l = {219}, m8635m = "invokeSuspend", m8634n = {"it"}, m8633s = {"L$0"})
        /* renamed from: kotlinx.coroutines.flow.q$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15040b extends SuspendLambda implements InterfaceC15284p<SharingStarted, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private SharingStarted f42978a;

            /* renamed from: b */
            Object f42979b;

            /* renamed from: c */
            int f42980c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15040b(InterfaceC14268c interfaceC14268c) {
                super(2, interfaceC14268c);
                C15038a.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15040b c15040b = new C15040b(interfaceC14268c);
                c15040b.f42978a = (SharingStarted) obj;
                return c15040b;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(SharingStarted sharingStarted, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15040b) create(sharingStarted, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42980c;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    SharingStarted sharingStarted = this.f42978a;
                    int i2 = C15004j.f42864a[sharingStarted.ordinal()];
                    if (i2 == 1) {
                        C15038a c15038a = C15038a.this;
                        InterfaceC14958h interfaceC14958h = c15038a.f42973e;
                        InterfaceC15043s interfaceC15043s = c15038a.f42974f;
                        this.f42979b = sharingStarted;
                        this.f42980c = 1;
                        if (interfaceC14958h.mo4470e(interfaceC15043s, this) == m8642h) {
                            return m8642h;
                        }
                    } else if (i2 == 3) {
                        C15038a c15038a2 = C15038a.this;
                        Object obj2 = c15038a2.f42975g;
                        if (obj2 == SharedFlow.f42672a) {
                            c15038a2.f42974f.mo4469g();
                        } else {
                            c15038a2.f42974f.mo4472b(obj2);
                        }
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    SharingStarted sharingStarted2 = (SharingStarted) this.f42979b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15038a(InterfaceC14948d0 interfaceC14948d0, InterfaceC14958h interfaceC14958h, InterfaceC15043s interfaceC15043s, Object obj, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42972d = interfaceC14948d0;
            this.f42973e = interfaceC14958h;
            this.f42974f = interfaceC15043s;
            this.f42975g = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C15038a c15038a = new C15038a(this.f42972d, this.f42973e, this.f42974f, this.f42975g, interfaceC14268c);
            c15038a.f42969a = (CoroutineScope) obj;
            return c15038a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15038a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0078 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r8.f42971c
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L25
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L25
                if (r1 != r2) goto L15
                goto L25
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1d:
                java.lang.Object r1 = r8.f42970b
                kotlinx.coroutines.q0 r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.C14294d0.m8596n(r9)
                goto L6a
            L25:
                java.lang.Object r0 = r8.f42970b
                kotlinx.coroutines.q0 r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.C14294d0.m8596n(r9)
                goto L99
            L2d:
                kotlin.C14294d0.m8596n(r9)
                kotlinx.coroutines.q0 r1 = r8.f42969a
                kotlinx.coroutines.flow.d0 r9 = r8.f42972d
                kotlinx.coroutines.flow.d0$a r6 = kotlinx.coroutines.flow.InterfaceC14948d0.f42687a
                kotlinx.coroutines.flow.d0 r7 = r6.m4820c()
                if (r9 != r7) goto L4b
                kotlinx.coroutines.flow.h r9 = r8.f42973e
                kotlinx.coroutines.flow.s r2 = r8.f42974f
                r8.f42970b = r1
                r8.f42971c = r5
                java.lang.Object r9 = r9.mo4470e(r2, r8)
                if (r9 != r0) goto L99
                return r0
            L4b:
                kotlinx.coroutines.flow.d0 r9 = r8.f42972d
                kotlinx.coroutines.flow.d0 r5 = r6.m4819d()
                r6 = 0
                if (r9 != r5) goto L79
                kotlinx.coroutines.flow.s r9 = r8.f42974f
                kotlinx.coroutines.flow.h0 r9 = r9.m4501c()
                kotlinx.coroutines.flow.q$a$a r2 = new kotlinx.coroutines.flow.q$a$a
                r2.<init>(r6)
                r8.f42970b = r1
                r8.f42971c = r4
                java.lang.Object r9 = kotlinx.coroutines.flow.C15006k.m4576z0(r9, r2, r8)
                if (r9 != r0) goto L6a
                return r0
            L6a:
                kotlinx.coroutines.flow.h r9 = r8.f42973e
                kotlinx.coroutines.flow.s r2 = r8.f42974f
                r8.f42970b = r1
                r8.f42971c = r3
                java.lang.Object r9 = r9.mo4470e(r2, r8)
                if (r9 != r0) goto L99
                return r0
            L79:
                kotlinx.coroutines.flow.d0 r9 = r8.f42972d
                kotlinx.coroutines.flow.s r3 = r8.f42974f
                kotlinx.coroutines.flow.h0 r3 = r3.m4501c()
                kotlinx.coroutines.flow.h r9 = r9.mo4814a(r3)
                kotlinx.coroutines.flow.h r9 = kotlinx.coroutines.flow.C15006k.m4624l0(r9)
                kotlinx.coroutines.flow.q$a$b r3 = new kotlinx.coroutines.flow.q$a$b
                r3.<init>(r6)
                r8.f42970b = r1
                r8.f42971c = r2
                java.lang.Object r9 = kotlinx.coroutines.flow.C15006k.m4735E(r9, r3, r8)
                if (r9 != r0) goto L99
                return r0
            L99:
                kotlin.f1 r9 = kotlin.Unit.f41048a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15037q.C15038a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Share.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", m8638f = "Share.kt", m8637i = {0, 0, 0}, m8636l = {TTAdConstant.VIDEO_COVER_URL_CODE}, m8635m = "invokeSuspend", m8634n = {"$this$launch", "state", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.q$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15041b extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42982a;

        /* renamed from: b */
        Object f42983b;

        /* renamed from: c */
        Object f42984c;

        /* renamed from: d */
        Object f42985d;

        /* renamed from: e */
        int f42986e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC14958h f42987f;

        /* renamed from: g */
        final /* synthetic */ InterfaceC15255y f42988g;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.q$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15042a<T> implements FlowCollector<T> {

            /* renamed from: b */
            final /* synthetic */ CoroutineScope f42990b;

            /* renamed from: c */
            final /* synthetic */ Ref.ObjectRef f42991c;

            public C15042a(CoroutineScope coroutineScope, Ref.ObjectRef objectRef) {
                C15041b.this = r1;
                this.f42990b = coroutineScope;
                this.f42991c = objectRef;
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.flow.t, T] */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Unit unit;
                Object m8642h;
                Ref.ObjectRef objectRef = this.f42991c;
                InterfaceC15044t interfaceC15044t = (InterfaceC15044t) objectRef.element;
                if (interfaceC15044t != null) {
                    interfaceC15044t.setValue(obj);
                    unit = Unit.f41048a;
                } else {
                    ?? r3 = (T) C15005j0.m4754a(obj);
                    C15041b.this.f42988g.mo3488y(C15006k.m4621m(r3));
                    Unit unit2 = Unit.f41048a;
                    objectRef.element = r3;
                    unit = unit2;
                }
                m8642h = C14287b.m8642h();
                return unit == m8642h ? unit : Unit.f41048a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15041b(InterfaceC14958h interfaceC14958h, InterfaceC15255y interfaceC15255y, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42987f = interfaceC14958h;
            this.f42988g = interfaceC15255y;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C15041b c15041b = new C15041b(this.f42987f, this.f42988g, interfaceC14268c);
            c15041b.f42982a = (CoroutineScope) obj;
            return c15041b;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15041b) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42986e;
            try {
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    CoroutineScope coroutineScope = this.f42982a;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = null;
                    InterfaceC14958h interfaceC14958h = this.f42987f;
                    C15042a c15042a = new C15042a(coroutineScope, objectRef);
                    this.f42983b = coroutineScope;
                    this.f42984c = objectRef;
                    this.f42985d = interfaceC14958h;
                    this.f42986e = 1;
                    if (interfaceC14958h.mo4470e(c15042a, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42985d;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.f42984c;
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.f42983b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            } catch (Throwable th) {
                this.f42988g.mo3493c(th);
                throw th;
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC15048x<T> m4521a(@NotNull InterfaceC15043s<T> interfaceC15043s) {
        return new C15045u(interfaceC15043s);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> StateFlow<T> m4520b(@NotNull InterfaceC15044t<T> interfaceC15044t) {
        return new C15046v(interfaceC15044t);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x002d, code lost:
        if (r3 == 0) goto L17;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.coroutines.flow.Share<T> m4519c(kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.n$b r0 = kotlinx.coroutines.channels.InterfaceC14722n.f42117n0
            int r0 = r0.m5401a()
            int r0 = kotlin.ranges.C14420o.m7577n(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3d
            r1 = r7
            kotlinx.coroutines.flow.internal.e r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.h r2 = r1.mo4772l()
            if (r2 == 0) goto L3d
            kotlinx.coroutines.flow.c0 r7 = new kotlinx.coroutines.flow.c0
            int r3 = r1.f42815b
            r4 = -3
            r5 = 0
            if (r3 == r4) goto L27
            r4 = -2
            if (r3 == r4) goto L27
            if (r3 == 0) goto L27
            r0 = r3
            goto L35
        L27:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f42816c
            kotlinx.coroutines.channels.BufferOverflow r6 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 != r6) goto L30
            if (r3 != 0) goto L35
            goto L34
        L30:
            if (r8 != 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f42816c
            kotlin.coroutines.f r1 = r1.f42814a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3d:
            kotlinx.coroutines.flow.c0 r8 = new kotlinx.coroutines.flow.c0
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15037q.m4519c(kotlinx.coroutines.flow.h, int):kotlinx.coroutines.flow.c0");
    }

    /* renamed from: d */
    private static final <T> void m4518d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, InterfaceC14958h<? extends T> interfaceC14958h, InterfaceC15043s<T> interfaceC15043s, InterfaceC14948d0 interfaceC14948d0, T t) {
        C15111j.m4126f(coroutineScope, coroutineContext, null, new C15038a(interfaceC14948d0, interfaceC14958h, interfaceC15043s, t, null), 2, null);
    }

    /* renamed from: e */
    private static final <T> void m4517e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, InterfaceC14958h<? extends T> interfaceC14958h, InterfaceC15255y<StateFlow<T>> interfaceC15255y) {
        C15111j.m4126f(coroutineScope, coroutineContext, null, new C15041b(interfaceC14958h, interfaceC15255y, null), 2, null);
    }

    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC15048x<T> m4516f(@NotNull InterfaceC15048x<? extends T> interfaceC15048x, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new C15015m0(interfaceC15048x, interfaceC15284p);
    }

    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC15048x<T> m4515g(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14948d0 interfaceC14948d0, int i) {
        Share m4519c = m4519c(interfaceC14958h, i);
        InterfaceC15043s m4832a = SharedFlow.m4832a(i, m4519c.f42682b, m4519c.f42683c);
        m4518d(coroutineScope, m4519c.f42684d, m4519c.f42681a, m4832a, interfaceC14948d0, SharedFlow.f42672a);
        return C15006k.m4625l(m4832a);
    }

    /* renamed from: h */
    public static /* synthetic */ InterfaceC15048x m4514h(InterfaceC14958h interfaceC14958h, CoroutineScope coroutineScope, InterfaceC14948d0 interfaceC14948d0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return C15006k.m4697Q1(interfaceC14958h, coroutineScope, interfaceC14948d0, i);
    }

    @Nullable
    /* renamed from: i */
    public static final <T> Object m4513i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14268c<? super StateFlow<? extends T>> interfaceC14268c) {
        Share m4519c = m4519c(interfaceC14958h, 1);
        InterfaceC15255y m5754c = CompletableDeferred.m5754c(null, 1, null);
        m4517e(coroutineScope, m4519c.f42684d, m4519c.f42681a, m5754c);
        return m5754c.mo3490m(interfaceC14268c);
    }

    @NotNull
    /* renamed from: j */
    public static final <T> StateFlow<T> m4512j(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope, @NotNull InterfaceC14948d0 interfaceC14948d0, T t) {
        Share m4519c = m4519c(interfaceC14958h, 1);
        InterfaceC15044t m4754a = C15005j0.m4754a(t);
        m4518d(coroutineScope, m4519c.f42684d, m4519c.f42681a, m4754a, interfaceC14948d0, t);
        return C15006k.m4621m(m4754a);
    }
}
