import java.util.ArrayList;
import java.util.List;

public class tests {
    public static void main(String[] args) {
        Automaton automaton = new Automaton();
        automaton.createState("q0");
        automaton.createState("q1");
        automaton.createState("q2");
        automaton.createState("q3");
        automaton.setInitial("q0");
        automaton.setAccepatbleStates("q3");
        automaton.addTransition('a', "q0", "q1");
        automaton.addTransition('a', "q1", "q1");
        automaton.addTransition('d', "q1", "q3");
        automaton.addTransition('b', "q1", "q2");
        automaton.addTransition('c', "q2", "q3");
        ArrayList<String> stringTovalidate = new ArrayList<>();
        stringTovalidate.add("aaabc");
        stringTovalidate.add("aaa");
        stringTovalidate.add("bc");
        stringTovalidate.add("aaaaaaad");
        stringTovalidate.add("aaaaaacd");
        stringTovalidate.add("aaaaaaabd");
        stringTovalidate.add("aaaaaaabcd");
        automaton.setStringToValidate(stringTovalidate);
        System.out.println(automaton.initSimulation());

    }
}
