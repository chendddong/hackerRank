/* Hidden stub code will pass a root argument to the function below. 
The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

/* 
    Note: We do not consider a binary tree to be a binary search tree if it
    contains duplicate values.

    I think the O-(n) where n is the range of the problem.
    Could be faster than we thought 
 */


boolean checkBST(Node root) {
    return checkBST(root, 0, 10000); // range of values in problem
}

boolean checkBST(Node node, int min, int max) {
    /* Base case */
    if (node == null) {
        return true;
    } else if (node.data < min || node.data > max) {
        return false;
    }
    return checkBST(node.left, min, node.data - 1) && checkBST(node.right, node.data + 1, max);
}