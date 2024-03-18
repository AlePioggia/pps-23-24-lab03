package tasks
import u03.Sequences.*
import Sequence.*
import u02.Modules.Person
import u02.Modules.Person.Teacher
import u02.Modules.Person.Student
import u02.Modules.isStudent
import u02.Modules.Person.course

object Task2 extends App:
    def getCourses(l: Sequence[Person]): Sequence[String] = 
        val teachers = filter(l)(!isStudent(_))
        map(teachers)(x => course(x))


