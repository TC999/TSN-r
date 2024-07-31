package kotlin.text;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.HttpConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Annotations;
import kotlin.C14372l0;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.WasExperimental;
import kotlin.collections.AbstractC14221u;
import kotlin.collections.C14236x;
import kotlin.collections.CollectionsJVM;
import kotlin.collections._Arrays;
import kotlin.collections._ArraysJvm;
import kotlin.collections._Collections;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.C14410i;
import kotlin.ranges.C14413k;
import kotlin.ranges._Ranges;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Strings.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0082\u0001\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0016\u001a$\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u0006*\u00020\u00062\n\u0010\r\u001a\u00020\f\"\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0016\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0018\u001a\u00020\u0000*\u00020\u0000\u001a\r\u0010\u0019\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a\u001c\u0010 \u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u001a \u0010!\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\"\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010#\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010$\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a \u0010%\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010'\u001a\u00020&*\u00020\u0000H\u0086\u0002\u001a\u000f\u0010(\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\b\u001a9\u0010-\u001a\u00028\u0001\"\f\b\u0000\u0010)*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010**\u00028\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a9\u0010/\u001a\u00028\u0001\"\f\b\u0000\u0010)*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010**\u00028\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0087\bø\u0001\u0000¢\u0006\u0004\b/\u0010.\u001a\u0012\u00101\u001a\u00020\u0003*\u00020\u00002\u0006\u00100\u001a\u00020\u001a\u001a\u0012\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u000202\u001a\u0012\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u001d\u00108\u001a\u00020\u0000*\u00020\u00062\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001aH\u0087\b\u001a\u001f\u0010;\u001a\u00020\u0006*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\b\b\u0002\u0010:\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010<\u001a\u00020\u0006*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u001c\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010D\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010E\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001c\u0010F\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\"\u0010H\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0000\u001a%\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0000H\u0087\b\u001a\u001a\u0010J\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u0010G\u001a\u00020\u0000\u001a\u001d\u0010K\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u0010G\u001a\u00020\u0000H\u0087\b\u001a\u001a\u0010L\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a\u001a\u001d\u0010M\u001a\u00020\u0006*\u00020\u00062\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u000202\u001a\u0015\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u000202H\u0087\b\u001a\u0012\u0010Q\u001a\u00020\u0000*\u00020\u00002\u0006\u0010P\u001a\u00020\u0000\u001a\u0012\u0010R\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u0000\u001a\u0012\u0010T\u001a\u00020\u0000*\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u0012\u0010U\u001a\u00020\u0006*\u00020\u00062\u0006\u0010S\u001a\u00020\u0000\u001a\u001a\u0010V\u001a\u00020\u0000*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u001a\u0010W\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u0000\u001a\u0012\u0010X\u001a\u00020\u0000*\u00020\u00002\u0006\u0010=\u001a\u00020\u0000\u001a\u0012\u0010Y\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u0000\u001a$\u0010Z\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010[\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010\\\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010]\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010^\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010_\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010`\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a$\u0010a\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0006\u001a\u001d\u0010d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0006\u0010G\u001a\u00020\u0006H\u0087\b\u001a.\u0010g\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0014\b\b\u0010f\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00000\u0001H\u0087\bø\u0001\u0000\u001a\u001d\u0010h\u001a\u00020\u0006*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0006\u0010G\u001a\u00020\u0006H\u0087\b\u001a+\u0010i\u001a\u00020\u0006*\u00020\u00062\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\bi\u0010j\u001a+\u0010k\u001a\u00020\u0006*\u00020\u00062\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\bk\u0010j\u001a\u0015\u0010l\u001a\u00020\u0003*\u00020\u00002\u0006\u0010c\u001a\u00020bH\u0087\f\u001a4\u0010q\u001a\u00020\u0003*\u00020\u00002\u0006\u0010m\u001a\u00020\u001a2\u0006\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u0003H\u0000\u001a\u001c\u0010s\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010u\u001a\u00020\u0003*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a$\u0010v\u001a\u00020\u0003*\u00020\u00002\u0006\u0010P\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010w\u001a\u00020\u0003*\u00020\u00002\u0006\u0010S\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010x\u001a\u00020\u0006*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a\u001c\u0010y\u001a\u00020\u0006*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003\u001a&\u0010z\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a&\u0010{\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a=\u0010}\u001a\u00020\u001a*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u00032\b\b\u0002\u0010|\u001a\u00020\u0003H\u0002¢\u0006\u0004\b}\u0010~\u001aL\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u0003H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a=\u0010\u0084\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a=\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0081\u0001*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a.\u0010\u0086\u0001\u001a\u00020\u001a*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a.\u0010\u0087\u0001\u001a\u00020\u001a*\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u007f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a'\u0010\u0088\u0001\u001a\u00020\u001a*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a(\u0010\u008a\u0001\u001a\u00020\u001a*\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a'\u0010\u008b\u0001\u001a\u00020\u001a*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a(\u0010\u008c\u0001\u001a\u00020\u001a*\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u0003\u001a \u0010\u008d\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086\u0002\u001a \u0010\u008e\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010r\u001a\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086\u0002\u001a\u0016\u0010\u008f\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010c\u001a\u00020bH\u0087\n\u001aE\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0092\u0001*\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001aN\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0092\u0001*\u00020\u00002\u0010\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u00012\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0013\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0000\u001aF\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u0014\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u0001\"\u00020\u00062\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001aF\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0014\u0010\u0090\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00060\u0095\u0001\"\u00020\u00062\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a4\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u000b\u0010\u0090\u0001\u001a\u00020\f\"\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u001a4\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u000b\u0010\u0090\u0001\u001a\u00020\f\"\u00020\u00022\b\b\u0002\u0010p\u001a\u00020\u00032\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001a\u001a6\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0006\u0010=\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u00032\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001a(\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0087\b\u001a(\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u001aH\u0087\b\u001a\u0012\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u0001*\u00020\u0000\u001a\u0012\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u009c\u0001*\u00020\u0000\u001a\u0019\u0010§\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0019\u0010¨\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\r\u0010©\u0001\u001a\u00020\u0003*\u00020\u0006H\u0007\u001a\u0018\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003*\u00020\u0006H\u0007¢\u0006\u0006\bª\u0001\u0010«\u0001\"\u0018\u0010®\u0001\u001a\u000202*\u00020\u00008F¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0018\u0010±\u0001\u001a\u00020\u001a*\u00020\u00008F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006²\u0001"}, m12616d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "F5", "", "I5", "R5", "U5", "L5", "O5", "", "chars", "G5", "J5", "S5", "V5", "M5", "P5", "E5", "H5", "Q5", "T5", "K5", "N5", "", "length", "padChar", "S3", "T3", "O3", "P3", "A3", "w3", "y3", "x3", "z3", "Lkotlin/collections/u;", "B3", "N3", "C", "R", "Lkotlin/Function0;", "defaultValue", "l3", "(Ljava/lang/CharSequence;Ll1/a;)Ljava/lang/Object;", "k3", "index", "j3", "Lkotlin/ranges/k;", "range", "k5", "g5", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "h5", "startIndex", "endIndex", "i5", "j5", "delimiter", "missingDelimiterValue", "u5", "v5", "m5", "n5", "y5", "z5", "q5", "r5", "replacement", "I4", "K4", "J4", "L4", "d4", "f4", "e4", "g4", "prefix", "b4", "c4", "suffix", "h4", "i4", "k4", "m4", "j4", "l4", "x4", "y4", "p4", "q4", "u4", "t4", "B4", "C4", "Lkotlin/text/Regex;", "regex", "n4", "Lkotlin/text/k;", "transform", "o4", "F4", "G4", "(Ljava/lang/String;Ll1/l;)Ljava/lang/String;", "H4", "M3", "thisOffset", AdnName.OTHER, "otherOffset", "ignoreCase", "a4", "char", "a5", "Y2", "c5", "b5", "Z2", "N2", "P2", "t3", "H3", "last", "o3", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "d3", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "c3", "f3", "s3", "G3", "m3", "string", "n3", "C3", "D3", "S2", "R2", "T2", "delimiters", "limit", "Lkotlin/sequences/m;", "W3", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/m;", "", "X3", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/m;", "Lkotlin/f1;", "M4", "W4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/m;", "", "P4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "V4", "O4", "Q4", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "N4", "U4", "K3", "L3", "W2", "X2", "C5", "D5", "(Ljava/lang/String;)Ljava/lang/Boolean;", "h3", "(Ljava/lang/CharSequence;)Lkotlin/ranges/k;", "indices", "i3", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C14579x extends StringsJVM {

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, m12616d2 = {"kotlin/text/x$a", "Lkotlin/collections/u;", "", "c", "", "hasNext", "", "a", "I", "index", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.x$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14580a extends AbstractC14221u {

        /* renamed from: a */
        private int f41626a;

        /* renamed from: b */
        final /* synthetic */ CharSequence f41627b;

        C14580a(CharSequence charSequence) {
            this.f41627b = charSequence;
        }

        @Override // kotlin.collections.AbstractC14221u
        /* renamed from: c */
        public char mo6371c() {
            CharSequence charSequence = this.f41627b;
            int i = this.f41626a;
            this.f41626a = i + 1;
            return charSequence.charAt(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41626a < this.f41627b.length();
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "", "currentIndex", "Lkotlin/Pair;", "a", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.x$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14581b extends Lambda implements InterfaceC15284p<CharSequence, Integer, Tuples<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ char[] f41628a;

        /* renamed from: b */
        final /* synthetic */ boolean f41629b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14581b(char[] cArr, boolean z) {
            super(2);
            this.f41628a = cArr;
            this.f41629b = z;
        }

        @Nullable
        /* renamed from: a */
        public final Tuples<Integer, Integer> m6370a(@NotNull CharSequence receiver, int i) {
            C14342f0.m8184p(receiver, "$receiver");
            int m6392t3 = C14579x.m6392t3(receiver, this.f41628a, i, this.f41629b);
            if (m6392t3 < 0) {
                return null;
            }
            return C14372l0.m7952a(Integer.valueOf(m6392t3), 1);
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Tuples<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return m6370a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "", "currentIndex", "Lkotlin/Pair;", "a", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.x$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14582c extends Lambda implements InterfaceC15284p<CharSequence, Integer, Tuples<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ List f41630a;

        /* renamed from: b */
        final /* synthetic */ boolean f41631b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14582c(List list, boolean z) {
            super(2);
            this.f41630a = list;
            this.f41631b = z;
        }

        @Nullable
        /* renamed from: a */
        public final Tuples<Integer, Integer> m6369a(@NotNull CharSequence receiver, int i) {
            C14342f0.m8184p(receiver, "$receiver");
            Tuples m6440d3 = C14579x.m6440d3(receiver, this.f41630a, i, this.f41631b, false);
            if (m6440d3 != null) {
                return C14372l0.m7952a(m6440d3.getFirst(), Integer.valueOf(((String) m6440d3.getSecond()).length()));
            }
            return null;
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Tuples<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return m6369a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/ranges/k;", "it", "", "a", "(Lkotlin/ranges/k;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.x$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14583d extends Lambda implements InterfaceC15280l<C14413k, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f41632a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14583d(CharSequence charSequence) {
            super(1);
            this.f41632a = charSequence;
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull C14413k it) {
            C14342f0.m8184p(it, "it");
            return C14579x.m6420j5(this.f41632a, it);
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/ranges/k;", "it", "", "a", "(Lkotlin/ranges/k;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.x$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14584e extends Lambda implements InterfaceC15280l<C14413k, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f41633a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14584e(CharSequence charSequence) {
            super(1);
            this.f41633a = charSequence;
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull C14413k it) {
            C14342f0.m8184p(it, "it");
            return C14579x.m6420j5(this.f41633a, it);
        }
    }

    @InlineOnly
    /* renamed from: A3 */
    private static final boolean m6537A3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: A4 */
    public static /* synthetic */ String m6536A4(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return m6376y4(str, str2, str3, str4);
    }

    /* renamed from: A5 */
    public static /* synthetic */ String m6535A5(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m6375y5(str, c, str2);
    }

    @NotNull
    /* renamed from: B3 */
    public static final AbstractC14221u m6534B3(@NotNull CharSequence iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return new C14580a(iterator);
    }

    @NotNull
    /* renamed from: B4 */
    public static final String m6533B4(@NotNull String replaceBeforeLast, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6525E3;
        C14342f0.m8184p(replaceBeforeLast, "$this$replaceBeforeLast");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6525E3 = m6525E3(replaceBeforeLast, c, 0, false, 6, null);
        return m6525E3 == -1 ? missingDelimiterValue : m6512I4(replaceBeforeLast, 0, m6525E3, replacement).toString();
    }

    /* renamed from: B5 */
    public static /* synthetic */ String m6532B5(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m6372z5(str, str2, str3);
    }

    /* renamed from: C3 */
    public static final int m6531C3(@NotNull CharSequence lastIndexOf, char c, int i, boolean z) {
        C14342f0.m8184p(lastIndexOf, "$this$lastIndexOf");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(c, i);
        }
        return m6516H3(lastIndexOf, new char[]{c}, i, z);
    }

    @NotNull
    /* renamed from: C4 */
    public static final String m6530C4(@NotNull String replaceBeforeLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6522F3;
        C14342f0.m8184p(replaceBeforeLast, "$this$replaceBeforeLast");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6522F3 = m6522F3(replaceBeforeLast, delimiter, 0, false, 6, null);
        return m6522F3 == -1 ? missingDelimiterValue : m6512I4(replaceBeforeLast, 0, m6522F3, replacement).toString();
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: C5 */
    public static final boolean m6529C5(@NotNull String toBooleanStrict) {
        C14342f0.m8184p(toBooleanStrict, "$this$toBooleanStrict");
        int hashCode = toBooleanStrict.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && toBooleanStrict.equals("false")) {
                return false;
            }
        } else if (toBooleanStrict.equals("true")) {
            return true;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + toBooleanStrict);
    }

    /* renamed from: D3 */
    public static final int m6528D3(@NotNull CharSequence lastIndexOf, @NotNull String string, int i, boolean z) {
        C14342f0.m8184p(lastIndexOf, "$this$lastIndexOf");
        C14342f0.m8184p(string, "string");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(string, i);
        }
        return m6407o3(lastIndexOf, string, i, 0, z, true);
    }

    /* renamed from: D4 */
    public static /* synthetic */ String m6527D4(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return m6533B4(str, c, str2, str3);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    /* renamed from: D5 */
    public static final Boolean m6526D5(@NotNull String toBooleanStrictOrNull) {
        C14342f0.m8184p(toBooleanStrictOrNull, "$this$toBooleanStrictOrNull");
        int hashCode = toBooleanStrictOrNull.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && toBooleanStrictOrNull.equals("false")) {
                return Boolean.FALSE;
            }
        } else if (toBooleanStrictOrNull.equals("true")) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* renamed from: E3 */
    public static /* synthetic */ int m6525E3(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m6425i3(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6531C3(charSequence, c, i, z);
    }

    /* renamed from: E4 */
    public static /* synthetic */ String m6524E4(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return m6530C4(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: E5 */
    public static CharSequence m6523E5(@NotNull CharSequence trim) {
        C14342f0.m8184p(trim, "$this$trim");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean m6876r = CharJVM.m6876r(trim.charAt(!z ? i : length));
            if (z) {
                if (!m6876r) {
                    break;
                }
                length--;
            } else if (m6876r) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    /* renamed from: F3 */
    public static /* synthetic */ int m6522F3(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m6425i3(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6528D3(charSequence, str, i, z);
    }

    @InlineOnly
    /* renamed from: F4 */
    private static final String m6521F4(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    @NotNull
    /* renamed from: F5 */
    public static final CharSequence m6520F5(@NotNull CharSequence trim, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        C14342f0.m8184p(trim, "$this$trim");
        C14342f0.m8184p(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    /* renamed from: G3 */
    public static final int m6519G3(@NotNull CharSequence lastIndexOfAny, @NotNull Collection<String> strings, int i, boolean z) {
        Integer first;
        C14342f0.m8184p(lastIndexOfAny, "$this$lastIndexOfAny");
        C14342f0.m8184p(strings, "strings");
        Tuples<Integer, String> m6440d3 = m6440d3(lastIndexOfAny, strings, i, z, true);
        if (m6440d3 == null || (first = m6440d3.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: G4 */
    private static final String m6518G4(String str, InterfaceC15280l<? super Character, Character> interfaceC15280l) {
        if (str.length() > 0) {
            char charValue = interfaceC15280l.invoke(Character.valueOf(str.charAt(0))).charValue();
            String substring = str.substring(1);
            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(charValue) + substring;
        }
        return str;
    }

    @NotNull
    /* renamed from: G5 */
    public static final CharSequence m6517G5(@NotNull CharSequence trim, @NotNull char... chars) {
        boolean m11145K7;
        C14342f0.m8184p(trim, "$this$trim");
        C14342f0.m8184p(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            m11145K7 = _Arrays.m11145K7(chars, trim.charAt(!z ? i : length));
            if (z) {
                if (!m11145K7) {
                    break;
                }
                length--;
            } else if (m11145K7) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    /* renamed from: H3 */
    public static final int m6516H3(@NotNull CharSequence lastIndexOfAny, @NotNull char[] chars, int i, boolean z) {
        int m6425i3;
        int m7460u;
        char m10051ss;
        C14342f0.m8184p(lastIndexOfAny, "$this$lastIndexOfAny");
        C14342f0.m8184p(chars, "chars");
        if (!z && chars.length == 1 && (lastIndexOfAny instanceof String)) {
            m10051ss = _Arrays.m10051ss(chars);
            return ((String) lastIndexOfAny).lastIndexOf(m10051ss, i);
        }
        m6425i3 = m6425i3(lastIndexOfAny);
        for (m7460u = _Ranges.m7460u(i, m6425i3); m7460u >= 0; m7460u--) {
            char charAt = lastIndexOfAny.charAt(m7460u);
            int length = chars.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (Char.m6858J(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return m7460u;
            }
        }
        return -1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: H4 */
    private static final String m6515H4(String str, InterfaceC15280l<? super Character, ? extends CharSequence> interfaceC15280l) {
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(interfaceC15280l.invoke(Character.valueOf(str.charAt(0))).toString());
            String substring = str.substring(1);
            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    @InlineOnly
    /* renamed from: H5 */
    private static final String m6514H5(String str) {
        CharSequence m6523E5;
        if (str != null) {
            m6523E5 = m6523E5(str);
            return m6523E5.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: I3 */
    public static /* synthetic */ int m6513I3(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m6425i3(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6519G3(charSequence, collection, i, z);
    }

    @NotNull
    /* renamed from: I4 */
    public static final CharSequence m6512I4(@NotNull CharSequence replaceRange, int i, int i2, @NotNull CharSequence replacement) {
        C14342f0.m8184p(replaceRange, "$this$replaceRange");
        C14342f0.m8184p(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(replaceRange, 0, i);
            C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(replaceRange, i2, replaceRange.length());
            C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    @NotNull
    /* renamed from: I5 */
    public static final String m6511I5(@NotNull String trim, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        C14342f0.m8184p(trim, "$this$trim");
        C14342f0.m8184p(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1).toString();
    }

    /* renamed from: J3 */
    public static /* synthetic */ int m6510J3(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m6425i3(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6516H3(charSequence, cArr, i, z);
    }

    @NotNull
    /* renamed from: J4 */
    public static final CharSequence m6509J4(@NotNull CharSequence replaceRange, @NotNull C14413k range, @NotNull CharSequence replacement) {
        C14342f0.m8184p(replaceRange, "$this$replaceRange");
        C14342f0.m8184p(range, "range");
        C14342f0.m8184p(replacement, "replacement");
        return m6512I4(replaceRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    @NotNull
    /* renamed from: J5 */
    public static final String m6508J5(@NotNull String trim, @NotNull char... chars) {
        boolean m11145K7;
        C14342f0.m8184p(trim, "$this$trim");
        C14342f0.m8184p(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            m11145K7 = _Arrays.m11145K7(chars, trim.charAt(!z ? i : length));
            if (z) {
                if (!m11145K7) {
                    break;
                }
                length--;
            } else if (m11145K7) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1).toString();
    }

    @NotNull
    /* renamed from: K3 */
    public static final Sequence<String> m6507K3(@NotNull CharSequence lineSequence) {
        C14342f0.m8184p(lineSequence, "$this$lineSequence");
        return m6450Z4(lineSequence, new String[]{"\r\n", ShellAdbUtils.f33810d, "\r"}, false, 0, 6, null);
    }

    @InlineOnly
    /* renamed from: K4 */
    private static final String m6506K4(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return m6512I4(str, i, i2, charSequence).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    /* renamed from: K5 */
    public static final CharSequence m6505K5(@NotNull CharSequence trimEnd) {
        C14342f0.m8184p(trimEnd, "$this$trimEnd");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharJVM.m6876r(trimEnd.charAt(length)));
        return trimEnd.subSequence(0, length + 1);
    }

    @NotNull
    /* renamed from: L3 */
    public static final List<String> m6504L3(@NotNull CharSequence lines) {
        List<String> m7189V2;
        C14342f0.m8184p(lines, "$this$lines");
        m7189V2 = _Sequences.m7189V2(m6507K3(lines));
        return m7189V2;
    }

    @InlineOnly
    /* renamed from: L4 */
    private static final String m6503L4(String str, C14413k c14413k, CharSequence charSequence) {
        if (str != null) {
            return m6509J4(str, c14413k, charSequence).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    /* renamed from: L5 */
    public static final CharSequence m6502L5(@NotNull CharSequence trimEnd, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        C14342f0.m8184p(trimEnd, "$this$trimEnd");
        C14342f0.m8184p(predicate, "predicate");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue());
        return trimEnd.subSequence(0, length + 1);
    }

    @InlineOnly
    /* renamed from: M3 */
    private static final boolean m6500M3(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    /* renamed from: M4 */
    public static final void m6499M4(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    @NotNull
    /* renamed from: M5 */
    public static final CharSequence m6498M5(@NotNull CharSequence trimEnd, @NotNull char... chars) {
        boolean m11145K7;
        C14342f0.m8184p(trimEnd, "$this$trimEnd");
        C14342f0.m8184p(chars, "chars");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
            m11145K7 = _Arrays.m11145K7(chars, trimEnd.charAt(length));
        } while (m11145K7);
        return trimEnd.subSequence(0, length + 1);
    }

    @NotNull
    /* renamed from: N2 */
    public static final String m6497N2(@NotNull CharSequence commonPrefixWith, @NotNull CharSequence other, boolean z) {
        C14342f0.m8184p(commonPrefixWith, "$this$commonPrefixWith");
        C14342f0.m8184p(other, "other");
        int min = Math.min(commonPrefixWith.length(), other.length());
        int i = 0;
        while (i < min && Char.m6858J(commonPrefixWith.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (m6422j3(commonPrefixWith, i2) || m6422j3(other, i2)) {
            i--;
        }
        return commonPrefixWith.subSequence(0, i).toString();
    }

    @InlineOnly
    /* renamed from: N3 */
    private static final String m6496N3(String str) {
        return str != null ? str : "";
    }

    @InlineOnly
    /* renamed from: N4 */
    private static final List<String> m6495N4(CharSequence charSequence, Regex regex, int i) {
        return regex.split(charSequence, i);
    }

    @InlineOnly
    /* renamed from: N5 */
    private static final String m6494N5(String str) {
        if (str != null) {
            return m6505K5(str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: O2 */
    public static /* synthetic */ String m6493O2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6497N2(charSequence, charSequence2, z);
    }

    @NotNull
    /* renamed from: O3 */
    public static final CharSequence m6492O3(@NotNull CharSequence padEnd, int i, char c) {
        C14342f0.m8184p(padEnd, "$this$padEnd");
        if (i >= 0) {
            if (i <= padEnd.length()) {
                return padEnd.subSequence(0, padEnd.length());
            }
            StringBuilder sb = new StringBuilder(i);
            sb.append(padEnd);
            int length = i - padEnd.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    @NotNull
    /* renamed from: O4 */
    public static final List<String> m6491O4(@NotNull CharSequence split, @NotNull char[] delimiters, boolean z, int i) {
        Iterable<C14413k> m7252G;
        int m8957Y;
        C14342f0.m8184p(split, "$this$split");
        C14342f0.m8184p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return m6483Q4(split, String.valueOf(delimiters[0]), z, i);
        }
        m7252G = _Sequences.m7252G(m6454Y3(split, delimiters, 0, z, i, 2, null));
        m8957Y = C14236x.m8957Y(m7252G, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        for (C14413k c14413k : m7252G) {
            arrayList.add(m6420j5(split, c14413k));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: O5 */
    public static final String m6490O5(@NotNull String trimEnd, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        C14342f0.m8184p(trimEnd, "$this$trimEnd");
        C14342f0.m8184p(predicate, "predicate");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue()) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    /* renamed from: P2 */
    public static final String m6489P2(@NotNull CharSequence commonSuffixWith, @NotNull CharSequence other, boolean z) {
        int length;
        C14342f0.m8184p(commonSuffixWith, "$this$commonSuffixWith");
        C14342f0.m8184p(other, "other");
        int length2 = commonSuffixWith.length();
        int min = Math.min(length2, other.length());
        int i = 0;
        while (i < min && Char.m6858J(commonSuffixWith.charAt((length2 - i) - 1), other.charAt((length - i) - 1), z)) {
            i++;
        }
        if (m6422j3(commonSuffixWith, (length2 - i) - 1) || m6422j3(other, (length - i) - 1)) {
            i--;
        }
        return commonSuffixWith.subSequence(length2 - i, length2).toString();
    }

    @NotNull
    /* renamed from: P3 */
    public static final String m6488P3(@NotNull String padEnd, int i, char c) {
        C14342f0.m8184p(padEnd, "$this$padEnd");
        return m6492O3(padEnd, i, c).toString();
    }

    @NotNull
    /* renamed from: P4 */
    public static final List<String> m6487P4(@NotNull CharSequence split, @NotNull String[] delimiters, boolean z, int i) {
        Iterable<C14413k> m7252G;
        int m8957Y;
        C14342f0.m8184p(split, "$this$split");
        C14342f0.m8184p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return m6483Q4(split, str, z, i);
            }
        }
        m7252G = _Sequences.m7252G(m6451Z3(split, delimiters, 0, z, i, 2, null));
        m8957Y = C14236x.m8957Y(m7252G, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        for (C14413k c14413k : m7252G) {
            arrayList.add(m6420j5(split, c14413k));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: P5 */
    public static final String m6486P5(@NotNull String trimEnd, @NotNull char... chars) {
        CharSequence charSequence;
        boolean m11145K7;
        C14342f0.m8184p(trimEnd, "$this$trimEnd");
        C14342f0.m8184p(chars, "chars");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            m11145K7 = _Arrays.m11145K7(chars, trimEnd.charAt(length));
            if (!m11145K7) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: Q2 */
    public static /* synthetic */ String m6485Q2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6489P2(charSequence, charSequence2, z);
    }

    /* renamed from: Q3 */
    public static /* synthetic */ CharSequence m6484Q3(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = HttpConstants.SP_CHAR;
        }
        return m6492O3(charSequence, i, c);
    }

    /* renamed from: Q4 */
    private static final List<String> m6483Q4(CharSequence charSequence, String str, boolean z, int i) {
        List<String> m8965k;
        m6499M4(i);
        int i2 = 0;
        int m6410n3 = m6410n3(charSequence, str, 0, z);
        if (m6410n3 != -1 && i != 1) {
            boolean z2 = i > 0;
            ArrayList arrayList = new ArrayList(z2 ? _Ranges.m7460u(i, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i2, m6410n3).toString());
                i2 = str.length() + m6410n3;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                m6410n3 = m6410n3(charSequence, str, i2, z);
            } while (m6410n3 != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        m8965k = CollectionsJVM.m8965k(charSequence.toString());
        return m8965k;
    }

    @NotNull
    /* renamed from: Q5 */
    public static final CharSequence m6482Q5(@NotNull CharSequence trimStart) {
        C14342f0.m8184p(trimStart, "$this$trimStart");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!CharJVM.m6876r(trimStart.charAt(i))) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    /* renamed from: R2 */
    public static final boolean m6481R2(@NotNull CharSequence contains, char c, boolean z) {
        int m6401q3;
        C14342f0.m8184p(contains, "$this$contains");
        m6401q3 = m6401q3(contains, c, 0, z, 2, null);
        return m6401q3 >= 0;
    }

    /* renamed from: R3 */
    public static /* synthetic */ String m6480R3(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = HttpConstants.SP_CHAR;
        }
        return m6488P3(str, i, c);
    }

    /* renamed from: R4 */
    static /* synthetic */ List m6479R4(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    @NotNull
    /* renamed from: R5 */
    public static final CharSequence m6478R5(@NotNull CharSequence trimStart, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        C14342f0.m8184p(trimStart, "$this$trimStart");
        C14342f0.m8184p(predicate, "predicate");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    /* renamed from: S2 */
    public static boolean m6477S2(@NotNull CharSequence contains, @NotNull CharSequence other, boolean z) {
        int m6398r3;
        C14342f0.m8184p(contains, "$this$contains");
        C14342f0.m8184p(other, "other");
        if (other instanceof String) {
            m6398r3 = m6398r3(contains, (String) other, 0, z, 2, null);
            if (m6398r3 >= 0) {
                return true;
            }
        } else if (m6404p3(contains, other, 0, contains.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: S3 */
    public static final CharSequence m6476S3(@NotNull CharSequence padStart, int i, char c) {
        C14342f0.m8184p(padStart, "$this$padStart");
        if (i >= 0) {
            if (i <= padStart.length()) {
                return padStart.subSequence(0, padStart.length());
            }
            StringBuilder sb = new StringBuilder(i);
            int length = i - padStart.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(padStart);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    /* renamed from: S4 */
    public static /* synthetic */ List m6475S4(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6491O4(charSequence, cArr, z, i);
    }

    @NotNull
    /* renamed from: S5 */
    public static final CharSequence m6474S5(@NotNull CharSequence trimStart, @NotNull char... chars) {
        boolean m11145K7;
        C14342f0.m8184p(trimStart, "$this$trimStart");
        C14342f0.m8184p(chars, "chars");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            m11145K7 = _Arrays.m11145K7(chars, trimStart.charAt(i));
            if (!m11145K7) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    @InlineOnly
    /* renamed from: T2 */
    private static final boolean m6473T2(CharSequence contains, Regex regex) {
        C14342f0.m8184p(contains, "$this$contains");
        return regex.containsMatchIn(contains);
    }

    @NotNull
    /* renamed from: T3 */
    public static String m6472T3(@NotNull String padStart, int i, char c) {
        C14342f0.m8184p(padStart, "$this$padStart");
        return m6476S3(padStart, i, c).toString();
    }

    /* renamed from: T4 */
    public static /* synthetic */ List m6471T4(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6487P4(charSequence, strArr, z, i);
    }

    @InlineOnly
    /* renamed from: T5 */
    private static final String m6470T5(String str) {
        if (str != null) {
            return m6482Q5(str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: U2 */
    public static /* synthetic */ boolean m6469U2(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6481R2(charSequence, c, z);
    }

    /* renamed from: U3 */
    public static /* synthetic */ CharSequence m6468U3(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = HttpConstants.SP_CHAR;
        }
        return m6476S3(charSequence, i, c);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: U4 */
    private static final Sequence<String> m6467U4(CharSequence charSequence, Regex regex, int i) {
        return regex.splitToSequence(charSequence, i);
    }

    @NotNull
    /* renamed from: U5 */
    public static final String m6466U5(@NotNull String trimStart, @NotNull InterfaceC15280l<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        C14342f0.m8184p(trimStart, "$this$trimStart");
        C14342f0.m8184p(predicate, "predicate");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                charSequence = trimStart.subSequence(i, trimStart.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: V2 */
    public static /* synthetic */ boolean m6465V2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        boolean m6477S2;
        if ((i & 2) != 0) {
            z = false;
        }
        m6477S2 = m6477S2(charSequence, charSequence2, z);
        return m6477S2;
    }

    /* renamed from: V3 */
    public static /* synthetic */ String m6464V3(String str, int i, char c, int i2, Object obj) {
        String m6472T3;
        if ((i2 & 2) != 0) {
            c = HttpConstants.SP_CHAR;
        }
        m6472T3 = m6472T3(str, i, c);
        return m6472T3;
    }

    @NotNull
    /* renamed from: V4 */
    public static final Sequence<String> m6463V4(@NotNull CharSequence splitToSequence, @NotNull char[] delimiters, boolean z, int i) {
        Sequence<String> m7159d1;
        C14342f0.m8184p(splitToSequence, "$this$splitToSequence");
        C14342f0.m8184p(delimiters, "delimiters");
        m7159d1 = _Sequences.m7159d1(m6454Y3(splitToSequence, delimiters, 0, z, i, 2, null), new C14584e(splitToSequence));
        return m7159d1;
    }

    @NotNull
    /* renamed from: V5 */
    public static final String m6462V5(@NotNull String trimStart, @NotNull char... chars) {
        CharSequence charSequence;
        boolean m11145K7;
        C14342f0.m8184p(trimStart, "$this$trimStart");
        C14342f0.m8184p(chars, "chars");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            m11145K7 = _Arrays.m11145K7(chars, trimStart.charAt(i));
            if (!m11145K7) {
                charSequence = trimStart.subSequence(i, trimStart.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }

    /* renamed from: W2 */
    public static final boolean m6461W2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        boolean m6604K1;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            m6604K1 = StringsJVM.m6604K1((String) charSequence, (String) charSequence2, true);
            return m6604K1;
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (!Char.m6858J(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: W3 */
    private static final Sequence<C14413k> m6460W3(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        m6499M4(i2);
        return new Strings(charSequence, i, i2, new C14581b(cArr, z));
    }

    @NotNull
    /* renamed from: W4 */
    public static final Sequence<String> m6459W4(@NotNull CharSequence splitToSequence, @NotNull String[] delimiters, boolean z, int i) {
        Sequence<String> m7159d1;
        C14342f0.m8184p(splitToSequence, "$this$splitToSequence");
        C14342f0.m8184p(delimiters, "delimiters");
        m7159d1 = _Sequences.m7159d1(m6451Z3(splitToSequence, delimiters, 0, z, i, 2, null), new C14583d(splitToSequence));
        return m7159d1;
    }

    /* renamed from: X2 */
    public static final boolean m6458X2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return C14342f0.m8193g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: X3 */
    private static final Sequence<C14413k> m6457X3(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        List m11537t;
        m6499M4(i2);
        m11537t = _ArraysJvm.m11537t(strArr);
        return new Strings(charSequence, i, i2, new C14582c(m11537t, z));
    }

    /* renamed from: X4 */
    static /* synthetic */ Sequence m6456X4(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    /* renamed from: Y2 */
    public static final boolean m6455Y2(@NotNull CharSequence endsWith, char c, boolean z) {
        int m6425i3;
        C14342f0.m8184p(endsWith, "$this$endsWith");
        if (endsWith.length() > 0) {
            m6425i3 = m6425i3(endsWith);
            if (Char.m6858J(endsWith.charAt(m6425i3), c, z)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Y3 */
    static /* synthetic */ Sequence m6454Y3(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m6460W3(charSequence, cArr, i, z, i2);
    }

    /* renamed from: Y4 */
    public static /* synthetic */ Sequence m6453Y4(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6463V4(charSequence, cArr, z, i);
    }

    /* renamed from: Z2 */
    public static final boolean m6452Z2(@NotNull CharSequence endsWith, @NotNull CharSequence suffix, boolean z) {
        boolean m6606J1;
        C14342f0.m8184p(endsWith, "$this$endsWith");
        C14342f0.m8184p(suffix, "suffix");
        if (!z && (endsWith instanceof String) && (suffix instanceof String)) {
            m6606J1 = StringsJVM.m6606J1((String) endsWith, (String) suffix, false, 2, null);
            return m6606J1;
        }
        return m6448a4(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    /* renamed from: Z3 */
    static /* synthetic */ Sequence m6451Z3(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m6457X3(charSequence, strArr, i, z, i2);
    }

    /* renamed from: Z4 */
    public static /* synthetic */ Sequence m6450Z4(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m6459W4(charSequence, strArr, z, i);
    }

    /* renamed from: a3 */
    public static /* synthetic */ boolean m6449a3(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6455Y2(charSequence, c, z);
    }

    /* renamed from: a4 */
    public static final boolean m6448a4(@NotNull CharSequence regionMatchesImpl, int i, @NotNull CharSequence other, int i2, int i3, boolean z) {
        C14342f0.m8184p(regionMatchesImpl, "$this$regionMatchesImpl");
        C14342f0.m8184p(other, "other");
        if (i2 < 0 || i < 0 || i > regionMatchesImpl.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!Char.m6858J(regionMatchesImpl.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a5 */
    public static final boolean m6447a5(@NotNull CharSequence startsWith, char c, boolean z) {
        C14342f0.m8184p(startsWith, "$this$startsWith");
        return startsWith.length() > 0 && Char.m6858J(startsWith.charAt(0), c, z);
    }

    /* renamed from: b3 */
    public static /* synthetic */ boolean m6446b3(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6452Z2(charSequence, charSequence2, z);
    }

    @NotNull
    /* renamed from: b4 */
    public static final CharSequence m6445b4(@NotNull CharSequence removePrefix, @NotNull CharSequence prefix) {
        C14342f0.m8184p(removePrefix, "$this$removePrefix");
        C14342f0.m8184p(prefix, "prefix");
        if (m6432f5(removePrefix, prefix, false, 2, null)) {
            return removePrefix.subSequence(prefix.length(), removePrefix.length());
        }
        return removePrefix.subSequence(0, removePrefix.length());
    }

    /* renamed from: b5 */
    public static final boolean m6444b5(@NotNull CharSequence startsWith, @NotNull CharSequence prefix, int i, boolean z) {
        boolean m6550t2;
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            m6550t2 = StringsJVM.m6550t2((String) startsWith, (String) prefix, i, false, 4, null);
            return m6550t2;
        }
        return m6448a4(startsWith, i, prefix, 0, prefix.length(), z);
    }

    @Nullable
    /* renamed from: c3 */
    public static final Tuples<Integer, String> m6443c3(@NotNull CharSequence findAnyOf, @NotNull Collection<String> strings, int i, boolean z) {
        C14342f0.m8184p(findAnyOf, "$this$findAnyOf");
        C14342f0.m8184p(strings, "strings");
        return m6440d3(findAnyOf, strings, i, z, false);
    }

    @NotNull
    /* renamed from: c4 */
    public static String m6442c4(@NotNull String removePrefix, @NotNull CharSequence prefix) {
        C14342f0.m8184p(removePrefix, "$this$removePrefix");
        C14342f0.m8184p(prefix, "prefix");
        if (m6432f5(removePrefix, prefix, false, 2, null)) {
            String substring = removePrefix.substring(prefix.length());
            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return removePrefix;
    }

    /* renamed from: c5 */
    public static final boolean m6441c5(@NotNull CharSequence startsWith, @NotNull CharSequence prefix, boolean z) {
        boolean m6548u2;
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            m6548u2 = StringsJVM.m6548u2((String) startsWith, (String) prefix, false, 2, null);
            return m6548u2;
        }
        return m6448a4(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    /* renamed from: d3 */
    public static final Tuples<Integer, String> m6440d3(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        int m6425i3;
        int m7460u;
        C14410i m7523W;
        Object obj;
        Object obj2;
        boolean m6582d2;
        int m7481n;
        Object m12184S4;
        if (!z && collection.size() == 1) {
            m12184S4 = _Collections.m12184S4(collection);
            String str = (String) m12184S4;
            int m6398r3 = !z2 ? m6398r3(charSequence, str, i, false, 4, null) : m6522F3(charSequence, str, i, false, 4, null);
            if (m6398r3 < 0) {
                return null;
            }
            return C14372l0.m7952a(Integer.valueOf(m6398r3), str);
        }
        if (z2) {
            m6425i3 = m6425i3(charSequence);
            m7460u = _Ranges.m7460u(i, m6425i3);
            m7523W = _Ranges.m7523W(m7460u, 0);
        } else {
            m7481n = _Ranges.m7481n(i, 0);
            m7523W = new C14413k(m7481n, charSequence.length());
        }
        if (charSequence instanceof String) {
            int m7604c = m7523W.m7604c();
            int m7603d = m7523W.m7603d();
            int m7602e = m7523W.m7602e();
            if (m7602e < 0 ? m7604c >= m7603d : m7604c <= m7603d) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        m6582d2 = StringsJVM.m6582d2(str2, 0, (String) charSequence, m7604c, str2.length(), z);
                        if (m6582d2) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (m7604c == m7603d) {
                            break;
                        }
                        m7604c += m7602e;
                    } else {
                        return C14372l0.m7952a(Integer.valueOf(m7604c), str3);
                    }
                }
            }
        } else {
            int m7604c2 = m7523W.m7604c();
            int m7603d2 = m7523W.m7603d();
            int m7602e2 = m7523W.m7602e();
            if (m7602e2 < 0 ? m7604c2 >= m7603d2 : m7604c2 <= m7603d2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (m6448a4(str4, 0, charSequence, m7604c2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (m7604c2 == m7603d2) {
                            break;
                        }
                        m7604c2 += m7602e2;
                    } else {
                        return C14372l0.m7952a(Integer.valueOf(m7604c2), str5);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    /* renamed from: d4 */
    public static final CharSequence m6439d4(@NotNull CharSequence removeRange, int i, int i2) {
        C14342f0.m8184p(removeRange, "$this$removeRange");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        } else if (i2 == i) {
            return removeRange.subSequence(0, removeRange.length());
        } else {
            StringBuilder sb = new StringBuilder(removeRange.length() - (i2 - i));
            sb.append(removeRange, 0, i);
            C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(removeRange, i2, removeRange.length());
            C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    /* renamed from: d5 */
    public static /* synthetic */ boolean m6438d5(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6447a5(charSequence, c, z);
    }

    /* renamed from: e3 */
    public static /* synthetic */ Tuples m6437e3(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6443c3(charSequence, collection, i, z);
    }

    @NotNull
    /* renamed from: e4 */
    public static final CharSequence m6436e4(@NotNull CharSequence removeRange, @NotNull C14413k range) {
        C14342f0.m8184p(removeRange, "$this$removeRange");
        C14342f0.m8184p(range, "range");
        return m6439d4(removeRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    /* renamed from: e5 */
    public static /* synthetic */ boolean m6435e5(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6444b5(charSequence, charSequence2, i, z);
    }

    @Nullable
    /* renamed from: f3 */
    public static final Tuples<Integer, String> m6434f3(@NotNull CharSequence findLastAnyOf, @NotNull Collection<String> strings, int i, boolean z) {
        C14342f0.m8184p(findLastAnyOf, "$this$findLastAnyOf");
        C14342f0.m8184p(strings, "strings");
        return m6440d3(findLastAnyOf, strings, i, z, true);
    }

    @InlineOnly
    /* renamed from: f4 */
    private static final String m6433f4(String str, int i, int i2) {
        if (str != null) {
            return m6439d4(str, i, i2).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: f5 */
    public static /* synthetic */ boolean m6432f5(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6441c5(charSequence, charSequence2, z);
    }

    /* renamed from: g3 */
    public static /* synthetic */ Tuples m6431g3(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m6425i3(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6434f3(charSequence, collection, i, z);
    }

    @InlineOnly
    /* renamed from: g4 */
    private static final String m6430g4(String str, C14413k c14413k) {
        if (str != null) {
            return m6436e4(str, c14413k).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    /* renamed from: g5 */
    public static final CharSequence m6429g5(@NotNull CharSequence subSequence, @NotNull C14413k range) {
        C14342f0.m8184p(subSequence, "$this$subSequence");
        C14342f0.m8184p(range, "range");
        return subSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @NotNull
    /* renamed from: h3 */
    public static final C14413k m6428h3(@NotNull CharSequence indices) {
        C14342f0.m8184p(indices, "$this$indices");
        return new C14413k(0, indices.length() - 1);
    }

    @NotNull
    /* renamed from: h4 */
    public static final CharSequence m6427h4(@NotNull CharSequence removeSuffix, @NotNull CharSequence suffix) {
        C14342f0.m8184p(removeSuffix, "$this$removeSuffix");
        C14342f0.m8184p(suffix, "suffix");
        if (m6446b3(removeSuffix, suffix, false, 2, null)) {
            return removeSuffix.subSequence(0, removeSuffix.length() - suffix.length());
        }
        return removeSuffix.subSequence(0, removeSuffix.length());
    }

    @Annotations(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    /* renamed from: h5 */
    private static final CharSequence m6426h5(String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    /* renamed from: i3 */
    public static int m6425i3(@NotNull CharSequence lastIndex) {
        C14342f0.m8184p(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    @NotNull
    /* renamed from: i4 */
    public static String m6424i4(@NotNull String removeSuffix, @NotNull CharSequence suffix) {
        C14342f0.m8184p(removeSuffix, "$this$removeSuffix");
        C14342f0.m8184p(suffix, "suffix");
        if (m6446b3(removeSuffix, suffix, false, 2, null)) {
            String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSuffix;
    }

    @InlineOnly
    /* renamed from: i5 */
    private static final String m6423i5(CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    /* renamed from: j3 */
    public static final boolean m6422j3(@NotNull CharSequence hasSurrogatePairAt, int i) {
        C14342f0.m8184p(hasSurrogatePairAt, "$this$hasSurrogatePairAt");
        return i >= 0 && hasSurrogatePairAt.length() + (-2) >= i && Character.isHighSurrogate(hasSurrogatePairAt.charAt(i)) && Character.isLowSurrogate(hasSurrogatePairAt.charAt(i + 1));
    }

    @NotNull
    /* renamed from: j4 */
    public static final CharSequence m6421j4(@NotNull CharSequence removeSurrounding, @NotNull CharSequence delimiter) {
        C14342f0.m8184p(removeSurrounding, "$this$removeSurrounding");
        C14342f0.m8184p(delimiter, "delimiter");
        return m6418k4(removeSurrounding, delimiter, delimiter);
    }

    @NotNull
    /* renamed from: j5 */
    public static final String m6420j5(@NotNull CharSequence substring, @NotNull C14413k range) {
        C14342f0.m8184p(substring, "$this$substring");
        C14342f0.m8184p(range, "range");
        return substring.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: k3 */
    private static final <C extends CharSequence & R, R> R m6419k3(C c, InterfaceC15269a<? extends R> interfaceC15269a) {
        return StringsJVM.m6592U1(c) ? interfaceC15269a.invoke() : c;
    }

    @NotNull
    /* renamed from: k4 */
    public static final CharSequence m6418k4(@NotNull CharSequence removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        C14342f0.m8184p(removeSurrounding, "$this$removeSurrounding");
        C14342f0.m8184p(prefix, "prefix");
        C14342f0.m8184p(suffix, "suffix");
        if (removeSurrounding.length() >= prefix.length() + suffix.length() && m6432f5(removeSurrounding, prefix, false, 2, null) && m6446b3(removeSurrounding, suffix, false, 2, null)) {
            return removeSurrounding.subSequence(prefix.length(), removeSurrounding.length() - suffix.length());
        }
        return removeSurrounding.subSequence(0, removeSurrounding.length());
    }

    @NotNull
    /* renamed from: k5 */
    public static final String m6417k5(@NotNull String substring, @NotNull C14413k range) {
        C14342f0.m8184p(substring, "$this$substring");
        C14342f0.m8184p(range, "range");
        String substring2 = substring.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        C14342f0.m8185o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: l3 */
    private static final <C extends CharSequence & R, R> R m6416l3(C c, InterfaceC15269a<? extends R> interfaceC15269a) {
        return c.length() == 0 ? interfaceC15269a.invoke() : c;
    }

    @NotNull
    /* renamed from: l4 */
    public static String m6415l4(@NotNull String removeSurrounding, @NotNull CharSequence delimiter) {
        C14342f0.m8184p(removeSurrounding, "$this$removeSurrounding");
        C14342f0.m8184p(delimiter, "delimiter");
        return m6412m4(removeSurrounding, delimiter, delimiter);
    }

    /* renamed from: l5 */
    static /* synthetic */ String m6414l5(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    /* renamed from: m3 */
    public static final int m6413m3(@NotNull CharSequence indexOf, char c, int i, boolean z) {
        C14342f0.m8184p(indexOf, "$this$indexOf");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(c, i);
        }
        return m6392t3(indexOf, new char[]{c}, i, z);
    }

    @NotNull
    /* renamed from: m4 */
    public static final String m6412m4(@NotNull String removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        C14342f0.m8184p(removeSurrounding, "$this$removeSurrounding");
        C14342f0.m8184p(prefix, "prefix");
        C14342f0.m8184p(suffix, "suffix");
        if (removeSurrounding.length() >= prefix.length() + suffix.length() && m6432f5(removeSurrounding, prefix, false, 2, null) && m6446b3(removeSurrounding, suffix, false, 2, null)) {
            String substring = removeSurrounding.substring(prefix.length(), removeSurrounding.length() - suffix.length());
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSurrounding;
    }

    @NotNull
    /* renamed from: m5 */
    public static final String m6411m5(@NotNull String substringAfter, char c, @NotNull String missingDelimiterValue) {
        int m6401q3;
        C14342f0.m8184p(substringAfter, "$this$substringAfter");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6401q3 = m6401q3(substringAfter, c, 0, false, 6, null);
        if (m6401q3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(m6401q3 + 1, substringAfter.length());
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: n3 */
    public static final int m6410n3(@NotNull CharSequence indexOf, @NotNull String string, int i, boolean z) {
        C14342f0.m8184p(indexOf, "$this$indexOf");
        C14342f0.m8184p(string, "string");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(string, i);
        }
        return m6404p3(indexOf, string, i, indexOf.length(), z, false, 16, null);
    }

    @InlineOnly
    /* renamed from: n4 */
    private static final String m6409n4(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    @NotNull
    /* renamed from: n5 */
    public static final String m6408n5(@NotNull String substringAfter, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int m6398r3;
        C14342f0.m8184p(substringAfter, "$this$substringAfter");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6398r3 = m6398r3(substringAfter, delimiter, 0, false, 6, null);
        if (m6398r3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(m6398r3 + delimiter.length(), substringAfter.length());
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: o3 */
    private static final int m6407o3(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int m6425i3;
        int m7460u;
        int m7481n;
        C14410i m7523W;
        boolean m6582d2;
        int m7481n2;
        int m7460u2;
        if (!z2) {
            m7481n2 = _Ranges.m7481n(i, 0);
            m7460u2 = _Ranges.m7460u(i2, charSequence.length());
            m7523W = new C14413k(m7481n2, m7460u2);
        } else {
            m6425i3 = m6425i3(charSequence);
            m7460u = _Ranges.m7460u(i, m6425i3);
            m7481n = _Ranges.m7481n(i2, 0);
            m7523W = _Ranges.m7523W(m7460u, m7481n);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int m7604c = m7523W.m7604c();
            int m7603d = m7523W.m7603d();
            int m7602e = m7523W.m7602e();
            if (m7602e >= 0) {
                if (m7604c > m7603d) {
                    return -1;
                }
            } else if (m7604c < m7603d) {
                return -1;
            }
            while (true) {
                m6582d2 = StringsJVM.m6582d2((String) charSequence2, 0, (String) charSequence, m7604c, charSequence2.length(), z);
                if (m6582d2) {
                    return m7604c;
                }
                if (m7604c == m7603d) {
                    return -1;
                }
                m7604c += m7602e;
            }
        } else {
            int m7604c2 = m7523W.m7604c();
            int m7603d2 = m7523W.m7603d();
            int m7602e2 = m7523W.m7602e();
            if (m7602e2 >= 0) {
                if (m7604c2 > m7603d2) {
                    return -1;
                }
            } else if (m7604c2 < m7603d2) {
                return -1;
            }
            while (!m6448a4(charSequence2, 0, charSequence, m7604c2, charSequence2.length(), z)) {
                if (m7604c2 == m7603d2) {
                    return -1;
                }
                m7604c2 += m7602e2;
            }
            return m7604c2;
        }
    }

    @InlineOnly
    /* renamed from: o4 */
    private static final String m6406o4(CharSequence charSequence, Regex regex, InterfaceC15280l<? super InterfaceC14566k, ? extends CharSequence> interfaceC15280l) {
        return regex.replace(charSequence, interfaceC15280l);
    }

    /* renamed from: o5 */
    public static /* synthetic */ String m6405o5(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m6411m5(str, c, str2);
    }

    /* renamed from: p3 */
    static /* synthetic */ int m6404p3(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m6407o3(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    @NotNull
    /* renamed from: p4 */
    public static final String m6403p4(@NotNull String replaceAfter, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6401q3;
        C14342f0.m8184p(replaceAfter, "$this$replaceAfter");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6401q3 = m6401q3(replaceAfter, c, 0, false, 6, null);
        return m6401q3 == -1 ? missingDelimiterValue : m6512I4(replaceAfter, m6401q3 + 1, replaceAfter.length(), replacement).toString();
    }

    /* renamed from: p5 */
    public static /* synthetic */ String m6402p5(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m6408n5(str, str2, str3);
    }

    /* renamed from: q3 */
    public static /* synthetic */ int m6401q3(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6413m3(charSequence, c, i, z);
    }

    @NotNull
    /* renamed from: q4 */
    public static final String m6400q4(@NotNull String replaceAfter, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6398r3;
        C14342f0.m8184p(replaceAfter, "$this$replaceAfter");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6398r3 = m6398r3(replaceAfter, delimiter, 0, false, 6, null);
        return m6398r3 == -1 ? missingDelimiterValue : m6512I4(replaceAfter, m6398r3 + delimiter.length(), replaceAfter.length(), replacement).toString();
    }

    @NotNull
    /* renamed from: q5 */
    public static String m6399q5(@NotNull String substringAfterLast, char c, @NotNull String missingDelimiterValue) {
        int m6525E3;
        C14342f0.m8184p(substringAfterLast, "$this$substringAfterLast");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6525E3 = m6525E3(substringAfterLast, c, 0, false, 6, null);
        if (m6525E3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(m6525E3 + 1, substringAfterLast.length());
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: r3 */
    public static /* synthetic */ int m6398r3(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6410n3(charSequence, str, i, z);
    }

    /* renamed from: r4 */
    public static /* synthetic */ String m6397r4(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return m6403p4(str, c, str2, str3);
    }

    @NotNull
    /* renamed from: r5 */
    public static final String m6396r5(@NotNull String substringAfterLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int m6522F3;
        C14342f0.m8184p(substringAfterLast, "$this$substringAfterLast");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6522F3 = m6522F3(substringAfterLast, delimiter, 0, false, 6, null);
        if (m6522F3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(m6522F3 + delimiter.length(), substringAfterLast.length());
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: s3 */
    public static final int m6395s3(@NotNull CharSequence indexOfAny, @NotNull Collection<String> strings, int i, boolean z) {
        Integer first;
        C14342f0.m8184p(indexOfAny, "$this$indexOfAny");
        C14342f0.m8184p(strings, "strings");
        Tuples<Integer, String> m6440d3 = m6440d3(indexOfAny, strings, i, z, false);
        if (m6440d3 == null || (first = m6440d3.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    /* renamed from: s4 */
    public static /* synthetic */ String m6394s4(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return m6400q4(str, str2, str3, str4);
    }

    /* renamed from: s5 */
    public static /* synthetic */ String m6393s5(String str, char c, String str2, int i, Object obj) {
        String m6399q5;
        if ((i & 2) != 0) {
            str2 = str;
        }
        m6399q5 = m6399q5(str, c, str2);
        return m6399q5;
    }

    /* renamed from: t3 */
    public static final int m6392t3(@NotNull CharSequence indexOfAny, @NotNull char[] chars, int i, boolean z) {
        int m7481n;
        int m6425i3;
        boolean z2;
        char m10051ss;
        C14342f0.m8184p(indexOfAny, "$this$indexOfAny");
        C14342f0.m8184p(chars, "chars");
        if (!z && chars.length == 1 && (indexOfAny instanceof String)) {
            m10051ss = _Arrays.m10051ss(chars);
            return ((String) indexOfAny).indexOf(m10051ss, i);
        }
        m7481n = _Ranges.m7481n(i, 0);
        m6425i3 = m6425i3(indexOfAny);
        if (m7481n > m6425i3) {
            return -1;
        }
        while (true) {
            char charAt = indexOfAny.charAt(m7481n);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (Char.m6858J(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return m7481n;
            }
            if (m7481n == m6425i3) {
                return -1;
            }
            m7481n++;
        }
    }

    @NotNull
    /* renamed from: t4 */
    public static final String m6391t4(@NotNull String replaceAfterLast, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6525E3;
        C14342f0.m8184p(replaceAfterLast, "$this$replaceAfterLast");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6525E3 = m6525E3(replaceAfterLast, c, 0, false, 6, null);
        return m6525E3 == -1 ? missingDelimiterValue : m6512I4(replaceAfterLast, m6525E3 + 1, replaceAfterLast.length(), replacement).toString();
    }

    /* renamed from: t5 */
    public static /* synthetic */ String m6390t5(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m6396r5(str, str2, str3);
    }

    /* renamed from: u3 */
    public static /* synthetic */ int m6389u3(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6395s3(charSequence, collection, i, z);
    }

    @NotNull
    /* renamed from: u4 */
    public static final String m6388u4(@NotNull String replaceAfterLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6522F3;
        C14342f0.m8184p(replaceAfterLast, "$this$replaceAfterLast");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6522F3 = m6522F3(replaceAfterLast, delimiter, 0, false, 6, null);
        return m6522F3 == -1 ? missingDelimiterValue : m6512I4(replaceAfterLast, m6522F3 + delimiter.length(), replaceAfterLast.length(), replacement).toString();
    }

    @NotNull
    /* renamed from: u5 */
    public static final String m6387u5(@NotNull String substringBefore, char c, @NotNull String missingDelimiterValue) {
        int m6401q3;
        C14342f0.m8184p(substringBefore, "$this$substringBefore");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6401q3 = m6401q3(substringBefore, c, 0, false, 6, null);
        if (m6401q3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, m6401q3);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: v3 */
    public static /* synthetic */ int m6386v3(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m6392t3(charSequence, cArr, i, z);
    }

    /* renamed from: v4 */
    public static /* synthetic */ String m6385v4(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return m6391t4(str, c, str2, str3);
    }

    @NotNull
    /* renamed from: v5 */
    public static final String m6384v5(@NotNull String substringBefore, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int m6398r3;
        C14342f0.m8184p(substringBefore, "$this$substringBefore");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6398r3 = m6398r3(substringBefore, delimiter, 0, false, 6, null);
        if (m6398r3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, m6398r3);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    /* renamed from: w3 */
    private static final boolean m6383w3(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    /* renamed from: w4 */
    public static /* synthetic */ String m6382w4(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return m6388u4(str, str2, str3, str4);
    }

    /* renamed from: w5 */
    public static /* synthetic */ String m6381w5(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m6387u5(str, c, str2);
    }

    @InlineOnly
    /* renamed from: x3 */
    private static final boolean m6380x3(CharSequence charSequence) {
        return !StringsJVM.m6592U1(charSequence);
    }

    @NotNull
    /* renamed from: x4 */
    public static final String m6379x4(@NotNull String replaceBefore, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6401q3;
        C14342f0.m8184p(replaceBefore, "$this$replaceBefore");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6401q3 = m6401q3(replaceBefore, c, 0, false, 6, null);
        return m6401q3 == -1 ? missingDelimiterValue : m6512I4(replaceBefore, 0, m6401q3, replacement).toString();
    }

    /* renamed from: x5 */
    public static /* synthetic */ String m6378x5(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m6384v5(str, str2, str3);
    }

    @InlineOnly
    /* renamed from: y3 */
    private static final boolean m6377y3(CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @NotNull
    /* renamed from: y4 */
    public static final String m6376y4(@NotNull String replaceBefore, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int m6398r3;
        C14342f0.m8184p(replaceBefore, "$this$replaceBefore");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(replacement, "replacement");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6398r3 = m6398r3(replaceBefore, delimiter, 0, false, 6, null);
        return m6398r3 == -1 ? missingDelimiterValue : m6512I4(replaceBefore, 0, m6398r3, replacement).toString();
    }

    @NotNull
    /* renamed from: y5 */
    public static final String m6375y5(@NotNull String substringBeforeLast, char c, @NotNull String missingDelimiterValue) {
        int m6525E3;
        C14342f0.m8184p(substringBeforeLast, "$this$substringBeforeLast");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6525E3 = m6525E3(substringBeforeLast, c, 0, false, 6, null);
        if (m6525E3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, m6525E3);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    /* renamed from: z3 */
    private static final boolean m6374z3(CharSequence charSequence) {
        return charSequence == null || StringsJVM.m6592U1(charSequence);
    }

    /* renamed from: z4 */
    public static /* synthetic */ String m6373z4(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return m6379x4(str, c, str2, str3);
    }

    @NotNull
    /* renamed from: z5 */
    public static final String m6372z5(@NotNull String substringBeforeLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int m6522F3;
        C14342f0.m8184p(substringBeforeLast, "$this$substringBeforeLast");
        C14342f0.m8184p(delimiter, "delimiter");
        C14342f0.m8184p(missingDelimiterValue, "missingDelimiterValue");
        m6522F3 = m6522F3(substringBeforeLast, delimiter, 0, false, 6, null);
        if (m6522F3 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, m6522F3);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
