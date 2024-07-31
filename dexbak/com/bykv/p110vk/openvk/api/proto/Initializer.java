package com.bykv.p110vk.openvk.api.proto;

import android.content.Context;

/* renamed from: com.bykv.vk.openvk.api.proto.Initializer */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
