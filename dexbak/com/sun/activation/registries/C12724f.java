package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

/* compiled from: MimeTypeFile.java */
/* renamed from: com.sun.activation.registries.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12724f {

    /* renamed from: a */
    private String f35840a;

    /* renamed from: b */
    private Hashtable f35841b;

    public C12724f(String str) throws IOException {
        this.f35840a = null;
        this.f35841b = new Hashtable();
        this.f35840a = str;
        FileReader fileReader = new FileReader(new File(this.f35840a));
        try {
            m16446d(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: d */
    private void m16446d(BufferedReader bufferedReader) throws IOException {
        String str;
        String readLine;
        loop0: while (true) {
            str = null;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                if (str != null) {
                    readLine = str + readLine;
                }
                int length = readLine.length();
                if (readLine.length() > 0) {
                    int i = length - 1;
                    if (readLine.charAt(i) == '\\') {
                        str = readLine.substring(0, i);
                    }
                }
            }
            m16445e(readLine);
        }
        if (str != null) {
            m16445e(str);
        }
    }

    /* renamed from: e */
    private void m16445e(String str) {
        MimeTypeEntry mimeTypeEntry;
        MimeTypeEntry mimeTypeEntry2;
        String trim = str.trim();
        if (trim.length() == 0 || trim.charAt(0) == '#') {
            return;
        }
        if (trim.indexOf(61) > 0) {
            MimeTypeFile mimeTypeFile = new MimeTypeFile(trim);
            String str2 = null;
            while (mimeTypeFile.m16481a()) {
                String m16480b = mimeTypeFile.m16480b();
                String m16480b2 = (mimeTypeFile.m16481a() && mimeTypeFile.m16480b().equals("=") && mimeTypeFile.m16481a()) ? mimeTypeFile.m16480b() : null;
                if (m16480b2 == null) {
                    if (LogSupport.m16477a()) {
                        LogSupport.m16476b("Bad .mime.types entry: " + trim);
                        return;
                    }
                    return;
                } else if (m16480b.equals("type")) {
                    str2 = m16480b2;
                } else if (m16480b.equals("exts")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(m16480b2, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        this.f35841b.put(nextToken, new MimeTypeEntry(str2, nextToken));
                        if (LogSupport.m16477a()) {
                            LogSupport.m16476b("Added: " + mimeTypeEntry2.toString());
                        }
                    }
                }
            }
            return;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
        if (stringTokenizer2.countTokens() == 0) {
            return;
        }
        String nextToken2 = stringTokenizer2.nextToken();
        while (stringTokenizer2.hasMoreTokens()) {
            String nextToken3 = stringTokenizer2.nextToken();
            this.f35841b.put(nextToken3, new MimeTypeEntry(nextToken2, nextToken3));
            if (LogSupport.m16477a()) {
                LogSupport.m16476b("Added: " + mimeTypeEntry.toString());
            }
        }
    }

    /* renamed from: a */
    public void m16449a(String str) {
        try {
            m16446d(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    /* renamed from: b */
    public String m16448b(String str) {
        MimeTypeEntry m16447c = m16447c(str);
        if (m16447c != null) {
            return m16447c.m16450b();
        }
        return null;
    }

    /* renamed from: c */
    public MimeTypeEntry m16447c(String str) {
        return (MimeTypeEntry) this.f35841b.get(str);
    }

    public C12724f(InputStream inputStream) throws IOException {
        this.f35840a = null;
        this.f35841b = new Hashtable();
        m16446d(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public C12724f() {
        this.f35840a = null;
        this.f35841b = new Hashtable();
    }
}
