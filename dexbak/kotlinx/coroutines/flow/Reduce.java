package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.FlowExceptions;
import kotlinx.coroutines.flow.internal.NullSurrogate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001au\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a{\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013\u001aG\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013\u001aI\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m12616d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "", "operation", "g", "(Lkotlinx/coroutines/flow/h;Ll1/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "initial", "acc", "e", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;Ll1/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "i", "a", "Lkotlin/Function2;", "", "predicate", "b", "(Lkotlinx/coroutines/flow/h;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "d", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Reduce {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Limit.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14849a<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ Ref.ObjectRef f42477a;

        public C14849a(Ref.ObjectRef objectRef) {
            this.f42477a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            this.f42477a.element = obj;
            if (boxing.m8631a(false).booleanValue()) {
                return Unit.f41048a;
            }
            throw new FlowExceptions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "first"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0}, m8636l = {Opcodes.INVOKEVIRTUAL}, m8635m = "first", m8634n = {"$this$first", CommonNetImpl.RESULT, "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14850b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42478a;

        /* renamed from: b */
        int f42479b;

        /* renamed from: c */
        Object f42480c;

        /* renamed from: d */
        Object f42481d;

        /* renamed from: e */
        Object f42482e;

        /* renamed from: f */
        Object f42483f;

        C14850b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42478a = obj;
            this.f42479b |= Integer.MIN_VALUE;
            return C15006k.m4579y0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "continuation", "first"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0, 0}, m8636l = {197}, m8635m = "first", m8634n = {"$this$first", "predicate", CommonNetImpl.RESULT, "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14851c extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42484a;

        /* renamed from: b */
        int f42485b;

        /* renamed from: c */
        Object f42486c;

        /* renamed from: d */
        Object f42487d;

        /* renamed from: e */
        Object f42488e;

        /* renamed from: f */
        Object f42489f;

        /* renamed from: g */
        Object f42490g;

        C14851c(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42484a = obj;
            this.f42485b |= Integer.MIN_VALUE;
            return C15006k.m4576z0(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Limit.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14852d<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ Ref.ObjectRef f42491a;

        public C14852d(Ref.ObjectRef objectRef) {
            this.f42491a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            this.f42491a.element = obj;
            if (boxing.m8631a(false).booleanValue()) {
                return Unit.f41048a;
            }
            throw new FlowExceptions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "firstOrNull"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0}, m8636l = {AdEventType.VIDEO_PRELOADED}, m8635m = "firstOrNull", m8634n = {"$this$firstOrNull", CommonNetImpl.RESULT, "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14853e extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42492a;

        /* renamed from: b */
        int f42493b;

        /* renamed from: c */
        Object f42494c;

        /* renamed from: d */
        Object f42495d;

        /* renamed from: e */
        Object f42496e;

        /* renamed from: f */
        Object f42497f;

        C14853e(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42492a = obj;
            this.f42493b |= Integer.MIN_VALUE;
            return C15006k.m4746A0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "continuation", "firstOrNull"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0, 0}, m8636l = {227}, m8635m = "firstOrNull", m8634n = {"$this$firstOrNull", "predicate", CommonNetImpl.RESULT, "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14854f extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42498a;

        /* renamed from: b */
        int f42499b;

        /* renamed from: c */
        Object f42500c;

        /* renamed from: d */
        Object f42501d;

        /* renamed from: e */
        Object f42502e;

        /* renamed from: f */
        Object f42503f;

        /* renamed from: g */
        Object f42504g;

        C14854f(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42498a = obj;
            this.f42499b |= Integer.MIN_VALUE;
            return C15006k.m4743B0(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@"}, m12616d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "", "operation", "continuation", "reduce"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0}, m8636l = {148}, m8635m = "reduce", m8634n = {"$this$reduce", "operation", "accumulator", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14855g extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42505a;

        /* renamed from: b */
        int f42506b;

        /* renamed from: c */
        Object f42507c;

        /* renamed from: d */
        Object f42508d;

        /* renamed from: e */
        Object f42509e;

        /* renamed from: f */
        Object f42510f;

        C14855g(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42505a = obj;
            this.f42506b |= Integer.MIN_VALUE;
            return C15006k.m4739C1(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Collect.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14856h<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ Ref.ObjectRef f42511a;

        public C14856h(Ref.ObjectRef objectRef) {
            this.f42511a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            Ref.ObjectRef objectRef = this.f42511a;
            if (objectRef.element == NullSurrogate.f42850a) {
                objectRef.element = obj;
                return Unit.f41048a;
            }
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "single"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0}, m8636l = {Opcodes.IFNE}, m8635m = "single", m8634n = {"$this$single", CommonNetImpl.RESULT, "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14857i extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42512a;

        /* renamed from: b */
        int f42513b;

        /* renamed from: c */
        Object f42514c;

        /* renamed from: d */
        Object f42515d;

        /* renamed from: e */
        Object f42516e;

        C14857i(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42512a = obj;
            this.f42513b |= Integer.MIN_VALUE;
            return C15006k.m4691S1(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Limit.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14858j<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ Ref.ObjectRef f42517a;

        public C14858j(Ref.ObjectRef objectRef) {
            this.f42517a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            boolean z;
            Ref.ObjectRef objectRef = this.f42517a;
            T t = objectRef.element;
            T t2 = (T) NullSurrogate.f42850a;
            if (t == t2) {
                objectRef.element = obj;
                z = true;
            } else {
                objectRef.element = t2;
                z = false;
            }
            if (boxing.m8631a(z).booleanValue()) {
                return Unit.f41048a;
            }
            throw new FlowExceptions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Reduce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "continuation", "", "singleOrNull"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m8638f = "Reduce.kt", m8637i = {0, 0, 0, 0}, m8636l = {Opcodes.GOTO}, m8635m = "singleOrNull", m8634n = {"$this$singleOrNull", CommonNetImpl.RESULT, "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14859k extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42518a;

        /* renamed from: b */
        int f42519b;

        /* renamed from: c */
        Object f42520c;

        /* renamed from: d */
        Object f42521d;

        /* renamed from: e */
        Object f42522e;

        /* renamed from: f */
        Object f42523f;

        C14859k(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42518a = obj;
            this.f42519b |= Integer.MIN_VALUE;
            return C15006k.m4688T1(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4904a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.Reduce.C14850b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = (kotlinx.coroutines.flow.Reduce.C14850b) r0
            int r1 = r0.f42479b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42479b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42478a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42479b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f42483f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = (kotlinx.coroutines.flow.Reduce.C14849a) r4
            java.lang.Object r1 = r0.f42482e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.InterfaceC14958h) r1
            java.lang.Object r1 = r0.f42481d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f42480c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r5)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.C14294d0.m8596n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.f42480c = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42481d = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42482e = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42483f = r2     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42479b = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            java.lang.Object r4 = r4.mo4470e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r5, r4)
        L6e:
            T r4 = r1.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            if (r4 == r5) goto L75
            return r4
        L75:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4904a(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4903b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super T, ? super kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Reduce.C14851c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = (kotlinx.coroutines.flow.Reduce.C14851c) r0
            int r1 = r0.f42485b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42485b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42484a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42485b
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.f42490g
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f42489f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            java.lang.Object r5 = r0.f42488e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.f42487d
            l1.p r1 = (p617l1.InterfaceC15284p) r1
            java.lang.Object r0 = r0.f42486c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r6)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L3d
            goto L76
        L3d:
            r6 = move-exception
            goto L73
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            kotlin.C14294d0.m8596n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f42486c = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            r0.f42487d = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            r0.f42488e = r6     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            r0.f42489f = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            r0.f42490g = r2     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            r0.f42485b = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            java.lang.Object r4 = r4.mo4470e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6e
            if (r4 != r1) goto L6b
            return r1
        L6b:
            r1 = r5
            r5 = r6
            goto L76
        L6e:
            r4 = move-exception
            r1 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L73:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r6, r4)
        L76:
            T r4 = r5.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            if (r4 == r5) goto L7d
            return r4
        L7d:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4903b(kotlinx.coroutines.flow.h, l1.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4902c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.Reduce.C14853e
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = (kotlinx.coroutines.flow.Reduce.C14853e) r0
            int r1 = r0.f42493b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42493b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42492a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42493b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f42497f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r4 = (kotlinx.coroutines.flow.Reduce.C14852d) r4
            java.lang.Object r1 = r0.f42496e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.InterfaceC14958h) r1
            java.lang.Object r1 = r0.f42495d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f42494c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r5)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L39
            goto L6d
        L39:
            r5 = move-exception
            goto L6a
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.C14294d0.m8596n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$d
            r2.<init>(r5)
            r0.f42494c = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            r0.f42495d = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            r0.f42496e = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            r0.f42497f = r2     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            r0.f42493b = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            java.lang.Object r4 = r4.mo4470e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L66
            if (r4 != r1) goto L64
            return r1
        L64:
            r1 = r5
            goto L6d
        L66:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6a:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r5, r4)
        L6d:
            T r4 = r1.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4902c(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4901d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super T, ? super kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Reduce.C14854f
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = (kotlinx.coroutines.flow.Reduce.C14854f) r0
            int r1 = r0.f42499b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42499b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42498a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42499b
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r4 = r0.f42504g
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f42503f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            java.lang.Object r5 = r0.f42502e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r0.f42501d
            l1.p r1 = (p617l1.InterfaceC15284p) r1
            java.lang.Object r0 = r0.f42500c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r6)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L3d
            goto L73
        L3d:
            r6 = move-exception
            goto L70
        L3f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L47:
            kotlin.C14294d0.m8596n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f42500c = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            r0.f42501d = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            r0.f42502e = r6     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            r0.f42503f = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            r0.f42504g = r2     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            r0.f42499b = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            java.lang.Object r4 = r4.mo4470e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L6c
            if (r4 != r1) goto L6a
            return r1
        L6a:
            r5 = r6
            goto L73
        L6c:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L70:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r6, r4)
        L73:
            T r4 = r5.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4901d(kotlinx.coroutines.flow.h, l1.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, R> java.lang.Object m4900e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, R r5, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15285q<? super R, ? super T, ? super kotlin.coroutines.InterfaceC14268c<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super R> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.L$4
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$2
            l1.q r5 = (p617l1.InterfaceC15285q) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            kotlin.C14294d0.m8596n(r7)
            goto L64
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.C14294d0.m8596n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1
            r2.<init>(r7, r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r7
            r0.L$4 = r4
            r0.label = r3
            java.lang.Object r4 = r4.mo4470e(r2, r0)
            if (r4 != r1) goto L63
            return r1
        L63:
            r4 = r7
        L64:
            T r4 = r4.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4900e(kotlinx.coroutines.flow.h, java.lang.Object, l1.q, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* renamed from: f */
    private static final Object m4899f(@NotNull InterfaceC14958h interfaceC14958h, Object obj, @NotNull InterfaceC15285q interfaceC15285q, @NotNull InterfaceC14268c interfaceC14268c) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = obj;
        FlowKt__ReduceKt$fold$$inlined$collect$1 flowKt__ReduceKt$fold$$inlined$collect$1 = new FlowKt__ReduceKt$fold$$inlined$collect$1(objectRef, interfaceC15285q);
        InlineMarker.m8227e(0);
        interfaceC14958h.mo4470e(flowKt__ReduceKt$fold$$inlined$collect$1, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.j0] */
    @org.jetbrains.annotations.Nullable
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S, T extends S> java.lang.Object m4898g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15285q<? super S, ? super T, ? super kotlin.coroutines.InterfaceC14268c<? super S>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super S> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Reduce.C14855g
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = (kotlinx.coroutines.flow.Reduce.C14855g) r0
            int r1 = r0.f42506b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42506b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42505a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42506b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.f42510f
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.f42509e
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.f42508d
            l1.q r5 = (p617l1.InterfaceC15285q) r5
            java.lang.Object r5 = r0.f42507c
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            kotlin.C14294d0.m8596n(r6)
            goto L64
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.C14294d0.m8596n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1
            r2.<init>(r6, r5)
            r0.f42507c = r4
            r0.f42508d = r5
            r0.f42509e = r6
            r0.f42510f = r4
            r0.f42506b = r3
            java.lang.Object r4 = r4.mo4470e(r2, r0)
            if (r4 != r1) goto L63
            return r1
        L63:
            r4 = r6
        L64:
            T r4 = r4.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            if (r4 == r5) goto L6b
            return r4
        L6b:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Empty flow can't be reduced"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4898g(kotlinx.coroutines.flow.h, l1.q, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4897h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.Reduce.C14857i
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$i r0 = (kotlinx.coroutines.flow.Reduce.C14857i) r0
            int r1 = r0.f42513b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42513b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$i r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42512a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42513b
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f42516e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.f42515d
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r0 = r0.f42514c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r5)
            goto L5e
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C14294d0.m8596n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$h r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$h
            r2.<init>(r5)
            r0.f42514c = r4
            r0.f42515d = r5
            r0.f42516e = r4
            r0.f42513b = r3
            java.lang.Object r4 = r4.mo4470e(r2, r0)
            if (r4 != r1) goto L5d
            return r1
        L5d:
            r4 = r5
        L5e:
            T r4 = r4.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            if (r4 == r5) goto L65
            return r4
        L65:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4897h(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4896i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.Reduce.C14859k
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$k r0 = (kotlinx.coroutines.flow.Reduce.C14859k) r0
            int r1 = r0.f42519b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42519b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$k r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$k
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42518a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42519b
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.f42523f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r4 = (kotlinx.coroutines.flow.Reduce.C14858j) r4
            java.lang.Object r1 = r0.f42522e
            kotlinx.coroutines.flow.h r1 = (kotlinx.coroutines.flow.InterfaceC14958h) r1
            java.lang.Object r1 = r0.f42521d
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f42520c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r5)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L39
            goto L6e
        L39:
            r5 = move-exception
            goto L6b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.C14294d0.m8596n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$j
            r2.<init>(r5)
            r0.f42520c = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42521d = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42522e = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42523f = r2     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            r0.f42519b = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            java.lang.Object r4 = r4.mo4470e(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L67
            if (r4 != r1) goto L65
            return r1
        L65:
            r1 = r5
            goto L6e
        L67:
            r4 = move-exception
            r1 = r5
            r5 = r4
            r4 = r2
        L6b:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r5, r4)
        L6e:
            T r4 = r1.element
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
            if (r4 != r5) goto L75
            r4 = 0
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Reduce.m4896i(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }
}
