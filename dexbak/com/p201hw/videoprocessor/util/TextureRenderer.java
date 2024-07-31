package com.p201hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(16)
/* renamed from: com.hw.videoprocessor.util.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TextureRenderer {

    /* renamed from: k */
    private static final int f24162k = 4;

    /* renamed from: l */
    private static final int f24163l = 20;

    /* renamed from: m */
    private static final int f24164m = 0;

    /* renamed from: n */
    private static final int f24165n = 3;

    /* renamed from: o */
    private static final float[] f24166o = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: p */
    private static final String f24167p = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: q */
    private static final String f24168q = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: a */
    private FloatBuffer f24169a;

    /* renamed from: d */
    private int f24172d;

    /* renamed from: f */
    private int f24174f;

    /* renamed from: g */
    private int f24175g;

    /* renamed from: h */
    private int f24176h;

    /* renamed from: i */
    private int f24177i;

    /* renamed from: j */
    private int f24178j;

    /* renamed from: b */
    private float[] f24170b = new float[16];

    /* renamed from: c */
    private float[] f24171c = new float[16];

    /* renamed from: e */
    private int f24173e = -12345;

    public TextureRenderer(int i) {
        this.f24178j = i;
        float[] fArr = f24166o;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f24169a = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f24171c, 0);
    }

    /* renamed from: c */
    private int m34855c(String str, String str2) {
        int m34852f;
        int m34852f2 = m34852f(35633, str);
        if (m34852f2 == 0 || (m34852f = m34852f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m34856b("glCreateProgram");
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, m34852f2);
        m34856b("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, m34852f);
        m34856b("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    /* renamed from: f */
    private int m34852f(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m34856b("glCreateShader type=" + i);
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

    /* renamed from: a */
    public void m34857a(String str) {
        GLES20.glDeleteProgram(this.f24172d);
        int m34855c = m34855c(f24167p, str);
        this.f24172d = m34855c;
        if (m34855c == 0) {
            throw new RuntimeException("failed creating program");
        }
    }

    /* renamed from: b */
    public void m34856b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    /* renamed from: d */
    public void m34854d(SurfaceTexture surfaceTexture, boolean z) {
        m34856b("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f24171c);
        if (z) {
            float[] fArr = this.f24171c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.f24172d);
        m34856b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f24173e);
        this.f24169a.position(0);
        GLES20.glVertexAttribPointer(this.f24176h, 3, 5126, false, 20, (Buffer) this.f24169a);
        m34856b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f24176h);
        m34856b("glEnableVertexAttribArray maPositionHandle");
        this.f24169a.position(3);
        GLES20.glVertexAttribPointer(this.f24177i, 2, 5126, false, 20, (Buffer) this.f24169a);
        m34856b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f24177i);
        m34856b("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f24175g, 1, false, this.f24171c, 0);
        GLES20.glUniformMatrix4fv(this.f24174f, 1, false, this.f24170b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m34856b("glDrawArrays");
        GLES20.glFinish();
    }

    /* renamed from: e */
    public int m34853e() {
        return this.f24173e;
    }

    /* renamed from: g */
    public void m34851g() {
        int m34855c = m34855c(f24167p, f24168q);
        this.f24172d = m34855c;
        if (m34855c != 0) {
            this.f24176h = GLES20.glGetAttribLocation(m34855c, "aPosition");
            m34856b("glGetAttribLocation aPosition");
            if (this.f24176h != -1) {
                this.f24177i = GLES20.glGetAttribLocation(this.f24172d, "aTextureCoord");
                m34856b("glGetAttribLocation aTextureCoord");
                if (this.f24177i != -1) {
                    this.f24174f = GLES20.glGetUniformLocation(this.f24172d, "uMVPMatrix");
                    m34856b("glGetUniformLocation uMVPMatrix");
                    if (this.f24174f != -1) {
                        this.f24175g = GLES20.glGetUniformLocation(this.f24172d, "uSTMatrix");
                        m34856b("glGetUniformLocation uSTMatrix");
                        if (this.f24175g != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i = iArr[0];
                            this.f24173e = i;
                            GLES20.glBindTexture(36197, i);
                            m34856b("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            m34856b("glTexParameter");
                            Matrix.setIdentityM(this.f24170b, 0);
                            int i2 = this.f24178j;
                            if (i2 != 0) {
                                Matrix.rotateM(this.f24170b, 0, i2, 0.0f, 0.0f, 1.0f);
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
