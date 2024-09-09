package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: NamedLoggerBase.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g implements org.slf4j.c, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // org.slf4j.c
    public String getName() {
        return this.name;
    }

    protected Object readResolve() throws ObjectStreamException {
        return org.slf4j.d.j(getName());
    }
}
