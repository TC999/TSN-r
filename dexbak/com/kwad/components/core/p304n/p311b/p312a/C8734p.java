package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.C11075bv;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.kwad.components.core.n.b.a.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8734p implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return C11075bv.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return C11075bv.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        C11075bv.zipFile(file);
    }
}
