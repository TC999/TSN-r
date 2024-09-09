package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;

    public ParticleOverlay(IGlOverlayLayer iGlOverlayLayer, ParticleOverlayOptions particleOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = particleOverlayOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setDuration(long j4) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setDuration(j4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z3) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setLoop(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i4) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setMaxParticles(i4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j4) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleLifeTime(j4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleShapeModule(particleShapeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartColor(colorGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i4, int i5) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setStartParticleSize(i4, i5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z3) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setVisible(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
