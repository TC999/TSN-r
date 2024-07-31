package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C89611 {

        /* renamed from: UO */
        static final /* synthetic */ int[] f28893UO;

        static {
            int[] iArr = new int[AdaptType.values().length];
            f28893UO = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28893UO[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28893UO[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28893UO[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractC8962a implements InterfaceC8991c {
        /* renamed from: b */
        private static boolean m29513b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.InterfaceC8991c
        /* renamed from: a */
        public final void mo29442a(View view, View view2, int i, int i2) {
            AdaptType adaptType;
            if (!m29513b(view, view2, i, i2)) {
                C10331c.m26254d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            C8965d c8965d = new C8965d(view2.getWidth(), view2.getHeight());
            C8965d c8965d2 = new C8965d(i, i2);
            boolean z = c8965d2.getRatio() >= 1.0f;
            boolean z2 = c8965d.getRatio() >= 1.0f;
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            mo29512a(adaptType, layoutParams, c8965d, c8965d2);
            view.setLayoutParams(layoutParams);
        }

        /* renamed from: a */
        protected abstract void mo29512a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull C8965d c8965d, @NonNull C8965d c8965d2);
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8963b extends AbstractC8962a {

        /* renamed from: UP */
        private float f28894UP = 0.8f;

        /* renamed from: UQ */
        private float f28895UQ = 0.9375f;

        /* renamed from: UR */
        private float f28896UR = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.AbstractC8962a
        /* renamed from: a */
        protected final void mo29512a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull C8965d c8965d, @NonNull C8965d c8965d2) {
            float m29510rP;
            float f;
            float m29509rQ = c8965d.m29509rQ();
            float m29509rQ2 = c8965d2.m29509rQ();
            float m29510rP2 = c8965d.m29510rP();
            float m29511rO = c8965d.m29511rO();
            C10331c.m26254d("FullHeightAdapter", "onAdaptVideo containerSize: " + m29511rO + ", " + m29510rP2);
            int i = C89611.f28893UO[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (m29509rQ > m29509rQ2) {
                    float m29511rO2 = c8965d.m29511rO();
                    float f2 = m29511rO2 / m29509rQ2;
                    float f3 = this.f28894UP;
                    if (m29510rP2 / f2 >= f3) {
                        f = m29511rO2;
                        m29510rP = f2;
                    } else {
                        m29510rP = m29510rP2 / f3;
                        f = m29510rP * m29509rQ2;
                    }
                } else {
                    m29510rP = c8965d.m29510rP();
                    f = m29509rQ2 * m29510rP;
                    float f4 = this.f28895UQ;
                    if (m29511rO / f < f4) {
                        f = m29511rO / f4;
                        m29510rP = f / m29509rQ2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = m29510rP2 * this.f28896UR;
                m29510rP = f / m29509rQ2;
            } else {
                m29510rP = -2.1474836E9f;
                f = -2.1474836E9f;
            }
            C10331c.m26254d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + m29510rP);
            if (f == -2.1474836E9f || m29510rP == -2.1474836E9f) {
                return;
            }
            if (c8965d2.getHeight() >= c8965d2.getWidth()) {
                layoutParams.width = (int) m29510rP;
                layoutParams.height = (int) f;
                return;
            }
            layoutParams.height = (int) m29510rP;
            layoutParams.width = (int) f;
        }
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8964c extends AbstractC8962a {
        @Override // com.kwad.components.core.video.VideoAdapters.AbstractC8962a
        /* renamed from: a */
        protected final void mo29512a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull C8965d c8965d, @NonNull C8965d c8965d2) {
            float m29511rO;
            float m29510rP;
            float m29509rQ = c8965d.m29509rQ();
            float m29509rQ2 = c8965d2.m29509rQ();
            int i = C89611.f28893UO[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (m29509rQ >= m29509rQ2) {
                    m29510rP = c8965d.m29510rP();
                    m29511rO = m29510rP * m29509rQ2;
                } else {
                    m29511rO = c8965d.m29511rO();
                    m29510rP = m29511rO / m29509rQ2;
                }
            } else if (i == 3 || i == 4) {
                m29511rO = c8965d.m29510rP();
                m29510rP = m29511rO / m29509rQ2;
            } else {
                m29511rO = 0.0f;
                m29510rP = -2.1474836E9f;
            }
            if (m29510rP == -2.1474836E9f || m29511rO == -2.1474836E9f) {
                return;
            }
            if (c8965d2.getHeight() > c8965d2.getWidth()) {
                layoutParams.width = (int) m29510rP;
                layoutParams.height = (int) m29511rO;
                return;
            }
            layoutParams.height = (int) m29510rP;
            layoutParams.width = (int) m29511rO;
        }
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8965d {

        /* renamed from: US */
        float f28897US;
        float height;
        float width;

        public C8965d(float f, float f2) {
            this.f28897US = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.f28897US = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.f28897US;
        }

        public final float getWidth() {
            return this.width;
        }

        /* renamed from: rO */
        public final float m29511rO() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        /* renamed from: rP */
        public final float m29510rP() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        /* renamed from: rQ */
        public final float m29509rQ() {
            if (isValid()) {
                float f = this.height;
                float f2 = this.width;
                return f > f2 ? f / f2 : f2 / f;
            }
            return -1.0f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.f28897US + '}';
        }
    }
}
