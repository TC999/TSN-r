package com.kwad.framework.filedownloader.services;

import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar != null) {
            if (cVar.tV() == -3) {
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra("model", cVar);
                com.kwad.framework.filedownloader.f.c.wL().sendBroadcast(intent);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
