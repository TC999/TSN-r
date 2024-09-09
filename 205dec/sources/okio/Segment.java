package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Segment.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cB1\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0003\u001a\u00020\u0000J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lokio/Segment;", "", "sharedCopy", "unsharedCopy", "pop", "segment", "push", "", "byteCount", "split", "Lkotlin/f1;", "compact", "sink", "writeTo", "", "data", "[B", "pos", "I", "limit", "", "shared", "Z", "owner", "next", "Lokio/Segment;", "prev", "<init>", "()V", "([BIIZZ)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    @JvmField
    @NotNull
    public final byte[] data;
    @JvmField
    public int limit;
    @JvmField
    @Nullable
    public Segment next;
    @JvmField
    public boolean owner;
    @JvmField
    public int pos;
    @JvmField
    @Nullable
    public Segment prev;
    @JvmField
    public boolean shared;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Segment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i4 = 0;
        if (segment != this) {
            f0.m(segment);
            if (segment.owner) {
                int i5 = this.limit - this.pos;
                Segment segment2 = this.prev;
                f0.m(segment2);
                int i6 = 8192 - segment2.limit;
                Segment segment3 = this.prev;
                f0.m(segment3);
                if (!segment3.shared) {
                    Segment segment4 = this.prev;
                    f0.m(segment4);
                    i4 = segment4.pos;
                }
                if (i5 > i6 + i4) {
                    return;
                }
                Segment segment5 = this.prev;
                f0.m(segment5);
                writeTo(segment5, i5);
                pop();
                SegmentPool.recycle(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        f0.m(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        f0.m(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @NotNull
    public final Segment push(@NotNull Segment segment) {
        f0.p(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        f0.m(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @NotNull
    public final Segment split(int i4) {
        Segment take;
        if (i4 > 0 && i4 <= this.limit - this.pos) {
            if (i4 >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = take.data;
                int i5 = this.pos;
                o.f1(bArr, bArr2, 0, i5, i5 + i4, 2, null);
            }
            take.limit = take.pos + i4;
            this.pos += i4;
            Segment segment = this.prev;
            f0.m(segment);
            segment.push(take);
            return take;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment sink, int i4) {
        f0.p(sink, "sink");
        if (sink.owner) {
            int i5 = sink.limit;
            if (i5 + i4 > 8192) {
                if (!sink.shared) {
                    int i6 = sink.pos;
                    if ((i5 + i4) - i6 <= 8192) {
                        byte[] bArr = sink.data;
                        o.f1(bArr, bArr, 0, i6, i5, 2, null);
                        sink.limit -= sink.pos;
                        sink.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = sink.data;
            int i7 = sink.limit;
            int i8 = this.pos;
            o.W0(bArr2, bArr3, i7, i8, i8 + i4);
            sink.limit += i4;
            this.pos += i4;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(@NotNull byte[] data, int i4, int i5, boolean z3, boolean z4) {
        f0.p(data, "data");
        this.data = data;
        this.pos = i4;
        this.limit = i5;
        this.shared = z3;
        this.owner = z4;
    }
}
