public class FactoryProducer {
   public static AbstractFactory getFactory(int type){   
      if(type==1){
         return new MilkFactory();         
      }
      else if(type==2){
         return new CoffeeFactory();
      }else if(type==3){
         return new TeaFactory();
      }
      return null;
   }
}
