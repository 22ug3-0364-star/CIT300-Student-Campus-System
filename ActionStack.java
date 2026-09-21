import java.util.Stack;

public class ActionStack {
    private Stack<String> actionHistory;

    public ActionStack() {
        actionHistory = new Stack<>();
    }

    // Add an action to the stack
    public void pushAction(String action) {
        actionHistory.push(action);
    }

    // Undo - remove and return last action
    public String undoLastAction() {
        if (actionHistory.isEmpty()) {
            System.out.println("No actions to undo!");
            return null;
        }
        return actionHistory.pop();
    }

    // Display all recent actions
    public void displayActions() {
        if (actionHistory.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("---- Recent Actions (Most Recent First) ----");
        for (int i = actionHistory.size() - 1; i >= 0; i--) {
            System.out.println(actionHistory.get(i));
        }
    }
}

