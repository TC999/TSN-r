package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.utils.C10977a;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11032ax;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kwad.components.core.n.b.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8706c implements IEncrypt {
    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileMD5(File file) {
        return C10977a.getFileMD5(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final byte[] getFileMD5Digest(File file) {
        try {
            return C10977a.getFileMD5Digest(file);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileSha256(File file) {
        return C11032ax.m23990ac(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getMD5(String str) {
        return C11010ad.m24144bu(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getResponseData(String str) {
        return C9889d.getResponseData(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getSha256(String str) {
        return C11032ax.m23989gJ(str);
    }
}
