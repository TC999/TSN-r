package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: InputSource.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class l {

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class b extends l {

        /* renamed from: a  reason: collision with root package name */
        private final AssetFileDescriptor f61863a;

        public b(@NonNull AssetFileDescriptor assetFileDescriptor) {
            super();
            this.f61863a = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f61863a);
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c extends l {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f61864a;

        /* renamed from: b  reason: collision with root package name */
        private final String f61865b;

        public c(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.f61864a = assetManager;
            this.f61865b = str;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f61864a.openFd(this.f61865b));
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class d extends l {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f61866a;

        public d(@NonNull byte[] bArr) {
            super();
            this.f61866a = bArr;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f61866a);
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e extends l {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f61867a;

        public e(@NonNull ByteBuffer byteBuffer) {
            super();
            this.f61867a = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f61867a);
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f extends l {

        /* renamed from: a  reason: collision with root package name */
        private final FileDescriptor f61868a;

        public f(@NonNull FileDescriptor fileDescriptor) {
            super();
            this.f61868a = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f61868a);
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class h extends l {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f61870a;

        public h(@NonNull InputStream inputStream) {
            super();
            this.f61870a = inputStream;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f61870a);
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class i extends l {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f61871a;

        /* renamed from: b  reason: collision with root package name */
        private final int f61872b;

        public i(@NonNull Resources resources, @DrawableRes @RawRes int i4) {
            super();
            this.f61871a = resources;
            this.f61872b = i4;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f61871a.openRawResourceFd(this.f61872b));
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class j extends l {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f61873a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f61874b;

        public j(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
            super();
            this.f61873a = contentResolver;
            this.f61874b = uri;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return GifInfoHandle.y(this.f61873a, this.f61874b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final pl.droidsonroids.gif.e a(pl.droidsonroids.gif.e eVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z3, pl.droidsonroids.gif.h hVar) throws IOException {
        return new pl.droidsonroids.gif.e(b(hVar), eVar, scheduledThreadPoolExecutor, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GifInfoHandle b(@NonNull pl.droidsonroids.gif.h hVar) throws IOException {
        GifInfoHandle c4 = c();
        c4.K(hVar.f61853a, hVar.f61854b);
        return c4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle c() throws IOException;

    /* compiled from: InputSource.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class g extends l {

        /* renamed from: a  reason: collision with root package name */
        private final String f61869a;

        public g(@NonNull File file) {
            super();
            this.f61869a = file.getPath();
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f61869a);
        }

        public g(@NonNull String str) {
            super();
            this.f61869a = str;
        }
    }

    private l() {
    }
}
