package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.DefaultSocks5InitialRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultSocks5InitialRequest extends AbstractSocks5Message implements Socks5InitialRequest {
    private final List<Socks5AuthMethod> authMethods;

    public DefaultSocks5InitialRequest(Socks5AuthMethod... socks5AuthMethodArr) {
        if (socks5AuthMethodArr != null) {
            ArrayList arrayList = new ArrayList(socks5AuthMethodArr.length);
            for (Socks5AuthMethod socks5AuthMethod : socks5AuthMethodArr) {
                if (socks5AuthMethod == null) {
                    break;
                }
                arrayList.add(socks5AuthMethod);
            }
            if (!arrayList.isEmpty()) {
                this.authMethods = Collections.unmodifiableList(arrayList);
                return;
            }
            throw new IllegalArgumentException("authMethods is empty");
        }
        throw new NullPointerException("authMethods");
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5InitialRequest
    public List<Socks5AuthMethod> authMethods() {
        return this.authMethods;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethods: ");
        } else {
            sb.append("(authMethods: ");
        }
        sb.append(authMethods());
        sb.append(')');
        return sb.toString();
    }

    public DefaultSocks5InitialRequest(Iterable<Socks5AuthMethod> iterable) {
        Socks5AuthMethod next;
        if (iterable != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Socks5AuthMethod> it = iterable.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                arrayList.add(next);
            }
            if (!arrayList.isEmpty()) {
                this.authMethods = Collections.unmodifiableList(arrayList);
                return;
            }
            throw new IllegalArgumentException("authMethods is empty");
        }
        throw new NullPointerException("authSchemes");
    }
}
