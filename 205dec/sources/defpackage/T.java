package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: T  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class T implements DexParser.Id {

    /* renamed from: a  reason: collision with root package name */
    public final int f58a;

    public T(int i4) {
        this.f58a = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f58a - ((DexParser.Id) obj).getId();
    }

    @Override // io.github.libxposed.api.utils.DexParser.Id
    public final int getId() {
        return this.f58a;
    }
}
