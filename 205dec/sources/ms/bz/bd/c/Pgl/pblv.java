package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class pblv implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f61451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pblv(pblu pbluVar, String str) {
        this.f61451a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f61451a);
    }
}
