package kotlin.collections.unsigned;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.b1;
import kotlin.c1;
import kotlin.collections.p;
import kotlin.g1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.n0;
import kotlin.o0;
import kotlin.r0;
import kotlin.s0;
import kotlin.v0;
import kotlin.w0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _UArraysJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012*\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012*\u00020\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012*\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\u00020\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u001e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010 \u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#\u001a2\u0010$\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%\u001a.\u0010)\u001a\u00020'*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010*\u001a.\u0010+\u001a\u00020'*\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020'*\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'0&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.\u001a.\u0010/\u001a\u00020'*\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020'0&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u00100\u001a.\u00102\u001a\u000201*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002010&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b2\u00103\u001a.\u00104\u001a\u000201*\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002010&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b4\u00105\u001a.\u00106\u001a\u000201*\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002010&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b6\u00107\u001a.\u00108\u001a\u000201*\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002010&H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b8\u00109\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006:"}, d2 = {"Lkotlin/s0;", "", "index", "Lkotlin/r0;", "o", "([II)I", "Lkotlin/w0;", "Lkotlin/v0;", "p", "([JI)J", "Lkotlin/o0;", "Lkotlin/n0;", "m", "([BI)B", "Lkotlin/c1;", "Lkotlin/b1;", "n", "([SI)S", "", "a", "([I)Ljava/util/List;", "c", "([J)Ljava/util/List;", "b", "([B)Ljava/util/List;", "d", "([S)Ljava/util/List;", "element", "fromIndex", "toIndex", "e", "([IIII)I", "i", "([JJII)I", "k", "([BBII)I", "g", "([SSII)I", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "r", "([ILd2/l;)Ljava/math/BigDecimal;", "s", "([JLd2/l;)Ljava/math/BigDecimal;", CampaignEx.JSON_KEY_AD_Q, "([BLd2/l;)Ljava/math/BigDecimal;", "t", "([SLd2/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "v", "([ILd2/l;)Ljava/math/BigInteger;", "w", "([JLd2/l;)Ljava/math/BigInteger;", "u", "([BLd2/l;)Ljava/math/BigInteger;", "x", "([SLd2/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, pn = "kotlin.collections", xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: _UArraysJvm.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0013"}, d2 = {"kotlin/collections/unsigned/b$a", "Lkotlin/collections/c;", "Lkotlin/r0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(I)Z", "", "index", "c", "(I)I", "g", "k", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.collections.c<r0> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f55450a;

        a(int[] iArr) {
            this.f55450a = iArr;
        }

        public boolean a(int i4) {
            return s0.m(this.f55450a, i4);
        }

        public int c(int i4) {
            return s0.q(this.f55450a, i4);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof r0) {
                return a(((r0) obj).l0());
            }
            return false;
        }

        public int g(int i4) {
            int df;
            df = p.df(this.f55450a, i4);
            return df;
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i4) {
            return r0.b(c(i4));
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return s0.s(this.f55450a);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof r0) {
                return g(((r0) obj).l0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return s0.w(this.f55450a);
        }

        public int k(int i4) {
            int hh;
            hh = p.hh(this.f55450a, i4);
            return hh;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof r0) {
                return k(((r0) obj).l0());
            }
            return -1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: _UArraysJvm.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"kotlin/collections/unsigned/b$b", "Lkotlin/collections/c;", "Lkotlin/v0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(J)Z", "", "index", "c", "(I)J", "g", "(J)I", "k", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.collections.unsigned.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1094b extends kotlin.collections.c<v0> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long[] f55451a;

        C1094b(long[] jArr) {
            this.f55451a = jArr;
        }

        public boolean a(long j4) {
            return w0.m(this.f55451a, j4);
        }

        public long c(int i4) {
            return w0.q(this.f55451a, i4);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof v0) {
                return a(((v0) obj).l0());
            }
            return false;
        }

        public int g(long j4) {
            int ef;
            ef = p.ef(this.f55451a, j4);
            return ef;
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i4) {
            return v0.b(c(i4));
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return w0.s(this.f55451a);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof v0) {
                return g(((v0) obj).l0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return w0.w(this.f55451a);
        }

        public int k(long j4) {
            int ih;
            ih = p.ih(this.f55451a, j4);
            return ih;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof v0) {
                return k(((v0) obj).l0());
            }
            return -1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: _UArraysJvm.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"kotlin/collections/unsigned/b$c", "Lkotlin/collections/c;", "Lkotlin/n0;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(B)Z", "", "index", "c", "(I)B", "g", "(B)I", "k", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends kotlin.collections.c<n0> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f55452a;

        c(byte[] bArr) {
            this.f55452a = bArr;
        }

        public boolean a(byte b4) {
            return o0.m(this.f55452a, b4);
        }

        public byte c(int i4) {
            return o0.q(this.f55452a, i4);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof n0) {
                return a(((n0) obj).j0());
            }
            return false;
        }

        public int g(byte b4) {
            int Ze;
            Ze = p.Ze(this.f55452a, b4);
            return Ze;
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i4) {
            return n0.b(c(i4));
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return o0.s(this.f55452a);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof n0) {
                return g(((n0) obj).j0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return o0.w(this.f55452a);
        }

        public int k(byte b4) {
            int dh;
            dh = p.dh(this.f55452a, b4);
            return dh;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof n0) {
                return k(((n0) obj).j0());
            }
            return -1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: _UArraysJvm.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"kotlin/collections/unsigned/b$d", "Lkotlin/collections/c;", "Lkotlin/b1;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "element", "a", "(S)Z", "", "index", "c", "(I)S", "g", "(S)I", "k", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends kotlin.collections.c<b1> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ short[] f55453a;

        d(short[] sArr) {
            this.f55453a = sArr;
        }

        public boolean a(short s3) {
            return c1.m(this.f55453a, s3);
        }

        public short c(int i4) {
            return c1.q(this.f55453a, i4);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof b1) {
                return a(((b1) obj).j0());
            }
            return false;
        }

        public int g(short s3) {
            int gf;
            gf = p.gf(this.f55453a, s3);
            return gf;
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i4) {
            return b1.b(c(i4));
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return c1.s(this.f55453a);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof b1) {
                return g(((b1) obj).j0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return c1.w(this.f55453a);
        }

        public int k(short s3) {
            int kh;
            kh = p.kh(this.f55453a, s3);
            return kh;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof b1) {
                return k(((b1) obj).j0());
            }
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<r0> a(@NotNull int[] asList) {
        f0.p(asList, "$this$asList");
        return new a(asList);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<n0> b(@NotNull byte[] asList) {
        f0.p(asList, "$this$asList");
        return new c(asList);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> c(@NotNull long[] asList) {
        f0.p(asList, "$this$asList");
        return new C1094b(asList);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<b1> d(@NotNull short[] asList) {
        f0.p(asList, "$this$asList");
        return new d(asList);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int e(@NotNull int[] binarySearch, int i4, int i5, int i6) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.Companion.d(i5, i6, s0.s(binarySearch));
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int c4 = g1.c(binarySearch[i8], i4);
            if (c4 < 0) {
                i5 = i8 + 1;
            } else if (c4 <= 0) {
                return i8;
            } else {
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = s0.s(iArr);
        }
        return e(iArr, i4, i5, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int g(@NotNull short[] binarySearch, short s3, int i4, int i5) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.Companion.d(i4, i5, c1.s(binarySearch));
        int i6 = s3 & 65535;
        int i7 = i5 - 1;
        while (i4 <= i7) {
            int i8 = (i4 + i7) >>> 1;
            int c4 = g1.c(binarySearch[i8], i6);
            if (c4 < 0) {
                i4 = i8 + 1;
            } else if (c4 <= 0) {
                return i8;
            } else {
                i7 = i8 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = c1.s(sArr);
        }
        return g(sArr, s3, i4, i5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int i(@NotNull long[] binarySearch, long j4, int i4, int i5) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.Companion.d(i4, i5, w0.s(binarySearch));
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int g4 = g1.g(binarySearch[i7], j4);
            if (g4 < 0) {
                i4 = i7 + 1;
            } else if (g4 <= 0) {
                return i7;
            } else {
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j4, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = w0.s(jArr);
        }
        return i(jArr, j4, i4, i5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int k(@NotNull byte[] binarySearch, byte b4, int i4, int i5) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.Companion.d(i4, i5, o0.s(binarySearch));
        int i6 = b4 & 255;
        int i7 = i5 - 1;
        while (i4 <= i7) {
            int i8 = (i4 + i7) >>> 1;
            int c4 = g1.c(binarySearch[i8], i6);
            if (c4 < 0) {
                i4 = i8 + 1;
            } else if (c4 <= 0) {
                return i8;
            } else {
                i7 = i8 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b4, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = o0.s(bArr);
        }
        return k(bArr, b4, i4, i5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte m(byte[] elementAt, int i4) {
        f0.p(elementAt, "$this$elementAt");
        return o0.q(elementAt, i4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short n(short[] elementAt, int i4) {
        f0.p(elementAt, "$this$elementAt");
        return c1.q(elementAt, i4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int o(int[] elementAt, int i4) {
        f0.p(elementAt, "$this$elementAt");
        return s0.q(elementAt, i4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long p(long[] elementAt, int i4) {
        f0.p(elementAt, "$this$elementAt");
        return w0.q(elementAt, i4);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal q(byte[] sumOf, l<? super n0, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<n0> x3 = o0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(n0.b(x3.next().j0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal r(int[] sumOf, l<? super r0, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<r0> x3 = s0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(r0.b(x3.next().l0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal s(long[] sumOf, l<? super v0, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<v0> x3 = w0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(v0.b(x3.next().l0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal t(short[] sumOf, l<? super b1, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<b1> x3 = c1.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(b1.b(x3.next().j0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger u(byte[] sumOf, l<? super n0, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<n0> x3 = o0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(n0.b(x3.next().j0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger v(int[] sumOf, l<? super r0, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<r0> x3 = s0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(r0.b(x3.next().l0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger w(long[] sumOf, l<? super v0, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<v0> x3 = w0.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(v0.b(x3.next().l0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger x(short[] sumOf, l<? super b1, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        Iterator<b1> x3 = c1.x(sumOf);
        while (x3.hasNext()) {
            valueOf = valueOf.add(selector.invoke(b1.b(x3.next().j0())));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
