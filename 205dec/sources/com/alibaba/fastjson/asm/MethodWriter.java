package com.alibaba.fastjson.asm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    final ClassWriter cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i4, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i4;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.exceptionCount = length;
        this.exceptions = new int[length];
        for (int i5 = 0; i5 < this.exceptionCount; i5++) {
            this.exceptions[i5] = classWriter.newClassItem(strArr[i5]).index;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getSize() {
        int i4;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i4 = this.code.length + 18 + 0 + 8;
        } else {
            i4 = 8;
        }
        if (this.exceptionCount > 0) {
            this.cw.newUTF8("Exceptions");
            return i4 + (this.exceptionCount * 2) + 8;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i4 = this.code.length > 0 ? 1 : 0;
        if (this.exceptionCount > 0) {
            i4++;
        }
        byteVector.putShort(i4);
        int i5 = this.code.length;
        if (i5 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i5 + 12 + 0);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            putInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i6 = 0; i6 < this.exceptionCount; i6++) {
                byteVector.putShort(this.exceptions[i6]);
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i4, String str, String str2, String str3) {
        this.code.put12(i4, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i4, int i5) {
        this.code.putByte(132).put11(i4, i5);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i4) {
        this.code.putByte(i4);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i4, int i5) {
        this.code.put11(i4, i5);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i4, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i4);
        ByteVector byteVector = this.code;
        label.put(this, byteVector, byteVector.length - 1);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i4 = newConstItem.index;
        int i5 = newConstItem.type;
        if (i5 == 5 || i5 == 6) {
            this.code.put12(20, i4);
        } else if (i4 >= 256) {
            this.code.put12(19, i4);
        } else {
            this.code.put11(18, i4);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i4, int i5) {
        this.maxStack = i4;
        this.maxLocals = i5;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i4, String str, String str2, String str3) {
        boolean z3 = i4 == 185;
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z3);
        int i5 = newMethodItem.intVal;
        if (z3) {
            if (i5 == 0) {
                i5 = Type.getArgumentsAndReturnSizes(str3);
                newMethodItem.intVal = i5;
            }
            this.code.put12(185, newMethodItem.index).put11(i5 >> 2, 0);
            return;
        }
        this.code.put12(i4, newMethodItem.index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i4, String str) {
        this.code.put12(i4, this.cw.newClassItem(str).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i4, int i5) {
        if (i5 < 4 && i4 != 169) {
            this.code.putByte((i4 < 54 ? ((i4 - 21) << 2) + 26 : ((i4 - 54) << 2) + 59) + i5);
        } else if (i5 >= 256) {
            this.code.putByte(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE).put12(i4, i5);
        } else {
            this.code.put11(i4, i5);
        }
    }
}
