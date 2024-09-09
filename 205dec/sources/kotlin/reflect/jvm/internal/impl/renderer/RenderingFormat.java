package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.b
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            f0.p(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.a
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            String k22;
            String k23;
            f0.p(string, "string");
            k22 = w.k2(string, "<", "&lt;", false, 4, null);
            k23 = w.k2(k22, ">", "&gt;", false, 4, null);
            return k23;
        }
    };

    /* synthetic */ RenderingFormat(u uVar) {
        this();
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
