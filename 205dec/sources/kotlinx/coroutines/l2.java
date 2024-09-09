package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: JobSupport.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {}, d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004}y\u00cc\u0001B\u0012\u0012\u0007\u0010\u00c9\u0001\u001a\u00020\u001b\u00a2\u0006\u0006\b\u00ca\u0001\u0010\u00cb\u0001J&\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0082\b\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u0007*\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b'\u0010$J2\u0010*\u001a\u00020\u0007\"\u000e\b\u0000\u0010)\u0018\u0001*\u0006\u0012\u0002\b\u00030(2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0082\b\u00a2\u0006\u0004\b*\u0010$J\u0019\u0010,\u001a\u00020+2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b,\u0010-JD\u00103\u001a\u0006\u0012\u0002\b\u00030(2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`02\u0006\u00102\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b3\u00104J+\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\n\u00106\u001a\u0006\u0012\u0002\b\u00030(H\u0002\u00a2\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00072\u0006\u0010\r\u001a\u000209H\u0002\u00a2\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\u00072\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030(H\u0002\u00a2\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bB\u0010CJ\u001b\u0010D\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bD\u0010AJ\u0019\u0010E\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bI\u0010JJ#\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010\r\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\bN\u0010OJ*\u0010Q\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010P\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0082\u0010\u00a2\u0006\u0004\bQ\u0010RJ)\u0010T\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010S\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u0004\u0018\u00010M*\u00020VH\u0002\u00a2\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020Y2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u001b\u00a2\u0006\u0004\b_\u0010?J\u000f\u0010`\u001a\u00020\u0007H\u0010\u00a2\u0006\u0004\b`\u0010aJ\u0011\u0010d\u001a\u00060bj\u0002`c\u00a2\u0006\u0004\bd\u0010eJ#\u0010g\u001a\u00060bj\u0002`c*\u00020\u00122\n\b\u0002\u0010f\u001a\u0004\u0018\u00010YH\u0004\u00a2\u0006\u0004\bg\u0010hJ6\u0010j\u001a\u00020i2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0\u00a2\u0006\u0004\bj\u0010kJF\u0010m\u001a\u00020i2\u0006\u00102\u001a\u00020\u001b2\u0006\u0010l\u001a\u00020\u001b2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0\u00a2\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010pJ\u0013\u0010q\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010pJB\u0010v\u001a\u00020\u0007\"\u0004\b\u0000\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00000s2\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000u\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\bv\u0010wJ\u001b\u0010x\u001a\u00020\u00072\n\u00106\u001a\u0006\u0012\u0002\b\u00030(H\u0000\u00a2\u0006\u0004\bx\u0010=J\u001f\u0010y\u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0018\u00010bj\u0004\u0018\u0001`cH\u0016\u00a2\u0006\u0004\by\u0010zJ\u000f\u0010{\u001a\u00020YH\u0014\u00a2\u0006\u0004\b{\u0010|J\u0019\u0010}\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0017\u00a2\u0006\u0004\b}\u0010&J\u0017\u0010~\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b~\u0010\u007fJ\u0019\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0003\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0019\u0010\u0083\u0001\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0016\u00a2\u0006\u0005\b\u0083\u0001\u0010&J\u0019\u0010\u0084\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0005\b\u0084\u0001\u0010&J\u001c\u0010\u0085\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J,\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010Y2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0080\b\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0015\u0010\u008a\u0001\u001a\u00060bj\u0002`cH\u0016\u00a2\u0006\u0005\b\u008a\u0001\u0010eJ\u001c\u0010\u008b\u0001\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0006\b\u008b\u0001\u0010\u0086\u0001J\u001d\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0005\b\u008c\u0001\u0010AJ\u0017\u0010r\u001a\u00030\u008d\u00012\u0006\u0010P\u001a\u00020\u0002\u00a2\u0006\u0005\br\u0010\u008e\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0012H\u0010\u00a2\u0006\u0005\b\u0090\u0001\u0010\u007fJ\u001b\u0010\u0091\u0001\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0014\u00a2\u0006\u0005\b\u0091\u0001\u0010\u007fJ\u001a\u0010\u0092\u0001\u001a\u00020\u001b2\u0007\u0010\u008f\u0001\u001a\u00020\u0012H\u0014\u00a2\u0006\u0005\b\u0092\u0001\u0010&J\u001c\u0010\u0093\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001c\u0010\u0095\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001J\u0011\u0010\u0096\u0001\u001a\u00020YH\u0016\u00a2\u0006\u0005\b\u0096\u0001\u0010|J\u0011\u0010\u0097\u0001\u001a\u00020YH\u0007\u00a2\u0006\u0005\b\u0097\u0001\u0010|J\u0011\u0010\u0098\u0001\u001a\u00020YH\u0010\u00a2\u0006\u0005\b\u0098\u0001\u0010|J\u0012\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0014\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0017\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u009d\u0001\u0010pJ\u0017\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u009e\u0001\u0010pJT\u0010\u00a0\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u009f\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u00a1\u0001JT\u0010\u00a2\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u009f\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00a2\u0001\u0010\u00a1\u0001R\u001e\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u00068BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00a3\u0001\u0010CR\u001b\u0010\u00a7\u0001\u001a\u00020\u001b*\u00020\u00198BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0019\u0010\u00ab\u0001\u001a\u0007\u0012\u0002\b\u00030\u00a8\u00018F\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R0\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u008d\u00018@@@X\u0080\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00b2\u0001\u0010\u009c\u0001R\u0016\u0010\u00b3\u0001\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b3\u0001\u0010?R\u0013\u0010\u00b4\u0001\u001a\u00020\u001b8F\u00a2\u0006\u0007\u001a\u0005\b\u00b4\u0001\u0010?R\u0013\u0010\u00b5\u0001\u001a\u00020\u001b8F\u00a2\u0006\u0007\u001a\u0005\b\u00b5\u0001\u0010?R\u0019\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004\u00a2\u0006\b\u001a\u0006\b\u00b6\u0001\u0010\u009a\u0001R\u0016\u0010\u00b9\u0001\u001a\u00020\u001b8DX\u0084\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b8\u0001\u0010?R\u0014\u0010\u00bc\u0001\u001a\u00020\u00048F\u00a2\u0006\b\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0016\u0010\u00be\u0001\u001a\u00020\u001b8PX\u0090\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00bd\u0001\u0010?R\u001b\u0010\u00c2\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u00bf\u00018F\u00a2\u0006\b\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u0016\u0010\u00c4\u0001\u001a\u00020\u001b8TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00c3\u0001\u0010?R\u0016\u0010\u00c6\u0001\u001a\u00020\u001b8PX\u0090\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00c5\u0001\u0010?R\u0013\u0010\u00c8\u0001\u001a\u00020\u001b8F\u00a2\u0006\u0007\u001a\u0005\b\u00c7\u0001\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00cd\u0001"}, d2 = {"Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/u2;", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "", "Lkotlin/f1;", "block", "", "H0", "(Ld2/l;)Ljava/lang/Void;", "Lkotlinx/coroutines/l2$c;", "state", "proposedUpdate", "n0", "(Lkotlinx/coroutines/l2$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "t0", "(Lkotlinx/coroutines/l2$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "X", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/y1;", "update", "", "f1", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)Z", "i0", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/q2;", "list", "cause", "O0", "(Lkotlinx/coroutines/q2;Ljava/lang/Throwable;)V", "f0", "(Ljava/lang/Throwable;)Z", "P0", "Lkotlinx/coroutines/k2;", "T", "Q0", "", "a1", "(Ljava/lang/Object;)I", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "L0", "(Ld2/l;Z)Lkotlinx/coroutines/k2;", "expect", "node", "W", "(Ljava/lang/Object;Lkotlinx/coroutines/q2;Lkotlinx/coroutines/k2;)Z", "Lkotlinx/coroutines/l1;", "U0", "(Lkotlinx/coroutines/l1;)V", "V0", "(Lkotlinx/coroutines/k2;)V", "F0", "()Z", "e0", "(Ljava/lang/Object;)Ljava/lang/Object;", "k0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "I0", "w0", "(Lkotlinx/coroutines/y1;)Lkotlinx/coroutines/q2;", "g1", "(Lkotlinx/coroutines/y1;Ljava/lang/Throwable;)Z", "h1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "i1", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/v;", "o0", "(Lkotlinx/coroutines/y1;)Lkotlinx/coroutines/v;", "child", "j1", "(Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)Z", "lastChild", "j0", "(Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/s;", "N0", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/v;", "", "b1", "(Ljava/lang/Object;)Ljava/lang/String;", "parent", "B0", "(Lkotlinx/coroutines/e2;)V", CampaignEx.JSON_NATIVE_VIDEO_START, "T0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "l", "()Ljava/util/concurrent/CancellationException;", "message", "c1", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/i1;", "m", "(Ld2/l;)Lkotlinx/coroutines/i1;", "invokeImmediately", "z", "(ZZLd2/l;)Lkotlinx/coroutines/i1;", "A", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "G0", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/coroutines/c;", "N", "(Lkotlinx/coroutines/selects/f;Ld2/l;)V", "X0", "b", "(Ljava/util/concurrent/CancellationException;)V", "g0", "()Ljava/lang/String;", "a", "d0", "(Ljava/lang/Throwable;)V", "parentJob", "i", "(Lkotlinx/coroutines/u2;)V", "h0", "b0", "c0", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/JobCancellationException;", "l0", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "x", "J0", "K0", "Lkotlinx/coroutines/u;", "(Lkotlinx/coroutines/w;)Lkotlinx/coroutines/u;", "exception", "A0", "R0", "z0", "S0", "(Ljava/lang/Object;)V", "Y", "toString", "e1", "M0", "j", "()Ljava/lang/Throwable;", "p0", "()Ljava/lang/Object;", "Z", "a0", "Lkotlin/Function2;", "W0", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "Y0", "s0", "exceptionOrNull", "C0", "(Lkotlinx/coroutines/y1;)Z", "isCancelling", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "value", "x0", "()Lkotlinx/coroutines/u;", "Z0", "(Lkotlinx/coroutines/u;)V", "parentHandle", "y0", "isActive", "isCompleted", "isCancelled", "q0", "completionCause", "r0", "completionCauseHandled", "M", "()Lkotlinx/coroutines/selects/c;", "onJoin", "v0", "onCancelComplete", "Lkotlin/sequences/m;", "h", "()Lkotlin/sequences/m;", "children", "E0", "isScopedCoroutine", "u0", "handlesException", "D0", "isCompletedExceptionally", "active", "<init>", "(Z)V", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l2 implements e2, w, u2, kotlinx.coroutines.selects.c {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60469a = AtomicReferenceFieldUpdater.newUpdater(l2.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/l2$a;", "T", "Lkotlinx/coroutines/p;", "Lkotlinx/coroutines/e2;", "parent", "", "w", "", "E", "Lkotlinx/coroutines/l2;", "h", "Lkotlinx/coroutines/l2;", "job", "Lkotlin/coroutines/c;", "delegate", "<init>", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/l2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends p<T> {

        /* renamed from: h  reason: collision with root package name */
        private final l2 f60470h;

        public a(@NotNull kotlin.coroutines.c<? super T> cVar, @NotNull l2 l2Var) {
            super(cVar, 1);
            this.f60470h = l2Var;
        }

        @Override // kotlinx.coroutines.p
        @NotNull
        protected String E() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.p
        @NotNull
        public Throwable w(@NotNull e2 e2Var) {
            Throwable d4;
            Object y02 = this.f60470h.y0();
            return (!(y02 instanceof c) || (d4 = ((c) y02).d()) == null) ? y02 instanceof d0 ? ((d0) y02).f59534a : e2Var.l() : d4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/l2$b;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/l2;", "e", "Lkotlinx/coroutines/l2;", "parent", "Lkotlinx/coroutines/l2$c;", "f", "Lkotlinx/coroutines/l2$c;", "state", "Lkotlinx/coroutines/v;", "g", "Lkotlinx/coroutines/v;", "child", "", "h", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends k2<e2> {

        /* renamed from: e  reason: collision with root package name */
        private final l2 f60471e;

        /* renamed from: f  reason: collision with root package name */
        private final c f60472f;

        /* renamed from: g  reason: collision with root package name */
        private final v f60473g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f60474h;

        public b(@NotNull l2 l2Var, @NotNull c cVar, @NotNull v vVar, @Nullable Object obj) {
            super(vVar.f60745e);
            this.f60471e = l2Var;
            this.f60472f = cVar;
            this.f60473g = vVar;
            this.f60474h = obj;
        }

        @Override // kotlinx.coroutines.f0
        public void h0(@Nullable Throwable th) {
            this.f60471e.j0(this.f60472f, this.f60473g, this.f60474h);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
            h0(th);
            return kotlin.f1.f55527a;
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "ChildCompletion[" + this.f60473g + ", " + this.f60474h + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b.\u0010/J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0010R\u0011\u0010*\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010!R\u0011\u0010,\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010!R\u0014\u0010-\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010!\u00a8\u00060"}, d2 = {"Lkotlinx/coroutines/l2$c;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/y1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "()Ljava/util/ArrayList;", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lkotlin/f1;", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/q2;", "Lkotlinx/coroutines/q2;", "f", "()Lkotlinx/coroutines/q2;", "list", "value", "c", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "g", "()Z", "j", "(Z)V", "isCompleting", "d", "()Ljava/lang/Throwable;", "l", "rootCause", "h", "isSealed", "e", "isCancelling", "isActive", "<init>", "(Lkotlinx/coroutines/q2;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements y1 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final q2 f60475a;

        public c(@NotNull q2 q2Var, boolean z3, @Nullable Throwable th) {
            this.f60475a = q2Var;
            this._isCompleting = z3 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull Throwable th) {
            Throwable d4 = d();
            if (d4 == null) {
                l(th);
            } else if (th == d4) {
            } else {
                Object c4 = c();
                if (c4 == null) {
                    k(th);
                } else if (!(c4 instanceof Throwable)) {
                    if (c4 instanceof ArrayList) {
                        ((ArrayList) c4).add(th);
                        return;
                    }
                    throw new IllegalStateException(("State is " + c4).toString());
                } else if (th == c4) {
                } else {
                    ArrayList<Throwable> b4 = b();
                    b4.add(c4);
                    b4.add(th);
                    kotlin.f1 f1Var = kotlin.f1.f55527a;
                    k(b4);
                }
            }
        }

        @Nullable
        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return d() != null;
        }

        @Override // kotlinx.coroutines.y1
        @NotNull
        public q2 f() {
            return this.f60475a;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.j0 j0Var;
            Object c4 = c();
            j0Var = m2.f60504h;
            return c4 == j0Var;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.j0 j0Var;
            Object c4 = c();
            if (c4 == null) {
                arrayList = b();
            } else if (c4 instanceof Throwable) {
                ArrayList<Throwable> b4 = b();
                b4.add(c4);
                arrayList = b4;
            } else if (!(c4 instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + c4).toString());
            } else {
                arrayList = (ArrayList) c4;
            }
            Throwable d4 = d();
            if (d4 != null) {
                arrayList.add(0, d4);
            }
            if (th != null && (!kotlin.jvm.internal.f0.g(th, d4))) {
                arrayList.add(th);
            }
            j0Var = m2.f60504h;
            k(j0Var);
            return arrayList;
        }

        @Override // kotlinx.coroutines.y1
        public boolean isActive() {
            return d() == null;
        }

        public final void j(boolean z3) {
            this._isCompleting = z3 ? 1 : 0;
        }

        public final void l(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + g() + ", rootCause=" + d() + ", exceptions=" + c() + ", list=" + f() + ']';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends s.c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.s f60476d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l2 f60477e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f60478f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.s sVar, kotlinx.coroutines.internal.s sVar2, l2 l2Var, Object obj) {
            super(sVar2);
            this.f60476d = sVar;
            this.f60477e = l2Var;
            this.f60478f = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (this.f60477e.y0() == this.f60478f) {
                return null;
            }
            return kotlinx.coroutines.internal.r.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/o;", "Lkotlinx/coroutines/w;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends RestrictedSuspendLambda implements d2.p<kotlin.sequences.o<? super w>, kotlin.coroutines.c<? super kotlin.f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private kotlin.sequences.o f60479a;

        /* renamed from: b  reason: collision with root package name */
        Object f60480b;

        /* renamed from: c  reason: collision with root package name */
        Object f60481c;

        /* renamed from: d  reason: collision with root package name */
        Object f60482d;

        /* renamed from: e  reason: collision with root package name */
        Object f60483e;

        /* renamed from: f  reason: collision with root package name */
        Object f60484f;

        /* renamed from: g  reason: collision with root package name */
        Object f60485g;

        /* renamed from: h  reason: collision with root package name */
        int f60486h;

        e(kotlin.coroutines.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            e eVar = new e(cVar);
            eVar.f60479a = (kotlin.sequences.o) obj;
            return eVar;
        }

        @Override // d2.p
        public final Object invoke(kotlin.sequences.o<? super w> oVar, kotlin.coroutines.c<? super kotlin.f1> cVar) {
            return ((e) create(oVar, cVar)).invokeSuspend(kotlin.f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:29:0x009b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:29:0x009b). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r10.f60486h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3b
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                java.lang.Object r1 = r10.f60485g
                kotlinx.coroutines.v r1 = (kotlinx.coroutines.v) r1
                java.lang.Object r1 = r10.f60484f
                kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.s) r1
                java.lang.Object r4 = r10.f60483e
                kotlinx.coroutines.internal.q r4 = (kotlinx.coroutines.internal.q) r4
                java.lang.Object r5 = r10.f60482d
                kotlinx.coroutines.q2 r5 = (kotlinx.coroutines.q2) r5
                java.lang.Object r6 = r10.f60481c
                java.lang.Object r7 = r10.f60480b
                kotlin.sequences.o r7 = (kotlin.sequences.o) r7
                kotlin.d0.n(r11)
                r11 = r10
                goto L9b
            L2a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L32:
                java.lang.Object r0 = r10.f60480b
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                kotlin.d0.n(r11)
                goto La8
            L3b:
                kotlin.d0.n(r11)
                kotlin.sequences.o r11 = r10.f60479a
                kotlinx.coroutines.l2 r1 = kotlinx.coroutines.l2.this
                java.lang.Object r1 = r1.y0()
                boolean r4 = r1 instanceof kotlinx.coroutines.v
                if (r4 == 0) goto L5c
                r2 = r1
                kotlinx.coroutines.v r2 = (kotlinx.coroutines.v) r2
                kotlinx.coroutines.w r2 = r2.f60745e
                r10.f60480b = r11
                r10.f60481c = r1
                r10.f60486h = r3
                java.lang.Object r11 = r11.e(r2, r10)
                if (r11 != r0) goto La8
                return r0
            L5c:
                boolean r4 = r1 instanceof kotlinx.coroutines.y1
                if (r4 == 0) goto La8
                r4 = r1
                kotlinx.coroutines.y1 r4 = (kotlinx.coroutines.y1) r4
                kotlinx.coroutines.q2 r4 = r4.f()
                if (r4 == 0) goto La8
                java.lang.Object r5 = r4.Q()
                if (r5 == 0) goto La0
                kotlinx.coroutines.internal.s r5 = (kotlinx.coroutines.internal.s) r5
                r7 = r11
                r6 = r1
                r1 = r5
                r11 = r10
                r5 = r4
            L76:
                boolean r8 = kotlin.jvm.internal.f0.g(r1, r4)
                r8 = r8 ^ r3
                if (r8 == 0) goto La8
                boolean r8 = r1 instanceof kotlinx.coroutines.v
                if (r8 == 0) goto L9b
                r8 = r1
                kotlinx.coroutines.v r8 = (kotlinx.coroutines.v) r8
                kotlinx.coroutines.w r9 = r8.f60745e
                r11.f60480b = r7
                r11.f60481c = r6
                r11.f60482d = r5
                r11.f60483e = r4
                r11.f60484f = r1
                r11.f60485g = r8
                r11.f60486h = r2
                java.lang.Object r8 = r7.e(r9, r11)
                if (r8 != r0) goto L9b
                return r0
            L9b:
                kotlinx.coroutines.internal.s r1 = r1.R()
                goto L76
            La0:
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
            */
            //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                r11.<init>(r0)
                throw r11
            La8:
                kotlin.f1 r11 = kotlin.f1.f55527a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.l2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public l2(boolean z3) {
        this._state = z3 ? m2.f60506j : m2.f60505i;
        this._parentHandle = null;
    }

    private final boolean C0(y1 y1Var) {
        return (y1Var instanceof c) && ((c) y1Var).e();
    }

    private final boolean F0() {
        Object y02;
        do {
            y02 = y0();
            if (!(y02 instanceof y1)) {
                return false;
            }
        } while (a1(y02) < 0);
        return true;
    }

    private final Void H0(d2.l<Object, kotlin.f1> lVar) {
        while (true) {
            lVar.invoke(y0());
        }
    }

    private final Object I0(Object obj) {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        kotlinx.coroutines.internal.j0 j0Var3;
        kotlinx.coroutines.internal.j0 j0Var4;
        kotlinx.coroutines.internal.j0 j0Var5;
        kotlinx.coroutines.internal.j0 j0Var6;
        Throwable th = null;
        while (true) {
            Object y02 = y0();
            if (y02 instanceof c) {
                synchronized (y02) {
                    if (((c) y02).h()) {
                        j0Var2 = m2.f60500d;
                        return j0Var2;
                    }
                    boolean e4 = ((c) y02).e();
                    if (obj != null || !e4) {
                        if (th == null) {
                            th = k0(obj);
                        }
                        ((c) y02).a(th);
                    }
                    Throwable d4 = e4 ^ true ? ((c) y02).d() : null;
                    if (d4 != null) {
                        O0(((c) y02).f(), d4);
                    }
                    j0Var = m2.f60497a;
                    return j0Var;
                }
            } else if (y02 instanceof y1) {
                if (th == null) {
                    th = k0(obj);
                }
                y1 y1Var = (y1) y02;
                if (y1Var.isActive()) {
                    if (g1(y1Var, th)) {
                        j0Var4 = m2.f60497a;
                        return j0Var4;
                    }
                } else {
                    Object h12 = h1(y02, new d0(th, false, 2, null));
                    j0Var5 = m2.f60497a;
                    if (h12 != j0Var5) {
                        j0Var6 = m2.f60499c;
                        if (h12 != j0Var6) {
                            return h12;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + y02).toString());
                    }
                }
            } else {
                j0Var3 = m2.f60500d;
                return j0Var3;
            }
        }
    }

    private final k2<?> L0(d2.l<? super Throwable, kotlin.f1> lVar, boolean z3) {
        if (z3) {
            f2 f2Var = lVar instanceof f2 ? lVar : null;
            return f2Var != null ? f2Var : new c2(this, lVar);
        }
        k2<?> k2Var = lVar instanceof k2 ? lVar : null;
        return k2Var != null ? k2Var : new d2(this, lVar);
    }

    private final v N0(kotlinx.coroutines.internal.s sVar) {
        while (sVar.X()) {
            sVar = sVar.U();
        }
        while (true) {
            sVar = sVar.R();
            if (!sVar.X()) {
                if (sVar instanceof v) {
                    return (v) sVar;
                }
                if (sVar instanceof q2) {
                    return null;
                }
            }
        }
    }

    private final void O0(q2 q2Var, Throwable th) {
        R0(th);
        Object Q = q2Var.Q();
        if (Q != null) {
            CompletionHandlerException completionHandlerException = null;
            for (kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) Q; !kotlin.jvm.internal.f0.g(sVar, q2Var); sVar = sVar.R()) {
                if (sVar instanceof f2) {
                    k2 k2Var = (k2) sVar;
                    try {
                        k2Var.h0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.j.a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                            kotlin.f1 f1Var = kotlin.f1.f55527a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                A0(completionHandlerException);
            }
            f0(th);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final void P0(q2 q2Var, Throwable th) {
        Object Q = q2Var.Q();
        if (Q != null) {
            CompletionHandlerException completionHandlerException = null;
            for (kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) Q; !kotlin.jvm.internal.f0.g(sVar, q2Var); sVar = sVar.R()) {
                if (sVar instanceof k2) {
                    k2 k2Var = (k2) sVar;
                    try {
                        k2Var.h0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.j.a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                            kotlin.f1 f1Var = kotlin.f1.f55527a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                A0(completionHandlerException);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final /* synthetic */ <T extends k2<?>> void Q0(q2 q2Var, Throwable th) {
        Object Q = q2Var.Q();
        if (Q != null) {
            CompletionHandlerException completionHandlerException = null;
            for (kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) Q; !kotlin.jvm.internal.f0.g(sVar, q2Var); sVar = sVar.R()) {
                kotlin.jvm.internal.f0.y(3, "T");
                if (sVar instanceof kotlinx.coroutines.internal.s) {
                    k2 k2Var = (k2) sVar;
                    try {
                        k2Var.h0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.j.a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                            kotlin.f1 f1Var = kotlin.f1.f55527a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                A0(completionHandlerException);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.x1] */
    private final void U0(l1 l1Var) {
        q2 q2Var = new q2();
        if (!l1Var.isActive()) {
            q2Var = new x1(q2Var);
        }
        io.netty.channel.a.a(f60469a, this, l1Var, q2Var);
    }

    private final void V0(k2<?> k2Var) {
        k2Var.K(new q2());
        io.netty.channel.a.a(f60469a, this, k2Var, k2Var.R());
    }

    private final boolean W(Object obj, q2 q2Var, k2<?> k2Var) {
        int f02;
        d dVar = new d(k2Var, k2Var, this, obj);
        do {
            f02 = q2Var.U().f0(k2Var, q2Var, dVar);
            if (f02 == 1) {
                return true;
            }
        } while (f02 != 2);
        return false;
    }

    private final void X(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.j.a(th, th2);
            }
        }
    }

    private final int a1(Object obj) {
        l1 l1Var;
        if (obj instanceof l1) {
            if (((l1) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60469a;
            l1Var = m2.f60506j;
            if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, obj, l1Var)) {
                T0();
                return 1;
            }
            return -1;
        } else if (obj instanceof x1) {
            if (io.netty.channel.a.a(f60469a, this, obj, ((x1) obj).f())) {
                T0();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    private final String b1(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof y1 ? ((y1) obj).isActive() ? "Active" : "New" : obj instanceof d0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.e() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException d1(l2 l2Var, Throwable th, String str, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                str = null;
            }
            return l2Var.c1(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final Object e0(Object obj) {
        kotlinx.coroutines.internal.j0 j0Var;
        Object h12;
        kotlinx.coroutines.internal.j0 j0Var2;
        do {
            Object y02 = y0();
            if ((y02 instanceof y1) && (!(y02 instanceof c) || !((c) y02).g())) {
                h12 = h1(y02, new d0(k0(obj), false, 2, null));
                j0Var2 = m2.f60499c;
            } else {
                j0Var = m2.f60497a;
                return j0Var;
            }
        } while (h12 == j0Var2);
        return h12;
    }

    private final boolean f0(Throwable th) {
        if (E0()) {
            return true;
        }
        boolean z3 = th instanceof CancellationException;
        u x02 = x0();
        return (x02 == null || x02 == s2.f60556a) ? z3 : x02.g(th) || z3;
    }

    private final boolean f1(y1 y1Var, Object obj) {
        if (io.netty.channel.a.a(f60469a, this, y1Var, m2.g(obj))) {
            R0(null);
            S0(obj);
            i0(y1Var, obj);
            return true;
        }
        return false;
    }

    private final boolean g1(y1 y1Var, Throwable th) {
        q2 w02 = w0(y1Var);
        if (w02 != null) {
            if (io.netty.channel.a.a(f60469a, this, y1Var, new c(w02, false, th))) {
                O0(w02, th);
                return true;
            }
            return false;
        }
        return false;
    }

    private final Object h1(Object obj, Object obj2) {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        if (!(obj instanceof y1)) {
            j0Var2 = m2.f60497a;
            return j0Var2;
        } else if (((obj instanceof l1) || (obj instanceof k2)) && !(obj instanceof v) && !(obj2 instanceof d0)) {
            if (f1((y1) obj, obj2)) {
                return obj2;
            }
            j0Var = m2.f60499c;
            return j0Var;
        } else {
            return i1((y1) obj, obj2);
        }
    }

    private final void i0(y1 y1Var, Object obj) {
        u x02 = x0();
        if (x02 != null) {
            x02.dispose();
            Z0(s2.f60556a);
        }
        if (!(obj instanceof d0)) {
            obj = null;
        }
        d0 d0Var = (d0) obj;
        Throwable th = d0Var != null ? d0Var.f59534a : null;
        if (y1Var instanceof k2) {
            try {
                ((k2) y1Var).h0(th);
                return;
            } catch (Throwable th2) {
                A0(new CompletionHandlerException("Exception in completion handler " + y1Var + " for " + this, th2));
                return;
            }
        }
        q2 f4 = y1Var.f();
        if (f4 != null) {
            P0(f4, th);
        }
    }

    private final Object i1(y1 y1Var, Object obj) {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        kotlinx.coroutines.internal.j0 j0Var3;
        q2 w02 = w0(y1Var);
        if (w02 != null) {
            c cVar = (c) (!(y1Var instanceof c) ? null : y1Var);
            if (cVar == null) {
                cVar = new c(w02, false, null);
            }
            synchronized (cVar) {
                if (cVar.g()) {
                    j0Var3 = m2.f60497a;
                    return j0Var3;
                }
                cVar.j(true);
                if (cVar != y1Var && !io.netty.channel.a.a(f60469a, this, y1Var, cVar)) {
                    j0Var2 = m2.f60499c;
                    return j0Var2;
                }
                boolean e4 = cVar.e();
                d0 d0Var = (d0) (!(obj instanceof d0) ? null : obj);
                if (d0Var != null) {
                    cVar.a(d0Var.f59534a);
                }
                Throwable d4 = true ^ e4 ? cVar.d() : null;
                kotlin.f1 f1Var = kotlin.f1.f55527a;
                if (d4 != null) {
                    O0(w02, d4);
                }
                v o02 = o0(y1Var);
                if (o02 != null && j1(cVar, o02, obj)) {
                    return m2.f60498b;
                }
                return n0(cVar, obj);
            }
        }
        j0Var = m2.f60499c;
        return j0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(c cVar, v vVar, Object obj) {
        v N0 = N0(vVar);
        if (N0 == null || !j1(cVar, N0, obj)) {
            Y(n0(cVar, obj));
        }
    }

    private final boolean j1(c cVar, v vVar, Object obj) {
        while (e2.a.f(vVar.f60745e, false, false, new b(this, cVar, vVar, obj), 1, null) == s2.f60556a) {
            vVar = N0(vVar);
            if (vVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable k0(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(g0(), null, this);
        } else if (obj != null) {
            return ((u2) obj).x();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    public static /* synthetic */ JobCancellationException m0(l2 l2Var, String str, Throwable th, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                str = null;
            }
            if ((i4 & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = l2Var.g0();
            }
            return new JobCancellationException(str, th, l2Var);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object n0(c cVar, Object obj) {
        boolean e4;
        Throwable t02;
        d0 d0Var = (d0) (!(obj instanceof d0) ? null : obj);
        Throwable th = d0Var != null ? d0Var.f59534a : null;
        synchronized (cVar) {
            e4 = cVar.e();
            List<Throwable> i4 = cVar.i(th);
            t02 = t0(cVar, i4);
            if (t02 != null) {
                X(t02, i4);
            }
        }
        boolean z3 = false;
        if (t02 != null && t02 != th) {
            obj = new d0(t02, false, 2, null);
        }
        if (t02 != null) {
            if ((f0(t02) || z0(t02)) ? true : true) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((d0) obj).b();
            }
        }
        if (!e4) {
            R0(t02);
        }
        S0(obj);
        io.netty.channel.a.a(f60469a, this, cVar, m2.g(obj));
        i0(cVar, obj);
        return obj;
    }

    private final v o0(y1 y1Var) {
        v vVar = (v) (!(y1Var instanceof v) ? null : y1Var);
        if (vVar != null) {
            return vVar;
        }
        q2 f4 = y1Var.f();
        if (f4 != null) {
            return N0(f4);
        }
        return null;
    }

    private final Throwable s0(Object obj) {
        if (!(obj instanceof d0)) {
            obj = null;
        }
        d0 d0Var = (d0) obj;
        if (d0Var != null) {
            return d0Var.f59534a;
        }
        return null;
    }

    private final Throwable t0(c cVar, List<? extends Throwable> list) {
        Object obj;
        boolean z3;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.e()) {
                return new JobCancellationException(g0(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof TimeoutCancellationException)) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final q2 w0(y1 y1Var) {
        q2 f4 = y1Var.f();
        if (f4 != null) {
            return f4;
        }
        if (y1Var instanceof l1) {
            return new q2();
        }
        if (y1Var instanceof k2) {
            V0((k2) y1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + y1Var).toString());
    }

    @Override // kotlinx.coroutines.e2
    @Nullable
    public final Object A(@NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        Object h4;
        if (!F0()) {
            v3.a(cVar.getContext());
            return kotlin.f1.f55527a;
        }
        Object G0 = G0(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return G0 == h4 ? G0 : kotlin.f1.f55527a;
    }

    public void A0(@NotNull Throwable th) {
        throw th;
    }

    public final void B0(@Nullable e2 e2Var) {
        if (e2Var == null) {
            Z0(s2.f60556a);
            return;
        }
        e2Var.start();
        u R = e2Var.R(this);
        Z0(R);
        if (isCompleted()) {
            R.dispose();
            Z0(s2.f60556a);
        }
    }

    public final boolean D0() {
        return y0() instanceof d0;
    }

    protected boolean E0() {
        return false;
    }

    @Nullable
    final /* synthetic */ Object G0(@NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        r.a(pVar, m(new y2(this, pVar)));
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    public final boolean J0(@Nullable Object obj) {
        Object h12;
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        do {
            h12 = h1(y0(), obj);
            j0Var = m2.f60497a;
            if (h12 == j0Var) {
                return false;
            }
            if (h12 == m2.f60498b) {
                return true;
            }
            j0Var2 = m2.f60499c;
        } while (h12 == j0Var2);
        Y(h12);
        return true;
    }

    @Nullable
    public final Object K0(@Nullable Object obj) {
        Object h12;
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        do {
            h12 = h1(y0(), obj);
            j0Var = m2.f60497a;
            if (h12 != j0Var) {
                j0Var2 = m2.f60499c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, s0(obj));
            }
        } while (h12 == j0Var2);
        return h12;
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final kotlinx.coroutines.selects.c M() {
        return this;
    }

    @NotNull
    public String M0() {
        return u0.a(this);
    }

    @Override // kotlinx.coroutines.selects.c
    public final <R> void N(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        Object y02;
        do {
            y02 = y0();
            if (fVar.h()) {
                return;
            }
            if (!(y02 instanceof y1)) {
                if (fVar.p()) {
                    z2.b.c(lVar, fVar.t());
                    return;
                }
                return;
            }
        } while (a1(y02) != 0);
        fVar.k(m(new d3(this, fVar, lVar)));
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final u R(@NotNull w wVar) {
        i1 f4 = e2.a.f(this, true, false, new v(this, wVar), 2, null);
        if (f4 != null) {
            return (u) f4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    protected void R0(@Nullable Throwable th) {
    }

    protected void S0(@Nullable Object obj) {
    }

    public void T0() {
    }

    public final <T, R> void W0(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        Object y02;
        do {
            y02 = y0();
            if (fVar.h()) {
                return;
            }
            if (!(y02 instanceof y1)) {
                if (fVar.p()) {
                    if (y02 instanceof d0) {
                        fVar.v(((d0) y02).f59534a);
                        return;
                    } else {
                        z2.b.d(pVar, m2.o(y02), fVar.t());
                        return;
                    }
                }
                return;
            }
        } while (a1(y02) != 0);
        fVar.k(m(new c3(this, fVar, pVar)));
    }

    public final void X0(@NotNull k2<?> k2Var) {
        Object y02;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        l1 l1Var;
        do {
            y02 = y0();
            if (!(y02 instanceof k2)) {
                if (!(y02 instanceof y1) || ((y1) y02).f() == null) {
                    return;
                }
                k2Var.a0();
                return;
            } else if (y02 != k2Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = f60469a;
                l1Var = m2.f60506j;
            }
        } while (!io.netty.channel.a.a(atomicReferenceFieldUpdater, this, y02, l1Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(@Nullable Object obj) {
    }

    public final <T, R> void Y0(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        Object y02 = y0();
        if (y02 instanceof d0) {
            fVar.v(((d0) y02).f59534a);
        } else {
            z2.a.e(pVar, m2.o(y02), fVar.t(), null, 4, null);
        }
    }

    @Nullable
    public final Object Z(@NotNull kotlin.coroutines.c<Object> cVar) {
        Object y02;
        do {
            y02 = y0();
            if (!(y02 instanceof y1)) {
                if (!(y02 instanceof d0)) {
                    return m2.o(y02);
                }
                throw ((d0) y02).f59534a;
            }
        } while (a1(y02) < 0);
        return a0(cVar);
    }

    public final void Z0(@Nullable u uVar) {
        this._parentHandle = uVar;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(@Nullable Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = d1(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(g0(), null, this);
        }
        d0(jobCancellationException);
        return true;
    }

    @Nullable
    final /* synthetic */ Object a0(@NotNull kotlin.coroutines.c<Object> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        a aVar = new a(d4, this);
        r.a(aVar, m(new x2(this, aVar)));
        Object y3 = aVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    public void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(g0(), null, this);
        }
        d0(cancellationException);
    }

    public final boolean b0(@Nullable Throwable th) {
        return c0(th);
    }

    public final boolean c0(@Nullable Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        kotlinx.coroutines.internal.j0 j0Var3;
        obj2 = m2.f60497a;
        if (v0() && (obj2 = e0(obj)) == m2.f60498b) {
            return true;
        }
        j0Var = m2.f60497a;
        if (obj2 == j0Var) {
            obj2 = I0(obj);
        }
        j0Var2 = m2.f60497a;
        if (obj2 == j0Var2 || obj2 == m2.f60498b) {
            return true;
        }
        j0Var3 = m2.f60500d;
        if (obj2 == j0Var3) {
            return false;
        }
        Y(obj2);
        return true;
    }

    @NotNull
    protected final CancellationException c1(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = g0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    public void d0(@NotNull Throwable th) {
        c0(th);
    }

    @InternalCoroutinesApi
    @NotNull
    public final String e1() {
        return M0() + '{' + b1(y0()) + '}';
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) e2.a.d(this, r3, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String g0() {
        return "Job was cancelled";
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        return (E) e2.a.e(this, cVar);
    }

    @Override // kotlin.coroutines.f.b
    @NotNull
    public final f.c<?> getKey() {
        return e2.f59626i0;
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final kotlin.sequences.m<e2> h() {
        kotlin.sequences.m<e2> e4;
        e4 = kotlin.sequences.q.e(new e(null));
        return e4;
    }

    public boolean h0(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return c0(th) && u0();
    }

    @Override // kotlinx.coroutines.w
    public final void i(@NotNull u2 u2Var) {
        c0(u2Var);
    }

    @Override // kotlinx.coroutines.e2
    public boolean isActive() {
        Object y02 = y0();
        return (y02 instanceof y1) && ((y1) y02).isActive();
    }

    @Override // kotlinx.coroutines.e2
    public final boolean isCancelled() {
        Object y02 = y0();
        return (y02 instanceof d0) || ((y02 instanceof c) && ((c) y02).e());
    }

    @Override // kotlinx.coroutines.e2
    public final boolean isCompleted() {
        return !(y0() instanceof y1);
    }

    @Nullable
    public final Throwable j() {
        Object y02 = y0();
        if (!(y02 instanceof y1)) {
            return s0(y02);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final CancellationException l() {
        Object y02 = y0();
        if (y02 instanceof c) {
            Throwable d4 = ((c) y02).d();
            if (d4 != null) {
                CancellationException c12 = c1(d4, u0.a(this) + " is cancelling");
                if (c12 != null) {
                    return c12;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(y02 instanceof y1)) {
            if (y02 instanceof d0) {
                return d1(this, ((d0) y02).f59534a, null, 1, null);
            }
            return new JobCancellationException(u0.a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    @NotNull
    public final JobCancellationException l0(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = g0();
        }
        return new JobCancellationException(str, th, this);
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final i1 m(@NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        return z(false, true, lVar);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> cVar) {
        return e2.a.g(this, cVar);
    }

    @Nullable
    public final Object p0() {
        Object y02 = y0();
        if (!(y02 instanceof y1)) {
            if (!(y02 instanceof d0)) {
                return m2.o(y02);
            }
            throw ((d0) y02).f59534a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f plus(@NotNull kotlin.coroutines.f fVar) {
        return e2.a.h(this, fVar);
    }

    @Nullable
    protected final Throwable q0() {
        Object y02 = y0();
        if (y02 instanceof c) {
            Throwable d4 = ((c) y02).d();
            if (d4 != null) {
                return d4;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(y02 instanceof y1)) {
            if (y02 instanceof d0) {
                return ((d0) y02).f59534a;
            }
            return null;
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    protected final boolean r0() {
        Object y02 = y0();
        return (y02 instanceof d0) && ((d0) y02).a();
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public e2 s(@NotNull e2 e2Var) {
        return e2.a.i(this, e2Var);
    }

    @Override // kotlinx.coroutines.e2
    public final boolean start() {
        int a12;
        do {
            a12 = a1(y0());
            if (a12 == 0) {
                return false;
            }
        } while (a12 != 1);
        return true;
    }

    @NotNull
    public String toString() {
        return e1() + '@' + u0.b(this);
    }

    public boolean u0() {
        return true;
    }

    public boolean v0() {
        return false;
    }

    @Override // kotlinx.coroutines.u2
    @NotNull
    public CancellationException x() {
        Throwable th;
        Object y02 = y0();
        if (y02 instanceof c) {
            th = ((c) y02).d();
        } else if (y02 instanceof d0) {
            th = ((d0) y02).f59534a;
        } else if (y02 instanceof y1) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + y02).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + b1(y02), th, this);
    }

    @Nullable
    public final u x0() {
        return (u) this._parentHandle;
    }

    @Nullable
    public final Object y0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.c0)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.c0) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final i1 z(boolean z3, boolean z4, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        Throwable th;
        k2<?> k2Var = null;
        while (true) {
            Object y02 = y0();
            if (y02 instanceof l1) {
                l1 l1Var = (l1) y02;
                if (l1Var.isActive()) {
                    if (k2Var == null) {
                        k2Var = L0(lVar, z3);
                    }
                    if (io.netty.channel.a.a(f60469a, this, y02, k2Var)) {
                        return k2Var;
                    }
                } else {
                    U0(l1Var);
                }
            } else if (y02 instanceof y1) {
                q2 f4 = ((y1) y02).f();
                if (f4 != null) {
                    i1 i1Var = s2.f60556a;
                    if (z3 && (y02 instanceof c)) {
                        synchronized (y02) {
                            th = ((c) y02).d();
                            if (th == null || ((lVar instanceof v) && !((c) y02).g())) {
                                if (k2Var == null) {
                                    k2Var = L0(lVar, z3);
                                }
                                if (W(y02, f4, k2Var)) {
                                    if (th == null) {
                                        return k2Var;
                                    }
                                    i1Var = k2Var;
                                }
                            }
                            kotlin.f1 f1Var = kotlin.f1.f55527a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z4) {
                            lVar.invoke(th);
                        }
                        return i1Var;
                    }
                    if (k2Var == null) {
                        k2Var = L0(lVar, z3);
                    }
                    if (W(y02, f4, k2Var)) {
                        return k2Var;
                    }
                } else if (y02 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                } else {
                    V0((k2) y02);
                }
            } else {
                if (z4) {
                    if (!(y02 instanceof d0)) {
                        y02 = null;
                    }
                    d0 d0Var = (d0) y02;
                    lVar.invoke(d0Var != null ? d0Var.f59534a : null);
                }
                return s2.f60556a;
            }
        }
    }

    protected boolean z0(@NotNull Throwable th) {
        return false;
    }
}
