package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* compiled from: ExtensionProcessor.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final i f16469a;

    /* renamed from: b  reason: collision with root package name */
    private final g f16470b;

    /* renamed from: c  reason: collision with root package name */
    private final e f16471c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ProcessingEnvironment processingEnvironment, i iVar, g gVar) {
        this.f16469a = iVar;
        this.f16470b = gVar;
        this.f16471c = new e(processingEnvironment, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> a() {
        return Collections.singleton(GlideExtension.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RoundEnvironment roundEnvironment) {
        List<TypeElement> t3 = this.f16469a.t(GlideExtension.class, roundEnvironment);
        i iVar = this.f16469a;
        iVar.f("Processing types : " + t3);
        for (TypeElement typeElement : t3) {
            this.f16471c.k(typeElement);
            i iVar2 = this.f16469a;
            iVar2.f("Processing elements: " + typeElement.getEnclosedElements());
        }
        if (t3.isEmpty()) {
            return false;
        }
        this.f16469a.M(this.f16470b.a(t3));
        return true;
    }
}
