package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections._ArraysJvm;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.InterfaceC15299e;
import p620m1.InterfaceC15300f;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001BBO\b\u0002\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u000008\u0012\u0006\u0010G\u001a\u00020\u0006\u0012\u0006\u0010H\u001a\u00020\u0006\u0012\u0006\u0010K\u001a\u00020\u000f\u0012\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\bS\u0010TB\t\b\u0016¢\u0006\u0004\bS\u0010UB\u0011\b\u0016\u0012\u0006\u0010V\u001a\u00020\u0006¢\u0006\u0004\bS\u0010WJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\u000f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0017\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J.\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\b\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\"\u0010\u0019J \u0010#\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010&J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010,\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010\u0014J\u0016\u0010.\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001e\u0010.\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0017\u00100\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0019J\u0017\u00101\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u0010-J\u0016\u00102\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u0016\u00103\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006H\u0016J)\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0001\u001072\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<08H\u0016¢\u0006\u0004\b:\u0010=J\u0013\u0010>\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010<H\u0096\u0002J\b\u0010?\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020@H\u0016R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u0000088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010FR\u0016\u0010K\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010R\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010Q¨\u0006X"}, m12616d2 = {"Lkotlin/collections/builders/b;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/g;", "", "minCapacity", "Lkotlin/f1;", "o", "m", "n", "p", "", AdnName.OTHER, "", "i", CampaignEx.JSON_KEY_AD_Q, "element", "k", "(ILjava/lang/Object;)V", "", "elements", "j", "r", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "s", "retain", UMCommonContent.f37782aL, C7304t.f25048d, "isEmpty", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "", "listIterator", "add", "(Ljava/lang/Object;)Z", "addAll", "clear", "c", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", ExifInterface.GPS_DIRECTION_TRUE, "", RtspHeaders.Values.DESTINATION, "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "equals", TTDownloadField.TT_HASHCODE, "", "toString", "a", "[Ljava/lang/Object;", "array", "b", "I", IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, "length", "d", "Z", "isReadOnly", "e", "Lkotlin/collections/builders/b;", "backing", "f", "root", "()I", "size", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/b;Lkotlin/collections/builders/b;)V", "()V", "initialCapacity", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.builders.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, InterfaceC15299e {

    /* renamed from: a */
    private E[] f40833a;

    /* renamed from: b */
    private int f40834b;

    /* renamed from: c */
    private int f40835c;

    /* renamed from: d */
    private boolean f40836d;

    /* renamed from: e */
    private final ListBuilder<E> f40837e;

    /* renamed from: f */
    private final ListBuilder<E> f40838f;

    /* compiled from: ListBuilder.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, m12616d2 = {"Lkotlin/collections/builders/b$a;", ExifInterface.LONGITUDE_EAST, "", "", "hasPrevious", "hasNext", "", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "Lkotlin/f1;", "set", "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/b;", "a", "Lkotlin/collections/builders/b;", "list", "b", "I", "index", "c", "lastIndex", "<init>", "(Lkotlin/collections/builders/b;I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14130a<E> implements ListIterator<E>, InterfaceC15300f {

        /* renamed from: a */
        private final ListBuilder<E> f40839a;

        /* renamed from: b */
        private int f40840b;

        /* renamed from: c */
        private int f40841c;

        public C14130a(@NotNull ListBuilder<E> list, int i) {
            C14342f0.m8184p(list, "list");
            this.f40839a = list;
            this.f40840b = i;
            this.f40841c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.f40839a;
            int i = this.f40840b;
            this.f40840b = i + 1;
            listBuilder.add(i, e);
            this.f40841c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f40840b < ((ListBuilder) this.f40839a).f40835c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f40840b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f40840b < ((ListBuilder) this.f40839a).f40835c) {
                int i = this.f40840b;
                this.f40840b = i + 1;
                this.f40841c = i;
                return (E) ((ListBuilder) this.f40839a).f40833a[((ListBuilder) this.f40839a).f40834b + this.f40841c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f40840b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i = this.f40840b;
            if (i > 0) {
                int i2 = i - 1;
                this.f40840b = i2;
                this.f40841c = i2;
                return (E) ((ListBuilder) this.f40839a).f40833a[((ListBuilder) this.f40839a).f40834b + this.f40841c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f40840b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.f40841c;
            if (i != -1) {
                this.f40839a.remove(i);
                this.f40840b = this.f40841c;
                this.f40841c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            int i = this.f40841c;
            if (i != -1) {
                this.f40839a.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f40833a = eArr;
        this.f40834b = i;
        this.f40835c = i2;
        this.f40836d = z;
        this.f40837e = listBuilder;
        this.f40838f = listBuilder2;
    }

    /* renamed from: j */
    private final void m12399j(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.f40837e;
        if (listBuilder != null) {
            listBuilder.m12399j(i, collection, i2);
            this.f40833a = this.f40837e.f40833a;
            this.f40835c += i2;
            return;
        }
        m12392q(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f40833a[i + i3] = it.next();
        }
    }

    /* renamed from: k */
    private final void m12398k(int i, E e) {
        ListBuilder<E> listBuilder = this.f40837e;
        if (listBuilder != null) {
            listBuilder.m12398k(i, e);
            this.f40833a = this.f40837e.f40833a;
            this.f40835c++;
            return;
        }
        m12392q(i, 1);
        this.f40833a[i] = e;
    }

    /* renamed from: m */
    private final void m12396m() {
        ListBuilder<E> listBuilder;
        if (this.f40836d || ((listBuilder = this.f40838f) != null && listBuilder.f40836d)) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: n */
    private final boolean m12395n(List<?> list) {
        boolean m12381h;
        m12381h = C14131c.m12381h(this.f40833a, this.f40834b, this.f40835c, list);
        return m12381h;
    }

    /* renamed from: o */
    private final void m12394o(int i) {
        if (this.f40837e == null) {
            E[] eArr = this.f40833a;
            if (i > eArr.length) {
                this.f40833a = (E[]) C14131c.m12384e(this.f40833a, ArrayDeque.f40908g.m11924a(eArr.length, i));
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: p */
    private final void m12393p(int i) {
        m12394o(this.f40835c + i);
    }

    /* renamed from: q */
    private final void m12392q(int i, int i2) {
        m12393p(i2);
        E[] eArr = this.f40833a;
        _ArraysJvm.m11625c1(eArr, eArr, i + i2, i, this.f40834b + this.f40835c);
        this.f40835c += i2;
    }

    /* renamed from: r */
    private final E m12391r(int i) {
        ListBuilder<E> listBuilder = this.f40837e;
        if (listBuilder != null) {
            this.f40835c--;
            return listBuilder.m12391r(i);
        }
        E[] eArr = this.f40833a;
        E e = eArr[i];
        _ArraysJvm.m11625c1(eArr, eArr, i, i + 1, this.f40834b + this.f40835c);
        C14131c.m12383f(this.f40833a, (this.f40834b + this.f40835c) - 1);
        this.f40835c--;
        return e;
    }

    /* renamed from: s */
    private final void m12390s(int i, int i2) {
        ListBuilder<E> listBuilder = this.f40837e;
        if (listBuilder != null) {
            listBuilder.m12390s(i, i2);
        } else {
            E[] eArr = this.f40833a;
            _ArraysJvm.m11625c1(eArr, eArr, i, i + i2, this.f40835c);
            E[] eArr2 = this.f40833a;
            int i3 = this.f40835c;
            C14131c.m12382g(eArr2, i3 - i2, i3);
        }
        this.f40835c -= i2;
    }

    /* renamed from: t */
    private final int m12389t(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.f40837e;
        if (listBuilder != null) {
            int m12389t = listBuilder.m12389t(i, i2, collection, z);
            this.f40835c -= m12389t;
            return m12389t;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.f40833a[i5]) == z) {
                E[] eArr = this.f40833a;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.f40833a;
        _ArraysJvm.m11625c1(eArr2, eArr2, i + i4, i2 + i, this.f40835c);
        E[] eArr3 = this.f40833a;
        int i7 = this.f40835c;
        C14131c.m12382g(eArr3, i7 - i6, i7);
        this.f40835c -= i6;
        return i6;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: a */
    public int mo11949a() {
        return this.f40835c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        m12396m();
        m12398k(this.f40834b + this.f40835c, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        m12396m();
        int size = elements.size();
        m12399j(this.f40834b + this.f40835c, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: c */
    public E mo11948c(int i) {
        m12396m();
        AbstractList.Companion.m12304b(i, this.f40835c);
        return m12391r(this.f40834b + i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        m12396m();
        m12390s(this.f40834b, this.f40835c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && m12395n((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.m12304b(i, this.f40835c);
        return this.f40833a[this.f40834b + i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int m12380i;
        m12380i = C14131c.m12380i(this.f40833a, this.f40834b, this.f40835c);
        return m12380i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.f40835c; i++) {
            if (C14342f0.m8193g(this.f40833a[this.f40834b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f40835c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new C14130a(this, 0);
    }

    @NotNull
    /* renamed from: l */
    public final List<E> m12397l() {
        if (this.f40837e == null) {
            m12396m();
            this.f40836d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.f40835c - 1; i >= 0; i--) {
            if (C14342f0.m8193g(this.f40833a[this.f40834b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new C14130a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        m12396m();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        m12396m();
        return m12389t(this.f40834b, this.f40835c, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        m12396m();
        return m12389t(this.f40834b, this.f40835c, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        m12396m();
        AbstractList.Companion.m12304b(i, this.f40835c);
        E[] eArr = this.f40833a;
        int i2 = this.f40834b;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i, int i2) {
        AbstractList.Companion.m12302d(i, i2, this.f40835c);
        E[] eArr = this.f40833a;
        int i3 = this.f40834b + i;
        int i4 = i2 - i;
        boolean z = this.f40836d;
        ListBuilder<E> listBuilder = this.f40838f;
        return new ListBuilder(eArr, i3, i4, z, this, listBuilder != null ? listBuilder : this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        C14342f0.m8184p(destination, "destination");
        int length = destination.length;
        int i = this.f40835c;
        if (length < i) {
            E[] eArr = this.f40833a;
            int i2 = this.f40834b;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            C14342f0.m8185o(tArr, "java.util.Arrays.copyOfR…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f40833a;
        if (eArr2 != null) {
            int i3 = this.f40834b;
            _ArraysJvm.m11625c1(eArr2, destination, 0, i3, i + i3);
            int length2 = destination.length;
            int i4 = this.f40835c;
            if (length2 > i4) {
                destination[i4] = null;
            }
            return destination;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        String m12379j;
        m12379j = C14131c.m12379j(this.f40833a, this.f40834b, this.f40835c);
        return m12379j;
    }

    public ListBuilder() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion.m12303c(i, this.f40835c);
        return new C14130a(this, i);
    }

    public ListBuilder(int i) {
        this(C14131c.m12385d(i), 0, 0, false, null, null);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        m12396m();
        AbstractList.Companion.m12303c(i, this.f40835c);
        m12398k(this.f40834b + i, e);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        m12396m();
        AbstractList.Companion.m12303c(i, this.f40835c);
        int size = elements.size();
        m12399j(this.f40834b + i, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        Object[] m11704M1;
        E[] eArr = this.f40833a;
        int i = this.f40834b;
        m11704M1 = _ArraysJvm.m11704M1(eArr, i, this.f40835c + i);
        if (m11704M1 != null) {
            return m11704M1;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
}
