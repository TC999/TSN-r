package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i4) {
        this.mEdgeEffect.onAbsorb(i4);
        return true;
    }

    @Deprecated
    public boolean onPull(float f4) {
        this.mEdgeEffect.onPull(f4);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i4, int i5) {
        this.mEdgeEffect.setSize(i4, i5);
    }

    @Deprecated
    public boolean onPull(float f4, float f5) {
        onPull(this.mEdgeEffect, f4, f5);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f4, f5);
        } else {
            edgeEffect.onPull(f4);
        }
    }
}
