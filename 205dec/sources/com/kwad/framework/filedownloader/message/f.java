package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f {
    public static MessageSnapshot a(int i4, File file, boolean z3) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z3) {
                return new d.a(i4, true, length);
            }
            return new d.b(i4, true, length);
        } else if (z3) {
            return new h.a(i4, true, (int) length);
        } else {
            return new h.b(i4, true, (int) length);
        }
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.ub()) {
            return new d.e(aVar.getId(), aVar.tT(), aVar.tU());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.tV() == -3) {
            return new a.C0673a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV())));
    }

    public static MessageSnapshot a(int i4, long j4, long j5, boolean z3) {
        if (j5 > 2147483647L) {
            if (z3) {
                return new d.i(i4, j4, j5);
            }
            return new d.j(i4, j4, j5);
        } else if (z3) {
            return new h.i(i4, (int) j4, (int) j5);
        } else {
            return new h.j(i4, (int) j4, (int) j5);
        }
    }

    public static MessageSnapshot a(int i4, long j4, Throwable th) {
        if (j4 > 2147483647L) {
            return new d.C0674d(i4, j4, th);
        }
        return new h.d(i4, (int) j4, th);
    }

    public static MessageSnapshot a(byte b4, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b4 != -4) {
            if (b4 == -3) {
                if (cVar.ub()) {
                    return new d.b(id, false, cVar.getTotal());
                }
                return new h.b(id, false, (int) cVar.getTotal());
            }
            if (b4 != -1) {
                if (b4 == 1) {
                    if (cVar.ub()) {
                        return new d.f(id, cVar.wl(), cVar.getTotal());
                    }
                    return new h.f(id, (int) cVar.wl(), (int) cVar.getTotal());
                } else if (b4 == 2) {
                    String filename = cVar.tR() ? cVar.getFilename() : null;
                    if (cVar.ub()) {
                        return new d.c(id, aVar.vQ(), cVar.getTotal(), cVar.wm(), filename);
                    }
                    return new h.c(id, aVar.vQ(), (int) cVar.getTotal(), cVar.wm(), filename);
                } else if (b4 == 3) {
                    if (cVar.ub()) {
                        return new d.g(id, cVar.wl());
                    }
                    return new h.g(id, (int) cVar.wl());
                } else if (b4 != 5) {
                    if (b4 != 6) {
                        String b5 = com.kwad.framework.filedownloader.f.f.b("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b4));
                        com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b4));
                        if (aVar.getException() != null) {
                            illegalStateException = new IllegalStateException(b5, aVar.getException());
                        } else {
                            illegalStateException = new IllegalStateException(b5);
                        }
                        if (cVar.ub()) {
                            return new d.C0674d(id, cVar.wl(), illegalStateException);
                        }
                        return new h.d(id, (int) cVar.wl(), illegalStateException);
                    }
                    return new MessageSnapshot.b(id);
                } else if (cVar.ub()) {
                    dVar = new d.h(id, cVar.wl(), aVar.getException(), aVar.tZ());
                } else {
                    dVar = new h.C0675h(id, (int) cVar.wl(), aVar.getException(), aVar.tZ());
                }
            } else if (cVar.ub()) {
                dVar = new d.C0674d(id, cVar.wl(), aVar.getException());
            } else {
                dVar = new h.d(id, (int) cVar.wl(), aVar.getException());
            }
            return dVar;
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("please use #catchWarn instead %d", Integer.valueOf(id)));
    }
}
