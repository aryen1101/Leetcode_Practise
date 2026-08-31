class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode node = head;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (node.next.next != null) {

            if ((node.val > node.next.val && 
                 node.next.next.val > node.next.val) || 
                
                (node.next.val > node.val && 
                 node.next.val > node.next.next.val)) {

                list.add(index + 1);
            }

            index++;
            node = node.next;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {

            int val = list.get(i) - list.get(i - 1);

            min = Math.min(min, val);
        }

        int max = list.get(list.size() - 1) - list.get(0);

        return new int[]{min, max};
    }
}