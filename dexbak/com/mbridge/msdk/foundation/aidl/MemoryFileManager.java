package com.mbridge.msdk.foundation.aidl;

import android.os.MemoryFile;
import java.io.FileDescriptor;

/* renamed from: com.mbridge.msdk.foundation.aidl.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MemoryFileManager {
    /* renamed from: a */
    public static FileDescriptor m22937a(MemoryFile memoryFile) {
        try {
            Object m22936a = ReflectUtils.m22936a("android.os.MemoryFile", memoryFile, "getFileDescriptor", new Object[0]);
            if (m22936a != null) {
                return (FileDescriptor) m22936a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
