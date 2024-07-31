package kotlin.collections.unsigned;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.collections.AbstractList;
import kotlin.collections._Arrays;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u001e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010 \u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a2\u0010$\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a.\u0010)\u001a\u00020'*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a.\u0010+\u001a\u00020'*\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020'*\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a.\u0010/\u001a\u00020'*\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a.\u00102\u001a\u000201*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002010&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001a.\u00104\u001a\u000201*\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002010&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001a.\u00106\u001a\u000201*\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002010&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a.\u00108\u001a\u000201*\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002010&H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006:"}, m12616d2 = {"Lkotlin/s0;", "", "index", "Lkotlin/r0;", "o", "([II)I", "Lkotlin/w0;", "Lkotlin/v0;", "p", "([JI)J", "Lkotlin/o0;", "Lkotlin/n0;", "m", "([BI)B", "Lkotlin/c1;", "Lkotlin/b1;", "n", "([SI)S", "", "a", "([I)Ljava/util/List;", "c", "([J)Ljava/util/List;", "b", "([B)Ljava/util/List;", "d", "([S)Ljava/util/List;", "element", "fromIndex", "toIndex", "e", "([IIII)I", "i", "([JJII)I", "k", "([BBII)I", "g", "([SSII)I", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "r", "([ILl1/l;)Ljava/math/BigDecimal;", "s", "([JLl1/l;)Ljava/math/BigDecimal;", CampaignEx.JSON_KEY_AD_Q, "([BLl1/l;)Ljava/math/BigDecimal;", UMCommonContent.f37782aL, "([SLl1/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "v", "([ILl1/l;)Ljava/math/BigInteger;", IAdInterListener.AdReqParam.WIDTH, "([JLl1/l;)Ljava/math/BigInteger;", "u", "([BLl1/l;)Ljava/math/BigInteger;", "x", "([SLl1/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12613pn = "kotlin.collections", m12611xs = "kotlin/collections/unsigned/UArraysKt")
/* renamed from: kotlin.collections.unsigned.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class _UArraysJvm {

    /* compiled from: _UArraysJvm.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, m12616d2 = {"kotlin/collections/unsigned/b$a", "Lkotlin/collections/d;", "Lkotlin/r0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(I)Z", "", "index", "c", "(I)I", "d", "e", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.unsigned.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14225a extends AbstractList<UInt> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ int[] f40976a;

        C14225a(int[] iArr) {
            this.f40976a = iArr;
        }

        /* renamed from: a */
        public boolean m9755a(int i) {
            return UIntArray.m7288g(this.f40976a, i);
        }

        /* renamed from: c */
        public int m9754c(int i) {
            return UIntArray.m7284k(this.f40976a, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof UInt) {
                return m9755a(((UInt) obj).m7679g0());
            }
            return false;
        }

        /* renamed from: d */
        public int m9753d(int i) {
            int m10531df;
            m10531df = _Arrays.m10531df(this.f40976a, i);
            return m10531df;
        }

        /* renamed from: e */
        public int m9752e(int i) {
            int m10405hh;
            m10405hh = _Arrays.m10405hh(this.f40976a, i);
            return m10405hh;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return UInt.m7690b(m9754c(i));
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return UIntArray.m7282m(this.f40976a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof UInt) {
                return m9753d(((UInt) obj).m7679g0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return UIntArray.m7279p(this.f40976a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof UInt) {
                return m9752e(((UInt) obj).m7679g0());
            }
            return -1;
        }
    }

    /* compiled from: _UArraysJvm.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"kotlin/collections/unsigned/b$b", "Lkotlin/collections/d;", "Lkotlin/v0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(J)Z", "", "index", "c", "(I)J", "d", "(J)I", "e", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.unsigned.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14226b extends AbstractList<ULong> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ long[] f40977a;

        C14226b(long[] jArr) {
            this.f40977a = jArr;
        }

        /* renamed from: a */
        public boolean m9751a(long j) {
            return ULongArray.m5828g(this.f40977a, j);
        }

        /* renamed from: c */
        public long m9750c(int i) {
            return ULongArray.m5824k(this.f40977a, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ULong) {
                return m9751a(((ULong) obj).m5890g0());
            }
            return false;
        }

        /* renamed from: d */
        public int m9749d(long j) {
            int m10500ef;
            m10500ef = _Arrays.m10500ef(this.f40977a, j);
            return m10500ef;
        }

        /* renamed from: e */
        public int m9748e(long j) {
            int m10374ih;
            m10374ih = _Arrays.m10374ih(this.f40977a, j);
            return m10374ih;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return ULong.m5901b(m9750c(i));
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return ULongArray.m5822m(this.f40977a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ULong) {
                return m9749d(((ULong) obj).m5890g0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ULongArray.m5819p(this.f40977a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ULong) {
                return m9748e(((ULong) obj).m5890g0());
            }
            return -1;
        }
    }

    /* compiled from: _UArraysJvm.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"kotlin/collections/unsigned/b$c", "Lkotlin/collections/d;", "Lkotlin/n0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(B)Z", "", "index", "c", "(I)B", "d", "(B)I", "e", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.unsigned.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14227c extends AbstractList<UByte> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ byte[] f40978a;

        C14227c(byte[] bArr) {
            this.f40978a = bArr;
        }

        /* renamed from: a */
        public boolean m9747a(byte b) {
            return UByteArray.m7752g(this.f40978a, b);
        }

        /* renamed from: c */
        public byte m9746c(int i) {
            return UByteArray.m7748k(this.f40978a, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof UByte) {
                return m9747a(((UByte) obj).m7780e0());
            }
            return false;
        }

        /* renamed from: d */
        public int m9745d(byte b) {
            int m10658Ze;
            m10658Ze = _Arrays.m10658Ze(this.f40978a, b);
            return m10658Ze;
        }

        /* renamed from: e */
        public int m9744e(byte b) {
            int m10529dh;
            m10529dh = _Arrays.m10529dh(this.f40978a, b);
            return m10529dh;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return UByte.m7787b(m9746c(i));
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return UByteArray.m7746m(this.f40978a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof UByte) {
                return m9745d(((UByte) obj).m7780e0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return UByteArray.m7743p(this.f40978a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof UByte) {
                return m9744e(((UByte) obj).m7780e0());
            }
            return -1;
        }
    }

    /* compiled from: _UArraysJvm.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"kotlin/collections/unsigned/b$d", "Lkotlin/collections/d;", "Lkotlin/b1;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(S)Z", "", "index", "c", "(I)S", "d", "(S)I", "e", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.unsigned.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14228d extends AbstractList<UShort> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ short[] f40979a;

        C14228d(short[] sArr) {
            this.f40979a = sArr;
        }

        /* renamed from: a */
        public boolean m9743a(short s) {
            return UShortArray.m12496g(this.f40979a, s);
        }

        /* renamed from: c */
        public short m9742c(int i) {
            return UShortArray.m12492k(this.f40979a, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof UShort) {
                return m9743a(((UShort) obj).m12532e0());
            }
            return false;
        }

        /* renamed from: d */
        public int m9741d(short s) {
            int m10438gf;
            m10438gf = _Arrays.m10438gf(this.f40979a, s);
            return m10438gf;
        }

        /* renamed from: e */
        public int m9740e(short s) {
            int m10312kh;
            m10312kh = _Arrays.m10312kh(this.f40979a, s);
            return m10312kh;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return UShort.m12539b(m9742c(i));
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return UShortArray.m12490m(this.f40979a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof UShort) {
                return m9741d(((UShort) obj).m12532e0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return UShortArray.m12487p(this.f40979a);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof UShort) {
                return m9740e(((UShort) obj).m12532e0());
            }
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: a */
    public static final List<UInt> m9779a(@NotNull int[] asList) {
        C14342f0.m8184p(asList, "$this$asList");
        return new C14225a(asList);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: b */
    public static final List<UByte> m9778b(@NotNull byte[] asList) {
        C14342f0.m8184p(asList, "$this$asList");
        return new C14227c(asList);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: c */
    public static final List<ULong> m9777c(@NotNull long[] asList) {
        C14342f0.m8184p(asList, "$this$asList");
        return new C14226b(asList);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: d */
    public static final List<UShort> m9776d(@NotNull short[] asList) {
        C14342f0.m8184p(asList, "$this$asList");
        return new C14228d(asList);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    /* renamed from: e */
    public static final int m9775e(@NotNull int[] binarySearch, int i, int i2, int i3) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        AbstractList.Companion.m12302d(i2, i3, UIntArray.m7282m(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int m8561c = UnsignedUtils.m8561c(binarySearch[i5], i);
            if (m8561c < 0) {
                i2 = i5 + 1;
            } else if (m8561c <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: f */
    public static /* synthetic */ int m9774f(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m7282m(iArr);
        }
        return m9775e(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    /* renamed from: g */
    public static final int m9773g(@NotNull short[] binarySearch, short s, int i, int i2) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        AbstractList.Companion.m12302d(i, i2, UShortArray.m12490m(binarySearch));
        int i3 = s & UShort.f40820c;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int m8561c = UnsignedUtils.m8561c(binarySearch[i5], i3);
            if (m8561c < 0) {
                i = i5 + 1;
            } else if (m8561c <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: h */
    public static /* synthetic */ int m9772h(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m12490m(sArr);
        }
        return m9773g(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    /* renamed from: i */
    public static final int m9771i(@NotNull long[] binarySearch, long j, int i, int i2) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        AbstractList.Companion.m12302d(i, i2, ULongArray.m5822m(binarySearch));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int m8557g = UnsignedUtils.m8557g(binarySearch[i4], j);
            if (m8557g < 0) {
                i = i4 + 1;
            } else if (m8557g <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: j */
    public static /* synthetic */ int m9770j(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m5822m(jArr);
        }
        return m9771i(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    /* renamed from: k */
    public static final int m9769k(@NotNull byte[] binarySearch, byte b, int i, int i2) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        AbstractList.Companion.m12302d(i, i2, UByteArray.m7746m(binarySearch));
        int i3 = b & UByte.f41242c;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int m8561c = UnsignedUtils.m8561c(binarySearch[i5], i3);
            if (m8561c < 0) {
                i = i5 + 1;
            } else if (m8561c <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: l */
    public static /* synthetic */ int m9768l(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7746m(bArr);
        }
        return m9769k(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: m */
    private static final byte m9767m(byte[] bArr, int i) {
        return UByteArray.m7748k(bArr, i);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: n */
    private static final short m9766n(short[] sArr, int i) {
        return UShortArray.m12492k(sArr, i);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: o */
    private static final int m9765o(int[] iArr, int i) {
        return UIntArray.m7284k(iArr, i);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: p */
    private static final long m9764p(long[] jArr, int i) {
        return ULongArray.m5824k(jArr, i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: q */
    private static final BigDecimal m9763q(byte[] bArr, InterfaceC15280l<? super UByte, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        for (byte b : bArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UByte.m7787b(b)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: r */
    private static final BigDecimal m9762r(int[] iArr, InterfaceC15280l<? super UInt, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        for (int i : iArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UInt.m7690b(i)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: s */
    private static final BigDecimal m9761s(long[] jArr, InterfaceC15280l<? super ULong, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        for (long j : jArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(ULong.m5901b(j)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: t */
    private static final BigDecimal m9760t(short[] sArr, InterfaceC15280l<? super UShort, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        for (short s : sArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UShort.m12539b(s)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: u */
    private static final BigInteger m9759u(byte[] bArr, InterfaceC15280l<? super UByte, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        for (byte b : bArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UByte.m7787b(b)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: v */
    private static final BigInteger m9758v(int[] iArr, InterfaceC15280l<? super UInt, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        for (int i : iArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UInt.m7690b(i)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: w */
    private static final BigInteger m9757w(long[] jArr, InterfaceC15280l<? super ULong, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        for (long j : jArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(ULong.m5901b(j)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: x */
    private static final BigInteger m9756x(short[] sArr, InterfaceC15280l<? super UShort, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        for (short s : sArr) {
            valueOf = valueOf.add(interfaceC15280l.invoke(UShort.m12539b(s)));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
