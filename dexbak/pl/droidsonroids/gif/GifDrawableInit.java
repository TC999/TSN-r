package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import pl.droidsonroids.gif.GifDrawableInit;
import pl.droidsonroids.gif.InputSource;
import pl.droidsonroids.gif.annotations.Beta;

/* renamed from: pl.droidsonroids.gif.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class GifDrawableInit<T extends GifDrawableInit<T>> {

    /* renamed from: a */
    private InputSource f44435a;

    /* renamed from: b */
    private GifDrawable f44436b;

    /* renamed from: c */
    private ScheduledThreadPoolExecutor f44437c;

    /* renamed from: d */
    private boolean f44438d = true;

    /* renamed from: e */
    private C15443h f44439e = new C15443h();

    /* renamed from: a */
    public GifDrawable m2419a() throws IOException {
        InputSource inputSource = this.f44435a;
        if (inputSource != null) {
            return inputSource.m2370a(this.f44436b, this.f44437c, this.f44438d, this.f44439e);
        }
        throw new NullPointerException("Source is not set");
    }

    /* renamed from: b */
    public T m2418b(ContentResolver contentResolver, Uri uri) {
        this.f44435a = new InputSource.C15457j(contentResolver, uri);
        return mo2400t();
    }

    /* renamed from: c */
    public T m2417c(AssetFileDescriptor assetFileDescriptor) {
        this.f44435a = new InputSource.C15449b(assetFileDescriptor);
        return mo2400t();
    }

    /* renamed from: d */
    public T m2416d(AssetManager assetManager, String str) {
        this.f44435a = new InputSource.C15450c(assetManager, str);
        return mo2400t();
    }

    /* renamed from: e */
    public T m2415e(Resources resources, int i) {
        this.f44435a = new InputSource.C15456i(resources, i);
        return mo2400t();
    }

    /* renamed from: f */
    public T m2414f(File file) {
        this.f44435a = new InputSource.C15454g(file);
        return mo2400t();
    }

    /* renamed from: g */
    public T m2413g(FileDescriptor fileDescriptor) {
        this.f44435a = new InputSource.C15453f(fileDescriptor);
        return mo2400t();
    }

    /* renamed from: h */
    public T m2412h(InputStream inputStream) {
        this.f44435a = new InputSource.C15455h(inputStream);
        return mo2400t();
    }

    /* renamed from: i */
    public T m2411i(String str) {
        this.f44435a = new InputSource.C15454g(str);
        return mo2400t();
    }

    /* renamed from: j */
    public T m2410j(ByteBuffer byteBuffer) {
        this.f44435a = new InputSource.C15452e(byteBuffer);
        return mo2400t();
    }

    /* renamed from: k */
    public T m2409k(byte[] bArr) {
        this.f44435a = new InputSource.C15451d(bArr);
        return mo2400t();
    }

    /* renamed from: l */
    public ScheduledThreadPoolExecutor m2408l() {
        return this.f44437c;
    }

    /* renamed from: m */
    public InputSource m2407m() {
        return this.f44435a;
    }

    /* renamed from: n */
    public GifDrawable m2406n() {
        return this.f44436b;
    }

    /* renamed from: o */
    public C15443h m2405o() {
        return this.f44439e;
    }

    /* renamed from: p */
    public boolean m2404p() {
        return this.f44438d;
    }

    @Beta
    /* renamed from: q */
    public T m2403q(@Nullable C15443h c15443h) {
        this.f44439e.m2394b(c15443h);
        return mo2400t();
    }

    /* renamed from: r */
    public T m2402r(boolean z) {
        this.f44438d = z;
        return mo2400t();
    }

    /* renamed from: s */
    public T m2401s(@IntRange(from = 1, m60035to = 65535) int i) {
        this.f44439e.m2392d(i);
        return mo2400t();
    }

    /* renamed from: t */
    protected abstract T mo2400t();

    /* renamed from: u */
    public T m2399u(boolean z) {
        return m2402r(z);
    }

    /* renamed from: v */
    public T m2398v(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f44437c = scheduledThreadPoolExecutor;
        return mo2400t();
    }

    /* renamed from: w */
    public T m2397w(int i) {
        this.f44437c = new ScheduledThreadPoolExecutor(i);
        return mo2400t();
    }

    /* renamed from: x */
    public T m2396x(GifDrawable gifDrawable) {
        this.f44436b = gifDrawable;
        return mo2400t();
    }
}
