package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.text.Typography;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class GifInfoHandle {

    /* renamed from: a */
    private volatile long f44384a;

    static {
        LibraryLoader.m2366b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle() {
    }

    /* renamed from: O */
    private void m2523O(@IntRange(from = 0) int i) {
        int numberOfFrames = getNumberOfFrames(this.f44384a);
        if (i < 0 || i >= numberOfFrames) {
            throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + Typography.f41569e);
        }
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    @RequiresApi(21)
    /* renamed from: m */
    private static int m2510m(FileDescriptor fileDescriptor, boolean z) throws GifIOException, ErrnoException {
        try {
            int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
            return createTempNativeFileDescriptor;
        } finally {
            if (z) {
                Os.close(fileDescriptor);
            }
        }
    }

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    /* renamed from: x */
    private static long m2499x(FileDescriptor fileDescriptor, long j, boolean z) throws GifIOException {
        int m2510m;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                m2510m = m2510m(fileDescriptor, z);
            } catch (Exception e) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            m2510m = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(m2510m, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static GifInfoHandle m2498y(ContentResolver contentResolver, Uri uri) throws IOException {
        if (IDataSource.f43973c.equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public synchronized void m2537A() {
        free(this.f44384a);
        this.f44384a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public synchronized long m2536B(Bitmap bitmap) {
        return renderFrame(this.f44384a, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public synchronized boolean m2535C() {
        return reset(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public synchronized long m2534D() {
        return restoreRemainder(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: E */
    public synchronized int m2533E(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f44384a, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public synchronized void m2532F() {
        saveRemainder(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: G */
    public synchronized void m2531G(@IntRange(from = 0, m60035to = 2147483647L) int i, Bitmap bitmap) {
        seekToFrame(this.f44384a, i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: H */
    public void m2530H(@IntRange(from = 0) int i) {
        m2523O(i);
        seekToFrameGL(this.f44384a, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: I */
    public synchronized void m2529I(@IntRange(from = 0, m60035to = 2147483647L) int i, Bitmap bitmap) {
        seekToTime(this.f44384a, i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: J */
    public void m2528J(@IntRange(from = 0, m60035to = 65535) int i) {
        if (i >= 0 && i <= 65535) {
            synchronized (this) {
                setLoopCount(this.f44384a, (char) i);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: K */
    public void m2527K(char c, boolean z) {
        setOptions(this.f44384a, c, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: L */
    public void m2526L(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f > 0.0f && !Float.isNaN(f)) {
            if (f < 4.656613E-10f) {
                f = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.f44384a, f);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M */
    public void m2525M() {
        startDecoderThread(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N */
    public void m2524N() {
        stopDecoderThread(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2522a(Surface surface, long[] jArr) {
        bindSurface(this.f44384a, surface, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized long m2521b() {
        return getAllocationByteCount(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized String m2520c() {
        return getComment(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized int m2519d() {
        return getCurrentFrameIndex(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized int m2518e() {
        return getCurrentLoop(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized int m2517f() {
        return getCurrentPosition(this.f44384a);
    }

    protected void finalize() throws Throwable {
        try {
            m2537A();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public synchronized int m2516g() {
        return getDuration(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public synchronized int m2515h(@IntRange(from = 0) int i) {
        m2523O(i);
        return getFrameDuration(this.f44384a, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized int m2514i() {
        return getHeight(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public synchronized int m2513j() {
        return getLoopCount(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public synchronized long m2512k() {
        return getMetadataByteCount(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public synchronized int m2511l() {
        return getNativeErrorCode(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public synchronized int m2509n() {
        return getNumberOfFrames(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public synchronized long[] m2508o() {
        return getSavedState(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public synchronized long m2507p() {
        return getSourceLength(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public synchronized int m2506q() {
        return getWidth(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m2505r(int i, int i2) {
        glTexImage2D(this.f44384a, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public void m2504s(int i, int i2) {
        glTexSubImage2D(this.f44384a, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void m2503t() {
        initTexImageDescriptor(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public synchronized boolean m2502u() {
        return isAnimationCompleted(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public synchronized boolean m2501v() {
        return isOpaque(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public synchronized boolean m2500w() {
        return this.f44384a == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public synchronized void m2497z() {
        postUnbindSurface(this.f44384a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f44384a = m2499x(fileDescriptor, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f44384a = openByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f44384a = openDirectByteBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(String str) throws GifIOException {
        this.f44384a = openFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f44384a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f44384a = m2499x(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
