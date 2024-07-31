package com.sun.mail.smtp;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.StringTokenizer;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DigestMD5 {
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String clientResponse;
    private PrintStream debugout;
    private MessageDigest md5;
    private String uri;

    public DigestMD5(PrintStream printStream) {
        this.debugout = printStream;
        if (printStream != null) {
            printStream.println("DEBUG DIGEST-MD5: Loaded");
        }
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & UByte.f41242c;
            int i3 = i + 1;
            char[] cArr2 = digits;
            cArr[i] = cArr2[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    private Hashtable tokenize(String str) throws IOException {
        Hashtable hashtable = new Hashtable();
        byte[] bytes = str.getBytes();
        StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(new BASE64DecoderStream(new ByteArrayInputStream(bytes, 4, bytes.length - 4))));
        streamTokenizer.ordinaryChars(48, 57);
        streamTokenizer.wordChars(48, 57);
        while (true) {
            String str2 = null;
            while (true) {
                int nextToken = streamTokenizer.nextToken();
                if (nextToken != -1) {
                    if (nextToken == -3) {
                        if (str2 != null) {
                            break;
                        }
                        str2 = streamTokenizer.sval;
                    } else if (nextToken == 34) {
                        break;
                    }
                } else {
                    return hashtable;
                }
            }
            PrintStream printStream = this.debugout;
            if (printStream != null) {
                printStream.println("DEBUG DIGEST-MD5: Received => " + str2 + "='" + streamTokenizer.sval + "'");
            }
            if (hashtable.containsKey(str2)) {
                hashtable.put(str2, hashtable.get(str2) + "," + streamTokenizer.sval);
            } else {
                hashtable.put(str2, streamTokenizer.sval);
            }
        }
    }

    public byte[] authClient(String str, String str2, String str3, String str4, String str5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        try {
            SecureRandom secureRandom = new SecureRandom();
            this.md5 = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            this.uri = "smtp/" + str;
            byte[] bArr = new byte[32];
            PrintStream printStream = this.debugout;
            if (printStream != null) {
                printStream.println("DEBUG DIGEST-MD5: Begin authentication ...");
            }
            Hashtable hashtable = tokenize(str5);
            if (str4 == null) {
                String str6 = (String) hashtable.get("realm");
                if (str6 != null) {
                    str = new StringTokenizer(str6, ",").nextToken();
                }
                str4 = str;
            }
            String str7 = (String) hashtable.get(Constants.NONCE);
            secureRandom.nextBytes(bArr);
            bASE64EncoderStream.write(bArr);
            bASE64EncoderStream.flush();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();
            MessageDigest messageDigest = this.md5;
            messageDigest.update(messageDigest.digest(ASCIIUtility.getBytes(String.valueOf(str2) + ":" + str4 + ":" + str3)));
            MessageDigest messageDigest2 = this.md5;
            messageDigest2.update(ASCIIUtility.getBytes(":" + str7 + ":" + byteArrayOutputStream2));
            this.clientResponse = String.valueOf(toHex(this.md5.digest())) + ":" + str7 + ":00000001:" + byteArrayOutputStream2 + ":auth:";
            MessageDigest messageDigest3 = this.md5;
            StringBuilder sb = new StringBuilder("AUTHENTICATE:");
            sb.append(this.uri);
            messageDigest3.update(ASCIIUtility.getBytes(sb.toString()));
            MessageDigest messageDigest4 = this.md5;
            StringBuilder sb2 = new StringBuilder(String.valueOf(this.clientResponse));
            sb2.append(toHex(this.md5.digest()));
            messageDigest4.update(ASCIIUtility.getBytes(sb2.toString()));
            stringBuffer.append("username=\"" + str2 + "\"");
            stringBuffer.append(",realm=\"" + str4 + "\"");
            StringBuilder sb3 = new StringBuilder(",qop=");
            sb3.append("auth");
            stringBuffer.append(sb3.toString());
            stringBuffer.append(",nc=00000001");
            stringBuffer.append(",nonce=\"" + str7 + "\"");
            stringBuffer.append(",cnonce=\"" + byteArrayOutputStream2 + "\"");
            stringBuffer.append(",digest-uri=\"" + this.uri + "\"");
            StringBuilder sb4 = new StringBuilder(",response=");
            sb4.append(toHex(this.md5.digest()));
            stringBuffer.append(sb4.toString());
            PrintStream printStream2 = this.debugout;
            if (printStream2 != null) {
                printStream2.println("DEBUG DIGEST-MD5: Response => " + stringBuffer.toString());
            }
            bASE64EncoderStream.write(ASCIIUtility.getBytes(stringBuffer.toString()));
            bASE64EncoderStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchAlgorithmException e) {
            PrintStream printStream3 = this.debugout;
            if (printStream3 != null) {
                printStream3.println("DEBUG DIGEST-MD5: " + e);
            }
            throw new IOException(e.toString());
        }
    }

    public boolean authServer(String str) throws IOException {
        Hashtable hashtable = tokenize(str);
        MessageDigest messageDigest = this.md5;
        messageDigest.update(ASCIIUtility.getBytes(":" + this.uri));
        MessageDigest messageDigest2 = this.md5;
        messageDigest2.update(ASCIIUtility.getBytes(String.valueOf(this.clientResponse) + toHex(this.md5.digest())));
        String hex = toHex(this.md5.digest());
        if (hex.equals((String) hashtable.get("rspauth"))) {
            return true;
        }
        PrintStream printStream = this.debugout;
        if (printStream != null) {
            printStream.println("DEBUG DIGEST-MD5: Expected => rspauth=" + hex);
            return false;
        }
        return false;
    }
}
