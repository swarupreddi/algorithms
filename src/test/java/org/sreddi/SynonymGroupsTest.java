package org.sreddi;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by swarup on 3/29/17.
 */
public class SynonymGroupsTest {

    private static final char[] G1 = new char[]{'a', 'b', 'c'};
    private static final char[] G2 = new char[]{'d', 'e', 'f'};
    private static final char[] G3 = new char[]{'c', 'e'};
    private static final char[] G4 = new char[]{'u', 'v'};

    private static final char[][] GROUPS = new char[][]{G1, G2, G3, G4};

    @Test
    public void runThis() throws Exception {
        SynonymGroups s = new SynonymGroups();

        Map<Character, Integer> thesaurus = s.createThesaurus(GROUPS);
        boolean b1 = s.isSynonym(thesaurus, 'a', 'e');
        boolean b2 = s.isSynonym(thesaurus, 'a', 'u');
        assertTrue(b1);
        assertFalse(b2);
    }

}