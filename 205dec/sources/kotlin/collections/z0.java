package kotlin.collections;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Maps.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008e\u0001\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010(\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\t\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\u001a\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001a!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aQ\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\b\u001a1\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aa\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b\u001aa\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001aX\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0002\b\u0018H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a`\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u001c\u001a\u00020\u001b2%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0002\b\u0018H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a'\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\b\u001a:\u0010 \u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a3\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u001aA\u0010$\u001a\u00028\u0001\"\u0014\b\u0000\u0010\u000f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010\u0013*\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%\u001a;\u0010(\u001a\u00020\u001e\"\t\b\u0000\u0010\u0000\u00a2\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000\u00a2\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b*\u0010+\u001a<\u0010-\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001H\u0087\n\u00a2\u0006\u0004\b-\u0010.\u001a3\u0010/\u001a\u00020\u001e\"\t\b\u0000\u0010\u0000\u00a2\u0006\u0002\b&*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b/\u0010)\u001a9\u00100\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\t\b\u0001\u0010\u0001\u00a2\u0006\u0002\b&*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0001H\u0087\b\u00a2\u0006\u0004\b0\u0010)\u001a=\u00101\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000\u00a2\u0006\u0002\b&\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b1\u0010+\u001a,\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\n\u00a2\u0006\u0004\b3\u00104\u001a,\u00105\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\n\u00a2\u0006\u0004\b5\u00104\u001a1\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0087\b\u001aE\u00107\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108\u001aE\u00109\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u00108\u001a3\u0010\u0000\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0000\u0010+\u001aE\u0010:\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u00108\u001a9\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001020;\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n\u001a>\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>0=\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0087\n\u00a2\u0006\u0004\b?\u0010@\u001ay\u0010C\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013\"\u0018\b\u0003\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010D\u001ay\u0010E\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013\"\u0018\b\u0003\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010D\u001aI\u0010F\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u00a2\u0006\u0004\bF\u0010G\u001a@\u0010I\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H\u001a@\u0010K\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J\u001a\\\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b\u00f8\u0001\u0000\u001a\\\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b\u00f8\u0001\u0000\u001aJ\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u001aJ\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u001as\u0010Q\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010D\u001aV\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u001as\u0010S\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010D\u001aV\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010N\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0004\u0012\u00020\u001e0\u0016H\u0086\b\u00f8\u0001\u0000\u001a4\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H\u001aQ\u0010V\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050H2\u0006\u0010A\u001a\u00028\u0002\u00a2\u0006\u0004\bV\u0010W\u001a=\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u00a2\u0006\u0004\bX\u0010\b\u001aS\u0010Y\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00042\u0006\u0010A\u001a\u00028\u0002\u00a2\u0006\u0004\bY\u0010Z\u001a4\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J\u001aQ\u0010\\\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050J2\u0006\u0010A\u001a\u00028\u0002\u00a2\u0006\u0004\b\\\u0010]\u001a2\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001a2\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001aO\u0010`\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u000f*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010A\u001a\u00028\u0002H\u0007\u00a2\u0006\u0004\b`\u0010a\u001aG\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\u0002\u001aM\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050HH\u0086\u0002\u001aV\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0086\u0002\u00a2\u0006\u0004\be\u0010f\u001aM\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050JH\u0086\u0002\u001aI\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010h\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002\u001a=\u0010j\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0087\n\u001aC\u0010k\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050HH\u0087\n\u001aL\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0087\n\u00a2\u0006\u0004\bl\u0010G\u001aC\u0010m\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050JH\u0087\n\u001a=\u0010n\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n\u001aB\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010'\u001a\u00028\u0000H\u0087\u0002\u00a2\u0006\u0004\bo\u0010p\u001aA\u0010r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0087\u0002\u001aJ\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0087\u0002\u00a2\u0006\u0004\bs\u0010t\u001aA\u0010u\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0087\u0002\u001a4\u0010v\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010'\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\bv\u0010w\u001a3\u0010x\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0087\n\u001a<\u0010y\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0087\n\u00a2\u0006\u0004\by\u0010z\u001a3\u0010{\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0087\n\u001a0\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006}"}, d2 = {"K", "V", "", "z", "", "Lkotlin/Pair;", "pairs", "W", "([Lkotlin/Pair;)Ljava/util/Map;", "", "i0", "j0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "L", "M", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "R", "S", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "t", "", "capacity", "s", "", "O", "P", "l0", "Lkotlin/Function0;", "defaultValue", "N", "(Ljava/util/Map;Ld2/a;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", DomainCampaignEx.LOOPBACK_KEY, "w", "(Ljava/util/Map;Ljava/lang/Object;)Z", "G", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "value", "A0", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "x", "y", "z0", "", "u", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "v", "K0", "H", "(Ljava/util/Map;Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "I", "J", "", "Q", "", "", "h0", "(Ljava/util/Map;)Ljava/util/Iterator;", "destination", "transform", "Y", "(Ljava/util/Map;Ljava/util/Map;Ld2/l;)Ljava/util/Map;", "U", "y0", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "w0", "Lkotlin/sequences/m;", "x0", "X", "T", "predicate", "B", "F", "E", "A", "D", "C", "B0", "C0", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "H0", "I0", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "F0", "G0", "(Lkotlin/sequences/m;Ljava/util/Map;)Ljava/util/Map;", "D0", "J0", "E0", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "pair", "o0", "m0", "q0", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "p0", "map", "n0", "t0", "r0", "v0", "u0", "s0", "a0", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "Z", "c0", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "b0", "e0", "(Ljava/util/Map;Ljava/lang/Object;)V", "d0", "g0", "(Ljava/util/Map;[Ljava/lang/Object;)V", "f0", "k0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/MapsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class z0 extends y0 {
    @NotNull
    public static final <K, V> Map<K, V> A(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void A0(Map<K, V> map, K k4, V v3) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        map.put(k4, v3);
    }

    @NotNull
    public static final <K, V> Map<K, V> B(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super K, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke((K) entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> B0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Map<K, V> z3;
        Map<K, V> k4;
        int j4;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                z3 = z();
                return z3;
            } else if (size != 1) {
                j4 = y0.j(collection.size());
                return C0(iterable, new LinkedHashMap(j4));
            } else {
                k4 = y0.k(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
                return k4;
            }
        }
        return k0(C0(iterable, new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V> Map<K, V> C(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M destination) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        w0(destination, iterable);
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> D0(@NotNull Map<? extends K, ? extends V> map) {
        Map<K, V> z3;
        Map<K, V> J0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        int size = map.size();
        if (size == 0) {
            z3 = z();
            return z3;
        } else if (size != 1) {
            J0 = J0(map);
            return J0;
        } else {
            return y0.o(map);
        }
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, V> F(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super V, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke((V) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> F0(@NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        return k0(G0(mVar, new LinkedHashMap()));
    }

    @InlineOnly
    private static final <K, V> V G(Map<? extends K, ? extends V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.get(k4);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar, @NotNull M destination) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        x0(destination, mVar);
        return destination;
    }

    @InlineOnly
    private static final <K, V> V H(Map<K, ? extends V> map, K k4, d2.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v3 = map.get(k4);
        return v3 == null ? defaultValue.invoke() : v3;
    }

    @NotNull
    public static final <K, V> Map<K, V> H0(@NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Map<K, V> z3;
        Map<K, V> k4;
        int j4;
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        int length = pairArr.length;
        if (length == 0) {
            z3 = z();
            return z3;
        } else if (length != 1) {
            j4 = y0.j(pairArr.length);
            return I0(pairArr, new LinkedHashMap(j4));
        } else {
            k4 = y0.k(pairArr[0]);
            return k4;
        }
    }

    public static final <K, V> V I(@NotNull Map<K, ? extends V> map, K k4, @NotNull d2.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v3 = map.get(k4);
        return (v3 != null || map.containsKey(k4)) ? v3 : defaultValue.invoke();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M destination) {
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        y0(destination, pairArr);
        return destination;
    }

    public static final <K, V> V J(@NotNull Map<K, V> map, K k4, @NotNull d2.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v3 = map.get(k4);
        if (v3 == null) {
            V invoke = defaultValue.invoke();
            map.put(k4, invoke);
            return invoke;
        }
        return v3;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> J0(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> V K(@NotNull Map<K, ? extends V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return (V) x0.a(map, k4);
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @NotNull
    public static <K, V> HashMap<K, V> M(@NotNull Pair<? extends K, ? extends V>... pairs) {
        int j4;
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        j4 = y0.j(pairs.length);
        HashMap<K, V> hashMap = new HashMap<>(j4);
        y0(hashMap, pairs);
        return hashMap;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Ld2/a<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object N(Map map, d2.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map.isEmpty() ? defaultValue.invoke() : map;
    }

    @InlineOnly
    private static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return (Iterator<Map.Entry<? extends K, ? extends V>>) map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> S(@NotNull Pair<? extends K, ? extends V>... pairs) {
        int j4;
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        j4 = y0.j(pairs.length);
        return (LinkedHashMap) I0(pairs, new LinkedHashMap(j4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R> Map<R, V> T(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int j4;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        j4 = y0.j(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (Object obj : map.entrySet()) {
            destination.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return destination;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> V() {
        Map<K, V> z3;
        z3 = z();
        return z3;
    }

    @NotNull
    public static <K, V> Map<K, V> W(@NotNull Pair<? extends K, ? extends V>... pairs) {
        Map<K, V> z3;
        int j4;
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        if (pairs.length > 0) {
            j4 = y0.j(pairs.length);
            return I0(pairs, new LinkedHashMap(j4));
        }
        z3 = z();
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R> Map<K, R> X(@NotNull Map<? extends K, ? extends V> map, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int j4;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        j4 = y0.j(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull d2.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (Object obj : map.entrySet()) {
            destination.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> Z(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends K> keys) {
        Map J0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        J0 = J0(map);
        c0.E0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> a0(@NotNull Map<? extends K, ? extends V> map, K k4) {
        Map J0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        J0 = J0(map);
        J0.remove(k4);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> b0(@NotNull Map<? extends K, ? extends V> map, @NotNull kotlin.sequences.m<? extends K> keys) {
        Map J0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        J0 = J0(map);
        c0.G0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> c0(@NotNull Map<? extends K, ? extends V> map, @NotNull K[] keys) {
        Map J0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        J0 = J0(map);
        c0.H0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void d0(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        c0.E0(map.keySet(), keys);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void e0(Map<K, V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        map.remove(k4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void f0(Map<K, V> map, kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        c0.G0(map.keySet(), keys);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void g0(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        c0.H0(map.keySet(), keys);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @NotNull
    public static <K, V> Map<K, V> j0(@NotNull Pair<? extends K, ? extends V>... pairs) {
        int j4;
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        j4 = y0.j(pairs.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> k0(@NotNull Map<K, ? extends V> map) {
        Map<K, V> z3;
        kotlin.jvm.internal.f0.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : y0.o(map);
        }
        z3 = z();
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        Map<K, V> z3;
        if (map == 0) {
            z3 = z();
            return z3;
        }
        return map;
    }

    @NotNull
    public static final <K, V> Map<K, V> m0(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Map<K, V> B0;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        if (map.isEmpty()) {
            B0 = B0(pairs);
            return B0;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> n0(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> o0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V> pair) {
        Map<K, V> k4;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pair, "pair");
        if (map.isEmpty()) {
            k4 = y0.k(pair);
            return k4;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> p0(@NotNull Map<? extends K, ? extends V> map, @NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, pairs);
        return k0(linkedHashMap);
    }

    @NotNull
    public static final <K, V> Map<K, V> q0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return H0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void r0(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        w0(map, pairs);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <K, V> Map<K, V> s(int i4, @BuilderInference d2.l<? super Map<K, V>, kotlin.f1> builderAction) {
        Map h4;
        Map<K, V> d4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        h4 = y0.h(i4);
        builderAction.invoke(h4);
        d4 = y0.d(h4);
        return d4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> void s0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(map2, "map");
        map.putAll(map2);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <K, V> Map<K, V> t(@BuilderInference d2.l<? super Map<K, V>, kotlin.f1> builderAction) {
        Map g4;
        Map<K, V> d4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        g4 = y0.g();
        builderAction.invoke(g4);
        d4 = y0.d(g4);
        return d4;
    }

    @InlineOnly
    private static final <K, V> void t0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pair, "pair");
        map.put((K) pair.getFirst(), (V) pair.getSecond());
    }

    @InlineOnly
    private static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return entry.getKey();
    }

    @InlineOnly
    private static final <K, V> void u0(Map<? super K, ? super V> map, kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        x0(map, pairs);
    }

    @InlineOnly
    private static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return entry.getValue();
    }

    @InlineOnly
    private static final <K, V> void v0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        y0(map, pairs);
    }

    @InlineOnly
    private static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsKey(k4);
    }

    public static final <K, V> void w0(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @InlineOnly
    private static final <K> boolean x(Map<? extends K, ?> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsKey(k4);
    }

    public static final <K, V> void x0(@NotNull Map<? super K, ? super V> map, @NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @InlineOnly
    private static final <K, V> boolean y(Map<K, ? extends V> map, V v3) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsValue(v3);
    }

    public static final <K, V> void y0(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        int length = pairs.length;
        int i4 = 0;
        while (i4 < length) {
            Pair<? extends K, ? extends V> pair = pairs[i4];
            i4++;
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> z() {
        return i0.f55334a;
    }

    @InlineOnly
    private static final <K, V> V z0(Map<? extends K, V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.remove(k4);
    }
}
