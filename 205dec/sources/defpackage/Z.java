package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.DexParserBridge;
import io.github.libxposed.api.utils.DexParser;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: Z  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class Z implements DexParser {

    /* renamed from: a  reason: collision with root package name */
    public long f89a;

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.StringId[] f90b;

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.TypeId[] f91c;

    /* renamed from: d  reason: collision with root package name */
    public final DexParser.ProtoId[] f92d;

    /* renamed from: e  reason: collision with root package name */
    public final DexParser.FieldId[] f93e;

    /* renamed from: f  reason: collision with root package name */
    public final DexParser.MethodId[] f94f;

    /* renamed from: g  reason: collision with root package name */
    public final DexParser.Annotation[] f95g;

    /* renamed from: h  reason: collision with root package name */
    public final DexParser.Array[] f96h;

    public Z(ByteBuffer byteBuffer, boolean z3) {
        Object obj;
        if (!byteBuffer.isDirect() || !byteBuffer.asReadOnlyBuffer().hasArray()) {
            ByteBuffer.allocateDirect(byteBuffer.capacity()).put(byteBuffer);
        }
        try {
            long[] jArr = new long[2];
            jArr[1] = z3 ? 1L : 0L;
            Object[] objArr = (Object[]) DexParserBridge.openDex(byteBuffer, jArr);
            int i4 = 0;
            this.f89a = jArr[0];
            Object[] objArr2 = (Object[]) objArr[0];
            this.f90b = new DexParser.StringId[objArr2.length];
            for (int i5 = 0; i5 < objArr2.length; i5++) {
                this.f90b[i5] = new W(i5, objArr2[i5]);
            }
            int[] iArr = (int[]) objArr[1];
            this.f91c = new DexParser.TypeId[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                this.f91c[i6] = new X(this, i6, iArr[i6]);
            }
            int[][] iArr2 = (int[][]) objArr[2];
            this.f92d = new DexParser.ProtoId[iArr2.length];
            for (int i7 = 0; i7 < iArr2.length; i7++) {
                this.f92d[i7] = new V(this, i7, iArr2[i7]);
            }
            int[] iArr3 = (int[]) objArr[3];
            this.f93e = new DexParser.FieldId[iArr3.length / 3];
            int i8 = 0;
            while (true) {
                DexParser.FieldId[] fieldIdArr = this.f93e;
                if (i8 >= fieldIdArr.length) {
                    break;
                }
                int i9 = i8 * 3;
                fieldIdArr[i8] = new S(this, i8, iArr3[i9], iArr3[i9 + 1], iArr3[i9 + 2]);
                i8++;
            }
            int[] iArr4 = (int[]) objArr[4];
            this.f94f = new DexParser.MethodId[iArr4.length / 3];
            int i10 = 0;
            while (true) {
                DexParser.MethodId[] methodIdArr = this.f94f;
                if (i10 >= methodIdArr.length / 3) {
                    break;
                }
                int i11 = i10 * 3;
                methodIdArr[i10] = new U(this, i10, iArr4[i11], iArr4[i11 + 1], iArr4[i11 + 2]);
                i10++;
            }
            Object obj2 = objArr[5];
            if (obj2 == null || (obj = objArr[6]) == null) {
                this.f95g = new DexParser.Annotation[0];
            } else {
                int[] iArr5 = (int[]) obj2;
                Object[] objArr3 = (Object[]) obj;
                this.f95g = new DexParser.Annotation[iArr5.length / 2];
                int i12 = 0;
                while (true) {
                    DexParser.Annotation[] annotationArr = this.f95g;
                    if (i12 >= annotationArr.length) {
                        break;
                    }
                    int i13 = i12 * 2;
                    int i14 = i13 + 1;
                    annotationArr[i12] = new O(this, iArr5[i13], iArr5[i14], (int[]) objArr3[i13], (Object[]) objArr3[i14]);
                    i12++;
                }
            }
            Object obj3 = objArr[7];
            if (obj3 == null) {
                this.f96h = new DexParser.Array[0];
                return;
            }
            Object[] objArr4 = (Object[]) obj3;
            this.f96h = new DexParser.Array[objArr4.length / 2];
            while (true) {
                DexParser.Array[] arrayArr = this.f96h;
                if (i4 >= arrayArr.length) {
                    return;
                }
                int i15 = i4 * 2;
                arrayArr[i4] = new P((int[]) objArr4[i15], (Object[]) objArr4[i15 + 1]);
                i4++;
            }
        } catch (Throwable th) {
            throw new IOException("Invalid dex file", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j4 = this.f89a;
        if (j4 != 0) {
            DexParserBridge.closeDex(j4);
            this.f89a = 0L;
        }
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.Annotation[] getAnnotations() {
        return this.f95g;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.Array[] getArrays() {
        return this.f96h;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.FieldId[] getFieldId() {
        return this.f93e;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.MethodId[] getMethodId() {
        return this.f94f;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.ProtoId[] getProtoId() {
        return this.f92d;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.StringId[] getStringId() {
        return this.f90b;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final DexParser.TypeId[] getTypeId() {
        return this.f91c;
    }

    @Override // io.github.libxposed.api.utils.DexParser
    public final synchronized void visitDefinedClasses(DexParser.ClassVisitor classVisitor) {
        if (this.f89a == 0) {
            throw new IllegalStateException("Closed");
        }
        DexParserBridge.visitClass(this.f89a, classVisitor, DexParser.FieldVisitor.class, DexParser.MethodVisitor.class, DexParser.ClassVisitor.class.getDeclaredMethods()[0], DexParser.FieldVisitor.class.getDeclaredMethods()[0], DexParser.MethodVisitor.class.getDeclaredMethods()[0], DexParser.MethodBodyVisitor.class.getDeclaredMethods()[0], DexParser.EarlyStopVisitor.class.getDeclaredMethods()[0]);
    }
}
