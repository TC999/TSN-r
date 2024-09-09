package com.bytedance.msdk.adapter.pangle_csjm;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class PluginInitAdapterConfiguration implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    protected PluginInitConfig f27201c;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8240) {
            initAdn((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i4, valueSet, cls);
    }

    public <T> T callFunction(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final void initAdn(Context context, ValueSet valueSet) {
        PluginInitConfig create = PluginInitConfig.create(valueSet);
        this.f27201c = create;
        realInitAdn(context, create);
    }

    public abstract void realInitAdn(Context context, PluginInitConfig pluginInitConfig);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
