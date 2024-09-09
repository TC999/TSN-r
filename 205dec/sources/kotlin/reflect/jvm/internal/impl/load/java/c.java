package kotlin.reflect.jvm.internal.impl.load.java;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return a.b().contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(dVar)) || dVar.getAnnotations().i(a.f());
    }
}
