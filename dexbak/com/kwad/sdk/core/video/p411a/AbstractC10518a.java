package com.kwad.sdk.core.video.p411a;

import android.media.TimedText;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.core.video.p411a.p412a.C10519a;

/* renamed from: com.kwad.sdk.core.video.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10518a implements InterfaceC10522c {

    /* renamed from: Uc */
    private InterfaceC10522c.InterfaceC10527e f29588Uc;

    /* renamed from: Ud */
    private InterfaceC10522c.InterfaceC10531i f29589Ud;

    /* renamed from: Ue */
    private InterfaceC10522c.InterfaceC10524b f29590Ue;

    /* renamed from: Uf */
    private InterfaceC10522c.InterfaceC10525c f29591Uf;

    /* renamed from: Ug */
    private InterfaceC10522c.InterfaceC10526d f29592Ug;

    /* renamed from: Uh */
    private InterfaceC10522c.InterfaceC10523a f29593Uh;
    private InterfaceC10522c.InterfaceC10528f aAY;
    private InterfaceC10522c.InterfaceC10529g aAZ;
    private InterfaceC10522c.InterfaceC10530h aBa;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public static void m25563f(float f) {
        if (f == 0.0f) {
            C10519a.m25561ev("autoMute");
        } else {
            C10519a.m25561ev("autoVoice");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: FX */
    public final void m25565FX() {
        InterfaceC10522c.InterfaceC10528f interfaceC10528f = this.aAY;
        if (interfaceC10528f != null) {
            interfaceC10528f.mo25546ry();
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25552a(InterfaceC10522c.InterfaceC10528f interfaceC10528f) {
        this.aAY = interfaceC10528f;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: b */
    public final void mo25548b(InterfaceC10522c.InterfaceC10527e interfaceC10527e) {
        this.f29588Uc = interfaceC10527e;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: c */
    public final void mo25547c(InterfaceC10522c.InterfaceC10526d interfaceC10526d) {
        this.f29592Ug = interfaceC10526d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnBufferingUpdate(int i) {
        InterfaceC10522c.InterfaceC10523a interfaceC10523a = this.f29593Uh;
        if (interfaceC10523a != null) {
            interfaceC10523a.mo25496av(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnCompletion() {
        InterfaceC10522c.InterfaceC10524b interfaceC10524b = this.f29590Ue;
        if (interfaceC10524b != null) {
            interfaceC10524b.mo25499oZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnError(int i, int i2) {
        C10519a.m25561ev("videoPlayError");
        InterfaceC10522c.InterfaceC10525c interfaceC10525c = this.f29591Uf;
        return interfaceC10525c != null && interfaceC10525c.mo25498l(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i, int i2) {
        InterfaceC10522c.InterfaceC10526d interfaceC10526d = this.f29592Ug;
        return interfaceC10526d != null && interfaceC10526d.mo25497m(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnPrepared() {
        InterfaceC10522c.InterfaceC10527e interfaceC10527e = this.f29588Uc;
        if (interfaceC10527e != null) {
            interfaceC10527e.mo25501a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSeekComplete() {
        InterfaceC10522c.InterfaceC10529g interfaceC10529g = this.aAZ;
        if (interfaceC10529g != null) {
            interfaceC10529g.mo25545pa();
        }
    }

    public final void resetListeners() {
        this.aAY = null;
        this.f29588Uc = null;
        this.f29593Uh = null;
        this.f29590Ue = null;
        this.aAZ = null;
        this.f29589Ud = null;
        this.f29591Uf = null;
        this.f29592Ug = null;
        this.aBa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public final void m25562w(int i, int i2) {
        InterfaceC10522c.InterfaceC10531i interfaceC10531i = this.f29589Ud;
        if (interfaceC10531i != null) {
            interfaceC10531i.mo25500k(i, i2);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25554a(InterfaceC10522c.InterfaceC10524b interfaceC10524b) {
        this.f29590Ue = interfaceC10524b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m25564b(TimedText timedText) {
        InterfaceC10522c.InterfaceC10530h interfaceC10530h = this.aBa;
        if (interfaceC10530h != null) {
            interfaceC10530h.mo25544a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25555a(InterfaceC10522c.InterfaceC10523a interfaceC10523a) {
        this.f29593Uh = interfaceC10523a;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25551a(InterfaceC10522c.InterfaceC10529g interfaceC10529g) {
        this.aAZ = interfaceC10529g;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25549a(InterfaceC10522c.InterfaceC10531i interfaceC10531i) {
        this.f29589Ud = interfaceC10531i;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25553a(InterfaceC10522c.InterfaceC10525c interfaceC10525c) {
        this.f29591Uf = interfaceC10525c;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25550a(InterfaceC10522c.InterfaceC10530h interfaceC10530h) {
        this.aBa = interfaceC10530h;
    }
}
