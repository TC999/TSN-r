package kotlin.p613io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, m12616d2 = {"Lkotlin/io/q;", "Lkotlin/sequences/m;", "", "", "iterator", "Ljava/io/BufferedReader;", "a", "Ljava/io/BufferedReader;", "reader", "<init>", "(Ljava/io/BufferedReader;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ReadWrite implements Sequence<String> {

    /* renamed from: a */
    private final BufferedReader f41108a;

    /* compiled from: ReadWrite.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, m12616d2 = {"kotlin/io/q$a", "", "", "", "hasNext", "a", "Ljava/lang/String;", "nextValue", "b", "Z", "done", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.q$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14331a implements Iterator<String>, KMarkers {

        /* renamed from: a */
        private String f41109a;

        /* renamed from: b */
        private boolean f41110b;

        C14331a() {
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f41109a;
                this.f41109a = null;
                C14342f0.m8187m(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41109a == null && !this.f41110b) {
                String readLine = ReadWrite.this.f41108a.readLine();
                this.f41109a = readLine;
                if (readLine == null) {
                    this.f41110b = true;
                }
            }
            return this.f41109a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ReadWrite(@NotNull BufferedReader reader) {
        C14342f0.m8184p(reader, "reader");
        this.f41108a = reader;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<String> iterator() {
        return new C14331a();
    }
}
