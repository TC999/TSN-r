package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExperimentalStdlibApi;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u008e\u0001\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010(\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\t\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\u001a\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001a!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aQ\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u000b\u0010\b\u001a1\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aa\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aa\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001aX\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a`\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u001c\u001a\u00020\u001b2%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a'\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\b\u001a:\u0010 \u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a3\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u001aA\u0010$\u001a\u00028\u0001\"\u0014\b\u0000\u0010\u000f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010\u0013*\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a;\u0010(\u001a\u00020\u001e\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b*\u0010+\u001a<\u0010-\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001H\u0087\n¢\u0006\u0004\b-\u0010.\u001a3\u0010/\u001a\u00020\u001e\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b&*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b/\u0010)\u001a9\u00100\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b&*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0001H\u0087\b¢\u0006\u0004\b0\u0010)\u001a=\u00101\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b1\u0010+\u001a,\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\n¢\u0006\u0004\b3\u00104\u001a,\u00105\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\n¢\u0006\u0004\b5\u00104\u001a1\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\b\u001aE\u00107\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001aE\u00109\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0080\bø\u0001\u0000¢\u0006\u0004\b9\u00108\u001a3\u0010\u0000\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0000\u0010+\u001aE\u0010:\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b:\u00108\u001a9\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001020;\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n\u001a>\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>0=\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0087\n¢\u0006\u0004\b?\u0010@\u001ay\u0010C\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013\"\u0018\b\u0003\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001ay\u0010E\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013\"\u0018\b\u0003\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\bE\u0010D\u001aI\u0010F\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\bF\u0010G\u001a@\u0010I\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H\u001a@\u0010K\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J\u001a\\\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\bø\u0001\u0000\u001a\\\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\bø\u0001\u0000\u001aJ\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000\u001aJ\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000\u001as\u0010Q\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\bQ\u0010D\u001aV\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000\u001as\u0010S\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\bS\u0010D\u001aV\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\bø\u0001\u0000\u001a4\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H\u001aQ\u0010V\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H2\u0006\u0010A\u001a\u00028\u0002¢\u0006\u0004\bV\u0010W\u001a=\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\bX\u0010\b\u001aS\u0010Y\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00042\u0006\u0010A\u001a\u00028\u0002¢\u0006\u0004\bY\u0010Z\u001a4\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J\u001aQ\u0010\\\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J2\u0006\u0010A\u001a\u00028\u0002¢\u0006\u0004\b\\\u0010]\u001a2\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001a2\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001aO\u0010`\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u0002H\u0007¢\u0006\u0004\b`\u0010a\u001aG\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\u0002\u001aM\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050HH\u0086\u0002\u001aV\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0086\u0002¢\u0006\u0004\be\u0010f\u001aM\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050JH\u0086\u0002\u001aI\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010h\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002\u001a=\u0010j\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0087\n\u001aC\u0010k\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050HH\u0087\n\u001aL\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0087\n¢\u0006\u0004\bl\u0010G\u001aC\u0010m\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050JH\u0087\n\u001a=\u0010n\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n\u001aB\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\bo\u0010p\u001aA\u0010r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0087\u0002\u001aJ\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0087\u0002¢\u0006\u0004\bs\u0010t\u001aA\u0010u\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0087\u0002\u001a4\u0010v\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\bv\u0010w\u001a3\u0010x\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0087\n\u001a<\u0010y\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0087\n¢\u0006\u0004\by\u0010z\u001a3\u0010{\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0087\n\u001a0\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006}"}, m12616d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", UMCommonContent.f37777aG, "", "Lkotlin/Pair;", "pairs", ExifInterface.LONGITUDE_WEST, "([Lkotlin/Pair;)Ljava/util/Map;", "", "i0", "j0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "L", "M", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "R", ExifInterface.LATITUDE_SOUTH, "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", UMCommonContent.f37782aL, "", "capacity", "s", "", "O", "P", "l0", "Lkotlin/Function0;", "defaultValue", "N", "(Ljava/util/Map;Ll1/a;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", DomainCampaignEx.LOOPBACK_KEY, IAdInterListener.AdReqParam.WIDTH, "(Ljava/util/Map;Ljava/lang/Object;)Z", "G", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "A0", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "x", "y", "z0", "", "u", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "v", "K0", "H", "(Ljava/util/Map;Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "I", "J", "", "Q", "", "", "h0", "(Ljava/util/Map;)Ljava/util/Iterator;", RtspHeaders.Values.DESTINATION, "transform", "Y", "(Ljava/util/Map;Ljava/util/Map;Ll1/l;)Ljava/util/Map;", "U", "y0", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "w0", "Lkotlin/sequences/m;", "x0", "X", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "B", "F", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "C", "B0", "C0", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "H0", "I0", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "F0", "G0", "(Lkotlin/sequences/m;Ljava/util/Map;)Ljava/util/Map;", "D0", "J0", "E0", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "pair", "o0", "m0", "q0", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", C7202bq.f24604g, "map", "n0", "t0", "r0", "v0", "u0", "s0", "a0", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "Z", "c0", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "b0", "e0", "(Ljava/util/Map;Ljava/lang/Object;)V", "d0", "g0", "(Ljava/util/Map;[Ljava/lang/Object;)V", "f0", "k0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.y0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14239y0 extends MapsJVM {
    @NotNull
    /* renamed from: A */
    public static final <K, V> Map<K, V> m8934A(@NotNull Map<? extends K, ? extends V> filter, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(filter, "$this$filter");
        C14342f0.m8184p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filter.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    /* renamed from: A0 */
    private static final <K, V> void m8933A0(Map<K, V> set, K k, V v) {
        C14342f0.m8184p(set, "$this$set");
        set.put(k, v);
    }

    @NotNull
    /* renamed from: B */
    public static final <K, V> Map<K, V> m8932B(@NotNull Map<? extends K, ? extends V> filterKeys, @NotNull InterfaceC15280l<? super K, Boolean> predicate) {
        C14342f0.m8184p(filterKeys, "$this$filterKeys");
        C14342f0.m8184p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterKeys.entrySet()) {
            if (predicate.invoke((K) entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: B0 */
    public static <K, V> Map<K, V> m8931B0(@NotNull Iterable<? extends Tuples<? extends K, ? extends V>> toMap) {
        Map<K, V> m8865z;
        int m8944j;
        C14342f0.m8184p(toMap, "$this$toMap");
        if (toMap instanceof Collection) {
            Collection collection = (Collection) toMap;
            int size = collection.size();
            if (size == 0) {
                m8865z = m8865z();
                return m8865z;
            } else if (size == 1) {
                return MapsJVM.m8943k(toMap instanceof List ? (Tuples<? extends K, ? extends V>) ((List) toMap).get(0) : toMap.iterator().next());
            } else {
                m8944j = MapsJVM.m8944j(collection.size());
                return m8929C0(toMap, new LinkedHashMap(m8944j));
            }
        }
        return m8887k0(m8929C0(toMap, new LinkedHashMap()));
    }

    @NotNull
    /* renamed from: C */
    public static final <K, V> Map<K, V> m8930C(@NotNull Map<? extends K, ? extends V> filterNot, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(filterNot, "$this$filterNot");
        C14342f0.m8184p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterNot.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: C0 */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8929C0(@NotNull Iterable<? extends Tuples<? extends K, ? extends V>> toMap, @NotNull M destination) {
        C14342f0.m8184p(toMap, "$this$toMap");
        C14342f0.m8184p(destination, "destination");
        m8870w0(destination, toMap);
        return destination;
    }

    @NotNull
    /* renamed from: D */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8928D(@NotNull Map<? extends K, ? extends V> filterNotTo, @NotNull M destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(filterNotTo, "$this$filterNotTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : filterNotTo.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: D0 */
    public static <K, V> Map<K, V> m8927D0(@NotNull Map<? extends K, ? extends V> toMap) {
        Map<K, V> m8865z;
        Map<K, V> m8915J0;
        C14342f0.m8184p(toMap, "$this$toMap");
        int size = toMap.size();
        if (size == 0) {
            m8865z = m8865z();
            return m8865z;
        } else if (size != 1) {
            m8915J0 = m8915J0(toMap);
            return m8915J0;
        } else {
            return MapsJVM.m8939o(toMap);
        }
    }

    @NotNull
    /* renamed from: E */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8926E(@NotNull Map<? extends K, ? extends V> filterTo, @NotNull M destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(filterTo, "$this$filterTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : filterTo.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: E0 */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8925E0(@NotNull Map<? extends K, ? extends V> toMap, @NotNull M destination) {
        C14342f0.m8184p(toMap, "$this$toMap");
        C14342f0.m8184p(destination, "destination");
        destination.putAll(toMap);
        return destination;
    }

    @NotNull
    /* renamed from: F */
    public static final <K, V> Map<K, V> m8924F(@NotNull Map<? extends K, ? extends V> filterValues, @NotNull InterfaceC15280l<? super V, Boolean> predicate) {
        C14342f0.m8184p(filterValues, "$this$filterValues");
        C14342f0.m8184p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterValues.entrySet()) {
            if (predicate.invoke((V) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: F0 */
    public static final <K, V> Map<K, V> m8923F0(@NotNull Sequence<? extends Tuples<? extends K, ? extends V>> toMap) {
        C14342f0.m8184p(toMap, "$this$toMap");
        return m8887k0(m8921G0(toMap, new LinkedHashMap()));
    }

    @InlineOnly
    /* renamed from: G */
    private static final <K, V> V m8922G(Map<? extends K, ? extends V> get, K k) {
        C14342f0.m8184p(get, "$this$get");
        return get.get(k);
    }

    @NotNull
    /* renamed from: G0 */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8921G0(@NotNull Sequence<? extends Tuples<? extends K, ? extends V>> toMap, @NotNull M destination) {
        C14342f0.m8184p(toMap, "$this$toMap");
        C14342f0.m8184p(destination, "destination");
        m8868x0(destination, toMap);
        return destination;
    }

    @InlineOnly
    /* renamed from: H */
    private static final <K, V> V m8920H(Map<K, ? extends V> map, K k, InterfaceC15269a<? extends V> interfaceC15269a) {
        V v = map.get(k);
        return v != null ? v : interfaceC15269a.invoke();
    }

    @NotNull
    /* renamed from: H0 */
    public static final <K, V> Map<K, V> m8919H0(@NotNull Tuples<? extends K, ? extends V>[] toMap) {
        Map<K, V> m8865z;
        int m8944j;
        C14342f0.m8184p(toMap, "$this$toMap");
        int length = toMap.length;
        if (length == 0) {
            m8865z = m8865z();
            return m8865z;
        } else if (length != 1) {
            m8944j = MapsJVM.m8944j(toMap.length);
            return m8917I0(toMap, new LinkedHashMap(m8944j));
        } else {
            return MapsJVM.m8943k(toMap[0]);
        }
    }

    /* renamed from: I */
    public static final <K, V> V m8918I(@NotNull Map<K, ? extends V> getOrElseNullable, K k, @NotNull InterfaceC15269a<? extends V> defaultValue) {
        C14342f0.m8184p(getOrElseNullable, "$this$getOrElseNullable");
        C14342f0.m8184p(defaultValue, "defaultValue");
        V v = getOrElseNullable.get(k);
        return (v != null || getOrElseNullable.containsKey(k)) ? v : defaultValue.invoke();
    }

    @NotNull
    /* renamed from: I0 */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8917I0(@NotNull Tuples<? extends K, ? extends V>[] toMap, @NotNull M destination) {
        C14342f0.m8184p(toMap, "$this$toMap");
        C14342f0.m8184p(destination, "destination");
        m8866y0(destination, toMap);
        return destination;
    }

    /* renamed from: J */
    public static final <K, V> V m8916J(@NotNull Map<K, V> getOrPut, K k, @NotNull InterfaceC15269a<? extends V> defaultValue) {
        C14342f0.m8184p(getOrPut, "$this$getOrPut");
        C14342f0.m8184p(defaultValue, "defaultValue");
        V v = getOrPut.get(k);
        if (v == null) {
            V invoke = defaultValue.invoke();
            getOrPut.put(k, invoke);
            return invoke;
        }
        return v;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: J0 */
    public static <K, V> Map<K, V> m8915J0(@NotNull Map<? extends K, ? extends V> toMutableMap) {
        C14342f0.m8184p(toMutableMap, "$this$toMutableMap");
        return new LinkedHashMap(toMutableMap);
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: K */
    public static final <K, V> V m8914K(@NotNull Map<K, ? extends V> getValue, K k) {
        C14342f0.m8184p(getValue, "$this$getValue");
        return (V) C14235w0.m8961a(getValue, k);
    }

    @InlineOnly
    /* renamed from: K0 */
    private static final <K, V> Tuples<K, V> m8913K0(Map.Entry<? extends K, ? extends V> entry) {
        return new Tuples<>(entry.getKey(), entry.getValue());
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: L */
    private static final <K, V> HashMap<K, V> m8912L() {
        return new HashMap<>();
    }

    @NotNull
    /* renamed from: M */
    public static final <K, V> HashMap<K, V> m8911M(@NotNull Tuples<? extends K, ? extends V>... pairs) {
        int m8944j;
        C14342f0.m8184p(pairs, "pairs");
        m8944j = MapsJVM.m8944j(pairs.length);
        HashMap<K, V> hashMap = new HashMap<>(m8944j);
        m8866y0(hashMap, pairs);
        return hashMap;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Ll1/a<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: N */
    private static final Object m8910N(Map map, InterfaceC15269a interfaceC15269a) {
        return map.isEmpty() ? interfaceC15269a.invoke() : map;
    }

    @InlineOnly
    /* renamed from: O */
    private static final <K, V> boolean m8909O(Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: P */
    private static final <K, V> boolean m8908P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InlineOnly
    /* renamed from: Q */
    private static final <K, V> Iterator<Map.Entry<K, V>> m8907Q(Map<? extends K, ? extends V> iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return (Iterator<Map.Entry<? extends K, ? extends V>>) iterator.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: R */
    private static final <K, V> LinkedHashMap<K, V> m8906R() {
        return new LinkedHashMap<>();
    }

    @NotNull
    /* renamed from: S */
    public static final <K, V> LinkedHashMap<K, V> m8905S(@NotNull Tuples<? extends K, ? extends V>... pairs) {
        int m8944j;
        C14342f0.m8184p(pairs, "pairs");
        m8944j = MapsJVM.m8944j(pairs.length);
        return (LinkedHashMap) m8917I0(pairs, new LinkedHashMap(m8944j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: T */
    public static final <K, V, R> Map<R, V> m8904T(@NotNull Map<? extends K, ? extends V> mapKeys, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int m8944j;
        C14342f0.m8184p(mapKeys, "$this$mapKeys");
        C14342f0.m8184p(transform, "transform");
        m8944j = MapsJVM.m8944j(mapKeys.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m8944j);
        for (Object obj : mapKeys.entrySet()) {
            linkedHashMap.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: U */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M m8903U(@NotNull Map<? extends K, ? extends V> mapKeysTo, @NotNull M destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(mapKeysTo, "$this$mapKeysTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Object obj : mapKeysTo.entrySet()) {
            destination.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return destination;
    }

    @InlineOnly
    /* renamed from: V */
    private static final <K, V> Map<K, V> m8902V() {
        Map<K, V> m8865z;
        m8865z = m8865z();
        return m8865z;
    }

    @NotNull
    /* renamed from: W */
    public static <K, V> Map<K, V> m8901W(@NotNull Tuples<? extends K, ? extends V>... pairs) {
        Map<K, V> m8865z;
        int m8944j;
        C14342f0.m8184p(pairs, "pairs");
        if (pairs.length > 0) {
            m8944j = MapsJVM.m8944j(pairs.length);
            return m8917I0(pairs, new LinkedHashMap(m8944j));
        }
        m8865z = m8865z();
        return m8865z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: X */
    public static final <K, V, R> Map<K, R> m8900X(@NotNull Map<? extends K, ? extends V> mapValues, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int m8944j;
        C14342f0.m8184p(mapValues, "$this$mapValues");
        C14342f0.m8184p(transform, "transform");
        m8944j = MapsJVM.m8944j(mapValues.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m8944j);
        for (Object obj : mapValues.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: Y */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M m8899Y(@NotNull Map<? extends K, ? extends V> mapValuesTo, @NotNull M destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(mapValuesTo, "$this$mapValuesTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Object obj : mapValuesTo.entrySet()) {
            destination.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: Z */
    public static final <K, V> Map<K, V> m8898Z(@NotNull Map<? extends K, ? extends V> minus, @NotNull Iterable<? extends K> keys) {
        Map m8915J0;
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(keys, "keys");
        m8915J0 = m8915J0(minus);
        MutableCollections.m12432G0(m8915J0.keySet(), keys);
        return m8887k0(m8915J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: a0 */
    public static final <K, V> Map<K, V> m8897a0(@NotNull Map<? extends K, ? extends V> minus, K k) {
        Map m8915J0;
        C14342f0.m8184p(minus, "$this$minus");
        m8915J0 = m8915J0(minus);
        m8915J0.remove(k);
        return m8887k0(m8915J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: b0 */
    public static final <K, V> Map<K, V> m8896b0(@NotNull Map<? extends K, ? extends V> minus, @NotNull Sequence<? extends K> keys) {
        Map m8915J0;
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(keys, "keys");
        m8915J0 = m8915J0(minus);
        MutableCollections.m12430I0(m8915J0.keySet(), keys);
        return m8887k0(m8915J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: c0 */
    public static final <K, V> Map<K, V> m8895c0(@NotNull Map<? extends K, ? extends V> minus, @NotNull K[] keys) {
        Map m8915J0;
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(keys, "keys");
        m8915J0 = m8915J0(minus);
        MutableCollections.m12429J0(m8915J0.keySet(), keys);
        return m8887k0(m8915J0);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: d0 */
    private static final <K, V> void m8894d0(Map<K, V> minusAssign, Iterable<? extends K> iterable) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        MutableCollections.m12432G0(minusAssign.keySet(), iterable);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: e0 */
    private static final <K, V> void m8893e0(Map<K, V> minusAssign, K k) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        minusAssign.remove(k);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: f0 */
    private static final <K, V> void m8892f0(Map<K, V> minusAssign, Sequence<? extends K> sequence) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        MutableCollections.m12430I0(minusAssign.keySet(), sequence);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: g0 */
    private static final <K, V> void m8891g0(Map<K, V> minusAssign, K[] kArr) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        MutableCollections.m12429J0(minusAssign.keySet(), kArr);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    /* renamed from: h0 */
    private static final <K, V> Iterator<Map.Entry<K, V>> m8890h0(Map<K, V> iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return iterator.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: i0 */
    private static final <K, V> Map<K, V> m8889i0() {
        return new LinkedHashMap();
    }

    @NotNull
    /* renamed from: j0 */
    public static final <K, V> Map<K, V> m8888j0(@NotNull Tuples<? extends K, ? extends V>... pairs) {
        int m8944j;
        C14342f0.m8184p(pairs, "pairs");
        m8944j = MapsJVM.m8944j(pairs.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(m8944j);
        m8866y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: k0 */
    public static final <K, V> Map<K, V> m8887k0(@NotNull Map<K, ? extends V> optimizeReadOnlyMap) {
        Map<K, V> m8865z;
        C14342f0.m8184p(optimizeReadOnlyMap, "$this$optimizeReadOnlyMap");
        int size = optimizeReadOnlyMap.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlyMap : MapsJVM.m8939o(optimizeReadOnlyMap);
        }
        m8865z = m8865z();
        return m8865z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: l0 */
    private static final <K, V> Map<K, V> m8886l0(Map<K, ? extends V> map) {
        Map<K, V> m8865z;
        if (map != 0) {
            return map;
        }
        m8865z = m8865z();
        return m8865z;
    }

    @NotNull
    /* renamed from: m0 */
    public static final <K, V> Map<K, V> m8885m0(@NotNull Map<? extends K, ? extends V> plus, @NotNull Iterable<? extends Tuples<? extends K, ? extends V>> pairs) {
        Map<K, V> m8931B0;
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(pairs, "pairs");
        if (plus.isEmpty()) {
            m8931B0 = m8931B0(pairs);
            return m8931B0;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        m8870w0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: n0 */
    public static final <K, V> Map<K, V> m8884n0(@NotNull Map<? extends K, ? extends V> plus, @NotNull Map<? extends K, ? extends V> map) {
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: o0 */
    public static final <K, V> Map<K, V> m8883o0(@NotNull Map<? extends K, ? extends V> plus, @NotNull Tuples<? extends K, ? extends V> pair) {
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(pair, "pair");
        if (plus.isEmpty()) {
            return MapsJVM.m8943k(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    @NotNull
    /* renamed from: p0 */
    public static final <K, V> Map<K, V> m8882p0(@NotNull Map<? extends K, ? extends V> plus, @NotNull Sequence<? extends Tuples<? extends K, ? extends V>> pairs) {
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        m8868x0(linkedHashMap, pairs);
        return m8887k0(linkedHashMap);
    }

    @NotNull
    /* renamed from: q0 */
    public static final <K, V> Map<K, V> m8881q0(@NotNull Map<? extends K, ? extends V> plus, @NotNull Tuples<? extends K, ? extends V>[] pairs) {
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(pairs, "pairs");
        if (plus.isEmpty()) {
            return m8919H0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        m8866y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @InlineOnly
    /* renamed from: r0 */
    private static final <K, V> void m8880r0(Map<? super K, ? super V> plusAssign, Iterable<? extends Tuples<? extends K, ? extends V>> iterable) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m8870w0(plusAssign, iterable);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: s */
    private static final <K, V> Map<K, V> m8879s(int i, @Inference InterfaceC15280l<? super Map<K, V>, Unit> interfaceC15280l) {
        Map m8946h = MapsJVM.m8946h(i);
        interfaceC15280l.invoke(m8946h);
        return MapsJVM.m8950d(m8946h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: s0 */
    private static final <K, V> void m8878s0(Map<? super K, ? super V> plusAssign, Map<K, ? extends V> map) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        plusAssign.putAll(map);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: t */
    private static final <K, V> Map<K, V> m8877t(@Inference InterfaceC15280l<? super Map<K, V>, Unit> interfaceC15280l) {
        Map m8947g = MapsJVM.m8947g();
        interfaceC15280l.invoke(m8947g);
        return MapsJVM.m8950d(m8947g);
    }

    @InlineOnly
    /* renamed from: t0 */
    private static final <K, V> void m8876t0(Map<? super K, ? super V> plusAssign, Tuples<? extends K, ? extends V> tuples) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        plusAssign.put((K) tuples.getFirst(), (V) tuples.getSecond());
    }

    @InlineOnly
    /* renamed from: u */
    private static final <K, V> K m8875u(Map.Entry<? extends K, ? extends V> component1) {
        C14342f0.m8184p(component1, "$this$component1");
        return component1.getKey();
    }

    @InlineOnly
    /* renamed from: u0 */
    private static final <K, V> void m8874u0(Map<? super K, ? super V> plusAssign, Sequence<? extends Tuples<? extends K, ? extends V>> sequence) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m8868x0(plusAssign, sequence);
    }

    @InlineOnly
    /* renamed from: v */
    private static final <K, V> V m8873v(Map.Entry<? extends K, ? extends V> component2) {
        C14342f0.m8184p(component2, "$this$component2");
        return component2.getValue();
    }

    @InlineOnly
    /* renamed from: v0 */
    private static final <K, V> void m8872v0(Map<? super K, ? super V> plusAssign, Tuples<? extends K, ? extends V>[] tuplesArr) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m8866y0(plusAssign, tuplesArr);
    }

    @InlineOnly
    /* renamed from: w */
    private static final <K, V> boolean m8871w(Map<? extends K, ? extends V> contains, K k) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.containsKey(k);
    }

    /* renamed from: w0 */
    public static final <K, V> void m8870w0(@NotNull Map<? super K, ? super V> putAll, @NotNull Iterable<? extends Tuples<? extends K, ? extends V>> pairs) {
        C14342f0.m8184p(putAll, "$this$putAll");
        C14342f0.m8184p(pairs, "pairs");
        for (Tuples<? extends K, ? extends V> tuples : pairs) {
            putAll.put((K) tuples.component1(), (V) tuples.component2());
        }
    }

    @InlineOnly
    /* renamed from: x */
    private static final <K> boolean m8869x(Map<? extends K, ?> map, K k) {
        if (map != null) {
            return map.containsKey(k);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* renamed from: x0 */
    public static final <K, V> void m8868x0(@NotNull Map<? super K, ? super V> putAll, @NotNull Sequence<? extends Tuples<? extends K, ? extends V>> pairs) {
        C14342f0.m8184p(putAll, "$this$putAll");
        C14342f0.m8184p(pairs, "pairs");
        for (Tuples<? extends K, ? extends V> tuples : pairs) {
            putAll.put((K) tuples.component1(), (V) tuples.component2());
        }
    }

    @InlineOnly
    /* renamed from: y */
    private static final <K, V> boolean m8867y(Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    /* renamed from: y0 */
    public static final <K, V> void m8866y0(@NotNull Map<? super K, ? super V> putAll, @NotNull Tuples<? extends K, ? extends V>[] pairs) {
        C14342f0.m8184p(putAll, "$this$putAll");
        C14342f0.m8184p(pairs, "pairs");
        for (Tuples<? extends K, ? extends V> tuples : pairs) {
            putAll.put((K) tuples.component1(), (V) tuples.component2());
        }
    }

    @NotNull
    /* renamed from: z */
    public static <K, V> Map<K, V> m8865z() {
        Maps maps = Maps.f40901a;
        if (maps != null) {
            return maps;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @InlineOnly
    /* renamed from: z0 */
    private static final <K, V> V m8864z0(Map<? extends K, V> map, K k) {
        if (map != null) {
            return (V) TypeIntrinsics.m8016k(map).remove(k);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
