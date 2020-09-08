import java.util.ArrayList;
import java.util.List;

public class Automaton {
    private ArrayList<Character> alphabet;
    private List<State> states;
    private State initial;
    private final List<State> accepatbleStates;
    private final List<State> statesWay;
    private List<Transition> transitionFunctions;
    private List<String> stringToValidate;
    private int countState = 0;
    private int countTransition = 0;

    public Automaton() {
        this.alphabet = new ArrayList<>();
        this.states = new ArrayList<>();
        this.accepatbleStates = new ArrayList<>();
        this.transitionFunctions = new ArrayList<>();
        this.initial = null;
        statesWay = new ArrayList<>();
    }

    public List<State> getStatesWay() {
        initSimulation();
        return statesWay;
    }

    public ArrayList<Boolean> initSimulation(){
        ArrayList<Boolean> results = new ArrayList<>();
        for (String word: this.stringToValidate) {
            State aux = null;
            this.statesWay.add(initial);
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < transitionFunctions.size(); j++) {
                    if(i == 0){
                        if(transitionFunctions.get(j).getInitialState() == initial){
                            if(transitionFunctions.get(j).getElement() == word.charAt(i)){
                                aux = transitionFunctions.get(j).getFinalState();
                                System.out.println(aux.getName());
                                break;
                            }
                        }
                    }else if(transitionFunctions.get(j).getInitialState() == aux){
                        if(transitionFunctions.get(j).getElement() == word.charAt(i)){
                            aux = transitionFunctions.get(j).getFinalState();
                            this.statesWay.add(aux);
                            System.out.println(aux.getName());
                            break;
                        }
                        }else if(j == transitionFunctions.size() - 1){
                            aux = null;
                        }
                }
                if(i == word.length() - 1){
                    if(accepatbleStates.contains(aux)) {
                        results.add(true);
                    }else{
                        results.add(false);
                    }
                }
            }
        }
        return results;
    }

    public void createState(String name){
        countState++;
        State newState = new State(countState, name);
        states.add(newState);
    }

    public void changeNameState(String oldName, String newName){
        for (int i = 0; i < this.states.size(); i++) {
            if(this.states.get(i).getName() == oldName){
                this.states.get(i).setName(newName);
            }
        }
    }

    public void addTransition(char element, String nameIn, String nameOut){
        State stateIn = null;
        State stateOut = null;
        boolean flag = false;
        for (int i = 0; i < this.transitionFunctions.size(); i++) {
            if(this.transitionFunctions.get(i).getInitialState().getName() == nameIn && this.transitionFunctions.get(i).getElement() == element){
                flag = true;
            }
        }
        if(!flag){
            if(!this.alphabet.contains(element)){
                this.alphabet.add(element);
            }
            for (int i = 0; i < this.states.size(); i++) {
                if(this.states.get(i).getName() == nameIn){
                    stateIn = this.states.get(i);
                }
                if(this.states.get(i).getName() == nameOut){
                    stateOut = this.states.get(i);
                }
            }
            countTransition++;
            Transition newTransition = new Transition(countTransition, stateIn, element, stateOut);
            transitionFunctions.add(newTransition);
        }
    }


    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public State getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        for (int i = 0; i < states.size(); i++) {
            if(states.get(i).getName() == initial){
                if(this.initial == null)
                    this.initial = states.get(i);
            }
        }
    }

    public List<State> getAccepatbleStates() {
        return accepatbleStates;
    }

    public void setAccepatbleStates(String accepatbleStates) {
        for (int i = 0; i < states.size(); i++) {
            if(states.get(i).getName() == accepatbleStates){
                this.accepatbleStates.add(states.get(i));
            }
        }
    }

    public List<Transition> getTransitionFunctions() {
        return transitionFunctions;
    }

    public void setTransitionFunctions(List<Transition> transitionFunctions) {
        this.transitionFunctions = transitionFunctions;
    }

    public List<String> getStringToValidate() {
        return stringToValidate;
    }

    public void setStringToValidate(List<String> stringToValidate) {
        this.stringToValidate = stringToValidate;
    }
}
