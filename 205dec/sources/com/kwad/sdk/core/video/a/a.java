package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements c {
    private c.e Uc;
    private c.i Ud;
    private c.b Ue;
    private c.InterfaceC0702c Uf;
    private c.d Ug;
    private c.a Uh;
    private c.f aAY;
    private c.g aAZ;
    private c.h aBa;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(float f4) {
        if (f4 == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.ev("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.ev("autoVoice");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void FX() {
        c.f fVar = this.aAY;
        if (fVar != null) {
            fVar.ry();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aAY = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.Uc = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.Ug = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnBufferingUpdate(int i4) {
        c.a aVar = this.Uh;
        if (aVar != null) {
            aVar.av(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnCompletion() {
        c.b bVar = this.Ue;
        if (bVar != null) {
            bVar.oZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnError(int i4, int i5) {
        com.kwad.sdk.core.video.a.a.a.ev("videoPlayError");
        c.InterfaceC0702c interfaceC0702c = this.Uf;
        return interfaceC0702c != null && interfaceC0702c.l(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i4, int i5) {
        c.d dVar = this.Ug;
        return dVar != null && dVar.m(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnPrepared() {
        c.e eVar = this.Uc;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSeekComplete() {
        c.g gVar = this.aAZ;
        if (gVar != null) {
            gVar.pa();
        }
    }

    public final void resetListeners() {
        this.aAY = null;
        this.Uc = null;
        this.Uh = null;
        this.Ue = null;
        this.aAZ = null;
        this.Ud = null;
        this.Uf = null;
        this.Ug = null;
        this.aBa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w(int i4, int i5) {
        c.i iVar = this.Ud;
        if (iVar != null) {
            iVar.k(i4, i5);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.Ue = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(TimedText timedText) {
        c.h hVar = this.aBa;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.Uh = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aAZ = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.Ud = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0702c interfaceC0702c) {
        this.Uf = interfaceC0702c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aBa = hVar;
    }
}
