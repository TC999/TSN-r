package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
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
import kotlin.C14294d0;
import kotlin.C14372l0;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.C14236x;
import kotlin.collections.MapsJVM;
import kotlin.collections._Arrays;
import kotlin.collections._Collections;
import kotlin.comparisons.Comparisons;
import kotlin.concurrent.Thread;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges._Ranges;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import kotlin.text.StringsJVM;
import kotlinx.coroutines.C15060h2;
import kotlinx.coroutines.C15125l2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.debug.AgentPremain;
import kotlinx.coroutines.internal.Scopes;
import kotlinx.coroutines.internal.StackTraceRecovery;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0090\u0001B\n\b\u0002¢\u0006\u0005\b\u008f\u0001\u0010\bJ\u001d\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ;\u0010\u0013\u001a\u00020\u0004*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J>\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\u0015*\u00020\u00012\u001c\u0010\u0019\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0016H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b%\u0010&J5\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010'\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b+\u0010,J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003012\u0006\u0010.\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b2\u00103J3\u00105\u001a\u00020-2\u0006\u00104\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0/2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\b5\u00106J#\u0010\u0015\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u00109J\u001f\u0010;\u001a\u00020\u00042\u0006\u00108\u001a\u00020:2\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b;\u0010<J\u0016\u0010=\u001a\u0004\u0018\u00010:*\u00020:H\u0082\u0010¢\u0006\u0004\b=\u0010>J/\u0010@\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u00172\n\u00108\u001a\u0006\u0012\u0002\b\u0003072\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b@\u0010AJ\u001d\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u000307H\u0002¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020:H\u0082\u0010¢\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\u0004\u0018\u00010F*\b\u0012\u0004\u0012\u00020#0\u001aH\u0002¢\u0006\u0004\bG\u0010HJ3\u0010K\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u0000072\b\u00108\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00042\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\bM\u0010NJ'\u0010Q\u001a\b\u0012\u0004\u0012\u00020#0\u001a\"\b\b\u0000\u0010I*\u00020O2\u0006\u0010P\u001a\u00028\u0000H\u0002¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\u0004¢\u0006\u0004\bS\u0010\bJ\r\u0010T\u001a\u00020\u0004¢\u0006\u0004\bT\u0010\bJ\u0015\u0010V\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ\u0013\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u001a¢\u0006\u0004\bY\u0010ZJ\u0013\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0\u001a¢\u0006\u0004\b\\\u0010ZJ\u0015\u0010]\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b]\u0010\"J)\u0010_\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010^\u001a\u00020X2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u001a¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000¢\u0006\u0004\ba\u0010bJ\u001b\u0010c\u001a\u00020\u00042\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0000¢\u0006\u0004\bc\u0010bJ)\u0010d\u001a\b\u0012\u0004\u0012\u00028\u000007\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0000¢\u0006\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR$\u0010s\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00030p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010=R\u0014\u0010w\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010vR\"\u0010}\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R#\u0010\u0080\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010x\u001a\u0004\b~\u0010z\"\u0004\b\u007f\u0010|R!\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\f0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010rR\"\u0010\u0085\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\"\u0010\u0089\u0001\u001a\u00020\u0011*\u00020\n8BX\u0082\u0004¢\u0006\u000f\u0012\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0005\b\u0086\u0001\u0010WR\u001b\u0010\u008c\u0001\u001a\u00020\u0003*\u00020#8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010\u008e\u0001\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010z¨\u0006\u0091\u0001"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/f;", "", "Lkotlin/Function1;", "", "Lkotlin/f1;", UMCommonContent.f37782aL, "()Ll1/l;", "M", "()V", "N", "Lkotlinx/coroutines/e2;", "", "Lkotlinx/coroutines/debug/internal/d;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "indent", "f", "(Lkotlinx/coroutines/e2;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/f$e;", "Lkotlin/coroutines/f;", "create", "", "j", "(Ll1/p;)Ljava/util/List;", "y", "(Lkotlinx/coroutines/debug/internal/f$e;)Z", "Ljava/io/PrintStream;", "out", "k", "(Ljava/io/PrintStream;)V", "Ljava/lang/StackTraceElement;", "frames", "D", "(Ljava/io/PrintStream;Ljava/util/List;)V", "state", "Ljava/lang/Thread;", "thread", "coroutineTrace", "n", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "o", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "p", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/coroutines/c;", "frame", "(Lkotlin/coroutines/c;Ljava/lang/String;)V", "Lkotlin/coroutines/jvm/internal/c;", "Q", "(Lkotlin/coroutines/jvm/internal/c;Ljava/lang/String;)V", "I", "(Lkotlin/coroutines/jvm/internal/c;)Lkotlin/coroutines/jvm/internal/c;", "owner", ExifInterface.LATITUDE_SOUTH, "(Lkotlinx/coroutines/debug/internal/f$e;Lkotlin/coroutines/c;Ljava/lang/String;)V", "B", "(Lkotlin/coroutines/c;)Lkotlinx/coroutines/debug/internal/f$e;", "C", "(Lkotlin/coroutines/jvm/internal/c;)Lkotlinx/coroutines/debug/internal/f$e;", "Lkotlinx/coroutines/debug/internal/j;", "O", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/j;", ExifInterface.GPS_DIRECTION_TRUE, "completion", "g", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/debug/internal/j;)Lkotlin/coroutines/c;", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/debug/internal/f$e;)V", "", "throwable", "J", "(Ljava/lang/Throwable;)Ljava/util/List;", "x", "P", "job", IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/e2;)Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/c;", "i", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", C7304t.f25048d, "h", "info", "m", "(Lkotlinx/coroutines/debug/internal/c;Ljava/util/List;)Ljava/util/List;", "G", "(Lkotlin/coroutines/c;)V", "H", "F", "(Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "a", "Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "dateFormat", "c", "Ljava/lang/Thread;", "weakRefCleanerThread", "Lkotlinx/coroutines/debug/internal/a;", "d", "Lkotlinx/coroutines/debug/internal/a;", "capturedCoroutinesMap", "installations", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Z", "v", "()Z", "L", "(Z)V", "sanitizeStackTraces", "u", "K", "enableCreationStackTraces", "callerInfoCache", "", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Set;", "capturedCoroutines", "r", "getDebugString$annotations", "(Lkotlinx/coroutines/e2;)V", "debugString", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/StackTraceElement;)Z", "isInternalMethod", UMCommonContent.f37777aG, "isInstalled", "<init>", "e", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.debug.internal.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DebugProbesImpl {

    /* renamed from: a */
    private static final String f42257a = "Coroutine creation stacktrace";

    /* renamed from: b */
    private static final SimpleDateFormat f42258b;

    /* renamed from: c */
    private static Thread f42259c;

    /* renamed from: d */
    private static final ConcurrentWeakMap<C14767e<?>, Boolean> f42260d;

    /* renamed from: e */
    static final /* synthetic */ C14770g f42261e;

    /* renamed from: f */
    static final /* synthetic */ AtomicLongFieldUpdater f42262f;

    /* renamed from: g */
    private static final ReentrantReadWriteLock f42263g;

    /* renamed from: h */
    private static boolean f42264h;

    /* renamed from: i */
    private static boolean f42265i;
    private static volatile int installations;

    /* renamed from: j */
    private static final InterfaceC15280l<Boolean, Unit> f42266j;

    /* renamed from: k */
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> f42267k;

    /* renamed from: l */
    public static final DebugProbesImpl f42268l;

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14763a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g(Long.valueOf(((C14767e) t).f42270b.f42241f), Long.valueOf(((C14767e) t2).f42270b.f42241f));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14764b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g(Long.valueOf(((C14767e) t).f42270b.f42241f), Long.valueOf(((C14767e) t2).f42270b.f42241f));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14765c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g(Long.valueOf(((C14767e) t).f42270b.f42241f), Long.valueOf(((C14767e) t2).f42270b.f42241f));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14766d<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g(Long.valueOf(((C14767e) t).f42270b.f42241f), Long.valueOf(((C14767e) t2).f42270b.f42241f));
            return m8803g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B'\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/f$e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "a", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/debug/internal/d;", "b", "Lkotlinx/coroutines/debug/internal/d;", "info", "c", "Lkotlin/coroutines/jvm/internal/c;", "frame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/debug/internal/d;Lkotlin/coroutines/jvm/internal/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14767e<T> implements InterfaceC14268c<T>, CoroutineStackFrame {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: a */
        public final InterfaceC14268c<T> f42269a;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final DebugCoroutineInfoImpl f42270b;

        /* renamed from: c */
        private final CoroutineStackFrame f42271c;

        /* JADX WARN: Multi-variable type inference failed */
        public C14767e(@NotNull InterfaceC14268c<? super T> interfaceC14268c, @NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @Nullable CoroutineStackFrame coroutineStackFrame) {
            this.f42269a = interfaceC14268c;
            this.f42270b = debugCoroutineInfoImpl;
            this.f42271c = coroutineStackFrame;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.f42271c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        @NotNull
        public CoroutineContext getContext() {
            return this.f42269a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.f42271c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        public void resumeWith(@NotNull Object obj) {
            DebugProbesImpl.f42268l.m5094E(this);
            this.f42269a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.f42269a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/f$e;", "it", "", "a", "(Lkotlinx/coroutines/debug/internal/f$e;)Z"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14768f extends Lambda implements InterfaceC15280l<C14767e<?>, Boolean> {

        /* renamed from: a */
        public static final C14768f f42272a = new C14768f();

        C14768f() {
            super(1);
        }

        /* renamed from: a */
        public final boolean m5053a(@NotNull C14767e<?> c14767e) {
            return !DebugProbesImpl.f42268l.m5055y(c14767e);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Boolean invoke(C14767e<?> c14767e) {
            return Boolean.valueOf(m5053a(c14767e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.f$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14769g extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        public static final C14769g f42273a = new C14769g();

        C14769g() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DebugProbesImpl.m5079a(DebugProbesImpl.f42268l).m5133k();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.g] */
    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f42268l = debugProbesImpl;
        f42258b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f42260d = new ConcurrentWeakMap<>(false, 1, null);
        f42261e = new Object(0L) { // from class: kotlinx.coroutines.debug.internal.g
            volatile long sequenceNumber;

            {
                this.sequenceNumber = r1;
            }
        };
        f42263g = new ReentrantReadWriteLock();
        f42264h = true;
        f42265i = true;
        f42266j = debugProbesImpl.m5060t();
        f42267k = new ConcurrentWeakMap<>(true);
        f42262f = AtomicLongFieldUpdater.newUpdater(C14770g.class, "sequenceNumber");
    }

    private DebugProbesImpl() {
    }

    /* renamed from: A */
    private final boolean m5098A(StackTraceElement stackTraceElement) {
        boolean m6548u2;
        m6548u2 = StringsJVM.m6548u2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
        return m6548u2;
    }

    /* renamed from: B */
    private final C14767e<?> m5097B(InterfaceC14268c<?> interfaceC14268c) {
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) interfaceC14268c;
        if (coroutineStackFrame != null) {
            return m5096C(coroutineStackFrame);
        }
        return null;
    }

    /* renamed from: C */
    private final C14767e<?> m5096C(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof C14767e)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (C14767e) coroutineStackFrame;
    }

    /* renamed from: D */
    private final void m5095D(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public final void m5094E(C14767e<?> c14767e) {
        CoroutineStackFrame m5090I;
        f42260d.remove(c14767e);
        CoroutineStackFrame m5104d = c14767e.f42270b.m5104d();
        if (m5104d == null || (m5090I = m5090I(m5104d)) == null) {
            return;
        }
        f42267k.remove(m5090I);
    }

    /* renamed from: I */
    private final CoroutineStackFrame m5090I(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    /* renamed from: J */
    private final <T extends Throwable> List<StackTraceElement> m5089J(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            } else if (C14342f0.m8193g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i = length2;
                break;
            } else {
                length2--;
            }
        }
        int i2 = 0;
        if (!f42264h) {
            int i3 = length - i;
            ArrayList arrayList = new ArrayList(i3);
            while (i2 < i3) {
                arrayList.add(i2 == 0 ? StackTraceRecovery.m4328d(f42257a) : stackTrace[i2 + i]);
                i2++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i) + 1);
        arrayList2.add(StackTraceRecovery.m4328d(f42257a));
        int i4 = length - 1;
        boolean z = true;
        for (int i5 = i + 1; i5 < i4; i5++) {
            StackTraceElement stackTraceElement = stackTrace[i5];
            if (m5098A(stackTraceElement)) {
                if (z) {
                    arrayList2.add(stackTraceElement);
                    z = false;
                } else if (!m5098A(stackTrace[i5 + 1])) {
                    arrayList2.add(stackTraceElement);
                }
            } else {
                arrayList2.add(stackTraceElement);
            }
            z = true;
        }
        arrayList2.add(stackTrace[i4]);
        return arrayList2;
    }

    /* renamed from: M */
    private final void m5086M() {
        Thread m8701b;
        m8701b = Thread.m8701b((r12 & 1) != 0, (r12 & 2) != 0 ? false : true, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : "Coroutines Debugger Cleaner", (r12 & 16) != 0 ? -1 : 0, C14769g.f42273a);
        f42259c = m8701b;
    }

    /* renamed from: N */
    private final void m5085N() {
        Thread thread = f42259c;
        if (thread != null) {
            thread.interrupt();
        }
        f42259c = null;
    }

    /* renamed from: O */
    private final StackTraceFrame m5084O(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }

    /* renamed from: Q */
    private final void m5082Q(CoroutineStackFrame coroutineStackFrame, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f42263g.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f42268l;
            if (debugProbesImpl.m5054z()) {
                ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = f42267k;
                DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
                if (remove == null) {
                    C14767e<?> m5096C = debugProbesImpl.m5096C(coroutineStackFrame);
                    if (m5096C == null || (remove = m5096C.f42270b) == null) {
                        return;
                    }
                    CoroutineStackFrame m5104d = remove.m5104d();
                    CoroutineStackFrame m5090I = m5104d != null ? debugProbesImpl.m5090I(m5104d) : null;
                    if (m5090I != null) {
                        concurrentWeakMap.remove(m5090I);
                    }
                }
                if (coroutineStackFrame != null) {
                    remove.m5100h(str, (InterfaceC14268c) coroutineStackFrame);
                    CoroutineStackFrame m5090I2 = debugProbesImpl.m5090I(coroutineStackFrame);
                    if (m5090I2 != null) {
                        concurrentWeakMap.put(m5090I2, remove);
                        Unit unit = Unit.f41048a;
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

    /* renamed from: R */
    private final void m5081R(InterfaceC14268c<?> interfaceC14268c, String str) {
        if (m5054z()) {
            if (C14342f0.m8193g(str, C14762e.f42255b) && KotlinVersion.f41225f.m7954f(1, 3, 30)) {
                if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
                    interfaceC14268c = null;
                }
                CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) interfaceC14268c;
                if (coroutineStackFrame != null) {
                    m5082Q(coroutineStackFrame, str);
                    return;
                }
                return;
            }
            C14767e<?> m5097B = m5097B(interfaceC14268c);
            if (m5097B != null) {
                m5080S(m5097B, interfaceC14268c, str);
            }
        }
    }

    /* renamed from: S */
    private final void m5080S(C14767e<?> c14767e, InterfaceC14268c<?> interfaceC14268c, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f42263g.readLock();
        readLock.lock();
        try {
            if (f42268l.m5054z()) {
                c14767e.f42270b.m5100h(str, interfaceC14268c);
                Unit unit = Unit.f41048a;
            }
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ ConcurrentWeakMap m5079a(DebugProbesImpl debugProbesImpl) {
        return f42267k;
    }

    /* renamed from: c */
    public static final /* synthetic */ ReentrantReadWriteLock m5077c(DebugProbesImpl debugProbesImpl) {
        return f42263g;
    }

    /* renamed from: f */
    private final void m5074f(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        Object m12059t2;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl == null) {
            if (!(job instanceof Scopes)) {
                sb.append(str + m5062r(job) + '\n');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("\t");
                str = sb2.toString();
            }
        } else {
            m12059t2 = _Collections.m12059t2(debugCoroutineInfoImpl.m5102f());
            String m5103e = debugCoroutineInfoImpl.m5103e();
            sb.append(str + m5062r(job) + ", continuation is " + m5103e + " at line " + ((StackTraceElement) m12059t2) + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("\t");
            str = sb3.toString();
        }
        for (Job job2 : job.mo3826i()) {
            m5074f(job2, map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    private final <T> InterfaceC14268c<T> m5073g(InterfaceC14268c<? super T> interfaceC14268c, StackTraceFrame stackTraceFrame) {
        if (m5054z()) {
            C14767e<?> c14767e = new C14767e<>(interfaceC14268c, new DebugCoroutineInfoImpl(interfaceC14268c.getContext(), stackTraceFrame, f42262f.incrementAndGet(f42261e)), stackTraceFrame);
            ConcurrentWeakMap<C14767e<?>, Boolean> concurrentWeakMap = f42260d;
            concurrentWeakMap.put(c14767e, Boolean.TRUE);
            if (!m5054z()) {
                concurrentWeakMap.clear();
            }
            return c14767e;
        }
        return interfaceC14268c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        r6.add(r9);
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <R> java.util.List<R> m5070j(p617l1.InterfaceC15284p<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.C14767e<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r11) {
        /*
            r10 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = m5077c(r10)
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
            kotlinx.coroutines.debug.internal.f r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L8a
            boolean r6 = r5.m5054z()     // Catch: java.lang.Throwable -> L8a
            if (r6 == 0) goto L7e
            java.util.Set r5 = m5078b(r5)     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f$a r6 = new kotlinx.coroutines.debug.internal.f$a     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.List r5 = kotlin.collections.C14233v.m9000h5(r5, r6)     // Catch: java.lang.Throwable -> L8a
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Throwable -> L8a
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L8a
        L44:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L8a
            if (r7 == 0) goto L6c
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f$e r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.C14767e) r7     // Catch: java.lang.Throwable -> L8a
            kotlinx.coroutines.debug.internal.f r8 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L8a
            boolean r8 = m5076d(r8, r7)     // Catch: java.lang.Throwable -> L8a
            r9 = 0
            if (r8 == 0) goto L5a
            goto L66
        L5a:
            kotlinx.coroutines.debug.internal.d r8 = r7.f42270b     // Catch: java.lang.Throwable -> L8a
            kotlin.coroutines.f r8 = r8.getContext()     // Catch: java.lang.Throwable -> L8a
            if (r8 == 0) goto L66
            java.lang.Object r9 = r11.invoke(r7, r8)     // Catch: java.lang.Throwable -> L8a
        L66:
            if (r9 == 0) goto L44
            r6.add(r9)     // Catch: java.lang.Throwable -> L8a
            goto L44
        L6c:
            kotlin.jvm.internal.InlineMarker.m8228d(r4)
        L6f:
            if (r3 >= r2) goto L77
            r1.lock()
            int r3 = r3 + 1
            goto L6f
        L77:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.m8229c(r4)
            return r6
        L7e:
            java.lang.String r11 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L8a
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L8a
            r5.<init>(r11)     // Catch: java.lang.Throwable -> L8a
            throw r5     // Catch: java.lang.Throwable -> L8a
        L8a:
            r11 = move-exception
            kotlin.jvm.internal.InlineMarker.m8228d(r4)
        L8e:
            if (r3 >= r2) goto L96
            r1.lock()
            int r3 = r3 + 1
            goto L8e
        L96:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.m8229c(r4)
            goto L9e
        L9d:
            throw r11
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.m5070j(l1.p):java.util.List");
    }

    /* renamed from: k */
    private final void m5069k(PrintStream printStream) {
        Sequence m12090n1;
        Sequence m7140i0;
        Sequence<C14767e> m7261D2;
        ReentrantReadWriteLock reentrantReadWriteLock = f42263g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f42268l;
            if (debugProbesImpl.m5054z()) {
                printStream.print("Coroutines dump " + f42258b.format(Long.valueOf(System.currentTimeMillis())));
                m12090n1 = _Collections.m12090n1(debugProbesImpl.m5063q());
                m7140i0 = _Sequences.m7140i0(m12090n1, C14768f.f42272a);
                m7261D2 = _Sequences.m7261D2(m7140i0, new C14766d());
                for (C14767e c14767e : m7261D2) {
                    DebugCoroutineInfoImpl debugCoroutineInfoImpl = c14767e.f42270b;
                    List<StackTraceElement> m5102f = debugCoroutineInfoImpl.m5102f();
                    DebugProbesImpl debugProbesImpl2 = f42268l;
                    List<StackTraceElement> m5066n = debugProbesImpl2.m5066n(debugCoroutineInfoImpl.m5103e(), debugCoroutineInfoImpl.f42238c, m5102f);
                    printStream.print("\n\nCoroutine " + c14767e.f42269a + ", state: " + ((C14342f0.m8193g(debugCoroutineInfoImpl.m5103e(), C14762e.f42255b) && m5066n == m5102f) ? debugCoroutineInfoImpl.m5103e() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfoImpl.m5103e()));
                    if (m5102f.isEmpty()) {
                        printStream.print("\n\tat " + StackTraceRecovery.m4328d(f42257a));
                        debugProbesImpl2.m5095D(printStream, debugCoroutineInfoImpl.m5105c());
                    } else {
                        debugProbesImpl2.m5095D(printStream, m5066n);
                    }
                }
                Unit unit = Unit.f41048a;
                return;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    /* renamed from: n */
    private final List<StackTraceElement> m5066n(String str, Thread thread, List<StackTraceElement> list) {
        Object m60148constructorimpl;
        if (!(!C14342f0.m8193g(str, C14762e.f42255b)) && thread != null) {
            try {
                Result.C14124a c14124a = Result.Companion;
                m60148constructorimpl = Result.m60148constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.C14124a c14124a2 = Result.Companion;
                m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
            }
            if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                m60148constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m60148constructorimpl;
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (C14342f0.m8193g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && C14342f0.m8193g(stackTraceElement.getMethodName(), "resumeWith") && C14342f0.m8193g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i++;
                }
                Tuples<Integer, Boolean> m5065o = m5065o(i, stackTraceElementArr, list);
                int intValue = m5065o.component1().intValue();
                boolean booleanValue = m5065o.component2().booleanValue();
                if (intValue == -1) {
                    return list;
                }
                ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - (booleanValue ? 1 : 0));
                int i2 = i - (booleanValue ? 1 : 0);
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList.add(stackTraceElementArr[i3]);
                }
                int size = list.size();
                for (int i4 = intValue + 1; i4 < size; i4++) {
                    arrayList.add(list.get(i4));
                }
                return arrayList;
            }
        }
        return list;
    }

    /* renamed from: o */
    private final Tuples<Integer, Boolean> m5065o(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int m5064p = m5064p(i - 1, stackTraceElementArr, list);
        if (m5064p == -1) {
            return C14372l0.m7952a(Integer.valueOf(m5064p(i - 2, stackTraceElementArr, list)), Boolean.TRUE);
        }
        return C14372l0.m7952a(Integer.valueOf(m5064p), Boolean.FALSE);
    }

    /* renamed from: p */
    private final int m5064p(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        Object m10253me;
        m10253me = _Arrays.m10253me(stackTraceElementArr, i);
        StackTraceElement stackTraceElement = (StackTraceElement) m10253me;
        if (stackTraceElement != null) {
            int i2 = 0;
            for (StackTraceElement stackTraceElement2 : list) {
                if (C14342f0.m8193g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && C14342f0.m8193g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && C14342f0.m8193g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public final Set<C14767e<?>> m5063q() {
        return f42260d.keySet();
    }

    /* renamed from: r */
    private final String m5062r(Job job) {
        return job instanceof C15125l2 ? ((C15125l2) job).m4039e1() : job.toString();
    }

    /* renamed from: s */
    private static /* synthetic */ void m5061s(Job job) {
    }

    /* renamed from: t */
    private final InterfaceC15280l<Boolean, Unit> m5060t() {
        Object m60148constructorimpl;
        Object newInstance;
        try {
            Result.C14124a c14124a = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        if (newInstance != null) {
            m60148constructorimpl = Result.m60148constructorimpl((InterfaceC15280l) TypeIntrinsics.m8010q(newInstance, 1));
            if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                m60148constructorimpl = null;
            }
            return (InterfaceC15280l) m60148constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public final boolean m5055y(C14767e<?> c14767e) {
        Job job;
        CoroutineContext context = c14767e.f42270b.getContext();
        if (context == null || (job = (Job) context.get(Job.f42281m0)) == null || !job.isCompleted()) {
            return false;
        }
        f42260d.remove(c14767e);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: F */
    public final <T> InterfaceC14268c<T> m5093F(@NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        if (m5054z() && m5097B(interfaceC14268c) == null) {
            return m5073g(interfaceC14268c, f42265i ? m5084O(m5089J(new Exception())) : null);
        }
        return interfaceC14268c;
    }

    /* renamed from: G */
    public final void m5092G(@NotNull InterfaceC14268c<?> interfaceC14268c) {
        m5081R(interfaceC14268c, C14762e.f42255b);
    }

    /* renamed from: H */
    public final void m5091H(@NotNull InterfaceC14268c<?> interfaceC14268c) {
        m5081R(interfaceC14268c, C14762e.f42256c);
    }

    /* renamed from: K */
    public final void m5088K(boolean z) {
        f42265i = z;
    }

    /* renamed from: L */
    public final void m5087L(boolean z) {
        f42264h = z;
    }

    /* renamed from: P */
    public final void m5083P() {
        ReentrantReadWriteLock reentrantReadWriteLock = f42263g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f42268l;
            if (debugProbesImpl.m5054z()) {
                installations--;
                if (installations != 0) {
                    return;
                }
                debugProbesImpl.m5085N();
                f42260d.clear();
                f42267k.clear();
                if (AgentPremain.f42200c.m5145b()) {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                    return;
                }
                InterfaceC15280l<Boolean, Unit> interfaceC15280l = f42266j;
                if (interfaceC15280l != null) {
                    interfaceC15280l.invoke(Boolean.FALSE);
                }
                Unit unit = Unit.f41048a;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            throw new IllegalStateException("Agent was not installed".toString());
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    /* renamed from: h */
    public final void m5072h(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            f42268l.m5069k(printStream);
            Unit unit = Unit.f41048a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> m5071i() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = m5077c(r9)
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
            kotlinx.coroutines.debug.internal.f r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.m5054z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = m5078b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$b r5 = new kotlinx.coroutines.debug.internal.f$b     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.C14233v.m9000h5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$e r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.C14767e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L86
            boolean r7 = m5076d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.d r7 = r6.f42270b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.f r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            kotlinx.coroutines.debug.internal.c r8 = new kotlinx.coroutines.debug.internal.c     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.d r6 = r6.f42270b     // Catch: java.lang.Throwable -> L86
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.m5071i():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.add(r8);
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> m5068l() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = m5077c(r9)
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
            kotlinx.coroutines.debug.internal.f r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.m5054z()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7a
            java.util.Set r4 = m5078b(r4)     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$c r5 = new kotlinx.coroutines.debug.internal.f$c     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.List r4 = kotlin.collections.C14233v.m9000h5(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L86
        L43:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f$e r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.C14767e) r6     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.f r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f42268l     // Catch: java.lang.Throwable -> L86
            boolean r7 = m5076d(r7, r6)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            if (r7 == 0) goto L59
            goto L68
        L59:
            kotlinx.coroutines.debug.internal.d r7 = r6.f42270b     // Catch: java.lang.Throwable -> L86
            kotlin.coroutines.f r7 = r7.getContext()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L68
            kotlinx.coroutines.debug.internal.DebuggerInfo r8 = new kotlinx.coroutines.debug.internal.DebuggerInfo     // Catch: java.lang.Throwable -> L86
            kotlinx.coroutines.debug.internal.d r6 = r6.f42270b     // Catch: java.lang.Throwable -> L86
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.m5068l():java.util.List");
    }

    @NotNull
    /* renamed from: m */
    public final List<StackTraceElement> m5067m(@NotNull DebugCoroutineInfo debugCoroutineInfo, @NotNull List<StackTraceElement> list) {
        return m5066n(debugCoroutineInfo.m5109f(), debugCoroutineInfo.m5111d(), list);
    }

    /* renamed from: u */
    public final boolean m5059u() {
        return f42265i;
    }

    /* renamed from: v */
    public final boolean m5058v() {
        return f42264h;
    }

    @NotNull
    /* renamed from: w */
    public final String m5057w(@NotNull Job job) {
        int m8957Y;
        int m8944j;
        int m7481n;
        ReentrantReadWriteLock reentrantReadWriteLock = f42263g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f42268l;
            if (debugProbesImpl.m5054z()) {
                Set<C14767e<?>> m5063q = debugProbesImpl.m5063q();
                ArrayList arrayList = new ArrayList();
                for (Object obj : m5063q) {
                    if (((C14767e) obj).f42269a.getContext().get(Job.f42281m0) != null) {
                        arrayList.add(obj);
                    }
                }
                m8957Y = C14236x.m8957Y(arrayList, 10);
                m8944j = MapsJVM.m8944j(m8957Y);
                m7481n = _Ranges.m7481n(m8944j, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(m7481n);
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(C15060h2.m4441C(((C14767e) obj2).f42269a.getContext()), ((C14767e) obj2).f42270b);
                }
                StringBuilder sb = new StringBuilder();
                f42268l.m5074f(job, linkedHashMap, sb, "");
                String sb2 = sb.toString();
                C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    /* renamed from: x */
    public final void m5056x() {
        ReentrantReadWriteLock reentrantReadWriteLock = f42263g;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                return;
            }
            f42268l.m5086M();
            if (AgentPremain.f42200c.m5145b()) {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            InterfaceC15280l<Boolean, Unit> interfaceC15280l = f42266j;
            if (interfaceC15280l != null) {
                interfaceC15280l.invoke(Boolean.TRUE);
            }
            Unit unit = Unit.f41048a;
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    /* renamed from: z */
    public final boolean m5054z() {
        return installations > 0;
    }
}
