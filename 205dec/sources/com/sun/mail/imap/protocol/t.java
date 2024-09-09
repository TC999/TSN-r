package com.sun.mail.imap.protocol;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SearchSequence.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f50589a = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: b  reason: collision with root package name */
    private static Calendar f50590b = new GregorianCalendar();

    t() {
    }

    private static com.sun.mail.iap.b a(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        com.sun.mail.iap.b e4 = e(terms[0], str);
        for (int i4 = 1; i4 < terms.length; i4++) {
            e4.a(e(terms[i4], str));
        }
        return e4;
    }

    private static com.sun.mail.iap.b b(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("BODY");
        bVar.p(bodyTerm.getPattern(), str);
        return bVar;
    }

    private static com.sun.mail.iap.b c(FlagTerm flagTerm) throws SearchException {
        boolean testSet = flagTerm.getTestSet();
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (int i4 = 0; i4 < systemFlags.length; i4++) {
            if (systemFlags[i4] == Flags.Flag.DELETED) {
                bVar.i(testSet ? "DELETED" : "UNDELETED");
            } else if (systemFlags[i4] == Flags.Flag.ANSWERED) {
                bVar.i(testSet ? "ANSWERED" : "UNANSWERED");
            } else if (systemFlags[i4] == Flags.Flag.DRAFT) {
                bVar.i(testSet ? "DRAFT" : "UNDRAFT");
            } else if (systemFlags[i4] == Flags.Flag.FLAGGED) {
                bVar.i(testSet ? "FLAGGED" : "UNFLAGGED");
            } else if (systemFlags[i4] == Flags.Flag.RECENT) {
                bVar.i(testSet ? "RECENT" : "OLD");
            } else if (systemFlags[i4] == Flags.Flag.SEEN) {
                bVar.i(testSet ? "SEEN" : "UNSEEN");
            }
        }
        for (String str : userFlags) {
            bVar.i(testSet ? "KEYWORD" : "UNKEYWORD");
            bVar.i(str);
        }
        return bVar;
    }

    private static com.sun.mail.iap.b d(String str, String str2) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("FROM");
        bVar.p(str, str2);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.sun.mail.iap.b e(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return a((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return k((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return j((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return f((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return c((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return d(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return d(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return m(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        } else if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return m(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        } else if (searchTerm instanceof SubjectTerm) {
            return p((SubjectTerm) searchTerm, str);
        } else {
            if (searchTerm instanceof BodyTerm) {
                return b((BodyTerm) searchTerm, str);
            }
            if (searchTerm instanceof SizeTerm) {
                return o((SizeTerm) searchTerm);
            }
            if (searchTerm instanceof SentDateTerm) {
                return n((SentDateTerm) searchTerm);
            }
            if (searchTerm instanceof ReceivedDateTerm) {
                return l((ReceivedDateTerm) searchTerm);
            }
            if (searchTerm instanceof MessageIDTerm) {
                return i((MessageIDTerm) searchTerm, str);
            }
            throw new SearchException("Search too complex");
        }
    }

    private static com.sun.mail.iap.b f(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("HEADER");
        bVar.o(headerTerm.getHeaderName());
        bVar.p(headerTerm.getPattern(), str);
        return bVar;
    }

    private static boolean g(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) > '\u007f') {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(SearchTerm searchTerm) {
        SearchTerm[] terms;
        boolean z3 = searchTerm instanceof AndTerm;
        if (!z3 && !(searchTerm instanceof OrTerm)) {
            if (searchTerm instanceof NotTerm) {
                return h(((NotTerm) searchTerm).getTerm());
            }
            if (searchTerm instanceof StringTerm) {
                return g(((StringTerm) searchTerm).getPattern());
            }
            if (searchTerm instanceof AddressTerm) {
                return g(((AddressTerm) searchTerm).getAddress().toString());
            }
            return true;
        }
        if (z3) {
            terms = ((AndTerm) searchTerm).getTerms();
        } else {
            terms = ((OrTerm) searchTerm).getTerms();
        }
        for (SearchTerm searchTerm2 : terms) {
            if (!h(searchTerm2)) {
                return false;
            }
        }
        return true;
    }

    private static com.sun.mail.iap.b i(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("HEADER");
        bVar.o("Message-ID");
        bVar.p(messageIDTerm.getPattern(), str);
        return bVar;
    }

    private static com.sun.mail.iap.b j(NotTerm notTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("NOT");
        SearchTerm term = notTerm.getTerm();
        if (!(term instanceof AndTerm) && !(term instanceof FlagTerm)) {
            bVar.a(e(term, str));
        } else {
            bVar.h(e(term, str));
        }
        return bVar;
    }

    private static com.sun.mail.iap.b k(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            OrTerm orTerm2 = terms[0];
            int i4 = 1;
            while (i4 < terms.length) {
                i4++;
                orTerm2 = new OrTerm(orTerm2, terms[i4]);
            }
            terms = ((OrTerm) orTerm2).getTerms();
        }
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        if (terms.length > 1) {
            bVar.i("OR");
        }
        if (!(terms[0] instanceof AndTerm) && !(terms[0] instanceof FlagTerm)) {
            bVar.a(e(terms[0], str));
        } else {
            bVar.h(e(terms[0], str));
        }
        if (terms.length > 1) {
            if (!(terms[1] instanceof AndTerm) && !(terms[1] instanceof FlagTerm)) {
                bVar.a(e(terms[1], str));
            } else {
                bVar.h(e(terms[1], str));
            }
        }
        return bVar;
    }

    private static com.sun.mail.iap.b l(DateTerm dateTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        String q3 = q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                bVar.i("OR BEFORE " + q3 + " ON " + q3);
                break;
            case 2:
                bVar.i("BEFORE " + q3);
                break;
            case 3:
                bVar.i("ON " + q3);
                break;
            case 4:
                bVar.i("NOT ON " + q3);
                break;
            case 5:
                bVar.i("SINCE " + q3);
                break;
            case 6:
                bVar.i("OR SINCE " + q3 + " ON " + q3);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return bVar;
    }

    private static com.sun.mail.iap.b m(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        if (recipientType == Message.RecipientType.TO) {
            bVar.i("TO");
        } else if (recipientType == Message.RecipientType.CC) {
            bVar.i("CC");
        } else if (recipientType == Message.RecipientType.BCC) {
            bVar.i("BCC");
        } else {
            throw new SearchException("Illegal Recipient type");
        }
        bVar.p(str, str2);
        return bVar;
    }

    private static com.sun.mail.iap.b n(DateTerm dateTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        String q3 = q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                bVar.i("OR SENTBEFORE " + q3 + " SENTON " + q3);
                break;
            case 2:
                bVar.i("SENTBEFORE " + q3);
                break;
            case 3:
                bVar.i("SENTON " + q3);
                break;
            case 4:
                bVar.i("NOT SENTON " + q3);
                break;
            case 5:
                bVar.i("SENTSINCE " + q3);
                break;
            case 6:
                bVar.i("OR SENTSINCE " + q3 + " SENTON " + q3);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return bVar;
    }

    private static com.sun.mail.iap.b o(SizeTerm sizeTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        int comparison = sizeTerm.getComparison();
        if (comparison == 2) {
            bVar.i("SMALLER");
        } else if (comparison == 5) {
            bVar.i("LARGER");
        } else {
            throw new SearchException("Cannot handle Comparison");
        }
        bVar.m(sizeTerm.getNumber());
        return bVar;
    }

    private static com.sun.mail.iap.b p(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("SUBJECT");
        bVar.p(subjectTerm.getPattern(), str);
        return bVar;
    }

    private static String q(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        f50590b.setTime(date);
        stringBuffer.append(f50590b.get(5));
        stringBuffer.append("-");
        stringBuffer.append(f50589a[f50590b.get(2)]);
        stringBuffer.append('-');
        stringBuffer.append(f50590b.get(1));
        return stringBuffer.toString();
    }
}
