package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final long f28794a = Os.sysconf(OsConstants._SC_PAGESIZE);

    /* renamed from: b  reason: collision with root package name */
    private final FileDescriptor f28795b;

    /* renamed from: c  reason: collision with root package name */
    private final long f28796c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28797d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FileDescriptor fileDescriptor, long j4, long j5) {
        this.f28795b = fileDescriptor;
        this.f28796c = j4;
        this.f28797d = j5;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f28797d;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
