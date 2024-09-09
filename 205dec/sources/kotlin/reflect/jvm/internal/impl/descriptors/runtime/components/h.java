package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.f0;
import kotlin.text.w;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        String j22;
        String b4 = bVar.i().b();
        f0.o(b4, "relativeClassName.asString()");
        j22 = w.j2(b4, '.', '$', false, 4, null);
        if (bVar.h().d()) {
            return j22;
        }
        return bVar.h() + '.' + j22;
    }
}
