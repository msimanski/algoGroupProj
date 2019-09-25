package algoGroupProj;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort
{

	public static void main(String[] args)
	{
		ArrayList<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(14, 5 ,88, 313, 43, 17, 24, 42));
		
		System.out.println(mergeSort(unsortedList.size(), unsortedList));
	}
	
	public static ArrayList<Integer> mergeSort(int n, ArrayList<Integer> a) 
	{
		if(n == 1) 
		{
			return a;
		}
		
		ArrayList<Integer> copy = a;
		ArrayList<Integer> part1 = new ArrayList<Integer>(a.subList(0, (n-1)/2));
		ArrayList<Integer> part2 = new ArrayList<Integer>(copy.subList(((n -1)/2)+1, n-1));
		
		part1 = mergeSort(n, part1);
		part2 = mergeSort(n, part2);
		
		return merge(part1, part2);
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		while(!(a.isEmpty()) && !(b.isEmpty()))
		{
			if(a.get(0) > b.get(0))
			{
				c.add(c.size() - 1, b.get(0));
				b.remove(0);
			}
			else 
			{
				c.add(c.size() - 1, a.get(0));
				a.remove(0);
			}
		}
		
		while(!(a.isEmpty())) 
		{
			c.add(c.size() - 1, a.get(0));
			a.remove(0);
		}
		
		while(!(b.isEmpty())) 
		{
			c.add(c.size() - 1, b.get(0));
			b.remove(0);
		}
		
		return c;
	}

}
