package se.hernebring;

import java.util.HashSet;
import java.util.Set;

public class Perm {

    private final HashSet<String> perms = new HashSet<>();
    public Set<String> generate(String raw) {
        generate("", raw);
        return perms;
    }

    private void generate(String fixed, String changing) {
        if(changing.length() > 1)
            for(int fi = 0; fi < changing.length(); fi++)
                generate(fixed + changing.charAt(fi),
                        changing.substring(0, fi) +
                                changing.substring(fi + 1));

        perms.add(fixed + changing);
    }

}
