package com.qq.e.comm.plugin.d.g;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a implements d {
    @Override // com.qq.e.comm.plugin.d.g.d
    public boolean a(b bVar) {
        for (StackTraceElement stackTraceElement : bVar.f42191f) {
            if (stackTraceElement.getClassName().startsWith("com.qq.e")) {
                return false;
            }
        }
        return true;
    }
}
