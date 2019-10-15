package Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileFunction 
{
	private static Scanner scan;

	public static String textFileToString(String pathOfFile) throws Exception
	{
		String content = new String(Files.readAllBytes(Paths.get(pathOfFile)), "UTF-8");
		return content;
	}
	
	public static int SearchStringAndReturnLine(String fileName,String searchStr) throws FileNotFoundException
	{
		scan = new Scanner(new File(fileName));
		int lineNumber = 1;
        while(scan.hasNext())
        {
            String line = scan.nextLine().toString();
            if(line.contains(searchStr))
            {
                return lineNumber;
            }
            lineNumber++;
        }
        scan.close();
        return 0;
    }
	
	public static boolean SearchInFile(String fileName,String searchStr) throws FileNotFoundException
	{
		scan = new Scanner(new File(fileName));
        while(scan.hasNext())
        {
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr))
            {
                return true;
            }
            
        }
        scan.close();
        return false;
    }
	
	public static int SearchInFilefromFirstLineAndJump(String fileName,String searchStr,int numberOfLineToJump) throws FileNotFoundException
	{
		scan = new Scanner(new File(fileName));
		int lineNumber = 1;
        while(scan.hasNext())
        {
        	String line = scan.nextLine().toString();
            if(line.contains(searchStr))
            {
                return lineNumber;
            }
        	for(int i=0;i<numberOfLineToJump;i++)
        	{
        		if(scan.hasNext())
        		{
        			scan.nextLine();
        			lineNumber++;
        		}
        	}
        	lineNumber++;
        }
        scan.close();
        return 0;
    }
	
	public static void CopyFileToFile(File inpute,File outpute)
	{
		try {
			FileWriter fileWriter = new FileWriter(inpute);
			BufferedReader reader = new BufferedReader(new FileReader(outpute));
			String line = reader.readLine();
			while (line != null)
			{
				fileWriter.write(line + "\n");
				line = reader.readLine();
			}
			fileWriter.close();
			reader.close();
			outpute.delete();
		} catch (IOException e) {
			System.out.println("Erorr: FileFunction/CopyFileToFile ");
		}
	}
	
	public static void WriteToFile(String fileName, String textToWrite)
	{
		File inpute = new File(fileName);
		try {
			FileWriter fileWriter = new FileWriter(inpute,true);
			fileWriter.write(textToWrite + "\n");
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Erorr: FileFunction/WriteToFile ");
		}
	}
	
	public static int GetNumberOfLines(String fileName)
	{
		FileReader in;
		int n = 0;
		
		try {
			in = new FileReader(fileName);
			BufferedReader br = new BufferedReader(in);
			while (br.readLine() != null) {
			    n++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erorr: FileFunction/GetNumberOfLines/FileNotFound ");
		} catch (IOException e) {
			System.out.println("Erorr: FileFunction/GetNumberOfLines/br error ");
		}
		return n;
		// use this only if you have large files, meaning that each line is very long.
		
		/*long lineCount = 0;
		try {
			lineCount = Files.lines(Paths.get(fileName)).count();
			return lineCount;
		} catch (IOException e) {
			System.out.println("Erorr: FileFunction/GetNumberOfLines ");
		}
		return lineCount;*/
	}
	
	public static void DeleteFromText(String fileName, int startLine,int endLine)
	{
		 try {
		File inputFile = new File(fileName);
        File tempFile = new File("BarCode\\src\\dataBase\\temp.txt");
        	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            int lineToRemove = endLine;
            String currentLine;
            int count = startLine;
            for (int i=0;i<startLine;i++)
            {
            	 writer.write(reader.readLine()+ System.getProperty("line.separator"));
            }
            while ((currentLine = reader.readLine()) != null) {
                count++;
                if (count <= lineToRemove) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            CopyFileToFile(inputFile, tempFile);
        }
        catch (Exception e) {
        		System.out.println("Erorr: Catch , DeleteFromText");
		}
	}
	
	public static StringBuilder ReadLineFromText(String fileName, int startLine,int endLine)
	{
		StringBuilder builder = new StringBuilder();
		try {
			scan = new Scanner(new File(fileName));
			for(int i=0;i<startLine;i++)
			{
				scan.nextLine();
			}
			for (int i=startLine;i<=endLine;i++)
			{
				builder.append(scan.nextLine().toString() + "\n");
			}
			scan.close();
			return builder;
		} catch (FileNotFoundException e) {
			System.out.println("Erorr: FileFunction/ReadLineFromText");
		}
		return builder;
	}
	
	public static String ReadLineFromTextToStirng(String fileName, int startLine,int endLine)
	{
		String str = new String();
		try {
			scan = new Scanner(new File(fileName));
			for(int i=0;i<startLine-1;i++)
			{
				scan.nextLine();
			}
			for (int i=startLine;i<=endLine;i++)
			{
				str = scan.nextLine().toString();
			}
			scan.close();
			return str;
		} catch (FileNotFoundException e) {
			System.out.println("Erorr: FileFunction/ReadLineFromText");
		}
		return str;
	}
	
	
}
