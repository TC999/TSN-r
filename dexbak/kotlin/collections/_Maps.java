package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.umeng.ccg.CcgConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Annotations;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0080\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a]\u0010\b\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a_\u0010\n\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a6\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001a\\\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e0\u0005H\u0086\bø\u0001\u0000\u001ac\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00100\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aw\u0010\u0016\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0015\u001a\u00028\u00032$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e0\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aw\u0010\u0018\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0015\u001a\u00028\u00032$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00100\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0017\u001aV\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0086\bø\u0001\u0000\u001a\\\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\u0086\bø\u0001\u0000\u001aw\u0010\u001b\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0015\u001a\u00028\u00032 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aq\u0010\u001c\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0013*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0015\u001a\u00028\u00032\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017\u001aJ\u0010\u001f\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001d0\u0005H\u0086\bø\u0001\u0000\u001a$\u0010 \u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001aJ\u0010!\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001d0\u0005H\u0086\bø\u0001\u0000\u001a'\u0010#\u001a\u00020\"\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u001aJ\u0010$\u001a\u00020\"\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001d0\u0005H\u0086\bø\u0001\u0000\u001aJ\u0010'\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010&\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020%0\u0005H\u0087\bø\u0001\u0000\u001ah\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000\u001ah\u0010+\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000\u001aJ\u0010-\u001a\u00020,\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020,0\u0005H\u0087\bø\u0001\u0000\u001aJ\u0010/\u001a\u00020.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020.0\u0005H\u0087\bø\u0001\u0000\u001aa\u00100\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aS\u00102\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020,0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aS\u00104\u001a\u0004\u0018\u00010.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020.0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001ac\u00106\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b6\u00101\u001as\u0010:\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u00109\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000207j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`82\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001au\u0010<\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u00109\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000207j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`82\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010;\u001ai\u0010=\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u00109\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000607j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`8H\u0087\b\u001ai\u0010>\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u00109\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000607j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`8H\u0087\b\u001ah\u0010?\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000\u001ah\u0010@\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000\u001aJ\u0010A\u001a\u00020,\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020,0\u0005H\u0087\bø\u0001\u0000\u001aJ\u0010B\u001a\u00020.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020.0\u0005H\u0087\bø\u0001\u0000\u001aa\u0010C\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bC\u00101\u001aS\u0010D\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020,0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bD\u00103\u001aS\u0010E\u001a\u0004\u0018\u00010.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020.0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u00105\u001ac\u0010F\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020(*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bF\u00101\u001as\u0010G\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u00109\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000207j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`82\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bG\u0010;\u001au\u0010H\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u00109\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000207j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`82\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bH\u0010;\u001ah\u0010I\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u00109\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000607j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`8H\u0007\u001ai\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u00109\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000607j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`8H\u0087\b\u001a$\u0010K\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001aJ\u0010L\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001d0\u0005H\u0086\bø\u0001\u0000\u001a[\u0010N\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010M*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u00028\u00022\u001e\u0010&\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020%0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001ap\u0010T\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010M*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u00028\u000223\u0010&\u001a/\u0012\u0013\u0012\u00110\"¢\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(S\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020%0PH\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a9\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u001a6\u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006X"}, m12616d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "R", "", "Lkotlin/Function1;", "", "transform", "S0", "(Ljava/util/Map;Ll1/l;)Ljava/lang/Object;", "T0", "", "Lkotlin/Pair;", "F1", "", "U0", "Lkotlin/sequences/m;", "V0", "(Ljava/util/Map;Ll1/l;)Ljava/util/List;", "", "C", RtspHeaders.Values.DESTINATION, "X0", "(Ljava/util/Map;Ljava/util/Collection;Ll1/l;)Ljava/util/Collection;", "W0", "Z0", "a1", "b1", "c1", "", "predicate", "L0", "M0", "N0", "", "Q0", "R0", "Lkotlin/f1;", CcgConstant.f38549t, "Y0", "", "selector", "d1", "e1", "", "f1", "", "g1", "h1", "(Ljava/util/Map;Ll1/l;)Ljava/lang/Comparable;", "j1", "(Ljava/util/Map;Ll1/l;)Ljava/lang/Double;", "k1", "(Ljava/util/Map;Ll1/l;)Ljava/lang/Float;", "i1", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "l1", "(Ljava/util/Map;Ljava/util/Comparator;Ll1/l;)Ljava/lang/Object;", "m1", "n1", "o1", "p1", "q1", "r1", "s1", "t1", "v1", "w1", "u1", "x1", "y1", "z1", "A1", "B1", "C1", "M", "D1", "(Ljava/util/Map;Ll1/l;)Ljava/util/Map;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "E1", "(Ljava/util/Map;Ll1/p;)Ljava/util/Map;", "O0", "P0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.z0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class _Maps extends C14239y0 {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: A1 */
    private static final <K, V> Map.Entry<K, V> m8860A1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) _Collections.m12140b4(map.entrySet(), comparator);
    }

    /* renamed from: B1 */
    public static final <K, V> boolean m8859B1(@NotNull Map<? extends K, ? extends V> none) {
        C14342f0.m8184p(none, "$this$none");
        return none.isEmpty();
    }

    /* renamed from: C1 */
    public static final <K, V> boolean m8858C1(@NotNull Map<? extends K, ? extends V> none, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(none, "$this$none");
        C14342f0.m8184p(predicate, "predicate");
        if (none.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : none.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: D1 */
    public static final <K, V, M extends Map<? extends K, ? extends V>> M m8857D1(@NotNull M onEach, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        C14342f0.m8184p(onEach, "$this$onEach");
        C14342f0.m8184p(action, "action");
        for (Map.Entry<K, V> entry : onEach.entrySet()) {
            action.invoke(entry);
        }
        return onEach;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: E1 */
    public static final <K, V, M extends Map<? extends K, ? extends V>> M m8856E1(@NotNull M onEachIndexed, @NotNull InterfaceC15284p<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        C14342f0.m8184p(onEachIndexed, "$this$onEachIndexed");
        C14342f0.m8184p(action, "action");
        int i = 0;
        for (Object obj : onEachIndexed.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            action.invoke(Integer.valueOf(i), obj);
            i = i2;
        }
        return onEachIndexed;
    }

    @NotNull
    /* renamed from: F1 */
    public static <K, V> List<Tuples<K, V>> m8855F1(@NotNull Map<? extends K, ? extends V> toList) {
        List<Tuples<K, V>> m8965k;
        List<Tuples<K, V>> m12478E;
        List<Tuples<K, V>> m12478E2;
        C14342f0.m8184p(toList, "$this$toList");
        if (toList.size() == 0) {
            m12478E2 = CollectionsKt__CollectionsKt.m12478E();
            return m12478E2;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = toList.entrySet().iterator();
        if (!it.hasNext()) {
            m12478E = CollectionsKt__CollectionsKt.m12478E();
            return m12478E;
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            m8965k = CollectionsJVM.m8965k(new Tuples(next.getKey(), next.getValue()));
            return m8965k;
        }
        ArrayList arrayList = new ArrayList(toList.size());
        arrayList.add(new Tuples(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Tuples(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    /* renamed from: L0 */
    public static final <K, V> boolean m8854L0(@NotNull Map<? extends K, ? extends V> all, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(all, "$this$all");
        C14342f0.m8184p(predicate, "predicate");
        if (all.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : all.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: M0 */
    public static final <K, V> boolean m8853M0(@NotNull Map<? extends K, ? extends V> any) {
        C14342f0.m8184p(any, "$this$any");
        return !any.isEmpty();
    }

    /* renamed from: N0 */
    public static final <K, V> boolean m8852N0(@NotNull Map<? extends K, ? extends V> any, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(any, "$this$any");
        C14342f0.m8184p(predicate, "predicate");
        if (any.isEmpty()) {
            return false;
        }
        for (Map.Entry<? extends K, ? extends V> entry : any.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @InlineOnly
    /* renamed from: O0 */
    private static final <K, V> Iterable<Map.Entry<K, V>> m8851O0(Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    @NotNull
    /* renamed from: P0 */
    public static final <K, V> Sequence<Map.Entry<K, V>> m8850P0(@NotNull Map<? extends K, ? extends V> asSequence) {
        Sequence<Map.Entry<K, V>> m12090n1;
        C14342f0.m8184p(asSequence, "$this$asSequence");
        m12090n1 = _Collections.m12090n1(asSequence.entrySet());
        return m12090n1;
    }

    @InlineOnly
    /* renamed from: Q0 */
    private static final <K, V> int m8849Q0(Map<? extends K, ? extends V> map) {
        return map.size();
    }

    /* renamed from: R0 */
    public static final <K, V> int m8848R0(@NotNull Map<? extends K, ? extends V> count, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        C14342f0.m8184p(count, "$this$count");
        C14342f0.m8184p(predicate, "predicate");
        int i = 0;
        if (count.isEmpty()) {
            return 0;
        }
        for (Map.Entry<? extends K, ? extends V> entry : count.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: S0 */
    private static final <K, V, R> R m8847S0(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        R r;
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = interfaceC15280l.invoke(it.next());
            if (r != null) {
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: T0 */
    private static final <K, V, R> R m8846T0(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            R invoke = interfaceC15280l.invoke(entry);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @NotNull
    /* renamed from: U0 */
    public static final <K, V, R> List<R> m8845U0(@NotNull Map<? extends K, ? extends V> flatMap, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        C14342f0.m8184p(flatMap, "$this$flatMap");
        C14342f0.m8184p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : flatMap.entrySet()) {
            MutableCollections.m12416q0(arrayList, transform.invoke(entry));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    /* renamed from: V0 */
    public static final <K, V, R> List<R> m8844V0(@NotNull Map<? extends K, ? extends V> flatMap, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        C14342f0.m8184p(flatMap, "$this$flatMap");
        C14342f0.m8184p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : flatMap.entrySet()) {
            MutableCollections.m12415r0(arrayList, transform.invoke(entry));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    /* renamed from: W0 */
    public static final <K, V, R, C extends Collection<? super R>> C m8843W0(@NotNull Map<? extends K, ? extends V> flatMapTo, @NotNull C destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        C14342f0.m8184p(flatMapTo, "$this$flatMapTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : flatMapTo.entrySet()) {
            MutableCollections.m12415r0(destination, transform.invoke(entry));
        }
        return destination;
    }

    @NotNull
    /* renamed from: X0 */
    public static final <K, V, R, C extends Collection<? super R>> C m8842X0(@NotNull Map<? extends K, ? extends V> flatMapTo, @NotNull C destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        C14342f0.m8184p(flatMapTo, "$this$flatMapTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : flatMapTo.entrySet()) {
            MutableCollections.m12416q0(destination, transform.invoke(entry));
        }
        return destination;
    }

    @HidesMembers
    /* renamed from: Y0 */
    public static final <K, V> void m8841Y0(@NotNull Map<? extends K, ? extends V> forEach, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        C14342f0.m8184p(forEach, "$this$forEach");
        C14342f0.m8184p(action, "action");
        for (Map.Entry<? extends K, ? extends V> entry : forEach.entrySet()) {
            action.invoke(entry);
        }
    }

    @NotNull
    /* renamed from: Z0 */
    public static final <K, V, R> List<R> m8840Z0(@NotNull Map<? extends K, ? extends V> map, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(map, "$this$map");
        C14342f0.m8184p(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            arrayList.add(transform.invoke(entry));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: a1 */
    public static final <K, V, R> List<R> m8839a1(@NotNull Map<? extends K, ? extends V> mapNotNull, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(mapNotNull, "$this$mapNotNull");
        C14342f0.m8184p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : mapNotNull.entrySet()) {
            R invoke = transform.invoke(entry);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: b1 */
    public static final <K, V, R, C extends Collection<? super R>> C m8838b1(@NotNull Map<? extends K, ? extends V> mapNotNullTo, @NotNull C destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(mapNotNullTo, "$this$mapNotNullTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : mapNotNullTo.entrySet()) {
            R invoke = transform.invoke(entry);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    /* renamed from: c1 */
    public static final <K, V, R, C extends Collection<? super R>> C m8837c1(@NotNull Map<? extends K, ? extends V> mapTo, @NotNull C destination, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        C14342f0.m8184p(mapTo, "$this$mapTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : mapTo.entrySet()) {
            destination.add(transform.invoke(entry));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Annotations(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: d1 */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m8836d1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = interfaceC15280l.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = interfaceC15280l.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: e1 */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m8835e1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = interfaceC15280l.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = interfaceC15280l.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: f1 */
    private static final <K, V> double m8834f1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Double> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = interfaceC15280l.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, interfaceC15280l.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: g1 */
    private static final <K, V> float m8833g1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Float> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = interfaceC15280l.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, interfaceC15280l.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: h1 */
    private static final <K, V, R extends Comparable<? super R>> R m8832h1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = interfaceC15280l.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: i1 */
    private static final <K, V, R extends Comparable<? super R>> R m8831i1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = interfaceC15280l.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: j1 */
    private static final <K, V> Double m8830j1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Double> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = interfaceC15280l.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, interfaceC15280l.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: k1 */
    private static final <K, V> Float m8829k1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Float> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = interfaceC15280l.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, interfaceC15280l.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: l1 */
    private static final <K, V, R> R m8828l1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = interfaceC15280l.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: m1 */
    private static final <K, V, R> R m8827m1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = interfaceC15280l.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @Annotations(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: n1 */
    private static final <K, V> Map.Entry<K, V> m8826n1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) _Collections.m12230J3(map.entrySet(), comparator);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: o1 */
    private static final <K, V> Map.Entry<K, V> m8825o1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) _Collections.m12230J3(map.entrySet(), comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Annotations(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = BuildConfig.VERSION_NAME)
    @Nullable
    /* renamed from: p1 */
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m8824p1(@NotNull Map<? extends K, ? extends V> minBy, @NotNull InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        C14342f0.m8184p(minBy, "$this$minBy");
        C14342f0.m8184p(selector, "selector");
        Iterator it = minBy.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = selector.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: q1 */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m8823q1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = interfaceC15280l.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = interfaceC15280l.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: r1 */
    private static final <K, V> double m8822r1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Double> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = interfaceC15280l.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, interfaceC15280l.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: s1 */
    private static final <K, V> float m8821s1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Float> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = interfaceC15280l.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, interfaceC15280l.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: t1 */
    private static final <K, V, R extends Comparable<? super R>> R m8820t1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = interfaceC15280l.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: u1 */
    private static final <K, V, R extends Comparable<? super R>> R m8819u1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = interfaceC15280l.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: v1 */
    private static final <K, V> Double m8818v1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Double> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = interfaceC15280l.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, interfaceC15280l.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: w1 */
    private static final <K, V> Float m8817w1(Map<? extends K, ? extends V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, Float> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = interfaceC15280l.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, interfaceC15280l.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: x1 */
    private static final <K, V, R> R m8816x1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = interfaceC15280l.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: y1 */
    private static final <K, V, R> R m8815y1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) interfaceC15280l.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = interfaceC15280l.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @Annotations(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = BuildConfig.VERSION_NAME)
    @Nullable
    /* renamed from: z1 */
    public static final <K, V> Map.Entry<K, V> m8814z1(@NotNull Map<? extends K, ? extends V> minWith, @NotNull Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        C14342f0.m8184p(minWith, "$this$minWith");
        C14342f0.m8184p(comparator, "comparator");
        return (Map.Entry) _Collections.m12140b4(minWith.entrySet(), comparator);
    }
}
