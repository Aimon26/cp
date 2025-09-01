import java.math.BigInteger
import kotlin.math.max

fun maxProfit(prices: IntArray): Int {
    var minPr = Int.MAX_VALUE
    var maxPr = 0
    for (p in prices) {
        if (p < minPr)
            minPr = p
        else if (p - minPr > maxPr)
            maxPr = p - minPr
    }
    return maxPr
}



fun productExceptSelf(nums: IntArray): IntArray {
    var mul=1
    var x = MutableList(nums.size) { 1 }
    for(i in 0 until nums.size) {
        mul*=nums[i]
    }
    for(i in 0 until nums.size) {
        x.add(mul/nums[i])
    }
    return x.toIntArray()


}
//Maximum Subarray Sum - Kadane's Algorithm using kotlin

//fun maxSubArray(nums: IntArray): Int {
//    var res=nums[0]
//    for(i in 0 until nums.size) {
//        var cur=0
//        for(j in i  until nums.size) {
//            cur=cur+nums[j]
//            res= max(res,cur)
//
//        }
//    }
//
//    return res;
//
//}
//optimized kadanes
fun maxSubArray(nums: IntArray): Int {
var cur = nums[0]
var res = nums[0]

for (i in 1 until nums.size) {
    cur = max(nums[i], cur + nums[i])
    res = max(res, cur)
}

return res
}

fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    num1 = kotlin.math.abs(num1)
    num2 = kotlin.math.abs(num2)
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}
fun findGCD(nums: IntArray): Int {
    var x=nums.min()
    var y=nums.max()
    var ans=gcd(x,y)
    return ans
}



fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    var x=mutableListOf<Int>()
    var y=mutableListOf<Int>()
    for(i in 0 until nums.size) {
        x.add(nums[i])
    }
    x.sort()
    for(i in 0 until nums.size) {
        for(j in 0 until x.size) {
            if(x[j]==nums[i])
            {
                y.add(j)
                break
            }
        }
    }
    return y.toIntArray()

}


fun addStrings(num1: String, num2: String): String {
    val x= BigInteger(num1)
    val y=BigInteger(num2)
    val p= x+y

    return p.toString()
}




fun checkPerfectNumber(num: Int): Boolean {
    var x= mutableListOf<Int>()
    for(i in 1 until (num/2)+1)
    {
        if(num%i==0)
            x.add(i)
    }
    var sum =0
    for(i in 0 until x.size) {
        sum=sum+x[i]
    }
    if(sum==num)
        return true
    else
        return false

}

fun maximumProduct(nums: IntArray): Int {
    nums.sort()
    var s=nums.size
    var c=1
    if(nums[0]>=0) {
        c=nums[s - 1] * nums[s - 2] * nums[s - 3]
    }
    else if(nums[0]<0 && nums[1]>=0) {
        c=nums[s - 1] * nums[s - 2] * nums[s - 3]
    }
    else if(nums[s-1]<0){
        c= nums[s-1]*nums[s-2]*nums[s-3]
    }
    else if(nums[0]<0 && nums[1]<0 && (nums[s-2]<0 || nums[s-3]<0)) {
        c= (nums[0] * nums[1] * nums[s - 1])
    }
    else if(nums[0]<0 && nums[1]<0 && nums[s-2]>=0 && nums[s-3]>=0) {
        c= max(nums[0] * nums[1] * nums[s - 1], nums[s - 2] * nums[s - 1] * nums[s - 3])
    }
    return c
}
fun main()
{
    var x= intArrayOf(-3,-3,-2,-1)
    println(maximumProduct(x))
}
