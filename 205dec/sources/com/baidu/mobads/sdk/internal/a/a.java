package com.baidu.mobads.sdk.internal.a;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface a extends IOAdEvent {
    @NonNull
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
