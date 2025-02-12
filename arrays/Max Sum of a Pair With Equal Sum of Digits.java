class Solution {
    public int maximumSum(int[] arr) {
        HashMap<Integer, Integer> map =  new HashMap<>();
		int max = -1;
		
		for(int i = 0; i < arr.length; i++)
		{
			int sum = 0;
			int n = arr[i];
			while(n > 0)
			{
				sum += n % 10;
				n /= 10;
			}
			if(map.get(sum) == null)
			{
				map.put(sum, arr[i]);
			}
			else if(map.get(sum) < arr[i])
			{	
				max = Math.max(arr[i] + map.get(sum), max);
				map.put(sum, arr[i]);
			}
			else
			{
				max = Math.max(arr[i] + map.get(sum), max);
			}
		}
        return max;
    }
}
