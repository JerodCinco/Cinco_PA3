class Application{
        public static void main(String[] args){
                SavingsAccount saver1 = new SavingsAccount(2000.0); //Instantiate saver 1 balance of $2000.00
                SavingsAccount saver2 = new SavingsAccount(3000.0); //saver 2 balance $3000.00
                SavingsAccount.modifyInterestRate(4.0); // setting interest rate to 4.0%
                System.out.println("Month \t\t Saver1 \t Saver2");

                for(int i=1; i<=12; ++i){  //print the savings
                        saver1.calculateMonthlyInterest();
                        saver2.calculateMonthlyInterest();
                        System.out.print("Month " + i + ": \t");
                        saver1.showBalance();
                        System.out.print("\t"); //makae spae
                        saver2.showBalance();
                        System.out.println();
                }

                SavingsAccount.modifyInterestRate(5.0); // Changing the interest rate to 5%

                saver1.calculateMonthlyInterest();
                saver2.calculateMonthlyInterest();

                System.out.print("Month 13: \t"); //for the 13th month w/ 5% interest rate
                saver1.showBalance();
                System.out.print("\t");
                saver2.showBalance();
                System.out.println();
        }
}