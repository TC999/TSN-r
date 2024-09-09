package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: SignatureBuildingComponents.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final w f57261a = new w();

    /* compiled from: SignatureBuildingComponents.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57262a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull String it) {
            f0.p(it, "it");
            return w.f57261a.c(it);
        }
    }

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() > 1) {
            return 'L' + str + ';';
        }
        return str;
    }

    @NotNull
    public final String[] b(@NotNull String... signatures) {
        f0.p(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        int length = signatures.length;
        int i4 = 0;
        while (i4 < length) {
            String str = signatures[i4];
            i4++;
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @NotNull
    public final Set<String> d(@NotNull String internalName, @NotNull String... signatures) {
        f0.p(internalName, "internalName");
        f0.p(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = signatures.length;
        int i4 = 0;
        while (i4 < length) {
            String str = signatures[i4];
            i4++;
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> e(@NotNull String name, @NotNull String... signatures) {
        f0.p(name, "name");
        f0.p(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final Set<String> f(@NotNull String name, @NotNull String... signatures) {
        f0.p(name, "name");
        f0.p(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final String g(@NotNull String name) {
        f0.p(name, "name");
        return f0.C("java/util/function/", name);
    }

    @NotNull
    public final String h(@NotNull String name) {
        f0.p(name, "name");
        return f0.C("java/lang/", name);
    }

    @NotNull
    public final String i(@NotNull String name) {
        f0.p(name, "name");
        return f0.C("java/util/", name);
    }

    @NotNull
    public final String j(@NotNull String name, @NotNull List<String> parameters, @NotNull String ret) {
        String X2;
        f0.p(name, "name");
        f0.p(parameters, "parameters");
        f0.p(ret, "ret");
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append('(');
        X2 = kotlin.collections.f0.X2(parameters, "", null, null, 0, null, a.f57262a, 30, null);
        sb.append(X2);
        sb.append(')');
        sb.append(c(ret));
        return sb.toString();
    }

    @NotNull
    public final String k(@NotNull String internalName, @NotNull String jvmDescriptor) {
        f0.p(internalName, "internalName");
        f0.p(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }
}
