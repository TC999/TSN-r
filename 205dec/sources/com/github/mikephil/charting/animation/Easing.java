package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@RequiresApi(11)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Easing {
    private static final float DOUBLE_PI = 6.2831855f;
    public static final EasingFunction Linear = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.1
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4;
        }
    };
    public static final EasingFunction EaseInQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.2
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 * f4;
        }
    };
    public static final EasingFunction EaseOutQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.3
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return (-f4) * (f4 - 2.0f);
        }
    };
    public static final EasingFunction EaseInOutQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.4
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 * 2.0f;
            if (f5 < 1.0f) {
                return 0.5f * f5 * f5;
            }
            float f6 = f5 - 1.0f;
            return ((f6 * (f6 - 2.0f)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction EaseInCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.5
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return (float) Math.pow(f4, 3.0d);
        }
    };
    public static final EasingFunction EaseOutCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.6
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return ((float) Math.pow(f4 - 1.0f, 3.0d)) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.7
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float pow;
            float f5 = f4 * 2.0f;
            if (f5 < 1.0f) {
                pow = (float) Math.pow(f5, 3.0d);
            } else {
                pow = ((float) Math.pow(f5 - 2.0f, 3.0d)) + 2.0f;
            }
            return pow * 0.5f;
        }
    };
    public static final EasingFunction EaseInQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.8
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return (float) Math.pow(f4, 4.0d);
        }
    };
    public static final EasingFunction EaseOutQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.9
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return -(((float) Math.pow(f4 - 1.0f, 4.0d)) - 1.0f);
        }
    };
    public static final EasingFunction EaseInOutQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.10
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 * 2.0f;
            if (f5 < 1.0f) {
                return ((float) Math.pow(f5, 4.0d)) * 0.5f;
            }
            return (((float) Math.pow(f5 - 2.0f, 4.0d)) - 2.0f) * (-0.5f);
        }
    };
    public static final EasingFunction EaseInSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.11
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            double d4 = f4;
            Double.isNaN(d4);
            return (-((float) Math.cos(d4 * 1.5707963267948966d))) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.12
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            double d4 = f4;
            Double.isNaN(d4);
            return (float) Math.sin(d4 * 1.5707963267948966d);
        }
    };
    public static final EasingFunction EaseInOutSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.13
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            double d4 = f4;
            Double.isNaN(d4);
            return (((float) Math.cos(d4 * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction EaseInExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.14
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f4 - 1.0f) * 10.0f);
        }
    };
    public static final EasingFunction EaseOutExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.15
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f4 + 1.0f) * (-10.0f)));
        }
    };
    public static final EasingFunction EaseInOutExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.16
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5;
            if (f4 == 0.0f) {
                return 0.0f;
            }
            if (f4 == 1.0f) {
                return 1.0f;
            }
            float f6 = f4 * 2.0f;
            if (f6 < 1.0f) {
                f5 = (float) Math.pow(2.0d, (f6 - 1.0f) * 10.0f);
            } else {
                f5 = (-((float) Math.pow(2.0d, (f6 - 1.0f) * (-10.0f)))) + 2.0f;
            }
            return f5 * 0.5f;
        }
    };
    public static final EasingFunction EaseInCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.17
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return -(((float) Math.sqrt(1.0f - (f4 * f4))) - 1.0f);
        }
    };
    public static final EasingFunction EaseOutCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.18
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (float) Math.sqrt(1.0f - (f5 * f5));
        }
    };
    public static final EasingFunction EaseInOutCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.19
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 * 2.0f;
            if (f5 < 1.0f) {
                return (((float) Math.sqrt(1.0f - (f5 * f5))) - 1.0f) * (-0.5f);
            }
            float f6 = f5 - 2.0f;
            return (((float) Math.sqrt(1.0f - (f6 * f6))) + 1.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.20
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 == 0.0f) {
                return 0.0f;
            }
            if (f4 == 1.0f) {
                return 1.0f;
            }
            float f5 = f4 - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f5)) * ((float) Math.sin(((f5 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    };
    public static final EasingFunction EaseOutElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.21
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 == 0.0f) {
                return 0.0f;
            }
            if (f4 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f4)) * ((float) Math.sin(((f4 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.22
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 == 0.0f) {
                return 0.0f;
            }
            float f5 = f4 * 2.0f;
            if (f5 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f5 < 1.0f) {
                float f6 = f5 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f6)) * ((float) Math.sin(((f6 * 1.0f) - asin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f7 = f5 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f7)) * 0.5f * ((float) Math.sin(((f7 * 1.0f) - asin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    };
    public static final EasingFunction EaseInBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.23
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 * f4 * ((f4 * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction EaseOutBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.24
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * ((f5 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.25
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 * 2.0f;
            if (f5 < 1.0f) {
                return f5 * f5 * ((3.5949094f * f5) - 2.5949094f) * 0.5f;
            }
            float f6 = f5 - 2.0f;
            return ((f6 * f6 * ((3.5949094f * f6) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.26
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return 1.0f - Easing.EaseOutBounce.getInterpolation(1.0f - f4);
        }
    };
    public static final EasingFunction EaseOutBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.27
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 < 0.36363637f) {
                return 7.5625f * f4 * f4;
            }
            if (f4 < 0.72727275f) {
                float f5 = f4 - 0.54545456f;
                return (7.5625f * f5 * f5) + 0.75f;
            } else if (f4 < 0.90909094f) {
                float f6 = f4 - 0.8181818f;
                return (7.5625f * f6 * f6) + 0.9375f;
            } else {
                float f7 = f4 - 0.95454544f;
                return (7.5625f * f7 * f7) + 0.984375f;
            }
        }
    };
    public static final EasingFunction EaseInOutBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.28
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            if (f4 < 0.5f) {
                return Easing.EaseInBounce.getInterpolation(f4 * 2.0f) * 0.5f;
            }
            return (Easing.EaseOutBounce.getInterpolation((f4 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f4);
    }
}
