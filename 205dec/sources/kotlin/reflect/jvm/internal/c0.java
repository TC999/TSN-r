package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "", "b", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "signature", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Class;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Class;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<Class<?>, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55879a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(Class<?> it) {
            kotlin.jvm.internal.f0.o(it, "it");
            return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Method method) {
        String Ig;
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.f0.o(parameterTypes, "parameterTypes");
        Ig = kotlin.collections.p.Ig(parameterTypes, "", "(", ")", 0, null, a.f55879a, 24, null);
        sb.append(Ig);
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.f0.o(returnType, "returnType");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(returnType));
        return sb.toString();
    }
}
