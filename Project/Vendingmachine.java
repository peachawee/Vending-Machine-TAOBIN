import java.util.Scanner;
public class Vendingmachine
{
    Scanner kb = new Scanner(System.in);
    State  unSelectState ;
    State decorateState;
    State unpaymentState;
    State collectPointState ;
    State state;
    private String name = "Taobin eiei";
    AbstractFactory beverageFactory;
    Beverage beverage;
    TaobinDataBase db = new TaobinDataBase();
    Context context;
    public Vendingmachine(){
        unSelectState = new UnSelect(this);
        decorateState = new Decorate(this);
        unpaymentState = new UnPayment(this);
        collectPointState = new CollectPoint(this);
    }
    /*private void createProduct(int want, int temperat){
        beverageFactory = FactoryProducer.getFactory(want);
        String temp = "HOT";
        if(temperat==2) temp = "ICE";
        beverage = beverageFactory.getBeverage(temp);
    }*/
    void showAllProduct(){
        String[] BEVERAGE = {"MILK","COFFEE","TEA"};
        for(int i=0;i<3;i++){
            System.out.println("-"+(i+1)+" "+BEVERAGE[i]+" 15 Baht.");
        }
    }
    void startProcess(){
        showMenu();
        int temp = kb.nextInt();
        if(temp==1){
            state = new UnSelect(this);
            state.selectAndCreate();
            state.addTopping();
            showDesc();
            showPrice();
            state.choosePaymentMethod();
            state.collectAPoint();
            showDesc();
            System.out.println("Successfully!!");
        }
        else if(temp==2){
            topUp();
        }
        cancel();
    }
    void setState(State state){
        this.state = state;
    }
    State getState(){
        return state;
    }
    private void topUp(){
        System.out.println("Please select mobile network operator");
        System.out.println("or press (5) to cancel");
        System.out.println("- 1.AIS ");
        System.out.println("- 2.DTAC ");
        System.out.println("- 3.TRUE ");
        int temp = kb.nextInt();
        while(temp!=1 && temp!=2 && temp!=3 && temp!=5){
            System.out.println("Please press only (1),(2),(3) or (5) !!");
            System.out.println("Please select mobile network operator");
            System.out.println("- 1.AIS ");
            System.out.println("- 2.DTAC ");
            System.out.println("- 3.TRUE ");
            System.out.println("or press (5) to cancel");
            temp = kb.nextInt();
            }
        if(temp == 5){
            cancel();
        }
        while(true){
            String phone = enterPhoneNumber();
            if(checkPhone(phone)){
                System.out.println("Enter the amount you want to top up.");
                topUpbyCash();
                System.out.println("Top up Successfully!");
                return;
            }
            else{
                System.out.println("Please try again.");
            }
        }
    }
    void showMenu(){
        System.out.println("- - - START MENU - - -");
        System.out.println("-press (1) for select a products.");
        System.out.println("-press (2) for top up.");
        System.out.println("-press (5) to cancel.");
    }
    
    public void cancel(){
        beverageFactory = null;
        beverage = null;
        context = null;
        state = null;
        System.out.println("-------------------------------------------------------");
        startProcess();
    }
    
    String enterPhoneNumber(){
        System.out.println("Please enter your phone number: ");
        String phone = kb.next();
        return phone;
    }
    
    public boolean checkPhone(String phone){
        if(phone.length() == 10){
            return true;
        }
        System.out.println("Your phone number was wrong!!");
        return false;
    }
    
    private void topUpbyCash(){
        int t = kb.nextInt();
        System.out.print("Please insert money: ");
        int save = kb.nextInt();
        int coin[] = {10,5,1};
        int banknote[] = {100,50,20};
        while(save < t){
            System.out.println("Please insert more:");
            save +=kb.nextInt();
        }
        double dif = save - t;
        if(dif>0){
            //รับเฉพาะเหรัยญ 1,5,10,20,50,100
            for(int i=0;i<banknote.length; i++){
                int count = 0;
                while(banknote[i]<=dif){
                    dif-=banknote[i];
                    count++;
                }
                if(count>0){
                    System.out.println("Your change: "+banknote[i]+"Baht "+count+"bills.");
                }
            }
            for(int i=0;i<coin.length;i++){
                int count =0;
                while(coin[i]<=dif){
                    dif-=coin[i];
                    count++;
                }
                if(count>0){
                    System.out.println("Your change: "+coin[i]+"Baht "+count+" "+"coin.");
                }
            }
        }
    }
    void showDesc(){
        System.out.println("-->"+beverage.getDesc());
    }
    private void showPrice(){
        System.out.println("-->"+beverage.getPrice()+" Baht.");
    }
}
