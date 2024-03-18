package tasks

class TasksTests:
  // Task 1

  @Test def testTake() =
    assertEquals(Cons(10, Cons(20, Nil())), take(l)(2))
    assertEquals(Cons(10, Cons(20, Cons(30, Nil()))), take(l)(3))
    assertEquals(Nil(), take(l)(0))
    assertEquals(Nil(), take(Nil())(2))

  @Test def testZip() =
    val l2: Sequence[String] = Cons("10", Cons("20", Cons("30", Nil())))
    assertEquals(
      Cons((10, "10"), Cons((20, "20"), Cons((30, "30"), Nil()))),
      zip(l, l2)
    )
    assertEquals(Nil(), zip(l, Nil()))
    assertEquals(Nil(), zip(Nil(), l2))
    assertEquals(Nil(), zip(Nil(), Nil()))

  @Test def testConcat() =
    val l2: Sequence[Int] = Cons(40, Cons(50, Nil()))
    assertEquals(
      Cons(10, Cons(20, Cons(30, Cons(40, Cons(50, Nil()))))),
      concat(l, l2)
    )
    assertEquals(Cons(40, Cons(50, Nil())), concat(Nil(), l2))

  @Test def testFlatMap() =
    assertEquals(
      Cons(11, Cons(21, Cons(31, Nil()))),
      flatMap(l)(v => Cons(v + 1, Nil()))
    )
    assertEquals(Nil(), flatMap(Nil())(v => Cons(v, Nil())))

  @Test def testMin() =
    assertEquals(Just(10), min(l))
    assertEquals(Just(1), min(Cons(1, Nil())))
    assertEquals(Empty(), min(Nil()))

  @Test def testAlternativeFilter() =
    assertEquals(Cons(20, Cons(30, Nil())), alternativeFilter(l)(_ >= 20))
    assertEquals(Cons(10, Cons(30, Nil())), alternativeFilter(l)(_ != 20))

  @Test def testAlternativeMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), alternativeMap(l)(_ + 1))
    assertEquals(
      Cons("10", Cons("20", Cons("30", Nil()))),
      alternativeMap(l)(_ + "")
    )

    // Task 2

    val l: Sequence[Person] = Cons(
      Student("Mario", 10),
      Cons(Teacher("Maria", "karl"), Cons(Student("Milena", 12), Nil()))
    )

    @Test def testGetCourses() =
      assertEquals(getCourses(l), Cons("karl", Nil()))

    @Test def testFoldLeft() =
      val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
      assertEquals(foldLeft(lst)(0)(_ - _), -16)
      assertEquals(foldLeft(lst)(0)(_ + _), 16)

    //Task 3

    @Test def takeWhile(): Unit = 
      val str1 = Stream.iterate(0)(_ + 1) // {0,1,2,3,..}
      val str2 = Stream.takeWhile(str1)(_ < 5) // {0,1,2,3,4}
      assertEquals(Cons(0, Cons(1, Cons(2, Cons(3, Cons(4, Nil()))))), Stream.toList(str2))

    @Test def testFill(): Unit = 
      assertEquals(toList(Stream.fill(3)('a')), Cons ('a', Cons ('a',Cons ('a', Nil ()))))
      assertEquals(toList(Stream.fill(3)(5)), Cons (5, Cons (5,Cons (5, Nil ()))))

    @Test def testPellNumbers(): Unit = 
      assertEquals(Stream.toList(Stream.take(pell())(5)), Cons(0, Cons (1, Cons(2, Cons(5, Cons(12, Nil ()))))))
