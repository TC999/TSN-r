package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements Comparable<a> {
    public String akf;
    public boolean qs;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
