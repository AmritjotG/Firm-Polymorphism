public class Commission extends Hourly //Commission Extends and adds to the Hourly Class
{
    //This is the percentage that will be multiplied to the totalSales, which is specified in the Staff List
    protected double CommissionRate;
    //This is the amount Sales of a employee which is added in the Staff class, after the staffList.
    protected double totalSales;

    public Commission (String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commrate)
    {
        //This part makes it so that the Commission Method can have the CommissionRate Defined in the StaffList
        //super allows to retrieve parts from the parent class/the class higher in the hierarchy
        super(eName, eAddress, ePhone, socSecNumber, rate);
        CommissionRate = commrate;
        totalSales = 0; //makes sure that total sales is 0 at this point
    }

    public void addSales(double sales)
    {
        totalSales +=sales; //this will make it so that the amount of sales can be added like how hours are added.
    }

    public double pay()
    {
    //this takes the amount being paid after the hourly payment is calculated and adds the amount of money made in commissions
        double payment = super.pay() + totalSales * CommissionRate;

        totalSales = 0;
        //total sales is set to 0 to start fresh with the next employee payment.

        return payment;
    }

    public String toString()
    {
        //Using super allows the class to take the string result after the hourly toString to add the total Sales number
        String result = super.toString();

        result += "\nTotal Sales: " + totalSales;

        return result;
    }
}
