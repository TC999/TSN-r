package cn.jiguang.ce;

import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f3324a = new d(new UUID(0, 0));

    /* renamed from: b  reason: collision with root package name */
    private final UUID f3325b;

    public d() {
        this(null);
    }

    public d(UUID uuid) {
        this.f3325b = uuid == null ? UUID.randomUUID() : uuid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && d.class == obj.getClass() && this.f3325b.compareTo(((d) obj).f3325b) == 0;
    }

    public int hashCode() {
        return this.f3325b.hashCode();
    }

    public String toString() {
        return this.f3325b.toString().replace("-", "");
    }
}
