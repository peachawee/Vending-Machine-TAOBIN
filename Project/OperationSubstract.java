public class OperationSubstract implements Strategy{
   @Override
   public void doOperation(TaobinDataBase db, double num, int no) {
      int x = db.point.get(no)-(int)num;
      db.point.add(no,x);
   }
}