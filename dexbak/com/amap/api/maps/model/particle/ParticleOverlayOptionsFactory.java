package com.amap.api.maps.model.particle;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.clj.fastble.BleManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ParticleOverlayOptionsFactory {
    public static final int PARTICLE_TYPE_HAZE = 3;
    public static final int PARTICLE_TYPE_RAIN = 1;
    public static final int PARTICLE_TYPE_SNOWY = 2;
    public static final int PARTICLE_TYPE_SUNNY = 0;

    /* renamed from: a */
    private static List<ParticleOverlayOptions> m52006a() {
        ArrayList arrayList = new ArrayList();
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setLoop(false);
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000L);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, BleManager.f22896l));
        particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.5f, 0.5f, 0.0f, true));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-10.0f, -0.0f, -0.0f, -20.0f, 0.0f, 0.0f));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 5, fromAsset.getWidth() * 5);
        }
        arrayList.add(particleOverlayOptions);
        ParticleOverlayOptions particleOverlayOptions2 = new ParticleOverlayOptions();
        particleOverlayOptions2.setMaxParticles(1000);
        particleOverlayOptions2.setDuration(10000L);
        particleOverlayOptions2.setParticleEmissionModule(new ParticleEmissionModule(30, 2500));
        particleOverlayOptions2.setLoop(true);
        particleOverlayOptions2.setParticleShapeModule(new RectParticleShape(0.5f, 0.5f, 1.0f, 1.0f, true));
        particleOverlayOptions2.setParticleLifeTime(10000L);
        particleOverlayOptions2.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-100.0f, -100.0f, -1.0f, -200.0f, 100.0f, 1.0f));
        BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
        if (fromAsset2 != null) {
            particleOverlayOptions2.icon(fromAsset2);
            particleOverlayOptions2.setStartParticleSize(fromAsset2.getWidth(), fromAsset2.getHeight());
        }
        particleOverlayOptions2.setParticleStartColor(new RandomColorBetWeenTwoConstants(255.0f, 255.0f, 255.0f, 102.0f, 255.0f, 255.0f, 255.0f, 255.0f));
        arrayList.add(particleOverlayOptions2);
        return arrayList;
    }

    /* renamed from: b */
    private static ParticleOverlayOptions m52005b() {
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000L);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(20, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-50.0f, 100.0f, 0.0f, 50.0f, 200.0f, 0.0f));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth(), fromAsset.getHeight());
        }
        return particleOverlayOptions;
    }

    /* renamed from: c */
    private static ParticleOverlayOptions m52004c() {
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000L);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(100, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleLifeTime(5000L);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(10.0f, 1000.0f, 0.0f, 100.0f, 1000.0f, 0.0f));
        particleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 2, fromAsset.getHeight() * 2);
        }
        return particleOverlayOptions;
    }

    /* renamed from: d */
    private static List<ParticleOverlayOptions> m52003d() {
        ArrayList arrayList = new ArrayList();
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000L);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, 2500));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleOverLifeModule(new ParticleOverLifeModule());
        particleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
        particleOverlayOptions.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions);
        ParticleOverlayOptions particleOverlayOptions2 = new ParticleOverlayOptions();
        particleOverlayOptions2.setMaxParticles(1);
        particleOverlayOptions2.setDuration(10000L);
        particleOverlayOptions2.setParticleEmissionModule(new ParticleEmissionModule(1, 2500));
        particleOverlayOptions2.setLoop(true);
        particleOverlayOptions2.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions2.setParticleLifeTime(10000L);
        particleOverlayOptions2.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        ParticleOverLifeModule particleOverLifeModule = new ParticleOverLifeModule();
        particleOverLifeModule.setRotateOverLife(new ConstantRotationOverLife(45.0f));
        particleOverlayOptions2.setParticleOverLifeModule(particleOverLifeModule);
        particleOverlayOptions2.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
        particleOverlayOptions2.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions2);
        return arrayList;
    }

    public static List<ParticleOverlayOptions> defaultOptions(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.addAll(m52003d());
        } else if (i == 1) {
            arrayList.add(m52004c());
        } else if (i == 2) {
            arrayList.add(m52005b());
        } else if (i == 3) {
            arrayList.addAll(m52006a());
        }
        return arrayList;
    }
}
