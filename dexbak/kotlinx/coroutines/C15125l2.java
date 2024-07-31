package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.C13675a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.AbstractC14514o;
import kotlin.sequences.C14515p;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.AbstractC15073c0;
import kotlinx.coroutines.internal.C15093r;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.selects.InterfaceC15194c;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

/* compiled from: JobSupport.kt */
@Annotations(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004}yÍ\u0001B\u0012\u0012\u0007\u0010Ê\u0001\u001a\u00020\u001b¢\u0006\u0006\bË\u0001\u0010Ì\u0001J&\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0082\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u0007*\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b'\u0010$J2\u0010*\u001a\u00020\u0007\"\u000e\b\u0000\u0010)\u0018\u0001*\u0006\u0012\u0002\b\u00030(2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0082\b¢\u0006\u0004\b*\u0010$J\u0019\u0010,\u001a\u00020+2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b,\u0010-JD\u00103\u001a\u0006\u0012\u0002\b\u00030(2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`02\u0006\u00102\u001a\u00020\u001bH\u0002¢\u0006\u0004\b3\u00104J+\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\n\u00106\u001a\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00072\u0006\u0010\r\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\u00072\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001bH\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u001b\u0010D\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bD\u0010AJ\u0019\u0010E\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bI\u0010JJ#\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010\r\u001a\u00020\u0019H\u0002¢\u0006\u0004\bN\u0010OJ*\u0010Q\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010P\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0082\u0010¢\u0006\u0004\bQ\u0010RJ)\u0010T\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010S\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u0004\u0018\u00010M*\u00020VH\u0002¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020Y2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u001b¢\u0006\u0004\b_\u0010?J\u000f\u0010`\u001a\u00020\u0007H\u0010¢\u0006\u0004\b`\u0010aJ\u0011\u0010d\u001a\u00060bj\u0002`c¢\u0006\u0004\bd\u0010eJ#\u0010g\u001a\u00060bj\u0002`c*\u00020\u00122\n\b\u0002\u0010f\u001a\u0004\u0018\u00010YH\u0004¢\u0006\u0004\bg\u0010hJ6\u0010j\u001a\u00020i2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0¢\u0006\u0004\bj\u0010kJF\u0010m\u001a\u00020i2\u0006\u00102\u001a\u00020\u001b2\u0006\u0010l\u001a\u00020\u001b2'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`0¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ\u0013\u0010q\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\bq\u0010pJB\u0010v\u001a\u00020\u0007\"\u0004\b\u0000\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00000s2\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000u\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u001b\u0010x\u001a\u00020\u00072\n\u00106\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0004\bx\u0010=J\u001f\u0010y\u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0018\u00010bj\u0004\u0018\u0001`cH\u0016¢\u0006\u0004\by\u0010zJ\u000f\u0010{\u001a\u00020YH\u0014¢\u0006\u0004\b{\u0010|J\u0019\u0010}\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\b}\u0010&J\u0017\u0010~\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0004\b~\u0010\u007fJ\u0019\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0019\u0010\u0083\u0001\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u0083\u0001\u0010&J\u0019\u0010\u0084\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0005\b\u0084\u0001\u0010&J\u001c\u0010\u0085\u0001\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J,\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010Y2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0080\b¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0015\u0010\u008a\u0001\u001a\u00060bj\u0002`cH\u0016¢\u0006\u0005\b\u008a\u0001\u0010eJ\u001c\u0010\u008b\u0001\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u0086\u0001J\u001d\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0005\b\u008c\u0001\u0010AJ\u0019\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0006\u0010P\u001a\u00020\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u0012H\u0010¢\u0006\u0005\b\u0091\u0001\u0010\u007fJ\u001b\u0010\u0092\u0001\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0005\b\u0092\u0001\u0010\u007fJ\u001a\u0010\u0093\u0001\u001a\u00020\u001b2\u0007\u0010\u0090\u0001\u001a\u00020\u0012H\u0014¢\u0006\u0005\b\u0093\u0001\u0010&J\u001c\u0010\u0094\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001c\u0010\u0096\u0001\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0006\b\u0096\u0001\u0010\u0095\u0001J\u0011\u0010\u0097\u0001\u001a\u00020YH\u0016¢\u0006\u0005\b\u0097\u0001\u0010|J\u0011\u0010\u0098\u0001\u001a\u00020YH\u0007¢\u0006\u0005\b\u0098\u0001\u0010|J\u0011\u0010\u0099\u0001\u001a\u00020YH\u0010¢\u0006\u0005\b\u0099\u0001\u0010|J\u0012\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0014\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0017\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006H\u0080@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010pJ\u0017\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0001\u0010pJT\u0010¡\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060 \u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001JT\u0010£\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010r2\f\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010s2#\u0010\b\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010u\u0012\u0006\u0012\u0004\u0018\u00010\u00060 \u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¢\u0001R\u001e\u0010¥\u0001\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010CR\u001b\u0010¨\u0001\u001a\u00020\u001b*\u00020\u00198BX\u0082\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010¬\u0001\u001a\u0007\u0012\u0002\b\u00030©\u00018F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R0\u0010²\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u008d\u00018@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010\u009d\u0001R\u0016\u0010´\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010?R\u0013\u0010µ\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010?R\u0013\u0010¶\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010?R\u0019\u0010¸\u0001\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010\u009b\u0001R\u0016\u0010º\u0001\u001a\u00020\u001b8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010?R\u0014\u0010½\u0001\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R\u0016\u0010¿\u0001\u001a\u00020\u001b8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010?R\u001b\u0010Ã\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010À\u00018F¢\u0006\b\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010Å\u0001\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010?R\u0016\u0010Ç\u0001\u001a\u00020\u001b8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u0010?R\u0013\u0010É\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\bÈ\u0001\u0010?\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Î\u0001"}, m12616d2 = {"Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/u2;", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "", "Lkotlin/f1;", "block", "", "H0", "(Ll1/l;)Ljava/lang/Void;", "Lkotlinx/coroutines/l2$c;", "state", "proposedUpdate", "n0", "(Lkotlinx/coroutines/l2$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "t0", "(Lkotlinx/coroutines/l2$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "X", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/y1;", "update", "", "f1", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)Z", "i0", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/q2;", "list", "cause", "O0", "(Lkotlinx/coroutines/q2;Ljava/lang/Throwable;)V", "f0", "(Ljava/lang/Throwable;)Z", "P0", "Lkotlinx/coroutines/k2;", ExifInterface.GPS_DIRECTION_TRUE, "Q0", "", "a1", "(Ljava/lang/Object;)I", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "L0", "(Ll1/l;Z)Lkotlinx/coroutines/k2;", "expect", "node", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/Object;Lkotlinx/coroutines/q2;Lkotlinx/coroutines/k2;)Z", "Lkotlinx/coroutines/l1;", "U0", "(Lkotlinx/coroutines/l1;)V", "V0", "(Lkotlinx/coroutines/k2;)V", "F0", "()Z", "e0", "(Ljava/lang/Object;)Ljava/lang/Object;", "k0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "I0", "w0", "(Lkotlinx/coroutines/y1;)Lkotlinx/coroutines/q2;", "g1", "(Lkotlinx/coroutines/y1;Ljava/lang/Throwable;)Z", "h1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "i1", "(Lkotlinx/coroutines/y1;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/v;", "o0", "(Lkotlinx/coroutines/y1;)Lkotlinx/coroutines/v;", "child", "j1", "(Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)Z", "lastChild", "j0", "(Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/s;", "N0", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/v;", "", "b1", "(Ljava/lang/Object;)Ljava/lang/String;", "parent", "B0", "(Lkotlinx/coroutines/e2;)V", CampaignEx.JSON_NATIVE_VIDEO_START, "T0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", C7304t.f25048d, "()Ljava/util/concurrent/CancellationException;", "message", "c1", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/i1;", IAdInterListener.AdReqParam.WIDTH, "(Ll1/l;)Lkotlinx/coroutines/i1;", "invokeImmediately", "o", "(ZZLl1/l;)Lkotlinx/coroutines/i1;", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "G0", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/coroutines/c;", "u", "(Lkotlinx/coroutines/selects/f;Ll1/l;)V", "X0", "b", "(Ljava/util/concurrent/CancellationException;)V", "g0", "()Ljava/lang/String;", "a", "d0", "(Ljava/lang/Throwable;)V", "parentJob", "n", "(Lkotlinx/coroutines/u2;)V", "h0", "b0", "c0", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/JobCancellationException;", "l0", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J0", "K0", "Lkotlinx/coroutines/u;", ExifInterface.LATITUDE_SOUTH, "(Lkotlinx/coroutines/w;)Lkotlinx/coroutines/u;", "exception", "A0", "R0", "z0", "S0", "(Ljava/lang/Object;)V", "Y", "toString", "e1", "M0", "j", "()Ljava/lang/Throwable;", C7202bq.f24604g, "()Ljava/lang/Object;", "Z", "a0", "Lkotlin/Function2;", "W0", "(Lkotlinx/coroutines/selects/f;Ll1/p;)V", "Y0", "s0", "exceptionOrNull", "C0", "(Lkotlinx/coroutines/y1;)Z", "isCancelling", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "x0", "()Lkotlinx/coroutines/u;", "Z0", "(Lkotlinx/coroutines/u;)V", "parentHandle", "y0", "isActive", "isCompleted", "isCancelled", "q0", "completionCause", "r0", "completionCauseHandled", "O", "()Lkotlinx/coroutines/selects/c;", "onJoin", "v0", "onCancelComplete", "Lkotlin/sequences/m;", "i", "()Lkotlin/sequences/m;", "children", "E0", "isScopedCoroutine", "u0", "handlesException", "D0", "isCompletedExceptionally", "active", "<init>", "(Z)V", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.l2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C15125l2 implements Job, InterfaceC15244w, InterfaceC15237u2, InterfaceC15194c {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f43152a = AtomicReferenceFieldUpdater.newUpdater(C15125l2.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/l2$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/p;", "Lkotlinx/coroutines/e2;", "parent", "", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/l2;", "h", "Lkotlinx/coroutines/l2;", "job", "Lkotlin/coroutines/c;", "delegate", "<init>", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/l2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.l2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15126a<T> extends C15153p<T> {

        /* renamed from: h */
        private final C15125l2 f43153h;

        public C15126a(@NotNull InterfaceC14268c<? super T> interfaceC14268c, @NotNull C15125l2 c15125l2) {
            super(interfaceC14268c, 1);
            this.f43153h = c15125l2;
        }

        @Override // kotlinx.coroutines.C15153p
        @NotNull
        /* renamed from: E */
        protected String mo3920E() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.C15153p
        @NotNull
        /* renamed from: w */
        public Throwable mo3885w(@NotNull Job job) {
            Throwable m4009d;
            Object m4014y0 = this.f43153h.m4014y0();
            return (!(m4014y0 instanceof C15128c) || (m4009d = ((C15128c) m4014y0).m4009d()) == null) ? m4014y0 instanceof CompletionState ? ((CompletionState) m4014y0).f42189a : job.mo3825l() : m4009d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, m12616d2 = {"Lkotlinx/coroutines/l2$b;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/l2;", "e", "Lkotlinx/coroutines/l2;", "parent", "Lkotlinx/coroutines/l2$c;", "f", "Lkotlinx/coroutines/l2$c;", "state", "Lkotlinx/coroutines/v;", "g", "Lkotlinx/coroutines/v;", "child", "", "h", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/l2$c;Lkotlinx/coroutines/v;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.l2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15127b extends AbstractC15119k2<Job> {

        /* renamed from: e */
        private final C15125l2 f43154e;

        /* renamed from: f */
        private final C15128c f43155f;

        /* renamed from: g */
        private final C15241v f43156g;

        /* renamed from: h */
        private final Object f43157h;

        public C15127b(@NotNull C15125l2 c15125l2, @NotNull C15128c c15128c, @NotNull C15241v c15241v, @Nullable Object obj) {
            super(c15241v.f43428e);
            this.f43154e = c15125l2;
            this.f43155f = c15128c;
            this.f43156g = c15241v;
            this.f43157h = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandler
        /* renamed from: f0 */
        public void mo3495f0(@Nullable Throwable th) {
            this.f43154e.m4029j0(this.f43155f, this.f43156g, this.f43157h);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo3495f0(th);
            return Unit.f41048a;
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "ChildCompletion[" + this.f43156g + ", " + this.f43157h + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b.\u0010/J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0010R\u0011\u0010*\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b)\u0010!R\u0011\u0010,\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b+\u0010!R\u0014\u0010-\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010!¨\u00060"}, m12616d2 = {"Lkotlinx/coroutines/l2$c;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/y1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "()Ljava/util/ArrayList;", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lkotlin/f1;", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/q2;", "Lkotlinx/coroutines/q2;", "h", "()Lkotlinx/coroutines/q2;", "list", DomainCampaignEx.LOOPBACK_VALUE, "c", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "f", "()Z", "j", "(Z)V", "isCompleting", "d", "()Ljava/lang/Throwable;", C7304t.f25048d, "rootCause", "g", "isSealed", "e", "isCancelling", "isActive", "<init>", "(Lkotlinx/coroutines/q2;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.l2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15128c implements InterfaceC15259y1 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        @NotNull

        /* renamed from: a */
        private final C15159q2 f43158a;

        public C15128c(@NotNull C15159q2 c15159q2, boolean z, @Nullable Throwable th) {
            this.f43158a = c15159q2;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* renamed from: b */
        private final ArrayList<Throwable> m4011b() {
            return new ArrayList<>(4);
        }

        /* renamed from: c */
        private final Object m4010c() {
            return this._exceptionsHolder;
        }

        /* renamed from: k */
        private final void m4003k(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public final void m4012a(@NotNull Throwable th) {
            Throwable m4009d = m4009d();
            if (m4009d == null) {
                m4002l(th);
            } else if (th == m4009d) {
            } else {
                Object m4010c = m4010c();
                if (m4010c == null) {
                    m4003k(th);
                } else if (!(m4010c instanceof Throwable)) {
                    if (m4010c instanceof ArrayList) {
                        ((ArrayList) m4010c).add(th);
                        return;
                    }
                    throw new IllegalStateException(("State is " + m4010c).toString());
                } else if (th == m4010c) {
                } else {
                    ArrayList<Throwable> m4011b = m4011b();
                    m4011b.add(m4010c);
                    m4011b.add(th);
                    Unit unit = Unit.f41048a;
                    m4003k(m4011b);
                }
            }
        }

        @Nullable
        /* renamed from: d */
        public final Throwable m4009d() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: e */
        public final boolean m4008e() {
            return m4009d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        /* renamed from: f */
        public final boolean m4007f() {
            return this._isCompleting;
        }

        /* renamed from: g */
        public final boolean m4006g() {
            return m4010c() == C15134m2.m3983e();
        }

        @Override // kotlinx.coroutines.InterfaceC15259y1
        @NotNull
        /* renamed from: h */
        public C15159q2 mo3496h() {
            return this.f43158a;
        }

        @NotNull
        /* renamed from: i */
        public final List<Throwable> m4005i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            Object m4010c = m4010c();
            if (m4010c == null) {
                arrayList = m4011b();
            } else if (m4010c instanceof Throwable) {
                ArrayList<Throwable> m4011b = m4011b();
                m4011b.add(m4010c);
                arrayList = m4011b;
            } else if (!(m4010c instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + m4010c).toString());
            } else {
                arrayList = (ArrayList) m4010c;
            }
            Throwable m4009d = m4009d();
            if (m4009d != null) {
                arrayList.add(0, m4009d);
            }
            if (th != null && (!C14342f0.m8193g(th, m4009d))) {
                arrayList.add(th);
            }
            m4003k(C15134m2.m3983e());
            return arrayList;
        }

        @Override // kotlinx.coroutines.InterfaceC15259y1
        public boolean isActive() {
            return m4009d() == null;
        }

        /* renamed from: j */
        public final void m4004j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* renamed from: l */
        public final void m4002l(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + m4008e() + ", completing=" + m4007f() + ", rootCause=" + m4009d() + ", exceptions=" + m4010c() + ", list=" + mo3496h() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.l2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15129d extends C15094s.AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ C15094s f43159d;

        /* renamed from: e */
        final /* synthetic */ C15125l2 f43160e;

        /* renamed from: f */
        final /* synthetic */ Object f43161f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15129d(C15094s c15094s, C15094s c15094s2, C15125l2 c15125l2, Object obj) {
            super(c15094s2);
            this.f43159d = c15094s;
            this.f43160e = c15125l2;
            this.f43161f = obj;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (this.f43160e.m4014y0() == this.f43161f) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/sequences/o;", "Lkotlinx/coroutines/w;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.JobSupport$children$1", m8638f = "JobSupport.kt", m8637i = {0, 0, 1, 1, 1, 1, 1, 1}, m8636l = {949, 951}, m8635m = "invokeSuspend", m8634n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it"}, m8633s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: kotlinx.coroutines.l2$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15130e extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super InterfaceC15244w>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private AbstractC14514o f43162a;

        /* renamed from: b */
        Object f43163b;

        /* renamed from: c */
        Object f43164c;

        /* renamed from: d */
        Object f43165d;

        /* renamed from: e */
        Object f43166e;

        /* renamed from: f */
        Object f43167f;

        /* renamed from: g */
        Object f43168g;

        /* renamed from: h */
        int f43169h;

        C15130e(InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C15130e c15130e = new C15130e(interfaceC14268c);
            c15130e.f43162a = (AbstractC14514o) obj;
            return c15130e;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(AbstractC14514o<? super InterfaceC15244w> abstractC14514o, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15130e) create(abstractC14514o, interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r10.f43169h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3b
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                java.lang.Object r1 = r10.f43168g
                kotlinx.coroutines.v r1 = (kotlinx.coroutines.C15241v) r1
                java.lang.Object r1 = r10.f43167f
                kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.C15094s) r1
                java.lang.Object r4 = r10.f43166e
                kotlinx.coroutines.internal.q r4 = (kotlinx.coroutines.internal.C15091q) r4
                java.lang.Object r5 = r10.f43165d
                kotlinx.coroutines.q2 r5 = (kotlinx.coroutines.C15159q2) r5
                java.lang.Object r6 = r10.f43164c
                java.lang.Object r7 = r10.f43163b
                kotlin.sequences.o r7 = (kotlin.sequences.AbstractC14514o) r7
                kotlin.C14294d0.m8596n(r11)
                r11 = r10
                goto L9b
            L2a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L32:
                java.lang.Object r0 = r10.f43163b
                kotlin.sequences.o r0 = (kotlin.sequences.AbstractC14514o) r0
                kotlin.C14294d0.m8596n(r11)
                goto La8
            L3b:
                kotlin.C14294d0.m8596n(r11)
                kotlin.sequences.o r11 = r10.f43162a
                kotlinx.coroutines.l2 r1 = kotlinx.coroutines.C15125l2.this
                java.lang.Object r1 = r1.m4014y0()
                boolean r4 = r1 instanceof kotlinx.coroutines.C15241v
                if (r4 == 0) goto L5c
                r2 = r1
                kotlinx.coroutines.v r2 = (kotlinx.coroutines.C15241v) r2
                kotlinx.coroutines.w r2 = r2.f43428e
                r10.f43163b = r11
                r10.f43164c = r1
                r10.f43169h = r3
                java.lang.Object r11 = r11.mo7018c(r2, r10)
                if (r11 != r0) goto La8
                return r0
            L5c:
                boolean r4 = r1 instanceof kotlinx.coroutines.InterfaceC15259y1
                if (r4 == 0) goto La8
                r4 = r1
                kotlinx.coroutines.y1 r4 = (kotlinx.coroutines.InterfaceC15259y1) r4
                kotlinx.coroutines.q2 r4 = r4.mo3496h()
                if (r4 == 0) goto La8
                java.lang.Object r5 = r4.m4219P()
                if (r5 == 0) goto La0
                kotlinx.coroutines.internal.s r5 = (kotlinx.coroutines.internal.C15094s) r5
                r7 = r11
                r6 = r1
                r1 = r5
                r11 = r10
                r5 = r4
            L76:
                boolean r8 = kotlin.jvm.internal.C14342f0.m8193g(r1, r4)
                r8 = r8 ^ r3
                if (r8 == 0) goto La8
                boolean r8 = r1 instanceof kotlinx.coroutines.C15241v
                if (r8 == 0) goto L9b
                r8 = r1
                kotlinx.coroutines.v r8 = (kotlinx.coroutines.C15241v) r8
                kotlinx.coroutines.w r9 = r8.f43428e
                r11.f43163b = r7
                r11.f43164c = r6
                r11.f43165d = r5
                r11.f43166e = r4
                r11.f43167f = r1
                r11.f43168g = r8
                r11.f43169h = r2
                java.lang.Object r8 = r7.mo7018c(r9, r11)
                if (r8 != r0) goto L9b
                return r0
            L9b:
                kotlinx.coroutines.internal.s r1 = r1.m4218Q()
                goto L76
            La0:
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
            */
            //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                r11.<init>(r0)
                throw r11
            La8:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C15125l2.C15130e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public C15125l2(boolean z) {
        this._state = z ? C15134m2.m3985c() : C15134m2.m3984d();
        this._parentHandle = null;
    }

    /* renamed from: C0 */
    private final boolean m4077C0(InterfaceC15259y1 interfaceC15259y1) {
        return (interfaceC15259y1 instanceof C15128c) && ((C15128c) interfaceC15259y1).m4008e();
    }

    /* renamed from: F0 */
    private final boolean m4074F0() {
        Object m4014y0;
        do {
            m4014y0 = m4014y0();
            if (!(m4014y0 instanceof InterfaceC15259y1)) {
                return false;
            }
        } while (m4047a1(m4014y0) < 0);
        return true;
    }

    /* renamed from: H0 */
    private final Void m4072H0(InterfaceC15280l<Object, Unit> interfaceC15280l) {
        while (true) {
            interfaceC15280l.invoke(m4014y0());
        }
    }

    /* renamed from: I0 */
    private final Object m4071I0(Object obj) {
        Throwable th = null;
        while (true) {
            Object m4014y0 = m4014y0();
            if (m4014y0 instanceof C15128c) {
                synchronized (m4014y0) {
                    if (((C15128c) m4014y0).m4006g()) {
                        return C15134m2.m3982f();
                    }
                    boolean m4008e = ((C15128c) m4014y0).m4008e();
                    if (obj != null || !m4008e) {
                        if (th == null) {
                            th = m4027k0(obj);
                        }
                        ((C15128c) m4014y0).m4012a(th);
                    }
                    Throwable m4009d = m4008e ^ true ? ((C15128c) m4014y0).m4009d() : null;
                    if (m4009d != null) {
                        m4066O0(((C15128c) m4014y0).mo3496h(), m4009d);
                    }
                    return C15134m2.m3987a();
                }
            } else if (m4014y0 instanceof InterfaceC15259y1) {
                if (th == null) {
                    th = m4027k0(obj);
                }
                InterfaceC15259y1 interfaceC15259y1 = (InterfaceC15259y1) m4014y0;
                if (interfaceC15259y1.isActive()) {
                    if (m4035g1(interfaceC15259y1, th)) {
                        return C15134m2.m3987a();
                    }
                } else {
                    Object m4033h1 = m4033h1(m4014y0, new CompletionState(th, false, 2, null));
                    if (m4033h1 != C15134m2.m3987a()) {
                        if (m4033h1 != C15134m2.m3986b()) {
                            return m4033h1;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + m4014y0).toString());
                    }
                }
            } else {
                return C15134m2.m3982f();
            }
        }
    }

    /* renamed from: L0 */
    private final AbstractC15119k2<?> m4068L0(InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, boolean z) {
        if (z) {
            AbstractC14779f2 abstractC14779f2 = interfaceC15280l instanceof AbstractC14779f2 ? interfaceC15280l : null;
            return abstractC14779f2 != null ? abstractC14779f2 : new JobSupport(this, interfaceC15280l);
        }
        AbstractC15119k2<?> abstractC15119k2 = interfaceC15280l instanceof AbstractC15119k2 ? interfaceC15280l : null;
        return abstractC15119k2 != null ? abstractC15119k2 : new C14749d2(this, interfaceC15280l);
    }

    /* renamed from: N0 */
    private final C15241v m4067N0(C15094s c15094s) {
        while (c15094s.mo4214V()) {
            c15094s = c15094s.m4217R();
        }
        while (true) {
            c15094s = c15094s.m4218Q();
            if (!c15094s.mo4214V()) {
                if (c15094s instanceof C15241v) {
                    return (C15241v) c15094s;
                }
                if (c15094s instanceof C15159q2) {
                    return null;
                }
            }
        }
    }

    /* renamed from: O0 */
    private final void m4066O0(C15159q2 c15159q2, Throwable th) {
        mo4063R0(th);
        Object m4219P = c15159q2.m4219P();
        if (m4219P != null) {
            CompletionHandlerException completionHandlerException = null;
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, c15159q2); c15094s = c15094s.m4218Q()) {
                if (c15094s instanceof AbstractC14779f2) {
                    AbstractC15119k2 abstractC15119k2 = (AbstractC15119k2) c15094s;
                    try {
                        abstractC15119k2.mo3495f0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            Exceptions.m8551a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC15119k2 + " for " + this, th2);
                            Unit unit = Unit.f41048a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                mo4079A0(completionHandlerException);
            }
            m4038f0(th);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: P0 */
    private final void m4065P0(C15159q2 c15159q2, Throwable th) {
        Object m4219P = c15159q2.m4219P();
        if (m4219P != null) {
            CompletionHandlerException completionHandlerException = null;
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, c15159q2); c15094s = c15094s.m4218Q()) {
                if (c15094s instanceof AbstractC15119k2) {
                    AbstractC15119k2 abstractC15119k2 = (AbstractC15119k2) c15094s;
                    try {
                        abstractC15119k2.mo3495f0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            Exceptions.m8551a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC15119k2 + " for " + this, th2);
                            Unit unit = Unit.f41048a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                mo4079A0(completionHandlerException);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: Q0 */
    private final /* synthetic */ <T extends AbstractC15119k2<?>> void m4064Q0(C15159q2 c15159q2, Throwable th) {
        Object m4219P = c15159q2.m4219P();
        if (m4219P != null) {
            CompletionHandlerException completionHandlerException = null;
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, c15159q2); c15094s = c15094s.m4218Q()) {
                C14342f0.m8175y(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (c15094s instanceof C15094s) {
                    AbstractC15119k2 abstractC15119k2 = (AbstractC15119k2) c15094s;
                    try {
                        abstractC15119k2.mo3495f0(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            Exceptions.m8551a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC15119k2 + " for " + this, th2);
                            Unit unit = Unit.f41048a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                mo4079A0(completionHandlerException);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.x1] */
    /* renamed from: U0 */
    private final void m4059U0(C15124l1 c15124l1) {
        C15159q2 c15159q2 = new C15159q2();
        if (!c15124l1.isActive()) {
            c15159q2 = new C15253x1(c15159q2);
        }
        C13675a.m12692a(f43152a, this, c15124l1, c15159q2);
    }

    /* renamed from: V0 */
    private final void m4057V0(AbstractC15119k2<?> abstractC15119k2) {
        abstractC15119k2.m4225G(new C15159q2());
        C13675a.m12692a(f43152a, this, abstractC15119k2, abstractC15119k2.m4218Q());
    }

    /* renamed from: W */
    private final boolean m4056W(Object obj, C15159q2 c15159q2, AbstractC15119k2<?> abstractC15119k2) {
        int m4206d0;
        C15129d c15129d = new C15129d(abstractC15119k2, abstractC15119k2, this, obj);
        do {
            m4206d0 = c15159q2.m4217R().m4206d0(abstractC15119k2, c15159q2, c15129d);
            if (m4206d0 == 1) {
                return true;
            }
        } while (m4206d0 != 2);
        return false;
    }

    /* renamed from: X */
    private final void m4054X(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                Exceptions.m8551a(th, th2);
            }
        }
    }

    /* renamed from: a1 */
    private final int m4047a1(Object obj) {
        if (obj instanceof C15124l1) {
            if (((C15124l1) obj).isActive()) {
                return 0;
            }
            if (C13675a.m12692a(f43152a, this, obj, C15134m2.m3985c())) {
                mo4061T0();
                return 1;
            }
            return -1;
        } else if (obj instanceof C15253x1) {
            if (C13675a.m12692a(f43152a, this, obj, ((C15253x1) obj).mo3496h())) {
                mo4061T0();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    /* renamed from: b1 */
    private final String m4045b1(Object obj) {
        if (!(obj instanceof C15128c)) {
            return obj instanceof InterfaceC15259y1 ? ((InterfaceC15259y1) obj).isActive() ? "Active" : "New" : obj instanceof CompletionState ? "Cancelled" : "Completed";
        }
        C15128c c15128c = (C15128c) obj;
        return c15128c.m4008e() ? "Cancelling" : c15128c.m4007f() ? "Completing" : "Active";
    }

    /* renamed from: d1 */
    public static /* synthetic */ CancellationException m4041d1(C15125l2 c15125l2, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return c15125l2.m4043c1(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* renamed from: e0 */
    private final Object m4040e0(Object obj) {
        Object m4033h1;
        do {
            Object m4014y0 = m4014y0();
            if ((m4014y0 instanceof InterfaceC15259y1) && (!(m4014y0 instanceof C15128c) || !((C15128c) m4014y0).m4007f())) {
                m4033h1 = m4033h1(m4014y0, new CompletionState(m4027k0(obj), false, 2, null));
            } else {
                return C15134m2.m3987a();
            }
        } while (m4033h1 == C15134m2.m3986b());
        return m4033h1;
    }

    /* renamed from: f0 */
    private final boolean m4038f0(Throwable th) {
        if (mo4075E0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        InterfaceC15235u m4015x0 = m4015x0();
        return (m4015x0 == null || m4015x0 == C15171s2.f43239a) ? z : m4015x0.mo3544g(th) || z;
    }

    /* renamed from: f1 */
    private final boolean m4037f1(InterfaceC15259y1 interfaceC15259y1, Object obj) {
        if (C13675a.m12692a(f43152a, this, interfaceC15259y1, C15134m2.m3981g(obj))) {
            mo4063R0(null);
            mo4062S0(obj);
            m4032i0(interfaceC15259y1, obj);
            return true;
        }
        return false;
    }

    /* renamed from: g1 */
    private final boolean m4035g1(InterfaceC15259y1 interfaceC15259y1, Throwable th) {
        C15159q2 m4016w0 = m4016w0(interfaceC15259y1);
        if (m4016w0 != null) {
            if (C13675a.m12692a(f43152a, this, interfaceC15259y1, new C15128c(m4016w0, false, th))) {
                m4066O0(m4016w0, th);
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: h1 */
    private final Object m4033h1(Object obj, Object obj2) {
        if (!(obj instanceof InterfaceC15259y1)) {
            return C15134m2.m3987a();
        }
        if ((!(obj instanceof C15124l1) && !(obj instanceof AbstractC15119k2)) || (obj instanceof C15241v) || (obj2 instanceof CompletionState)) {
            return m4031i1((InterfaceC15259y1) obj, obj2);
        }
        return m4037f1((InterfaceC15259y1) obj, obj2) ? obj2 : C15134m2.m3986b();
    }

    /* renamed from: i0 */
    private final void m4032i0(InterfaceC15259y1 interfaceC15259y1, Object obj) {
        InterfaceC15235u m4015x0 = m4015x0();
        if (m4015x0 != null) {
            m4015x0.dispose();
            m4049Z0(C15171s2.f43239a);
        }
        if (!(obj instanceof CompletionState)) {
            obj = null;
        }
        CompletionState completionState = (CompletionState) obj;
        Throwable th = completionState != null ? completionState.f42189a : null;
        if (interfaceC15259y1 instanceof AbstractC15119k2) {
            try {
                ((AbstractC15119k2) interfaceC15259y1).mo3495f0(th);
                return;
            } catch (Throwable th2) {
                mo4079A0(new CompletionHandlerException("Exception in completion handler " + interfaceC15259y1 + " for " + this, th2));
                return;
            }
        }
        C15159q2 mo3496h = interfaceC15259y1.mo3496h();
        if (mo3496h != null) {
            m4065P0(mo3496h, th);
        }
    }

    /* renamed from: i1 */
    private final Object m4031i1(InterfaceC15259y1 interfaceC15259y1, Object obj) {
        C15159q2 m4016w0 = m4016w0(interfaceC15259y1);
        if (m4016w0 != null) {
            C15128c c15128c = (C15128c) (!(interfaceC15259y1 instanceof C15128c) ? null : interfaceC15259y1);
            if (c15128c == null) {
                c15128c = new C15128c(m4016w0, false, null);
            }
            synchronized (c15128c) {
                if (c15128c.m4007f()) {
                    return C15134m2.m3987a();
                }
                c15128c.m4004j(true);
                if (c15128c != interfaceC15259y1 && !C13675a.m12692a(f43152a, this, interfaceC15259y1, c15128c)) {
                    return C15134m2.m3986b();
                }
                boolean m4008e = c15128c.m4008e();
                CompletionState completionState = (CompletionState) (!(obj instanceof CompletionState) ? null : obj);
                if (completionState != null) {
                    c15128c.m4012a(completionState.f42189a);
                }
                Throwable m4009d = true ^ m4008e ? c15128c.m4009d() : null;
                Unit unit = Unit.f41048a;
                if (m4009d != null) {
                    m4066O0(m4016w0, m4009d);
                }
                C15241v m4023o0 = m4023o0(interfaceC15259y1);
                if (m4023o0 != null && m4028j1(c15128c, m4023o0, obj)) {
                    return C15134m2.f43181b;
                }
                return m4024n0(c15128c, obj);
            }
        }
        return C15134m2.m3986b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public final void m4029j0(C15128c c15128c, C15241v c15241v, Object obj) {
        C15241v m4067N0 = m4067N0(c15241v);
        if (m4067N0 == null || !m4028j1(c15128c, m4067N0, obj)) {
            mo4052Y(m4024n0(c15128c, obj));
        }
    }

    /* renamed from: j1 */
    private final boolean m4028j1(C15128c c15128c, C15241v c15241v, Object obj) {
        while (Job.C14776a.m5043f(c15241v.f43428e, false, false, new C15127b(this, c15128c, c15241v, obj), 1, null) == C15171s2.f43239a) {
            c15241v = m4067N0(c15241v);
            if (c15241v == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k0 */
    private final Throwable m4027k0(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(mo4036g0(), null, this);
        } else if (obj != null) {
            return ((InterfaceC15237u2) obj).mo3551A();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    /* renamed from: m0 */
    public static /* synthetic */ JobCancellationException m4025m0(C15125l2 c15125l2, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = c15125l2.mo4036g0();
            }
            return new JobCancellationException(str, th, c15125l2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    /* renamed from: n0 */
    private final Object m4024n0(C15128c c15128c, Object obj) {
        boolean m4008e;
        Throwable m4018t0;
        CompletionState completionState = (CompletionState) (!(obj instanceof CompletionState) ? null : obj);
        Throwable th = completionState != null ? completionState.f42189a : null;
        synchronized (c15128c) {
            m4008e = c15128c.m4008e();
            List<Throwable> m4005i = c15128c.m4005i(th);
            m4018t0 = m4018t0(c15128c, m4005i);
            if (m4018t0 != null) {
                m4054X(m4018t0, m4005i);
            }
        }
        boolean z = false;
        if (m4018t0 != null && m4018t0 != th) {
            obj = new CompletionState(m4018t0, false, 2, null);
        }
        if (m4018t0 != null) {
            if ((m4038f0(m4018t0) || mo4013z0(m4018t0)) ? true : true) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((CompletionState) obj).m5155b();
            }
        }
        if (!m4008e) {
            mo4063R0(m4018t0);
        }
        mo4062S0(obj);
        C13675a.m12692a(f43152a, this, c15128c, C15134m2.m3981g(obj));
        m4032i0(c15128c, obj);
        return obj;
    }

    /* renamed from: o0 */
    private final C15241v m4023o0(InterfaceC15259y1 interfaceC15259y1) {
        C15241v c15241v = (C15241v) (!(interfaceC15259y1 instanceof C15241v) ? null : interfaceC15259y1);
        if (c15241v != null) {
            return c15241v;
        }
        C15159q2 mo3496h = interfaceC15259y1.mo3496h();
        if (mo3496h != null) {
            return m4067N0(mo3496h);
        }
        return null;
    }

    /* renamed from: s0 */
    private final Throwable m4019s0(Object obj) {
        if (!(obj instanceof CompletionState)) {
            obj = null;
        }
        CompletionState completionState = (CompletionState) obj;
        if (completionState != null) {
            return completionState.f42189a;
        }
        return null;
    }

    /* renamed from: t0 */
    private final Throwable m4018t0(C15128c c15128c, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (c15128c.m4008e()) {
                return new JobCancellationException(mo4036g0(), null, this);
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
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
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

    /* renamed from: w0 */
    private final C15159q2 m4016w0(InterfaceC15259y1 interfaceC15259y1) {
        C15159q2 mo3496h = interfaceC15259y1.mo3496h();
        if (mo3496h != null) {
            return mo3496h;
        }
        if (interfaceC15259y1 instanceof C15124l1) {
            return new C15159q2();
        }
        if (interfaceC15259y1 instanceof AbstractC15119k2) {
            m4057V0((AbstractC15119k2) interfaceC15259y1);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC15259y1).toString());
    }

    @Override // kotlinx.coroutines.InterfaceC15237u2
    @NotNull
    /* renamed from: A */
    public CancellationException mo3551A() {
        Throwable th;
        Object m4014y0 = m4014y0();
        if (m4014y0 instanceof C15128c) {
            th = ((C15128c) m4014y0).m4009d();
        } else if (m4014y0 instanceof CompletionState) {
            th = ((CompletionState) m4014y0).f42189a;
        } else if (m4014y0 instanceof InterfaceC15259y1) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + m4014y0).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + m4045b1(m4014y0), th, this);
    }

    /* renamed from: A0 */
    public void mo4079A0(@NotNull Throwable th) {
        throw th;
    }

    /* renamed from: B0 */
    public final void m4078B0(@Nullable Job job) {
        if (job == null) {
            m4049Z0(C15171s2.f43239a);
            return;
        }
        job.start();
        InterfaceC15235u mo3829S = job.mo3829S(this);
        m4049Z0(mo3829S);
        if (isCompleted()) {
            mo3829S.dispose();
            m4049Z0(C15171s2.f43239a);
        }
    }

    /* renamed from: D0 */
    public final boolean m4076D0() {
        return m4014y0() instanceof CompletionState;
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    /* renamed from: E */
    public final Object mo3831E(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if (!m4074F0()) {
            Yield.m3531a(interfaceC14268c.getContext());
            return Unit.f41048a;
        }
        Object m4073G0 = m4073G0(interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4073G0 == m8642h ? m4073G0 : Unit.f41048a;
    }

    /* renamed from: E0 */
    protected boolean mo4075E0() {
        return false;
    }

    @Nullable
    /* renamed from: G0 */
    final /* synthetic */ Object m4073G0(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        C15161r.m3853a(c15153p, mo3818w(new C15260y2(this, c15153p)));
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    /* renamed from: J0 */
    public final boolean m4070J0(@Nullable Object obj) {
        Object m4033h1;
        do {
            m4033h1 = m4033h1(m4014y0(), obj);
            if (m4033h1 == C15134m2.m3987a()) {
                return false;
            }
            if (m4033h1 == C15134m2.f43181b) {
                return true;
            }
        } while (m4033h1 == C15134m2.m3986b());
        mo4052Y(m4033h1);
        return true;
    }

    @Nullable
    /* renamed from: K0 */
    public final Object m4069K0(@Nullable Object obj) {
        Object m4033h1;
        do {
            m4033h1 = m4033h1(m4014y0(), obj);
            if (m4033h1 == C15134m2.m3987a()) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m4019s0(obj));
            }
        } while (m4033h1 == C15134m2.m3986b());
        return m4033h1;
    }

    @NotNull
    /* renamed from: M0 */
    public String mo3854M0() {
        return DebugStrings.m3554a(this);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: O */
    public final InterfaceC15194c mo3830O() {
        return this;
    }

    /* renamed from: R0 */
    protected void mo4063R0(@Nullable Throwable th) {
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: S */
    public final InterfaceC15235u mo3829S(@NotNull InterfaceC15244w interfaceC15244w) {
        InterfaceC15064i1 m5043f = Job.C14776a.m5043f(this, true, false, new C15241v(this, interfaceC15244w), 2, null);
        if (m5043f != null) {
            return (InterfaceC15235u) m5043f;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    /* renamed from: S0 */
    protected void mo4062S0(@Nullable Object obj) {
    }

    /* renamed from: T0 */
    public void mo4061T0() {
    }

    /* renamed from: W0 */
    public final <T, R> void m4055W0(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        Object m4014y0;
        do {
            m4014y0 = m4014y0();
            if (interfaceC15197f.mo3706i()) {
                return;
            }
            if (!(m4014y0 instanceof InterfaceC15259y1)) {
                if (interfaceC15197f.mo3703o()) {
                    if (m4014y0 instanceof CompletionState) {
                        interfaceC15197f.mo3701t(((CompletionState) m4014y0).f42189a);
                        return;
                    } else {
                        Undispatched.m222d(interfaceC15284p, C15134m2.m3973o(m4014y0), interfaceC15197f.mo3702s());
                        return;
                    }
                }
                return;
            }
        } while (m4047a1(m4014y0) != 0);
        interfaceC15197f.mo3705k(mo3818w(new C14633c3(this, interfaceC15197f, interfaceC15284p)));
    }

    /* renamed from: X0 */
    public final void m4053X0(@NotNull AbstractC15119k2<?> abstractC15119k2) {
        Object m4014y0;
        do {
            m4014y0 = m4014y0();
            if (!(m4014y0 instanceof AbstractC15119k2)) {
                if (!(m4014y0 instanceof InterfaceC15259y1) || ((InterfaceC15259y1) m4014y0).mo3496h() == null) {
                    return;
                }
                abstractC15119k2.mo4211Y();
                return;
            } else if (m4014y0 != abstractC15119k2) {
                return;
            }
        } while (!C13675a.m12692a(f43152a, this, m4014y0, C15134m2.m3985c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y */
    public void mo4052Y(@Nullable Object obj) {
    }

    /* renamed from: Y0 */
    public final <T, R> void m4051Y0(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        Object m4014y0 = m4014y0();
        if (m4014y0 instanceof CompletionState) {
            interfaceC15197f.mo3701t(((CompletionState) m4014y0).f42189a);
        } else {
            C16231a.m226e(interfaceC15284p, C15134m2.m3973o(m4014y0), interfaceC15197f.mo3702s(), null, 4, null);
        }
    }

    @Nullable
    /* renamed from: Z */
    public final Object m4050Z(@NotNull InterfaceC14268c<Object> interfaceC14268c) {
        Object m4014y0;
        do {
            m4014y0 = m4014y0();
            if (!(m4014y0 instanceof InterfaceC15259y1)) {
                if (!(m4014y0 instanceof CompletionState)) {
                    return C15134m2.m3973o(m4014y0);
                }
                throw ((CompletionState) m4014y0).f42189a;
            }
        } while (m4047a1(m4014y0) < 0);
        return m4048a0(interfaceC14268c);
    }

    /* renamed from: Z0 */
    public final void m4049Z0(@Nullable InterfaceC15235u interfaceC15235u) {
        this._parentHandle = interfaceC15235u;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    public /* synthetic */ boolean mo3828a(@Nullable Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = m4041d1(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(mo4036g0(), null, this);
        }
        mo4042d0(jobCancellationException);
        return true;
    }

    @Nullable
    /* renamed from: a0 */
    final /* synthetic */ Object m4048a0(@NotNull InterfaceC14268c<Object> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15126a c15126a = new C15126a(m8650d, this);
        C15161r.m3853a(c15126a, mo3818w(new C15254x2(this, c15126a)));
        Object m3883y = c15126a.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: b */
    public void mo3827b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo4036g0(), null, this);
        }
        mo4042d0(cancellationException);
    }

    /* renamed from: b0 */
    public final boolean m4046b0(@Nullable Throwable th) {
        return m4044c0(th);
    }

    /* renamed from: c0 */
    public final boolean m4044c0(@Nullable Object obj) {
        Object m3987a = C15134m2.m3987a();
        if (mo3489v0() && (m3987a = m4040e0(obj)) == C15134m2.f43181b) {
            return true;
        }
        if (m3987a == C15134m2.m3987a()) {
            m3987a = m4071I0(obj);
        }
        if (m3987a == C15134m2.m3987a() || m3987a == C15134m2.f43181b) {
            return true;
        }
        if (m3987a == C15134m2.m3982f()) {
            return false;
        }
        mo4052Y(m3987a);
        return true;
    }

    @NotNull
    /* renamed from: c1 */
    protected final CancellationException m4043c1(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = mo4036g0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.InterfaceC14695d0
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.C14776a.m5048a(this);
    }

    /* renamed from: d0 */
    public void mo4042d0(@NotNull Throwable th) {
        m4044c0(th);
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: e1 */
    public final String m4039e1() {
        return mo3854M0() + '{' + m4045b1(m4014y0()) + '}';
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
        return (R) Job.C14776a.m5045d(this, r, interfaceC15284p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g0 */
    public String mo4036g0() {
        return "Job was cancelled";
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        return (E) Job.C14776a.m5044e(this, interfaceC14277c);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b
    @NotNull
    public final CoroutineContext.InterfaceC14277c<?> getKey() {
        return Job.f42281m0;
    }

    /* renamed from: h0 */
    public boolean mo4034h0(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m4044c0(th) && mo4017u0();
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: i */
    public final Sequence<Job> mo3826i() {
        return C14515p.m7004e(new C15130e(null));
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object m4014y0 = m4014y0();
        return (m4014y0 instanceof InterfaceC15259y1) && ((InterfaceC15259y1) m4014y0).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object m4014y0 = m4014y0();
        return (m4014y0 instanceof CompletionState) || ((m4014y0 instanceof C15128c) && ((C15128c) m4014y0).m4008e());
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(m4014y0() instanceof InterfaceC15259y1);
    }

    @Nullable
    /* renamed from: j */
    public final Throwable m4030j() {
        Object m4014y0 = m4014y0();
        if (!(m4014y0 instanceof InterfaceC15259y1)) {
            return m4019s0(m4014y0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: l */
    public final CancellationException mo3825l() {
        Object m4014y0 = m4014y0();
        if (m4014y0 instanceof C15128c) {
            Throwable m4009d = ((C15128c) m4014y0).m4009d();
            if (m4009d != null) {
                CancellationException m4043c1 = m4043c1(m4009d, DebugStrings.m3554a(this) + " is cancelling");
                if (m4043c1 != null) {
                    return m4043c1;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(m4014y0 instanceof InterfaceC15259y1)) {
            if (m4014y0 instanceof CompletionState) {
                return m4041d1(this, ((CompletionState) m4014y0).f42189a, null, 1, null);
            }
            return new JobCancellationException(DebugStrings.m3554a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    @NotNull
    /* renamed from: l0 */
    public final JobCancellationException m4026l0(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = mo4036g0();
        }
        return new JobCancellationException(str, th, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return Job.C14776a.m5042g(this, interfaceC14277c);
    }

    @Override // kotlinx.coroutines.InterfaceC15244w
    /* renamed from: n */
    public final void mo3529n(@NotNull InterfaceC15237u2 interfaceC15237u2) {
        m4044c0(interfaceC15237u2);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: o */
    public final InterfaceC15064i1 mo3824o(boolean z, boolean z2, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        Throwable th;
        AbstractC15119k2<?> abstractC15119k2 = null;
        while (true) {
            Object m4014y0 = m4014y0();
            if (m4014y0 instanceof C15124l1) {
                C15124l1 c15124l1 = (C15124l1) m4014y0;
                if (c15124l1.isActive()) {
                    if (abstractC15119k2 == null) {
                        abstractC15119k2 = m4068L0(interfaceC15280l, z);
                    }
                    if (C13675a.m12692a(f43152a, this, m4014y0, abstractC15119k2)) {
                        return abstractC15119k2;
                    }
                } else {
                    m4059U0(c15124l1);
                }
            } else if (m4014y0 instanceof InterfaceC15259y1) {
                C15159q2 mo3496h = ((InterfaceC15259y1) m4014y0).mo3496h();
                if (mo3496h != null) {
                    InterfaceC15064i1 interfaceC15064i1 = C15171s2.f43239a;
                    if (z && (m4014y0 instanceof C15128c)) {
                        synchronized (m4014y0) {
                            th = ((C15128c) m4014y0).m4009d();
                            if (th == null || ((interfaceC15280l instanceof C15241v) && !((C15128c) m4014y0).m4007f())) {
                                if (abstractC15119k2 == null) {
                                    abstractC15119k2 = m4068L0(interfaceC15280l, z);
                                }
                                if (m4056W(m4014y0, mo3496h, abstractC15119k2)) {
                                    if (th == null) {
                                        return abstractC15119k2;
                                    }
                                    interfaceC15064i1 = abstractC15119k2;
                                }
                            }
                            Unit unit = Unit.f41048a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            interfaceC15280l.invoke(th);
                        }
                        return interfaceC15064i1;
                    }
                    if (abstractC15119k2 == null) {
                        abstractC15119k2 = m4068L0(interfaceC15280l, z);
                    }
                    if (m4056W(m4014y0, mo3496h, abstractC15119k2)) {
                        return abstractC15119k2;
                    }
                } else if (m4014y0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                } else {
                    m4057V0((AbstractC15119k2) m4014y0);
                }
            } else {
                if (z2) {
                    if (!(m4014y0 instanceof CompletionState)) {
                        m4014y0 = null;
                    }
                    CompletionState completionState = (CompletionState) m4014y0;
                    interfaceC15280l.invoke(completionState != null ? completionState.f42189a : null);
                }
                return C15171s2.f43239a;
            }
        }
    }

    @Nullable
    /* renamed from: p0 */
    public final Object m4022p0() {
        Object m4014y0 = m4014y0();
        if (!(m4014y0 instanceof InterfaceC15259y1)) {
            if (!(m4014y0 instanceof CompletionState)) {
                return C15134m2.m3973o(m4014y0);
            }
            throw ((CompletionState) m4014y0).f42189a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.C14776a.m5041h(this, coroutineContext);
    }

    @Nullable
    /* renamed from: q0 */
    protected final Throwable m4021q0() {
        Object m4014y0 = m4014y0();
        if (m4014y0 instanceof C15128c) {
            Throwable m4009d = ((C15128c) m4014y0).m4009d();
            if (m4009d != null) {
                return m4009d;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(m4014y0 instanceof InterfaceC15259y1)) {
            if (m4014y0 instanceof CompletionState) {
                return ((CompletionState) m4014y0).f42189a;
            }
            return null;
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    /* renamed from: r0 */
    protected final boolean m4020r0() {
        Object m4014y0 = m4014y0();
        return (m4014y0 instanceof CompletionState) && ((CompletionState) m4014y0).m5156a();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int m4047a1;
        do {
            m4047a1 = m4047a1(m4014y0());
            if (m4047a1 == 0) {
                return false;
            }
        } while (m4047a1 != 1);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    /* renamed from: t */
    public Job mo3819t(@NotNull Job job) {
        return Job.C14776a.m5040i(this, job);
    }

    @NotNull
    public String toString() {
        return m4039e1() + '@' + DebugStrings.m3553b(this);
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15194c
    /* renamed from: u */
    public final <R> void mo3707u(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        Object m4014y0;
        do {
            m4014y0 = m4014y0();
            if (interfaceC15197f.mo3706i()) {
                return;
            }
            if (!(m4014y0 instanceof InterfaceC15259y1)) {
                if (interfaceC15197f.mo3703o()) {
                    Undispatched.m223c(interfaceC15280l, interfaceC15197f.mo3702s());
                    return;
                }
                return;
            }
        } while (m4047a1(m4014y0) != 0);
        interfaceC15197f.mo3705k(mo3818w(new C14750d3(this, interfaceC15197f, interfaceC15280l)));
    }

    /* renamed from: u0 */
    public boolean mo4017u0() {
        return true;
    }

    /* renamed from: v0 */
    public boolean mo3489v0() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: w */
    public final InterfaceC15064i1 mo3818w(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return mo3824o(false, true, interfaceC15280l);
    }

    @Nullable
    /* renamed from: x0 */
    public final InterfaceC15235u m4015x0() {
        return (InterfaceC15235u) this._parentHandle;
    }

    @Nullable
    /* renamed from: y0 */
    public final Object m4014y0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof AbstractC15073c0)) {
                return obj;
            }
            ((AbstractC15073c0) obj).mo3620c(this);
        }
    }

    /* renamed from: z0 */
    protected boolean mo4013z0(@NotNull Throwable th) {
        return false;
    }
}
