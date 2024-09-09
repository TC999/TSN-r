package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: W  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class W extends T implements DexParser.StringId {

    /* renamed from: b  reason: collision with root package name */
    public final String f68b;

    public W(int i4, Object obj) {
        super(i4);
        this.f68b = (String) obj;
    }

    @Override // io.github.libxposed.api.utils.DexParser.StringId
    public final String getString() {
        return this.f68b;
    }
}
