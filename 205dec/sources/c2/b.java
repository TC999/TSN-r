package c2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/* compiled from: Trie.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Hashtable<String, b> f1514a = new Hashtable<>();

    /* renamed from: b  reason: collision with root package name */
    private String f1515b;

    /* renamed from: c  reason: collision with root package name */
    private b f1516c;

    public b a(String str) {
        return this.f1514a.get(str);
    }

    public b b() {
        return this.f1516c;
    }

    public String c() {
        return this.f1515b;
    }

    public synchronized void d(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                String[] split = readLine.split(" ");
                                if (split.length == 2) {
                                    b bVar = new b();
                                    bVar.f1515b = split[1];
                                    g(split[0], bVar);
                                }
                            } else {
                                inputStreamReader.close();
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                inputStreamReader = null;
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public synchronized void e(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                String[] split = readLine.split(" ");
                                if (split.length == 2) {
                                    int i4 = 0;
                                    String str = split[0];
                                    String str2 = split[1];
                                    char[] charArray = str.toCharArray();
                                    b bVar = this;
                                    while (true) {
                                        if (i4 >= charArray.length) {
                                            break;
                                        }
                                        String upperCase = Integer.toHexString(charArray[i4]).toUpperCase();
                                        b a4 = bVar.a(upperCase);
                                        if (a4 == null) {
                                            bVar.g(upperCase, new b());
                                            a4 = bVar.a(upperCase);
                                        }
                                        b b4 = a4.b();
                                        if (charArray.length - 1 == i4) {
                                            a4.f1515b = str2;
                                            break;
                                        }
                                        if (b4 != null) {
                                            bVar = b4;
                                        } else if (charArray.length - 1 != i4) {
                                            bVar = new b();
                                            a4.h(bVar);
                                            bVar.g(Integer.toHexString(charArray[i4 + 1]).toUpperCase(), new b());
                                        }
                                        i4++;
                                    }
                                }
                            } else {
                                inputStreamReader.close();
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                inputStreamReader = null;
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public void f() throws IOException {
        String str = a.f1513a;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                e(new FileInputStream(file));
            }
        }
    }

    public void g(String str, b bVar) {
        this.f1514a.put(str, bVar);
    }

    public void h(b bVar) {
        this.f1516c = bVar;
    }

    public void i(String str) {
        this.f1515b = str;
    }
}
