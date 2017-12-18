package org.sreddi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PriorityQProblemTest {

    @Test
    public void foo() {
        PriorityQProblem pqp = new PriorityQProblem();
        String events[] = new String[] {
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED",
        };
        List<String> elist = Arrays.asList(events);
        List<String> res = pqp.foo(elist);
        assertTrue(res.size() == 4);
        assertEquals("Dan", res.get(0));
        assertEquals("Ashley", res.get(1));
        assertEquals("Shafaet", res.get(2));
        assertEquals("Maria", res.get(3));
    }
}