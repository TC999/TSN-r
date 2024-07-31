package com.sun.mail.handlers;

import javax.activation.ActivationDataFlavor;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class text_html extends text_plain {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(String.class, "text/html", "HTML String");

    @Override // com.sun.mail.handlers.text_plain
    protected ActivationDataFlavor getDF() {
        return myDF;
    }
}
