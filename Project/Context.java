public class Context
{
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public void executeStrategy(TaobinDataBase db, double num, int no){
      strategy.doOperation(db, num, no);
   }
}
