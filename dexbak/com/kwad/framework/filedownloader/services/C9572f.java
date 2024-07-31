package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9492c;

/* renamed from: com.kwad.framework.filedownloader.services.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9572f {
    /* renamed from: f */
    public static void m28376f(C9464c c9464c) {
        if (c9464c != null) {
            if (c9464c.m28687tV() == -3) {
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra(C2624bk.f8685i, c9464c);
                C9492c.m28544wL().sendBroadcast(intent);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
