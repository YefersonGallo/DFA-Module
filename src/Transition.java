public class Transition {
    private int id;
    private State initialState;
    private char element;
    private State finalState;

    public Transition(int id, State initialState, char element, State finalState) {
        this.id = id;
        this.initialState = initialState;
        this.element = element;
        this.finalState = finalState;
    }

    public int getId() {
        return id;
    }

    public State getInitialState() {
        return initialState;
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    public State getFinalState() {
        return finalState;
    }
}
