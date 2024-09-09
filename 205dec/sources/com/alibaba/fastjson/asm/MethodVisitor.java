package com.alibaba.fastjson.asm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i4, String str, String str2, String str3);

    void visitIincInsn(int i4, int i5);

    void visitInsn(int i4);

    void visitIntInsn(int i4, int i5);

    void visitJumpInsn(int i4, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i4, int i5);

    void visitMethodInsn(int i4, String str, String str2, String str3);

    void visitTypeInsn(int i4, String str);

    void visitVarInsn(int i4, int i5);
}
