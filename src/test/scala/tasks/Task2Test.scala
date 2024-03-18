package tasks

import org.junit.*
import org.junit.Assert.*
import u03.Sequences.Sequence
import u02.Modules.*
import u02.Modules.Person
import u02.Modules.Person.Teacher
import u02.Modules.Person.Student
import u03.Sequences.*
import Sequence.*


class Task2Test:

    val l: Sequence[Person] = Cons(Student("Mario", 10), Cons(Teacher("Maria", "karl"), Cons(Student("Milena", 12), Nil())))

    @Test def testGetCourses() =
        assertEquals(getCourses(l), Cons(Student("Mario", 10), Cons(Student("Milena", 12), Nil())))
