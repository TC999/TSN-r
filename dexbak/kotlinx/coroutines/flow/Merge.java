package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.C14294d0;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Arrays;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.C14987i;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.internal.C15082l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ag\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aq\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\r\u001a\u00020\f27\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0011H\u0007\u001a;\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0013\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u001at\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\t\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0019\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0018¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aj\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000b\u001ac\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000b\" \u0010%\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\"\u001a\u0010'\u001a\u00020&8\u0006X\u0087T¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "", "transform", "a", "(Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "", "concurrency", "c", "(Lkotlinx/coroutines/flow/h;ILl1/p;)Lkotlinx/coroutines/flow/h;", "e", "", "k", "", "flows", C7304t.f25048d, "([Lkotlinx/coroutines/flow/h;)Lkotlinx/coroutines/flow/h;", "f", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "m", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "b", "j", "I", "h", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Merge {

    /* renamed from: a */
    private static final int f42425a = C15082l0.m4280b(C15006k.f42867a, 16, 1, Integer.MAX_VALUE);

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14828a<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42426a;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$3"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14829a implements FlowCollector<InterfaceC14958h<? extends T>> {

            /* renamed from: a */
            final /* synthetic */ FlowCollector f42427a;

            public C14829a(FlowCollector flowCollector) {
                this.f42427a = flowCollector;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object mo4470e = ((InterfaceC14958h) obj).mo4470e(this.f42427a, interfaceC14268c);
                m8642h = C14287b.m8642h();
                return mo4470e == m8642h ? mo4470e : Unit.f41048a;
            }
        }

        public C14828a(InterfaceC14958h interfaceC14958h) {
            this.f42426a = interfaceC14958h;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object mo4470e = this.f42426a.mo4470e(new C14829a(flowCollector), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return mo4470e == m8642h ? mo4470e : Unit.f41048a;
        }
    }

    /* compiled from: Merge.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", m8638f = "Merge.kt", m8637i = {0, 0, 1, 1}, m8636l = {214, 214}, m8635m = "invokeSuspend", m8634n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, m8633s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14830b<R, T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, T, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42428a;

        /* renamed from: b */
        private Object f42429b;

        /* renamed from: c */
        Object f42430c;

        /* renamed from: d */
        Object f42431d;

        /* renamed from: e */
        Object f42432e;

        /* renamed from: f */
        int f42433f;

        /* renamed from: g */
        final /* synthetic */ InterfaceC15284p f42434g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14830b(InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
            this.f42434g = interfaceC15284p;
        }

        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C14830b c14830b = new C14830b(this.f42434g, interfaceC14268c);
            c14830b.f42428a = flowCollector;
            c14830b.f42429b = t;
            return c14830b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p617l1.InterfaceC15285q
        public final Object invoke(Object obj, Object obj2, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14830b) create((FlowCollector) obj, obj2, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            FlowCollector flowCollector;
            FlowCollector flowCollector2;
            Object obj2;
            m8642h = C14287b.m8642h();
            int i = this.f42433f;
            if (i == 0) {
                C14294d0.m8596n(obj);
                flowCollector = this.f42428a;
                Object obj3 = this.f42429b;
                InterfaceC15284p interfaceC15284p = this.f42434g;
                this.f42430c = flowCollector;
                this.f42431d = obj3;
                this.f42432e = flowCollector;
                this.f42433f = 1;
                Object invoke = interfaceC15284p.invoke(obj3, this);
                if (invoke == m8642h) {
                    return m8642h;
                }
                flowCollector2 = flowCollector;
                obj2 = obj3;
                obj = invoke;
            } else if (i != 1) {
                if (i == 2) {
                    FlowCollector flowCollector3 = (FlowCollector) this.f42430c;
                    C14294d0.m8596n(obj);
                    return Unit.f41048a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.f42432e;
                obj2 = this.f42431d;
                flowCollector2 = (FlowCollector) this.f42430c;
                C14294d0.m8596n(obj);
            }
            this.f42430c = flowCollector2;
            this.f42431d = obj2;
            this.f42433f = 2;
            if (flowCollector.emit(obj, this) == m8642h) {
                return m8642h;
            }
            return Unit.f41048a;
        }
    }

    @FlowPreview
    @NotNull
    /* renamed from: a */
    public static final <T, R> InterfaceC14958h<R> m4964a(@NotNull final InterfaceC14958h<? extends T> interfaceC14958h, @NotNull final InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return C15006k.m4716K0(new InterfaceC14958h<InterfaceC14958h<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* compiled from: Collect.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2"}, m12615k = 1, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C148312<T> implements FlowCollector<T> {

                /* renamed from: a */
                final /* synthetic */ FlowCollector f42437a;

                /* renamed from: b */
                final /* synthetic */ FlowKt__MergeKt$flatMapConcat$$inlined$map$1 f42438b;

                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1", "emit"}, m12615k = 3, m12614mv = {1, 4, 0})
                @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", m8638f = "Merge.kt", m8637i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE}, m8635m = "emit", m8634n = {"this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver", "this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                public static final class C148321 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;

                    public C148321(InterfaceC14268c interfaceC14268c) {
                        super(interfaceC14268c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C148312.this.emit(null, this);
                    }
                }

                public C148312(FlowCollector flowCollector, FlowKt__MergeKt$flatMapConcat$$inlined$map$1 flowKt__MergeKt$flatMapConcat$$inlined$map$1) {
                    this.f42437a = flowCollector;
                    this.f42438b = flowKt__MergeKt$flatMapConcat$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L63
                        if (r2 == r4) goto L45
                        if (r2 != r3) goto L3d
                        java.lang.Object r11 = r0.L$6
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321) r11
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321) r11
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312) r11
                        kotlin.C14294d0.m8596n(r12)
                        goto La5
                    L3d:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L45:
                        java.lang.Object r11 = r0.L$7
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                        java.lang.Object r2 = r0.L$6
                        kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.C148321) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312) r9
                        kotlin.C14294d0.m8596n(r12)
                        goto L8e
                    L63:
                        kotlin.C14294d0.m8596n(r12)
                        kotlinx.coroutines.flow.i r12 = r10.f42437a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1 r2 = r10.f42438b
                        l1.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L85
                        return r1
                    L85:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L8e:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto La5
                        return r1
                    La5:
                        kotlin.f1 r11 = kotlin.Unit.f41048a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.C148312.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object mo4470e = InterfaceC14958h.this.mo4470e(new C148312(flowCollector, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return mo4470e == m8642h ? mo4470e : Unit.f41048a;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: b */
    public static final <T, R> InterfaceC14958h<R> m4963b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return C15006k.m4618m2(interfaceC14958h, new FlowKt__MergeKt$flatMapLatest$1(interfaceC15284p, null));
    }

    @FlowPreview
    @NotNull
    /* renamed from: c */
    public static final <T, R> InterfaceC14958h<R> m4962c(@NotNull final InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull final InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return C15006k.m4713L0(new InterfaceC14958h<InterfaceC14958h<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* compiled from: Collect.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2"}, m12615k = 1, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C148332<T> implements FlowCollector<T> {

                /* renamed from: a */
                final /* synthetic */ FlowCollector f42441a;

                /* renamed from: b */
                final /* synthetic */ FlowKt__MergeKt$flatMapMerge$$inlined$map$1 f42442b;

                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1", "emit"}, m12615k = 3, m12614mv = {1, 4, 0})
                @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", m8638f = "Merge.kt", m8637i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE}, m8635m = "emit", m8634n = {"this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver", "this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                public static final class C148341 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;

                    public C148341(InterfaceC14268c interfaceC14268c) {
                        super(interfaceC14268c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C148332.this.emit(null, this);
                    }
                }

                public C148332(FlowCollector flowCollector, FlowKt__MergeKt$flatMapMerge$$inlined$map$1 flowKt__MergeKt$flatMapMerge$$inlined$map$1) {
                    this.f42441a = flowCollector;
                    this.f42442b = flowKt__MergeKt$flatMapMerge$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341
                        if (r0 == 0) goto L13
                        r0 = r12
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L63
                        if (r2 == r4) goto L45
                        if (r2 != r3) goto L3d
                        java.lang.Object r11 = r0.L$6
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                        java.lang.Object r11 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341) r11
                        java.lang.Object r11 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341) r11
                        java.lang.Object r11 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332) r11
                        kotlin.C14294d0.m8596n(r12)
                        goto La5
                    L3d:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L45:
                        java.lang.Object r11 = r0.L$7
                        kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                        java.lang.Object r2 = r0.L$6
                        kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                        java.lang.Object r4 = r0.L$5
                        java.lang.Object r5 = r0.L$4
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r5 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341) r5
                        java.lang.Object r6 = r0.L$3
                        java.lang.Object r7 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.C148341) r7
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332) r9
                        kotlin.C14294d0.m8596n(r12)
                        goto L8e
                    L63:
                        kotlin.C14294d0.m8596n(r12)
                        kotlinx.coroutines.flow.i r12 = r10.f42441a
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1 r2 = r10.f42442b
                        l1.p r2 = r2
                        r0.L$0 = r10
                        r0.L$1 = r11
                        r0.L$2 = r0
                        r0.L$3 = r11
                        r0.L$4 = r0
                        r0.L$5 = r11
                        r0.L$6 = r12
                        r0.L$7 = r12
                        r0.label = r4
                        java.lang.Object r2 = r2.invoke(r11, r0)
                        if (r2 != r1) goto L85
                        return r1
                    L85:
                        r9 = r10
                        r4 = r11
                        r6 = r4
                        r8 = r6
                        r11 = r12
                        r5 = r0
                        r7 = r5
                        r12 = r2
                        r2 = r11
                    L8e:
                        r0.L$0 = r9
                        r0.L$1 = r8
                        r0.L$2 = r7
                        r0.L$3 = r6
                        r0.L$4 = r5
                        r0.L$5 = r4
                        r0.L$6 = r2
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto La5
                        return r1
                    La5:
                        kotlin.f1 r11 = kotlin.Unit.f41048a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.C148332.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object mo4470e = InterfaceC14958h.this.mo4470e(new C148332(flowCollector, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return mo4470e == m8642h ? mo4470e : Unit.f41048a;
            }
        }, i);
    }

    /* renamed from: d */
    public static /* synthetic */ InterfaceC14958h m4961d(InterfaceC14958h interfaceC14958h, int i, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = f42425a;
        }
        return C15006k.m4725H0(interfaceC14958h, i, interfaceC15284p);
    }

    @FlowPreview
    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14958h<T> m4960e(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        return new C14828a(interfaceC14958h);
    }

    @FlowPreview
    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m4959f(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h, int i) {
        if (i > 0) {
            return i == 1 ? C15006k.m4716K0(interfaceC14958h) : new ChannelFlowMerge(interfaceC14958h, i, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
    }

    /* renamed from: g */
    public static /* synthetic */ InterfaceC14958h m4958g(InterfaceC14958h interfaceC14958h, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = f42425a;
        }
        return C15006k.m4713L0(interfaceC14958h, i);
    }

    /* renamed from: h */
    public static final int m4957h() {
        return f42425a;
    }

    @FlowPreview
    /* renamed from: i */
    public static /* synthetic */ void m4956i() {
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: j */
    public static final <T, R> InterfaceC14958h<R> m4955j(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return C15006k.m4618m2(interfaceC14958h, new C14830b(interfaceC15284p, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: k */
    public static final <T> InterfaceC14958h<T> m4954k(@NotNull Iterable<? extends InterfaceC14958h<? extends T>> iterable) {
        return new C14987i(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: l */
    public static final <T> InterfaceC14958h<T> m4953l(@NotNull InterfaceC14958h<? extends T>... interfaceC14958hArr) {
        Iterable m10700Y4;
        m10700Y4 = _Arrays.m10700Y4(interfaceC14958hArr);
        return C15006k.m4643g1(m10700Y4);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: m */
    public static final <T, R> InterfaceC14958h<R> m4952m(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return new ChannelFlowTransformLatest(interfaceC15285q, interfaceC14958h, null, 0, null, 28, null);
    }
}
