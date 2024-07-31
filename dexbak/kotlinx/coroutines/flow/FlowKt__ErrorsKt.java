package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.C2640by;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.ccg.CcgConstant;
import kotlin.Annotations;
import kotlin.C14294d0;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;

/* compiled from: Errors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012B\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aB\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001ae\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u001423\b\u0002\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00192\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001a\u007f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012W\u0010\u0012\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a3\u0010 \u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001b\u0010$\u001a\u00020\u0011*\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u0011*\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(*\\\b\u0007\u00104\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010B6\b)\u0012\n\b*\u0012\u0006\b\n0+8,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001c\b/\u0012\u0018\b\u000bB\u0014\b0\u0012\u0006\b1\u0012\u0002\b\f\u0012\b\b2\u0012\u0004\b\b(3\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "b", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "fallback", "Lkotlin/Function1;", "", "predicate", "f", "", "retries", "Lkotlin/Function2;", "i", "(Lkotlinx/coroutines/flow/h;JLl1/p;)Lkotlinx/coroutines/flow/h;", "", "h", "Lkotlin/Function4;", "attempt", C7304t.f25048d, "(Lkotlinx/coroutines/flow/h;Ll1/r;)Lkotlinx/coroutines/flow/h;", "collector", "c", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "coroutineContext", "d", "(Ljava/lang/Throwable;Lkotlin/coroutines/f;)Z", AdnName.OTHER, "e", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "Lkotlin/Deprecated;", "level", "Lkotlin/DeprecationLevel;", C2640by.f8774l, "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "(Throwable) -> Boolean", "ExceptionPredicate", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0080@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "", "continuation", "", "catchImpl"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", m8638f = "Errors.kt", m8637i = {0, 0, 0, 0}, m8636l = {230}, m8635m = "catchImpl", m8634n = {"$this$catchImpl", "collector", "fromDownstream", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14808a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42352a;

        /* renamed from: b */
        int f42353b;

        /* renamed from: c */
        Object f42354c;

        /* renamed from: d */
        Object f42355d;

        /* renamed from: e */
        Object f42356e;

        /* renamed from: f */
        Object f42357f;

        C14808a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42352a = obj;
            this.f42353b |= Integer.MIN_VALUE;
            return C15006k.m4583x(null, null, this);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Throwable;)Z"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14809b extends Lambda implements InterfaceC15280l<Throwable, Boolean> {

        /* renamed from: a */
        public static final C14809b f42358a = new C14809b();

        C14809b() {
            super(1);
        }

        /* renamed from: a */
        public final boolean m4978a(@NotNull Throwable th) {
            return true;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(m4978a(th));
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "", "e", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", m8638f = "Errors.kt", m8637i = {0, 0, 0, 0}, m8636l = {227}, m8635m = "invokeSuspend", m8634n = {"$this$catch", "e", "$this$emitAll$iv", "flow$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14810c<T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super T>, Throwable, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42359a;

        /* renamed from: b */
        private Throwable f42360b;

        /* renamed from: c */
        Object f42361c;

        /* renamed from: d */
        Object f42362d;

        /* renamed from: e */
        Object f42363e;

        /* renamed from: f */
        Object f42364f;

        /* renamed from: g */
        int f42365g;

        /* renamed from: h */
        final /* synthetic */ InterfaceC15280l f42366h;

        /* renamed from: i */
        final /* synthetic */ InterfaceC14958h f42367i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14810c(InterfaceC15280l interfaceC15280l, InterfaceC14958h interfaceC14958h, InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
            this.f42366h = interfaceC15280l;
            this.f42367i = interfaceC14958h;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4977d(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C14810c c14810c = new C14810c(this.f42366h, this.f42367i, interfaceC14268c);
            c14810c.f42359a = flowCollector;
            c14810c.f42360b = th;
            return c14810c;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(Object obj, Throwable th, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14810c) m4977d((FlowCollector) obj, th, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42365g;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector<? super T> flowCollector = this.f42359a;
                Throwable th = this.f42360b;
                if (((Boolean) this.f42366h.invoke(th)).booleanValue()) {
                    InterfaceC14958h interfaceC14958h = this.f42367i;
                    this.f42361c = flowCollector;
                    this.f42362d = th;
                    this.f42363e = flowCollector;
                    this.f42364f = interfaceC14958h;
                    this.f42365g = 1;
                    if (interfaceC14958h.mo4470e(flowCollector, this) == m8642h) {
                        return m8642h;
                    }
                } else {
                    throw th;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42364f;
                FlowCollector flowCollector2 = (FlowCollector) this.f42363e;
                Throwable th2 = (Throwable) this.f42362d;
                FlowCollector flowCollector3 = (FlowCollector) this.f42361c;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", m8638f = "Errors.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14811d extends SuspendLambda implements InterfaceC15284p<Throwable, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        private Throwable f42368a;

        /* renamed from: b */
        int f42369b;

        C14811d(InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14811d c14811d = new C14811d(interfaceC14268c);
            c14811d.f42368a = (Throwable) obj;
            return c14811d;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Throwable th, InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C14811d) create(th, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f42369b == 0) {
                C14294d0.m8596n(obj);
                return boxing.m8631a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", m8638f = "Errors.kt", m8637i = {0, 0, 0}, m8636l = {124}, m8635m = "invokeSuspend", m8634n = {"$this$retryWhen", "cause", "attempt"}, m8633s = {"L$0", "L$1", "J$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14812e<T> extends SuspendLambda implements InterfaceC15286r<FlowCollector<? super T>, Throwable, Long, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        private FlowCollector f42370a;

        /* renamed from: b */
        private Throwable f42371b;

        /* renamed from: c */
        private long f42372c;

        /* renamed from: d */
        Object f42373d;

        /* renamed from: e */
        Object f42374e;

        /* renamed from: f */
        long f42375f;

        /* renamed from: g */
        int f42376g;

        /* renamed from: h */
        final /* synthetic */ long f42377h;

        /* renamed from: i */
        final /* synthetic */ InterfaceC15284p f42378i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14812e(long j, InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
            super(4, interfaceC14268c);
            this.f42377h = j;
            this.f42378i = interfaceC15284p;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4976d(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j, @NotNull InterfaceC14268c<? super Boolean> interfaceC14268c) {
            C14812e c14812e = new C14812e(this.f42377h, this.f42378i, interfaceC14268c);
            c14812e.f42370a = flowCollector;
            c14812e.f42371b = th;
            c14812e.f42372c = j;
            return c14812e;
        }

        @Override // p617l1.InterfaceC15286r
        public final Object invoke(Object obj, Throwable th, Long l, InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C14812e) m4976d((FlowCollector) obj, th, l.longValue(), interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0045, code lost:
            if (((java.lang.Boolean) r9).booleanValue() != false) goto L8;
         */
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
                int r1 = r8.f42376g
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.f42374e
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                java.lang.Object r0 = r8.f42373d
                kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                kotlin.C14294d0.m8596n(r9)
                goto L3f
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                kotlin.C14294d0.m8596n(r9)
                kotlinx.coroutines.flow.i r9 = r8.f42370a
                java.lang.Throwable r1 = r8.f42371b
                long r3 = r8.f42372c
                long r5 = r8.f42377h
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L48
                l1.p r5 = r8.f42378i
                r8.f42373d = r9
                r8.f42374e = r1
                r8.f42375f = r3
                r8.f42376g = r2
                java.lang.Object r9 = r5.invoke(r1, r8)
                if (r9 != r0) goto L3f
                return r0
            L3f:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L48
                goto L49
            L48:
                r2 = 0
            L49:
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.m8631a(r2)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.C14812e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Throwable;)Z"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14813f extends Lambda implements InterfaceC15280l<Throwable, Boolean> {

        /* renamed from: a */
        public static final C14813f f42379a = new C14813f();

        C14813f() {
            super(1);
        }

        /* renamed from: a */
        public final boolean m4975a(@NotNull Throwable th) {
            return true;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(m4975a(th));
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", m8638f = "Errors.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14814g<T> extends SuspendLambda implements InterfaceC15286r<FlowCollector<? super T>, Throwable, Long, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        private FlowCollector f42380a;

        /* renamed from: b */
        private Throwable f42381b;

        /* renamed from: c */
        private long f42382c;

        /* renamed from: d */
        int f42383d;

        /* renamed from: e */
        final /* synthetic */ int f42384e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15280l f42385f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14814g(int i, InterfaceC15280l interfaceC15280l, InterfaceC14268c interfaceC14268c) {
            super(4, interfaceC14268c);
            this.f42384e = i;
            this.f42385f = interfaceC15280l;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4974d(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j, @NotNull InterfaceC14268c<? super Boolean> interfaceC14268c) {
            C14814g c14814g = new C14814g(this.f42384e, this.f42385f, interfaceC14268c);
            c14814g.f42380a = flowCollector;
            c14814g.f42381b = th;
            c14814g.f42382c = j;
            return c14814g;
        }

        @Override // p617l1.InterfaceC15286r
        public final Object invoke(Object obj, Throwable th, Long l, InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C14814g) m4974d((FlowCollector) obj, th, l.longValue(), interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f42383d == 0) {
                C14294d0.m8596n(obj);
                return boxing.m8631a(((Boolean) this.f42385f.invoke(this.f42381b)).booleanValue() && this.f42382c < ((long) this.f42384e));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use (Throwable) -> Boolean functional type", replaceWith = @ReplaceWith(expression = "(Throwable) -> Boolean", imports = {}))
    /* renamed from: a */
    public static /* synthetic */ void m4990a() {
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4989b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super FlowCollector<? super T>, ? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15285q);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0044  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4988c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r5, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.Throwable> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.C14808a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.C14808a) r0
            int r1 = r0.f42353b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42353b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f42352a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42353b
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.f42357f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            java.lang.Object r5 = r0.f42356e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.f42355d
            kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r6 = r0.f42354c
            kotlinx.coroutines.flow.h r6 = (kotlinx.coroutines.flow.InterfaceC14958h) r6
            kotlin.C14294d0.m8596n(r7)     // Catch: java.lang.Throwable -> L3a
            goto L64
        L3a:
            r6 = move-exception
            goto L67
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C14294d0.m8596n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r3
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1     // Catch: java.lang.Throwable -> L65
            r2.<init>(r6, r7)     // Catch: java.lang.Throwable -> L65
            r0.f42354c = r5     // Catch: java.lang.Throwable -> L65
            r0.f42355d = r6     // Catch: java.lang.Throwable -> L65
            r0.f42356e = r7     // Catch: java.lang.Throwable -> L65
            r0.f42357f = r5     // Catch: java.lang.Throwable -> L65
            r0.f42353b = r4     // Catch: java.lang.Throwable -> L65
            java.lang.Object r5 = r5.mo4470e(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r5 != r1) goto L64
            return r1
        L64:
            return r3
        L65:
            r6 = move-exception
            r5 = r7
        L67:
            T r5 = r5.element
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            boolean r5 = m4986e(r6, r5)
            if (r5 != 0) goto L7c
            kotlin.coroutines.f r5 = r0.getContext()
            boolean r5 = m4987d(r6, r5)
            if (r5 != 0) goto L7c
            return r6
        L7c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.m4988c(kotlinx.coroutines.flow.h, kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: d */
    private static final boolean m4987d(Throwable th, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return m4986e(th, job.mo3825l());
    }

    /* renamed from: e */
    private static final boolean m4986e(Throwable th, Throwable th2) {
        return th2 != null && C14342f0.m8193g(th2, th);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m4985f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        return C15006k.m4586w(interfaceC14958h, new C14810c(interfaceC15280l, interfaceC14958h2, null));
    }

    /* renamed from: g */
    public static /* synthetic */ InterfaceC14958h m4984g(InterfaceC14958h interfaceC14958h, InterfaceC14958h interfaceC14958h2, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC15280l = C14809b.f42358a;
        }
        return C15006k.m4611o1(interfaceC14958h, interfaceC14958h2, interfaceC15280l);
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    @FlowPreview
    @NotNull
    /* renamed from: h */
    public static final /* synthetic */ <T> InterfaceC14958h<T> m4983h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        if (i > 0) {
            return C15006k.m4718J1(interfaceC14958h, new C14814g(i, interfaceC15280l, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + i).toString());
    }

    @NotNull
    /* renamed from: i */
    public static final <T> InterfaceC14958h<T> m4982i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j, @NotNull InterfaceC15284p<? super Throwable, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        if (j > 0) {
            return C15006k.m4718J1(interfaceC14958h, new C14812e(j, interfaceC15284p, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
    }

    /* renamed from: j */
    public static /* synthetic */ InterfaceC14958h m4981j(InterfaceC14958h interfaceC14958h, int i, InterfaceC15280l interfaceC15280l, int i2, Object obj) {
        InterfaceC14958h m4983h;
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            interfaceC15280l = C14813f.f42379a;
        }
        m4983h = m4983h(interfaceC14958h, i, interfaceC15280l);
        return m4983h;
    }

    /* renamed from: k */
    public static /* synthetic */ InterfaceC14958h m4980k(InterfaceC14958h interfaceC14958h, long j, InterfaceC15284p interfaceC15284p, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            interfaceC15284p = new C14811d(null);
        }
        return C15006k.m4727G1(interfaceC14958h, j, interfaceC15284p);
    }

    @NotNull
    /* renamed from: l */
    public static final <T> InterfaceC14958h<T> m4979l(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15286r<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15286r) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15286r);
    }
}
