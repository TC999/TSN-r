package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14221u;
import kotlin.jvm.internal.C14342f0;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m12616d2 = {"Lkotlin/ranges/b;", "Lkotlin/collections/u;", "", "hasNext", "", "c", "", "a", "I", "finalElement", "b", "Z", "next", "d", "()I", "step", "first", "last", "<init>", "(CCI)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ProgressionIterators extends AbstractC14221u {

    /* renamed from: a */
    private final int f41280a;

    /* renamed from: b */
    private boolean f41281b;

    /* renamed from: c */
    private int f41282c;

    /* renamed from: d */
    private final int f41283d;

    public ProgressionIterators(char c, char c2, int i) {
        this.f41283d = i;
        this.f41280a = c2;
        boolean z = true;
        if (i <= 0 ? C14342f0.m8180t(c, c2) < 0 : C14342f0.m8180t(c, c2) > 0) {
            z = false;
        }
        this.f41281b = z;
        this.f41282c = z ? c : c2;
    }

    @Override // kotlin.collections.AbstractC14221u
    /* renamed from: c */
    public char mo6371c() {
        int i = this.f41282c;
        if (i == this.f41280a) {
            if (this.f41281b) {
                this.f41281b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f41282c = this.f41283d + i;
        }
        return (char) i;
    }

    /* renamed from: d */
    public final int m7623d() {
        return this.f41283d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41281b;
    }
}
