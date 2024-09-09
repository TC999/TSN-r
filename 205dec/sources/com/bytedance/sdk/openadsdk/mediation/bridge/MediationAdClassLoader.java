package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationAdClassLoader implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static volatile MediationAdClassLoader f36057c;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (f36057c == null) {
            synchronized (MediationAdClassLoader.class) {
                f36057c = new MediationAdClassLoader();
            }
        }
        return f36057c;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    @RequiresApi(api = 19)
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8106) {
            MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
            Context context = (Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
            try {
                Object newInstance = Class.forName(create.getClassName()).newInstance();
                if (newInstance instanceof Bridge) {
                    Bridge bridge = (Bridge) newInstance;
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
                    ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
                    if (valueSet2 != null) {
                        create2.add(8424, valueSet2);
                    } else {
                        create2.add(8424, valueSet);
                    }
                    bridge.call(8241, create2.build(), null);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e4) {
                e4.printStackTrace();
            }
        } else if (i4 == 8229) {
            try {
                Class.forName(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow));
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException e5) {
                e5.printStackTrace();
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
