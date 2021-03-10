package org.techtown.array

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //버튼을 클릭하면 이벤트가 일어난다.
        button.setOnClickListener {
            //names변수는 홍길동들을 배열로 한다.
            val names = arrayOf("홍길동1", "홍길동2", "홍길동3")
            //names2변수는 배열을 가진다. 크기는 3, 홍길동을 3개 넣는다. 홍길동뒤에는 인덱스 +1
            //즉, 홍길동0+1 홍길동1+1 홍길동 2+1
            val names2 = Array<String>(3, {index -> "홍길동${index+1}"})
            //names3은 배열을 가진다. null값으로 String으로 값을 받고 배열의 크기는 3
            val names3 = arrayOfNulls<String>(3)
            //names4는 비어있는 배열을 가진다. null값도 아닌. String으로 받는다.
            val names4 = emptyArray<String>()

            //배열을 String을로 받는다. names = 홍길동1 홍길동 2 홍길동3
            textView.append("\n${Arrays.toString(names)}")
            //names2 = 홍길동1 홍길동2 홍길동3
            textView.append("\n${Arrays.toString(names2)}")
            //names3 = null null null
            textView.append("\n${Arrays.toString(names3)}")
            //names4 = [] null값조차 없다.
            textView.append("\n${Arrays.toString(names4)}")
        }

        //버튼2를 누르면 이벤트가 발
        button2.setOnClickListener {
            // digits함수는 int배열을 갖는다. 1 , 2, 3
            val digits = intArrayOf(1, 2, 3)
            //뱐수 digits의 인덱스 2를 4로 바꾼다. 즉 3 -> 4 / 1, 2, 4
            digits.set(2, 4)
            //aDigits는 변수 digits의 인덱스2를 얻는다. 즉 aDigits = 4
            val aDigits = digits.get(2)
            //aDigits는 4는 인덱스2, 3번째 숫
            textView.append("\n세번째 숫자 : ${aDigits}")
            //digits의 배열은 1, 2, 4 -> 원소의 갯수는 3
            textView.append("\n원소 갯수 : ${digits.count()}")

            //변수 digits2는 digits에 5를 추가한다.
            val digits2 = digits.plus(5)
            //5가 추가된 digits2의 현재 배열은 1, 2, 4, 5
            textView.append("\n${Arrays.toString(digits2)}")
            //aIndex는 digits2의 5의 인덱스 이다. 즉, 인덱스가 0 1 2 3 임으로 indexO(5)는 3
            // aIndex = 3
            val aIndex = digits2.indexOf(5)
            //digit3은 digits2의 배열에서 잘라낸다. 1~index의 값을
            //즉, 1~3의 인덱스를 잘란다.
            val digits3 = digits2.sliceArray(1..aIndex)
            //1 , 2, 4, 5 의 배열에서 1~3의 인덱스를 잘래내면 2, 4, 5가 남는다.
            textView.append("\n${Arrays.toString(digits3)}")
        }

        //버튼3을 누르면 이벤트가 발
       button3.setOnClickListener {
           //digits는 int 배열을 갖는다. 2, 1, 3
            val digits = intArrayOf(2, 1, 3)
           //forEach는 배열의 요소를 하나씩 꺼내는 메소드
           //즉 digits에서 요소를 하나씩 꺼낸다.
           //요소는 elem이라고 한다. elem을 보여라 -> 하나씩 꺼내니까 2, 1, 3
            digits.forEach { elem -> textView.append("$elem") }

            textView.append("\n")

           //for문으로 digits의 elem을 반복한다.
            for (elem in digits) {
                textView.append("$elem")
            }

            textView.append("\n")
           //iterator를 사용. 첫 뻔째 요소부터 마지막 요소까지 이동.
           //while과 99% 같이 사용한다.
            val iter = digits.iterator()
           // iter에서 하나씩 넘긴다.
            while (iter.hasNext()) {
                //변수 elem는 iter의 next, 요소가 없을 때까지 계속 넘어간다.
                val elem = iter.next()
                //요소를 하나씩 넘기면 확인한다. 2, 1, 3
                textView.append("$elem")
            }
        }

        //버튼 4를 누르면 이벤트 발생
        button4.setOnClickListener {
            //digits 변수는 int배열을 갖는다. 2, 1, 3
            val digits = intArrayOf(2, 1, 3)

            //변수 sorted는 digits배열을 오름차순으로 정리한다.
            val sorted = digits.sortedArray()
            //즉 sorted = 1, 2, 3
            textView.append("\n${Arrays.toString(sorted)}")

            //변수 sorterDesc는 digits배열을 내림차순으로 정리한다.
            val sortedDesc = digits.sortedArrayDescending()
            //즉 sortedDesc = 3, 2, 1
            textView.append("\n${Arrays.toString(sortedDesc)}")

            textView.append("\n")
            //변수digits에 필터를 건다. -> elem은 1보다 크다.
            //digits에서 elem을 하나씩 꺼낸다. elem = 1보다 큰 요소
            //즉 2, 3
            digits.filter { elem ->elem > 1 }.forEach { elem -> textView.append("$elem") }
        }
    }
}