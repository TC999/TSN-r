package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* compiled from: Transform.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001a\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\u001ad\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\b\u001aj\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\n*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u000125\b\u0004\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\b\u001a\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001aJ\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\b\u001a\u0080\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00028\u00012H\b\u0001\u0010\u001b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ap\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012F\u0010\u001b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "a", "(Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "c", "R", "b", "d", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, "transform", "e", "f", "Lkotlin/collections/n0;", "j", "Lkotlin/f1;", CcgConstant.f38549t, "g", "initial", "Lkotlin/Function3;", "accumulator", "operation", "i", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;Ll1/q;)Lkotlinx/coroutines/flow/h;", "h", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class FlowKt__TransformKt {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14864a<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42532a;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14865a implements FlowCollector<T> {

            /* renamed from: a */
            final /* synthetic */ FlowCollector f42533a;

            /* renamed from: b */
            final /* synthetic */ C14864a f42534b;

            public C14865a(FlowCollector flowCollector, C14864a c14864a) {
                this.f42533a = flowCollector;
                this.f42534b = c14864a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                FlowCollector flowCollector = this.f42533a;
                if (obj != null) {
                    Object emit = flowCollector.emit(obj, interfaceC14268c);
                    m8642h = C14287b.m8642h();
                    return emit == m8642h ? emit : Unit.f41048a;
                }
                return Unit.f41048a;
            }
        }

        public C14864a(InterfaceC14958h interfaceC14958h) {
            this.f42532a = interfaceC14958h;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object mo4470e = this.f42532a.mo4470e(new C14865a(flowCollector, this), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return mo4470e == m8642h ? mo4470e : Unit.f41048a;
        }
    }

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14866b<T> implements InterfaceC14958h<IndexedValue<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42535a;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$7"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14867a implements FlowCollector<T> {

            /* renamed from: a */
            final /* synthetic */ FlowCollector f42536a;

            /* renamed from: b */
            final /* synthetic */ Ref.IntRef f42537b;

            public C14867a(FlowCollector flowCollector, Ref.IntRef intRef) {
                this.f42536a = flowCollector;
                this.f42537b = intRef;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                FlowCollector flowCollector = this.f42536a;
                Ref.IntRef intRef = this.f42537b;
                int i = intRef.element;
                intRef.element = i + 1;
                if (i >= 0) {
                    Object emit = flowCollector.emit(new IndexedValue(i, obj), interfaceC14268c);
                    m8642h = C14287b.m8642h();
                    return emit == m8642h ? emit : Unit.f41048a;
                }
                throw new ArithmeticException("Index overflow has happened");
            }
        }

        public C14866b(InterfaceC14958h interfaceC14958h) {
            this.f42535a = interfaceC14958h;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Object mo4470e = this.f42535a.mo4470e(new C14867a(flowCollector, intRef), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return mo4470e == m8642h ? mo4470e : Unit.f41048a;
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4894a(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(interfaceC14958h, interfaceC15284p);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    @org.jetbrains.annotations.NotNull
    /* renamed from: b */
    public static final /* synthetic */ <R> kotlinx.coroutines.flow.InterfaceC14958h<R> m4893b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<?> r1) {
        /*
            kotlin.jvm.internal.C14342f0.m8177w()
            kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt.m4893b(kotlinx.coroutines.flow.h):kotlinx.coroutines.flow.h");
    }

    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4892c(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4891d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return new C14864a(interfaceC14958h);
    }

    @NotNull
    /* renamed from: e */
    public static final <T, R> InterfaceC14958h<R> m4890e(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: f */
    public static final <T, R> InterfaceC14958h<R> m4889f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14958h<T> m4888g(@NotNull final InterfaceC14958h<? extends T> interfaceC14958h, @NotNull final InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new InterfaceC14958h<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* compiled from: Collect.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1"}, m12615k = 1, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C148862 implements FlowCollector<T> {

                /* renamed from: a */
                final /* synthetic */ FlowCollector f42563a;

                /* renamed from: b */
                final /* synthetic */ FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 f42564b;

                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1$1", "emit"}, m12615k = 3, m12614mv = {1, 4, 0})
                @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", m8638f = "Transform.kt", m8637i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA}, m8635m = "emit", m8634n = {"this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver", "this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                public static final class C148871 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public C148871(InterfaceC14268c interfaceC14268c) {
                        super(interfaceC14268c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C148862.this.emit(null, this);
                    }
                }

                public C148862(FlowCollector flowCollector, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1) {
                    this.f42563a = flowCollector;
                    this.f42564b = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a3 A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862.C148871
                        if (r0 == 0) goto L13
                        r0 = r11
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862.C148871) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L5e
                        if (r2 == r4) goto L44
                        if (r2 != r3) goto L3c
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r10 = r0.L$4
                        kotlin.coroutines.c r10 = (kotlin.coroutines.InterfaceC14268c) r10
                        java.lang.Object r10 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862.C148871) r10
                        java.lang.Object r10 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862) r10
                        kotlin.C14294d0.m8596n(r11)
                        goto La4
                    L3c:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L44:
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r2 = r0.L$5
                        java.lang.Object r4 = r0.L$4
                        kotlin.coroutines.c r4 = (kotlin.coroutines.InterfaceC14268c) r4
                        java.lang.Object r5 = r0.L$3
                        java.lang.Object r6 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862.C148871) r6
                        java.lang.Object r7 = r0.L$1
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862) r8
                        kotlin.C14294d0.m8596n(r11)
                        goto L8d
                    L5e:
                        kotlin.C14294d0.m8596n(r11)
                        kotlinx.coroutines.flow.i r11 = r9.f42563a
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r2 = r9.f42564b
                        l1.p r2 = r2
                        r0.L$0 = r9
                        r0.L$1 = r10
                        r0.L$2 = r0
                        r0.L$3 = r10
                        r0.L$4 = r0
                        r0.L$5 = r10
                        r0.L$6 = r11
                        r0.label = r4
                        r4 = 6
                        kotlin.jvm.internal.InlineMarker.m8227e(r4)
                        java.lang.Object r2 = r2.invoke(r10, r0)
                        r4 = 7
                        kotlin.jvm.internal.InlineMarker.m8227e(r4)
                        if (r2 != r1) goto L86
                        return r1
                    L86:
                        r8 = r9
                        r2 = r10
                        r5 = r2
                        r7 = r5
                        r10 = r11
                        r4 = r0
                        r6 = r4
                    L8d:
                        r0.L$0 = r8
                        r0.L$1 = r7
                        r0.L$2 = r6
                        r0.L$3 = r5
                        r0.L$4 = r4
                        r0.L$5 = r2
                        r0.L$6 = r10
                        r0.label = r3
                        java.lang.Object r10 = r10.emit(r2, r0)
                        if (r10 != r1) goto La4
                        return r1
                    La4:
                        kotlin.f1 r10 = kotlin.Unit.f41048a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.C148862.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object mo4470e = InterfaceC14958h.this.mo4470e(new C148862(flowCollector, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return mo4470e == m8642h ? mo4470e : Unit.f41048a;
            }
        };
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4887h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super T, ? super T, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15285q) {
        return new FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15285q);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: i */
    public static final <T, R> InterfaceC14958h<R> m4886i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, R r, @Inference @NotNull InterfaceC15285q<? super R, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(interfaceC14958h, r, interfaceC15285q);
    }

    @NotNull
    /* renamed from: j */
    public static final <T> InterfaceC14958h<IndexedValue<T>> m4885j(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return new C14866b(interfaceC14958h);
    }
}
