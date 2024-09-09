package cn.jpush.android.f;

import android.annotation.TargetApi;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4182a;

    /* renamed from: b  reason: collision with root package name */
    public long f4183b;

    public b(String str, long j4) {
        this.f4182a = str;
        this.f4183b = j4;
    }

    @TargetApi(19)
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f4183b == bVar.f4183b && androidx.core.graphics.a.a(this.f4182a, bVar.f4182a)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4182a, Long.valueOf(this.f4183b)});
    }
}
