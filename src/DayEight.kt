import kotlin.math.abs
import kotlin.math.min
fun checkIfExist(arr: IntArray): Boolean {
    arr.sort()
    var p=0
    for(i in 0 until arr.size-1){
        if(arr[i]>=0) {
            for (j in i + 1 until arr.size) {
                if (2 * arr[i] == arr[j]) {
                    p = 1
                    break
                }
            }
        }
        else
        {
            for (j in i + 1 until arr.size) {
                if (arr[i] == 2*arr[j]) {
                    p = 1
                    break
                }
            }
        }
        if(p==1)
            break
    }
    if(p==1)
        return true
    else
        return false
}



fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    arr.sort()
    var p=arr[1]-arr[0]
    var c=1
    for(i in 1 until arr.size-1)
    {
        if(arr[i+1]!=arr[i]+p) {
            c=0
            break
        }
    }
    if(c==0 && arr.size>0)
        return false
    else
        return true
}

fun checkRecord(s: String): Boolean {
    var c=0
    var p=0
    for(i in 0 until s.length)
    {
        if(s[i]=='A')
            c++
    }
    if(c>=2)
        return false
    else
    {
       for(i in 0 until s.length-2)
       {
           if(s[i]=='L' && s[i+1]=='L' && s[i+2]=='L'){
               p=1
               break}
       }
        if(p==1)
            return false
        else
            return true
    }

}


fun detectCapitalUse(word: String): Boolean {
    var c=0
    var d=0
    var e=0
    for( i in 0 until word.length)
    {
        if(word[i].isUpperCase())
            c++
        else
            d++
    }
    if(c==word.length||d==word.length)
        return true
    else if(c==1 && word[0].isUpperCase()==true && d+1==word.length)
        return true
    else
        return false

}

fun minTimeToType(word: String): Int {
    var c=0
    var ptr=97
    for(i in 0 until word.length)
    {
        var x=word[i].code
        c+=min(abs(ptr-x),26-abs(ptr-x))
        ptr=x;

    }
    return c+word.length

}

fun fizzBuzz(n: Int): List<String> {
    var x=mutableListOf<String>()
    for(i in 1..n)
    {
        if(i%3==0 && i%5==0)
            x.add("FizzBuzz")
        else if(i%3==0)
            x.add("Fizz")
        else if(i%5==0)
            x.add("Buzz")
        else
            x.add(i.toString())

    }
    return x

}

fun judgeCircle(moves: String): Boolean {

    var l=0
    var r=0
    var u=0
    var d=0
    for(i in 0 until moves.length)
    {
        if(moves[i]=='L')
            l++
        else if(moves[i]=='R')
            r++
        else if(moves[i]=='U')
            u++
        else
            d++

    }
    if(l==r && u==d)
        return true
    else
        return false

}


fun commonFactors(a: Int, b: Int): Int {
    var x=mutableListOf<Int>()
    var y=mutableListOf<Int>()

    for(i in 1 until (a/2)+1)
    {

        if (a % i == 0)
            x.add(i)
    }

    x.add(a)
    for(j in 1 until (b/2)+1)
    {
        if(b%j==0)
            y.add(j)
    }
    y.add(b)
    var c=0
    for(i in 0 until x.size)
    {
        for(j in 0 until y.size)
        {
            if(x[i]==y[j])
            {
                c++
                break
            }
        }
    }
    return c
}

fun main(){
    var x=25
    var y=30
    println(commonFactors(x,y))


}