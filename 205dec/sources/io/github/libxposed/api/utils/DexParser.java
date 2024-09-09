package io.github.libxposed.api.utils;

import java.io.Closeable;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface DexParser extends Closeable {
    public static final int NO_INDEX = -1;

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Annotation {
        Element[] getElements();

        TypeId getType();

        int getVisibility();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Array {
        Value[] getValues();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface ClassVisitor extends EarlyStopVisitor {
        MemberVisitor visit(int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, int[] iArr9, int[] iArr10);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface EarlyStopVisitor {
        boolean stop();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Element extends Value {
        StringId getName();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface FieldId extends Id {
        TypeId getDeclaringClass();

        StringId getName();

        TypeId getType();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface FieldVisitor extends MemberVisitor {
        void visit(int i4, int i5, int[] iArr);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Id extends Comparable {
        int getId();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface MemberVisitor extends EarlyStopVisitor {
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface MethodBodyVisitor {
        void visit(int i4, int i5, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, byte[] bArr);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface MethodId extends Id {
        TypeId getDeclaringClass();

        StringId getName();

        ProtoId getPrototype();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface MethodVisitor extends MemberVisitor {
        MethodBodyVisitor visit(int i4, int i5, boolean z3, int[] iArr, int[] iArr2);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface ProtoId extends Id {
        TypeId[] getParameters();

        TypeId getReturnType();

        StringId getShorty();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface StringId extends Id {
        String getString();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface TypeId extends Id {
        StringId getDescriptor();
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Value {
        byte[] getValue();

        int getValueType();
    }

    Annotation[] getAnnotations();

    Array[] getArrays();

    FieldId[] getFieldId();

    MethodId[] getMethodId();

    ProtoId[] getProtoId();

    StringId[] getStringId();

    TypeId[] getTypeId();

    void visitDefinedClasses(ClassVisitor classVisitor);
}
