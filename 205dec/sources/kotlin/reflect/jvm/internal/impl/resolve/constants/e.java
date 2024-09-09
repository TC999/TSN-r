package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends o<Character> {
    public e(char c4) {
        super(Character.valueOf(c4));
    }

    private final String b(char c4) {
        return c4 == '\b' ? "\\b" : c4 == '\t' ? "\\t" : c4 == '\n' ? "\\n" : c4 == '\f' ? "\\f" : c4 == '\r' ? "\\r" : c(c4) ? String.valueOf(c4) : "?";
    }

    private final boolean c(char c4) {
        byte type = (byte) Character.getType(c4);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(a().charValue()), b(a().charValue())}, 2));
        f0.o(format, "format(this, *args)");
        return format;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public m0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        m0 u3 = module.k().u();
        f0.o(u3, "module.builtIns.charType");
        return u3;
    }
}
