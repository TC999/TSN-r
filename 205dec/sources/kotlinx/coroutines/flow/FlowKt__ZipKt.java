package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a\u008a\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u008c\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\f\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001a\u009d\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011\u00a2\u0006\u0002\b\u0014H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011\u00a2\u0006\u0002\b\u0014\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016\u001a\u008a\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0001\u0010\f\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u009b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032A\b\u0001\u0010\f\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c\u00a2\u0006\u0002\b\u0014\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u00a2\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\f\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u00b5\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032G\b\u0001\u0010\f\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#\u00a2\u0006\u0002\b\u0014\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%\u001a\u00bc\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\f\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0#\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u001a\u00cf\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001f\"\u0004\b\u0004\u0010&\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032M\b\u0001\u0010\f\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*\u00a2\u0006\u0002\b\u0014\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001as\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102\u001a\u0084\u0001\u00103\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104\u001as\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00102\u001a\u0084\u0001\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010/\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030.\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\u0014H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00104\u001a#\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010.07\"\u0004\b\u0000\u0010-H\u0002\u00a2\u0006\u0004\b8\u00109\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2*\b\u0004\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b00H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010;\u001ax\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010-\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030:2;\b\u0005\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=\u001aj\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/h;", "flow", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "Lkotlin/coroutines/c;", "", "transform", "p", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "flow2", "c", "Lkotlin/Function4;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/r;)Lkotlinx/coroutines/flow/h;", "i", "T3", "flow3", "d", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/r;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function5;", "j", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/s;)Lkotlinx/coroutines/flow/h;", "T4", "flow4", "e", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/s;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function6;", "k", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/t;)Lkotlinx/coroutines/flow/h;", "T5", "flow5", "f", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/t;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function7;", "l", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/u;)Lkotlinx/coroutines/flow/h;", "T", "", "flows", "Lkotlin/Function2;", "g", "([Lkotlinx/coroutines/flow/h;Ld2/p;)Lkotlinx/coroutines/flow/h;", "m", "([Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "o", "n", "Lkotlin/Function0;", "r", "()Ld2/a;", "", "(Ljava/lang/Iterable;Ld2/p;)Lkotlinx/coroutines/flow/h;", "h", "(Ljava/lang/Iterable;Ld2/q;)Lkotlinx/coroutines/flow/h;", "other", "s", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__ZipKt {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> implements h<R> {

        /* renamed from: a */
        final /* synthetic */ h f59964a;

        /* renamed from: b */
        final /* synthetic */ h f59965b;

        /* renamed from: c */
        final /* synthetic */ d2.q f59966c;

        /* compiled from: Zip.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u008a@\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/i;", "", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$a$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1208a extends SuspendLambda implements d2.q<i<? super R>, Object[], kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private i f59967a;

            /* renamed from: b */
            private Object[] f59968b;

            /* renamed from: c */
            Object f59969c;

            /* renamed from: d */
            Object f59970d;

            /* renamed from: e */
            Object f59971e;

            /* renamed from: f */
            int f59972f;

            /* renamed from: g */
            final /* synthetic */ a f59973g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1208a(kotlin.coroutines.c cVar, a aVar) {
                super(3, cVar);
                this.f59973g = aVar;
            }

            @NotNull
            public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
                C1208a c1208a = new C1208a(cVar, this.f59973g);
                c1208a.f59967a = iVar;
                c1208a.f59968b = objArr;
                return c1208a;
            }

            @Override // d2.q
            public final Object invoke(Object obj, Object[] objArr, kotlin.coroutines.c<? super f1> cVar) {
                return ((C1208a) create((i) obj, objArr, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                i iVar;
                i iVar2;
                Object[] objArr;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f59972f;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    iVar = this.f59967a;
                    Object[] objArr2 = this.f59968b;
                    d2.q qVar = this.f59973g.f59966c;
                    Object obj2 = objArr2[0];
                    Object obj3 = objArr2[1];
                    this.f59969c = iVar;
                    this.f59970d = objArr2;
                    this.f59971e = iVar;
                    this.f59972f = 1;
                    kotlin.jvm.internal.c0.e(6);
                    Object invoke = qVar.invoke(obj2, obj3, this);
                    kotlin.jvm.internal.c0.e(7);
                    if (invoke == h4) {
                        return h4;
                    }
                    iVar2 = iVar;
                    objArr = objArr2;
                    obj = invoke;
                } else if (i4 != 1) {
                    if (i4 == 2) {
                        Object[] objArr3 = (Object[]) this.f59970d;
                        i iVar3 = (i) this.f59969c;
                        kotlin.d0.n(obj);
                        return f1.f55527a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    iVar = (i) this.f59971e;
                    objArr = (Object[]) this.f59970d;
                    iVar2 = (i) this.f59969c;
                    kotlin.d0.n(obj);
                }
                this.f59969c = iVar2;
                this.f59970d = objArr;
                this.f59972f = 2;
                if (iVar.emit(obj, this) == h4) {
                    return h4;
                }
                return f1.f55527a;
            }
        }

        public a(h hVar, h hVar2, d2.q qVar) {
            this.f59964a = hVar;
            this.f59965b = hVar2;
            this.f59966c = qVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object a4 = CombineKt.a(iVar, new h[]{this.f59964a, this.f59965b}, FlowKt__ZipKt.a(), new C1208a(null, this), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return a4 == h4 ? a4 : f1.f55527a;
        }
    }

    /* compiled from: Zip.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/Void;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a {

        /* renamed from: a */
        public static final b f59974a = new b();

        b() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Void invoke() {
            return null;
        }
    }

    public static final /* synthetic */ d2.a a() {
        return r();
    }

    @NotNull
    public static final /* synthetic */ <T, R> h<R> b(@NotNull Iterable<? extends h<? extends T>> iterable, @NotNull d2.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        List G5;
        G5 = kotlin.collections.f0.G5(iterable);
        Object[] array = G5.toArray(new h[0]);
        if (array != null) {
            kotlin.jvm.internal.f0.w();
            return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4((h[]) array, pVar);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final <T1, T2, R> h<R> c(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return k.O0(hVar, hVar2, qVar);
    }

    @NotNull
    public static final <T1, T2, T3, R> h<R> d(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @BuilderInference @NotNull final d2.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        final h[] hVarArr = {hVar, hVar2, hVar3};
        return new h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Zip.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2  reason: invalid class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements d2.q<i<? super R>, Object[], kotlin.coroutines.c<? super f1>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                private i p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.c cVar, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1;
                }

                @NotNull
                public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.this$0);
                    anonymousClass2.p$ = iVar;
                    anonymousClass2.p$0 = objArr;
                    return anonymousClass2;
                }

                @Override // d2.q
                public final Object invoke(Object obj, Object[] objArr, kotlin.coroutines.c<? super f1> cVar) {
                    return ((AnonymousClass2) create((i) obj, objArr, cVar)).invokeSuspend(f1.f55527a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object h4;
                    i iVar;
                    i iVar2;
                    Object[] objArr;
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    int i4 = this.label;
                    if (i4 == 0) {
                        kotlin.d0.n(obj);
                        iVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        d2.r rVar = rVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        this.L$0 = iVar;
                        this.L$1 = objArr2;
                        this.L$2 = iVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        kotlin.jvm.internal.c0.e(6);
                        Object invoke = rVar.invoke(obj2, obj3, obj4, this);
                        kotlin.jvm.internal.c0.e(7);
                        if (invoke == h4) {
                            return h4;
                        }
                        iVar2 = iVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i4 != 1) {
                        if (i4 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i iVar3 = (i) this.L$0;
                            kotlin.d0.n(obj);
                            return f1.f55527a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        kotlin.coroutines.c cVar = (kotlin.coroutines.c) this.L$3;
                        iVar = (i) this.L$2;
                        objArr = (Object[]) this.L$1;
                        iVar2 = (i) this.L$0;
                        kotlin.d0.n(obj);
                    }
                    this.L$0 = iVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (iVar.emit(obj, this) == h4) {
                        return h4;
                    }
                    return f1.f55527a;
                }
            }

            @Override // kotlinx.coroutines.flow.h
            @Nullable
            public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object a4 = CombineKt.a(iVar, hVarArr, FlowKt__ZipKt.a(), new AnonymousClass2(null, this), cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return a4 == h4 ? a4 : f1.f55527a;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> h<R> e(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull final d2.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        final h[] hVarArr = {hVar, hVar2, hVar3, hVar4};
        return new h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Zip.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3  reason: invalid class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements d2.q<i<? super R>, Object[], kotlin.coroutines.c<? super f1>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                private i p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(kotlin.coroutines.c cVar, FlowKt__ZipKt$combine$$inlined$combine$1 flowKt__ZipKt$combine$$inlined$combine$1) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combine$1;
                }

                @NotNull
                public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(cVar, this.this$0);
                    anonymousClass3.p$ = iVar;
                    anonymousClass3.p$0 = objArr;
                    return anonymousClass3;
                }

                @Override // d2.q
                public final Object invoke(Object obj, Object[] objArr, kotlin.coroutines.c<? super f1> cVar) {
                    return ((AnonymousClass3) create((i) obj, objArr, cVar)).invokeSuspend(f1.f55527a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object h4;
                    i iVar;
                    i iVar2;
                    Object[] objArr;
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    int i4 = this.label;
                    if (i4 == 0) {
                        kotlin.d0.n(obj);
                        iVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        d2.s sVar = sVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        this.L$0 = iVar;
                        this.L$1 = objArr2;
                        this.L$2 = iVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        kotlin.jvm.internal.c0.e(6);
                        Object invoke = sVar.invoke(obj2, obj3, obj4, obj5, this);
                        kotlin.jvm.internal.c0.e(7);
                        if (invoke == h4) {
                            return h4;
                        }
                        iVar2 = iVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i4 != 1) {
                        if (i4 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i iVar3 = (i) this.L$0;
                            kotlin.d0.n(obj);
                            return f1.f55527a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        kotlin.coroutines.c cVar = (kotlin.coroutines.c) this.L$3;
                        iVar = (i) this.L$2;
                        objArr = (Object[]) this.L$1;
                        iVar2 = (i) this.L$0;
                        kotlin.d0.n(obj);
                    }
                    this.L$0 = iVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (iVar.emit(obj, this) == h4) {
                        return h4;
                    }
                    return f1.f55527a;
                }
            }

            @Override // kotlinx.coroutines.flow.h
            @Nullable
            public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object a4 = CombineKt.a(iVar, hVarArr, new d2.a<Object[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1.2
                    {
                        super(0);
                    }

                    @Override // d2.a
                    @Nullable
                    public final Object[] invoke() {
                        return new Object[hVarArr.length];
                    }
                }, new AnonymousClass3(null, this), cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return a4 == h4 ? a4 : f1.f55527a;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> h<R> f(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull h<? extends T5> hVar5, @NotNull final d2.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        final h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5};
        return new h<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Zip.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2  reason: invalid class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements d2.q<i<? super R>, Object[], kotlin.coroutines.c<? super f1>, Object> {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                private i p$;
                private Object[] p$0;
                final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.c cVar, FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2) {
                    super(3, cVar);
                    this.this$0 = flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2;
                }

                @NotNull
                public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.this$0);
                    anonymousClass2.p$ = iVar;
                    anonymousClass2.p$0 = objArr;
                    return anonymousClass2;
                }

                @Override // d2.q
                public final Object invoke(Object obj, Object[] objArr, kotlin.coroutines.c<? super f1> cVar) {
                    return ((AnonymousClass2) create((i) obj, objArr, cVar)).invokeSuspend(f1.f55527a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object h4;
                    i iVar;
                    i iVar2;
                    Object[] objArr;
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    int i4 = this.label;
                    if (i4 == 0) {
                        kotlin.d0.n(obj);
                        iVar = this.p$;
                        Object[] objArr2 = this.p$0;
                        d2.t tVar = tVar;
                        Object obj2 = objArr2[0];
                        Object obj3 = objArr2[1];
                        Object obj4 = objArr2[2];
                        Object obj5 = objArr2[3];
                        Object obj6 = objArr2[4];
                        this.L$0 = iVar;
                        this.L$1 = objArr2;
                        this.L$2 = iVar;
                        this.L$3 = this;
                        this.L$4 = objArr2;
                        this.label = 1;
                        kotlin.jvm.internal.c0.e(6);
                        Object invoke = tVar.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        kotlin.jvm.internal.c0.e(7);
                        if (invoke == h4) {
                            return h4;
                        }
                        iVar2 = iVar;
                        objArr = objArr2;
                        obj = invoke;
                    } else if (i4 != 1) {
                        if (i4 == 2) {
                            Object[] objArr3 = (Object[]) this.L$1;
                            i iVar3 = (i) this.L$0;
                            kotlin.d0.n(obj);
                            return f1.f55527a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object[] objArr4 = (Object[]) this.L$4;
                        kotlin.coroutines.c cVar = (kotlin.coroutines.c) this.L$3;
                        iVar = (i) this.L$2;
                        objArr = (Object[]) this.L$1;
                        iVar2 = (i) this.L$0;
                        kotlin.d0.n(obj);
                    }
                    this.L$0 = iVar2;
                    this.L$1 = objArr;
                    this.label = 2;
                    if (iVar.emit(obj, this) == h4) {
                        return h4;
                    }
                    return f1.f55527a;
                }
            }

            @Override // kotlinx.coroutines.flow.h
            @Nullable
            public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object a4 = CombineKt.a(iVar, hVarArr, FlowKt__ZipKt.a(), new AnonymousClass2(null, this), cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return a4 == h4 ? a4 : f1.f55527a;
            }
        };
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
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.h<R> g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T>[] r1, @org.jetbrains.annotations.NotNull d2.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends java.lang.Object> r2) {
        /*
            kotlin.jvm.internal.f0.w()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt.g(kotlinx.coroutines.flow.h[], d2.p):kotlinx.coroutines.flow.h");
    }

    @NotNull
    public static final /* synthetic */ <T, R> h<R> h(@NotNull Iterable<? extends h<? extends T>> iterable, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T[], ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        List G5;
        G5 = kotlin.collections.f0.G5(iterable);
        Object[] array = G5.toArray(new h[0]);
        if (array != null) {
            kotlin.jvm.internal.f0.w();
            return k.N0(new FlowKt__ZipKt$combineTransform$7((h[]) array, qVar, null));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final <T1, T2, R> h<R> i(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @BuilderInference @NotNull d2.r<? super i<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super f1>, ? extends Object> rVar) {
        return k.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new h[]{hVar, hVar2}, null, rVar));
    }

    @NotNull
    public static final <T1, T2, T3, R> h<R> j(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @BuilderInference @NotNull d2.s<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super f1>, ? extends Object> sVar) {
        return k.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new h[]{hVar, hVar2, hVar3}, null, sVar));
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> h<R> k(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @BuilderInference @NotNull d2.t<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super f1>, ? extends Object> tVar) {
        return k.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new h[]{hVar, hVar2, hVar3, hVar4}, null, tVar));
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> h<R> l(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h<? extends T3> hVar3, @NotNull h<? extends T4> hVar4, @NotNull h<? extends T5> hVar5, @BuilderInference @NotNull d2.u<? super i<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super f1>, ? extends Object> uVar) {
        return k.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new h[]{hVar, hVar2, hVar3, hVar4, hVar5}, null, uVar));
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
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.h<R> m(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T>[] r2, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull d2.q<? super kotlinx.coroutines.flow.i<? super R>, ? super T[], ? super kotlin.coroutines.c<? super kotlin.f1>, ? extends java.lang.Object> r3) {
        /*
            kotlin.jvm.internal.f0.w()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6
            r1 = 0
            r0.<init>(r2, r3, r1)
            kotlinx.coroutines.flow.h r2 = kotlinx.coroutines.flow.k.N0(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt.m(kotlinx.coroutines.flow.h[], d2.q):kotlinx.coroutines.flow.h");
    }

    private static final /* synthetic */ <T, R> h<R> o(h<? extends T>[] hVarArr, d2.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$3(hVarArr, pVar);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> h<R> p(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return new a(hVar, hVar2, qVar);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> h<R> q(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @BuilderInference @NotNull d2.r<? super i<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super f1>, ? extends Object> rVar) {
        return k.N0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new h[]{hVar, hVar2}, null, rVar));
    }

    private static final <T> d2.a<T[]> r() {
        return b.f59974a;
    }

    @NotNull
    public static final <T1, T2, R> h<R> s(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return CombineKt.b(hVar, hVar2, qVar);
    }
}
