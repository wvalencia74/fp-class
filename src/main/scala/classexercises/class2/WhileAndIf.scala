package classexercises.class2

object WhileAndIf {

  def simularWhile(condition:Boolean): Unit ={
    if(condition) simularWhile(true)
    else simularWhile(false)
  }

  def probarIfElse(firstCondition:Boolean, secondCondition:Boolean, one:Any, two:Any, three:Any) ={
    if(firstCondition) one
    else if (secondCondition) two
    else three
  }
}
