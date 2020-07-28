/**
 * @author xiangjin.kong
 * @date 2020/7/28 14:45
 * @desc 二叉查找树
 */
class BstTest {

    static class Node {
        public String content;
        public Node parent;
        public Node left;
        public Node right;

        public Node(String content) {
            this.content = content;
        }
    }

    public Node root;

    // BST的查找操作

    public Node search (String content) {
        Node r = root;
        while (r != null) {
            if (r.content.equals(content)) {
                return r;
            } else if (content.compareTo(r.content) > 1) {
                r = r.right;
            } else if (content.compareTo(r.content) <= 1) {
                r = r.left;
            }
        }

        return null;
    }

    // BST的插入操作
    public void insert (String content) {
        Node newNode = new Node(content);
        Node r = root;
        Node parent = null;

        if (r == null) {
            root = newNode;
            return;
        }

        while (r != null) {
            parent = r;
            if (newNode.content.compareTo(r.content) > 1) {
                r = r.right;
            } else if (newNode.content.compareTo(r.content) < 1){
                r = r.left;
            } else {
                r = r.left;
            }
        }

        if (parent.content.compareTo(newNode.content) > 1) {
            parent.left = newNode;
            newNode.parent = parent;
        } else {
            parent.right = newNode;
            newNode.parent = parent;
        }
    }
}
