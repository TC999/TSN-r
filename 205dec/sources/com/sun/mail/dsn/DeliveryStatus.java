package com.sun.mail.dsn;

import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DeliveryStatus {
    private static boolean debug;
    protected InternetHeaders messageDSN;
    protected InternetHeaders[] recipientDSN;

    static {
        try {
            String property = System.getProperty("mail.dsn.debug");
            debug = (property == null || property.equalsIgnoreCase("false")) ? false : true;
        } catch (SecurityException unused) {
        }
    }

    public DeliveryStatus() throws MessagingException {
        this.messageDSN = new InternetHeaders();
        this.recipientDSN = new InternetHeaders[0];
    }

    private static void writeInternetHeaders(InternetHeaders internetHeaders, LineOutputStream lineOutputStream) throws IOException {
        Enumeration allHeaderLines = internetHeaders.getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            try {
                lineOutputStream.writeln((String) allHeaderLines.nextElement());
            } catch (MessagingException e4) {
                Exception nextException = e4.getNextException();
                if (nextException instanceof IOException) {
                    throw ((IOException) nextException);
                }
                throw new IOException("Exception writing headers: " + e4);
            }
        }
    }

    public void addRecipientDSN(InternetHeaders internetHeaders) {
        InternetHeaders[] internetHeadersArr = this.recipientDSN;
        InternetHeaders[] internetHeadersArr2 = new InternetHeaders[internetHeadersArr.length + 1];
        System.arraycopy(internetHeadersArr, 0, internetHeadersArr2, 0, internetHeadersArr.length);
        this.recipientDSN = internetHeadersArr2;
        internetHeadersArr2[internetHeadersArr2.length - 1] = internetHeaders;
    }

    public InternetHeaders getMessageDSN() {
        return this.messageDSN;
    }

    public InternetHeaders getRecipientDSN(int i4) {
        return this.recipientDSN[i4];
    }

    public int getRecipientDSNCount() {
        return this.recipientDSN.length;
    }

    public void setMessageDSN(InternetHeaders internetHeaders) {
        this.messageDSN = internetHeaders;
    }

    public String toString() {
        return "DeliveryStatus: Reporting-MTA=" + this.messageDSN.getHeader("Reporting-MTA", null) + ", #Recipients=" + this.recipientDSN.length;
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        LineOutputStream lineOutputStream;
        if (outputStream instanceof LineOutputStream) {
            lineOutputStream = (LineOutputStream) outputStream;
        } else {
            lineOutputStream = new LineOutputStream(outputStream);
        }
        writeInternetHeaders(this.messageDSN, lineOutputStream);
        lineOutputStream.writeln();
        int i4 = 0;
        while (true) {
            InternetHeaders[] internetHeadersArr = this.recipientDSN;
            if (i4 >= internetHeadersArr.length) {
                return;
            }
            writeInternetHeaders(internetHeadersArr[i4], lineOutputStream);
            lineOutputStream.writeln();
            i4++;
        }
    }

    public DeliveryStatus(InputStream inputStream) throws MessagingException, IOException {
        this.messageDSN = new InternetHeaders(inputStream);
        if (debug) {
            System.out.println("DSN: got messageDSN");
        }
        Vector vector = new Vector();
        while (inputStream.available() > 0) {
            try {
                InternetHeaders internetHeaders = new InternetHeaders(inputStream);
                if (debug) {
                    System.out.println("DSN: got recipientDSN");
                }
                vector.addElement(internetHeaders);
            } catch (EOFException unused) {
                if (debug) {
                    System.out.println("DSN: got EOFException");
                }
            }
        }
        if (debug) {
            PrintStream printStream = System.out;
            printStream.println("DSN: recipientDSN size " + vector.size());
        }
        InternetHeaders[] internetHeadersArr = new InternetHeaders[vector.size()];
        this.recipientDSN = internetHeadersArr;
        vector.copyInto(internetHeadersArr);
    }
}
