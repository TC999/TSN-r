package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import io.netty.handler.codec.http.HttpConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Annotations;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.comparisons._ComparisonsJvm;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.C14376d;
import kotlin.ranges.C14418n;
import kotlin.ranges.C14420o;
import kotlin.text.C14579x;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\bH\b\u0087@\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001WB\u0015\b\u0000\u0012\u0006\u0010Y\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0015H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0014J\u001e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0015H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u001b\u0010 \u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u009d\u0001\u0010,\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2u\u0010+\u001aq\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000#H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b,\u0010-J\u0088\u0001\u0010/\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2`\u0010+\u001a\\\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000.H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b/\u00100Js\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2K\u0010+\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u000001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b2\u00103J^\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"26\u0010+\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u000004H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b5\u00106J\u0019\u0010:\u001a\u00020\u00152\n\u00109\u001a\u000607j\u0002`8¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u000b2\n\u00109\u001a\u000607j\u0002`8¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00112\n\u00109\u001a\u000607j\u0002`8¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u000bH\u0007¢\u0006\u0004\b@\u0010\u0007J\u000f\u0010A\u001a\u00020\u000bH\u0007¢\u0006\u0004\bA\u0010\u0007J\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ?\u0010L\u001a\u00020K*\u00060Ej\u0002`F2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u00109\u001a\u00020B2\u0006\u0010J\u001a\u00020\u0002H\u0002¢\u0006\u0004\bL\u0010MJ#\u0010O\u001a\u00020B2\n\u00109\u001a\u000607j\u0002`82\b\b\u0002\u0010N\u001a\u00020\u0011¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020B¢\u0006\u0004\bQ\u0010DJ\u0010\u0010R\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bR\u0010SJ\u001a\u0010U\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010THÖ\u0003¢\u0006\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0007R\u0015\u0010]\u001a\u00020\u00118Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010SR\u0014\u0010`\u001a\u0002078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0017\u0010b\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010\u0007R\u001a\u0010f\u001a\u00020\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\bd\u0010e\u001a\u0004\bc\u0010SR\u001a\u0010i\u001a\u00020\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\bh\u0010e\u001a\u0004\bg\u0010SR\u001a\u0010l\u001a\u00020\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\bk\u0010e\u001a\u0004\bj\u0010SR\u001a\u0010o\u001a\u00020\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\bn\u0010e\u001a\u0004\bm\u0010SR\u001a\u0010s\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\br\u0010e\u001a\u0004\bp\u0010qR\u001a\u0010v\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\bu\u0010e\u001a\u0004\bt\u0010qR\u001a\u0010y\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\bx\u0010e\u001a\u0004\bw\u0010qR\u001a\u0010|\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b{\u0010e\u001a\u0004\bz\u0010qR\u001a\u0010\u007f\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b~\u0010e\u001a\u0004\b}\u0010qR\u001d\u0010\u0082\u0001\u001a\u00020\u00158FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0081\u0001\u0010e\u001a\u0005\b\u0080\u0001\u0010qR\u001d\u0010\u0085\u0001\u001a\u00020\u00158FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0084\u0001\u0010e\u001a\u0005\b\u0083\u0001\u0010qR\u001d\u0010\u0088\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0087\u0001\u0010e\u001a\u0005\b\u0086\u0001\u0010\u0007R\u001d\u0010\u008b\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008a\u0001\u0010e\u001a\u0005\b\u0089\u0001\u0010\u0007R\u001d\u0010\u008e\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008d\u0001\u0010e\u001a\u0005\b\u008c\u0001\u0010\u0007R\u001d\u0010\u0091\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0090\u0001\u0010e\u001a\u0005\b\u008f\u0001\u0010\u0007R\u001d\u0010\u0094\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0093\u0001\u0010e\u001a\u0005\b\u0092\u0001\u0010\u0007R\u001d\u0010\u0097\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0096\u0001\u0010e\u001a\u0005\b\u0095\u0001\u0010\u0007R\u001d\u0010\u009a\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0099\u0001\u0010e\u001a\u0005\b\u0098\u0001\u0010\u0007\u0088\u0001Y\u0092\u0001\u00020\u000bø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u009c\u0001"}, m12616d2 = {"Lkotlin/time/d;", "", "", "f0", "(J)Z", "e0", "A0", "(J)J", AdnName.OTHER, "k0", "(JJ)J", "", "thisMillis", "otherNanos", "d", "(JJJ)J", "j0", "", "scale", "m0", "(JI)J", "", "l0", "(JD)J", C7304t.f25048d, "k", "j", "(JJ)D", "h0", "i0", "g0", "d0", "h", "(JJ)I", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", CcgConstant.f38549t, "q0", "(JLl1/s;)Ljava/lang/Object;", "Lkotlin/Function4;", C7202bq.f24604g, "(JLl1/r;)Ljava/lang/Object;", "Lkotlin/Function3;", "o0", "(JLl1/q;)Ljava/lang/Object;", "Lkotlin/Function2;", "n0", "(JLl1/p;)Ljava/lang/Object;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "r0", "(JLjava/util/concurrent/TimeUnit;)D", "u0", "(JLjava/util/concurrent/TimeUnit;)J", "s0", "(JLjava/util/concurrent/TimeUnit;)I", "w0", "v0", "", "x0", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "Lkotlin/f1;", "e", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "y0", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "t0", "c0", "(J)I", "", "m", "(JLjava/lang/Object;)Z", "a", "J", "rawValue", "b0", DomainCampaignEx.LOOPBACK_VALUE, "a0", "unitDiscriminator", "Z", "(J)Ljava/util/concurrent/TimeUnit;", "storageUnit", "o", "absoluteValue", CampaignEx.JSON_KEY_AD_Q, "getHoursComponent$annotations", "()V", "hoursComponent", "U", "getMinutesComponent$annotations", "minutesComponent", "Y", "getSecondsComponent$annotations", "secondsComponent", ExifInterface.LONGITUDE_WEST, "getNanosecondsComponent$annotations", "nanosecondsComponent", "s", "(J)D", "getInDays$annotations", "inDays", "u", "getInHours$annotations", "inHours", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getInMinutes$annotations", "inMinutes", ExifInterface.LONGITUDE_EAST, "getInSeconds$annotations", "inSeconds", "y", "getInMilliseconds$annotations", "inMilliseconds", IAdInterListener.AdReqParam.WIDTH, "getInMicroseconds$annotations", "inMicroseconds", "C", "getInNanoseconds$annotations", "inNanoseconds", "G", "getInWholeDays$annotations", "inWholeDays", "I", "getInWholeHours$annotations", "inWholeHours", "O", "getInWholeMinutes$annotations", "inWholeMinutes", ExifInterface.LATITUDE_SOUTH, "getInWholeSeconds$annotations", "inWholeSeconds", "M", "getInWholeMilliseconds$annotations", "inWholeMilliseconds", "K", "getInWholeMicroseconds$annotations", "inWholeMicroseconds", "Q", "getInWholeNanoseconds$annotations", "inWholeNanoseconds", "i", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@JvmInline
@ExperimentalTime
/* renamed from: kotlin.time.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Duration implements Comparable<Duration> {

    /* renamed from: a */
    private final long f41659a;
    @NotNull

    /* renamed from: e */
    public static final C14596a f41658e = new C14596a(null);

    /* renamed from: b */
    private static final long f41655b = m6133i(0);

    /* renamed from: c */
    private static final long f41656c = C14597e.m6040b(C14597e.f41662c);

    /* renamed from: d */
    private static final long f41657d = C14597e.m6040b(-4611686018427387903L);

    /* compiled from: Duration.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b3\u00104J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u001d\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u001d\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\fJ\u001d\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000fJ\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u001d\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u000fJ\u001d\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\fJ\u001d\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u000fJ\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0011J\u001d\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\fJ\u001d\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u000fJ\u001d\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0011J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010&J\u001f\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010)R\u001d\u0010+\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010/\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R \u00101\u001a\u00020\n8\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00065"}, m12616d2 = {"Lkotlin/time/d$a;", "", "", DomainCampaignEx.LOOPBACK_VALUE, "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "a", "", "Lkotlin/time/d;", "u", "(I)J", "", "v", "(J)J", UMCommonContent.f37782aL, "(D)J", C7304t.f25048d, "m", "k", "o", "p", "n", "B", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "s", CampaignEx.JSON_KEY_AD_Q, "i", "j", "h", "c", "d", "b", "", IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/String;)J", "x", UMCommonContent.f37777aG, "(Ljava/lang/String;)Lkotlin/time/d;", "y", "ZERO", "J", "g", "()J", "INFINITE", "e", "NEG_INFINITE", "f", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.time.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14596a {
        private C14596a() {
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: A */
        public final long m6097A(double d) {
            return C14597e.m6017m0(d, TimeUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: B */
        public final long m6096B(int i) {
            return C14597e.m6015n0(i, TimeUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: C */
        public final long m6095C(long j) {
            return C14597e.m6013o0(j, TimeUnit.SECONDS);
        }

        /* renamed from: a */
        public final double m6094a(double d, @NotNull TimeUnit sourceUnit, @NotNull TimeUnit targetUnit) {
            C14342f0.m8184p(sourceUnit, "sourceUnit");
            C14342f0.m8184p(targetUnit, "targetUnit");
            return DurationUnitJvm.m6000b(d, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: b */
        public final long m6093b(double d) {
            return C14597e.m6017m0(d, TimeUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: c */
        public final long m6092c(int i) {
            return C14597e.m6015n0(i, TimeUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: d */
        public final long m6091d(long j) {
            return C14597e.m6013o0(j, TimeUnit.DAYS);
        }

        /* renamed from: e */
        public final long m6090e() {
            return Duration.f41656c;
        }

        /* renamed from: f */
        public final long m6089f() {
            return Duration.f41657d;
        }

        /* renamed from: g */
        public final long m6088g() {
            return Duration.f41655b;
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: h */
        public final long m6087h(double d) {
            return C14597e.m6017m0(d, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: i */
        public final long m6086i(int i) {
            return C14597e.m6015n0(i, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: j */
        public final long m6085j(long j) {
            return C14597e.m6013o0(j, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: k */
        public final long m6084k(double d) {
            return C14597e.m6017m0(d, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: l */
        public final long m6083l(int i) {
            return C14597e.m6015n0(i, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: m */
        public final long m6082m(long j) {
            return C14597e.m6013o0(j, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: n */
        public final long m6081n(double d) {
            return C14597e.m6017m0(d, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: o */
        public final long m6080o(int i) {
            return C14597e.m6015n0(i, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: p */
        public final long m6079p(long j) {
            return C14597e.m6013o0(j, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: q */
        public final long m6078q(double d) {
            return C14597e.m6017m0(d, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: r */
        public final long m6077r(int i) {
            return C14597e.m6015n0(i, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: s */
        public final long m6076s(long j) {
            return C14597e.m6013o0(j, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: t */
        public final long m6075t(double d) {
            return C14597e.m6017m0(d, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: u */
        public final long m6074u(int i) {
            return C14597e.m6015n0(i, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: v */
        public final long m6073v(long j) {
            return C14597e.m6013o0(j, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: w */
        public final long m6072w(@NotNull String value) {
            C14342f0.m8184p(value, "value");
            try {
                return C14597e.m6028h(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: x */
        public final long m6071x(@NotNull String value) {
            C14342f0.m8184p(value, "value");
            try {
                return C14597e.m6028h(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        @SinceKotlin(version = "1.5")
        @Nullable
        /* renamed from: y */
        public final Duration m6070y(@NotNull String value) {
            C14342f0.m8184p(value, "value");
            try {
                return Duration.m6139f(C14597e.m6028h(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        @Nullable
        /* renamed from: z */
        public final Duration m6069z(@NotNull String value) {
            C14342f0.m8184p(value, "value");
            try {
                return Duration.m6139f(C14597e.m6028h(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ C14596a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ Duration(long j) {
        this.f41659a = j;
    }

    /* renamed from: A */
    public static final double m6177A(long j) {
        return m6114r0(j, TimeUnit.MINUTES);
    }

    /* renamed from: A0 */
    public static final long m6176A0(long j) {
        return C14597e.m6042a(-m6146b0(j), ((int) j) & 1);
    }

    @Annotations(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    /* renamed from: B */
    public static /* synthetic */ void m6175B() {
    }

    /* renamed from: C */
    public static final double m6173C(long j) {
        return m6114r0(j, TimeUnit.NANOSECONDS);
    }

    @Annotations(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    /* renamed from: D */
    public static /* synthetic */ void m6172D() {
    }

    /* renamed from: E */
    public static final double m6171E(long j) {
        return m6114r0(j, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: F */
    public static /* synthetic */ void m6170F() {
    }

    /* renamed from: G */
    public static final long m6169G(long j) {
        return m6108u0(j, TimeUnit.DAYS);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: H */
    public static /* synthetic */ void m6168H() {
    }

    /* renamed from: I */
    public static final long m6167I(long j) {
        return m6108u0(j, TimeUnit.HOURS);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: J */
    public static /* synthetic */ void m6166J() {
    }

    /* renamed from: K */
    public static final long m6165K(long j) {
        return m6108u0(j, TimeUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: L */
    public static /* synthetic */ void m6164L() {
    }

    /* renamed from: M */
    public static final long m6163M(long j) {
        return (m6140e0(j) && m6142d0(j)) ? m6146b0(j) : m6108u0(j, TimeUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: N */
    public static /* synthetic */ void m6162N() {
    }

    /* renamed from: O */
    public static final long m6161O(long j) {
        return m6108u0(j, TimeUnit.MINUTES);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: P */
    public static /* synthetic */ void m6160P() {
    }

    /* renamed from: Q */
    public static final long m6159Q(long j) {
        long m6146b0 = m6146b0(j);
        if (m6138f0(j)) {
            return m6146b0;
        }
        if (m6146b0 > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (m6146b0 < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return C14597e.m6032f(m6146b0);
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: R */
    public static /* synthetic */ void m6158R() {
    }

    /* renamed from: S */
    public static final long m6157S(long j) {
        return m6108u0(j, TimeUnit.SECONDS);
    }

    @PublishedApi
    /* renamed from: T */
    public static /* synthetic */ void m6156T() {
    }

    /* renamed from: U */
    public static final int m6155U(long j) {
        if (m6136g0(j)) {
            return 0;
        }
        return (int) (m6161O(j) % 60);
    }

    @PublishedApi
    /* renamed from: V */
    public static /* synthetic */ void m6154V() {
    }

    /* renamed from: W */
    public static final int m6153W(long j) {
        if (m6136g0(j)) {
            return 0;
        }
        return (int) (m6140e0(j) ? C14597e.m6032f(m6146b0(j) % 1000) : m6146b0(j) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
    }

    @PublishedApi
    /* renamed from: X */
    public static /* synthetic */ void m6152X() {
    }

    /* renamed from: Y */
    public static final int m6151Y(long j) {
        if (m6136g0(j)) {
            return 0;
        }
        return (int) (m6157S(j) % 60);
    }

    /* renamed from: Z */
    private static final TimeUnit m6150Z(long j) {
        return m6138f0(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: a0 */
    private static final int m6148a0(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: b0 */
    private static final long m6146b0(long j) {
        return j >> 1;
    }

    /* renamed from: c0 */
    public static int m6144c0(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: d */
    private static final long m6143d(long j, long j2, long j3) {
        long m6030g = C14597e.m6030g(j3);
        long j4 = j2 + m6030g;
        if (-4611686018426L <= j4 && 4611686018426L >= j4) {
            return C14597e.m6036d(C14597e.m6032f(j4) + (j3 - C14597e.m6032f(m6030g)));
        }
        return C14597e.m6040b(C14420o.m7581D(j4, -4611686018427387903L, C14597e.f41662c));
    }

    /* renamed from: d0 */
    public static final boolean m6142d0(long j) {
        return !m6136g0(j);
    }

    /* renamed from: e */
    private static final void m6141e(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        String m6472T3;
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            m6472T3 = C14579x.m6472T3(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = m6472T3.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (m6472T3.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (!z && i5 < 3) {
                sb.append((CharSequence) m6472T3, 0, i5);
                C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) m6472T3, 0, ((i5 + 2) / 3) * 3);
                C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: e0 */
    private static final boolean m6140e0(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: f */
    public static final /* synthetic */ Duration m6139f(long j) {
        return new Duration(j);
    }

    /* renamed from: f0 */
    private static final boolean m6138f0(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: g0 */
    public static final boolean m6136g0(long j) {
        return j == f41656c || j == f41657d;
    }

    /* renamed from: h */
    public static int m6135h(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m6134h0(j) ? -i : i;
    }

    /* renamed from: h0 */
    public static final boolean m6134h0(long j) {
        return j < 0;
    }

    /* renamed from: i */
    public static long m6133i(long j) {
        if (m6138f0(j)) {
            long m6146b0 = m6146b0(j);
            if (-4611686018426999999L > m6146b0 || C14597e.f41661b < m6146b0) {
                throw new AssertionError(m6146b0(j) + " ns is out of nanoseconds range");
            }
        } else {
            long m6146b02 = m6146b0(j);
            if (-4611686018427387903L <= m6146b02 && C14597e.f41662c >= m6146b02) {
                long m6146b03 = m6146b0(j);
                if (-4611686018426L <= m6146b03 && 4611686018426L >= m6146b03) {
                    throw new AssertionError(m6146b0(j) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(m6146b0(j) + " ms is out of milliseconds range");
            }
        }
        return j;
    }

    /* renamed from: i0 */
    public static final boolean m6132i0(long j) {
        return j > 0;
    }

    /* renamed from: j */
    public static final double m6131j(long j, long j2) {
        Comparable m8770O;
        m8770O = _ComparisonsJvm.m8770O(m6150Z(j), m6150Z(j2));
        TimeUnit timeUnit = (TimeUnit) m8770O;
        return m6114r0(j, timeUnit) / m6114r0(j2, timeUnit);
    }

    /* renamed from: j0 */
    public static final long m6130j0(long j, long j2) {
        return m6128k0(j, m6176A0(j2));
    }

    /* renamed from: k */
    public static final long m6129k(long j, double d) {
        int m7914G0;
        m7914G0 = C14376d.m7914G0(d);
        if (m7914G0 == d && m7914G0 != 0) {
            return m6127l(j, m7914G0);
        }
        TimeUnit m6150Z = m6150Z(j);
        return C14597e.m6017m0(m6114r0(j, m6150Z) / d, m6150Z);
    }

    /* renamed from: k0 */
    public static final long m6128k0(long j, long j2) {
        if (m6136g0(j)) {
            if (m6142d0(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m6136g0(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m6146b0 = m6146b0(j) + m6146b0(j2);
                if (m6138f0(j)) {
                    return C14597e.m6034e(m6146b0);
                }
                return C14597e.m6038c(m6146b0);
            } else if (m6140e0(j)) {
                return m6143d(j, m6146b0(j), m6146b0(j2));
            } else {
                return m6143d(j, m6146b0(j2), m6146b0(j));
            }
        }
    }

    /* renamed from: l */
    public static final long m6127l(long j, int i) {
        int m7895Q;
        if (i == 0) {
            if (m6132i0(j)) {
                return f41656c;
            }
            if (m6134h0(j)) {
                return f41657d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m6138f0(j)) {
            return C14597e.m6036d(m6146b0(j) / i);
        } else {
            if (m6136g0(j)) {
                m7895Q = C14376d.m7895Q(i);
                return m6124m0(j, m7895Q);
            }
            long j2 = i;
            long m6146b0 = m6146b0(j) / j2;
            if (-4611686018426L <= m6146b0 && 4611686018426L >= m6146b0) {
                return C14597e.m6036d(C14597e.m6032f(m6146b0) + (C14597e.m6032f(m6146b0(j) - (m6146b0 * j2)) / j2));
            }
            return C14597e.m6040b(m6146b0);
        }
    }

    /* renamed from: l0 */
    public static final long m6126l0(long j, double d) {
        int m7914G0;
        m7914G0 = C14376d.m7914G0(d);
        if (m7914G0 == d) {
            return m6124m0(j, m7914G0);
        }
        TimeUnit m6150Z = m6150Z(j);
        return C14597e.m6017m0(m6114r0(j, m6150Z) * d, m6150Z);
    }

    /* renamed from: m */
    public static boolean m6125m(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m6174B0();
    }

    /* renamed from: m0 */
    public static final long m6124m0(long j, int i) {
        int m7893R;
        int m7895Q;
        int m7893R2;
        int m7895Q2;
        if (m6136g0(j)) {
            if (i != 0) {
                return i > 0 ? j : m6176A0(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return f41655b;
        } else {
            long m6146b0 = m6146b0(j);
            long j2 = i;
            long j3 = m6146b0 * j2;
            if (!m6138f0(j)) {
                if (j3 / j2 == m6146b0) {
                    return C14597e.m6040b(C14420o.m7580E(j3, new C14418n(-4611686018427387903L, C14597e.f41662c)));
                }
                m7893R = C14376d.m7893R(m6146b0);
                m7895Q = C14376d.m7895Q(i);
                return m7893R * m7895Q > 0 ? f41656c : f41657d;
            } else if (-2147483647L <= m6146b0 && 2147483647L >= m6146b0) {
                return C14597e.m6036d(j3);
            } else {
                if (j3 / j2 == m6146b0) {
                    return C14597e.m6034e(j3);
                }
                long m6030g = C14597e.m6030g(m6146b0);
                long j4 = m6030g * j2;
                long m6030g2 = C14597e.m6030g((m6146b0 - C14597e.m6032f(m6030g)) * j2) + j4;
                if (j4 / j2 == m6030g && (m6030g2 ^ j4) >= 0) {
                    return C14597e.m6040b(C14420o.m7580E(m6030g2, new C14418n(-4611686018427387903L, C14597e.f41662c)));
                }
                m7893R2 = C14376d.m7893R(m6146b0);
                m7895Q2 = C14376d.m7895Q(i);
                return m7893R2 * m7895Q2 > 0 ? f41656c : f41657d;
            }
        }
    }

    /* renamed from: n */
    public static final boolean m6123n(long j, long j2) {
        return j == j2;
    }

    /* renamed from: n0 */
    public static final <T> T m6122n0(long j, @NotNull InterfaceC15284p<? super Long, ? super Integer, ? extends T> action) {
        C14342f0.m8184p(action, "action");
        return action.invoke(Long.valueOf(m6157S(j)), Integer.valueOf(m6153W(j)));
    }

    /* renamed from: o */
    public static final long m6121o(long j) {
        return m6134h0(j) ? m6176A0(j) : j;
    }

    /* renamed from: o0 */
    public static final <T> T m6120o0(long j, @NotNull InterfaceC15285q<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        C14342f0.m8184p(action, "action");
        return action.invoke(Integer.valueOf(m6112s0(j, TimeUnit.MINUTES)), Integer.valueOf(m6151Y(j)), Integer.valueOf(m6153W(j)));
    }

    @PublishedApi
    /* renamed from: p */
    public static /* synthetic */ void m6119p() {
    }

    /* renamed from: p0 */
    public static final <T> T m6118p0(long j, @NotNull InterfaceC15286r<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        C14342f0.m8184p(action, "action");
        return action.invoke(Integer.valueOf(m6112s0(j, TimeUnit.HOURS)), Integer.valueOf(m6155U(j)), Integer.valueOf(m6151Y(j)), Integer.valueOf(m6153W(j)));
    }

    /* renamed from: q */
    public static final int m6117q(long j) {
        if (m6136g0(j)) {
            return 0;
        }
        return (int) (m6167I(j) % 24);
    }

    /* renamed from: q0 */
    public static final <T> T m6116q0(long j, @NotNull InterfaceC15287s<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        C14342f0.m8184p(action, "action");
        return action.invoke(Integer.valueOf(m6112s0(j, TimeUnit.DAYS)), Integer.valueOf(m6117q(j)), Integer.valueOf(m6155U(j)), Integer.valueOf(m6151Y(j)), Integer.valueOf(m6153W(j)));
    }

    @Annotations(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    /* renamed from: r */
    public static /* synthetic */ void m6115r() {
    }

    /* renamed from: r0 */
    public static final double m6114r0(long j, @NotNull TimeUnit unit) {
        C14342f0.m8184p(unit, "unit");
        if (j == f41656c) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == f41657d) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitJvm.m6000b(m6146b0(j), m6150Z(j), unit);
    }

    /* renamed from: s */
    public static final double m6113s(long j) {
        return m6114r0(j, TimeUnit.DAYS);
    }

    /* renamed from: s0 */
    public static final int m6112s0(long j, @NotNull TimeUnit unit) {
        C14342f0.m8184p(unit, "unit");
        return (int) C14420o.m7581D(m6108u0(j, unit), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Annotations(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    /* renamed from: t */
    public static /* synthetic */ void m6111t() {
    }

    @NotNull
    /* renamed from: t0 */
    public static final String m6110t0(long j) {
        StringBuilder sb = new StringBuilder();
        if (m6134h0(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m6121o = m6121o(j);
        m6112s0(m6121o, TimeUnit.HOURS);
        int m6155U = m6155U(m6121o);
        int m6151Y = m6151Y(m6121o);
        int m6153W = m6153W(m6121o);
        long m6167I = m6167I(m6121o);
        if (m6136g0(j)) {
            m6167I = 9999999999999L;
        }
        boolean z = true;
        boolean z2 = m6167I != 0;
        boolean z3 = (m6151Y == 0 && m6153W == 0) ? false : true;
        if (m6155U == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m6167I);
            sb.append('H');
        }
        if (z) {
            sb.append(m6155U);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m6141e(j, sb, m6151Y, m6153W, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: u */
    public static final double m6109u(long j) {
        return m6114r0(j, TimeUnit.HOURS);
    }

    /* renamed from: u0 */
    public static final long m6108u0(long j, @NotNull TimeUnit unit) {
        C14342f0.m8184p(unit, "unit");
        if (j == f41656c) {
            return Long.MAX_VALUE;
        }
        if (j == f41657d) {
            return Long.MIN_VALUE;
        }
        return DurationUnitJvm.m5999c(m6146b0(j), m6150Z(j), unit);
    }

    @Annotations(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    /* renamed from: v */
    public static /* synthetic */ void m6107v() {
    }

    @Annotations(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: v0 */
    public static final long m6106v0(long j) {
        return m6163M(j);
    }

    /* renamed from: w */
    public static final double m6105w(long j) {
        return m6114r0(j, TimeUnit.MICROSECONDS);
    }

    @Annotations(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: w0 */
    public static final long m6104w0(long j) {
        return m6159Q(j);
    }

    @Annotations(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    /* renamed from: x */
    public static /* synthetic */ void m6103x() {
    }

    @NotNull
    /* renamed from: x0 */
    public static String m6102x0(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == f41656c) {
            return "Infinity";
        }
        if (j == f41657d) {
            return "-Infinity";
        }
        boolean m6134h0 = m6134h0(j);
        StringBuilder sb = new StringBuilder();
        if (m6134h0) {
            sb.append('-');
        }
        long m6121o = m6121o(j);
        m6112s0(m6121o, TimeUnit.DAYS);
        int m6117q = m6117q(m6121o);
        int m6155U = m6155U(m6121o);
        int m6151Y = m6151Y(m6121o);
        int m6153W = m6153W(m6121o);
        long m6169G = m6169G(m6121o);
        int i = 0;
        boolean z = m6169G != 0;
        boolean z2 = m6117q != 0;
        boolean z3 = m6155U != 0;
        boolean z4 = (m6151Y == 0 && m6153W == 0) ? false : true;
        if (z) {
            sb.append(m6169G);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(HttpConstants.SP_CHAR);
            }
            sb.append(m6117q);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(HttpConstants.SP_CHAR);
            }
            sb.append(m6155U);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(HttpConstants.SP_CHAR);
            }
            if (m6151Y != 0 || z || z2 || z3) {
                m6141e(m6121o, sb, m6151Y, m6153W, 9, "s", false);
            } else if (m6153W >= 1000000) {
                m6141e(m6121o, sb, m6153W / 1000000, m6153W % 1000000, 6, "ms", false);
            } else if (m6153W >= 1000) {
                m6141e(m6121o, sb, m6153W / 1000, m6153W % 1000, 3, "us", false);
            } else {
                sb.append(m6153W);
                sb.append("ns");
            }
            i = i4;
        }
        if (m6134h0 && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: y */
    public static final double m6101y(long j) {
        return m6114r0(j, TimeUnit.MILLISECONDS);
    }

    @NotNull
    /* renamed from: y0 */
    public static final String m6100y0(long j, @NotNull TimeUnit unit, int i) {
        C14342f0.m8184p(unit, "unit");
        if (i >= 0) {
            double m6114r0 = m6114r0(j, unit);
            if (Double.isInfinite(m6114r0)) {
                return String.valueOf(m6114r0);
            }
            return formatToDecimals.m5993b(m6114r0, C14420o.m7574u(i, 12)) + DurationUnit.m5995g(unit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }

    @Annotations(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    /* renamed from: z */
    public static /* synthetic */ void m6099z() {
    }

    /* renamed from: z0 */
    public static /* synthetic */ String m6098z0(long j, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m6100y0(j, timeUnit, i);
    }

    /* renamed from: B0 */
    public final /* synthetic */ long m6174B0() {
        return this.f41659a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m6137g(duration.m6174B0());
    }

    public boolean equals(Object obj) {
        return m6125m(this.f41659a, obj);
    }

    /* renamed from: g */
    public int m6137g(long j) {
        return m6135h(this.f41659a, j);
    }

    public int hashCode() {
        return m6144c0(this.f41659a);
    }

    @NotNull
    public String toString() {
        return m6102x0(this.f41659a);
    }
}
