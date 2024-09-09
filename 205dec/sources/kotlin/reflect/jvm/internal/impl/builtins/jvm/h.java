package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.k1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.load.kotlin.w;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmBuiltInsSignatures.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f56216a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f56217b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f56218c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f56219d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f56220e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f56221f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Set<String> f56222g;

    static {
        Set<String> D;
        Set C;
        Set C2;
        Set C3;
        Set C4;
        Set C5;
        Set<String> C6;
        Set C7;
        Set C8;
        Set C9;
        Set C10;
        Set C11;
        Set<String> C12;
        Set C13;
        Set<String> C14;
        Set C15;
        Set<String> C16;
        h hVar = new h();
        f56216a = hVar;
        w wVar = w.f57261a;
        D = k1.D(wVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f56217b = D;
        C = k1.C(hVar.b(), wVar.f("List", "sort(Ljava/util/Comparator;)V"));
        C2 = k1.C(C, wVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        C3 = k1.C(C2, wVar.e("Double", "isInfinite()Z", "isNaN()Z"));
        C4 = k1.C(C3, wVar.e("Float", "isInfinite()Z", "isNaN()Z"));
        C5 = k1.C(C4, wVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        C6 = k1.C(C5, wVar.e("CharSequence", "isEmpty()Z"));
        f56218c = C6;
        C7 = k1.C(wVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), wVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        C8 = k1.C(C7, wVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        C9 = k1.C(C8, wVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        C10 = k1.C(C9, wVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        C11 = k1.C(C10, wVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        C12 = k1.C(C11, wVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f56219d = C12;
        C13 = k1.C(wVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), wVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        C14 = k1.C(C13, wVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        f56220e = C14;
        Set<String> a4 = hVar.a();
        String[] b4 = wVar.b("D");
        C15 = k1.C(a4, wVar.e("Float", (String[]) Arrays.copyOf(b4, b4.length)));
        String[] b5 = wVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        C16 = k1.C(C15, wVar.e("String", (String[]) Arrays.copyOf(b5, b5.length)));
        f56221f = C16;
        String[] b6 = wVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f56222g = wVar.e("Throwable", (String[]) Arrays.copyOf(b6, b6.length));
    }

    private h() {
    }

    private final Set<String> a() {
        List<JvmPrimitiveType> M;
        w wVar = w.f57261a;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        M = CollectionsKt__CollectionsKt.M(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType2 : M) {
            String b4 = jvmPrimitiveType2.getWrapperFqName().g().b();
            f0.o(b4, "it.wrapperFqName.shortName().asString()");
            String[] b5 = wVar.b("Ljava/lang/String;");
            c0.o0(linkedHashSet, wVar.e(b4, (String[]) Arrays.copyOf(b5, b5.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        List<JvmPrimitiveType> M;
        w wVar = w.f57261a;
        M = CollectionsKt__CollectionsKt.M(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : M) {
            String b4 = jvmPrimitiveType.getWrapperFqName().g().b();
            f0.o(b4, "it.wrapperFqName.shortName().asString()");
            c0.o0(linkedHashSet, wVar.e(b4, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> c() {
        return f56217b;
    }

    @NotNull
    public final Set<String> d() {
        return f56221f;
    }

    @NotNull
    public final Set<String> e() {
        return f56218c;
    }

    @NotNull
    public final Set<String> f() {
        return f56220e;
    }

    @NotNull
    public final Set<String> g() {
        return f56222g;
    }

    @NotNull
    public final Set<String> h() {
        return f56219d;
    }

    public final boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        f0.p(fqName, "fqName");
        return f0.g(fqName, j.a.f56107i) || j.e(fqName);
    }

    public final boolean j(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        f0.p(fqName, "fqName");
        if (i(fqName)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.name.b o4 = c.f56159a.o(fqName);
        if (o4 == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(o4.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
