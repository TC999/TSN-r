package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.slf4j.helpers.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class NamedLoggerBase implements InterfaceC15424c, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // org.slf4j.InterfaceC15424c
    public String getName() {
        return this.name;
    }

    protected Object readResolve() throws ObjectStreamException {
        return LoggerFactory.m2655j(getName());
    }
}
