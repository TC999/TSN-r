package q2;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: SerializerExtensionProtocol.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f f62002a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Package, Integer> f62003b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> f62004c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> f62005d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> f62006e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f62007f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f62008g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f62009h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> f62010i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> f62011j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> f62012k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> f62013l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f62014m;

    public a(@NotNull f extensionRegistry, @NotNull GeneratedMessageLite.f<ProtoBuf.Package, Integer> packageFqName, @NotNull GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue, @NotNull GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation) {
        f0.p(extensionRegistry, "extensionRegistry");
        f0.p(packageFqName, "packageFqName");
        f0.p(constructorAnnotation, "constructorAnnotation");
        f0.p(classAnnotation, "classAnnotation");
        f0.p(functionAnnotation, "functionAnnotation");
        f0.p(propertyAnnotation, "propertyAnnotation");
        f0.p(propertyGetterAnnotation, "propertyGetterAnnotation");
        f0.p(propertySetterAnnotation, "propertySetterAnnotation");
        f0.p(enumEntryAnnotation, "enumEntryAnnotation");
        f0.p(compileTimeValue, "compileTimeValue");
        f0.p(parameterAnnotation, "parameterAnnotation");
        f0.p(typeAnnotation, "typeAnnotation");
        f0.p(typeParameterAnnotation, "typeParameterAnnotation");
        this.f62002a = extensionRegistry;
        this.f62003b = packageFqName;
        this.f62004c = constructorAnnotation;
        this.f62005d = classAnnotation;
        this.f62006e = functionAnnotation;
        this.f62007f = propertyAnnotation;
        this.f62008g = propertyGetterAnnotation;
        this.f62009h = propertySetterAnnotation;
        this.f62010i = enumEntryAnnotation;
        this.f62011j = compileTimeValue;
        this.f62012k = parameterAnnotation;
        this.f62013l = typeAnnotation;
        this.f62014m = typeParameterAnnotation;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> a() {
        return this.f62005d;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> b() {
        return this.f62011j;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> c() {
        return this.f62004c;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> d() {
        return this.f62010i;
    }

    @NotNull
    public final f e() {
        return this.f62002a;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> f() {
        return this.f62006e;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> g() {
        return this.f62012k;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> h() {
        return this.f62007f;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> i() {
        return this.f62008g;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> j() {
        return this.f62009h;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> k() {
        return this.f62013l;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> l() {
        return this.f62014m;
    }
}
