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
import pl.droidsonroids.gif.annotations.Beta;
import pl.droidsonroids.gif.g;
import pl.droidsonroids.gif.l;

/* compiled from: GifDrawableInit.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class g<T extends g<T>> {

    /* renamed from: a  reason: collision with root package name */
    private l f61848a;

    /* renamed from: b  reason: collision with root package name */
    private e f61849b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f61850c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61851d = true;

    /* renamed from: e  reason: collision with root package name */
    private h f61852e = new h();

    public e a() throws IOException {
        l lVar = this.f61848a;
        if (lVar != null) {
            return lVar.a(this.f61849b, this.f61850c, this.f61851d, this.f61852e);
        }
        throw new NullPointerException("Source is not set");
    }

    public T b(ContentResolver contentResolver, Uri uri) {
        this.f61848a = new l.j(contentResolver, uri);
        return t();
    }

    public T c(AssetFileDescriptor assetFileDescriptor) {
        this.f61848a = new l.b(assetFileDescriptor);
        return t();
    }

    public T d(AssetManager assetManager, String str) {
        this.f61848a = new l.c(assetManager, str);
        return t();
    }

    public T e(Resources resources, int i4) {
        this.f61848a = new l.i(resources, i4);
        return t();
    }

    public T f(File file) {
        this.f61848a = new l.g(file);
        return t();
    }

    public T g(FileDescriptor fileDescriptor) {
        this.f61848a = new l.f(fileDescriptor);
        return t();
    }

    public T h(InputStream inputStream) {
        this.f61848a = new l.h(inputStream);
        return t();
    }

    public T i(String str) {
        this.f61848a = new l.g(str);
        return t();
    }

    public T j(ByteBuffer byteBuffer) {
        this.f61848a = new l.e(byteBuffer);
        return t();
    }

    public T k(byte[] bArr) {
        this.f61848a = new l.d(bArr);
        return t();
    }

    public ScheduledThreadPoolExecutor l() {
        return this.f61850c;
    }

    public l m() {
        return this.f61848a;
    }

    public e n() {
        return this.f61849b;
    }

    public h o() {
        return this.f61852e;
    }

    public boolean p() {
        return this.f61851d;
    }

    @Beta
    public T q(@Nullable h hVar) {
        this.f61852e.b(hVar);
        return t();
    }

    public T r(boolean z3) {
        this.f61851d = z3;
        return t();
    }

    public T s(@IntRange(from = 1, to = 65535) int i4) {
        this.f61852e.d(i4);
        return t();
    }

    protected abstract T t();

    public T u(boolean z3) {
        return r(z3);
    }

    public T v(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f61850c = scheduledThreadPoolExecutor;
        return t();
    }

    public T w(int i4) {
        this.f61850c = new ScheduledThreadPoolExecutor(i4);
        return t();
    }

    public T x(e eVar) {
        this.f61849b = eVar;
        return t();
    }
}
