package tasks

object Tasks extends App:
    //Task 1
    def zip[A, B](first: Sequence[A], second: Sequence[B]): Sequence[(A, B)] = (first, second) match
      case (Cons(h1, t1), Cons(h2, t2)) => Cons((h1, h2), zip(t1, t2))
      case _ => Nil()
    
    def take[A](l: Sequence[A])(n: Int): Sequence[A] = l match
      case Cons(h, t) if n > 0 => Cons(h, take(t)(n - 1))
      case _ => Nil()
    
    def concat[A](l1: Sequence[A], l2: Sequence[A]): Sequence[A] = (l1, l2) match
      case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1, concat(t1, Cons(h2, t2)))
      case _ => l2
    
    def flatMap[A, B](l: Sequence[A])(mapper: A => Sequence[B]): Sequence[B] = l match
      case Cons(h, t) => concat(mapper(h), flatMap(t)(mapper))
      case _ => Nil()

    def alternativeFilter[A](l1: Sequence[A])(pred: A => Boolean): Sequence[A] = flatMap(l1)(v => v match
      case exp if pred(exp) => Cons(exp, Nil())
      case _ => Nil()
    )

    def alternativeMap[A, B](l: Sequence[A])(mapper: A => B): Sequence[B] = flatMap(l)(a => Cons(mapper(a), Nil()))
    
    def getMin(a: Int, b: Int): Int = (a, b) match
      case (_, _) if a < b => a
      case (_, _) if a > b => b

    def min(l: Sequence[Int]): Optional[Int] = l match
      case Cons(h1, Cons(h2, t)) => min(Cons(getMin(h1, h2), t))
      case Cons(h, _) => Optional.Just(h)
      case Nil() => Optional.Empty()

    //Task 2

    def getCourses(l: Sequence[Person]): Sequence[String] = 
        val teachers = filter(l)(!isStudent(_))
        map(teachers)(x => course(x))

    def foldLeft(seq: Sequence[Int])(i: Int)(f: (Int, Int) => Int): Int = seq match
        case Cons(h, t) => f(foldLeft(t)(i)(f), h)
        case _ => i

    //Task 3

    def takeWhile[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match
      case Cons(head, tail) if pred(head()) => cons(head(), takeWhile(tail())(pred))
      case _ => Empty()

    def fill[A](n: Int)(a: A): Stream[A] = n match 
      case n if n > 0 => Cons(() => a, () => fill(n - 1)(a))
      case 0 => Empty()

    def getPellNumber(n: Int): Int = n match
      case n if n <= 2 => n
      case _ => 2 * getPellNumber(n - 1) + getPellNumber(n - 2)   

    def pell[A](): Stream[Int] = 
      map(Stream.iterate(0)(_ + 1))(getPellNumber(_))


