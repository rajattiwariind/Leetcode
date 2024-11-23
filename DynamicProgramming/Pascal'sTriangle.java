class Solution {

    public ArrayList<Integer> cal(int row){{
        int result = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(result);

        for(int i = 1; i < row; i++){
            result *= row-i;
            result /= i;
            nums.add(result);
        }

        return nums;
    }

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){
            arr.add(cal(i));
        }

        return arr;
    }
}
