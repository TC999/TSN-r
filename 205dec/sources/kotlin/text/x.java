package kotlin.text;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0082\u0001\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0016\u001a$\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0016\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0018\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0019\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010 \u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a \u0010!\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\"\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010#\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010$\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a \u0010%\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010'\u001a\u00020&*\u00020\u0000H\u0086\u0002\u001a\u000f\u0010(\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\b\u001a9\u0010-\u001a\u00028\u0001\"\f\b\u0000\u0010)*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010**\u00028\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.\u001a9\u0010/\u001a\u00028\u0001\"\f\b\u0000\u0010)*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010**\u00028\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010.\u001a\u0012\u00101\u001a\u00020\u0003*\u00020\u00002\u0006\u00100\u001a\u00020\u001a\u001a\u0012\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u000202\u001a\u0012\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u001d\u00108\u001a\u00020\u0000*\u00020\u00062\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001aH\u0087\b\u001a\u001f\u0010;\u001a\u00020\u0006*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\b\b\u0002\u0010:\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010<\u001a\u00020\u0006*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u001c\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010D\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010E\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010F\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\"\u0010H\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0000\u001a%\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0000H\u0087\b\u001a\u001a\u0010J\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u0010G\u001a\u00020\u0000\u001a\u001d\u0010K\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u0010G\u001a\u00020\u0000H\u0087\b\u001a\u001a\u0010L\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a\u001a\u001d\u0010M\u001a\u00020\u0006*\u00020\u00062\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u0015\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u000202H\u0087\b\u001a\u0012\u0010Q\u001a\u00020\u0000*\u00020\u00002\u0006\u0010P\u001a\u00020\u0000\u001a\u0012\u0010R\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u0000\u001a\u0012\u0010T\u001a\u00020\u0000*\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u0012\u0010U\u001a\u00020\u0006*\u00020\u00062\u0006\u0010S\u001a\u00020\u0000\u001a\u001a\u0010V\u001a\u00020\u0000*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u001a\u0010W\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u0012\u0010X\u001a\u00020\u0000*\u00020\u00002\u0006\u0010=\u001a\u00020\u0000\u001a\u0012\u0010Y\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u0000\u001a$\u0010Z\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010[\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010\\\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010]\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010^\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010_\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010`\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010a\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001d\u0010d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0006\u0010G\u001a\u00020\u0006H\u0087\b\u001a.\u0010g\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0014\b\b\u0010f\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00000\u0001H\u0087\b\u00f8\u0001\u0000\u001a\u001d\u0010h\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0006\u0010G\u001a\u00020\u0006H\u0087\b\u001a+\u0010i\u001a\u00020\u0006*\u00020\u00062\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bi\u0010j\u001a+\u0010k\u001a\u00020\u0006*\u00020\u00062\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bk\u0010j\u001a\u0015\u0010l\u001a\u00020\u0003*\u00020\u00002\u0006\u0010c\u001a\u00020bH\u0087\f\u001a4\u0010q\u001a\u00020\u0003*\u00020\u00002\u0006\u0010m\u001a\u00020\u001a2\u0006\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u0003H\u0000\u001a\u001c\u0010s\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010u\u001a\u00020\u0003*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a$\u0010v\u001a\u00020\u0003*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010w\u001a\u00020\u0003*\u00020\u00002\u0006\u0010S\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010x\u001a\u00020\u0006*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010y\u001a\u00020\u0006*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a&\u0010z\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a&\u0010{\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a=\u0010}\u001a\u00020\u001a*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u00032\b\b\u0002\u0010|\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b}\u0010~\u001aL\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u0003H\u0002\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a=\u0010\u0084\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a=\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a.\u0010\u0086\u0001\u001a\u00020\u001a*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a.\u0010\u0087\u0001\u001a\u00020\u001a*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a'\u0010\u0088\u0001\u001a\u00020\u001a*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a(\u0010\u008a\u0001\u001a\u00020\u001a*\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a'\u0010\u008b\u0001\u001a\u00020\u001a*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a(\u0010\u008c\u0001\u001a\u00020\u001a*\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a \u0010\u008d\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086\u0002\u001a \u0010\u008e\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086\u0002\u001a\u0016\u0010\u008f\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010c\u001a\u00020bH\u0087\n\u001aE\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0092\u0001*\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0002\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001aN\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0092\u0001*\u00020\u00002\u0010\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u00012\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0002\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0013\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0000\u001aF\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u0014\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u0001\"\u00020\u00062\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001aF\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0014\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u0001\"\u00020\u00062\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a4\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u000b\u0010\u0090\u0001\u001a\u00020\f\"\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u001a4\u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u000b\u0010\u0090\u0001\u001a\u00020\f\"\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u001a6\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0006\u0010=\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u00032\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0002\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a(\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0087\b\u001a(\u0010\u00a4\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010\u00a5\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u0000\u001a\u0012\u0010\u00a6\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u0000\u001a\u0019\u0010\u00a7\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0019\u0010\u00a8\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\r\u0010\u00a9\u0001\u001a\u00020\u0003*\u00020\u0006H\u0007\u001a\u0018\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u0003*\u00020\u0006H\u0007\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0018\u0010\u00ae\u0001\u001a\u000202*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001\"\u0018\u0010\u00b1\u0001\u001a\u00020\u001a*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "F5", "", "I5", "R5", "U5", "L5", "O5", "", "chars", "G5", "J5", "S5", "V5", "M5", "P5", "E5", "H5", "Q5", "T5", "K5", "N5", "", "length", "padChar", "S3", "T3", "O3", "P3", "A3", "w3", "y3", "x3", "z3", "Lkotlin/collections/u;", "B3", "N3", "C", "R", "Lkotlin/Function0;", "defaultValue", "l3", "(Ljava/lang/CharSequence;Ld2/a;)Ljava/lang/Object;", "k3", "index", "j3", "Lkotlin/ranges/k;", "range", "k5", "g5", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "h5", "startIndex", "endIndex", "i5", "j5", "delimiter", "missingDelimiterValue", "u5", "v5", "m5", "n5", "y5", "z5", "q5", "r5", "replacement", "I4", "K4", "J4", "L4", "d4", "f4", "e4", "g4", "prefix", "b4", "c4", "suffix", "h4", "i4", "k4", "m4", "j4", "l4", "x4", "y4", "p4", "q4", "u4", "t4", "B4", "C4", "Lkotlin/text/Regex;", "regex", "o4", "Lkotlin/text/k;", "transform", "n4", "F4", "G4", "(Ljava/lang/String;Ld2/l;)Ljava/lang/String;", "H4", "M3", "thisOffset", "other", "otherOffset", "ignoreCase", "a4", "char", "a5", "Y2", "c5", "b5", "Z2", "N2", "P2", "t3", "H3", "last", "o3", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "d3", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "c3", "f3", "s3", "G3", "m3", "string", "n3", "C3", "D3", "S2", "R2", "T2", "delimiters", "limit", "Lkotlin/sequences/m;", "W3", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/m;", "", "X3", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/m;", "Lkotlin/f1;", "M4", "W4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/m;", "", "P4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "V4", "O4", "Q4", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "N4", "U4", "K3", "L3", "W2", "X2", "C5", "D5", "(Ljava/lang/String;)Ljava/lang/Boolean;", "h3", "(Ljava/lang/CharSequence;)Lkotlin/ranges/k;", "indices", "i3", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class x extends w {

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"kotlin/text/x$a", "Lkotlin/collections/u;", "", "d", "", "hasNext", "", "a", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.collections.u {

        /* renamed from: a */
        private int f58964a;

        /* renamed from: b */
        final /* synthetic */ CharSequence f58965b;

        a(CharSequence charSequence) {
            this.f58965b = charSequence;
        }

        @Override // kotlin.collections.u
        public char d() {
            CharSequence charSequence = this.f58965b;
            int i4 = this.f58964a;
            this.f58964a = i4 + 1;
            return charSequence.charAt(i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58964a < this.f58965b.length();
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "currentIndex", "Lkotlin/Pair;", "a", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ char[] f58966a;

        /* renamed from: b */
        final /* synthetic */ boolean f58967b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(char[] cArr, boolean z3) {
            super(2);
            this.f58966a = cArr;
            this.f58967b = z3;
        }

        @Nullable
        public final Pair<Integer, Integer> a(@NotNull CharSequence $receiver, int i4) {
            f0.p($receiver, "$this$$receiver");
            int t3 = x.t3($receiver, this.f58966a, i4, this.f58967b);
            if (t3 < 0) {
                return null;
            }
            return l0.a(Integer.valueOf(t3), 1);
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "currentIndex", "Lkotlin/Pair;", "a", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ List<String> f58968a;

        /* renamed from: b */
        final /* synthetic */ boolean f58969b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<String> list, boolean z3) {
            super(2);
            this.f58968a = list;
            this.f58969b = z3;
        }

        @Nullable
        public final Pair<Integer, Integer> a(@NotNull CharSequence $receiver, int i4) {
            f0.p($receiver, "$this$$receiver");
            Pair d32 = x.d3($receiver, this.f58968a, i4, this.f58969b, false);
            if (d32 == null) {
                return null;
            }
            return l0.a(d32.getFirst(), Integer.valueOf(((String) d32.getSecond()).length()));
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/ranges/k;", "it", "", "a", "(Lkotlin/ranges/k;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.l<kotlin.ranges.k, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f58970a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence) {
            super(1);
            this.f58970a = charSequence;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull kotlin.ranges.k it) {
            f0.p(it, "it");
            return x.j5(this.f58970a, it);
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/ranges/k;", "it", "", "a", "(Lkotlin/ranges/k;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.l<kotlin.ranges.k, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f58971a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence) {
            super(1);
            this.f58971a = charSequence;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull kotlin.ranges.k it) {
            f0.p(it, "it");
            return x.j5(this.f58971a, it);
        }
    }

    @InlineOnly
    private static final boolean A3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String A4(String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str4 = str;
        }
        return y4(str, str2, str3, str4);
    }

    public static /* synthetic */ String A5(String str, char c4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return y5(str, c4, str2);
    }

    @NotNull
    public static final kotlin.collections.u B3(@NotNull CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return new a(charSequence);
    }

    @NotNull
    public static final String B4(@NotNull String str, char c4, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int E3;
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        E3 = E3(str, c4, 0, false, 6, null);
        return E3 == -1 ? missingDelimiterValue : I4(str, 0, E3, replacement).toString();
    }

    public static /* synthetic */ String B5(String str, String str2, String str3, int i4, Object obj) {
        String z5;
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        z5 = z5(str, str2, str3);
        return z5;
    }

    public static final int C3(@NotNull CharSequence charSequence, char c4, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c4, i4);
        }
        return H3(charSequence, new char[]{c4}, i4, z3);
    }

    @NotNull
    public static final String C4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int F3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        F3 = F3(str, delimiter, 0, false, 6, null);
        return F3 == -1 ? missingDelimiterValue : I4(str, 0, F3, replacement).toString();
    }

    @SinceKotlin(version = "1.5")
    public static final boolean C5(@NotNull String str) {
        f0.p(str, "<this>");
        if (f0.g(str, "true")) {
            return true;
        }
        if (f0.g(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException(f0.C("The string doesn't represent a boolean value: ", str));
    }

    public static final int D3(@NotNull CharSequence charSequence, @NotNull String string, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(string, "string");
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i4);
        }
        return o3(charSequence, string, i4, 0, z3, true);
    }

    public static /* synthetic */ String D4(String str, char c4, String str2, String str3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str3 = str;
        }
        return B4(str, c4, str2, str3);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Boolean D5(@NotNull String str) {
        f0.p(str, "<this>");
        if (f0.g(str, "true")) {
            return Boolean.TRUE;
        }
        if (f0.g(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int E3(CharSequence charSequence, char c4, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3(charSequence);
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return C3(charSequence, c4, i4, z3);
    }

    public static /* synthetic */ String E4(String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str4 = str;
        }
        return C4(str, str2, str3, str4);
    }

    @NotNull
    public static CharSequence E5(@NotNull CharSequence charSequence) {
        boolean r3;
        f0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            r3 = kotlin.text.b.r(charSequence.charAt(!z3 ? i4 : length));
            if (z3) {
                if (!r3) {
                    break;
                }
                length--;
            } else if (r3) {
                i4++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i4, length + 1);
    }

    public static /* synthetic */ int F3(CharSequence charSequence, String str, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3(charSequence);
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return D3(charSequence, str, i4, z3);
    }

    @InlineOnly
    private static final String F4(CharSequence charSequence, Regex regex, String replacement) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    @NotNull
    public static final CharSequence F5(@NotNull CharSequence charSequence, @NotNull d2.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(charSequence.charAt(!z3 ? i4 : length))).booleanValue();
            if (z3) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i4++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i4, length + 1);
    }

    public static final int G3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        Pair<Integer, String> d32 = d3(charSequence, strings, i4, z3, true);
        if (d32 == null) {
            return -1;
        }
        return d32.getFirst().intValue();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String G4(String str, d2.l<? super Character, Character> transform) {
        f0.p(str, "<this>");
        f0.p(transform, "transform");
        if (str.length() > 0) {
            char charValue = transform.invoke(Character.valueOf(str.charAt(0))).charValue();
            String substring = str.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            return charValue + substring;
        }
        return str;
    }

    @NotNull
    public static final CharSequence G5(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean K7;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            K7 = kotlin.collections.p.K7(chars, charSequence.charAt(!z3 ? i4 : length));
            if (z3) {
                if (!K7) {
                    break;
                }
                length--;
            } else if (K7) {
                i4++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i4, length + 1);
    }

    public static final int H3(@NotNull CharSequence charSequence, @NotNull char[] chars, int i4, boolean z3) {
        int i32;
        int u3;
        char ss;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        if (!z3 && chars.length == 1 && (charSequence instanceof String)) {
            ss = kotlin.collections.p.ss(chars);
            return ((String) charSequence).lastIndexOf(ss, i4);
        }
        i32 = i3(charSequence);
        u3 = kotlin.ranges.q.u(i4, i32);
        if (u3 < 0) {
            return -1;
        }
        while (true) {
            int i5 = u3 - 1;
            char charAt = charSequence.charAt(u3);
            int length = chars.length;
            boolean z4 = false;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                char c4 = chars[i6];
                i6++;
                if (kotlin.text.c.J(c4, charAt, z3)) {
                    z4 = true;
                    break;
                }
            }
            if (z4) {
                return u3;
            }
            if (i5 < 0) {
                return -1;
            }
            u3 = i5;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String H4(String str, d2.l<? super Character, ? extends CharSequence> transform) {
        f0.p(str, "<this>");
        f0.p(transform, "transform");
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) transform.invoke(Character.valueOf(str.charAt(0))));
            String substring = str.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    @InlineOnly
    private static final String H5(String str) {
        CharSequence E5;
        f0.p(str, "<this>");
        E5 = E5(str);
        return E5.toString();
    }

    public static /* synthetic */ int I3(CharSequence charSequence, Collection collection, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3(charSequence);
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return G3(charSequence, collection, i4, z3);
    }

    @NotNull
    public static final CharSequence I4(@NotNull CharSequence charSequence, int i4, int i5, @NotNull CharSequence replacement) {
        f0.p(charSequence, "<this>");
        f0.p(replacement, "replacement");
        if (i5 >= i4) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i4);
            f0.o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i5, charSequence.length());
            f0.o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i5 + ") is less than start index (" + i4 + ").");
    }

    @NotNull
    public static final String I5(@NotNull String str, @NotNull d2.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(str.charAt(!z3 ? i4 : length))).booleanValue();
            if (z3) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i4++;
            } else {
                z3 = true;
            }
        }
        return str.subSequence(i4, length + 1).toString();
    }

    public static /* synthetic */ int J3(CharSequence charSequence, char[] cArr, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3(charSequence);
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return H3(charSequence, cArr, i4, z3);
    }

    @NotNull
    public static final CharSequence J4(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.k range, @NotNull CharSequence replacement) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        f0.p(replacement, "replacement");
        return I4(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    @NotNull
    public static final String J5(@NotNull String str, @NotNull char... chars) {
        boolean K7;
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            K7 = kotlin.collections.p.K7(chars, str.charAt(!z3 ? i4 : length));
            if (z3) {
                if (!K7) {
                    break;
                }
                length--;
            } else if (K7) {
                i4++;
            } else {
                z3 = true;
            }
        }
        return str.subSequence(i4, length + 1).toString();
    }

    @NotNull
    public static final kotlin.sequences.m<String> K3(@NotNull CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return Z4(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @InlineOnly
    private static final String K4(String str, int i4, int i5, CharSequence replacement) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        return I4(str, i4, i5, replacement).toString();
    }

    @NotNull
    public static final CharSequence K5(@NotNull CharSequence charSequence) {
        boolean r3;
        f0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                r3 = kotlin.text.b.r(charSequence.charAt(length));
                if (!r3) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i4 < 0) {
                    break;
                }
                length = i4;
            }
        }
        return "";
    }

    @NotNull
    public static final List<String> L3(@NotNull CharSequence charSequence) {
        List<String> V2;
        f0.p(charSequence, "<this>");
        V2 = SequencesKt___SequencesKt.V2(K3(charSequence));
        return V2;
    }

    @InlineOnly
    private static final String L4(String str, kotlin.ranges.k range, CharSequence replacement) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        f0.p(replacement, "replacement");
        return J4(str, range, replacement).toString();
    }

    @NotNull
    public static final CharSequence L5(@NotNull CharSequence charSequence, @NotNull d2.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i4 = length - 1;
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i4 < 0) {
                return "";
            }
            length = i4;
        }
    }

    @InlineOnly
    private static final boolean M3(CharSequence charSequence, Regex regex) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.matches(charSequence);
    }

    public static final void M4(int i4) {
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(f0.C("Limit must be non-negative, but was ", Integer.valueOf(i4)).toString());
        }
    }

    @NotNull
    public static final CharSequence M5(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean K7;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                K7 = kotlin.collections.p.K7(chars, charSequence.charAt(length));
                if (!K7) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i4 < 0) {
                    break;
                }
                length = i4;
            }
        }
        return "";
    }

    @NotNull
    public static final String N2(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        int i4 = 0;
        while (i4 < min && kotlin.text.c.J(charSequence.charAt(i4), other.charAt(i4), z3)) {
            i4++;
        }
        int i5 = i4 - 1;
        if (j3(charSequence, i5) || j3(other, i5)) {
            i4--;
        }
        return charSequence.subSequence(0, i4).toString();
    }

    @InlineOnly
    private static final String N3(String str) {
        return str == null ? "" : str;
    }

    @InlineOnly
    private static final List<String> N4(CharSequence charSequence, Regex regex, int i4) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.split(charSequence, i4);
    }

    @InlineOnly
    private static final String N5(String str) {
        f0.p(str, "<this>");
        return K5(str).toString();
    }

    public static /* synthetic */ String O2(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return N2(charSequence, charSequence2, z3);
    }

    @NotNull
    public static final CharSequence O3(@NotNull CharSequence charSequence, int i4, char c4) {
        f0.p(charSequence, "<this>");
        if (i4 >= 0) {
            if (i4 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i4);
            sb.append(charSequence);
            int length = i4 - charSequence.length();
            int i5 = 1;
            if (1 <= length) {
                while (true) {
                    int i6 = i5 + 1;
                    sb.append(c4);
                    if (i5 == length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
    }

    @NotNull
    public static final List<String> O4(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z3, int i4) {
        Iterable<kotlin.ranges.k> G;
        int Z;
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return Q4(charSequence, String.valueOf(delimiters[0]), z3, i4);
        }
        G = SequencesKt___SequencesKt.G(Y3(charSequence, delimiters, 0, z3, i4, 2, null));
        Z = kotlin.collections.y.Z(G, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.ranges.k kVar : G) {
            arrayList.add(j5(charSequence, kVar));
        }
        return arrayList;
    }

    @NotNull
    public static final String O5(@NotNull String str, @NotNull d2.l<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                if (!predicate.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                } else if (i4 < 0) {
                    break;
                } else {
                    length = i4;
                }
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @NotNull
    public static final String P2(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z3) {
        int length;
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        int length2 = charSequence.length();
        int min = Math.min(length2, other.length());
        int i4 = 0;
        while (i4 < min && kotlin.text.c.J(charSequence.charAt((length2 - i4) - 1), other.charAt((length - i4) - 1), z3)) {
            i4++;
        }
        if (j3(charSequence, (length2 - i4) - 1) || j3(other, (length - i4) - 1)) {
            i4--;
        }
        return charSequence.subSequence(length2 - i4, length2).toString();
    }

    @NotNull
    public static final String P3(@NotNull String str, int i4, char c4) {
        f0.p(str, "<this>");
        return O3(str, i4, c4).toString();
    }

    @NotNull
    public static final List<String> P4(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z3, int i4) {
        Iterable<kotlin.ranges.k> G;
        int Z;
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return Q4(charSequence, str, z3, i4);
            }
        }
        G = SequencesKt___SequencesKt.G(Z3(charSequence, delimiters, 0, z3, i4, 2, null));
        Z = kotlin.collections.y.Z(G, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.ranges.k kVar : G) {
            arrayList.add(j5(charSequence, kVar));
        }
        return arrayList;
    }

    @NotNull
    public static final String P5(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        boolean K7;
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                K7 = kotlin.collections.p.K7(chars, str.charAt(length));
                if (!K7) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                } else if (i4 < 0) {
                    break;
                } else {
                    length = i4;
                }
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static /* synthetic */ String Q2(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return P2(charSequence, charSequence2, z3);
    }

    public static /* synthetic */ CharSequence Q3(CharSequence charSequence, int i4, char c4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            c4 = ' ';
        }
        return O3(charSequence, i4, c4);
    }

    private static final List<String> Q4(CharSequence charSequence, String str, boolean z3, int i4) {
        List<String> l4;
        M4(i4);
        int i5 = 0;
        int n32 = n3(charSequence, str, 0, z3);
        if (n32 != -1 && i4 != 1) {
            boolean z4 = i4 > 0;
            ArrayList arrayList = new ArrayList(z4 ? kotlin.ranges.q.u(i4, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i5, n32).toString());
                i5 = str.length() + n32;
                if (z4 && arrayList.size() == i4 - 1) {
                    break;
                }
                n32 = n3(charSequence, str, i5, z3);
            } while (n32 != -1);
            arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
            return arrayList;
        }
        l4 = kotlin.collections.x.l(charSequence.toString());
        return l4;
    }

    @NotNull
    public static final CharSequence Q5(@NotNull CharSequence charSequence) {
        boolean r3;
        f0.p(charSequence, "<this>");
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            r3 = kotlin.text.b.r(charSequence.charAt(i4));
            if (!r3) {
                return charSequence.subSequence(i4, charSequence.length());
            }
            i4 = i5;
        }
        return "";
    }

    public static final boolean R2(@NotNull CharSequence charSequence, char c4, boolean z3) {
        int q3;
        f0.p(charSequence, "<this>");
        q3 = q3(charSequence, c4, 0, z3, 2, null);
        return q3 >= 0;
    }

    public static /* synthetic */ String R3(String str, int i4, char c4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            c4 = ' ';
        }
        return P3(str, i4, c4);
    }

    static /* synthetic */ List R4(CharSequence charSequence, Regex regex, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.split(charSequence, i4);
    }

    @NotNull
    public static final CharSequence R5(@NotNull CharSequence charSequence, @NotNull d2.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i4))).booleanValue()) {
                return charSequence.subSequence(i4, charSequence.length());
            }
            i4 = i5;
        }
        return "";
    }

    public static boolean S2(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z3) {
        int r3;
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        if (other instanceof String) {
            r3 = r3(charSequence, (String) other, 0, z3, 2, null);
            if (r3 >= 0) {
                return true;
            }
        } else if (p3(charSequence, other, 0, charSequence.length(), z3, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final CharSequence S3(@NotNull CharSequence charSequence, int i4, char c4) {
        f0.p(charSequence, "<this>");
        if (i4 >= 0) {
            if (i4 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i4);
            int length = i4 - charSequence.length();
            int i5 = 1;
            if (1 <= length) {
                while (true) {
                    int i6 = i5 + 1;
                    sb.append(c4);
                    if (i5 == length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
    }

    public static /* synthetic */ List S4(CharSequence charSequence, char[] cArr, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z3 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return O4(charSequence, cArr, z3, i4);
    }

    @NotNull
    public static final CharSequence S5(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean K7;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            K7 = kotlin.collections.p.K7(chars, charSequence.charAt(i4));
            if (!K7) {
                return charSequence.subSequence(i4, charSequence.length());
            }
            i4 = i5;
        }
        return "";
    }

    @InlineOnly
    private static final boolean T2(CharSequence charSequence, Regex regex) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    @NotNull
    public static String T3(@NotNull String str, int i4, char c4) {
        f0.p(str, "<this>");
        return S3(str, i4, c4).toString();
    }

    public static /* synthetic */ List T4(CharSequence charSequence, String[] strArr, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z3 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return P4(charSequence, strArr, z3, i4);
    }

    @InlineOnly
    private static final String T5(String str) {
        f0.p(str, "<this>");
        return Q5(str).toString();
    }

    public static /* synthetic */ boolean U2(CharSequence charSequence, char c4, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return R2(charSequence, c4, z3);
    }

    public static /* synthetic */ CharSequence U3(CharSequence charSequence, int i4, char c4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            c4 = ' ';
        }
        return S3(charSequence, i4, c4);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final kotlin.sequences.m<String> U4(CharSequence charSequence, Regex regex, int i4) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.splitToSequence(charSequence, i4);
    }

    @NotNull
    public static final String U5(@NotNull String str, @NotNull d2.l<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                charSequence = "";
                break;
            }
            int i5 = i4 + 1;
            if (!predicate.invoke(Character.valueOf(str.charAt(i4))).booleanValue()) {
                charSequence = str.subSequence(i4, str.length());
                break;
            }
            i4 = i5;
        }
        return charSequence.toString();
    }

    public static /* synthetic */ boolean V2(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i4, Object obj) {
        boolean S2;
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        S2 = S2(charSequence, charSequence2, z3);
        return S2;
    }

    public static /* synthetic */ String V3(String str, int i4, char c4, int i5, Object obj) {
        String T3;
        if ((i5 & 2) != 0) {
            c4 = ' ';
        }
        T3 = T3(str, i4, c4);
        return T3;
    }

    @NotNull
    public static final kotlin.sequences.m<String> V4(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z3, int i4) {
        kotlin.sequences.m<String> d12;
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        d12 = SequencesKt___SequencesKt.d1(Y3(charSequence, delimiters, 0, z3, i4, 2, null), new e(charSequence));
        return d12;
    }

    @NotNull
    public static final String V5(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        boolean K7;
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                charSequence = "";
                break;
            }
            int i5 = i4 + 1;
            K7 = kotlin.collections.p.K7(chars, str.charAt(i4));
            if (!K7) {
                charSequence = str.subSequence(i4, str.length());
                break;
            }
            i4 = i5;
        }
        return charSequence.toString();
    }

    public static final boolean W2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        boolean K1;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            K1 = w.K1((String) charSequence, (String) charSequence2, true);
            return K1;
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            int length = charSequence.length();
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (!kotlin.text.c.J(charSequence.charAt(i4), charSequence2.charAt(i4), true)) {
                    return false;
                }
                i4 = i5;
            }
            return true;
        }
    }

    private static final kotlin.sequences.m<kotlin.ranges.k> W3(CharSequence charSequence, char[] cArr, int i4, boolean z3, int i5) {
        M4(i5);
        return new f(charSequence, i4, i5, new b(cArr, z3));
    }

    @NotNull
    public static final kotlin.sequences.m<String> W4(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z3, int i4) {
        kotlin.sequences.m<String> d12;
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        d12 = SequencesKt___SequencesKt.d1(Z3(charSequence, delimiters, 0, z3, i4, 2, null), new d(charSequence));
        return d12;
    }

    public static final boolean X2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return f0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (charSequence.charAt(i4) != charSequence2.charAt(i4)) {
                return false;
            }
            i4 = i5;
        }
        return true;
    }

    private static final kotlin.sequences.m<kotlin.ranges.k> X3(CharSequence charSequence, String[] strArr, int i4, boolean z3, int i5) {
        List t3;
        M4(i5);
        t3 = kotlin.collections.o.t(strArr);
        return new f(charSequence, i4, i5, new c(t3, z3));
    }

    static /* synthetic */ kotlin.sequences.m X4(CharSequence charSequence, Regex regex, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.splitToSequence(charSequence, i4);
    }

    public static final boolean Y2(@NotNull CharSequence charSequence, char c4, boolean z3) {
        int i32;
        f0.p(charSequence, "<this>");
        if (charSequence.length() > 0) {
            i32 = i3(charSequence);
            if (kotlin.text.c.J(charSequence.charAt(i32), c4, z3)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ kotlin.sequences.m Y3(CharSequence charSequence, char[] cArr, int i4, boolean z3, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z3 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return W3(charSequence, cArr, i4, z3, i5);
    }

    public static /* synthetic */ kotlin.sequences.m Y4(CharSequence charSequence, char[] cArr, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z3 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return V4(charSequence, cArr, z3, i4);
    }

    public static final boolean Z2(@NotNull CharSequence charSequence, @NotNull CharSequence suffix, boolean z3) {
        boolean J1;
        f0.p(charSequence, "<this>");
        f0.p(suffix, "suffix");
        if (!z3 && (charSequence instanceof String) && (suffix instanceof String)) {
            J1 = w.J1((String) charSequence, (String) suffix, false, 2, null);
            return J1;
        }
        return a4(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z3);
    }

    static /* synthetic */ kotlin.sequences.m Z3(CharSequence charSequence, String[] strArr, int i4, boolean z3, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z3 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return X3(charSequence, strArr, i4, z3, i5);
    }

    public static /* synthetic */ kotlin.sequences.m Z4(CharSequence charSequence, String[] strArr, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z3 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return W4(charSequence, strArr, z3, i4);
    }

    public static /* synthetic */ boolean a3(CharSequence charSequence, char c4, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return Y2(charSequence, c4, z3);
    }

    public static final boolean a4(@NotNull CharSequence charSequence, int i4, @NotNull CharSequence other, int i5, int i6, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        if (i5 < 0 || i4 < 0 || i4 > charSequence.length() - i6 || i5 > other.length() - i6) {
            return false;
        }
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 + 1;
            if (!kotlin.text.c.J(charSequence.charAt(i4 + i7), other.charAt(i7 + i5), z3)) {
                return false;
            }
            i7 = i8;
        }
        return true;
    }

    public static final boolean a5(@NotNull CharSequence charSequence, char c4, boolean z3) {
        f0.p(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.c.J(charSequence.charAt(0), c4, z3);
    }

    public static /* synthetic */ boolean b3(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return Z2(charSequence, charSequence2, z3);
    }

    @NotNull
    public static final CharSequence b4(@NotNull CharSequence charSequence, @NotNull CharSequence prefix) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        if (f5(charSequence, prefix, false, 2, null)) {
            return charSequence.subSequence(prefix.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean b5(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, int i4, boolean z3) {
        boolean t22;
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        if (!z3 && (charSequence instanceof String) && (prefix instanceof String)) {
            t22 = w.t2((String) charSequence, (String) prefix, i4, false, 4, null);
            return t22;
        }
        return a4(charSequence, i4, prefix, 0, prefix.length(), z3);
    }

    @Nullable
    public static final Pair<Integer, String> c3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        return d3(charSequence, strings, i4, z3, false);
    }

    @NotNull
    public static String c4(@NotNull String str, @NotNull CharSequence prefix) {
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        if (f5(str, prefix, false, 2, null)) {
            String substring = str.substring(prefix.length());
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static final boolean c5(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, boolean z3) {
        boolean u22;
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        if (!z3 && (charSequence instanceof String) && (prefix instanceof String)) {
            u22 = w.u2((String) charSequence, (String) prefix, false, 2, null);
            return u22;
        }
        return a4(charSequence, 0, prefix, 0, prefix.length(), z3);
    }

    public static final Pair<Integer, String> d3(CharSequence charSequence, Collection<String> collection, int i4, boolean z3, boolean z4) {
        int i32;
        int u3;
        kotlin.ranges.i W;
        Object obj;
        Object obj2;
        boolean d22;
        int n4;
        Object Q4;
        if (!z3 && collection.size() == 1) {
            Q4 = kotlin.collections.f0.Q4(collection);
            String str = (String) Q4;
            int r3 = !z4 ? r3(charSequence, str, i4, false, 4, null) : F3(charSequence, str, i4, false, 4, null);
            if (r3 < 0) {
                return null;
            }
            return l0.a(Integer.valueOf(r3), str);
        }
        if (z4) {
            i32 = i3(charSequence);
            u3 = kotlin.ranges.q.u(i4, i32);
            W = kotlin.ranges.q.W(u3, 0);
        } else {
            n4 = kotlin.ranges.q.n(i4, 0);
            W = new kotlin.ranges.k(n4, charSequence.length());
        }
        if (charSequence instanceof String) {
            int c4 = W.c();
            int g4 = W.g();
            int k4 = W.k();
            if ((k4 > 0 && c4 <= g4) || (k4 < 0 && g4 <= c4)) {
                while (true) {
                    int i5 = c4 + k4;
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        d22 = w.d2(str2, 0, (String) charSequence, c4, str2.length(), z3);
                        if (d22) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return l0.a(Integer.valueOf(c4), str3);
                    }
                    if (c4 == g4) {
                        break;
                    }
                    c4 = i5;
                }
            }
        } else {
            int c5 = W.c();
            int g5 = W.g();
            int k5 = W.k();
            if ((k5 > 0 && c5 <= g5) || (k5 < 0 && g5 <= c5)) {
                while (true) {
                    int i6 = c5 + k5;
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (a4(str4, 0, charSequence, c5, str4.length(), z3)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return l0.a(Integer.valueOf(c5), str5);
                    }
                    if (c5 == g5) {
                        break;
                    }
                    c5 = i6;
                }
            }
        }
        return null;
    }

    @NotNull
    public static final CharSequence d4(@NotNull CharSequence charSequence, int i4, int i5) {
        f0.p(charSequence, "<this>");
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("End index (" + i5 + ") is less than start index (" + i4 + ").");
        } else if (i5 == i4) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i5 - i4));
            sb.append(charSequence, 0, i4);
            f0.o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence, i5, charSequence.length());
            f0.o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    public static /* synthetic */ boolean d5(CharSequence charSequence, char c4, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return a5(charSequence, c4, z3);
    }

    public static /* synthetic */ Pair e3(CharSequence charSequence, Collection collection, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return c3(charSequence, collection, i4, z3);
    }

    @NotNull
    public static final CharSequence e4(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.k range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return d4(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ boolean e5(CharSequence charSequence, CharSequence charSequence2, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return b5(charSequence, charSequence2, i4, z3);
    }

    @Nullable
    public static final Pair<Integer, String> f3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        return d3(charSequence, strings, i4, z3, true);
    }

    @InlineOnly
    private static final String f4(String str, int i4, int i5) {
        f0.p(str, "<this>");
        return d4(str, i4, i5).toString();
    }

    public static /* synthetic */ boolean f5(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return c5(charSequence, charSequence2, z3);
    }

    public static /* synthetic */ Pair g3(CharSequence charSequence, Collection collection, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3(charSequence);
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return f3(charSequence, collection, i4, z3);
    }

    @InlineOnly
    private static final String g4(String str, kotlin.ranges.k range) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        return e4(str, range).toString();
    }

    @NotNull
    public static final CharSequence g5(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.k range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static kotlin.ranges.k h3(@NotNull CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return new kotlin.ranges.k(0, charSequence.length() - 1);
    }

    @NotNull
    public static final CharSequence h4(@NotNull CharSequence charSequence, @NotNull CharSequence suffix) {
        f0.p(charSequence, "<this>");
        f0.p(suffix, "suffix");
        if (b3(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(0, charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence h5(String str, int i4, int i5) {
        f0.p(str, "<this>");
        return str.subSequence(i4, i5);
    }

    public static int i3(@NotNull CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @NotNull
    public static String i4(@NotNull String str, @NotNull CharSequence suffix) {
        f0.p(str, "<this>");
        f0.p(suffix, "suffix");
        if (b3(str, suffix, false, 2, null)) {
            String substring = str.substring(0, str.length() - suffix.length());
            f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    @InlineOnly
    private static final String i5(CharSequence charSequence, int i4, int i5) {
        f0.p(charSequence, "<this>");
        return charSequence.subSequence(i4, i5).toString();
    }

    public static final boolean j3(@NotNull CharSequence charSequence, int i4) {
        f0.p(charSequence, "<this>");
        return (i4 >= 0 && i4 <= charSequence.length() + (-2)) && Character.isHighSurrogate(charSequence.charAt(i4)) && Character.isLowSurrogate(charSequence.charAt(i4 + 1));
    }

    @NotNull
    public static final CharSequence j4(@NotNull CharSequence charSequence, @NotNull CharSequence delimiter) {
        f0.p(charSequence, "<this>");
        f0.p(delimiter, "delimiter");
        return k4(charSequence, delimiter, delimiter);
    }

    @NotNull
    public static final String j5(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.k range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R k3(C c4, d2.a<? extends R> defaultValue) {
        f0.p(defaultValue, "defaultValue");
        return w.U1(c4) ? defaultValue.invoke() : c4;
    }

    @NotNull
    public static final CharSequence k4(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        f0.p(suffix, "suffix");
        if (charSequence.length() >= prefix.length() + suffix.length() && f5(charSequence, prefix, false, 2, null) && b3(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final String k5(@NotNull String str, @NotNull kotlin.ranges.k range) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R l3(C c4, d2.a<? extends R> defaultValue) {
        f0.p(defaultValue, "defaultValue");
        return c4.length() == 0 ? defaultValue.invoke() : c4;
    }

    @NotNull
    public static String l4(@NotNull String str, @NotNull CharSequence delimiter) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        return m4(str, delimiter, delimiter);
    }

    static /* synthetic */ String l5(CharSequence charSequence, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = charSequence.length();
        }
        f0.p(charSequence, "<this>");
        return charSequence.subSequence(i4, i5).toString();
    }

    public static final int m3(@NotNull CharSequence charSequence, char c4, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c4, i4);
        }
        return t3(charSequence, new char[]{c4}, i4, z3);
    }

    @NotNull
    public static final String m4(@NotNull String str, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        f0.p(suffix, "suffix");
        if (str.length() >= prefix.length() + suffix.length() && f5(str, prefix, false, 2, null) && b3(str, suffix, false, 2, null)) {
            String substring = str.substring(prefix.length(), str.length() - suffix.length());
            f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    @NotNull
    public static final String m5(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        int q3;
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        q3 = q3(str, c4, 0, false, 6, null);
        if (q3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(q3 + 1, str.length());
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final int n3(@NotNull CharSequence charSequence, @NotNull String string, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(string, "string");
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i4);
        }
        return p3(charSequence, string, i4, charSequence.length(), z3, false, 16, null);
    }

    @InlineOnly
    private static final String n4(CharSequence charSequence, Regex regex, d2.l<? super k, ? extends CharSequence> transform) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(transform, "transform");
        return regex.replace(charSequence, transform);
    }

    @NotNull
    public static String n5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int r3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        r3 = r3(str, delimiter, 0, false, 6, null);
        if (r3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(r3 + delimiter.length(), str.length());
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    private static final int o3(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z3, boolean z4) {
        int i32;
        int u3;
        int n4;
        kotlin.ranges.i W;
        boolean d22;
        int n5;
        int u4;
        if (!z4) {
            n5 = kotlin.ranges.q.n(i4, 0);
            u4 = kotlin.ranges.q.u(i5, charSequence.length());
            W = new kotlin.ranges.k(n5, u4);
        } else {
            i32 = i3(charSequence);
            u3 = kotlin.ranges.q.u(i4, i32);
            n4 = kotlin.ranges.q.n(i5, 0);
            W = kotlin.ranges.q.W(u3, n4);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int c4 = W.c();
            int g4 = W.g();
            int k4 = W.k();
            if ((k4 <= 0 || c4 > g4) && (k4 >= 0 || g4 > c4)) {
                return -1;
            }
            while (true) {
                int i6 = c4 + k4;
                d22 = w.d2((String) charSequence2, 0, (String) charSequence, c4, charSequence2.length(), z3);
                if (d22) {
                    return c4;
                }
                if (c4 == g4) {
                    return -1;
                }
                c4 = i6;
            }
        } else {
            int c5 = W.c();
            int g5 = W.g();
            int k5 = W.k();
            if ((k5 <= 0 || c5 > g5) && (k5 >= 0 || g5 > c5)) {
                return -1;
            }
            while (true) {
                int i7 = c5 + k5;
                if (a4(charSequence2, 0, charSequence, c5, charSequence2.length(), z3)) {
                    return c5;
                }
                if (c5 == g5) {
                    return -1;
                }
                c5 = i7;
            }
        }
    }

    @InlineOnly
    private static final String o4(CharSequence charSequence, Regex regex, String replacement) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(replacement, "replacement");
        return regex.replace(charSequence, replacement);
    }

    public static /* synthetic */ String o5(String str, char c4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return m5(str, c4, str2);
    }

    static /* synthetic */ int p3(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z3, boolean z4, int i6, Object obj) {
        return o3(charSequence, charSequence2, i4, i5, z3, (i6 & 16) != 0 ? false : z4);
    }

    @NotNull
    public static final String p4(@NotNull String str, char c4, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int q3;
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        q3 = q3(str, c4, 0, false, 6, null);
        return q3 == -1 ? missingDelimiterValue : I4(str, q3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String p5(String str, String str2, String str3, int i4, Object obj) {
        String n5;
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        n5 = n5(str, str2, str3);
        return n5;
    }

    public static /* synthetic */ int q3(CharSequence charSequence, char c4, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return m3(charSequence, c4, i4, z3);
    }

    @NotNull
    public static final String q4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int r3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        r3 = r3(str, delimiter, 0, false, 6, null);
        return r3 == -1 ? missingDelimiterValue : I4(str, r3 + delimiter.length(), str.length(), replacement).toString();
    }

    @NotNull
    public static String q5(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        int E3;
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        E3 = E3(str, c4, 0, false, 6, null);
        if (E3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(E3 + 1, str.length());
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int r3(CharSequence charSequence, String str, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return n3(charSequence, str, i4, z3);
    }

    public static /* synthetic */ String r4(String str, char c4, String str2, String str3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str3 = str;
        }
        return p4(str, c4, str2, str3);
    }

    @NotNull
    public static final String r5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int F3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        F3 = F3(str, delimiter, 0, false, 6, null);
        if (F3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(F3 + delimiter.length(), str.length());
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final int s3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i4, boolean z3) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        Pair<Integer, String> d32 = d3(charSequence, strings, i4, z3, false);
        if (d32 == null) {
            return -1;
        }
        return d32.getFirst().intValue();
    }

    public static /* synthetic */ String s4(String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str4 = str;
        }
        return q4(str, str2, str3, str4);
    }

    public static /* synthetic */ String s5(String str, char c4, String str2, int i4, Object obj) {
        String q5;
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        q5 = q5(str, c4, str2);
        return q5;
    }

    public static final int t3(@NotNull CharSequence charSequence, @NotNull char[] chars, int i4, boolean z3) {
        int n4;
        int i32;
        boolean z4;
        char ss;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        if (!z3 && chars.length == 1 && (charSequence instanceof String)) {
            ss = kotlin.collections.p.ss(chars);
            return ((String) charSequence).indexOf(ss, i4);
        }
        n4 = kotlin.ranges.q.n(i4, 0);
        i32 = i3(charSequence);
        if (n4 > i32) {
            return -1;
        }
        while (true) {
            int i5 = n4 + 1;
            char charAt = charSequence.charAt(n4);
            int length = chars.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    z4 = false;
                    break;
                }
                char c4 = chars[i6];
                i6++;
                if (kotlin.text.c.J(c4, charAt, z3)) {
                    z4 = true;
                    break;
                }
            }
            if (z4) {
                return n4;
            }
            if (n4 == i32) {
                return -1;
            }
            n4 = i5;
        }
    }

    @NotNull
    public static final String t4(@NotNull String str, char c4, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int E3;
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        E3 = E3(str, c4, 0, false, 6, null);
        return E3 == -1 ? missingDelimiterValue : I4(str, E3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String t5(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        return r5(str, str2, str3);
    }

    public static /* synthetic */ int u3(CharSequence charSequence, Collection collection, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return s3(charSequence, collection, i4, z3);
    }

    @NotNull
    public static final String u4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int F3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        F3 = F3(str, delimiter, 0, false, 6, null);
        return F3 == -1 ? missingDelimiterValue : I4(str, F3 + delimiter.length(), str.length(), replacement).toString();
    }

    @NotNull
    public static final String u5(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        int q3;
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        q3 = q3(str, c4, 0, false, 6, null);
        if (q3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, q3);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int v3(CharSequence charSequence, char[] cArr, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        return t3(charSequence, cArr, i4, z3);
    }

    public static /* synthetic */ String v4(String str, char c4, String str2, String str3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str3 = str;
        }
        return t4(str, c4, str2, str3);
    }

    @NotNull
    public static final String v5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int r3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        r3 = r3(str, delimiter, 0, false, 6, null);
        if (r3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, r3);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final boolean w3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String w4(String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str4 = str;
        }
        return u4(str, str2, str3, str4);
    }

    public static /* synthetic */ String w5(String str, char c4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return u5(str, c4, str2);
    }

    @InlineOnly
    private static final boolean x3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return !w.U1(charSequence);
    }

    @NotNull
    public static final String x4(@NotNull String str, char c4, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int q3;
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        q3 = q3(str, c4, 0, false, 6, null);
        return q3 == -1 ? missingDelimiterValue : I4(str, 0, q3, replacement).toString();
    }

    public static /* synthetic */ String x5(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        return v5(str, str2, str3);
    }

    @InlineOnly
    private static final boolean y3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @NotNull
    public static final String y4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int r3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        r3 = r3(str, delimiter, 0, false, 6, null);
        return r3 == -1 ? missingDelimiterValue : I4(str, 0, r3, replacement).toString();
    }

    @NotNull
    public static final String y5(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        int E3;
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        E3 = E3(str, c4, 0, false, 6, null);
        if (E3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, E3);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final boolean z3(CharSequence charSequence) {
        return charSequence == null || w.U1(charSequence);
    }

    public static /* synthetic */ String z4(String str, char c4, String str2, String str3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str3 = str;
        }
        return x4(str, c4, str2, str3);
    }

    @NotNull
    public static String z5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int F3;
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        F3 = F3(str, delimiter, 0, false, 6, null);
        if (F3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, F3);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }
}
