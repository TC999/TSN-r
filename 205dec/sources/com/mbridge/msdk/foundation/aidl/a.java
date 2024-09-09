package com.mbridge.msdk.foundation.aidl;

import android.os.MemoryFile;
import java.io.FileDescriptor;

/* compiled from: MemoryFileManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static FileDescriptor a(MemoryFile memoryFile) {
        try {
            Object a4 = b.a("android.os.MemoryFile", memoryFile, "getFileDescriptor", new Object[0]);
            if (a4 != null) {
                return (FileDescriptor) a4;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
