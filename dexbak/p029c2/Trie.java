package p029c2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/* renamed from: c2.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Trie {

    /* renamed from: a */
    private Hashtable<String, Trie> f1514a = new Hashtable<>();

    /* renamed from: b */
    private String f1515b;

    /* renamed from: c */
    private Trie f1516c;

    /* renamed from: a */
    public Trie m58051a(String str) {
        return this.f1514a.get(str);
    }

    /* renamed from: b */
    public Trie m58050b() {
        return this.f1516c;
    }

    /* renamed from: c */
    public String m58049c() {
        return this.f1515b;
    }

    /* renamed from: d */
    public synchronized void m58048d(InputStream inputStream) throws IOException {
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
                                    Trie trie = new Trie();
                                    trie.f1515b = split[1];
                                    m58045g(split[0], trie);
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

    /* renamed from: e */
    public synchronized void m58047e(InputStream inputStream) throws IOException {
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
                                    int i = 0;
                                    String str = split[0];
                                    String str2 = split[1];
                                    char[] charArray = str.toCharArray();
                                    Trie trie = this;
                                    while (true) {
                                        if (i >= charArray.length) {
                                            break;
                                        }
                                        String upperCase = Integer.toHexString(charArray[i]).toUpperCase();
                                        Trie m58051a = trie.m58051a(upperCase);
                                        if (m58051a == null) {
                                            trie.m58045g(upperCase, new Trie());
                                            m58051a = trie.m58051a(upperCase);
                                        }
                                        Trie m58050b = m58051a.m58050b();
                                        if (charArray.length - 1 == i) {
                                            m58051a.f1515b = str2;
                                            break;
                                        }
                                        if (m58050b != null) {
                                            trie = m58050b;
                                        } else if (charArray.length - 1 != i) {
                                            trie = new Trie();
                                            m58051a.m58044h(trie);
                                            trie.m58045g(Integer.toHexString(charArray[i + 1]).toUpperCase(), new Trie());
                                        }
                                        i++;
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

    /* renamed from: f */
    public void m58046f() throws IOException {
        String str = MultiPinyinConfig.f1513a;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                m58047e(new FileInputStream(file));
            }
        }
    }

    /* renamed from: g */
    public void m58045g(String str, Trie trie) {
        this.f1514a.put(str, trie);
    }

    /* renamed from: h */
    public void m58044h(Trie trie) {
        this.f1516c = trie;
    }

    /* renamed from: i */
    public void m58043i(String str) {
        this.f1515b = str;
    }
}
