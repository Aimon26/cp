fun majorityElement(nums: IntArray): Int {
    nums.sort()
    var x = mutableListOf<Int>()
    var y = mutableListOf<Int>()
    var c=1;
    if(nums.size==1) {
        return nums[0]
    }
    else {
        for (i in 0 until nums.size-1) {
            if (nums[i] == nums[i + 1]) {
                c++;
                if(i==nums.size-2)
                    {
                        x.add(c)
                        y.add(nums[i])

                    }
                }
            else {
                x.add(c)
                y.add(nums[i])
                c=1
            }
        }
        var mx = x.max()
        var res=0
        for (j in 0 until y.size) {
            if (mx == x[j] && mx > nums.size/2) {
                res = y[j]
                break
            }
        }
        return res
    }
}



fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (ransomNote.length > magazine.length)
        return false
    val cnt = IntArray(26)
    for (c in magazine)
        cnt[c - 'a']++
    for (c in ransomNote) {
        val i = c - 'a'
        if (cnt[i] == 0) return false
        cnt[i]--
    }
    return true
}





fun missingNumber(nums: IntArray): Int {
    nums.sort()
    var c=0
    var p=0
    for(i in 0 until nums.size-1)
    {
        if(nums[i]+2 == nums[i + 1]) {
            p = nums[i] + 1
            c=1
            break
        }

    }
    if(nums[0]==0){
    if(c==1)
        return p
    else
        return nums[nums.size-1]+1;}
    else
        return 0

}


fun findDisappearedNumbers2(nums: IntArray): List<Int> {

    nums.sort()
    var lst = mutableListOf<Int>()
    var y = mutableListOf<Int>()
    var c=1
    var p=0
    /*for(i in 0 until nums.size-1) {
        if(nums[i]!=nums[i+1])//1,2,2,3,3,4,7,8
            x.add(nums[i])
        if(i==nums.size-2)
            x.add(nums[i+1])
    }*/
    for(i in 0 until nums.size) {
        lst.add(nums[i])
    }
    val x=lst.distinct()
    println(x)

    var i=0
    while(i  < x.size) {
        if(c>nums.size)
            break
        else if(c==x[i]) {
            c++
            i=0
            p=0
        }
        else {
            p++
            i++
        }
        if(p==x.size)
        {
            y.add(c)
            c++
            p=0
            i=0
        }

    }
    return y

}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    var x = IntArray(nums.size, init = {-1})
    var y = mutableListOf<Int>()
    for(i in 0 until nums.size) {
        x[nums[i]-1]=nums[i]
    }
    for(i in 0 until x.size) {
        if(x[i]==-1)
            y.add(i+1)

    }
    return y


}

fun isAnagram(s: String, t: String): Boolean {
    val sortedString1 = s.toCharArray()
        .sorted()
        .joinToString("")
    println(sortedString1)
    val sortedString2 = t.toCharArray()
        .sorted()
        .joinToString("")
    println(sortedString2)
    if(sortedString1 == sortedString2)
        return true
    else
        return false
}


fun findTheDifference(s: String, t: String): Char {
    var ch: Char = ' '
    var c=0
    val sortedString1 = s.toCharArray()
        .sorted()
        .joinToString("")

    val sortedString2 = t.toCharArray()
        .sorted()
        .joinToString("")
    for(i in 0 until sortedString1.length)
    {
        if(sortedString1[i]!=sortedString2[i])
        {
            ch=sortedString2[i]
            c=1
            break
        }
    }
    if(c==1)
        return ch
    else
        return sortedString2[sortedString2.length-1]

}


fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

    var lst1 = mutableListOf<Int>()
    var lst2 = mutableListOf<Int>()
    var lst3 = mutableListOf<Int>()

    nums1.sort()
    nums2.sort()
    for(i in 0 until nums1.size) {
        lst1.add(nums1[i])
    }
    val x=lst1.distinct()
    for(i in 0 until nums2.size) {
        lst2.add(nums2[i])
    }
    val y=lst2.distinct()
    var c=0
    for(i in 0 until x.size) {
        for(j in 0 until y.size) {
            if(x[i]==y[j]) {
                lst3.add(x[i])
                break
            }
        }
    }
    return lst3.toIntArray()
}




fun containsDuplicate(nums: IntArray): Boolean {
    nums.sort();
    var p=0
    for(i in 0 until nums.size-1) {
        if(nums[i] == nums[i+1]) {
            p = 1
            break
        }
    }
    if(p==1)
        return true
    else
        return false
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    var p=0
    for(i in 0 until nums.size-1) {
        for (j in i + 1 until nums.size) {
            if ((nums[i] == nums[j]) && (j - i <= k)) {
                p = 1
                break;
            }
            if(p==1)
                break

        }
    }
        if(p==1)
            return true
        else
            return false


}

fun findErrorNums(nums: IntArray): IntArray {
    var lst = mutableListOf<Int>()
    var arr=IntArray(nums.size)
    for(i in 0 until arr.size) {
    arr[i]=i+1;
    }
    for(i in 0 until nums.size) {
        if(nums[i]!=arr[i])
        {
            lst.add(nums[i])
            lst.add(arr[i])
            lst.sorted()
            break;
        }

    }
    return lst.toIntArray()

}

fun main()
{
    var nums1=intArrayOf(3,2,2);
    println(findErrorNums(nums1).toList())
}