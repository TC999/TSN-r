package com.kwad.library.solder.lib.p362c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.kwad.library.solder.lib.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9617b implements Comparable<C9617b> {

    /* renamed from: Jd */
    public boolean f29489Jd;
    public String ajI;
    public boolean ajJ;
    public String akf;
    public String akg;
    public long akh;
    public String aki;
    public boolean akj = false;
    public boolean akk = true;
    public HashMap<String, String> akl = new HashMap<>(10);
    public List<String> akm;
    public List<String> akn;
    public ClassLoader ako;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(@NonNull C9617b c9617b) {
        return -this.version.compareTo(c9617b.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.akf + "', version='" + this.version + "', downloadUrl='" + this.akg + "', fileSize=" + this.akh + ", enable=" + this.f29489Jd + ", md5sum='" + this.aki + "', onlyWifiDownload=" + this.akj + ", onlyWifiRetryDownload=" + this.akk + ", soMd5s=" + this.akl + ", hostPackages=" + this.akm + ", hostInterfaces=" + this.akn + '}';
    }
}
