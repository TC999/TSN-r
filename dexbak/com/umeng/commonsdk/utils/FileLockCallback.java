package com.umeng.commonsdk.utils;

import java.io.File;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface FileLockCallback {
    boolean onFileLock(File file, int i);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}
