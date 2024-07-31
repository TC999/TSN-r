package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import kotlin.Annotations;
import kotlin.C14294d0;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsH;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Delay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;
import p617l1.InterfaceC15288t;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0082\u0001\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a\u0018\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001aF\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aj\u0010\u0016\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aX\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032(\u0010\u0019\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a>\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u001cH\u0007\u001a$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0003H\u0007\u001a$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0003H\u0007\u001aI\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032#\u0010!\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u001c¢\u0006\u0002\b H\u0007\u001a&\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010$\u001a\u00020#H\u0007\u001aU\u0010*\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u000321\u0010)\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0013\u001a\u0080\u0001\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010+\u001a\u00028\u00012H\b\u0001\u0010.\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100,H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a-\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0007¢\u0006\u0004\b1\u00102\u001aC\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00028\u00002\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0004\b5\u00106\u001a-\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010(\u001a\u00028\u0000H\u0007¢\u0006\u0004\b7\u00102\u001a,\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a-\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010(\u001a\u00028\u0000H\u0007¢\u0006\u0004\b:\u00102\u001a,\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001al\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010<\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010>\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100,H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u0086\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010<\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010A\"\u0004\b\u0003\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032.\u0010>\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100CH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a \u0001\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010<\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010A\"\u0004\b\u0003\u0010F\"\u0004\b\u0004\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010>\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100HH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001aº\u0001\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010<\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010A\"\u0004\b\u0003\u0010F\"\u0004\b\u0004\u0010K\"\u0004\b\u0005\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010>\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100MH\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a&\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010Q\u001a\u00020PH\u0007\u001a&\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010Q\u001a\u00020PH\u0007\u001ag\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u000327\u0010>\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010\u001b\u001ap\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032F\u0010.\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100,H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u001e\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a&\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010X\u001a\u00020#H\u0007\u001a\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a&\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010X\u001a\u00020#H\u0007\u001a\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, m12616d2 = {"", "p", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/f;", "context", CampaignEx.JSON_KEY_AD_Q, "y", "J", "fallback", "r", "s", "Lkotlin/f1;", "G", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "onEach", "H", "(Lkotlinx/coroutines/flow/h;Ll1/p;)V", "", "onError", "I", "(Lkotlinx/coroutines/flow/h;Ll1/p;Ll1/p;)V", "R", "mapper", C7304t.f25048d, "(Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function1;", "g", "o", "m", "Lkotlin/ExtensionFunctionType;", "transformer", "f", "", "count", "D", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, CcgConstant.f38549t, "n", "initial", "Lkotlin/Function3;", "accumulator", "operation", "B", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;Ll1/q;)Lkotlinx/coroutines/flow/h;", UMCommonContent.f37782aL, "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;)Lkotlinx/coroutines/flow/h;", "", "predicate", "u", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Object;Ll1/l;)Lkotlinx/coroutines/flow/h;", ExifInterface.LONGITUDE_EAST, AdnName.OTHER, "F", "h", "i", "T1", "T2", "transform", "e", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "T3", "other2", "Lkotlin/Function4;", "d", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/r;)Lkotlinx/coroutines/flow/h;", "T4", "other3", "Lkotlin/Function5;", "c", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/s;)Lkotlinx/coroutines/flow/h;", "T5", "other4", "Lkotlin/Function6;", "b", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/t;)Lkotlinx/coroutines/flow/h;", "", "timeMillis", "k", "j", "K", "C", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", IAdInterListener.AdReqParam.WIDTH, "bufferSize", "x", UMCommonContent.f37777aG, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class Migration {

    /* compiled from: Migration.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", m8638f = "Migration.kt", m8637i = {0}, m8636l = {423}, m8635m = "invokeSuspend", m8634n = {"it"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14845a<T> extends SuspendLambda implements InterfaceC15284p<T, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private Object f42460a;

        /* renamed from: b */
        Object f42461b;

        /* renamed from: c */
        int f42462c;

        /* renamed from: d */
        final /* synthetic */ long f42463d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14845a(long j, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42463d = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14845a c14845a = new C14845a(this.f42463d, interfaceC14268c);
            c14845a.f42460a = obj;
            return c14845a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14845a) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42462c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Object obj2 = this.f42460a;
                long j = this.f42463d;
                this.f42461b = obj2;
                this.f42462c = 1;
                if (Delay.m5751b(j, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: Migration.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", m8638f = "Migration.kt", m8637i = {0}, m8636l = {TTAdConstant.IMAGE_CODE}, m8635m = "invokeSuspend", m8634n = {"$this$onStart"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14846b<T> extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42464a;

        /* renamed from: b */
        Object f42465b;

        /* renamed from: c */
        int f42466c;

        /* renamed from: d */
        final /* synthetic */ long f42467d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14846b(long j, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42467d = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14846b c14846b = new C14846b(this.f42467d, interfaceC14268c);
            c14846b.f42464a = (FlowCollector) obj;
            return c14846b;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14846b) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42466c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector flowCollector = this.f42464a;
                long j = this.f42467d;
                this.f42465b = flowCollector;
                this.f42466c = 1;
                if (Delay.m5751b(j, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                FlowCollector flowCollector2 = (FlowCollector) this.f42465b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: Migration.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Throwable;)Z"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14847c extends Lambda implements InterfaceC15280l<Throwable, Boolean> {

        /* renamed from: a */
        public static final C14847c f42468a = new C14847c();

        C14847c() {
            super(1);
        }

        /* renamed from: a */
        public final boolean m4906a(@NotNull Throwable th) {
            return true;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(m4906a(th));
        }
    }

    /* compiled from: Migration.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "", "e", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", m8638f = "Migration.kt", m8637i = {0, 0}, m8636l = {306}, m8635m = "invokeSuspend", m8634n = {"$this$catch", "e"}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14848d<T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super T>, Throwable, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42469a;

        /* renamed from: b */
        private Throwable f42470b;

        /* renamed from: c */
        Object f42471c;

        /* renamed from: d */
        Object f42472d;

        /* renamed from: e */
        int f42473e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15280l f42474f;

        /* renamed from: g */
        final /* synthetic */ Object f42475g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14848d(InterfaceC15280l interfaceC15280l, Object obj, InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
            this.f42474f = interfaceC15280l;
            this.f42475g = obj;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4905d(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C14848d c14848d = new C14848d(this.f42474f, this.f42475g, interfaceC14268c);
            c14848d.f42469a = flowCollector;
            c14848d.f42470b = th;
            return c14848d;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(Object obj, Throwable th, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14848d) m4905d((FlowCollector) obj, th, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42473e;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector flowCollector = this.f42469a;
                Throwable th = this.f42470b;
                if (((Boolean) this.f42474f.invoke(th)).booleanValue()) {
                    Object obj2 = this.f42475g;
                    this.f42471c = flowCollector;
                    this.f42472d = th;
                    this.f42473e = 1;
                    if (flowCollector.emit(obj2, this) == m8642h) {
                        return m8642h;
                    }
                } else {
                    throw th;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Throwable th2 = (Throwable) this.f42472d;
                FlowCollector flowCollector2 = (FlowCollector) this.f42471c;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    /* renamed from: A */
    public static final <T> InterfaceC14958h<T> m4943A(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    /* renamed from: B */
    public static final <T, R> InterfaceC14958h<R> m4942B(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, R r, @Inference @NotNull InterfaceC15285q<? super R, ? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    /* renamed from: C */
    public static final <T> InterfaceC14958h<T> m4941C(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super T, ? super T, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15285q) {
        return C15006k.m4715K1(interfaceC14958h, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    /* renamed from: D */
    public static final <T> InterfaceC14958h<T> m4940D(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    /* renamed from: E */
    public static final <T> InterfaceC14958h<T> m4939E(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    /* renamed from: F */
    public static final <T> InterfaceC14958h<T> m4938F(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: G */
    public static final <T> void m4937G(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: H */
    public static final <T> void m4936H(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    /* renamed from: I */
    public static final <T> void m4935I(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC15284p<? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p2) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    /* renamed from: J */
    public static final <T> InterfaceC14958h<T> m4934J(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    /* renamed from: K */
    public static final <T, R> InterfaceC14958h<R> m4933K(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        return C15006k.m4618m2(interfaceC14958h, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(interfaceC15284p, null));
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4932a(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    /* renamed from: b */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4931b(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @NotNull InterfaceC15288t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15288t) {
        return C15006k.m4723I(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5, interfaceC15288t);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    /* renamed from: c */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4930c(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC15287s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15287s) {
        return C15006k.m4720J(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC15287s);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    /* renamed from: d */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4929d(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC15286r<? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15286r) {
        return C15006k.m4717K(interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC15286r);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    /* renamed from: e */
    public static final <T1, T2, R> InterfaceC14958h<R> m4928e(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return C15006k.m4714L(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    /* renamed from: f */
    public static final <T, R> InterfaceC14958h<R> m4927f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super InterfaceC14958h<? extends T>, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    /* renamed from: g */
    public static final <T, R> InterfaceC14958h<R> m4926g(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4925h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    @NotNull
    /* renamed from: i */
    public static final <T> InterfaceC14958h<T> m4924i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    /* renamed from: j */
    public static final <T> InterfaceC14958h<T> m4923j(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return C15006k.m4619m1(interfaceC14958h, new C14845a(j, null));
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    /* renamed from: k */
    public static final <T> InterfaceC14958h<T> m4922k(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        return C15006k.m4587v1(interfaceC14958h, new C14846b(j, null));
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    /* renamed from: l */
    public static final <T, R> InterfaceC14958h<R> m4921l(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super InterfaceC14958h<? extends R>>, ? extends Object> interfaceC15284p) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    /* renamed from: m */
    public static final <T> InterfaceC14958h<T> m4920m(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    /* renamed from: n */
    public static final <T> void m4919n(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    /* renamed from: o */
    public static final <T> InterfaceC14958h<T> m4918o(@NotNull InterfaceC14958h<? extends InterfaceC14958h<? extends T>> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @NotNull
    /* renamed from: p */
    public static final Void m4917p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    /* renamed from: q */
    public static final <T> InterfaceC14958h<T> m4916q(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    /* renamed from: r */
    public static final <T> InterfaceC14958h<T> m4915r(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    /* renamed from: s */
    public static final <T> InterfaceC14958h<T> m4914s(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14958h<? extends T> interfaceC14958h2) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    /* renamed from: t */
    public static final <T> InterfaceC14958h<T> m4913t(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    /* renamed from: u */
    public static final <T> InterfaceC14958h<T> m4912u(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, T t, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        return C15006k.m4586w(interfaceC14958h, new C14848d(interfaceC15280l, t, null));
    }

    /* renamed from: v */
    public static /* synthetic */ InterfaceC14958h m4911v(InterfaceC14958h interfaceC14958h, Object obj, InterfaceC15280l interfaceC15280l, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC15280l = C14847c.f42468a;
        }
        return C15006k.m4593t1(interfaceC14958h, obj, interfaceC15280l);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    /* renamed from: w */
    public static final <T> InterfaceC14958h<T> m4910w(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    /* renamed from: x */
    public static final <T> InterfaceC14958h<T> m4909x(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    /* renamed from: y */
    public static final <T> InterfaceC14958h<T> m4908y(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    /* renamed from: z */
    public static final <T> InterfaceC14958h<T> m4907z(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        C15006k.m4631j1();
        throw new ExceptionsH();
    }
}
