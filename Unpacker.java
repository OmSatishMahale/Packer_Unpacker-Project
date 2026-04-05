//Unpacking Code

import java.io.*;
import java.util.*;

public class Unpacker
{
    public static void main(String A[]) throws Exception
    {
        //Variable creation
        int FileSize = 0;
        int i=0;
        int iRet = 0;

        byte Key = 0x11;

        Scanner sobj = null;
        String FileName = null;
        File fpackobj = null;
        File fobj = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
        byte bHeader[] = new byte[100];
        String Header = null;
        String Tokens[] = null;
        byte Buffer[] = null;

        sobj = new Scanner(System.in);

        System.out.println("Enter the name of packed file : ");
        FileName = sobj.nextLine();

        fpackobj = new File(FileName);

        if(fpackobj.exists() == false)
        {
            System.out.println("Error : There is no such packed file");
            return;
        }

        fiobj = new FileInputStream(fpackobj);

        //Read the header
        while((iRet = fiobj.read(bHeader,0,100))!= -1)
        {
            Header = new String(bHeader);           //Byte to string conversion

            System.out.println("Header : "+Header);

            Header = Header.trim();
            
            Tokens = Header.split(" ");

            System.out.println("File Name : "+Tokens[0]);
            System.out.println("File Size : "+Tokens[1]);

            fobj = new File(Tokens[0]);
            fobj.createNewFile();
            fobj.createNewFile();

            foobj = new FileOutputStream(fobj);

            FileSize = Integer.parseInt(Tokens[1]);

            //Buffer for Reading the data
            Buffer = new byte[FileSize];

            //Read from packed file
            fiobj.read(Buffer,0,FileSize);

            //Decrypt the data
            for(i=0;i<FileSize;i++)
            {
                Buffer[i] = (byte)(Buffer[i] ^ Key);
            }
            
            //Write into Extracted file
            foobj.write(Buffer,0,FileSize);
            }
    }   
}