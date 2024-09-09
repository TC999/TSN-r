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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MimeTypeFile.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f50261a;

    /* renamed from: b  reason: collision with root package name */
    private Hashtable f50262b;

    public f(String str) throws IOException {
        this.f50261a = null;
        this.f50262b = new Hashtable();
        this.f50261a = str;
        FileReader fileReader = new FileReader(new File(this.f50261a));
        try {
            d(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private void d(BufferedReader bufferedReader) throws IOException {
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
                    int i4 = length - 1;
                    if (readLine.charAt(i4) == '\\') {
                        str = readLine.substring(0, i4);
                    }
                }
            }
            e(readLine);
        }
        if (str != null) {
            e(str);
        }
    }

    private void e(String str) {
        e eVar;
        e eVar2;
        String trim = str.trim();
        if (trim.length() == 0 || trim.charAt(0) == '#') {
            return;
        }
        if (trim.indexOf(61) > 0) {
            a aVar = new a(trim);
            String str2 = null;
            while (aVar.a()) {
                String b4 = aVar.b();
                String b5 = (aVar.a() && aVar.b().equals("=") && aVar.a()) ? aVar.b() : null;
                if (b5 == null) {
                    if (b.a()) {
                        b.b("Bad .mime.types entry: " + trim);
                        return;
                    }
                    return;
                } else if (b4.equals("type")) {
                    str2 = b5;
                } else if (b4.equals("exts")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(b5, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        this.f50262b.put(nextToken, new e(str2, nextToken));
                        if (b.a()) {
                            b.b("Added: " + eVar2.toString());
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
            this.f50262b.put(nextToken3, new e(nextToken2, nextToken3));
            if (b.a()) {
                b.b("Added: " + eVar.toString());
            }
        }
    }

    public void a(String str) {
        try {
            d(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    public String b(String str) {
        e c4 = c(str);
        if (c4 != null) {
            return c4.b();
        }
        return null;
    }

    public e c(String str) {
        return (e) this.f50262b.get(str);
    }

    public f(InputStream inputStream) throws IOException {
        this.f50261a = null;
        this.f50262b = new Hashtable();
        d(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public f() {
        this.f50261a = null;
        this.f50262b = new Hashtable();
    }
}
