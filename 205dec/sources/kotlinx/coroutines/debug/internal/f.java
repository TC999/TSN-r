package kotlinx.coroutines.debug.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.p;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.l0;
import kotlin.m;
import kotlin.ranges.q;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.w;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.l2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugProbesImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u000f\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u0090\u0001B\n\b\u0002\u00a2\u0006\u0005\b\u008f\u0001\u0010\bJ\u001d\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\bJ;\u0010\u0013\u001a\u00020\u0004*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J>\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\u0015*\u00020\u00012\u001c\u0010\u0019\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0016H\u0082\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0017H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002\u00a2\u0006\u0004\b%\u0010&J5\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010'\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002\u00a2\u0006\u0004\b+\u0010,J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003012\u0006\u0010.\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002\u00a2\u0006\u0004\b2\u00103J3\u00105\u001a\u00020-2\u0006\u00104\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002\u00a2\u0006\u0004\b5\u00106J#\u0010\u0015\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0015\u00109J\u001f\u0010;\u001a\u00020\u00042\u0006\u00108\u001a\u00020:2\u0006\u0010'\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b;\u0010<J\u0016\u0010=\u001a\u0004\u0018\u00010:*\u00020:H\u0082\u0010\u00a2\u0006\u0004\b=\u0010>J/\u0010@\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u00172\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b@\u0010AJ\u001d\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u000307H\u0002\u00a2\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020:H\u0082\u0010\u00a2\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\u0004\u0018\u00010F*\b\u0012\u0004\u0012\u00020#0\u001aH\u0002\u00a2\u0006\u0004\bG\u0010HJ3\u0010K\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u0000072\b\u00108\u001a\u0004\u0018\u00010FH\u0002\u00a2\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002\u00a2\u0006\u0004\bM\u0010NJ'\u0010Q\u001a\b\u0012\u0004\u0012\u00020#0\u001a\"\b\b\u0000\u0010I*\u00020O2\u0006\u0010P\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\u0004\u00a2\u0006\u0004\bS\u0010\bJ\r\u0010T\u001a\u00020\u0004\u00a2\u0006\u0004\bT\u0010\bJ\u0015\u0010V\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n\u00a2\u0006\u0004\bV\u0010WJ\u0013\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u001a\u00a2\u0006\u0004\bY\u0010ZJ\u0013\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0\u001a\u00a2\u0006\u0004\b\\\u0010ZJ\u0015\u0010]\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b]\u0010\"J)\u0010_\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010^\u001a\u00020X2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001a\u00a2\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000\u00a2\u0006\u0004\ba\u0010bJ\u001b\u0010c\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000\u00a2\u0006\u0004\bc\u0010bJ)\u0010d\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0000\u00a2\u0006\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR$\u0010s\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00030p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010=R\u0014\u0010w\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010vR\"\u0010}\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R#\u0010\u0080\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010x\u001a\u0004\b~\u0010z\"\u0004\b\u007f\u0010|R!\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\f0p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010rR\"\u0010\u0085\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0082\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\"\u0010\u0089\u0001\u001a\u00020\u0011*\u00020\n8BX\u0082\u0004\u00a2\u0006\u000f\u0012\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0005\b\u0086\u0001\u0010WR\u001b\u0010\u008c\u0001\u001a\u00020\u0003*\u00020#8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010\u008e\u0001\u001a\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010z\u00a8\u0006\u0091\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/f;", "", "Lkotlin/Function1;", "", "Lkotlin/f1;", "t", "()Ld2/l;", "M", "()V", "N", "Lkotlinx/coroutines/e2;", "", "Lkotlinx/coroutines/debug/internal/d;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "indent", "f", "(Lkotlinx/coroutines/e2;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/f$e;", "Lkotlin/coroutines/f;", "create", "", "j", "(Ld2/p;)Ljava/util/List;", "y", "(Lkotlinx/coroutines/debug/internal/f$e;)Z", "Ljava/io/PrintStream;", "out", "k", "(Ljava/io/PrintStream;)V", "Ljava/lang/StackTraceElement;", "frames", "D", "(Ljava/io/PrintStream;Ljava/util/List;)V", "state", "Ljava/lang/Thread;", "thread", "coroutineTrace", "n", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "o", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "p", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/coroutines/c;", "frame", "(Lkotlin/coroutines/c;Ljava/lang/String;)V", "Lkotlin/coroutines/jvm/internal/c;", "Q", "(Lkotlin/coroutines/jvm/internal/c;Ljava/lang/String;)V", "I", "(Lkotlin/coroutines/jvm/internal/c;)Lkotlin/coroutines/jvm/internal/c;", "owner", "S", "(Lkotlinx/coroutines/debug/internal/f$e;Lkotlin/coroutines/c;Ljava/lang/String;)V", "B", "(Lkotlin/coroutines/c;)Lkotlinx/coroutines/debug/internal/f$e;", "C", "(Lkotlin/coroutines/jvm/internal/c;)Lkotlinx/coroutines/debug/internal/f$e;", "Lkotlinx/coroutines/debug/internal/j;", "O", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/j;", "T", "completion", "g", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/debug/internal/j;)Lkotlin/coroutines/c;", "E", "(Lkotlinx/coroutines/debug/internal/f$e;)V", "", "throwable", "J", "(Ljava/lang/Throwable;)Ljava/util/List;", "x", "P", "job", "w", "(Lkotlinx/coroutines/e2;)Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/c;", "i", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "l", "h", "info", "m", "(Lkotlinx/coroutines/debug/internal/c;Ljava/util/List;)Ljava/util/List;", "G", "(Lkotlin/coroutines/c;)V", "H", "F", "(Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "a", "Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "dateFormat", "c", "Ljava/lang/Thread;", "weakRefCleanerThread", "Lkotlinx/coroutines/debug/internal/a;", "d", "Lkotlinx/coroutines/debug/internal/a;", "capturedCoroutinesMap", "installations", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Z", "v", "()Z", "L", "(Z)V", "sanitizeStackTraces", "u", "K", "enableCreationStackTraces", "callerInfoCache", "", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Set;", "capturedCoroutines", "r", "getDebugString$annotations", "(Lkotlinx/coroutines/e2;)V", "debugString", "A", "(Ljava/lang/StackTraceElement;)Z", "isInternalMethod", "z", "isInstalled", "<init>", "e", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f59602a = "Coroutine creation stacktrace";

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f59603b;

    /* renamed from: c  reason: collision with root package name */
    private static Thread f59604c;

    /* renamed from: d  reason: collision with root package name */
    private static final kotlinx.coroutines.debug.internal.a<e<?>, Boolean> f59605d;

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ kotlinx.coroutines.debug.internal.g f59606e;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f59607f;

    /* renamed from: g  reason: collision with root package name */
    private static final ReentrantReadWriteLock f59608g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f59609h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f59610i;
    private static volatile int installations;

    /* renamed from: j  reason: collision with root package name */
    private static final l<Boolean, f1> f59611j;

    /* renamed from: k  reason: collision with root package name */
    private static final kotlinx.coroutines.debug.internal.a<kotlin.coroutines.jvm.internal.c, kotlinx.coroutines.debug.internal.d> f59612k;

    /* renamed from: l  reason: collision with root package name */
    public static final f f59613l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            g4 = kotlin.comparisons.b.g(Long.valueOf(((e) t3).f59615b.f59586f), Long.valueOf(((e) t4).f59615b.f59586f));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            g4 = kotlin.comparisons.b.g(Long.valueOf(((e) t3).f59615b.f59586f), Long.valueOf(((e) t4).f59615b.f59586f));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            g4 = kotlin.comparisons.b.g(Long.valueOf(((e) t3).f59615b.f59586f), Long.valueOf(((e) t4).f59615b.f59586f));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            g4 = kotlin.comparisons.b.g(Long.valueOf(((e) t3).f59615b.f59586f), Long.valueOf(((e) t4).f59615b.f59586f));
            return g4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B'\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/f$e;", "T", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "a", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/debug/internal/d;", "b", "Lkotlinx/coroutines/debug/internal/d;", "info", "c", "Lkotlin/coroutines/jvm/internal/c;", "frame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/debug/internal/d;Lkotlin/coroutines/jvm/internal/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> implements kotlin.coroutines.c<T>, kotlin.coroutines.jvm.internal.c {
        @JvmField
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final kotlin.coroutines.c<T> f59614a;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final kotlinx.coroutines.debug.internal.d f59615b;

        /* renamed from: c  reason: collision with root package name */
        private final kotlin.coroutines.jvm.internal.c f59616c;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull kotlin.coroutines.c<? super T> cVar, @NotNull kotlinx.coroutines.debug.internal.d dVar, @Nullable kotlin.coroutines.jvm.internal.c cVar2) {
            this.f59614a = cVar;
            this.f59615b = dVar;
            this.f59616c = cVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public kotlin.coroutines.jvm.internal.c getCallerFrame() {
            kotlin.coroutines.jvm.internal.c cVar = this.f59616c;
            if (cVar != null) {
                return cVar.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.c
        @NotNull
        public kotlin.coroutines.f getContext() {
            return this.f59614a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public StackTraceElement getStackTraceElement() {
            kotlin.coroutines.jvm.internal.c cVar = this.f59616c;
            if (cVar != null) {
                return cVar.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(@NotNull Object obj) {
            f.f59613l.E(this);
            this.f59614a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.f59614a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/f$e;", "it", "", "a", "(Lkotlinx/coroutines/debug/internal/f$e;)Z"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1204f extends Lambda implements l<e<?>, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1204f f59617a = new C1204f();

        C1204f() {
            super(1);
        }

        public final boolean a(@NotNull e<?> eVar) {
            return !f.f59613l.y(eVar);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ Boolean invoke(e<?> eVar) {
            return Boolean.valueOf(a(eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends Lambda implements d2.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f59618a = new g();

        g() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            f.a(f.f59613l).l();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.g] */
    static {
        f fVar = new f();
        f59613l = fVar;
        f59603b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f59605d = new kotlinx.coroutines.debug.internal.a<>(false, 1, null);
        f59606e = new Object(0L) { // from class: kotlinx.coroutines.debug.internal.g
            volatile long sequenceNumber;

            {
                this.sequenceNumber = r1;
            }
        };
        f59608g = new ReentrantReadWriteLock();
        f59609h = true;
        f59610i = true;
        f59611j = fVar.t();
        f59612k = new kotlinx.coroutines.debug.internal.a<>(true);
        f59607f = AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.g.class, "sequenceNumber");
    }

    private f() {
    }

    private final boolean A(StackTraceElement stackTraceElement) {
        boolean u22;
        u22 = w.u2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
        return u22;
    }

    private final e<?> B(kotlin.coroutines.c<?> cVar) {
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        kotlin.coroutines.jvm.internal.c cVar2 = (kotlin.coroutines.jvm.internal.c) cVar;
        if (cVar2 != null) {
            return C(cVar2);
        }
        return null;
    }

    private final e<?> C(kotlin.coroutines.jvm.internal.c cVar) {
        while (!(cVar instanceof e)) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        }
        return (e) cVar;
    }

    private final void D(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(e<?> eVar) {
        kotlin.coroutines.jvm.internal.c I;
        f59605d.remove(eVar);
        kotlin.coroutines.jvm.internal.c d4 = eVar.f59615b.d();
        if (d4 == null || (I = I(d4)) == null) {
            return;
        }
        f59612k.remove(I);
    }

    private final kotlin.coroutines.jvm.internal.c I(kotlin.coroutines.jvm.internal.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }

    private final <T extends Throwable> List<StackTraceElement> J(T t3) {
        StackTraceElement[] stackTrace = t3.getStackTrace();
        int length = stackTrace.length;
        int i4 = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            } else if (f0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i4 = length2;
                break;
            } else {
                length2--;
            }
        }
        int i5 = 0;
        if (!f59609h) {
            int i6 = length - i4;
            ArrayList arrayList = new ArrayList(i6);
            while (i5 < i6) {
                arrayList.add(i5 == 0 ? i0.d("Coroutine creation stacktrace") : stackTrace[i5 + i4]);
                i5++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i4) + 1);
        arrayList2.add(i0.d("Coroutine creation stacktrace"));
        int i7 = length - 1;
        boolean z3 = true;
        for (int i8 = i4 + 1; i8 < i7; i8++) {
            StackTraceElement stackTraceElement = stackTrace[i8];
            if (A(stackTraceElement)) {
                if (z3) {
                    arrayList2.add(stackTraceElement);
                    z3 = false;
                } else if (!A(stackTrace[i8 + 1])) {
                    arrayList2.add(stackTraceElement);
                }
            } else {
                arrayList2.add(stackTraceElement);
            }
            z3 = true;
        }
        arrayList2.add(stackTrace[i7]);
        return arrayList2;
    }

    private final void M() {
        Thread b4;
        b4 = kotlin.concurrent.b.b((r12 & 1) != 0, (r12 & 2) != 0 ? false : true, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : "Coroutines Debugger Cleaner", (r12 & 16) != 0 ? -1 : 0, g.f59618a);
        f59604c = b4;
    }

    private final void N() {
        Thread thread = f59604c;
        if (thread != null) {
            thread.interrupt();
        }
        f59604c = null;
    }

    private final j O(List<StackTraceElement> list) {
        j jVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                jVar = new j(jVar, listIterator.previous());
            }
        }
        return jVar;
    }

    private final void Q(kotlin.coroutines.jvm.internal.c cVar, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f59608g.readLock();
        readLock.lock();
        try {
            f fVar = f59613l;
            if (fVar.z()) {
                kotlinx.coroutines.debug.internal.a<kotlin.coroutines.jvm.internal.c, kotlinx.coroutines.debug.internal.d> aVar = f59612k;
                kotlinx.coroutines.debug.internal.d remove = aVar.remove(cVar);
                if (remove == null) {
                    e<?> C = fVar.C(cVar);
                    if (C == null || (remove = C.f59615b) == null) {
                        return;
                    }
                    kotlin.coroutines.jvm.internal.c d4 = remove.d();
                    kotlin.coroutines.jvm.internal.c I = d4 != null ? fVar.I(d4) : null;
                    if (I != null) {
                        aVar.remove(I);
                    }
                }
                if (cVar != null) {
                    remove.h(str, (kotlin.coroutines.c) cVar);
                    kotlin.coroutines.jvm.internal.c I2 = fVar.I(cVar);
                    if (I2 != null) {
                        aVar.put(I2, remove);
                        f1 f1Var = f1.f55527a;
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            }
        } finally {
            readLock.unlock();
        }
    }

    private final void R(kotlin.coroutines.c<?> cVar, String str) {
        if (z()) {
            if (f0.g(str, "RUNNING") && m.f55726g.g(1, 3, 30)) {
                if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                    cVar = null;
                }
                kotlin.coroutines.jvm.internal.c cVar2 = (kotlin.coroutines.jvm.internal.c) cVar;
                if (cVar2 != null) {
                    Q(cVar2, str);
                    return;
                }
                return;
            }
            e<?> B = B(cVar);
            if (B != null) {
                S(B, cVar, str);
            }
        }
    }

    private final void S(e<?> eVar, kotlin.coroutines.c<?> cVar, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f59608g.readLock();
        readLock.lock();
        try {
            if (f59613l.z()) {
                eVar.f59615b.h(str, cVar);
                f1 f1Var = f1.f55527a;
            }
        } finally {
            readLock.unlock();
        }
    }

    public static final /* synthetic */ kotlinx.coroutines.debug.internal.a a(f fVar) {
        return f59612k;
    }

    public static final /* synthetic */ ReentrantReadWriteLock c(f fVar) {
        return f59608g;
    }

    private final void f(e2 e2Var, Map<e2, kotlinx.coroutines.debug.internal.d> map, StringBuilder sb, String str) {
        Object r22;
        kotlinx.coroutines.debug.internal.d dVar = map.get(e2Var);
        if (dVar == null) {
            if (!(e2Var instanceof kotlinx.coroutines.internal.f0)) {
                sb.append(str + r(e2Var) + '\n');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("\t");
                str = sb2.toString();
            }
        } else {
            r22 = kotlin.collections.f0.r2(dVar.f());
            String e4 = dVar.e();
            sb.append(str + r(e2Var) + ", continuation is " + e4 + " at line " + ((StackTraceElement) r22) + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("\t");
            str = sb3.toString();
        }
        for (e2 e2Var2 : e2Var.h()) {
            f(e2Var2, map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> kotlin.coroutines.c<T> g(kotlin.coroutines.c<? super T> cVar, j jVar) {
        if (z()) {
            e<?> eVar = new e<>(cVar, new kotlinx.coroutines.debug.internal.d(cVar.getContext(), jVar, f59607f.incrementAndGet(f59606e)), jVar);
            kotlinx.coroutines.debug.internal.a<e<?>, Boolean> aVar = f59605d;
            aVar.put(eVar, Boolean.TRUE);
            if (!z()) {
                aVar.clear();
            }
            return eVar;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        r6.add(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <R> java.util.List<R> j(d2.p<? super kotlinx.coroutines.debug.internal.f.e<?>, ? super kotlin.coroutines.f, ? extends R> r11) {
        /*
            r10 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r10)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.f r5 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L8a
            boolean r6 = r5.z()     // Catch: java.lang.Throwable -> L8a
            if (r6 == 0) goto L7e
            java.util.Set r5 = b(r5)     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f$a r6 = new kotlinx.coroutines.debug.internal.f$a     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.List r5 = kotlin.collections.w.f5(r5, r6)     // Catch: java.lang.Throwable -> L8a
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L8a
        L44:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L8a
            if (r7 == 0) goto L6c
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f$e r7 = (kotlinx.coroutines.debug.internal.f.e) r7     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f r8 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L8a
            boolean r8 = d(r8, r7)     // Catch: java.lang.Throwable -> L8a
            r9 = 0
            if (r8 == 0) goto L5a
            goto L66
        L5a:
            kotlinx.coroutines.debug.internal.d r8 = r7.f59615b     // Catch: java.lang.Throwable -> L8a
            kotlin.coroutines.f r8 = r8.getContext()     // Catch: java.lang.Throwable -> L8a
            if (r8 == 0) goto L66
            java.lang.Object r9 = r11.invoke(r7, r8)     // Catch: java.lang.Throwable -> L8a
        L66:
            if (r9 == 0) goto L44
            r6.add(r9)     // Catch: java.lang.Throwable -> L8a
            goto L44
        L6c:
            kotlin.jvm.internal.c0.d(r4)
        L6f:
            if (r3 >= r2) goto L77
            r1.lock()
            int r3 = r3 + 1
            goto L6f
        L77:
            r0.unlock()
            kotlin.jvm.internal.c0.c(r4)
            return r6
        L7e:
            java.lang.String r11 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L8a
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L8a
            r5.<init>(r11)     // Catch: java.lang.Throwable -> L8a
            throw r5     // Catch: java.lang.Throwable -> L8a
        L8a:
            r11 = move-exception
            kotlin.jvm.internal.c0.d(r4)
        L8e:
            if (r3 >= r2) goto L96
            r1.lock()
            int r3 = r3 + 1
            goto L8e
        L96:
            r0.unlock()
            kotlin.jvm.internal.c0.c(r4)
            goto L9e
        L9d:
            throw r11
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.f.j(d2.p):java.util.List");
    }

    private final void k(PrintStream printStream) {
        kotlin.sequences.m l12;
        kotlin.sequences.m i02;
        kotlin.sequences.m<e> D2;
        ReentrantReadWriteLock reentrantReadWriteLock = f59608g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i4 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i5 = 0; i5 < readHoldCount; i5++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            f fVar = f59613l;
            if (fVar.z()) {
                printStream.print("Coroutines dump " + f59603b.format(Long.valueOf(System.currentTimeMillis())));
                l12 = kotlin.collections.f0.l1(fVar.q());
                i02 = SequencesKt___SequencesKt.i0(l12, C1204f.f59617a);
                D2 = SequencesKt___SequencesKt.D2(i02, new d());
                for (e eVar : D2) {
                    kotlinx.coroutines.debug.internal.d dVar = eVar.f59615b;
                    List<StackTraceElement> f4 = dVar.f();
                    f fVar2 = f59613l;
                    List<StackTraceElement> n4 = fVar2.n(dVar.e(), dVar.f59583c, f4);
                    printStream.print("\n\nCoroutine " + eVar.f59614a + ", state: " + ((f0.g(dVar.e(), "RUNNING") && n4 == f4) ? dVar.e() + " (Last suspension stacktrace, not an actual stacktrace)" : dVar.e()));
                    if (f4.isEmpty()) {
                        printStream.print("\n\tat " + i0.d("Coroutine creation stacktrace"));
                        fVar2.D(printStream, dVar.c());
                    } else {
                        fVar2.D(printStream, n4);
                    }
                }
                f1 f1Var = f1.f55527a;
                return;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i4 < readHoldCount) {
                readLock.lock();
                i4++;
            }
            writeLock.unlock();
        }
    }

    private final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object m119constructorimpl;
        if (!(!f0.g(str, "RUNNING")) && thread != null) {
            try {
                Result.a aVar = Result.Companion;
                m119constructorimpl = Result.m119constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m119constructorimpl = Result.m119constructorimpl(d0.a(th));
            }
            if (Result.m125isFailureimpl(m119constructorimpl)) {
                m119constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m119constructorimpl;
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i4 = -1;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i4];
                    if (f0.g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && f0.g(stackTraceElement.getMethodName(), "resumeWith") && f0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i4++;
                }
                Pair<Integer, Boolean> o4 = o(i4, stackTraceElementArr, list);
                int intValue = o4.component1().intValue();
                boolean booleanValue = o4.component2().booleanValue();
                if (intValue == -1) {
                    return list;
                }
                ArrayList arrayList = new ArrayList((((list.size() + i4) - intValue) - 1) - (booleanValue ? 1 : 0));
                int i5 = i4 - (booleanValue ? 1 : 0);
                for (int i6 = 0; i6 < i5; i6++) {
                    arrayList.add(stackTraceElementArr[i6]);
                }
                int size = list.size();
                for (int i7 = intValue + 1; i7 < size; i7++) {
                    arrayList.add(list.get(i7));
                }
                return arrayList;
            }
        }
        return list;
    }

    private final Pair<Integer, Boolean> o(int i4, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int p3 = p(i4 - 1, stackTraceElementArr, list);
        if (p3 == -1) {
            return l0.a(Integer.valueOf(p(i4 - 2, stackTraceElementArr, list)), Boolean.TRUE);
        }
        return l0.a(Integer.valueOf(p3), Boolean.FALSE);
    }

    private final int p(int i4, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        Object me;
        me = p.me(stackTraceElementArr, i4);
        StackTraceElement stackTraceElement = (StackTraceElement) me;
        if (stackTraceElement != null) {
            int i5 = 0;
            for (StackTraceElement stackTraceElement2 : list) {
                if (f0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && f0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && f0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<e<?>> q() {
        return f59605d.keySet();
    }

    private final String r(e2 e2Var) {
        return e2Var instanceof l2 ? ((l2) e2Var).e1() : e2Var.toString();
    }

    private static /* synthetic */ void s(e2 e2Var) {
    }

    private final l<Boolean, f1> t() {
        Object m119constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(d0.a(th));
        }
        if (newInstance != null) {
            m119constructorimpl = Result.m119constructorimpl((l) t0.q(newInstance, 1));
            if (Result.m125isFailureimpl(m119constructorimpl)) {
                m119constructorimpl = null;
            }
            return (l) m119constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(e<?> eVar) {
        e2 e2Var;
        kotlin.coroutines.f context = eVar.f59615b.getContext();
        if (context == null || (e2Var = (e2) context.get(e2.f59626i0)) == null || !e2Var.isCompleted()) {
            return false;
        }
        f59605d.remove(eVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> kotlin.coroutines.c<T> F(@NotNull kotlin.coroutines.c<? super T> cVar) {
        if (z() && B(cVar) == null) {
            return g(cVar, f59610i ? O(J(new Exception())) : null);
        }
        return cVar;
    }

    public final void G(@NotNull kotlin.coroutines.c<?> cVar) {
        R(cVar, "RUNNING");
    }

    public final void H(@NotNull kotlin.coroutines.c<?> cVar) {
        R(cVar, "SUSPENDED");
    }

    public final void K(boolean z3) {
        f59610i = z3;
    }

    public final void L(boolean z3) {
        f59609h = z3;
    }

    public final void P() {
        ReentrantReadWriteLock reentrantReadWriteLock = f59608g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i4 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i5 = 0; i5 < readHoldCount; i5++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            f fVar = f59613l;
            if (fVar.z()) {
                installations--;
                if (installations != 0) {
                    return;
                }
                fVar.N();
                f59605d.clear();
                f59612k.clear();
                if (kotlinx.coroutines.debug.a.f59545c.b()) {
                    while (i4 < readHoldCount) {
                        readLock.lock();
                        i4++;
                    }
                    writeLock.unlock();
                    return;
                }
                l<Boolean, f1> lVar = f59611j;
                if (lVar != null) {
                    lVar.invoke(Boolean.FALSE);
                }
                f1 f1Var = f1.f55527a;
                while (i4 < readHoldCount) {
                    readLock.lock();
                    i4++;
                }
                writeLock.unlock();
                return;
            }
            throw new IllegalStateException("Agent was not installed".toString());
        } finally {
            while (i4 < readHoldCount) {
                readLock.lock();
                i4++;
            }
            writeLock.unlock();
        }
    }

    public final void h(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            f59613l.k(printStream);
            f1 f1Var = f1.f55527a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.debug.internal.c> i() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.f r4 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$b r5 = new kotlinx.coroutines.debug.internal.f$b     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.w.f5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$e r6 = (kotlinx.coroutines.debug.internal.f.e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f r7 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L86
            boolean r7 = d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.d r7 = r6.f59615b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.f r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            kotlinx.coroutines.debug.internal.c r8 = new kotlinx.coroutines.debug.internal.c     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.d r6 = r6.f59615b     // Catch: java.lang.Throwable -> L86
            r8.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
        L68:
            if (r8 == 0) goto L43
            r5.add(r8)     // Catch: java.lang.Throwable -> L86
            goto L43
        L6e:
            if (r3 >= r2) goto L76
            r1.lock()
            int r3 = r3 + 1
            goto L6e
        L76:
            r0.unlock()
            return r5
        L7a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L86
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L86
            throw r5     // Catch: java.lang.Throwable -> L86
        L86:
            r4 = move-exception
        L87:
            if (r3 >= r2) goto L8f
            r1.lock()
            int r3 = r3 + 1
            goto L87
        L8f:
            r0.unlock()
            goto L94
        L93:
            throw r4
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.f.i():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> l() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = c(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L14
            int r2 = r0.getReadHoldCount()
            goto L15
        L14:
            r2 = 0
        L15:
            r4 = 0
        L16:
            if (r4 >= r2) goto L1e
            r1.unlock()
            int r4 = r4 + 1
            goto L16
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.f r4 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$c r5 = new kotlinx.coroutines.debug.internal.f$c     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.w.f5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$e r6 = (kotlinx.coroutines.debug.internal.f.e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f r7 = kotlinx.coroutines.debug.internal.f.f59613l     // Catch: java.lang.Throwable -> L86
            boolean r7 = d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.d r7 = r6.f59615b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.f r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            kotlinx.coroutines.debug.internal.DebuggerInfo r8 = new kotlinx.coroutines.debug.internal.DebuggerInfo     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.d r6 = r6.f59615b     // Catch: java.lang.Throwable -> L86
            r8.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
        L68:
            if (r8 == 0) goto L43
            r5.add(r8)     // Catch: java.lang.Throwable -> L86
            goto L43
        L6e:
            if (r3 >= r2) goto L76
            r1.lock()
            int r3 = r3 + 1
            goto L6e
        L76:
            r0.unlock()
            return r5
        L7a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L86
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L86
            throw r5     // Catch: java.lang.Throwable -> L86
        L86:
            r4 = move-exception
        L87:
            if (r3 >= r2) goto L8f
            r1.lock()
            int r3 = r3 + 1
            goto L87
        L8f:
            r0.unlock()
            goto L94
        L93:
            throw r4
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.f.l():java.util.List");
    }

    @NotNull
    public final List<StackTraceElement> m(@NotNull kotlinx.coroutines.debug.internal.c cVar, @NotNull List<StackTraceElement> list) {
        return n(cVar.f(), cVar.d(), list);
    }

    public final boolean u() {
        return f59610i;
    }

    public final boolean v() {
        return f59609h;
    }

    @NotNull
    public final String w(@NotNull e2 e2Var) {
        int Z;
        int j4;
        int n4;
        ReentrantReadWriteLock reentrantReadWriteLock = f59608g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i4 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i5 = 0; i5 < readHoldCount; i5++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            f fVar = f59613l;
            if (fVar.z()) {
                Set<e<?>> q3 = fVar.q();
                ArrayList arrayList = new ArrayList();
                for (Object obj : q3) {
                    if (((e) obj).f59614a.getContext().get(e2.f59626i0) != null) {
                        arrayList.add(obj);
                    }
                }
                Z = y.Z(arrayList, 10);
                j4 = y0.j(Z);
                n4 = q.n(j4, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(h2.C(((e) obj2).f59614a.getContext()), ((e) obj2).f59615b);
                }
                StringBuilder sb = new StringBuilder();
                f59613l.f(e2Var, linkedHashMap, sb, "");
                String sb2 = sb.toString();
                f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i4 < readHoldCount) {
                readLock.lock();
                i4++;
            }
            writeLock.unlock();
        }
    }

    public final void x() {
        ReentrantReadWriteLock reentrantReadWriteLock = f59608g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i4 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i5 = 0; i5 < readHoldCount; i5++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                return;
            }
            f59613l.M();
            if (kotlinx.coroutines.debug.a.f59545c.b()) {
                while (i4 < readHoldCount) {
                    readLock.lock();
                    i4++;
                }
                writeLock.unlock();
                return;
            }
            l<Boolean, f1> lVar = f59611j;
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
            f1 f1Var = f1.f55527a;
            while (i4 < readHoldCount) {
                readLock.lock();
                i4++;
            }
            writeLock.unlock();
        } finally {
            while (i4 < readHoldCount) {
                readLock.lock();
                i4++;
            }
            writeLock.unlock();
        }
    }

    public final boolean z() {
        return installations > 0;
    }
}
