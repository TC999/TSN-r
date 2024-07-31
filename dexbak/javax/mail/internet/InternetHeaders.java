package javax.mail.internet;

import com.sun.mail.util.LineInputStream;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.mail.Header;
import javax.mail.MessagingException;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class InternetHeaders {
    protected List headers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class matchEnum implements Enumeration {

        /* renamed from: e */
        private Iterator f40790e;
        private boolean match;
        private String[] names;
        private InternetHeader next_header = null;
        private boolean want_line;

        matchEnum(List list, String[] strArr, boolean z, boolean z2) {
            this.f40790e = list.iterator();
            this.names = strArr;
            this.match = z;
            this.want_line = z2;
        }

        private InternetHeader nextMatch() {
            while (this.f40790e.hasNext()) {
                InternetHeader internetHeader = (InternetHeader) this.f40790e.next();
                if (internetHeader.line != null) {
                    if (this.names == null) {
                        if (this.match) {
                            return null;
                        }
                        return internetHeader;
                    }
                    int i = 0;
                    while (true) {
                        String[] strArr = this.names;
                        if (i >= strArr.length) {
                            if (!this.match) {
                                return internetHeader;
                            }
                        } else if (!strArr[i].equalsIgnoreCase(internetHeader.getName())) {
                            i++;
                        } else if (this.match) {
                            return internetHeader;
                        }
                    }
                }
            }
            return null;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            return this.next_header != null;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            InternetHeader internetHeader = this.next_header;
            if (internetHeader != null) {
                this.next_header = null;
                if (this.want_line) {
                    return internetHeader.line;
                }
                return new Header(internetHeader.getName(), internetHeader.getValue());
            }
            throw new NoSuchElementException("No more headers");
        }
    }

    public InternetHeaders() {
        ArrayList arrayList = new ArrayList(40);
        this.headers = arrayList;
        arrayList.add(new InternetHeader("Return-Path", null));
        this.headers.add(new InternetHeader("Received", null));
        this.headers.add(new InternetHeader("Resent-Date", null));
        this.headers.add(new InternetHeader("Resent-From", null));
        this.headers.add(new InternetHeader("Resent-Sender", null));
        this.headers.add(new InternetHeader("Resent-To", null));
        this.headers.add(new InternetHeader("Resent-Cc", null));
        this.headers.add(new InternetHeader("Resent-Bcc", null));
        this.headers.add(new InternetHeader("Resent-Message-Id", null));
        this.headers.add(new InternetHeader("Date", null));
        this.headers.add(new InternetHeader("From", null));
        this.headers.add(new InternetHeader("Sender", null));
        this.headers.add(new InternetHeader("Reply-To", null));
        this.headers.add(new InternetHeader("To", null));
        this.headers.add(new InternetHeader("Cc", null));
        this.headers.add(new InternetHeader("Bcc", null));
        this.headers.add(new InternetHeader("Message-Id", null));
        this.headers.add(new InternetHeader("In-Reply-To", null));
        this.headers.add(new InternetHeader("References", null));
        this.headers.add(new InternetHeader("Subject", null));
        this.headers.add(new InternetHeader("Comments", null));
        this.headers.add(new InternetHeader("Keywords", null));
        this.headers.add(new InternetHeader("Errors-To", null));
        this.headers.add(new InternetHeader("MIME-Version", null));
        this.headers.add(new InternetHeader("Content-Type", null));
        this.headers.add(new InternetHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, null));
        this.headers.add(new InternetHeader(HttpHeaders.Names.CONTENT_MD5, null));
        this.headers.add(new InternetHeader(":", null));
        this.headers.add(new InternetHeader("Content-Length", null));
        this.headers.add(new InternetHeader("Status", null));
    }

    public void addHeader(String str, String str2) {
        int size = this.headers.size();
        boolean z = str.equalsIgnoreCase("Received") || str.equalsIgnoreCase("Return-Path");
        if (z) {
            size = 0;
        }
        for (int size2 = this.headers.size() - 1; size2 >= 0; size2--) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(size2);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z) {
                    this.headers.add(size2 + 1, new InternetHeader(str, str2));
                    return;
                }
                size = size2;
            }
            if (internetHeader.getName().equals(":")) {
                size = size2;
            }
        }
        this.headers.add(size, new InternetHeader(str, str2));
    }

    public void addHeaderLine(String str) {
        try {
            char charAt = str.charAt(0);
            if (charAt != ' ' && charAt != '\t') {
                this.headers.add(new InternetHeader(str));
            }
            List list = this.headers;
            InternetHeader internetHeader = (InternetHeader) list.get(list.size() - 1);
            internetHeader.line = String.valueOf(internetHeader.line) + "\r\n" + str;
        } catch (StringIndexOutOfBoundsException | NoSuchElementException unused) {
        }
    }

    public Enumeration getAllHeaderLines() {
        return getNonMatchingHeaderLines(null);
    }

    public Enumeration getAllHeaders() {
        return new matchEnum(this.headers, null, false, false);
    }

    public String[] getHeader(String str) {
        ArrayList arrayList = new ArrayList();
        for (InternetHeader internetHeader : this.headers) {
            if (str.equalsIgnoreCase(internetHeader.getName()) && internetHeader.line != null) {
                arrayList.add(internetHeader.getValue());
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, true);
    }

    public Enumeration getMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, false);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, true);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, false);
    }

    public void load(InputStream inputStream) throws MessagingException {
        String readLine;
        LineInputStream lineInputStream = new LineInputStream(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        String str = null;
        do {
            try {
                readLine = lineInputStream.readLine();
                if (readLine == null || !(readLine.startsWith(" ") || readLine.startsWith("\t"))) {
                    if (str != null) {
                        addHeaderLine(str);
                    } else if (stringBuffer.length() > 0) {
                        addHeaderLine(stringBuffer.toString());
                        stringBuffer.setLength(0);
                    }
                    str = readLine;
                } else {
                    if (str != null) {
                        stringBuffer.append(str);
                        str = null;
                    }
                    stringBuffer.append("\r\n");
                    stringBuffer.append(readLine);
                }
                if (readLine == null) {
                    return;
                }
            } catch (IOException e) {
                throw new MessagingException("Error in input stream", e);
            }
        } while (readLine.length() > 0);
    }

    public void removeHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                internetHeader.line = null;
            }
        }
    }

    public void setHeader(String str, String str2) {
        int indexOf;
        int i = 0;
        boolean z = false;
        while (i < this.headers.size()) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z) {
                    String str3 = internetHeader.line;
                    if (str3 != null && (indexOf = str3.indexOf(58)) >= 0) {
                        internetHeader.line = String.valueOf(internetHeader.line.substring(0, indexOf + 1)) + " " + str2;
                    } else {
                        internetHeader.line = str + ": " + str2;
                    }
                    z = true;
                } else {
                    this.headers.remove(i);
                    i--;
                }
            }
            i++;
        }
        if (z) {
            return;
        }
        addHeader(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class InternetHeader extends Header {
        String line;

        public InternetHeader(String str) {
            super("", "");
            int indexOf = str.indexOf(58);
            if (indexOf < 0) {
                this.name = str.trim();
            } else {
                this.name = str.substring(0, indexOf).trim();
            }
            this.line = str;
        }

        @Override // javax.mail.Header
        public String getValue() {
            char charAt;
            int indexOf = this.line.indexOf(58);
            if (indexOf < 0) {
                return this.line;
            }
            while (true) {
                indexOf++;
                if (indexOf < this.line.length() && ((charAt = this.line.charAt(indexOf)) == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n')) {
                }
            }
            return this.line.substring(indexOf);
        }

        public InternetHeader(String str, String str2) {
            super(str, "");
            if (str2 != null) {
                this.line = String.valueOf(str) + ": " + str2;
                return;
            }
            this.line = null;
        }
    }

    public String getHeader(String str, String str2) {
        String[] header = getHeader(str);
        if (header == null) {
            return null;
        }
        if (header.length != 1 && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer(header[0]);
            for (int i = 1; i < header.length; i++) {
                stringBuffer.append(str2);
                stringBuffer.append(header[i]);
            }
            return stringBuffer.toString();
        }
        return header[0];
    }

    public InternetHeaders(InputStream inputStream) throws MessagingException {
        this.headers = new ArrayList(40);
        load(inputStream);
    }
}