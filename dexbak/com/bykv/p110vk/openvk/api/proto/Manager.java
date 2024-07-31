package com.bykv.p110vk.openvk.api.proto;

import android.content.Context;

/* renamed from: com.bykv.vk.openvk.api.proto.Manager */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
