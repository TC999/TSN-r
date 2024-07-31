package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.AbstractC8914c;
import com.kwad.components.core.request.InterfaceC8924i;
import com.kwad.components.p208ad.p220e.C7414a;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* renamed from: com.kwad.components.core.request.model.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8927a {
    @NonNull

    /* renamed from: Mv */
    public final ImpInfo f28803Mv;

    /* renamed from: RA */
    private String f28804RA;
    @NonNull

    /* renamed from: Ru */
    public final AbstractC8914c f28805Ru;
    @Nullable

    /* renamed from: Rv */
    public InterfaceC8924i f28806Rv;
    @Nullable

    /* renamed from: Rw */
    public List<String> f28807Rw;

    /* renamed from: Rx */
    public boolean f28808Rx;

    /* renamed from: Ry */
    public boolean f28809Ry;
    @Nullable

    /* renamed from: Rz */
    public C8931c f28810Rz;

    /* renamed from: com.kwad.components.core.request.model.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8928a {

        /* renamed from: Mv */
        public ImpInfo f28811Mv;

        /* renamed from: RB */
        public InterfaceC8924i f28812RB;

        /* renamed from: Ru */
        public AbstractC8914c f28813Ru;

        /* renamed from: Rx */
        public boolean f28814Rx;

        /* renamed from: Ry */
        public boolean f28815Ry;

        /* renamed from: a */
        public final C8928a m29589a(@NonNull AbstractC8914c abstractC8914c) {
            this.f28813Ru = abstractC8914c;
            return this;
        }

        /* renamed from: aI */
        public final C8928a m29587aI(boolean z) {
            this.f28814Rx = true;
            return this;
        }

        /* renamed from: aJ */
        public final C8928a m29586aJ(boolean z) {
            this.f28815Ry = z;
            return this;
        }

        /* renamed from: e */
        public final C8928a m29585e(ImpInfo impInfo) {
            this.f28811Mv = impInfo;
            return this;
        }

        /* renamed from: qy */
        public final C8927a m29584qy() {
            if (C7414a.f25415md.booleanValue() && (this.f28811Mv == null || this.f28813Ru == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new C8927a(this, (byte) 0);
        }

        /* renamed from: a */
        public final C8928a m29588a(InterfaceC8924i interfaceC8924i) {
            this.f28812RB = interfaceC8924i;
            return this;
        }
    }

    /* synthetic */ C8927a(C8928a c8928a, byte b) {
        this(c8928a);
    }

    /* renamed from: a */
    public static void m29593a(@NonNull C8927a c8927a, AdResultData adResultData, boolean z) {
        C9829d.m27584a(c8927a.f28803Mv.adScene, c8927a.m29590qx(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            c8927a.f28805Ru.mo29609a(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg, z);
        } else {
            c8927a.f28805Ru.mo29608a(adResultData, z);
        }
    }

    /* renamed from: ax */
    public final void m29592ax(String str) {
        this.f28804RA = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.f28803Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.f28803Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.f28803Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    /* renamed from: qw */
    public final InterfaceC8924i m29591qw() {
        return this.f28806Rv;
    }

    /* renamed from: qx */
    public final String m29590qx() {
        return !TextUtils.isEmpty(this.f28804RA) ? this.f28804RA : "network_only";
    }

    private C8927a(C8928a c8928a) {
        this.f28803Mv = c8928a.f28811Mv;
        this.f28805Ru = c8928a.f28813Ru;
        this.f28808Rx = c8928a.f28814Rx;
        this.f28809Ry = c8928a.f28815Ry;
        this.f28806Rv = c8928a.f28812RB;
    }

    /* renamed from: a */
    public static void m29594a(@NonNull C8927a c8927a, int i, String str, boolean z) {
        c8927a.f28805Ru.mo29609a(i, str, z);
        C9829d.m27587a(c8927a.getAdStyle(), i, str, c8927a.m29590qx());
    }
}
