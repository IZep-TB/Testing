package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Coin exchange system");
        Scanner Input = new Scanner(System.in);
//      ประกาศตัวเก็บจำนวนเหรียญในเครื่องแลกเหรียญ
        int count_ten = 0;
        int count_five = 100;
        int count_one = 100;
        while (true) {
            System.out.println("----START-----");
            System.out.println("Coin in System");
            System.out.println("10 B: "+count_ten);
            System.out.println("5 B: "+count_five);
            System.out.println("1 B: "+count_one);
            System.out.println("Please Enter money (100,50,20): ");
            String input = Input.nextLine();
            try {
//              เงื่อนไขให้โปรแกรมหยุดทำงาน
                if (input.equals("stop")) {
                    break;
                }
//              เติมเหรียญเข้าสู่ตู้แลกเหรียญ
                else if(input.equals("top up coin"))
                {
                    count_ten = 100;
                    count_five = 100;
                    count_one = 100;
                }
//              ประกาศค่าเป็นตัวเช็คจำนวนเหรียญในตู้แลกเหรียญ
                String cT = "F";
                String cF = "F";
                String cO = "F";
                int number = Integer.parseInt(input);
                 if (number == 0) {
                    System.out.println("Bath bill Only(100,50,20)");
                    continue;
                }
                if (number % 100 != 0) {
                    int bank = number % 100;
                    if (bank % 50 != 0) {
                        if (bank % 20 != 0) {
                            System.out.println("Bath bill Only(100,50,20)");
                            continue;
                        }
                    }
                }
//               เช็คเหรียญในตู้
                if(count_ten>0)
                {
                    cT = "T";
                }
                if(count_five>0)
                {
                    cF = "T";
                }
                if(count_one>0)
                {
                    cO = "T";
                }
                String chk = cT+cF+cO;
                int Ten = 0;
                int Five = 0;
                int One = 0;
                String result = "";
                String confirm = "";
//              เช็ค จำนวนเหรียญว่าในตู้มีเหรียญอะไรบ้าง
                switch (chk){
                    case "TTT": {
                        Ten = number / 10;
                        if (count_ten >= Ten) {
                            count_ten -= Ten;
                            number = number % 10;
                        } else {
                            Ten = count_ten;
                            number = number - Ten * 10;
                            count_ten = 0;
                        }
                        Five = number / 5;
                        if (count_five >= Five) {
                            count_five -= Five;
                            number = number % 5;
                        } else {
                            Five = count_five;
                            number = number - Five * 5;
                            count_five = 0;
                        }
                        One = number;
                        if (number > 5 && count_one >= number) {
                            count_one -= number;
                        } else {
                            if (number > 5) {
                                if (One>count_one)
                                {
                                    count_ten+=Ten;
                                    count_five+=Five;
                                    System.out.println("Not enough coins");
                                    break;
                                }
                                count_one -= number;
                            }
                            One = number % 5;
                            if (count_one >= One) {
                                count_one -= One;
                            } else {
                                if (number % 5 > count_one) {
                                    System.out.println("Not enough coins");
                                }
                                One = count_one;
                                count_one = 0;
                            }
                        }
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "FTT": {
                        Five = number / 5;
                        if (count_five >= Five) {
                            count_five -= Five;
                            number = number % 5;
                        } else {
                            Five = count_five;
                            number = number - Five * 5;
                            count_five = 0;
                        }
                        System.out.println(number);
                        One = number;
                        if (number > 5 && count_one >= number) {
                            count_one -= number;
                        } else {
                            if (number > 5) {
                                if (One > count_one) {
                                    count_ten += Ten;
                                    count_five += Five;
                                    System.out.println("Not enough coins");
                                    break;
                                }
                                count_one -= number;
                            }
                            One = number % 5;
                            if (count_one >= One) {
                                count_one -= One;
                            } else {
                                if (number % 5 > count_one) {
                                    System.out.println("Not enough coins");
                                }
                                One = count_one;
                                count_one = 0;
                            }
                        }
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "TFT": {
                        Ten = number / 10;
                        if (count_ten >= Ten) {
                            count_ten -= Ten;
                            number = number % 10;
                        } else {
                            Ten = count_ten;
                            number = number - Ten * 10;
                            count_ten = 0;
                        }
                        One = number;
                        if (number > 5 && count_one >= number) {
                            count_one -= number;
                        } else {
                            if (number > 5) {
                                if (One > count_one) {
                                    count_ten += Ten;
                                    count_five += Five;
                                    System.out.println("Not enough coins");
                                    break;
                                }
                                count_one -= number;
                            }
                            One = number;
                            if (count_one >= One) {
                                count_one -= One;
                            } else {
                                if (number % 5 > count_one) {
                                    System.out.println("Not enough coins");
                                }
                                One = count_one;
                                count_one = 0;
                            }
                        }
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "TTF": {
                        Ten = number / 10;
                        if (count_ten >= Ten) {
                            count_ten -= Ten;
                            number = number % 10;
                        } else {
                            Ten = count_ten;
                            number = number - Ten * 10;
                            count_ten = 0;
                        }

                        Five = number / 5;
                        if (count_five >= Five) {
                            count_five -= Five;
                        } else {
                            if (count_five<Five){
                                System.out.println("Not enough coins");
                                break;
                            }
                            Five = count_five;
                            count_five = 0;
                        }
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "FFT":
                        {
                        if (count_one >= number) {
                            count_one -= number;
                        } else {
                            System.out.println("Not enough coins");
                            break;
                        }
                        One = number;
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "TFF":
                    {

                        if (count_ten >= number/10 && number %10 ==0) {
                            count_ten -= number/10;
                        } else {
                            System.out.println("Not enough coins");
                            break;
                        }
                        Ten = number/10;
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "FTF":
                    {
                        if (count_five >= number/5 && number %5 ==0) {
                            count_five -= number/5;
                        } else {
                            System.out.println("Not enough coins");
                            break;
                        }
                        Five = number/5;
                        result = "Check coin" + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One;
                        System.out.println(result);
                        System.out.println("Confirm exchage (Y/N)");
                        confirm = Input.nextLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Return coin: " + "\n" + "10 Bath: " + Ten + "\n" + "5  Bath: " + Five + "\n" + "1  Bath: " + One);
                        } else {
                            System.out.println("Return money: " + input);
                            count_ten += Ten;
                            count_five += Five;
                            count_one += One;
                        }
                        break;
                    }
                    case "FFF": {
                        System.out.println("Coin is Empty");
                        break;
                    }
                }
            } catch (Exception e) {
                String empty = "";
                if (input.equals("top up coin"))
                {
                    System.out.println("Top up successfully");
                }
                else if (input.equals(empty)){
                    System.out.println("Please enter Money");
                }

            }
        }
    }
}
