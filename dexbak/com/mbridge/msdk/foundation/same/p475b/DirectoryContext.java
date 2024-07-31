package com.mbridge.msdk.foundation.same.p475b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class DirectoryContext {

    /* renamed from: a */
    protected Directory f30628a;

    public DirectoryContext(String str) {
        Directory directory = new Directory();
        directory.m22360a(str);
        directory.m22362a(MBridgeDir.AD_ROOT);
        List<Directory> mo22353b = mo22353b();
        if (mo22353b != null && mo22353b.size() > 0) {
            directory.m22359a(mo22353b);
        }
        this.f30628a = directory;
    }

    /* renamed from: a */
    public final Directory m22355a() {
        return this.f30628a;
    }

    /* renamed from: b */
    protected abstract List<Directory> mo22353b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Directory m22354a(ArrayList<Directory> arrayList, MBridgeDir mBridgeDir, String str) {
        Directory directory = new Directory();
        directory.m22362a(mBridgeDir);
        directory.m22360a(str);
        arrayList.add(directory);
        return directory;
    }
}
