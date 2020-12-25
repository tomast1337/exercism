import java.util.*;
class IsogramChecker {
    boolean isIsogram(String phrase) {
        phrase = phrase.replace("-","").replace(" ","");
        return phrase.length() == 0 ? true :  phrase.length() == new HashSet<>(Arrays.asList(phrase.toLowerCase().split(""))).size();
    }
}
