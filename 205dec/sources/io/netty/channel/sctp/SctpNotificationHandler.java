package io.netty.channel.sctp;

import com.sun.nio.sctp.AbstractNotificationHandler;
import com.sun.nio.sctp.AssociationChangeNotification;
import com.sun.nio.sctp.HandlerResult;
import com.sun.nio.sctp.Notification;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import com.sun.nio.sctp.SendFailedNotification;
import com.sun.nio.sctp.ShutdownNotification;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SctpNotificationHandler extends AbstractNotificationHandler<Object> {
    private final SctpChannel sctpChannel;

    public SctpNotificationHandler(SctpChannel sctpChannel) {
        if (sctpChannel != null) {
            this.sctpChannel = sctpChannel;
            return;
        }
        throw new NullPointerException("sctpChannel");
    }

    private void fireEvent(Notification notification) {
        this.sctpChannel.pipeline().fireUserEventTriggered((Object) notification);
    }

    public HandlerResult handleNotification(AssociationChangeNotification associationChangeNotification, Object obj) {
        fireEvent(associationChangeNotification);
        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(PeerAddressChangeNotification peerAddressChangeNotification, Object obj) {
        fireEvent(peerAddressChangeNotification);
        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(SendFailedNotification sendFailedNotification, Object obj) {
        fireEvent(sendFailedNotification);
        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(ShutdownNotification shutdownNotification, Object obj) {
        fireEvent(shutdownNotification);
        this.sctpChannel.close();
        return HandlerResult.RETURN;
    }
}
