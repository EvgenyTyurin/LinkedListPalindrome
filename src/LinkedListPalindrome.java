import java.util.Stack;

/**
 * Check if a linked list is a palindrome
 * Push the first half of list to stack then pop and compare with second half
 */

public class LinkedListPalindrome {

    public static void main(String[] args) {
        // Init list and stack
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(0, 1, 1, 0);
        Stack<Integer> listStack = new Stack<>();
        // Push first half of list to stack
        MyLinkedList.Node node = linkedList.head;
        int halfIdx = linkedList.size() / 2;
        for (int idx = 0; idx < halfIdx; idx++) {
            listStack.push((Integer) node.getData());
            node = node.next();
        }
        // Skip center element if exists
        if (linkedList.size() % 2 != 0)
            node = node.next();
        // Popping stack and compare to 2nd half list elements
        boolean noMatch = false;
        while (node != null) {
            Integer stackVal = listStack.pop();
            // Stack and list not match - not a palindrome
            if (!stackVal.equals(node.getData())) {
                noMatch = true;
                break;
            }
            node = node.next();
        }
        // Print result
        if (noMatch)
            System.out.println("List is NOT a palindrome");
        else
            System.out.println("List IS a palindrome"); // Yes it is
    }

}
