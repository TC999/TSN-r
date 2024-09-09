package xyz.adscope.common.network.cookie;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface CookieStore {
    public static final CookieStore DEFAULT = new CookieStore() { // from class: xyz.adscope.common.network.cookie.CookieStore.1
        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void add(URI uri, HttpCookie httpCookie) {
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void clear() {
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public List<HttpCookie> get(URI uri) {
            return Collections.emptyList();
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void remove(HttpCookie httpCookie) {
        }
    };

    void add(URI uri, HttpCookie httpCookie);

    void clear();

    List<HttpCookie> get(URI uri);

    void remove(HttpCookie httpCookie);
}
