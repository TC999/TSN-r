package com.kwad.sdk.core.videocache;

import com.kwad.sdk.core.videocache.p413a.InterfaceC10549a;
import com.kwad.sdk.core.videocache.p413a.InterfaceC10551c;
import com.kwad.sdk.core.videocache.p414b.InterfaceC10560b;
import com.kwad.sdk.core.videocache.p416d.InterfaceC10566c;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.core.videocache.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10561c {
    public final File aBG;
    public final InterfaceC10551c aBH;
    public final InterfaceC10549a aBI;
    public final InterfaceC10566c aBJ;
    public final InterfaceC10560b aBK;
    public final int aBL;
    public final int aBM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C10561c(File file, InterfaceC10551c interfaceC10551c, InterfaceC10549a interfaceC10549a, InterfaceC10566c interfaceC10566c, InterfaceC10560b interfaceC10560b, int i, int i2) {
        this.aBG = file;
        this.aBH = interfaceC10551c;
        this.aBI = interfaceC10549a;
        this.aBJ = interfaceC10566c;
        this.aBK = interfaceC10560b;
        this.aBL = i;
        this.aBM = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ex */
    public final File m25470ex(String str) {
        return new File(this.aBG, this.aBH.generate(str));
    }
}
