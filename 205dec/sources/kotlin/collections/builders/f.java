package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.y0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0017\u0012\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/f;", "Ljava/io/Externalizable;", "", "readResolve", "Ljava/io/ObjectOutput;", "output", "Lkotlin/f1;", "writeExternal", "Ljava/io/ObjectInput;", "input", "readExternal", "", "a", "Ljava/util/Map;", "map", "<init>", "(Ljava/util/Map;)V", "()V", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class f implements Externalizable {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f55285b = new a(null);
    private static final long serialVersionUID = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private Map<?, ?> f55286a;

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/collections/builders/f$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public f(@NotNull Map<?, ?> map) {
        f0.p(map, "map");
        this.f55286a = map;
    }

    private final Object readResolve() {
        return this.f55286a;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        Map h4;
        Map<?, ?> d4;
        f0.p(input, "input");
        byte readByte = input.readByte();
        if (readByte == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                h4 = y0.h(readInt);
                int i4 = 0;
                while (i4 < readInt) {
                    i4++;
                    h4.put(input.readObject(), input.readObject());
                }
                f1 f1Var = f1.f55527a;
                d4 = y0.d(h4);
                this.f55286a = d4;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException(f0.C("Unsupported flags value: ", Integer.valueOf(readByte)));
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        f0.p(output, "output");
        output.writeByte(0);
        output.writeInt(this.f55286a.size());
        for (Map.Entry<?, ?> entry : this.f55286a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f() {
        /*
            r1 = this;
            java.util.Map r0 = kotlin.collections.w0.z()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.f.<init>():void");
    }
}
