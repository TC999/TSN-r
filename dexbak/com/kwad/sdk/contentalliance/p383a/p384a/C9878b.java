package com.kwad.sdk.contentalliance.p383a.p384a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* renamed from: com.kwad.sdk.contentalliance.a.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9878b {
    public AdTemplate adTemplate;
    public C9877a aoR;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* renamed from: com.kwad.sdk.contentalliance.a.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9879a {
        private AdTemplate adTemplate;
        private C9877a aoR;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public C9879a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* renamed from: Bb */
        public final C9878b m27477Bb() {
            return new C9878b(this, (byte) 0);
        }

        /* renamed from: bl */
        public final C9879a m27472bl(boolean z) {
            this.isNoCache = z;
            return this;
        }

        /* renamed from: cR */
        public final C9879a m27470cR(String str) {
            this.videoUrl = str;
            return this;
        }

        /* renamed from: cS */
        public final C9879a m27469cS(String str) {
            this.manifest = str;
            return this;
        }

        /* renamed from: a */
        public final C9879a m27475a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        /* renamed from: b */
        public final C9879a m27474b(@NonNull C9877a c9877a) {
            this.aoR = c9877a;
            return this;
        }

        public C9879a(String str) {
            this.videoUrl = str;
        }
    }

    /* synthetic */ C9878b(C9879a c9879a, byte b) {
        this(c9879a);
    }

    private C9878b(C9879a c9879a) {
        this.aoR = new C9877a();
        this.isNoCache = false;
        this.adTemplate = c9879a.adTemplate;
        this.videoUrl = c9879a.videoUrl;
        this.manifest = c9879a.manifest;
        this.videoPlayerStatus = c9879a.videoPlayerStatus;
        if (c9879a.aoR != null) {
            this.aoR.photoId = c9879a.aoR.photoId;
            this.aoR.clickTime = c9879a.aoR.clickTime;
            this.aoR.adStyle = c9879a.aoR.adStyle;
            this.aoR.contentType = c9879a.aoR.contentType;
        }
        this.isNoCache = c9879a.isNoCache;
    }
}
