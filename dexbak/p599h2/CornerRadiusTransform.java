package p599h2;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.github.mikephil.charting.utils.Utils;

/* renamed from: h2.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CornerRadiusTransform implements Transform {

    /* renamed from: a */
    private float f40159a;

    /* renamed from: b */
    private Shader f40160b;

    /* renamed from: c */
    private final RectF f40161c = new RectF();

    public CornerRadiusTransform(@FloatRange(from = 0.0d) float f) {
        m12724f(f);
    }

    /* renamed from: f */
    private void m12724f(@FloatRange(from = 0.0d) float f) {
        float max = Math.max(0.0f, f);
        if (max != this.f40159a) {
            this.f40159a = max;
            this.f40160b = null;
        }
    }

    @Override // p599h2.Transform
    /* renamed from: a */
    public void mo12723a(Rect rect) {
        this.f40161c.set(rect);
        this.f40160b = null;
    }

    @Override // p599h2.Transform
    /* renamed from: b */
    public void mo12722b(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.f40159a == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f40161c, paint);
            return;
        }
        if (this.f40160b == null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f40160b = new BitmapShader(bitmap, tileMode, tileMode);
            Matrix matrix = new Matrix();
            RectF rectF = this.f40161c;
            matrix.setTranslate(rectF.left, rectF.top);
            matrix.preScale(this.f40161c.width() / bitmap.getWidth(), this.f40161c.height() / bitmap.getHeight());
            this.f40160b.setLocalMatrix(matrix);
        }
        paint.setShader(this.f40160b);
        RectF rectF2 = this.f40161c;
        float f = this.f40159a;
        canvas.drawRoundRect(rectF2, f, f, paint);
    }

    @NonNull
    /* renamed from: c */
    public RectF m12727c() {
        return this.f40161c;
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON)
    /* renamed from: d */
    public float m12726d() {
        return this.f40159a;
    }

    /* renamed from: e */
    public void m12725e(@FloatRange(from = 0.0d) float f) {
        m12724f(f);
    }
}
