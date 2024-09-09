package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Transport extends Service {
    private Vector transportListeners;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
        this.transportListeners = null;
    }

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    private static void send0(Message message, Address[] addressArr) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        Transport transport;
        if (addressArr != null && addressArr.length != 0) {
            Hashtable hashtable = new Hashtable();
            Vector vector = new Vector();
            Vector vector2 = new Vector();
            Vector vector3 = new Vector();
            for (int i4 = 0; i4 < addressArr.length; i4++) {
                if (hashtable.containsKey(addressArr[i4].getType())) {
                    ((Vector) hashtable.get(addressArr[i4].getType())).addElement(addressArr[i4]);
                } else {
                    Vector vector4 = new Vector();
                    vector4.addElement(addressArr[i4]);
                    hashtable.put(addressArr[i4].getType(), vector4);
                }
            }
            int size = hashtable.size();
            if (size != 0) {
                Session session = message.session;
                Address[] addressArr4 = null;
                if (session == null) {
                    session = Session.getDefaultInstance(System.getProperties(), null);
                }
                if (size == 1) {
                    transport = session.getTransport(addressArr[0]);
                    try {
                        transport.connect();
                        transport.sendMessage(message, addressArr);
                        return;
                    } finally {
                    }
                }
                Enumeration elements = hashtable.elements();
                SendFailedException sendFailedException = null;
                boolean z3 = false;
                while (elements.hasMoreElements()) {
                    Vector vector5 = (Vector) elements.nextElement();
                    int size2 = vector5.size();
                    Address[] addressArr5 = new Address[size2];
                    vector5.copyInto(addressArr5);
                    transport = session.getTransport(addressArr5[0]);
                    if (transport == null) {
                        for (int i5 = 0; i5 < size2; i5++) {
                            vector.addElement(addressArr5[i5]);
                        }
                    } else {
                        try {
                            try {
                                transport.connect();
                                transport.sendMessage(message, addressArr5);
                            } catch (SendFailedException e4) {
                                if (sendFailedException == null) {
                                    sendFailedException = e4;
                                } else {
                                    sendFailedException.setNextException(e4);
                                }
                                Address[] invalidAddresses = e4.getInvalidAddresses();
                                if (invalidAddresses != null) {
                                    for (Address address : invalidAddresses) {
                                        vector.addElement(address);
                                    }
                                }
                                Address[] validSentAddresses = e4.getValidSentAddresses();
                                if (validSentAddresses != null) {
                                    for (Address address2 : validSentAddresses) {
                                        vector2.addElement(address2);
                                    }
                                }
                                Address[] validUnsentAddresses = e4.getValidUnsentAddresses();
                                if (validUnsentAddresses != null) {
                                    for (Address address3 : validUnsentAddresses) {
                                        vector3.addElement(address3);
                                    }
                                }
                                transport.close();
                                z3 = true;
                            } catch (MessagingException e5) {
                                if (sendFailedException == null) {
                                    sendFailedException = e5;
                                } else {
                                    sendFailedException.setNextException(e5);
                                }
                                transport.close();
                                z3 = true;
                            }
                        } finally {
                        }
                    }
                }
                if (!z3 && vector.size() == 0 && vector3.size() == 0) {
                    return;
                }
                if (vector2.size() > 0) {
                    Address[] addressArr6 = new Address[vector2.size()];
                    vector2.copyInto(addressArr6);
                    addressArr2 = addressArr6;
                } else {
                    addressArr2 = null;
                }
                if (vector3.size() > 0) {
                    Address[] addressArr7 = new Address[vector3.size()];
                    vector3.copyInto(addressArr7);
                    addressArr3 = addressArr7;
                } else {
                    addressArr3 = null;
                }
                if (vector.size() > 0) {
                    addressArr4 = new Address[vector.size()];
                    vector.copyInto(addressArr4);
                }
                throw new SendFailedException("Sending failed", sendFailedException, addressArr2, addressArr3, addressArr4);
            }
            throw new SendFailedException("No recipient addresses");
        }
        throw new SendFailedException("No recipient addresses");
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector();
        }
        this.transportListeners.addElement(transportListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyTransportListeners(int i4, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners == null) {
            return;
        }
        queueEvent(new TransportEvent(this, i4, addressArr, addressArr2, addressArr3, message), this.transportListeners);
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        Vector vector = this.transportListeners;
        if (vector != null) {
            vector.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr);
    }
}
