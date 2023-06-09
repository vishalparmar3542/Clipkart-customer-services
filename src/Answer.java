/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author visha
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;

import  java.io.*;
import  java.io.FileReader;


public class Answer {
    boolean found;
    private String basicquestion;
    String question;

  
    HashMap<List<String>,List<String>>  smartAnswer=new HashMap<>();
    Answer()
      {
          createbot();
      }
      private void createbot() {


                try{
                    BufferedReader  smartbuffer = new BufferedReader(new FileReader("C:\\Users\\visha\\OneDrive\\Documents\\NetBeansProjects\\MajorfinalchatBot\\src\\res\\advance.txt"));
                     String line="";

                     while((line=smartbuffer.readLine())!=null)
                     {
                         String [] keyvalue=line.split("\t",2);

                        String[] key=keyvalue[0].split(",");

                            String[] value = keyvalue[1].split(",");

                            smartAnswer.put(Arrays.asList(key), Arrays.asList(value));

                     }

                }catch(IOException e)
                {
                 System.out.println("  error while fetching smart file  : " +e);
                 }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(" smart  file not correct");
                }
      }




   public String getAnswer(String question)
   {
       found=false;
       this.question=question;
       basicquestion=basic(question);
       if(basicquestion.equalsIgnoreCase("help")) {
           return "call 911 for help";
       }

       if(!found)
       {
           for(List <String >keys :smartAnswer.keySet())
           {
               for(String eachkey :keys )
               {      String beachkey=basic(eachkey);
                    if(beachkey.equalsIgnoreCase(basicquestion))
                    {

                        found=true;
                        List<String>values=smartAnswer.get(keys);
                        int  length=values.size();

                        int rand=(int)Math.floor(Math.random()*length);

                       return  values.get(rand);
                    }
               }
           }

       }
       //to do (main reply getter from file)
       return "we don't have answer to this";
   }

    static public String basic(String val)
    {

        return  val.replaceAll("[^\\w]","");
    }

    
   


}

