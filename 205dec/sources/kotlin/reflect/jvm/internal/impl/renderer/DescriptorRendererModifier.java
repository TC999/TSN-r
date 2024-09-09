package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.p;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    @NotNull
    public static final a Companion = new a(null);
    private final boolean includeByDefault;

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        Set<DescriptorRendererModifier> L5;
        Set<DescriptorRendererModifier> Gy;
        int i4 = 0;
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        int length = values.length;
        while (i4 < length) {
            DescriptorRendererModifier descriptorRendererModifier = values[i4];
            i4++;
            if (descriptorRendererModifier.getIncludeByDefault()) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        L5 = f0.L5(arrayList);
        ALL_EXCEPT_ANNOTATIONS = L5;
        Gy = p.Gy(values());
        ALL = Gy;
    }

    DescriptorRendererModifier(boolean z3) {
        this.includeByDefault = z3;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
