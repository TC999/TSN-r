package o2;

import org.jetbrains.annotations.NotNull;

/* compiled from: TargetPlatform.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f61575a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d f61576b;

    @NotNull
    public String a() {
        return b().getDescription();
    }

    @NotNull
    public d b() {
        return this.f61576b;
    }

    @NotNull
    public String toString() {
        String a4 = a();
        if (a4.length() > 0) {
            return this.f61575a + " (" + a4 + ')';
        }
        return this.f61575a;
    }
}
