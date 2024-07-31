package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.p353f.C9501f;

/* renamed from: com.kwad.framework.filedownloader.message.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9517a {

    /* renamed from: com.kwad.framework.filedownloader.message.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9518a extends MessageSnapshot implements InterfaceC9517a {
        private final MessageSnapshot ahl;

        public C9518a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.mo28442tV() == -3) {
                this.ahl = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(C9501f.m28515b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.mo28442tV())));
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9517a
        /* renamed from: vX */
        public final MessageSnapshot mo28466vX() {
            return this.ahl;
        }
    }

    /* renamed from: vX */
    MessageSnapshot mo28466vX();
}
