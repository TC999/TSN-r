package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.sdk.core.download.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10326d implements InterfaceC10325c {
    private AdInfo mAdInfo;

    public C10326d(AdTemplate adTemplate) {
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26283a(String str, int i, int i2, int i3) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26282a(String str, int i, String str2, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26281a(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26280a(String str, String str2, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26279a(String str, Throwable th, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: b */
    public final void mo26278b(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: b */
    public void mo26277b(String str, String str2, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: c */
    public final void mo26276c(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: d */
    public final void mo26275d(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: e */
    public final void mo26274e(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: f */
    public final void mo26273f(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: g */
    public final void mo26272g(String str, C10327e c10327e) {
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: nX */
    public final String mo26271nX() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: nY */
    public final String mo26270nY() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}
