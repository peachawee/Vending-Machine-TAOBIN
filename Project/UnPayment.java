public class UnPayment implements State
{
    private Vendingmachine v;
    public UnPayment(Vendingmachine v){
        this.v = v;   
    }
    public void choosePaymentMethod(){
        System.out.println("-press (1) for pay by mobile banking.");
        System.out.println("-press (2) for pay by cash.");
        System.out.println("-press (3) for pay by point.");
        System.out.println("-press (5) to cancel.");
        int temp = v.kb.nextInt();
        while(temp!=1 && temp!=2 && temp!=3 && temp!=5){
            System.out.println("Please press only (1),(2),(3) or (5) !!");
            System.out.println("-press (1) for pay by mobile banking.");
            System.out.println("-press (2) for pay by cash.");
            System.out.println("-press (3) for pay by point.");
            System.out.println("-press (5) to cancel.");
            temp = v.kb.nextInt();
            }
        if(temp==5){
            v.cancel();
        }
        if(temp==1){
            System.out.println("QR code PromPay");
            System.out.println("__________");
            System.out.println("|..|__|..|");
            System.out.println("|___..___|");
            System.out.println("|..|__|..|");
            System.out.println("__________");
            System.out.println("When you scan success please press (1) or Choose other choice to pay press (5)");
            int x = v.kb.nextInt();
            while(x!=1 && x!=5){
            System.out.println("Please press only (1) or (5)");
            System.out.println("When you scan success please press (1) or Choose other choice to pay press (5)");
            x = v.kb.nextInt();
            }
            if(x == 5){
                choosePaymentMethod();
            }
            v.setState(v.collectPointState);
        }
        else if(temp==2){
            payByCash();
            v.setState(v.collectPointState);
        }
        else if(temp==3){
            payByPoint();
            v.setState(v.collectPointState);
        }
        
    }
    private void payByPoint(){
        while(true){
                String phone = v.enterPhoneNumber();
                if(v.checkPhone(phone)){
                    int no = v.db.checkMember(phone);
                    if(no>=0){
                        int point  = v.db.getPoint(no);
                        System.out.println("You have : "+point +" points");
                        if(point>=v.beverage.getPrice()){
                            v.context = new Context(new OperationSubstract());
                            v.context.executeStrategy(v.db, v.beverage.getPrice(), no);
                            point  = v.db.getPoint(no);
                            System.out.println("You have used : 15 points");
                            System.out.println("You have : "+point +" points");
                            return ;
                        }
                        else{
                            System.out.println("You don't have enough point.");
                            
                        }
                    }
                    else{
                        System.out.println("You haven't been a member ^-^.");
                    }
                    System.out.println("Please choose other choice to pay.");
                    choosePaymentMethod();
                    return ;
                }
                else{
                    System.out.println("Please try again.");
                }
            }
    }
    private void payByCash(){
        System.out.print("Please insert money: ");
        int save = v.kb.nextInt();
        int coin[] = {10,5,1};
        int banknote[] = {100,50,20};
        while(save<v.beverage.getPrice()){
            System.out.println("Please insert more:");
            save +=v.kb.nextInt();
        }
        double dif = save - v.beverage.getPrice();
        if(dif>0){
            //รับเฉพาะเหรัยญ 1,5,10,20,100
            for(int i=0;i<banknote.length; i++){
                int count = 0;
                while(banknote[i]<=dif){
                    dif-=banknote[i];
                    count++;
                }
                if(count>0){
                    System.out.println("Your change: "+banknote[i]+"Baht "+count+" bills.");
                }
            }
            for(int i=0;i<coin.length;i++){
                int count =0;
                while(coin[i]<=dif){
                    dif-=coin[i];
                    count++;
                }
                if(count>0){
                    System.out.println("Your change: "+coin[i]+"Baht "+count+" coins.");
                }
            }
        }
    }
    public void selectAndCreate(){
        throw new RuntimeException("Can't select and create.\nYou're in unpayment state.");
    }
    public void collectAPoint(){
        throw new RuntimeException("Can't collect a point.\nYou're in unpayment state.");
    }
    public void addTopping(){
        throw new RuntimeException("Can't add topping.\nYou're in unpayment state.");
    }
}
