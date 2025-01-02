class Solution {
    public int[] vowelStrings(String[] words, int[][] arr) {
        int ans [] = new int [arr.length];
		boolean isFound []= new boolean [words.length];
		for(int i = 0; i < words.length; i++)
		{
			isFound[i] = containsVowels(words[i]);
		}
		int values [] = new int [isFound.length];
		int count = 0;
		for(int i = 0; i < isFound.length; i++)
		{
			if(isFound[i] == true)
			{
				count++;
			}
			values[i] = count;
		}
		for(int i = 0;i < arr.length; i++)
		{
			if(arr[i][0] == arr[i][1])
			{
				if(isFound[arr[i][1]])
				{
					ans[i] = 1;
				}
				else
				{
					ans[i] = 0;
				}
                continue;
			}
			ans[i] = values[arr[i][1]] - values[arr[i][0]] + (isFound[arr[i][0]] == false ? 0 : 1); 
		}
		return ans;
	}

	private static boolean containsVowels(String s) {
		int l = s.length() - 1;
		if((s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' ||s.charAt(0) == 'o' || s.charAt(0) == 'u') && (s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' ||s.charAt(l) == 'o' || s.charAt(l) == 'u'))
		{
			return true;
		}
		return false;
	}
}
