package com.sun.mail.imap;

/* renamed from: com.sun.mail.imap.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ACL implements Cloneable {

    /* renamed from: a */
    private String f35886a;

    /* renamed from: b */
    private Rights f35887b;

    public ACL(String str) {
        this.f35886a = str;
        this.f35887b = new Rights();
    }

    /* renamed from: a */
    public String m16378a() {
        return this.f35886a;
    }

    /* renamed from: b */
    public Rights m16377b() {
        return this.f35887b;
    }

    /* renamed from: c */
    public void m16376c(Rights rights) {
        this.f35887b = rights;
    }

    public Object clone() throws CloneNotSupportedException {
        ACL acl = (ACL) super.clone();
        acl.f35887b = (Rights) this.f35887b.clone();
        return acl;
    }

    public ACL(String str, Rights rights) {
        this.f35886a = str;
        this.f35887b = rights;
    }
}
