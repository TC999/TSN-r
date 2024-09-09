package com.kwad.sdk.crash.utils;

import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(String str) {
        super(str);
    }

    public FileExistsException(File file) {
        super("File " + file + " already exists");
    }
}
