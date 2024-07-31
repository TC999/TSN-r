package com.sun.mail.iap;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.sun.mail.iap.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Literal {
    int size();

    void writeTo(OutputStream outputStream) throws IOException;
}
