package com.kwad.framework.filedownloader.p348a;

import com.kwad.framework.filedownloader.p353f.C9492c;

/* renamed from: com.kwad.framework.filedownloader.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9431a implements C9492c.InterfaceC9493a {
    @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9493a
    /* renamed from: O */
    public final int mo28543O(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
