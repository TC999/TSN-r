package com.umeng.commonsdk.utils;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface FileLockCallback {
    boolean onFileLock(File file, int i4);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}
