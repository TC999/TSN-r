package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9501f;

/* renamed from: com.kwad.framework.filedownloader.services.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9565b implements C9492c.InterfaceC9496d {
    @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9496d
    /* renamed from: f */
    public final int mo28406f(String str, String str2, boolean z) {
        return mo28405g(str, str2, z);
    }

    @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9496d
    /* renamed from: g */
    public final int mo28405g(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (z) {
                return C9501f.m28507bu(C9501f.m28515b("%sp%s@dir", str, str2)).hashCode();
            }
            return C9501f.m28507bu(C9501f.m28515b("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
