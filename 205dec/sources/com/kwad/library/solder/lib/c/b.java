package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements Comparable<b> {
    public boolean Jd;
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
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.akf + "', version='" + this.version + "', downloadUrl='" + this.akg + "', fileSize=" + this.akh + ", enable=" + this.Jd + ", md5sum='" + this.aki + "', onlyWifiDownload=" + this.akj + ", onlyWifiRetryDownload=" + this.akk + ", soMd5s=" + this.akl + ", hostPackages=" + this.akm + ", hostInterfaces=" + this.akn + '}';
    }
}
