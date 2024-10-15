package class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.cn/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/*
	 You need 3 lists to resolve this problem:
	 1. The return list.
	 2. A list to act as a queue, that becomes a intermediate queue to work with.
	 3. A temp list to save each level of nodes. 
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			
			//size is important, we need to size to know 
			//how many times to poll as the queue is actually
			//changing during iterating.
			int size = queue.size();
			List<Integer> curAns = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				curAns.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			ans.add(0, curAns);
		}
		return ans;
	}

}
