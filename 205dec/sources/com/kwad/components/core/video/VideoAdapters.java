package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class VideoAdapters {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.video.VideoAdapters$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] UO;

        static {
            int[] iArr = new int[AdaptType.values().length];
            UO = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                UO[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                UO[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                UO[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i4, int i5) {
            if (view == null || i4 == 0 || i5 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i4, int i5) {
            AdaptType adaptType;
            if (!b(view, view2, i4, i5)) {
                com.kwad.sdk.core.e.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i4, i5);
            boolean z3 = dVar2.getRatio() >= 1.0f;
            boolean z4 = dVar.getRatio() >= 1.0f;
            if (z4 && z3) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z4) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z3) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        protected abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends a {
        private float UP = 0.8f;
        private float UQ = 0.9375f;
        private float UR = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rP;
            float f4;
            float rQ = dVar.rQ();
            float rQ2 = dVar2.rQ();
            float rP2 = dVar.rP();
            float rO = dVar.rO();
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + rO + ", " + rP2);
            int i4 = AnonymousClass1.UO[adaptType.ordinal()];
            if (i4 == 1 || i4 == 2) {
                if (rQ > rQ2) {
                    float rO2 = dVar.rO();
                    float f5 = rO2 / rQ2;
                    float f6 = this.UP;
                    if (rP2 / f5 >= f6) {
                        f4 = rO2;
                        rP = f5;
                    } else {
                        rP = rP2 / f6;
                        f4 = rP * rQ2;
                    }
                } else {
                    rP = dVar.rP();
                    f4 = rQ2 * rP;
                    float f7 = this.UQ;
                    if (rO / f4 < f7) {
                        f4 = rO / f7;
                        rP = f4 / rQ2;
                    }
                }
            } else if (i4 == 3 || i4 == 4) {
                f4 = rP2 * this.UR;
                rP = f4 / rQ2;
            } else {
                rP = -2.1474836E9f;
                f4 = -2.1474836E9f;
            }
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo result: " + f4 + ", " + rP);
            if (f4 == -2.1474836E9f || rP == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) rP;
                layoutParams.height = (int) f4;
                return;
            }
            layoutParams.height = (int) rP;
            layoutParams.width = (int) f4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rO;
            float rP;
            float rQ = dVar.rQ();
            float rQ2 = dVar2.rQ();
            int i4 = AnonymousClass1.UO[adaptType.ordinal()];
            if (i4 == 1 || i4 == 2) {
                if (rQ >= rQ2) {
                    rP = dVar.rP();
                    rO = rP * rQ2;
                } else {
                    rO = dVar.rO();
                    rP = rO / rQ2;
                }
            } else if (i4 == 3 || i4 == 4) {
                rO = dVar.rP();
                rP = rO / rQ2;
            } else {
                rO = 0.0f;
                rP = -2.1474836E9f;
            }
            if (rP == -2.1474836E9f || rO == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) rP;
                layoutParams.height = (int) rO;
                return;
            }
            layoutParams.height = (int) rP;
            layoutParams.width = (int) rO;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class d {
        float US;
        float height;
        float width;

        public d(float f4, float f5) {
            this.US = -1.0f;
            this.width = f4;
            this.height = f5;
            if (f4 <= 0.0f || f5 <= 0.0f) {
                return;
            }
            this.US = f5 / f4;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.US;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float rO() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float rP() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float rQ() {
            if (isValid()) {
                float f4 = this.height;
                float f5 = this.width;
                return f4 > f5 ? f4 / f5 : f5 / f4;
            }
            return -1.0f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.US + '}';
        }
    }
}
