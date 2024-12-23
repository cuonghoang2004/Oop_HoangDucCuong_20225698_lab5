import java.util.Scanner;
public class numberOfDay {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the month: ");
        String monthInput = scanner.nextLine();
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        if(year < 0) System.out.println("Invalid year");
        
        int month = getMonth(monthInput);
        if( month == -1 ) System.out.println("Invalid month");
        int day = getDay(month, year);

        System.out.println("Numbers of day is: " + day);
          
    }
    public static int getMonth(String monthInput) {
        switch (monthInput) {
            case "January":
            case "Jan":
            case "Jan.":
            case "1":
                return 1;
            case "February":
            case "Feb":
            case "Feb.":
            case "2":
                return 2;
            case "March":
            case "Mar":
            case "Mar.":
            case "3":
                return 3;
            case "April":
            case "Apr":
            case "Apr.":
            case "4":
                return 4;
            case "May":
            case "5":
                return 5;
            case "June":
            case "Jun":
            case "Jun.":
            case "6":
                return 6;
            case "July":
            case "Jul":
            case "Jul.":
            case "7":
                return 7;
            case "August":
            case "Aug":
            case "Aug.":
            case "8":
                return 8;
            case "September":
            case "Sep":
            case "Sep.":
            case "9":
                return 9;
            case "October":
            case "Oct":
            case "Oct.":
            case "10":
                return 10;
            case "November":
            case "Nov":
            case "Nov.":
            case "11":
                return 11;
            case "December":
            case "Dec":
            case "Dec.":
            case "12":
                return 12;
            default:
                return -1; 
        }
    }
    public static int getDay(int month, int year){
        switch (month) {
            case 1: 
            case 3: 
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
        
    }

