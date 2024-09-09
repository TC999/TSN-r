package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i4);

    ValueSet values();
}
