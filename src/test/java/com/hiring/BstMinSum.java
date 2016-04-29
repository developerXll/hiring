package com.hiring;

public class BstMinSum
{
	static int min = Integer.MAX_VALUE;

	public static int minTreePath(TNode t)
	{
		if( t == null) return 0;
		minSum(t);
		return min;
	}
	
	public static int minSum(TNode t){

		if( t == null) return 0;
		
		int  value  = t.value;
        int  lmin = 0;
        int  rmin = 0;
        
		if(t.left != null)
		{
			lmin  = minTreePath(t.left);
			if(lmin>0) {
            	value  += lmin;
            }
		}
		
		if(t.right != null)
		{
			rmin  = minTreePath(t.right);
			if(rmin>0) {
            	value  += rmin;
            }
		}
		
		if (min > value) {
			min = value;
        }
		
		return Math.min(t.value, Math.min(t.value + lmin, t.value + rmin));
	
	}

	public static void main(String[] args)
	{

		// TNode root = new TNode();
		// root.value = 10;
		//
		// TNode left = new TNode();
		// left.value = 5;
		// TNode right = new TNode();
		// right.value = 15;
		//
		// root.left = left;
		// root.right = right;

		TNode root = new TNode();
		root.value = 7;

		TNode left1 = new TNode();
		left1.value = 3;
		root.left = left1;

		TNode left2 = new TNode();
		left2.value = 1;
		left1.left = left2;

		TNode right1 = new TNode();
		right1.value = 10;
		root.right = right1;

		TNode left3 = new TNode();
		left3.value = 8;
		right1.left = left3;

		TNode right2 = new TNode();
		right2.value = 12;
		right1.right = right2;

		System.out.println(minTreePath(root));

	
	}
}
