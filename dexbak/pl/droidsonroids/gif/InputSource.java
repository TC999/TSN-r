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

/* renamed from: pl.droidsonroids.gif.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class InputSource {

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15449b extends InputSource {

        /* renamed from: a */
        private final AssetFileDescriptor f44450a;

        public C15449b(@NonNull AssetFileDescriptor assetFileDescriptor) {
            super();
            this.f44450a = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return new GifInfoHandle(this.f44450a);
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15450c extends InputSource {

        /* renamed from: a */
        private final AssetManager f44451a;

        /* renamed from: b */
        private final String f44452b;

        public C15450c(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.f44451a = assetManager;
            this.f44452b = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return new GifInfoHandle(this.f44451a.openFd(this.f44452b));
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15451d extends InputSource {

        /* renamed from: a */
        private final byte[] f44453a;

        public C15451d(@NonNull byte[] bArr) {
            super();
            this.f44453a = bArr;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws GifIOException {
            return new GifInfoHandle(this.f44453a);
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15452e extends InputSource {

        /* renamed from: a */
        private final ByteBuffer f44454a;

        public C15452e(@NonNull ByteBuffer byteBuffer) {
            super();
            this.f44454a = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws GifIOException {
            return new GifInfoHandle(this.f44454a);
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15453f extends InputSource {

        /* renamed from: a */
        private final FileDescriptor f44455a;

        public C15453f(@NonNull FileDescriptor fileDescriptor) {
            super();
            this.f44455a = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return new GifInfoHandle(this.f44455a);
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15455h extends InputSource {

        /* renamed from: a */
        private final InputStream f44457a;

        public C15455h(@NonNull InputStream inputStream) {
            super();
            this.f44457a = inputStream;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return new GifInfoHandle(this.f44457a);
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15456i extends InputSource {

        /* renamed from: a */
        private final Resources f44458a;

        /* renamed from: b */
        private final int f44459b;

        public C15456i(@NonNull Resources resources, @DrawableRes @RawRes int i) {
            super();
            this.f44458a = resources;
            this.f44459b = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return new GifInfoHandle(this.f44458a.openRawResourceFd(this.f44459b));
        }
    }

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15457j extends InputSource {

        /* renamed from: a */
        private final ContentResolver f44460a;

        /* renamed from: b */
        private final Uri f44461b;

        public C15457j(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
            super();
            this.f44460a = contentResolver;
            this.f44461b = uri;
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws IOException {
            return GifInfoHandle.m2498y(this.f44460a, this.f44461b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final GifDrawable m2370a(GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z, C15443h c15443h) throws IOException {
        return new GifDrawable(m2369b(c15443h), gifDrawable, scheduledThreadPoolExecutor, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final GifInfoHandle m2369b(@NonNull C15443h c15443h) throws IOException {
        GifInfoHandle mo2368c = mo2368c();
        mo2368c.m2527K(c15443h.f44440a, c15443h.f44441b);
        return mo2368c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract GifInfoHandle mo2368c() throws IOException;

    /* compiled from: InputSource.java */
    /* renamed from: pl.droidsonroids.gif.l$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15454g extends InputSource {

        /* renamed from: a */
        private final String f44456a;

        public C15454g(@NonNull File file) {
            super();
            this.f44456a = file.getPath();
        }

        @Override // pl.droidsonroids.gif.InputSource
        /* renamed from: c */
        GifInfoHandle mo2368c() throws GifIOException {
            return new GifInfoHandle(this.f44456a);
        }

        public C15454g(@NonNull String str) {
            super();
            this.f44456a = str;
        }
    }

    private InputSource() {
    }
}
