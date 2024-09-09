package javax.activation;

import java.beans.Beans;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class CommandInfo {
    private String className;
    private String verb;

    public CommandInfo(String str, String str2) {
        this.verb = str;
        this.className = str2;
    }

    public String getCommandClass() {
        return this.className;
    }

    public String getCommandName() {
        return this.verb;
    }

    public Object getCommandObject(DataHandler dataHandler, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        InputStream inputStream;
        Object instantiate = Beans.instantiate(classLoader, this.className);
        if (instantiate != null) {
            if (instantiate instanceof CommandObject) {
                ((CommandObject) instantiate).setCommandContext(this.verb, dataHandler);
            } else if ((instantiate instanceof Externalizable) && dataHandler != null && (inputStream = dataHandler.getInputStream()) != null) {
                ((Externalizable) instantiate).readExternal(new ObjectInputStream(inputStream));
            }
        }
        return instantiate;
    }
}
