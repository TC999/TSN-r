package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path getPath(float f4, float f5, float f6, float f7);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
