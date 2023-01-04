public class CollectPoint implements State
{
    private Vendingmachine v;
    public CollectPoint(Vendingmachine v){
        this.v = v;
    }
    public void collectAPoint(){
        System.out.println("Do you want to collect points?");
        System.out.println("-press (1) for Yes!.");
        System.out.println("-otherwise press other number for No!.");
        int temp = v.kb.nextInt();
        if(temp==1){
            String phone = v.enterPhoneNumber();
            if(v.checkPhone(phone)){
                int no = v.db.checkMember(phone);
                //
                if(no>=0){
                    v.context = new Context(new OperationAdd());
                    v.context.executeStrategy(v.db, 5, no);
                }else{
                    v.db.addMember(phone);
                    no = v.db.getSize()-1;
                }
                System.out.println("You have : "+v.db.getPoint(no) +" points");
            }else{
                collectAPoint();
            }
        }
    }
    public void addTopping(){
        throw new RuntimeException("Can't add topping.\nYou're in collect a point state.");
    }
    public void choosePaymentMethod(){
        throw new RuntimeException("Can't choose payment method.\nYou're in collect a point state.");
    }
    public void selectAndCreate(){
        throw new RuntimeException("Can't select and create.\nYou're in collect a point state.");
    }
}
