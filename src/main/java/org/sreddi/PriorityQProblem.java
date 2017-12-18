package org.sreddi;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQProblem {

    class Student implements Comparable<Student> {
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int compareTo(Student s) {
            if(cgpa == s.cgpa) {
                if(name.compareTo(s.name) == 0) {
                    return (id == s.id) ? 0 : (id > s.id) ? 1 : -1;
                } else {
                    return name.compareTo(s.name);
                }
            } else {
                return (cgpa > s.cgpa) ? -1 : 1;
            }
        }

        int getId() { return id; }
        String getName() { return name; }
        double getCGPA() { return cgpa; }
    }

    class Priorities {
        private PriorityQueue<Student> pq = new PriorityQueue<>();
        List<Student> getStudents(List<String> events) {
            for (String event: events) {
                String[] elems = event.split(" ");
                if (elems[0].equals("ENTER")) {
                    Student s = new Student(Integer.parseInt(elems[3]),
                                            elems[1],
                                            Double.parseDouble(elems[2]));
                    pq.add(s);
                } else {
                    pq.poll();
                }
                Student slist[] = pq.toArray(new Student[0]);
            }
            List<Student> res = new ArrayList<>();
            while(!pq.isEmpty()) {
                res.add(pq.poll());
            }
            return res;
        }
    }

    List<String> foo(List<String> events) {
        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);
        List<String> res = new ArrayList<>();
        for (Student s: students) {
            res.add(s.getName());
        }
        return res;
    }
}
