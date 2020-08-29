package demo;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

import objectRepository.MenuClass.Records;


public class Dump {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Current User Working directory::::"+System.getProperty("user.dir"));
		System.out.println("Current OS version:::"+System.getProperty("os.version"));
		System.out.println("Current OS Arch:::"+System.getProperty("os.arch"));
		System.out.println(System.getProperty("os.name"));
		
		System.setProperty("machine.name", InetAddress.getLocalHost().getHostName());
		
		System.out.println("Machine name::::"+System.getProperty("machine.name"));
		
		System.out.println(Records.Select_All_Records.getCompanyLetter());
		int max = 32;
				int min = 20;
		new Random().ints(3,20,32).forEach(System.out::println);
		
		
	}

}
