package com.hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: TextureRenderer.java */
@TargetApi(16)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {

    /* renamed from: k  reason: collision with root package name */
    private static final int f37644k = 4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f37645l = 20;

    /* renamed from: m  reason: collision with root package name */
    private static final int f37646m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f37647n = 3;

    /* renamed from: o  reason: collision with root package name */
    private static final float[] f37648o = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: p  reason: collision with root package name */
    private static final String f37649p = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: q  reason: collision with root package name */
    private static final String f37650q = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: a  reason: collision with root package name */
    private FloatBuffer f37651a;

    /* renamed from: d  reason: collision with root package name */
    private int f37654d;

    /* renamed from: f  reason: collision with root package name */
    private int f37656f;

    /* renamed from: g  reason: collision with root package name */
    private int f37657g;

    /* renamed from: h  reason: collision with root package name */
    private int f37658h;

    /* renamed from: i  reason: collision with root package name */
    private int f37659i;

    /* renamed from: j  reason: collision with root package name */
    private int f37660j;

    /* renamed from: b  reason: collision with root package name */
    private float[] f37652b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private float[] f37653c = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private int f37655e = -12345;

    public h(int i4) {
        this.f37660j = i4;
        float[] fArr = f37648o;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f37651a = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f37653c, 0);
    }

    private int c(String str, String str2) {
        int f4;
        int f5 = f(35633, str);
        if (f5 == 0 || (f4 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        b("glCreateProgram");
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, f5);
        b("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f4);
        b("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private int f(int i4, String str) {
        int glCreateShader = GLES20.glCreateShader(i4);
        b("glCreateShader type=" + i4);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void a(String str) {
        GLES20.glDeleteProgram(this.f37654d);
        int c4 = c("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", str);
        this.f37654d = c4;
        if (c4 == 0) {
            throw new RuntimeException("failed creating program");
        }
    }

    public void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void d(SurfaceTexture surfaceTexture, boolean z3) {
        b("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f37653c);
        if (z3) {
            float[] fArr = this.f37653c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.f37654d);
        b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f37655e);
        this.f37651a.position(0);
        GLES20.glVertexAttribPointer(this.f37658h, 3, 5126, false, 20, (Buffer) this.f37651a);
        b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f37658h);
        b("glEnableVertexAttribArray maPositionHandle");
        this.f37651a.position(3);
        GLES20.glVertexAttribPointer(this.f37659i, 2, 5126, false, 20, (Buffer) this.f37651a);
        b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f37659i);
        b("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f37657g, 1, false, this.f37653c, 0);
        GLES20.glUniformMatrix4fv(this.f37656f, 1, false, this.f37652b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glFinish();
    }

    public int e() {
        return this.f37655e;
    }

    public void g() {
        int c4 = c("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f37654d = c4;
        if (c4 != 0) {
            this.f37658h = GLES20.glGetAttribLocation(c4, "aPosition");
            b("glGetAttribLocation aPosition");
            if (this.f37658h != -1) {
                this.f37659i = GLES20.glGetAttribLocation(this.f37654d, "aTextureCoord");
                b("glGetAttribLocation aTextureCoord");
                if (this.f37659i != -1) {
                    this.f37656f = GLES20.glGetUniformLocation(this.f37654d, "uMVPMatrix");
                    b("glGetUniformLocation uMVPMatrix");
                    if (this.f37656f != -1) {
                        this.f37657g = GLES20.glGetUniformLocation(this.f37654d, "uSTMatrix");
                        b("glGetUniformLocation uSTMatrix");
                        if (this.f37657g != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i4 = iArr[0];
                            this.f37655e = i4;
                            GLES20.glBindTexture(36197, i4);
                            b("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            b("glTexParameter");
                            Matrix.setIdentityM(this.f37652b, 0);
                            int i5 = this.f37660j;
                            if (i5 != 0) {
                                Matrix.rotateM(this.f37652b, 0, i5, 0.0f, 0.0f, 1.0f);
                                return;
                            }
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }
}
