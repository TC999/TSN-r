package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlideExtensionValidator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingEnvironment f16477a;

    /* renamed from: b  reason: collision with root package name */
    private final i f16478b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GlideExtensionValidator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<AnnotationMirror, String> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(AnnotationMirror annotationMirror) {
            return annotationMirror.getAnnotationType().asElement().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16477a = processingEnvironment;
        this.f16478b = iVar;
    }

    private static List<String> a(ExecutableElement executableElement, boolean z3) {
        List<VariableElement> parameters = executableElement.getParameters();
        if (z3) {
            parameters = parameters.subList(1, parameters.size());
        }
        ArrayList arrayList = new ArrayList(parameters.size());
        for (VariableElement variableElement : parameters) {
            arrayList.add(variableElement.asType().toString());
        }
        return arrayList;
    }

    private static String b(Element element) {
        return element.getEnclosingElement().toString();
    }

    private String c(ExecutableElement executableElement) {
        return this.f16478b.i(executableElement, GlideType.class).iterator().next();
    }

    private static String d(Element element) {
        return element.toString();
    }

    private static String e(ExecutableElement executableElement) {
        return b(executableElement) + "#" + d(executableElement);
    }

    private static boolean f(TypeMirror typeMirror) {
        return typeMirror.toString().equals("com.bumptech.glide.request.BaseRequestOptions<?>");
    }

    private boolean g(ExecutableElement executableElement) {
        TypeElement typeElement = this.f16477a.getElementUtils().getTypeElement("com.bumptech.glide.request.BaseRequestOptions");
        List<String> a4 = a(executableElement, true);
        String obj = executableElement.getSimpleName().toString();
        for (ExecutableElement executableElement2 : typeElement.getEnclosedElements()) {
            if (executableElement2.getKind() == ElementKind.METHOD) {
                ExecutableElement executableElement3 = executableElement2;
                if (obj.equals(executableElement3.getSimpleName().toString()) && a(executableElement3, false).equals(a4)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h(TypeMirror typeMirror) {
        return this.f16477a.getTypeUtils().erasure(typeMirror).toString().equals("com.bumptech.glide.RequestBuilder");
    }

    private boolean i(TypeMirror typeMirror, ExecutableElement executableElement) {
        if (typeMirror instanceof DeclaredType) {
            List typeArguments = ((DeclaredType) typeMirror).getTypeArguments();
            if (typeArguments.size() != 1) {
                return false;
            }
            return ((TypeMirror) typeArguments.get(0)).toString().equals(c(executableElement));
        }
        return false;
    }

    private void j(ExecutableElement executableElement) {
        boolean z3;
        ImmutableSet m4 = com.bumptech.glide.repackaged.com.google.common.collect.g.g(executableElement.getAnnotationMirrors()).n(new a()).m();
        Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.c> it = i.I().iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = true;
                break;
            } else if (m4.contains(it.next().D())) {
                z3 = false;
                break;
            }
        }
        if (z3) {
            Messager messager = this.f16477a.getMessager();
            Diagnostic.Kind kind = Diagnostic.Kind.WARNING;
            messager.printMessage(kind, e(executableElement) + " is missing the " + i.H().D() + " annotation, please add it to ensure that your extension methods are always returning non-null values");
        }
    }

    private static void l(Element element) {
        if (element.getModifiers().contains(Modifier.PRIVATE)) {
            if (((ExecutableElement) element).getParameters().isEmpty()) {
                return;
            }
            throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found parameters in the constructor of: " + b(element));
        }
        throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found a non-private constructor in: " + b(element));
    }

    private void m(ExecutableElement executableElement) {
        n(executableElement);
        p(executableElement);
        TypeMirror returnType = executableElement.getReturnType();
        if (f(returnType)) {
            o(executableElement);
            return;
        }
        throw new IllegalArgumentException("@GlideOption methods should return a BaseRequestOptions<?> object, but " + e(executableElement) + " returns " + returnType + ". If you're using old style @GlideOption methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void n(ExecutableElement executableElement) {
        j(executableElement);
    }

    private void o(ExecutableElement executableElement) {
        int w3 = this.f16478b.w(executableElement);
        boolean g4 = g(executableElement);
        if (g4 && w3 == 0) {
            throw new IllegalArgumentException("Accidentally attempting to override a method in BaseRequestOptions. Add an 'override' value in the @GlideOption annotation if this is intentional. Offending method: " + e(executableElement));
        } else if (g4 || w3 == 0) {
        } else {
            throw new IllegalArgumentException("Requested to override an existing method in BaseRequestOptions, but no such method was found. Offending method: " + e(executableElement));
        }
    }

    private static void p(ExecutableElement executableElement) {
        if (!executableElement.getParameters().isEmpty()) {
            TypeMirror asType = ((VariableElement) executableElement.getParameters().get(0)).asType();
            if (f(asType)) {
                return;
            }
            throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but the first parameter in " + e(executableElement) + " is " + asType);
        }
        throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but " + e(executableElement) + " has none");
    }

    private void q(ExecutableElement executableElement) {
        TypeMirror returnType = executableElement.getReturnType();
        r(executableElement);
        if (h(returnType) && i(returnType, executableElement)) {
            s(executableElement);
            return;
        }
        String c4 = c(executableElement);
        throw new IllegalArgumentException("@GlideType methods should return a RequestBuilder<" + c4 + "> object, but " + e(executableElement) + " returns: " + returnType + ". If you're using old style @GlideType methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void r(ExecutableElement executableElement) {
        j(executableElement);
    }

    private static void s(ExecutableElement executableElement) {
        if (executableElement.getParameters().size() == 1) {
            TypeMirror asType = ((VariableElement) executableElement.getParameters().get(0)).asType();
            if (asType.toString().startsWith("com.bumptech.glide.RequestBuilder")) {
                return;
            }
            throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given: " + asType + " for: " + e(executableElement));
        }
        throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given multiple for: " + e(executableElement));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(TypeElement typeElement) {
        if (typeElement.getModifiers().contains(Modifier.PUBLIC)) {
            for (Element element : typeElement.getEnclosedElements()) {
                if (element.getKind() == ElementKind.CONSTRUCTOR) {
                    l(element);
                } else if (element.getKind() == ElementKind.METHOD) {
                    ExecutableElement executableElement = (ExecutableElement) element;
                    if (executableElement.getAnnotation(GlideOption.class) != null) {
                        m(executableElement);
                    } else if (executableElement.getAnnotation(GlideType.class) != null) {
                        q(executableElement);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("RequestOptionsExtensions must be public, including: " + d(typeElement));
    }
}
