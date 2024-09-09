package com.sun.mail.handlers;

import javax.activation.ActivationDataFlavor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class text_xml extends text_plain {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(String.class, "text/xml", "XML String");

    @Override // com.sun.mail.handlers.text_plain
    protected ActivationDataFlavor getDF() {
        return myDF;
    }
}
