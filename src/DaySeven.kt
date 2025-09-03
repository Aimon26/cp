//fun hasSameDigits(s: String): Boolean {
//
//        if (s.isEmpty()) return false
//        var chars = s.toCharArray()
//        var i = 0
//        while (i < chars.size - 1) {
//            var a = chars[i].digitToInt()
//            var b = chars[i + 1].digitToInt()
//            var n = ((a + b) % 10)
//            println(n)
//            var charValue: Char = ('0' + n)
//            chars[i] = charValue
//            if (i + 2 == chars.size) {
//                chars[i + 1] = ' '
//                i = 0
//            } else {
//                i++
//            }
//            if (chars.size > 2 && chars[2] == ' ')
//                break
//        }
//        if (chars[0] == chars[1])
//            return true
//        else
//            return false
//    }
//

import kotlin.math.max
import kotlin.math.min

fun findRelativeRanks(score: IntArray): Array<String> {
    var x=mutableListOf<Int>()
    var y=mutableListOf<String>()
    for(i in score.indices){
        x.add(score[i])
    }
    x.sort()
    x.reverse()
    var a=x[0]
    var b=x[1]
    var c=x[2]
    for(i in score.indices){
        if(score[i]==a)
            y.add("Gold Medal")
        else if(score[i]==b)
            y.add("Silver Medal")
        else if(score[i]==c)
            y.add("Bronze Medal")
        else
        {
            for(j in x.indices)
            {
                if(score[i]==x[j])
                {
                    var p=j+1
                        y.add(p.toString())
                    break
                }
            }
        }
    }
    return y.toTypedArray()
}




fun sortEvenOdd(nums: IntArray): IntArray {
    var x=mutableListOf<Int>()
    var y=mutableListOf<Int>()
    var z=mutableListOf<Int>()
    var i=0;
    while(i<nums.size){
        x.add(nums[i])
        i+=2
    }
    var j=1;
    while(j<nums.size){
        y.add(nums[j])
        j+=2
    }
    x.sort()
    y.sort()
    y.reverse()
    println(x)
    println(y)
    var p=0
    while(p< max(x.size,y.size)){
        if(p<x.size)
            z.add(x[p])
        if(p<y.size)
        z.add(y[p])
        p++;
    }
        return z.toIntArray()
}




fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var x=mutableListOf<Int>()
    var c=0
    if(nums.size>=2){
    for(i in 0 until nums.size-1){
        if(nums[i]==nums[i+1] && nums[i]==1)
        {
            c++
        }
        else if(nums[i]==1 && nums[i]!=nums[i+1])
        {
            x.add(c+1)
            c=0;
        }
    }
    if(nums[nums.size-2]==1 && nums[nums.size-1]==1)
        x.add(c+1)
    else if(nums[nums.size-2]==0 && nums[nums.size-1]==1) {
        for (i in nums.indices) {
            if (nums[i] == 1) {
                c = 1
                x.add(c)
                break
            }
        }
    }}
        x.sort()
        x.reverse()
    var p=-6
    if(nums.size==1)
    {
        if(nums[0]==1)
            p=1
        else
            p=0
    }
    else if(x.isEmpty())
    {
        return 0
    }
    else {
        p = x[0]
    }
        return p
}


fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var cnt = 0
    if (timeSeries.size >= 2) {
        for (i in 0 until timeSeries.size - 1) {
            var p = timeSeries[i]
            cnt += duration
            var t = p + duration
            if (t > timeSeries[i + 1]) {
                cnt = cnt - (t - timeSeries[i + 1])
            }
        }
        return cnt + duration
    } else {
        cnt = duration
        return cnt
    }
}


fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        for(i in 0 until k)
        {
            var mn=nums.min()
            for(i in 0 until nums.size)
            {
                if(mn==nums[i])
                {
                    nums[i]=multiplier*nums[i]
                    break
                }
            }
        }
    return nums
}

fun smallestIndex(nums: IntArray): Int {
    var x=0
    var  y=-1
    for( i in 0 until nums.size){
        var p=nums[i]
        var cnt=0
        while(p>0)
        {
            var m=p%10;
            cnt+=m
            if(p>=10) {
                p = p / 10
            }
            else
            {
                break

            }

        }
        if(cnt==i){
            x=1
            y=i
            break}

    }
    if(x==1)
        return y
    else
        return -1

}

fun getNoZeroIntegers(n: Int): IntArray {
    var x=intArrayOf(2)
    if((n-1)%10==0)
    {
        x[0]=2
        x[1]=n-2
    }
    else
    {
        x[0]=1

    }

    return intArrayOf()
}



fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    var x = mutableListOf<String>()
    var y = mutableListOf<Int>()
    var z = mutableListOf<Int>()
    var p = mutableListOf<String>()

    for (i in 0 until list1.size) {
        for (j in 0 until list2.size) {
            if (list1[i] == list2[j]) {
                x.add(list1[i])
            }
        }
    }

    var a = -2
    var b = -2
    for (i in 0 until x.size) {
        for (j in 0 until list1.size) {
            if (x[i] == list1[j]) {
                a = j
                break
            }
        }
        for (k in 0 until list2.size) {
            if (x[i] == list2[k]) {
                b = k
                break
            }
        }
        y.add(a + b)
    }

    for (i in 0 until y.size)
        z.add(y[i])
    z.sort()

    for (i in 0 until y.size) {
        if (y[i] == z[0])
            p.add(x[i])
    }

    return p.toTypedArray()
}

fun main() {
    val nums = arrayOf("Shogun","Tapioca Express","Burger King","KFC")
    val list = arrayOf("KFC","Shogun","Burger King")
    println(findRestaurant(nums, list).contentToString())
}
