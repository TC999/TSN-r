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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class GifInfoHandle {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f61797a;

    static {
        n.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle() {
    }

    private void O(@IntRange(from = 0) int i4) {
        int numberOfFrames = getNumberOfFrames(this.f61797a);
        if (i4 < 0 || i4 >= numberOfFrames) {
            throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + '>');
        }
    }

    private static native void bindSurface(long j4, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z3) throws GifIOException;

    private static native void free(long j4);

    private static native long getAllocationByteCount(long j4);

    private static native String getComment(long j4);

    private static native int getCurrentFrameIndex(long j4);

    private static native int getCurrentLoop(long j4);

    private static native int getCurrentPosition(long j4);

    private static native int getDuration(long j4);

    private static native int getFrameDuration(long j4, int i4);

    private static native int getHeight(long j4);

    private static native int getLoopCount(long j4);

    private static native long getMetadataByteCount(long j4);

    private static native int getNativeErrorCode(long j4);

    private static native int getNumberOfFrames(long j4);

    private static native long[] getSavedState(long j4);

    private static native long getSourceLength(long j4);

    private static native int getWidth(long j4);

    private static native void glTexImage2D(long j4, int i4, int i5);

    private static native void glTexSubImage2D(long j4, int i4, int i5);

    private static native void initTexImageDescriptor(long j4);

    private static native boolean isAnimationCompleted(long j4);

    private static native boolean isOpaque(long j4);

    @RequiresApi(21)
    private static int m(FileDescriptor fileDescriptor, boolean z3) throws GifIOException, ErrnoException {
        try {
            int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
            return createTempNativeFileDescriptor;
        } finally {
            if (z3) {
                Os.close(fileDescriptor);
            }
        }
    }

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i4, long j4) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j4);

    private static native long renderFrame(long j4, Bitmap bitmap);

    private static native boolean reset(long j4);

    private static native long restoreRemainder(long j4);

    private static native int restoreSavedState(long j4, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j4);

    private static native void seekToFrame(long j4, int i4, Bitmap bitmap);

    private static native void seekToFrameGL(long j4, int i4);

    private static native void seekToTime(long j4, int i4, Bitmap bitmap);

    private static native void setLoopCount(long j4, char c4);

    private static native void setOptions(long j4, char c4, boolean z3);

    private static native void setSpeedFactor(long j4, float f4);

    private static native void startDecoderThread(long j4);

    private static native void stopDecoderThread(long j4);

    private static long x(FileDescriptor fileDescriptor, long j4, boolean z3) throws GifIOException {
        int m4;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                m4 = m(fileDescriptor, z3);
            } catch (Exception e4) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e4.getMessage());
            }
        } else {
            m4 = extractNativeFileDescriptor(fileDescriptor, z3);
        }
        return openNativeFileDescriptor(m4, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle y(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void A() {
        free(this.f61797a);
        this.f61797a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long B(Bitmap bitmap) {
        return renderFrame(this.f61797a, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean C() {
        return reset(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long D() {
        return restoreRemainder(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int E(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f61797a, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void F() {
        saveRemainder(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void G(@IntRange(from = 0, to = 2147483647L) int i4, Bitmap bitmap) {
        seekToFrame(this.f61797a, i4, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@IntRange(from = 0) int i4) {
        O(i4);
        seekToFrameGL(this.f61797a, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void I(@IntRange(from = 0, to = 2147483647L) int i4, Bitmap bitmap) {
        seekToTime(this.f61797a, i4, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(@IntRange(from = 0, to = 65535) int i4) {
        if (i4 >= 0 && i4 <= 65535) {
            synchronized (this) {
                setLoopCount(this.f61797a, (char) i4);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(char c4, boolean z3) {
        setOptions(this.f61797a, c4, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        if (f4 > 0.0f && !Float.isNaN(f4)) {
            if (f4 < 4.656613E-10f) {
                f4 = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.f61797a, f4);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        startDecoderThread(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        stopDecoderThread(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Surface surface, long[] jArr) {
        bindSurface(this.f61797a, surface, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long b() {
        return getAllocationByteCount(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String c() {
        return getComment(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int d() {
        return getCurrentFrameIndex(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int e() {
        return getCurrentLoop(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int f() {
        return getCurrentPosition(this.f61797a);
    }

    protected void finalize() throws Throwable {
        try {
            A();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int g() {
        return getDuration(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int h(@IntRange(from = 0) int i4) {
        O(i4);
        return getFrameDuration(this.f61797a, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int i() {
        return getHeight(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int j() {
        return getLoopCount(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long k() {
        return getMetadataByteCount(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int l() {
        return getNativeErrorCode(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int n() {
        return getNumberOfFrames(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long[] o() {
        return getSavedState(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long p() {
        return getSourceLength(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int q() {
        return getWidth(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i4, int i5) {
        glTexImage2D(this.f61797a, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i4, int i5) {
        glTexSubImage2D(this.f61797a, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        initTexImageDescriptor(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean u() {
        return isAnimationCompleted(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean v() {
        return isOpaque(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean w() {
        return this.f61797a == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void z() {
        postUnbindSurface(this.f61797a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f61797a = x(fileDescriptor, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f61797a = openByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f61797a = openDirectByteBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(String str) throws GifIOException {
        this.f61797a = openFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f61797a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f61797a = x(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
