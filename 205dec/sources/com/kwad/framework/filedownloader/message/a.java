package com.kwad.framework.filedownloader.message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.framework.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0673a extends MessageSnapshot implements a {
        private final MessageSnapshot ahl;

        public C0673a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.tV() == -3) {
                this.ahl = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV())));
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot vX() {
            return this.ahl;
        }
    }

    MessageSnapshot vX();
}
