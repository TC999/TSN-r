package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: GifDrawable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class e extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a  reason: collision with root package name */
    final ScheduledThreadPoolExecutor f61824a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f61825b;

    /* renamed from: c  reason: collision with root package name */
    long f61826c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f61827d;

    /* renamed from: e  reason: collision with root package name */
    protected final Paint f61828e;

    /* renamed from: f  reason: collision with root package name */
    final Bitmap f61829f;

    /* renamed from: g  reason: collision with root package name */
    final GifInfoHandle f61830g;

    /* renamed from: h  reason: collision with root package name */
    final ConcurrentLinkedQueue<pl.droidsonroids.gif.a> f61831h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f61832i;

    /* renamed from: j  reason: collision with root package name */
    private PorterDuffColorFilter f61833j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f61834k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f61835l;

    /* renamed from: m  reason: collision with root package name */
    final m f61836m;

    /* renamed from: n  reason: collision with root package name */
    private final q f61837n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f61838o;

    /* renamed from: p  reason: collision with root package name */
    ScheduledFuture<?> f61839p;

    /* renamed from: q  reason: collision with root package name */
    private int f61840q;

    /* renamed from: r  reason: collision with root package name */
    private int f61841r;

    /* renamed from: s  reason: collision with root package name */
    private h2.b f61842s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a extends s {
        a(e eVar) {
            super(eVar);
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            if (e.this.f61830g.C()) {
                e.this.start();
            }
        }
    }

    /* compiled from: GifDrawable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class b extends s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f61844b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e eVar, int i4) {
            super(eVar);
            this.f61844b = i4;
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            e eVar = e.this;
            eVar.f61830g.I(this.f61844b, eVar.f61829f);
            this.f61882a.f61836m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    /* compiled from: GifDrawable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class c extends s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f61846b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e eVar, int i4) {
            super(eVar);
            this.f61846b = i4;
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            e eVar = e.this;
            eVar.f61830g.G(this.f61846b, eVar.f61829f);
            e.this.f61836m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public e(@NonNull Resources resources, @DrawableRes @RawRes int i4) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i4));
        float b4 = k.b(resources, i4);
        this.f61841r = (int) (this.f61830g.i() * b4);
        this.f61840q = (int) (this.f61830g.q() * b4);
    }

    private void I() {
        this.f61825b = false;
        this.f61836m.removeMessages(-1);
        this.f61830g.A();
    }

    private PorterDuffColorFilter K(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void b() {
        ScheduledFuture<?> scheduledFuture = this.f61839p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f61836m.removeMessages(-1);
    }

    @Nullable
    public static e c(@NonNull Resources resources, @DrawableRes @RawRes int i4) {
        try {
            return new e(resources, i4);
        } catch (IOException unused) {
            return null;
        }
    }

    private void z() {
        if (this.f61835l && this.f61825b) {
            long j4 = this.f61826c;
            if (j4 != Long.MIN_VALUE) {
                long max = Math.max(0L, j4 - SystemClock.uptimeMillis());
                this.f61826c = Long.MIN_VALUE;
                this.f61824a.remove(this.f61837n);
                this.f61839p = this.f61824a.schedule(this.f61837n, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void A(@IntRange(from = 0, to = 2147483647L) int i4) {
        if (i4 >= 0) {
            synchronized (this.f61830g) {
                this.f61830g.I(i4, this.f61829f);
            }
            this.f61836m.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void B(@IntRange(from = 0, to = 2147483647L) int i4) {
        if (i4 >= 0) {
            this.f61824a.execute(new c(this, i4));
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap C(@IntRange(from = 0, to = 2147483647L) int i4) {
        Bitmap g4;
        if (i4 >= 0) {
            synchronized (this.f61830g) {
                this.f61830g.G(i4, this.f61829f);
                g4 = g();
            }
            this.f61836m.sendEmptyMessageAtTime(-1, 0L);
            return g4;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap D(@IntRange(from = 0, to = 2147483647L) int i4) {
        Bitmap g4;
        if (i4 >= 0) {
            synchronized (this.f61830g) {
                this.f61830g.I(i4, this.f61829f);
                g4 = g();
            }
            this.f61836m.sendEmptyMessageAtTime(-1, 0L);
            return g4;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [h2.a, h2.b] */
    public void E(@FloatRange(from = 0.0d) float f4) {
        ?? aVar = new h2.a(f4);
        this.f61842s = aVar;
        aVar.a(this.f61827d);
    }

    public void F(@IntRange(from = 0, to = 65535) int i4) {
        this.f61830g.J(i4);
    }

    public void G(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.f61830g.L(f4);
    }

    public void H(@Nullable h2.b bVar) {
        this.f61842s = bVar;
        if (bVar != null) {
            bVar.a(this.f61827d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(long j4) {
        if (this.f61835l) {
            this.f61826c = 0L;
            this.f61836m.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        b();
        this.f61839p = this.f61824a.schedule(this.f61837n, Math.max(j4, 0L), TimeUnit.MILLISECONDS);
    }

    public void a(@NonNull pl.droidsonroids.gif.a aVar) {
        this.f61831h.add(aVar);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return p() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return p() > 1;
    }

    public long d() {
        int k4;
        long b4 = this.f61830g.b();
        if (Build.VERSION.SDK_INT >= 19) {
            k4 = this.f61829f.getAllocationByteCount();
        } else {
            k4 = k();
        }
        return b4 + k4;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z3;
        if (this.f61833j == null || this.f61828e.getColorFilter() != null) {
            z3 = false;
        } else {
            this.f61828e.setColorFilter(this.f61833j);
            z3 = true;
        }
        h2.b bVar = this.f61842s;
        if (bVar == null) {
            canvas.drawBitmap(this.f61829f, this.f61838o, this.f61827d, this.f61828e);
        } else {
            bVar.b(canvas, this.f61828e, this.f61829f);
        }
        if (z3) {
            this.f61828e.setColorFilter(null);
        }
    }

    @Nullable
    public String e() {
        return this.f61830g.c();
    }

    @FloatRange(from = 0.0d)
    public float f() {
        h2.b bVar = this.f61842s;
        if (bVar instanceof h2.a) {
            return ((h2.a) bVar).d();
        }
        return 0.0f;
    }

    public Bitmap g() {
        Bitmap bitmap = this.f61829f;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), this.f61829f.isMutable());
        copy.setHasAlpha(this.f61829f.hasAlpha());
        return copy;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f61828e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f61828e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f61830g.f();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f61830g.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f61841r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f61840q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f61830g.v() || this.f61828e.getAlpha() < 255) ? -2 : -1;
    }

    public int h() {
        return this.f61830g.d();
    }

    public int i() {
        int e4 = this.f61830g.e();
        return (e4 == 0 || e4 < this.f61830g.j()) ? e4 : e4 - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        z();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f61825b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f61825b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f61832i) != null && colorStateList.isStateful());
    }

    @NonNull
    public GifError j() {
        return GifError.fromCode(this.f61830g.l());
    }

    public int k() {
        return this.f61829f.getRowBytes() * this.f61829f.getHeight();
    }

    public int l(@IntRange(from = 0) int i4) {
        return this.f61830g.h(i4);
    }

    public long m() {
        return this.f61830g.p();
    }

    public int n() {
        return this.f61830g.j();
    }

    public long o() {
        return this.f61830g.k();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f61827d.set(rect);
        h2.b bVar = this.f61842s;
        if (bVar != null) {
            bVar.a(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f61832i;
        if (colorStateList == null || (mode = this.f61834k) == null) {
            return false;
        }
        this.f61833j = K(colorStateList, mode);
        return true;
    }

    public int p() {
        return this.f61830g.n();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @NonNull
    public final Paint q() {
        return this.f61828e;
    }

    public int r(@IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        if (i4 < this.f61830g.q()) {
            if (i5 < this.f61830g.i()) {
                return this.f61829f.getPixel(i4, i5);
            }
            throw new IllegalArgumentException("y must be < height");
        }
        throw new IllegalArgumentException("x must be < width");
    }

    public void s(@NonNull int[] iArr) {
        this.f61829f.getPixels(iArr, 0, this.f61830g.q(), 0, 0, this.f61830g.q(), this.f61830g.i());
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) int i4) {
        if (i4 >= 0) {
            this.f61824a.execute(new b(this, i4));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i4) {
        this.f61828e.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f61828e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z3) {
        this.f61828e.setDither(z3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f61828e.setFilterBitmap(z3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f61832i = colorStateList;
        this.f61833j = K(colorStateList, this.f61834k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f61834k = mode;
        this.f61833j = K(this.f61832i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        if (!this.f61835l) {
            if (z3) {
                if (z4) {
                    y();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (this.f61825b) {
                return;
            }
            this.f61825b = true;
            J(this.f61830g.D());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.f61825b) {
                this.f61825b = false;
                b();
                this.f61830g.F();
            }
        }
    }

    @Nullable
    public h2.b t() {
        return this.f61842s;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f61830g.q()), Integer.valueOf(this.f61830g.i()), Integer.valueOf(this.f61830g.n()), Integer.valueOf(this.f61830g.l()));
    }

    public boolean u() {
        return this.f61830g.u();
    }

    public boolean v() {
        return this.f61830g.w();
    }

    public void w() {
        I();
        this.f61829f.recycle();
    }

    public boolean x(pl.droidsonroids.gif.a aVar) {
        return this.f61831h.remove(aVar);
    }

    public void y() {
        this.f61824a.execute(new a(this));
    }

    public e(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public e(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public e(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public e(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream), null, null, true);
    }

    public e(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public e(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor), null, null, true);
    }

    public e(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    public e(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer), null, null, true);
    }

    public e(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.y(contentResolver, uri), null, null, true);
    }

    protected e(@NonNull l lVar, @Nullable e eVar, @Nullable ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z3, @NonNull h hVar) throws IOException {
        this(lVar.b(hVar), eVar, scheduledThreadPoolExecutor, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GifInfoHandle gifInfoHandle, e eVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z3) {
        this.f61825b = true;
        this.f61826c = Long.MIN_VALUE;
        this.f61827d = new Rect();
        this.f61828e = new Paint(6);
        this.f61831h = new ConcurrentLinkedQueue<>();
        q qVar = new q(this);
        this.f61837n = qVar;
        this.f61835l = z3;
        this.f61824a = scheduledThreadPoolExecutor == null ? i.a() : scheduledThreadPoolExecutor;
        this.f61830g = gifInfoHandle;
        Bitmap bitmap = null;
        if (eVar != null) {
            synchronized (eVar.f61830g) {
                if (!eVar.f61830g.w() && eVar.f61830g.i() >= gifInfoHandle.i() && eVar.f61830g.q() >= gifInfoHandle.q()) {
                    eVar.I();
                    Bitmap bitmap2 = eVar.f61829f;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f61829f = Bitmap.createBitmap(gifInfoHandle.q(), gifInfoHandle.i(), Bitmap.Config.ARGB_8888);
        } else {
            this.f61829f = bitmap;
        }
        this.f61829f.setHasAlpha(!gifInfoHandle.v());
        this.f61838o = new Rect(0, 0, gifInfoHandle.q(), gifInfoHandle.i());
        this.f61836m = new m(this);
        qVar.a();
        this.f61840q = gifInfoHandle.q();
        this.f61841r = gifInfoHandle.i();
    }
}
