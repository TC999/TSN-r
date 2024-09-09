package com.bumptech.glide.annotation.compiler;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/* compiled from: GlideAnnotationProcessor.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class d extends AbstractProcessor {

    /* renamed from: a  reason: collision with root package name */
    private i f16472a;

    /* renamed from: b  reason: collision with root package name */
    private h f16473b;

    /* renamed from: c  reason: collision with root package name */
    private b f16474c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16475d;

    /* renamed from: e  reason: collision with root package name */
    private c f16476e;

    public Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f16473b.a());
        hashSet.addAll(this.f16476e.a());
        return hashSet;
    }

    public SourceVersion b() {
        return SourceVersion.latestSupported();
    }

    public synchronized void c(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        i iVar = new i(processingEnvironment);
        this.f16472a = iVar;
        g gVar = new g(iVar);
        this.f16473b = new h(this.f16472a, gVar);
        this.f16474c = new b(processingEnvironment, this.f16472a);
        this.f16476e = new c(processingEnvironment, this.f16472a, gVar);
    }

    public boolean d(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        this.f16472a.K();
        boolean b4 = this.f16473b.b(roundEnvironment);
        boolean b5 = this.f16476e.b(roundEnvironment);
        this.f16474c.d(set, roundEnvironment);
        if (!b5 && !b4) {
            if (!this.f16475d) {
                this.f16475d = this.f16474c.c();
            }
            return true;
        } else if (this.f16475d) {
            throw new IllegalStateException("Cannot process annotations after writing AppGlideModule");
        } else {
            return true;
        }
    }
}
