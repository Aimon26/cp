import jdk.internal.classfile.components.ClassPrinter
import kotlin.math.sqrt
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxDiagonal = 0.0
        var maxArea = 0

        for (rect in dimensions) {
            val diagonal = sqrt(rect[0].toDouble() * rect[0] + rect[1].toDouble() * rect[1])
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal
                maxArea = rect[0] * rect[1]
            } else if (diagonal == maxDiagonal) {
                maxArea = maxOf(maxArea, rect[0] * rect[1])
            }
        }

        return maxArea
    }
/*fun main()
{
    val numbers=mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    val capital=mutableMapOf(
        "bangladesh" to "dhaka",
        "india" to "delhi"
    )
    println(numbers);
    println(numbers[2])
    capital["japan"]="tokyo"
    capital.remove("bangladesh")
    println(capital)
    for((key,value) in capital) {
    println("$key -> $value")
    }

    val ptr=listOf(1,2,3,4)
    println(ptr)
    println(ptr[2])

    val x=mutableListOf(1,2,3,4,5,6,7,8,9,10)
    println(x)
    println(x[2])
    x.add(11)
    println(x)
    x.add(7,11)
    println(x);
    x.remove(7)
    println(x)
    x.removeAt(8)
    println(x)
    for(i in x.indices)
        println(x[i])
    val max=x.maxOrNull();
    println(max)
    val min=x.minOrNull();
    println(min)
    val sum=x.sum()
    println(sum)

    val set=setOf("anda","panda","ganda","sanda","zanda","gunda")
    println(set)
    println(set.elementAt(3))
    for(i in set.indices)
        println(set.elementAt(i))
}*/
fun removeDuplicates(nums: IntArray): Int {
    var x = mutableListOf<Int>()
    if (nums.isEmpty())
        return 0
    var count = 1
    for(i in 0 until nums.size-1)
    {
        if (nums[i] != nums[i+1])
        {
            count++
            x.add(nums[i])
        }
    }
    x.add(nums[nums.size-1])
    for(j in 0 until count)
        nums[j]=x[j]
    return count
}





fun removeElement(nums: IntArray, `val`: Int): Int {
    var x = mutableListOf<Int>()
    var count =0
    for(i in 0 until nums.size)
        if(nums[i] != `val`)
        {
            count++
            x.add(nums[i])
        }
    for(j in 0 until count) {
        nums[j] = x[j]
        println(nums[j])
    }
    return count


}



fun searchInsert(nums: IntArray, target: Int): Int {
    var p=0
    for(i in 0 until nums.size)
    {
        if (nums[i]==target)
        {
            p=i
            break
        }
        else if(nums[i]>target)
        {
            p=i
            break
        }
        else if(i==nums.size-1)
        {
            p=i+1
            break;
        }
        else
            p=0
    }
    return p

}



fun isUgly(n: Int): Boolean {
    var m=n
    while(m>=1)
    {
        if(m%2==0)
            m/=2;
        else if(m%3==0)
            m/=3
        else if(m%5==0)
            m/=5
        else
            break
    }
    if(m==1)
        return true
    else
        return false

}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var c = 0
    var j = 0
    for (i in g.indices) {
        while (j < s.size && s[j] < g[i]) {
            j++
        }
        if (j < s.size) {
            c++
            j++
        } else {
            break
        }
    }
    return c
}


fun plusOne(digits: IntArray): IntArray {
    var x = mutableListOf<Int>()
    var p= digits[digits.size-1]+1;
    println(p)
    var m=digits.size;
    digits[m-1]=p;
    println(digits[m-1])
    return digits
}


fun lengthOfLastWord(s: String): Int {
    var sz=s.length;
    var c=0
    var t=0
    while(sz!=0) {
        if (s[sz - 1] == ' ' && t==0)
            sz--
        else if (s[sz - 1] == ' ' && t==1)
            break;
        else
        {
            c++
            t=1
            sz--
        }
    }
    return c;

}


fun singleNumber(nums: IntArray): Int {
    nums.sort()
    var i=0
    var p=0
    var x=0
    while(i<=nums.size-2)
    {
        if (nums[i] != nums[i+1])
        {
            p=nums[i]
            x=1
            break
        }
        else
            i+=2
    }
    if(x==1)
        return p
    else
        return nums[nums.size-1]

}

fun main() {
    val arr = intArrayOf(1)
    println(singleNumber(arr))  // Output: 1
}









