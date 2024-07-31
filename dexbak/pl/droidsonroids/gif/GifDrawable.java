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
import com.github.mikephil.charting.utils.Utils;
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
import p599h2.CornerRadiusTransform;
import p599h2.Transform;

/* renamed from: pl.droidsonroids.gif.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a */
    final ScheduledThreadPoolExecutor f44411a;

    /* renamed from: b */
    volatile boolean f44412b;

    /* renamed from: c */
    long f44413c;

    /* renamed from: d */
    private final Rect f44414d;

    /* renamed from: e */
    protected final Paint f44415e;

    /* renamed from: f */
    final Bitmap f44416f;

    /* renamed from: g */
    final GifInfoHandle f44417g;

    /* renamed from: h */
    final ConcurrentLinkedQueue<AnimationListener> f44418h;

    /* renamed from: i */
    private ColorStateList f44419i;

    /* renamed from: j */
    private PorterDuffColorFilter f44420j;

    /* renamed from: k */
    private PorterDuff.Mode f44421k;

    /* renamed from: l */
    final boolean f44422l;

    /* renamed from: m */
    final InvalidationHandler f44423m;

    /* renamed from: n */
    private final RenderTask f44424n;

    /* renamed from: o */
    private final Rect f44425o;

    /* renamed from: p */
    ScheduledFuture<?> f44426p;

    /* renamed from: q */
    private int f44427q;

    /* renamed from: r */
    private int f44428r;

    /* renamed from: s */
    private Transform f44429s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* renamed from: pl.droidsonroids.gif.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15440a extends SafeRunnable {
        C15440a(GifDrawable gifDrawable) {
            super(gifDrawable);
        }

        @Override // pl.droidsonroids.gif.SafeRunnable
        /* renamed from: a */
        public void mo2363a() {
            if (GifDrawable.this.f44417g.m2535C()) {
                GifDrawable.this.start();
            }
        }
    }

    /* compiled from: GifDrawable.java */
    /* renamed from: pl.droidsonroids.gif.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15441b extends SafeRunnable {

        /* renamed from: b */
        final /* synthetic */ int f44431b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15441b(GifDrawable gifDrawable, int i) {
            super(gifDrawable);
            this.f44431b = i;
        }

        @Override // pl.droidsonroids.gif.SafeRunnable
        /* renamed from: a */
        public void mo2363a() {
            GifDrawable gifDrawable = GifDrawable.this;
            gifDrawable.f44417g.m2529I(this.f44431b, gifDrawable.f44416f);
            this.f44469a.f44423m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    /* compiled from: GifDrawable.java */
    /* renamed from: pl.droidsonroids.gif.e$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15442c extends SafeRunnable {

        /* renamed from: b */
        final /* synthetic */ int f44433b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15442c(GifDrawable gifDrawable, int i) {
            super(gifDrawable);
            this.f44433b = i;
        }

        @Override // pl.droidsonroids.gif.SafeRunnable
        /* renamed from: a */
        public void mo2363a() {
            GifDrawable gifDrawable = GifDrawable.this;
            gifDrawable.f44417g.m2531G(this.f44433b, gifDrawable.f44416f);
            GifDrawable.this.f44423m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public GifDrawable(@NonNull Resources resources, @DrawableRes @RawRes int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        float m2375b = GifViewUtils.m2375b(resources, i);
        this.f44428r = (int) (this.f44417g.m2514i() * m2375b);
        this.f44427q = (int) (this.f44417g.m2506q() * m2375b);
    }

    /* renamed from: I */
    private void m2449I() {
        this.f44412b = false;
        this.f44423m.removeMessages(-1);
        this.f44417g.m2537A();
    }

    /* renamed from: K */
    private PorterDuffColorFilter m2447K(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* renamed from: b */
    private void m2445b() {
        ScheduledFuture<?> scheduledFuture = this.f44426p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f44423m.removeMessages(-1);
    }

    @Nullable
    /* renamed from: c */
    public static GifDrawable m2444c(@NonNull Resources resources, @DrawableRes @RawRes int i) {
        try {
            return new GifDrawable(resources, i);
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: z */
    private void m2421z() {
        if (this.f44422l && this.f44412b) {
            long j = this.f44413c;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.f44413c = Long.MIN_VALUE;
                this.f44411a.remove(this.f44424n);
                this.f44426p = this.f44411a.schedule(this.f44424n, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* renamed from: A */
    public void m2457A(@IntRange(from = 0, m60035to = 2147483647L) int i) {
        if (i >= 0) {
            synchronized (this.f44417g) {
                this.f44417g.m2529I(i, this.f44416f);
            }
            this.f44423m.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    /* renamed from: B */
    public void m2456B(@IntRange(from = 0, m60035to = 2147483647L) int i) {
        if (i >= 0) {
            this.f44411a.execute(new C15442c(this, i));
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    /* renamed from: C */
    public Bitmap m2455C(@IntRange(from = 0, m60035to = 2147483647L) int i) {
        Bitmap m2440g;
        if (i >= 0) {
            synchronized (this.f44417g) {
                this.f44417g.m2531G(i, this.f44416f);
                m2440g = m2440g();
            }
            this.f44423m.sendEmptyMessageAtTime(-1, 0L);
            return m2440g;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    /* renamed from: D */
    public Bitmap m2454D(@IntRange(from = 0, m60035to = 2147483647L) int i) {
        Bitmap m2440g;
        if (i >= 0) {
            synchronized (this.f44417g) {
                this.f44417g.m2529I(i, this.f44416f);
                m2440g = m2440g();
            }
            this.f44423m.sendEmptyMessageAtTime(-1, 0L);
            return m2440g;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    /* renamed from: E */
    public void m2453E(@FloatRange(from = 0.0d) float f) {
        CornerRadiusTransform cornerRadiusTransform = new CornerRadiusTransform(f);
        this.f44429s = cornerRadiusTransform;
        cornerRadiusTransform.mo12723a(this.f44414d);
    }

    /* renamed from: F */
    public void m2452F(@IntRange(from = 0, m60035to = 65535) int i) {
        this.f44417g.m2528J(i);
    }

    /* renamed from: G */
    public void m2451G(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.f44417g.m2526L(f);
    }

    /* renamed from: H */
    public void m2450H(@Nullable Transform transform) {
        this.f44429s = transform;
        if (transform != null) {
            transform.mo12723a(this.f44414d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: J */
    public void m2448J(long j) {
        if (this.f44422l) {
            this.f44413c = 0L;
            this.f44423m.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        m2445b();
        this.f44426p = this.f44411a.schedule(this.f44424n, Math.max(j, 0L), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public void m2446a(@NonNull AnimationListener animationListener) {
        this.f44418h.add(animationListener);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return m2431p() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return m2431p() > 1;
    }

    /* renamed from: d */
    public long m2443d() {
        int m2436k;
        long m2521b = this.f44417g.m2521b();
        if (Build.VERSION.SDK_INT >= 19) {
            m2436k = this.f44416f.getAllocationByteCount();
        } else {
            m2436k = m2436k();
        }
        return m2521b + m2436k;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        if (this.f44420j == null || this.f44415e.getColorFilter() != null) {
            z = false;
        } else {
            this.f44415e.setColorFilter(this.f44420j);
            z = true;
        }
        Transform transform = this.f44429s;
        if (transform == null) {
            canvas.drawBitmap(this.f44416f, this.f44425o, this.f44414d, this.f44415e);
        } else {
            transform.mo12722b(canvas, this.f44415e, this.f44416f);
        }
        if (z) {
            this.f44415e.setColorFilter(null);
        }
    }

    @Nullable
    /* renamed from: e */
    public String m2442e() {
        return this.f44417g.m2520c();
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON)
    /* renamed from: f */
    public float m2441f() {
        Transform transform = this.f44429s;
        if (transform instanceof CornerRadiusTransform) {
            return ((CornerRadiusTransform) transform).m12726d();
        }
        return 0.0f;
    }

    /* renamed from: g */
    public Bitmap m2440g() {
        Bitmap bitmap = this.f44416f;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), this.f44416f.isMutable());
        copy.setHasAlpha(this.f44416f.hasAlpha());
        return copy;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f44415e.getAlpha();
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
        return this.f44415e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f44417g.m2517f();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f44417g.m2516g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f44428r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f44427q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f44417g.m2501v() || this.f44415e.getAlpha() < 255) ? -2 : -1;
    }

    /* renamed from: h */
    public int m2439h() {
        return this.f44417g.m2519d();
    }

    /* renamed from: i */
    public int m2438i() {
        int m2518e = this.f44417g.m2518e();
        return (m2518e == 0 || m2518e < this.f44417g.m2513j()) ? m2518e : m2518e - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        m2421z();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f44412b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f44412b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f44419i) != null && colorStateList.isStateful());
    }

    @NonNull
    /* renamed from: j */
    public GifError m2437j() {
        return GifError.fromCode(this.f44417g.m2511l());
    }

    /* renamed from: k */
    public int m2436k() {
        return this.f44416f.getRowBytes() * this.f44416f.getHeight();
    }

    /* renamed from: l */
    public int m2435l(@IntRange(from = 0) int i) {
        return this.f44417g.m2515h(i);
    }

    /* renamed from: m */
    public long m2434m() {
        return this.f44417g.m2507p();
    }

    /* renamed from: n */
    public int m2433n() {
        return this.f44417g.m2513j();
    }

    /* renamed from: o */
    public long m2432o() {
        return this.f44417g.m2512k();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f44414d.set(rect);
        Transform transform = this.f44429s;
        if (transform != null) {
            transform.mo12723a(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f44419i;
        if (colorStateList == null || (mode = this.f44421k) == null) {
            return false;
        }
        this.f44420j = m2447K(colorStateList, mode);
        return true;
    }

    /* renamed from: p */
    public int m2431p() {
        return this.f44417g.m2509n();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @NonNull
    /* renamed from: q */
    public final Paint m2430q() {
        return this.f44415e;
    }

    /* renamed from: r */
    public int m2429r(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        if (i < this.f44417g.m2506q()) {
            if (i2 < this.f44417g.m2514i()) {
                return this.f44416f.getPixel(i, i2);
            }
            throw new IllegalArgumentException("y must be < height");
        }
        throw new IllegalArgumentException("x must be < width");
    }

    /* renamed from: s */
    public void m2428s(@NonNull int[] iArr) {
        this.f44416f.getPixels(iArr, 0, this.f44417g.m2506q(), 0, 0, this.f44417g.m2506q(), this.f44417g.m2514i());
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, m60035to = 2147483647L) int i) {
        if (i >= 0) {
            this.f44411a.execute(new C15441b(this, i));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m60035to = 255) int i) {
        this.f44415e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f44415e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f44415e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f44415e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f44419i = colorStateList;
        this.f44420j = m2447K(colorStateList, this.f44421k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f44421k = mode;
        this.f44420j = m2447K(this.f44419i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.f44422l) {
            if (z) {
                if (z2) {
                    m2422y();
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
            if (this.f44412b) {
                return;
            }
            this.f44412b = true;
            m2448J(this.f44417g.m2534D());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.f44412b) {
                this.f44412b = false;
                m2445b();
                this.f44417g.m2532F();
            }
        }
    }

    @Nullable
    /* renamed from: t */
    public Transform m2427t() {
        return this.f44429s;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f44417g.m2506q()), Integer.valueOf(this.f44417g.m2514i()), Integer.valueOf(this.f44417g.m2509n()), Integer.valueOf(this.f44417g.m2511l()));
    }

    /* renamed from: u */
    public boolean m2426u() {
        return this.f44417g.m2502u();
    }

    /* renamed from: v */
    public boolean m2425v() {
        return this.f44417g.m2500w();
    }

    /* renamed from: w */
    public void m2424w() {
        m2449I();
        this.f44416f.recycle();
    }

    /* renamed from: x */
    public boolean m2423x(AnimationListener animationListener) {
        return this.f44418h.remove(animationListener);
    }

    /* renamed from: y */
    public void m2422y() {
        this.f44411a.execute(new C15440a(this));
    }

    public GifDrawable(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifDrawable(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public GifDrawable(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifDrawable(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream), null, null, true);
    }

    public GifDrawable(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor), null, null, true);
    }

    public GifDrawable(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    public GifDrawable(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer), null, null, true);
    }

    public GifDrawable(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.m2498y(contentResolver, uri), null, null, true);
    }

    protected GifDrawable(@NonNull InputSource inputSource, @Nullable GifDrawable gifDrawable, @Nullable ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z, @NonNull C15443h c15443h) throws IOException {
        this(inputSource.m2369b(c15443h), gifDrawable, scheduledThreadPoolExecutor, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.f44412b = true;
        this.f44413c = Long.MIN_VALUE;
        this.f44414d = new Rect();
        this.f44415e = new Paint(6);
        this.f44418h = new ConcurrentLinkedQueue<>();
        RenderTask renderTask = new RenderTask(this);
        this.f44424n = renderTask;
        this.f44422l = z;
        this.f44411a = scheduledThreadPoolExecutor == null ? GifRenderingExecutor.m2391a() : scheduledThreadPoolExecutor;
        this.f44417g = gifInfoHandle;
        Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.f44417g) {
                if (!gifDrawable.f44417g.m2500w() && gifDrawable.f44417g.m2514i() >= gifInfoHandle.m2514i() && gifDrawable.f44417g.m2506q() >= gifInfoHandle.m2506q()) {
                    gifDrawable.m2449I();
                    Bitmap bitmap2 = gifDrawable.f44416f;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f44416f = Bitmap.createBitmap(gifInfoHandle.m2506q(), gifInfoHandle.m2514i(), Bitmap.Config.ARGB_8888);
        } else {
            this.f44416f = bitmap;
        }
        this.f44416f.setHasAlpha(!gifInfoHandle.m2501v());
        this.f44425o = new Rect(0, 0, gifInfoHandle.m2506q(), gifInfoHandle.m2514i());
        this.f44423m = new InvalidationHandler(this);
        renderTask.mo2363a();
        this.f44427q = gifInfoHandle.m2506q();
        this.f44428r = gifInfoHandle.m2514i();
    }
}
