package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IMediationAdLoader extends Bridge {
    void load(Context context, ValueSet valueSet);
}
