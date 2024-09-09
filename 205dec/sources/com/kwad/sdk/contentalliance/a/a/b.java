package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public AdTemplate adTemplate;
    public com.kwad.sdk.contentalliance.a.a.a aoR;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private AdTemplate adTemplate;
        private com.kwad.sdk.contentalliance.a.a.a aoR;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final b Bb() {
            return new b(this, (byte) 0);
        }

        public final a bl(boolean z3) {
            this.isNoCache = z3;
            return this;
        }

        public final a cR(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a cS(String str) {
            this.manifest = str;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.aoR = aVar;
            return this;
        }

        public a(String str) {
            this.videoUrl = str;
        }
    }

    /* synthetic */ b(a aVar, byte b4) {
        this(aVar);
    }

    private b(a aVar) {
        this.aoR = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.aoR != null) {
            this.aoR.photoId = aVar.aoR.photoId;
            this.aoR.clickTime = aVar.aoR.clickTime;
            this.aoR.adStyle = aVar.aoR.adStyle;
            this.aoR.contentType = aVar.aoR.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }
}
