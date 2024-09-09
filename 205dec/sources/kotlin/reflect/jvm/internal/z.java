package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.o0;
import kotlin.reflect.KVariance;

/* compiled from: ReflectionFactoryImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class z extends o0 {
    public static void u() {
        g.a();
        x.a();
    }

    private static KDeclarationContainerImpl v(CallableReference callableReference) {
        kotlin.reflect.h owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : b.f55876d;
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.d a(Class cls) {
        return new h(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.d b(Class cls, String str) {
        return new h(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.i c(FunctionReference functionReference) {
        return new j(v(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.d d(Class cls) {
        return g.b(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.d e(Class cls, String str) {
        return g.b(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.h f(Class cls, String str) {
        return new n(cls, str);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.r g(kotlin.reflect.r rVar) {
        return d0.a(rVar);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.k h(MutablePropertyReference0 mutablePropertyReference0) {
        return new k(v(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.l i(MutablePropertyReference1 mutablePropertyReference1) {
        return new l(v(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.m j(MutablePropertyReference2 mutablePropertyReference2) {
        return new m(v(mutablePropertyReference2), mutablePropertyReference2.getName(), mutablePropertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.r k(kotlin.reflect.r rVar) {
        return d0.b(rVar);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.r l(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return d0.c(rVar, rVar2);
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.o m(PropertyReference0 propertyReference0) {
        return new p(v(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.p n(PropertyReference1 propertyReference1) {
        return new q(v(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.q o(PropertyReference2 propertyReference2) {
        return new r(v(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.o0
    public String p(kotlin.jvm.internal.b0 b0Var) {
        j c4;
        kotlin.reflect.i a4 = kotlin.reflect.jvm.e.a(b0Var);
        if (a4 != null && (c4 = f0.c(a4)) != null) {
            return a0.f55871a.e(c4.I());
        }
        return super.p(b0Var);
    }

    @Override // kotlin.jvm.internal.o0
    public String q(Lambda lambda) {
        return p(lambda);
    }

    @Override // kotlin.jvm.internal.o0
    public void r(kotlin.reflect.s sVar, List<kotlin.reflect.r> list) {
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.r s(kotlin.reflect.g gVar, List<kotlin.reflect.t> list, boolean z3) {
        return kotlin.reflect.full.e.b(gVar, list, z3, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.o0
    public kotlin.reflect.s t(Object obj, String str, KVariance kVariance, boolean z3) {
        List<kotlin.reflect.s> typeParameters;
        if (obj instanceof kotlin.reflect.d) {
            typeParameters = ((kotlin.reflect.d) obj).getTypeParameters();
        } else if (obj instanceof kotlin.reflect.c) {
            typeParameters = ((kotlin.reflect.c) obj).getTypeParameters();
        } else {
            throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
        }
        for (kotlin.reflect.s sVar : typeParameters) {
            if (sVar.getName().equals(str)) {
                return sVar;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }
}
