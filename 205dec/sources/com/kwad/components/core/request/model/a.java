package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.i;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    @NonNull
    public final ImpInfo Mv;
    private String RA;
    @NonNull
    public final com.kwad.components.core.request.c Ru;
    @Nullable
    public i Rv;
    @Nullable
    public List<String> Rw;
    public boolean Rx;
    public boolean Ry;
    @Nullable
    public c Rz;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.request.model.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0649a {
        public ImpInfo Mv;
        public i RB;
        public com.kwad.components.core.request.c Ru;
        public boolean Rx;
        public boolean Ry;

        public final C0649a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Ru = cVar;
            return this;
        }

        public final C0649a aI(boolean z3) {
            this.Rx = true;
            return this;
        }

        public final C0649a aJ(boolean z3) {
            this.Ry = z3;
            return this;
        }

        public final C0649a e(ImpInfo impInfo) {
            this.Mv = impInfo;
            return this;
        }

        public final a qy() {
            if (com.kwad.components.ad.e.a.md.booleanValue() && (this.Mv == null || this.Ru == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0649a a(i iVar) {
            this.RB = iVar;
            return this;
        }
    }

    /* synthetic */ a(C0649a c0649a, byte b4) {
        this(c0649a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z3) {
        d.a(aVar.Mv.adScene, aVar.qx(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Ru.a(e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.avy.msg : adResultData.testErrorMsg, z3);
        } else {
            aVar.Ru.a(adResultData, z3);
        }
    }

    public final void ax(String str) {
        this.RA = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final i qw() {
        return this.Rv;
    }

    public final String qx() {
        return !TextUtils.isEmpty(this.RA) ? this.RA : "network_only";
    }

    private a(C0649a c0649a) {
        this.Mv = c0649a.Mv;
        this.Ru = c0649a.Ru;
        this.Rx = c0649a.Rx;
        this.Ry = c0649a.Ry;
        this.Rv = c0649a.RB;
    }

    public static void a(@NonNull a aVar, int i4, String str, boolean z3) {
        aVar.Ru.a(i4, str, z3);
        d.a(aVar.getAdStyle(), i4, str, aVar.qx());
    }
}
