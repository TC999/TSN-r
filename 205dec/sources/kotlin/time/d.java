package kotlin.time;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.r;
import d2.s;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Duration.kt */
@SinceKotlin(version = "1.6")
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\bB\b\u0087@\u0018\u0000 \u0094\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001VB\u0015\b\u0000\u0012\u0006\u0010X\u001a\u00020\u000b\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0093\u0001\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0015H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0014J\u001e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0015H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0004J\u001b\u0010 \u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u009d\u0001\u0010,\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2u\u0010+\u001aq\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000#H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b,\u0010-J\u0088\u0001\u0010/\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2`\u0010+\u001a\\\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000.H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b/\u00100Js\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2K\u0010+\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u000001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b2\u00103J^\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"26\u0010+\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u000004H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\u00152\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\u000b2\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00112\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000bH\u0007\u00a2\u0006\u0004\b?\u0010\u0007J\u000f\u0010@\u001a\u00020\u000bH\u0007\u00a2\u0006\u0004\b@\u0010\u0007J\u000f\u0010B\u001a\u00020AH\u0016\u00a2\u0006\u0004\bB\u0010CJ?\u0010K\u001a\u00020J*\u00060Dj\u0002`E2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u00108\u001a\u00020A2\u0006\u0010I\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bK\u0010LJ\u001f\u0010N\u001a\u00020A2\u0006\u00108\u001a\u0002072\b\b\u0002\u0010M\u001a\u00020\u0011\u00a2\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020A\u00a2\u0006\u0004\bP\u0010CJ\u0010\u0010Q\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\bQ\u0010RJ\u001a\u0010T\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010SH\u00d6\u0003\u00a2\u0006\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010\u0007R\u0015\u0010\\\u001a\u00020\u00118\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010RR\u0014\u0010_\u001a\u0002078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^R\u0017\u0010a\u001a\u00020\u00008F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b`\u0010\u0007R\u001a\u0010e\u001a\u00020\u00118@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bc\u0010d\u001a\u0004\bb\u0010RR\u001a\u0010h\u001a\u00020\u00118@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bg\u0010d\u001a\u0004\bf\u0010RR\u001a\u0010k\u001a\u00020\u00118@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bj\u0010d\u001a\u0004\bi\u0010RR\u001a\u0010n\u001a\u00020\u00118@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bm\u0010d\u001a\u0004\bl\u0010RR\u001a\u0010r\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bq\u0010d\u001a\u0004\bo\u0010pR\u001a\u0010u\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bt\u0010d\u001a\u0004\bs\u0010pR\u001a\u0010x\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bw\u0010d\u001a\u0004\bv\u0010pR\u001a\u0010{\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bz\u0010d\u001a\u0004\by\u0010pR\u001a\u0010~\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b}\u0010d\u001a\u0004\b|\u0010pR\u001c\u0010\u0081\u0001\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\r\u0012\u0005\b\u0080\u0001\u0010d\u001a\u0004\b\u007f\u0010pR\u001d\u0010\u0084\u0001\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\u000e\u0012\u0005\b\u0083\u0001\u0010d\u001a\u0005\b\u0082\u0001\u0010pR\u0013\u0010\u0086\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u0007R\u0013\u0010\u0088\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0007R\u0013\u0010\u008a\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u0007R\u0013\u0010\u008c\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\u0007R\u0013\u0010\u008e\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010\u0007R\u0013\u0010\u0090\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u0007R\u0013\u0010\u0092\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0007\u0088\u0001X\u0092\u0001\u00020\u000b\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001\u00a8\u0006\u0095\u0001"}, d2 = {"Lkotlin/time/d;", "", "", "d0", "(J)Z", "c0", "y0", "(J)J", "other", "i0", "(JJ)J", "", "thisMillis", "otherNanos", "e", "(JJJ)J", "h0", "", "scale", "k0", "(JI)J", "", "j0", "(JD)J", "m", "l", "k", "(JJ)D", "f0", "g0", "e0", "b0", "i", "(JJ)I", "T", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "o0", "(JLd2/s;)Ljava/lang/Object;", "Lkotlin/Function4;", "n0", "(JLd2/r;)Ljava/lang/Object;", "Lkotlin/Function3;", "m0", "(JLd2/q;)Ljava/lang/Object;", "Lkotlin/Function2;", "l0", "(JLd2/p;)Ljava/lang/Object;", "Lkotlin/time/DurationUnit;", "unit", "p0", "(JLkotlin/time/DurationUnit;)D", "s0", "(JLkotlin/time/DurationUnit;)J", "q0", "(JLkotlin/time/DurationUnit;)I", "u0", "t0", "", "v0", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "Lkotlin/f1;", "f", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "w0", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "r0", "a0", "(J)I", "", "n", "(JLjava/lang/Object;)Z", "a", "J", "rawValue", "Z", "value", "Y", "unitDiscriminator", "X", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "p", "absoluteValue", "r", "getHoursComponent$annotations", "()V", "hoursComponent", "S", "getMinutesComponent$annotations", "minutesComponent", "W", "getSecondsComponent$annotations", "secondsComponent", "U", "getNanosecondsComponent$annotations", "nanosecondsComponent", "t", "(J)D", "getInDays$annotations", "inDays", "w", "getInHours$annotations", "inHours", "D", "getInMinutes$annotations", "inMinutes", "H", "getInSeconds$annotations", "inSeconds", "B", "getInMilliseconds$annotations", "inMilliseconds", "z", "getInMicroseconds$annotations", "inMicroseconds", "F", "getInNanoseconds$annotations", "inNanoseconds", "K", "inWholeDays", "L", "inWholeHours", "O", "inWholeMinutes", "Q", "inWholeSeconds", "N", "inWholeMilliseconds", "M", "inWholeMicroseconds", "P", "inWholeNanoseconds", "j", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d implements Comparable<d> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f58993b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final long f58994c = j(0);

    /* renamed from: d  reason: collision with root package name */
    private static final long f58995d = f.b(4611686018427387903L);

    /* renamed from: e  reason: collision with root package name */
    private static final long f58996e = f.b(-4611686018427387903L);

    /* renamed from: a  reason: collision with root package name */
    private final long f58997a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Duration.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b6\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bW\u0010XJ \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u000eJ\u001d\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u000bJ\u001d\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u000eJ\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u000bJ\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u000eJ\u001d\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0010J\u001d\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u000bJ\u001d\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u000eJ\u001d\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010\u0010J\u001d\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010\u000bJ\u001d\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u000eJ\u001d\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010\u0010J\u001b\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020#\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020#\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010%J\u001d\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020#\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020#\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010(R%\u0010-\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010\u000bR%\u0010-\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b+\u0010/\u001a\u0004\b.\u0010\u000eR%\u0010-\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b+\u00101\u001a\u0004\b0\u0010\u0010R%\u00104\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b2\u0010\u000bR%\u00104\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b3\u0010/\u001a\u0004\b5\u0010\u000eR%\u00104\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b3\u00101\u001a\u0004\b6\u0010\u0010R%\u00109\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b8\u0010,\u001a\u0004\b7\u0010\u000bR%\u00109\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b8\u0010/\u001a\u0004\b:\u0010\u000eR%\u00109\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b8\u00101\u001a\u0004\b;\u0010\u0010R%\u0010>\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b=\u0010,\u001a\u0004\b<\u0010\u000bR%\u0010>\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b=\u0010/\u001a\u0004\b?\u0010\u000eR%\u0010>\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b=\u00101\u001a\u0004\b@\u0010\u0010R%\u0010C\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bB\u0010,\u001a\u0004\bA\u0010\u000bR%\u0010C\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bB\u0010/\u001a\u0004\bD\u0010\u000eR%\u0010C\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bB\u00101\u001a\u0004\bE\u0010\u0010R%\u0010H\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bG\u0010,\u001a\u0004\bF\u0010\u000bR%\u0010H\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bG\u0010/\u001a\u0004\bI\u0010\u000eR%\u0010H\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bG\u00101\u001a\u0004\bJ\u0010\u0010R%\u0010M\u001a\u00020\t*\u00020\b8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bL\u0010,\u001a\u0004\bK\u0010\u000bR%\u0010M\u001a\u00020\t*\u00020\f8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bL\u0010/\u001a\u0004\bN\u0010\u000eR%\u0010M\u001a\u00020\t*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\bL\u00101\u001a\u0004\bO\u0010\u0010R\u001d\u0010P\u001a\u00020\t8\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001d\u0010T\u001a\u00020\t8\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\bT\u0010Q\u001a\u0004\bU\u0010SR \u0010V\u001a\u00020\t8\u0000X\u0080\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bQ\u0010S\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006Y"}, d2 = {"Lkotlin/time/d$a;", "", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "a", "", "Lkotlin/time/d;", "k0", "(I)J", "", "l0", "(J)J", "j0", "(D)J", "b0", "c0", "a0", "e0", "f0", "d0", "r0", "s0", "q0", "h0", "i0", "g0", "Y", "Z", "X", "c", "d", "b", "", "m0", "(Ljava/lang/String;)J", "n0", "p0", "(Ljava/lang/String;)Lkotlin/time/d;", "o0", "L", "getNanoseconds-UwyO8pc$annotations", "(I)V", "nanoseconds", "M", "(J)V", "K", "(D)V", "s", "getMicroseconds-UwyO8pc$annotations", "microseconds", "t", "r", "y", "getMilliseconds-UwyO8pc$annotations", "milliseconds", "z", "x", "R", "getSeconds-UwyO8pc$annotations", "seconds", "S", "Q", "E", "getMinutes-UwyO8pc$annotations", "minutes", "F", "D", "l", "getHours-UwyO8pc$annotations", "hours", "m", "k", "f", "getDays-UwyO8pc$annotations", "days", "g", "e", "ZERO", "J", "W", "()J", "INFINITE", CampaignEx.JSON_KEY_AD_Q, "NEG_INFINITE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @InlineOnly
        public static /* synthetic */ void A(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void B(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void C(long j4) {
        }

        private final long D(double d4) {
            return f.l0(d4, DurationUnit.MINUTES);
        }

        private final long E(int i4) {
            return f.m0(i4, DurationUnit.MINUTES);
        }

        private final long F(long j4) {
            return f.n0(j4, DurationUnit.MINUTES);
        }

        @InlineOnly
        public static /* synthetic */ void G(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void H(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void I(long j4) {
        }

        private final long K(double d4) {
            return f.l0(d4, DurationUnit.NANOSECONDS);
        }

        private final long L(int i4) {
            return f.m0(i4, DurationUnit.NANOSECONDS);
        }

        private final long M(long j4) {
            return f.n0(j4, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void N(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void O(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void P(long j4) {
        }

        private final long Q(double d4) {
            return f.l0(d4, DurationUnit.SECONDS);
        }

        private final long R(int i4) {
            return f.m0(i4, DurationUnit.SECONDS);
        }

        private final long S(long j4) {
            return f.n0(j4, DurationUnit.SECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void T(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void U(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void V(long j4) {
        }

        private final long e(double d4) {
            return f.l0(d4, DurationUnit.DAYS);
        }

        private final long f(int i4) {
            return f.m0(i4, DurationUnit.DAYS);
        }

        private final long g(long j4) {
            return f.n0(j4, DurationUnit.DAYS);
        }

        @InlineOnly
        public static /* synthetic */ void h(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void i(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void j(long j4) {
        }

        private final long k(double d4) {
            return f.l0(d4, DurationUnit.HOURS);
        }

        private final long l(int i4) {
            return f.m0(i4, DurationUnit.HOURS);
        }

        private final long m(long j4) {
            return f.n0(j4, DurationUnit.HOURS);
        }

        @InlineOnly
        public static /* synthetic */ void n(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void o(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void p(long j4) {
        }

        private final long r(double d4) {
            return f.l0(d4, DurationUnit.MICROSECONDS);
        }

        private final long s(int i4) {
            return f.m0(i4, DurationUnit.MICROSECONDS);
        }

        private final long t(long j4) {
            return f.n0(j4, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void u(double d4) {
        }

        @InlineOnly
        public static /* synthetic */ void v(int i4) {
        }

        @InlineOnly
        public static /* synthetic */ void w(long j4) {
        }

        private final long x(double d4) {
            return f.l0(d4, DurationUnit.MILLISECONDS);
        }

        private final long y(int i4) {
            return f.m0(i4, DurationUnit.MILLISECONDS);
        }

        private final long z(long j4) {
            return f.n0(j4, DurationUnit.MILLISECONDS);
        }

        public final long J() {
            return d.f58996e;
        }

        public final long W() {
            return d.f58994c;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long X(double d4) {
            return f.l0(d4, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long Y(int i4) {
            return f.m0(i4, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long Z(long j4) {
            return f.n0(j4, DurationUnit.HOURS);
        }

        @ExperimentalTime
        public final double a(double d4, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            f0.p(sourceUnit, "sourceUnit");
            f0.p(targetUnit, "targetUnit");
            return h.a(d4, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long a0(double d4) {
            return f.l0(d4, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long b(double d4) {
            return f.l0(d4, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long b0(int i4) {
            return f.m0(i4, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long c(int i4) {
            return f.m0(i4, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long c0(long j4) {
            return f.n0(j4, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long d(long j4) {
            return f.n0(j4, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long d0(double d4) {
            return f.l0(d4, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long e0(int i4) {
            return f.m0(i4, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long f0(long j4) {
            return f.n0(j4, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long g0(double d4) {
            return f.l0(d4, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long h0(int i4) {
            return f.m0(i4, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long i0(long j4) {
            return f.n0(j4, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long j0(double d4) {
            return f.l0(d4, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long k0(int i4) {
            return f.m0(i4, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long l0(long j4) {
            return f.n0(j4, DurationUnit.NANOSECONDS);
        }

        public final long m0(@NotNull String value) {
            f0.p(value, "value");
            try {
                return f.h(value, false);
            } catch (IllegalArgumentException e4) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e4);
            }
        }

        public final long n0(@NotNull String value) {
            f0.p(value, "value");
            try {
                return f.h(value, true);
            } catch (IllegalArgumentException e4) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e4);
            }
        }

        @Nullable
        public final d o0(@NotNull String value) {
            f0.p(value, "value");
            try {
                return d.g(f.h(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        public final d p0(@NotNull String value) {
            f0.p(value, "value");
            try {
                return d.g(f.h(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long q() {
            return d.f58995d;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long q0(double d4) {
            return f.l0(d4, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long r0(int i4) {
            return f.m0(i4, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        public final long s0(long j4) {
            return f.n0(j4, DurationUnit.SECONDS);
        }
    }

    private /* synthetic */ d(long j4) {
        this.f58997a = j4;
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void A() {
    }

    public static final double B(long j4) {
        return p0(j4, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void C() {
    }

    public static final double D(long j4) {
        return p0(j4, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void E() {
    }

    public static final double F(long j4) {
        return p0(j4, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void G() {
    }

    public static final double H(long j4) {
        return p0(j4, DurationUnit.SECONDS);
    }

    public static final long K(long j4) {
        return s0(j4, DurationUnit.DAYS);
    }

    public static final long L(long j4) {
        return s0(j4, DurationUnit.HOURS);
    }

    public static final long M(long j4) {
        return s0(j4, DurationUnit.MICROSECONDS);
    }

    public static final long N(long j4) {
        return (c0(j4) && b0(j4)) ? Z(j4) : s0(j4, DurationUnit.MILLISECONDS);
    }

    public static final long O(long j4) {
        return s0(j4, DurationUnit.MINUTES);
    }

    public static final long P(long j4) {
        long Z = Z(j4);
        if (d0(j4)) {
            return Z;
        }
        if (Z > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (Z < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return f.f(Z);
    }

    public static final long Q(long j4) {
        return s0(j4, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void R() {
    }

    public static final int S(long j4) {
        if (e0(j4)) {
            return 0;
        }
        return (int) (O(j4) % 60);
    }

    @PublishedApi
    public static /* synthetic */ void T() {
    }

    public static final int U(long j4) {
        if (e0(j4)) {
            return 0;
        }
        return (int) (c0(j4) ? f.f(Z(j4) % 1000) : Z(j4) % 1000000000);
    }

    @PublishedApi
    public static /* synthetic */ void V() {
    }

    public static final int W(long j4) {
        if (e0(j4)) {
            return 0;
        }
        return (int) (Q(j4) % 60);
    }

    private static final DurationUnit X(long j4) {
        return d0(j4) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final int Y(long j4) {
        return ((int) j4) & 1;
    }

    private static final long Z(long j4) {
        return j4 >> 1;
    }

    public static int a0(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static final boolean b0(long j4) {
        return !e0(j4);
    }

    private static final boolean c0(long j4) {
        return (((int) j4) & 1) == 1;
    }

    private static final boolean d0(long j4) {
        return (((int) j4) & 1) == 0;
    }

    private static final long e(long j4, long j5, long j6) {
        long g4 = f.g(j6);
        long j7 = j5 + g4;
        boolean z3 = false;
        if (-4611686018426L <= j7 && j7 < 4611686018427L) {
            z3 = true;
        }
        if (z3) {
            return f.d(f.f(j7) + (j6 - f.f(g4)));
        }
        return f.b(kotlin.ranges.o.D(j7, -4611686018427387903L, 4611686018427387903L));
    }

    public static final boolean e0(long j4) {
        return j4 == f58995d || j4 == f58996e;
    }

    private static final void f(long j4, StringBuilder sb, int i4, int i5, int i6, String str, boolean z3) {
        String T3;
        sb.append(i4);
        if (i5 != 0) {
            sb.append('.');
            T3 = x.T3(String.valueOf(i5), i6, '0');
            int i7 = -1;
            int length = T3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i8 = length - 1;
                    if (T3.charAt(length) != '0') {
                        i7 = length;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        length = i8;
                    }
                }
            }
            int i9 = i7 + 1;
            if (!z3 && i9 < 3) {
                sb.append((CharSequence) T3, 0, i9);
                f0.o(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) T3, 0, ((i9 + 2) / 3) * 3);
                f0.o(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static final boolean f0(long j4) {
        return j4 < 0;
    }

    public static final /* synthetic */ d g(long j4) {
        return new d(j4);
    }

    public static final boolean g0(long j4) {
        return j4 > 0;
    }

    public static final long h0(long j4, long j5) {
        return i0(j4, y0(j5));
    }

    public static int i(long j4, long j5) {
        long j6 = j4 ^ j5;
        if (j6 < 0 || (((int) j6) & 1) == 0) {
            return f0.u(j4, j5);
        }
        int i4 = (((int) j4) & 1) - (((int) j5) & 1);
        return f0(j4) ? -i4 : i4;
    }

    public static final long i0(long j4, long j5) {
        if (e0(j4)) {
            if (b0(j5) || (j5 ^ j4) >= 0) {
                return j4;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (e0(j5)) {
            return j5;
        } else {
            if ((((int) j4) & 1) == (((int) j5) & 1)) {
                long Z = Z(j4) + Z(j5);
                if (d0(j4)) {
                    return f.e(Z);
                }
                return f.c(Z);
            } else if (c0(j4)) {
                return e(j4, Z(j4), Z(j5));
            } else {
                return e(j4, Z(j5), Z(j4));
            }
        }
    }

    public static long j(long j4) {
        if (e.d()) {
            boolean z3 = true;
            if (d0(j4)) {
                long Z = Z(j4);
                if (!((-4611686018426999999L > Z || Z >= 4611686018427000000L) ? false : false)) {
                    throw new AssertionError(Z(j4) + " ns is out of nanoseconds range");
                }
            } else {
                long Z2 = Z(j4);
                if (-4611686018427387903L <= Z2 && Z2 < 4611686018427387904L) {
                    long Z3 = Z(j4);
                    if ((-4611686018426L > Z3 || Z3 >= 4611686018427L) ? false : false) {
                        throw new AssertionError(Z(j4) + " ms is denormalized");
                    }
                } else {
                    throw new AssertionError(Z(j4) + " ms is out of milliseconds range");
                }
            }
        }
        return j4;
    }

    public static final long j0(long j4, double d4) {
        int I0;
        I0 = kotlin.math.d.I0(d4);
        if (((double) I0) == d4) {
            return k0(j4, I0);
        }
        DurationUnit X = X(j4);
        return f.l0(p0(j4, X) * d4, X);
    }

    public static final double k(long j4, long j5) {
        Comparable O;
        O = kotlin.comparisons.c.O(X(j4), X(j5));
        DurationUnit durationUnit = (DurationUnit) O;
        return p0(j4, durationUnit) / p0(j5, durationUnit);
    }

    public static final long k0(long j4, int i4) {
        int T;
        int S;
        int T2;
        int S2;
        if (e0(j4)) {
            if (i4 != 0) {
                return i4 > 0 ? j4 : y0(j4);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i4 == 0) {
            return f58994c;
        } else {
            long Z = Z(j4);
            long j5 = i4;
            long j6 = Z * j5;
            if (!d0(j4)) {
                if (j6 / j5 == Z) {
                    return f.b(kotlin.ranges.o.E(j6, new kotlin.ranges.n(-4611686018427387903L, 4611686018427387903L)));
                }
                T = kotlin.math.d.T(Z);
                S = kotlin.math.d.S(i4);
                return T * S > 0 ? f58995d : f58996e;
            }
            boolean z3 = false;
            if (Z <= 2147483647L && -2147483647L <= Z) {
                z3 = true;
            }
            if (z3) {
                return f.d(j6);
            }
            if (j6 / j5 == Z) {
                return f.e(j6);
            }
            long g4 = f.g(Z);
            long j7 = g4 * j5;
            long g5 = f.g((Z - f.f(g4)) * j5) + j7;
            if (j7 / j5 == g4 && (g5 ^ j7) >= 0) {
                return f.b(kotlin.ranges.o.E(g5, new kotlin.ranges.n(-4611686018427387903L, 4611686018427387903L)));
            }
            T2 = kotlin.math.d.T(Z);
            S2 = kotlin.math.d.S(i4);
            return T2 * S2 > 0 ? f58995d : f58996e;
        }
    }

    public static final long l(long j4, double d4) {
        int I0;
        I0 = kotlin.math.d.I0(d4);
        if ((((double) I0) == d4) && I0 != 0) {
            return m(j4, I0);
        }
        DurationUnit X = X(j4);
        return f.l0(p0(j4, X) / d4, X);
    }

    public static final <T> T l0(long j4, @NotNull d2.p<? super Long, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.invoke(Long.valueOf(Q(j4)), Integer.valueOf(U(j4)));
    }

    public static final long m(long j4, int i4) {
        int S;
        if (i4 == 0) {
            if (g0(j4)) {
                return f58995d;
            }
            if (f0(j4)) {
                return f58996e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (d0(j4)) {
            return f.d(Z(j4) / i4);
        } else {
            if (e0(j4)) {
                S = kotlin.math.d.S(i4);
                return k0(j4, S);
            }
            long j5 = i4;
            long Z = Z(j4) / j5;
            boolean z3 = false;
            if (-4611686018426L <= Z && Z < 4611686018427L) {
                z3 = true;
            }
            if (z3) {
                return f.d(f.f(Z) + (f.f(Z(j4) - (Z * j5)) / j5));
            }
            return f.b(Z);
        }
    }

    public static final <T> T m0(long j4, @NotNull d2.q<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.invoke(Long.valueOf(O(j4)), Integer.valueOf(W(j4)), Integer.valueOf(U(j4)));
    }

    public static boolean n(long j4, Object obj) {
        return (obj instanceof d) && j4 == ((d) obj).z0();
    }

    public static final <T> T n0(long j4, @NotNull r<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.invoke(Long.valueOf(L(j4)), Integer.valueOf(S(j4)), Integer.valueOf(W(j4)), Integer.valueOf(U(j4)));
    }

    public static final boolean o(long j4, long j5) {
        return j4 == j5;
    }

    public static final <T> T o0(long j4, @NotNull s<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.invoke(Long.valueOf(K(j4)), Integer.valueOf(r(j4)), Integer.valueOf(S(j4)), Integer.valueOf(W(j4)), Integer.valueOf(U(j4)));
    }

    public static final long p(long j4) {
        return f0(j4) ? y0(j4) : j4;
    }

    public static final double p0(long j4, @NotNull DurationUnit unit) {
        f0.p(unit, "unit");
        if (j4 == f58995d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j4 == f58996e) {
            return Double.NEGATIVE_INFINITY;
        }
        return h.a(Z(j4), X(j4), unit);
    }

    @PublishedApi
    public static /* synthetic */ void q() {
    }

    public static final int q0(long j4, @NotNull DurationUnit unit) {
        f0.p(unit, "unit");
        return (int) kotlin.ranges.o.D(s0(j4, unit), -2147483648L, 2147483647L);
    }

    public static final int r(long j4) {
        if (e0(j4)) {
            return 0;
        }
        return (int) (L(j4) % 24);
    }

    @NotNull
    public static final String r0(long j4) {
        StringBuilder sb = new StringBuilder();
        if (f0(j4)) {
            sb.append('-');
        }
        sb.append("PT");
        long p3 = p(j4);
        long L2 = L(p3);
        int S = S(p3);
        int W = W(p3);
        int U = U(p3);
        if (e0(j4)) {
            L2 = 9999999999999L;
        }
        boolean z3 = true;
        boolean z4 = L2 != 0;
        boolean z5 = (W == 0 && U == 0) ? false : true;
        if (S == 0 && (!z5 || !z4)) {
            z3 = false;
        }
        if (z4) {
            sb.append(L2);
            sb.append('H');
        }
        if (z3) {
            sb.append(S);
            sb.append('M');
        }
        if (z5 || (!z4 && !z3)) {
            f(j4, sb, W, U, 9, "S", true);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void s() {
    }

    public static final long s0(long j4, @NotNull DurationUnit unit) {
        f0.p(unit, "unit");
        if (j4 == f58995d) {
            return Long.MAX_VALUE;
        }
        if (j4 == f58996e) {
            return Long.MIN_VALUE;
        }
        return h.b(Z(j4), X(j4), unit);
    }

    public static final double t(long j4) {
        return p0(j4, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    public static final long t0(long j4) {
        return N(j4);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void u() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @ExperimentalTime
    public static final long u0(long j4) {
        return P(j4);
    }

    @NotNull
    public static String v0(long j4) {
        if (j4 == 0) {
            return "0s";
        }
        if (j4 == f58995d) {
            return "Infinity";
        }
        if (j4 == f58996e) {
            return "-Infinity";
        }
        boolean f02 = f0(j4);
        StringBuilder sb = new StringBuilder();
        if (f02) {
            sb.append('-');
        }
        long p3 = p(j4);
        long K = K(p3);
        int r3 = r(p3);
        int S = S(p3);
        int W = W(p3);
        int U = U(p3);
        int i4 = 0;
        boolean z3 = K != 0;
        boolean z4 = r3 != 0;
        boolean z5 = S != 0;
        boolean z6 = (W == 0 && U == 0) ? false : true;
        if (z3) {
            sb.append(K);
            sb.append('d');
            i4 = 1;
        }
        if (z4 || (z3 && (z5 || z6))) {
            int i5 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            sb.append(r3);
            sb.append('h');
            i4 = i5;
        }
        if (z5 || (z6 && (z4 || z3))) {
            int i6 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            sb.append(S);
            sb.append('m');
            i4 = i6;
        }
        if (z6) {
            int i7 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            if (W != 0 || z3 || z4 || z5) {
                f(j4, sb, W, U, 9, "s", false);
            } else if (U >= 1000000) {
                f(j4, sb, U / 1000000, U % 1000000, 6, "ms", false);
            } else if (U >= 1000) {
                f(j4, sb, U / 1000, U % 1000, 3, "us", false);
            } else {
                sb.append(U);
                sb.append("ns");
            }
            i4 = i7;
        }
        if (f02 && i4 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final double w(long j4) {
        return p0(j4, DurationUnit.HOURS);
    }

    @NotNull
    public static final String w0(long j4, @NotNull DurationUnit unit, int i4) {
        f0.p(unit, "unit");
        if (i4 >= 0) {
            double p02 = p0(j4, unit);
            return Double.isInfinite(p02) ? String.valueOf(p02) : f0.C(e.b(p02, kotlin.ranges.o.u(i4, 12)), i.h(unit));
        }
        throw new IllegalArgumentException(f0.C("decimals must be not negative, but was ", Integer.valueOf(i4)).toString());
    }

    public static /* synthetic */ String x0(long j4, DurationUnit durationUnit, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return w0(j4, durationUnit, i4);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void y() {
    }

    public static final long y0(long j4) {
        return f.a(-Z(j4), ((int) j4) & 1);
    }

    public static final double z(long j4) {
        return p0(j4, DurationUnit.MICROSECONDS);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return h(dVar.z0());
    }

    public boolean equals(Object obj) {
        return n(this.f58997a, obj);
    }

    public int h(long j4) {
        return i(this.f58997a, j4);
    }

    public int hashCode() {
        return a0(this.f58997a);
    }

    @NotNull
    public String toString() {
        return v0(this.f58997a);
    }

    public final /* synthetic */ long z0() {
        return this.f58997a;
    }
}
