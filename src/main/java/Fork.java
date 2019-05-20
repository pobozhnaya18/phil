
/**
 * @author  Natya Pobozhnaya
 *
 */
public class Fork {
    boolean state;
    /**
     * This function show state.
     * @return state
     */
    boolean isTaken() {
        return state;
    }
    void setState(boolean state) {
        this.state = state;
    }
    Fork(){
        state = false;
    }
}