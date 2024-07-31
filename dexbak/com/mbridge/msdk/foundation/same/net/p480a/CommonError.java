package com.mbridge.msdk.foundation.same.net.p480a;

import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;

/* renamed from: com.mbridge.msdk.foundation.same.net.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonError extends Exception {

    /* renamed from: a */
    public int f30690a;

    /* renamed from: b */
    public NetworkResponse f30691b;

    public CommonError(int i, NetworkResponse networkResponse) {
        this.f30690a = i;
        this.f30691b = networkResponse;
    }
}
