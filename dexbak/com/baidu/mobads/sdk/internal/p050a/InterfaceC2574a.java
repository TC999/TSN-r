package com.baidu.mobads.sdk.internal.p050a;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* renamed from: com.baidu.mobads.sdk.internal.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC2574a extends IOAdEvent {
    @NonNull
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
