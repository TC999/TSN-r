package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmPackagePartSource.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.d f57229b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.d f57230c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> f57231d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f57232e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final DeserializedContainerAbiStability f57233f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final p f57234g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f57235h;

    public j(@NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.d className, @Nullable kotlin.reflect.jvm.internal.impl.resolve.jvm.d dVar, @NotNull ProtoBuf.Package packageProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> rVar, boolean z3, @NotNull DeserializedContainerAbiStability abiStability, @Nullable p pVar) {
        f0.p(className, "className");
        f0.p(packageProto, "packageProto");
        f0.p(nameResolver, "nameResolver");
        f0.p(abiStability, "abiStability");
        this.f57229b = className;
        this.f57230c = dVar;
        this.f57231d = rVar;
        this.f57232e = z3;
        this.f57233f = abiStability;
        this.f57234g = pVar;
        GeneratedMessageLite.f<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.f57499m;
        f0.o(packageModuleName, "packageModuleName");
        Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(packageProto, packageModuleName);
        this.f57235h = num == null ? "main" : nameResolver.getString(num.intValue());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f
    @NotNull
    public String a() {
        return "Class '" + d().b().b() + '\'';
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    @NotNull
    public w0 b() {
        w0 NO_SOURCE_FILE = w0.f56635a;
        f0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b d() {
        return new kotlin.reflect.jvm.internal.impl.name.b(this.f57229b.g(), g());
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.d e() {
        return this.f57230c;
    }

    @Nullable
    public final p f() {
        return this.f57234g;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f g() {
        String s5;
        String f4 = this.f57229b.f();
        f0.o(f4, "className.internalName");
        s5 = kotlin.text.x.s5(f4, '/', null, 2, null);
        kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f(s5);
        f0.o(f5, "identifier(className.int\u2026.substringAfterLast('/'))");
        return f5;
    }

    @NotNull
    public String toString() {
        return ((Object) j.class.getSimpleName()) + ": " + this.f57229b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.p r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c r13, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            r9 = r11
            kotlin.jvm.internal.f0.p(r11, r0)
            java.lang.String r0 = "packageProto"
            r4 = r12
            kotlin.jvm.internal.f0.p(r12, r0)
            java.lang.String r0 = "nameResolver"
            r5 = r13
            kotlin.jvm.internal.f0.p(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            kotlin.jvm.internal.f0.p(r8, r0)
            kotlin.reflect.jvm.internal.impl.name.b r0 = r11.c()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.d r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.b(r0)
            java.lang.String r0 = "byClassId(kotlinClass.classId)"
            kotlin.jvm.internal.f0.o(r2, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.e()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 != 0) goto L33
        L31:
            r3 = r1
            goto L43
        L33:
            int r3 = r0.length()
            if (r3 <= 0) goto L3b
            r3 = 1
            goto L3c
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L31
            kotlin.reflect.jvm.internal.impl.resolve.jvm.d r1 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(r0)
            goto L31
        L43:
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.j.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.p, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c, kotlin.reflect.jvm.internal.impl.serialization.deserialization.r, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }
}
