package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections._ArraysJvm;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.InterfaceC15298d;
import p620m1.InterfaceC15301g;

/* compiled from: MapBuilder.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0007\b\u0000\u0018\u0000 <*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0006ILQUY\\BG\b\u0002\u0012\f\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n\u0012\u0006\u0010f\u001a\u00020d\u0012\u0006\u0010h\u001a\u00020d\u0012\u0006\u0010j\u001a\u00020\u0004\u0012\u0006\u0010k\u001a\u00020\u0004¢\u0006\u0004\bz\u0010{B\t\b\u0016¢\u0006\u0004\bz\u00107B\u0011\b\u0016\u0012\u0006\u0010|\u001a\u00020\u0004¢\u0006\u0004\bz\u0010}J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u000e\u0010\u001e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001dH\u0002J\u001c\u0010\"\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 H\u0002J\"\u0010%\u001a\u00020\u00142\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 0#H\u0002J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001dJ\b\u0010&\u001a\u00020\u0014H\u0016J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0004\b)\u0010(J\u001a\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0004\b,\u0010-J\u001e\u0010.\u001a\u00020\u00062\u0014\u0010$\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001dH\u0016J\u0019\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b/\u0010+J\b\u00100\u001a\u00020\u0006H\u0016J\u0013\u00102\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u000204H\u0016J\u000f\u00106\u001a\u00020\u0006H\u0000¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0000¢\u0006\u0004\b8\u0010\u000fJ\u0017\u00109\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0000¢\u0006\u0004\b9\u0010\u000fJ#\u0010:\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 H\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\u00142\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030#H\u0000¢\u0006\u0004\b<\u0010=J#\u0010\u0001\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 H\u0000¢\u0006\u0004\b\u0001\u0010;J\u0017\u0010?\u001a\u00020\u00142\u0006\u0010>\u001a\u00028\u0001H\u0000¢\u0006\u0004\b?\u0010(J\u001b\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010@H\u0000¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010CH\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010\u0015R$\u0010O\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bL\u0010\u0015\u001a\u0004\bM\u0010NR\u001e\u0010S\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010W\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR$\u0010[\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001e\u0010c\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010eR\u0016\u0010h\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010eR\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010\u0015R\u0016\u0010k\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010NR\u0014\u0010n\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010NR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00028\u00000o8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR&\u0010y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010w0o8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010q¨\u0006~"}, m12616d2 = {"Lkotlin/collections/builders/d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "n", "Lkotlin/f1;", "u", "capacity", UMCommonContent.f37782aL, "", "m", "()[Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Object;)I", "p", "newHashSize", "J", "i", "", "I", IAdInterListener.AdReqParam.WIDTH, DomainCampaignEx.LOOPBACK_VALUE, "x", "index", "N", "removedHash", "L", "", AdnName.OTHER, "s", "", "entry", "H", "", Constants.FROM, "G", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "clear", "", "equals", TTDownloadField.TT_HASHCODE, "", "toString", "o", "()V", C7304t.f25048d, "M", "r", "(Ljava/util/Map$Entry;)Z", CampaignEx.JSON_KEY_AD_Q, "(Ljava/util/Collection;)Z", "element", "O", "Lkotlin/collections/builders/d$e;", "F", "()Lkotlin/collections/builders/d$e;", "Lkotlin/collections/builders/d$f;", "P", "()Lkotlin/collections/builders/d$f;", "Lkotlin/collections/builders/d$b;", "v", "()Lkotlin/collections/builders/d$b;", "a", "hashShift", "<set-?>", "b", "C", "()I", "size", "Lkotlin/collections/builders/f;", "c", "Lkotlin/collections/builders/f;", "keysView", "Lkotlin/collections/builders/g;", "d", "Lkotlin/collections/builders/g;", "valuesView", "Lkotlin/collections/builders/e;", "e", "Lkotlin/collections/builders/e;", "entriesView", "f", "Z", "isReadOnly", "g", "[Ljava/lang/Object;", "keysArray", "h", "valuesArray", "", "[I", "presenceArray", "j", "hashArray", "k", "maxProbeDistance", "length", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "hashSize", "", "B", "()Ljava/util/Set;", "keys", "", "D", "()Ljava/util/Collection;", "values", "", UMCommonContent.f37777aG, "entries", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "initialCapacity", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.builders.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14132d<K, V> implements Map<K, V>, InterfaceC15301g {
    @Deprecated

    /* renamed from: m */
    private static final int f40842m = -1640531527;
    @Deprecated

    /* renamed from: n */
    private static final int f40843n = 8;
    @Deprecated

    /* renamed from: o */
    private static final int f40844o = 2;
    @Deprecated

    /* renamed from: p */
    private static final int f40845p = -1;
    @NotNull

    /* renamed from: q */
    private static final C14133a f40846q = new C14133a(null);

    /* renamed from: a */
    private int f40847a;

    /* renamed from: b */
    private int f40848b;

    /* renamed from: c */
    private C14140f<K> f40849c;

    /* renamed from: d */
    private C14141g<V> f40850d;

    /* renamed from: e */
    private C14139e<K, V> f40851e;

    /* renamed from: f */
    private boolean f40852f;

    /* renamed from: g */
    private K[] f40853g;

    /* renamed from: h */
    private V[] f40854h;

    /* renamed from: i */
    private int[] f40855i;

    /* renamed from: j */
    private int[] f40856j;

    /* renamed from: k */
    private int f40857k;

    /* renamed from: l */
    private int f40858l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e"}, m12616d2 = {"Lkotlin/collections/builders/d$a;", "", "", "capacity", "c", "hashSize", "d", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14133a {
        private C14133a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public final int m12335c(int i) {
            int m7481n;
            m7481n = _Ranges.m7481n(i, 1);
            return Integer.highestOneBit(m7481n * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public final int m12334d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public /* synthetic */ C14133a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\f¨\u0006\u0014"}, m12616d2 = {"Lkotlin/collections/builders/d$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/d$d;", "", "", "Lkotlin/collections/builders/d$c;", "h", "", "j", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lkotlin/f1;", "i", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14134b<K, V> extends C14136d<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC15298d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14134b(@NotNull C14132d<K, V> map) {
            super(map);
            C14342f0.m8184p(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: h */
        public C14135c<K, V> next() {
            if (m12330a() < ((C14132d) m12328d()).f40858l) {
                int m12330a = m12330a();
                m12326f(m12330a + 1);
                m12325g(m12330a);
                C14135c<K, V> c14135c = new C14135c<>(m12328d(), m12329c());
                m12327e();
                return c14135c;
            }
            throw new NoSuchElementException();
        }

        /* renamed from: i */
        public final void m12332i(@NotNull StringBuilder sb) {
            C14342f0.m8184p(sb, "sb");
            if (m12330a() < ((C14132d) m12328d()).f40858l) {
                int m12330a = m12330a();
                m12326f(m12330a + 1);
                m12325g(m12330a);
                Object obj = ((C14132d) m12328d()).f40853g[m12329c()];
                if (C14342f0.m8193g(obj, m12328d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((C14132d) m12328d()).f40854h;
                C14342f0.m8187m(objArr);
                Object obj2 = objArr[m12329c()];
                if (C14342f0.m8193g(obj2, m12328d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                m12327e();
                return;
            }
            throw new NoSuchElementException();
        }

        /* renamed from: j */
        public final int m12331j() {
            if (m12330a() < ((C14132d) m12328d()).f40858l) {
                int m12330a = m12330a();
                m12326f(m12330a + 1);
                m12325g(m12330a);
                Object obj = ((C14132d) m12328d()).f40853g[m12329c()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((C14132d) m12328d()).f40854h;
                C14342f0.m8187m(objArr);
                Object obj2 = objArr[m12329c()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                m12327e();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, m12616d2 = {"Lkotlin/collections/builders/d$c;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "Lkotlin/collections/builders/d;", "a", "Lkotlin/collections/builders/d;", "map", "b", "I", "index", "getKey", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "getValue", DomainCampaignEx.LOOPBACK_VALUE, "<init>", "(Lkotlin/collections/builders/d;I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14135c<K, V> implements Map.Entry<K, V>, InterfaceC15301g.InterfaceC15302a {

        /* renamed from: a */
        private final C14132d<K, V> f40859a;

        /* renamed from: b */
        private final int f40860b;

        public C14135c(@NotNull C14132d<K, V> map, int i) {
            C14342f0.m8184p(map, "map");
            this.f40859a = map;
            this.f40860b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (C14342f0.m8193g(entry.getKey(), getKey()) && C14342f0.m8193g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((C14132d) this.f40859a).f40853g[this.f40860b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((C14132d) this.f40859a).f40854h;
            C14342f0.m8187m(objArr);
            return (V) objArr[this.f40860b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.f40859a.m12349o();
            Object[] m12351m = this.f40859a.m12351m();
            int i = this.f40860b;
            V v2 = (V) m12351m[i];
            m12351m[i] = v;
            return v2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004R\"\u0010\u0010\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, m12616d2 = {"Lkotlin/collections/builders/d$d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/f1;", "e", "()V", "", "hasNext", "remove", "", "a", "I", "()I", "f", "(I)V", "index", "b", "c", "g", "lastIndex", "Lkotlin/collections/builders/d;", "Lkotlin/collections/builders/d;", "d", "()Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C14136d<K, V> {

        /* renamed from: a */
        private int f40861a;

        /* renamed from: b */
        private int f40862b;
        @NotNull

        /* renamed from: c */
        private final C14132d<K, V> f40863c;

        public C14136d(@NotNull C14132d<K, V> map) {
            C14342f0.m8184p(map, "map");
            this.f40863c = map;
            this.f40862b = -1;
            m12327e();
        }

        /* renamed from: a */
        public final int m12330a() {
            return this.f40861a;
        }

        /* renamed from: c */
        public final int m12329c() {
            return this.f40862b;
        }

        @NotNull
        /* renamed from: d */
        public final C14132d<K, V> m12328d() {
            return this.f40863c;
        }

        /* renamed from: e */
        public final void m12327e() {
            while (this.f40861a < ((C14132d) this.f40863c).f40858l) {
                int[] iArr = ((C14132d) this.f40863c).f40855i;
                int i = this.f40861a;
                if (iArr[i] >= 0) {
                    return;
                }
                this.f40861a = i + 1;
            }
        }

        /* renamed from: f */
        public final void m12326f(int i) {
            this.f40861a = i;
        }

        /* renamed from: g */
        public final void m12325g(int i) {
            this.f40862b = i;
        }

        public final boolean hasNext() {
            return this.f40861a < ((C14132d) this.f40863c).f40858l;
        }

        public final void remove() {
            if (this.f40862b != -1) {
                this.f40863c.m12349o();
                this.f40863c.m12365N(this.f40862b);
                this.f40862b = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m12616d2 = {"Lkotlin/collections/builders/d$e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/d$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14137e<K, V> extends C14136d<K, V> implements Iterator<K>, InterfaceC15298d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14137e(@NotNull C14132d<K, V> map) {
            super(map);
            C14342f0.m8184p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (m12330a() < ((C14132d) m12328d()).f40858l) {
                int m12330a = m12330a();
                m12326f(m12330a + 1);
                m12325g(m12330a);
                K k = (K) ((C14132d) m12328d()).f40853g[m12329c()];
                m12327e();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m12616d2 = {"Lkotlin/collections/builders/d$f;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/d$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14138f<K, V> extends C14136d<K, V> implements Iterator<V>, InterfaceC15298d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14138f(@NotNull C14132d<K, V> map) {
            super(map);
            C14342f0.m8184p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (m12330a() < ((C14132d) m12328d()).f40858l) {
                int m12330a = m12330a();
                m12326f(m12330a + 1);
                m12325g(m12330a);
                Object[] objArr = ((C14132d) m12328d()).f40854h;
                C14342f0.m8187m(objArr);
                V v = (V) objArr[m12329c()];
                m12327e();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private C14132d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.f40853g = kArr;
        this.f40854h = vArr;
        this.f40855i = iArr;
        this.f40856j = iArr2;
        this.f40857k = i;
        this.f40858l = i2;
        this.f40847a = f40846q.m12334d(m12378A());
    }

    /* renamed from: A */
    private final int m12378A() {
        return this.f40856j.length;
    }

    /* renamed from: E */
    private final int m12374E(K k) {
        return ((k != null ? k.hashCode() : 0) * f40842m) >>> this.f40847a;
    }

    /* renamed from: G */
    private final boolean m12372G(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        m12343u(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (m12371H(entry)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: H */
    private final boolean m12371H(Map.Entry<? extends K, ? extends V> entry) {
        int m12352l = m12352l(entry.getKey());
        V[] m12351m = m12351m();
        if (m12352l >= 0) {
            m12351m[m12352l] = entry.getValue();
            return true;
        }
        int i = (-m12352l) - 1;
        if (!C14342f0.m8193g(entry.getValue(), m12351m[i])) {
            m12351m[i] = entry.getValue();
            return true;
        }
        return false;
    }

    /* renamed from: I */
    private final boolean m12370I(int i) {
        int m12374E = m12374E(this.f40853g[i]);
        int i2 = this.f40857k;
        while (true) {
            int[] iArr = this.f40856j;
            if (iArr[m12374E] == 0) {
                iArr[m12374E] = i + 1;
                this.f40855i[i] = m12374E;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            m12374E = m12374E == 0 ? m12378A() - 1 : m12374E - 1;
        }
    }

    /* renamed from: J */
    private final void m12369J(int i) {
        if (this.f40858l > size()) {
            m12348p();
        }
        int i2 = 0;
        if (i != m12378A()) {
            this.f40856j = new int[i];
            this.f40847a = f40846q.m12334d(i);
        } else {
            _ArraysJvm.m11579l2(this.f40856j, 0, 0, m12378A());
        }
        while (i2 < this.f40858l) {
            int i3 = i2 + 1;
            if (!m12370I(i2)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3;
        }
    }

    /* renamed from: L */
    private final void m12367L(int i) {
        int m7460u;
        m7460u = _Ranges.m7460u(this.f40857k * 2, m12378A() / 2);
        int i2 = m7460u;
        int i3 = 0;
        int i4 = i;
        do {
            i = i == 0 ? m12378A() - 1 : i - 1;
            i3++;
            if (i3 > this.f40857k) {
                this.f40856j[i4] = 0;
                return;
            }
            int[] iArr = this.f40856j;
            int i5 = iArr[i];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((m12374E(this.f40853g[i6]) - i) & (m12378A() - 1)) >= i3) {
                    this.f40856j[i4] = i5;
                    this.f40855i[i6] = i4;
                }
                i2--;
            }
            i4 = i;
            i3 = 0;
            i2--;
        } while (i2 >= 0);
        this.f40856j[i4] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final void m12365N(int i) {
        C14131c.m12383f(this.f40853g, i);
        m12367L(this.f40855i[i]);
        this.f40855i[i] = -1;
        this.f40848b = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public final V[] m12351m() {
        V[] vArr = this.f40854h;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) C14131c.m12385d(m12339y());
        this.f40854h = vArr2;
        return vArr2;
    }

    /* renamed from: p */
    private final void m12348p() {
        int i;
        V[] vArr = this.f40854h;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.f40858l;
            if (i2 >= i) {
                break;
            }
            if (this.f40855i[i2] >= 0) {
                K[] kArr = this.f40853g;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        C14131c.m12382g(this.f40853g, i3, i);
        if (vArr != null) {
            C14131c.m12382g(vArr, i3, this.f40858l);
        }
        this.f40858l = i3;
    }

    /* renamed from: s */
    private final boolean m12345s(Map<?, ?> map) {
        return size() == map.size() && m12347q(map.entrySet());
    }

    /* renamed from: t */
    private final void m12344t(int i) {
        if (i > m12339y()) {
            int m12339y = (m12339y() * 3) / 2;
            if (i <= m12339y) {
                i = m12339y;
            }
            this.f40853g = (K[]) C14131c.m12384e(this.f40853g, i);
            V[] vArr = this.f40854h;
            this.f40854h = vArr != null ? (V[]) C14131c.m12384e(vArr, i) : null;
            int[] copyOf = Arrays.copyOf(this.f40855i, i);
            C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.f40855i = copyOf;
            int m12335c = f40846q.m12335c(i);
            if (m12335c > m12378A()) {
                m12369J(m12335c);
            }
        } else if ((this.f40858l + i) - size() > m12339y()) {
            m12369J(m12378A());
        }
    }

    /* renamed from: u */
    private final void m12343u(int i) {
        m12344t(this.f40858l + i);
    }

    /* renamed from: w */
    private final int m12341w(K k) {
        int m12374E = m12374E(k);
        int i = this.f40857k;
        while (true) {
            int i2 = this.f40856j[m12374E];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (C14342f0.m8193g(this.f40853g[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            m12374E = m12374E == 0 ? m12378A() - 1 : m12374E - 1;
        }
    }

    /* renamed from: x */
    private final int m12340x(V v) {
        int i = this.f40858l;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f40855i[i] >= 0) {
                V[] vArr = this.f40854h;
                C14342f0.m8187m(vArr);
                if (C14342f0.m8193g(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    /* renamed from: y */
    private final int m12339y() {
        return this.f40853g.length;
    }

    @NotNull
    /* renamed from: B */
    public Set<K> m12377B() {
        C14140f<K> c14140f = this.f40849c;
        if (c14140f == null) {
            C14140f<K> c14140f2 = new C14140f<>(this);
            this.f40849c = c14140f2;
            return c14140f2;
        }
        return c14140f;
    }

    /* renamed from: C */
    public int m12376C() {
        return this.f40848b;
    }

    @NotNull
    /* renamed from: D */
    public Collection<V> m12375D() {
        C14141g<V> c14141g = this.f40850d;
        if (c14141g == null) {
            C14141g<V> c14141g2 = new C14141g<>(this);
            this.f40850d = c14141g2;
            return c14141g2;
        }
        return c14141g;
    }

    @NotNull
    /* renamed from: F */
    public final C14137e<K, V> m12373F() {
        return new C14137e<>(this);
    }

    /* renamed from: K */
    public final boolean m12368K(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        C14342f0.m8184p(entry, "entry");
        m12349o();
        int m12341w = m12341w(entry.getKey());
        if (m12341w < 0) {
            return false;
        }
        V[] vArr = this.f40854h;
        C14342f0.m8187m(vArr);
        if (!C14342f0.m8193g(vArr[m12341w], entry.getValue())) {
            return false;
        }
        m12365N(m12341w);
        return true;
    }

    /* renamed from: M */
    public final int m12366M(K k) {
        m12349o();
        int m12341w = m12341w(k);
        if (m12341w < 0) {
            return -1;
        }
        m12365N(m12341w);
        return m12341w;
    }

    /* renamed from: O */
    public final boolean m12364O(V v) {
        m12349o();
        int m12340x = m12340x(v);
        if (m12340x < 0) {
            return false;
        }
        m12365N(m12340x);
        return true;
    }

    @NotNull
    /* renamed from: P */
    public final C14138f<K, V> m12363P() {
        return new C14138f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        m12349o();
        int i = this.f40858l - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f40855i;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.f40856j[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        C14131c.m12382g(this.f40853g, 0, this.f40858l);
        V[] vArr = this.f40854h;
        if (vArr != null) {
            C14131c.m12382g(vArr, 0, this.f40858l);
        }
        this.f40848b = 0;
        this.f40858l = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return m12341w(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return m12340x(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m12338z();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && m12345s((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int m12341w = m12341w(obj);
        if (m12341w < 0) {
            return null;
        }
        V[] vArr = this.f40854h;
        C14342f0.m8187m(vArr);
        return vArr[m12341w];
    }

    @Override // java.util.Map
    public int hashCode() {
        C14134b<K, V> m12342v = m12342v();
        int i = 0;
        while (m12342v.hasNext()) {
            i += m12342v.m12331j();
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m12377B();
    }

    /* renamed from: l */
    public final int m12352l(K k) {
        int m7460u;
        m12349o();
        while (true) {
            int m12374E = m12374E(k);
            m7460u = _Ranges.m7460u(this.f40857k * 2, m12378A() / 2);
            int i = 0;
            while (true) {
                int i2 = this.f40856j[m12374E];
                if (i2 <= 0) {
                    if (this.f40858l >= m12339y()) {
                        m12343u(1);
                    } else {
                        int i3 = this.f40858l;
                        int i4 = i3 + 1;
                        this.f40858l = i4;
                        this.f40853g[i3] = k;
                        this.f40855i[i3] = m12374E;
                        this.f40856j[m12374E] = i4;
                        this.f40848b = size() + 1;
                        if (i > this.f40857k) {
                            this.f40857k = i;
                        }
                        return i3;
                    }
                } else if (C14342f0.m8193g(this.f40853g[i2 - 1], k)) {
                    return -i2;
                } else {
                    i++;
                    if (i > m7460u) {
                        m12369J(m12378A() * 2);
                        break;
                    }
                    m12374E = m12374E == 0 ? m12378A() - 1 : m12374E - 1;
                }
            }
        }
    }

    @NotNull
    /* renamed from: n */
    public final Map<K, V> m12350n() {
        m12349o();
        this.f40852f = true;
        return this;
    }

    /* renamed from: o */
    public final void m12349o() {
        if (this.f40852f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k, V v) {
        m12349o();
        int m12352l = m12352l(k);
        V[] m12351m = m12351m();
        if (m12352l < 0) {
            int i = (-m12352l) - 1;
            V v2 = m12351m[i];
            m12351m[i] = v;
            return v2;
        }
        m12351m[m12352l] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        C14342f0.m8184p(from, "from");
        m12349o();
        m12372G(from.entrySet());
    }

    /* renamed from: q */
    public final boolean m12347q(@NotNull Collection<?> m) {
        C14342f0.m8184p(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!m12346r((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: r */
    public final boolean m12346r(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        C14342f0.m8184p(entry, "entry");
        int m12341w = m12341w(entry.getKey());
        if (m12341w < 0) {
            return false;
        }
        V[] vArr = this.f40854h;
        C14342f0.m8187m(vArr);
        return C14342f0.m8193g(vArr[m12341w], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int m12366M = m12366M(obj);
        if (m12366M < 0) {
            return null;
        }
        V[] vArr = this.f40854h;
        C14342f0.m8187m(vArr);
        V v = vArr[m12366M];
        C14131c.m12383f(vArr, m12366M);
        return v;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m12376C();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        C14134b<K, V> m12342v = m12342v();
        int i = 0;
        while (m12342v.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            m12342v.m12332i(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    /* renamed from: v */
    public final C14134b<K, V> m12342v() {
        return new C14134b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m12375D();
    }

    @NotNull
    /* renamed from: z */
    public Set<Map.Entry<K, V>> m12338z() {
        C14139e<K, V> c14139e = this.f40851e;
        if (c14139e == null) {
            C14139e<K, V> c14139e2 = new C14139e<>(this);
            this.f40851e = c14139e2;
            return c14139e2;
        }
        return c14139e;
    }

    public C14132d() {
        this(8);
    }

    public C14132d(int i) {
        this(C14131c.m12385d(i), null, new int[i], new int[f40846q.m12335c(i)], 2, 0);
    }
}
