package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* compiled from: LibraryModuleProcessor.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class h {

    /* renamed from: a  reason: collision with root package name */
    private final i f16488a;

    /* renamed from: b  reason: collision with root package name */
    private final g f16489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, g gVar) {
        this.f16488a = iVar;
        this.f16489b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> a() {
        return Collections.singleton(GlideModule.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RoundEnvironment roundEnvironment) {
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement : this.f16488a.t(GlideModule.class, roundEnvironment)) {
            if (!this.f16488a.C(typeElement)) {
                if (this.f16488a.E(typeElement)) {
                    arrayList.add(typeElement);
                } else {
                    throw new IllegalStateException("@GlideModule can only be applied to LibraryGlideModule and AppGlideModule implementations, not: " + typeElement);
                }
            }
        }
        i iVar = this.f16488a;
        iVar.f("got child modules: " + arrayList);
        if (arrayList.isEmpty()) {
            return false;
        }
        this.f16488a.M(this.f16489b.a(arrayList));
        this.f16488a.f("Wrote an Indexer this round, skipping the app module to ensure all indexers are found");
        return true;
    }
}
