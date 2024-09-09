package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BinaryVersion.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final C1155a f57444f = new C1155a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final int[] f57445a;

    /* renamed from: b  reason: collision with root package name */
    private final int f57446b;

    /* renamed from: c  reason: collision with root package name */
    private final int f57447c;

    /* renamed from: d  reason: collision with root package name */
    private final int f57448d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f57449e;

    /* compiled from: BinaryVersion.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1155a {
        private C1155a() {
        }

        public /* synthetic */ C1155a(u uVar) {
            this();
        }
    }

    public a(@NotNull int... numbers) {
        Integer ke;
        Integer ke2;
        Integer ke3;
        List<Integer> F;
        List r3;
        f0.p(numbers, "numbers");
        this.f57445a = numbers;
        ke = p.ke(numbers, 0);
        this.f57446b = ke == null ? -1 : ke.intValue();
        ke2 = p.ke(numbers, 1);
        this.f57447c = ke2 == null ? -1 : ke2.intValue();
        ke3 = p.ke(numbers, 2);
        this.f57448d = ke3 != null ? ke3.intValue() : -1;
        if (numbers.length > 3) {
            r3 = o.r(numbers);
            F = kotlin.collections.f0.G5(r3.subList(3, numbers.length));
        } else {
            F = CollectionsKt__CollectionsKt.F();
        }
        this.f57449e = F;
    }

    public final int a() {
        return this.f57446b;
    }

    public final int b() {
        return this.f57447c;
    }

    public final boolean c(int i4, int i5, int i6) {
        int i7 = this.f57446b;
        if (i7 > i4) {
            return true;
        }
        if (i7 < i4) {
            return false;
        }
        int i8 = this.f57447c;
        if (i8 > i5) {
            return true;
        }
        return i8 >= i5 && this.f57448d >= i6;
    }

    public final boolean d(@NotNull a version) {
        f0.p(version, "version");
        return c(version.f57446b, version.f57447c, version.f57448d);
    }

    public final boolean e(int i4, int i5, int i6) {
        int i7 = this.f57446b;
        if (i7 < i4) {
            return true;
        }
        if (i7 > i4) {
            return false;
        }
        int i8 = this.f57447c;
        if (i8 < i5) {
            return true;
        }
        return i8 <= i5 && this.f57448d <= i6;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && f0.g(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.f57446b == aVar.f57446b && this.f57447c == aVar.f57447c && this.f57448d == aVar.f57448d && f0.g(this.f57449e, aVar.f57449e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f(@NotNull a ourVersion) {
        f0.p(ourVersion, "ourVersion");
        int i4 = this.f57446b;
        if (i4 == 0) {
            if (ourVersion.f57446b == 0 && this.f57447c == ourVersion.f57447c) {
                return true;
            }
        } else if (i4 == ourVersion.f57446b && this.f57447c <= ourVersion.f57447c) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] g() {
        return this.f57445a;
    }

    public int hashCode() {
        int i4 = this.f57446b;
        int i5 = i4 + (i4 * 31) + this.f57447c;
        int i6 = i5 + (i5 * 31) + this.f57448d;
        return i6 + (i6 * 31) + this.f57449e.hashCode();
    }

    @NotNull
    public String toString() {
        String X2;
        int[] g4 = g();
        ArrayList arrayList = new ArrayList();
        int length = g4.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = g4[i4];
            i4++;
            if (!(i5 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i5));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        X2 = kotlin.collections.f0.X2(arrayList, ".", null, null, 0, null, null, 62, null);
        return X2;
    }
}
