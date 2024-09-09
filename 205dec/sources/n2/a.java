package n2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.r0;
import kotlin.collections.y;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInsBinaryVersion.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.metadata.deserialization.a {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final C1246a f61495g = new C1246a(null);
    @JvmField
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final a f61496h = new a(1, 0, 7);
    @JvmField
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final a f61497i = new a(new int[0]);

    /* compiled from: BuiltInsBinaryVersion.kt */
    /* renamed from: n2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1246a {
        private C1246a() {
        }

        public /* synthetic */ C1246a(u uVar) {
            this();
        }

        @NotNull
        public final a a(@NotNull InputStream stream) {
            int Z;
            int[] F5;
            f0.p(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            k kVar = new k(1, dataInputStream.readInt());
            Z = y.Z(kVar, 10);
            ArrayList arrayList = new ArrayList(Z);
            Iterator<Integer> it = kVar.iterator();
            while (it.hasNext()) {
                ((r0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            F5 = kotlin.collections.f0.F5(arrayList);
            return new a(Arrays.copyOf(F5, F5.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        f0.p(numbers, "numbers");
    }

    public boolean h() {
        return f(f61496h);
    }
}
