import java.io.*;
import java.util.*;

public class Packer
{
    public static void main(String A[]) throws Exception
    {
        String Header = null;

        byte Key = 0x11;
        
        int iRet = 0;
        int i=0,j=0;
        byte Buffer[] = new byte[1024];

        byte bHeader[] = new byte[100];

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the name of Folder : ");
        String FolderName = sobj.nextLine();

        System.out.println("Enter the name of Packd File : ");
        String PackName = sobj.nextLine();

        File fobj = new File(FolderName);

        if((fobj.exists()) && (fobj.isDirectory()))
        {
            File Packobj = new File(PackName);

            Packobj.createNewFile();

            FileOutputStream foobj = new FileOutputStream(Packobj);

            FileInputStream fiobj = null;

            System.out.println("Folder already exist");

            File fArr[] = fobj.listFiles();
            System.out.println("Number of Files in the Folder are : "+fArr.length);

            for(i = 0;i < fArr.length;i++)
            {

                fiobj = new FileInputStream(fArr[i]);
            
                if(fArr[i].getName().endsWith(".txt"))
                {

                    //Header formation
                    Header = fArr[i].getName() + " " + fArr[i].length();
                    for(j=Header.length();j<100;j++)
                    {
                        Header = Header + " ";
                    }

                    bHeader = Header.getBytes();

                    //Write header into pack file
                    foobj.write(bHeader,0,100);

                    //Reade the data from input file from Marvellous folder
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        //Encryption Logic
                        for(j=0;j<iRet;j++)
                        {
                            Buffer[j] = (byte)(Buffer[j] ^ Key);
                        }

                        //Write the files data into pack file
                        foobj.write(Buffer,0,iRet);
                    }
                }
                fiobj.close();
            }
            foobj.close();
        }
        else
        {
            System.out.println("Folder does not exist");
        }
    }   
}