package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.C14294d0;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.Combine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;
import p617l1.InterfaceC15288t;
import p617l1.InterfaceC15289u;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000l\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a\u008a\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u008c\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u009d\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u008a\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0001\u0010\f\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u009b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032A\b\u0001\u0010\f\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a¢\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\f\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001cø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aµ\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032G\b\u0001\u0010\f\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a¼\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\f\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aÏ\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032M\b\u0001\u0010\f\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001as\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0084\u0001\u00103\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u00104\u001as\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0082\bø\u0001\u0000¢\u0006\u0004\b5\u00102\u001a\u0084\u0001\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0082\bø\u0001\u0000¢\u0006\u0004\b6\u00104\u001a#\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010.07\"\u0004\b\u0000\u0010-H\u0002¢\u0006\u0004\b8\u00109\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010;\u001ax\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001aj\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0004\b?\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, m12616d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/h;", "flow", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "Lkotlin/coroutines/c;", "", "transform", "p", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "flow2", "f", "Lkotlin/Function4;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/r;)Lkotlinx/coroutines/flow/h;", C7304t.f25048d, "T3", "flow3", "e", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/r;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function5;", "k", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/s;)Lkotlinx/coroutines/flow/h;", "T4", "flow4", "d", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/s;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function6;", "j", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/t;)Lkotlinx/coroutines/flow/h;", "T5", "flow5", "c", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/t;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function7;", "i", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/u;)Lkotlinx/coroutines/flow/h;", ExifInterface.GPS_DIRECTION_TRUE, "", "flows", "Lkotlin/Function2;", "g", "([Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "m", "([Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "o", "n", "Lkotlin/Function0;", "r", "()Ll1/a;", "", "(Ljava/lang/Iterable;Ll1/p;)Lkotlinx/coroutines/flow/h;", "h", "(Ljava/lang/Iterable;Ll1/q;)Lkotlinx/coroutines/flow/h;", AdnName.OTHER, "s", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Zip {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14912a<R> implements InterfaceC14958h<R> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42604a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC14958h f42605b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15285q f42606c;

        /* compiled from: Zip.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u008a@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m12616d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/i;", "", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C14913a extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, Object[], InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private FlowCollector f42607a;

            /* renamed from: b */
            private Object[] f42608b;

            /* renamed from: c */
            Object f42609c;

            /* renamed from: d */
            Object f42610d;

            /* renamed from: e */
            Object f42611e;

            /* renamed from: f */
            int f42612f;

            /* renamed from: g */
            final /* synthetic */ C14912a f42613g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14913a(InterfaceC14268c interfaceC14268c, C14912a c14912a) {
                super(3, interfaceC14268c);
                this.f42613g = c14912a;
            }

            @NotNull
            public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
                C14913a c14913a = new C14913a(interfaceC14268c, this.f42613g);
                c14913a.f42607a = flowCollector;
                c14913a.f42608b = objArr;
                return c14913a;
            }

            @Override // p617l1.InterfaceC15285q
            public final Object invoke(Object obj, Object[] objArr, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C14913a) create((FlowCollector) obj, objArr, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                FlowCollector flowCollector;
                FlowCollector flowCollector2;
                Object[] objArr;
                m8642h = C14287b.m8642h();
                int i = this.f42612f;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    flowCollector = this.f42607a;
                    Object[] objArr2 = this.f42608b;
                    InterfaceC15285q interfaceC15285q = this.f42613g.f42606c;
                    Object obj2 = objArr2[0];
                    Object obj3 = objArr2[1];
                    this.f42609c = flowCollector;
                    this.f42610d = objArr2;
                    this.f42611e = flowCollector;
                    this.f42612f = 1;
                    InlineMarker.m8227e(6);
                    Object invoke = interfaceC15285q.invoke(obj2, obj3, this);
                    InlineMarker.m8227e(7);
                    if (invoke == m8642h) {
                        return m8642h;
                    }
                    flowCollector2 = flowCollector;
                    objArr = objArr2;
                    obj = invoke;
                } else if (i != 1) {
                    if (i == 2) {
                        Object[] objArr3 = (Object[]) this.f42610d;
                        FlowCollector flowCollector3 = (FlowCollector) this.f42609c;
                        C14294d0.m8596n(obj);
                        return Unit.f41048a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowCollector = (FlowCollector) this.f42611e;
                    objArr = (Object[]) this.f42610d;
                    flowCollector2 = (FlowCollector) this.f42609c;
                    C14294d0.m8596n(obj);
                }
                this.f42609c = flowCollector2;
                this.f42610d = objArr;
                this.f42612f = 2;
                if (flowCollector.emit(obj, this) == m8642h) {
                    return m8642h;
                }
                return Unit.f41048a;
            }
        }

        public C14912a(InterfaceC14958h interfaceC14958h, InterfaceC14958h interfaceC14958h2, InterfaceC15285q interfaceC15285q) {
            this.f42604a = interfaceC14958h;
            this.f42605b = interfaceC14958h2;
            this.f42606c = interfaceC15285q;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object m4805a = Combine.m4805a(flowCollector, new InterfaceC14958h[]{this.f42604a, this.f42605b}, Zip.m4858a(), new C14913a(null, this), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return m4805a == m8642h ? m4805a : Unit.f41048a;
        }
    }

    /* compiled from: Zip.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()Ljava/lang/Void;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14914b extends Lambda implements InterfaceC15269a {

        /* renamed from: a */
        public static final C14914b f42614a = new C14914b();

        C14914b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @Nullable
        /* renamed from: a */
        public final Void invoke() {
            return null;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ InterfaceC15269a m4858a() {
        return m4841r();
    }

    @NotNull
    /* renamed from: b */
    public static final /* synthetic */ <T, R> InterfaceC14958h<R> m4857b(@NotNull Iterable<? extends InterfaceC14958h<? extends T>> iterable, @NotNull InterfaceC15284p<? super T[], ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        List m12233I5;
        m12233I5 = _Collections.m12233I5(iterable);
        Object[] array = m12233I5.toArray(new InterfaceC14958h[0]);
        if (array != null) {
            C14342f0.m8177w();
            return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4((InterfaceC14958h[]) array, interfaceC15284p);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    /* renamed from: c */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4856c(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @NotNull final InterfaceC15288t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15288t) {
        final InterfaceC14958h[] interfaceC14958hArr = {interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5};
        return new InterfaceC14958h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* compiled from: Zip.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", m8638f = "Zip.kt", m8637i = {0, 0, 0, 0, 1, 1}, m8636l = {338, 338}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, m8633s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C149182 extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, Object[], InterfaceC14268c<? super Unit>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* renamed from: p$ */
                private FlowCollector f42623p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C149182(InterfaceC14268c interfaceC14268c, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2) {
                    super(3, interfaceC14268c);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2;
                }

                @NotNull
                public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
                    C149182 c149182 = new C149182(interfaceC14268c, this.this$0);
                    c149182.f42623p$ = flowCollector;
                    c149182.p$0 = objArr;
                    return c149182;
                }

                @Override // p617l1.InterfaceC15285q
                public final Object invoke(Object obj, Object[] objArr, InterfaceC14268c<? super Unit> interfaceC14268c) {
                    return ((C149182) create((FlowCollector) obj, objArr, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object m8642h;
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2;
                    Object[] objArr;
                    m8642h = C14287b.m8642h();
                    int i = this.label;
                    if (i == 0) {
                        C14294d0.m8596n(obj);
                        flowCollector = this.f42623p$;
                        Object[] objArr2 = this.p$0;
                        InterfaceC15288t interfaceC15288t = interfaceC15288t;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        Object obj6 = objArr2[4];
                        this.L$0 = flowCollector;
                        this.L$1 = objArr2;
                        this.L$2 = flowCollector;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        InlineMarker.m8227e(6);
                        Object invoke = interfaceC15288t.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        InlineMarker.m8227e(7);
                        if (invoke == m8642h) {
                            return m8642h;
                        }
                        flowCollector2 = flowCollector;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i != 1) {
                        if (i == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                            C14294d0.m8596n(obj);
                            return Unit.f41048a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        InterfaceC14268c interfaceC14268c = (InterfaceC14268c) this.L$3;
                        flowCollector = (FlowCollector) this.L$2;
                        objArr = (Object[]) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        C14294d0.m8596n(obj);
                    }
                    this.L$0 = flowCollector2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == m8642h) {
                        return m8642h;
                    }
                    return Unit.f41048a;
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object m4805a = Combine.m4805a(flowCollector, interfaceC14958hArr, Zip.m4858a(), new C149182(null, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return m4805a == m8642h ? m4805a : Unit.f41048a;
            }
        };
    }

    @NotNull
    /* renamed from: d */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4855d(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull final InterfaceC15287s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15287s) {
        final InterfaceC14958h[] interfaceC14958hArr = {interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4};
        return new InterfaceC14958h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1

            /* compiled from: Zip.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$2", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3", m8638f = "Zip.kt", m8637i = {0, 0, 0, 0, 1, 1}, m8636l = {337, 337}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, m8633s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C149163 extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, Object[], InterfaceC14268c<? super Unit>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* renamed from: p$ */
                private FlowCollector f42617p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C149163(InterfaceC14268c interfaceC14268c, FlowKt__ZipKt$combine$$inlined$combine$1 flowKt__ZipKt$combine$$inlined$combine$1) {
                    super(3, interfaceC14268c);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combine$1;
                }

                @NotNull
                public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
                    C149163 c149163 = new C149163(interfaceC14268c, this.this$0);
                    c149163.f42617p$ = flowCollector;
                    c149163.p$0 = objArr;
                    return c149163;
                }

                @Override // p617l1.InterfaceC15285q
                public final Object invoke(Object obj, Object[] objArr, InterfaceC14268c<? super Unit> interfaceC14268c) {
                    return ((C149163) create((FlowCollector) obj, objArr, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object m8642h;
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2;
                    Object[] objArr;
                    m8642h = C14287b.m8642h();
                    int i = this.label;
                    if (i == 0) {
                        C14294d0.m8596n(obj);
                        flowCollector = this.f42617p$;
                        Object[] objArr2 = this.p$0;
                        InterfaceC15287s interfaceC15287s = interfaceC15287s;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        this.L$0 = flowCollector;
                        this.L$1 = objArr2;
                        this.L$2 = flowCollector;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        InlineMarker.m8227e(6);
                        Object invoke = interfaceC15287s.invoke(obj2, obj3, obj4, obj5, this);
                        InlineMarker.m8227e(7);
                        if (invoke == m8642h) {
                            return m8642h;
                        }
                        flowCollector2 = flowCollector;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i != 1) {
                        if (i == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                            C14294d0.m8596n(obj);
                            return Unit.f41048a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        InterfaceC14268c interfaceC14268c = (InterfaceC14268c) this.L$3;
                        flowCollector = (FlowCollector) this.L$2;
                        objArr = (Object[]) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        C14294d0.m8596n(obj);
                    }
                    this.L$0 = flowCollector2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == m8642h) {
                        return m8642h;
                    }
                    return Unit.f41048a;
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object m4805a = Combine.m4805a(flowCollector, interfaceC14958hArr, new InterfaceC15269a<Object[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1.2
                    {
                        super(0);
                    }

                    @Override // p617l1.InterfaceC15269a
                    @Nullable
                    public final Object[] invoke() {
                        return new Object[interfaceC14958hArr.length];
                    }
                }, new C149163(null, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return m4805a == m8642h ? m4805a : Unit.f41048a;
            }
        };
    }

    @NotNull
    /* renamed from: e */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4854e(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @Inference @NotNull final InterfaceC15286r<? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15286r) {
        final InterfaceC14958h[] interfaceC14958hArr = {interfaceC14958h, interfaceC14958h2, interfaceC14958h3};
        return new InterfaceC14958h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* compiled from: Zip.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", m8638f = "Zip.kt", m8637i = {0, 0, 0, 0, 1, 1}, m8636l = {336, 336}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, m8633s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C149172 extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, Object[], InterfaceC14268c<? super Unit>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* renamed from: p$ */
                private FlowCollector f42620p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C149172(InterfaceC14268c interfaceC14268c, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1) {
                    super(3, interfaceC14268c);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1;
                }

                @NotNull
                public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
                    C149172 c149172 = new C149172(interfaceC14268c, this.this$0);
                    c149172.f42620p$ = flowCollector;
                    c149172.p$0 = objArr;
                    return c149172;
                }

                @Override // p617l1.InterfaceC15285q
                public final Object invoke(Object obj, Object[] objArr, InterfaceC14268c<? super Unit> interfaceC14268c) {
                    return ((C149172) create((FlowCollector) obj, objArr, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object m8642h;
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2;
                    Object[] objArr;
                    m8642h = C14287b.m8642h();
                    int i = this.label;
                    if (i == 0) {
                        C14294d0.m8596n(obj);
                        flowCollector = this.f42620p$;
                        Object[] objArr2 = this.p$0;
                        InterfaceC15286r interfaceC15286r = interfaceC15286r;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        this.L$0 = flowCollector;
                        this.L$1 = objArr2;
                        this.L$2 = flowCollector;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        InlineMarker.m8227e(6);
                        Object invoke = interfaceC15286r.invoke(obj2, obj3, obj4, this);
                        InlineMarker.m8227e(7);
                        if (invoke == m8642h) {
                            return m8642h;
                        }
                        flowCollector2 = flowCollector;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i != 1) {
                        if (i == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                            C14294d0.m8596n(obj);
                            return Unit.f41048a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        InterfaceC14268c interfaceC14268c = (InterfaceC14268c) this.L$3;
                        flowCollector = (FlowCollector) this.L$2;
                        objArr = (Object[]) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        C14294d0.m8596n(obj);
                    }
                    this.L$0 = flowCollector2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == m8642h) {
                        return m8642h;
                    }
                    return Unit.f41048a;
                }
            }

            @Override // kotlinx.coroutines.flow.InterfaceC14958h
            @Nullable
            /* renamed from: e */
            public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object m4805a = Combine.m4805a(flowCollector, interfaceC14958hArr, Zip.m4858a(), new C149172(null, this), interfaceC14268c);
                m8642h = C14287b.m8642h();
                return m4805a == m8642h ? m4805a : Unit.f41048a;
            }
        };
    }

    @NotNull
    /* renamed from: f */
    public static final <T1, T2, R> InterfaceC14958h<R> m4853f(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return C15006k.m4704O0(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    @org.jetbrains.annotations.NotNull
    /* renamed from: g */
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.InterfaceC14958h<R> m4852g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T>[] r1, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super T[], ? super kotlin.coroutines.InterfaceC14268c<? super R>, ? extends java.lang.Object> r2) {
        /*
            kotlin.jvm.internal.C14342f0.m8177w()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Zip.m4852g(kotlinx.coroutines.flow.h[], l1.p):kotlinx.coroutines.flow.h");
    }

    @NotNull
    /* renamed from: h */
    public static final /* synthetic */ <T, R> InterfaceC14958h<R> m4851h(@NotNull Iterable<? extends InterfaceC14958h<? extends T>> iterable, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T[], ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        List m12233I5;
        m12233I5 = _Collections.m12233I5(iterable);
        Object[] array = m12233I5.toArray(new InterfaceC14958h[0]);
        if (array != null) {
            C14342f0.m8177w();
            return C15006k.m4707N0(new FlowKt__ZipKt$combineTransform$7((InterfaceC14958h[]) array, interfaceC15285q, null));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    /* renamed from: i */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC14958h<R> m4850i(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @NotNull InterfaceC14958h<? extends T5> interfaceC14958h5, @Inference @NotNull InterfaceC15289u<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15289u) {
        return C15006k.m4707N0(new C14930xd7c321ea(new InterfaceC14958h[]{interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4, interfaceC14958h5}, null, interfaceC15289u));
    }

    @NotNull
    /* renamed from: j */
    public static final <T1, T2, T3, T4, R> InterfaceC14958h<R> m4849j(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @NotNull InterfaceC14958h<? extends T4> interfaceC14958h4, @Inference @NotNull InterfaceC15288t<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15288t) {
        return C15006k.m4707N0(new C14928xd7c321e9(new InterfaceC14958h[]{interfaceC14958h, interfaceC14958h2, interfaceC14958h3, interfaceC14958h4}, null, interfaceC15288t));
    }

    @NotNull
    /* renamed from: k */
    public static final <T1, T2, T3, R> InterfaceC14958h<R> m4848k(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC14958h<? extends T3> interfaceC14958h3, @Inference @NotNull InterfaceC15287s<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15287s) {
        return C15006k.m4707N0(new C14926xd7c321e8(new InterfaceC14958h[]{interfaceC14958h, interfaceC14958h2, interfaceC14958h3}, null, interfaceC15287s));
    }

    @NotNull
    /* renamed from: l */
    public static final <T1, T2, R> InterfaceC14958h<R> m4847l(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @Inference @NotNull InterfaceC15286r<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15286r) {
        return C15006k.m4707N0(new C14924xd7c321e7(new InterfaceC14958h[]{interfaceC14958h, interfaceC14958h2}, null, interfaceC15286r));
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    @org.jetbrains.annotations.NotNull
    /* renamed from: m */
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.InterfaceC14958h<R> m4846m(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T>[] r2, @kotlin.Inference @org.jetbrains.annotations.NotNull p617l1.InterfaceC15285q<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit>, ? extends java.lang.Object> r3) {
        /*
            kotlin.jvm.internal.C14342f0.m8177w()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6
            r1 = 0
            r0.<init>(r2, r3, r1)
            kotlinx.coroutines.flow.h r2 = kotlinx.coroutines.flow.C15006k.m4707N0(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Zip.m4846m(kotlinx.coroutines.flow.h[], l1.q):kotlinx.coroutines.flow.h");
    }

    /* renamed from: o */
    private static final /* synthetic */ <T, R> InterfaceC14958h<R> m4844o(InterfaceC14958h<? extends T>[] interfaceC14958hArr, InterfaceC15284p<? super T[], ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$3(interfaceC14958hArr, interfaceC15284p);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    /* renamed from: p */
    public static final <T1, T2, R> InterfaceC14958h<R> m4843p(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return new C14912a(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    /* renamed from: q */
    public static final <T1, T2, R> InterfaceC14958h<R> m4842q(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @Inference @NotNull InterfaceC15286r<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15286r) {
        return C15006k.m4707N0(new C14922xd7c321e6(new InterfaceC14958h[]{interfaceC14958h, interfaceC14958h2}, null, interfaceC15286r));
    }

    /* renamed from: r */
    private static final <T> InterfaceC15269a<T[]> m4841r() {
        return C14914b.f42614a;
    }

    @NotNull
    /* renamed from: s */
    public static final <T1, T2, R> InterfaceC14958h<R> m4840s(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return Combine.m4804b(interfaceC14958h, interfaceC14958h2, interfaceC15285q);
    }
}
