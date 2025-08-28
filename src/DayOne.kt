fun isPalindrome(x: Int): Boolean {
    val str: String = x.toString()
    val reversedStr = str.reversed()
    if(str== reversedStr)
        return true
    else
        return false

}



/*fun twoSum(nums: IntArray, target: Int): IntArray {

    for(i in nums.indices)
        for(j in i+1 until nums.size)
            if(nums[i] + nums[j] == target)
                return intArrayOf(i, j)


    return intArrayOf();


}*/

