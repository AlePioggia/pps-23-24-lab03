import org.junit.*
import org.junit.Assert.*
import u03.Sequences.Sequence.take
import u03.Sequences.Sequence.Cons
import u03.Sequences.Sequence.Nil

class Task1Test:

    @Test def testTake() =
        val lst = Cons(10 , Cons(20 , Cons(30, Nil())))
        assertEquals(take(lst)(2), Cons(10 , Cons(20, Nil()))) 
        // assertEquals(take(lst)(0), Nil()) 
        // assertEquals(take(lst)(5), Cons(10 , Cons(20, Cons(30 , Nil())))) 
