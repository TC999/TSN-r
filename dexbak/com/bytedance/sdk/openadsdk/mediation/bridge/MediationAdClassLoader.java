package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationAdClassLoader implements Bridge {

    /* renamed from: ok */
    private static volatile MediationAdClassLoader f22707ok;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (f22707ok == null) {
            synchronized (MediationAdClassLoader.class) {
                f22707ok = new MediationAdClassLoader();
            }
        }
        return f22707ok;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    @RequiresApi(api = 19)
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
            Context context = (Context) valueSet.objectValue(8009, Context.class);
            try {
                Object newInstance = Class.forName(create.getClassName()).newInstance();
                if (newInstance instanceof Bridge) {
                    Bridge bridge = (Bridge) newInstance;
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(8009, context);
                    ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
                    if (valueSet2 != null) {
                        create2.add(8424, valueSet2);
                    } else {
                        create2.add(8424, valueSet);
                    }
                    bridge.call(8241, create2.build(), null);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        } else if (i == 8229) {
            try {
                Class.forName(valueSet.stringValue(8010));
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
