package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: pl.droidsonroids.gif.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RenderTask extends SafeRunnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // pl.droidsonroids.gif.SafeRunnable
    /* renamed from: a */
    public void mo2363a() {
        GifDrawable gifDrawable = this.f44469a;
        long m2536B = gifDrawable.f44417g.m2536B(gifDrawable.f44416f);
        if (m2536B >= 0) {
            this.f44469a.f44413c = SystemClock.uptimeMillis() + m2536B;
            if (this.f44469a.isVisible() && this.f44469a.f44412b) {
                GifDrawable gifDrawable2 = this.f44469a;
                if (!gifDrawable2.f44422l) {
                    gifDrawable2.f44411a.remove(this);
                    GifDrawable gifDrawable3 = this.f44469a;
                    gifDrawable3.f44426p = gifDrawable3.f44411a.schedule(this, m2536B, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f44469a.f44418h.isEmpty() && this.f44469a.m2439h() == this.f44469a.f44417g.m2509n() - 1) {
                GifDrawable gifDrawable4 = this.f44469a;
                gifDrawable4.f44423m.sendEmptyMessageAtTime(gifDrawable4.m2438i(), this.f44469a.f44413c);
            }
        } else {
            GifDrawable gifDrawable5 = this.f44469a;
            gifDrawable5.f44413c = Long.MIN_VALUE;
            gifDrawable5.f44412b = false;
        }
        if (!this.f44469a.isVisible() || this.f44469a.f44423m.hasMessages(-1)) {
            return;
        }
        this.f44469a.f44423m.sendEmptyMessageAtTime(-1, 0L);
    }
}
