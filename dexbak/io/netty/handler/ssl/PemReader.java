package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class PemReader {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PemReader.class);
    private static final Pattern CERT_PATTERN = Pattern.compile("-+BEGIN\\s+.*CERTIFICATE[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*CERTIFICATE[^-]*-+", 2);
    private static final Pattern KEY_PATTERN = Pattern.compile("-+BEGIN\\s+.*PRIVATE\\s+KEY[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*PRIVATE\\s+KEY[^-]*-+", 2);

    private PemReader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf[] readCertificates(File file) throws CertificateException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteBuf[] readCertificates = readCertificates(fileInputStream);
            safeClose(fileInputStream);
            return readCertificates;
        } catch (FileNotFoundException unused) {
            throw new CertificateException("could not find certificate file: " + file);
        }
    }

    private static String readContent(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return byteArrayOutputStream.toString(CharsetUtil.US_ASCII.name());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            safeClose(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf readPrivateKey(File file) throws KeyException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteBuf readPrivateKey = readPrivateKey(fileInputStream);
            safeClose(fileInputStream);
            return readPrivateKey;
        } catch (FileNotFoundException unused) {
            throw new KeyException("could not fine key file: " + file);
        }
    }

    private static void safeClose(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.warn("Failed to close a stream.", (Throwable) e);
        }
    }

    private static void safeClose(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            logger.warn("Failed to close a stream.", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf[] readCertificates(InputStream inputStream) throws CertificateException {
        try {
            String readContent = readContent(inputStream);
            ArrayList arrayList = new ArrayList();
            Matcher matcher = CERT_PATTERN.matcher(readContent);
            for (int i = 0; matcher.find(i); i = matcher.end()) {
                ByteBuf copiedBuffer = Unpooled.copiedBuffer(matcher.group(1), CharsetUtil.US_ASCII);
                ByteBuf decode = Base64.decode(copiedBuffer);
                copiedBuffer.release();
                arrayList.add(decode);
            }
            if (!arrayList.isEmpty()) {
                return (ByteBuf[]) arrayList.toArray(new ByteBuf[arrayList.size()]);
            }
            throw new CertificateException("found no certificates in input stream");
        } catch (IOException e) {
            throw new CertificateException("failed to read certificate input stream", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf readPrivateKey(InputStream inputStream) throws KeyException {
        try {
            Matcher matcher = KEY_PATTERN.matcher(readContent(inputStream));
            if (matcher.find()) {
                ByteBuf copiedBuffer = Unpooled.copiedBuffer(matcher.group(1), CharsetUtil.US_ASCII);
                ByteBuf decode = Base64.decode(copiedBuffer);
                copiedBuffer.release();
                return decode;
            }
            throw new KeyException("could not find a PKCS #8 private key in input stream (see http://netty.io/wiki/sslcontextbuilder-and-private-key.html for more information)");
        } catch (IOException e) {
            throw new KeyException("failed to read key input stream", e);
        }
    }
}
