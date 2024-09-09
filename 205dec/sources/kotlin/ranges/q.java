package kotlin.ranges;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.random.Random;
import kotlin.ranges.a;
import kotlin.ranges.i;
import kotlin.ranges.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: _Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000f\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0087\b\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0014\u0010\f\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0004*\u00020\u0003H\u0087\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0087\b\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\n\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u001e\u001a\u00020\u001b*\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0087\n\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010 \u001a\u00020\u001b*\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\n\u00a2\u0006\u0004\b \u0010!\u001a\"\u0010%\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b%\u0010&\u001a\"\u0010'\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b'\u0010&\u001a\"\u0010)\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b)\u0010&\u001a\"\u0010+\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b+\u0010&\u001a\"\u0010-\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b-\u0010&\u001a\"\u0010.\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002\u00a2\u0006\u0004\b.\u0010/\u001a\"\u00100\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002\u00a2\u0006\u0004\b0\u0010/\u001a\"\u00101\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002\u00a2\u0006\u0004\b1\u0010/\u001a\"\u00102\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002\u00a2\u0006\u0004\b2\u0010/\u001a\"\u00103\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002\u00a2\u0006\u0004\b3\u0010/\u001a\"\u00104\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002\u00a2\u0006\u0004\b4\u00105\u001a\"\u00106\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002\u00a2\u0006\u0004\b6\u00105\u001a\"\u00107\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002\u00a2\u0006\u0004\b7\u00105\u001a\"\u00108\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002\u00a2\u0006\u0004\b8\u00105\u001a\"\u00109\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002\u00a2\u0006\u0004\b9\u00105\u001a\"\u0010:\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b:\u0010;\u001a\"\u0010<\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b<\u0010;\u001a\"\u0010=\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b=\u0010;\u001a\"\u0010>\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b>\u0010;\u001a\"\u0010?\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b?\u0010;\u001a\"\u0010@\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\b@\u0010A\u001a\"\u0010B\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\bB\u0010A\u001a\"\u0010C\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\bC\u0010A\u001a\"\u0010D\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\bD\u0010A\u001a\"\u0010E\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\bE\u0010A\u001a\"\u0010F\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002\u00a2\u0006\u0004\bF\u0010G\u001a\"\u0010H\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002\u00a2\u0006\u0004\bH\u0010G\u001a\"\u0010I\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002\u00a2\u0006\u0004\bI\u0010G\u001a\"\u0010J\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002\u00a2\u0006\u0004\bJ\u0010G\u001a\"\u0010K\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002\u00a2\u0006\u0004\bK\u0010G\u001a\u0015\u0010N\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010Q\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010R\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010T\u001a\u00020S*\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0086\u0004\u001a\u0015\u0010U\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010V\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010W\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010X\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010Y\u001a\u00020O*\u00020\u00012\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010Z\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010[\u001a\u00020O*\u00020#2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010\\\u001a\u00020O*\u00020(2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010]\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010^\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010_\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010`\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\n\u0010a\u001a\u00020M*\u00020M\u001a\n\u0010b\u001a\u00020O*\u00020O\u001a\n\u0010c\u001a\u00020S*\u00020S\u001a\u0015\u0010e\u001a\u00020M*\u00020M2\u0006\u0010d\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010f\u001a\u00020O*\u00020O2\u0006\u0010d\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010g\u001a\u00020S*\u00020S2\u0006\u0010d\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010h\u001a\u0004\u0018\u00010#*\u00020\u0001H\u0000\u00a2\u0006\u0004\bh\u0010i\u001a\u0015\u0010j\u001a\u0004\u0018\u00010#*\u00020\u0004H\u0000\u00a2\u0006\u0004\bj\u0010k\u001a\u0015\u0010l\u001a\u0004\u0018\u00010#*\u00020(H\u0000\u00a2\u0006\u0004\bl\u0010m\u001a\u0015\u0010n\u001a\u0004\u0018\u00010#*\u00020*H\u0000\u00a2\u0006\u0004\bn\u0010o\u001a\u0015\u0010p\u001a\u0004\u0018\u00010#*\u00020,H\u0000\u00a2\u0006\u0004\bp\u0010q\u001a\u0015\u0010r\u001a\u0004\u0018\u00010\u0001*\u00020\u0004H\u0000\u00a2\u0006\u0004\br\u0010s\u001a\u0015\u0010t\u001a\u0004\u0018\u00010\u0001*\u00020*H\u0000\u00a2\u0006\u0004\bt\u0010u\u001a\u0015\u0010v\u001a\u0004\u0018\u00010\u0001*\u00020,H\u0000\u00a2\u0006\u0004\bv\u0010w\u001a\u0015\u0010x\u001a\u0004\u0018\u00010\u0004*\u00020*H\u0000\u00a2\u0006\u0004\bx\u0010y\u001a\u0015\u0010z\u001a\u0004\u0018\u00010\u0004*\u00020,H\u0000\u00a2\u0006\u0004\bz\u0010{\u001a\u0015\u0010|\u001a\u0004\u0018\u00010(*\u00020\u0001H\u0000\u00a2\u0006\u0004\b|\u0010}\u001a\u0015\u0010~\u001a\u0004\u0018\u00010(*\u00020\u0004H\u0000\u00a2\u0006\u0004\b~\u0010\u007f\u001a\u0018\u0010\u0080\u0001\u001a\u0004\u0018\u00010(*\u00020*H\u0000\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0018\u0010\u0082\u0001\u001a\u0004\u0018\u00010(*\u00020,H\u0000\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0016\u0010\u0084\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0085\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0086\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0087\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0088\u0001\u001a\u00020\u0006*\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0086\u0004\u001a\u0016\u0010\u0089\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008a\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008b\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008c\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008d\u0001\u001a\u00020\u0003*\u00020\u00012\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u008e\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u008f\u0001\u001a\u00020\u0003*\u00020#2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u0090\u0001\u001a\u00020\u0003*\u00020(2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u0091\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0092\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0093\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0094\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a.\u0010\u0097\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u0007\u0010\u0096\u0001\u001a\u00028\u0000\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0014\u0010\u0099\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u0096\u0001\u001a\u00020#\u001a\u0014\u0010\u009a\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u0096\u0001\u001a\u00020(\u001a\u0014\u0010\u009b\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u009c\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u0004\u001a\u0014\u0010\u009d\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u0096\u0001\u001a\u00020,\u001a\u0014\u0010\u009e\u0001\u001a\u00020**\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*\u001a.\u0010\u00a0\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u0007\u0010\u009f\u0001\u001a\u00028\u0000\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u0098\u0001\u001a\u0014\u0010\u00a1\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u009f\u0001\u001a\u00020#\u001a\u0014\u0010\u00a2\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u009f\u0001\u001a\u00020(\u001a\u0014\u0010\u00a3\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u00a4\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0004\u001a\u0014\u0010\u00a5\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u009f\u0001\u001a\u00020,\u001a\u0014\u0010\u00a6\u0001\u001a\u00020**\u00020*2\u0007\u0010\u009f\u0001\u001a\u00020*\u001a;\u0010\u00a7\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\t\u0010\u0096\u0001\u001a\u0004\u0018\u00018\u00002\t\u0010\u009f\u0001\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u001a\u001d\u0010\u00a9\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u0096\u0001\u001a\u00020#2\u0007\u0010\u009f\u0001\u001a\u00020#\u001a\u001d\u0010\u00aa\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u0096\u0001\u001a\u00020(2\u0007\u0010\u009f\u0001\u001a\u00020(\u001a\u001d\u0010\u00ab\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0001\u001a\u001d\u0010\u00ac\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0004\u001a\u001d\u0010\u00ad\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u009f\u0001\u001a\u00020,\u001a\u001d\u0010\u00ae\u0001\u001a\u00020**\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u009f\u0001\u001a\u00020*\u001a7\u0010\u00b1\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u000e\u0010\u00b0\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00af\u0001H\u0007\u00a2\u0006\u0006\b\u00b1\u0001\u0010\u00b2\u0001\u001a4\u0010\u00b3\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\r\u0010\u00b0\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\"\u00a2\u0006\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u001a\u001a\u0010\u00b5\u0001\u001a\u00020\u0001*\u00020\u00012\r\u0010\u00b0\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\"\u001a\u001a\u0010\u00b6\u0001\u001a\u00020\u0004*\u00020\u00042\r\u0010\u00b0\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\"\u00a8\u0006\u00b7\u0001"}, d2 = {"Lkotlin/ranges/k;", "", "z0", "Lkotlin/ranges/n;", "", "B0", "Lkotlin/ranges/c;", "", "x0", "Lkotlin/random/Random;", "random", "A0", "C0", "y0", "F0", "(Lkotlin/ranges/k;)Ljava/lang/Integer;", "H0", "(Lkotlin/ranges/n;)Ljava/lang/Long;", "D0", "(Lkotlin/ranges/c;)Ljava/lang/Character;", "G0", "(Lkotlin/ranges/k;Lkotlin/random/Random;)Ljava/lang/Integer;", "I0", "(Lkotlin/ranges/n;Lkotlin/random/Random;)Ljava/lang/Long;", "E0", "(Lkotlin/ranges/c;Lkotlin/random/Random;)Ljava/lang/Character;", "element", "", "K", "(Lkotlin/ranges/k;Ljava/lang/Integer;)Z", "L", "(Lkotlin/ranges/n;Ljava/lang/Long;)Z", "J", "(Lkotlin/ranges/c;Ljava/lang/Character;)Z", "Lkotlin/ranges/g;", "", "value", "n0", "(Lkotlin/ranges/g;B)Z", "s0", "", "M0", "", "M", "", "i0", "o0", "(Lkotlin/ranges/g;D)Z", "t0", "f", "N0", "j0", "p0", "(Lkotlin/ranges/g;F)Z", "u0", "g", "O0", "N", "v0", "(Lkotlin/ranges/g;I)Z", "h", "P0", "O", "k0", "q0", "(Lkotlin/ranges/g;J)Z", "i", "Q0", "P", "l0", "r0", "(Lkotlin/ranges/g;S)Z", "w0", "j", "Q", "m0", "to", "Lkotlin/ranges/i;", "V", "Lkotlin/ranges/l;", "d0", "S", "Y", "Lkotlin/ranges/a;", "R", "W", "e0", "T", "Z", "c0", "f0", "b0", "h0", "X", "g0", "U", "a0", "K0", "L0", "J0", "step", "S0", "T0", "R0", "W0", "(I)Ljava/lang/Byte;", "X0", "(J)Ljava/lang/Byte;", "Y0", "(S)Ljava/lang/Byte;", "U0", "(D)Ljava/lang/Byte;", "V0", "(F)Ljava/lang/Byte;", "b1", "(J)Ljava/lang/Integer;", "Z0", "(D)Ljava/lang/Integer;", "a1", "(F)Ljava/lang/Integer;", "c1", "(D)Ljava/lang/Long;", "d1", "(F)Ljava/lang/Long;", "g1", "(I)Ljava/lang/Short;", "h1", "(J)Ljava/lang/Short;", "e1", "(D)Ljava/lang/Short;", "f1", "(F)Ljava/lang/Short;", "m1", "u1", "j1", "p1", "i1", "n1", EventMonitor.V1_STAGING_ADLOG, "k1", "q1", "t1", "w1", "s1", "y1", "o1", "x1", "l1", "r1", "", "minimumValue", "p", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "k", CampaignEx.JSON_KEY_AD_Q, "n", "o", "m", "l", "maximumValue", "w", "r", "x", "u", "v", "t", "s", "F", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "y", "I", "B", "D", "A", "z", "Lkotlin/ranges/f;", "range", "G", "(Ljava/lang/Comparable;Lkotlin/ranges/f;)Ljava/lang/Comparable;", "H", "(Ljava/lang/Comparable;Lkotlin/ranges/g;)Ljava/lang/Comparable;", "C", "E", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/ranges/RangesKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q extends p {
    public static final float A(float f4, float f5, float f6) {
        if (f5 <= f6) {
            return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f6 + " is less than minimum " + f5 + '.');
    }

    @SinceKotlin(version = "1.3")
    public static final int A0(@NotNull k kVar, @NotNull Random random) {
        f0.p(kVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.f.h(random, kVar);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    public static int B(int i4, int i5, int i6) {
        if (i5 <= i6) {
            return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i6 + " is less than minimum " + i5 + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long B0(n nVar) {
        f0.p(nVar, "<this>");
        return C0(nVar, Random.Default);
    }

    public static final int C(int i4, @NotNull g<Integer> range) {
        f0.p(range, "range");
        if (range instanceof f) {
            return ((Number) G(Integer.valueOf(i4), (f) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i4 < range.getStart().intValue() ? range.getStart().intValue() : i4 > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    public static final long C0(@NotNull n nVar, @NotNull Random random) {
        f0.p(nVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.f.i(random, nVar);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    public static long D(long j4, long j5, long j6) {
        if (j5 <= j6) {
            return j4 < j5 ? j5 : j4 > j6 ? j6 : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j6 + " is less than minimum " + j5 + '.');
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Character D0(c cVar) {
        f0.p(cVar, "<this>");
        return E0(cVar, Random.Default);
    }

    public static long E(long j4, @NotNull g<Long> range) {
        f0.p(range, "range");
        if (range instanceof f) {
            return ((Number) G(Long.valueOf(j4), (f) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j4 < range.getStart().longValue() ? range.getStart().longValue() : j4 > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character E0(@NotNull c cVar, @NotNull Random random) {
        f0.p(cVar, "<this>");
        f0.p(random, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(cVar.c(), cVar.g() + 1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T F(@NotNull T t3, @Nullable T t4, @Nullable T t5) {
        f0.p(t3, "<this>");
        if (t4 != null && t5 != null) {
            if (t4.compareTo(t5) <= 0) {
                if (t3.compareTo(t4) < 0) {
                    return t4;
                }
                if (t3.compareTo(t5) > 0) {
                    return t5;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t5 + " is less than minimum " + t4 + '.');
            }
        } else if (t4 != null && t3.compareTo(t4) < 0) {
            return t4;
        } else {
            if (t5 != null && t3.compareTo(t5) > 0) {
                return t5;
            }
        }
        return t3;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Integer F0(k kVar) {
        f0.p(kVar, "<this>");
        return G0(kVar, Random.Default);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T G(@NotNull T t3, @NotNull f<T> range) {
        f0.p(t3, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            return (!range.a(t3, range.getStart()) || range.a(range.getStart(), t3)) ? (!range.a(range.getEndInclusive(), t3) || range.a(t3, range.getEndInclusive())) ? t3 : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer G0(@NotNull k kVar, @NotNull Random random) {
        f0.p(kVar, "<this>");
        f0.p(random, "random");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kotlin.random.f.h(random, kVar));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T H(@NotNull T t3, @NotNull g<T> range) {
        f0.p(t3, "<this>");
        f0.p(range, "range");
        if (range instanceof f) {
            return (T) G(t3, (f) range);
        }
        if (!range.isEmpty()) {
            return t3.compareTo(range.getStart()) < 0 ? range.getStart() : t3.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : t3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Long H0(n nVar) {
        f0.p(nVar, "<this>");
        return I0(nVar, Random.Default);
    }

    public static final short I(short s3, short s4, short s5) {
        if (s4 <= s5) {
            return s3 < s4 ? s4 : s3 > s5 ? s5 : s3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s5) + " is less than minimum " + ((int) s4) + '.');
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long I0(@NotNull n nVar, @NotNull Random random) {
        f0.p(nVar, "<this>");
        f0.p(random, "random");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(kotlin.random.f.i(random, nVar));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean J(c cVar, Character ch) {
        f0.p(cVar, "<this>");
        return ch != null && cVar.n(ch.charValue());
    }

    @NotNull
    public static final a J0(@NotNull a aVar) {
        f0.p(aVar, "<this>");
        return a.f55776d.a(aVar.g(), aVar.c(), -aVar.k());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean K(k kVar, Integer num) {
        f0.p(kVar, "<this>");
        return num != null && kVar.n(num.intValue());
    }

    @NotNull
    public static final i K0(@NotNull i iVar) {
        f0.p(iVar, "<this>");
        return i.f55792d.a(iVar.g(), iVar.c(), -iVar.k());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean L(n nVar, Long l4) {
        f0.p(nVar, "<this>");
        return l4 != null && nVar.n(l4.longValue());
    }

    @NotNull
    public static final l L0(@NotNull l lVar) {
        f0.p(lVar, "<this>");
        return l.f55802d.a(lVar.g(), lVar.c(), -lVar.k());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean M(g gVar, byte b4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(b4));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean M0(@NotNull g<Short> gVar, byte b4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Short.valueOf(b4));
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean N(@NotNull g<Double> gVar, float f4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(f4));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean N0(g gVar, double d4) {
        f0.p(gVar, "<this>");
        Short e12 = e1(d4);
        if (e12 != null) {
            return gVar.contains(e12);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean O(g gVar, int i4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(i4));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean O0(g gVar, float f4) {
        f0.p(gVar, "<this>");
        Short f12 = f1(f4);
        if (f12 != null) {
            return gVar.contains(f12);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean P(g gVar, long j4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(j4));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean P0(@NotNull g<Short> gVar, int i4) {
        f0.p(gVar, "<this>");
        Short g12 = g1(i4);
        if (g12 != null) {
            return gVar.contains(g12);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean Q(g gVar, short s3) {
        f0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(s3));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean Q0(@NotNull g<Short> gVar, long j4) {
        f0.p(gVar, "<this>");
        Short h12 = h1(j4);
        if (h12 != null) {
            return gVar.contains(h12);
        }
        return false;
    }

    @NotNull
    public static final a R(char c4, char c5) {
        return a.f55776d.a(c4, c5, -1);
    }

    @NotNull
    public static final a R0(@NotNull a aVar, int i4) {
        f0.p(aVar, "<this>");
        p.a(i4 > 0, Integer.valueOf(i4));
        a.C1104a c1104a = a.f55776d;
        char c4 = aVar.c();
        char g4 = aVar.g();
        if (aVar.k() <= 0) {
            i4 = -i4;
        }
        return c1104a.a(c4, g4, i4);
    }

    @NotNull
    public static final i S(byte b4, byte b5) {
        return i.f55792d.a(b4, b5, -1);
    }

    @NotNull
    public static i S0(@NotNull i iVar, int i4) {
        f0.p(iVar, "<this>");
        p.a(i4 > 0, Integer.valueOf(i4));
        i.a aVar = i.f55792d;
        int c4 = iVar.c();
        int g4 = iVar.g();
        if (iVar.k() <= 0) {
            i4 = -i4;
        }
        return aVar.a(c4, g4, i4);
    }

    @NotNull
    public static final i T(byte b4, int i4) {
        return i.f55792d.a(b4, i4, -1);
    }

    @NotNull
    public static final l T0(@NotNull l lVar, long j4) {
        f0.p(lVar, "<this>");
        p.a(j4 > 0, Long.valueOf(j4));
        l.a aVar = l.f55802d;
        long c4 = lVar.c();
        long g4 = lVar.g();
        if (lVar.k() <= 0) {
            j4 = -j4;
        }
        return aVar.a(c4, g4, j4);
    }

    @NotNull
    public static final i U(byte b4, short s3) {
        return i.f55792d.a(b4, s3, -1);
    }

    @Nullable
    public static final Byte U0(double d4) {
        boolean z3 = false;
        if (d4 <= 127.0d && -128.0d <= d4) {
            z3 = true;
        }
        if (z3) {
            return Byte.valueOf((byte) d4);
        }
        return null;
    }

    @NotNull
    public static final i V(int i4, byte b4) {
        return i.f55792d.a(i4, b4, -1);
    }

    @Nullable
    public static final Byte V0(float f4) {
        boolean z3 = false;
        if (f4 <= 127.0f && -128.0f <= f4) {
            z3 = true;
        }
        if (z3) {
            return Byte.valueOf((byte) f4);
        }
        return null;
    }

    @NotNull
    public static i W(int i4, int i5) {
        return i.f55792d.a(i4, i5, -1);
    }

    @Nullable
    public static final Byte W0(int i4) {
        boolean z3 = false;
        if (i4 <= 127 && -128 <= i4) {
            z3 = true;
        }
        if (z3) {
            return Byte.valueOf((byte) i4);
        }
        return null;
    }

    @NotNull
    public static final i X(int i4, short s3) {
        return i.f55792d.a(i4, s3, -1);
    }

    @Nullable
    public static final Byte X0(long j4) {
        boolean z3 = false;
        if (j4 <= 127 && -128 <= j4) {
            z3 = true;
        }
        if (z3) {
            return Byte.valueOf((byte) j4);
        }
        return null;
    }

    @NotNull
    public static final i Y(short s3, byte b4) {
        return i.f55792d.a(s3, b4, -1);
    }

    @Nullable
    public static final Byte Y0(short s3) {
        boolean z3 = false;
        if (-128 <= s3 && s3 <= 127) {
            z3 = true;
        }
        if (z3) {
            return Byte.valueOf((byte) s3);
        }
        return null;
    }

    @NotNull
    public static final i Z(short s3, int i4) {
        return i.f55792d.a(s3, i4, -1);
    }

    @Nullable
    public static final Integer Z0(double d4) {
        boolean z3 = false;
        if (d4 <= 2.147483647E9d && -2.147483648E9d <= d4) {
            z3 = true;
        }
        if (z3) {
            return Integer.valueOf((int) d4);
        }
        return null;
    }

    @NotNull
    public static final i a0(short s3, short s4) {
        return i.f55792d.a(s3, s4, -1);
    }

    @Nullable
    public static final Integer a1(float f4) {
        boolean z3 = false;
        if (f4 <= 2.1474836E9f && -2.1474836E9f <= f4) {
            z3 = true;
        }
        if (z3) {
            return Integer.valueOf((int) f4);
        }
        return null;
    }

    @NotNull
    public static final l b0(byte b4, long j4) {
        return l.f55802d.a(b4, j4, -1L);
    }

    @Nullable
    public static final Integer b1(long j4) {
        boolean z3 = false;
        if (j4 <= 2147483647L && -2147483648L <= j4) {
            z3 = true;
        }
        if (z3) {
            return Integer.valueOf((int) j4);
        }
        return null;
    }

    @NotNull
    public static final l c0(int i4, long j4) {
        return l.f55802d.a(i4, j4, -1L);
    }

    @Nullable
    public static final Long c1(double d4) {
        boolean z3 = false;
        if (d4 <= 9.223372036854776E18d && -9.223372036854776E18d <= d4) {
            z3 = true;
        }
        if (z3) {
            return Long.valueOf((long) d4);
        }
        return null;
    }

    @NotNull
    public static final l d0(long j4, byte b4) {
        return l.f55802d.a(j4, b4, -1L);
    }

    @Nullable
    public static final Long d1(float f4) {
        boolean z3 = false;
        if (f4 <= 9.223372E18f && -9.223372E18f <= f4) {
            z3 = true;
        }
        if (z3) {
            return Long.valueOf(f4);
        }
        return null;
    }

    @NotNull
    public static final l e0(long j4, int i4) {
        return l.f55802d.a(j4, i4, -1L);
    }

    @Nullable
    public static final Short e1(double d4) {
        boolean z3 = false;
        if (d4 <= 32767.0d && -32768.0d <= d4) {
            z3 = true;
        }
        if (z3) {
            return Short.valueOf((short) d4);
        }
        return null;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean f(g gVar, double d4) {
        f0.p(gVar, "<this>");
        Byte U0 = U0(d4);
        if (U0 != null) {
            return gVar.contains(U0);
        }
        return false;
    }

    @NotNull
    public static final l f0(long j4, long j5) {
        return l.f55802d.a(j4, j5, -1L);
    }

    @Nullable
    public static final Short f1(float f4) {
        boolean z3 = false;
        if (f4 <= 32767.0f && -32768.0f <= f4) {
            z3 = true;
        }
        if (z3) {
            return Short.valueOf((short) f4);
        }
        return null;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean g(g gVar, float f4) {
        f0.p(gVar, "<this>");
        Byte V0 = V0(f4);
        if (V0 != null) {
            return gVar.contains(V0);
        }
        return false;
    }

    @NotNull
    public static final l g0(long j4, short s3) {
        return l.f55802d.a(j4, s3, -1L);
    }

    @Nullable
    public static final Short g1(int i4) {
        boolean z3 = false;
        if (i4 <= 32767 && -32768 <= i4) {
            z3 = true;
        }
        if (z3) {
            return Short.valueOf((short) i4);
        }
        return null;
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean h(@NotNull g<Byte> gVar, int i4) {
        f0.p(gVar, "<this>");
        Byte W0 = W0(i4);
        if (W0 != null) {
            return gVar.contains(W0);
        }
        return false;
    }

    @NotNull
    public static final l h0(short s3, long j4) {
        return l.f55802d.a(s3, j4, -1L);
    }

    @Nullable
    public static final Short h1(long j4) {
        boolean z3 = false;
        if (j4 <= 32767 && -32768 <= j4) {
            z3 = true;
        }
        if (z3) {
            return Short.valueOf((short) j4);
        }
        return null;
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean i(@NotNull g<Byte> gVar, long j4) {
        f0.p(gVar, "<this>");
        Byte X0 = X0(j4);
        if (X0 != null) {
            return gVar.contains(X0);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean i0(g gVar, byte b4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(b4));
    }

    @NotNull
    public static final c i1(char c4, char c5) {
        return f0.t(c5, 0) <= 0 ? c.f55784e.a() : new c(c4, (char) (c5 - 1));
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean j(@NotNull g<Byte> gVar, short s3) {
        f0.p(gVar, "<this>");
        Byte Y0 = Y0(s3);
        if (Y0 != null) {
            return gVar.contains(Y0);
        }
        return false;
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean j0(@NotNull g<Float> gVar, double d4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf((float) d4));
    }

    @NotNull
    public static final k j1(byte b4, byte b5) {
        return new k(b4, b5 - 1);
    }

    public static final byte k(byte b4, byte b5) {
        return b4 < b5 ? b5 : b4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean k0(g gVar, int i4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(i4));
    }

    @NotNull
    public static final k k1(byte b4, int i4) {
        if (i4 <= Integer.MIN_VALUE) {
            return k.f55800e.a();
        }
        return new k(b4, i4 - 1);
    }

    public static final double l(double d4, double d5) {
        return d4 < d5 ? d5 : d4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean l0(g gVar, long j4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf((float) j4));
    }

    @NotNull
    public static final k l1(byte b4, short s3) {
        return new k(b4, s3 - 1);
    }

    public static final float m(float f4, float f5) {
        return f4 < f5 ? f5 : f4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean m0(g gVar, short s3) {
        f0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(s3));
    }

    @NotNull
    public static final k m1(int i4, byte b4) {
        return new k(i4, b4 - 1);
    }

    public static int n(int i4, int i5) {
        return i4 < i5 ? i5 : i4;
    }

    @JvmName(name = "intRangeContains")
    public static final boolean n0(@NotNull g<Integer> gVar, byte b4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Integer.valueOf(b4));
    }

    @NotNull
    public static k n1(int i4, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            return k.f55800e.a();
        }
        return new k(i4, i5 - 1);
    }

    public static long o(long j4, long j5) {
        return j4 < j5 ? j5 : j4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean o0(g gVar, double d4) {
        f0.p(gVar, "<this>");
        Integer Z0 = Z0(d4);
        if (Z0 != null) {
            return gVar.contains(Z0);
        }
        return false;
    }

    @NotNull
    public static final k o1(int i4, short s3) {
        return new k(i4, s3 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T p(@NotNull T t3, @NotNull T minimumValue) {
        f0.p(t3, "<this>");
        f0.p(minimumValue, "minimumValue");
        return t3.compareTo(minimumValue) < 0 ? minimumValue : t3;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean p0(g gVar, float f4) {
        f0.p(gVar, "<this>");
        Integer a12 = a1(f4);
        if (a12 != null) {
            return gVar.contains(a12);
        }
        return false;
    }

    @NotNull
    public static final k p1(short s3, byte b4) {
        return new k(s3, b4 - 1);
    }

    public static final short q(short s3, short s4) {
        return s3 < s4 ? s4 : s3;
    }

    @JvmName(name = "intRangeContains")
    public static final boolean q0(@NotNull g<Integer> gVar, long j4) {
        f0.p(gVar, "<this>");
        Integer b12 = b1(j4);
        if (b12 != null) {
            return gVar.contains(b12);
        }
        return false;
    }

    @NotNull
    public static final k q1(short s3, int i4) {
        if (i4 <= Integer.MIN_VALUE) {
            return k.f55800e.a();
        }
        return new k(s3, i4 - 1);
    }

    public static final byte r(byte b4, byte b5) {
        return b4 > b5 ? b5 : b4;
    }

    @JvmName(name = "intRangeContains")
    public static final boolean r0(@NotNull g<Integer> gVar, short s3) {
        f0.p(gVar, "<this>");
        return gVar.contains(Integer.valueOf(s3));
    }

    @NotNull
    public static final k r1(short s3, short s4) {
        return new k(s3, s4 - 1);
    }

    public static final double s(double d4, double d5) {
        return d4 > d5 ? d5 : d4;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean s0(@NotNull g<Long> gVar, byte b4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(b4));
    }

    @NotNull
    public static final n s1(byte b4, long j4) {
        if (j4 <= Long.MIN_VALUE) {
            return n.f55810e.a();
        }
        return new n(b4, j4 - 1);
    }

    public static final float t(float f4, float f5) {
        return f4 > f5 ? f5 : f4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean t0(g gVar, double d4) {
        f0.p(gVar, "<this>");
        Long c12 = c1(d4);
        if (c12 != null) {
            return gVar.contains(c12);
        }
        return false;
    }

    @NotNull
    public static final n t1(int i4, long j4) {
        if (j4 <= Long.MIN_VALUE) {
            return n.f55810e.a();
        }
        return new n(i4, j4 - 1);
    }

    public static int u(int i4, int i5) {
        return i4 > i5 ? i5 : i4;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean u0(g gVar, float f4) {
        f0.p(gVar, "<this>");
        Long d12 = d1(f4);
        if (d12 != null) {
            return gVar.contains(d12);
        }
        return false;
    }

    @NotNull
    public static final n u1(long j4, byte b4) {
        return new n(j4, b4 - 1);
    }

    public static long v(long j4, long j5) {
        return j4 > j5 ? j5 : j4;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean v0(@NotNull g<Long> gVar, int i4) {
        f0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(i4));
    }

    @NotNull
    public static final n v1(long j4, int i4) {
        return new n(j4, i4 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T w(@NotNull T t3, @NotNull T maximumValue) {
        f0.p(t3, "<this>");
        f0.p(maximumValue, "maximumValue");
        return t3.compareTo(maximumValue) > 0 ? maximumValue : t3;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean w0(@NotNull g<Long> gVar, short s3) {
        f0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(s3));
    }

    @NotNull
    public static final n w1(long j4, long j5) {
        if (j5 <= Long.MIN_VALUE) {
            return n.f55810e.a();
        }
        return new n(j4, j5 - 1);
    }

    public static final short x(short s3, short s4) {
        return s3 > s4 ? s4 : s3;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char x0(c cVar) {
        f0.p(cVar, "<this>");
        return y0(cVar, Random.Default);
    }

    @NotNull
    public static final n x1(long j4, short s3) {
        return new n(j4, s3 - 1);
    }

    public static final byte y(byte b4, byte b5, byte b6) {
        if (b5 <= b6) {
            return b4 < b5 ? b5 : b4 > b6 ? b6 : b4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b6) + " is less than minimum " + ((int) b5) + '.');
    }

    @SinceKotlin(version = "1.3")
    public static final char y0(@NotNull c cVar, @NotNull Random random) {
        f0.p(cVar, "<this>");
        f0.p(random, "random");
        try {
            return (char) random.nextInt(cVar.c(), cVar.g() + 1);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @NotNull
    public static final n y1(short s3, long j4) {
        if (j4 <= Long.MIN_VALUE) {
            return n.f55810e.a();
        }
        return new n(s3, j4 - 1);
    }

    public static final double z(double d4, double d5, double d6) {
        if (d5 <= d6) {
            return d4 < d5 ? d5 : d4 > d6 ? d6 : d4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d6 + " is less than minimum " + d5 + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int z0(k kVar) {
        f0.p(kVar, "<this>");
        return A0(kVar, Random.Default);
    }
}
