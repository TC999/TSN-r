package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.NoSuchElementException;
import kotlin.Annotations;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.random.C14400f;
import kotlin.random.Random;
import kotlin.ranges.C14410i;
import kotlin.ranges.C14415l;
import kotlin.ranges.Progressions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000f\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0087\b\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0014\u0010\f\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0004*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u001e\u001a\u00020\u001b*\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010 \u001a\u00020\u001b*\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\n¢\u0006\u0004\b \u0010!\u001a\"\u0010%\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b%\u0010&\u001a\"\u0010'\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b'\u0010&\u001a\"\u0010)\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b)\u0010&\u001a\"\u0010+\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b+\u0010&\u001a\"\u0010-\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b-\u0010&\u001a\"\u0010.\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002¢\u0006\u0004\b.\u0010/\u001a\"\u00100\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002¢\u0006\u0004\b0\u0010/\u001a\"\u00101\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002¢\u0006\u0004\b1\u0010/\u001a\"\u00102\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002¢\u0006\u0004\b2\u0010/\u001a\"\u00103\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020*H\u0087\u0002¢\u0006\u0004\b3\u0010/\u001a\"\u00104\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002¢\u0006\u0004\b4\u00105\u001a\"\u00106\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002¢\u0006\u0004\b6\u00105\u001a\"\u00107\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002¢\u0006\u0004\b7\u00105\u001a\"\u00108\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002¢\u0006\u0004\b8\u00105\u001a\"\u00109\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020,H\u0087\u0002¢\u0006\u0004\b9\u00105\u001a\"\u0010:\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b:\u0010;\u001a\"\u0010<\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b<\u0010;\u001a\"\u0010=\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b=\u0010;\u001a\"\u0010>\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b>\u0010;\u001a\"\u0010?\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b?\u0010;\u001a\"\u0010@\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b@\u0010A\u001a\"\u0010B\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\bB\u0010A\u001a\"\u0010C\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020(0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\bC\u0010A\u001a\"\u0010D\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\bD\u0010A\u001a\"\u0010E\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\bE\u0010A\u001a\"\u0010F\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002¢\u0006\u0004\bF\u0010G\u001a\"\u0010H\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002¢\u0006\u0004\bH\u0010G\u001a\"\u0010I\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002¢\u0006\u0004\bI\u0010G\u001a\"\u0010J\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002¢\u0006\u0004\bJ\u0010G\u001a\"\u0010K\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010$\u001a\u00020(H\u0087\u0002¢\u0006\u0004\bK\u0010G\u001a\u0015\u0010N\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010Q\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010R\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0015\u0010T\u001a\u00020S*\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0086\u0004\u001a\u0015\u0010U\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010V\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010W\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010X\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010Y\u001a\u00020O*\u00020\u00012\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010Z\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010[\u001a\u00020O*\u00020#2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010\\\u001a\u00020O*\u00020(2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010]\u001a\u00020M*\u00020\u00012\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010^\u001a\u00020O*\u00020\u00042\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010_\u001a\u00020M*\u00020#2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010`\u001a\u00020M*\u00020(2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\n\u0010a\u001a\u00020M*\u00020M\u001a\n\u0010b\u001a\u00020O*\u00020O\u001a\n\u0010c\u001a\u00020S*\u00020S\u001a\u0015\u0010e\u001a\u00020M*\u00020M2\u0006\u0010d\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010f\u001a\u00020O*\u00020O2\u0006\u0010d\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010g\u001a\u00020S*\u00020S2\u0006\u0010d\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010h\u001a\u0004\u0018\u00010#*\u00020\u0001H\u0000¢\u0006\u0004\bh\u0010i\u001a\u0015\u0010j\u001a\u0004\u0018\u00010#*\u00020\u0004H\u0000¢\u0006\u0004\bj\u0010k\u001a\u0015\u0010l\u001a\u0004\u0018\u00010#*\u00020(H\u0000¢\u0006\u0004\bl\u0010m\u001a\u0015\u0010n\u001a\u0004\u0018\u00010#*\u00020*H\u0000¢\u0006\u0004\bn\u0010o\u001a\u0015\u0010p\u001a\u0004\u0018\u00010#*\u00020,H\u0000¢\u0006\u0004\bp\u0010q\u001a\u0015\u0010r\u001a\u0004\u0018\u00010\u0001*\u00020\u0004H\u0000¢\u0006\u0004\br\u0010s\u001a\u0015\u0010t\u001a\u0004\u0018\u00010\u0001*\u00020*H\u0000¢\u0006\u0004\bt\u0010u\u001a\u0015\u0010v\u001a\u0004\u0018\u00010\u0001*\u00020,H\u0000¢\u0006\u0004\bv\u0010w\u001a\u0015\u0010x\u001a\u0004\u0018\u00010\u0004*\u00020*H\u0000¢\u0006\u0004\bx\u0010y\u001a\u0015\u0010z\u001a\u0004\u0018\u00010\u0004*\u00020,H\u0000¢\u0006\u0004\bz\u0010{\u001a\u0015\u0010|\u001a\u0004\u0018\u00010(*\u00020\u0001H\u0000¢\u0006\u0004\b|\u0010}\u001a\u0015\u0010~\u001a\u0004\u0018\u00010(*\u00020\u0004H\u0000¢\u0006\u0004\b~\u0010\u007f\u001a\u0018\u0010\u0080\u0001\u001a\u0004\u0018\u00010(*\u00020*H\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0018\u0010\u0082\u0001\u001a\u0004\u0018\u00010(*\u00020,H\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0016\u0010\u0084\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0085\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0086\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0087\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020#H\u0086\u0004\u001a\u0016\u0010\u0088\u0001\u001a\u00020\u0006*\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0086\u0004\u001a\u0016\u0010\u0089\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008a\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008b\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008c\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020\u0001H\u0086\u0004\u001a\u0016\u0010\u008d\u0001\u001a\u00020\u0003*\u00020\u00012\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u008e\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u008f\u0001\u001a\u00020\u0003*\u00020#2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u0090\u0001\u001a\u00020\u0003*\u00020(2\u0006\u0010L\u001a\u00020\u0004H\u0086\u0004\u001a\u0016\u0010\u0091\u0001\u001a\u00020\u0000*\u00020\u00012\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0092\u0001\u001a\u00020\u0003*\u00020\u00042\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0093\u0001\u001a\u00020\u0000*\u00020#2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a\u0016\u0010\u0094\u0001\u001a\u00020\u0000*\u00020(2\u0006\u0010L\u001a\u00020(H\u0086\u0004\u001a.\u0010\u0097\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u0007\u0010\u0096\u0001\u001a\u00028\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0014\u0010\u0099\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u0096\u0001\u001a\u00020#\u001a\u0014\u0010\u009a\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u0096\u0001\u001a\u00020(\u001a\u0014\u0010\u009b\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u009c\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u0004\u001a\u0014\u0010\u009d\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u0096\u0001\u001a\u00020,\u001a\u0014\u0010\u009e\u0001\u001a\u00020**\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*\u001a.\u0010 \u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u0007\u0010\u009f\u0001\u001a\u00028\u0000¢\u0006\u0006\b \u0001\u0010\u0098\u0001\u001a\u0014\u0010¡\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u009f\u0001\u001a\u00020#\u001a\u0014\u0010¢\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u009f\u0001\u001a\u00020(\u001a\u0014\u0010£\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0001\u001a\u0014\u0010¤\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0004\u001a\u0014\u0010¥\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u009f\u0001\u001a\u00020,\u001a\u0014\u0010¦\u0001\u001a\u00020**\u00020*2\u0007\u0010\u009f\u0001\u001a\u00020*\u001a;\u0010§\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\t\u0010\u0096\u0001\u001a\u0004\u0018\u00018\u00002\t\u0010\u009f\u0001\u001a\u0004\u0018\u00018\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001a\u001d\u0010©\u0001\u001a\u00020#*\u00020#2\u0007\u0010\u0096\u0001\u001a\u00020#2\u0007\u0010\u009f\u0001\u001a\u00020#\u001a\u001d\u0010ª\u0001\u001a\u00020(*\u00020(2\u0007\u0010\u0096\u0001\u001a\u00020(2\u0007\u0010\u009f\u0001\u001a\u00020(\u001a\u001d\u0010«\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0001\u001a\u001d\u0010¬\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0004\u001a\u001d\u0010\u00ad\u0001\u001a\u00020,*\u00020,2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u009f\u0001\u001a\u00020,\u001a\u001d\u0010®\u0001\u001a\u00020**\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u009f\u0001\u001a\u00020*\u001a7\u0010±\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\u000e\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¯\u0001H\u0007¢\u0006\u0006\b±\u0001\u0010²\u0001\u001a4\u0010³\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010W*\t\u0012\u0004\u0012\u00028\u00000\u0095\u0001*\u00028\u00002\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0006\b³\u0001\u0010´\u0001\u001a\u001a\u0010µ\u0001\u001a\u00020\u0001*\u00020\u00012\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\"\u001a\u001a\u0010¶\u0001\u001a\u00020\u0004*\u00020\u00042\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\"¨\u0006·\u0001"}, m12616d2 = {"Lkotlin/ranges/k;", "", "z0", "Lkotlin/ranges/n;", "", "B0", "Lkotlin/ranges/c;", "", "x0", "Lkotlin/random/Random;", "random", "A0", "C0", "y0", "F0", "(Lkotlin/ranges/k;)Ljava/lang/Integer;", "H0", "(Lkotlin/ranges/n;)Ljava/lang/Long;", "D0", "(Lkotlin/ranges/c;)Ljava/lang/Character;", "G0", "(Lkotlin/ranges/k;Lkotlin/random/Random;)Ljava/lang/Integer;", "I0", "(Lkotlin/ranges/n;Lkotlin/random/Random;)Ljava/lang/Long;", "E0", "(Lkotlin/ranges/c;Lkotlin/random/Random;)Ljava/lang/Character;", "element", "", "K", "(Lkotlin/ranges/k;Ljava/lang/Integer;)Z", "L", "(Lkotlin/ranges/n;Ljava/lang/Long;)Z", "J", "(Lkotlin/ranges/c;Ljava/lang/Character;)Z", "Lkotlin/ranges/g;", "", DomainCampaignEx.LOOPBACK_VALUE, "n0", "(Lkotlin/ranges/g;B)Z", "s0", "", "M0", "", "M", "", "i0", "o0", "(Lkotlin/ranges/g;D)Z", "t0", "f", "N0", "j0", C7202bq.f24604g, "(Lkotlin/ranges/g;F)Z", "u0", "g", "O0", "N", "v0", "(Lkotlin/ranges/g;I)Z", "h", "P0", "O", "k0", "q0", "(Lkotlin/ranges/g;J)Z", "i", "Q0", "P", "l0", "r0", "(Lkotlin/ranges/g;S)Z", "w0", "j", "Q", "m0", "to", "Lkotlin/ranges/i;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/ranges/l;", "d0", ExifInterface.LATITUDE_SOUTH, "Y", "Lkotlin/ranges/a;", "R", ExifInterface.LONGITUDE_WEST, "e0", ExifInterface.GPS_DIRECTION_TRUE, "Z", "c0", "f0", "b0", "h0", "X", "g0", "U", "a0", "K0", "L0", "J0", "step", "S0", "T0", "R0", "W0", "(I)Ljava/lang/Byte;", "X0", "(J)Ljava/lang/Byte;", "Y0", "(S)Ljava/lang/Byte;", "U0", "(D)Ljava/lang/Byte;", "V0", "(F)Ljava/lang/Byte;", "b1", "(J)Ljava/lang/Integer;", "Z0", "(D)Ljava/lang/Integer;", "a1", "(F)Ljava/lang/Integer;", "c1", "(D)Ljava/lang/Long;", "d1", "(F)Ljava/lang/Long;", "g1", "(I)Ljava/lang/Short;", "h1", "(J)Ljava/lang/Short;", "e1", "(D)Ljava/lang/Short;", "f1", "(F)Ljava/lang/Short;", "m1", "u1", "j1", "p1", "i1", "n1", "v1", "k1", "q1", "t1", "w1", "s1", "y1", "o1", "x1", "l1", "r1", "", "minimumValue", "p", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "k", CampaignEx.JSON_KEY_AD_Q, "n", "o", "m", C7304t.f25048d, "maximumValue", IAdInterListener.AdReqParam.WIDTH, "r", "x", "u", "v", UMCommonContent.f37782aL, "s", "F", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "y", "I", "B", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "Lkotlin/ranges/f;", "range", "G", "(Ljava/lang/Comparable;Lkotlin/ranges/f;)Ljava/lang/Comparable;", "H", "(Ljava/lang/Comparable;Lkotlin/ranges/g;)Ljava/lang/Comparable;", "C", ExifInterface.LONGITUDE_EAST, "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/ranges/RangesKt")
/* renamed from: kotlin.ranges.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class _Ranges extends C14421p {
    /* renamed from: A */
    public static final float m7567A(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: A0 */
    public static final int m7566A0(@NotNull C14413k random, @NotNull Random random2) {
        C14342f0.m8184p(random, "$this$random");
        C14342f0.m8184p(random2, "random");
        try {
            return C14400f.m7645h(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: B */
    public static int m7565B(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: B0 */
    private static final long m7564B0(C14418n c14418n) {
        return m7562C0(c14418n, Random.Default);
    }

    /* renamed from: C */
    public static final int m7563C(int i, @NotNull InterfaceC14407g<Integer> range) {
        C14342f0.m8184p(range, "range");
        if (range instanceof InterfaceC14405f) {
            return ((Number) m7555G(Integer.valueOf(i), (InterfaceC14405f) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i < range.getStart().intValue() ? range.getStart().intValue() : i > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: C0 */
    public static final long m7562C0(@NotNull C14418n random, @NotNull Random random2) {
        C14342f0.m8184p(random, "$this$random");
        C14342f0.m8184p(random2, "random");
        try {
            return C14400f.m7644i(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: D */
    public static long m7561D(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: D0 */
    private static final Character m7560D0(Ranges ranges) {
        return m7558E0(ranges, Random.Default);
    }

    /* renamed from: E */
    public static long m7559E(long j, @NotNull InterfaceC14407g<Long> range) {
        C14342f0.m8184p(range, "range");
        if (range instanceof InterfaceC14405f) {
            return ((Number) m7555G(Long.valueOf(j), (InterfaceC14405f) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j < range.getStart().longValue() ? range.getStart().longValue() : j > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: E0 */
    public static final Character m7558E0(@NotNull Ranges randomOrNull, @NotNull Random random) {
        C14342f0.m8184p(randomOrNull, "$this$randomOrNull");
        C14342f0.m8184p(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(randomOrNull.m7628c(), randomOrNull.m7627d() + 1));
    }

    @NotNull
    /* renamed from: F */
    public static final <T extends Comparable<? super T>> T m7557F(@NotNull T coerceIn, @Nullable T t, @Nullable T t2) {
        C14342f0.m8184p(coerceIn, "$this$coerceIn");
        if (t != null && t2 != null) {
            if (t.compareTo(t2) <= 0) {
                if (coerceIn.compareTo(t) < 0) {
                    return t;
                }
                if (coerceIn.compareTo(t2) > 0) {
                    return t2;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t2 + " is less than minimum " + t + '.');
            }
        } else if (t != null && coerceIn.compareTo(t) < 0) {
            return t;
        } else {
            if (t2 != null && coerceIn.compareTo(t2) > 0) {
                return t2;
            }
        }
        return coerceIn;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: F0 */
    private static final Integer m7556F0(C14413k c14413k) {
        return m7554G0(c14413k, Random.Default);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: G */
    public static final <T extends Comparable<? super T>> T m7555G(@NotNull T coerceIn, @NotNull InterfaceC14405f<T> range) {
        C14342f0.m8184p(coerceIn, "$this$coerceIn");
        C14342f0.m8184p(range, "range");
        if (!range.isEmpty()) {
            return (!range.mo7609a(coerceIn, range.getStart()) || range.mo7609a(range.getStart(), coerceIn)) ? (!range.mo7609a(range.getEndInclusive(), coerceIn) || range.mo7609a(coerceIn, range.getEndInclusive())) ? coerceIn : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: G0 */
    public static final Integer m7554G0(@NotNull C14413k randomOrNull, @NotNull Random random) {
        C14342f0.m8184p(randomOrNull, "$this$randomOrNull");
        C14342f0.m8184p(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf(C14400f.m7645h(random, randomOrNull));
    }

    @NotNull
    /* renamed from: H */
    public static final <T extends Comparable<? super T>> T m7553H(@NotNull T coerceIn, @NotNull InterfaceC14407g<T> range) {
        C14342f0.m8184p(coerceIn, "$this$coerceIn");
        C14342f0.m8184p(range, "range");
        if (range instanceof InterfaceC14405f) {
            return (T) m7555G(coerceIn, (InterfaceC14405f) range);
        }
        if (!range.isEmpty()) {
            return coerceIn.compareTo(range.getStart()) < 0 ? range.getStart() : coerceIn.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: H0 */
    private static final Long m7552H0(C14418n c14418n) {
        return m7550I0(c14418n, Random.Default);
    }

    /* renamed from: I */
    public static final short m7551I(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: I0 */
    public static final Long m7550I0(@NotNull C14418n randomOrNull, @NotNull Random random) {
        C14342f0.m8184p(randomOrNull, "$this$randomOrNull");
        C14342f0.m8184p(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf(C14400f.m7644i(random, randomOrNull));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: J */
    private static final boolean m7549J(Ranges contains, Character ch) {
        C14342f0.m8184p(contains, "$this$contains");
        return ch != null && contains.m7621h(ch.charValue());
    }

    @NotNull
    /* renamed from: J0 */
    public static final Progressions m7548J0(@NotNull Progressions reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        return Progressions.f41276d.m7624a(reversed.m7627d(), reversed.m7628c(), -reversed.m7626e());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: K */
    private static final boolean m7547K(C14413k contains, Integer num) {
        C14342f0.m8184p(contains, "$this$contains");
        return num != null && contains.m7597h(num.intValue());
    }

    @NotNull
    /* renamed from: K0 */
    public static final C14410i m7546K0(@NotNull C14410i reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        return C14410i.f41292d.m7600a(reversed.m7603d(), reversed.m7604c(), -reversed.m7602e());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: L */
    private static final boolean m7545L(C14418n contains, Long l) {
        C14342f0.m8184p(contains, "$this$contains");
        return l != null && contains.m7586h(l.longValue());
    }

    @NotNull
    /* renamed from: L0 */
    public static final C14415l m7544L0(@NotNull C14415l reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        return C14415l.f41302d.m7589a(reversed.m7592d(), reversed.m7593c(), -reversed.m7591e());
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    /* renamed from: M */
    public static final /* synthetic */ boolean m7543M(InterfaceC14407g<Double> contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Double.valueOf(b));
    }

    @JvmName(name = "shortRangeContains")
    /* renamed from: M0 */
    public static final boolean m7542M0(@NotNull InterfaceC14407g<Short> contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Short.valueOf(b));
    }

    @JvmName(name = "doubleRangeContains")
    /* renamed from: N */
    public static final boolean m7541N(@NotNull InterfaceC14407g<Double> contains, float f) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Double.valueOf(f));
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    /* renamed from: N0 */
    public static final /* synthetic */ boolean m7540N0(InterfaceC14407g<Short> contains, double d) {
        C14342f0.m8184p(contains, "$this$contains");
        Short m7506e1 = m7506e1(d);
        if (m7506e1 != null) {
            return contains.contains(m7506e1);
        }
        return false;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    /* renamed from: O */
    public static final /* synthetic */ boolean m7539O(InterfaceC14407g<Double> contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Double.valueOf(i));
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    /* renamed from: O0 */
    public static final /* synthetic */ boolean m7538O0(InterfaceC14407g<Short> contains, float f) {
        C14342f0.m8184p(contains, "$this$contains");
        Short m7503f1 = m7503f1(f);
        if (m7503f1 != null) {
            return contains.contains(m7503f1);
        }
        return false;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    /* renamed from: P */
    public static final /* synthetic */ boolean m7537P(InterfaceC14407g<Double> contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Double.valueOf(j));
    }

    @JvmName(name = "shortRangeContains")
    /* renamed from: P0 */
    public static final boolean m7536P0(@NotNull InterfaceC14407g<Short> contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        Short m7500g1 = m7500g1(i);
        if (m7500g1 != null) {
            return contains.contains(m7500g1);
        }
        return false;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    /* renamed from: Q */
    public static final /* synthetic */ boolean m7535Q(InterfaceC14407g<Double> contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Double.valueOf(s));
    }

    @JvmName(name = "shortRangeContains")
    /* renamed from: Q0 */
    public static final boolean m7534Q0(@NotNull InterfaceC14407g<Short> contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        Short m7497h1 = m7497h1(j);
        if (m7497h1 != null) {
            return contains.contains(m7497h1);
        }
        return false;
    }

    @NotNull
    /* renamed from: R */
    public static final Progressions m7533R(char c, char c2) {
        return Progressions.f41276d.m7624a(c, c2, -1);
    }

    @NotNull
    /* renamed from: R0 */
    public static final Progressions m7532R0(@NotNull Progressions step, int i) {
        C14342f0.m8184p(step, "$this$step");
        C14421p.m7572a(i > 0, Integer.valueOf(i));
        Progressions.C14401a c14401a = Progressions.f41276d;
        char m7628c = step.m7628c();
        char m7627d = step.m7627d();
        if (step.m7626e() <= 0) {
            i = -i;
        }
        return c14401a.m7624a(m7628c, m7627d, i);
    }

    @NotNull
    /* renamed from: S */
    public static final C14410i m7531S(byte b, byte b2) {
        return C14410i.f41292d.m7600a(b, b2, -1);
    }

    @NotNull
    /* renamed from: S0 */
    public static C14410i m7530S0(@NotNull C14410i step, int i) {
        C14342f0.m8184p(step, "$this$step");
        C14421p.m7572a(i > 0, Integer.valueOf(i));
        C14410i.C14411a c14411a = C14410i.f41292d;
        int m7604c = step.m7604c();
        int m7603d = step.m7603d();
        if (step.m7602e() <= 0) {
            i = -i;
        }
        return c14411a.m7600a(m7604c, m7603d, i);
    }

    @NotNull
    /* renamed from: T */
    public static final C14410i m7529T(byte b, int i) {
        return C14410i.f41292d.m7600a(b, i, -1);
    }

    @NotNull
    /* renamed from: T0 */
    public static final C14415l m7528T0(@NotNull C14415l step, long j) {
        C14342f0.m8184p(step, "$this$step");
        C14421p.m7572a(j > 0, Long.valueOf(j));
        C14415l.C14416a c14416a = C14415l.f41302d;
        long m7593c = step.m7593c();
        long m7592d = step.m7592d();
        if (step.m7591e() <= 0) {
            j = -j;
        }
        return c14416a.m7589a(m7593c, m7592d, j);
    }

    @NotNull
    /* renamed from: U */
    public static final C14410i m7527U(byte b, short s) {
        return C14410i.f41292d.m7600a(b, s, -1);
    }

    @Nullable
    /* renamed from: U0 */
    public static final Byte m7526U0(double d) {
        double d2 = 127;
        if (d < -128 || d > d2) {
            return null;
        }
        return Byte.valueOf((byte) d);
    }

    @NotNull
    /* renamed from: V */
    public static final C14410i m7525V(int i, byte b) {
        return C14410i.f41292d.m7600a(i, b, -1);
    }

    @Nullable
    /* renamed from: V0 */
    public static final Byte m7524V0(float f) {
        float f2 = 127;
        if (f < -128 || f > f2) {
            return null;
        }
        return Byte.valueOf((byte) f);
    }

    @NotNull
    /* renamed from: W */
    public static C14410i m7523W(int i, int i2) {
        return C14410i.f41292d.m7600a(i, i2, -1);
    }

    @Nullable
    /* renamed from: W0 */
    public static final Byte m7522W0(int i) {
        if (-128 <= i && 127 >= i) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    @NotNull
    /* renamed from: X */
    public static final C14410i m7521X(int i, short s) {
        return C14410i.f41292d.m7600a(i, s, -1);
    }

    @Nullable
    /* renamed from: X0 */
    public static final Byte m7520X0(long j) {
        long j2 = 127;
        if (-128 <= j && j2 >= j) {
            return Byte.valueOf((byte) j);
        }
        return null;
    }

    @NotNull
    /* renamed from: Y */
    public static final C14410i m7519Y(short s, byte b) {
        return C14410i.f41292d.m7600a(s, b, -1);
    }

    @Nullable
    /* renamed from: Y0 */
    public static final Byte m7518Y0(short s) {
        short s2 = (short) 127;
        if (((short) (-128)) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @NotNull
    /* renamed from: Z */
    public static final C14410i m7517Z(short s, int i) {
        return C14410i.f41292d.m7600a(s, i, -1);
    }

    @Nullable
    /* renamed from: Z0 */
    public static final Integer m7516Z0(double d) {
        double d2 = Integer.MAX_VALUE;
        if (d < Integer.MIN_VALUE || d > d2) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    @NotNull
    /* renamed from: a0 */
    public static final C14410i m7515a0(short s, short s2) {
        return C14410i.f41292d.m7600a(s, s2, -1);
    }

    @Nullable
    /* renamed from: a1 */
    public static final Integer m7514a1(float f) {
        float f2 = Integer.MAX_VALUE;
        if (f < Integer.MIN_VALUE || f > f2) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    @NotNull
    /* renamed from: b0 */
    public static final C14415l m7513b0(byte b, long j) {
        return C14415l.f41302d.m7589a(b, j, -1L);
    }

    @Nullable
    /* renamed from: b1 */
    public static final Integer m7512b1(long j) {
        long j2 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j && j2 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    @NotNull
    /* renamed from: c0 */
    public static final C14415l m7511c0(int i, long j) {
        return C14415l.f41302d.m7589a(i, j, -1L);
    }

    @Nullable
    /* renamed from: c1 */
    public static final Long m7510c1(double d) {
        double d2 = Long.MAX_VALUE;
        if (d < Long.MIN_VALUE || d > d2) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    @NotNull
    /* renamed from: d0 */
    public static final C14415l m7509d0(long j, byte b) {
        return C14415l.f41302d.m7589a(j, b, -1L);
    }

    @Nullable
    /* renamed from: d1 */
    public static final Long m7508d1(float f) {
        float f2 = (float) Long.MAX_VALUE;
        if (f < ((float) Long.MIN_VALUE) || f > f2) {
            return null;
        }
        return Long.valueOf(f);
    }

    @NotNull
    /* renamed from: e0 */
    public static final C14415l m7507e0(long j, int i) {
        return C14415l.f41302d.m7589a(j, i, -1L);
    }

    @Nullable
    /* renamed from: e1 */
    public static final Short m7506e1(double d) {
        double d2 = 32767;
        if (d < -32768 || d > d2) {
            return null;
        }
        return Short.valueOf((short) d);
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    /* renamed from: f */
    public static final /* synthetic */ boolean m7505f(InterfaceC14407g<Byte> contains, double d) {
        C14342f0.m8184p(contains, "$this$contains");
        Byte m7526U0 = m7526U0(d);
        if (m7526U0 != null) {
            return contains.contains(m7526U0);
        }
        return false;
    }

    @NotNull
    /* renamed from: f0 */
    public static final C14415l m7504f0(long j, long j2) {
        return C14415l.f41302d.m7589a(j, j2, -1L);
    }

    @Nullable
    /* renamed from: f1 */
    public static final Short m7503f1(float f) {
        float f2 = 32767;
        if (f < -32768 || f > f2) {
            return null;
        }
        return Short.valueOf((short) f);
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    /* renamed from: g */
    public static final /* synthetic */ boolean m7502g(InterfaceC14407g<Byte> contains, float f) {
        C14342f0.m8184p(contains, "$this$contains");
        Byte m7524V0 = m7524V0(f);
        if (m7524V0 != null) {
            return contains.contains(m7524V0);
        }
        return false;
    }

    @NotNull
    /* renamed from: g0 */
    public static final C14415l m7501g0(long j, short s) {
        return C14415l.f41302d.m7589a(j, s, -1L);
    }

    @Nullable
    /* renamed from: g1 */
    public static final Short m7500g1(int i) {
        if (-32768 <= i && 32767 >= i) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    @JvmName(name = "byteRangeContains")
    /* renamed from: h */
    public static final boolean m7499h(@NotNull InterfaceC14407g<Byte> contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        Byte m7522W0 = m7522W0(i);
        if (m7522W0 != null) {
            return contains.contains(m7522W0);
        }
        return false;
    }

    @NotNull
    /* renamed from: h0 */
    public static final C14415l m7498h0(short s, long j) {
        return C14415l.f41302d.m7589a(s, j, -1L);
    }

    @Nullable
    /* renamed from: h1 */
    public static final Short m7497h1(long j) {
        long j2 = 32767;
        if (-32768 <= j && j2 >= j) {
            return Short.valueOf((short) j);
        }
        return null;
    }

    @JvmName(name = "byteRangeContains")
    /* renamed from: i */
    public static final boolean m7496i(@NotNull InterfaceC14407g<Byte> contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        Byte m7520X0 = m7520X0(j);
        if (m7520X0 != null) {
            return contains.contains(m7520X0);
        }
        return false;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    /* renamed from: i0 */
    public static final /* synthetic */ boolean m7495i0(InterfaceC14407g<Float> contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Float.valueOf(b));
    }

    @NotNull
    /* renamed from: i1 */
    public static final Ranges m7494i1(char c, char c2) {
        return C14342f0.m8180t(c2, 0) <= 0 ? Ranges.f41285f.m7618a() : new Ranges(c, (char) (c2 - 1));
    }

    @JvmName(name = "byteRangeContains")
    /* renamed from: j */
    public static final boolean m7493j(@NotNull InterfaceC14407g<Byte> contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        Byte m7518Y0 = m7518Y0(s);
        if (m7518Y0 != null) {
            return contains.contains(m7518Y0);
        }
        return false;
    }

    @JvmName(name = "floatRangeContains")
    /* renamed from: j0 */
    public static final boolean m7492j0(@NotNull InterfaceC14407g<Float> contains, double d) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Float.valueOf((float) d));
    }

    @NotNull
    /* renamed from: j1 */
    public static final C14413k m7491j1(byte b, byte b2) {
        return new C14413k(b, b2 - 1);
    }

    /* renamed from: k */
    public static final byte m7490k(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    /* renamed from: k0 */
    public static final /* synthetic */ boolean m7489k0(InterfaceC14407g<Float> contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Float.valueOf(i));
    }

    @NotNull
    /* renamed from: k1 */
    public static final C14413k m7488k1(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return C14413k.f41301f.m7594a();
        }
        return new C14413k(b, i - 1);
    }

    /* renamed from: l */
    public static final double m7487l(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    /* renamed from: l0 */
    public static final /* synthetic */ boolean m7486l0(InterfaceC14407g<Float> contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Float.valueOf((float) j));
    }

    @NotNull
    /* renamed from: l1 */
    public static final C14413k m7485l1(byte b, short s) {
        return new C14413k(b, s - 1);
    }

    /* renamed from: m */
    public static final float m7484m(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    /* renamed from: m0 */
    public static final /* synthetic */ boolean m7483m0(InterfaceC14407g<Float> contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Float.valueOf(s));
    }

    @NotNull
    /* renamed from: m1 */
    public static final C14413k m7482m1(int i, byte b) {
        return new C14413k(i, b - 1);
    }

    /* renamed from: n */
    public static int m7481n(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    @JvmName(name = "intRangeContains")
    /* renamed from: n0 */
    public static final boolean m7480n0(@NotNull InterfaceC14407g<Integer> contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Integer.valueOf(b));
    }

    @NotNull
    /* renamed from: n1 */
    public static C14413k m7479n1(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return C14413k.f41301f.m7594a();
        }
        return new C14413k(i, i2 - 1);
    }

    /* renamed from: o */
    public static long m7478o(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    /* renamed from: o0 */
    public static final /* synthetic */ boolean m7477o0(InterfaceC14407g<Integer> contains, double d) {
        C14342f0.m8184p(contains, "$this$contains");
        Integer m7516Z0 = m7516Z0(d);
        if (m7516Z0 != null) {
            return contains.contains(m7516Z0);
        }
        return false;
    }

    @NotNull
    /* renamed from: o1 */
    public static final C14413k m7476o1(int i, short s) {
        return new C14413k(i, s - 1);
    }

    @NotNull
    /* renamed from: p */
    public static final <T extends Comparable<? super T>> T m7475p(@NotNull T coerceAtLeast, @NotNull T minimumValue) {
        C14342f0.m8184p(coerceAtLeast, "$this$coerceAtLeast");
        C14342f0.m8184p(minimumValue, "minimumValue");
        return coerceAtLeast.compareTo(minimumValue) < 0 ? minimumValue : coerceAtLeast;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    /* renamed from: p0 */
    public static final /* synthetic */ boolean m7474p0(InterfaceC14407g<Integer> contains, float f) {
        C14342f0.m8184p(contains, "$this$contains");
        Integer m7514a1 = m7514a1(f);
        if (m7514a1 != null) {
            return contains.contains(m7514a1);
        }
        return false;
    }

    @NotNull
    /* renamed from: p1 */
    public static final C14413k m7473p1(short s, byte b) {
        return new C14413k(s, b - 1);
    }

    /* renamed from: q */
    public static final short m7472q(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    @JvmName(name = "intRangeContains")
    /* renamed from: q0 */
    public static final boolean m7471q0(@NotNull InterfaceC14407g<Integer> contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        Integer m7512b1 = m7512b1(j);
        if (m7512b1 != null) {
            return contains.contains(m7512b1);
        }
        return false;
    }

    @NotNull
    /* renamed from: q1 */
    public static final C14413k m7470q1(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return C14413k.f41301f.m7594a();
        }
        return new C14413k(s, i - 1);
    }

    /* renamed from: r */
    public static final byte m7469r(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    @JvmName(name = "intRangeContains")
    /* renamed from: r0 */
    public static final boolean m7468r0(@NotNull InterfaceC14407g<Integer> contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Integer.valueOf(s));
    }

    @NotNull
    /* renamed from: r1 */
    public static final C14413k m7467r1(short s, short s2) {
        return new C14413k(s, s2 - 1);
    }

    /* renamed from: s */
    public static final double m7466s(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    @JvmName(name = "longRangeContains")
    /* renamed from: s0 */
    public static final boolean m7465s0(@NotNull InterfaceC14407g<Long> contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Long.valueOf(b));
    }

    @NotNull
    /* renamed from: s1 */
    public static final C14418n m7464s1(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return C14418n.f41311f.m7583a();
        }
        return new C14418n(b, j - 1);
    }

    /* renamed from: t */
    public static final float m7463t(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    /* renamed from: t0 */
    public static final /* synthetic */ boolean m7462t0(InterfaceC14407g<Long> contains, double d) {
        C14342f0.m8184p(contains, "$this$contains");
        Long m7510c1 = m7510c1(d);
        if (m7510c1 != null) {
            return contains.contains(m7510c1);
        }
        return false;
    }

    @NotNull
    /* renamed from: t1 */
    public static final C14418n m7461t1(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return C14418n.f41311f.m7583a();
        }
        return new C14418n(i, j - 1);
    }

    /* renamed from: u */
    public static int m7460u(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    @Annotations(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    /* renamed from: u0 */
    public static final /* synthetic */ boolean m7459u0(InterfaceC14407g<Long> contains, float f) {
        C14342f0.m8184p(contains, "$this$contains");
        Long m7508d1 = m7508d1(f);
        if (m7508d1 != null) {
            return contains.contains(m7508d1);
        }
        return false;
    }

    @NotNull
    /* renamed from: u1 */
    public static final C14418n m7458u1(long j, byte b) {
        return new C14418n(j, b - 1);
    }

    /* renamed from: v */
    public static long m7457v(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    @JvmName(name = "longRangeContains")
    /* renamed from: v0 */
    public static final boolean m7456v0(@NotNull InterfaceC14407g<Long> contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Long.valueOf(i));
    }

    @NotNull
    /* renamed from: v1 */
    public static final C14418n m7455v1(long j, int i) {
        return new C14418n(j, i - 1);
    }

    @NotNull
    /* renamed from: w */
    public static final <T extends Comparable<? super T>> T m7454w(@NotNull T coerceAtMost, @NotNull T maximumValue) {
        C14342f0.m8184p(coerceAtMost, "$this$coerceAtMost");
        C14342f0.m8184p(maximumValue, "maximumValue");
        return coerceAtMost.compareTo(maximumValue) > 0 ? maximumValue : coerceAtMost;
    }

    @JvmName(name = "longRangeContains")
    /* renamed from: w0 */
    public static final boolean m7453w0(@NotNull InterfaceC14407g<Long> contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.contains(Long.valueOf(s));
    }

    @NotNull
    /* renamed from: w1 */
    public static final C14418n m7452w1(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return C14418n.f41311f.m7583a();
        }
        return new C14418n(j, j2 - 1);
    }

    /* renamed from: x */
    public static final short m7451x(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: x0 */
    private static final char m7450x0(Ranges ranges) {
        return m7447y0(ranges, Random.Default);
    }

    @NotNull
    /* renamed from: x1 */
    public static final C14418n m7449x1(long j, short s) {
        return new C14418n(j, s - 1);
    }

    /* renamed from: y */
    public static final byte m7448y(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            return b < b2 ? b2 : b > b3 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + '.');
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: y0 */
    public static final char m7447y0(@NotNull Ranges random, @NotNull Random random2) {
        C14342f0.m8184p(random, "$this$random");
        C14342f0.m8184p(random2, "random");
        try {
            return (char) random2.nextInt(random.m7628c(), random.m7627d() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @NotNull
    /* renamed from: y1 */
    public static final C14418n m7446y1(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return C14418n.f41311f.m7583a();
        }
        return new C14418n(s, j - 1);
    }

    /* renamed from: z */
    public static final double m7445z(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: z0 */
    private static final int m7444z0(C14413k c14413k) {
        return m7566A0(c14413k, Random.Default);
    }
}
