package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B-\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002¨\u0006\f"}, m12616d2 = {"Lkotlin/sequences/j;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "", "iterator", "Lkotlin/Function0;", "getInitialValue", "Lkotlin/Function1;", "getNextValue", "<init>", "(Ll1/a;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14508j<T> implements Sequence<T> {

    /* renamed from: a */
    private final InterfaceC15269a<T> f41452a;

    /* renamed from: b */
    private final InterfaceC15280l<T, T> f41453b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R$\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m12616d2 = {"kotlin/sequences/j$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/lang/Object;", "c", "e", "(Ljava/lang/Object;)V", "nextItem", "", "b", "I", "d", "()I", "f", "(I)V", "nextState", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14509a implements Iterator<T>, KMarkers {
        @Nullable

        /* renamed from: a */
        private T f41454a;

        /* renamed from: b */
        private int f41455b = -2;

        C14509a() {
        }

        /* renamed from: a */
        private final void m7037a() {
            T t;
            if (this.f41455b == -2) {
                t = (T) C14508j.this.f41452a.invoke();
            } else {
                InterfaceC15280l interfaceC15280l = C14508j.this.f41453b;
                T t2 = this.f41454a;
                C14342f0.m8187m(t2);
                t = (T) interfaceC15280l.invoke(t2);
            }
            this.f41454a = t;
            this.f41455b = t == null ? 0 : 1;
        }

        @Nullable
        /* renamed from: c */
        public final T m7036c() {
            return this.f41454a;
        }

        /* renamed from: d */
        public final int m7035d() {
            return this.f41455b;
        }

        /* renamed from: e */
        public final void m7034e(@Nullable T t) {
            this.f41454a = t;
        }

        /* renamed from: f */
        public final void m7033f(int i) {
            this.f41455b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41455b < 0) {
                m7037a();
            }
            return this.f41455b == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.f41455b < 0) {
                m7037a();
            }
            if (this.f41455b != 0) {
                T t = this.f41454a;
                if (t != null) {
                    this.f41455b = -1;
                    return t;
                }
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14508j(@NotNull InterfaceC15269a<? extends T> getInitialValue, @NotNull InterfaceC15280l<? super T, ? extends T> getNextValue) {
        C14342f0.m8184p(getInitialValue, "getInitialValue");
        C14342f0.m8184p(getNextValue, "getNextValue");
        this.f41452a = getInitialValue;
        this.f41453b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14509a();
    }
}
